package com.didi.universal.pay.sdk.util;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleSpanStringBuilder extends SpannableStringBuilder {
    private static final String REGEX_NUM = "([1-9]\\d*\\.\\d*|0\\.\\d*|[0-9]+)";
    private CharSequence content;

    public SimpleSpanStringBuilder(CharSequence charSequence) {
        super(charSequence);
        this.content = charSequence;
    }

    public SimpleSpanStringBuilder(CharSequence charSequence, int i, int i2) {
        super(charSequence, i, i2);
        this.content = charSequence;
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
        Matcher matcher = Pattern.compile(str).matcher(this.content);
        while (matcher.find()) {
            spanColor(i, matcher.start(), matcher.end());
        }
        return this;
    }

    public SimpleSpanStringBuilder spanRegexSize(String str, float f) {
        Matcher matcher = Pattern.compile(str).matcher(this.content);
        while (matcher.find()) {
            spanSize(f, matcher.start(), matcher.end());
        }
        return this;
    }

    public SimpleSpanStringBuilder spanNumsColor(int i) {
        return spanRegexColor(REGEX_NUM, i);
    }

    public SimpleSpanStringBuilder spanNums(int i, float f) {
        return spanRegexColor(REGEX_NUM, i).spanRegexSize(REGEX_NUM, f);
    }

    public SimpleSpanStringBuilder spanNumSize(float f) {
        return spanRegexSize(REGEX_NUM, f);
    }
}
