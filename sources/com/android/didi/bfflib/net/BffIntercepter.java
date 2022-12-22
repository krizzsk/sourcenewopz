package com.android.didi.bfflib.net;

import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@ServiceProvider({RpcInterceptor.class})
public class BffIntercepter implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f1 A[Catch:{ Exception -> 0x0106 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didichuxing.foundation.net.rpc.http.HttpRpcResponse intercept(com.didichuxing.foundation.rpc.RpcInterceptor.RpcChain<com.didichuxing.foundation.net.rpc.http.HttpRpcRequest, com.didichuxing.foundation.net.rpc.http.HttpRpcResponse> r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "didi-header-rid"
            java.lang.Object r1 = r8.getRequest()
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r1 = (com.didichuxing.foundation.net.rpc.http.HttpRpcRequest) r1
            java.lang.String r2 = r1.getUrl()
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r3 = r2.getPath()     // Catch:{ Exception -> 0x0106 }
            if (r3 == 0) goto L_0x010a
            java.lang.String r4 = "/halo/v1/multi/ability"
            boolean r4 = r3.endsWith(r4)     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x010a
            com.didichuxing.foundation.net.http.HttpEntity r4 = r1.getEntity()     // Catch:{ Exception -> 0x0106 }
            java.io.InputStream r4 = r4.getContent()     // Catch:{ Exception -> 0x0106 }
            byte[] r4 = r7.streamToByteArray(r4)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x0106 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0106 }
            java.lang.Object r4 = com.didichuxing.foundation.p188io.JSON.parse((java.lang.String) r5)     // Catch:{ Exception -> 0x0106 }
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ Exception -> 0x0106 }
            java.lang.String r5 = "abilities"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch:{ Exception -> 0x0106 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0106 }
            r5.<init>()     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x0054
            java.util.Iterator r4 = r4.keys()     // Catch:{ Exception -> 0x0106 }
        L_0x0046:
            boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x0106 }
            if (r6 == 0) goto L_0x0054
            java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x0106 }
            r5.add(r6)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0046
        L_0x0054:
            java.util.Collections.sort(r5)     // Catch:{ Exception -> 0x0106 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0106 }
            r4.<init>()     // Catch:{ Exception -> 0x0106 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0106 }
        L_0x0060:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x0106 }
            if (r6 == 0) goto L_0x0075
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x0106 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0106 }
            r4.append(r6)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r6 = "_"
            r4.append(r6)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0060
        L_0x0075:
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0106 }
            int r5 = r4.length()     // Catch:{ Exception -> 0x0106 }
            if (r5 <= 0) goto L_0x008a
            r5 = 0
            int r6 = r4.length()     // Catch:{ Exception -> 0x0106 }
            int r6 = r6 + -1
            java.lang.String r4 = r4.substring(r5, r6)     // Catch:{ Exception -> 0x0106 }
        L_0x008a:
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0106 }
            if (r5 != 0) goto L_0x010a
            boolean r5 = com.android.didi.bfflib.debug.BffDebugUtil.isDebug()     // Catch:{ Exception -> 0x0106 }
            java.lang.String r6 = "/"
            if (r5 == 0) goto L_0x00bd
            boolean r5 = com.android.didi.bfflib.debug.BffDebugUtil.isMd5Open()     // Catch:{ Exception -> 0x0106 }
            if (r5 != 0) goto L_0x00bd
            android.net.Uri$Builder r2 = r2.buildUpon()     // Catch:{ Exception -> 0x0106 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0106 }
            r5.<init>()     // Catch:{ Exception -> 0x0106 }
            r5.append(r3)     // Catch:{ Exception -> 0x0106 }
            r5.append(r6)     // Catch:{ Exception -> 0x0106 }
            r5.append(r4)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0106 }
            android.net.Uri$Builder r2 = r2.path(r3)     // Catch:{ Exception -> 0x0106 }
            android.net.Uri r2 = r2.build()     // Catch:{ Exception -> 0x0106 }
            goto L_0x00e3
        L_0x00bd:
            java.lang.String r4 = com.didi.sdk.util.MD5.toMD5((java.lang.String) r4)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ Exception -> 0x0106 }
            android.net.Uri$Builder r2 = r2.buildUpon()     // Catch:{ Exception -> 0x0106 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0106 }
            r5.<init>()     // Catch:{ Exception -> 0x0106 }
            r5.append(r3)     // Catch:{ Exception -> 0x0106 }
            r5.append(r6)     // Catch:{ Exception -> 0x0106 }
            r5.append(r4)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0106 }
            android.net.Uri$Builder r2 = r2.path(r3)     // Catch:{ Exception -> 0x0106 }
            android.net.Uri r2 = r2.build()     // Catch:{ Exception -> 0x0106 }
        L_0x00e3:
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r3 = r1.newBuilder()     // Catch:{ Exception -> 0x0106 }
            java.lang.String r4 = r1.getHeader(r0)     // Catch:{ Exception -> 0x0106 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0106 }
            if (r4 == 0) goto L_0x00f9
            r4 = 0
            java.lang.String r4 = didihttp.internal.trace.IdGenrator.generate(r4)     // Catch:{ Exception -> 0x0106 }
            r3.addHeader((java.lang.String) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x0106 }
        L_0x00f9:
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0106 }
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest$Builder r0 = r3.setUrl((java.lang.String) r0)     // Catch:{ Exception -> 0x0106 }
            com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r1 = r0.build()     // Catch:{ Exception -> 0x0106 }
            goto L_0x010a
        L_0x0106:
            r0 = move-exception
            r0.printStackTrace()
        L_0x010a:
            java.lang.Object r8 = r8.proceed(r1)
            com.didichuxing.foundation.net.rpc.http.HttpRpcResponse r8 = (com.didichuxing.foundation.net.rpc.http.HttpRpcResponse) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.didi.bfflib.net.BffIntercepter.intercept(com.didichuxing.foundation.rpc.RpcInterceptor$RpcChain):com.didichuxing.foundation.net.rpc.http.HttpRpcResponse");
    }

    public byte[] streamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
