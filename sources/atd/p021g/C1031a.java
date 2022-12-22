package atd.p021g;

import atd.p022g0.C1033b;
import atd.p046s0.C1172a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.g.a */
public final class C1031a {

    /* renamed from: a */
    private final C1033b f285a;

    /* renamed from: b */
    private final String f286b;

    public C1031a(JSONObject jSONObject) throws JSONException {
        this.f285a = C1033b.m371a(jSONObject.getJSONObject(C1172a.m764a(-19009978583726L)));
        C1033b.m371a(jSONObject.getJSONObject(C1172a.m764a(-19074403093166L)));
        this.f286b = jSONObject.getString(C1172a.m764a(-19138827602606L));
    }

    /* renamed from: a */
    public C1033b mo13757a() {
        return this.f285a;
    }

    /* renamed from: b */
    public String mo13758b() {
        return this.f286b;
    }
}
