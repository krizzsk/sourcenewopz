package com.didichuxing.mas.sdk.quality.report.transport;

import android.net.TrafficStats;
import android.os.Build;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.analysis.Tracker;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class HttpSender {
    private static String omegaUserAgent = ("Omega/" + MASConfig.MAS_SDK_VERSION + " (android, " + MASConfig.CUSTOM_APP_NAME + ")");

    public static String post(String str, String str2, Map<String, String> map, String str3) throws IOException {
        return post(str, str2.getBytes("UTF-8"), map, str3);
    }

    public static String post(String str, String str2, Map<String, String> map) throws IOException {
        return post(str, str2.getBytes("UTF-8"), map, (String) null);
    }

    public static String post(String str, byte[] bArr, Map<String, String> map, String str2) throws IOException {
        int i = 0;
        while (true) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                String post = post(str, (InputStream) byteArrayInputStream, map, bArr.length > 1048576);
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    OLog.m34419e("HttpSender post", e);
                }
                return post;
            } catch (IOException e2) {
                int i2 = i + 1;
                if (i >= MASConfig.HTTP_SENDER_RETRY_TIMES) {
                    if (str2 != null && !str2.equals("")) {
                        Tracker.trackCounter(str2);
                    }
                    throw e2;
                }
                try {
                    byteArrayInputStream.close();
                } catch (IOException e3) {
                    OLog.m34419e("HttpSender post", e3);
                }
                i = i2;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e4) {
                    OLog.m34419e("HttpSender post", e4);
                }
                throw th;
            }
        }
    }

    public static String post(String str, File file, Map<String, String> map) throws Exception {
        int i = 0;
        while (true) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String post = post(str, (InputStream) fileInputStream, map, file.length() > 1048576);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    OLog.m34418e(e.getMessage());
                }
                return post;
            } catch (FileTooLargeException e2) {
                throw e2;
            } catch (IOException e3) {
                int i2 = i + 1;
                if (i < MASConfig.HTTP_SENDER_RETRY_TIMES) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        OLog.m34418e(e4.getMessage());
                    }
                    i = i2;
                } else {
                    throw e3;
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    OLog.m34418e(e5.getMessage());
                }
                throw th;
            }
        }
    }

    public static String post(String str, InputStream inputStream, Map<String, String> map) throws IOException {
        return post(str, inputStream, map, false);
    }

    public static String post(String str, InputStream inputStream, Map<String, String> map, boolean z) throws IOException {
        long nanoTime = System.nanoTime();
        String doPost = doPost(str, inputStream, map, z);
        OLog.m34424w("total upload request time：" + ((System.nanoTime() - nanoTime) / 1000000) + "ms");
        return doPost;
    }

    private static String doPost(String str, InputStream inputStream, Map<String, String> map, boolean z) throws IOException {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(1);
        }
        HttpURLConnection openAndSend = openAndSend(str, "POST", inputStream, map, z);
        int responseCode = openAndSend.getResponseCode();
        if (500 <= responseCode) {
            String str2 = "url:" + str + " response code:" + openAndSend.getResponseCode() + ".";
            openAndSend.disconnect();
            throw new IOException(str2);
        } else if (responseCode != 413) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openAndSend.getInputStream(), "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
            openAndSend.disconnect();
            bufferedReader.close();
            if (Build.VERSION.SDK_INT >= 14) {
                TrafficStats.clearThreadStatsTag();
            }
            return sb.toString();
        } else {
            throw new FileTooLargeException("File too large, drop it!!");
        }
    }

    public static HttpResponse get(String str, Map<String, String> map) throws IOException {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(1);
        }
        HttpURLConnection openAndSend = openAndSend(str, "GET", (InputStream) null, map, false);
        if (200 == openAndSend.getResponseCode()) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openAndSend.getInputStream(), "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
            openAndSend.disconnect();
            bufferedReader.close();
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.setBody(sb.toString());
            httpResponse.setHeaders(openAndSend.getHeaderFields());
            if (Build.VERSION.SDK_INT >= 14) {
                TrafficStats.clearThreadStatsTag();
            }
            return httpResponse;
        }
        String str2 = "url:" + str + " response code:" + openAndSend.getResponseCode() + ".";
        openAndSend.disconnect();
        throw new IOException(str2);
    }

    private static HttpURLConnection openAndSend(String str, String str2, InputStream inputStream, Map<String, String> map, boolean z) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        if ("POST".equals(str2) || "PUT".equals(str2)) {
            httpURLConnection.setDoOutput(true);
        }
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setRequestProperty("User-Agent", omegaUserAgent);
        if (z) {
            httpURLConnection.setChunkedStreamingMode(8192);
        }
        if (map != null) {
            for (String next : map.keySet()) {
                String str3 = map.get(next);
                if (str3 != null) {
                    httpURLConnection.setRequestProperty(next, str3);
                }
            }
        }
        if (inputStream != null) {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            outputStream.flush();
            outputStream.close();
        }
        return httpURLConnection;
    }

    public static String httpGet(String str) {
        return httpGet(str, (Map<String, String>) null);
    }

    public static String httpPost(String str, String str2) {
        return httpPost(str, str2, (Map<String, String>) null);
    }

    public static String httpPost(String str, Map<String, Object> map) {
        return httpPost(str, getParams(map), (Map<String, String>) null);
    }

    public static String httpPost(String str, Map<String, Object> map, Map<String, String> map2) {
        StringBuilder sb = new StringBuilder();
        for (String next : map.keySet()) {
            if (sb.length() == 0) {
                sb.append(next);
                sb.append("=");
                sb.append(map.get(next));
            } else {
                sb.append(ParamKeys.SIGN_AND);
                sb.append(next);
                sb.append("=");
                sb.append(map.get(next));
            }
        }
        return httpPost(str, sb.toString(), map2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.io.OutputStreamWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r6v3, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.OutputStreamWriter] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b9 A[SYNTHETIC, Splitter:B:50:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c3 A[SYNTHETIC, Splitter:B:55:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00cd A[DONT_GENERATE] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String httpPost(java.lang.String r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00ec }
            r1.<init>(r6)     // Catch:{ MalformedURLException -> 0x00ec }
            int r6 = android.os.Build.VERSION.SDK_INT
            r2 = 1
            r3 = 14
            if (r6 < r3) goto L_0x0010
            android.net.TrafficStats.setThreadStatsTag(r2)
        L_0x0010:
            java.net.URLConnection r6 = r1.openConnection()     // Catch:{ all -> 0x00ac }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ all -> 0x00ac }
            r6.setDoOutput(r2)     // Catch:{ all -> 0x00a9 }
            java.lang.String r1 = "POST"
            r6.setRequestMethod(r1)     // Catch:{ all -> 0x00a9 }
            r1 = 10000(0x2710, float:1.4013E-41)
            r6.setConnectTimeout(r1)     // Catch:{ all -> 0x00a9 }
            r6.setReadTimeout(r1)     // Catch:{ all -> 0x00a9 }
            java.lang.String r1 = "User-Agent"
            java.lang.String r2 = omegaUserAgent     // Catch:{ all -> 0x00a9 }
            r6.setRequestProperty(r1, r2)     // Catch:{ all -> 0x00a9 }
            if (r8 == 0) goto L_0x004d
            java.util.Set r1 = r8.keySet()     // Catch:{ all -> 0x00a9 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00a9 }
        L_0x0037:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00a9 }
            if (r2 == 0) goto L_0x004d
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00a9 }
            java.lang.Object r4 = r8.get(r2)     // Catch:{ all -> 0x00a9 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00a9 }
            r6.setRequestProperty(r2, r4)     // Catch:{ all -> 0x00a9 }
            goto L_0x0037
        L_0x004d:
            java.io.OutputStreamWriter r8 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00a9 }
            java.io.OutputStream r1 = r6.getOutputStream()     // Catch:{ all -> 0x00a9 }
            r8.<init>(r1)     // Catch:{ all -> 0x00a9 }
            r8.write(r7)     // Catch:{ all -> 0x00a5 }
            r8.flush()     // Catch:{ all -> 0x00a5 }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ all -> 0x00a5 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x00a5 }
            java.io.InputStream r2 = r6.getInputStream()     // Catch:{ all -> 0x00a5 }
            r1.<init>(r2)     // Catch:{ all -> 0x00a5 }
            r7.<init>(r1)     // Catch:{ all -> 0x00a5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            r1.<init>()     // Catch:{ all -> 0x009f }
        L_0x006f:
            java.lang.String r2 = r7.readLine()     // Catch:{ all -> 0x009f }
            if (r2 == 0) goto L_0x007e
            r1.append(r2)     // Catch:{ all -> 0x009f }
            java.lang.String r2 = "\n"
            r1.append(r2)     // Catch:{ all -> 0x009f }
            goto L_0x006f
        L_0x007e:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x009f }
            if (r2 < r3) goto L_0x0085
            android.net.TrafficStats.clearThreadStatsTag()     // Catch:{ all -> 0x009f }
        L_0x0085:
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x009f }
            r8.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0091:
            r7.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0099:
            if (r6 == 0) goto L_0x009e
            r6.disconnect()
        L_0x009e:
            return r0
        L_0x009f:
            r1 = move-exception
            r5 = r8
            r8 = r7
            r7 = r1
            r1 = r5
            goto L_0x00b0
        L_0x00a5:
            r7 = move-exception
            r1 = r8
            r8 = r0
            goto L_0x00b0
        L_0x00a9:
            r7 = move-exception
            r8 = r0
            goto L_0x00af
        L_0x00ac:
            r7 = move-exception
            r6 = r0
            r8 = r6
        L_0x00af:
            r1 = r8
        L_0x00b0:
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00d1 }
            com.didichuxing.mas.sdk.quality.report.utils.OLog.m34418e(r7)     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x00c1
            r1.close()     // Catch:{ IOException -> 0x00bd }
            goto L_0x00c1
        L_0x00bd:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00c1:
            if (r8 == 0) goto L_0x00cb
            r8.close()     // Catch:{ IOException -> 0x00c7 }
            goto L_0x00cb
        L_0x00c7:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00cb:
            if (r6 == 0) goto L_0x00d0
            r6.disconnect()
        L_0x00d0:
            return r0
        L_0x00d1:
            r7 = move-exception
            if (r1 == 0) goto L_0x00dc
            r1.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00dc
        L_0x00d8:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00dc:
            if (r8 == 0) goto L_0x00e6
            r8.close()     // Catch:{ IOException -> 0x00e2 }
            goto L_0x00e6
        L_0x00e2:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00e6:
            if (r6 == 0) goto L_0x00eb
            r6.disconnect()
        L_0x00eb:
            throw r7
        L_0x00ec:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "url err:"
            r8.append(r1)
            java.lang.String r7 = r7.toString()
            r8.append(r7)
            java.lang.String r7 = " url:"
            r8.append(r7)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            com.didichuxing.mas.sdk.quality.report.utils.OLog.m34418e(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.transport.HttpSender.httpPost(java.lang.String, java.lang.String, java.util.Map):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x009e A[SYNTHETIC, Splitter:B:46:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0 A[SYNTHETIC, Splitter:B:56:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String httpGet(java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00be }
            r1.<init>(r6)     // Catch:{ MalformedURLException -> 0x00be }
            int r6 = android.os.Build.VERSION.SDK_INT
            r2 = 1
            r3 = 14
            if (r6 < r3) goto L_0x0010
            android.net.TrafficStats.setThreadStatsTag(r2)
        L_0x0010:
            java.net.URLConnection r6 = r1.openConnection()     // Catch:{ IOException -> 0x0096, all -> 0x0093 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ IOException -> 0x0096, all -> 0x0093 }
            r6.setDoOutput(r2)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.lang.String r1 = "GET"
            r6.setRequestMethod(r1)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            r1 = 10000(0x2710, float:1.4013E-41)
            r6.setConnectTimeout(r1)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            r6.setReadTimeout(r1)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            if (r7 == 0) goto L_0x0046
            java.util.Set r1 = r7.keySet()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
        L_0x0030:
            boolean r2 = r1.hasNext()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            if (r2 == 0) goto L_0x0046
            java.lang.Object r2 = r1.next()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.lang.Object r4 = r7.get(r2)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            r6.setRequestProperty(r2, r4)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            goto L_0x0030
        L_0x0046:
            r6.connect()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.io.InputStream r2 = r6.getInputStream()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            r7.<init>(r1)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
            r1.<init>()     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
        L_0x005c:
            java.lang.String r2 = r7.readLine()     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
            if (r2 == 0) goto L_0x006b
            r1.append(r2)     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
            java.lang.String r2 = "\n"
            r1.append(r2)     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
            goto L_0x005c
        L_0x006b:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
            if (r2 < r3) goto L_0x0072
            android.net.TrafficStats.clearThreadStatsTag()     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
        L_0x0072:
            java.lang.String r0 = r1.toString()     // Catch:{ IOException -> 0x0089, all -> 0x0084 }
            r7.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r7 = move-exception
            r7.printStackTrace()
        L_0x007e:
            if (r6 == 0) goto L_0x0083
            r6.disconnect()
        L_0x0083:
            return r0
        L_0x0084:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
            goto L_0x00ae
        L_0x0089:
            r1 = move-exception
            r5 = r1
            r1 = r7
            r7 = r5
            goto L_0x0099
        L_0x008e:
            r7 = move-exception
            goto L_0x00ae
        L_0x0090:
            r7 = move-exception
            r1 = r0
            goto L_0x0099
        L_0x0093:
            r7 = move-exception
            r6 = r0
            goto L_0x00ae
        L_0x0096:
            r7 = move-exception
            r6 = r0
            r1 = r6
        L_0x0099:
            r7.printStackTrace()     // Catch:{ all -> 0x00ac }
            if (r1 == 0) goto L_0x00a6
            r1.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00a6
        L_0x00a2:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00a6:
            if (r6 == 0) goto L_0x00ab
            r6.disconnect()
        L_0x00ab:
            return r0
        L_0x00ac:
            r7 = move-exception
            r0 = r1
        L_0x00ae:
            if (r0 == 0) goto L_0x00b8
            r0.close()     // Catch:{ IOException -> 0x00b4 }
            goto L_0x00b8
        L_0x00b4:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b8:
            if (r6 == 0) goto L_0x00bd
            r6.disconnect()
        L_0x00bd:
            throw r7
        L_0x00be:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.transport.HttpSender.httpGet(java.lang.String, java.util.Map):java.lang.String");
    }

    private static String getParams(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        synchronized (map) {
            boolean z = true;
            for (String next : map.keySet()) {
                try {
                    String encode = URLEncoder.encode(map.get(next).toString(), "UTF-8");
                    if (z) {
                        sb.append(next);
                        sb.append("=");
                        sb.append(encode);
                        z = false;
                    } else {
                        sb.append(ParamKeys.SIGN_AND);
                        sb.append(next);
                        sb.append("=");
                        sb.append(encode);
                    }
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
        return sb.toString();
    }
}
