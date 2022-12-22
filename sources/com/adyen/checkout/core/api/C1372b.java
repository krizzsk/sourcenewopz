package com.adyen.checkout.core.api;

import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import java.net.HttpURLConnection;

/* renamed from: com.adyen.checkout.core.api.b */
/* compiled from: HttpUrlConnectionFactory */
final class C1372b extends C1371a {

    /* renamed from: a */
    private static final String f929a = LogUtil.getTag();

    /* renamed from: b */
    private static final String f930b = "Trying to connect to a URL that is not HTTPS.";

    /* renamed from: c */
    private static C1372b f931c;

    /* renamed from: a */
    static C1372b m1069a() {
        C1372b bVar;
        synchronized (C1372b.class) {
            if (f931c == null) {
                f931c = new C1372b();
            }
            bVar = f931c;
        }
        return bVar;
    }

    private C1372b() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpURLConnection mo14725a(HttpURLConnection httpURLConnection) {
        Logger.m1084w(f929a, f930b);
        return httpURLConnection;
    }
}
