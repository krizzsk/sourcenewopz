package atd.p044r0;

import android.util.Base64;
import com.adyen.threeds2.internal.C1395b;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: atd.r0.a */
public final class C1154a {

    /* renamed from: c */
    private static final Charset f374c = C1395b.f995a;

    /* renamed from: a */
    private final Charset f375a;

    /* renamed from: b */
    private final int f376b;

    private C1154a(Charset charset, int i) {
        this.f375a = charset;
        this.f376b = i;
    }

    /* renamed from: a */
    public static C1154a m709a() {
        return m711a(f374c, 11);
    }

    /* renamed from: e */
    private byte[] m713e(String str) {
        return str.getBytes(this.f375a);
    }

    /* renamed from: b */
    public Charset mo13921b() {
        return this.f375a;
    }

    /* renamed from: c */
    public byte[] mo13924c(byte[] bArr) {
        return Base64.encode(bArr, this.f376b);
    }

    /* renamed from: d */
    public String mo13926d(byte[] bArr) {
        return m712e(mo13924c(bArr));
    }

    /* renamed from: a */
    public static C1154a m710a(Charset charset) {
        return m711a(charset, 11);
    }

    /* renamed from: e */
    private String m712e(byte[] bArr) {
        return new String(bArr, this.f375a);
    }

    /* renamed from: b */
    public String mo13920b(byte[] bArr) {
        return new String(mo13919a(bArr), this.f375a);
    }

    /* renamed from: c */
    public String mo13923c(String str) {
        return mo13920b(str.getBytes(this.f375a));
    }

    /* renamed from: d */
    public String mo13925d(String str) {
        return mo13926d(str.getBytes(this.f375a));
    }

    /* renamed from: a */
    public static C1154a m711a(Charset charset, int... iArr) {
        int i = 0;
        if (iArr != null) {
            int length = iArr.length;
            int i2 = 0;
            while (i < length) {
                i2 |= iArr[i];
                i++;
            }
            i = i2;
        }
        return new C1154a(charset, i);
    }

    /* renamed from: b */
    public JSONObject mo13922b(String str) throws JSONException {
        return new JSONObject(mo13923c(str));
    }

    /* renamed from: a */
    public byte[] mo13919a(byte[] bArr) {
        return Base64.decode(bArr, this.f376b);
    }

    /* renamed from: a */
    public byte[] mo13918a(String str) {
        return mo13919a(m713e(str));
    }
}
