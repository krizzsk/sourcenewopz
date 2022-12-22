package com.didichuxing.publicservice.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.network.ThreadTask;
import com.didichuxing.publicservice.resourcecontrol.utils.IoUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpHelper {
    protected static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    private static final int CONNECT_TIMEOUT = 10000;
    public static final int CONNECT_TIMEOUT_LOW = 5000;
    private static int MAX_RETRY_TIMES = 3;
    private static final int MESSAGE_RESULT = 1;
    private static final int MESSAGE_RESULT_FAIL = 11;
    private static final int MESSAGE_RESULT_POST = 12;
    private static final int MESSAGE_RESULT_SUCCESS = 10;
    private static final int READ_TIMEOUT = 10000;
    /* access modifiers changed from: private */
    public static final String TAG = (HttpHelper.class.getSimpleName() + " ");
    private static RequestCallBack mCallBack;
    /* access modifiers changed from: private */
    public static ResultHandler mHandler = new ResultHandler();

    public interface BitmapRequestCallBack {
        void onFail(int i);

        void onSuccess(Bitmap bitmap);
    }

    public interface RequestCallBack {
        void onFail();

        void onSuccess(HttpResult httpResult);
    }

    private static class ResultHandler extends Handler {
        private ResultHandler() {
        }

        public void handleMessage(Message message) {
            RequestCallBack requestCallBack;
            Bundle data;
            super.handleMessage(message);
            if (message.what == 10) {
                RequestCallBack requestCallBack2 = (RequestCallBack) message.obj;
                if (requestCallBack2 != null && (data = message.getData()) != null) {
                    requestCallBack2.onSuccess((HttpResult) data.getSerializable("result"));
                }
            } else if (message.what == 11 && (requestCallBack = (RequestCallBack) message.obj) != null) {
                requestCallBack.onFail();
            }
        }
    }

    public static void get(final String str, final RequestCallBack requestCallBack, final boolean z, int i) {
        ThreadManager.getInstance().getInternetPool().stopAllRunningTasks();
        MAX_RETRY_TIMES = i;
        ThreadTask threadTask = new ThreadTask();
        threadTask.setTaskContentCallBack(new ThreadTask.TaskCallBack() {
            public void setTaskContent() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                HttpResult access$100 = HttpHelper.performRequest(str, z);
                Message obtainMessage = HttpHelper.mHandler.obtainMessage();
                obtainMessage.obj = requestCallBack;
                if (access$100 == null) {
                    obtainMessage.what = 11;
                } else {
                    obtainMessage.what = 10;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("result", access$100);
                    obtainMessage.setData(bundle);
                }
                HttpHelper.mHandler.sendMessage(obtainMessage);
            }
        });
        ThreadManager.getInstance().getInternetPool().execute(threadTask);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (r7 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004a, code lost:
        r7.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
        if (r7 != null) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didichuxing.publicservice.network.HttpHelper.HttpResult performRequest(java.lang.String r7, boolean r8) {
        /*
            r8 = 0
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            r0.<init>(r7)     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            java.net.URL r7 = interceptor(r0)     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ IOException -> 0x0039, all -> 0x0034 }
            java.lang.String r0 = "GET"
            r7.setRequestMethod(r0)     // Catch:{ IOException -> 0x0032 }
            r0 = 10000(0x2710, float:1.4013E-41)
            r7.setReadTimeout(r0)     // Catch:{ IOException -> 0x0032 }
            r7.setConnectTimeout(r0)     // Catch:{ IOException -> 0x0032 }
            r7.connect()     // Catch:{ IOException -> 0x0032 }
            java.io.InputStream r0 = r7.getInputStream()     // Catch:{ IOException -> 0x0032 }
            int r1 = r7.getResponseCode()     // Catch:{ IOException -> 0x0032 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x002f
            convertStreamToString(r0)     // Catch:{ IOException -> 0x0032 }
        L_0x002f:
            if (r7 == 0) goto L_0x004d
            goto L_0x004a
        L_0x0032:
            r0 = move-exception
            goto L_0x003b
        L_0x0034:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            goto L_0x004f
        L_0x0039:
            r0 = move-exception
            r7 = r8
        L_0x003b:
            r3 = r0
            java.lang.String r1 = TAG     // Catch:{ all -> 0x004e }
            java.lang.String r2 = ""
            r0 = 6
            java.lang.String r4 = "com.didichuxing.publicservice.network.HttpHelper"
            r5 = 153(0x99, float:2.14E-43)
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x004e }
            if (r7 == 0) goto L_0x004d
        L_0x004a:
            r7.disconnect()
        L_0x004d:
            return r8
        L_0x004e:
            r8 = move-exception
        L_0x004f:
            if (r7 == 0) goto L_0x0054
            r7.disconnect()
        L_0x0054:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.publicservice.network.HttpHelper.performRequest(java.lang.String, boolean):com.didichuxing.publicservice.network.HttpHelper$HttpResult");
    }

    public static void cancelRequest() {
        ThreadManager.getInstance().getInternetPool().stopAllRunningTasks();
    }

    private static String convertStreamToString(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static void post(final String str, final HashMap<String, Object> hashMap, final RequestCallBack requestCallBack, final int i) {
        ThreadTask threadTask = new ThreadTask();
        threadTask.setTaskContentCallBack(new ThreadTask.TaskCallBack() {
            public void setTaskContent() {
                HttpResult access$300 = HttpHelper.performPostRequest(str, hashMap, i);
                Message obtainMessage = HttpHelper.mHandler.obtainMessage();
                obtainMessage.obj = requestCallBack;
                if (access$300 == null) {
                    obtainMessage.what = 11;
                } else {
                    obtainMessage.what = 10;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("result", access$300);
                    obtainMessage.setData(bundle);
                }
                HttpHelper.mHandler.sendMessage(obtainMessage);
            }
        });
        ThreadManager.getInstance().getInternetPool().execute(threadTask);
    }

    private static URL interceptor(URL url) {
        INonRpcInterceptor iNonRpcInterceptor = (INonRpcInterceptor) ServiceLoader.load(INonRpcInterceptor.class).get();
        return (iNonRpcInterceptor == null || iNonRpcInterceptor.intercept(url) == null) ? url : iNonRpcInterceptor.intercept(url);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: com.didichuxing.publicservice.network.HttpHelper$HttpResult} */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r9v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0140 A[SYNTHETIC, Splitter:B:48:0x0140] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0150 A[SYNTHETIC, Splitter:B:56:0x0150] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didichuxing.publicservice.network.HttpHelper.HttpResult performPostRequest(java.lang.String r7, java.util.HashMap<java.lang.String, java.lang.Object> r8, int r9) {
        /*
            r0 = 10000(0x2710, float:1.4013E-41)
            r1 = 5000(0x1388, float:7.006E-42)
            if (r9 > r1) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            r1 = 10000(0x2710, float:1.4013E-41)
        L_0x0009:
            r9 = 0
            java.lang.String r8 = com.didichuxing.publicservice.general.AppUtils.map2UrlString(r8)     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            r3 = 1
            if (r2 != 0) goto L_0x001f
            int r2 = r8.length()     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            if (r2 <= 0) goto L_0x001f
            java.lang.String r8 = r8.substring(r3)     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
        L_0x001f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            r2.<init>()     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            java.lang.String r4 = TAG     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            r2.append(r4)     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            java.lang.String r4 = " url: "
            r2.append(r4)     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            r2.append(r7)     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            java.lang.String r4 = " ========= paramsString = "
            r2.append(r4)     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            r2.append(r8)     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            com.didichuxing.publicservice.general.AppUtils.log(r2)     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            r2.<init>(r7)     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            java.net.URL r7 = interceptor(r2)     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ IOException -> 0x0113, all -> 0x0110 }
            java.lang.String r2 = "POST"
            r7.setRequestMethod(r2)     // Catch:{ IOException -> 0x010c, all -> 0x0107 }
            r7.setDoOutput(r3)     // Catch:{ IOException -> 0x010c, all -> 0x0107 }
            r7.setReadTimeout(r0)     // Catch:{ IOException -> 0x010c, all -> 0x0107 }
            r7.setConnectTimeout(r1)     // Catch:{ IOException -> 0x010c, all -> 0x0107 }
            r0 = 0
            r7.setUseCaches(r0)     // Catch:{ IOException -> 0x010c, all -> 0x0107 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r1 = "application/x-www-form-urlencoded"
            r7.setRequestProperty(r0, r1)     // Catch:{ IOException -> 0x010c, all -> 0x0107 }
            java.lang.String r0 = "Accept-Charset"
            java.lang.String r1 = "utf-8"
            r7.setRequestProperty(r0, r1)     // Catch:{ IOException -> 0x010c, all -> 0x0107 }
            r7.connect()     // Catch:{ IOException -> 0x010c, all -> 0x0107 }
            java.io.DataOutputStream r0 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x010c, all -> 0x0107 }
            java.io.OutputStream r1 = r7.getOutputStream()     // Catch:{ IOException -> 0x010c, all -> 0x0107 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x010c, all -> 0x0107 }
            byte[] r8 = r8.getBytes()     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            r0.write(r8)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            r0.flush()     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            int r8 = r7.getResponseCode()     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r8 != r1) goto L_0x00da
            java.io.InputStream r8 = r7.getInputStream()     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            java.lang.String r8 = convertStreamToString(r8)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            r1.<init>()     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            java.lang.String r2 = TAG     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            r1.append(r2)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            java.lang.String r2 = " ========= json = "
            r1.append(r2)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            r1.append(r8)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            com.didichuxing.publicservice.general.AppUtils.log(r1)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            com.didichuxing.publicservice.network.HttpHelper$HttpResult r1 = new com.didichuxing.publicservice.network.HttpHelper$HttpResult     // Catch:{ JSONException -> 0x00bb }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00bb }
            r2.<init>(r8)     // Catch:{ JSONException -> 0x00bb }
            r1.<init>((org.json.JSONObject) r2)     // Catch:{ JSONException -> 0x00bb }
        L_0x00b9:
            r9 = r1
            goto L_0x00f3
        L_0x00bb:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            r2.<init>()     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            java.lang.String r3 = TAG     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            r2.append(r3)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            r2.append(r1)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            java.lang.String r1 = r2.toString()     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            com.didichuxing.publicservice.general.AppUtils.logE(r1)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            com.didichuxing.publicservice.network.HttpHelper$HttpResult r1 = new com.didichuxing.publicservice.network.HttpHelper$HttpResult     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            r1.<init>((java.lang.String) r8)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            goto L_0x00b9
        L_0x00da:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            r1.<init>()     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            java.lang.String r2 = TAG     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            r1.append(r2)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            java.lang.String r2 = " ============== responseCode : "
            r1.append(r2)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            r1.append(r8)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            java.lang.String r8 = r1.toString()     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
            com.didichuxing.publicservice.general.AppUtils.log(r8)     // Catch:{ IOException -> 0x0103, all -> 0x0101 }
        L_0x00f3:
            if (r7 == 0) goto L_0x00f8
            r7.disconnect()
        L_0x00f8:
            r0.close()     // Catch:{ IOException -> 0x00fc }
            goto L_0x0143
        L_0x00fc:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x0143
        L_0x0101:
            r8 = move-exception
            goto L_0x0109
        L_0x0103:
            r8 = move-exception
            r3 = r8
            r8 = r0
            goto L_0x0117
        L_0x0107:
            r8 = move-exception
            r0 = r9
        L_0x0109:
            r9 = r7
            r7 = r8
            goto L_0x0149
        L_0x010c:
            r8 = move-exception
            r3 = r8
            r8 = r9
            goto L_0x0117
        L_0x0110:
            r7 = move-exception
            r0 = r9
            goto L_0x0149
        L_0x0113:
            r7 = move-exception
            r3 = r7
            r7 = r9
            r8 = r7
        L_0x0117:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x0144 }
            java.lang.String r2 = ""
            r0 = 6
            java.lang.String r4 = "com.didichuxing.publicservice.network.HttpHelper"
            r5 = 275(0x113, float:3.85E-43)
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0144 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0144 }
            r0.<init>()     // Catch:{ all -> 0x0144 }
            java.lang.String r1 = TAG     // Catch:{ all -> 0x0144 }
            r0.append(r1)     // Catch:{ all -> 0x0144 }
            java.lang.String r1 = "======== IOException ======== 请求失败 ========"
            r0.append(r1)     // Catch:{ all -> 0x0144 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0144 }
            com.didichuxing.publicservice.general.AppUtils.log(r0)     // Catch:{ all -> 0x0144 }
            if (r7 == 0) goto L_0x013e
            r7.disconnect()
        L_0x013e:
            if (r8 == 0) goto L_0x0143
            r8.close()     // Catch:{ IOException -> 0x00fc }
        L_0x0143:
            return r9
        L_0x0144:
            r9 = move-exception
            r0 = r8
            r6 = r9
            r9 = r7
            r7 = r6
        L_0x0149:
            if (r9 == 0) goto L_0x014e
            r9.disconnect()
        L_0x014e:
            if (r0 == 0) goto L_0x0158
            r0.close()     // Catch:{ IOException -> 0x0154 }
            goto L_0x0158
        L_0x0154:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0158:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.publicservice.network.HttpHelper.performPostRequest(java.lang.String, java.util.HashMap, int):com.didichuxing.publicservice.network.HttpHelper$HttpResult");
    }

    public static void requestBitmap(final String str, final BitmapRequestCallBack bitmapRequestCallBack) {
        ThreadTask threadTask = new ThreadTask();
        threadTask.setTaskContentCallBack(new ThreadTask.TaskCallBack() {
            public void setTaskContent() {
                try {
                    bitmapRequestCallBack.onSuccess(BitmapFactory.decodeStream(HttpHelper.getStreamFromNetwork(str)));
                } catch (IOException e) {
                    SystemUtils.log(6, HttpHelper.TAG, "", e, "com.didichuxing.publicservice.network.HttpHelper$3", 303);
                    AppUtils.log(HttpHelper.TAG + "======== IOException ======== 请求失败 ========");
                    bitmapRequestCallBack.onFail(-1);
                }
            }
        });
        ThreadManager.getInstance().getInternetPool().execute(threadTask);
    }

    protected static InputStream getStreamFromNetwork(String str) throws IOException {
        HttpURLConnection createConnection = createConnection(str);
        int i = 0;
        while (createConnection.getResponseCode() / 100 == 3 && i < 3) {
            createConnection = createConnection(createConnection.getHeaderField("Location"));
            i++;
        }
        try {
            return new BufferedInputStream(createConnection.getInputStream(), 32768);
        } catch (IOException e) {
            IoUtils.readAndCloseStream(createConnection.getErrorStream());
            throw e;
        }
    }

    protected static HttpURLConnection createConnection(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) interceptor(new URL(Uri.encode(str, ALLOWED_URI_CHARS))).openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }

    public static final class HttpResult implements Serializable {
        private String originJson;
        public Status status;

        public HttpResult(JSONObject jSONObject) throws JSONException {
            this.originJson = jSONObject.toString();
            this.status = new Status(jSONObject);
        }

        public HttpResult(String str) {
            this.originJson = str;
        }

        public String getOriginJson() {
            return this.originJson;
        }

        public class Status implements Serializable {
            public int code;
            public String msg;

            public Status(JSONObject jSONObject) throws JSONException {
                if (jSONObject != null) {
                    if (jSONObject.has("errorno")) {
                        this.code = jSONObject.getInt("errorno");
                    } else if (jSONObject.has("errno")) {
                        this.code = jSONObject.getInt("errno");
                    }
                    if (jSONObject.has("errormsg")) {
                        this.msg = jSONObject.optString("errormsg");
                    } else if (jSONObject.has("errmsg")) {
                        this.msg = jSONObject.optString("errmsg");
                    }
                }
            }
        }
    }
}
