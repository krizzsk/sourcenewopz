package com.didi.global.fintech.cashier.core.ktx;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import com.taxis99.R;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u001a\u001a\u0010\u0002\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"REGULAR_EXPRESSION", "", "highlight", "Landroid/text/SpannableStringBuilder;", "", "context", "Landroid/content/Context;", "colorResId", "", "bold", "", "onClick", "Lcom/didi/global/fintech/cashier/core/ktx/TextClickCallback;", "cashier_core_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StringKtx.kt */
public final class StringKtxKt {
    public static final String REGULAR_EXPRESSION = "\\{[^}]*\\}";

    public static final CharSequence highlight(String str, Context context, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        Matcher matcher = Pattern.compile(REGULAR_EXPRESSION).matcher(charSequence);
        Stack stack = new Stack();
        while (matcher.find()) {
            stack.push(new Range(matcher.start(), matcher.end()));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.global_cashier_theme_text_color, typedValue, true);
        int color = i > 0 ? ContextCompat.getColor(context, i) : typedValue.data;
        while (stack.size() > 0) {
            Range range = (Range) stack.pop();
            spannableStringBuilder.delete(range.getStart(), range.getStart() + 1);
            spannableStringBuilder.delete(range.getEnd() - 2, range.getEnd() - 1);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), range.getStart(), range.getEnd() - 2, 18);
        }
        return spannableStringBuilder;
    }

    public static /* synthetic */ SpannableStringBuilder highlight$default(CharSequence charSequence, Context context, int i, boolean z, TextClickCallback textClickCallback, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            textClickCallback = null;
        }
        return highlight(charSequence, context, i, z, textClickCallback);
    }

    public static final SpannableStringBuilder highlight(CharSequence charSequence, Context context, int i, boolean z, TextClickCallback textClickCallback) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        Matcher matcher = Pattern.compile(REGULAR_EXPRESSION).matcher(charSequence);
        Stack stack = new Stack();
        while (matcher.find()) {
            stack.push(new Range(matcher.start(), matcher.end()));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.global_cashier_theme_text_color, typedValue, true);
        int color = i > 0 ? ContextCompat.getColor(context, i) : typedValue.data;
        while (stack.size() > 0) {
            Range range = (Range) stack.pop();
            spannableStringBuilder.delete(range.getStart(), range.getStart() + 1);
            spannableStringBuilder.delete(range.getEnd() - 2, range.getEnd() - 1);
            if (textClickCallback == null) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(color), range.getStart(), range.getEnd() - 2, 18);
            } else {
                spannableStringBuilder.setSpan(new StringKtxKt$highlight$1(textClickCallback, stack.size()), range.getStart(), range.getEnd() - 2, 34);
                spannableStringBuilder.setSpan(new StringKtxKt$highlight$2(color), range.getStart(), range.getEnd() - 2, 18);
            }
            if (z) {
                spannableStringBuilder.setSpan(new StyleSpan(1), range.getStart(), range.getEnd() - 2, 34);
            }
        }
        return spannableStringBuilder;
    }
}
