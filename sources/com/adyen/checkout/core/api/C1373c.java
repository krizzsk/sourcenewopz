package com.adyen.checkout.core.api;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: com.adyen.checkout.core.api.c */
/* compiled from: TLSSocketFactory */
class C1373c extends SSLSocketFactory {

    /* renamed from: a */
    private final SSLSocketFactory f932a;

    /* renamed from: b */
    private final String[] f933b = {"TLSv1.2"};

    C1373c() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        this.f932a = instance.getSocketFactory();
    }

    public String[] getDefaultCipherSuites() {
        return this.f932a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f932a.getSupportedCipherSuites();
    }

    public Socket createSocket() throws IOException {
        return m1071a(this.f932a.createSocket());
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return m1071a(this.f932a.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) throws IOException {
        return m1071a(this.f932a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return m1071a(this.f932a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return m1071a(this.f932a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return m1071a(this.f932a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    /* renamed from: a */
    private Socket m1071a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(this.f933b);
        }
        return socket;
    }
}
