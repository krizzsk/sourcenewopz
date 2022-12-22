package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* compiled from: context.kt */
public final class JavaResolverComponents {

    /* renamed from: a */
    private final StorageManager f60462a;

    /* renamed from: b */
    private final JavaClassFinder f60463b;

    /* renamed from: c */
    private final KotlinClassFinder f60464c;

    /* renamed from: d */
    private final DeserializedDescriptorResolver f60465d;

    /* renamed from: e */
    private final SignaturePropagator f60466e;

    /* renamed from: f */
    private final ErrorReporter f60467f;

    /* renamed from: g */
    private final JavaResolverCache f60468g;

    /* renamed from: h */
    private final JavaPropertyInitializerEvaluator f60469h;

    /* renamed from: i */
    private final SamConversionResolver f60470i;

    /* renamed from: j */
    private final JavaSourceElementFactory f60471j;

    /* renamed from: k */
    private final ModuleClassResolver f60472k;

    /* renamed from: l */
    private final PackagePartProvider f60473l;

    /* renamed from: m */
    private final SupertypeLoopChecker f60474m;

    /* renamed from: n */
    private final LookupTracker f60475n;

    /* renamed from: o */
    private final ModuleDescriptor f60476o;

    /* renamed from: p */
    private final ReflectionTypes f60477p;

    /* renamed from: q */
    private final AnnotationTypeQualifierResolver f60478q;

    /* renamed from: r */
    private final SignatureEnhancement f60479r;

    /* renamed from: s */
    private final JavaClassesTracker f60480s;

    /* renamed from: t */
    private final JavaResolverSettings f60481t;

    /* renamed from: u */
    private final NewKotlinTypeChecker f60482u;

    /* renamed from: v */
    private final JavaTypeEnhancementState f60483v;

    /* renamed from: w */
    private final JavaModuleAnnotationsProvider f60484w;

    /* renamed from: x */
    private final SyntheticJavaPartsProvider f60485x;

    public JavaResolverComponents(StorageManager storageManager, JavaClassFinder javaClassFinder, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, SignaturePropagator signaturePropagator, ErrorReporter errorReporter, JavaResolverCache javaResolverCache, JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, SamConversionResolver samConversionResolver, JavaSourceElementFactory javaSourceElementFactory, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, SupertypeLoopChecker supertypeLoopChecker, LookupTracker lookupTracker, ModuleDescriptor moduleDescriptor, ReflectionTypes reflectionTypes, AnnotationTypeQualifierResolver annotationTypeQualifierResolver, SignatureEnhancement signatureEnhancement, JavaClassesTracker javaClassesTracker, JavaResolverSettings javaResolverSettings, NewKotlinTypeChecker newKotlinTypeChecker, JavaTypeEnhancementState javaTypeEnhancementState, JavaModuleAnnotationsProvider javaModuleAnnotationsProvider, SyntheticJavaPartsProvider syntheticJavaPartsProvider) {
        StorageManager storageManager2 = storageManager;
        JavaClassFinder javaClassFinder2 = javaClassFinder;
        KotlinClassFinder kotlinClassFinder2 = kotlinClassFinder;
        DeserializedDescriptorResolver deserializedDescriptorResolver2 = deserializedDescriptorResolver;
        SignaturePropagator signaturePropagator2 = signaturePropagator;
        ErrorReporter errorReporter2 = errorReporter;
        JavaResolverCache javaResolverCache2 = javaResolverCache;
        JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator2 = javaPropertyInitializerEvaluator;
        SamConversionResolver samConversionResolver2 = samConversionResolver;
        JavaSourceElementFactory javaSourceElementFactory2 = javaSourceElementFactory;
        ModuleClassResolver moduleClassResolver2 = moduleClassResolver;
        PackagePartProvider packagePartProvider2 = packagePartProvider;
        SupertypeLoopChecker supertypeLoopChecker2 = supertypeLoopChecker;
        LookupTracker lookupTracker2 = lookupTracker;
        ReflectionTypes reflectionTypes2 = reflectionTypes;
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(javaClassFinder2, "finder");
        Intrinsics.checkNotNullParameter(kotlinClassFinder2, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(deserializedDescriptorResolver2, "deserializedDescriptorResolver");
        Intrinsics.checkNotNullParameter(signaturePropagator2, "signaturePropagator");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        Intrinsics.checkNotNullParameter(javaResolverCache2, "javaResolverCache");
        Intrinsics.checkNotNullParameter(javaPropertyInitializerEvaluator2, "javaPropertyInitializerEvaluator");
        Intrinsics.checkNotNullParameter(samConversionResolver2, "samConversionResolver");
        Intrinsics.checkNotNullParameter(javaSourceElementFactory2, "sourceElementFactory");
        Intrinsics.checkNotNullParameter(moduleClassResolver2, "moduleClassResolver");
        Intrinsics.checkNotNullParameter(packagePartProvider2, "packagePartProvider");
        Intrinsics.checkNotNullParameter(supertypeLoopChecker2, "supertypeLoopChecker");
        Intrinsics.checkNotNullParameter(lookupTracker2, "lookupTracker");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(reflectionTypes, "reflectionTypes");
        Intrinsics.checkNotNullParameter(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        Intrinsics.checkNotNullParameter(signatureEnhancement, "signatureEnhancement");
        Intrinsics.checkNotNullParameter(javaClassesTracker, "javaClassesTracker");
        Intrinsics.checkNotNullParameter(javaResolverSettings, "settings");
        Intrinsics.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        Intrinsics.checkNotNullParameter(javaModuleAnnotationsProvider, "javaModuleResolver");
        Intrinsics.checkNotNullParameter(syntheticJavaPartsProvider, "syntheticPartsProvider");
        this.f60462a = storageManager2;
        this.f60463b = javaClassFinder2;
        this.f60464c = kotlinClassFinder2;
        this.f60465d = deserializedDescriptorResolver2;
        this.f60466e = signaturePropagator2;
        this.f60467f = errorReporter2;
        this.f60468g = javaResolverCache2;
        this.f60469h = javaPropertyInitializerEvaluator2;
        this.f60470i = samConversionResolver2;
        this.f60471j = javaSourceElementFactory2;
        this.f60472k = moduleClassResolver2;
        this.f60473l = packagePartProvider2;
        this.f60474m = supertypeLoopChecker2;
        this.f60475n = lookupTracker2;
        this.f60476o = moduleDescriptor;
        this.f60477p = reflectionTypes;
        this.f60478q = annotationTypeQualifierResolver;
        this.f60479r = signatureEnhancement;
        this.f60480s = javaClassesTracker;
        this.f60481t = javaResolverSettings;
        this.f60482u = newKotlinTypeChecker;
        this.f60483v = javaTypeEnhancementState;
        this.f60484w = javaModuleAnnotationsProvider;
        this.f60485x = syntheticJavaPartsProvider;
    }

    public final StorageManager getStorageManager() {
        return this.f60462a;
    }

    public final JavaClassFinder getFinder() {
        return this.f60463b;
    }

    public final KotlinClassFinder getKotlinClassFinder() {
        return this.f60464c;
    }

    public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
        return this.f60465d;
    }

    public final SignaturePropagator getSignaturePropagator() {
        return this.f60466e;
    }

    public final ErrorReporter getErrorReporter() {
        return this.f60467f;
    }

    public final JavaResolverCache getJavaResolverCache() {
        return this.f60468g;
    }

    public final JavaPropertyInitializerEvaluator getJavaPropertyInitializerEvaluator() {
        return this.f60469h;
    }

    public final JavaSourceElementFactory getSourceElementFactory() {
        return this.f60471j;
    }

    public final ModuleClassResolver getModuleClassResolver() {
        return this.f60472k;
    }

    public final PackagePartProvider getPackagePartProvider() {
        return this.f60473l;
    }

    public final SupertypeLoopChecker getSupertypeLoopChecker() {
        return this.f60474m;
    }

    public final LookupTracker getLookupTracker() {
        return this.f60475n;
    }

    public final ModuleDescriptor getModule() {
        return this.f60476o;
    }

    public final ReflectionTypes getReflectionTypes() {
        return this.f60477p;
    }

    public final AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver() {
        return this.f60478q;
    }

    public final SignatureEnhancement getSignatureEnhancement() {
        return this.f60479r;
    }

    public final JavaClassesTracker getJavaClassesTracker() {
        return this.f60480s;
    }

    public final JavaResolverSettings getSettings() {
        return this.f60481t;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.f60482u;
    }

    public final JavaTypeEnhancementState getJavaTypeEnhancementState() {
        return this.f60483v;
    }

    public final JavaModuleAnnotationsProvider getJavaModuleResolver() {
        return this.f60484w;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaResolverComponents(StorageManager storageManager, JavaClassFinder javaClassFinder, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, SignaturePropagator signaturePropagator, ErrorReporter errorReporter, JavaResolverCache javaResolverCache, JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, SamConversionResolver samConversionResolver, JavaSourceElementFactory javaSourceElementFactory, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, SupertypeLoopChecker supertypeLoopChecker, LookupTracker lookupTracker, ModuleDescriptor moduleDescriptor, ReflectionTypes reflectionTypes, AnnotationTypeQualifierResolver annotationTypeQualifierResolver, SignatureEnhancement signatureEnhancement, JavaClassesTracker javaClassesTracker, JavaResolverSettings javaResolverSettings, NewKotlinTypeChecker newKotlinTypeChecker, JavaTypeEnhancementState javaTypeEnhancementState, JavaModuleAnnotationsProvider javaModuleAnnotationsProvider, SyntheticJavaPartsProvider syntheticJavaPartsProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, javaClassFinder, kotlinClassFinder, deserializedDescriptorResolver, signaturePropagator, errorReporter, javaResolverCache, javaPropertyInitializerEvaluator, samConversionResolver, javaSourceElementFactory, moduleClassResolver, packagePartProvider, supertypeLoopChecker, lookupTracker, moduleDescriptor, reflectionTypes, annotationTypeQualifierResolver, signatureEnhancement, javaClassesTracker, javaResolverSettings, newKotlinTypeChecker, javaTypeEnhancementState, javaModuleAnnotationsProvider, (i & 8388608) != 0 ? SyntheticJavaPartsProvider.Companion.getEMPTY() : syntheticJavaPartsProvider);
    }

    public final SyntheticJavaPartsProvider getSyntheticPartsProvider() {
        return this.f60485x;
    }

    public final JavaResolverComponents replace(JavaResolverCache javaResolverCache) {
        Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        return new JavaResolverComponents(this.f60462a, this.f60463b, this.f60464c, this.f60465d, this.f60466e, this.f60467f, javaResolverCache, this.f60469h, this.f60470i, this.f60471j, this.f60472k, this.f60473l, this.f60474m, this.f60475n, this.f60476o, this.f60477p, this.f60478q, this.f60479r, this.f60480s, this.f60481t, this.f60482u, this.f60483v, this.f60484w, (SyntheticJavaPartsProvider) null, 8388608, (DefaultConstructorMarker) null);
    }
}
