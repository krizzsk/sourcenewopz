package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: signatureEnhancement.kt */
public final class SignatureEnhancement {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AnnotationTypeQualifierResolver f60610a;

    /* renamed from: b */
    private final JavaTypeEnhancementState f60611b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final JavaTypeEnhancement f60612c;

    public SignatureEnhancement(AnnotationTypeQualifierResolver annotationTypeQualifierResolver, JavaTypeEnhancementState javaTypeEnhancementState, JavaTypeEnhancement javaTypeEnhancement) {
        Intrinsics.checkNotNullParameter(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        Intrinsics.checkNotNullParameter(javaTypeEnhancement, "typeEnhancement");
        this.f60610a = annotationTypeQualifierResolver;
        this.f60611b = javaTypeEnhancementState;
        this.f60612c = javaTypeEnhancement;
    }

    /* renamed from: a */
    private final NullabilityQualifierWithMigrationStatus m44694a(AnnotationDescriptor annotationDescriptor, boolean z) {
        ConstantValue<?> firstArgument = DescriptorUtilsKt.firstArgument(annotationDescriptor);
        EnumValue enumValue = firstArgument instanceof EnumValue ? (EnumValue) firstArgument : null;
        if (enumValue == null) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, z);
        }
        String asString = enumValue.getEnumEntryName().asString();
        switch (asString.hashCode()) {
            case 73135176:
                if (!asString.equals("MAYBE")) {
                    return null;
                }
                break;
            case 74175084:
                if (!asString.equals("NEVER")) {
                    return null;
                }
                break;
            case 433141802:
                if (!asString.equals("UNKNOWN")) {
                    return null;
                }
                return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.FORCE_FLEXIBILITY, z);
            case 1933739535:
                if (!asString.equals("ALWAYS")) {
                    return null;
                }
                return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, z);
            default:
                return null;
        }
        return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, z);
    }

    public final NullabilityQualifierWithMigrationStatus extractNullability(AnnotationDescriptor annotationDescriptor, boolean z, boolean z2) {
        NullabilityQualifierWithMigrationStatus a;
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        NullabilityQualifierWithMigrationStatus a2 = m44695a(annotationDescriptor, z, z2);
        if (a2 != null) {
            return a2;
        }
        AnnotationDescriptor resolveTypeQualifierAnnotation = this.f60610a.resolveTypeQualifierAnnotation(annotationDescriptor);
        if (resolveTypeQualifierAnnotation == null) {
            return null;
        }
        ReportLevel resolveJsr305AnnotationState = this.f60610a.resolveJsr305AnnotationState(annotationDescriptor);
        if (!resolveJsr305AnnotationState.isIgnore() && (a = m44695a(resolveTypeQualifierAnnotation, z, z2)) != null) {
            return NullabilityQualifierWithMigrationStatus.copy$default(a, (NullabilityQualifier) null, resolveJsr305AnnotationState.isWarning(), 1, (Object) null);
        }
        return null;
    }

    /* renamed from: a */
    private final NullabilityQualifierWithMigrationStatus m44695a(AnnotationDescriptor annotationDescriptor, boolean z, boolean z2) {
        FqName fqName = annotationDescriptor.getFqName();
        if (fqName == null) {
            return null;
        }
        NullabilityQualifierWithMigrationStatus a = m44696a(fqName, annotationDescriptor, (annotationDescriptor instanceof LazyJavaAnnotationDescriptor) && (((LazyJavaAnnotationDescriptor) annotationDescriptor).isFreshlySupportedTypeUseAnnotation() || z2) && !z);
        if (a == null) {
            return null;
        }
        return (a.isForWarningOnly() || !(annotationDescriptor instanceof PossiblyExternalAnnotationDescriptor) || !((PossiblyExternalAnnotationDescriptor) annotationDescriptor).isIdeExternalAnnotation()) ? a : NullabilityQualifierWithMigrationStatus.copy$default(a, (NullabilityQualifier) null, true, 1, (Object) null);
    }

    /* renamed from: a */
    private final NullabilityQualifierWithMigrationStatus m44696a(FqName fqName, AnnotationDescriptor annotationDescriptor, boolean z) {
        ReportLevel invoke = this.f60611b.getGetReportLevelForAnnotation().invoke(fqName);
        if (invoke.isIgnore()) {
            return null;
        }
        boolean z2 = invoke.isWarning() || z;
        if (JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS().contains(fqName)) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, z2);
        }
        if (JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS().contains(fqName)) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, z2);
        }
        if (Intrinsics.areEqual((Object) fqName, (Object) JvmAnnotationNamesKt.getJSPECIFY_NULLABLE())) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, z2);
        }
        if (Intrinsics.areEqual((Object) fqName, (Object) JvmAnnotationNamesKt.getJSPECIFY_NULLNESS_UNKNOWN())) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.FORCE_FLEXIBILITY, z2);
        }
        if (Intrinsics.areEqual((Object) fqName, (Object) JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION())) {
            return m44694a(annotationDescriptor, z2);
        }
        if (Intrinsics.areEqual((Object) fqName, (Object) JvmAnnotationNamesKt.getCOMPATQUAL_NULLABLE_ANNOTATION())) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, z2);
        }
        if (Intrinsics.areEqual((Object) fqName, (Object) JvmAnnotationNamesKt.getCOMPATQUAL_NONNULL_ANNOTATION())) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, z2);
        }
        if (Intrinsics.areEqual((Object) fqName, (Object) JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION())) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, z2);
        }
        if (Intrinsics.areEqual((Object) fqName, (Object) JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION())) {
            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, z2);
        }
        return null;
    }

    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(LazyJavaResolverContext lazyJavaResolverContext, Collection<? extends D> collection) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(collection, "platformSignatures");
        Iterable<CallableMemberDescriptor> iterable = collection;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (CallableMemberDescriptor b : iterable) {
            arrayList.add(m44699b(b, lazyJavaResolverContext));
        }
        return (List) arrayList;
    }

    /* renamed from: a */
    private final <D extends CallableMemberDescriptor> Annotations m44693a(D d, LazyJavaResolverContext lazyJavaResolverContext) {
        ClassifierDescriptor topLevelContainingClassifier = DescriptorUtilKt.getTopLevelContainingClassifier((DeclarationDescriptor) d);
        if (topLevelContainingClassifier == null) {
            return d.getAnnotations();
        }
        List<JavaAnnotation> list = null;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = topLevelContainingClassifier instanceof LazyJavaClassDescriptor ? (LazyJavaClassDescriptor) topLevelContainingClassifier : null;
        if (lazyJavaClassDescriptor != null) {
            list = lazyJavaClassDescriptor.getModuleAnnotations();
        }
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            return d.getAnnotations();
        }
        Iterable<JavaAnnotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (JavaAnnotation lazyJavaAnnotationDescriptor : iterable) {
            arrayList.add(new LazyJavaAnnotationDescriptor(lazyJavaResolverContext, lazyJavaAnnotationDescriptor, true));
        }
        return Annotations.Companion.create(CollectionsKt.plus(d.getAnnotations(), (Annotations) (List) arrayList));
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01c4 A[EDGE_INSN: B:139:0x01c4->B:90:0x01c4 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0207 A[EDGE_INSN: B:140:0x0207->B:112:0x0207 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01e0  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> D m44699b(D r19, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r20) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            boolean r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
            if (r0 != 0) goto L_0x0009
            return r8
        L_0x0009:
            r9 = r8
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor r9 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor) r9
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r0 = r9.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r1 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE
            r10 = 1
            if (r0 != r1) goto L_0x0024
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = r9.getOriginal()
            java.util.Collection r0 = r0.getOverriddenDescriptors()
            int r0 = r0.size()
            if (r0 != r10) goto L_0x0024
            return r8
        L_0x0024:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r18.m44693a(r19, (kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext) r20)
            r1 = r20
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.copyWithNewDefaultTypeQualifiers(r1, r0)
            boolean r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor
            r11 = 0
            if (r0 == 0) goto L_0x0057
            r0 = r8
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor r0 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl r1 = r0.getGetter()
            if (r1 != 0) goto L_0x003e
        L_0x003c:
            r1 = 0
            goto L_0x0045
        L_0x003e:
            boolean r1 = r1.isDefault()
            if (r1 != 0) goto L_0x003c
            r1 = 1
        L_0x0045:
            if (r1 == 0) goto L_0x0057
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl r0 = r0.getGetter()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r1 = "getter!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0
            r12 = r0
            goto L_0x0058
        L_0x0057:
            r12 = r8
        L_0x0058:
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r0 = r9.getExtensionReceiverParameter()
            r13 = 0
            if (r0 == 0) goto L_0x0082
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r0 != 0) goto L_0x0065
            r0 = r13
            goto L_0x0066
        L_0x0065:
            r0 = r12
        L_0x0066:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0
            if (r0 != 0) goto L_0x006c
            r0 = r13
            goto L_0x0074
        L_0x006c:
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor$UserDataKey<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r1 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER
            java.lang.Object r0 = r0.getUserData(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
        L_0x0074:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1 r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts r0 = r7.m44697a(r8, r0, r4, r1)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.enhance$default(r0, r13, r10, r13)
            r14 = r0
            goto L_0x0083
        L_0x0082:
            r14 = r13
        L_0x0083:
            boolean r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor
            if (r0 == 0) goto L_0x008b
            r0 = r8
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor r0 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor) r0
            goto L_0x008c
        L_0x008b:
            r0 = r13
        L_0x008c:
            if (r0 != 0) goto L_0x0090
        L_0x008e:
            r15 = r13
            goto L_0x00b1
        L_0x0090:
            kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents r1 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r0.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0
            r3 = 3
            java.lang.String r0 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r0, r11, r11, r3, r13)
            java.lang.String r0 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt.signature(r1, r2, r0)
            if (r0 != 0) goto L_0x00a6
            goto L_0x008e
        L_0x00a6:
            java.util.Map r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE()
            java.lang.Object r0 = r1.get(r0)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo r0 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo) r0
            r15 = r0
        L_0x00b1:
            if (r15 != 0) goto L_0x00b4
            goto L_0x010e
        L_0x00b4:
            java.util.List r0 = r15.getParametersInfo()
            int r0 = r0.size()
            java.util.List r1 = r9.getValueParameters()
            int r1 = r1.size()
            if (r0 != r1) goto L_0x00c8
            r0 = 1
            goto L_0x00c9
        L_0x00c8:
            r0 = 0
        L_0x00c9:
            boolean r1 = kotlin._Assertions.ENABLED
            if (r1 == 0) goto L_0x010e
            if (r0 == 0) goto L_0x00d0
            goto L_0x010e
        L_0x00d0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Predefined enhancement info for "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = " has "
            r0.append(r1)
            java.util.List r1 = r15.getParametersInfo()
            int r1 = r1.size()
            r0.append(r1)
            java.lang.String r1 = ", but "
            r0.append(r1)
            java.util.List r1 = r9.getValueParameters()
            int r1 = r1.size()
            r0.append(r1)
            java.lang.String r1 = " expected"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x010e:
            java.util.List r0 = r12.getValueParameters()
            java.lang.String r1 = "annotationOwnerForMember.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r6 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r6)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x012a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x015e
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r2
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1 r3 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1
            r3.<init>(r2)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts r3 = r7.m44697a(r8, r2, r4, r3)
            if (r15 != 0) goto L_0x0145
        L_0x0143:
            r2 = r13
            goto L_0x0156
        L_0x0145:
            java.util.List r5 = r15.getParametersInfo()
            if (r5 != 0) goto L_0x014c
            goto L_0x0143
        L_0x014c:
            int r2 = r2.getIndex()
            java.lang.Object r2 = kotlin.collections.CollectionsKt.getOrNull(r5, r2)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r2 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo) r2
        L_0x0156:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult r2 = r3.enhance(r2)
            r1.add(r2)
            goto L_0x012a
        L_0x015e:
            r16 = r1
            java.util.List r16 = (java.util.List) r16
            r2 = r12
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated) r2
            r3 = 1
            boolean r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
            if (r0 != 0) goto L_0x016c
            r0 = r13
            goto L_0x016d
        L_0x016c:
            r0 = r8
        L_0x016d:
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r0
            if (r0 != 0) goto L_0x0173
        L_0x0171:
            r0 = 0
            goto L_0x017a
        L_0x0173:
            boolean r0 = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt.isJavaField(r0)
            if (r0 != r10) goto L_0x0171
            r0 = 1
        L_0x017a:
            if (r0 == 0) goto L_0x017f
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r0 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.FIELD
            goto L_0x0181
        L_0x017f:
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r0 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE
        L_0x0181:
            r5 = r0
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1 r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1.INSTANCE
            r17 = r0
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r0 = r18
            r1 = r19
            r11 = 10
            r6 = r17
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts r0 = r0.m44698a(r1, r2, r3, r4, r5, r6)
            if (r15 != 0) goto L_0x0198
            r1 = r13
            goto L_0x019c
        L_0x0198:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r1 = r15.getReturnTypeInfo()
        L_0x019c:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult r0 = r0.enhance(r1)
            if (r14 != 0) goto L_0x01a4
        L_0x01a2:
            r1 = 0
            goto L_0x01ab
        L_0x01a4:
            boolean r1 = r14.getContainsFunctionN()
            if (r1 != r10) goto L_0x01a2
            r1 = 1
        L_0x01ab:
            if (r1 != 0) goto L_0x01e2
            boolean r1 = r0.getContainsFunctionN()
            if (r1 != 0) goto L_0x01e2
            r1 = r16
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r2 = r1 instanceof java.util.Collection
            if (r2 == 0) goto L_0x01c6
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x01c6
        L_0x01c4:
            r1 = 0
            goto L_0x01dd
        L_0x01c6:
            java.util.Iterator r1 = r1.iterator()
        L_0x01ca:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01c4
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult r2 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.PartEnhancementResult) r2
            boolean r2 = r2.getContainsFunctionN()
            if (r2 == 0) goto L_0x01ca
            r1 = 1
        L_0x01dd:
            if (r1 == 0) goto L_0x01e0
            goto L_0x01e2
        L_0x01e0:
            r1 = 0
            goto L_0x01e3
        L_0x01e2:
            r1 = 1
        L_0x01e3:
            if (r14 != 0) goto L_0x01e7
        L_0x01e5:
            r2 = 0
            goto L_0x01ee
        L_0x01e7:
            boolean r2 = r14.getWereChanges()
            if (r2 != r10) goto L_0x01e5
            r2 = 1
        L_0x01ee:
            if (r2 != 0) goto L_0x0225
            boolean r2 = r0.getWereChanges()
            if (r2 != 0) goto L_0x0225
            r2 = r16
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r3 = r2 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0209
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0209
        L_0x0207:
            r10 = 0
            goto L_0x021f
        L_0x0209:
            java.util.Iterator r2 = r2.iterator()
        L_0x020d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0207
            java.lang.Object r3 = r2.next()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult r3 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.PartEnhancementResult) r3
            boolean r3 = r3.getWereChanges()
            if (r3 == 0) goto L_0x020d
        L_0x021f:
            if (r10 != 0) goto L_0x0225
            if (r1 == 0) goto L_0x0224
            goto L_0x0225
        L_0x0224:
            return r8
        L_0x0225:
            if (r1 == 0) goto L_0x0238
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor$UserDataKey r1 = kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationKt.getDEPRECATED_FUNCTION_KEY()
            kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionN r2 = new kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionN
            r3 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            r2.<init>(r3)
            kotlin.Pair r1 = kotlin.TuplesKt.m42317to(r1, r2)
            goto L_0x0239
        L_0x0238:
            r1 = r13
        L_0x0239:
            if (r14 != 0) goto L_0x023c
            goto L_0x0240
        L_0x023c:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = r14.getType()
        L_0x0240:
            r2 = r16
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r11)
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
            r11 = 0
        L_0x0254:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0283
            java.lang.Object r4 = r2.next()
            int r5 = r11 + 1
            if (r11 >= 0) goto L_0x0265
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0265:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult r4 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.PartEnhancementResult) r4
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.ValueParameterData r6 = new kotlin.reflect.jvm.internal.impl.load.java.descriptors.ValueParameterData
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r4.getType()
            java.util.List r8 = r12.getValueParameters()
            java.lang.Object r8 = r8.get(r11)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r8
            boolean r8 = r8.declaresDefaultValue()
            r6.<init>(r4, r8)
            r3.add(r6)
            r11 = r5
            goto L_0x0254
        L_0x0283:
            java.util.List r3 = (java.util.List) r3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getType()
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor r0 = r9.enhance(r13, r3, r0, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.m44699b(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor");
    }

    public final List<KotlinType> enhanceTypeParameterBounds(TypeParameterDescriptor typeParameterDescriptor, List<? extends KotlinType> list, LazyJavaResolverContext lazyJavaResolverContext) {
        TypeParameterDescriptor typeParameterDescriptor2 = typeParameterDescriptor;
        List<? extends KotlinType> list2 = list;
        Intrinsics.checkNotNullParameter(typeParameterDescriptor2, "typeParameter");
        Intrinsics.checkNotNullParameter(list2, "bounds");
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "context");
        Iterable<KotlinType> iterable = list2;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (KotlinType kotlinType : iterable) {
            if (!TypeUtilsKt.contains(kotlinType, SignatureEnhancement$enhanceTypeParameterBounds$1$1.INSTANCE)) {
                SignatureParts signatureParts = r3;
                SignatureParts signatureParts2 = new SignatureParts(this, typeParameterDescriptor2, kotlinType, CollectionsKt.emptyList(), false, lazyJavaResolverContext, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, true, false, 128, (DefaultConstructorMarker) null);
                kotlinType = SignatureParts.enhance$default(signatureParts, (TypeEnhancementInfo) null, 1, (Object) null).getType();
            }
            arrayList.add(kotlinType);
            typeParameterDescriptor2 = typeParameterDescriptor;
        }
        return (List) arrayList;
    }

    public final KotlinType enhanceSuperType(KotlinType kotlinType, LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "context");
        return SignatureParts.enhance$default(new SignatureParts(this, (Annotated) null, kotlinType, CollectionsKt.emptyList(), false, lazyJavaResolverContext, AnnotationQualifierApplicabilityType.TYPE_USE, false, true, 64, (DefaultConstructorMarker) null), (TypeEnhancementInfo) null, 1, (Object) null).getType();
    }

    /* compiled from: signatureEnhancement.kt */
    private final class SignatureParts {
        private final AnnotationQualifierApplicabilityType containerApplicabilityType;
        private final LazyJavaResolverContext containerContext;
        private final Collection<KotlinType> fromOverridden;
        private final KotlinType fromOverride;
        private final boolean isCovariant;
        private final boolean isSuperTypesEnhancement;
        final /* synthetic */ SignatureEnhancement this$0;
        private final Annotated typeContainer;
        private final boolean typeParameterBounds;

        public SignatureParts(SignatureEnhancement signatureEnhancement, Annotated annotated, KotlinType kotlinType, Collection<? extends KotlinType> collection, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(signatureEnhancement, "this$0");
            Intrinsics.checkNotNullParameter(kotlinType, "fromOverride");
            Intrinsics.checkNotNullParameter(collection, "fromOverridden");
            Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "containerContext");
            Intrinsics.checkNotNullParameter(annotationQualifierApplicabilityType, "containerApplicabilityType");
            this.this$0 = signatureEnhancement;
            this.typeContainer = annotated;
            this.fromOverride = kotlinType;
            this.fromOverridden = collection;
            this.isCovariant = z;
            this.containerContext = lazyJavaResolverContext;
            this.containerApplicabilityType = annotationQualifierApplicabilityType;
            this.typeParameterBounds = z2;
            this.isSuperTypesEnhancement = z3;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ SignatureParts(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement r12, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r13, kotlin.reflect.jvm.internal.impl.types.KotlinType r14, java.util.Collection r15, boolean r16, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r17, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r18, boolean r19, boolean r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
            /*
                r11 = this;
                r0 = r21
                r10 = r11
                r1 = r12
                r10.this$0 = r1
                r2 = r0 & 64
                r3 = 0
                if (r2 == 0) goto L_0x000d
                r8 = 0
                goto L_0x000f
            L_0x000d:
                r8 = r19
            L_0x000f:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x0015
                r9 = 0
                goto L_0x0017
            L_0x0015:
                r9 = r20
            L_0x0017:
                r0 = r11
                r1 = r12
                r2 = r13
                r3 = r14
                r4 = r15
                r5 = r16
                r6 = r17
                r7 = r18
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.<init>(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated, kotlin.reflect.jvm.internal.impl.types.KotlinType, java.util.Collection, boolean, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        private final boolean isForVarargParameter() {
            Annotated annotated = this.typeContainer;
            KotlinType kotlinType = null;
            if (!(annotated instanceof ValueParameterDescriptor)) {
                annotated = null;
            }
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) annotated;
            if (valueParameterDescriptor != null) {
                kotlinType = valueParameterDescriptor.getVarargElementType();
            }
            return kotlinType != null;
        }

        public static /* synthetic */ PartEnhancementResult enhance$default(SignatureParts signatureParts, TypeEnhancementInfo typeEnhancementInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                typeEnhancementInfo = null;
            }
            return signatureParts.enhance(typeEnhancementInfo);
        }

        public final PartEnhancementResult enhance(TypeEnhancementInfo typeEnhancementInfo) {
            Function1<Integer, JavaTypeQualifiers> function1;
            boolean z;
            Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiersForOverride = computeIndexedQualifiersForOverride();
            PartEnhancementResult partEnhancementResult = null;
            if (typeEnhancementInfo == null) {
                function1 = null;
            } else {
                function1 = new C21627x3450d111(typeEnhancementInfo, computeIndexedQualifiersForOverride);
            }
            if (this.isSuperTypesEnhancement) {
                z = TypeUtils.containsStoppingAt(this.fromOverride, SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1.INSTANCE, SignatureEnhancement$SignatureParts$enhance$containsFunctionN$2.INSTANCE);
            } else {
                z = TypeUtils.contains(this.fromOverride, SignatureEnhancement$SignatureParts$enhance$containsFunctionN$3.INSTANCE);
            }
            JavaTypeEnhancement access$getTypeEnhancement$p = this.this$0.f60612c;
            KotlinType kotlinType = this.fromOverride;
            if (function1 != null) {
                computeIndexedQualifiersForOverride = function1;
            }
            KotlinType enhance = access$getTypeEnhancement$p.enhance(kotlinType, computeIndexedQualifiersForOverride, this.isSuperTypesEnhancement);
            if (enhance != null) {
                partEnhancementResult = new PartEnhancementResult(enhance, true, z);
            }
            return partEnhancementResult == null ? new PartEnhancementResult(this.fromOverride, false, z) : partEnhancementResult;
        }

        /* access modifiers changed from: private */
        public static final boolean enhance$containsFunctionN(UnwrappedType unwrappedType) {
            ClassifierDescriptor declarationDescriptor = unwrappedType.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor != null && Intrinsics.areEqual((Object) declarationDescriptor.getName(), (Object) JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME().shortName()) && Intrinsics.areEqual((Object) DescriptorUtilsKt.fqNameOrNull(declarationDescriptor), (Object) JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME())) {
                return true;
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers extractQualifiers(kotlin.reflect.jvm.internal.impl.types.KotlinType r12) {
            /*
                r11 = this;
                boolean r0 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.isFlexible(r12)
                if (r0 == 0) goto L_0x0018
                kotlin.reflect.jvm.internal.impl.types.FlexibleType r0 = kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.asFlexibleType(r12)
                kotlin.Pair r1 = new kotlin.Pair
                kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = r0.getLowerBound()
                kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r0.getUpperBound()
                r1.<init>(r2, r0)
                goto L_0x001d
            L_0x0018:
                kotlin.Pair r1 = new kotlin.Pair
                r1.<init>(r12, r12)
            L_0x001d:
                java.lang.Object r0 = r1.component1()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
                java.lang.Object r1 = r1.component2()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper r2 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper.INSTANCE
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r10 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers
                boolean r3 = r0.isMarkedNullable()
                r4 = 0
                if (r3 == 0) goto L_0x0038
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            L_0x0036:
                r5 = r3
                goto L_0x0042
            L_0x0038:
                boolean r3 = r1.isMarkedNullable()
                if (r3 != 0) goto L_0x0041
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                goto L_0x0036
            L_0x0041:
                r5 = r4
            L_0x0042:
                boolean r0 = r2.isReadOnly((kotlin.reflect.jvm.internal.impl.types.KotlinType) r0)
                if (r0 == 0) goto L_0x004b
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY
                goto L_0x0055
            L_0x004b:
                boolean r0 = r2.isMutable((kotlin.reflect.jvm.internal.impl.types.KotlinType) r1)
                if (r0 == 0) goto L_0x0054
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE
                goto L_0x0055
            L_0x0054:
                r0 = r4
            L_0x0055:
                kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12 = r12.unwrap()
                boolean r6 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameter
                r7 = 0
                r8 = 8
                r9 = 0
                r3 = r10
                r4 = r5
                r5 = r0
                r3.<init>(r4, r5, r6, r7, r8, r9)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.extractQualifiers(kotlin.reflect.jvm.internal.impl.types.KotlinType):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c8, code lost:
            if (((r13.getAffectsTypeParameterBasedTypes() || !kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isTypeParameter(r11)) && (r13.getAffectsStarProjection() || !r15)) != false) goto L_0x00ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fa, code lost:
            if (r1.getQualifier() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL) goto L_0x010e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x010c, code lost:
            if (r12 != false) goto L_0x010e;
         */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0114  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x013a  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x013c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers extractQualifiersFromAnnotations(kotlin.reflect.jvm.internal.impl.types.KotlinType r11, boolean r12, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r13, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r14, boolean r15) {
            /*
                r10 = this;
                r0 = 0
                if (r15 == 0) goto L_0x0016
                if (r14 != 0) goto L_0x0007
                r1 = r0
                goto L_0x000b
            L_0x0007:
                kotlin.reflect.jvm.internal.impl.types.Variance r1 = r14.getVariance()
            L_0x000b:
                kotlin.reflect.jvm.internal.impl.types.Variance r2 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
                if (r1 != r2) goto L_0x0016
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers$Companion r11 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers.Companion
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r11 = r11.getNONE()
                return r11
            L_0x0016:
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r1 = r10.containerContext
                kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r1 = r1.getComponents()
                kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings r1 = r1.getSettings()
                boolean r1 = r1.getTypeEnhancementImprovementsInStrictMode()
                r2 = 0
                r3 = 1
                if (r12 == 0) goto L_0x0083
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r4 = r10.typeContainer
                if (r4 == 0) goto L_0x0083
                boolean r5 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
                if (r5 != 0) goto L_0x0083
                if (r1 == 0) goto L_0x0083
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = r4.getAnnotations()
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement r5 = r10.this$0
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.Collection r6 = (java.util.Collection) r6
                java.util.Iterator r4 = r4.iterator()
            L_0x0045:
                boolean r7 = r4.hasNext()
                if (r7 == 0) goto L_0x0072
                java.lang.Object r7 = r4.next()
                r8 = r7
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor) r8
                kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver r9 = r5.f60610a
                kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$TypeQualifierWithApplicability r8 = r9.resolveAnnotation(r8)
                if (r8 != 0) goto L_0x005e
            L_0x005c:
                r8 = 1
                goto L_0x006c
            L_0x005e:
                java.util.List r8 = r8.component2()
                kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r9 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_USE
                boolean r8 = r8.contains(r9)
                if (r8 != 0) goto L_0x006b
                goto L_0x005c
            L_0x006b:
                r8 = 0
            L_0x006c:
                if (r8 == 0) goto L_0x0045
                r6.add(r7)
                goto L_0x0045
            L_0x0072:
                java.util.List r6 = (java.util.List) r6
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = r4.create(r6)
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r5 = r11.getAnnotations()
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt.composeAnnotations(r4, r5)
                goto L_0x009a
            L_0x0083:
                if (r12 == 0) goto L_0x0096
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r4 = r10.typeContainer
                if (r4 == 0) goto L_0x0096
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = r4.getAnnotations()
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r5 = r11.getAnnotations()
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt.composeAnnotations(r4, r5)
                goto L_0x009a
            L_0x0096:
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = r11.getAnnotations()
            L_0x009a:
                if (r12 == 0) goto L_0x00ac
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r12 = r10.containerContext
                kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r12 = r12.getDefaultTypeQualifiers()
                if (r12 != 0) goto L_0x00a6
                r13 = r0
                goto L_0x00ac
            L_0x00a6:
                kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r13 = r10.containerApplicabilityType
                kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r13 = r12.get(r13)
            L_0x00ac:
                if (r13 != 0) goto L_0x00b0
            L_0x00ae:
                r13 = r0
                goto L_0x00ca
            L_0x00b0:
                boolean r12 = r13.getAffectsTypeParameterBasedTypes()
                if (r12 != 0) goto L_0x00bc
                boolean r12 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isTypeParameter(r11)
                if (r12 != 0) goto L_0x00c5
            L_0x00bc:
                boolean r12 = r13.getAffectsStarProjection()
                if (r12 != 0) goto L_0x00c7
                if (r15 != 0) goto L_0x00c5
                goto L_0x00c7
            L_0x00c5:
                r12 = 0
                goto L_0x00c8
            L_0x00c7:
                r12 = 1
            L_0x00c8:
                if (r12 == 0) goto L_0x00ae
            L_0x00ca:
                kotlin.Pair r12 = r10.nullabilityInfoBoundsForTypeParameterUsage(r11)
                java.lang.Object r5 = r12.component1()
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus) r5
                java.lang.Object r12 = r12.component2()
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                boolean r6 = r10.typeParameterBounds
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r1 = r10.extractNullability(r4, r1, r6)
                if (r1 != 0) goto L_0x00e8
            L_0x00e6:
                r1 = r0
                goto L_0x00ea
            L_0x00e8:
                if (r15 != 0) goto L_0x00e6
            L_0x00ea:
                if (r1 != 0) goto L_0x00f1
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r14 = r10.computeNullabilityInfoInTheAbsenceOfExplicitAnnotation(r5, r13, r14)
                goto L_0x00f2
            L_0x00f1:
                r14 = r1
            L_0x00f2:
                if (r1 == 0) goto L_0x00ff
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r12 = r1.getQualifier()
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r13 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                if (r12 != r13) goto L_0x00fd
                goto L_0x010e
            L_0x00fd:
                r12 = 0
                goto L_0x010f
            L_0x00ff:
                if (r12 != 0) goto L_0x010e
                if (r13 != 0) goto L_0x0105
            L_0x0103:
                r12 = 0
                goto L_0x010c
            L_0x0105:
                boolean r12 = r13.getMakesTypeParameterNotNull()
                if (r12 != r3) goto L_0x0103
                r12 = 1
            L_0x010c:
                if (r12 == 0) goto L_0x00fd
            L_0x010e:
                r12 = 1
            L_0x010f:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r13 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers
                if (r14 != 0) goto L_0x0114
                goto L_0x0118
            L_0x0114:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = r14.getQualifier()
            L_0x0118:
                java.util.List r15 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS()
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY
                java.lang.Object r15 = extractQualifiersFromAnnotations$ifPresent(r15, r4, r1)
                java.util.List r1 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS()
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE
                java.lang.Object r1 = extractQualifiersFromAnnotations$ifPresent(r1, r4, r5)
                java.lang.Object r15 = extractQualifiersFromAnnotations$uniqueNotNull(r15, r1)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r15 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier) r15
                if (r12 == 0) goto L_0x013c
                boolean r11 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isTypeParameter(r11)
                if (r11 == 0) goto L_0x013c
                r11 = 1
                goto L_0x013d
            L_0x013c:
                r11 = 0
            L_0x013d:
                if (r14 != 0) goto L_0x0140
                goto L_0x0147
            L_0x0140:
                boolean r12 = r14.isForWarningOnly()
                if (r12 != r3) goto L_0x0147
                r2 = 1
            L_0x0147:
                r13.<init>(r0, r15, r11, r2)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.extractQualifiersFromAnnotations(kotlin.reflect.jvm.internal.impl.types.KotlinType, boolean, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers");
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static final <T> T extractQualifiersFromAnnotations$ifPresent(java.util.List<kotlin.reflect.jvm.internal.impl.name.FqName> r3, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4, T r5) {
            /*
                java.lang.Iterable r3 = (java.lang.Iterable) r3
                boolean r0 = r3 instanceof java.util.Collection
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0013
                r0 = r3
                java.util.Collection r0 = (java.util.Collection) r0
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x0013
            L_0x0011:
                r1 = 0
                goto L_0x002e
            L_0x0013:
                java.util.Iterator r3 = r3.iterator()
            L_0x0017:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x0011
                java.lang.Object r0 = r3.next()
                kotlin.reflect.jvm.internal.impl.name.FqName r0 = (kotlin.reflect.jvm.internal.impl.name.FqName) r0
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r0 = r4.findAnnotation(r0)
                if (r0 == 0) goto L_0x002b
                r0 = 1
                goto L_0x002c
            L_0x002b:
                r0 = 0
            L_0x002c:
                if (r0 == 0) goto L_0x0017
            L_0x002e:
                if (r1 == 0) goto L_0x0031
                goto L_0x0032
            L_0x0031:
                r5 = 0
            L_0x0032:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.extractQualifiersFromAnnotations$ifPresent(java.util.List, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, java.lang.Object):java.lang.Object");
        }

        private static final <T> T extractQualifiersFromAnnotations$uniqueNotNull(T t, T t2) {
            if (t == null || t2 == null || Intrinsics.areEqual((Object) t, (Object) t2)) {
                return t == null ? t2 : t;
            }
            return null;
        }

        private final NullabilityQualifierWithMigrationStatus computeNullabilityInfoInTheAbsenceOfExplicitAnnotation(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, JavaDefaultQualifiers javaDefaultQualifiers, TypeParameterDescriptor typeParameterDescriptor) {
            NullabilityQualifierWithMigrationStatus nullabilityQualifier;
            NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2 = null;
            if (nullabilityQualifierWithMigrationStatus == null) {
                if (javaDefaultQualifiers == null || (nullabilityQualifier = javaDefaultQualifiers.getNullabilityQualifier()) == null) {
                    nullabilityQualifierWithMigrationStatus = null;
                } else {
                    nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(nullabilityQualifier.getQualifier(), nullabilityQualifier.isForWarningOnly());
                }
            }
            if (typeParameterDescriptor != null) {
                nullabilityQualifierWithMigrationStatus2 = boundsNullability(typeParameterDescriptor);
            }
            if (nullabilityQualifierWithMigrationStatus2 == null) {
                return nullabilityQualifierWithMigrationStatus;
            }
            if (javaDefaultQualifiers == null && nullabilityQualifierWithMigrationStatus == null && nullabilityQualifierWithMigrationStatus2.getQualifier() == NullabilityQualifier.NULLABLE) {
                return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.FORCE_FLEXIBILITY, nullabilityQualifierWithMigrationStatus2.isForWarningOnly());
            }
            if (nullabilityQualifierWithMigrationStatus == null) {
                return nullabilityQualifierWithMigrationStatus2;
            }
            return mostSpecific(nullabilityQualifierWithMigrationStatus2, nullabilityQualifierWithMigrationStatus);
        }

        private final NullabilityQualifierWithMigrationStatus mostSpecific(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus2) {
            if (nullabilityQualifierWithMigrationStatus.getQualifier() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                return nullabilityQualifierWithMigrationStatus2;
            }
            if (nullabilityQualifierWithMigrationStatus2.getQualifier() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                return nullabilityQualifierWithMigrationStatus;
            }
            if (nullabilityQualifierWithMigrationStatus.getQualifier() == NullabilityQualifier.NULLABLE) {
                return nullabilityQualifierWithMigrationStatus2;
            }
            if (nullabilityQualifierWithMigrationStatus2.getQualifier() == NullabilityQualifier.NULLABLE) {
                return nullabilityQualifierWithMigrationStatus;
            }
            boolean z = nullabilityQualifierWithMigrationStatus.getQualifier() == nullabilityQualifierWithMigrationStatus2.getQualifier() && nullabilityQualifierWithMigrationStatus.getQualifier() == NullabilityQualifier.NOT_NULL;
            if (!_Assertions.ENABLED || z) {
                return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, (DefaultConstructorMarker) null);
            }
            throw new AssertionError("Expected everything is NOT_NULL, but " + nullabilityQualifierWithMigrationStatus + " and " + nullabilityQualifierWithMigrationStatus2 + " are found");
        }

        private final Pair<NullabilityQualifierWithMigrationStatus, Boolean> nullabilityInfoBoundsForTypeParameterUsage(KotlinType kotlinType) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
            NullabilityQualifierWithMigrationStatus boundsNullability = typeParameterDescriptor == null ? null : boundsNullability(typeParameterDescriptor);
            boolean z = false;
            if (boundsNullability == null) {
                return new Pair<>(null, false);
            }
            NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, boundsNullability.isForWarningOnly());
            if (boundsNullability.getQualifier() == NullabilityQualifier.NOT_NULL) {
                z = true;
            }
            return new Pair<>(nullabilityQualifierWithMigrationStatus, Boolean.valueOf(z));
        }

        private final NullabilityQualifierWithMigrationStatus boundsNullability(TypeParameterDescriptor typeParameterDescriptor) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            if (typeParameterDescriptor instanceof LazyJavaTypeParameterDescriptor) {
                LazyJavaTypeParameterDescriptor lazyJavaTypeParameterDescriptor = (LazyJavaTypeParameterDescriptor) typeParameterDescriptor;
                List<KotlinType> upperBounds = lazyJavaTypeParameterDescriptor.getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "upperBounds");
                Iterable iterable = upperBounds;
                boolean z6 = false;
                boolean z7 = true;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it = iterable.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!KotlinTypeKt.isError((KotlinType) it.next())) {
                                z = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = true;
                if (!z) {
                    List<KotlinType> upperBounds2 = lazyJavaTypeParameterDescriptor.getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds2, "upperBounds");
                    Iterable iterable2 = upperBounds2;
                    if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                        Iterator it2 = iterable2.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (!SignatureEnhancementKt.m44702a((KotlinType) it2.next())) {
                                    z2 = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                        List<KotlinType> upperBounds3 = lazyJavaTypeParameterDescriptor.getUpperBounds();
                        Intrinsics.checkNotNullExpressionValue(upperBounds3, "upperBounds");
                        Iterable iterable3 = upperBounds3;
                        if (!(iterable3 instanceof Collection) || !((Collection) iterable3).isEmpty()) {
                            Iterator it3 = iterable3.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                }
                                KotlinType kotlinType = (KotlinType) it3.next();
                                if (!(kotlinType instanceof FlexibleTypeWithEnhancement) || KotlinTypeKt.isNullable(((FlexibleTypeWithEnhancement) kotlinType).getEnhancement())) {
                                    z5 = false;
                                    continue;
                                } else {
                                    z5 = true;
                                    continue;
                                }
                                if (z5) {
                                    z3 = true;
                                    break;
                                }
                            }
                        }
                        z3 = false;
                        if (z3) {
                            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, true);
                        }
                        List<KotlinType> upperBounds4 = lazyJavaTypeParameterDescriptor.getUpperBounds();
                        Intrinsics.checkNotNullExpressionValue(upperBounds4, "upperBounds");
                        Iterable iterable4 = upperBounds4;
                        if (!(iterable4 instanceof Collection) || !((Collection) iterable4).isEmpty()) {
                            Iterator it4 = iterable4.iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    break;
                                }
                                KotlinType kotlinType2 = (KotlinType) it4.next();
                                if (!(kotlinType2 instanceof FlexibleTypeWithEnhancement) || !KotlinTypeKt.isNullable(((FlexibleTypeWithEnhancement) kotlinType2).getEnhancement())) {
                                    z4 = false;
                                    continue;
                                } else {
                                    z4 = true;
                                    continue;
                                }
                                if (z4) {
                                    z6 = true;
                                    break;
                                }
                            }
                        }
                        if (z6) {
                            return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, true);
                        }
                        return null;
                    }
                    List<KotlinType> upperBounds5 = lazyJavaTypeParameterDescriptor.getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds5, "upperBounds");
                    Iterable iterable5 = upperBounds5;
                    if (!(iterable5 instanceof Collection) || !((Collection) iterable5).isEmpty()) {
                        Iterator it5 = iterable5.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                break;
                            }
                            KotlinType kotlinType3 = (KotlinType) it5.next();
                            Intrinsics.checkNotNullExpressionValue(kotlinType3, "it");
                            if (!KotlinTypeKt.isNullable(kotlinType3)) {
                                break;
                            }
                        }
                    }
                    z7 = false;
                    return new NullabilityQualifierWithMigrationStatus(z7 ? NullabilityQualifier.NOT_NULL : NullabilityQualifier.NULLABLE, false, 2, (DefaultConstructorMarker) null);
                }
            }
            return null;
        }

        private final NullabilityQualifierWithMigrationStatus extractNullability(Annotations annotations, boolean z, boolean z2) {
            SignatureEnhancement signatureEnhancement = this.this$0;
            Iterator it = annotations.iterator();
            while (it.hasNext()) {
                NullabilityQualifierWithMigrationStatus extractNullability = signatureEnhancement.extractNullability((AnnotationDescriptor) it.next(), z, z2);
                if (extractNullability != null) {
                    return extractNullability;
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x007b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> computeIndexedQualifiersForOverride() {
            /*
                r17 = this;
                r7 = r17
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> r0 = r7.fromOverridden
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r1 = new java.util.ArrayList
                r2 = 10
                int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
                r1.<init>(r2)
                java.util.Collection r1 = (java.util.Collection) r1
                java.util.Iterator r0 = r0.iterator()
            L_0x0017:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x002b
                java.lang.Object r2 = r0.next()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
                java.util.List r2 = r7.toIndexed(r2)
                r1.add(r2)
                goto L_0x0017
            L_0x002b:
                r8 = r1
                java.util.List r8 = (java.util.List) r8
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r7.fromOverride
                java.util.List r9 = r7.toIndexed(r0)
                boolean r0 = r7.isCovariant
                r11 = 1
                if (r0 == 0) goto L_0x006c
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> r0 = r7.fromOverridden
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                boolean r1 = r0 instanceof java.util.Collection
                if (r1 == 0) goto L_0x004c
                r1 = r0
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x004c
            L_0x004a:
                r0 = 0
                goto L_0x0068
            L_0x004c:
                java.util.Iterator r0 = r0.iterator()
            L_0x0050:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x004a
                java.lang.Object r1 = r0.next()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
                kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker r2 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT
                kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r7.fromOverride
                boolean r1 = r2.equalTypes(r1, r3)
                r1 = r1 ^ r11
                if (r1 == 0) goto L_0x0050
                r0 = 1
            L_0x0068:
                if (r0 == 0) goto L_0x006c
                r12 = 1
                goto L_0x006d
            L_0x006c:
                r12 = 0
            L_0x006d:
                if (r12 == 0) goto L_0x0071
                r13 = 1
                goto L_0x0076
            L_0x0071:
                int r0 = r9.size()
                r13 = r0
            L_0x0076:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[] r14 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[r13]
                r15 = 0
            L_0x0079:
                if (r15 >= r13) goto L_0x00ee
                if (r15 != 0) goto L_0x007f
                r4 = 1
                goto L_0x0080
            L_0x007f:
                r4 = 0
            L_0x0080:
                if (r4 != 0) goto L_0x0087
                if (r12 != 0) goto L_0x0085
                goto L_0x0087
            L_0x0085:
                r0 = 0
                goto L_0x0088
            L_0x0087:
                r0 = 1
            L_0x0088:
                boolean r1 = kotlin._Assertions.ENABLED
                if (r1 == 0) goto L_0x0099
                if (r0 == 0) goto L_0x008f
                goto L_0x0099
            L_0x008f:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                java.lang.String r1 = "Only head type constructors should be computed"
                r0.<init>(r1)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                throw r0
            L_0x0099:
                java.lang.Object r0 = r9.get(r15)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d r0 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.C21632d) r0
                kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r0.mo178240b()
                kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r3 = r0.mo178241c()
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r5 = r0.mo178242d()
                boolean r6 = r0.mo178243e()
                r0 = r8
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Collection r2 = (java.util.Collection) r2
                java.util.Iterator r0 = r0.iterator()
            L_0x00bd:
                boolean r16 = r0.hasNext()
                if (r16 == 0) goto L_0x00df
                java.lang.Object r16 = r0.next()
                r10 = r16
                java.util.List r10 = (java.util.List) r10
                java.lang.Object r10 = kotlin.collections.CollectionsKt.getOrNull(r10, r15)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d r10 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.C21632d) r10
                if (r10 != 0) goto L_0x00d5
                r10 = 0
                goto L_0x00d9
            L_0x00d5:
                kotlin.reflect.jvm.internal.impl.types.KotlinType r10 = r10.mo178239a()
            L_0x00d9:
                if (r10 == 0) goto L_0x00bd
                r2.add(r10)
                goto L_0x00bd
            L_0x00df:
                java.util.List r2 = (java.util.List) r2
                java.util.Collection r2 = (java.util.Collection) r2
                r0 = r17
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r0 = r0.computeQualifiersForOverride(r1, r2, r3, r4, r5, r6)
                r14[r15] = r0
                int r15 = r15 + 1
                goto L_0x0079
            L_0x00ee:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1 r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1
                r0.<init>(r14)
                kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.computeIndexedQualifiersForOverride():kotlin.jvm.functions.Function1");
        }

        private final List<C21632d> toIndexed(KotlinType kotlinType) {
            ArrayList arrayList = new ArrayList(1);
            toIndexed$add(this, arrayList, kotlinType, this.containerContext, (TypeParameterDescriptor) null);
            return arrayList;
        }

        private static final void toIndexed$add(SignatureParts signatureParts, ArrayList<C21632d> arrayList, KotlinType kotlinType, LazyJavaResolverContext lazyJavaResolverContext, TypeParameterDescriptor typeParameterDescriptor) {
            JavaDefaultQualifiers javaDefaultQualifiers;
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
            LazyJavaResolverContext copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, kotlinType.getAnnotations());
            JavaTypeQualifiersByElementType defaultTypeQualifiers = copyWithNewDefaultTypeQualifiers.getDefaultTypeQualifiers();
            if (defaultTypeQualifiers == null) {
                javaDefaultQualifiers = null;
            } else {
                if (signatureParts.typeParameterBounds) {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
                } else {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_USE;
                }
                javaDefaultQualifiers = defaultTypeQualifiers.get(annotationQualifierApplicabilityType);
            }
            arrayList.add(new C21632d(kotlinType, javaDefaultQualifiers, typeParameterDescriptor, false));
            if (!signatureParts.isSuperTypesEnhancement || !(kotlinType instanceof RawType)) {
                List<TypeParameterDescriptor> parameters = kotlinType.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "type.constructor.parameters");
                for (Pair pair : CollectionsKt.zip(kotlinType.getArguments(), parameters)) {
                    TypeProjection typeProjection = (TypeProjection) pair.component1();
                    TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor) pair.component2();
                    if (typeProjection.isStarProjection()) {
                        KotlinType type = typeProjection.getType();
                        Intrinsics.checkNotNullExpressionValue(type, "arg.type");
                        arrayList.add(new C21632d(type, javaDefaultQualifiers, typeParameterDescriptor2, true));
                    } else {
                        KotlinType type2 = typeProjection.getType();
                        Intrinsics.checkNotNullExpressionValue(type2, "arg.type");
                        toIndexed$add(signatureParts, arrayList, type2, copyWithNewDefaultTypeQualifiers, typeParameterDescriptor2);
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:72:0x014f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers computeQualifiersForOverride(kotlin.reflect.jvm.internal.impl.types.KotlinType r10, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> r11, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r12, boolean r13, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r14, boolean r15) {
            /*
                r9 = this;
                java.lang.Iterable r11 = (java.lang.Iterable) r11
                java.util.ArrayList r0 = new java.util.ArrayList
                r1 = 10
                int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r1)
                r0.<init>(r1)
                java.util.Collection r0 = (java.util.Collection) r0
                java.util.Iterator r1 = r11.iterator()
            L_0x0013:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0027
                java.lang.Object r2 = r1.next()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r2 = r9.extractQualifiers(r2)
                r0.add(r2)
                goto L_0x0013
            L_0x0027:
                java.util.List r0 = (java.util.List) r0
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.Collection r1 = (java.util.Collection) r1
                java.util.Iterator r2 = r0.iterator()
            L_0x0036:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x004c
                java.lang.Object r3 = r2.next()
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r3 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r3
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r3 = r3.getMutability()
                if (r3 == 0) goto L_0x0036
                r1.add(r3)
                goto L_0x0036
            L_0x004c:
                java.util.List r1 = (java.util.List) r1
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Set r1 = kotlin.collections.CollectionsKt.toSet(r1)
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Collection r2 = (java.util.Collection) r2
                java.util.Iterator r3 = r0.iterator()
            L_0x005f:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L_0x0075
                java.lang.Object r4 = r3.next()
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r4 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r4
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r4 = r4.getNullability()
                if (r4 == 0) goto L_0x005f
                r2.add(r4)
                goto L_0x005f
            L_0x0075:
                java.util.List r2 = (java.util.List) r2
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                java.util.Set r2 = kotlin.collections.CollectionsKt.toSet(r2)
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                java.util.Collection r3 = (java.util.Collection) r3
                java.util.Iterator r11 = r11.iterator()
            L_0x0088:
                boolean r4 = r11.hasNext()
                if (r4 == 0) goto L_0x00a6
                java.lang.Object r4 = r11.next()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
                kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.unwrapEnhancement(r4)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r4 = r9.extractQualifiers(r4)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r4 = r4.getNullability()
                if (r4 == 0) goto L_0x0088
                r3.add(r4)
                goto L_0x0088
            L_0x00a6:
                java.util.List r3 = (java.util.List) r3
                java.lang.Iterable r3 = (java.lang.Iterable) r3
                java.util.Set r11 = kotlin.collections.CollectionsKt.toSet(r3)
                r3 = r9
                r4 = r10
                r5 = r13
                r6 = r12
                r7 = r14
                r8 = r15
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r10 = r3.extractQualifiersFromAnnotations(r4, r5, r6, r7, r8)
                boolean r12 = r10.isNullabilityQualifierForWarning()
                r14 = 1
                r12 = r12 ^ r14
                r15 = 0
                if (r12 == 0) goto L_0x00c3
                r12 = r10
                goto L_0x00c4
            L_0x00c3:
                r12 = r15
            L_0x00c4:
                if (r12 != 0) goto L_0x00c8
                r12 = r15
                goto L_0x00cc
            L_0x00c8:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r12 = r12.getNullability()
            L_0x00cc:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = r10.getNullability()
                boolean r4 = r9.isCovariant
                r5 = 0
                if (r4 == 0) goto L_0x00d9
                if (r13 == 0) goto L_0x00d9
                r4 = 1
                goto L_0x00da
            L_0x00d9:
                r4 = 0
            L_0x00da:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnchancementUtilsKt.select(r2, r12, r4)
                if (r6 != 0) goto L_0x00e1
                goto L_0x00f3
            L_0x00e1:
                boolean r7 = r9.isForVarargParameter()
                if (r7 == 0) goto L_0x00ef
                if (r13 == 0) goto L_0x00ef
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r13 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
                if (r6 != r13) goto L_0x00ef
                r13 = 1
                goto L_0x00f0
            L_0x00ef:
                r13 = 0
            L_0x00f0:
                if (r13 != 0) goto L_0x00f3
                r15 = r6
            L_0x00f3:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r13 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r7 = r10.getMutability()
                java.lang.Object r13 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnchancementUtilsKt.select(r1, r13, r6, r7, r4)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r13 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier) r13
                if (r3 != r12) goto L_0x010c
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r2)
                if (r12 != 0) goto L_0x010a
                goto L_0x010c
            L_0x010a:
                r12 = 0
                goto L_0x010d
            L_0x010c:
                r12 = 1
            L_0x010d:
                boolean r10 = r10.isNotNullTypeParameter()
                if (r10 != 0) goto L_0x013e
                boolean r10 = r0 instanceof java.util.Collection
                if (r10 == 0) goto L_0x0122
                r10 = r0
                java.util.Collection r10 = (java.util.Collection) r10
                boolean r10 = r10.isEmpty()
                if (r10 == 0) goto L_0x0122
            L_0x0120:
                r10 = 0
                goto L_0x0139
            L_0x0122:
                java.util.Iterator r10 = r0.iterator()
            L_0x0126:
                boolean r0 = r10.hasNext()
                if (r0 == 0) goto L_0x0120
                java.lang.Object r0 = r10.next()
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r0 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r0
                boolean r0 = r0.isNotNullTypeParameter()
                if (r0 == 0) goto L_0x0126
                r10 = 1
            L_0x0139:
                if (r10 == 0) goto L_0x013c
                goto L_0x013e
            L_0x013c:
                r10 = 0
                goto L_0x013f
            L_0x013e:
                r10 = 1
            L_0x013f:
                if (r15 != 0) goto L_0x014c
                if (r12 == 0) goto L_0x014c
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r11 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnchancementUtilsKt.select(r11, r3, r4)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r10 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnchancementUtilsKt.createJavaTypeQualifiers(r11, r13, r14, r10)
                return r10
            L_0x014c:
                if (r15 != 0) goto L_0x014f
                goto L_0x0150
            L_0x014f:
                r14 = 0
            L_0x0150:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r10 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnchancementUtilsKt.createJavaTypeQualifiers(r15, r13, r14, r10)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.computeQualifiersForOverride(kotlin.reflect.jvm.internal.impl.types.KotlinType, java.util.Collection, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers, boolean, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers");
        }
    }

    /* compiled from: signatureEnhancement.kt */
    private static class PartEnhancementResult {
        private final boolean containsFunctionN;
        private final KotlinType type;
        private final boolean wereChanges;

        public PartEnhancementResult(KotlinType kotlinType, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(kotlinType, "type");
            this.type = kotlinType;
            this.wereChanges = z;
            this.containsFunctionN = z2;
        }

        public final KotlinType getType() {
            return this.type;
        }

        public final boolean getWereChanges() {
            return this.wereChanges;
        }

        public final boolean getContainsFunctionN() {
            return this.containsFunctionN;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r9 = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.copyWithNewDefaultTypeQualifiers(r10, r9.getAnnotations());
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts m44697a(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r8, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r9, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r10, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, ? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> r11) {
        /*
            r7 = this;
            r2 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated) r2
            if (r9 != 0) goto L_0x0006
            goto L_0x0010
        L_0x0006:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r9 = r9.getAnnotations()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r9 = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.copyWithNewDefaultTypeQualifiers(r10, r9)
            if (r9 != 0) goto L_0x0012
        L_0x0010:
            r4 = r10
            goto L_0x0013
        L_0x0012:
            r4 = r9
        L_0x0013:
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r5 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.VALUE_PARAMETER
            r3 = 0
            r0 = r7
            r1 = r8
            r6 = r11
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts r8 = r0.m44698a(r1, r2, r3, r4, r5, r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.m44697a(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.jvm.functions.Function1):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts");
    }

    /* renamed from: a */
    private final SignatureParts m44698a(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
        Function1<? super CallableMemberDescriptor, ? extends KotlinType> function12 = function1;
        KotlinType kotlinType = (KotlinType) function12.invoke(callableMemberDescriptor2);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        Iterable<CallableMemberDescriptor> iterable = overriddenDescriptors;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (CallableMemberDescriptor callableMemberDescriptor3 : iterable) {
            Intrinsics.checkNotNullExpressionValue(callableMemberDescriptor3, "it");
            arrayList.add((KotlinType) function12.invoke(callableMemberDescriptor3));
        }
        return new SignatureParts(this, annotated, kotlinType, (List) arrayList, z, ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, ((KotlinType) function12.invoke(callableMemberDescriptor2)).getAnnotations()), annotationQualifierApplicabilityType, false, false, 192, (DefaultConstructorMarker) null);
    }
}
