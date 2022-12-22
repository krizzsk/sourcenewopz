package com.didi.dimina.container.secondparty.imghook;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.widget.Toast;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.DMThreadPool;
import com.didi.dimina.container.secondparty.http.DidiNetworkServiceManager;
import com.didi.dimina.container.secondparty.imghook.Cache4Action;
import com.didi.dimina.container.secondparty.util.Trace4DiUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.dimina.webview.util.NetworkUtil;
import com.didi.dimina.webview.util.WsgSafeUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.enginecore.cache.XECacheConfig;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.AsyncHttpRequest;
import didihttp.Call;
import didihttp.DidiHttpClient;
import didihttp.Dispatcher;
import didihttp.Headers;
import didihttp.MediaType;
import didihttp.Request;
import didihttp.Response;
import didihttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ImgLoadHooker {

    /* renamed from: a */
    static final String f17180a = "mainUrlFlag";

    /* renamed from: b */
    private static final String f17181b = "ImgLoadHooker";

    /* renamed from: c */
    private static final float f17182c = 1048576.0f;

    /* renamed from: d */
    private static final boolean f17183d = false;

    /* renamed from: e */
    private static final String f17184e = "web_img_cache";

    /* renamed from: f */
    private static volatile ImgLoadHooker f17185f;

    /* renamed from: g */
    private final Context f17186g;

    /* renamed from: h */
    private final DidiHttpClient f17187h;

    /* renamed from: i */
    private final Cache4Action f17188i;

    /* renamed from: j */
    private final Dispatcher f17189j;

    /* renamed from: k */
    private final AtomicInteger f17190k = new AtomicInteger();

    /* renamed from: l */
    private boolean f17191l = false;

    public static ImgLoadHooker getIns(Context context) {
        if (f17185f == null) {
            synchronized (ImgLoadHooker.class) {
                if (f17185f == null) {
                    f17185f = new ImgLoadHooker(context);
                }
            }
        }
        return f17185f;
    }

    public ImgLoadHooker(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f17186g = applicationContext;
        this.f17189j = DidiNetworkServiceManager.getHttpClient().dispatcher();
        DidiHttpClient.Builder newBuilder = DidiNetworkServiceManager.getHttpClient().newBuilder();
        newBuilder.interceptors().clear();
        File externalCacheDir = applicationContext.getExternalCacheDir();
        Cache4Action cache4Action = new Cache4Action(new File((externalCacheDir == null || !externalCacheDir.exists()) ? applicationContext.getCacheDir() : externalCacheDir, f17184e), XECacheConfig.XE_CACHE_DEF_MAX_SIZE);
        this.f17188i = cache4Action;
        cache4Action.setFinishAction(new Cache4Action.FinishAction() {
            public final void onAction(String str, String str2, File file, long j, long j2, String str3) {
                ImgLoadHooker.this.m12751a(str, str2, file, j, j2, str3);
            }
        });
        newBuilder.connectTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).retryOnConnectionFailure(true);
        newBuilder.addInterceptor(new C7553a(this.f17188i));
        newBuilder.addNetworkInterceptor($$Lambda$ImgLoadHooker$PjjEgu0tKdFjFzmaxcK7U7AYBq0.INSTANCE);
        this.f17187h = newBuilder.build();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12751a(String str, String str2, File file, long j, long j2, String str3) {
        ImgHookConfig config = ImgHookConfig.getConfig();
        if (config != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            try {
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                long j3 = (long) (options.outWidth * options.outHeight);
                long length = file.length();
                if (j3 > config.mo55676a() || length > config.mo55677b()) {
                    Trace4DiUtil.traceWebRequestBigImgWaring(options.outMimeType, options.outWidth, options.outHeight, length, str, str2, str3, j2, j3, WsgSafeUtil.getAppVersionName(this.f17186g), ImgHookConfig.getConfigStr());
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m12749a(Response response) {
        DMThreadPool.getExecutor().execute(new Runnable(response) {
            public final /* synthetic */ Response f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ImgLoadHooker.this.m12754b(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m12754b(Response response) {
        try {
            ImgHookConfig config = ImgHookConfig.getConfig();
            if (config != null) {
                String header = response.header(f17180a);
                String httpUrl = response.request().url().toString();
                File file = this.f17188i.f17134a.mo55645a(Cache4Action.key(httpUrl)).getFile(1);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                long j = (long) (options.outWidth * options.outHeight);
                long length = file.length();
                if (j > config.mo55676a() || length > config.mo55677b()) {
                    Trace4DiUtil.traceImageWebRequestFromCache(options.outMimeType, options.outWidth, options.outHeight, length, header, httpUrl, j, WsgSafeUtil.getAppVersionName(this.f17186g), ImgHookConfig.getConfigStr());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.eRelease(f17181b, "大图cache命中 发生错误:" + Log.getStackTraceString(e));
        }
    }

    /* renamed from: a */
    private void m12748a(long j, BitmapFactory.Options options, String str, long j2, String str2, String str3) {
        String str4;
        float f = (float) j;
        if (f >= f17182c) {
            str4 = String.format(Locale.US, "%.1fMb", new Object[]{Float.valueOf(f / f17182c)});
        } else {
            str4 = String.format(Locale.US, "%.1fKb", new Object[]{Float.valueOf(f / 1024.0f)});
        }
        if (Dimina.getConfig().isDebug()) {
            String str5 = "\nmime: " + options.outMimeType + "\nwidth: " + options.outWidth + "\nheight: " + options.outHeight + "\nsourceSize: " + str4 + "\nmainFrame: " + str + "\nduration: " + j2 + "\ncdnHeaders: " + str2 + "\nresource: " + str3;
            LogUtil.m13410e(f17181b, "checkAndReport  " + str5);
            new Handler(Looper.getMainLooper()).post(new Runnable(str5) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    ImgLoadHooker.this.m12750a(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12750a(String str) {
        Context context = this.f17186g;
        SystemUtils.showToast(Toast.makeText(context, "大图预警:" + str, 1));
    }

    /* renamed from: a */
    private boolean m12752a() {
        ImgHookConfig config = ImgHookConfig.getConfig();
        if (config == null) {
            return true;
        }
        return !config.mo55678c().contains(Integer.valueOf(NetworkUtil.getNetworkType(this.f17186g)));
    }

    public WebResourceResponse shouldInterceptRequest(WebViewEngine webViewEngine, String str, String str2) {
        ImgHookConfig config = ImgHookConfig.getConfig();
        if (config == null || str == null || !str.toLowerCase(Locale.US).startsWith("http") || m12752a()) {
            return null;
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        String mimeTypeFromExtension = !TextUtils.isEmpty(fileExtensionFromUrl) ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : AsyncHttpRequest.HEADER_ACCEPT_ALL;
        if (mimeTypeFromExtension != null && C7554b.m12760a(mimeTypeFromExtension)) {
            return m12745a(config, str, new HashMap(), str2);
        }
        return null;
    }

    public WebResourceResponse shouldInterceptRequest(WebViewEngine webViewEngine, WebResourceRequest webResourceRequest, String str) {
        ImgHookConfig config = ImgHookConfig.getConfig();
        if (config == null || !"GET".equals(webResourceRequest.getMethod()) || webResourceRequest.getUrl() == null || m12752a() || !webResourceRequest.getUrl().toString().toLowerCase(Locale.US).startsWith("http")) {
            return null;
        }
        String str2 = webResourceRequest.getRequestHeaders().get(HttpHeaders.ACCEPT);
        if (str2 == null) {
            str2 = webResourceRequest.getRequestHeaders().get("accept");
        }
        if (str2 != null && C7554b.m12760a(str2)) {
            return m12745a(config, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders(), str);
        }
        return null;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* renamed from: a */
    private android.webkit.WebResourceResponse m12745a(com.didi.dimina.container.secondparty.imghook.ImgHookConfig r4, java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6, java.lang.String r7) {
        /*
            r3 = this;
            if (r7 != 0) goto L_0x0004
            java.lang.String r7 = "unknown"
        L_0x0004:
            didihttp.Request$Builder r0 = new didihttp.Request$Builder
            r0.<init>()
            didihttp.Request$Builder r0 = r0.url((java.lang.String) r5)
            didihttp.Headers r6 = didihttp.Headers.m40612of((java.util.Map<java.lang.String, java.lang.String>) r6)
            didihttp.Request$Builder r6 = r0.headers(r6)
            java.lang.String r0 = "mainUrlFlag"
            didihttp.Request$Builder r6 = r6.header(r0, r7)
            didihttp.Request r6 = r6.build()
            com.didi.dimina.container.secondparty.imghook.Cache4Action r7 = r3.f17188i
            didihttp.Response r7 = r7.get(r6)
            if (r7 == 0) goto L_0x002f
            r3.m12749a((didihttp.Response) r7)
            android.webkit.WebResourceResponse r4 = r3.m12753b((didihttp.Request) r6)
            return r4
        L_0x002f:
            boolean r7 = r3.f17191l
            r0 = 0
            r1 = 1
            if (r7 != 0) goto L_0x0043
            java.util.concurrent.atomic.AtomicInteger r7 = r3.f17190k
            int r7 = r7.getAndIncrement()
            int r2 = r4.f17175e
            if (r7 >= r2) goto L_0x0041
            r7 = 1
            goto L_0x0044
        L_0x0041:
            r3.f17191l = r1
        L_0x0043:
            r7 = 0
        L_0x0044:
            int r4 = r4.f17176f
            if (r4 != r1) goto L_0x0057
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r4 = r5.toLowerCase(r4)
            java.lang.String r5 = ".gif"
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x0057
            r0 = 1
        L_0x0057:
            if (r0 != 0) goto L_0x0061
            if (r7 == 0) goto L_0x005c
            goto L_0x0061
        L_0x005c:
            android.webkit.WebResourceResponse r4 = r3.m12753b((didihttp.Request) r6)
            return r4
        L_0x0061:
            didihttp.Dispatcher r4 = r3.f17189j
            monitor-enter(r4)
            didihttp.Dispatcher r5 = r3.f17189j     // Catch:{ all -> 0x00af }
            int r5 = r5.runningCallsCount()     // Catch:{ all -> 0x00af }
            int r5 = r5 + 5
            didihttp.Dispatcher r7 = r3.f17189j     // Catch:{ all -> 0x00af }
            int r7 = r7.getMaxRequests()     // Catch:{ all -> 0x00af }
            if (r5 >= r7) goto L_0x00a9
            int r5 = r3.m12744a((didihttp.Request) r6)     // Catch:{ all -> 0x00af }
            didihttp.Dispatcher r7 = r3.f17189j     // Catch:{ all -> 0x00af }
            int r7 = r7.getMaxRequestsPerHost()     // Catch:{ all -> 0x00af }
            if (r5 < r7) goto L_0x0081
            goto L_0x00a9
        L_0x0081:
            java.io.PipedOutputStream r5 = new java.io.PipedOutputStream     // Catch:{ all -> 0x00af }
            r5.<init>()     // Catch:{ all -> 0x00af }
            java.io.PipedInputStream r7 = new java.io.PipedInputStream     // Catch:{ all -> 0x00af }
            r7.<init>()     // Catch:{ all -> 0x00af }
            r5.connect(r7)     // Catch:{ IOException -> 0x00a3 }
            didihttp.DidiHttpClient r0 = r3.f17187h     // Catch:{ all -> 0x00af }
            didihttp.Call r6 = r0.newCall(r6)     // Catch:{ all -> 0x00af }
            com.didi.dimina.container.secondparty.imghook.ImgLoadHooker$1 r0 = new com.didi.dimina.container.secondparty.imghook.ImgLoadHooker$1     // Catch:{ all -> 0x00af }
            r0.<init>(r5)     // Catch:{ all -> 0x00af }
            r6.enqueue(r0)     // Catch:{ all -> 0x00af }
            r5 = 0
            android.webkit.WebResourceResponse r5 = r3.m12746a(r5, r7, r5)     // Catch:{ all -> 0x00af }
            monitor-exit(r4)     // Catch:{ all -> 0x00af }
            return r5
        L_0x00a3:
            android.webkit.WebResourceResponse r5 = r3.m12753b((didihttp.Request) r6)     // Catch:{ all -> 0x00af }
            monitor-exit(r4)     // Catch:{ all -> 0x00af }
            return r5
        L_0x00a9:
            android.webkit.WebResourceResponse r5 = r3.m12753b((didihttp.Request) r6)     // Catch:{ all -> 0x00af }
            monitor-exit(r4)     // Catch:{ all -> 0x00af }
            return r5
        L_0x00af:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00af }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.imghook.ImgLoadHooker.m12745a(com.didi.dimina.container.secondparty.imghook.ImgHookConfig, java.lang.String, java.util.Map, java.lang.String):android.webkit.WebResourceResponse");
    }

    /* renamed from: a */
    private int m12744a(Request request) {
        int i = 0;
        for (Call request2 : this.f17189j.runningCalls()) {
            if (request2.request().url().hostAndPath().equals(request.url().hostAndPath())) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: b */
    private WebResourceResponse m12753b(Request request) {
        try {
            ResponseBody body = this.f17187h.newCall(request).execute().body();
            return m12746a(body.contentType(), body.byteStream(), request.headers());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private WebResourceResponse m12746a(MediaType mediaType, InputStream inputStream, Headers headers) {
        WebResourceResponse webResourceResponse = new WebResourceResponse(mediaType != null ? mediaType.toString() : AsyncHttpRequest.HEADER_ACCEPT_ALL, "UTF-8", inputStream);
        HashMap hashMap = new HashMap();
        if (headers != null) {
            for (int i = 0; i < headers.size(); i++) {
                String name = headers.name(i);
                if (!HttpHeaders.CACHE_CONTROL.equalsIgnoreCase(name)) {
                    hashMap.put(name, headers.value(i));
                }
            }
        }
        hashMap.put(HttpHeaders.CACHE_CONTROL, "no-store");
        webResourceResponse.setResponseHeaders(hashMap);
        return webResourceResponse;
    }
}
