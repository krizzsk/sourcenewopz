package atd.p016d0;

import atd.p014c0.C0972b;
import atd.p014c0.C0974d;
import atd.p020f0.C1028f;
import atd.p022g0.C1032a;
import atd.p022g0.C1033b;
import atd.p026i0.C1056c;
import atd.p026i0.C1057d;
import atd.p026i0.C1060e;
import atd.p046s0.C1172a;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.d0.c */
final class C1006c extends C1007d {
    static {
        C1172a.m764a(-698405085334190L);
    }

    C1006c() {
    }

    /* renamed from: a */
    public String mo13603a() {
        return C1172a.m764a(-698336365857454L);
    }

    /* renamed from: a */
    public C0974d mo13730a(C1028f fVar, C1033b bVar) throws JSONException {
        C1033b.m372a(bVar, C1032a.class);
        C0972b e = fVar.mo13750e();
        C1032a aVar = new C1032a((String) null, C1057d.P256);
        ECPublicKey f = ((C1032a) bVar).mo13762f();
        ECPrivateKey e2 = aVar.mo13760d();
        JSONObject d = fVar.mo13792d();
        return mo13731a(e, d.optString(C1172a.m764a(-698370725595822L), (String) null), d.optString(C1172a.m764a(-698387905465006L), (String) null), f, e2);
    }

    /* renamed from: a */
    public C0974d mo13731a(C0972b bVar, String str, String str2, ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) {
        return new C0974d(C1056c.m444a(C1060e.m453a(eCPublicKey, eCPrivateKey), bVar.mo13615f(), bVar.mo13603a(), str, str2), bVar);
    }
}
