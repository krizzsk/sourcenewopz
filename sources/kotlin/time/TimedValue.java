package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0018\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\bJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001a"}, mo175978d2 = {"Lkotlin/time/TimedValue;", "T", "", "value", "duration", "Lkotlin/time/Duration;", "(Ljava/lang/Object;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDuration-UwyO8pc", "()J", "J", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component2-UwyO8pc", "copy", "copy-RFiDyg4", "(Ljava/lang/Object;J)Lkotlin/time/TimedValue;", "equals", "", "other", "hashCode", "", "toString", "", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: measureTime.kt */
public final class TimedValue<T> {

    /* renamed from: a */
    private final T f61291a;

    /* renamed from: b */
    private final long f61292b;

    /* renamed from: copy-RFiDyg4$default  reason: not valid java name */
    public static /* synthetic */ TimedValue m48230copyRFiDyg4$default(TimedValue timedValue, T t, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            t = timedValue.f61291a;
        }
        if ((i & 2) != 0) {
            j = timedValue.f61292b;
        }
        return timedValue.m48232copyRFiDyg4(t, j);
    }

    public final T component1() {
        return this.f61291a;
    }

    /* renamed from: component2-UwyO8pc  reason: not valid java name */
    public final long m48231component2UwyO8pc() {
        return this.f61292b;
    }

    /* renamed from: copy-RFiDyg4  reason: not valid java name */
    public final TimedValue<T> m48232copyRFiDyg4(T t, long j) {
        return new TimedValue<>(t, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimedValue)) {
            return false;
        }
        TimedValue timedValue = (TimedValue) obj;
        return Intrinsics.areEqual((Object) this.f61291a, (Object) timedValue.f61291a) && this.f61292b == timedValue.f61292b;
    }

    public int hashCode() {
        T t = this.f61291a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.f61292b;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "TimedValue(value=" + this.f61291a + ", duration=" + Duration.m48192toStringimpl(this.f61292b) + ")";
    }

    private TimedValue(T t, long j) {
        this.f61291a = t;
        this.f61292b = j;
    }

    public /* synthetic */ TimedValue(Object obj, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, j);
    }

    /* renamed from: getDuration-UwyO8pc  reason: not valid java name */
    public final long m48233getDurationUwyO8pc() {
        return this.f61292b;
    }

    public final T getValue() {
        return this.f61291a;
    }
}
