package atd.p022g0;

import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.g0.b */
public class C1033b {

    /* renamed from: a */
    private final String f290a;

    C1033b(JSONObject jSONObject) throws JSONException {
        this.f290a = jSONObject.optString(C1172a.m764a(-699916913822382L));
        jSONObject.getString(C1172a.m764a(-699934093691566L));
    }

    /* renamed from: a */
    public static C1033b m371a(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString(C1172a.m764a(-699852489312942L));
        if (C1172a.m764a(-699869669182126L).equals(string)) {
            return new C1035d(jSONObject);
        }
        if (C1172a.m764a(-699886849051310L).equals(string)) {
            return new C1032a(jSONObject);
        }
        if (C1172a.m764a(-699899733953198L).equals(string)) {
            return new C1036e(jSONObject);
        }
        throw C1225c.CRYPTO_FAILURE.mo13982a();
    }

    /* renamed from: b */
    public String mo13764b() {
        return this.f290a;
    }

    C1033b(String str, String str2) {
        this.f290a = str;
    }

    /* renamed from: a */
    public static void m372a(C1033b bVar, Class<? extends C1033b> cls) {
        if (!cls.isInstance(bVar)) {
            throw C1225c.CRYPTO_FAILURE.mo13982a();
        }
    }
}
