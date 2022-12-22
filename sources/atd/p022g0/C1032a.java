package atd.p022g0;

import atd.p014c0.C0973c;
import atd.p016d0.C1010g;
import atd.p020f0.C1023a;
import atd.p020f0.C1028f;
import atd.p026i0.C1055b;
import atd.p026i0.C1056c;
import atd.p026i0.C1057d;
import atd.p026i0.C1060e;
import atd.p044r0.C1154a;
import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.g0.a */
public final class C1032a extends C1034c {

    /* renamed from: b */
    private final C1057d f287b;

    /* renamed from: c */
    private final ECPublicKey f288c;

    /* renamed from: d */
    private final ECPrivateKey f289d;

    static {
        C1172a.m764a(-699839604411054L);
    }

    public C1032a(String str, C1057d dVar) {
        super(str, C1172a.m764a(-699676395653806L));
        this.f287b = dVar;
        KeyPair a = C1060e.m450a(dVar);
        this.f288c = (ECPublicKey) a.getPublic();
        this.f289d = (ECPrivateKey) a.getPrivate();
    }

    /* renamed from: a */
    public C1023a mo13749a() throws JSONException {
        C1032a aVar = new C1032a(mo13764b(), C1057d.P256);
        JSONObject jSONObject = new JSONObject();
        String b = aVar.mo13764b();
        if (b != null && !b.isEmpty()) {
            jSONObject.put(C1172a.m764a(-699805244672686L), b);
        }
        jSONObject.put(C1172a.m764a(-699822424541870L), aVar.mo13763g());
        C1028f fVar = new C1028f(C1010g.f266b, C0973c.f202a, jSONObject);
        byte[] a = aVar.mo13759a((String) null, (String) null, mo13764b(), mo13762f());
        return new C1023a(fVar, C1010g.f265a.mo13729a(C0973c.f202a, a), new C1036e(mo13764b(), a));
    }

    /* renamed from: e */
    public ECPrivateKey mo13760d() {
        return this.f289d;
    }

    /* renamed from: f */
    public ECPublicKey mo13762f() {
        return this.f288c;
    }

    /* renamed from: g */
    public JSONObject mo13763g() {
        ECPoint w = this.f288c.getW();
        C1154a a = C1154a.m709a();
        String d = a.mo13926d(C1055b.m441a(w.getAffineX()));
        String d2 = a.mo13926d(C1055b.m441a(w.getAffineY()));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C1172a.m764a(-699740820163246L), C1172a.m764a(-699758000032430L));
            jSONObject.put(C1172a.m764a(-699770884934318L), this.f287b.mo13786a());
            jSONObject.put(C1172a.m764a(-699788064803502L), d);
            jSONObject.put(C1172a.m764a(-699796654738094L), d2);
            return jSONObject;
        } catch (JSONException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }

    C1032a(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        C1154a a = C1154a.m709a();
        BigInteger a2 = C1055b.m440a(a.mo13918a(jSONObject.getString(C1172a.m764a(-699689280555694L))));
        BigInteger a3 = C1055b.m440a(a.mo13918a(jSONObject.getString(C1172a.m764a(-699697870490286L))));
        ECPrivateKey eCPrivateKey = null;
        BigInteger a4 = jSONObject.has(C1172a.m764a(-699706460424878L)) ? C1055b.m440a(a.mo13918a(jSONObject.getString(C1172a.m764a(-699715050359470L)))) : null;
        C1057d a5 = C1057d.m445a(jSONObject.getString(C1172a.m764a(-699723640294062L)));
        this.f287b = a5;
        this.f288c = C1060e.m452a(a5, a2, a3);
        this.f289d = a4 != null ? C1060e.m451a(this.f287b, a4) : eCPrivateKey;
    }

    /* renamed from: a */
    public byte[] mo13759a(String str, String str2, String str3, ECPublicKey eCPublicKey) {
        byte[] a = C1060e.m453a(eCPublicKey, this.f289d);
        return C1056c.m444a(a, a.length * 8, str, str2, str3);
    }
}
