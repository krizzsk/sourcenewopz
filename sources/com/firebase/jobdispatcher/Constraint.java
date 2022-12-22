package com.firebase.jobdispatcher;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Constraint {
    public static final int DEVICE_CHARGING = 4;
    public static final int DEVICE_IDLE = 8;
    public static final int ON_ANY_NETWORK = 2;
    public static final int ON_UNMETERED_NETWORK = 1;

    /* renamed from: a */
    static final int[] f52072a = {2, 1, 4, 8};

    @Retention(RetentionPolicy.SOURCE)
    public @interface JobConstraint {
    }

    private Constraint() {
    }

    /* renamed from: a */
    static int m37173a(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int i = 0;
        for (int i2 : iArr) {
            i |= i2;
        }
        return i;
    }

    /* renamed from: a */
    static int[] m37174a(int i) {
        int[] iArr = f52072a;
        int length = iArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            i2 += (i & i4) == i4 ? 1 : 0;
        }
        int[] iArr2 = new int[i2];
        int i5 = 0;
        for (int i6 : f52072a) {
            if ((i & i6) == i6) {
                iArr2[i5] = i6;
                i5++;
            }
        }
        return iArr2;
    }
}
