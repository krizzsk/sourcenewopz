package atd.p015d;

import atd.p017e.C1015d;
import atd.p019f.C1022b;
import atd.p046s0.C1172a;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d.i */
public abstract class C0988i implements C1022b {

    /* renamed from: a */
    private final C1015d f231a;

    /* renamed from: b */
    private final String f232b;

    /* renamed from: c */
    private final String f233c;

    /* renamed from: d */
    private final String f234d;

    /* renamed from: e */
    private final String f235e;

    /* renamed from: f */
    private int f236f;

    /* renamed from: g */
    private String f237g;

    public C0988i(C1015d dVar, String str, String str2, String str3, String str4, String str5) {
        this.f231a = dVar;
        this.f232b = str;
        this.f233c = str2;
        this.f234d = str3;
        this.f235e = str4;
        this.f237g = str5;
    }

    /* renamed from: a */
    public JSONObject mo13606a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(C1172a.m764a(-9496626023086L), this.f231a.mo13744a());
        jSONObject.put(C1172a.m764a(-9548165630638L), this.f232b);
        jSONObject.put(C1172a.m764a(-9612590140078L), this.f233c);
        jSONObject.put(C1172a.m764a(-9702784453294L), this.f234d);
        jSONObject.put(C1172a.m764a(-9750029093550L), this.f235e);
        jSONObject.put(C1172a.m764a(-9797273733806L), String.format(Locale.ROOT, C1172a.m764a(-9861698243246L), new Object[]{Integer.valueOf(this.f236f)}));
        jSONObject.putOpt(C1172a.m764a(-9883173079726L), this.f237g);
        return jSONObject;
    }

    /* renamed from: b */
    public String mo13663b() {
        return this.f234d;
    }

    /* renamed from: c */
    public C1015d mo13664c() {
        return this.f231a;
    }

    /* renamed from: d */
    public String mo13665d() {
        return this.f232b;
    }

    /* renamed from: e */
    public int mo13666e() {
        return this.f236f;
    }

    /* renamed from: f */
    public String mo13667f() {
        return this.f235e;
    }

    /* renamed from: g */
    public String mo13668g() {
        return this.f237g;
    }

    /* renamed from: h */
    public String mo13669h() {
        return this.f233c;
    }

    /* renamed from: i */
    public abstract boolean mo13634i();

    /* renamed from: a */
    public void mo13662a(int i) {
        this.f236f = i;
    }
}
