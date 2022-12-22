package p093switch;

import com.iproov.sdk.cameray.Orientation;

/* renamed from: switch.else */
/* compiled from: OrientationUtils */
public class C3116else {

    /* renamed from: do */
    public static final float[] f6945do = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: for  reason: not valid java name */
    public static final float[] f61705for = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: if */
    public static final float[] f6946if = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: new  reason: not valid java name */
    public static final float[] f61706new = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: switch.else$do */
    /* compiled from: OrientationUtils */
    static /* synthetic */ class C3117do {

        /* renamed from: do */
        static final /* synthetic */ int[] f6947do;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.iproov.sdk.cameray.Orientation[] r0 = com.iproov.sdk.cameray.Orientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6947do = r0
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.PORTRAIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6947do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6947do     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.REVERSE_PORTRAIT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6947do     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.iproov.sdk.cameray.Orientation r1 = com.iproov.sdk.cameray.Orientation.REVERSE_LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p093switch.C3116else.C3117do.<clinit>():void");
        }
    }

    /* renamed from: do */
    public static float[] m4027do(Orientation orientation) {
        int i = C3117do.f6947do[orientation.ordinal()];
        if (i == 1) {
            return f6945do;
        }
        if (i == 2) {
            return f6946if;
        }
        if (i == 3) {
            return f61705for;
        }
        if (i != 4) {
            return f61706new;
        }
        return f61706new;
    }

    /* renamed from: do */
    public static Orientation m4026do(Orientation orientation, Orientation orientation2) {
        return Orientation.findByDegrees((orientation.angleDegrees + orientation2.angleDegrees) % 360);
    }
}
