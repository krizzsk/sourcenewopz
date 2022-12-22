package com.didi.dynamic.manager.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSSocketFactory extends SSLSocketFactory {

    /* renamed from: a */
    private SSLSocketFactory f19408a;

    public TLSSocketFactory(SSLContext sSLContext) {
        this.f19408a = sSLContext.getSocketFactory();
    }

    public void setProxySocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f19408a = sSLSocketFactory;
    }

    public String[] getDefaultCipherSuites() {
        return this.f19408a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f19408a.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return m14518a(this.f19408a.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return m14518a(this.f19408a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return m14518a(this.f19408a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return m14518a(this.f19408a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return m14518a(this.f19408a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    /* renamed from: a */
    private Socket m14518a(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            try {
                String[] supportedProtocols = sSLSocket.getSupportedProtocols();
                if (supportedProtocols != null) {
                    if (supportedProtocols.length != 0) {
                        ArrayList arrayList = new ArrayList(supportedProtocols.length);
                        for (String str : supportedProtocols) {
                            if (str.startsWith("TLSv1.")) {
                                arrayList.add(str);
                            }
                        }
                        if (arrayList.size() > 0) {
                            sSLSocket.setEnabledProtocols((String[]) arrayList.toArray(new String[arrayList.size()]));
                        } else {
                            sSLSocket.setEnabledProtocols(supportedProtocols);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return socket;
    }
}
