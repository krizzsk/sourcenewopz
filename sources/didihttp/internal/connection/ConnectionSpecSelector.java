package didihttp.internal.connection;

import didihttp.ConnectionSpec;
import didihttp.internal.Internal;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpecSelector {

    /* renamed from: a */
    private final List<ConnectionSpec> f56646a;

    /* renamed from: b */
    private int f56647b = 0;

    /* renamed from: c */
    private boolean f56648c;

    /* renamed from: d */
    private boolean f56649d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f56646a = list;
    }

    public ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        int i = this.f56647b;
        int size = this.f56646a.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f56646a.get(i);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.f56647b = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec != null) {
            this.f56648c = m40679a(sSLSocket);
            Internal.instance.apply(connectionSpec, sSLSocket, this.f56649d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f56649d + ", modes=" + this.f56646a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean connectionFailed(IOException iOException) {
        this.f56649d = true;
        if (!this.f56648c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (z || (iOException instanceof SSLProtocolException)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m40679a(SSLSocket sSLSocket) {
        for (int i = this.f56647b; i < this.f56646a.size(); i++) {
            if (this.f56646a.get(i).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
