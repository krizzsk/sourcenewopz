package com.didichuxing.dfbasesdk.interceptor;

import android.net.Uri;
import android.text.TextUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import java.io.IOException;
import java.util.Map;

public class FormDataParse extends AbsContentTypeParse {
    public static final String BINARY = "binary";
    public static final String Content_Transfer_Encoding = "Content-Transfer-Encoding";

    /* renamed from: a */
    private static final int f46580a = 0;

    /* renamed from: b */
    private static final int f46581b = 1;

    /* renamed from: c */
    private static final int f46582c = 2;

    /* renamed from: d */
    private static final String f46583d = "Content-Disposition";

    public HttpRpcRequest sign(HttpRpcRequest httpRpcRequest) throws IOException {
        String a = m33434a(httpRpcRequest.getEntity().getContent(), httpRpcRequest.getEntity().getContentType().toString());
        LogUtils.m33570i("xxxx", "jsonString: " + a);
        if (TextUtils.isEmpty(a)) {
            return httpRpcRequest;
        }
        Uri.Builder buildUpon = Uri.parse(httpRpcRequest.getUrl()).buildUpon();
        Map<String, Object> queryParam = getQueryParam(a);
        LogUtils.m33570i("xxxx", "getQueryParam: " + queryParam);
        for (Map.Entry next : queryParam.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), String.valueOf(next.getValue()));
        }
        return httpRpcRequest.newBuilder().setUrl(buildUpon.build().toString()).build();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0065, code lost:
        if (r7.equalsIgnoreCase("binary") != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r4.put(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r6.printStackTrace();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m33434a(java.io.InputStream r14, java.lang.String r15) {
        /*
            java.lang.String r0 = ";"
            java.lang.String r1 = "--"
            java.lang.String r2 = "关闭异常"
            java.lang.String r3 = "xxxx"
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            r5 = 0
            java.lang.String r6 = "boundary="
            int r6 = r15.indexOf(r6)     // Catch:{ IOException -> 0x00c5 }
            r7 = -1
            java.lang.String r8 = ""
            if (r6 == r7) goto L_0x003e
            int r6 = r6 + 9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c5 }
            r7.<init>()     // Catch:{ IOException -> 0x00c5 }
            r7.append(r1)     // Catch:{ IOException -> 0x00c5 }
            java.lang.String r15 = r15.substring(r6)     // Catch:{ IOException -> 0x00c5 }
            r7.append(r15)     // Catch:{ IOException -> 0x00c5 }
            java.lang.String r15 = r7.toString()     // Catch:{ IOException -> 0x00c5 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c5 }
            r6.<init>()     // Catch:{ IOException -> 0x00c5 }
            r6.append(r15)     // Catch:{ IOException -> 0x00c5 }
            r6.append(r1)     // Catch:{ IOException -> 0x00c5 }
            java.lang.String r1 = r6.toString()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x0040
        L_0x003e:
            r15 = r8
            r1 = r15
        L_0x0040:
            okio.Source r14 = okio.Okio.source((java.io.InputStream) r14)     // Catch:{ IOException -> 0x00c5 }
            okio.BufferedSource r5 = okio.Okio.buffer((okio.Source) r14)     // Catch:{ IOException -> 0x00c5 }
            r14 = 0
            r7 = r8
            r9 = r7
        L_0x004b:
            r6 = 0
        L_0x004c:
            java.lang.String r10 = r5.readUtf8Line()     // Catch:{ IOException -> 0x00c5 }
            if (r10 == r1) goto L_0x00c1
            if (r10 != 0) goto L_0x0056
            goto L_0x00c1
        L_0x0056:
            r11 = 2
            r12 = 1
            if (r6 == 0) goto L_0x00b9
            if (r6 == r12) goto L_0x0070
            if (r6 == r11) goto L_0x005f
            goto L_0x004c
        L_0x005f:
            java.lang.String r6 = "binary"
            boolean r6 = r7.equalsIgnoreCase(r6)     // Catch:{ IOException -> 0x00c5 }
            if (r6 != 0) goto L_0x004b
            r4.put(r9, r10)     // Catch:{ JSONException -> 0x006b }
            goto L_0x004b
        L_0x006b:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x004b
        L_0x0070:
            boolean r13 = r10.equals(r8)     // Catch:{ IOException -> 0x00c5 }
            if (r13 == 0) goto L_0x0078
            r6 = 2
            goto L_0x004c
        L_0x0078:
            java.lang.String r11 = "Content-Disposition"
            boolean r11 = r10.startsWith(r11)     // Catch:{ Exception -> 0x00b4 }
            if (r11 == 0) goto L_0x009f
            boolean r11 = r10.contains(r0)     // Catch:{ Exception -> 0x00b4 }
            if (r11 == 0) goto L_0x004c
            java.lang.String[] r10 = r10.split(r0)     // Catch:{ Exception -> 0x00b4 }
            r10 = r10[r12]     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r11 = "="
            java.lang.String[] r10 = r10.split(r11)     // Catch:{ Exception -> 0x00b4 }
            r10 = r10[r12]     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r10 = r10.trim()     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r11 = "\""
            java.lang.String r9 = r10.replace(r11, r8)     // Catch:{ Exception -> 0x00b4 }
            goto L_0x004c
        L_0x009f:
            java.lang.String r11 = "Content-Transfer-Encoding"
            boolean r11 = r10.startsWith(r11)     // Catch:{ Exception -> 0x00b4 }
            if (r11 == 0) goto L_0x004c
            java.lang.String r11 = ":"
            java.lang.String[] r10 = r10.split(r11)     // Catch:{ Exception -> 0x00b4 }
            r10 = r10[r12]     // Catch:{ Exception -> 0x00b4 }
            java.lang.String r7 = r10.trim()     // Catch:{ Exception -> 0x00b4 }
            goto L_0x004c
        L_0x00b4:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x004c
        L_0x00b9:
            boolean r10 = r10.startsWith(r15)     // Catch:{ IOException -> 0x00c5 }
            if (r10 == 0) goto L_0x004c
            r6 = 1
            goto L_0x004c
        L_0x00c1:
            r5.close()     // Catch:{ IOException -> 0x00cf }
            goto L_0x00d3
        L_0x00c5:
            r14 = move-exception
            java.lang.String r15 = "getData: "
            com.didichuxing.dfbasesdk.utils.LogUtils.m33567e(r3, r15, r14)     // Catch:{ all -> 0x00d8 }
            r5.close()     // Catch:{ IOException -> 0x00cf }
            goto L_0x00d3
        L_0x00cf:
            r14 = move-exception
            com.didichuxing.dfbasesdk.utils.LogUtils.m33567e(r3, r2, r14)
        L_0x00d3:
            java.lang.String r14 = r4.toString()
            return r14
        L_0x00d8:
            r14 = move-exception
            r5.close()     // Catch:{ IOException -> 0x00dd }
            goto L_0x00e1
        L_0x00dd:
            r15 = move-exception
            com.didichuxing.dfbasesdk.utils.LogUtils.m33567e(r3, r2, r15)
        L_0x00e1:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.interceptor.FormDataParse.m33434a(java.io.InputStream, java.lang.String):java.lang.String");
    }
}
