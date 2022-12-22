package com.microblink.blinkbarcode.secured;

import com.google.common.net.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.JSONObject;

/* compiled from: line */
public class IIIlIIIIlI {
    private OutputStream IlIllIlIIl = null;
    private final URL IllIIIllII;
    private boolean llIIIlllll = false;
    private HttpsURLConnection llIIlIlIIl = null;

    /* compiled from: line */
    public static class llIIlIlIIl extends Exception {
        public llIIlIlIIl(Exception exc) {
            super(exc);
        }

        public Throwable getCause() {
            return (IOException) super.getCause();
        }
    }

    public IIIlIIIIlI(URL url, String str) {
        this.IllIIIllII = url;
    }

    public int IlIllIlIIl() throws llIIlIlIIl {
        if (!this.llIIIlllll) {
            this.llIIIlllll = true;
            try {
                this.IlIllIlIIl.close();
            } catch (Exception e) {
                throw new llIIlIlIIl(e);
            }
        }
        try {
            return llIIlIlIIl().getResponseCode();
        } catch (Exception e2) {
            throw new llIIlIlIIl(e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c A[SYNTHETIC, Splitter:B:22:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String IllIIIllII() throws com.microblink.blinkbarcode.secured.IIIlIIIIlI.llIIlIlIIl {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0042 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0042 }
            javax.net.ssl.HttpsURLConnection r4 = r6.llIIlIlIIl()     // Catch:{ IOException -> 0x0042 }
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ IOException -> 0x0042 }
            java.lang.String r5 = "UTF-8"
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x0042 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0042 }
        L_0x001a:
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x003d, all -> 0x003b }
            if (r1 == 0) goto L_0x0028
            java.lang.String r1 = r1.trim()     // Catch:{ IOException -> 0x003d, all -> 0x003b }
            r0.append(r1)     // Catch:{ IOException -> 0x003d, all -> 0x003b }
            goto L_0x001a
        L_0x0028:
            r2.close()     // Catch:{ IOException -> 0x0036 }
            javax.net.ssl.HttpsURLConnection r1 = r6.llIIlIlIIl()     // Catch:{ IOException -> 0x0036 }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x0036 }
            r1.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0036:
            java.lang.String r0 = r0.toString()
            return r0
        L_0x003b:
            r0 = move-exception
            goto L_0x004a
        L_0x003d:
            r0 = move-exception
            r1 = r2
            goto L_0x0043
        L_0x0040:
            r0 = move-exception
            goto L_0x0049
        L_0x0042:
            r0 = move-exception
        L_0x0043:
            com.microblink.blinkbarcode.secured.IIIlIIIIlI$llIIlIlIIl r2 = new com.microblink.blinkbarcode.secured.IIIlIIIIlI$llIIlIlIIl     // Catch:{ all -> 0x0040 }
            r2.<init>(r0)     // Catch:{ all -> 0x0040 }
            throw r2     // Catch:{ all -> 0x0040 }
        L_0x0049:
            r2 = r1
        L_0x004a:
            if (r2 == 0) goto L_0x004f
            r2.close()     // Catch:{ IOException -> 0x005a }
        L_0x004f:
            javax.net.ssl.HttpsURLConnection r1 = r6.llIIlIlIIl()     // Catch:{ IOException -> 0x005a }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x005a }
            r1.close()     // Catch:{ IOException -> 0x005a }
        L_0x005a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.secured.IIIlIIIIlI.IllIIIllII():java.lang.String");
    }

    public void llIIlIlIIl(JSONObject jSONObject) throws llIIlIlIIl {
        HttpsURLConnection llIIlIlIIl2 = llIIlIlIIl();
        llIIlIlIIl2.setRequestProperty("Content-Type", "application/json" + "; charset=UTF-8");
        llIIlIlIIl().setRequestProperty(HttpHeaders.ACCEPT, "application/json");
        if (this.IlIllIlIIl == null) {
            try {
                llIIlIlIIl();
                this.llIIlIlIIl.setDoOutput(true);
                this.IlIllIlIIl = new BufferedOutputStream(llIIlIlIIl().getOutputStream(), 8192);
            } catch (Exception e) {
                throw new llIIlIlIIl(e);
            }
        }
        if (this.IlIllIlIIl != null) {
            try {
                byte[] bytes = jSONObject.toString().getBytes("UTF-8");
                this.IlIllIlIIl.write(bytes, 0, bytes.length);
            } catch (Exception e2) {
                throw new llIIlIlIIl(e2);
            }
        } else {
            throw new llIIlIlIIl(new NullPointerException("outputStream == null"));
        }
    }

    private HttpsURLConnection llIIlIlIIl() throws llIIlIlIIl {
        if (this.llIIlIlIIl == null) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) this.IllIIIllII.openConnection();
                this.llIIlIlIIl = httpsURLConnection;
                httpsURLConnection.setRequestMethod("POST");
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                this.llIIlIlIIl.setSSLSocketFactory(instance.getSocketFactory());
            } catch (Exception e) {
                throw new llIIlIlIIl(e);
            }
        }
        return this.llIIlIlIIl;
    }

    public void llIIlIlIIl(int i) throws llIIlIlIIl {
        llIIlIlIIl().setConnectTimeout(i);
    }
}
