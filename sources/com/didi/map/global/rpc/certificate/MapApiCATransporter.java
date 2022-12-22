package com.didi.map.global.rpc.certificate;

import com.didichuxing.foundation.net.Transporter;
import didinet.RootCAPinningManager;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class MapApiCATransporter implements Transporter {
    /* renamed from: a */
    private boolean m19313a() {
        return false;
    }

    public HostnameVerifier getHostnameVerifier() {
        return null;
    }

    public SocketFactory getSocketFactory() {
        return SocketFactory.getDefault();
    }

    public SSLSocketFactory getSslSocketFactory() {
        if (!m19313a()) {
            return RootCAPinningManager.getInstance().getSslSocketFactory();
        }
        return RootCAPinningManager.getInstance().getSystemDefaultSslSocketFactory();
    }

    public TrustManager getTrustManager() {
        if (!m19313a()) {
            return RootCAPinningManager.getInstance().getX509TrustManager();
        }
        return RootCAPinningManager.getInstance().getSystemDefaultTrustManager();
    }
}
