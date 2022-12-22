package com.didichuxing.foundation.net;

import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public interface Transporter {
    HostnameVerifier getHostnameVerifier();

    SocketFactory getSocketFactory();

    SSLSocketFactory getSslSocketFactory();

    TrustManager getTrustManager();
}
