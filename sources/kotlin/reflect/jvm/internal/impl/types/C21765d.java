package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.d */
/* compiled from: KotlinTypeFactory.kt */
final class C21765d extends SimpleType {

    /* renamed from: a */
    private final TypeConstructor f61169a;

    /* renamed from: b */
    private final List<TypeProjection> f61170b;

    /* renamed from: c */
    private final boolean f61171c;

    /* renamed from: d */
    private final MemberScope f61172d;

    /* renamed from: e */
    private final Function1<KotlinTypeRefiner, SimpleType> f61173e;

    public TypeConstructor getConstructor() {
        return this.f61169a;
    }

    public List<TypeProjection> getArguments() {
        return this.f61170b;
    }

    public boolean isMarkedNullable() {
        return this.f61171c;
    }

    public MemberScope getMemberScope() {
        return this.f61172d;
    }

    public C21765d(TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z, MemberScope memberScope, Function1<? super KotlinTypeRefiner, ? extends SimpleType> function1) {
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter(function1, "refinedTypeFactory");
        this.f61169a = typeConstructor;
        this.f61170b = list;
        this.f61171c = z;
        this.f61172d = memberScope;
        this.f61173e = function1;
        if (getMemberScope() instanceof ErrorUtils.ErrorScope) {
            throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + getMemberScope() + 10 + getConstructor());
        }
    }

    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    public SimpleType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        if (annotations.isEmpty()) {
            return this;
        }
        return new C21755a(this, annotations);
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        if (z == isMarkedNullable()) {
            return this;
        }
        if (z) {
            return new C21757c(this);
        }
        return new C21756b(this);
    }

    /* renamed from: a */
    public SimpleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType invoke = this.f61173e.invoke(kotlinTypeRefiner);
        return invoke == null ? this : invoke;
    }
}
