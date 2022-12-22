package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

/* compiled from: CapturedTypeApproximation.kt */
public final class ApproximationBounds<T> {

    /* renamed from: a */
    private final T f61176a;

    /* renamed from: b */
    private final T f61177b;

    public final T component1() {
        return this.f61176a;
    }

    public final T component2() {
        return this.f61177b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApproximationBounds)) {
            return false;
        }
        ApproximationBounds approximationBounds = (ApproximationBounds) obj;
        return Intrinsics.areEqual((Object) this.f61176a, (Object) approximationBounds.f61176a) && Intrinsics.areEqual((Object) this.f61177b, (Object) approximationBounds.f61177b);
    }

    public int hashCode() {
        T t = this.f61176a;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.f61177b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.f61176a + ", upper=" + this.f61177b + VersionRange.RIGHT_OPEN;
    }

    public ApproximationBounds(T t, T t2) {
        this.f61176a = t;
        this.f61177b = t2;
    }

    public final T getLower() {
        return this.f61176a;
    }

    public final T getUpper() {
        return this.f61177b;
    }
}
