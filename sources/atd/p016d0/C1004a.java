package atd.p016d0;

import atd.p014c0.C0972b;
import atd.p014c0.C0974d;
import atd.p020f0.C1028f;
import atd.p022g0.C1033b;
import atd.p022g0.C1036e;
import atd.p046s0.C1172a;
import java.util.Arrays;

/* renamed from: atd.d0.a */
final class C1004a extends C1005b {
    static {
        C1172a.m764a(-698319185988270L);
    }

    C1004a() {
    }

    /* renamed from: a */
    public String mo13603a() {
        return C1172a.m764a(-698302006119086L);
    }

    /* renamed from: a */
    public C0974d mo13730a(C1028f fVar, C1033b bVar) {
        C1033b.m372a(bVar, C1036e.class);
        return mo13729a(fVar.mo13750e(), ((C1036e) bVar).mo13768c());
    }

    /* renamed from: a */
    public C0974d mo13729a(C0972b bVar, byte[] bArr) {
        return new C0974d(Arrays.copyOfRange(bArr, 0, bVar.mo13615f() / 8), bVar);
    }
}
