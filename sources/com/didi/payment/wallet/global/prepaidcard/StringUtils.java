package com.didi.payment.wallet.global.prepaidcard;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/StringUtils;", "", "()V", "BoldFont", "Companion", "DefaultFont", "IFont", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StringUtils.kt */
public final class StringUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/StringUtils$IFont;", "", "handleFont", "", "spannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "start", "", "end", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: StringUtils.kt */
    public interface IFont {
        void handleFont(SpannableStringBuilder spannableStringBuilder, int i, int i2);
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/StringUtils$Companion;", "", "()V", "handleSpecialText", "", "param", "", "font", "Lcom/didi/payment/wallet/global/prepaidcard/StringUtils$IFont;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: StringUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CharSequence handleSpecialText(String str, IFont iFont) {
            Intrinsics.checkNotNullParameter(str, "param");
            Intrinsics.checkNotNullParameter(iFont, "font");
            CharSequence charSequence = str;
            Matcher matcher = Pattern.compile("\\{[^{}]*\\}").matcher(charSequence);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            int i = 1;
            while (matcher.find()) {
                try {
                    String group = matcher.group();
                    int start = matcher.start();
                    int end = matcher.end();
                    Intrinsics.checkNotNullExpressionValue(group, "str");
                    String substring = group.substring(1, group.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    int i2 = (i - 1) * 2;
                    int i3 = start - i2;
                    SpannableStringBuilder delete = spannableStringBuilder.delete(i3, i3 + 1);
                    Intrinsics.checkNotNullExpressionValue(delete, "spannableStringBuilder.d…e(spanStart, spanStart+1)");
                    int i4 = end - (i2 + 1);
                    try {
                        spannableStringBuilder = delete.delete(i4 - 1, i4);
                        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "spannableStringBuilder.delete(spanEnd-1, spanEnd)");
                        iFont.handleFont(spannableStringBuilder, i3, substring.length() + i3);
                        i++;
                    } catch (IndexOutOfBoundsException e) {
                        e = e;
                        spannableStringBuilder = delete;
                        e.printStackTrace();
                        return spannableStringBuilder;
                    }
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                    e.printStackTrace();
                    return spannableStringBuilder;
                }
            }
            return spannableStringBuilder;
        }
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/StringUtils$DefaultFont;", "Lcom/didi/payment/wallet/global/prepaidcard/StringUtils$IFont;", "color", "", "fontSize", "(II)V", "getColor", "()I", "handleFont", "", "spannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "start", "end", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: StringUtils.kt */
    public static final class DefaultFont implements IFont {
        private final int color;
        private final int fontSize;

        public DefaultFont(int i, int i2) {
            this.color = i;
            this.fontSize = i2;
        }

        public final int getColor() {
            return this.color;
        }

        public void handleFont(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            Intrinsics.checkNotNullParameter(spannableStringBuilder, "spannableStringBuilder");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.color), i, i2, 17);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.fontSize, true), i, i2, 17);
        }
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/StringUtils$BoldFont;", "Lcom/didi/payment/wallet/global/prepaidcard/StringUtils$IFont;", "()V", "handleFont", "", "spannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "start", "", "end", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: StringUtils.kt */
    public static final class BoldFont implements IFont {
        public void handleFont(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            Intrinsics.checkNotNullParameter(spannableStringBuilder, "spannableStringBuilder");
            spannableStringBuilder.setSpan(new StyleSpan(1), i, i2, 17);
        }
    }
}
