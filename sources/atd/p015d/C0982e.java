package atd.p015d;

import atd.p010a0.C0956a;
import atd.p017e.C1014c;
import atd.p046s0.C1172a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.e */
public class C0982e extends C0989j {

    /* renamed from: g */
    private final String f218g;

    /* renamed from: h */
    private final String f219h;

    /* renamed from: i */
    private final String f220i;

    C0982e(JSONObject jSONObject) throws C0956a {
        super(jSONObject);
        try {
            this.f218g = mo13676b(jSONObject, C1172a.m764a(-7731394464430L));
            mo13676b(jSONObject, C1172a.m764a(-7774344137390L));
            this.f219h = mo13676b(jSONObject, C1172a.m764a(-7838768646830L));
            this.f220i = mo13676b(jSONObject, C1172a.m764a(-7911783090862L));
            mo13676b(jSONObject, C1172a.m764a(-7963322698414L));
        } catch (JSONException e) {
            throw new C0956a(C1172a.m764a(-8036337142446L), e, C1014c.DATA_ELEMENT_MISSING);
        }
    }

    /* renamed from: f */
    public boolean mo13636f() {
        return false;
    }

    /* renamed from: g */
    public String mo13642g() {
        return this.f218g;
    }

    /* renamed from: h */
    public String mo13643h() {
        return this.f219h;
    }

    /* renamed from: i */
    public String mo13644i() {
        return this.f220i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public String mo13638g(JSONObject jSONObject, String str) throws C0956a {
        return mo13680f(jSONObject, str);
    }
}
