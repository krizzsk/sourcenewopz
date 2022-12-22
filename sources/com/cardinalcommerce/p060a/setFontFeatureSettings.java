package com.cardinalcommerce.p060a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.text.Typography;
import org.apache.commons.p071io.IOUtils;

/* renamed from: com.cardinalcommerce.a.setFontFeatureSettings */
public final class setFontFeatureSettings extends View {

    /* renamed from: a */
    private static int f2782a = 0;

    /* renamed from: b */
    private static int f2783b = 1;

    /* renamed from: com.cardinalcommerce.a.setFontFeatureSettings$Cardinal */
    interface Cardinal extends View.OnScrollChangeListener {
    }

    /* renamed from: com.cardinalcommerce.a.setFontFeatureSettings$configure */
    interface C2047configure extends View.OnTouchListener {
    }

    /* renamed from: com.cardinalcommerce.a.setFontFeatureSettings$getInstance */
    public interface getInstance extends View.OnFocusChangeListener {
    }

    /* renamed from: com.cardinalcommerce.a.setFontFeatureSettings$init */
    public interface C2048init extends View.OnClickListener {
    }

    public final void addOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        int i = f2782a;
        int i2 = i & 11;
        int i3 = -(-((i ^ 11) | i2));
        int i4 = (i2 & i3) + (i3 | i2);
        f2783b = i4 % 128;
        if ((i4 % 2 == 0 ? IOUtils.DIR_SEPARATOR_UNIX : 'D') == '/') {
            Object obj = null;
            super.hashCode();
        }
    }

    public final void addOnLayoutChangeListener(View.OnLayoutChangeListener onLayoutChangeListener) {
        int i = f2782a;
        int i2 = (i & 13) + (i | 13);
        f2783b = i2 % 128;
        if (!(i2 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public final void removeOnLayoutChangeListener(View.OnLayoutChangeListener onLayoutChangeListener) {
        int i = f2782a;
        int i2 = ((i ^ 82) + ((i & 82) << 1)) - 1;
        f2783b = i2 % 128;
        int i3 = i2 % 2;
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        int i = f2783b;
        int i2 = (i ^ 40) + ((i & 40) << 1);
        int i3 = ((i2 | -1) << 1) - (i2 ^ -1);
        f2782a = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        int i = f2783b;
        int i2 = i & 41;
        int i3 = -(-(i | 41));
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2782a = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 55 / 0;
        }
    }

    public final void setOnScrollChangeListener(View.OnScrollChangeListener onScrollChangeListener) {
        int i = f2783b;
        int i2 = (i | 13) << 1;
        int i3 = -(i ^ 13);
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2782a = i4 % 128;
        int i5 = i4 % 2;
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        int i = (f2783b + 18) - 1;
        f2782a = i % 128;
        if ((i % 2 != 0 ? 'W' : '^') == 'W') {
            Object obj = null;
            super.hashCode();
        }
    }

    public final void setVisibility(int i) {
        int i2 = f2782a;
        int i3 = (i2 & 39) - (~(-(-(i2 | 39))));
        boolean z = true;
        int i4 = i3 - 1;
        f2783b = i4 % 128;
        if (i4 % 2 == 0) {
            z = false;
        }
        if (!z) {
            int i5 = 56 / 0;
        }
    }

    public setFontFeatureSettings(Context context) {
        super(context);
    }

    public setFontFeatureSettings(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public setFontFeatureSettings(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setCCAOnClickListener(C2048init init) {
        int i = f2782a;
        int i2 = ((i ^ 41) | (i & 41)) << 1;
        int i3 = -(((~i) & 41) | (i & -42));
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2783b = i4 % 128;
        boolean z = i4 % 2 == 0;
        Object obj = null;
        super.setOnClickListener(init);
        if (z) {
            super.hashCode();
        }
        int i5 = f2783b;
        int i6 = i5 ^ 105;
        int i7 = (((i5 & 105) | i6) << 1) - i6;
        f2782a = i7 % 128;
        if ((i7 % 2 != 0 ? 4 : Typography.amp) != '&') {
            super.hashCode();
        }
    }

    public final void setCCAVisibility(int i) {
        int i2 = f2782a;
        int i3 = i2 & 13;
        int i4 = i3 + ((i2 ^ 13) | i3);
        f2783b = i4 % 128;
        boolean z = i4 % 2 != 0;
        super.setVisibility(i);
        if (!z) {
            int i5 = 50 / 0;
        }
        int i6 = f2783b;
        int i7 = (i6 & 67) + (i6 | 67);
        f2782a = i7 % 128;
        int i8 = i7 % 2;
    }

    public final void setCCAOnTouchListener(C2047configure configure) {
        int i = f2783b;
        int i2 = ((i & 50) + (i | 50)) - 1;
        f2782a = i2 % 128;
        boolean z = i2 % 2 != 0;
        super.setOnTouchListener(configure);
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public final void setCCAOnFocusChangeListener(getInstance getinstance) {
        int i = f2782a;
        int i2 = ((i | 54) << 1) - (i ^ 54);
        int i3 = (i2 & -1) + (i2 | -1);
        f2783b = i3 % 128;
        int i4 = i3 % 2;
        super.setOnFocusChangeListener(getinstance);
        int i5 = f2782a;
        int i6 = (i5 ^ 25) + ((i5 & 25) << 1);
        f2783b = i6 % 128;
        int i7 = i6 % 2;
    }

    public final void setCCAOnScrollChangeListener(Cardinal cardinal) {
        int i = f2782a;
        int i2 = ((i | 112) << 1) - (i ^ 112);
        boolean z = false;
        int i3 = (i2 - 0) - 1;
        f2783b = i3 % 128;
        int i4 = i3 % 2;
        super.setOnScrollChangeListener(cardinal);
        int i5 = f2782a;
        int i6 = i5 & 19;
        int i7 = (i6 - (~((i5 ^ 19) | i6))) - 1;
        f2783b = i7 % 128;
        if (i7 % 2 == 0) {
            z = true;
        }
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }
}
