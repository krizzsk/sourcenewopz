package atd.p015d;

import atd.p017e.C1014c;
import atd.p017e.C1015d;
import atd.p046s0.C1172a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.d */
public class C0981d extends C0988i {

    /* renamed from: h */
    private final C1014c f216h;

    /* renamed from: i */
    private final String f217i;

    public C0981d(String str, String str2, String str3, String str4, String str5, C1014c cVar, String str6) {
        super(C1015d.ERROR, str, str2, str3, str4, str5);
        this.f216h = cVar;
        this.f217i = str6;
    }

    /* renamed from: a */
    public JSONObject mo13606a() throws JSONException {
        JSONObject a = super.mo13606a();
        a.put(C1172a.m764a(-7426451786414L), this.f216h.mo13740a());
        a.put(C1172a.m764a(-7469401459374L), this.f216h.mo13741b());
        a.put(C1172a.m764a(-7533825968814L), this.f216h.mo13742c());
        a.put(C1172a.m764a(-7606840412846L), this.f216h.mo13743d());
        a.put(C1172a.m764a(-7679854856878L), this.f217i);
        return a;
    }

    /* renamed from: i */
    public boolean mo13634i() {
        return false;
    }
}
