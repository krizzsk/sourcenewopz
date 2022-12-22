package atd.p023h;

import atd.p052y.C1225c;
import com.adyen.threeds2.exception.InvalidInputException;

/* renamed from: atd.h.f */
final class C1043f {

    /* renamed from: atd.h.f$a */
    static /* synthetic */ class C1044a {

        /* renamed from: a */
        static final /* synthetic */ int[] f297a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                atd.h.a[] r0 = atd.p023h.C1037a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f297a = r0
                atd.h.a r1 = atd.p023h.C1037a.V1_1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f297a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.h.a r1 = atd.p023h.C1037a.V1_4     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.p023h.C1043f.C1044a.<clinit>():void");
        }
    }

    /* renamed from: a */
    public static C1040c m422a(C1037a aVar) throws InvalidInputException {
        int i = C1044a.f297a[aVar.ordinal()];
        if (i == 1) {
            return new C1041d();
        }
        if (i == 2) {
            return new C1042e();
        }
        throw C1225c.DEVICE_DATA_FAILURE.mo13982a();
    }
}
