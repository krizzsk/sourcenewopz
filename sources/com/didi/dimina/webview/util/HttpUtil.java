package com.didi.dimina.webview.util;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;

public class HttpUtil {

    /* renamed from: a */
    private static final int f18400a = 8192;

    public static String get(String str) {
        try {
            return get(str, (Map<String, String>) null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String get(String str, Map<String, String> map) {
        try {
            return fetch("GET", str, (String) null, map);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String fetch(String str, String str2, String str3, Map<String, String> map) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            if (str != null) {
                httpURLConnection.setRequestMethod(str);
            }
            if (map != null) {
                for (String next : map.keySet()) {
                    httpURLConnection.addRequestProperty(next, map.get(next));
                }
            }
            if (str3 != null) {
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(str3.getBytes());
                outputStream.flush();
                outputStream.close();
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            String streamToString = streamToString(inputStream);
            inputStream.close();
            return httpURLConnection.getResponseCode() == 301 ? fetch(str, httpURLConnection.getHeaderField("Location"), str3, map) : streamToString;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void download(String str, File file) throws Exception {
        InputStream inputStream = new URL(str).openConnection().getInputStream();
        byte[] bArr = new byte[4096];
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.close();
                inputStream.close();
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.util.zip.GZIPInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: java.io.BufferedInputStream} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x010b A[SYNTHETIC, Splitter:B:100:0x010b] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0115 A[SYNTHETIC, Splitter:B:105:0x0115] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x011f A[SYNTHETIC, Splitter:B:110:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6 A[SYNTHETIC, Splitter:B:81:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f0 A[SYNTHETIC, Splitter:B:86:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00fa A[SYNTHETIC, Splitter:B:91:0x00fa] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean downloadImg(java.lang.String r6, java.io.OutputStream r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00d7, all -> 0x00d2 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x00d7, all -> 0x00d2 }
            java.net.URLConnection r6 = r1.openConnection()     // Catch:{ Exception -> 0x00d7, all -> 0x00d2 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ Exception -> 0x00d7, all -> 0x00d2 }
            r1 = 5000(0x1388, float:7.006E-42)
            r6.setConnectTimeout(r1)     // Catch:{ Exception -> 0x00cc, all -> 0x00c6 }
            r6.setReadTimeout(r1)     // Catch:{ Exception -> 0x00cc, all -> 0x00c6 }
            if (r8 == 0) goto L_0x0034
            java.util.Set r1 = r8.keySet()     // Catch:{ Exception -> 0x00cc, all -> 0x00c6 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00cc, all -> 0x00c6 }
        L_0x001e:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x00cc, all -> 0x00c6 }
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x00cc, all -> 0x00c6 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x00cc, all -> 0x00c6 }
            java.lang.Object r3 = r8.get(r2)     // Catch:{ Exception -> 0x00cc, all -> 0x00c6 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x00cc, all -> 0x00c6 }
            r6.addRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00cc, all -> 0x00c6 }
            goto L_0x001e
        L_0x0034:
            java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00cc, all -> 0x00c6 }
            r1 = 8192(0x2000, float:1.14794E-41)
            r8.<init>(r7, r1)     // Catch:{ Exception -> 0x00cc, all -> 0x00c6 }
            java.lang.String r7 = r6.getContentEncoding()     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            java.io.InputStream r2 = r6.getInputStream()     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            r3 = -1
            if (r7 == 0) goto L_0x0080
            java.lang.String r4 = "gzip"
            boolean r7 = r7.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            if (r7 == 0) goto L_0x0080
            java.util.zip.GZIPInputStream r7 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            r7.<init>(r2)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0079, all -> 0x0072 }
            r2.<init>(r7, r1)     // Catch:{ Exception -> 0x0079, all -> 0x0072 }
        L_0x0058:
            int r0 = r7.read()     // Catch:{ Exception -> 0x006b, all -> 0x0064 }
            if (r0 == r3) goto L_0x0062
            r8.write(r0)     // Catch:{ Exception -> 0x006b, all -> 0x0064 }
            goto L_0x0058
        L_0x0062:
            r0 = r7
            goto L_0x0090
        L_0x0064:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
            goto L_0x0104
        L_0x006b:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
            goto L_0x00db
        L_0x0072:
            r1 = move-exception
            r2 = r0
            r0 = r6
            r6 = r7
            r7 = r1
            goto L_0x0104
        L_0x0079:
            r1 = move-exception
            r2 = r0
            r0 = r6
            r6 = r7
            r7 = r1
            goto L_0x00db
        L_0x0080:
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
            r7.<init>(r2, r1)     // Catch:{ Exception -> 0x00c3, all -> 0x00c0 }
        L_0x0085:
            int r1 = r7.read()     // Catch:{ Exception -> 0x00b9, all -> 0x00b1 }
            if (r1 == r3) goto L_0x008f
            r8.write(r1)     // Catch:{ Exception -> 0x00b9, all -> 0x00b1 }
            goto L_0x0085
        L_0x008f:
            r2 = r7
        L_0x0090:
            r7 = 1
            if (r6 == 0) goto L_0x0096
            r6.disconnect()
        L_0x0096:
            r8.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x009e
        L_0x009a:
            r6 = move-exception
            r6.printStackTrace()
        L_0x009e:
            if (r0 == 0) goto L_0x00a8
            r0.close()     // Catch:{ IOException -> 0x00a4 }
            goto L_0x00a8
        L_0x00a4:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00a8:
            r2.close()     // Catch:{ IOException -> 0x00ac }
            goto L_0x00b0
        L_0x00ac:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00b0:
            return r7
        L_0x00b1:
            r1 = move-exception
            r2 = r7
            r7 = r1
            r5 = r0
            r0 = r6
            r6 = r5
            goto L_0x0104
        L_0x00b9:
            r1 = move-exception
            r2 = r7
            r7 = r1
            r5 = r0
            r0 = r6
            r6 = r5
            goto L_0x00db
        L_0x00c0:
            r7 = move-exception
            r2 = r0
            goto L_0x00c9
        L_0x00c3:
            r7 = move-exception
            r2 = r0
            goto L_0x00cf
        L_0x00c6:
            r7 = move-exception
            r8 = r0
            r2 = r8
        L_0x00c9:
            r0 = r6
            r6 = r2
            goto L_0x0104
        L_0x00cc:
            r7 = move-exception
            r8 = r0
            r2 = r8
        L_0x00cf:
            r0 = r6
            r6 = r2
            goto L_0x00db
        L_0x00d2:
            r7 = move-exception
            r6 = r0
            r8 = r6
            r2 = r8
            goto L_0x0104
        L_0x00d7:
            r7 = move-exception
            r6 = r0
            r8 = r6
            r2 = r8
        L_0x00db:
            r7.printStackTrace()     // Catch:{ all -> 0x0103 }
            r7 = 0
            if (r0 == 0) goto L_0x00e4
            r0.disconnect()
        L_0x00e4:
            if (r8 == 0) goto L_0x00ee
            r8.close()     // Catch:{ IOException -> 0x00ea }
            goto L_0x00ee
        L_0x00ea:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00ee:
            if (r6 == 0) goto L_0x00f8
            r6.close()     // Catch:{ IOException -> 0x00f4 }
            goto L_0x00f8
        L_0x00f4:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00f8:
            if (r2 == 0) goto L_0x0102
            r2.close()     // Catch:{ IOException -> 0x00fe }
            goto L_0x0102
        L_0x00fe:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0102:
            return r7
        L_0x0103:
            r7 = move-exception
        L_0x0104:
            if (r0 == 0) goto L_0x0109
            r0.disconnect()
        L_0x0109:
            if (r8 == 0) goto L_0x0113
            r8.close()     // Catch:{ IOException -> 0x010f }
            goto L_0x0113
        L_0x010f:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0113:
            if (r6 == 0) goto L_0x011d
            r6.close()     // Catch:{ IOException -> 0x0119 }
            goto L_0x011d
        L_0x0119:
            r6 = move-exception
            r6.printStackTrace()
        L_0x011d:
            if (r2 == 0) goto L_0x0127
            r2.close()     // Catch:{ IOException -> 0x0123 }
            goto L_0x0127
        L_0x0123:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0127:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.util.HttpUtil.downloadImg(java.lang.String, java.io.OutputStream, java.util.Map):boolean");
    }

    public static String appendQueryParams(String str, Map<String, String> map) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str) || map == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() != 0) {
                sb.append(ParamKeys.SIGN_AND);
            }
            sb.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
            sb.append("=");
            sb.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
        }
        Uri parse = Uri.parse(str);
        Uri.Builder buildUpon = parse.buildUpon();
        String encodedQuery = parse.getEncodedQuery();
        if (!TextUtils.isEmpty(encodedQuery)) {
            sb.append(ParamKeys.SIGN_AND);
            sb.append(encodedQuery);
        }
        buildUpon.encodedQuery(sb.toString());
        return buildUpon.build().toString();
    }

    public static String streamToString(InputStream inputStream) {
        char[] cArr = new char[2048];
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            while (true) {
                int read = inputStreamReader.read(cArr, 0, 2048);
                if (read < 0) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
        } catch (IOException | UnsupportedEncodingException unused) {
        }
        return sb.toString();
    }

    public static String removeUriParameters(String str, Set<String> set) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        Uri.Builder clearQuery = parse.buildUpon().clearQuery();
        for (String next : queryParameterNames) {
            if (!set.contains(next)) {
                clearQuery.appendQueryParameter(next, parse.getQueryParameter(next));
            }
        }
        return clearQuery.build().toString();
    }
}
