package com.didi.trackupload.sdk.datachannel;

import android.content.Context;
import com.didi.map.certificateencryption.CertificateEncryptionUtils;
import com.didi.map.nettransformation.UrlRpcInterceptorV2;
import com.didi.trackupload.sdk.BuildConfig;
import com.didi.trackupload.sdk.Constants;
import com.didi.trackupload.sdk.TrackController;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.utils.TrackLog;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

class HttpSender {

    /* renamed from: a */
    private static final String f43970a = "HttpSender";

    /* renamed from: b */
    private static final String f43971b = "HttpSenderDetail";

    /* renamed from: d */
    private static HttpRpcClient f43972d = null;

    /* renamed from: e */
    private static long f43973e = 10000;

    /* renamed from: f */
    private static final Gson f43974f = new GsonBuilder().setPrettyPrinting().create();

    /* renamed from: h */
    private static long f43975h = 1000000;

    /* renamed from: c */
    private Context f43976c;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SendResult f43977g = null;

    public HttpSender(Context context) {
        this.f43976c = context.getApplicationContext();
        if (f43972d == null) {
            f43972d = (HttpRpcClient) new RpcServiceFactory(context).getRpcClient("http");
        }
    }

    /* renamed from: a */
    public SendResult mo109375a(byte[] bArr, String str) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        byte[] a = m31315a(bArr);
        if (a == null || a.length == 0) {
            return new SendResult(-1, SendResult.DETAIL_ERR_CODE_HTTP_BUILD_WHOLE_MSG, 1);
        }
        HashMap hashMap = new HashMap();
        String token = TrackController.getIntance().getInitParams().getCommonInfoDelegate().getToken();
        if (token == null) {
            token = "";
        }
        hashMap.put("token", token);
        hashMap.put("os", "android");
        hashMap.put("sdkver", BuildConfig.VERSION_NAME);
        hashMap.put("clienttype", str);
        m31312a(a, hashMap, Constants.HTTP_URL_SEND_TRACK, new HttpRpc.Callback() {
            public void onSuccess(HttpRpcResponse httpRpcResponse) {
                int i = -1;
                if (httpRpcResponse.getStatus() == 200) {
                    HttpResult a = HttpSender.this.m31309a(httpRpcResponse);
                    if (a.ret_code == 0) {
                        i = 0;
                    }
                    SendResult unused = HttpSender.this.f43977g = new SendResult(i, a.ret_code, 1);
                } else {
                    SendResult unused2 = HttpSender.this.f43977g = new SendResult(-1, httpRpcResponse.getStatus(), 1);
                }
                TrackLog.m31343d(HttpSender.f43970a, "http response result:" + String.valueOf(HttpSender.this.f43977g));
                countDownLatch.countDown();
            }

            public void onFailure(HttpRpcRequest httpRpcRequest, IOException iOException) {
                TrackLog.m31343d(HttpSender.f43970a, "http response exception:" + iOException.getMessage());
                if (iOException instanceof SocketTimeoutException) {
                    SendResult unused = HttpSender.this.f43977g = new SendResult(-2, 1);
                } else {
                    SendResult unused2 = HttpSender.this.f43977g = new SendResult(-1, -1000, 1);
                }
                TrackLog.m31343d(HttpSender.f43970a, "http response fail:" + String.valueOf(HttpSender.this.f43977g));
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            TrackLog.m31343d(f43970a, "http thread interrupt:" + e.getMessage());
            this.f43977g = new SendResult(-1, -1000, 1);
        }
        return this.f43977g;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public HttpResult m31309a(HttpRpcResponse httpRpcResponse) {
        HttpResult httpResult = new HttpResult();
        HttpEntity entity = httpRpcResponse.getEntity();
        try {
            httpResult = (HttpResult) f43974f.fromJson(new StringDeserializer().deserialize(entity.getContent()), HttpResult.class);
        } catch (IOException e) {
            httpResult.ret_code = -1002;
            httpResult.ret_msg = "local parse exception";
            e.printStackTrace();
        }
        try {
            entity.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return httpResult;
    }

    /* renamed from: a */
    private void m31312a(byte[] bArr, HashMap<String, String> hashMap, String str, HttpRpc.Callback callback) {
        HttpRpcRequest.Builder addHeader = new HttpRpcRequest.Builder().setUrl(str).setMethod(HttpMethod.POST, HttpBody.newInstance(MimeType.parse("application/x-www-form-urlencoded"), bArr)).addHeader(HttpHeaders.CONTENT_ENCODING, "gzip").addHeader("Encode-Version", "1.0");
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                addHeader.addHeader((String) next.getKey(), (String) next.getValue());
            }
        }
        HttpRpcRequest build = addHeader.build();
        HttpRpcClient.Builder newBuilder = f43972d.newBuilder();
        newBuilder.setConnectTimeout(f43973e).setReadTimeout(f43973e).addInterceptor((RpcInterceptor<HttpRpcRequest, HttpRpcResponse>) new UrlRpcInterceptorV2());
        CertificateEncryptionUtils.addSslSocketFactoryForBuilder(newBuilder).build().newRpc(build).enqueue(callback);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0131 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0132  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m31315a(byte[] r15) {
        /*
            r14 = this;
            java.lang.String r0 = "bytes:"
            java.lang.String r1 = "HttpSender"
            java.lang.String r2 = "HttpSenderDetail"
            com.didi.trackupload.sdk.TrackController r3 = com.didi.trackupload.sdk.TrackController.getIntance()
            com.didi.trackupload.sdk.TrackInitParams r3 = r3.getInitParams()
            com.didi.trackupload.sdk.ICommonInfoDelegate r3 = r3.getCommonInfoDelegate()
            r4 = 0
            com.didi.sdk.protobuf.BinaryMsg$Builder r5 = new com.didi.sdk.protobuf.BinaryMsg$Builder     // Catch:{ Exception -> 0x0059 }
            r5.<init>()     // Catch:{ Exception -> 0x0059 }
            int r6 = com.didi.trackupload.sdk.Constants.TRACK_BINARY_MSG_TYPE     // Catch:{ Exception -> 0x0059 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0059 }
            com.didi.sdk.protobuf.BinaryMsg$Builder r5 = r5.type(r6)     // Catch:{ Exception -> 0x0059 }
            okio.ByteString r15 = okio.ByteString.m3607of((byte[]) r15)     // Catch:{ Exception -> 0x0059 }
            com.didi.sdk.protobuf.BinaryMsg$Builder r15 = r5.payload(r15)     // Catch:{ Exception -> 0x0059 }
            long r5 = r3.getCityId()     // Catch:{ Exception -> 0x0059 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x0059 }
            com.didi.sdk.protobuf.BinaryMsg$Builder r15 = r15.city_id(r5)     // Catch:{ Exception -> 0x0059 }
            long r5 = r3.getCountryId()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0059 }
            com.didi.sdk.protobuf.BinaryMsg$Builder r15 = r15.location_country(r5)     // Catch:{ Exception -> 0x0059 }
            long r5 = r3.getCityId()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0059 }
            com.didi.sdk.protobuf.BinaryMsg$Builder r15 = r15.location_cityid(r5)     // Catch:{ Exception -> 0x0059 }
            com.didi.sdk.protobuf.BinaryMsg r15 = r15.build()     // Catch:{ Exception -> 0x0059 }
            byte[] r5 = r15.toByteArray()     // Catch:{ Exception -> 0x0057 }
            goto L_0x0065
        L_0x0057:
            r5 = move-exception
            goto L_0x005b
        L_0x0059:
            r5 = move-exception
            r15 = r4
        L_0x005b:
            java.lang.String r5 = r5.getMessage()
            java.lang.String r6 = "BuildBinaryMsgErr"
            com.didi.trackupload.sdk.utils.OmegaUtils.trackHttpBuildMsgErr(r6, r5)
            r5 = r4
        L_0x0065:
            if (r5 != 0) goto L_0x0068
            return r4
        L_0x0068:
            r6 = 1
            r7 = 0
            com.didi.sdk.protobuf.UserAgent$Builder r8 = new com.didi.sdk.protobuf.UserAgent$Builder     // Catch:{ Exception -> 0x011b }
            r8.<init>()     // Catch:{ Exception -> 0x011b }
            java.lang.String r9 = "android"
            com.didi.sdk.protobuf.UserAgent$Builder r8 = r8.os_type(r9)     // Catch:{ Exception -> 0x011b }
            java.lang.String r9 = com.didi.trackupload.sdk.utils.EquipmentAppUtils.getOSVersion()     // Catch:{ Exception -> 0x011b }
            com.didi.sdk.protobuf.UserAgent$Builder r8 = r8.os_ver(r9)     // Catch:{ Exception -> 0x011b }
            java.lang.String r9 = com.didi.trackupload.sdk.utils.EquipmentAppUtils.getPhoneModel()     // Catch:{ Exception -> 0x011b }
            com.didi.sdk.protobuf.UserAgent$Builder r8 = r8.model(r9)     // Catch:{ Exception -> 0x011b }
            android.content.Context r9 = r14.f43976c     // Catch:{ Exception -> 0x011b }
            java.lang.String r9 = com.didi.trackupload.sdk.utils.EquipmentAppUtils.getAppVersion(r9)     // Catch:{ Exception -> 0x011b }
            com.didi.sdk.protobuf.UserAgent$Builder r8 = r8.client_ver(r9)     // Catch:{ Exception -> 0x011b }
            android.content.Context r9 = r14.f43976c     // Catch:{ Exception -> 0x011b }
            java.lang.String[] r9 = com.didi.trackupload.sdk.utils.NetworkUtils.getNetWorkInfo(r9)     // Catch:{ Exception -> 0x011b }
            r9 = r9[r6]     // Catch:{ Exception -> 0x011b }
            com.didi.sdk.protobuf.UserAgent$Builder r8 = r8.network(r9)     // Catch:{ Exception -> 0x011b }
            java.lang.String r9 = r14.mo109376a()     // Catch:{ Exception -> 0x011b }
            com.didi.sdk.protobuf.UserAgent$Builder r8 = r8.location(r9)     // Catch:{ Exception -> 0x011b }
            android.content.Context r9 = r14.f43976c     // Catch:{ Exception -> 0x011b }
            java.lang.String[] r9 = com.didi.trackupload.sdk.utils.NetworkUtils.getNetWorkInfo(r9)     // Catch:{ Exception -> 0x011b }
            r9 = r9[r7]     // Catch:{ Exception -> 0x011b }
            com.didi.sdk.protobuf.UserAgent$Builder r8 = r8.carrier_operator(r9)     // Catch:{ Exception -> 0x011b }
            com.didi.sdk.protobuf.UserAgent r8 = r8.build()     // Catch:{ Exception -> 0x011b }
            long r9 = f43975h     // Catch:{ Exception -> 0x00bf }
            r11 = 1
            long r11 = r11 + r9
            f43975h = r11     // Catch:{ Exception -> 0x00bf }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x00bf }
            goto L_0x00d1
        L_0x00bf:
            r9 = move-exception
            java.lang.String r10 = "ConvertMsgIdErr"
            java.lang.String r11 = r9.getMessage()     // Catch:{ Exception -> 0x011b }
            com.didi.trackupload.sdk.utils.OmegaUtils.trackHttpBuildMsgErr(r10, r11)     // Catch:{ Exception -> 0x011b }
            java.lang.String r9 = android.util.Log.getStackTraceString(r9)     // Catch:{ Exception -> 0x011b }
            com.didi.trackupload.sdk.utils.TrackLog.m31343d(r1, r9)     // Catch:{ Exception -> 0x011b }
            r9 = r4
        L_0x00d1:
            com.didi.sdk.protobuf.Header$Builder r10 = new com.didi.sdk.protobuf.Header$Builder     // Catch:{ Exception -> 0x011b }
            r10.<init>()     // Catch:{ Exception -> 0x011b }
            int r11 = com.didi.trackupload.sdk.Constants.TRACK_PUSH_MSG_TYPE     // Catch:{ Exception -> 0x011b }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x011b }
            com.didi.sdk.protobuf.Header$Builder r10 = r10.type(r11)     // Catch:{ Exception -> 0x011b }
            java.lang.String r11 = r3.getUid()     // Catch:{ Exception -> 0x011b }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x011b }
            com.didi.sdk.protobuf.Header$Builder r10 = r10.auth_user_id(r11)     // Catch:{ Exception -> 0x011b }
            com.didi.sdk.protobuf.Header$Builder r8 = r10.user_agent(r8)     // Catch:{ Exception -> 0x011b }
            long r10 = r3.getCityId()     // Catch:{ Exception -> 0x011b }
            java.lang.Long r3 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x011b }
            com.didi.sdk.protobuf.Header$Builder r3 = r8.city_id(r3)     // Catch:{ Exception -> 0x011b }
            if (r9 == 0) goto L_0x0103
            long r8 = r9.longValue()     // Catch:{ Exception -> 0x011b }
            goto L_0x0106
        L_0x0103:
            r8 = 999999(0xf423f, double:4.94065E-318)
        L_0x0106:
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x011b }
            r3.msg_id(r8)     // Catch:{ Exception -> 0x011b }
            com.didi.sdk.protobuf.Header r3 = r3.build()     // Catch:{ Exception -> 0x011b }
            byte[] r1 = r3.toByteArray()     // Catch:{ Exception -> 0x0116 }
            goto L_0x012f
        L_0x0116:
            r8 = move-exception
            r13 = r8
            r8 = r3
            r3 = r13
            goto L_0x011d
        L_0x011b:
            r3 = move-exception
            r8 = r4
        L_0x011d:
            java.lang.String r9 = r3.getMessage()
            java.lang.String r10 = "BuildHeaderErr"
            com.didi.trackupload.sdk.utils.OmegaUtils.trackHttpBuildMsgErr(r10, r9)
            java.lang.String r3 = android.util.Log.getStackTraceString(r3)
            com.didi.trackupload.sdk.utils.TrackLog.m31343d(r1, r3)
            r1 = r4
            r3 = r8
        L_0x012f:
            if (r1 != 0) goto L_0x0132
            return r4
        L_0x0132:
            r4 = 22612(0x5854, float:3.1686E-41)
            int r8 = r1.length
            int r8 = r8 + 8
            short r8 = (short) r8
            int r9 = r1.length
            int r9 = r9 + 8
            int r10 = r5.length
            int r9 = r9 + r10
            r10 = 3
            byte[][] r11 = new byte[r10][]
            byte[] r4 = r14.m31314a((short) r4)
            r11[r7] = r4
            byte[] r4 = r14.m31314a((short) r8)
            r11[r6] = r4
            byte[] r4 = r14.m31313a((int) r9)
            r8 = 2
            r11[r8] = r4
            byte[] r4 = r14.m31316a((byte[][]) r11)
            boolean r9 = com.didi.trackupload.sdk.Constants.DEBUG
            if (r9 == 0) goto L_0x01b4
            java.lang.String r9 = "-----------------------http whole msg info----------------------------"
            com.didi.trackupload.sdk.utils.TrackLog.m31343d(r2, r9)     // Catch:{ Exception -> 0x01b4 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b4 }
            r9.<init>()     // Catch:{ Exception -> 0x01b4 }
            java.lang.String r11 = "[BinaryMsg]\n"
            r9.append(r11)     // Catch:{ Exception -> 0x01b4 }
            com.google.gson.Gson r11 = f43974f     // Catch:{ Exception -> 0x01b4 }
            java.lang.String r15 = r11.toJson((java.lang.Object) r15)     // Catch:{ Exception -> 0x01b4 }
            r9.append(r15)     // Catch:{ Exception -> 0x01b4 }
            r9.append(r0)     // Catch:{ Exception -> 0x01b4 }
            r9.append(r5)     // Catch:{ Exception -> 0x01b4 }
            java.lang.String r15 = r9.toString()     // Catch:{ Exception -> 0x01b4 }
            com.didi.trackupload.sdk.utils.TrackLog.m31343d(r2, r15)     // Catch:{ Exception -> 0x01b4 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b4 }
            r15.<init>()     // Catch:{ Exception -> 0x01b4 }
            java.lang.String r9 = "[Header]\n"
            r15.append(r9)     // Catch:{ Exception -> 0x01b4 }
            com.google.gson.Gson r9 = f43974f     // Catch:{ Exception -> 0x01b4 }
            java.lang.String r3 = r9.toJson((java.lang.Object) r3)     // Catch:{ Exception -> 0x01b4 }
            r15.append(r3)     // Catch:{ Exception -> 0x01b4 }
            r15.append(r0)     // Catch:{ Exception -> 0x01b4 }
            r15.append(r1)     // Catch:{ Exception -> 0x01b4 }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x01b4 }
            com.didi.trackupload.sdk.utils.TrackLog.m31343d(r2, r15)     // Catch:{ Exception -> 0x01b4 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b4 }
            r15.<init>()     // Catch:{ Exception -> 0x01b4 }
            java.lang.String r0 = "[OutHeaderBytes]\nbytes:"
            r15.append(r0)     // Catch:{ Exception -> 0x01b4 }
            r15.append(r4)     // Catch:{ Exception -> 0x01b4 }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x01b4 }
            com.didi.trackupload.sdk.utils.TrackLog.m31343d(r2, r15)     // Catch:{ Exception -> 0x01b4 }
        L_0x01b4:
            byte[][] r15 = new byte[r10][]
            r15[r7] = r4
            r15[r6] = r1
            r15[r8] = r5
            byte[] r15 = r14.m31316a((byte[][]) r15)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.datachannel.HttpSender.m31315a(byte[]):byte[]");
    }

    /* renamed from: a */
    private byte[] m31316a(byte[]... bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            if (bArr2 != null) {
                i += bArr2.length;
            }
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            if (bArr4 != null) {
                System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
                i2 += bArr4.length;
            }
        }
        return bArr3;
    }

    /* renamed from: a */
    private byte[] m31313a(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = new Integer(i & 255).byteValue();
            i >>= 8;
        }
        return bArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: short} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m31314a(short r6) {
        /*
            r5 = this;
            r0 = 2
            byte[] r1 = new byte[r0]
            r2 = 0
        L_0x0004:
            if (r2 >= r0) goto L_0x0018
            java.lang.Integer r3 = new java.lang.Integer
            r4 = r6 & 255(0xff, float:3.57E-43)
            r3.<init>(r4)
            byte r3 = r3.byteValue()
            r1[r2] = r3
            int r6 = r6 >> 8
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0018:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.datachannel.HttpSender.m31314a(short):byte[]");
    }

    /* renamed from: a */
    public String mo109376a() {
        TrackLocationInfo retrievedLocInfoRecord = LocationCenter.getIntance().getRetrievedLocInfoRecord();
        return String.format("%d,%3.5f,%3.5f", new Object[]{Integer.valueOf(retrievedLocInfoRecord.coordType.getValue()), Double.valueOf(retrievedLocInfoRecord.lng.doubleValue()), Double.valueOf(retrievedLocInfoRecord.lat.doubleValue())});
    }

    private class HttpResult {
        public int ret_code;
        public String ret_msg;

        private HttpResult() {
        }
    }
}
