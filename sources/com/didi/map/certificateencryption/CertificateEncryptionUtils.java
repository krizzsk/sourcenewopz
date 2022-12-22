package com.didi.map.certificateencryption;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import didinet.RootCAPinningManager;

public class CertificateEncryptionUtils {

    /* renamed from: a */
    static final String f24595a = "disable_certificate_encryption_toggle";

    public static HttpRpcClient.Builder addSslSocketFactoryForBuilder(HttpRpcClient.Builder builder) {
        RootCAPinningManager instance = RootCAPinningManager.getInstance();
        if (!Apollo.getToggle(f24595a).allow()) {
            builder.setSSLSocketFactory(instance.getSslSocketFactory(), instance.getX509TrustManager());
        } else {
            builder.setSSLSocketFactory(instance.getSystemDefaultSslSocketFactory(), instance.getSystemDefaultTrustManager());
        }
        return builder;
    }
}
