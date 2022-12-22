package com.didi.beatles.p099im.utils;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;

/* renamed from: com.didi.beatles.im.utils.IMSpanny */
public class IMSpanny extends SpannableStringBuilder {

    /* renamed from: a */
    private int f9789a = 33;

    /* renamed from: com.didi.beatles.im.utils.IMSpanny$GetSpan */
    public interface GetSpan {
        Object getSpan();
    }

    public IMSpanny() {
        super("");
    }

    public IMSpanny(CharSequence charSequence) {
        super(charSequence);
    }

    public IMSpanny(CharSequence charSequence, Object... objArr) {
        super(charSequence);
        for (Object a : objArr) {
            m6644a(a, 0, length());
        }
    }

    public IMSpanny(CharSequence charSequence, Object obj) {
        super(charSequence);
        m6644a(obj, 0, charSequence.length());
    }

    public IMSpanny append(CharSequence charSequence, Object... objArr) {
        append(charSequence);
        for (Object a : objArr) {
            m6644a(a, length() - charSequence.length(), length());
        }
        return this;
    }

    public IMSpanny append(CharSequence charSequence, Object obj) {
        append(charSequence);
        m6644a(obj, length() - charSequence.length(), length());
        return this;
    }

    public IMSpanny append(CharSequence charSequence, ImageSpan imageSpan) {
        String str = "." + charSequence;
        append((CharSequence) str);
        m6644a(imageSpan, length() - str.length(), (length() - str.length()) + 1);
        return this;
    }

    public IMSpanny append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Deprecated
    public IMSpanny appendText(CharSequence charSequence) {
        append(charSequence);
        return this;
    }

    public void setFlag(int i) {
        this.f9789a = i;
    }

    /* renamed from: a */
    private void m6644a(Object obj, int i, int i2) {
        setSpan(obj, i, i2, this.f9789a);
    }

    public IMSpanny findAndSpan(CharSequence charSequence, GetSpan getSpan) {
        int i = 0;
        while (i != -1) {
            i = toString().indexOf(charSequence.toString(), i);
            if (i != -1) {
                m6644a(getSpan.getSpan(), i, charSequence.length() + i);
                i += charSequence.length();
            }
        }
        return this;
    }

    public static SpannableString spanText(CharSequence charSequence, Object... objArr) {
        SpannableString spannableString = new SpannableString(charSequence);
        for (Object span : objArr) {
            spannableString.setSpan(span, 0, charSequence.length(), 33);
        }
        return spannableString;
    }

    public static SpannableString spanText(CharSequence charSequence, Object obj) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(obj, 0, charSequence.length(), 33);
        return spannableString;
    }
}
