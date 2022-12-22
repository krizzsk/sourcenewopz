package atd.p022g0;

import atd.p020f0.C1024b;
import java.security.PrivateKey;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.g0.c */
public abstract class C1034c extends C1033b implements C1024b {
    C1034c(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    /* renamed from: c */
    public void mo13765c() {
        try {
            PrivateKey d = mo13760d();
            if (d != null) {
                d.destroy();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public abstract PrivateKey mo13760d();

    C1034c(String str, String str2) {
        super(str, str2);
    }
}
