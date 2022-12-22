package atd.p009a;

import atd.p046s0.C1172a;
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

/* renamed from: atd.a.k */
final class C0955k extends SSLSocketFactory {

    /* renamed from: a */
    private final SSLSocketFactory f187a;

    /* renamed from: b */
    private final String[] f188b = {C1172a.m764a(-3960413178542L)};

    C0955k() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance(C1172a.m764a(-3943233309358L));
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        this.f187a = instance.getSocketFactory();
    }

    /* renamed from: a */
    private Socket m154a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(this.f188b);
        }
        return socket;
    }

    public Socket createSocket() throws IOException {
        return m154a(this.f187a.createSocket());
    }

    public String[] getDefaultCipherSuites() {
        return this.f187a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f187a.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return m154a(this.f187a.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) throws IOException {
        return m154a(this.f187a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return m154a(this.f187a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return m154a(this.f187a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return m154a(this.f187a.createSocket(inetAddress, i, inetAddress2, i2));
    }
}
