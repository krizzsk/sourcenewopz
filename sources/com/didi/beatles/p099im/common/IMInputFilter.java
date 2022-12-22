package com.didi.beatles.p099im.common;

import android.text.InputFilter;
import android.text.Spanned;

/* renamed from: com.didi.beatles.im.common.IMInputFilter */
public class IMInputFilter implements InputFilter {

    /* renamed from: a */
    private int f9143a = 60;

    /* renamed from: a */
    private int m6203a(char c) {
        return c < 128 ? 1 : 2;
    }

    public IMInputFilter(int i) {
        this.f9143a = i;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return m6204a(charSequence, i, i2, spanned, i3, i4);
    }

    /* renamed from: a */
    private CharSequence m6204a(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        Spanned spanned2 = (Spanned) spanned.subSequence(0, i3);
        int i5 = 0;
        int i6 = 0;
        while (i5 <= this.f9143a && i6 < spanned2.length()) {
            i5 += m6203a(spanned2.charAt(i6));
            i6++;
        }
        if (i5 > this.f9143a) {
            return "";
        }
        int i7 = 0;
        while (i5 <= this.f9143a && i7 < charSequence.length()) {
            i5 += m6203a(charSequence.charAt(i7));
            i7++;
        }
        if (i5 > this.f9143a) {
            i7--;
        }
        if (i7 == i2) {
            return null;
        }
        return charSequence.subSequence(0, i7);
    }

    public void setMaxLength(int i) {
        this.f9143a = i;
    }
}
