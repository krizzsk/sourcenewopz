package atd.p018e0;

import atd.p026i0.C1054a;
import atd.p046s0.C1172a;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;

/* renamed from: atd.e0.b */
final class C1018b extends C1019c {
    static {
        C1172a.m764a(-699358568073902L);
        C1172a.m764a(-699384337877678L);
    }

    C1018b() {
    }

    /* renamed from: b */
    private Signature m341b() throws GeneralSecurityException {
        return Signature.getInstance(C1172a.m764a(-699281258662574L), C1054a.f306a);
    }

    /* renamed from: a */
    public String mo13603a() {
        return C1172a.m764a(-699255488858798L);
    }

    /* renamed from: a */
    public boolean mo13746a(byte[] bArr, byte[] bArr2, PublicKey publicKey) throws GeneralSecurityException {
        Signature b = m341b();
        b.initVerify(publicKey);
        b.update(bArr2);
        return b.verify(bArr);
    }
}
