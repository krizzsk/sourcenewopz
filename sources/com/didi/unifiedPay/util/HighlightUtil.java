package com.didi.unifiedPay.util;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HighlightUtil {

    /* renamed from: a */
    private static final String f44598a = "\\{[^}]*\\}";

    public static CharSequence highlight(String str) {
        Matcher matcher = Pattern.compile("\\{[^}]*\\}").matcher(str);
        Stack stack = new Stack();
        while (matcher.find()) {
            stack.push(new Range(matcher.start(), matcher.end()));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int parseColor = Color.parseColor("#FC9153");
        while (stack.size() > 0) {
            Range range = (Range) stack.pop();
            spannableStringBuilder.delete(range.start, range.start + 1);
            spannableStringBuilder.delete(range.end - 2, range.end - 1);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), range.start, range.end - 2, 18);
        }
        return spannableStringBuilder;
    }

    public static CharSequence highlight(String str, int i, int i2) {
        Matcher matcher = Pattern.compile("\\{[^}]*\\}").matcher(str);
        Stack stack = new Stack();
        while (matcher.find()) {
            stack.push(new Range(matcher.start(), matcher.end()));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (stack.size() > 0) {
            Range range = (Range) stack.pop();
            spannableStringBuilder.delete(range.start, range.start + 1);
            spannableStringBuilder.delete(range.end - 2, range.end - 1);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), range.start, range.end - 2, 18);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, range.start, 18);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), range.end - 2, spannableStringBuilder.length(), 18);
        }
        return spannableStringBuilder;
    }

    public static CharSequence highlight(String str, int i, int i2, int i3, boolean z) {
        Matcher matcher = Pattern.compile("\\{[^}]*\\}").matcher(str);
        Stack stack = new Stack();
        while (matcher.find()) {
            stack.push(new Range(matcher.start(), matcher.end()));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        while (stack.size() > 0) {
            Range range = (Range) stack.pop();
            spannableStringBuilder.delete(range.start, range.start + 1);
            spannableStringBuilder.delete(range.end - 2, range.end - 1);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), range.start, range.end - 2, 18);
            if (i3 > 0) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i3, true), range.start, range.end - 2, 33);
            }
            if (z) {
                spannableStringBuilder.setSpan(new StyleSpan(1), range.start, range.end - 2, 33);
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, range.start, 18);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), range.end - 2, spannableStringBuilder.length(), 18);
        }
        return spannableStringBuilder;
    }

    static class Range {
        public final int end;
        public final int start;

        public Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }
    }
}
