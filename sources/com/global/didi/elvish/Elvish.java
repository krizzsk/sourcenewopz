package com.global.didi.elvish;

import android.content.Context;
import com.didi.sdk.elvish.ElvishInit;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.global.didi.elvish.base.BaseDataLoader;
import com.global.didi.elvish.currency.CurrencyApi;
import com.global.didi.elvish.datetime.DateTimeApi;
import com.global.didi.elvish.distance.DistanceApi;
import com.global.didi.elvish.language.LanguageModel;
import com.global.didi.elvish.number.NumberApi;
import com.global.didi.elvish.util.DateTimeUtils;
import com.global.didi.elvish.util.LogUtils;
import java.text.ParseException;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0011\u001a\u00020\u0012J.\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J.\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0011\u001a\u00020\u0012J0\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u0012J(\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010'\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001bJ\"\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0010H\u0002J\u0006\u00101\u001a\u00020\u000eJ\u0006\u00102\u001a\u00020\u000eJ\u001e\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010.\u001a\u0002072\u0006\u00108\u001a\u00020\u0012J&\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u0012J&\u0010;\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010.\u001a\u0002072\u0006\u00108\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u000eJ.\u0010;\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u000eJ\u000e\u0010=\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010J\u0018\u0010>\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u0010J\u0018\u0010@\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u0010J.\u0010A\u001a\u00020B2\u0006\u00105\u001a\u0002062\u0006\u0010.\u001a\u00020\u000e2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u000eJ:\u0010A\u001a\u00020B2\u0006\u00105\u001a\u0002062\u0006\u0010.\u001a\u00020\u000e2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u000eJ\u001c\u0010E\u001a\u0004\u0018\u00010\u00152\u0006\u0010F\u001a\u00020\u000e2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0015J\u0010\u0010H\u001a\u0004\u0018\u00010\u00152\u0006\u0010F\u001a\u00020\u000eJ\u001c\u0010I\u001a\u0004\u0018\u00010\u00152\u0006\u0010F\u001a\u00020\u000e2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0015J\u000e\u0010J\u001a\u00020B2\u0006\u0010K\u001a\u00020\u0012J\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000e0M2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J&\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000e0M2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006P"}, mo175978d2 = {"Lcom/global/didi/elvish/Elvish;", "", "()V", "currencyApi", "Lcom/global/didi/elvish/currency/CurrencyApi;", "dateTimeApi", "Lcom/global/didi/elvish/datetime/DateTimeApi;", "distanceApi", "Lcom/global/didi/elvish/distance/DistanceApi;", "mLocationInfo", "Lcom/global/didi/elvish/LocationInfo;", "mNumberApi", "Lcom/global/didi/elvish/number/NumberApi;", "formatCountdownTime", "", "seconds", "", "isHighlight", "", "formatCurrency", "number", "", "currencyAcronym", "localeString", "countryCode", "formatDateTime", "secondsTimeStamp", "", "dateStyle", "Lcom/global/didi/elvish/DateStyle;", "timeStyle", "Lcom/global/didi/elvish/TimeStyle;", "trans2Local", "formatDistance", "meter", "", "distanceStyle", "Lcom/global/didi/elvish/DistanceStyle;", "precision", "formatNumber", "decimalCount", "numberType", "getDateTimeCalendar", "Ljava/util/Calendar;", "timeInMillis", "getDayOfWeekDisplay", "locale", "index", "style", "getDecimalSymbol", "getGroupSymbol", "getLanguageAndLocale", "Lcom/global/didi/elvish/language/LanguageModel;", "context", "Landroid/content/Context;", "Ljava/util/Locale;", "isGlobal", "language", "country", "getLanguageAndLocaleByJson", "config", "getNumberPrecision", "getShortWeekDayByCalendarIndex", "dayOfWeek", "getShortWeekDayByIndex", "init", "", "cityId", "initLocal", "parseBigDecimalSafely", "numberStr", "defaultResult", "parseNumber", "parseNumberSafety", "setLoggerOutput", "output", "splitCurrency", "", "splitDistance", "Companion", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: Elvish.kt */
public final class Elvish {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String f52538f = "es-419";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final String f52539g = f52539g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static Map<String, Object> f52540h = new LinkedHashMap();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static Elvish f52541i = new Elvish();

    /* renamed from: a */
    private LocationInfo f52542a;

    /* renamed from: b */
    private CurrencyApi f52543b;

    /* renamed from: c */
    private DateTimeApi f52544c;

    /* renamed from: d */
    private DistanceApi f52545d;

    /* renamed from: e */
    private NumberApi f52546e;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0004J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019J.\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006J:\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, mo175978d2 = {"Lcom/global/didi/elvish/Elvish$Companion;", "", "()V", "INSTANCE", "Lcom/global/didi/elvish/Elvish;", "LOCAL_ES_419_1", "", "getLOCAL_ES_419_1", "()Ljava/lang/String;", "LOCAL_ES_419_2", "getLOCAL_ES_419_2", "localCustomRuleConf", "", "getLocalCustomRuleConf", "()Ljava/util/Map;", "setLocalCustomRuleConf", "(Ljava/util/Map;)V", "getInstance", "getLanguageAndLocale", "Lcom/global/didi/elvish/language/LanguageModel;", "context", "Landroid/content/Context;", "language", "country", "isGlobal", "", "init", "", "locale", "cityId", "initLocal", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: Elvish.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getLOCAL_ES_419_1() {
            return Elvish.f52538f;
        }

        public final String getLOCAL_ES_419_2() {
            return Elvish.f52539g;
        }

        public final Map<String, Object> getLocalCustomRuleConf() {
            return Elvish.f52540h;
        }

        public final void setLocalCustomRuleConf(Map<String, Object> map) {
            Intrinsics.checkParameterIsNotNull(map, "<set-?>");
            Elvish.f52540h = map;
        }

        public static /* synthetic */ void init$default(Companion companion, Context context, String str, String str2, String str3, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = "";
            }
            if ((i & 8) != 0) {
                str3 = "";
            }
            companion.init(context, str, str2, str3);
        }

        public final void init(Context context, String str, String str2, String str3) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(str, "locale");
            init(context, str, str, str2, str3);
        }

        public static /* synthetic */ void init$default(Companion companion, Context context, String str, String str2, String str3, String str4, int i, Object obj) {
            companion.init(context, str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4);
        }

        public final void init(Context context, String str, String str2, String str3, String str4) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(str, "locale");
            Companion companion = this;
            if (Intrinsics.areEqual((Object) companion.getLOCAL_ES_419_1(), (Object) str) || Intrinsics.areEqual((Object) companion.getLOCAL_ES_419_2(), (Object) str)) {
                OmegaSDKAdapter.trackEvent("tech_elvish_es_419");
            }
            Elvish.f52541i.init(context, str, str2, str3, str4);
        }

        public final Elvish getInstance() {
            ElvishInit.before();
            return Elvish.f52541i;
        }

        public final LanguageModel getLanguageAndLocale(Context context, String str, String str2, boolean z) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(str, "language");
            Intrinsics.checkParameterIsNotNull(str2, "country");
            return new BaseDataLoader().loadLanguageConfig(context, str, str2, z);
        }
    }

    private Elvish() {
    }

    public static /* synthetic */ void init$default(Elvish elvish, Context context, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        if ((i & 8) != 0) {
            str3 = "";
        }
        elvish.init(context, str, str2, str3);
    }

    public final void init(Context context, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "locale");
        init(context, str, str, str2, str3);
    }

    public static /* synthetic */ void init$default(Elvish elvish, Context context, String str, String str2, String str3, String str4, int i, Object obj) {
        elvish.init(context, str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4);
    }

    public final void init(Context context, String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "locale");
        if (!(str.length() == 0)) {
            if (str2 == null) {
                str2 = "";
            }
            if (str3 == null) {
                str3 = "";
            }
            if (str4 == null) {
                str4 = "";
            }
            LocationInfo locationInfo = new LocationInfo(str, str2, str3, str4);
            if (f52540h.isEmpty()) {
                f52540h = new BaseDataLoader().localCustomRuleConfData(context);
            }
            this.f52542a = locationInfo;
            this.f52546e = new NumberApi(context, locationInfo);
            this.f52543b = new CurrencyApi(context, locationInfo);
            this.f52544c = new DateTimeApi(context, locationInfo);
            this.f52545d = new DistanceApi(context, locationInfo);
            return;
        }
        throw new Exception("Locale is empty!");
    }

    public final void setLoggerOutput(boolean z) {
        LogUtils.INSTANCE.setOutput(z);
    }

    public static /* synthetic */ String formatCurrency$default(Elvish elvish, Number number, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return elvish.formatCurrency(number, z);
    }

    public final String formatCurrency(Number number, boolean z) {
        CurrencyApi currencyApi = this.f52543b;
        if (currencyApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currencyApi");
        }
        return currencyApi.formatCurrency(number, z);
    }

    public static /* synthetic */ String formatCurrency$default(Elvish elvish, Number number, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return elvish.formatCurrency(number, str, str2, z);
    }

    public final String formatCurrency(Number number, String str, String str2, boolean z) {
        CurrencyApi currencyApi = this.f52543b;
        if (currencyApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currencyApi");
        }
        return currencyApi.formatCurrency(number, z, str, str2);
    }

    public static /* synthetic */ String formatCurrency$default(Elvish elvish, String str, String str2, Number number, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return elvish.formatCurrency(str, str2, number, z);
    }

    public final String formatCurrency(String str, String str2, Number number, boolean z) {
        CurrencyApi currencyApi = this.f52543b;
        if (currencyApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currencyApi");
        }
        return currencyApi.formatCurrency(str, str2, number, z);
    }

    public final List<String> splitCurrency(Number number) {
        CurrencyApi currencyApi = this.f52543b;
        if (currencyApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currencyApi");
        }
        return currencyApi.splitCurrency(number);
    }

    public final String getDecimalSymbol() {
        CurrencyApi currencyApi = this.f52543b;
        if (currencyApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currencyApi");
        }
        return currencyApi.getDecimalSymbol();
    }

    public final String getGroupSymbol() {
        CurrencyApi currencyApi = this.f52543b;
        if (currencyApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currencyApi");
        }
        return currencyApi.getGroupSymbol();
    }

    public static /* synthetic */ String formatDateTime$default(Elvish elvish, long j, DateStyle dateStyle, TimeStyle timeStyle, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            dateStyle = DateStyle.NONE;
        }
        DateStyle dateStyle2 = dateStyle;
        if ((i & 4) != 0) {
            timeStyle = TimeStyle.NONE;
        }
        return elvish.formatDateTime(j, dateStyle2, timeStyle, (i & 8) != 0 ? true : z);
    }

    public final String formatDateTime(long j, DateStyle dateStyle, TimeStyle timeStyle, boolean z) {
        DateTimeApi dateTimeApi = this.f52544c;
        if (dateTimeApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateTimeApi");
        }
        if (dateStyle == null) {
            dateStyle = DateStyle.NONE;
        }
        DateStyle dateStyle2 = dateStyle;
        if (timeStyle == null) {
            timeStyle = TimeStyle.NONE;
        }
        return dateTimeApi.formatDateTime(j, dateStyle2, timeStyle, z);
    }

    public static /* synthetic */ String formatCountdownTime$default(Elvish elvish, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return elvish.formatCountdownTime(i, z);
    }

    public final String formatCountdownTime(int i, boolean z) {
        DateTimeApi dateTimeApi = this.f52544c;
        if (dateTimeApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateTimeApi");
        }
        return dateTimeApi.formatCountdownTime(i, z);
    }

    public final Calendar getDateTimeCalendar(long j) {
        DateTimeApi dateTimeApi = this.f52544c;
        if (dateTimeApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateTimeApi");
        }
        return dateTimeApi.getDateTimeCalendar(j);
    }

    /* renamed from: a */
    static /* synthetic */ String m37289a(Elvish elvish, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            LocationInfo locationInfo = elvish.f52542a;
            if (locationInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationInfo");
            }
            str = locationInfo.getLocaleString();
        }
        return elvish.m37290a(str, i, i2);
    }

    /* renamed from: a */
    private final String m37290a(String str, int i, int i2) {
        DateTimeApi dateTimeApi = this.f52544c;
        if (dateTimeApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateTimeApi");
        }
        return dateTimeApi.getDayOfWeekDisplay(str, i, i2);
    }

    public static /* synthetic */ String getShortWeekDayByIndex$default(Elvish elvish, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            LocationInfo locationInfo = elvish.f52542a;
            if (locationInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationInfo");
            }
            str = locationInfo.getLocaleString();
        }
        return elvish.getShortWeekDayByIndex(str, i);
    }

    public final String getShortWeekDayByIndex(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "locale");
        return m37290a(str, i, 1);
    }

    public static /* synthetic */ String getShortWeekDayByCalendarIndex$default(Elvish elvish, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            LocationInfo locationInfo = elvish.f52542a;
            if (locationInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationInfo");
            }
            str = locationInfo.getLocaleString();
        }
        return elvish.getShortWeekDayByCalendarIndex(str, i);
    }

    public final String getShortWeekDayByCalendarIndex(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "locale");
        return getShortWeekDayByIndex(str, DateTimeUtils.INSTANCE.calendarDayOfWeek2Index(i));
    }

    public static /* synthetic */ String formatDistance$default(Elvish elvish, double d, DistanceStyle distanceStyle, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            distanceStyle = DistanceStyle.M;
        }
        return elvish.formatDistance(d, distanceStyle, i, z);
    }

    public final String formatDistance(double d, DistanceStyle distanceStyle, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(distanceStyle, "distanceStyle");
        DistanceApi distanceApi = this.f52545d;
        if (distanceApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distanceApi");
        }
        return distanceApi.formatDistance(d, distanceStyle, i, z);
    }

    public static /* synthetic */ List splitDistance$default(Elvish elvish, double d, DistanceStyle distanceStyle, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            distanceStyle = DistanceStyle.M;
        }
        return elvish.splitDistance(d, distanceStyle, i);
    }

    public final List<String> splitDistance(double d, DistanceStyle distanceStyle, int i) {
        Intrinsics.checkParameterIsNotNull(distanceStyle, "distanceStyle");
        DistanceApi distanceApi = this.f52545d;
        if (distanceApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("distanceApi");
        }
        return distanceApi.splitDistance(d, distanceStyle, i);
    }

    public final String formatNumber(Number number, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(number, "number");
        NumberApi numberApi = this.f52546e;
        if (numberApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberApi");
        }
        return numberApi.format(number, i, i2);
    }

    public final Number parseNumber(String str) throws ParseException {
        Intrinsics.checkParameterIsNotNull(str, "numberStr");
        NumberApi numberApi = this.f52546e;
        if (numberApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberApi");
        }
        return numberApi.parse(str);
    }

    public static /* synthetic */ Number parseNumberSafety$default(Elvish elvish, String str, Number number, int i, Object obj) {
        if ((i & 2) != 0) {
            number = null;
        }
        return elvish.parseNumberSafety(str, number);
    }

    public final Number parseNumberSafety(String str, Number number) {
        Intrinsics.checkParameterIsNotNull(str, "numberStr");
        try {
            NumberApi numberApi = this.f52546e;
            if (numberApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberApi");
            }
            return numberApi.parse(str);
        } catch (ParseException unused) {
            return number;
        }
    }

    public static /* synthetic */ Number parseBigDecimalSafely$default(Elvish elvish, String str, Number number, int i, Object obj) {
        if ((i & 2) != 0) {
            number = null;
        }
        return elvish.parseBigDecimalSafely(str, number);
    }

    public final Number parseBigDecimalSafely(String str, Number number) {
        Intrinsics.checkParameterIsNotNull(str, "numberStr");
        try {
            NumberApi numberApi = this.f52546e;
            if (numberApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberApi");
            }
            return numberApi.parse(str, true);
        } catch (ParseException unused) {
            return number;
        }
    }

    public final int getNumberPrecision(int i) {
        NumberApi numberApi = this.f52546e;
        if (numberApi == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNumberApi");
        }
        return numberApi.getDecimalCountByType(i);
    }

    public final LanguageModel getLanguageAndLocale(Context context, Locale locale, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(locale, "locale");
        return new BaseDataLoader().loadLanguageConfig(context, locale, z);
    }

    public final LanguageModel getLanguageAndLocaleByJson(Context context, Locale locale, boolean z, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(locale, "locale");
        Intrinsics.checkParameterIsNotNull(str, "config");
        return new BaseDataLoader().loadLanguageConfig(context, locale, z, str);
    }

    public final LanguageModel getLanguageAndLocale(Context context, String str, String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "language");
        Intrinsics.checkParameterIsNotNull(str2, "country");
        return new BaseDataLoader().loadLanguageConfig(context, str, str2, z);
    }

    public final LanguageModel getLanguageAndLocaleByJson(Context context, String str, String str2, boolean z, String str3) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "language");
        Intrinsics.checkParameterIsNotNull(str2, "country");
        Intrinsics.checkParameterIsNotNull(str3, "config");
        return new BaseDataLoader().loadLanguageConfig(context, str, str2, z, str3);
    }
}
