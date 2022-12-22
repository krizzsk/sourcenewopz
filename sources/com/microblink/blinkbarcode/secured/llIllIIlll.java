package com.microblink.blinkbarcode.secured;

import android.content.Context;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* compiled from: line */
public class llIllIIlll {
    public static final void IlIllIlIIl(float[] fArr, int i, float f, float f2) {
        if (i == 1) {
            fArr[0] = fArr[1];
            fArr[1] = f - fArr[0];
        } else if (i == 8) {
            fArr[0] = f - fArr[0];
            fArr[1] = f2 - fArr[1];
        } else if (i == 9) {
            float f3 = f2 - fArr[1];
            float f4 = fArr[0];
            fArr[0] = f3;
            fArr[1] = f4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = android.os.Build.MANUFACTURER;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean llIIlIlIIl() {
        /*
            java.lang.String r0 = android.os.Build.BRAND
            if (r0 == 0) goto L_0x0018
            java.lang.String r1 = android.os.Build.MANUFACTURER
            if (r1 == 0) goto L_0x0018
            java.lang.String r2 = "Samsung"
            int r0 = r0.compareToIgnoreCase(r2)
            if (r0 == 0) goto L_0x0016
            int r0 = r1.compareToIgnoreCase(r2)
            if (r0 != 0) goto L_0x0018
        L_0x0016:
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.secured.llIllIIlll.llIIlIlIIl():boolean");
    }

    public static final void llIIlIlIIl(RectF rectF) {
        if (rectF.left < 0.0f) {
            rectF.left = 0.0f;
        }
        if (rectF.left > 1.0f) {
            rectF.left = 1.0f;
        }
        if (rectF.top < 0.0f) {
            rectF.top = 0.0f;
        }
        if (rectF.top > 1.0f) {
            rectF.top = 1.0f;
        }
        if (rectF.right < 0.0f) {
            rectF.right = 0.0f;
        }
        if (rectF.right > 1.0f) {
            rectF.right = 1.0f;
        }
        if (rectF.bottom < 0.0f) {
            rectF.bottom = 0.0f;
        }
        if (rectF.bottom > 1.0f) {
            rectF.bottom = 1.0f;
        }
    }

    public static final void llIIlIlIIl(float[] fArr, int i, float f, float f2) {
        if (i == 1) {
            float f3 = f - fArr[1];
            float f4 = fArr[0];
            fArr[0] = f3;
            fArr[1] = f4;
        } else if (i == 8) {
            fArr[0] = f - fArr[0];
            fArr[1] = f2 - fArr[1];
        } else if (i == 9) {
            fArr[0] = fArr[1];
            fArr[1] = f2 - fArr[0];
        }
    }

    public static final void IlIllIlIIl(float[] fArr, float f, float f2) {
        fArr[0] = fArr[0] / f;
        fArr[1] = fArr[1] / f2;
    }

    public static final void llIIlIlIIl(float[] fArr, float f, float f2) {
        fArr[0] = fArr[0] * f;
        fArr[1] = fArr[1] * f2;
    }

    public static boolean llIIlIlIIl(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels < displayMetrics.heightPixels;
    }
}
