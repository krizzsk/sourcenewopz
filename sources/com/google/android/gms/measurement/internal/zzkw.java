package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzkw extends SSLSocketFactory {
    private final SSLSocketFactory zza;

    zzkw() {
        this.zza = HttpsURLConnection.getDefaultSSLSocketFactory();
    }

    public final Socket createSocket() throws IOException {
        return new zzkv(this, (SSLSocket) this.zza.createSocket());
    }

    public final String[] getDefaultCipherSuites() {
        return this.zza.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zza.getSupportedCipherSuites();
    }

    zzkw(SSLSocketFactory sSLSocketFactory) {
        this.zza = sSLSocketFactory;
    }

    public final Socket createSocket(String str, int i) throws IOException {
        return new zzkv(this, (SSLSocket) this.zza.createSocket(str, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return new zzkv(this, (SSLSocket) this.zza.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return new zzkv(this, (SSLSocket) this.zza.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return new zzkv(this, (SSLSocket) this.zza.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return new zzkv(this, (SSLSocket) this.zza.createSocket(socket, str, i, z));
    }
}
