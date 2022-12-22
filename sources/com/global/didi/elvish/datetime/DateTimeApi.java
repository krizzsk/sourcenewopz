package com.global.didi.elvish.datetime;

import android.content.Context;
import com.global.didi.elvish.LocationInfo;
import com.global.didi.elvish.util.DateTimeUtils;
import com.global.didi.elvish.util.LocaleUtilsKt;
import com.global.didi.elvish.util.LogUtils;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ&\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012J \u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rJ \u0010\u001f\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002R\u0010\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0004\n\u0002\b\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/global/didi/elvish/datetime/DateTimeApi;", "", "context", "Landroid/content/Context;", "locationInfo", "Lcom/global/didi/elvish/LocationInfo;", "(Landroid/content/Context;Lcom/global/didi/elvish/LocationInfo;)V", "conf", "Lcom/global/didi/elvish/datetime/DateTimeConf;", "conf$1", "formatCountdownTime", "", "countSeconds", "", "isHighlight", "", "formatDateTime", "timestamp", "", "dateStyle", "Lcom/global/didi/elvish/DateStyle;", "timeStyle", "Lcom/global/didi/elvish/TimeStyle;", "trans2Local", "getDateTimeCalendar", "Ljava/util/Calendar;", "timeInMillis", "getDayOfWeekDisplay", "localeStr", "index", "style", "getFormatter", "Ljava/text/SimpleDateFormat;", "pattern", "Companion", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: DateTimeApi.kt */
public final class DateTimeApi {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static volatile DateTimeConf f52564c;

    /* renamed from: a */
    private DateTimeConf f52565a;

    /* renamed from: b */
    private LocationInfo f52566b;

    public DateTimeApi(Context context, LocationInfo locationInfo) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(locationInfo, "locationInfo");
        this.f52566b = locationInfo;
        this.f52565a = Companion.getConf(context);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/global/didi/elvish/datetime/DateTimeApi$Companion;", "", "()V", "conf", "Lcom/global/didi/elvish/datetime/DateTimeConf;", "getConf", "context", "Landroid/content/Context;", "getDayOfWeekDisplay", "", "locale", "Ljava/util/Locale;", "index", "", "style", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: DateTimeApi.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final DateTimeConf getConf(Context context) {
            DateTimeConf access$getConf$cp = DateTimeApi.f52564c;
            if (access$getConf$cp == null) {
                synchronized (this) {
                    access$getConf$cp = DateTimeApi.f52564c;
                    if (access$getConf$cp == null) {
                        access$getConf$cp = new DateTimeConf(context);
                        DateTimeApi.f52564c = access$getConf$cp;
                    }
                }
            }
            return access$getConf$cp;
        }

        /* access modifiers changed from: private */
        public final String getDayOfWeekDisplay(Locale locale, int i, int i2) {
            Calendar instance = Calendar.getInstance();
            instance.set(7, DateTimeUtils.INSTANCE.index2CalendarDayOfWeek(i));
            String displayName = instance.getDisplayName(7, i2, locale);
            return displayName != null ? displayName : "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0085 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String formatDateTime(long r7, com.global.didi.elvish.DateStyle r9, com.global.didi.elvish.TimeStyle r10, boolean r11) {
        /*
            r6 = this;
            java.lang.String r0 = "dateStyle"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            java.lang.String r0 = "timeStyle"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            com.global.didi.elvish.datetime.DateTimeConf r0 = r6.f52565a
            com.global.didi.elvish.LocationInfo r1 = r6.f52566b
            java.lang.String r1 = r1.getLocaleString()
            java.lang.String[] r0 = r0.getPatternsByLocale(r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0025
            int r3 = r0.length
            if (r3 != 0) goto L_0x001f
            r3 = 1
            goto L_0x0020
        L_0x001f:
            r3 = 0
        L_0x0020:
            if (r3 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r3 = 0
            goto L_0x0026
        L_0x0025:
            r3 = 1
        L_0x0026:
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x0085
            int r3 = r0.length
            r5 = 8
            if (r3 == r5) goto L_0x0030
            goto L_0x0085
        L_0x0030:
            com.global.didi.elvish.DateStyle r3 = com.global.didi.elvish.DateStyle.NONE
            if (r9 == r3) goto L_0x0053
            com.global.didi.elvish.TimeStyle r3 = com.global.didi.elvish.TimeStyle.NONE
            if (r10 == r3) goto L_0x0053
            int r9 = r9.getStyle()
            r9 = r0[r9]
            int r10 = r10.getStyle()
            r10 = r0[r10]
            r3 = 7
            r0 = r0[r3]
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r1] = r10
            r3[r2] = r9
            java.lang.String r4 = java.text.MessageFormat.format(r0, r3)
            goto L_0x0068
        L_0x0053:
            com.global.didi.elvish.DateStyle r1 = com.global.didi.elvish.DateStyle.NONE
            if (r9 == r1) goto L_0x005e
            int r9 = r9.getStyle()
            r4 = r0[r9]
            goto L_0x0068
        L_0x005e:
            com.global.didi.elvish.TimeStyle r9 = com.global.didi.elvish.TimeStyle.NONE
            if (r10 == r9) goto L_0x0068
            int r9 = r10.getStyle()
            r4 = r0[r9]
        L_0x0068:
            java.lang.String r9 = "pattern"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r9)
            java.text.SimpleDateFormat r9 = r6.m37306a(r7, r4, r11)
            java.util.Date r10 = new java.util.Date
            r11 = 1000(0x3e8, float:1.401E-42)
            long r0 = (long) r11
            long r7 = r7 * r0
            r10.<init>(r7)
            java.lang.String r7 = r9.format(r10)
            java.lang.String r8 = "format.format(Date(timestamp * 1000))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)
            return r7
        L_0x0085:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.global.didi.elvish.datetime.DateTimeApi.formatDateTime(long, com.global.didi.elvish.DateStyle, com.global.didi.elvish.TimeStyle, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0130 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String formatCountdownTime(int r9, boolean r10) {
        /*
            r8 = this;
            java.lang.String r0 = "0"
            if (r9 >= 0) goto L_0x0005
            return r0
        L_0x0005:
            r1 = 86400(0x15180, float:1.21072E-40)
            int r2 = r9 / r1
            com.global.didi.elvish.DurationStyle r3 = com.global.didi.elvish.DurationStyle.DD
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 125(0x7d, float:1.75E-43)
            r6 = 123(0x7b, float:1.72E-43)
            if (r2 <= 0) goto L_0x0038
            if (r10 == 0) goto L_0x002f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r3.append(r2)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r4.add(r3)
            goto L_0x0036
        L_0x002f:
            java.lang.String r3 = java.lang.String.valueOf(r2)
            r4.add(r3)
        L_0x0036:
            com.global.didi.elvish.DurationStyle r3 = com.global.didi.elvish.DurationStyle.DD
        L_0x0038:
            int r1 = r9 % r1
            int r1 = r1 / 3600
            r7 = 1
            if (r1 <= 0) goto L_0x0066
            if (r10 == 0) goto L_0x0057
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r3.append(r1)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r4.add(r3)
            goto L_0x005e
        L_0x0057:
            java.lang.String r3 = java.lang.String.valueOf(r1)
            r4.add(r3)
        L_0x005e:
            if (r2 >= r7) goto L_0x0063
            com.global.didi.elvish.DurationStyle r3 = com.global.didi.elvish.DurationStyle.HH
            goto L_0x0066
        L_0x0063:
            com.global.didi.elvish.DurationStyle r9 = com.global.didi.elvish.DurationStyle.DD_HH
            goto L_0x00c4
        L_0x0066:
            if (r2 <= 0) goto L_0x006a
        L_0x0068:
            r9 = r3
            goto L_0x00c4
        L_0x006a:
            int r2 = r9 % 3600
            int r2 = r2 / 60
            if (r2 <= 0) goto L_0x0097
            if (r10 == 0) goto L_0x0088
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r3.append(r2)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r4.add(r3)
            goto L_0x008f
        L_0x0088:
            java.lang.String r3 = java.lang.String.valueOf(r2)
            r4.add(r3)
        L_0x008f:
            if (r1 >= r7) goto L_0x0094
            com.global.didi.elvish.DurationStyle r3 = com.global.didi.elvish.DurationStyle.MM
            goto L_0x0097
        L_0x0094:
            com.global.didi.elvish.DurationStyle r9 = com.global.didi.elvish.DurationStyle.HH_MM
            goto L_0x00c4
        L_0x0097:
            if (r1 <= 0) goto L_0x009a
            goto L_0x0068
        L_0x009a:
            int r9 = r9 % 60
            if (r9 <= 0) goto L_0x0068
            if (r10 == 0) goto L_0x00b6
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r6)
            r10.append(r9)
            r10.append(r5)
            java.lang.String r9 = r10.toString()
            r4.add(r9)
            goto L_0x00bd
        L_0x00b6:
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r4.add(r9)
        L_0x00bd:
            if (r2 >= r7) goto L_0x00c2
            com.global.didi.elvish.DurationStyle r9 = com.global.didi.elvish.DurationStyle.SS
            goto L_0x00c4
        L_0x00c2:
            com.global.didi.elvish.DurationStyle r9 = com.global.didi.elvish.DurationStyle.MM_SS
        L_0x00c4:
            com.global.didi.elvish.datetime.DateTimeConf r10 = r8.f52565a
            com.global.didi.elvish.LocationInfo r1 = r8.f52566b
            java.lang.String r1 = r1.getLocaleString()
            java.lang.String[] r10 = r10.getDurationsByLocale(r1)
            int r9 = r9.getStyle()
            r9 = r10[r9]
            com.global.didi.elvish.util.LogUtils r10 = com.global.didi.elvish.util.LogUtils.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "pattern = "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r10.print(r1)
            com.global.didi.elvish.util.LogUtils r10 = com.global.didi.elvish.util.LogUtils.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "times = "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r10.print(r1)
            int r10 = r4.size()
            if (r10 <= 0) goto L_0x0130
            r10 = r4
            java.util.List r10 = (java.util.List) r10
            kotlin.collections.CollectionsKt.reverse(r10)
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            r1 = 0
            java.lang.Object r2 = r4.get(r1)
            r10[r1] = r2
            int r1 = r4.size()
            if (r1 <= r7) goto L_0x0124
            java.lang.Object r0 = r4.get(r7)
            java.lang.String r0 = (java.lang.String) r0
        L_0x0124:
            r10[r7] = r0
            java.lang.String r9 = java.text.MessageFormat.format(r9, r10)
            java.lang.String r10 = "MessageFormat.format(\n  …1] else \"0\"\n            )"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r10)
            return r9
        L_0x0130:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.global.didi.elvish.datetime.DateTimeApi.formatCountdownTime(int, boolean):java.lang.String");
    }

    /* renamed from: a */
    private final SimpleDateFormat m37306a(long j, String str, boolean z) {
        int i;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, this.f52566b.getLocale());
        String timeZone = this.f52565a.getTimeZone(this.f52566b.getCityId());
        NumberFormat numberFormat = simpleDateFormat.getNumberFormat();
        if (numberFormat instanceof DecimalFormat) {
            DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
            DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
            Intrinsics.checkExpressionValueIsNotNull(decimalFormatSymbols, "decimalFormatSymbols");
            decimalFormatSymbols.setZeroDigit('0');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            simpleDateFormat.setNumberFormat(numberFormat);
        }
        if (z) {
            boolean z2 = false;
            if (!(timeZone.length() == 0)) {
                TimeZone timeZone2 = TimeZone.getTimeZone(timeZone);
                int offset = this.f52565a.getOffset(this.f52566b.getCityId(), j);
                if (offset != -1) {
                    i = (int) TimeUnit.SECONDS.toMillis((long) offset);
                } else {
                    Intrinsics.checkExpressionValueIsNotNull(timeZone2, "timeZone");
                    i = timeZone2.getRawOffset();
                }
                Intrinsics.checkExpressionValueIsNotNull(timeZone2, "timeZone");
                simpleDateFormat.setTimeZone(new SimpleTimeZone(i, timeZone2.getID()));
                String[] amPmMarks = this.f52565a.getAmPmMarks(this.f52566b.getLocaleString());
                if (amPmMarks.length == 0) {
                    z2 = true;
                }
                if (!z2) {
                    DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.f52566b.getLocale());
                    dateFormatSymbols.setAmPmStrings(amPmMarks);
                    simpleDateFormat.setDateFormatSymbols(dateFormatSymbols);
                }
            }
        }
        return simpleDateFormat;
    }

    public final Calendar getDateTimeCalendar(long j) {
        int i;
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance()");
        instance.setTimeInMillis(j);
        String timeZone = this.f52565a.getTimeZone(this.f52566b.getCityId());
        if (timeZone.length() == 0) {
            return instance;
        }
        TimeZone timeZone2 = TimeZone.getTimeZone(timeZone);
        int offset = this.f52565a.getOffset(this.f52566b.getCityId(), j);
        if (offset != -1) {
            i = (int) TimeUnit.SECONDS.toMillis((long) offset);
        } else {
            Intrinsics.checkExpressionValueIsNotNull(timeZone2, "timeZone");
            i = timeZone2.getRawOffset();
        }
        Intrinsics.checkExpressionValueIsNotNull(timeZone2, "timeZone");
        instance.setTimeZone(new SimpleTimeZone(i, timeZone2.getID()));
        return instance;
    }

    public static /* synthetic */ String getDayOfWeekDisplay$default(DateTimeApi dateTimeApi, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = dateTimeApi.f52566b.getLocaleString();
        }
        return dateTimeApi.getDayOfWeekDisplay(str, i, i2);
    }

    public final String getDayOfWeekDisplay(String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "localeStr");
        Locale string2Locale = LocaleUtilsKt.string2Locale(str);
        if (string2Locale != null) {
            return Companion.getDayOfWeekDisplay(string2Locale, i, i2);
        }
        LogUtils logUtils = LogUtils.INSTANCE;
        logUtils.mo132615e("DateTimeApi.getDayOfWeekDisplay:local is null " + str);
        return "";
    }
}
