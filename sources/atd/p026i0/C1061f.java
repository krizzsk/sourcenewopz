package atd.p026i0;

import atd.p044r0.C1154a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.i0.f */
public class C1061f {

    /* renamed from: b */
    private static final C1154a f308b = C1154a.m709a();

    /* renamed from: a */
    private final byte[] f309a;

    protected C1061f(byte[] bArr) {
        this.f309a = (byte[]) bArr.clone();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C1154a mo13789a() {
        return f308b;
    }

    /* renamed from: b */
    public final byte[] mo13790b() {
        return (byte[]) this.f309a.clone();
    }

    /* renamed from: c */
    public final String mo13791c() {
        return mo13789a().mo13926d(this.f309a);
    }

    /* renamed from: d */
    public final JSONObject mo13792d() throws JSONException {
        return new JSONObject(new String(mo13790b(), mo13789a().mo13921b()));
    }

    protected C1061f(String str) {
        this.f309a = mo13789a().mo13918a(str);
    }
}
