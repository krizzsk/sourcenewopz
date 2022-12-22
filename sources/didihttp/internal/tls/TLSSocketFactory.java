package didihttp.internal.tls;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSSocketFactory extends SSLSocketFactory {

    /* renamed from: a */
    private SSLSocketFactory f56895a;

    public TLSSocketFactory(SSLContext sSLContext) {
        this.f56895a = sSLContext.getSocketFactory();
    }

    public void setProxySocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f56895a = sSLSocketFactory;
    }

    public String[] getDefaultCipherSuites() {
        return this.f56895a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f56895a.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return m40843a(this.f56895a.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return m40843a(this.f56895a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return m40843a(this.f56895a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return m40843a(this.f56895a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return m40843a(this.f56895a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    /* renamed from: a */
    private Socket m40843a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            try {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
            } catch (Exception unused) {
            }
        }
        return socket;
    }
}
