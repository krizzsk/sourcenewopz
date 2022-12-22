package com.didi.consume.phone;

import android.view.View;

public class CsPhoneRefillUtil {
    public static boolean isPointInsideView(float f, float f2, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        float f3 = (float) 20;
        if (f - f3 <= ((float) i) || f + f3 >= ((float) (i + view.getWidth())) || f2 - f3 <= ((float) i2) || f2 + f3 >= ((float) (i2 + view.getHeight()))) {
            return false;
        }
        return true;
    }
}
