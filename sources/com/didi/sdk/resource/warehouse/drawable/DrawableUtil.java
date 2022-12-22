package com.didi.sdk.resource.warehouse.drawable;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;

public class DrawableUtil {
    public static ColorDrawable getColorDrawable(int i) {
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(i);
        return colorDrawable;
    }

    public static GradientDrawable getLinearGradientDrawable(int i, GradientDrawable.Orientation orientation, int[] iArr, float[] fArr, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(i);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(orientation);
        if (!(iArr == null || iArr.length == 0)) {
            if (iArr.length == 1) {
                gradientDrawable.setColor(iArr[0]);
            } else {
                gradientDrawable.setColors(iArr);
            }
        }
        if (fArr == null || fArr.length == 0) {
            gradientDrawable.setCornerRadius(0.0f);
        } else if (fArr.length >= 8) {
            gradientDrawable.setCornerRadii(fArr);
        } else if (fArr.length >= 4) {
            gradientDrawable.setCornerRadii(new float[]{fArr[0], fArr[0], fArr[1], fArr[1], fArr[2], fArr[2], fArr[3], fArr[3]});
        } else {
            gradientDrawable.setCornerRadius(fArr[0]);
        }
        gradientDrawable.setStroke(i2, i3);
        return gradientDrawable;
    }
}
