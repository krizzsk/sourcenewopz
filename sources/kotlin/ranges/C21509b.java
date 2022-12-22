package kotlin.ranges;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, mo175978d2 = {"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(FF)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Float;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.ranges.b */
/* compiled from: Ranges.kt */
final class C21509b implements ClosedFloatingPointRange<Float> {

    /* renamed from: a */
    private final float f59995a;

    /* renamed from: b */
    private final float f59996b;

    /* renamed from: a */
    public boolean mo177051a(float f, float f2) {
        return f <= f2;
    }

    public C21509b(float f, float f2) {
        this.f59995a = f;
        this.f59996b = f2;
    }

    public /* synthetic */ boolean contains(Comparable comparable) {
        return mo177050a(((Number) comparable).floatValue());
    }

    public /* synthetic */ boolean lessThanOrEquals(Comparable comparable, Comparable comparable2) {
        return mo177051a(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    /* renamed from: a */
    public Float getStart() {
        return Float.valueOf(this.f59995a);
    }

    /* renamed from: b */
    public Float getEndInclusive() {
        return Float.valueOf(this.f59996b);
    }

    /* renamed from: a */
    public boolean mo177050a(float f) {
        return f >= this.f59995a && f <= this.f59996b;
    }

    public boolean isEmpty() {
        return this.f59995a > this.f59996b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C21509b) {
            if (!isEmpty() || !((C21509b) obj).isEmpty()) {
                C21509b bVar = (C21509b) obj;
                if (!(this.f59995a == bVar.f59995a && this.f59996b == bVar.f59996b)) {
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
        return (Float.valueOf(this.f59995a).hashCode() * 31) + Float.valueOf(this.f59996b).hashCode();
    }

    public String toString() {
        return this.f59995a + ".." + this.f59996b;
    }
}
