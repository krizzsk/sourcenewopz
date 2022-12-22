package com.didi.unifiedPay.util;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleSpanStringBuilder extends SpannableStringBuilder {

    /* renamed from: a */
    private static final String f44601a = "([1-9]\\d*\\.\\d*|0\\.\\d*|[0-9]+)";

    /* renamed from: b */
    private CharSequence f44602b;

    public SimpleSpanStringBuilder(CharSequence charSequence) {
        super(charSequence);
        this.f44602b = charSequence;
    }

    public SimpleSpanStringBuilder(CharSequence charSequence, int i, int i2) {
        super(charSequence, i, i2);
        this.f44602b = charSequence;
    }

    public SimpleSpanStringBuilder spanColor(int i, int i2, int i3) {
        setSpan(new ForegroundColorSpan(i), i2, i3, 33);
        return this;
    }

    public SimpleSpanStringBuilder spanSize(float f, int i, int i2) {
        setSpan(new RelativeSizeSpan(f), i, i2, 33);
        setSpan(new StyleSpan(1), i, i2, 33);
        return this;
    }

    public SimpleSpanStringBuilder spanSize(int i) {
        setSpan(new AbsoluteSizeSpan(i), 0, length(), 33);
        return this;
    }

    public SimpleSpanStringBuilder spanRegexColor(String str, int i) {
        Matcher matcher = Pattern.compile(str).matcher(this.f44602b);
        while (matcher.find()) {
            spanColor(i, matcher.start(), matcher.end());
        }
        return this;
    }

    public SimpleSpanStringBuilder spanRegexSize(String str, float f) {
        Matcher matcher = Pattern.compile(str).matcher(this.f44602b);
        while (matcher.find()) {
            spanSize(f, matcher.start(), matcher.end());
        }
        return this;
    }

    public SimpleSpanStringBuilder spanNumsColor(int i) {
        return spanRegexColor(f44601a, i);
    }

    public SimpleSpanStringBuilder spanNums(int i, float f) {
        return spanRegexColor(f44601a, i).spanRegexSize(f44601a, f);
    }

    public SimpleSpanStringBuilder spanNumSize(float f) {
        return spanRegexSize(f44601a, f);
    }
}
