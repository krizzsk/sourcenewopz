package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import org.osgi.framework.VersionRange;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedTypeConstructorImpl implements CapturedTypeConstructor {

    /* renamed from: a */
    private final TypeProjection f60868a;

    /* renamed from: b */
    private NewCapturedTypeConstructor f60869b;

    public Void getDeclarationDescriptor() {
        return null;
    }

    public boolean isDenotable() {
        return false;
    }

    public CapturedTypeConstructorImpl(TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "projection");
        this.f60868a = typeProjection;
        boolean z = getProjection().getProjectionKind() != Variance.INVARIANT;
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError(Intrinsics.stringPlus("Only nontrivial projections can be captured, not: ", getProjection()));
        }
    }

    public TypeProjection getProjection() {
        return this.f60868a;
    }

    public final NewCapturedTypeConstructor getNewTypeConstructor() {
        return this.f60869b;
    }

    public final void setNewTypeConstructor(NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this.f60869b = newCapturedTypeConstructor;
    }

    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    public Collection<KotlinType> getSupertypes() {
        KotlinType kotlinType;
        if (getProjection().getProjectionKind() == Variance.OUT_VARIANCE) {
            kotlinType = getProjection().getType();
        } else {
            kotlinType = getBuiltIns().getNullableAnyType();
        }
        Intrinsics.checkNotNullExpressionValue(kotlinType, "if (projection.projectio… builtIns.nullableAnyType");
        return CollectionsKt.listOf(kotlinType);
    }

    public String toString() {
        return "CapturedTypeConstructor(" + getProjection() + VersionRange.RIGHT_OPEN;
    }

    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = getProjection().getType().getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "projection.type.constructor.builtIns");
        return builtIns;
    }

    public CapturedTypeConstructorImpl refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection refine = getProjection().refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(refine, "projection.refine(kotlinTypeRefiner)");
        return new CapturedTypeConstructorImpl(refine);
    }
}
