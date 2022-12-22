package atd.p013c;

import atd.p019f.C1022b;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.c.c */
public abstract class C0963c<T> implements C1022b {

    /* renamed from: a */
    private final String f200a;

    /* renamed from: b */
    private final T f201b;

    public C0963c(String str, T t) {
        this.f200a = str;
        this.f201b = t;
    }

    /* renamed from: b */
    private String m175b() {
        return this.f200a;
    }

    /* renamed from: c */
    private T m176c() {
        return this.f201b;
    }

    /* renamed from: a */
    public JSONObject mo13606a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (mo13604a(m176c())) {
            jSONObject.put(m175b(), m176c());
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo13604a(T t);
}
