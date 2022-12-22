package com.cardinalcommerce.p060a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.cardinalcommerce.p060a.setFontFeatureSettings;

/* renamed from: com.cardinalcommerce.a.setShowSoftInputOnFocus */
public class setShowSoftInputOnFocus extends TextView {

    /* renamed from: a */
    private static int f2994a = 0;

    /* renamed from: b */
    private static int f2995b = 1;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        int i = f2994a;
        int i2 = i & 91;
        int i3 = (((i | 91) & (~i2)) - (~(-(-(i2 << 1))))) - 1;
        f2995b = i3 % 128;
        int i4 = i3 % 2;
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        int i = f2995b;
        int i2 = i & 7;
        int i3 = (i | 7) & (~i2);
        int i4 = -(-(i2 << 1));
        int i5 = (i3 ^ i4) + ((i3 & i4) << 1);
        f2994a = i5 % 128;
        int i6 = i5 % 2;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        int i = f2994a + 61;
        f2995b = i % 128;
        if (!(i % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public setShowSoftInputOnFocus(Context context) {
        super(context);
    }

    public setShowSoftInputOnFocus(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public setShowSoftInputOnFocus(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        int i = f2995b;
        int i2 = (((i ^ 13) | (i & 13)) << 1) - (((~i) & 13) | (i & -14));
        f2994a = i2 % 128;
        boolean z = i2 % 2 != 0;
        super.setText("", bufferType);
        if (z) {
            Object obj = null;
            super.hashCode();
        }
    }

    public CharSequence getText() {
        int i = f2994a;
        boolean z = true;
        int i2 = (i ^ 123) + ((i & 123) << 1);
        f2995b = i2 % 128;
        if (i2 % 2 == 0) {
            z = false;
        }
        if (z) {
            return "";
        }
        int i3 = 59 / 0;
        return "";
    }

    public void setCCAText(CharSequence charSequence) {
        int i = f2994a + 25;
        f2995b = i % 128;
        int i2 = i % 2;
        super.setText(charSequence, TextView.BufferType.EDITABLE);
        int i3 = f2994a;
        int i4 = i3 & 63;
        boolean z = true;
        int i5 = ((i3 ^ 63) | i4) << 1;
        int i6 = -((i3 | 63) & (~i4));
        int i7 = (i5 ^ i6) + ((i6 & i5) << 1);
        f2995b = i7 % 128;
        if (i7 % 2 != 0) {
            z = false;
        }
        if (z) {
            Object obj = null;
            super.hashCode();
        }
    }

    public void setCCAOnClickListener(setFontFeatureSettings.C2048init init) {
        int i = f2995b;
        int i2 = (i ^ 84) + ((i & 84) << 1);
        int i3 = (i2 & -1) + (i2 | -1);
        f2994a = i3 % 128;
        int i4 = i3 % 2;
        super.setOnClickListener(init);
        int i5 = f2994a;
        int i6 = i5 & 123;
        int i7 = -(-((i5 ^ 123) | i6));
        int i8 = ((i6 | i7) << 1) - (i7 ^ i6);
        f2995b = i8 % 128;
        int i9 = i8 % 2;
    }

    public void setCCAOnFocusChangeListener(setFontFeatureSettings.getInstance getinstance) {
        int i = f2994a + 121;
        f2995b = i % 128;
        int i2 = i % 2;
        super.setOnFocusChangeListener(getinstance);
        int i3 = f2995b;
        int i4 = ((i3 & -6) | ((~i3) & 5)) + ((i3 & 5) << 1);
        f2994a = i4 % 128;
        if (i4 % 2 != 0) {
            Object obj = null;
            super.hashCode();
        }
    }

    public void setCCAOnTouchListener(setFontFeatureSettings.C2047configure configure) {
        int i = f2995b;
        int i2 = i & 61;
        int i3 = (i | 61) & (~i2);
        boolean z = true;
        int i4 = i2 << 1;
        int i5 = ((i3 | i4) << 1) - (i3 ^ i4);
        f2994a = i5 % 128;
        boolean z2 = i5 % 2 != 0;
        Object[] objArr = null;
        super.setOnTouchListener(configure);
        if (z2) {
            int length = objArr.length;
        }
        int i6 = f2995b;
        int i7 = i6 & 53;
        int i8 = ((i6 | 53) & (~i7)) + (i7 << 1);
        f2994a = i8 % 128;
        if (i8 % 2 == 0) {
            z = false;
        }
        if (z) {
            super.hashCode();
        }
    }
}
