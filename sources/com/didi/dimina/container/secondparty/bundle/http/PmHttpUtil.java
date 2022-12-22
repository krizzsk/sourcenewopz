package com.didi.dimina.container.secondparty.bundle.http;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.secondparty.Dimina4Di;
import com.didi.dimina.container.secondparty.bundle.PmConstant;
import com.didi.dimina.container.secondparty.http.DidiNetworkServiceManager;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TextUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.google.gson.Gson;
import didihttp.Call;
import didihttp.Callback;
import didihttp.DidiHttpClient;
import didihttp.MediaType;
import didihttp.Request;
import didihttp.RequestBody;
import didihttp.Response;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PmHttpUtil {
    public static final String KEY_PM_IP_HTTP_HOST = "PM_IP_HTTP_HOST";
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8");

    /* renamed from: a */
    private static final String f17092a = "Dimina-PM PmHttpUtil";

    /* renamed from: b */
    private static DidiHttpClient f17093b;

    public static String getBaseUrl(DMMina dMMina) {
        try {
            String str = (String) MMKVUtil.getInstance().get(KEY_PM_IP_HTTP_HOST, "");
            if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
                return str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Dimina.getConfig() instanceof Dimina4Di.Config) {
            String pckManagerHostDomain = ((Dimina4Di.Config) Dimina.getConfig()).getPckManagerHostDomain();
            if (!TextUtil.isEmpty(pckManagerHostDomain)) {
                return pckManagerHostDomain;
            }
        }
        return PmConstant.HTTP.getDefaultHostDomain();
    }

    public static void get(String str, PmHttpCallback<String> pmHttpCallback) {
        get(str, (Map<String, String>) null, (Map<String, Object>) null, pmHttpCallback);
    }

    public static void get(String str, Map<String, String> map, Map<String, Object> map2, final PmHttpCallback<String> pmHttpCallback) {
        m12654a();
        Request.Builder url = new Request.Builder().url(m12652a(str, map2));
        m12655a(url, map);
        f17093b.newCall(url.build()).enqueue(new Callback() {
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                PmHttpCallback pmHttpCallback = pmHttpCallback;
                if (pmHttpCallback != null) {
                    try {
                        pmHttpCallback.onSucceed(string);
                    } catch (Exception e) {
                        pmHttpCallback.onFailed(e);
                    }
                }
            }

            public void onFailure(Call call, IOException iOException) {
                PmHttpCallback pmHttpCallback = pmHttpCallback;
                if (pmHttpCallback != null) {
                    pmHttpCallback.onFailed(iOException);
                }
            }
        });
    }

    public static void post(String str, Map<String, String> map, Map<String, Object> map2, final PmHttpCallback<String> pmHttpCallback) {
        m12654a();
        Request.Builder url = new Request.Builder().url(str);
        m12655a(url, map);
        f17093b.newCall(url.post(m12656b(map2)).build()).enqueue(new Callback() {
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                PmHttpCallback pmHttpCallback = pmHttpCallback;
                if (pmHttpCallback != null) {
                    try {
                        pmHttpCallback.onSucceed(string);
                    } catch (Exception e) {
                        pmHttpCallback.onFailed(e);
                    }
                }
            }

            public void onFailure(Call call, IOException iOException) {
                PmHttpCallback pmHttpCallback = pmHttpCallback;
                if (pmHttpCallback != null) {
                    pmHttpCallback.onFailed(iOException);
                }
            }
        });
    }

    public static Call download(String str, String str2, final PmDownloadCallback pmDownloadCallback) {
        LogUtil.iRelease(f17092a, "download, url = " + str + "\t saveFilePath=" + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        final File file = new File(str2);
        LogUtil.iRelease(f17092a, "download, breakpointBytes = " + 0);
        m12654a();
        Request.Builder url = new Request.Builder().url(str);
        Call newCall = f17093b.newCall(url.header("RANGE", "bytes=" + 0 + "-").build());
        newCall.enqueue(new Callback(0) {
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b1, code lost:
                r6 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b3, code lost:
                r6 = e;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:25:0x0082] */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x00d3 A[Catch:{ all -> 0x00ef }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x00da A[SYNTHETIC, Splitter:B:62:0x00da] */
            /* JADX WARNING: Removed duplicated region for block: B:67:0x00e2 A[Catch:{ Exception -> 0x00de }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x00e7 A[Catch:{ Exception -> 0x00de }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x00f2 A[SYNTHETIC, Splitter:B:73:0x00f2] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x00fa A[Catch:{ Exception -> 0x00f6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:80:0x00ff A[Catch:{ Exception -> 0x00f6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(didihttp.Call r6, didihttp.Response r7) throws java.io.IOException {
                /*
                    r5 = this;
                    boolean r6 = r7.isSuccessful()
                    if (r6 == 0) goto L_0x000c
                    didihttp.ResponseBody r6 = r7.body()
                    if (r6 != 0) goto L_0x002a
                L_0x000c:
                    com.didi.dimina.container.secondparty.bundle.http.PmDownloadCallback r6 = r7
                    if (r6 == 0) goto L_0x002a
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "Failed to download file: "
                    r1.append(r2)
                    r1.append(r7)
                    java.lang.String r7 = r1.toString()
                    r0.<init>(r7)
                    r6.onFailed(r0)
                    return
                L_0x002a:
                    com.didi.dimina.container.secondparty.bundle.http.PmDownloadCallback r6 = r7
                    if (r6 == 0) goto L_0x0031
                    r6.onStart()
                L_0x0031:
                    didihttp.ResponseBody r6 = r7.body()
                    long r0 = r6.contentLength()
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    java.lang.String r2 = "download, onResponse, contentLength = "
                    r6.append(r2)
                    r6.append(r0)
                    java.lang.String r6 = r6.toString()
                    java.lang.String r2 = "Dimina-PM PmHttpUtil"
                    com.didi.dimina.container.util.LogUtil.iRelease(r2, r6)
                    r2 = 0
                    int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r6 != 0) goto L_0x0067
                    java.io.File r6 = r0
                    boolean r6 = r6.exists()
                    if (r6 == 0) goto L_0x0067
                    com.didi.dimina.container.secondparty.bundle.http.PmDownloadCallback r6 = r7
                    if (r6 == 0) goto L_0x0066
                    java.io.File r7 = r0
                    r6.onSucceed(r7)
                L_0x0066:
                    return
                L_0x0067:
                    r6 = 2048(0x800, float:2.87E-42)
                    byte[] r6 = new byte[r6]
                    r0 = 0
                    didihttp.ResponseBody r7 = r7.body()     // Catch:{ Exception -> 0x00c9, all -> 0x00c5 }
                    java.io.InputStream r7 = r7.byteStream()     // Catch:{ Exception -> 0x00c9, all -> 0x00c5 }
                    java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00c0, all -> 0x00bb }
                    r1.<init>(r7)     // Catch:{ Exception -> 0x00c0, all -> 0x00bb }
                    java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                    java.io.File r3 = r0     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                    java.lang.String r4 = "rwd"
                    r2.<init>(r3, r4)     // Catch:{ Exception -> 0x00b8, all -> 0x00b5 }
                    long r3 = 0     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
                    r2.seek(r3)     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
                L_0x0087:
                    int r0 = r1.read(r6)     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
                    r3 = -1
                    if (r0 == r3) goto L_0x0093
                    r3 = 0
                    r2.write(r6, r3, r0)     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
                    goto L_0x0087
                L_0x0093:
                    com.didi.dimina.container.secondparty.bundle.http.PmDownloadCallback r6 = r7     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
                    if (r6 == 0) goto L_0x00a5
                    com.didi.dimina.container.secondparty.bundle.http.PmDownloadCallback r6 = r7     // Catch:{ Exception -> 0x009f, all -> 0x00b1 }
                    java.io.File r0 = r0     // Catch:{ Exception -> 0x009f, all -> 0x00b1 }
                    r6.onSucceed(r0)     // Catch:{ Exception -> 0x009f, all -> 0x00b1 }
                    goto L_0x00a5
                L_0x009f:
                    r6 = move-exception
                    com.didi.dimina.container.secondparty.bundle.http.PmDownloadCallback r0 = r7     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
                    r0.onFailed(r6)     // Catch:{ Exception -> 0x00b3, all -> 0x00b1 }
                L_0x00a5:
                    if (r7 == 0) goto L_0x00aa
                    r7.close()     // Catch:{ Exception -> 0x00de }
                L_0x00aa:
                    r1.close()     // Catch:{ Exception -> 0x00de }
                    r2.close()     // Catch:{ Exception -> 0x00de }
                    goto L_0x00ee
                L_0x00b1:
                    r6 = move-exception
                    goto L_0x00be
                L_0x00b3:
                    r6 = move-exception
                    goto L_0x00c3
                L_0x00b5:
                    r6 = move-exception
                    r2 = r0
                    goto L_0x00be
                L_0x00b8:
                    r6 = move-exception
                    r2 = r0
                    goto L_0x00c3
                L_0x00bb:
                    r6 = move-exception
                    r1 = r0
                    r2 = r1
                L_0x00be:
                    r0 = r7
                    goto L_0x00f0
                L_0x00c0:
                    r6 = move-exception
                    r1 = r0
                    r2 = r1
                L_0x00c3:
                    r0 = r7
                    goto L_0x00cc
                L_0x00c5:
                    r6 = move-exception
                    r1 = r0
                    r2 = r1
                    goto L_0x00f0
                L_0x00c9:
                    r6 = move-exception
                    r1 = r0
                    r2 = r1
                L_0x00cc:
                    r6.printStackTrace()     // Catch:{ all -> 0x00ef }
                    com.didi.dimina.container.secondparty.bundle.http.PmDownloadCallback r7 = r7     // Catch:{ all -> 0x00ef }
                    if (r7 == 0) goto L_0x00d8
                    com.didi.dimina.container.secondparty.bundle.http.PmDownloadCallback r7 = r7     // Catch:{ all -> 0x00ef }
                    r7.onFailed(r6)     // Catch:{ all -> 0x00ef }
                L_0x00d8:
                    if (r0 == 0) goto L_0x00e0
                    r0.close()     // Catch:{ Exception -> 0x00de }
                    goto L_0x00e0
                L_0x00de:
                    r6 = move-exception
                    goto L_0x00eb
                L_0x00e0:
                    if (r1 == 0) goto L_0x00e5
                    r1.close()     // Catch:{ Exception -> 0x00de }
                L_0x00e5:
                    if (r2 == 0) goto L_0x00ee
                    r2.close()     // Catch:{ Exception -> 0x00de }
                    goto L_0x00ee
                L_0x00eb:
                    r6.printStackTrace()
                L_0x00ee:
                    return
                L_0x00ef:
                    r6 = move-exception
                L_0x00f0:
                    if (r0 == 0) goto L_0x00f8
                    r0.close()     // Catch:{ Exception -> 0x00f6 }
                    goto L_0x00f8
                L_0x00f6:
                    r7 = move-exception
                    goto L_0x0103
                L_0x00f8:
                    if (r1 == 0) goto L_0x00fd
                    r1.close()     // Catch:{ Exception -> 0x00f6 }
                L_0x00fd:
                    if (r2 == 0) goto L_0x0106
                    r2.close()     // Catch:{ Exception -> 0x00f6 }
                    goto L_0x0106
                L_0x0103:
                    r7.printStackTrace()
                L_0x0106:
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.bundle.http.PmHttpUtil.C75283.onResponse(didihttp.Call, didihttp.Response):void");
            }

            public void onFailure(Call call, IOException iOException) {
                iOException.printStackTrace();
                PmDownloadCallback pmDownloadCallback = pmDownloadCallback;
                if (pmDownloadCallback != null) {
                    pmDownloadCallback.onFailed(iOException);
                }
            }
        });
        return newCall;
    }

    /* renamed from: a */
    private static String m12652a(String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder(str);
        String a = m12653a(map);
        if (!TextUtils.isEmpty(a)) {
            if (str.contains("?")) {
                sb.append(ParamKeys.SIGN_AND);
            } else {
                sb.append("?");
            }
            sb.append(a);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m12653a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String next : map.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(ParamKeys.SIGN_AND);
            }
            String valueOf = String.valueOf(map.get(next));
            try {
                next = URLEncoder.encode(next, "UTF-8");
                valueOf = URLEncoder.encode(valueOf, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            sb.append(next);
            sb.append("=");
            sb.append(valueOf);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static void m12655a(Request.Builder builder, Map<String, String> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                String valueOf = String.valueOf(map.get(next));
                if (!TextUtils.isEmpty(valueOf)) {
                    builder.addHeader(next, valueOf);
                }
            }
        }
    }

    /* renamed from: b */
    private static RequestBody m12656b(Map<String, Object> map) {
        String str = "";
        try {
            if (!CollectionsUtil.isEmpty((Map) map)) {
                str = new Gson().toJson((Object) map);
            }
        } catch (Exception unused) {
        }
        return RequestBody.create(MEDIA_TYPE_JSON, str);
    }

    /* renamed from: a */
    private static void m12654a() {
        DidiHttpClient httpClient = DidiNetworkServiceManager.getHttpClient();
        f17093b = httpClient;
        if (httpClient == null) {
            f17093b = new DidiHttpClient.Builder().connectTimeout(180, TimeUnit.SECONDS).readTimeout(180, TimeUnit.SECONDS).writeTimeout(180, TimeUnit.SECONDS).sslSocketFactory(PmFakeX509TrustManager.allowAllSSL(), new PmFakeX509TrustManager()).build();
        }
    }
}
