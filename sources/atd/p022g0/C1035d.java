package atd.p022g0;

import atd.p014c0.C0973c;
import atd.p016d0.C1010g;
import atd.p020f0.C1023a;
import atd.p020f0.C1028f;
import atd.p026i0.C1055b;
import atd.p026i0.C1062g;
import atd.p044r0.C1154a;
import atd.p046s0.C1172a;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.g0.d */
public final class C1035d extends C1034c {

    /* renamed from: b */
    private final RSAPublicKey f291b;

    /* renamed from: c */
    private final RSAPrivateKey f292c;

    static {
        C1172a.m764a(-700071532645038L);
    }

    C1035d(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        C1154a a = C1154a.m709a();
        BigInteger a2 = C1055b.m440a(a.mo13918a(jSONObject.getString(C1172a.m764a(-699968453429934L))));
        BigInteger a3 = C1055b.m440a(a.mo13918a(jSONObject.getString(C1172a.m764a(-699977043364526L))));
        RSAPrivateKey rSAPrivateKey = null;
        BigInteger a4 = jSONObject.has(C1172a.m764a(-699985633299118L)) ? C1055b.m440a(a.mo13918a(jSONObject.getString(C1172a.m764a(-699994223233710L)))) : null;
        this.f291b = C1062g.m459b(a2, a3);
        this.f292c = a4 != null ? C1062g.m458a(a2, a4) : rSAPrivateKey;
    }

    /* renamed from: a */
    public C1023a mo13749a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String b = mo13764b();
        if (b != null && !b.isEmpty()) {
            jSONObject.put(C1172a.m764a(-700054352775854L), b);
        }
        C1028f fVar = new C1028f(C1010g.f267c, C0973c.f202a, jSONObject);
        return new C1023a(fVar, fVar.mo13751f().mo13730a(fVar, this), this);
    }

    /* renamed from: e */
    public RSAPrivateKey mo13760d() {
        return this.f292c;
    }

    /* renamed from: f */
    public RSAPublicKey mo13767f() {
        return this.f291b;
    }
}
