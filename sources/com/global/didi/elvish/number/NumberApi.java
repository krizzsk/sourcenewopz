package com.global.didi.elvish.number;

import android.content.Context;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.LocationInfo;
import com.global.didi.elvish.number.model.NumberModel;
import com.global.didi.elvish.util.LocaleUtilsKt;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\bJ!\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/global/didi/elvish/number/NumberApi;", "", "context", "Landroid/content/Context;", "locationInfo", "Lcom/global/didi/elvish/LocationInfo;", "(Landroid/content/Context;Lcom/global/didi/elvish/LocationInfo;)V", "format", "", "number", "", "decimalCount", "", "numberType", "getDecimalCountByType", "type", "model", "Lcom/global/didi/elvish/number/model/NumberModel;", "getFormat", "Ljava/text/NumberFormat;", "locale", "Ljava/util/Locale;", "onInit", "", "parse", "numberStr", "isParseBigDecimal", "", "(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Number;", "Companion", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: NumberApi.kt */
public final class NumberApi {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static volatile Map<String, Map<String, Object>> f52580b;

    /* renamed from: a */
    private LocationInfo f52581a;

    public NumberApi(Context context, LocationInfo locationInfo) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(locationInfo, "locationInfo");
        this.f52581a = locationInfo;
        m37313a();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0006\u0018\u00010\u0004H\u0002R(\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0006\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/global/didi/elvish/number/NumberApi$Companion;", "", "()V", "sNumberMap", "", "", "", "loadData", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: NumberApi.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Map<String, Map<String, Object>> loadData() {
            return TypeIntrinsics.asMutableMap(Elvish.Companion.getLocalCustomRuleConf().get("numberV2"));
        }
    }

    /* renamed from: a */
    private final void m37313a() {
        Map<String, Map<String, Object>> map = f52580b;
        if (map == null || map.isEmpty()) {
            f52580b = Companion.loadData();
        }
    }

    /* renamed from: a */
    private final NumberFormat m37312a(Locale locale, NumberModel numberModel) {
        NumberFormat instance = locale == null ? NumberFormat.getInstance() : NumberFormat.getInstance(locale);
        Intrinsics.checkExpressionValueIsNotNull(instance, "format");
        instance.setRoundingMode(RoundingMode.HALF_EVEN);
        if (instance instanceof DecimalFormat) {
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(locale);
            boolean z = true;
            if (numberModel.getDecimal().length() > 0) {
                decimalFormatSymbols.setDecimalSeparator(numberModel.getDecimal().charAt(0));
                decimalFormatSymbols.setMonetaryDecimalSeparator(numberModel.getDecimal().charAt(0));
            }
            if (numberModel.getGroup().length() <= 0) {
                z = false;
            }
            if (z) {
                decimalFormatSymbols.setGroupingSeparator(numberModel.getGroup().charAt(0));
            }
            decimalFormatSymbols.setZeroDigit('0');
            ((DecimalFormat) instance).setDecimalFormatSymbols(decimalFormatSymbols);
        }
        return instance;
    }

    public final String format(Number number, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(number, "number");
        m37313a();
        String localeString = this.f52581a.getLocaleString();
        Locale string2Locale = LocaleUtilsKt.string2Locale(localeString);
        Map<String, Map<String, Object>> map = f52580b;
        Map map2 = map != null ? map.get(localeString) : null;
        NumberModel numberModel = new NumberModel((String) null, (String) null, (Map) null, 7, (DefaultConstructorMarker) null);
        numberModel.parse(map2);
        NumberFormat a = m37312a(string2Locale, numberModel);
        if (i >= 0) {
            a.setMinimumFractionDigits(i);
            a.setMaximumFractionDigits(i);
        } else {
            int a2 = m37311a(i2, numberModel);
            if (a2 >= 0) {
                a.setMinimumFractionDigits(a2);
                a.setMaximumFractionDigits(a2);
            } else {
                a.setMinimumFractionDigits(0);
                a.setMaximumFractionDigits(Integer.MAX_VALUE);
            }
        }
        String format = a.format(number);
        Intrinsics.checkExpressionValueIsNotNull(format, "format.format(number)");
        return format;
    }

    public final Number parse(String str) {
        Intrinsics.checkParameterIsNotNull(str, "numberStr");
        m37313a();
        String localeString = this.f52581a.getLocaleString();
        Locale string2Locale = LocaleUtilsKt.string2Locale(localeString);
        Map<String, Map<String, Object>> map = f52580b;
        Map map2 = map != null ? map.get(localeString) : null;
        NumberModel numberModel = new NumberModel((String) null, (String) null, (Map) null, 7, (DefaultConstructorMarker) null);
        numberModel.parse(map2);
        return m37312a(string2Locale, numberModel).parse(str);
    }

    public static /* synthetic */ Number parse$default(NumberApi numberApi, String str, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = false;
        }
        return numberApi.parse(str, bool);
    }

    public final Number parse(String str, Boolean bool) {
        Intrinsics.checkParameterIsNotNull(str, "numberStr");
        m37313a();
        String localeString = this.f52581a.getLocaleString();
        Locale string2Locale = LocaleUtilsKt.string2Locale(localeString);
        Map<String, Map<String, Object>> map = f52580b;
        Map map2 = map != null ? map.get(localeString) : null;
        NumberModel numberModel = new NumberModel((String) null, (String) null, (Map) null, 7, (DefaultConstructorMarker) null);
        numberModel.parse(map2);
        NumberFormat a = m37312a(string2Locale, numberModel);
        if ((a instanceof DecimalFormat) && Intrinsics.areEqual((Object) bool, (Object) true)) {
            ((DecimalFormat) a).setParseBigDecimal(true);
        }
        return a.parse(str);
    }

    public final int getDecimalCountByType(int i) {
        NumberModel numberModel = new NumberModel((String) null, (String) null, (Map) null, 7, (DefaultConstructorMarker) null);
        Map<String, Map<String, Object>> map = f52580b;
        numberModel.parse(map != null ? map.get(this.f52581a.getLocaleString()) : null);
        return m37311a(i, numberModel);
    }

    /* renamed from: a */
    private final int m37311a(int i, NumberModel numberModel) {
        Integer num;
        if (i == 1 && (num = numberModel.getPrecision().get("currency")) != null) {
            return num.intValue();
        }
        return -1;
    }
}
