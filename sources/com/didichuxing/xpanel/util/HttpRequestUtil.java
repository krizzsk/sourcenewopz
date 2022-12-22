package com.didichuxing.xpanel.util;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.JSONFormSerializer;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class HttpRequestUtil {

    /* renamed from: c */
    private static final String f49584c = "HttpRequestUtil";
    public static boolean hasContext = false;
    public static HttpRequestUtil instance;

    /* renamed from: a */
    RpcServiceFactory f49585a;

    /* renamed from: b */
    HttpRpcClient f49586b;

    public static HttpRequestUtil init(Context context) {
        if (instance == null) {
            instance = new HttpRequestUtil(context);
        } else if (context != null && !hasContext) {
            instance = new HttpRequestUtil(context);
        }
        return instance;
    }

    public static HttpRequestUtil getInstance() {
        return instance;
    }

    public static void requestUrl(String str) {
        HttpRequestUtil httpRequestUtil = instance;
        if (httpRequestUtil != null) {
            httpRequestUtil.request(str);
        } else {
            LogcatUtil.m35795e(f49584c, "instance == null");
        }
    }

    private HttpRequestUtil(Context context) {
        try {
            if (Class.forName("com.didichuxing.foundation.spi.ServiceRegistry") != null && context != null) {
                hasContext = true;
                RpcServiceFactory rpcServiceFactory = new RpcServiceFactory(context.getApplicationContext());
                this.f49585a = rpcServiceFactory;
                this.f49586b = (HttpRpcClient) rpcServiceFactory.getRpcClient("http");
            }
        } catch (Exception unused) {
        }
    }

    public void request(String str) {
        request(str, HttpMethod.GET, (HttpRpc.Callback) null, (HashMap<String, Object>) null);
    }

    public void request(String str, HashMap<String, Object> hashMap) {
        request(str, HttpMethod.GET, (HttpRpc.Callback) null, hashMap);
    }

    public void request(final String str, HttpMethod httpMethod, HttpRpc.Callback callback, final HashMap<String, Object> hashMap) {
        HttpRpcRequest httpRpcRequest;
        String str2 = "?";
        if (!TextUtils.isEmpty(str)) {
            if (this.f49586b != null) {
                if (httpMethod == HttpMethod.GET) {
                    if (!(hashMap == null || hashMap.size() == 0)) {
                        try {
                            InputStream serialize = new JSONFormSerializer().serialize(hashMap);
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                int read = serialize.read();
                                if (read == -1) {
                                    break;
                                }
                                sb.append((char) read);
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str);
                            if (str.contains(str2)) {
                                str2 = ParamKeys.SIGN_AND;
                            }
                            sb2.append(str2);
                            sb2.append(sb.toString());
                            str = sb2.toString();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    LogcatUtil.m35796i(f49584c, "HttpRequestUtil request " + str);
                    httpRpcRequest = new HttpRpcRequest.Builder().get(str).build();
                } else {
                    httpRpcRequest = new HttpRpcRequest.Builder().setUrl(str).setMethod(httpMethod, (hashMap == null || hashMap.size() == 0) ? null : new HttpBody() {
                        public void close() throws IOException {
                        }

                        public MimeType getContentType() {
                            return MimeType.parse("application/x-www-form-urlencoded");
                        }

                        public InputStream getContent() throws IOException {
                            return new JSONFormSerializer().serialize(hashMap);
                        }
                    }).build();
                }
                this.f49586b.newRpc(httpRpcRequest).enqueue(callback);
                return;
            }
            new AsyncTask() {
                /* access modifiers changed from: protected */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
                    if (r0 != null) goto L_0x0041;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
                    r0.disconnect();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
                    return null;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:6:0x0030, code lost:
                    if (r0 != null) goto L_0x0041;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:19:0x0048  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.Object doInBackground(java.lang.Object[] r6) {
                    /*
                        r5 = this;
                        r6 = 0
                        java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x003a, all -> 0x0035 }
                        java.lang.String r1 = r4     // Catch:{ Exception -> 0x003a, all -> 0x0035 }
                        r0.<init>(r1)     // Catch:{ Exception -> 0x003a, all -> 0x0035 }
                        java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x003a, all -> 0x0035 }
                        java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x003a, all -> 0x0035 }
                        java.lang.String r1 = "GET"
                        r0.setRequestMethod(r1)     // Catch:{ Exception -> 0x0033 }
                        r0.connect()     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r1 = "HttpRequestUtil"
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0033 }
                        r2.<init>()     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r3 = "doInBackground "
                        r2.append(r3)     // Catch:{ Exception -> 0x0033 }
                        int r3 = r0.getResponseCode()     // Catch:{ Exception -> 0x0033 }
                        r2.append(r3)     // Catch:{ Exception -> 0x0033 }
                        java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0033 }
                        com.didichuxing.xpanel.util.LogcatUtil.m35794d(r1, r2)     // Catch:{ Exception -> 0x0033 }
                        if (r0 == 0) goto L_0x0044
                        goto L_0x0041
                    L_0x0033:
                        r1 = move-exception
                        goto L_0x003c
                    L_0x0035:
                        r0 = move-exception
                        r4 = r0
                        r0 = r6
                        r6 = r4
                        goto L_0x0046
                    L_0x003a:
                        r1 = move-exception
                        r0 = r6
                    L_0x003c:
                        r1.printStackTrace()     // Catch:{ all -> 0x0045 }
                        if (r0 == 0) goto L_0x0044
                    L_0x0041:
                        r0.disconnect()
                    L_0x0044:
                        return r6
                    L_0x0045:
                        r6 = move-exception
                    L_0x0046:
                        if (r0 == 0) goto L_0x004b
                        r0.disconnect()
                    L_0x004b:
                        throw r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.util.HttpRequestUtil.C165812.doInBackground(java.lang.Object[]):java.lang.Object");
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
    }
}
