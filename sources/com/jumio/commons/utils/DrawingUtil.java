package com.jumio.commons.utils;

import android.graphics.Path;
import android.graphics.Rect;

public class DrawingUtil {
    public static Path createRectWithRoundedCornersAsPath(Rect rect, int i, int i2, int i3, int i4) {
        int i5 = rect.left;
        int i6 = rect.right;
        int i7 = rect.top;
        int i8 = rect.bottom;
        Path path = new Path();
        if (i <= 0) {
            path.moveTo((float) i5, (float) i7);
        } else {
            path.moveTo((float) (i5 + i), (float) i7);
        }
        if (i2 <= 0) {
            path.lineTo((float) i6, (float) i7);
        } else {
            float f = (float) i7;
            path.lineTo((float) (i6 - i), f);
            float f2 = (float) i6;
            path.quadTo(f2, f, f2, (float) (i2 + i7));
        }
        if (i3 <= 0) {
            path.lineTo((float) i6, (float) i8);
        } else {
            float f3 = (float) i6;
            path.lineTo(f3, (float) (i8 - i3));
            float f4 = (float) i8;
            path.quadTo(f3, f4, (float) (i6 - i3), f4);
        }
        if (i4 <= 0) {
            path.lineTo((float) i5, (float) i8);
        } else {
            float f5 = (float) i8;
            path.lineTo((float) (i5 + i4), f5);
            float f6 = (float) i5;
            path.quadTo(f6, f5, f6, (float) (i8 - i4));
        }
        if (i <= 0) {
            path.lineTo((float) i5, (float) i7);
        } else {
            float f7 = (float) i5;
            path.lineTo(f7, (float) (i7 + i));
            float f8 = (float) i7;
            path.quadTo(f7, f8, (float) (i5 + i), f8);
        }
        path.close();
        return path;
    }
}
