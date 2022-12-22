package kotlin.reflect.jvm.internal.impl.renderer;

import java.lang.reflect.Field;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt;

/* compiled from: DescriptorRendererOptionsImpl.kt */
public final class DescriptorRendererOptionsImpl implements DescriptorRendererOptions {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f60794a;

    /* renamed from: A */
    private final ReadWriteProperty f60795A = m44908a(true);

    /* renamed from: B */
    private final ReadWriteProperty f60796B = m44908a(OverrideRenderingPolicy.RENDER_OPEN);

    /* renamed from: C */
    private final ReadWriteProperty f60797C = m44908a(DescriptorRenderer.ValueParametersHandler.DEFAULT.INSTANCE);

    /* renamed from: D */
    private final ReadWriteProperty f60798D = m44908a(RenderingFormat.PLAIN);

    /* renamed from: E */
    private final ReadWriteProperty f60799E = m44908a(ParameterNameRenderingPolicy.ALL);

    /* renamed from: F */
    private final ReadWriteProperty f60800F = m44908a(false);

    /* renamed from: G */
    private final ReadWriteProperty f60801G = m44908a(false);

    /* renamed from: H */
    private final ReadWriteProperty f60802H = m44908a(PropertyAccessorRenderingPolicy.DEBUG);

    /* renamed from: I */
    private final ReadWriteProperty f60803I = m44908a(false);

    /* renamed from: J */
    private final ReadWriteProperty f60804J = m44908a(false);

    /* renamed from: K */
    private final ReadWriteProperty f60805K = m44908a(SetsKt.emptySet());

    /* renamed from: L */
    private final ReadWriteProperty f60806L = m44908a(ExcludedTypeAnnotations.INSTANCE.getInternalAnnotationsForResolve());

    /* renamed from: M */
    private final ReadWriteProperty f60807M = m44908a((Object) null);

    /* renamed from: N */
    private final ReadWriteProperty f60808N = m44908a(AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS);

    /* renamed from: O */
    private final ReadWriteProperty f60809O = m44908a(false);

    /* renamed from: P */
    private final ReadWriteProperty f60810P = m44908a(true);

    /* renamed from: Q */
    private final ReadWriteProperty f60811Q = m44908a(true);

    /* renamed from: R */
    private final ReadWriteProperty f60812R = m44908a(false);

    /* renamed from: S */
    private final ReadWriteProperty f60813S = m44908a(true);

    /* renamed from: T */
    private final ReadWriteProperty f60814T = m44908a(true);

    /* renamed from: U */
    private final ReadWriteProperty f60815U = m44908a(false);

    /* renamed from: V */
    private final ReadWriteProperty f60816V = m44908a(false);

    /* renamed from: W */
    private final ReadWriteProperty f60817W = m44908a(false);

    /* renamed from: X */
    private final ReadWriteProperty f60818X = m44908a(true);

    /* renamed from: b */
    private boolean f60819b;

    /* renamed from: c */
    private final ReadWriteProperty f60820c = m44908a(ClassifierNamePolicy.SOURCE_CODE_QUALIFIED.INSTANCE);

    /* renamed from: d */
    private final ReadWriteProperty f60821d = m44908a(true);

    /* renamed from: e */
    private final ReadWriteProperty f60822e = m44908a(true);

    /* renamed from: f */
    private final ReadWriteProperty f60823f = m44908a(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);

    /* renamed from: g */
    private final ReadWriteProperty f60824g = m44908a(false);

    /* renamed from: h */
    private final ReadWriteProperty f60825h = m44908a(false);

    /* renamed from: i */
    private final ReadWriteProperty f60826i = m44908a(false);

    /* renamed from: j */
    private final ReadWriteProperty f60827j = m44908a(false);

    /* renamed from: k */
    private final ReadWriteProperty f60828k = m44908a(false);

    /* renamed from: l */
    private final ReadWriteProperty f60829l = m44908a(true);

    /* renamed from: m */
    private final ReadWriteProperty f60830m = m44908a(false);

    /* renamed from: n */
    private final ReadWriteProperty f60831n = m44908a(false);

    /* renamed from: o */
    private final ReadWriteProperty f60832o = m44908a(false);

    /* renamed from: p */
    private final ReadWriteProperty f60833p = m44908a(true);

    /* renamed from: q */
    private final ReadWriteProperty f60834q = m44908a(true);

    /* renamed from: r */
    private final ReadWriteProperty f60835r = m44908a(false);

    /* renamed from: s */
    private final ReadWriteProperty f60836s = m44908a(false);

    /* renamed from: t */
    private final ReadWriteProperty f60837t = m44908a(false);

    /* renamed from: u */
    private final ReadWriteProperty f60838u = m44908a(false);

    /* renamed from: v */
    private final ReadWriteProperty f60839v = m44908a(false);

    /* renamed from: w */
    private final ReadWriteProperty f60840w = m44908a(false);

    /* renamed from: x */
    private final ReadWriteProperty f60841x = m44908a(false);

    /* renamed from: y */
    private final ReadWriteProperty f60842y = m44908a(DescriptorRendererOptionsImpl$typeNormalizer$2.INSTANCE);

    /* renamed from: z */
    private final ReadWriteProperty f60843z = m44908a(DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2.INSTANCE);

    public boolean getIncludeAnnotationArguments() {
        return DescriptorRendererOptions.DefaultImpls.getIncludeAnnotationArguments(this);
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return DescriptorRendererOptions.DefaultImpls.getIncludeEmptyAnnotationArguments(this);
    }

    public final boolean isLocked() {
        return this.f60819b;
    }

    public final void lock() {
        boolean z = !this.f60819b;
        if (!_Assertions.ENABLED || z) {
            this.f60819b = true;
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    public final DescriptorRendererOptionsImpl copy() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
        Field[] declaredFields = getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "this::class.java.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            i++;
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                ObservableProperty observableProperty = obj instanceof ObservableProperty ? (ObservableProperty) obj : null;
                if (observableProperty == null) {
                    continue;
                } else {
                    String name = field.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "field.name");
                    boolean z = !StringsKt.startsWith$default(name, "is", false, 2, (Object) null);
                    if (!_Assertions.ENABLED || z) {
                        KDeclarationContainer orCreateKotlinClass = C21490Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class);
                        String name2 = field.getName();
                        String name3 = field.getName();
                        Intrinsics.checkNotNullExpressionValue(name3, "field.name");
                        if (name3.length() > 0) {
                            char upperCase = Character.toUpperCase(name3.charAt(0));
                            String substring = name3.substring(1);
                            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                            name3 = String.valueOf(upperCase) + substring;
                        }
                        field.set(descriptorRendererOptionsImpl, descriptorRendererOptionsImpl.m44908a(observableProperty.getValue(this, new PropertyReference1Impl(orCreateKotlinClass, name2, Intrinsics.stringPlus("get", name3)))));
                    } else {
                        throw new AssertionError("Fields named is* are not supported here yet");
                    }
                }
            }
        }
        return descriptorRendererOptionsImpl;
    }

    /* renamed from: a */
    private final <T> ReadWriteProperty<DescriptorRendererOptionsImpl, T> m44908a(T t) {
        Delegates delegates = Delegates.INSTANCE;
        return new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(t, t, this);
    }

    static {
        Class<DescriptorRendererOptionsImpl> cls = DescriptorRendererOptionsImpl.class;
        f60794a = new KProperty[]{C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "withDefinedIn", "getWithDefinedIn()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "modifiers", "getModifiers()Ljava/util/Set;")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "startFromName", "getStartFromName()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "debugMode", "getDebugMode()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "verbose", "getVerbose()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "unitReturnType", "getUnitReturnType()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "withoutReturnType", "getWithoutReturnType()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "enhancedTypes", "getEnhancedTypes()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "normalizedVisibilities", "getNormalizedVisibilities()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "renderDefaultModality", "getRenderDefaultModality()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "includePropertyConstant", "getIncludePropertyConstant()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "withoutTypeParameters", "getWithoutTypeParameters()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "withoutSuperTypes", "getWithoutSuperTypes()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "receiverAfterName", "getReceiverAfterName()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "renderTypeExpansions", "getRenderTypeExpansions()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "renderFunctionContracts", "getRenderFunctionContracts()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), C21490Reflection.mutableProperty1(new MutablePropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(cls), "informativeErrorType", "getInformativeErrorType()Z"))};
    }

    public ClassifierNamePolicy getClassifierNamePolicy() {
        return (ClassifierNamePolicy) this.f60820c.getValue(this, f60794a[0]);
    }

    public void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.f60820c.setValue(this, f60794a[0], classifierNamePolicy);
    }

    public boolean getWithDefinedIn() {
        return ((Boolean) this.f60821d.getValue(this, f60794a[1])).booleanValue();
    }

    public void setWithDefinedIn(boolean z) {
        this.f60821d.setValue(this, f60794a[1], Boolean.valueOf(z));
    }

    public boolean getWithSourceFileForTopLevel() {
        return ((Boolean) this.f60822e.getValue(this, f60794a[2])).booleanValue();
    }

    public Set<DescriptorRendererModifier> getModifiers() {
        return (Set) this.f60823f.getValue(this, f60794a[3]);
    }

    public void setModifiers(Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.f60823f.setValue(this, f60794a[3], set);
    }

    public boolean getStartFromName() {
        return ((Boolean) this.f60824g.getValue(this, f60794a[4])).booleanValue();
    }

    public void setStartFromName(boolean z) {
        this.f60824g.setValue(this, f60794a[4], Boolean.valueOf(z));
    }

    public boolean getStartFromDeclarationKeyword() {
        return ((Boolean) this.f60825h.getValue(this, f60794a[5])).booleanValue();
    }

    public boolean getDebugMode() {
        return ((Boolean) this.f60826i.getValue(this, f60794a[6])).booleanValue();
    }

    public void setDebugMode(boolean z) {
        this.f60826i.setValue(this, f60794a[6], Boolean.valueOf(z));
    }

    public boolean getClassWithPrimaryConstructor() {
        return ((Boolean) this.f60827j.getValue(this, f60794a[7])).booleanValue();
    }

    public boolean getVerbose() {
        return ((Boolean) this.f60828k.getValue(this, f60794a[8])).booleanValue();
    }

    public void setVerbose(boolean z) {
        this.f60828k.setValue(this, f60794a[8], Boolean.valueOf(z));
    }

    public boolean getUnitReturnType() {
        return ((Boolean) this.f60829l.getValue(this, f60794a[9])).booleanValue();
    }

    public boolean getWithoutReturnType() {
        return ((Boolean) this.f60830m.getValue(this, f60794a[10])).booleanValue();
    }

    public boolean getEnhancedTypes() {
        return ((Boolean) this.f60831n.getValue(this, f60794a[11])).booleanValue();
    }

    public boolean getNormalizedVisibilities() {
        return ((Boolean) this.f60832o.getValue(this, f60794a[12])).booleanValue();
    }

    public boolean getRenderDefaultVisibility() {
        return ((Boolean) this.f60833p.getValue(this, f60794a[13])).booleanValue();
    }

    public boolean getRenderDefaultModality() {
        return ((Boolean) this.f60834q.getValue(this, f60794a[14])).booleanValue();
    }

    public boolean getRenderConstructorDelegation() {
        return ((Boolean) this.f60835r.getValue(this, f60794a[15])).booleanValue();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return ((Boolean) this.f60836s.getValue(this, f60794a[16])).booleanValue();
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return ((Boolean) this.f60837t.getValue(this, f60794a[17])).booleanValue();
    }

    public boolean getUninferredTypeParameterAsName() {
        return ((Boolean) this.f60838u.getValue(this, f60794a[18])).booleanValue();
    }

    public boolean getIncludePropertyConstant() {
        return ((Boolean) this.f60839v.getValue(this, f60794a[19])).booleanValue();
    }

    public boolean getWithoutTypeParameters() {
        return ((Boolean) this.f60840w.getValue(this, f60794a[20])).booleanValue();
    }

    public void setWithoutTypeParameters(boolean z) {
        this.f60840w.setValue(this, f60794a[20], Boolean.valueOf(z));
    }

    public boolean getWithoutSuperTypes() {
        return ((Boolean) this.f60841x.getValue(this, f60794a[21])).booleanValue();
    }

    public void setWithoutSuperTypes(boolean z) {
        this.f60841x.setValue(this, f60794a[21], Boolean.valueOf(z));
    }

    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return (Function1) this.f60842y.getValue(this, f60794a[22]);
    }

    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return (Function1) this.f60843z.getValue(this, f60794a[23]);
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return ((Boolean) this.f60795A.getValue(this, f60794a[24])).booleanValue();
    }

    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return (OverrideRenderingPolicy) this.f60796B.getValue(this, f60794a[25]);
    }

    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return (DescriptorRenderer.ValueParametersHandler) this.f60797C.getValue(this, f60794a[26]);
    }

    public RenderingFormat getTextFormat() {
        return (RenderingFormat) this.f60798D.getValue(this, f60794a[27]);
    }

    public void setTextFormat(RenderingFormat renderingFormat) {
        Intrinsics.checkNotNullParameter(renderingFormat, "<set-?>");
        this.f60798D.setValue(this, f60794a[27], renderingFormat);
    }

    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return (ParameterNameRenderingPolicy) this.f60799E.getValue(this, f60794a[28]);
    }

    public void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkNotNullParameter(parameterNameRenderingPolicy, "<set-?>");
        this.f60799E.setValue(this, f60794a[28], parameterNameRenderingPolicy);
    }

    public boolean getReceiverAfterName() {
        return ((Boolean) this.f60800F.getValue(this, f60794a[29])).booleanValue();
    }

    public void setReceiverAfterName(boolean z) {
        this.f60800F.setValue(this, f60794a[29], Boolean.valueOf(z));
    }

    public boolean getRenderCompanionObjectName() {
        return ((Boolean) this.f60801G.getValue(this, f60794a[30])).booleanValue();
    }

    public void setRenderCompanionObjectName(boolean z) {
        this.f60801G.setValue(this, f60794a[30], Boolean.valueOf(z));
    }

    public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return (PropertyAccessorRenderingPolicy) this.f60802H.getValue(this, f60794a[31]);
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return ((Boolean) this.f60803I.getValue(this, f60794a[32])).booleanValue();
    }

    public boolean getEachAnnotationOnNewLine() {
        return ((Boolean) this.f60804J.getValue(this, f60794a[33])).booleanValue();
    }

    public Set<FqName> getExcludedAnnotationClasses() {
        return (Set) this.f60805K.getValue(this, f60794a[34]);
    }

    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return (Set) this.f60806L.getValue(this, f60794a[35]);
    }

    public void setExcludedTypeAnnotationClasses(Set<FqName> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.f60806L.setValue(this, f60794a[35], set);
    }

    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return (Function1) this.f60807M.getValue(this, f60794a[36]);
    }

    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return (AnnotationArgumentsRenderingPolicy) this.f60808N.getValue(this, f60794a[37]);
    }

    public void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkNotNullParameter(annotationArgumentsRenderingPolicy, "<set-?>");
        this.f60808N.setValue(this, f60794a[37], annotationArgumentsRenderingPolicy);
    }

    public boolean getAlwaysRenderModifiers() {
        return ((Boolean) this.f60809O.getValue(this, f60794a[38])).booleanValue();
    }

    public boolean getRenderConstructorKeyword() {
        return ((Boolean) this.f60810P.getValue(this, f60794a[39])).booleanValue();
    }

    public boolean getRenderUnabbreviatedType() {
        return ((Boolean) this.f60811Q.getValue(this, f60794a[40])).booleanValue();
    }

    public boolean getRenderTypeExpansions() {
        return ((Boolean) this.f60812R.getValue(this, f60794a[41])).booleanValue();
    }

    public boolean getIncludeAdditionalModifiers() {
        return ((Boolean) this.f60813S.getValue(this, f60794a[42])).booleanValue();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return ((Boolean) this.f60814T.getValue(this, f60794a[43])).booleanValue();
    }

    public boolean getPresentableUnresolvedTypes() {
        return ((Boolean) this.f60816V.getValue(this, f60794a[45])).booleanValue();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return ((Boolean) this.f60817W.getValue(this, f60794a[46])).booleanValue();
    }

    public boolean getInformativeErrorType() {
        return ((Boolean) this.f60818X.getValue(this, f60794a[47])).booleanValue();
    }
}
