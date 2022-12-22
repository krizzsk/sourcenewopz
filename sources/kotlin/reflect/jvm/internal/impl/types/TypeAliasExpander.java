package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: TypeAliasExpander.kt */
public final class TypeAliasExpander {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c */
    private static final TypeAliasExpander f61129c = new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false);

    /* renamed from: a */
    private final TypeAliasExpansionReportStrategy f61130a;

    /* renamed from: b */
    private final boolean f61131b;

    public TypeAliasExpander(TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, boolean z) {
        Intrinsics.checkNotNullParameter(typeAliasExpansionReportStrategy, "reportStrategy");
        this.f61130a = typeAliasExpansionReportStrategy;
        this.f61131b = z;
    }

    public final SimpleType expand(TypeAliasExpansion typeAliasExpansion, Annotations annotations) {
        Intrinsics.checkNotNullParameter(typeAliasExpansion, "typeAliasExpansion");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        return m45048a(typeAliasExpansion, annotations, false, 0, true);
    }

    /* renamed from: a */
    private final SimpleType m45048a(TypeAliasExpansion typeAliasExpansion, Annotations annotations, boolean z, int i, boolean z2) {
        TypeProjection a = m45050a(new TypeProjectionImpl(Variance.INVARIANT, typeAliasExpansion.getDescriptor().getUnderlyingType()), typeAliasExpansion, (TypeParameterDescriptor) null, i);
        KotlinType type = a.getType();
        Intrinsics.checkNotNullExpressionValue(type, "expandedProjection.type");
        SimpleType asSimpleType = TypeSubstitutionKt.asSimpleType(type);
        if (KotlinTypeKt.isError(asSimpleType)) {
            return asSimpleType;
        }
        boolean z3 = a.getProjectionKind() == Variance.INVARIANT;
        if (!_Assertions.ENABLED || z3) {
            m45051a(asSimpleType.getAnnotations(), annotations);
            SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(m45044a(asSimpleType, annotations), z);
            Intrinsics.checkNotNullExpressionValue(makeNullableIfNeeded, "expandedType.combineAnno…fNeeded(it, isNullable) }");
            return z2 ? SpecialTypesKt.withAbbreviation(makeNullableIfNeeded, m45047a(typeAliasExpansion, annotations, z)) : makeNullableIfNeeded;
        }
        throw new AssertionError("Type alias expansion: result for " + typeAliasExpansion.getDescriptor() + " is " + a.getProjectionKind() + ", should be invariant");
    }

    /* renamed from: a */
    private final SimpleType m45047a(TypeAliasExpansion typeAliasExpansion, Annotations annotations, boolean z) {
        TypeConstructor typeConstructor = typeAliasExpansion.getDescriptor().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, typeAliasExpansion.getArguments(), z, MemberScope.Empty.INSTANCE);
    }

    /* renamed from: a */
    private final TypeProjection m45050a(TypeProjection typeProjection, TypeAliasExpansion typeAliasExpansion, TypeParameterDescriptor typeParameterDescriptor, int i) {
        Variance variance;
        UnwrappedType unwrappedType;
        Companion.assertRecursionDepth(i, typeAliasExpansion.getDescriptor());
        if (typeProjection.isStarProjection()) {
            Intrinsics.checkNotNull(typeParameterDescriptor);
            TypeProjection makeStarProjection = TypeUtils.makeStarProjection(typeParameterDescriptor);
            Intrinsics.checkNotNullExpressionValue(makeStarProjection, "makeStarProjection(typeParameterDescriptor!!)");
            return makeStarProjection;
        }
        KotlinType type = typeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type, "underlyingProjection.type");
        TypeProjection replacement = typeAliasExpansion.getReplacement(type.getConstructor());
        if (replacement == null) {
            return m45049a(typeProjection, typeAliasExpansion, i);
        }
        if (replacement.isStarProjection()) {
            Intrinsics.checkNotNull(typeParameterDescriptor);
            TypeProjection makeStarProjection2 = TypeUtils.makeStarProjection(typeParameterDescriptor);
            Intrinsics.checkNotNullExpressionValue(makeStarProjection2, "makeStarProjection(typeParameterDescriptor!!)");
            return makeStarProjection2;
        }
        UnwrappedType unwrap = replacement.getType().unwrap();
        TypeAliasExpander typeAliasExpander = this;
        Variance projectionKind = replacement.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(projectionKind, "argument.projectionKind");
        Variance projectionKind2 = typeProjection.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(projectionKind2, "underlyingProjection.projectionKind");
        if (!(projectionKind2 == projectionKind || projectionKind2 == Variance.INVARIANT)) {
            if (projectionKind == Variance.INVARIANT) {
                projectionKind = projectionKind2;
            } else {
                typeAliasExpander.f61130a.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrap);
            }
        }
        if (typeParameterDescriptor == null) {
            variance = null;
        } else {
            variance = typeParameterDescriptor.getVariance();
        }
        if (variance == null) {
            variance = Variance.INVARIANT;
        }
        Intrinsics.checkNotNullExpressionValue(variance, "typeParameterDescriptor?…nce ?: Variance.INVARIANT");
        if (!(variance == projectionKind || variance == Variance.INVARIANT)) {
            if (projectionKind == Variance.INVARIANT) {
                projectionKind = Variance.INVARIANT;
            } else {
                typeAliasExpander.f61130a.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrap);
            }
        }
        m45051a(type.getAnnotations(), unwrap.getAnnotations());
        if (unwrap instanceof DynamicType) {
            unwrappedType = m45043a((DynamicType) unwrap, type.getAnnotations());
        } else {
            unwrappedType = m45053b(TypeSubstitutionKt.asSimpleType(unwrap), type);
        }
        return new TypeProjectionImpl(projectionKind, unwrappedType);
    }

    /* renamed from: a */
    private final DynamicType m45043a(DynamicType dynamicType, Annotations annotations) {
        return dynamicType.replaceAnnotations(m45042a((KotlinType) dynamicType, annotations));
    }

    /* renamed from: a */
    private final SimpleType m45044a(SimpleType simpleType, Annotations annotations) {
        KotlinType kotlinType = simpleType;
        return KotlinTypeKt.isError(kotlinType) ? simpleType : TypeSubstitutionKt.replace$default(simpleType, (List) null, m45042a(kotlinType, annotations), 1, (Object) null);
    }

    /* renamed from: a */
    private final Annotations m45042a(KotlinType kotlinType, Annotations annotations) {
        if (KotlinTypeKt.isError(kotlinType)) {
            return kotlinType.getAnnotations();
        }
        return AnnotationsKt.composeAnnotations(annotations, kotlinType.getAnnotations());
    }

    /* renamed from: a */
    private final void m45051a(Annotations annotations, Annotations annotations2) {
        Collection hashSet = new HashSet();
        Iterator it = annotations.iterator();
        while (it.hasNext()) {
            hashSet.add(((AnnotationDescriptor) it.next()).getFqName());
        }
        HashSet hashSet2 = (HashSet) hashSet;
        Iterator it2 = annotations2.iterator();
        while (it2.hasNext()) {
            AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor) it2.next();
            if (hashSet2.contains(annotationDescriptor.getFqName())) {
                this.f61130a.repeatedAnnotation(annotationDescriptor);
            }
        }
    }

    /* renamed from: a */
    private final SimpleType m45045a(SimpleType simpleType, KotlinType kotlinType) {
        SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(simpleType, kotlinType.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(makeNullableIfNeeded, "makeNullableIfNeeded(thi…romType.isMarkedNullable)");
        return makeNullableIfNeeded;
    }

    /* renamed from: b */
    private final SimpleType m45053b(SimpleType simpleType, KotlinType kotlinType) {
        return m45044a(m45045a(simpleType, kotlinType), kotlinType.getAnnotations());
    }

    /* renamed from: a */
    private final TypeProjection m45049a(TypeProjection typeProjection, TypeAliasExpansion typeAliasExpansion, int i) {
        KotlinType unwrap = typeProjection.getType().unwrap();
        if (DynamicTypesKt.isDynamic(unwrap)) {
            return typeProjection;
        }
        SimpleType asSimpleType = TypeSubstitutionKt.asSimpleType(unwrap);
        KotlinType kotlinType = asSimpleType;
        if (KotlinTypeKt.isError(kotlinType) || !TypeUtilsKt.requiresTypeAliasExpansion(kotlinType)) {
            return typeProjection;
        }
        TypeConstructor constructor = asSimpleType.getConstructor();
        ClassifierDescriptor declarationDescriptor = constructor.getDeclarationDescriptor();
        int i2 = 0;
        boolean z = constructor.getParameters().size() == asSimpleType.getArguments().size();
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError(Intrinsics.stringPlus("Unexpected malformed type: ", asSimpleType));
        } else if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return typeProjection;
        } else {
            if (declarationDescriptor instanceof TypeAliasDescriptor) {
                TypeAliasDescriptor typeAliasDescriptor = (TypeAliasDescriptor) declarationDescriptor;
                if (typeAliasExpansion.isRecursion(typeAliasDescriptor)) {
                    this.f61130a.recursiveTypeAlias(typeAliasDescriptor);
                    return new TypeProjectionImpl(Variance.INVARIANT, ErrorUtils.createErrorType(Intrinsics.stringPlus("Recursive type alias: ", typeAliasDescriptor.getName())));
                }
                Iterable arguments = asSimpleType.getArguments();
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
                for (Object next : arguments) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    arrayList.add(m45050a((TypeProjection) next, typeAliasExpansion, constructor.getParameters().get(i2), i + 1));
                    i2 = i3;
                }
                SimpleType a = m45048a(TypeAliasExpansion.Companion.create(typeAliasExpansion, typeAliasDescriptor, (List) arrayList), asSimpleType.getAnnotations(), asSimpleType.isMarkedNullable(), i + 1, false);
                SimpleType a2 = m45046a(asSimpleType, typeAliasExpansion, i);
                if (!DynamicTypesKt.isDynamic(a)) {
                    a = SpecialTypesKt.withAbbreviation(a, a2);
                }
                return new TypeProjectionImpl(typeProjection.getProjectionKind(), a);
            }
            KotlinType a3 = m45046a(asSimpleType, typeAliasExpansion, i);
            m45052a(kotlinType, a3);
            return new TypeProjectionImpl(typeProjection.getProjectionKind(), a3);
        }
    }

    /* renamed from: a */
    private final SimpleType m45046a(SimpleType simpleType, TypeAliasExpansion typeAliasExpansion, int i) {
        TypeConstructor constructor = simpleType.getConstructor();
        Iterable arguments = simpleType.getArguments();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
        int i2 = 0;
        for (Object next : arguments) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) next;
            TypeProjection a = m45050a(typeProjection, typeAliasExpansion, constructor.getParameters().get(i2), i + 1);
            if (!a.isStarProjection()) {
                a = new TypeProjectionImpl(a.getProjectionKind(), TypeUtils.makeNullableIfNeeded(a.getType(), typeProjection.getType().isMarkedNullable()));
            }
            arrayList.add(a);
            i2 = i3;
        }
        return TypeSubstitutionKt.replace$default(simpleType, (List) arrayList, (Annotations) null, 2, (Object) null);
    }

    /* renamed from: a */
    private final void m45052a(KotlinType kotlinType, KotlinType kotlinType2) {
        TypeSubstitutor create = TypeSubstitutor.create(kotlinType2);
        Intrinsics.checkNotNullExpressionValue(create, "create(substitutedType)");
        int i = 0;
        for (Object next : kotlinType2.getArguments()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) next;
            if (!typeProjection.isStarProjection()) {
                KotlinType type = typeProjection.getType();
                Intrinsics.checkNotNullExpressionValue(type, "substitutedArgument.type");
                if (!TypeUtilsKt.containsTypeAliasParameters(type)) {
                    TypeProjection typeProjection2 = kotlinType.getArguments().get(i);
                    TypeParameterDescriptor typeParameterDescriptor = kotlinType.getConstructor().getParameters().get(i);
                    if (this.f61131b) {
                        TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy = this.f61130a;
                        KotlinType type2 = typeProjection2.getType();
                        Intrinsics.checkNotNullExpressionValue(type2, "unsubstitutedArgument.type");
                        KotlinType type3 = typeProjection.getType();
                        Intrinsics.checkNotNullExpressionValue(type3, "substitutedArgument.type");
                        Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "typeParameter");
                        typeAliasExpansionReportStrategy.boundsViolationInSubstitution(create, type2, type3, typeParameterDescriptor);
                    }
                }
            }
            i = i2;
        }
    }

    /* compiled from: TypeAliasExpander.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void assertRecursionDepth(int i, TypeAliasDescriptor typeAliasDescriptor) {
            if (i > 100) {
                throw new AssertionError(Intrinsics.stringPlus("Too deep recursion while expanding type alias ", typeAliasDescriptor.getName()));
            }
        }
    }
}
