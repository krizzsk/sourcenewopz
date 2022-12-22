package com.adyen.threeds2.internal;

import atd.p020f0.C1024b;
import atd.p020f0.C1030h;
import atd.p052y.C1225c;
import java.security.GeneralSecurityException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.adyen.threeds2.internal.c */
final class C1396c {
    /* renamed from: a */
    static C1030h m1098a(C1024b bVar, JSONObject jSONObject) {
        try {
            return bVar.mo13749a().mo13747a(jSONObject.toString().getBytes(C1395b.f995a));
        } catch (GeneralSecurityException | JSONException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }
}
