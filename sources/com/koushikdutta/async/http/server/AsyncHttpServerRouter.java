package com.koushikdutta.async.http.server;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.didi.dimina.starbox.util.FileUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.AsyncHttpHead;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.WebSocketImpl;
import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerRouter;
import com.koushikdutta.async.util.StreamUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public class AsyncHttpServerRouter implements RouteMatcher {

    /* renamed from: e */
    static Hashtable<String, String> f55425e = new Hashtable<>();

    /* renamed from: f */
    static Hashtable<String, Future<Manifest>> f55426f = new Hashtable<>();

    /* renamed from: g */
    static final /* synthetic */ boolean f55427g = (!AsyncHttpServerRouter.class.desiredAssertionStatus());

    /* renamed from: a */
    private Callback f55428a;

    /* renamed from: d */
    final ArrayList<RouteInfo> f55429d = new ArrayList<>();

    public AsyncHttpServerRouter() {
        f55425e.put("js", "application/javascript");
        f55425e.put("json", "application/json");
        f55425e.put("png", "image/png");
        f55425e.put(FileUtil.JPG, "image/jpeg");
        f55425e.put("jpeg", "image/jpeg");
        f55425e.put("html", "text/html");
        f55425e.put(Constants.JSON_KEY_CUR_CPU_STAT, "text/css");
        f55425e.put("mp4", "video/mp4");
        f55425e.put("mov", "video/quicktime");
        f55425e.put("wmv", "video/x-ms-wmv");
        f55425e.put("txt", "text/plain");
        this.f55428a = new Callback();
    }

    private static class RouteInfo {
        AsyncHttpRequestBodyProvider bodyCallback;
        HttpServerRequestCallback callback;
        String method;
        Pattern regex;

        private RouteInfo() {
        }
    }

    public void removeAction(String str, String str2) {
        int i = 0;
        while (i < this.f55429d.size()) {
            RouteInfo routeInfo = this.f55429d.get(i);
            if (!TextUtils.equals(routeInfo.method, str) || !str2.equals(routeInfo.regex.toString())) {
                i++;
            } else {
                this.f55429d.remove(i);
                return;
            }
        }
    }

    public void addAction(String str, String str2, HttpServerRequestCallback httpServerRequestCallback, AsyncHttpRequestBodyProvider asyncHttpRequestBodyProvider) {
        RouteInfo routeInfo = new RouteInfo();
        routeInfo.regex = Pattern.compile("^" + str2);
        routeInfo.callback = httpServerRequestCallback;
        routeInfo.method = str;
        routeInfo.bodyCallback = asyncHttpRequestBodyProvider;
        synchronized (this.f55429d) {
            this.f55429d.add(routeInfo);
        }
    }

    public void addAction(String str, String str2, HttpServerRequestCallback httpServerRequestCallback) {
        addAction(str, str2, httpServerRequestCallback, (AsyncHttpRequestBodyProvider) null);
    }

    public void websocket(String str, AsyncHttpServer.WebSocketRequestCallback webSocketRequestCallback) {
        websocket(str, (String) null, webSocketRequestCallback);
    }

    public static WebSocket checkWebSocketUpgrade(String str, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        String str2 = asyncHttpServerRequest.getHeaders().get(HttpHeaders.CONNECTION);
        boolean z = false;
        if (str2 != null) {
            String[] split = str2.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (HttpHeaders.UPGRADE.equalsIgnoreCase(split[i].trim())) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        if (!p242io.socket.engineio.client.transports.WebSocket.NAME.equalsIgnoreCase(asyncHttpServerRequest.getHeaders().get(HttpHeaders.UPGRADE)) || !z || !TextUtils.equals(str, asyncHttpServerRequest.getHeaders().get(HttpHeaders.SEC_WEBSOCKET_PROTOCOL))) {
            return null;
        }
        return new WebSocketImpl(asyncHttpServerRequest, asyncHttpServerResponse);
    }

    public void websocket(String str, String str2, AsyncHttpServer.WebSocketRequestCallback webSocketRequestCallback) {
        get(str, new HttpServerRequestCallback(str2, webSocketRequestCallback) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ AsyncHttpServer.WebSocketRequestCallback f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
                AsyncHttpServerRouter.m39997a(this.f$0, this.f$1, asyncHttpServerRequest, asyncHttpServerResponse);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m39997a(String str, AsyncHttpServer.WebSocketRequestCallback webSocketRequestCallback, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        WebSocket checkWebSocketUpgrade = checkWebSocketUpgrade(str, asyncHttpServerRequest, asyncHttpServerResponse);
        if (checkWebSocketUpgrade == null) {
            asyncHttpServerResponse.code(404);
            asyncHttpServerResponse.end();
            return;
        }
        webSocketRequestCallback.onConnected(checkWebSocketUpgrade, asyncHttpServerRequest);
    }

    public void get(String str, HttpServerRequestCallback httpServerRequestCallback) {
        addAction("GET", str, httpServerRequestCallback);
    }

    public void post(String str, HttpServerRequestCallback httpServerRequestCallback) {
        addAction("POST", str, httpServerRequestCallback);
    }

    public static class Asset {
        public int available;
        public InputStream inputStream;
        public String path;

        public Asset(int i, InputStream inputStream2, String str) {
            this.available = i;
            this.inputStream = inputStream2;
            this.path = str;
        }
    }

    public static Asset getAssetStream(Context context, String str) {
        return getAssetStream(context.getAssets(), str);
    }

    public static Asset getAssetStream(AssetManager assetManager, String str) {
        try {
            InputStream open = assetManager.open(str);
            return new Asset(open.available(), open, str);
        } catch (IOException unused) {
            String[] strArr = {"/index.htm", "/index.html", "index.htm", "index.html", ".htm", ".html"};
            int i = 0;
            while (i < 6) {
                String str2 = strArr[i];
                try {
                    InputStream open2 = assetManager.open(str + str2);
                    int available = open2.available();
                    return new Asset(available, open2, str + str2);
                } catch (IOException unused2) {
                    i++;
                }
            }
            return null;
        }
    }

    public static String getContentType(String str) {
        return tryGetContentType(str);
    }

    public static String tryGetContentType(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1 || (str2 = f55425e.get(str.substring(lastIndexOf + 1))) == null) {
            return null;
        }
        return str2;
    }

    /* renamed from: a */
    static synchronized Manifest m39994a(Context context) {
        ZipFile zipFile;
        synchronized (AsyncHttpServerRouter.class) {
            Future future = f55426f.get(context.getPackageName());
            if (future != null) {
                Manifest manifest = (Manifest) future.tryGet();
                return manifest;
            }
            SimpleFuture simpleFuture = new SimpleFuture();
            try {
                zipFile = new ZipFile(context.getPackageResourcePath());
                try {
                    Manifest manifest2 = new Manifest(zipFile.getInputStream(zipFile.getEntry("META-INF/MANIFEST.MF")));
                    simpleFuture.setComplete(manifest2);
                    StreamUtility.closeQuietly(zipFile);
                    f55426f.put(context.getPackageName(), simpleFuture);
                    return manifest2;
                } catch (Exception e) {
                    e = e;
                    try {
                        simpleFuture.setComplete(e);
                        StreamUtility.closeQuietly(zipFile);
                        f55426f.put(context.getPackageName(), simpleFuture);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        StreamUtility.closeQuietly(zipFile);
                        f55426f.put(context.getPackageName(), simpleFuture);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zipFile = null;
                simpleFuture.setComplete(e);
                StreamUtility.closeQuietly(zipFile);
                f55426f.put(context.getPackageName(), simpleFuture);
                return null;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                zipFile = null;
                th = th3;
                StreamUtility.closeQuietly(zipFile);
                f55426f.put(context.getPackageName(), simpleFuture);
                throw th;
            }
        }
    }

    /* renamed from: a */
    static boolean m39998a(Context context, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse, String str) {
        Manifest a = m39994a(context);
        if (a == null) {
            return false;
        }
        try {
            Map<String, Attributes> entries = a.getEntries();
            String value = entries.get("assets/" + str).getValue("SHA-256-Digest");
            if (TextUtils.isEmpty(value)) {
                return false;
            }
            String format = String.format("\"%s\"", new Object[]{value});
            asyncHttpServerResponse.getHeaders().set(HttpHeaders.ETAG, format);
            return TextUtils.equals(asyncHttpServerRequest.getHeaders().get(HttpHeaders.IF_NONE_MATCH), format);
        } catch (Exception e) {
            SystemUtils.log(5, AsyncHttpServerRouter.class.getSimpleName(), "Error getting ETag for apk asset", e, "com.koushikdutta.async.http.server.AsyncHttpServerRouter", 223);
            return false;
        }
    }

    public void directory(Context context, String str, String str2) {
        AssetManager assets = context.getAssets();
        addAction("GET", str, new HttpServerRequestCallback(assets, str2, context) {
            public final /* synthetic */ AssetManager f$0;
            public final /* synthetic */ String f$1;
            public final /* synthetic */ Context f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
                AsyncHttpServerRouter.m39999b(this.f$0, this.f$1, this.f$2, asyncHttpServerRequest, asyncHttpServerResponse);
            }
        });
        addAction(AsyncHttpHead.METHOD, str, new HttpServerRequestCallback(assets, str2, context) {
            public final /* synthetic */ AssetManager f$0;
            public final /* synthetic */ String f$1;
            public final /* synthetic */ Context f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
                AsyncHttpServerRouter.m39995a(this.f$0, this.f$1, this.f$2, asyncHttpServerRequest, asyncHttpServerResponse);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m39999b(AssetManager assetManager, String str, Context context, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        String replaceAll = asyncHttpServerRequest.getMatcher().replaceAll("");
        Asset assetStream = getAssetStream(assetManager, str + replaceAll);
        if (assetStream == null || assetStream.inputStream == null) {
            asyncHttpServerResponse.code(404);
            asyncHttpServerResponse.end();
        } else if (m39998a(context, asyncHttpServerRequest, asyncHttpServerResponse, assetStream.path)) {
            StreamUtility.closeQuietly(assetStream.inputStream);
            asyncHttpServerResponse.code(304);
            asyncHttpServerResponse.end();
        } else {
            asyncHttpServerResponse.getHeaders().set(HttpHeaders.CONTENT_LENGTH, String.valueOf(assetStream.available));
            asyncHttpServerResponse.getHeaders().add("Content-Type", getContentType(assetStream.path));
            asyncHttpServerResponse.code(200);
            C20137Util.pump(assetStream.inputStream, (long) assetStream.available, asyncHttpServerResponse, new CompletedCallback(assetStream) {
                public final /* synthetic */ AsyncHttpServerRouter.Asset f$1;

                {
                    this.f$1 = r2;
                }

                public final void onCompleted(Exception exc) {
                    AsyncHttpServerRouter.m39996a(AsyncHttpServerResponse.this, this.f$1, exc);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m39996a(AsyncHttpServerResponse asyncHttpServerResponse, Asset asset, Exception exc) {
        asyncHttpServerResponse.end();
        StreamUtility.closeQuietly(asset.inputStream);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m39995a(AssetManager assetManager, String str, Context context, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        String replaceAll = asyncHttpServerRequest.getMatcher().replaceAll("");
        Asset assetStream = getAssetStream(assetManager, str + replaceAll);
        if (assetStream == null || assetStream.inputStream == null) {
            asyncHttpServerResponse.code(404);
            asyncHttpServerResponse.end();
            return;
        }
        StreamUtility.closeQuietly(assetStream.inputStream);
        if (m39998a(context, asyncHttpServerRequest, asyncHttpServerResponse, assetStream.path)) {
            asyncHttpServerResponse.code(304);
        } else {
            asyncHttpServerResponse.getHeaders().set(HttpHeaders.CONTENT_LENGTH, String.valueOf(assetStream.available));
            asyncHttpServerResponse.getHeaders().add("Content-Type", getContentType(assetStream.path));
            asyncHttpServerResponse.code(200);
        }
        asyncHttpServerResponse.end();
    }

    public void directory(String str, File file) {
        directory(str, file, false);
    }

    public void directory(String str, final File file, final boolean z) {
        if (f55427g || file.isDirectory()) {
            addAction("GET", str, new HttpServerRequestCallback() {
                public void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, final AsyncHttpServerResponse asyncHttpServerResponse) {
                    File file = new File(file, asyncHttpServerRequest.getMatcher().replaceAll(""));
                    if (file.isDirectory() && z) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (File file2 : file.listFiles()) {
                            if (file2.isDirectory()) {
                                arrayList.add(file2);
                            } else {
                                arrayList2.add(file2);
                            }
                        }
                        C202471 r1 = new Comparator<File>() {
                            public int compare(File file, File file2) {
                                return file.getName().compareTo(file2.getName());
                            }
                        };
                        Collections.sort(arrayList, r1);
                        Collections.sort(arrayList2, r1);
                        arrayList2.addAll(0, arrayList);
                        StringBuilder sb = new StringBuilder();
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            File file3 = (File) it.next();
                            sb.append(String.format("<div><a href='%s'>%s</a></div>", new Object[]{new File(asyncHttpServerRequest.getPath(), file3.getName()).getAbsolutePath(), file3.getName()}));
                        }
                        asyncHttpServerResponse.send(sb.toString());
                    } else if (!file.isFile()) {
                        asyncHttpServerResponse.code(404);
                        asyncHttpServerResponse.end();
                    } else {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            asyncHttpServerResponse.code(200);
                            C20137Util.pump(fileInputStream, (long) fileInputStream.available(), asyncHttpServerResponse, new CompletedCallback() {
                                public void onCompleted(Exception exc) {
                                    asyncHttpServerResponse.end();
                                }
                            });
                        } catch (IOException unused) {
                            asyncHttpServerResponse.code(404);
                            asyncHttpServerResponse.end();
                        }
                    }
                }
            });
            return;
        }
        throw new AssertionError();
    }

    public static class RouteMatch {
        public final AsyncHttpRequestBodyProvider bodyCallback;
        public final HttpServerRequestCallback callback;
        public final Matcher matcher;
        public final String method;
        public final String path;

        private RouteMatch(String str, String str2, Matcher matcher2, HttpServerRequestCallback httpServerRequestCallback, AsyncHttpRequestBodyProvider asyncHttpRequestBodyProvider) {
            this.method = str;
            this.path = str2;
            this.matcher = matcher2;
            this.callback = httpServerRequestCallback;
            this.bodyCallback = asyncHttpRequestBodyProvider;
        }
    }

    abstract class AsyncHttpServerRequestImpl extends AsyncHttpServerRequestImpl {
        Matcher matcher;

        AsyncHttpServerRequestImpl() {
        }

        public Matcher getMatcher() {
            return this.matcher;
        }

        public void setMatcher(Matcher matcher2) {
            this.matcher = matcher2;
        }
    }

    class Callback implements HttpServerRequestCallback, RouteMatcher {
        Callback() {
        }

        public void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
            RouteMatch route = route(asyncHttpServerRequest.getMethod(), asyncHttpServerRequest.getPath());
            if (route == null) {
                asyncHttpServerResponse.code(404);
                asyncHttpServerResponse.end();
                return;
            }
            route.callback.onRequest(asyncHttpServerRequest, asyncHttpServerResponse);
        }

        public RouteMatch route(String str, String str2) {
            return AsyncHttpServerRouter.this.route(str, str2);
        }
    }

    public HttpServerRequestCallback getCallback() {
        return this.f55428a;
    }

    public RouteMatch route(String str, String str2) {
        synchronized (this.f55429d) {
            Iterator<RouteInfo> it = this.f55429d.iterator();
            while (it.hasNext()) {
                RouteInfo next = it.next();
                if (TextUtils.equals(str, next.method) || next.method == null) {
                    Matcher matcher = next.regex.matcher(str2);
                    if (matcher.matches()) {
                        if (next.callback instanceof RouteMatcher) {
                            RouteMatch route = ((RouteMatcher) next.callback).route(str, matcher.group(1));
                            return route;
                        }
                        RouteMatch routeMatch = new RouteMatch(str, str2, matcher, next.callback, next.bodyCallback);
                        return routeMatch;
                    }
                }
            }
            return null;
        }
    }
}
