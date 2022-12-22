package com.didi.hawaii.utils;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import didinet.RootCAPinningManager;

public class CertificateEncryptionUtils {
    static final String APPLO_NAME_CERTIFICATE_ENCRYPTION = "disable_certificate_encryption_toggle";

    public static HttpRpcClient.Builder addSslSocketFactoryForBuilder(HttpRpcClient.Builder builder) {
        RootCAPinningManager instance = RootCAPinningManager.getInstance();
        if (Apollo.getToggle(APPLO_NAME_CERTIFICATE_ENCRYPTION).allow()) {
            builder.setSSLSocketFactory(instance.getSystemDefaultSslSocketFactory(), instance.getSystemDefaultTrustManager());
        } else {
            builder.setSSLSocketFactory(instance.getSslSocketFactory(), instance.getX509TrustManager());
        }
        return builder;
    }
}
