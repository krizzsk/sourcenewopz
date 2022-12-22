package com.didi.map.certificateencryption;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.net.Transporter;
import didinet.RootCAPinningManager;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class RootCATransporter implements Transporter {
    public HostnameVerifier getHostnameVerifier() {
        return null;
    }

    public SocketFactory getSocketFactory() {
        return SocketFactory.getDefault();
    }

    public SSLSocketFactory getSslSocketFactory() {
        if (!Apollo.getToggle("disable_certificate_encryption_toggle").allow()) {
            return RootCAPinningManager.getInstance().getSslSocketFactory();
        }
        return RootCAPinningManager.getInstance().getSystemDefaultSslSocketFactory();
    }

    public TrustManager getTrustManager() {
        if (!Apollo.getToggle("disable_certificate_encryption_toggle").allow()) {
            return RootCAPinningManager.getInstance().getX509TrustManager();
        }
        return RootCAPinningManager.getInstance().getSystemDefaultTrustManager();
    }
}
