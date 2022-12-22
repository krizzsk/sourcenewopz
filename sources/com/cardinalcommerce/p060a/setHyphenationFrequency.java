package com.cardinalcommerce.p060a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.cardinalcommerce.p060a.setFontFeatureSettings;

/* renamed from: com.cardinalcommerce.a.setHyphenationFrequency */
public class setHyphenationFrequency extends Button {

    /* renamed from: a */
    private static int f2804a = 0;

    /* renamed from: b */
    private static int f2805b = 1;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        int i = f2804a;
        int i2 = ((i ^ 5) | (i & 5)) << 1;
        int i3 = -(((~i) & 5) | (i & -6));
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2805b = i4 % 128;
        int i5 = i4 % 2;
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        int i = f2805b;
        int i2 = i & 107;
        int i3 = (i ^ 107) | i2;
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f2804a = i4 % 128;
        int i5 = i4 % 2;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        int i = f2805b;
        int i2 = i & 93;
        int i3 = (i2 - (~((i ^ 93) | i2))) - 1;
        f2804a = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 63 / 0;
        }
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        int i = f2804a + 6;
        int i2 = (i ^ -1) + ((i & -1) << 1);
        f2805b = i2 % 128;
        int i3 = i2 % 2;
    }

    public void setVisibility(int i) {
        int i2 = f2805b;
        int i3 = (i2 & 75) + (i2 | 75);
        f2804a = i3 % 128;
        int i4 = i3 % 2;
    }

    public setHyphenationFrequency(Context context) {
        super(context);
    }

    public setHyphenationFrequency(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public setHyphenationFrequency(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CharSequence getText() {
        int i = f2805b;
        int i2 = (i & 78) + (i | 78);
        int i3 = (i2 & -1) + (i2 | -1);
        f2804a = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i4 = f2805b;
        int i5 = (i4 | 37) << 1;
        int i6 = -(((~i4) & 37) | (i4 & -38));
        int i7 = (i5 ^ i6) + ((i6 & i5) << 1);
        f2804a = i7 % 128;
        int i8 = i7 % 2;
        return "*";
    }

    public void setCCAOnClickListener(setFontFeatureSettings.C2048init init) {
        int i = f2804a;
        int i2 = (i & -114) | ((~i) & 113);
        int i3 = (i & 113) << 1;
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2805b = i4 % 128;
        char c = i4 % 2 == 0 ? 27 : '2';
        super.setOnClickListener(init);
        if (c != '2') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public void setCCAText(CharSequence charSequence) {
        int i = f2805b;
        int i2 = i & 67;
        int i3 = (i ^ 67) | i2;
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2804a = i4 % 128;
        if ((i4 % 2 != 0 ? '*' : 'K') != 'K') {
            super.setText(charSequence, TextView.BufferType.EDITABLE);
            int i5 = 65 / 0;
        } else {
            super.setText(charSequence, TextView.BufferType.EDITABLE);
        }
        int i6 = f2805b;
        int i7 = ((((i6 ^ 11) | (i6 & 11)) << 1) - (~(-(((~i6) & 11) | (i6 & -12))))) - 1;
        f2804a = i7 % 128;
        if (i7 % 2 != 0) {
            int i8 = 94 / 0;
        }
    }

    public void setCCAOnTouchListener(setFontFeatureSettings.C2047configure configure) {
        int i = (f2804a + 49) - 1;
        int i2 = (i ^ -1) + ((i & -1) << 1);
        f2805b = i2 % 128;
        int i3 = i2 % 2;
        super.setOnTouchListener(configure);
        int i4 = (f2805b + 30) - 1;
        f2804a = i4 % 128;
        if ((i4 % 2 != 0 ? 'W' : '-') != '-') {
            int i5 = 68 / 0;
        }
    }

    public void setCCAOnFocusChangeListener(setFontFeatureSettings.getInstance getinstance) {
        int i = ((f2804a + 105) - 1) - 1;
        f2805b = i % 128;
        char c = i % 2 == 0 ? '^' : ';';
        super.setOnFocusChangeListener(getinstance);
        if (c != ';') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public void setCCAVisibility(int i) {
        int i2 = (f2805b + 74) - 1;
        f2804a = i2 % 128;
        int i3 = i2 % 2;
        super.setVisibility(i);
        int i4 = f2805b;
        int i5 = (i4 & 53) + (i4 | 53);
        f2804a = i5 % 128;
        int i6 = i5 % 2;
    }
}
