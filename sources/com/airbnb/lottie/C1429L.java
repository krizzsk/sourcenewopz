package com.airbnb.lottie;

import androidx.core.p006os.TraceCompat;

/* renamed from: com.airbnb.lottie.L */
public class C1429L {
    public static boolean DBG = false;
    public static final String TAG = "LOTTIE";

    /* renamed from: a */
    private static final int f1095a = 20;

    /* renamed from: b */
    private static boolean f1096b = false;

    /* renamed from: c */
    private static String[] f1097c;

    /* renamed from: d */
    private static long[] f1098d;

    /* renamed from: e */
    private static int f1099e;

    /* renamed from: f */
    private static int f1100f;

    public static void setTraceEnabled(boolean z) {
        if (f1096b != z) {
            f1096b = z;
            if (z) {
                f1097c = new String[20];
                f1098d = new long[20];
            }
        }
    }

    public static void beginSection(String str) {
        if (f1096b) {
            int i = f1099e;
            if (i == 20) {
                f1100f++;
                return;
            }
            f1097c[i] = str;
            f1098d[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            f1099e++;
        }
    }

    public static float endSection(String str) {
        int i = f1100f;
        if (i > 0) {
            f1100f = i - 1;
            return 0.0f;
        } else if (!f1096b) {
            return 0.0f;
        } else {
            int i2 = f1099e - 1;
            f1099e = i2;
            if (i2 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(f1097c[i2])) {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - f1098d[f1099e])) / 1000000.0f;
            } else {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f1097c[f1099e] + ".");
            }
        }
    }
}
