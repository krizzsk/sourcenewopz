package com.didi.beatles.p099im.views.widget.photoview;

import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;

/* renamed from: com.didi.beatles.im.views.widget.photoview.d */
/* compiled from: Util */
class C4410d {
    /* renamed from: a */
    static int m7270a(int i) {
        return (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    C4410d() {
    }

    /* renamed from: a */
    static void m7271a(float f, float f2, float f3) {
        if (f >= f2) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        } else if (f2 >= f3) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    /* renamed from: a */
    static boolean m7273a(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    /* renamed from: a */
    static boolean m7272a(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (Util$1.$SwitchMap$android$widget$ImageView$ScaleType[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
