package atd.p015d;

import atd.p010a0.C0956a;
import atd.p017e.C1012a;
import atd.p017e.C1013b;
import atd.p017e.C1014c;
import atd.p017e.C1016e;
import atd.p046s0.C1172a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.c */
public final class C0980c extends C0989j {

    /* renamed from: g */
    private final int f212g;

    /* renamed from: h */
    private final C1012a f213h;

    /* renamed from: i */
    private final C1016e f214i;

    /* renamed from: j */
    private final C0976a f215j;

    C0980c(JSONObject jSONObject) throws C0956a {
        super(jSONObject);
        C1016e eVar;
        try {
            this.f212g = mo13675a(jSONObject, C1172a.m764a(-6889580874414L));
            C1012a a = C1012a.m320a(mo13676b(jSONObject, C1172a.m764a(-6954005383854L)));
            this.f213h = a;
            if (a.mo13734a()) {
                eVar = C1016e.m335a(mo13678d(jSONObject, C1172a.m764a(-7052789631662L)));
            } else {
                eVar = C1016e.m335a(mo13676b(jSONObject, C1172a.m764a(-7104329239214L)));
            }
            this.f214i = eVar;
            if (this.f213h.mo13734a()) {
                C1013b.m324a(mo13676b(jSONObject, C1172a.m764a(-7155868846766L)));
            } else {
                C1013b.m324a(mo13678d(jSONObject, C1172a.m764a(-7198818519726L)));
            }
            this.f215j = this.f213h.mo13734a() ? C0976a.m214a(jSONObject) : null;
        } catch (JSONException e) {
            throw new C0956a(C1172a.m764a(-7241768192686L), e, C1014c.DATA_ELEMENT_MISSING);
        }
    }

    /* renamed from: f */
    public boolean mo13636f() {
        return true;
    }

    /* renamed from: g */
    public int mo13637g() {
        return this.f212g;
    }

    /* renamed from: h */
    public C0976a mo13639h() {
        return this.f215j;
    }

    /* renamed from: i */
    public String mo13640i() {
        return this.f214i.mo13745a();
    }

    /* renamed from: j */
    public boolean mo13641j() {
        return this.f213h.mo13735b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public String mo13638g(JSONObject jSONObject, String str) throws C0956a, JSONException {
        return mo13677c(jSONObject, str);
    }
}
