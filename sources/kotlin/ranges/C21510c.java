package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, mo175978d2 = {"Lkotlin/ranges/ComparableRange;", "T", "", "Lkotlin/ranges/ClosedRange;", "start", "endInclusive", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getEndInclusive", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getStart", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.ranges.c */
/* compiled from: Ranges.kt */
class C21510c<T extends Comparable<? super T>> implements ClosedRange<T> {

    /* renamed from: a */
    private final T f59997a;

    /* renamed from: b */
    private final T f59998b;

    public C21510c(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, "start");
        Intrinsics.checkNotNullParameter(t2, "endInclusive");
        this.f59997a = t;
        this.f59998b = t2;
    }

    public boolean contains(T t) {
        Intrinsics.checkNotNullParameter(t, "value");
        return ClosedRange.DefaultImpls.contains(this, t);
    }

    public boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }

    public T getStart() {
        return this.f59997a;
    }

    public T getEndInclusive() {
        return this.f59998b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C21510c) {
            if (!isEmpty() || !((C21510c) obj).isEmpty()) {
                C21510c cVar = (C21510c) obj;
                if (!Intrinsics.areEqual((Object) getStart(), (Object) cVar.getStart()) || !Intrinsics.areEqual((Object) getEndInclusive(), (Object) cVar.getEndInclusive())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}
