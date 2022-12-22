package com.didi.foundation.sdk.service;

import android.content.Context;
import com.didi.foundation.sdk.mlocale.DateStyle;
import com.didi.foundation.sdk.mlocale.DistanceStyle;
import com.didi.foundation.sdk.mlocale.TimeStyle;
import com.didi.foundation.sdk.utils.EnumTransfer;
import com.didi.foundation.sdk.utils.LocaleUtils;
import com.didi.foundation.sdk.utils.LogUtils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.util.DateTimeUtils;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@ServiceProvider({LocalizationServiceProvider.class})
@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u000bJ3\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u000eJ3\u0010\t\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u000bJ,\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0016J(\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010 \u001a\u00020\u00042\u0006\u0010\n\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0014H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0016J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0006H\u0016J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0006H\u0016J,\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u00042\b\u00102\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u00103\u001a\u0004\u0018\u00010!2\u0006\u00104\u001a\u00020\u0004H\u0016J\u001c\u00105\u001a\u0004\u0018\u00010!2\u0006\u00104\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010!H\u0016J\u0018\u00107\u001a\b\u0012\u0004\u0012\u00020\u0004082\b\u0010\n\u001a\u0004\u0018\u00010!H\u0016J\"\u00107\u001a\b\u0012\u0004\u0012\u00020\u0004082\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J&\u00109\u001a\b\u0012\u0004\u0012\u00020\u0004082\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010:\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u0006H\u0002J,\u0010;\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u00042\b\u00102\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006<"}, mo175978d2 = {"Lcom/didi/foundation/sdk/service/LocalizationServiceImpl;", "Lcom/didi/foundation/sdk/service/LocalizationServiceProvider;", "()V", "formatCountdownTime", "", "countSeconds", "", "isHighlight", "", "formatCurrency", "number", "(ILjava/lang/Boolean;)Ljava/lang/String;", "currencyAcronym", "localeString", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/String;", "countryCode", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;)Ljava/lang/String;", "formatCurrencyNoDeal", "formatDateTime", "secondsTimeStamp", "", "dateStyle", "Lcom/didi/foundation/sdk/mlocale/DateStyle;", "timeStyle", "Lcom/didi/foundation/sdk/mlocale/TimeStyle;", "trans2Local", "formatDistance", "meter", "", "distanceStyle", "Lcom/didi/foundation/sdk/mlocale/DistanceStyle;", "precision", "formatNumber", "", "decimalCount", "numberType", "getDateTimeCalendar", "Ljava/util/Calendar;", "timeInMillis", "getNumberPrecision", "getShortWeekDayByCalendarIndex", "locale", "dayOfWeek", "getShortWeekDayByIndex", "index", "init", "", "context", "Landroid/content/Context;", "countryId", "cityId", "parseNumber", "numberStr", "parseNumberSafety", "defaultResult", "splitCurrency", "", "splitDistance", "transNumber", "updateInit", "global-foundation-sdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: LocalizationServiceImpl.kt */
public final class LocalizationServiceImpl implements LocalizationServiceProvider {
    public void init(Context context, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "locale");
        CharSequence charSequence = str2;
        if (charSequence == null || charSequence.length() == 0) {
            String localeToTag = LocaleUtils.localeToTag(LocaleUtils.defaultConfigLocale);
            Intrinsics.checkExpressionValueIsNotNull(localeToTag, "LocaleUtils.localeToTag(…tils.defaultConfigLocale)");
            str2 = (String) CollectionsKt.last(StringsKt.split$default((CharSequence) localeToTag, new String[]{"-"}, false, 0, 6, (Object) null));
        }
        String str4 = str2;
        if (str3 == null) {
            str3 = "";
        }
        try {
            Elvish.Companion.init(context, str, LocaleUtils.localeToTag(LocaleUtils.defaultConfigLocale), str4, str3);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils logUtils = LogUtils.INSTANCE;
            logUtils.mo63518d("locale is null:" + e.getMessage());
        }
    }

    public void updateInit(Context context, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "locale");
        CharSequence charSequence = str2;
        if (charSequence == null || charSequence.length() == 0) {
            String localeToTag = LocaleUtils.localeToTag(LocaleUtils.defaultConfigLocale);
            Intrinsics.checkExpressionValueIsNotNull(localeToTag, "LocaleUtils.localeToTag(…tils.defaultConfigLocale)");
            str2 = (String) CollectionsKt.last(StringsKt.split$default((CharSequence) localeToTag, new String[]{"-"}, false, 0, 6, (Object) null));
        }
        String str4 = str2;
        if (str3 == null) {
            str3 = "";
        }
        try {
            Elvish.Companion.init(context, str, LocaleUtils.localeToTag(LocaleUtils.defaultConfigLocale), str4, str3);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils logUtils = LogUtils.INSTANCE;
            logUtils.mo63518d("locale is null:" + e.getMessage());
        }
    }

    /* renamed from: a */
    private final double m15667a(int i) {
        BigDecimal divide = new BigDecimal(Math.abs(i)).divide(new BigDecimal(100), 2, 1);
        Intrinsics.checkExpressionValueIsNotNull(divide, "money.divide(scale, 2, BigDecimal.ROUND_DOWN)");
        return divide.doubleValue();
    }

    public String formatCurrency(int i, Boolean bool) {
        String formatCurrency = Elvish.Companion.getInstance().formatCurrency(Double.valueOf(m15667a(i)), bool != null ? bool.booleanValue() : false);
        if (StringsKt.contains$default((CharSequence) formatCurrency, (CharSequence) "MXN$", false, 2, (Object) null)) {
            formatCurrency = StringsKt.replace$default(formatCurrency, "MXN", "MX", false, 4, (Object) null);
        }
        String str = formatCurrency;
        CharSequence charSequence = str;
        return (StringsKt.contains$default(charSequence, (CharSequence) "MX$", false, 2, (Object) null) || !StringsKt.contains$default(charSequence, (CharSequence) "MX", false, 2, (Object) null)) ? str : StringsKt.replace$default(str, "MX", "MX$", false, 4, (Object) null);
    }

    public String formatCurrency(int i, String str, String str2, Boolean bool) {
        String formatCurrency = Elvish.Companion.getInstance().formatCurrency(Double.valueOf(m15667a(i)), str, str2, bool != null ? bool.booleanValue() : false);
        if (StringsKt.contains$default((CharSequence) formatCurrency, (CharSequence) "MXN$", false, 2, (Object) null)) {
            formatCurrency = StringsKt.replace$default(formatCurrency, "MXN", "MX", false, 4, (Object) null);
        }
        String str3 = formatCurrency;
        CharSequence charSequence = str3;
        return (StringsKt.contains$default(charSequence, (CharSequence) "MX$", false, 2, (Object) null) || !StringsKt.contains$default(charSequence, (CharSequence) "MX", false, 2, (Object) null)) ? str3 : StringsKt.replace$default(str3, "MX", "MX$", false, 4, (Object) null);
    }

    public String formatCurrency(String str, String str2, int i, Boolean bool) {
        String formatCurrency = Elvish.Companion.getInstance().formatCurrency(str, str2, Double.valueOf(m15667a(i)), bool != null ? bool.booleanValue() : false);
        if (StringsKt.contains$default((CharSequence) formatCurrency, (CharSequence) "MXN$", false, 2, (Object) null)) {
            formatCurrency = StringsKt.replace$default(formatCurrency, "MXN", "MX", false, 4, (Object) null);
        }
        String str3 = formatCurrency;
        CharSequence charSequence = str3;
        return (StringsKt.contains$default(charSequence, (CharSequence) "MX$", false, 2, (Object) null) || !StringsKt.contains$default(charSequence, (CharSequence) "MX", false, 2, (Object) null)) ? str3 : StringsKt.replace$default(str3, "MX", "MX$", false, 4, (Object) null);
    }

    public String formatCurrencyNoDeal(int i, Boolean bool) {
        return Elvish.Companion.getInstance().formatCurrency(Double.valueOf(m15667a(i)), bool != null ? bool.booleanValue() : false);
    }

    public String formatDateTime(long j, DateStyle dateStyle, TimeStyle timeStyle, boolean z) {
        if (dateStyle == null) {
            dateStyle = DateStyle.NONE;
        }
        if (timeStyle == null) {
            timeStyle = TimeStyle.NONE;
        }
        return Elvish.Companion.getInstance().formatDateTime(j, EnumTransfer.INSTANCE.getDateEnumByValue(dateStyle.getStyle()), EnumTransfer.INSTANCE.getTimeEnumByValue(timeStyle.getStyle()), z);
    }

    public String formatCountdownTime(int i, boolean z) {
        return Elvish.Companion.getInstance().formatCountdownTime(i, z);
    }

    public Calendar getDateTimeCalendar(long j) {
        return Elvish.Companion.getInstance().getDateTimeCalendar(j);
    }

    public String getShortWeekDayByIndex(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "locale");
        return Elvish.Companion.getInstance().getShortWeekDayByIndex(str, i);
    }

    public String getShortWeekDayByCalendarIndex(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "locale");
        return getShortWeekDayByIndex(str, DateTimeUtils.INSTANCE.calendarDayOfWeek2Index(i));
    }

    public String formatDistance(double d, DistanceStyle distanceStyle, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(distanceStyle, "distanceStyle");
        return Elvish.Companion.getInstance().formatDistance(d, EnumTransfer.INSTANCE.getDistanceStyleEnumByValue(distanceStyle.getStyle()), i, z);
    }

    public List<String> splitDistance(double d, DistanceStyle distanceStyle, int i) {
        Intrinsics.checkParameterIsNotNull(distanceStyle, "distanceStyle");
        return Elvish.Companion.getInstance().splitDistance(d, EnumTransfer.INSTANCE.getDistanceStyleEnumByValue(distanceStyle.getStyle()), i);
    }

    public String formatNumber(Number number, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(number, "number");
        return Elvish.Companion.getInstance().formatNumber(number, i, i2);
    }

    public Number parseNumber(String str) throws ParseException {
        Intrinsics.checkParameterIsNotNull(str, "numberStr");
        return Elvish.Companion.getInstance().parseNumber(str);
    }

    public Number parseNumberSafety(String str, Number number) {
        Intrinsics.checkParameterIsNotNull(str, "numberStr");
        return Elvish.Companion.getInstance().parseNumberSafety(str, number);
    }

    public int getNumberPrecision(int i) {
        return Elvish.Companion.getInstance().getNumberPrecision(i);
    }

    public List<String> splitCurrency(Number number) {
        return Elvish.Companion.getInstance().splitCurrency(number);
    }

    public List<String> splitCurrency(String str, String str2) {
        String str3;
        String formatCurrency = Elvish.Companion.getInstance().formatCurrency((Number) 1, str, str2, true);
        Pattern compile = Pattern.compile("\\{.*\\}");
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(regex)");
        Matcher matcher = compile.matcher(formatCurrency);
        Intrinsics.checkExpressionValueIsNotNull(matcher, "compile.matcher(ret)");
        if (matcher.find()) {
            str3 = matcher.group();
            Intrinsics.checkExpressionValueIsNotNull(str3, "matcher.group()");
        } else {
            str3 = "";
        }
        String str4 = str3;
        int length = str4.length() - 1;
        if (str4 != null) {
            String substring = str4.substring(1, length);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String replace$default = StringsKt.replace$default(formatCurrency, str4, "", false, 4, (Object) null);
            if (replace$default != null) {
                String obj = StringsKt.trim(replace$default).toString();
                if (StringsKt.contains$default((CharSequence) obj, (CharSequence) "MXN$", false, 2, (Object) null)) {
                    obj = StringsKt.replace$default(obj, "MXN", "MX", false, 4, (Object) null);
                }
                String str5 = obj;
                CharSequence charSequence = str5;
                if (!StringsKt.contains$default(charSequence, (CharSequence) "MX$", false, 2, (Object) null) && StringsKt.contains$default(charSequence, (CharSequence) "MX", false, 2, (Object) null)) {
                    str5 = StringsKt.replace$default(str5, "MX", "MX$", false, 4, (Object) null);
                }
                return CollectionsKt.listOf(substring, str5);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
