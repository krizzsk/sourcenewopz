package com.didi.component.evaluate.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import com.didi.component.business.util.HighlightUtil;
import com.didi.global.fintech.cashier.core.ktx.StringKtxKt;
import com.taxis99.R;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewUtil {
    public static boolean isTouchPointInView(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i3;
        int measuredHeight = view.getMeasuredHeight() + i4;
        if (i2 < i4 || i2 > measuredHeight || i < i3 || i > measuredWidth) {
            return false;
        }
        return true;
    }

    public static SpannableStringBuilder handleTipSymbolString(Context context, String str) {
        Matcher matcher = Pattern.compile("\\([^)]*\\)").matcher(str);
        Stack stack = new Stack();
        while (matcher.find()) {
            stack.push(new HighlightUtil.Range(matcher.start(), matcher.end()));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int color = context.getResources().getColor(R.color.oc_color_FF6822);
        while (stack.size() > 0) {
            HighlightUtil.Range range = (HighlightUtil.Range) stack.pop();
            spannableStringBuilder.delete(range.start, range.start + 1);
            spannableStringBuilder.delete(range.end - 2, range.end - 1);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), range.start, range.end - 2, 18);
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder handleTipString(Context context, SpannableStringBuilder spannableStringBuilder) {
        Matcher matcher = Pattern.compile(StringKtxKt.REGULAR_EXPRESSION).matcher(spannableStringBuilder.toString());
        Stack stack = new Stack();
        while (matcher.find()) {
            stack.push(new HighlightUtil.Range(matcher.start(), matcher.end()));
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        int color = context.getResources().getColor(R.color.oc_color_FF6822);
        while (stack.size() > 0) {
            HighlightUtil.Range range = (HighlightUtil.Range) stack.pop();
            spannableStringBuilder2.delete(range.start, range.start + 1);
            spannableStringBuilder2.delete(range.end - 2, range.end - 1);
            spannableStringBuilder2.setSpan(new RelativeSizeSpan(1.2f), range.start, range.end - 2, 18);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(color), range.start, range.end - 2, 18);
        }
        return spannableStringBuilder2;
    }
}
