package com.didiglobal.travel.infra.time;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001WB\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u000bHÖ\u0001J\r\u0010+\u001a\u00020(¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020(¢\u0006\u0004\b/\u0010-J\u001b\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u001b\u00100\u001a\u0002022\u0006\u0010$\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00104J\u001b\u00106\u001a\u00020\u00002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00104J\u0017\u00108\u001a\u00020\f2\b\b\u0002\u00109\u001a\u00020:¢\u0006\u0004\b;\u0010<Jg\u0010=\u001a\u00020>2\b\b\u0002\u00109\u001a\u00020:2K\u0010?\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(C\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(E\u0012\u0004\u0012\u00020>0@H\b¢\u0006\u0004\bF\u0010GJÒ\u0001\u0010=\u001a\u00020>2\b\b\u0002\u00109\u001a\u00020:2µ\u0001\u0010?\u001a°\u0001\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(C\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(I\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020>0HH\b¢\u0006\u0004\bF\u0010NJ\r\u0010O\u001a\u00020P¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020TH\u0016¢\u0006\u0004\bU\u0010VR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u001f\u0010\n\u001a\u00020\u000b*\u00020\f8À\u0002X\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0011\u001a\u00020\u000b*\u00020\f8À\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001f\u0010\u0014\u001a\u00020\u000b*\u00020\f8À\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001f\u0010\u0017\u001a\u00020\u000b*\u00020\f8À\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001f\u0010\u001a\u001a\u00020\u000b*\u00020\f8À\u0002X\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u001f\u0010\u001d\u001a\u00020\u000b*\u00020\f8À\u0002X\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u001f\u0010 \u001a\u00020\u000b*\u00020\f8À\u0002X\u0004¢\u0006\f\u0012\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006X"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/time/Timestamp;", "", "inMillis", "", "constructor-impl", "(J)J", "getInMillis", "()J", "inSeconds", "getInSeconds-impl", "dayOfMonthComponent", "", "Ljava/util/Calendar;", "dayOfMonthComponent$annotations", "(Ljava/util/Calendar;)V", "getDayOfMonthComponent-impl", "(JLjava/util/Calendar;)I", "hourComponent", "hourComponent$annotations", "getHourComponent-impl", "millisecondsComponent", "millisecondsComponent$annotations", "getMillisecondsComponent-impl", "minutesComponent", "minutesComponent$annotations", "getMinutesComponent-impl", "monthComponent", "monthComponent$annotations", "getMonthComponent-impl", "secondsComponent", "secondsComponent$annotations", "getSecondsComponent-impl", "yearComponent", "yearComponent$annotations", "getYearComponent-impl", "compareTo", "other", "compareTo-RdnlEiI", "(JJ)I", "equals", "", "", "hashCode", "isFuture", "isFuture-impl", "(J)Z", "isPast", "isPast-impl", "minus", "duration", "Lcom/didiglobal/travel/infra/time/Duration;", "minus-VSBMxCo", "(JJ)J", "minus-RdnlEiI", "plus", "plus-VSBMxCo", "toCalendar", "tz", "Ljava/util/TimeZone;", "toCalendar-impl", "(JLjava/util/TimeZone;)Ljava/util/Calendar;", "toComponents", "", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "year", "month", "dayOfMonth", "toComponents-impl", "(JLjava/util/TimeZone;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/Function8;", "hours", "minutes", "seconds", "millis", "zoneOffset", "(JLjava/util/TimeZone;Lkotlin/jvm/functions/Function8;)V", "toDate", "Ljava/util/Date;", "toDate-impl", "(J)Ljava/util/Date;", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Timestamp.kt */
public final class Timestamp implements Comparable<Timestamp> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final long f51448b = m47199constructorimpl(0);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final long f51449c = m47199constructorimpl(Long.MAX_VALUE);

    /* renamed from: a */
    private final long f51450a;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Timestamp m47197boximpl(long j) {
        return new Timestamp(j);
    }

    /* renamed from: compareTo-RdnlEiI  reason: not valid java name */
    public static int m47198compareToRdnlEiI(long j, long j2) {
        return (j > j2 ? 1 : (j == j2 ? 0 : -1));
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m47199constructorimpl(long j) {
        return j;
    }

    public static /* synthetic */ void dayOfMonthComponent$annotations(Calendar calendar) {
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47200equalsimpl(long j, Object obj) {
        return (obj instanceof Timestamp) && j == ((Timestamp) obj).m47225unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47201equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47210hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static /* synthetic */ void hourComponent$annotations(Calendar calendar) {
    }

    public static /* synthetic */ void millisecondsComponent$annotations(Calendar calendar) {
    }

    public static /* synthetic */ void minutesComponent$annotations(Calendar calendar) {
    }

    public static /* synthetic */ void monthComponent$annotations(Calendar calendar) {
    }

    public static /* synthetic */ void secondsComponent$annotations(Calendar calendar) {
    }

    public static /* synthetic */ void yearComponent$annotations(Calendar calendar) {
    }

    /* renamed from: compareTo-RdnlEiI  reason: not valid java name */
    public int m47224compareToRdnlEiI(long j) {
        return m47198compareToRdnlEiI(this.f51450a, j);
    }

    public boolean equals(Object obj) {
        return m47200equalsimpl(this.f51450a, obj);
    }

    public int hashCode() {
        return m47210hashCodeimpl(this.f51450a);
    }

    public String toString() {
        return m47223toStringimpl(this.f51450a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m47225unboximpl() {
        return this.f51450a;
    }

    private /* synthetic */ Timestamp(long j) {
        this.f51450a = j;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m47224compareToRdnlEiI(((Timestamp) obj).m47225unboximpl());
    }

    public final long getInMillis() {
        return this.f51450a;
    }

    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final long m47204getInSecondsimpl(long j) {
        return j / 1000;
    }

    /* renamed from: plus-VSBMxCo  reason: not valid java name */
    public static final long m47215plusVSBMxCo(long j, long j2) {
        return m47199constructorimpl(j + Duration.m47176getInMillisimpl(j2));
    }

    /* renamed from: minus-VSBMxCo  reason: not valid java name */
    public static final long m47214minusVSBMxCo(long j, long j2) {
        return m47199constructorimpl(j - Duration.m47176getInMillisimpl(j2));
    }

    /* renamed from: minus-RdnlEiI  reason: not valid java name */
    public static final long m47213minusRdnlEiI(long j, long j2) {
        return Duration.m47166constructorimpl(j - j2);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47223toStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(timeZone, "TimeZone.getDefault()");
        Calendar r12 = m47216toCalendarimpl(j, timeZone);
        int i = r12.get(1);
        int i2 = r12.get(2);
        int i3 = r12.get(5);
        int i4 = r12.get(11);
        int i5 = r12.get(12);
        int i6 = r12.get(13);
        int i7 = r12.get(14);
        r12.get(15);
        TimeZone timeZone2 = TimeZone.getDefault();
        sb.append(timeZone2.getDisplayName(timeZone2.useDaylightTime(), 0, Locale.ROOT));
        sb.append(' ');
        sb.append(i);
        sb.append('-');
        sb.append(StringsKt.padStart(String.valueOf(i2 + 1), 2, '0'));
        sb.append('-');
        sb.append(StringsKt.padStart(String.valueOf(i3), 2, '0'));
        sb.append(' ');
        sb.append(StringsKt.padStart(String.valueOf(i4), 2, '0'));
        sb.append(':');
        sb.append(StringsKt.padStart(String.valueOf(i5), 2, '0'));
        sb.append(':');
        sb.append(StringsKt.padStart(String.valueOf(i6), 2, '0'));
        if (i7 > 0) {
            sb.append('.');
            sb.append(StringsKt.padStart(String.valueOf(i7), 3, '0'));
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: isPast-impl  reason: not valid java name */
    public static final boolean m47212isPastimpl(long j) {
        return j < TimeSource.INSTANCE.currentTimeMillis();
    }

    /* renamed from: isFuture-impl  reason: not valid java name */
    public static final boolean m47211isFutureimpl(long j) {
        return j > TimeSource.INSTANCE.currentTimeMillis();
    }

    /* renamed from: toDate-impl  reason: not valid java name */
    public static final Date m47222toDateimpl(long j) {
        return new Date(j);
    }

    /* renamed from: toCalendar-impl  reason: not valid java name */
    public static final Calendar m47216toCalendarimpl(long j, TimeZone timeZone) {
        Intrinsics.checkParameterIsNotNull(timeZone, "tz");
        Calendar instance = Calendar.getInstance(Locale.ROOT);
        instance.setTimeZone(timeZone);
        instance.setTimeInMillis(j);
        Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance(Loc…estamp.inMillis\n        }");
        return instance;
    }

    /* renamed from: toCalendar-impl$default  reason: not valid java name */
    public static /* synthetic */ Calendar m47217toCalendarimpl$default(long j, TimeZone timeZone, int i, Object obj) {
        if ((i & 1) != 0) {
            timeZone = TimeZone.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(timeZone, "TimeZone.getDefault()");
        }
        return m47216toCalendarimpl(j, timeZone);
    }

    /* renamed from: toComponents-impl$default  reason: not valid java name */
    public static /* synthetic */ void m47220toComponentsimpl$default(long j, TimeZone timeZone, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            timeZone = TimeZone.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(timeZone, "TimeZone.getDefault()");
        }
        Intrinsics.checkParameterIsNotNull(timeZone, "tz");
        Intrinsics.checkParameterIsNotNull(function3, "action");
        Calendar r0 = m47216toCalendarimpl(j, timeZone);
        function3.invoke(Integer.valueOf(r0.get(1)), Integer.valueOf(r0.get(2)), Integer.valueOf(r0.get(5)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final void m47218toComponentsimpl(long j, TimeZone timeZone, Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(timeZone, "tz");
        Intrinsics.checkParameterIsNotNull(function3, "action");
        Calendar r1 = m47216toCalendarimpl(j, timeZone);
        function3.invoke(Integer.valueOf(r1.get(1)), Integer.valueOf(r1.get(2)), Integer.valueOf(r1.get(5)));
    }

    /* renamed from: toComponents-impl$default  reason: not valid java name */
    public static /* synthetic */ void m47221toComponentsimpl$default(long j, TimeZone timeZone, Function8 function8, int i, Object obj) {
        if ((i & 1) != 0) {
            timeZone = TimeZone.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(timeZone, "TimeZone.getDefault()");
        }
        Intrinsics.checkParameterIsNotNull(timeZone, "tz");
        Intrinsics.checkParameterIsNotNull(function8, "action");
        Calendar r9 = m47216toCalendarimpl(j, timeZone);
        function8.invoke(Integer.valueOf(r9.get(1)), Integer.valueOf(r9.get(2)), Integer.valueOf(r9.get(5)), Integer.valueOf(r9.get(11)), Integer.valueOf(r9.get(12)), Integer.valueOf(r9.get(13)), Integer.valueOf(r9.get(14)), Integer.valueOf(r9.get(15)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final void m47219toComponentsimpl(long j, TimeZone timeZone, Function8<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function8) {
        Intrinsics.checkParameterIsNotNull(timeZone, "tz");
        Intrinsics.checkParameterIsNotNull(function8, "action");
        Calendar r9 = m47216toCalendarimpl(j, timeZone);
        function8.invoke(Integer.valueOf(r9.get(1)), Integer.valueOf(r9.get(2)), Integer.valueOf(r9.get(5)), Integer.valueOf(r9.get(11)), Integer.valueOf(r9.get(12)), Integer.valueOf(r9.get(13)), Integer.valueOf(r9.get(14)), Integer.valueOf(r9.get(15)));
    }

    /* renamed from: getYearComponent-impl  reason: not valid java name */
    public static final int m47209getYearComponentimpl(long j, Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$yearComponent");
        return calendar.get(1);
    }

    /* renamed from: getMonthComponent-impl  reason: not valid java name */
    public static final int m47207getMonthComponentimpl(long j, Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$monthComponent");
        return calendar.get(2);
    }

    /* renamed from: getDayOfMonthComponent-impl  reason: not valid java name */
    public static final int m47202getDayOfMonthComponentimpl(long j, Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$dayOfMonthComponent");
        return calendar.get(5);
    }

    /* renamed from: getHourComponent-impl  reason: not valid java name */
    public static final int m47203getHourComponentimpl(long j, Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$hourComponent");
        return calendar.get(11);
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m47206getMinutesComponentimpl(long j, Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$minutesComponent");
        return calendar.get(12);
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m47208getSecondsComponentimpl(long j, Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$secondsComponent");
        return calendar.get(13);
    }

    /* renamed from: getMillisecondsComponent-impl  reason: not valid java name */
    public static final int m47205getMillisecondsComponentimpl(long j, Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$millisecondsComponent");
        return calendar.get(14);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/time/Timestamp$Companion;", "", "()V", "FAR_FUTURE", "Lcom/didiglobal/travel/infra/time/Timestamp;", "getFAR_FUTURE", "()J", "J", "ZERO", "getZERO", "now", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: Timestamp.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long getZERO() {
            return Timestamp.f51448b;
        }

        public final long getFAR_FUTURE() {
            return Timestamp.f51449c;
        }

        public final long now() {
            return Timestamp.m47199constructorimpl(TimeSource.INSTANCE.currentTimeMillis());
        }
    }
}
