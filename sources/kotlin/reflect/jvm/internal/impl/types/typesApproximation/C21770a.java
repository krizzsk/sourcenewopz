package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.typesApproximation.a */
/* compiled from: CapturedTypeApproximation.kt */
final class C21770a {

    /* renamed from: a */
    private final TypeParameterDescriptor f61178a;

    /* renamed from: b */
    private final KotlinType f61179b;

    /* renamed from: c */
    private final KotlinType f61180c;

    public C21770a(TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkNotNullParameter(kotlinType, "inProjection");
        Intrinsics.checkNotNullParameter(kotlinType2, "outProjection");
        this.f61178a = typeParameterDescriptor;
        this.f61179b = kotlinType;
        this.f61180c = kotlinType2;
    }

    /* renamed from: a */
    public final TypeParameterDescriptor mo180161a() {
        return this.f61178a;
    }

    /* renamed from: b */
    public final KotlinType mo180162b() {
        return this.f61179b;
    }

    /* renamed from: c */
    public final KotlinType mo180163c() {
        return this.f61180c;
    }

    /* renamed from: d */
    public final boolean mo180164d() {
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(this.f61179b, this.f61180c);
    }
}
