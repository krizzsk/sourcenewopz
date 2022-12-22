package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: LazyJavaClassDescriptor.kt */
public final class LazyJavaClassDescriptor extends ClassDescriptorBase implements JavaClassDescriptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: q */
    private static final Set<String> f60522q = SetsKt.setOf("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");

    /* renamed from: a */
    private final LazyJavaResolverContext f60523a;

    /* renamed from: b */
    private final JavaClass f60524b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ClassDescriptor f60525c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final LazyJavaResolverContext f60526d;

    /* renamed from: e */
    private final Lazy f60527e;

    /* renamed from: f */
    private final ClassKind f60528f;

    /* renamed from: g */
    private final Modality f60529g;

    /* renamed from: h */
    private final Visibility f60530h;

    /* renamed from: i */
    private final boolean f60531i;

    /* renamed from: j */
    private final LazyJavaClassTypeConstructor f60532j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final LazyJavaClassMemberScope f60533k;

    /* renamed from: l */
    private final ScopesHolderForClass<LazyJavaClassMemberScope> f60534l;

    /* renamed from: m */
    private final InnerClassesScopeWrapper f60535m;

    /* renamed from: n */
    private final LazyJavaStaticClassScope f60536n;

    /* renamed from: o */
    private final Annotations f60537o;

    /* renamed from: p */
    private final NotNullLazyValue<List<TypeParameterDescriptor>> f60538p;

    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    public InlineClassRepresentation<SimpleType> getInlineClassRepresentation() {
        return null;
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    public boolean isActual() {
        return false;
    }

    public boolean isCompanionObject() {
        return false;
    }

    public boolean isData() {
        return false;
    }

    public boolean isExpect() {
        return false;
    }

    public boolean isFun() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isValue() {
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaClassDescriptor(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaClass javaClass, ClassDescriptor classDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, declarationDescriptor, javaClass, (i & 8) != 0 ? null : classDescriptor);
    }

    public final LazyJavaResolverContext getOuterContext() {
        return this.f60523a;
    }

    public final JavaClass getJClass() {
        return this.f60524b;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LazyJavaClassDescriptor(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r16, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r17, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r18, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r19) {
        /*
            r15 = this;
            r6 = r15
            r7 = r16
            r8 = r18
            java.lang.String r0 = "outerContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "containingDeclaration"
            r2 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "jClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r1 = r16.getStorageManager()
            kotlin.reflect.jvm.internal.impl.name.Name r3 = r18.getName()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r16.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory r0 = r0.getSourceElementFactory()
            r4 = r8
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement r4 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement) r4
            kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement r0 = r0.source(r4)
            r4 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r4 = (kotlin.reflect.jvm.internal.impl.descriptors.SourceElement) r4
            r5 = 0
            r0 = r15
            r0.<init>(r1, r2, r3, r4, r5)
            r6.f60523a = r7
            r6.f60524b = r8
            r0 = r19
            r6.f60525c = r0
            r1 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor) r1
            r2 = r8
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner r2 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner) r2
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r16
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r0 = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.childForClassOrPackage$default(r0, r1, r2, r3, r4, r5)
            r6.f60526d = r0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r0.getComponents()
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache r0 = r0.getJavaResolverCache()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r1 = r6.f60524b
            r2 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
            r0.recordClass(r1, r2)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r6.f60524b
            kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind r0 = r0.getLightClassOriginKind()
            r1 = 1
            if (r0 != 0) goto L_0x0069
            r0 = 1
            goto L_0x006a
        L_0x0069:
            r0 = 0
        L_0x006a:
            boolean r4 = kotlin._Assertions.ENABLED
            if (r4 == 0) goto L_0x0083
            if (r0 == 0) goto L_0x0071
            goto L_0x0083
        L_0x0071:
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r15.getJClass()
            java.lang.String r1 = "Creating LazyJavaClassDescriptor for light class "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0083:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$moduleAnnotations$2 r0 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$moduleAnnotations$2
            r0.<init>(r15)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            kotlin.Lazy r0 = kotlin.LazyKt.lazy(r0)
            r6.f60527e = r0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r6.f60524b
            boolean r0 = r0.isAnnotationType()
            if (r0 == 0) goto L_0x009b
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r0 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS
            goto L_0x00b3
        L_0x009b:
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r6.f60524b
            boolean r0 = r0.isInterface()
            if (r0 == 0) goto L_0x00a6
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r0 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE
            goto L_0x00b3
        L_0x00a6:
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r6.f60524b
            boolean r0 = r0.isEnum()
            if (r0 == 0) goto L_0x00b1
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r0 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS
            goto L_0x00b3
        L_0x00b1:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r0 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS
        L_0x00b3:
            r6.f60528f = r0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r6.f60524b
            boolean r0 = r0.isAnnotationType()
            if (r0 != 0) goto L_0x00f0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r6.f60524b
            boolean r0 = r0.isEnum()
            if (r0 == 0) goto L_0x00c6
            goto L_0x00f0
        L_0x00c6:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality$Companion r0 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.Companion
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r4 = r6.f60524b
            boolean r4 = r4.isSealed()
            if (r4 != 0) goto L_0x00e3
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r4 = r6.f60524b
            boolean r4 = r4.isAbstract()
            if (r4 != 0) goto L_0x00e3
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r4 = r6.f60524b
            boolean r4 = r4.isInterface()
            if (r4 == 0) goto L_0x00e1
            goto L_0x00e3
        L_0x00e1:
            r4 = 0
            goto L_0x00e4
        L_0x00e3:
            r4 = 1
        L_0x00e4:
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r5 = r6.f60524b
            boolean r5 = r5.isFinal()
            r5 = r5 ^ r1
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r0 = r0.convertFromFlags(r3, r4, r5)
            goto L_0x00f2
        L_0x00f0:
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r0 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL
        L_0x00f2:
            r6.f60529g = r0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r6.f60524b
            kotlin.reflect.jvm.internal.impl.descriptors.Visibility r0 = r0.getVisibility()
            r6.f60530h = r0
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r6.f60524b
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r0.getOuterClass()
            if (r0 == 0) goto L_0x010e
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r0 = r6.f60524b
            boolean r0 = r0.isStatic()
            if (r0 != 0) goto L_0x010e
            r0 = 1
            goto L_0x010f
        L_0x010e:
            r0 = 0
        L_0x010f:
            r6.f60531i = r0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$LazyJavaClassTypeConstructor r0 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$LazyJavaClassTypeConstructor
            r0.<init>(r15)
            r6.f60532j = r0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r0 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r8 = r6.f60526d
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r10 = r6.f60524b
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = r6.f60525c
            if (r4 == 0) goto L_0x0124
            r11 = 1
            goto L_0x0125
        L_0x0124:
            r11 = 0
        L_0x0125:
            r12 = 0
            r13 = 16
            r14 = 0
            r7 = r0
            r9 = r2
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            r6.f60533k = r0
            kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$Companion r0 = kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass.Companion
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r1 = r6.f60526d
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r1 = r1.getStorageManager()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r3 = r6.f60526d
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r3 = r3.getComponents()
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker r3 = r3.getKotlinTypeChecker()
            kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r3 = r3.getKotlinTypeRefiner()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$scopeHolder$1 r4 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$scopeHolder$1
            r4.<init>(r15)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass r0 = r0.create(r2, r1, r3, r4)
            r6.f60534l = r0
            kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper r0 = new kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r1 = r6.f60533k
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r1 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) r1
            r0.<init>(r1)
            r6.f60535m = r0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope r0 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r1 = r6.f60526d
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r2 = r6.f60524b
            r0.<init>(r1, r2, r15)
            r6.f60536n = r0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r0 = r6.f60526d
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r1 = r6.f60524b
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner r1 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner) r1
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(r0, r1)
            r6.f60537o = r0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r0 = r6.f60526d
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r0 = r0.getStorageManager()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$declaredParameters$1 r1 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$declaredParameters$1
            r1.<init>(r15)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r0 = r0.createLazyValue(r1)
            r6.f60538p = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.<init>(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):void");
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final List<JavaAnnotation> getModuleAnnotations() {
        return (List) this.f60527e.getValue();
    }

    public ClassKind getKind() {
        return this.f60528f;
    }

    public Modality getModality() {
        return this.f60529g;
    }

    public DescriptorVisibility getVisibility() {
        if (!Intrinsics.areEqual((Object) this.f60530h, (Object) DescriptorVisibilities.PRIVATE) || this.f60524b.getOuterClass() != null) {
            return UtilsKt.toDescriptorVisibility(this.f60530h);
        }
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.PACKAGE_VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "{\n            JavaDescri…KAGE_VISIBILITY\n        }");
        return descriptorVisibility;
    }

    public boolean isInner() {
        return this.f60531i;
    }

    public TypeConstructor getTypeConstructor() {
        return this.f60532j;
    }

    /* access modifiers changed from: protected */
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f60534l.getScope(kotlinTypeRefiner);
    }

    public MemberScope getUnsubstitutedInnerClassesScope() {
        return this.f60535m;
    }

    public MemberScope getStaticScope() {
        return this.f60536n;
    }

    public LazyJavaClassMemberScope getUnsubstitutedMemberScope() {
        return (LazyJavaClassMemberScope) super.getUnsubstitutedMemberScope();
    }

    public List<ClassConstructorDescriptor> getConstructors() {
        return (List) this.f60533k.getConstructors$descriptors_jvm().invoke();
    }

    public Annotations getAnnotations() {
        return this.f60537o;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return (List) this.f60538p.invoke();
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        if (this.f60529g != Modality.SEALED) {
            return CollectionsKt.emptyList();
        }
        JavaTypeAttributes attributes$default = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, (TypeParameterDescriptor) null, 3, (Object) null);
        Collection arrayList = new ArrayList();
        for (JavaClassifierType transformJavaType : this.f60524b.getPermittedTypes()) {
            ClassifierDescriptor declarationDescriptor = this.f60526d.getTypeResolver().transformJavaType(transformJavaType, attributes$default).getConstructor().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor != null) {
                arrayList.add(classDescriptor);
            }
        }
        return (List) arrayList;
    }

    public String toString() {
        return Intrinsics.stringPlus("Lazy Java class ", DescriptorUtilsKt.getFqNameUnsafe(this));
    }

    /* compiled from: LazyJavaClassDescriptor.kt */
    private final class LazyJavaClassTypeConstructor extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters = this.this$0.f60526d.getStorageManager().createLazyValue(new C21595xbaf55d8a(this.this$0));
        final /* synthetic */ LazyJavaClassDescriptor this$0;

        public boolean isDenotable() {
            return true;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LazyJavaClassTypeConstructor(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
            super(lazyJavaClassDescriptor.f60526d.getStorageManager());
            Intrinsics.checkNotNullParameter(lazyJavaClassDescriptor, "this$0");
            this.this$0 = lazyJavaClassDescriptor;
        }

        public List<TypeParameterDescriptor> getParameters() {
            return (List) this.parameters.invoke();
        }

        /* access modifiers changed from: protected */
        public Collection<KotlinType> computeSupertypes() {
            Object obj;
            Collection<JavaClassifierType> supertypes = this.this$0.getJClass().getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            ArrayList arrayList2 = new ArrayList(0);
            KotlinType purelyImplementedSupertype = getPurelyImplementedSupertype();
            Iterator<JavaClassifierType> it = supertypes.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                JavaClassifierType next = it.next();
                KotlinType enhanceSuperType = this.this$0.f60526d.getComponents().getSignatureEnhancement().enhanceSuperType(this.this$0.f60526d.getTypeResolver().transformJavaType(next, JavaTypeResolverKt.toAttributes$default(TypeUsage.SUPERTYPE, false, (TypeParameterDescriptor) null, 3, (Object) null)), this.this$0.f60526d);
                if (enhanceSuperType.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor) {
                    arrayList2.add(next);
                }
                TypeConstructor constructor = enhanceSuperType.getConstructor();
                if (purelyImplementedSupertype != null) {
                    obj = purelyImplementedSupertype.getConstructor();
                }
                if (!Intrinsics.areEqual((Object) constructor, obj) && !KotlinBuiltIns.isAnyOrNullableAny(enhanceSuperType)) {
                    arrayList.add(enhanceSuperType);
                }
            }
            Collection collection = arrayList;
            ClassDescriptor access$getAdditionalSupertypeClassDescriptor$p = this.this$0.f60525c;
            if (access$getAdditionalSupertypeClassDescriptor$p != null) {
                obj = MappingUtilKt.createMappedTypeParametersSubstitution(access$getAdditionalSupertypeClassDescriptor$p, this.this$0).buildSubstitutor().substitute(access$getAdditionalSupertypeClassDescriptor$p.getDefaultType(), Variance.INVARIANT);
            }
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection, obj);
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection, purelyImplementedSupertype);
            if (!arrayList2.isEmpty()) {
                ErrorReporter errorReporter = this.this$0.f60526d.getComponents().getErrorReporter();
                ClassDescriptor declarationDescriptor = getDeclarationDescriptor();
                Iterable<JavaType> iterable = arrayList2;
                Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (JavaType javaType : iterable) {
                    arrayList3.add(((JavaClassifierType) javaType).getPresentableText());
                }
                errorReporter.reportIncompleteHierarchy(declarationDescriptor, (List) arrayList3);
            }
            return collection.isEmpty() ^ true ? CollectionsKt.toList(arrayList) : CollectionsKt.listOf(this.this$0.f60526d.getModule().getBuiltIns().getAnyType());
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.util.Collection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.util.List} */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
            if ((!r0.isRoot() && r0.startsWith(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_NAME)) != false) goto L_0x001d;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final kotlin.reflect.jvm.internal.impl.types.KotlinType getPurelyImplementedSupertype() {
            /*
                r8 = this;
                kotlin.reflect.jvm.internal.impl.name.FqName r0 = r8.getPurelyImplementsFqNameFromAnnotation()
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L_0x000a
            L_0x0008:
                r0 = r2
                goto L_0x001d
            L_0x000a:
                boolean r3 = r0.isRoot()
                if (r3 != 0) goto L_0x001a
                kotlin.reflect.jvm.internal.impl.name.Name r3 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_NAME
                boolean r3 = r0.startsWith(r3)
                if (r3 == 0) goto L_0x001a
                r3 = 1
                goto L_0x001b
            L_0x001a:
                r3 = 0
            L_0x001b:
                if (r3 == 0) goto L_0x0008
            L_0x001d:
                if (r0 != 0) goto L_0x0030
                kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider r3 = kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider.INSTANCE
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r4 = r8.this$0
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r4
                kotlin.reflect.jvm.internal.impl.name.FqName r4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r4)
                kotlin.reflect.jvm.internal.impl.name.FqName r3 = r3.getPurelyImplementedInterface(r4)
                if (r3 != 0) goto L_0x0031
                return r2
            L_0x0030:
                r3 = r0
            L_0x0031:
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r4 = r8.this$0
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r4 = r4.f60526d
                kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r4 = r4.getModule()
                kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r5 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_JAVA_LOADER
                kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r5 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r5
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.resolveTopLevelClass(r4, r3, r5)
                if (r3 != 0) goto L_0x0046
                return r2
            L_0x0046:
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r3.getTypeConstructor()
                java.util.List r4 = r4.getParameters()
                int r4 = r4.size()
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r5 = r8.this$0
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5 = r5.getTypeConstructor()
                java.util.List r5 = r5.getParameters()
                java.lang.String r6 = "getTypeConstructor().parameters"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
                int r6 = r5.size()
                r7 = 10
                if (r6 != r4) goto L_0x009a
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                java.util.ArrayList r0 = new java.util.ArrayList
                int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r7)
                r0.<init>(r1)
                java.util.Collection r0 = (java.util.Collection) r0
                java.util.Iterator r1 = r5.iterator()
            L_0x007a:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0097
                java.lang.Object r2 = r1.next()
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r2
                kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r4 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
                kotlin.reflect.jvm.internal.impl.types.Variance r5 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
                kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = r2.getDefaultType()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
                r4.<init>(r5, r2)
                r0.add(r4)
                goto L_0x007a
            L_0x0097:
                java.util.List r0 = (java.util.List) r0
                goto L_0x00dc
            L_0x009a:
                if (r6 != r1) goto L_0x00e9
                if (r4 <= r1) goto L_0x00e9
                if (r0 != 0) goto L_0x00e9
                kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r0 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
                kotlin.reflect.jvm.internal.impl.types.Variance r2 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
                java.lang.Object r5 = kotlin.collections.CollectionsKt.single(r5)
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r5
                kotlin.reflect.jvm.internal.impl.types.SimpleType r5 = r5.getDefaultType()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r5
                r0.<init>(r2, r5)
                kotlin.ranges.IntRange r2 = new kotlin.ranges.IntRange
                r2.<init>(r1, r4)
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                java.util.ArrayList r1 = new java.util.ArrayList
                int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r7)
                r1.<init>(r4)
                java.util.Collection r1 = (java.util.Collection) r1
                java.util.Iterator r2 = r2.iterator()
            L_0x00c9:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto L_0x00d9
                r4 = r2
                kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4
                r4.nextInt()
                r1.add(r0)
                goto L_0x00c9
            L_0x00d9:
                r0 = r1
                java.util.List r0 = (java.util.List) r0
            L_0x00dc:
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = r1.getEMPTY()
                kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleNotNullType(r1, r3, r0)
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
                return r0
            L_0x00e9:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.LazyJavaClassTypeConstructor.getPurelyImplementedSupertype():kotlin.reflect.jvm.internal.impl.types.KotlinType");
        }

        private final FqName getPurelyImplementsFqNameFromAnnotation() {
            Annotations annotations = this.this$0.getAnnotations();
            FqName fqName = JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION;
            Intrinsics.checkNotNullExpressionValue(fqName, "PURELY_IMPLEMENTS_ANNOTATION");
            AnnotationDescriptor findAnnotation = annotations.findAnnotation(fqName);
            if (findAnnotation == null) {
                return null;
            }
            Object singleOrNull = CollectionsKt.singleOrNull(findAnnotation.getAllValueArguments().values());
            StringValue stringValue = singleOrNull instanceof StringValue ? (StringValue) singleOrNull : null;
            String str = stringValue == null ? null : (String) stringValue.getValue();
            if (str != null && FqNamesUtilKt.isValidJavaFqName(str)) {
                return new FqName(str);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return this.this$0.f60526d.getComponents().getSupertypeLoopChecker();
        }

        public ClassDescriptor getDeclarationDescriptor() {
            return this.this$0;
        }

        public String toString() {
            String asString = this.this$0.getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
            return asString;
        }
    }

    public final LazyJavaClassDescriptor copy$descriptors_jvm(JavaResolverCache javaResolverCache, ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        LazyJavaResolverContext lazyJavaResolverContext = this.f60526d;
        LazyJavaResolverContext replaceComponents = ContextKt.replaceComponents(lazyJavaResolverContext, lazyJavaResolverContext.getComponents().replace(javaResolverCache));
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        return new LazyJavaClassDescriptor(replaceComponents, containingDeclaration, this.f60524b, classDescriptor);
    }
}
