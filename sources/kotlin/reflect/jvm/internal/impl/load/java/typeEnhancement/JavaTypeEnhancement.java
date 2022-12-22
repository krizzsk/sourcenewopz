package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.osgi.framework.VersionRange;

/* compiled from: typeEnhancement.kt */
public final class JavaTypeEnhancement {

    /* renamed from: a */
    private final JavaResolverSettings f60595a;

    public JavaTypeEnhancement(JavaResolverSettings javaResolverSettings) {
        Intrinsics.checkNotNullParameter(javaResolverSettings, "javaResolverSettings");
        this.f60595a = javaResolverSettings;
    }

    /* compiled from: typeEnhancement.kt */
    private static class Result {
        private final int subtreeSize;
        private final KotlinType type;
        private final boolean wereChanges;

        public Result(KotlinType kotlinType, int i, boolean z) {
            Intrinsics.checkNotNullParameter(kotlinType, "type");
            this.type = kotlinType;
            this.subtreeSize = i;
            this.wereChanges = z;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public KotlinType getType() {
            return this.type;
        }

        public final boolean getWereChanges() {
            return this.wereChanges;
        }

        public final KotlinType getTypeIfChanged() {
            KotlinType type2 = getType();
            if (getWereChanges()) {
                return type2;
            }
            return null;
        }
    }

    /* compiled from: typeEnhancement.kt */
    private static final class SimpleResult extends Result {
        private final SimpleType type;

        public SimpleType getType() {
            return this.type;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SimpleResult(SimpleType simpleType, int i, boolean z) {
            super(simpleType, i, z);
            Intrinsics.checkNotNullParameter(simpleType, "type");
            this.type = simpleType;
        }
    }

    public final KotlinType enhance(KotlinType kotlinType, Function1<? super Integer, JavaTypeQualifiers> function1, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(function1, "qualifiers");
        return m44687a(kotlinType.unwrap(), function1, 0, z).getTypeIfChanged();
    }

    /* renamed from: a */
    private final KotlinType m44690a(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinType enhancement = TypeWithEnhancementKt.getEnhancement(kotlinType2);
        KotlinType enhancement2 = TypeWithEnhancementKt.getEnhancement(kotlinType);
        if (enhancement2 == null) {
            if (enhancement == null) {
                return null;
            }
            enhancement2 = enhancement;
        }
        if (enhancement == null) {
            return enhancement2;
        }
        return KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(enhancement2), FlexibleTypesKt.upperIfFlexible(enhancement));
    }

    /* renamed from: a */
    private final Result m44687a(UnwrappedType unwrappedType, Function1<? super Integer, JavaTypeQualifiers> function1, int i, boolean z) {
        UnwrappedType unwrappedType2;
        UnwrappedType unwrappedType3 = unwrappedType;
        KotlinType kotlinType = unwrappedType3;
        boolean z2 = false;
        if (KotlinTypeKt.isError(kotlinType)) {
            return new Result(kotlinType, 1, false);
        }
        if (unwrappedType3 instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrappedType3;
            Function1<? super Integer, JavaTypeQualifiers> function12 = function1;
            int i2 = i;
            boolean z3 = unwrappedType3 instanceof RawType;
            boolean z4 = z;
            SimpleResult a = m44689a(flexibleType.getLowerBound(), function12, i2, TypeComponentPosition.FLEXIBLE_LOWER, z3, z4);
            SimpleResult a2 = m44689a(flexibleType.getUpperBound(), function12, i2, TypeComponentPosition.FLEXIBLE_UPPER, z3, z4);
            boolean z5 = a.getSubtreeSize() == a2.getSubtreeSize();
            if (!_Assertions.ENABLED || z5) {
                if (a.getWereChanges() || a2.getWereChanges()) {
                    z2 = true;
                }
                KotlinType a3 = m44690a(a.getType(), a2.getType());
                if (z2) {
                    if (unwrappedType3 instanceof RawTypeImpl) {
                        unwrappedType2 = new RawTypeImpl(a.getType(), a2.getType());
                    } else {
                        unwrappedType2 = KotlinTypeFactory.flexibleType(a.getType(), a2.getType());
                    }
                    unwrappedType3 = TypeWithEnhancementKt.wrapEnhancement(unwrappedType2, a3);
                }
                return new Result(unwrappedType3, a.getSubtreeSize(), z2);
            }
            throw new AssertionError("Different tree sizes of bounds: lower = (" + flexibleType.getLowerBound() + ", " + a.getSubtreeSize() + "), upper = (" + flexibleType.getUpperBound() + ", " + a2.getSubtreeSize() + VersionRange.RIGHT_OPEN);
        }
        if (unwrappedType3 instanceof SimpleType) {
            return m44688a(this, (SimpleType) unwrappedType3, function1, i, TypeComponentPosition.INFLEXIBLE, false, z, 8, (Object) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: a */
    static /* synthetic */ SimpleResult m44688a(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, Function1 function1, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2, int i2, Object obj) {
        return javaTypeEnhancement.m44689a(simpleType, function1, i, typeComponentPosition, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2);
    }

    /* renamed from: a */
    private final SimpleResult m44689a(SimpleType simpleType, Function1<? super Integer, JavaTypeQualifiers> function1, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2) {
        List<TypeProjection> list;
        boolean z3;
        TypeProjection typeProjection;
        SimpleType simpleType2 = simpleType;
        Function1<? super Integer, JavaTypeQualifiers> function12 = function1;
        TypeComponentPosition typeComponentPosition2 = typeComponentPosition;
        boolean z4 = z2;
        if (!TypeComponentPositionKt.shouldEnhance(typeComponentPosition) && simpleType.getArguments().isEmpty()) {
            return new SimpleResult(simpleType2, 1, false);
        }
        ClassifierDescriptor declarationDescriptor = simpleType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return new SimpleResult(simpleType2, 1, false);
        }
        JavaTypeQualifiers invoke = function12.invoke(Integer.valueOf(i));
        C21631c access$enhanceMutability = TypeEnhancementKt.m44705a(declarationDescriptor, invoke, typeComponentPosition2);
        ClassifierDescriptor classifierDescriptor = (ClassifierDescriptor) access$enhanceMutability.mo178234a();
        Annotations b = access$enhanceMutability.mo178235b();
        TypeConstructor typeConstructor = classifierDescriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "enhancedClassifier.typeConstructor");
        int i2 = i + 1;
        boolean z5 = b != null;
        if (!z4 || !z) {
            Iterable arguments = simpleType.getArguments();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
            int i3 = 0;
            for (Object next : arguments) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                TypeProjection typeProjection2 = (TypeProjection) next;
                if (typeProjection2.isStarProjection()) {
                    int i5 = i2 + 1;
                    if (function12.invoke(Integer.valueOf(i2)).getNullability() != NullabilityQualifier.NOT_NULL || z) {
                        typeProjection = TypeUtils.makeStarProjection(classifierDescriptor.getTypeConstructor().getParameters().get(i3));
                        Intrinsics.checkNotNullExpressionValue(typeProjection, "{\n                      …x])\n                    }");
                    } else {
                        KotlinType makeNotNullable = TypeUtilsKt.makeNotNullable(typeProjection2.getType().unwrap());
                        Variance projectionKind = typeProjection2.getProjectionKind();
                        Intrinsics.checkNotNullExpressionValue(projectionKind, "arg.projectionKind");
                        typeProjection = TypeUtilsKt.createProjection(makeNotNullable, projectionKind, typeConstructor.getParameters().get(i3));
                    }
                    i2 = i5;
                } else {
                    Result a = m44687a(typeProjection2.getType().unwrap(), function12, i2, z4);
                    z5 = z5 || a.getWereChanges();
                    i2 += a.getSubtreeSize();
                    KotlinType type = a.getType();
                    Variance projectionKind2 = typeProjection2.getProjectionKind();
                    Intrinsics.checkNotNullExpressionValue(projectionKind2, "arg.projectionKind");
                    typeProjection = TypeUtilsKt.createProjection(type, projectionKind2, typeConstructor.getParameters().get(i3));
                }
                arrayList.add(typeProjection);
                function12 = function1;
                i3 = i4;
            }
            z3 = z5;
            list = (List) arrayList;
        } else {
            i2 += simpleType.getArguments().size();
            boolean z6 = z5;
            list = simpleType.getArguments();
            z3 = z6;
        }
        C21631c access$getEnhancedNullability = TypeEnhancementKt.m44706a((KotlinType) simpleType2, invoke, typeComponentPosition2);
        boolean booleanValue = ((Boolean) access$getEnhancedNullability.mo178234a()).booleanValue();
        Annotations b2 = access$getEnhancedNullability.mo178235b();
        int i6 = i2 - i;
        if (!(z3 || b2 != null)) {
            return new SimpleResult(simpleType2, i6, false);
        }
        boolean z7 = false;
        SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(TypeEnhancementKt.m44703a((List<? extends Annotations>) CollectionsKt.listOfNotNull((T[]) new Annotations[]{simpleType.getAnnotations(), b, b2})), typeConstructor, list, booleanValue, (KotlinTypeRefiner) null, 16, (Object) null);
        if (invoke.isNotNullTypeParameter()) {
            simpleType$default = m44691a(simpleType$default);
        }
        if (b2 != null && invoke.isNullabilityQualifierForWarning()) {
            z7 = true;
        }
        return new SimpleResult((SimpleType) (z7 ? TypeWithEnhancementKt.wrapEnhancement(simpleType2, simpleType$default) : simpleType$default), i6, true);
    }

    /* renamed from: a */
    private final SimpleType m44691a(SimpleType simpleType) {
        if (this.f60595a.getCorrectNullabilityForNotNullTypeParameter()) {
            return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, true);
        }
        return new NotNullTypeParameter(simpleType);
    }
}
