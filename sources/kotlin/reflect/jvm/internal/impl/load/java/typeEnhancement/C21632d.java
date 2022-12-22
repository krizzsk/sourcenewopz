package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.osgi.framework.VersionRange;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d */
/* compiled from: signatureEnhancement.kt */
final class C21632d {

    /* renamed from: a */
    private final KotlinType f60622a;

    /* renamed from: b */
    private final JavaDefaultQualifiers f60623b;

    /* renamed from: c */
    private final TypeParameterDescriptor f60624c;

    /* renamed from: d */
    private final boolean f60625d;

    /* renamed from: b */
    public final KotlinType mo178240b() {
        return this.f60622a;
    }

    /* renamed from: c */
    public final JavaDefaultQualifiers mo178241c() {
        return this.f60623b;
    }

    /* renamed from: d */
    public final TypeParameterDescriptor mo178242d() {
        return this.f60624c;
    }

    /* renamed from: e */
    public final boolean mo178243e() {
        return this.f60625d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21632d)) {
            return false;
        }
        C21632d dVar = (C21632d) obj;
        return Intrinsics.areEqual((Object) this.f60622a, (Object) dVar.f60622a) && Intrinsics.areEqual((Object) this.f60623b, (Object) dVar.f60623b) && Intrinsics.areEqual((Object) this.f60624c, (Object) dVar.f60624c) && this.f60625d == dVar.f60625d;
    }

    public int hashCode() {
        int hashCode = this.f60622a.hashCode() * 31;
        JavaDefaultQualifiers javaDefaultQualifiers = this.f60623b;
        int i = 0;
        int hashCode2 = (hashCode + (javaDefaultQualifiers == null ? 0 : javaDefaultQualifiers.hashCode())) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.f60624c;
        if (typeParameterDescriptor != null) {
            i = typeParameterDescriptor.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.f60625d;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "TypeAndDefaultQualifiers(type=" + this.f60622a + ", defaultQualifiers=" + this.f60623b + ", typeParameterForArgument=" + this.f60624c + ", isFromStarProjection=" + this.f60625d + VersionRange.RIGHT_OPEN;
    }

    public C21632d(KotlinType kotlinType, JavaDefaultQualifiers javaDefaultQualifiers, TypeParameterDescriptor typeParameterDescriptor, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.f60622a = kotlinType;
        this.f60623b = javaDefaultQualifiers;
        this.f60624c = typeParameterDescriptor;
        this.f60625d = z;
    }

    /* renamed from: a */
    public final KotlinType mo178239a() {
        return this.f60622a;
    }
}
