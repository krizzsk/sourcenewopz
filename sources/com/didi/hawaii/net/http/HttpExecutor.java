package com.didi.hawaii.net.http;

import android.net.Proxy;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class HttpExecutor {
    public static HttpURLConnection createAConnection(String str) {
        try {
            URL url = new URL(str);
            if (!HttpContext.isPorxyPrefer()) {
                try {
                    if (str.startsWith("https:")) {
                        return (HttpsURLConnection) url.openConnection();
                    }
                    return (HttpURLConnection) url.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            } else {
                try {
                    return m17254a(url);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        } catch (MalformedURLException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v32, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v33, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0131 A[Catch:{ NetErrorException -> 0x0138, Exception -> 0x0129, all -> 0x0126, all -> 0x013b }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0132 A[Catch:{ NetErrorException -> 0x0138, Exception -> 0x0129, all -> 0x0126, all -> 0x013b }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0145  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didi.hawaii.net.http.HttpResponse doGetOrPost(boolean r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, byte[] r6, boolean r7, boolean r8) throws com.didi.hawaii.net.http.exception.NetUnavailableException, com.didi.hawaii.net.http.exception.NetErrorException, java.lang.Exception {
        /*
            boolean r8 = com.didi.hawaii.net.http.HttpContext.isNetAvailable()
            if (r8 == 0) goto L_0x0149
            r8 = 1
            if (r3 == 0) goto L_0x000e
            java.lang.String r0 = "navsdk_net"
            com.didi.hawaii.log.HWLog.m16758d(r8, r0, r3)
        L_0x000e:
            r0 = 0
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ NetErrorException -> 0x0138, Exception -> 0x0129, all -> 0x0126 }
            r1.<init>()     // Catch:{ NetErrorException -> 0x0138, Exception -> 0x0129, all -> 0x0126 }
            java.net.HttpURLConnection r3 = createAConnection(r3)     // Catch:{ NetErrorException -> 0x0138, Exception -> 0x0129, all -> 0x0126 }
            if (r3 == 0) goto L_0x011e
            boolean r1 = com.didi.hawaii.utils.StringUtil.isEmpty(r5)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            if (r1 == 0) goto L_0x002d
            java.net.URL r5 = r3.getURL()     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            java.lang.String r5 = r5.getHost()     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            boolean r5 = com.didi.hawaii.utils.StringUtil.isEmpty(r5)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            goto L_0x0032
        L_0x002d:
            java.lang.String r1 = "Host"
            r3.setRequestProperty(r1, r5)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
        L_0x0032:
            if (r2 == 0) goto L_0x003a
            java.lang.String r5 = "GET"
            r3.setRequestMethod(r5)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            goto L_0x003f
        L_0x003a:
            java.lang.String r5 = "POST"
            r3.setRequestMethod(r5)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
        L_0x003f:
            r5 = 15000(0x3a98, float:2.102E-41)
            r3.setConnectTimeout(r5)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            r5 = 45000(0xafc8, float:6.3058E-41)
            r3.setReadTimeout(r5)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            java.lang.String r5 = "User-Agent"
            r3.setRequestProperty(r5, r4)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            r3.setDoInput(r8)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            r4 = 0
            if (r2 != 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r8 = 0
        L_0x0057:
            r3.setDoOutput(r8)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            r3.setUseCaches(r4)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            if (r7 == 0) goto L_0x0066
            java.lang.String r5 = "Connection"
            java.lang.String r7 = "Keep-Alive"
            r3.setRequestProperty(r5, r7)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
        L_0x0066:
            if (r2 != 0) goto L_0x0083
            if (r6 == 0) goto L_0x0083
            int r5 = r6.length     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            if (r5 == 0) goto L_0x0083
            java.lang.String r5 = "Content-type"
            java.lang.String r7 = "application/octet-stream"
            r3.setRequestProperty(r5, r7)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            if (r6 != 0) goto L_0x0078
            r5 = 0
            goto L_0x0079
        L_0x0078:
            int r5 = r6.length     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
        L_0x0079:
            int r5 = r5 + r4
            java.lang.String r7 = "Content-length"
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            r3.setRequestProperty(r7, r5)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
        L_0x0083:
            r3.connect()     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            if (r2 != 0) goto L_0x00ab
            if (r6 == 0) goto L_0x00ab
            int r5 = r6.length     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            if (r5 == 0) goto L_0x00ab
            java.io.DataOutputStream r5 = new java.io.DataOutputStream     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            java.io.OutputStream r7 = r3.getOutputStream()     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            r5.<init>(r7)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            if (r6 == 0) goto L_0x009b
            r5.write(r6)     // Catch:{ NetErrorException -> 0x00a8, Exception -> 0x00a5, all -> 0x00a2 }
        L_0x009b:
            r5.flush()     // Catch:{ NetErrorException -> 0x00a8, Exception -> 0x00a5, all -> 0x00a2 }
            r5.close()     // Catch:{ NetErrorException -> 0x00a8, Exception -> 0x00a5, all -> 0x00a2 }
            goto L_0x00ab
        L_0x00a2:
            r2 = move-exception
            goto L_0x013d
        L_0x00a5:
            r2 = move-exception
            goto L_0x0118
        L_0x00a8:
            r2 = move-exception
            goto L_0x011c
        L_0x00ab:
            int r5 = r3.getResponseCode()     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 == r6) goto L_0x010a
            r6 = 206(0xce, float:2.89E-43)
            if (r5 != r6) goto L_0x00b8
            goto L_0x010a
        L_0x00b8:
            r2 = 202(0xca, float:2.83E-43)
            if (r5 == r2) goto L_0x0102
            r2 = 201(0xc9, float:2.82E-43)
            if (r5 == r2) goto L_0x0102
            r2 = 204(0xcc, float:2.86E-43)
            if (r5 == r2) goto L_0x0102
            r2 = 205(0xcd, float:2.87E-43)
            if (r5 == r2) goto L_0x0102
            r2 = 304(0x130, float:4.26E-43)
            if (r5 == r2) goto L_0x0102
            r2 = 305(0x131, float:4.27E-43)
            if (r5 == r2) goto L_0x0102
            r2 = 408(0x198, float:5.72E-43)
            if (r5 == r2) goto L_0x0102
            r2 = 502(0x1f6, float:7.03E-43)
            if (r5 == r2) goto L_0x0102
            r2 = 504(0x1f8, float:7.06E-43)
            if (r5 == r2) goto L_0x0102
            r2 = 503(0x1f7, float:7.05E-43)
            if (r5 == r2) goto L_0x0102
            r2 = 404(0x194, float:5.66E-43)
            if (r5 != r2) goto L_0x00ea
            if (r3 == 0) goto L_0x00e9
            r3.disconnect()
        L_0x00e9:
            return r0
        L_0x00ea:
            com.didi.hawaii.net.http.exception.NetErrorException r2 = new com.didi.hawaii.net.http.exception.NetErrorException     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            r4.<init>()     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            java.lang.String r6 = "response code is "
            r4.append(r6)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            r4.append(r5)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            java.lang.String r4 = r4.toString()     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            r2.<init>(r4)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            throw r2     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
        L_0x0102:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            java.lang.String r4 = "doGetOrPost retry"
            r2.<init>(r4)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            throw r2     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
        L_0x010a:
            com.didi.hawaii.net.http.HttpResponse r2 = m17253a(r3, r2, r4)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            if (r3 == 0) goto L_0x0113
            r3.disconnect()
        L_0x0113:
            return r2
        L_0x0114:
            r2 = move-exception
            goto L_0x013e
        L_0x0116:
            r2 = move-exception
            r5 = r0
        L_0x0118:
            r0 = r3
            goto L_0x012b
        L_0x011a:
            r2 = move-exception
            r5 = r0
        L_0x011c:
            r0 = r3
            goto L_0x013a
        L_0x011e:
            com.didi.hawaii.net.http.exception.NetErrorException r2 = new com.didi.hawaii.net.http.exception.NetErrorException     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            java.lang.String r4 = "con is null"
            r2.<init>(r4)     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
            throw r2     // Catch:{ NetErrorException -> 0x011a, Exception -> 0x0116, all -> 0x0114 }
        L_0x0126:
            r2 = move-exception
            r3 = r0
            goto L_0x013e
        L_0x0129:
            r2 = move-exception
            r5 = r0
        L_0x012b:
            boolean r3 = com.didi.hawaii.net.http.HttpContext.isNetAvailable()     // Catch:{ all -> 0x013b }
            if (r3 == 0) goto L_0x0132
            throw r2     // Catch:{ all -> 0x013b }
        L_0x0132:
            com.didi.hawaii.net.http.exception.NetUnavailableException r2 = new com.didi.hawaii.net.http.exception.NetUnavailableException     // Catch:{ all -> 0x013b }
            r2.<init>()     // Catch:{ all -> 0x013b }
            throw r2     // Catch:{ all -> 0x013b }
        L_0x0138:
            r2 = move-exception
            r5 = r0
        L_0x013a:
            throw r2     // Catch:{ all -> 0x013b }
        L_0x013b:
            r2 = move-exception
            r3 = r0
        L_0x013d:
            r0 = r5
        L_0x013e:
            if (r0 == 0) goto L_0x0143
            r0.close()
        L_0x0143:
            if (r3 == 0) goto L_0x0148
            r3.disconnect()
        L_0x0148:
            throw r2
        L_0x0149:
            com.didi.hawaii.net.http.exception.NetUnavailableException r2 = new com.didi.hawaii.net.http.exception.NetUnavailableException
            r2.<init>()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.net.http.HttpExecutor.doGetOrPost(boolean, java.lang.String, java.lang.String, java.lang.String, byte[], boolean, boolean):com.didi.hawaii.net.http.HttpResponse");
    }

    /* renamed from: a */
    private static boolean m17255a(String str) {
        return str.contains("navi/v1/driver/didiroute/encrypt");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x008b A[SYNTHETIC, Splitter:B:38:0x008b] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.didi.hawaii.net.http.HttpResponse m17253a(java.net.HttpURLConnection r9, boolean r10, boolean r11) throws java.io.IOException {
        /*
            r0 = 0
            com.didi.hawaii.net.http.HttpResponse r1 = new com.didi.hawaii.net.http.HttpResponse     // Catch:{ all -> 0x0088 }
            r1.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = r9.getContentType()     // Catch:{ all -> 0x0088 }
            java.lang.String r3 = m17256b(r2)     // Catch:{ all -> 0x0088 }
            r1.charset = r3     // Catch:{ all -> 0x0088 }
            if (r10 == 0) goto L_0x001e
            boolean r10 = com.didi.hawaii.net.http.HttpContext.isWAPFeePage(r2)     // Catch:{ all -> 0x0088 }
            if (r10 == 0) goto L_0x001e
            r9.disconnect()     // Catch:{ all -> 0x0088 }
            r9.connect()     // Catch:{ all -> 0x0088 }
        L_0x001e:
            java.io.InputStream r9 = r9.getInputStream()     // Catch:{ all -> 0x0088 }
            r10 = 1024(0x400, float:1.435E-42)
            r2 = 0
            if (r9 == 0) goto L_0x004e
            byte[] r3 = new byte[r2]     // Catch:{ all -> 0x004a }
            r1.data = r3     // Catch:{ all -> 0x004a }
            byte[] r3 = new byte[r10]     // Catch:{ all -> 0x004a }
            r4 = 0
        L_0x002e:
            int r5 = r9.read(r3)     // Catch:{ all -> 0x004a }
            if (r5 <= 0) goto L_0x0047
            int r4 = r4 + r5
            byte[] r6 = new byte[r4]     // Catch:{ all -> 0x004a }
            byte[] r7 = r1.data     // Catch:{ all -> 0x004a }
            byte[] r8 = r1.data     // Catch:{ all -> 0x004a }
            int r8 = r8.length     // Catch:{ all -> 0x004a }
            java.lang.System.arraycopy(r7, r2, r6, r2, r8)     // Catch:{ all -> 0x004a }
            byte[] r7 = r1.data     // Catch:{ all -> 0x004a }
            int r7 = r7.length     // Catch:{ all -> 0x004a }
            java.lang.System.arraycopy(r3, r2, r6, r7, r5)     // Catch:{ all -> 0x004a }
            r1.data = r6     // Catch:{ all -> 0x004a }
        L_0x0047:
            if (r5 > 0) goto L_0x002e
            goto L_0x004e
        L_0x004a:
            r10 = move-exception
            r0 = r9
            r9 = r10
            goto L_0x0089
        L_0x004e:
            if (r11 == 0) goto L_0x0082
            java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x007b }
            r11.<init>()     // Catch:{ Exception -> 0x007b }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x007b }
            r3.<init>(r0)     // Catch:{ Exception -> 0x007b }
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x007b }
            r4.<init>(r3)     // Catch:{ Exception -> 0x007b }
            byte[] r5 = new byte[r10]     // Catch:{ Exception -> 0x007b }
        L_0x0061:
            int r6 = r4.read(r5, r2, r10)     // Catch:{ Exception -> 0x007b }
            if (r6 <= 0) goto L_0x006b
            r11.write(r5, r2, r6)     // Catch:{ Exception -> 0x007b }
            goto L_0x0061
        L_0x006b:
            r4.close()     // Catch:{ Exception -> 0x007b }
            r3.close()     // Catch:{ Exception -> 0x007b }
            r11.close()     // Catch:{ Exception -> 0x007b }
            byte[] r10 = r11.toByteArray()     // Catch:{ Exception -> 0x007b }
            r1.data = r10     // Catch:{ Exception -> 0x007b }
            goto L_0x0082
        L_0x007b:
            if (r9 == 0) goto L_0x0081
            r9.close()     // Catch:{ IOException -> 0x0081 }
        L_0x0081:
            return r0
        L_0x0082:
            if (r9 == 0) goto L_0x0087
            r9.close()     // Catch:{ IOException -> 0x0087 }
        L_0x0087:
            return r1
        L_0x0088:
            r9 = move-exception
        L_0x0089:
            if (r0 == 0) goto L_0x008e
            r0.close()     // Catch:{ IOException -> 0x008e }
        L_0x008e:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.net.http.HttpExecutor.m17253a(java.net.HttpURLConnection, boolean, boolean):com.didi.hawaii.net.http.HttpResponse");
    }

    /* renamed from: b */
    private static String m17256b(String str) {
        if (str != null) {
            String[] split = str.split(";");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str2 = split[i];
                if (str2.contains("charset")) {
                    String[] split2 = str2.split("=");
                    if (split2.length > 1) {
                        return split2[1].trim();
                    }
                } else {
                    i++;
                }
            }
        }
        return "utf-8";
    }

    /* renamed from: a */
    private static HttpURLConnection m17254a(URL url) throws IOException {
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultPort == -1) {
            defaultPort = 80;
        }
        return (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(defaultHost, defaultPort)));
    }
}
