package com.didi.payment.wallet.global.exts;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0019\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00010\u0001*\u0004\u0018\u00010\b¢\u0006\u0002\u0010\t\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\b2\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003\u001a\u0016\u0010\u000f\u001a\u00020\u000b*\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\rH\u0007\u001a\u0016\u0010\u000f\u001a\u00020\u000b*\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u0003H\u0007\u001a\u001b\u0010\u000f\u001a\u00020\u000b*\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0011\u001a\u001b\u0010\u000f\u001a\u00020\u000b*\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u000f\u001a\u00020\u000b*\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0014\u001a\u001b\u0010\u000f\u001a\u00020\u000b*\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0015\u001a\u0011\u0010\u0016\u001a\u00020\b*\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0018"}, mo175978d2 = {"centToDollarRate", "Ljava/math/BigDecimal;", "ptLocale", "Ljava/util/Locale;", "getPtLocale", "()Ljava/util/Locale;", "centToDollar", "kotlin.jvm.PlatformType", "", "(Ljava/lang/Long;)Ljava/math/BigDecimal;", "centToDollarFormat", "", "format", "Ljava/text/DecimalFormat;", "locale", "currencyFormat", "", "(Ljava/lang/Double;Ljava/text/DecimalFormat;)Ljava/lang/String;", "(Ljava/lang/Double;Ljava/util/Locale;)Ljava/lang/String;", "", "(Ljava/lang/Float;Ljava/text/DecimalFormat;)Ljava/lang/String;", "(Ljava/lang/Float;Ljava/util/Locale;)Ljava/lang/String;", "dollarToCents", "(Ljava/lang/Float;)J", "wallet_globalRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CurrencyExts.kt */
public final class CurrencyUtils {

    /* renamed from: a */
    private static final BigDecimal f31741a;

    /* renamed from: b */
    private static final Locale f31742b = new Locale("pt", "BR");

    static {
        BigDecimal valueOf = BigDecimal.valueOf((long) 100);
        Intrinsics.checkNotNullExpressionValue(valueOf, "BigDecimal.valueOf(this.toLong())");
        f31741a = valueOf;
    }

    public static final Locale getPtLocale() {
        return f31742b;
    }

    public static final BigDecimal centToDollar(Long l) {
        BigDecimal valueOf = BigDecimal.valueOf(l == null ? 0 : l.longValue());
        Intrinsics.checkNotNullExpressionValue(valueOf, "BigDecimal.valueOf(this)");
        return valueOf.divide(f31741a);
    }

    public static final long dollarToCents(Float f) {
        return new BigDecimal(String.valueOf(f == null ? 0.0f : f.floatValue())).multiply(f31741a).longValue();
    }

    public static final String currencyFormat(Float f, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return currencyFormat(f == null ? null : new BigDecimal(String.valueOf(f.floatValue())), locale);
    }

    public static final String currencyFormat(Double d, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return currencyFormat(d == null ? null : new BigDecimal(String.valueOf(d.doubleValue())), locale);
    }

    public static final String currencyFormat(Float f, DecimalFormat decimalFormat) {
        Intrinsics.checkNotNullParameter(decimalFormat, "format");
        return currencyFormat(f == null ? null : new BigDecimal(String.valueOf(f.floatValue())), decimalFormat);
    }

    public static final String currencyFormat(Double d, DecimalFormat decimalFormat) {
        Intrinsics.checkNotNullParameter(decimalFormat, "format");
        return currencyFormat(d == null ? null : new BigDecimal(String.valueOf(d.doubleValue())), decimalFormat);
    }

    public static final String currencyFormat(BigDecimal bigDecimal, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return currencyFormat(bigDecimal, new DecimalFormat("#,##0.00", DecimalFormatSymbols.getInstance(locale)));
    }

    public static final String currencyFormat(BigDecimal bigDecimal, DecimalFormat decimalFormat) {
        Intrinsics.checkNotNullParameter(decimalFormat, "format");
        Object obj = bigDecimal;
        if (bigDecimal == null) {
            obj = Double.valueOf(0.0d);
        }
        String format = decimalFormat.format(obj);
        Intrinsics.checkNotNullExpressionValue(format, "format.format(this?:0.0)");
        return format;
    }

    public static final String centToDollarFormat(long j, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return currencyFormat(centToDollar(Long.valueOf(j)), locale);
    }

    public static final String centToDollarFormat(long j, DecimalFormat decimalFormat) {
        Intrinsics.checkNotNullParameter(decimalFormat, "format");
        return currencyFormat(centToDollar(Long.valueOf(j)), decimalFormat);
    }
}
