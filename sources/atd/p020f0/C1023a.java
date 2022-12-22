package atd.p020f0;

import atd.p014c0.C0972b;
import atd.p014c0.C0974d;
import atd.p014c0.C0975e;
import atd.p016d0.C1008e;
import atd.p016d0.C1009f;
import atd.p022g0.C1033b;
import atd.p022g0.C1035d;
import java.security.GeneralSecurityException;

/* renamed from: atd.f0.a */
public final class C1023a {

    /* renamed from: a */
    private final C1028f f275a;

    /* renamed from: b */
    private final C0974d f276b;

    /* renamed from: c */
    private final C1026d f277c;

    public C1023a(C1028f fVar, C0974d dVar, C1033b bVar) {
        C1009f f = fVar.mo13751f();
        this.f275a = fVar;
        this.f276b = dVar;
        this.f277c = m350a(f, bVar);
    }

    /* renamed from: a */
    public C1030h mo13747a(byte[] bArr) throws GeneralSecurityException {
        C0972b e = this.f275a.mo13750e();
        byte[] b = e.mo13620b();
        C0975e b2 = e.mo13619b(this.f276b, b, bArr, this.f275a.mo13790b());
        return new C1030h(this.f275a, this.f277c, new C1029g(b), new C1027e(b2.mo13624b()), new C1025c(b2.mo13623a()));
    }

    /* renamed from: a */
    public byte[] mo13748a(C1030h hVar) throws GeneralSecurityException {
        C0972b e = this.f275a.mo13750e();
        byte[] b = hVar.mo13754c().mo13790b();
        return e.mo13618a(this.f276b, hVar.mo13755d().mo13790b(), hVar.mo13753b().mo13790b(), b, hVar.mo13752a().mo13790b());
    }

    /* renamed from: a */
    private C1026d m350a(C1009f fVar, C1033b bVar) {
        byte[] bArr;
        if (fVar instanceof C1008e) {
            C1033b.m372a(bVar, C1035d.class);
            bArr = ((C1008e) fVar).mo13732a(this.f276b, ((C1035d) bVar).mo13767f());
        } else {
            bArr = null;
        }
        return new C1026d(bArr);
    }
}
