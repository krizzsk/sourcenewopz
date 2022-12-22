package atd.p022g0;

import atd.p044r0.C1154a;
import atd.p046s0.C1172a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.g0.e */
public final class C1036e extends C1033b {

    /* renamed from: b */
    private final byte[] f293b;

    static {
        C1172a.m764a(-700114482317998L);
    }

    C1036e(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.f293b = C1154a.m709a().mo13918a(jSONObject.getString(C1172a.m764a(-700088712514222L)));
    }

    /* renamed from: c */
    public byte[] mo13768c() {
        return (byte[]) this.f293b.clone();
    }

    public C1036e(String str, byte[] bArr) {
        super(str, C1172a.m764a(-700097302448814L));
        this.f293b = (byte[]) bArr.clone();
    }
}
