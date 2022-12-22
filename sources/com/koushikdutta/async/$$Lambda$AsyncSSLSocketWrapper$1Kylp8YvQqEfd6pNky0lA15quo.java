package com.koushikdutta.async;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* renamed from: com.koushikdutta.async.-$$Lambda$AsyncSSLSocketWrapper$1Kylp8YvQqEfd6p-Nky0lA15quo  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$AsyncSSLSocketWrapper$1Kylp8YvQqEfd6pNky0lA15quo implements HostnameVerifier {
    public static final /* synthetic */ $$Lambda$AsyncSSLSocketWrapper$1Kylp8YvQqEfd6pNky0lA15quo INSTANCE = new $$Lambda$AsyncSSLSocketWrapper$1Kylp8YvQqEfd6pNky0lA15quo();

    private /* synthetic */ $$Lambda$AsyncSSLSocketWrapper$1Kylp8YvQqEfd6pNky0lA15quo() {
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return AsyncSSLSocketWrapper.m39697a(str, sSLSession);
    }
}
