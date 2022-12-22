package com.didichuxing.diface.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.dfbasesdk.utils.HttpParamUtils;
import com.didichuxing.diface.data.BaseResult;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class HttpUtils {
    public static final String API_COMPARE = "risk.faceplus.compare2";
    public static final String API_FETCH_DEMO = "risk.face.appeal.teach.video.get";
    public static final String API_LIVE = "risk.faceplus.alive";
    public static final String API_UPLOAD_CAPTURE = "risk.face.data.burial.capture.push";

    /* renamed from: a */
    private static final String f47537a = "https://api-sec.didiglobal.com/sec/risk-gateway/common/";

    /* renamed from: b */
    private static final String f47538b = "https://api-sec-ru.didiglobal.com/sec/risk-gateway/common/";

    /* renamed from: c */
    private static String f47539c = "https://api-sec.didiglobal.com/sec/risk-gateway/common/";

    /* renamed from: d */
    private static final String f47540d = "1.0.0";

    /* renamed from: e */
    private static final String f47541e = "190001";

    public interface IDownloadListener {
        void onFailed(IOException iOException);

        void onSuccess();
    }

    public static void switchHost(HostArea hostArea) {
        if (hostArea == HostArea.f47536RU) {
            f47539c = f47538b;
        } else {
            f47539c = f47537a;
        }
    }

    public static void setHost(String str) {
        if (str.contains("/sec/risk-gateway/common/")) {
            f47539c = str;
            return;
        }
        f47539c = str + "/sec/risk-gateway/common/";
    }

    public static String getHost() {
        return f47539c;
    }

    public static String getHostNew(String str) {
        return f47539c + str + "?";
    }

    public static String getNewFinalUrl(String str) {
        return getNewFinalUrl(str, "1.0.0");
    }

    public static String getNewFinalUrl(String str, TreeMap<String, Object> treeMap) {
        return m34021a(str, "1.0.0", f47541e, HttpParamUtils.getSign(treeMap));
    }

    public static String getNewFinalUrl(String str, String str2) {
        return getNewFinalUrl(str, str2, f47541e);
    }

    public static String getNewFinalUrl(String str, String str2, String str3) {
        return m34021a(str, str2, str3, "");
    }

    /* renamed from: a */
    private static String m34021a(String str, String str2, String str3, String str4) {
        Uri.Builder buildUpon = Uri.parse(getHostNew(str)).buildUpon();
        if (!TextUtils.isEmpty(str2)) {
            buildUpon.appendQueryParameter("apiVersion", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            buildUpon.appendQueryParameter("appKey", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            buildUpon.appendQueryParameter("sign", str4);
        }
        return buildUpon.toString();
    }

    public static <T extends BaseResult> void successCallbackSwitch(AbsHttpCallback<T> absHttpCallback, T t) {
        if (t == null || t.apiCode != 200) {
            absHttpCallback.onFailed(2, "server error");
        } else {
            absHttpCallback.onSuccess(t);
        }
    }

    public static <T extends BaseResult> void failedCallbackSwitch(AbsHttpCallback<T> absHttpCallback, IOException iOException) {
        absHttpCallback.onFailed(1, iOException.getMessage());
    }

    public static void download(Context context, String str, final File file, final IDownloadListener iDownloadListener) {
        final HttpRpcRequest build = new HttpRpcRequest.Builder().get(str).build();
        ((HttpRpcClient) new RpcServiceFactory(context).getRpcClient("http")).newRpc(build).enqueue(new HttpRpc.Callback() {
            /* JADX WARNING: Removed duplicated region for block: B:30:0x005a A[SYNTHETIC, Splitter:B:30:0x005a] */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x0064 A[SYNTHETIC, Splitter:B:36:0x0064] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x0069 A[Catch:{ IOException -> 0x006c }] */
            /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSuccess(com.didichuxing.foundation.net.rpc.http.HttpRpcResponse r6) {
                /*
                    r5 = this;
                    r0 = 0
                    com.didichuxing.foundation.net.http.HttpEntity r6 = r6.getEntity()     // Catch:{ IOException -> 0x0049, all -> 0x0044 }
                    java.io.InputStream r6 = r6.getContent()     // Catch:{ IOException -> 0x0049, all -> 0x0044 }
                    java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x003f, all -> 0x003a }
                    java.io.File r2 = r3     // Catch:{ IOException -> 0x003f, all -> 0x003a }
                    r1.<init>(r2)     // Catch:{ IOException -> 0x003f, all -> 0x003a }
                    r0 = 4096(0x1000, float:5.74E-42)
                    byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0038 }
                L_0x0014:
                    int r2 = r6.read(r0)     // Catch:{ IOException -> 0x0038 }
                    r3 = -1
                    if (r2 == r3) goto L_0x0023
                    r3 = 0
                    r1.write(r0, r3, r2)     // Catch:{ IOException -> 0x0038 }
                    r1.flush()     // Catch:{ IOException -> 0x0038 }
                    goto L_0x0014
                L_0x0023:
                    com.didichuxing.diface.utils.HttpUtils$IDownloadListener r0 = r4     // Catch:{ IOException -> 0x0038 }
                    if (r0 == 0) goto L_0x002f
                    com.didichuxing.diface.utils.HttpUtils$1$1 r0 = new com.didichuxing.diface.utils.HttpUtils$1$1     // Catch:{ IOException -> 0x0038 }
                    r0.<init>()     // Catch:{ IOException -> 0x0038 }
                    com.didi.sdk.util.UiThreadHandler.post(r0)     // Catch:{ IOException -> 0x0038 }
                L_0x002f:
                    r1.close()     // Catch:{ IOException -> 0x0060 }
                    if (r6 == 0) goto L_0x0060
                L_0x0034:
                    r6.close()     // Catch:{ IOException -> 0x0060 }
                    goto L_0x0060
                L_0x0038:
                    r0 = move-exception
                    goto L_0x004d
                L_0x003a:
                    r1 = move-exception
                    r4 = r1
                    r1 = r0
                    r0 = r4
                    goto L_0x0062
                L_0x003f:
                    r1 = move-exception
                    r4 = r1
                    r1 = r0
                    r0 = r4
                    goto L_0x004d
                L_0x0044:
                    r6 = move-exception
                    r1 = r0
                    r0 = r6
                    r6 = r1
                    goto L_0x0062
                L_0x0049:
                    r6 = move-exception
                    r1 = r0
                    r0 = r6
                    r6 = r1
                L_0x004d:
                    r0.printStackTrace()     // Catch:{ all -> 0x0061 }
                    com.didichuxing.diface.utils.HttpUtils$1$2 r2 = new com.didichuxing.diface.utils.HttpUtils$1$2     // Catch:{ all -> 0x0061 }
                    r2.<init>(r0)     // Catch:{ all -> 0x0061 }
                    com.didi.sdk.util.UiThreadHandler.post(r2)     // Catch:{ all -> 0x0061 }
                    if (r1 == 0) goto L_0x005d
                    r1.close()     // Catch:{ IOException -> 0x0060 }
                L_0x005d:
                    if (r6 == 0) goto L_0x0060
                    goto L_0x0034
                L_0x0060:
                    return
                L_0x0061:
                    r0 = move-exception
                L_0x0062:
                    if (r1 == 0) goto L_0x0067
                    r1.close()     // Catch:{ IOException -> 0x006c }
                L_0x0067:
                    if (r6 == 0) goto L_0x006c
                    r6.close()     // Catch:{ IOException -> 0x006c }
                L_0x006c:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.utils.HttpUtils.C154981.onSuccess(com.didichuxing.foundation.net.rpc.http.HttpRpcResponse):void");
            }

            public void onFailure(HttpRpcRequest httpRpcRequest, final IOException iOException) {
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        if (iDownloadListener != null) {
                            iDownloadListener.onFailed(iOException);
                        }
                    }
                });
            }
        });
    }
}
