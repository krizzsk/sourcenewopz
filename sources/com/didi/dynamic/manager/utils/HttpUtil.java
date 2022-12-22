package com.didi.dynamic.manager.utils;

import android.os.Build;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.koushikdutta.async.http.AsyncHttpDelete;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.text.Typography;

public class HttpUtil {

    /* renamed from: a */
    private static SSLSocketFactory f19357a;

    public interface OperationController {
        void continueDownloading(String str, File file, long j) throws CanceledException;
    }

    static {
        try {
            f19357a = m14479a(m14480a());
        } catch (Throwable unused) {
            f19357a = null;
        }
    }

    /* renamed from: a */
    private static X509TrustManager m14480a() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private static SSLSocketFactory m14479a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return m14478a(instance);
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private static SSLSocketFactory m14478a(SSLContext sSLContext) {
        if (Build.VERSION.SDK_INT <= 19) {
            return new TLSSocketFactory(sSLContext);
        }
        return sSLContext.getSocketFactory();
    }

    public static String get(String str) throws Exception {
        return get(str, (Map<String, String>) null);
    }

    public static String get(String str, Map<String, String> map) throws Exception {
        return fetch("GET", str, (String) null, map);
    }

    public static String post(String str, String str2, Map<String, String> map) throws Exception {
        return fetch("POST", str, str2, map);
    }

    public static String post(String str, String str2) throws Exception {
        return post(str, str2, (Map<String, String>) null);
    }

    public static String postForm(String str, Map<String, String> map) throws Exception {
        return postForm(str, map, (Map<String, String>) null);
    }

    public static String postForm(String str, Map<String, String> map, Map<String, String> map2) throws Exception {
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        map2.put("Content-Type", "application/x-www-form-urlencoded");
        String str2 = "";
        if (map != null) {
            boolean z = true;
            for (String next : map.keySet()) {
                if (z) {
                    z = false;
                } else {
                    str2 = str2 + ParamKeys.SIGN_AND;
                }
                str2 = (str2 + URLEncoder.encode(next, "UTF-8") + "=") + URLEncoder.encode(map.get(next), "UTF-8");
            }
        }
        return post(str, str2, map2);
    }

    public static String put(String str, String str2, Map<String, String> map) throws Exception {
        return fetch("PUT", str, str2, map);
    }

    public static String put(String str, String str2) throws Exception {
        return put(str, str2, (Map<String, String>) null);
    }

    public static String delete(String str, Map<String, String> map) throws Exception {
        return fetch(AsyncHttpDelete.METHOD, str, (String) null, map);
    }

    public static String delete(String str) throws Exception {
        return delete(str, (Map<String, String>) null);
    }

    public static String appendQueryParams(String str, Map<String, String> map) throws Exception {
        String str2;
        if (map != null) {
            boolean z = str.indexOf(63) == -1;
            for (String next : map.keySet()) {
                if (z) {
                    str2 = str + '?';
                    z = false;
                } else {
                    str2 = str + Typography.amp;
                }
                String str3 = map.get(next);
                if (str3 == null) {
                    str3 = "";
                }
                str = (str2 + URLEncoder.encode(next, "UTF-8") + '=') + URLEncoder.encode(str3, "UTF-8");
            }
        }
        return str;
    }

    public static Map<String, String> getQueryParams(String str) throws Exception {
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        int indexOf = str.indexOf(63);
        while (indexOf != -1) {
            int indexOf2 = str.indexOf(61, indexOf);
            if (indexOf2 != -1) {
                str2 = str.substring(indexOf + 1, indexOf2);
            } else {
                str2 = str.substring(indexOf + 1);
            }
            if (indexOf2 != -1) {
                indexOf = str.indexOf(38, indexOf2);
                str3 = indexOf != -1 ? str.substring(indexOf2 + 1, indexOf) : str.substring(indexOf2 + 1);
            } else {
                str3 = "";
            }
            hashMap.put(URLDecoder.decode(str2, "UTF-8"), URLDecoder.decode(str3, "UTF-8"));
        }
        return hashMap;
    }

    public static String removeQueryParams(String str) throws Exception {
        int indexOf = str.indexOf(63);
        return indexOf != -1 ? str.substring(0, indexOf) : str;
    }

    public static String fetch(String str, String str2, String str3, Map<String, String> map) throws Exception {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        if ((httpURLConnection instanceof HttpsURLConnection) && !httpURLConnection.getClass().getName().startsWith("didihttp.") && (sSLSocketFactory = f19357a) != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
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
    }

    public static String streamToString(InputStream inputStream) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return stringBuffer.toString();
            }
            stringBuffer.append(new String(bArr, 0, read));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void download(java.lang.String r8, java.io.File r9, com.didi.dynamic.manager.utils.HttpUtil.OperationController r10) throws java.lang.Exception {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x003f }
            r1.<init>(r8)     // Catch:{ all -> 0x003f }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ all -> 0x003f }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ all -> 0x003f }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x003d }
            r3 = 0
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x003d }
            r5.<init>(r9)     // Catch:{ all -> 0x003d }
            if (r10 == 0) goto L_0x001e
            r10.continueDownloading(r8, r9, r3)     // Catch:{ all -> 0x003a }
        L_0x001e:
            int r0 = r1.read(r2)     // Catch:{ all -> 0x003a }
            r6 = -1
            if (r0 == r6) goto L_0x0031
            long r6 = (long) r0     // Catch:{ all -> 0x003a }
            long r3 = r3 + r6
            r6 = 0
            r5.write(r2, r6, r0)     // Catch:{ all -> 0x003a }
            if (r10 == 0) goto L_0x001e
            r10.continueDownloading(r8, r9, r3)     // Catch:{ all -> 0x003a }
            goto L_0x001e
        L_0x0031:
            r5.close()
            if (r1 == 0) goto L_0x0039
            r1.close()
        L_0x0039:
            return
        L_0x003a:
            r8 = move-exception
            r0 = r5
            goto L_0x0041
        L_0x003d:
            r8 = move-exception
            goto L_0x0041
        L_0x003f:
            r8 = move-exception
            r1 = r0
        L_0x0041:
            if (r0 == 0) goto L_0x0046
            r0.close()
        L_0x0046:
            if (r1 == 0) goto L_0x004b
            r1.close()
        L_0x004b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dynamic.manager.utils.HttpUtil.download(java.lang.String, java.io.File, com.didi.dynamic.manager.utils.HttpUtil$OperationController):void");
    }

    public static class CanceledException extends RuntimeException {
        public CanceledException(String str) {
            super(str);
        }

        public CanceledException(Throwable th) {
            super(th);
        }

        public CanceledException(String str, Throwable th) {
            super(str, th);
        }
    }
}
