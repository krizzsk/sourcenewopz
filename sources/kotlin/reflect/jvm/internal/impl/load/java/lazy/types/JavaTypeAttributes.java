package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.osgi.framework.VersionRange;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeAttributes {

    /* renamed from: a */
    private final TypeUsage f60578a;

    /* renamed from: b */
    private final JavaTypeFlexibility f60579b;

    /* renamed from: c */
    private final boolean f60580c;

    /* renamed from: d */
    private final Set<TypeParameterDescriptor> f60581d;

    /* renamed from: e */
    private final SimpleType f60582e;

    public static /* synthetic */ JavaTypeAttributes copy$default(JavaTypeAttributes javaTypeAttributes, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set<TypeParameterDescriptor> set, SimpleType simpleType, int i, Object obj) {
        if ((i & 1) != 0) {
            typeUsage = javaTypeAttributes.f60578a;
        }
        if ((i & 2) != 0) {
            javaTypeFlexibility = javaTypeAttributes.f60579b;
        }
        JavaTypeFlexibility javaTypeFlexibility2 = javaTypeFlexibility;
        if ((i & 4) != 0) {
            z = javaTypeAttributes.f60580c;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            set = javaTypeAttributes.f60581d;
        }
        Set<TypeParameterDescriptor> set2 = set;
        if ((i & 16) != 0) {
            simpleType = javaTypeAttributes.f60582e;
        }
        return javaTypeAttributes.copy(typeUsage, javaTypeFlexibility2, z2, set2, simpleType);
    }

    public final JavaTypeAttributes copy(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set<? extends TypeParameterDescriptor> set, SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        return new JavaTypeAttributes(typeUsage, javaTypeFlexibility, z, set, simpleType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaTypeAttributes)) {
            return false;
        }
        JavaTypeAttributes javaTypeAttributes = (JavaTypeAttributes) obj;
        return this.f60578a == javaTypeAttributes.f60578a && this.f60579b == javaTypeAttributes.f60579b && this.f60580c == javaTypeAttributes.f60580c && Intrinsics.areEqual((Object) this.f60581d, (Object) javaTypeAttributes.f60581d) && Intrinsics.areEqual((Object) this.f60582e, (Object) javaTypeAttributes.f60582e);
    }

    public int hashCode() {
        int hashCode = ((this.f60578a.hashCode() * 31) + this.f60579b.hashCode()) * 31;
        boolean z = this.f60580c;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        Set<TypeParameterDescriptor> set = this.f60581d;
        int i2 = 0;
        int hashCode2 = (i + (set == null ? 0 : set.hashCode())) * 31;
        SimpleType simpleType = this.f60582e;
        if (simpleType != null) {
            i2 = simpleType.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.f60578a + ", flexibility=" + this.f60579b + ", isForAnnotationParameter=" + this.f60580c + ", visitedTypeParameters=" + this.f60581d + ", defaultType=" + this.f60582e + VersionRange.RIGHT_OPEN;
    }

    public JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set<? extends TypeParameterDescriptor> set, SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        this.f60578a = typeUsage;
        this.f60579b = javaTypeFlexibility;
        this.f60580c = z;
        this.f60581d = set;
        this.f60582e = simpleType;
    }

    public final TypeUsage getHowThisTypeIsUsed() {
        return this.f60578a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set set, SimpleType simpleType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeUsage, (i & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : set, (i & 16) != 0 ? null : simpleType);
    }

    public final JavaTypeFlexibility getFlexibility() {
        return this.f60579b;
    }

    public final boolean isForAnnotationParameter() {
        return this.f60580c;
    }

    public final Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.f60581d;
    }

    public final SimpleType getDefaultType() {
        return this.f60582e;
    }

    public final JavaTypeAttributes withFlexibility(JavaTypeFlexibility javaTypeFlexibility) {
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        return copy$default(this, (TypeUsage) null, javaTypeFlexibility, false, (Set) null, (SimpleType) null, 29, (Object) null);
    }

    public final JavaTypeAttributes withDefaultType(SimpleType simpleType) {
        return copy$default(this, (TypeUsage) null, (JavaTypeFlexibility) null, false, (Set) null, simpleType, 15, (Object) null);
    }

    public final JavaTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Set<TypeParameterDescriptor> set = this.f60581d;
        return copy$default(this, (TypeUsage) null, (JavaTypeFlexibility) null, false, set != null ? SetsKt.plus(set, typeParameterDescriptor) : SetsKt.setOf(typeParameterDescriptor), (SimpleType) null, 23, (Object) null);
    }
}
