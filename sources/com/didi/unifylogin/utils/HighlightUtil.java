package com.didi.unifylogin.utils;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HighlightUtil {

    /* renamed from: a */
    private static final String f44918a = "\\{[^}]*\\}";

    public static SpannableStringBuilder highlight(CharSequence charSequence) {
        return highlight(charSequence, LoginPreferredConfig.getThemeColor(), false);
    }

    public static SpannableStringBuilder highlight(int i, CharSequence charSequence) {
        return highlight(charSequence, i, false);
    }

    public static SpannableStringBuilder highlight(CharSequence charSequence, int i, boolean z) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\{[^}]*\\}").matcher(charSequence);
        Stack stack = new Stack();
        while (matcher.find()) {
            stack.push(new Range(matcher.start(), matcher.end()));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        while (stack.size() > 0) {
            Range range = (Range) stack.pop();
            spannableStringBuilder.delete(range.start, range.start + 1);
            spannableStringBuilder.delete(range.end - 2, range.end - 1);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), range.start, range.end - 2, 18);
            if (z) {
                spannableStringBuilder.setSpan(new StyleSpan(1), range.start, range.end - 2, 34);
            }
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder highlight(SpannableStringBuilder spannableStringBuilder, int i, int i2, boolean z) {
        return highlight("\\{[^}]*\\}", spannableStringBuilder, i, i2, z);
    }

    public static SpannableStringBuilder highlight(String str, SpannableStringBuilder spannableStringBuilder, int i, int i2, boolean z) {
        if (TextUtils.isEmpty(spannableStringBuilder) || TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile(str).matcher(spannableStringBuilder);
        Stack stack = new Stack();
        while (matcher.find()) {
            stack.push(new Range(matcher.start(), matcher.end()));
        }
        while (stack.size() > 0) {
            Range range = (Range) stack.pop();
            spannableStringBuilder.delete(range.start, range.start + 1);
            spannableStringBuilder.delete(range.end - 2, range.end - 1);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), range.start, range.end - 2, 18);
            if (i2 > 0) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i2), range.start, range.end - 2, 34);
            }
            if (z) {
                spannableStringBuilder.setSpan(new StyleSpan(1), range.start, range.end - 2, 34);
            }
        }
        return spannableStringBuilder;
    }

    public static CharSequence highlight(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
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

    public static void changeColor(TextView textView, int[] iArr, int[] iArr2, int[] iArr3, int i) {
        SpannableString spannableString = new SpannableString(textView.getText());
        int i2 = 0;
        while (i2 < iArr2.length) {
            if (spannableString.length() >= iArr3[i2]) {
                spannableString.setSpan(new ForegroundColorSpan(iArr[i2]), iArr2[i2], iArr3[i2], i);
                i2++;
            } else {
                return;
            }
        }
        textView.setText(spannableString);
    }

    public static void changeColor(TextView textView, String str, int... iArr) {
        changeColor(textView, str, Const.joLeft, "}", iArr);
    }

    public static void changeColor(TextView textView, String str, String str2, String str3, int... iArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i);
            if (indexOf <= -1) {
                break;
            }
            int i3 = i2 * 2;
            arrayList.add(Integer.valueOf(indexOf - i3));
            i = str.indexOf(str3, indexOf + 1);
            arrayList2.add(Integer.valueOf(i - (i3 + 1)));
            i2++;
        }
        textView.setText(str.replace(str2, "").replace(str3, ""));
        if (iArr != null && iArr.length != 0 && arrayList.size() > 0 && arrayList.size() == arrayList2.size()) {
            int size = arrayList.size();
            int[] iArr2 = new int[size];
            int[] iArr3 = new int[size];
            int[] iArr4 = new int[size];
            int i4 = 0;
            while (i4 < size) {
                iArr2[i4] = iArr.length + -1 < i4 ? iArr[0] : iArr[i4];
                iArr3[i4] = ((Integer) arrayList.get(i4)).intValue();
                iArr4[i4] = ((Integer) arrayList2.get(i4)).intValue();
                i4++;
            }
            changeColor(textView, iArr2, iArr3, iArr4, 33);
        }
    }

    public static class Range {
        public final int end;
        public final int start;

        public Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }
    }
}
