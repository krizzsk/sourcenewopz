package atd.p020f0;

import atd.p014c0.C0972b;
import atd.p014c0.C0973c;
import atd.p016d0.C1009f;
import atd.p016d0.C1010g;
import atd.p026i0.C1061f;
import atd.p046s0.C1172a;
import atd.p052y.C1225c;
import com.adyen.threeds2.internal.C1395b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.f0.f */
public final class C1028f extends C1061f {

    /* renamed from: c */
    private final C1009f f278c;

    /* renamed from: d */
    private final C0972b f279d;

    public C1028f(C1009f fVar, C0972b bVar, JSONObject jSONObject) {
        super(m354a(fVar, bVar, jSONObject));
        this.f278c = fVar;
        this.f279d = bVar;
    }

    /* renamed from: a */
    private static byte[] m354a(C1009f fVar, C0972b bVar, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(C1172a.m764a(-699465942256302L), fVar.mo13603a());
            jSONObject2.put(C1172a.m764a(-699483122125486L), bVar.mo13603a());
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            }
            return jSONObject2.toString().getBytes(C1395b.f995a);
        } catch (JSONException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }

    /* renamed from: e */
    public C0972b mo13750e() {
        return this.f279d;
    }

    /* renamed from: f */
    public C1009f mo13751f() {
        return this.f278c;
    }

    C1028f(String str) {
        super(str);
        try {
            JSONObject d = mo13792d();
            this.f278c = C1010g.m315a(d.getString(C1172a.m764a(-699500301994670L)));
            this.f279d = C0973c.m209a(d.getString(C1172a.m764a(-699517481863854L)));
        } catch (JSONException e) {
            throw C1225c.CRYPTO_FAILURE.mo13983a(e);
        }
    }
}
