package com.didiglobal.travel.infra.time;

import com.airbnb.lottie.utils.Utils;
import com.didi.raven.config.RavenKey;
import com.didi.remotereslibrary.Config;
import com.didiglobal.domainservice.utils.DomainConstants;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.osgi.framework.VersionRange;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b@\u0018\u0000 x2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001xB\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101J'\u00102\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\"H\u0002¢\u0006\u0004\b5\u00106J\u001b\u00107\u001a\u0002082\u0006\u0010/\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u00107\u001a\u00020\u00002\u0006\u0010;\u001a\u000208H\u0002ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u001b\u00107\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b<\u0010>J\u0013\u0010?\u001a\u00020@2\b\u0010/\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\tHÖ\u0001J\r\u0010C\u001a\u00020@¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020@H\u0002¢\u0006\u0004\bG\u0010EJ\u000f\u0010H\u001a\u00020@H\u0002¢\u0006\u0004\bI\u0010EJ\r\u0010J\u001a\u00020@¢\u0006\u0004\bK\u0010EJ\r\u0010L\u001a\u00020@¢\u0006\u0004\bM\u0010EJ\r\u0010N\u001a\u00020@¢\u0006\u0004\bO\u0010EJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ\u001b\u0010S\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bT\u0010RJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010;\u001a\u000208H\u0002ø\u0001\u0000¢\u0006\u0004\bV\u0010=J\u001b\u0010U\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\bV\u0010>J\u0001\u0010W\u001a\u0002HX\"\u0004\b\u0000\u0010X2u\u0010Y\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(]\u0012\u0013\u0012\u00110\t¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(^\u0012\u0013\u0012\u00110\t¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110\t¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(`\u0012\u0013\u0012\u00110\t¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(a\u0012\u0004\u0012\u0002HX0ZH\b¢\u0006\u0004\bb\u0010cJ\u0015\u0010d\u001a\u00020\u00032\u0006\u0010e\u001a\u00020\"¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bm\u0010\u0005J?\u0010n\u001a\u00020o*\u00060pj\u0002`q2\u0006\u0010r\u001a\u00020\t2\u0006\u0010s\u001a\u00020\t2\u0006\u0010t\u001a\u00020\t2\u0006\u0010e\u001a\u00020i2\u0006\u0010u\u001a\u00020@H\u0002¢\u0006\u0004\bv\u0010wR\u0014\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u001a\u0010\u0018\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\rR\u001a\u0010\u001b\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR\u0014\u0010!\u001a\u00020\"8BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0015\u0010%\u001a\u00020\t8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\rR\u0014\u0010'\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0005ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006y"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-impl", "hoursComponent", "", "hoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "getInDays-impl", "inHours", "getInHours-impl", "inMillis", "getInMillis-impl", "inMinutes", "getInMinutes-impl", "inSeconds", "getInSeconds-impl", "minutesComponent", "minutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "nanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "secondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Ljava/util/concurrent/TimeUnit;", "getStorageUnit-impl", "(J)Ljava/util/concurrent/TimeUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-impl", "(JJJ)J", "compareTo", "other", "compareTo-VSBMxCo", "(JJ)I", "convertDurationUnit", "sourceUnit", "targetUnit", "convertDurationUnit-impl", "(JJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/TimeUnit;)J", "div", "", "div-VSBMxCo", "(JJ)D", "scale", "div-impl", "(JD)J", "(JI)J", "equals", "", "", "hashCode", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-VSBMxCo", "(JJ)J", "plus", "plus-VSBMxCo", "times", "times-impl", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "milliseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "toLong", "unit", "toLong-impl", "(JLjava/util/concurrent/TimeUnit;)J", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-impl", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Duration.kt */
public final class Duration implements Comparable<Duration> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final long f51442b = m47166constructorimpl(0);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final long f51443c = DurationKt.m36827d(4611686018427387903L);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final long f51444d = DurationKt.m36827d(-4611686018427387903L);

    /* renamed from: a */
    private final long f51445a;

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            $EnumSwitchMapping$0[TimeUnit.MICROSECONDS.ordinal()] = 2;
            int[] iArr2 = new int[TimeUnit.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[TimeUnit.NANOSECONDS.ordinal()] = 1;
            $EnumSwitchMapping$1[TimeUnit.MICROSECONDS.ordinal()] = 2;
            $EnumSwitchMapping$1[TimeUnit.MILLISECONDS.ordinal()] = 3;
            $EnumSwitchMapping$1[TimeUnit.SECONDS.ordinal()] = 4;
            $EnumSwitchMapping$1[TimeUnit.MINUTES.ordinal()] = 5;
            $EnumSwitchMapping$1[TimeUnit.HOURS.ordinal()] = 6;
            $EnumSwitchMapping$1[TimeUnit.DAYS.ordinal()] = 7;
        }
    }

    /* renamed from: a */
    private static final long m36814a(long j) {
        return j >> 1;
    }

    /* renamed from: b */
    private static final int m36818b(long j) {
        return ((int) j) & 1;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m47164boximpl(long j) {
        return new Duration(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m47166constructorimpl(long j) {
        return j;
    }

    /* renamed from: d */
    private static final boolean m36820d(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: e */
    private static final boolean m36821e(long j) {
        return (((int) j) & 1) == 1;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47170equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).m47196unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47171equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47182hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static /* synthetic */ void hoursComponent$annotations() {
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m47185isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m47186isPositiveimpl(long j) {
        return j > 0;
    }

    public static /* synthetic */ void minutesComponent$annotations() {
    }

    public static /* synthetic */ void nanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void secondsComponent$annotations() {
    }

    /* renamed from: compareTo-VSBMxCo  reason: not valid java name */
    public int m47195compareToVSBMxCo(long j) {
        return m47165compareToVSBMxCo(this.f51445a, j);
    }

    public boolean equals(Object obj) {
        return m47170equalsimpl(this.f51445a, obj);
    }

    public int hashCode() {
        return m47182hashCodeimpl(this.f51445a);
    }

    public String toString() {
        return m47193toStringimpl(this.f51445a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m47196unboximpl() {
        return this.f51445a;
    }

    private /* synthetic */ Duration(long j) {
        this.f51445a = j;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m47195compareToVSBMxCo(((Duration) obj).m47196unboximpl());
    }

    /* renamed from: getInMillis-impl  reason: not valid java name */
    public static final long m47176getInMillisimpl(long j) {
        return (!m36821e(j) || !m47183isFiniteimpl(j)) ? m47192toLongimpl(j, TimeUnit.MILLISECONDS) : m36814a(j);
    }

    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final long m47178getInSecondsimpl(long j) {
        return m47192toLongimpl(j, TimeUnit.SECONDS);
    }

    /* renamed from: getInMinutes-impl  reason: not valid java name */
    public static final long m47177getInMinutesimpl(long j) {
        return m47192toLongimpl(j, TimeUnit.MINUTES);
    }

    /* renamed from: getInHours-impl  reason: not valid java name */
    public static final long m47175getInHoursimpl(long j) {
        return m47192toLongimpl(j, TimeUnit.HOURS);
    }

    /* renamed from: getInDays-impl  reason: not valid java name */
    public static final long m47174getInDaysimpl(long j) {
        return m47192toLongimpl(j, TimeUnit.DAYS);
    }

    /* renamed from: getAbsoluteValue-impl  reason: not valid java name */
    public static final long m47172getAbsoluteValueimpl(long j) {
        return m47185isNegativeimpl(j) ? m47194unaryMinusimpl(j) : j;
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m47173getHoursComponentimpl(long j) {
        if (m47184isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m47175getInHoursimpl(j) % ((long) 24));
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m47179getMinutesComponentimpl(long j) {
        if (m47184isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m47177getInMinutesimpl(j) % ((long) 60));
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m47181getSecondsComponentimpl(long j) {
        if (m47184isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m47178getInSecondsimpl(j) % ((long) 60));
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m47180getNanosecondsComponentimpl(long j) {
        long j2;
        if (m47184isInfiniteimpl(j)) {
            return 0;
        }
        if (m36821e(j)) {
            j2 = DurationKt.m36825b(m36814a(j) % ((long) 1000));
        } else {
            j2 = m36814a(j) % ((long) Utils.SECOND_IN_NANOS);
        }
        return (int) j2;
    }

    /* renamed from: c */
    private static final TimeUnit m36819c(long j) {
        return m36820d(j) ? TimeUnit.NANOSECONDS : TimeUnit.MILLISECONDS;
    }

    /* renamed from: unaryMinus-impl  reason: not valid java name */
    public static final long m47194unaryMinusimpl(long j) {
        return DurationKt.m36824a(-m36814a(j), ((int) j) & 1);
    }

    /* renamed from: plus-VSBMxCo  reason: not valid java name */
    public static final long m47188plusVSBMxCo(long j, long j2) {
        if (m47184isInfiniteimpl(j)) {
            if (m47183isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (m47184isInfiniteimpl(j2)) {
            return j2;
        } else {
            if ((((int) j) & 1) == (((int) j2) & 1)) {
                long a = m36814a(j) + m36814a(j2);
                if (m36820d(j)) {
                    return DurationKt.m36828e(a);
                }
                return DurationKt.m36829f(a);
            } else if (m36821e(j)) {
                return m36815a(j, m36814a(j), m36814a(j2));
            } else {
                return m36815a(j, m36814a(j2), m36814a(j));
            }
        }
    }

    /* renamed from: minus-VSBMxCo  reason: not valid java name */
    public static final long m47187minusVSBMxCo(long j, long j2) {
        return m47188plusVSBMxCo(j, m47194unaryMinusimpl(j2));
    }

    /* renamed from: times-impl  reason: not valid java name */
    public static final long m47190timesimpl(long j, int i) {
        if (m47184isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m47194unaryMinusimpl(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        } else if (i == 0) {
            return f51442b;
        } else {
            long a = m36814a(j);
            long j2 = (long) i;
            long j3 = a * j2;
            if (m36820d(j)) {
                if (-2147483647L <= a && 2147483647L >= a) {
                    return DurationKt.m36826c(j3);
                }
                if (j3 / j2 == a) {
                    return DurationKt.m36828e(j3);
                }
                long access$nanosToMillis = DurationKt.m36823a(a);
                long j4 = access$nanosToMillis * j2;
                long access$nanosToMillis2 = DurationKt.m36823a((a - DurationKt.m36825b(access$nanosToMillis)) * j2) + j4;
                if (j4 / j2 != access$nanosToMillis || (access$nanosToMillis2 ^ j4) < 0) {
                    return MathKt.getSign(a) * MathKt.getSign(i) > 0 ? f51443c : f51444d;
                }
                return DurationKt.m36827d(RangesKt.coerceIn(access$nanosToMillis2, (ClosedRange<Long>) new LongRange(-4611686018427387903L, 4611686018427387903L)));
            } else if (j3 / j2 == a) {
                return DurationKt.m36827d(RangesKt.coerceIn(j3, (ClosedRange<Long>) new LongRange(-4611686018427387903L, 4611686018427387903L)));
            } else {
                return MathKt.getSign(a) * MathKt.getSign(i) > 0 ? f51443c : f51444d;
            }
        }
    }

    /* renamed from: times-impl  reason: not valid java name */
    public static final long m47189timesimpl(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if (((double) roundToInt) == d) {
            return m47190timesimpl(j, roundToInt);
        }
        TimeUnit c = m36819c(j);
        return Companion.mo124926of((long) (((double) m47192toLongimpl(j, c)) * d), c);
    }

    /* renamed from: div-impl  reason: not valid java name */
    public static final long m47169divimpl(long j, int i) {
        if (i == 0) {
            if (m47186isPositiveimpl(j)) {
                return f51443c;
            }
            if (m47185isNegativeimpl(j)) {
                return f51444d;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (m36820d(j)) {
            return DurationKt.m36826c(m36814a(j) / ((long) i));
        } else {
            if (m47184isInfiniteimpl(j)) {
                return m47190timesimpl(j, MathKt.getSign(i));
            }
            long j2 = (long) i;
            long a = m36814a(j) / j2;
            if (-4611686018426L > a || 4611686018426L < a) {
                return DurationKt.m36827d(a);
            }
            return DurationKt.m36826c(DurationKt.m36825b(a) + (DurationKt.m36825b(m36814a(j) - (a * j2)) / j2));
        }
    }

    /* renamed from: div-impl  reason: not valid java name */
    public static final long m47168divimpl(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if (((double) roundToInt) == d && roundToInt != 0) {
            return m47169divimpl(j, roundToInt);
        }
        TimeUnit c = m36819c(j);
        return Companion.mo124926of((long) (((double) m47192toLongimpl(j, c)) / d), c);
    }

    /* renamed from: div-VSBMxCo  reason: not valid java name */
    public static final double m47167divVSBMxCo(long j, long j2) {
        TimeUnit timeUnit = (TimeUnit) ComparisonsKt.maxOf(m36819c(j), m36819c(j2));
        return ((double) m47192toLongimpl(j, timeUnit)) / ((double) m47192toLongimpl(j2, timeUnit));
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47193toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == f51443c) {
            return "Infinity";
        }
        if (j == f51444d) {
            return "-Infinity";
        }
        boolean r2 = m47185isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (r2) {
            sb.append('-');
        }
        long r3 = m47172getAbsoluteValueimpl(j);
        long r5 = m47174getInDaysimpl(r3);
        int r7 = m47173getHoursComponentimpl(r3);
        int r8 = m47179getMinutesComponentimpl(r3);
        int r9 = m47181getSecondsComponentimpl(r3);
        int r10 = m47180getNanosecondsComponentimpl(r3);
        int i = 0;
        boolean z = r5 != 0;
        boolean z2 = r7 != 0;
        boolean z3 = r8 != 0;
        boolean z4 = (r9 == 0 && r10 == 0) ? false : true;
        if (z) {
            sb.append(r5);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(r7);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(r8);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (r9 != 0 || z || z2 || z3) {
                m36817a(j, sb, r9, r10, 9, RavenKey.STACK, false);
            } else if (r10 >= 1000000) {
                m36817a(j, sb, r10 / 1000000, r10 % 1000000, 6, "ms", false);
            } else if (r10 >= 1000) {
                m36817a(j, sb, r10 / 1000, r10 % 1000, 3, DomainConstants.DOMAIN_SUFFIX_US, false);
            } else {
                sb.append(r10);
                sb.append(Config.KEY_NS);
            }
            i = i4;
        }
        if (r2 && i > 1) {
            sb.insert(1, VersionRange.LEFT_OPEN).append(VersionRange.RIGHT_OPEN);
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: compareTo-VSBMxCo  reason: not valid java name */
    public static int m47165compareToVSBMxCo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return (j > j2 ? 1 : (j == j2 ? 0 : -1));
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m47185isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m47184isInfiniteimpl(long j) {
        return j == f51443c || j == f51444d;
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m47183isFiniteimpl(long j) {
        return !m47184isInfiniteimpl(j);
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m47192toLongimpl(long j, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        if (j == f51443c) {
            return Long.MAX_VALUE;
        }
        if (j == f51444d) {
            return Long.MIN_VALUE;
        }
        return m36816a(j, m36814a(j), m36819c(j), timeUnit);
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m47191toComponentsimpl(long j, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function5) {
        Intrinsics.checkParameterIsNotNull(function5, "action");
        return function5.invoke(Long.valueOf(m47174getInDaysimpl(j)), Integer.valueOf(m47173getHoursComponentimpl(j)), Integer.valueOf(m47179getMinutesComponentimpl(j)), Integer.valueOf(m47181getSecondsComponentimpl(j)), Integer.valueOf(m47180getNanosecondsComponentimpl(j)));
    }

    /* renamed from: a */
    private static final long m36816a(long j, long j2, TimeUnit timeUnit, TimeUnit timeUnit2) {
        if (timeUnit == TimeUnit.NANOSECONDS) {
            int i = WhenMappings.$EnumSwitchMapping$0[timeUnit2.ordinal()];
            if (i == 1) {
                return j2;
            }
            if (i == 2) {
                return j2 / ((long) 1000);
            }
            j2 = DurationKt.m36823a(j2);
        }
        switch (WhenMappings.$EnumSwitchMapping$1[timeUnit2.ordinal()]) {
            case 1:
                return DurationKt.m36825b(j2);
            case 2:
                return j2 * ((long) 1000);
            case 3:
                return j2;
            case 4:
                if (j2 >= 1000) {
                    return j2 / ((long) 1000);
                }
                break;
            case 5:
                long j3 = j2 / ((long) 1000);
                long j4 = (long) 60;
                if (j3 >= j4) {
                    return j3 / j4;
                }
                break;
            case 6:
                long j5 = j2 / ((long) 60000);
                long j6 = (long) 60;
                if (j5 >= j6) {
                    return j5 / j6;
                }
                break;
            case 7:
                long j7 = j2 / ((long) 3600000);
                long j8 = (long) 24;
                if (j7 >= j8) {
                    return j7 / j8;
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return 0;
    }

    /* renamed from: a */
    private static final long m36815a(long j, long j2, long j3) {
        long access$nanosToMillis = DurationKt.m36823a(j3);
        long j4 = j2 + access$nanosToMillis;
        if (-4611686018426L > j4 || 4611686018426L < j4) {
            return DurationKt.m36827d(RangesKt.coerceIn(j4, -4611686018427387903L, 4611686018427387903L));
        }
        return DurationKt.m36826c(DurationKt.m36825b(j4) + (j3 - DurationKt.m36825b(access$nanosToMillis)));
    }

    /* renamed from: a */
    private static final void m36817a(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String padStart = StringsKt.padStart(String.valueOf(i2), i3, '0');
            CharSequence charSequence = padStart;
            int i4 = -1;
            int length = charSequence.length() - 1;
            while (true) {
                if (length < 0) {
                    break;
                }
                if (charSequence.charAt(length) != '0') {
                    i4 = length;
                    break;
                }
                length--;
            }
            int i5 = i4 + 1;
            if (z || i5 >= 3) {
                int i6 = ((i5 + 2) / 3) * 3;
                if (padStart != null) {
                    String substring = padStart.substring(0, i6);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb.append(substring);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (padStart != null) {
                String substring2 = padStart.substring(0, i5);
                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring2);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        sb.append(str);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0016\u0010\n\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/time/Duration$Companion;", "", "()V", "INFINITE", "Lcom/didiglobal/travel/infra/time/Duration;", "getINFINITE", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE$lib_common_release", "ZERO", "getZERO", "millis", "value", "", "(J)J", "of", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)J", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: Duration.kt */
    public static final class Companion {

        @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TimeUnit.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
                $EnumSwitchMapping$0[TimeUnit.MICROSECONDS.ordinal()] = 2;
                $EnumSwitchMapping$0[TimeUnit.MILLISECONDS.ordinal()] = 3;
                $EnumSwitchMapping$0[TimeUnit.SECONDS.ordinal()] = 4;
                $EnumSwitchMapping$0[TimeUnit.MINUTES.ordinal()] = 5;
                $EnumSwitchMapping$0[TimeUnit.HOURS.ordinal()] = 6;
                $EnumSwitchMapping$0[TimeUnit.DAYS.ordinal()] = 7;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long getZERO() {
            return Duration.f51442b;
        }

        public final long getINFINITE() {
            return Duration.f51443c;
        }

        public final long getNEG_INFINITE$lib_common_release() {
            return Duration.f51444d;
        }

        /* renamed from: of */
        public final long mo124926of(long j, TimeUnit timeUnit) {
            long j2;
            int i;
            Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
            int i2 = timeUnit.compareTo(TimeUnit.MILLISECONDS) < 0 ? 0 : 1;
            switch (WhenMappings.$EnumSwitchMapping$0[timeUnit.ordinal()]) {
                case 1:
                case 3:
                    return DurationKt.m36824a(j, i2);
                case 2:
                case 4:
                    j2 = (long) 1000;
                    break;
                case 5:
                    i = 60000;
                    break;
                case 6:
                    j2 = (long) 3600000;
                    break;
                case 7:
                    j *= (long) 3600000;
                    i = 24;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            j2 = (long) i;
            j *= j2;
            return DurationKt.m36824a(j, i2);
        }

        public final long millis(long j) {
            return DurationKt.m36824a(j, 1);
        }
    }
}
