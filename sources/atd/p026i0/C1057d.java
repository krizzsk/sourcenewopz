package atd.p026i0;

import atd.p046s0.C1172a;
import java.math.BigInteger;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

/* renamed from: atd.i0.d */
public enum C1057d {
    P256(C1172a.m764a(-702790246943406L), new C1059b());
    
    private final String mApiName;
    private final ECParameterSpec mECParameterSpec;

    /* renamed from: atd.i0.d$a */
    private interface C1058a {
        /* renamed from: a */
        ECParameterSpec mo13788a();
    }

    /* renamed from: atd.i0.d$b */
    private static final class C1059b implements C1058a {
        C1059b() {
        }

        /* renamed from: a */
        public ECParameterSpec mo13788a() {
            EllipticCurve ellipticCurve = new EllipticCurve(new ECFieldFp(new BigInteger(C1172a.m764a(-700836036823726L), 16)), new BigInteger(C1172a.m764a(-701115209697966L), 16), new BigInteger(C1172a.m764a(-701394382572206L), 16), new BigInteger(C1172a.m764a(-701673555446446L), 16).toByteArray());
            BigInteger bigInteger = new BigInteger(C1172a.m764a(-701849649105582L), 16);
            BigInteger bigInteger2 = new BigInteger(C1172a.m764a(-702128821979822L), 16);
            return new ECParameterSpec(ellipticCurve, new ECPoint(bigInteger, bigInteger2), new BigInteger(C1172a.m764a(-702407994854062L), 16), 1);
        }
    }

    private C1057d(String str, C1058a aVar) {
        this.mApiName = str;
        this.mECParameterSpec = aVar.mo13788a();
    }

    /* renamed from: a */
    public static C1057d m445a(String str) {
        for (C1057d dVar : values()) {
            if (dVar.mApiName.equals(str)) {
                return dVar;
            }
        }
        throw new IllegalArgumentException(C1172a.m764a(-702687167728302L));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ECParameterSpec mo13787b() {
        return this.mECParameterSpec;
    }

    /* renamed from: a */
    public String mo13786a() {
        return this.mApiName;
    }
}
