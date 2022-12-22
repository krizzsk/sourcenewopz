package com.jumio.core.network;

import android.net.ConnectivityManager;
import com.didi.sdk.apm.SystemUtils;
import com.google.common.net.HttpHeaders;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.api.BackendManager;
import com.jumio.core.models.ApiCallDataModel;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import jumio.core.C21339a0;
import jumio.core.C21345d;
import jumio.core.C21348e0;
import jumio.core.C21351f;
import jumio.core.C21380s0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00032\u00020\u0004:\u00012B\u001b\u0012\u0006\u0010%\u001a\u00020$\u0012\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\u001c¢\u0006\u0004\b0\u00101J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0017\u0010\r\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000bH$¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0005H$J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H$J\u000f\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0004J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000bH\u0004J\u0011\u0010\u001a\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\b\u0010\u001b\u001a\u00020\u000bH\u0016R\u001d\u0010!\u001a\u0006\u0012\u0002\b\u00030\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010%\u001a\u00020$8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u000b8T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010\u000b8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*¨\u00063"}, mo175978d2 = {"Lcom/jumio/core/network/ApiCall;", "T", "Ljumio/core/e0;", "Ljava/util/concurrent/Callable;", "", "", "status", "", "time", "", "responseReceived", "", "plainTextAnswer", "parseResponse", "(Ljava/lang/String;)Ljava/lang/Object;", "prepareRequest", "Ljava/io/OutputStream;", "outputStream", "fillRequest", "execute", "()Ljava/lang/Object;", "Ljava/net/HttpURLConnection;", "connection", "close", "useUrl", "createClient", "call", "getCallId", "Lcom/jumio/core/models/ApiCallDataModel;", "c", "Lcom/jumio/core/models/ApiCallDataModel;", "getApiCallDataModel", "()Lcom/jumio/core/models/ApiCallDataModel;", "apiCallDataModel", "TAG", "Ljava/lang/String;", "Ljumio/core/f;", "apiCallSettings", "Ljumio/core/f;", "getApiCallSettings", "()Ljumio/core/f;", "getUri", "()Ljava/lang/String;", "uri", "getMethod", "method", "getBoundary", "boundary", "<init>", "(Ljumio/core/f;Lcom/jumio/core/models/ApiCallDataModel;)V", "a", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: ApiCall.kt */
public abstract class ApiCall<T> extends C21348e0<T> implements Callable<T> {
    public final String TAG = Intrinsics.stringPlus("Network/", getClass().getSimpleName());

    /* renamed from: b */
    public final C21351f f54897b;

    /* renamed from: c */
    public final ApiCallDataModel<?> f54898c;

    /* renamed from: com.jumio.core.network.ApiCall$a */
    /* compiled from: ApiCall.kt */
    public final class C19995a implements Runnable {

        /* renamed from: a */
        public final HttpURLConnection f54899a;

        /* renamed from: b */
        public final OutputStream f54900b;

        /* renamed from: c */
        public final /* synthetic */ ApiCall<T> f54901c;

        public C19995a(ApiCall apiCall, HttpURLConnection httpURLConnection, OutputStream outputStream) {
            Intrinsics.checkNotNullParameter(apiCall, "this$0");
            Intrinsics.checkNotNullParameter(httpURLConnection, "httpURLConnection");
            this.f54901c = apiCall;
            this.f54899a = httpURLConnection;
            this.f54900b = outputStream;
        }

        public void run() {
            try {
                this.f54899a.getResponseCode();
            } catch (Exception e) {
                Log.printStackTrace(e);
            } catch (Throwable th) {
                this.f54901c.close(this.f54899a, this.f54900b);
                throw th;
            }
            this.f54901c.close(this.f54899a, this.f54900b);
        }
    }

    public ApiCall(C21351f fVar, ApiCallDataModel<?> apiCallDataModel) {
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        this.f54897b = fVar;
        this.f54898c = apiCallDataModel;
    }

    /* renamed from: a */
    public final boolean mo162996a() {
        Object systemService = this.f54897b.getContext().getSystemService("connectivity");
        if (systemService != null) {
            return SystemUtils.getActiveNetworkInfo((ConnectivityManager) systemService) == null;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public T call() throws Exception {
        T t;
        Log.m39466i(this.TAG, "-> call()");
        try {
            if (!mo162996a()) {
                Log.m39471v(this.TAG, "execute()");
                try {
                    t = execute();
                } catch (C21345d e) {
                    Log.m39477w(this.TAG, "### ALE key update required. Re-execute call", (Throwable) e);
                    t = execute();
                }
                publishResult(t);
                Log.m39466i(this.TAG, "<- call(success)");
                return t;
            }
            Log.m39476w(this.TAG, "Device is offline");
            throw new Exception("Device is offline");
        } catch (SocketTimeoutException e2) {
            Log.m39466i(this.TAG, "<- call(failed)");
            if (this.f54898c.getIgnoreErrors()) {
                publishResult(null);
                return null;
            }
            publishError(e2);
            return null;
        } catch (C21339a0 e3) {
            Log.m39466i(this.TAG, "<- call(failed)");
            if (this.f54898c.getIgnoreErrors()) {
                publishResult(null);
                return null;
            }
            publishError(e3);
            return null;
        } catch (Exception e4) {
            Log.m39477w(this.TAG, "<- call(failed general error)", (Throwable) e4);
            if (this.f54898c.getIgnoreErrors()) {
                publishResult(null);
                return null;
            }
            publishError(e4);
            return null;
        }
    }

    public final void close(HttpURLConnection httpURLConnection, OutputStream outputStream) {
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                Log.printStackTrace(e);
            }
            try {
                InputStream errorStream = httpURLConnection.getErrorStream();
                if (errorStream != null) {
                    errorStream.close();
                }
            } catch (Exception e2) {
                Log.printStackTrace(e2);
            }
            if (outputStream == null) {
                try {
                    if (httpURLConnection.getDoOutput()) {
                        outputStream = httpURLConnection.getOutputStream();
                    }
                } catch (Exception e3) {
                    Log.printStackTrace(e3);
                }
            }
            if (outputStream != null) {
                outputStream.close();
            }
            httpURLConnection.disconnect();
        }
    }

    public final HttpURLConnection createClient(String str) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        Intrinsics.checkNotNullParameter(str, "useUrl");
        URL url = new URL(str);
        if (url.getProtocol().equals("https")) {
            URLConnection openConnection = url.openConnection();
            if (openConnection != null) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
                String host = url.getHost();
                Intrinsics.checkNotNullExpressionValue(host, "url.host");
                httpsURLConnection.setSSLSocketFactory(new C20001e(new TrustManager[]{new C19997a(host)}));
                httpsURLConnection.setRequestMethod(getMethod());
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(!Intrinsics.areEqual((Object) "GET", (Object) getMethod()));
                httpsURLConnection.setRequestProperty("Content-Type", "application/ale");
                httpsURLConnection.setRequestProperty(HttpHeaders.CONTENT_ENCODING, "identity");
                httpsURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
                httpsURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
                httpsURLConnection.setRequestProperty("User-Agent", this.f54897b.getUserAgent());
                httpsURLConnection.setConnectTimeout(this.f54898c.getTimeout());
                httpsURLConnection.setReadTimeout(this.f54898c.getTimeout());
                return httpsURLConnection;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        }
        throw new Exception("Only https ApiCalls are supported!");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: java.net.HttpURLConnection} */
    /* JADX WARNING: type inference failed for: r11v0, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r3v10, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r11v16, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r11v24 */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* JADX WARNING: type inference failed for: r11v31 */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0239, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x023a, code lost:
        r11 = r3;
        r12 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x023e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x023f, code lost:
        r8 = r2;
        r11 = r3;
        r13 = r4;
        r12 = r5;
        r14 = r6;
        r16 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0285, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0286, code lost:
        r13 = r4;
        r12 = r5;
        r14 = r6;
        r16 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0294, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0295, code lost:
        r12 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02be, code lost:
        r13.reportResponse(r14, r10, (java.lang.Integer) null, r12, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02d4, code lost:
        close(r2, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0142, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0143, code lost:
        r11 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01c6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01c7, code lost:
        r13 = r4;
        r12 = r5;
        r14 = r6;
        r16 = r15;
        r20 = r3;
        r3 = r2;
        r2 = r20;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:50:0x0122, B:71:0x01b3] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0239 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:68:0x01ab] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0270 A[Catch:{ Exception -> 0x0283, all -> 0x0281 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0294 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02bd A[Catch:{ all -> 0x02ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02be A[Catch:{ all -> 0x02ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0142 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:50:0x0122] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T execute() throws java.net.SocketTimeoutException, jumio.core.C21339a0, jumio.core.C21380s0, javax.net.ssl.SSLException {
        /*
            r21 = this;
            r7 = r21
            java.lang.String r0 = "java.lang.String.format(locale, format, *args)"
            java.lang.String r1 = ""
            java.lang.String r6 = r21.getCallId()
            com.jumio.core.util.DataDogHelper r2 = com.jumio.core.util.DataDogHelper.INSTANCE
            com.jumio.core.plugins.AnalyticsPlugin r4 = r2.getPlugin()
            r2 = 0
            r3 = 0
            jumio.core.f r5 = r7.f54897b     // Catch:{ Exception -> 0x02a3, all -> 0x02a0 }
            java.lang.String r5 = r5.getEndpoint()     // Catch:{ Exception -> 0x02a3, all -> 0x02a0 }
            java.lang.String r8 = r21.getUri()     // Catch:{ Exception -> 0x02a3, all -> 0x02a0 }
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r8)     // Catch:{ Exception -> 0x02a3, all -> 0x02a0 }
            java.net.HttpURLConnection r5 = r7.createClient(r5)     // Catch:{ Exception -> 0x02a3, all -> 0x02a0 }
            int r8 = r21.prepareRequest()     // Catch:{ Exception -> 0x0299, all -> 0x0294 }
            java.net.URL r9 = r5.getURL()     // Catch:{ Exception -> 0x0299, all -> 0x0294 }
            java.lang.String r15 = r9.toString()     // Catch:{ Exception -> 0x0299, all -> 0x0294 }
            java.lang.String r9 = "connection.url.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r9)     // Catch:{ Exception -> 0x0299, all -> 0x0294 }
            java.lang.String r9 = r7.TAG     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            kotlin.jvm.internal.StringCompanionObject r10 = kotlin.jvm.internal.StringCompanionObject.INSTANCE     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            java.lang.String r10 = "Sending request %s"
            r11 = 1
            java.lang.Object[] r12 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            r12[r3] = r15     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r11)     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            java.lang.String r10 = java.lang.String.format(r10, r12)     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            java.lang.String r12 = "java.lang.String.format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            com.jumio.commons.log.Log.m39456d((java.lang.String) r9, (java.lang.String) r10)     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            com.jumio.commons.log.Log$LogLevel r9 = com.jumio.commons.log.Log.LogLevel.VERBOSE     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            boolean r9 = com.jumio.commons.log.Log.isLogEnabledForLevel(r9)     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            if (r9 == 0) goto L_0x00ae
            java.util.Map r9 = r5.getRequestProperties()     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            java.lang.String r10 = "connection.requestProperties"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            java.util.Set r9 = r9.entrySet()     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
        L_0x0069:
            boolean r10 = r9.hasNext()     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            if (r10 == 0) goto L_0x00ae
            java.lang.Object r10 = r9.next()     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            java.lang.Object r12 = r10.getKey()     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            java.util.List r10 = (java.util.List) r10     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            java.lang.String r13 = r7.TAG     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            r14.<init>()     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            java.lang.String r11 = "Headers: "
            r14.append(r11)     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            r14.append(r12)     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            r11 = 61
            r14.append(r11)     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            r14.append(r10)     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            java.lang.String r10 = r14.toString()     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            com.jumio.commons.log.Log.m39471v((java.lang.String) r13, (java.lang.String) r10)     // Catch:{ Exception -> 0x00a6, all -> 0x00a1 }
            r11 = 1
            goto L_0x0069
        L_0x00a1:
            r0 = move-exception
            r11 = r2
        L_0x00a3:
            r2 = r5
            goto L_0x02cc
        L_0x00a6:
            r0 = move-exception
            r13 = r4
            r12 = r5
            r14 = r6
            r16 = r15
            goto L_0x028e
        L_0x00ae:
            if (r4 != 0) goto L_0x00b1
            goto L_0x00bd
        L_0x00b1:
            java.lang.String r9 = r5.getRequestMethod()     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            java.lang.String r10 = "connection.requestMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            r4.reportRequest(r6, r15, r8, r9)     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
        L_0x00bd:
            long r9 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            jumio.core.f r11 = r7.f54897b     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            com.jumio.core.network.b r11 = r11.getEncryptionProvider()     // Catch:{ Exception -> 0x0285, all -> 0x0294 }
            r12 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            java.lang.String r14 = r5.getRequestMethod()     // Catch:{ all -> 0x025f }
            java.lang.String r3 = "GET"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r3)     // Catch:{ all -> 0x025f }
            if (r3 != 0) goto L_0x0101
            java.io.OutputStream r3 = r5.getOutputStream()     // Catch:{ all -> 0x00f9 }
            java.lang.String r14 = r21.getBoundary()     // Catch:{ all -> 0x00f9 }
            java.io.OutputStream r3 = r11.mo163034a(r3, r8, r14)     // Catch:{ all -> 0x00f9 }
            r7.fillRequest(r3)     // Catch:{ all -> 0x00f0 }
            r3.flush()     // Catch:{ all -> 0x00f0 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f0 }
            kotlin.p245io.CloseableKt.closeFinally(r3, r2)     // Catch:{ all -> 0x014f }
            goto L_0x0102
        L_0x00f0:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x00f3 }
        L_0x00f3:
            r0 = move-exception
            r2 = r0
            kotlin.p245io.CloseableKt.closeFinally(r3, r1)     // Catch:{ all -> 0x014f }
            throw r2     // Catch:{ all -> 0x014f }
        L_0x00f9:
            r0 = move-exception
        L_0x00fa:
            r13 = r4
            r12 = r5
            r14 = r6
            r16 = r15
            goto L_0x0267
        L_0x0101:
            r3 = r2
        L_0x0102:
            com.jumio.core.models.ApiCallDataModel<?> r2 = r7.f54898c     // Catch:{ all -> 0x0254 }
            boolean r2 = r2.getFireAndForget()     // Catch:{ all -> 0x0254 }
            if (r2 == 0) goto L_0x0152
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ all -> 0x014f }
            com.jumio.core.network.ApiCall$a r2 = new com.jumio.core.network.ApiCall$a     // Catch:{ all -> 0x014f }
            r2.<init>(r7, r5, r3)     // Catch:{ all -> 0x014f }
            r0.<init>(r2)     // Catch:{ all -> 0x014f }
            r0.start()     // Catch:{ all -> 0x014f }
            java.lang.String r0 = r7.TAG     // Catch:{ all -> 0x014f }
            java.lang.String r2 = "Started fire&forget call - return with null response"
            com.jumio.commons.log.Log.m39456d((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ all -> 0x014f }
            java.lang.Object r0 = r7.parseResponse(r1)     // Catch:{ all -> 0x014f }
            com.jumio.core.models.ApiCallDataModel<?> r1 = r7.f54898c     // Catch:{ Exception -> 0x0146, all -> 0x0142 }
            boolean r1 = r1.getFireAndForget()     // Catch:{ Exception -> 0x0146, all -> 0x0142 }
            if (r1 != 0) goto L_0x0136
            long r1 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0146, all -> 0x0142 }
            long r1 = r1 - r9
            double r1 = (double) r1     // Catch:{ Exception -> 0x0146, all -> 0x0142 }
            double r1 = r1 / r12
            long r1 = (long) r1     // Catch:{ Exception -> 0x0146, all -> 0x0142 }
            r8 = 0
            r7.responseReceived(r8, r1)     // Catch:{ Exception -> 0x0146, all -> 0x0142 }
        L_0x0136:
            com.jumio.core.models.ApiCallDataModel<?> r1 = r7.f54898c
            boolean r1 = r1.getFireAndForget()
            if (r1 != 0) goto L_0x0141
            r7.close(r5, r3)
        L_0x0141:
            return r0
        L_0x0142:
            r0 = move-exception
            r11 = r3
            goto L_0x00a3
        L_0x0146:
            r0 = move-exception
            r2 = r3
            r13 = r4
            r12 = r5
            r14 = r6
            r16 = r15
            goto L_0x028d
        L_0x014f:
            r0 = move-exception
            r2 = r3
            goto L_0x00fa
        L_0x0152:
            int r2 = r5.getResponseCode()     // Catch:{ all -> 0x0254 }
            java.lang.String r1 = r7.TAG     // Catch:{ all -> 0x0249 }
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE     // Catch:{ all -> 0x0249 }
            java.util.Locale r8 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x0249 }
            java.lang.String r14 = "Response was %d, %s"
            r12 = 2
            java.lang.Object[] r13 = new java.lang.Object[r12]     // Catch:{ all -> 0x0249 }
            java.lang.Integer r18 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0249 }
            r17 = 0
            r13[r17] = r18     // Catch:{ all -> 0x0249 }
            java.lang.String r18 = r5.getResponseMessage()     // Catch:{ all -> 0x0249 }
            r16 = 1
            r13[r16] = r18     // Catch:{ all -> 0x0249 }
            java.lang.Object[] r13 = java.util.Arrays.copyOf(r13, r12)     // Catch:{ all -> 0x0249 }
            java.lang.String r13 = java.lang.String.format(r8, r14, r13)     // Catch:{ all -> 0x0249 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r0)     // Catch:{ all -> 0x0249 }
            com.jumio.commons.log.Log.m39456d((java.lang.String) r1, (java.lang.String) r13)     // Catch:{ all -> 0x0249 }
            java.lang.String r1 = r7.TAG     // Catch:{ all -> 0x0249 }
            kotlin.jvm.internal.StringCompanionObject r13 = kotlin.jvm.internal.StringCompanionObject.INSTANCE     // Catch:{ all -> 0x0249 }
            java.lang.String r13 = "Received response for %s in %d ms"
            java.lang.Object[] r14 = new java.lang.Object[r12]     // Catch:{ all -> 0x0249 }
            java.net.URL r18 = r5.getURL()     // Catch:{ all -> 0x0249 }
            java.lang.String r18 = r18.toString()     // Catch:{ all -> 0x0249 }
            r17 = 0
            r14[r17] = r18     // Catch:{ all -> 0x0249 }
            r18 = 0
            java.lang.Long r17 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x0249 }
            r16 = 1
            r14[r16] = r17     // Catch:{ all -> 0x0249 }
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r14, r12)     // Catch:{ all -> 0x0249 }
            java.lang.String r8 = java.lang.String.format(r8, r13, r12)     // Catch:{ all -> 0x0249 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)     // Catch:{ all -> 0x0249 }
            com.jumio.commons.log.Log.m39471v((java.lang.String) r1, (java.lang.String) r8)     // Catch:{ all -> 0x0249 }
            com.jumio.core.models.ApiCallDataModel<?> r0 = r7.f54898c     // Catch:{ Exception -> 0x023e, all -> 0x0239 }
            boolean r0 = r0.getFireAndForget()     // Catch:{ Exception -> 0x023e, all -> 0x0239 }
            if (r0 != 0) goto L_0x01d3
            long r0 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x01c6, all -> 0x0142 }
            long r0 = r0 - r9
            double r0 = (double) r0     // Catch:{ Exception -> 0x01c6, all -> 0x0142 }
            r8 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r0 = r0 / r8
            long r0 = (long) r0     // Catch:{ Exception -> 0x01c6, all -> 0x0142 }
            r7.responseReceived(r2, r0)     // Catch:{ Exception -> 0x01c6, all -> 0x0142 }
            r18 = r0
            goto L_0x01d3
        L_0x01c6:
            r0 = move-exception
            r13 = r4
            r12 = r5
            r14 = r6
            r16 = r15
            r20 = r3
            r3 = r2
            r2 = r20
            goto L_0x028e
        L_0x01d3:
            r0 = 200(0xc8, float:2.8E-43)
            if (r2 != r0) goto L_0x01dc
            java.io.InputStream r0 = r5.getInputStream()     // Catch:{ s0 -> 0x0222 }
            goto L_0x01e0
        L_0x01dc:
            java.io.InputStream r0 = r5.getErrorStream()     // Catch:{  }
        L_0x01e0:
            java.lang.String r0 = r11.mo163035a(r0)     // Catch:{  }
            if (r4 != 0) goto L_0x01e9
            r16 = r15
            goto L_0x01ff
        L_0x01e9:
            int r1 = r5.getContentLength()     // Catch:{ Exception -> 0x023e, all -> 0x0239 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x023e, all -> 0x0239 }
            r13 = 0
            r14 = 16
            r1 = 0
            r8 = r4
            r9 = r6
            r10 = r15
            r12 = r2
            r16 = r15
            r15 = r1
            com.jumio.core.plugins.AnalyticsPlugin.C20006a.m39588a(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x021b, all -> 0x0239 }
        L_0x01ff:
            r1 = r21
            r8 = r2
            r2 = r5
            r11 = r3
            r3 = r8
            r13 = r4
            r12 = r5
            r4 = r18
            r14 = r6
            r6 = r0
            java.lang.Object r0 = r1.mo162995a(r2, r3, r4, r6)     // Catch:{ Exception -> 0x0237, all -> 0x0234 }
            com.jumio.core.models.ApiCallDataModel<?> r1 = r7.f54898c
            boolean r1 = r1.getFireAndForget()
            if (r1 != 0) goto L_0x021a
            r7.close(r12, r11)
        L_0x021a:
            return r0
        L_0x021b:
            r0 = move-exception
            r8 = r2
            r11 = r3
            r13 = r4
            r12 = r5
            r14 = r6
            goto L_0x0246
        L_0x0222:
            r0 = move-exception
            r8 = r2
            r11 = r3
            r13 = r4
            r12 = r5
            r14 = r6
            r16 = r15
            int r1 = r0.mo175871a()     // Catch:{ Exception -> 0x0237, all -> 0x0234 }
            if (r1 != 0) goto L_0x0233
            r0.mo175872a(r8)     // Catch:{ Exception -> 0x0237, all -> 0x0234 }
        L_0x0233:
            throw r0     // Catch:{ Exception -> 0x0237, all -> 0x0234 }
        L_0x0234:
            r0 = move-exception
            goto L_0x0297
        L_0x0237:
            r0 = move-exception
            goto L_0x0246
        L_0x0239:
            r0 = move-exception
            r11 = r3
            r12 = r5
            goto L_0x0297
        L_0x023e:
            r0 = move-exception
            r8 = r2
            r11 = r3
            r13 = r4
            r12 = r5
            r14 = r6
            r16 = r15
        L_0x0246:
            r3 = r8
            r2 = r11
            goto L_0x028e
        L_0x0249:
            r0 = move-exception
            r8 = r2
            r11 = r3
            r13 = r4
            r12 = r5
            r14 = r6
            r16 = r15
            r3 = r8
            r2 = r11
            goto L_0x0268
        L_0x0254:
            r0 = move-exception
            r11 = r3
            r13 = r4
            r12 = r5
            r14 = r6
            r16 = r15
            r17 = 0
            r2 = r11
            goto L_0x0267
        L_0x025f:
            r0 = move-exception
            r13 = r4
            r12 = r5
            r14 = r6
            r16 = r15
            r17 = 0
        L_0x0267:
            r3 = 0
        L_0x0268:
            com.jumio.core.models.ApiCallDataModel<?> r1 = r7.f54898c     // Catch:{ Exception -> 0x0283, all -> 0x0281 }
            boolean r1 = r1.getFireAndForget()     // Catch:{ Exception -> 0x0283, all -> 0x0281 }
            if (r1 != 0) goto L_0x0280
            long r4 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0283, all -> 0x0281 }
            long r4 = r4 - r9
            double r4 = (double) r4     // Catch:{ Exception -> 0x0283, all -> 0x0281 }
            r8 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r4 = r4 / r8
            long r4 = (long) r4     // Catch:{ Exception -> 0x0283, all -> 0x0281 }
            r7.responseReceived(r3, r4)     // Catch:{ Exception -> 0x0283, all -> 0x0281 }
        L_0x0280:
            throw r0     // Catch:{ Exception -> 0x0283, all -> 0x0281 }
        L_0x0281:
            r0 = move-exception
            goto L_0x0296
        L_0x0283:
            r0 = move-exception
            goto L_0x028e
        L_0x0285:
            r0 = move-exception
            r13 = r4
            r12 = r5
            r14 = r6
            r16 = r15
            r17 = 0
        L_0x028d:
            r3 = 0
        L_0x028e:
            r1 = r2
            r2 = r12
            r10 = r16
            r12 = r3
            goto L_0x02ad
        L_0x0294:
            r0 = move-exception
            r12 = r5
        L_0x0296:
            r11 = r2
        L_0x0297:
            r2 = r12
            goto L_0x02cc
        L_0x0299:
            r0 = move-exception
            r13 = r4
            r12 = r5
            r14 = r6
            r17 = 0
            goto L_0x02a9
        L_0x02a0:
            r0 = move-exception
            r11 = r2
            goto L_0x02cc
        L_0x02a3:
            r0 = move-exception
            r13 = r4
            r14 = r6
            r17 = 0
            r5 = r2
        L_0x02a9:
            r10 = r1
            r1 = r2
            r2 = r5
            r12 = 0
        L_0x02ad:
            java.lang.Class r3 = r21.getClass()     // Catch:{ all -> 0x02ca }
            java.lang.String r3 = r3.getSimpleName()     // Catch:{ all -> 0x02ca }
            com.jumio.commons.log.Log.m39459e(r3)     // Catch:{ all -> 0x02ca }
            com.jumio.commons.log.Log.printStackTrace(r0)     // Catch:{ all -> 0x02ca }
            if (r13 != 0) goto L_0x02be
            goto L_0x02c5
        L_0x02be:
            r11 = 0
            r8 = r13
            r9 = r14
            r13 = r0
            r8.reportResponse(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x02ca }
        L_0x02c5:
            java.lang.Exception r0 = r7.mo162994a(r0)     // Catch:{ all -> 0x02ca }
            throw r0     // Catch:{ all -> 0x02ca }
        L_0x02ca:
            r0 = move-exception
            r11 = r1
        L_0x02cc:
            com.jumio.core.models.ApiCallDataModel<?> r1 = r7.f54898c
            boolean r1 = r1.getFireAndForget()
            if (r1 != 0) goto L_0x02d7
            r7.close(r2, r11)
        L_0x02d7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.network.ApiCall.execute():java.lang.Object");
    }

    public abstract void fillRequest(OutputStream outputStream) throws IOException;

    public final ApiCallDataModel<?> getApiCallDataModel() {
        return this.f54898c;
    }

    public final C21351f getApiCallSettings() {
        return this.f54897b;
    }

    public abstract String getBoundary();

    public String getCallId() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this::class.java.simpleName");
        return simpleName;
    }

    public String getMethod() {
        return "POST";
    }

    public abstract String getUri();

    public abstract T parseResponse(String str);

    public abstract int prepareRequest() throws Exception;

    public void responseReceived(int i, long j) {
        Analytics.Companion.add(MobileEvents.networkRequest(BackendManager.Companion.callNumber(getClass()), i, j));
    }

    /* renamed from: a */
    public final Exception mo162994a(Exception exc) {
        Exception exc2;
        if ((exc instanceof SocketTimeoutException) || (exc instanceof C21345d) || (exc instanceof C21380s0) || (exc instanceof SSLException)) {
            return exc;
        }
        if (exc instanceof ConnectException) {
            exc2 = new C21380s0(900, exc.getMessage());
        } else {
            exc2 = new C21339a0(exc);
        }
        return exc2;
    }

    /* renamed from: a */
    public final T mo162995a(HttpURLConnection httpURLConnection, int i, long j, String str) {
        LogUtils.logServerResponse(getClass().getSimpleName(), i, j, str);
        if (i == 200) {
            Log.m39456d(this.TAG, "parsing response");
            Log.m39471v(this.TAG, Intrinsics.stringPlus("Response: ", str));
            return parseResponse(str);
        }
        String responseMessage = httpURLConnection.getResponseMessage();
        try {
            responseMessage = new JSONObject(str).getString("message");
        } catch (Exception e) {
            Log.printStackTrace(e);
        }
        throw new C21380s0(i, responseMessage);
    }
}
