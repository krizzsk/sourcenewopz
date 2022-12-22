package com.adyen.checkout.core.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.adyen.checkout.core.api.a */
/* compiled from: BaseHttpUrlConnectionFactory */
abstract class C1371a {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract HttpURLConnection mo14725a(HttpURLConnection httpURLConnection);

    C1371a() {
    }

    static {
        HttpsURLConnection.setDefaultSSLSocketFactory(SSLSocketUtil.TLS_SOCKET_FACTORY);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpURLConnection mo14724a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        if (!(httpURLConnection instanceof HttpsURLConnection)) {
            return mo14725a(httpURLConnection);
        }
        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(SSLSocketUtil.TLS_SOCKET_FACTORY);
        return httpURLConnection;
    }
}
