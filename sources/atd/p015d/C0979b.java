package atd.p015d;

import atd.p013c.C0963c;
import atd.p017e.C1015d;
import atd.p019f.C1021a;
import atd.p046s0.C1172a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.b */
public final class C0979b extends C0988i {

    /* renamed from: h */
    private final C0963c f210h;

    /* renamed from: i */
    private final String f211i;

    public C0979b(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, (C0963c) null, (String) null);
    }

    /* renamed from: a */
    public JSONObject mo13606a() throws JSONException {
        JSONObject a = super.mo13606a();
        C0963c cVar = this.f210h;
        if (cVar != null) {
            a = C1021a.m347a(a, cVar.mo13606a());
        }
        a.putOpt(C1172a.m764a(-6795091593902L), this.f211i);
        return a;
    }

    /* renamed from: i */
    public boolean mo13634i() {
        return true;
    }

    /* renamed from: j */
    public C0963c mo13635j() {
        return this.f210h;
    }

    public C0979b(String str, String str2, String str3, String str4, String str5, C0963c cVar, String str6) {
        super(C1015d.CHALLENGE_REQUEST, str, str2, str3, str4, str5);
        this.f210h = cVar;
        this.f211i = str6;
    }
}
