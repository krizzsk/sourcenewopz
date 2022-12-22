package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.osgi.framework.VersionRange;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.c */
/* compiled from: typeEnhancement.kt */
final class C21631c<T> {

    /* renamed from: a */
    private final T f60620a;

    /* renamed from: b */
    private final Annotations f60621b;

    /* renamed from: a */
    public final T mo178234a() {
        return this.f60620a;
    }

    /* renamed from: b */
    public final Annotations mo178235b() {
        return this.f60621b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21631c)) {
            return false;
        }
        C21631c cVar = (C21631c) obj;
        return Intrinsics.areEqual((Object) this.f60620a, (Object) cVar.f60620a) && Intrinsics.areEqual((Object) this.f60621b, (Object) cVar.f60621b);
    }

    public int hashCode() {
        T t = this.f60620a;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        Annotations annotations = this.f60621b;
        if (annotations != null) {
            i = annotations.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "EnhancementResult(result=" + this.f60620a + ", enhancementAnnotations=" + this.f60621b + VersionRange.RIGHT_OPEN;
    }

    public C21631c(T t, Annotations annotations) {
        this.f60620a = t;
        this.f60621b = annotations;
    }
}
