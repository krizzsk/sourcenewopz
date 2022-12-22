package com.didichuxing.omega.sdk.cdnmonitor.detector;

import com.didichuxing.omega.sdk.cdnmonitor.ping.PingExecutor;
import com.didichuxing.omega.sdk.common.utils.OLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class CdnDetector {
    private static SSLSocketFactory ssf;
    private String expectedMd5;
    private String targetUrl;

    public CdnDetector(String str, String str2) {
        this.targetUrl = str;
        this.expectedMd5 = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (r1 == null) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003a, code lost:
        if (r1 != null) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didichuxing.omega.sdk.cdnmonitor.detector.CdnDetectionResult detect() {
        /*
            r7 = this;
            com.didichuxing.omega.sdk.cdnmonitor.detector.CdnDetectionResult r0 = new com.didichuxing.omega.sdk.cdnmonitor.detector.CdnDetectionResult
            java.lang.String r1 = r7.targetUrl
            r0.<init>(r1)
            r0.fetchEnvironmentParameters()
            r1 = 0
            java.lang.String r2 = r7.targetUrl     // Catch:{ all -> 0x003d }
            java.net.HttpURLConnection r1 = r7.setupConnection(r2)     // Catch:{ all -> 0x003d }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003d }
            int r4 = r1.getResponseCode()     // Catch:{ all -> 0x003d }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003d }
            long r5 = r5 - r2
            int r2 = (int) r5     // Catch:{ all -> 0x003d }
            int r3 = r1.getContentLength()     // Catch:{ all -> 0x003d }
            int r4 = r4 + 2000
            if (r2 <= 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r2 = 0
        L_0x0029:
            java.util.Map r5 = r1.getHeaderFields()     // Catch:{ all -> 0x003d }
            r0.addDetectionResult(r4, r2, r5, r3)     // Catch:{ all -> 0x003d }
            byte[] r2 = r7.readResponseBody(r1)     // Catch:{ all -> 0x003d }
            r7.validateResourceMd5(r0, r2)     // Catch:{ all -> 0x003d }
            r7.attachPingInfo(r0)
            if (r1 == 0) goto L_0x004d
            goto L_0x004a
        L_0x003d:
            r2 = move-exception
            int r2 = com.didichuxing.omega.sdk.cdnmonitor.detector.HttpDetectErrCode.praseException(r2)     // Catch:{ all -> 0x004e }
            r0.setDetectErrCode(r2)     // Catch:{ all -> 0x004e }
            r7.attachPingInfo(r0)
            if (r1 == 0) goto L_0x004d
        L_0x004a:
            r1.disconnect()
        L_0x004d:
            return r0
        L_0x004e:
            r2 = move-exception
            r7.attachPingInfo(r0)
            if (r1 == 0) goto L_0x0057
            r1.disconnect()
        L_0x0057:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.cdnmonitor.detector.CdnDetector.detect():com.didichuxing.omega.sdk.cdnmonitor.detector.CdnDetectionResult");
    }

    /* access modifiers changed from: package-private */
    public void validateResourceMd5(CdnDetectionResult cdnDetectionResult, byte[] bArr) {
        String mD5Checksum = getMD5Checksum(bArr);
        cdnDetectionResult.setDownFileMd5(mD5Checksum);
        if (mD5Checksum != null && !mD5Checksum.equals(this.expectedMd5)) {
            cdnDetectionResult.setDetectErrCode(1008);
        }
    }

    private HttpURLConnection setupConnection(String str) throws Throwable {
        HttpURLConnection httpURLConnection;
        Exception e;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                if (httpURLConnection instanceof HttpsURLConnection) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                    if (ssf != null) {
                        httpsURLConnection.setSSLSocketFactory(ssf);
                    }
                }
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
            } catch (Exception e2) {
                e = e2;
                OLog.m34769w("setupConnection fail " + e.getCause());
                return httpURLConnection;
            }
        } catch (Exception e3) {
            Exception exc = e3;
            httpURLConnection = null;
            e = exc;
            OLog.m34769w("setupConnection fail " + e.getCause());
            return httpURLConnection;
        }
        return httpURLConnection;
    }

    private void attachPingInfo(CdnDetectionResult cdnDetectionResult) {
        cdnDetectionResult.setPingInfo(new PingExecutor(parseHostOfUrl(this.targetUrl)).execute());
    }

    /* access modifiers changed from: package-private */
    public String parseHostOfUrl(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception unused) {
            OLog.m34763e("getUrlHost Error");
            return "";
        }
    }

    private byte[] readResponseBody(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* access modifiers changed from: package-private */
    public String getMD5Checksum(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            String str = "";
            for (byte b : instance.digest()) {
                str = str + Integer.toString((b & 255) + 256, 16).substring(1);
            }
            return str;
        } catch (Exception | NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
