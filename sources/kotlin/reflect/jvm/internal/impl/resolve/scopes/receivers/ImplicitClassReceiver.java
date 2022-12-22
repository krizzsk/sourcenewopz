package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: ImplicitClassReceiver.kt */
public class ImplicitClassReceiver implements ImplicitReceiver, ThisClassReceiver {

    /* renamed from: a */
    private final ClassDescriptor f60925a;

    /* renamed from: b */
    private final ImplicitClassReceiver f60926b;

    /* renamed from: c */
    private final ClassDescriptor f60927c;

    public ImplicitClassReceiver(ClassDescriptor classDescriptor, ImplicitClassReceiver implicitClassReceiver) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        this.f60925a = classDescriptor;
        this.f60926b = implicitClassReceiver == null ? this : implicitClassReceiver;
        this.f60927c = this.f60925a;
    }

    public final ClassDescriptor getClassDescriptor() {
        return this.f60925a;
    }

    public SimpleType getType() {
        SimpleType defaultType = this.f60925a.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "classDescriptor.defaultType");
        return defaultType;
    }

    public boolean equals(Object obj) {
        ClassDescriptor classDescriptor = this.f60925a;
        ClassDescriptor classDescriptor2 = null;
        ImplicitClassReceiver implicitClassReceiver = obj instanceof ImplicitClassReceiver ? (ImplicitClassReceiver) obj : null;
        if (implicitClassReceiver != null) {
            classDescriptor2 = implicitClassReceiver.f60925a;
        }
        return Intrinsics.areEqual((Object) classDescriptor, (Object) classDescriptor2);
    }

    public int hashCode() {
        return this.f60925a.hashCode();
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }
}
