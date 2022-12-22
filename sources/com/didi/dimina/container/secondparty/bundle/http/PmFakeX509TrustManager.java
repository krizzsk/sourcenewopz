package com.didi.dimina.container.secondparty.bundle.http;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class PmFakeX509TrustManager implements X509TrustManager {

    /* renamed from: a */
    private static TrustManager[] f17090a;

    /* renamed from: b */
    private static final X509Certificate[] f17091b = new X509Certificate[0];

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f17091b;
    }

    public static SSLSocketFactory allowAllSSL() {
        if (f17090a == null) {
            f17090a = new TrustManager[]{new PmFakeX509TrustManager()};
        }
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, f17090a, new SecureRandom());
            return instance.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (KeyManagementException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
