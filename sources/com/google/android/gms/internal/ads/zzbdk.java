package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbdk extends SSLSocketFactory {
    private SSLSocketFactory zzeqf = ((SSLSocketFactory) SSLSocketFactory.getDefault());
    private final /* synthetic */ zzbdh zzeqg;

    zzbdk(zzbdh zzbdh) {
        this.zzeqg = zzbdh;
    }

    public final String[] getDefaultCipherSuites() {
        return this.zzeqf.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zzeqf.getSupportedCipherSuites();
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return zzb(this.zzeqf.createSocket(socket, str, i, z));
    }

    public final Socket createSocket(String str, int i) throws IOException {
        return zzb(this.zzeqf.createSocket(str, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return zzb(this.zzeqf.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return zzb(this.zzeqf.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return zzb(this.zzeqf.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private final Socket zzb(Socket socket) throws SocketException {
        if (this.zzeqg.zzeps > 0) {
            socket.setReceiveBufferSize(this.zzeqg.zzeps);
        }
        this.zzeqg.zza(socket);
        return socket;
    }
}
