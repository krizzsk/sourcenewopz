package kotlin.reflect.jvm.internal.impl.renderer;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnresolvedType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.osgi.framework.VersionRange;

/* compiled from: DescriptorRendererImpl.kt */
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {

    /* renamed from: a */
    private final DescriptorRendererOptionsImpl f60792a;

    /* renamed from: b */
    private final Lazy f60793b;

    /* compiled from: DescriptorRendererImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RenderingFormat.values().length];
            iArr[RenderingFormat.PLAIN.ordinal()] = 1;
            iArr[RenderingFormat.HTML.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ParameterNameRenderingPolicy.values().length];
            iArr2[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
            iArr2[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            iArr2[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.f60792a.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.f60792a.getAlwaysRenderModifiers();
    }

    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.f60792a.getAnnotationArgumentsRenderingPolicy();
    }

    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return this.f60792a.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.f60792a.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.f60792a.getClassWithPrimaryConstructor();
    }

    public ClassifierNamePolicy getClassifierNamePolicy() {
        return this.f60792a.getClassifierNamePolicy();
    }

    public boolean getDebugMode() {
        return this.f60792a.getDebugMode();
    }

    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return this.f60792a.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.f60792a.getEachAnnotationOnNewLine();
    }

    public boolean getEnhancedTypes() {
        return this.f60792a.getEnhancedTypes();
    }

    public Set<FqName> getExcludedAnnotationClasses() {
        return this.f60792a.getExcludedAnnotationClasses();
    }

    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return this.f60792a.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.f60792a.getIncludeAdditionalModifiers();
    }

    public boolean getIncludeAnnotationArguments() {
        return this.f60792a.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.f60792a.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.f60792a.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.f60792a.getInformativeErrorType();
    }

    public Set<DescriptorRendererModifier> getModifiers() {
        return this.f60792a.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.f60792a.getNormalizedVisibilities();
    }

    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return this.f60792a.getOverrideRenderingPolicy();
    }

    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return this.f60792a.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.f60792a.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.f60792a.getPresentableUnresolvedTypes();
    }

    public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return this.f60792a.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.f60792a.getReceiverAfterName();
    }

    public boolean getRenderCompanionObjectName() {
        return this.f60792a.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.f60792a.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.f60792a.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.f60792a.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.f60792a.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.f60792a.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.f60792a.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.f60792a.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.f60792a.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.f60792a.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.f60792a.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.f60792a.getStartFromName();
    }

    public RenderingFormat getTextFormat() {
        return this.f60792a.getTextFormat();
    }

    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return this.f60792a.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.f60792a.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.f60792a.getUnitReturnType();
    }

    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return this.f60792a.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.f60792a.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.f60792a.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.f60792a.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.f60792a.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.f60792a.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.f60792a.getWithoutTypeParameters();
    }

    public void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkNotNullParameter(annotationArgumentsRenderingPolicy, "<set-?>");
        this.f60792a.setAnnotationArgumentsRenderingPolicy(annotationArgumentsRenderingPolicy);
    }

    public void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.f60792a.setClassifierNamePolicy(classifierNamePolicy);
    }

    public void setDebugMode(boolean z) {
        this.f60792a.setDebugMode(z);
    }

    public void setExcludedTypeAnnotationClasses(Set<FqName> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.f60792a.setExcludedTypeAnnotationClasses(set);
    }

    public void setModifiers(Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.f60792a.setModifiers(set);
    }

    public void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkNotNullParameter(parameterNameRenderingPolicy, "<set-?>");
        this.f60792a.setParameterNameRenderingPolicy(parameterNameRenderingPolicy);
    }

    public void setReceiverAfterName(boolean z) {
        this.f60792a.setReceiverAfterName(z);
    }

    public void setRenderCompanionObjectName(boolean z) {
        this.f60792a.setRenderCompanionObjectName(z);
    }

    public void setStartFromName(boolean z) {
        this.f60792a.setStartFromName(z);
    }

    public void setTextFormat(RenderingFormat renderingFormat) {
        Intrinsics.checkNotNullParameter(renderingFormat, "<set-?>");
        this.f60792a.setTextFormat(renderingFormat);
    }

    public void setVerbose(boolean z) {
        this.f60792a.setVerbose(z);
    }

    public void setWithDefinedIn(boolean z) {
        this.f60792a.setWithDefinedIn(z);
    }

    public void setWithoutSuperTypes(boolean z) {
        this.f60792a.setWithoutSuperTypes(z);
    }

    public void setWithoutTypeParameters(boolean z) {
        this.f60792a.setWithoutTypeParameters(z);
    }

    public final DescriptorRendererOptionsImpl getOptions() {
        return this.f60792a;
    }

    public DescriptorRendererImpl(DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        Intrinsics.checkNotNullParameter(descriptorRendererOptionsImpl, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        this.f60792a = descriptorRendererOptionsImpl;
        boolean isLocked = descriptorRendererOptionsImpl.isLocked();
        if (!_Assertions.ENABLED || isLocked) {
            this.f60793b = LazyKt.lazy(new DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(this));
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    /* renamed from: a */
    private final DescriptorRendererImpl m44845a() {
        return (DescriptorRendererImpl) this.f60793b.getValue();
    }

    /* renamed from: a */
    private final String m44840a(String str) {
        int i = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i == 1) {
            return str;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else if (getBoldOnlyForNamesInHtml()) {
            return str;
        } else {
            return "<b>" + str + "</b>";
        }
    }

    /* renamed from: b */
    private final String m44890b(String str) {
        int i = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i == 1) {
            return str;
        }
        if (i == 2) {
            return "<font color=red><b>" + str + "</b></font>";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: c */
    private final String m44901c(String str) {
        return getTextFormat().escape(str);
    }

    /* renamed from: b */
    private final String m44889b() {
        return m44901c(IMTextUtils.STREET_IMAGE_TAG_START);
    }

    /* renamed from: c */
    private final String m44900c() {
        return m44901c(IMTextUtils.STREET_IMAGE_TAG_END);
    }

    /* renamed from: d */
    private final String m44906d() {
        int i = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i == 1) {
            return m44901c("->");
        }
        if (i == 2) {
            return "&rarr;";
        }
        throw new NoWhenBranchMatchedException();
    }

    public String renderMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        int i = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i == 1) {
            return str;
        }
        if (i == 2) {
            return "<i>" + str + "</i>";
        }
        throw new NoWhenBranchMatchedException();
    }

    public String renderName(Name name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        String c = m44901c(RenderingUtilsKt.render(name));
        if (!getBoldOnlyForNamesInHtml() || getTextFormat() != RenderingFormat.HTML || !z) {
            return c;
        }
        return "<b>" + c + "</b>";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m44865a(DeclarationDescriptor declarationDescriptor, StringBuilder sb, boolean z) {
        Name name = declarationDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(renderName(name, z));
    }

    /* renamed from: a */
    private final void m44864a(DeclarationDescriptor declarationDescriptor, StringBuilder sb) {
        if (getRenderCompanionObjectName()) {
            if (getStartFromName()) {
                sb.append("companion object");
            }
            m44846a(sb);
            DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
            if (containingDeclaration != null) {
                sb.append("of ");
                Name name = containingDeclaration.getName();
                Intrinsics.checkNotNullExpressionValue(name, "containingDeclaration.name");
                sb.append(renderName(name, false));
            }
        }
        if (getVerbose() || !Intrinsics.areEqual((Object) declarationDescriptor.getName(), (Object) SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)) {
            if (!getStartFromName()) {
                m44846a(sb);
            }
            Name name2 = declarationDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "descriptor.name");
            sb.append(renderName(name2, true));
        }
    }

    public String renderFqName(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "fqName");
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "fqName.pathSegments()");
        return m44842a(pathSegments);
    }

    /* renamed from: a */
    private final String m44842a(List<Name> list) {
        return m44901c(RenderingUtilsKt.renderFqName(list));
    }

    public String renderClassifierName(ClassifierDescriptor classifierDescriptor) {
        Intrinsics.checkNotNullParameter(classifierDescriptor, "klass");
        if (ErrorUtils.isError(classifierDescriptor)) {
            return classifierDescriptor.getTypeConstructor().toString();
        }
        return getClassifierNamePolicy().renderClassifier(classifierDescriptor, this);
    }

    public String renderType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        StringBuilder sb = new StringBuilder();
        m44852a(sb, getTypeNormalizer().invoke(kotlinType));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: a */
    private final void m44852a(StringBuilder sb, KotlinType kotlinType) {
        UnwrappedType unwrap = kotlinType.unwrap();
        AbbreviatedType abbreviatedType = unwrap instanceof AbbreviatedType ? (AbbreviatedType) unwrap : null;
        if (abbreviatedType == null) {
            m44893b(sb, kotlinType);
        } else if (getRenderTypeExpansions()) {
            m44893b(sb, (KotlinType) abbreviatedType.getExpandedType());
        } else {
            m44893b(sb, (KotlinType) abbreviatedType.getAbbreviation());
            if (getRenderUnabbreviatedType()) {
                m44851a(sb, abbreviatedType);
            }
        }
    }

    /* renamed from: a */
    private final void m44851a(StringBuilder sb, AbbreviatedType abbreviatedType) {
        if (getTextFormat() == RenderingFormat.HTML) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        m44893b(sb, (KotlinType) abbreviatedType.getExpandedType());
        sb.append(" */");
        if (getTextFormat() == RenderingFormat.HTML) {
            sb.append("</i></font>");
        }
    }

    /* renamed from: b */
    private final void m44893b(StringBuilder sb, KotlinType kotlinType) {
        if (!(kotlinType instanceof WrappedType) || !getDebugMode() || ((WrappedType) kotlinType).isComputed()) {
            UnwrappedType unwrap = kotlinType.unwrap();
            if (unwrap instanceof FlexibleType) {
                sb.append(((FlexibleType) unwrap).render(this, this));
            } else if (unwrap instanceof SimpleType) {
                m44854a(sb, (SimpleType) unwrap);
            }
        } else {
            sb.append("<Not computed yet>");
        }
    }

    /* renamed from: a */
    private final void m44854a(StringBuilder sb, SimpleType simpleType) {
        if (!Intrinsics.areEqual((Object) simpleType, (Object) TypeUtils.CANT_INFER_FUNCTION_PARAM_TYPE)) {
            KotlinType kotlinType = simpleType;
            if (!TypeUtils.isDontCarePlaceholder(kotlinType)) {
                if (ErrorUtils.isUninferredParameter(kotlinType)) {
                    if (getUninferredTypeParameterAsName()) {
                        String name = ((ErrorUtils.UninferredParameterTypeConstructor) simpleType.getConstructor()).getTypeParameterDescriptor().getName().toString();
                        Intrinsics.checkNotNullExpressionValue(name, "type.constructor as Unin…escriptor.name.toString()");
                        sb.append(m44890b(name));
                        return;
                    }
                    sb.append("???");
                    return;
                } else if (KotlinTypeKt.isError(kotlinType)) {
                    m44902c(sb, kotlinType);
                    return;
                } else if (m44887a(kotlinType)) {
                    m44907d(sb, kotlinType);
                    return;
                } else {
                    m44902c(sb, kotlinType);
                    return;
                }
            }
        }
        sb.append("???");
    }

    /* renamed from: a */
    private final boolean m44887a(KotlinType kotlinType) {
        boolean z;
        if (!FunctionTypesKt.isBuiltinFunctionalType(kotlinType)) {
            return false;
        }
        Iterable arguments = kotlinType.getArguments();
        if (!(arguments instanceof Collection) || !((Collection) arguments).isEmpty()) {
            Iterator it = arguments.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((TypeProjection) it.next()).isStarProjection()) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = true;
        if (z) {
            return true;
        }
        return false;
    }

    public String renderFlexibleType(String str, String str2, KotlinBuiltIns kotlinBuiltIns) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, "lowerRendered");
        Intrinsics.checkNotNullParameter(str4, "upperRendered");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        if (!m44883a(str, str2)) {
            ClassifierNamePolicy classifierNamePolicy = getClassifierNamePolicy();
            ClassDescriptor collection = kotlinBuiltIns.getCollection();
            Intrinsics.checkNotNullExpressionValue(collection, "builtIns.collection");
            DescriptorRenderer descriptorRenderer = this;
            String substringBefore$default = StringsKt.substringBefore$default(classifierNamePolicy.renderClassifier(collection, descriptorRenderer), "Collection", (String) null, 2, (Object) null);
            String stringPlus = Intrinsics.stringPlus(substringBefore$default, "Mutable");
            String a = m44841a(str, stringPlus, str2, substringBefore$default, substringBefore$default + VersionRange.LEFT_OPEN + "Mutable" + VersionRange.RIGHT_OPEN);
            if (a != null) {
                return a;
            }
            String a2 = m44841a(str, Intrinsics.stringPlus(substringBefore$default, "MutableMap.MutableEntry"), str2, Intrinsics.stringPlus(substringBefore$default, "Map.Entry"), Intrinsics.stringPlus(substringBefore$default, "(Mutable)Map.(Mutable)Entry"));
            if (a2 != null) {
                return a2;
            }
            ClassifierNamePolicy classifierNamePolicy2 = getClassifierNamePolicy();
            ClassDescriptor array = kotlinBuiltIns.getArray();
            Intrinsics.checkNotNullExpressionValue(array, "builtIns.array");
            String substringBefore$default2 = StringsKt.substringBefore$default(classifierNamePolicy2.renderClassifier(array, descriptorRenderer), "Array", (String) null, 2, (Object) null);
            String a3 = m44841a(str, Intrinsics.stringPlus(substringBefore$default2, m44901c("Array<")), str2, Intrinsics.stringPlus(substringBefore$default2, m44901c("Array<out ")), Intrinsics.stringPlus(substringBefore$default2, m44901c("Array<(out) ")));
            if (a3 != null) {
                return a3;
            }
            return VersionRange.LEFT_OPEN + str3 + ".." + str4 + VersionRange.RIGHT_OPEN;
        } else if (!StringsKt.startsWith$default(str4, "(", false, 2, (Object) null)) {
            return Intrinsics.stringPlus(str3, "!");
        } else {
            return VersionRange.LEFT_OPEN + str3 + ")!";
        }
    }

    public String renderTypeArguments(List<? extends TypeProjection> list) {
        Intrinsics.checkNotNullParameter(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m44889b());
        m44847a(sb, list);
        sb.append(m44900c());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: c */
    private final void m44902c(StringBuilder sb, KotlinType kotlinType) {
        m44880a(this, sb, (Annotated) kotlinType, (AnnotationUseSiteTarget) null, 2, (Object) null);
        SimpleType simpleType = null;
        DefinitelyNotNullType definitelyNotNullType = kotlinType instanceof DefinitelyNotNullType ? (DefinitelyNotNullType) kotlinType : null;
        if (definitelyNotNullType != null) {
            simpleType = definitelyNotNullType.getOriginal();
        }
        if (KotlinTypeKt.isError(kotlinType)) {
            if ((kotlinType instanceof UnresolvedType) && getPresentableUnresolvedTypes()) {
                sb.append(((UnresolvedType) kotlinType).getPresentableName());
            } else if (!(kotlinType instanceof ErrorType) || getInformativeErrorType()) {
                sb.append(kotlinType.getConstructor().toString());
            } else {
                sb.append(((ErrorType) kotlinType).getPresentableName());
            }
            sb.append(renderTypeArguments(kotlinType.getArguments()));
        } else if (kotlinType instanceof StubTypeForBuilderInference) {
            sb.append(((StubTypeForBuilderInference) kotlinType).getOriginalTypeVariable().toString());
        } else if (simpleType instanceof StubTypeForBuilderInference) {
            sb.append(((StubTypeForBuilderInference) simpleType).getOriginalTypeVariable().toString());
        } else {
            m44881a(this, sb, kotlinType, (TypeConstructor) null, 2, (Object) null);
        }
        if (kotlinType.isMarkedNullable()) {
            sb.append("?");
        }
        if (SpecialTypesKt.isDefinitelyNotNullType(kotlinType)) {
            sb.append("!!");
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m44881a(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, KotlinType kotlinType, TypeConstructor typeConstructor, int i, Object obj) {
        if ((i & 2) != 0) {
            typeConstructor = kotlinType.getConstructor();
        }
        descriptorRendererImpl.m44853a(sb, kotlinType, typeConstructor);
    }

    /* renamed from: a */
    private final void m44853a(StringBuilder sb, KotlinType kotlinType, TypeConstructor typeConstructor) {
        PossiblyInnerType buildPossiblyInnerType = TypeParameterUtilsKt.buildPossiblyInnerType(kotlinType);
        if (buildPossiblyInnerType == null) {
            sb.append(renderTypeConstructor(typeConstructor));
            sb.append(renderTypeArguments(kotlinType.getArguments()));
            return;
        }
        m44849a(sb, buildPossiblyInnerType);
    }

    /* renamed from: a */
    private final void m44849a(StringBuilder sb, PossiblyInnerType possiblyInnerType) {
        StringBuilder sb2;
        PossiblyInnerType outerType = possiblyInnerType.getOuterType();
        if (outerType == null) {
            sb2 = null;
        } else {
            m44849a(sb, outerType);
            sb.append('.');
            Name name = possiblyInnerType.getClassifierDescriptor().getName();
            Intrinsics.checkNotNullExpressionValue(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(renderName(name, false));
            sb2 = sb;
        }
        if (sb2 == null) {
            TypeConstructor typeConstructor = possiblyInnerType.getClassifierDescriptor().getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "possiblyInnerType.classi…escriptor.typeConstructor");
            sb.append(renderTypeConstructor(typeConstructor));
        }
        sb.append(renderTypeArguments(possiblyInnerType.getArguments()));
    }

    public String renderTypeConstructor(TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        boolean z = true;
        if (!(declarationDescriptor instanceof TypeParameterDescriptor ? true : declarationDescriptor instanceof ClassDescriptor)) {
            z = declarationDescriptor instanceof TypeAliasDescriptor;
        }
        if (z) {
            return renderClassifierName(declarationDescriptor);
        }
        if (declarationDescriptor != null) {
            throw new IllegalStateException(Intrinsics.stringPlus("Unexpected classifier: ", declarationDescriptor.getClass()).toString());
        } else if (typeConstructor instanceof IntersectionTypeConstructor) {
            return ((IntersectionTypeConstructor) typeConstructor).makeDebugNameForIntersectionType(DescriptorRendererImpl$renderTypeConstructor$1.INSTANCE);
        } else {
            return typeConstructor.toString();
        }
    }

    public String renderTypeProjection(TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        StringBuilder sb = new StringBuilder();
        m44847a(sb, (List<? extends TypeProjection>) CollectionsKt.listOf(typeProjection));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: a */
    private final void m44847a(StringBuilder sb, List<? extends TypeProjection> list) {
        CollectionsKt.joinTo$default(list, sb, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new DescriptorRendererImpl$appendTypeProjections$1(this), 60, (Object) null);
    }

    /* renamed from: d */
    private final void m44907d(StringBuilder sb, KotlinType kotlinType) {
        Name name;
        int length = sb.length();
        m44880a(m44845a(), sb, (Annotated) kotlinType, (AnnotationUseSiteTarget) null, 2, (Object) null);
        boolean z = true;
        boolean z2 = sb.length() != length;
        boolean isSuspendFunctionType = FunctionTypesKt.isSuspendFunctionType(kotlinType);
        boolean isMarkedNullable = kotlinType.isMarkedNullable();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        boolean z3 = isMarkedNullable || (z2 && receiverTypeFromFunctionType != null);
        if (z3) {
            if (isSuspendFunctionType) {
                sb.insert(length, VersionRange.LEFT_OPEN);
            } else {
                if (z2) {
                    CharSequence charSequence = sb;
                    boolean isWhitespace = CharsKt.isWhitespace(StringsKt.last(charSequence));
                    if (_Assertions.ENABLED && !isWhitespace) {
                        throw new AssertionError("Assertion failed");
                    } else if (sb.charAt(StringsKt.getLastIndex(charSequence) - 1) != ')') {
                        sb.insert(StringsKt.getLastIndex(charSequence), "()");
                    }
                }
                sb.append("(");
            }
        }
        m44855a(sb, isSuspendFunctionType, "suspend");
        if (receiverTypeFromFunctionType != null) {
            if ((!m44887a(receiverTypeFromFunctionType) || receiverTypeFromFunctionType.isMarkedNullable()) && !m44899b(receiverTypeFromFunctionType)) {
                z = false;
            }
            if (z) {
                sb.append("(");
            }
            m44852a(sb, receiverTypeFromFunctionType);
            if (z) {
                sb.append(")");
            }
            sb.append(".");
        }
        sb.append("(");
        int i = 0;
        for (TypeProjection next : FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType)) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(", ");
            }
            if (getParameterNamesInFunctionalTypes()) {
                KotlinType type = next.getType();
                Intrinsics.checkNotNullExpressionValue(type, "typeProjection.type");
                name = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type);
            } else {
                name = null;
            }
            if (name != null) {
                sb.append(renderName(name, false));
                sb.append(": ");
            }
            sb.append(renderTypeProjection(next));
            i = i2;
        }
        sb.append(") ");
        sb.append(m44906d());
        sb.append(" ");
        m44852a(sb, FunctionTypesKt.getReturnTypeFromFunctionType(kotlinType));
        if (z3) {
            sb.append(")");
        }
        if (isMarkedNullable) {
            sb.append("?");
        }
    }

    /* renamed from: b */
    private final boolean m44899b(KotlinType kotlinType) {
        return FunctionTypesKt.isSuspendFunctionType(kotlinType) || !kotlinType.getAnnotations().isEmpty();
    }

    /* renamed from: a */
    private final void m44848a(StringBuilder sb, DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptor containingDeclaration;
        String name;
        if (!(declarationDescriptor instanceof PackageFragmentDescriptor) && !(declarationDescriptor instanceof PackageViewDescriptor) && (containingDeclaration = declarationDescriptor.getContainingDeclaration()) != null && !(containingDeclaration instanceof ModuleDescriptor)) {
            sb.append(" ");
            sb.append(renderMessage("defined in"));
            sb.append(" ");
            FqNameUnsafe fqName = DescriptorUtils.getFqName(containingDeclaration);
            Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(containingDeclaration)");
            sb.append(fqName.isRoot() ? "root package" : renderFqName(fqName));
            if (getWithSourceFileForTopLevel() && (containingDeclaration instanceof PackageFragmentDescriptor) && (declarationDescriptor instanceof DeclarationDescriptorWithSource) && (name = ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile().getName()) != null) {
                sb.append(" ");
                sb.append(renderMessage("in file"));
                sb.append(" ");
                sb.append(name);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m44880a(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget, int i, Object obj) {
        if ((i & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        descriptorRendererImpl.m44850a(sb, annotated, annotationUseSiteTarget);
    }

    /* renamed from: a */
    private final void m44850a(StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            Set<FqName> excludedTypeAnnotationClasses = annotated instanceof KotlinType ? getExcludedTypeAnnotationClasses() : getExcludedAnnotationClasses();
            Function1<AnnotationDescriptor, Boolean> annotationFilter = getAnnotationFilter();
            for (AnnotationDescriptor annotationDescriptor : annotated.getAnnotations()) {
                if (!CollectionsKt.contains(excludedTypeAnnotationClasses, annotationDescriptor.getFqName()) && !m44886a(annotationDescriptor)) {
                    if (annotationFilter == null || annotationFilter.invoke(annotationDescriptor).booleanValue()) {
                        sb.append(renderAnnotation(annotationDescriptor, annotationUseSiteTarget));
                        if (getEachAnnotationOnNewLine()) {
                            sb.append(10);
                            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
                        } else {
                            sb.append(" ");
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private final boolean m44886a(AnnotationDescriptor annotationDescriptor) {
        return Intrinsics.areEqual((Object) annotationDescriptor.getFqName(), (Object) StandardNames.FqNames.parameterName);
    }

    public String renderAnnotation(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (annotationUseSiteTarget != null) {
            sb.append(Intrinsics.stringPlus(annotationUseSiteTarget.getRenderName(), ":"));
        }
        KotlinType type = annotationDescriptor.getType();
        sb.append(renderType(type));
        if (getIncludeAnnotationArguments()) {
            List<String> b = m44891b(annotationDescriptor);
            if (getIncludeEmptyAnnotationArguments() || (!b.isEmpty())) {
                CollectionsKt.joinTo$default(b, sb, ", ", "(", ")", 0, (CharSequence) null, (Function1) null, 112, (Object) null);
            }
        }
        if (getVerbose() && (KotlinTypeKt.isError(type) || (type.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor))) {
            sb.append(" /* annotation class not found */");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> m44891b(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r8) {
        /*
            r7 = this;
            java.util.Map r0 = r8.getAllValueArguments()
            boolean r1 = r7.getRenderDefaultAnnotationArguments()
            r2 = 0
            if (r1 == 0) goto L_0x0010
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r8 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getAnnotationClass(r8)
            goto L_0x0011
        L_0x0010:
            r8 = r2
        L_0x0011:
            r1 = 10
            if (r8 != 0) goto L_0x0016
            goto L_0x0072
        L_0x0016:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r8 = r8.getUnsubstitutedPrimaryConstructor()
            if (r8 != 0) goto L_0x001d
            goto L_0x0072
        L_0x001d:
            java.util.List r8 = r8.getValueParameters()
            if (r8 != 0) goto L_0x0024
            goto L_0x0072
        L_0x0024:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r8 = r8.iterator()
        L_0x0031:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x0048
            java.lang.Object r3 = r8.next()
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            boolean r4 = r4.declaresDefaultValue()
            if (r4 == 0) goto L_0x0031
            r2.add(r3)
            goto L_0x0031
        L_0x0048:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r8 = new java.util.ArrayList
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r1)
            r8.<init>(r3)
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r2 = r2.iterator()
        L_0x005b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x006f
            java.lang.Object r3 = r2.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r3
            kotlin.reflect.jvm.internal.impl.name.Name r3 = r3.getName()
            r8.add(r3)
            goto L_0x005b
        L_0x006f:
            r2 = r8
            java.util.List r2 = (java.util.List) r2
        L_0x0072:
            if (r2 == 0) goto L_0x0075
            goto L_0x0079
        L_0x0075:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0079:
            r8 = r2
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r8 = r8.iterator()
        L_0x0087:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x00a5
            java.lang.Object r4 = r8.next()
            r5 = r4
            kotlin.reflect.jvm.internal.impl.name.Name r5 = (kotlin.reflect.jvm.internal.impl.name.Name) r5
            java.lang.String r6 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            boolean r5 = r0.containsKey(r5)
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x0087
            r3.add(r4)
            goto L_0x0087
        L_0x00a5:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r8 = new java.util.ArrayList
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r1)
            r8.<init>(r4)
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r3 = r3.iterator()
        L_0x00b8:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00d2
            java.lang.Object r4 = r3.next()
            kotlin.reflect.jvm.internal.impl.name.Name r4 = (kotlin.reflect.jvm.internal.impl.name.Name) r4
            java.lang.String r4 = r4.asString()
            java.lang.String r5 = " = ..."
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r5)
            r8.add(r4)
            goto L_0x00b8
        L_0x00d2:
            java.util.List r8 = (java.util.List) r8
            java.util.Set r0 = r0.entrySet()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r1)
            r3.<init>(r1)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r0 = r0.iterator()
        L_0x00e9:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x012a
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r4 = r1.getKey()
            kotlin.reflect.jvm.internal.impl.name.Name r4 = (kotlin.reflect.jvm.internal.impl.name.Name) r4
            java.lang.Object r1 = r1.getValue()
            kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue r1 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r4.asString()
            r5.append(r6)
            java.lang.String r6 = " = "
            r5.append(r6)
            boolean r4 = r2.contains(r4)
            if (r4 != 0) goto L_0x011d
            java.lang.String r1 = r7.m44843a((kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>) r1)
            goto L_0x011f
        L_0x011d:
            java.lang.String r1 = "..."
        L_0x011f:
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r3.add(r1)
            goto L_0x00e9
        L_0x012a:
            java.util.List r3 = (java.util.List) r3
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.List r8 = kotlin.collections.CollectionsKt.plus(r8, r3)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.List r8 = kotlin.collections.CollectionsKt.sorted(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.m44891b(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor):java.util.List");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final String m44843a(ConstantValue<?> constantValue) {
        if (constantValue instanceof ArrayValue) {
            return CollectionsKt.joinToString$default((Iterable) ((ArrayValue) constantValue).getValue(), ", ", Const.joLeft, "}", 0, (CharSequence) null, new DescriptorRendererImpl$renderConstant$1(this), 24, (Object) null);
        }
        if (constantValue instanceof AnnotationValue) {
            return StringsKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, (AnnotationDescriptor) ((AnnotationValue) constantValue).getValue(), (AnnotationUseSiteTarget) null, 2, (Object) null), (CharSequence) "@");
        }
        if (!(constantValue instanceof KClassValue)) {
            return constantValue.toString();
        }
        KClassValue.Value value = (KClassValue.Value) ((KClassValue) constantValue).getValue();
        if (value instanceof KClassValue.Value.LocalClass) {
            return ((KClassValue.Value.LocalClass) value).getType() + "::class";
        } else if (value instanceof KClassValue.Value.NormalClass) {
            KClassValue.Value.NormalClass normalClass = (KClassValue.Value.NormalClass) value;
            String asString = normalClass.getClassId().asSingleFqName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "classValue.classId.asSingleFqName().asString()");
            for (int i = 0; i < normalClass.getArrayDimensions(); i++) {
                asString = "kotlin.Array<" + asString + Typography.greater;
            }
            return Intrinsics.stringPlus(asString, "::class");
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: a */
    private final boolean m44885a(DescriptorVisibility descriptorVisibility, StringBuilder sb) {
        if (!getModifiers().contains(DescriptorRendererModifier.VISIBILITY)) {
            return false;
        }
        if (getNormalizedVisibilities()) {
            descriptorVisibility = descriptorVisibility.normalize();
        }
        if (!getRenderDefaultVisibility() && Intrinsics.areEqual((Object) descriptorVisibility, (Object) DescriptorVisibilities.DEFAULT_VISIBILITY)) {
            return false;
        }
        sb.append(m44840a(descriptorVisibility.getInternalDisplayName()));
        sb.append(" ");
        return true;
    }

    /* renamed from: a */
    private final void m44868a(Modality modality, StringBuilder sb, Modality modality2) {
        if (getRenderDefaultModality() || modality != modality2) {
            m44855a(sb, getModifiers().contains(DescriptorRendererModifier.MODALITY), CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(modality.name()));
        }
    }

    /* renamed from: a */
    private final Modality m44844a(MemberDescriptor memberDescriptor) {
        if (memberDescriptor instanceof ClassDescriptor) {
            return ((ClassDescriptor) memberDescriptor).getKind() == ClassKind.INTERFACE ? Modality.ABSTRACT : Modality.FINAL;
        }
        DeclarationDescriptor containingDeclaration = memberDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null) {
            return Modality.FINAL;
        }
        if (!(memberDescriptor instanceof CallableMemberDescriptor)) {
            return Modality.FINAL;
        }
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) memberDescriptor;
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        if ((!overriddenDescriptors.isEmpty()) && classDescriptor.getModality() != Modality.FINAL) {
            return Modality.OPEN;
        }
        if (classDescriptor.getKind() != ClassKind.INTERFACE || Intrinsics.areEqual((Object) callableMemberDescriptor.getVisibility(), (Object) DescriptorVisibilities.PRIVATE)) {
            return Modality.FINAL;
        }
        return callableMemberDescriptor.getModality() == Modality.ABSTRACT ? Modality.ABSTRACT : Modality.OPEN;
    }

    /* renamed from: a */
    private final void m44860a(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (DescriptorUtils.isTopLevelDeclaration(callableMemberDescriptor) && callableMemberDescriptor.getModality() == Modality.FINAL) {
            return;
        }
        if (getOverrideRenderingPolicy() != OverrideRenderingPolicy.RENDER_OVERRIDE || callableMemberDescriptor.getModality() != Modality.OPEN || !m44884a(callableMemberDescriptor)) {
            Modality modality = callableMemberDescriptor.getModality();
            Intrinsics.checkNotNullExpressionValue(modality, "callable.modality");
            m44868a(modality, sb, m44844a((MemberDescriptor) callableMemberDescriptor));
        }
    }

    /* renamed from: b */
    private final void m44895b(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRendererModifier.OVERRIDE) && m44884a(callableMemberDescriptor) && getOverrideRenderingPolicy() != OverrideRenderingPolicy.RENDER_OPEN) {
            m44855a(sb, true, "override");
            if (getVerbose()) {
                sb.append("/*");
                sb.append(callableMemberDescriptor.getOverriddenDescriptors().size());
                sb.append("*/ ");
            }
        }
    }

    /* renamed from: c */
    private final void m44903c(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND) && getVerbose() && callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.DECLARATION) {
            sb.append("/*");
            sb.append(CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(callableMemberDescriptor.getKind().name()));
            sb.append("*/ ");
        }
    }

    /* renamed from: a */
    private final void m44855a(StringBuilder sb, boolean z, String str) {
        if (z) {
            sb.append(m44840a(str));
            sb.append(" ");
        }
    }

    /* renamed from: a */
    private final void m44867a(MemberDescriptor memberDescriptor, StringBuilder sb) {
        m44855a(sb, memberDescriptor.isExternal(), "external");
        boolean z = true;
        m44855a(sb, getModifiers().contains(DescriptorRendererModifier.EXPECT) && memberDescriptor.isExpect(), "expect");
        if (!getModifiers().contains(DescriptorRendererModifier.ACTUAL) || !memberDescriptor.isActual()) {
            z = false;
        }
        m44855a(sb, z, "actual");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m44866a(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6, java.lang.StringBuilder r7) {
        /*
            r5 = this;
            boolean r0 = r6.isOperator()
            java.lang.String r1 = "functionDescriptor.overriddenDescriptors"
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x003f
            java.util.Collection r0 = r6.getOverriddenDescriptors()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x001e
        L_0x001c:
            r0 = 1
            goto L_0x0035
        L_0x001e:
            java.util.Iterator r0 = r0.iterator()
        L_0x0022:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x001c
            java.lang.Object r4 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r4
            boolean r4 = r4.isOperator()
            if (r4 == 0) goto L_0x0022
            r0 = 0
        L_0x0035:
            if (r0 != 0) goto L_0x003d
            boolean r0 = r5.getAlwaysRenderModifiers()
            if (r0 == 0) goto L_0x003f
        L_0x003d:
            r0 = 1
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            boolean r4 = r6.isInfix()
            if (r4 == 0) goto L_0x007a
            java.util.Collection r4 = r6.getOverriddenDescriptors()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x005a
        L_0x0058:
            r1 = 1
            goto L_0x0071
        L_0x005a:
            java.util.Iterator r1 = r4.iterator()
        L_0x005e:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0058
            java.lang.Object r4 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r4
            boolean r4 = r4.isInfix()
            if (r4 == 0) goto L_0x005e
            r1 = 0
        L_0x0071:
            if (r1 != 0) goto L_0x0079
            boolean r1 = r5.getAlwaysRenderModifiers()
            if (r1 == 0) goto L_0x007a
        L_0x0079:
            r2 = 1
        L_0x007a:
            boolean r1 = r6.isTailrec()
            java.lang.String r3 = "tailrec"
            r5.m44855a((java.lang.StringBuilder) r7, (boolean) r1, (java.lang.String) r3)
            r5.m44897b((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r6, (java.lang.StringBuilder) r7)
            boolean r6 = r6.isInline()
            java.lang.String r1 = "inline"
            r5.m44855a((java.lang.StringBuilder) r7, (boolean) r6, (java.lang.String) r1)
            java.lang.String r6 = "infix"
            r5.m44855a((java.lang.StringBuilder) r7, (boolean) r2, (java.lang.String) r6)
            java.lang.String r6 = "operator"
            r5.m44855a((java.lang.StringBuilder) r7, (boolean) r0, (java.lang.String) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.m44866a(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.StringBuilder):void");
    }

    /* renamed from: b */
    private final void m44897b(FunctionDescriptor functionDescriptor, StringBuilder sb) {
        m44855a(sb, functionDescriptor.isSuspend(), "suspend");
    }

    public String render(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        declarationDescriptor.accept(new RenderDeclarationDescriptorVisitor(this), sb);
        if (getWithDefinedIn()) {
            m44848a(sb, declarationDescriptor);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m44874a(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb, boolean z) {
        if (z) {
            sb.append(m44889b());
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(typeParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        m44855a(sb, typeParameterDescriptor.isReified(), "reified");
        String label = typeParameterDescriptor.getVariance().getLabel();
        boolean z2 = true;
        m44855a(sb, label.length() > 0, label);
        m44880a(this, sb, (Annotated) typeParameterDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
        m44865a((DeclarationDescriptor) typeParameterDescriptor, sb, z);
        int size = typeParameterDescriptor.getUpperBounds().size();
        if ((size > 1 && !z) || size == 1) {
            KotlinType next = typeParameterDescriptor.getUpperBounds().iterator().next();
            if (!KotlinBuiltIns.isDefaultBound(next)) {
                sb.append(" : ");
                Intrinsics.checkNotNullExpressionValue(next, "upperBound");
                sb.append(renderType(next));
            }
        } else if (z) {
            for (KotlinType next2 : typeParameterDescriptor.getUpperBounds()) {
                if (!KotlinBuiltIns.isDefaultBound(next2)) {
                    if (z2) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    Intrinsics.checkNotNullExpressionValue(next2, "upperBound");
                    sb.append(renderType(next2));
                    z2 = false;
                }
            }
        }
        if (z) {
            sb.append(m44900c());
        }
    }

    /* renamed from: a */
    private final void m44858a(List<? extends TypeParameterDescriptor> list, StringBuilder sb, boolean z) {
        if (!getWithoutTypeParameters() && (!list.isEmpty())) {
            sb.append(m44889b());
            m44892b(sb, list);
            sb.append(m44900c());
            if (z) {
                sb.append(" ");
            }
        }
    }

    /* renamed from: b */
    private final void m44892b(StringBuilder sb, List<? extends TypeParameterDescriptor> list) {
        Iterator<? extends TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            m44874a((TypeParameterDescriptor) it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m44905c(FunctionDescriptor functionDescriptor, StringBuilder sb) {
        if (!getStartFromName()) {
            if (!getStartFromDeclarationKeyword()) {
                m44880a(this, sb, (Annotated) functionDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
                DescriptorVisibility visibility = functionDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "function.visibility");
                m44885a(visibility, sb);
                CallableMemberDescriptor callableMemberDescriptor = functionDescriptor;
                m44860a(callableMemberDescriptor, sb);
                if (getIncludeAdditionalModifiers()) {
                    m44867a((MemberDescriptor) functionDescriptor, sb);
                }
                m44895b(callableMemberDescriptor, sb);
                if (getIncludeAdditionalModifiers()) {
                    m44866a(functionDescriptor, sb);
                } else {
                    m44897b(functionDescriptor, sb);
                }
                m44903c(callableMemberDescriptor, sb);
                if (getVerbose()) {
                    if (functionDescriptor.isHiddenToOvercomeSignatureClash()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (functionDescriptor.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(m44840a("fun"));
            sb.append(" ");
            List<TypeParameterDescriptor> typeParameters = functionDescriptor.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "function.typeParameters");
            m44858a((List<? extends TypeParameterDescriptor>) typeParameters, sb, true);
            m44894b((CallableDescriptor) functionDescriptor, sb);
        }
        m44865a((DeclarationDescriptor) functionDescriptor, sb, true);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "function.valueParameters");
        m44856a((Collection<? extends ValueParameterDescriptor>) valueParameters, functionDescriptor.hasSynthesizedParameterNames(), sb);
        m44859a((CallableDescriptor) functionDescriptor, sb);
        KotlinType returnType = functionDescriptor.getReturnType();
        if (!getWithoutReturnType() && (getUnitReturnType() || returnType == null || !KotlinBuiltIns.isUnit(returnType))) {
            sb.append(": ");
            sb.append(returnType == null ? "[NULL]" : renderType(returnType));
        }
        List<TypeParameterDescriptor> typeParameters2 = functionDescriptor.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters2, "function.typeParameters");
        m44857a((List<? extends TypeParameterDescriptor>) typeParameters2, sb);
    }

    /* renamed from: a */
    private final void m44859a(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter;
        if (getReceiverAfterName() && (extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter()) != null) {
            sb.append(" on ");
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
            sb.append(renderType(type));
        }
    }

    /* renamed from: b */
    private final void m44894b(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            m44850a(sb, (Annotated) extensionReceiverParameter, AnnotationUseSiteTarget.RECEIVER);
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
            String renderType = renderType(type);
            if (m44887a(type) && !TypeUtils.isNullableType(type)) {
                renderType = VersionRange.LEFT_OPEN + renderType + VersionRange.RIGHT_OPEN;
            }
            sb.append(renderType);
            sb.append(".");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m44863a(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r18, java.lang.StringBuilder r19) {
        /*
            r17 = this;
            r6 = r17
            r7 = r19
            r2 = r18
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated) r2
            r3 = 0
            r4 = 2
            r5 = 0
            r0 = r17
            r1 = r19
            m44880a((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl) r0, (java.lang.StringBuilder) r1, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated) r2, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget) r3, (int) r4, (java.lang.Object) r5)
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r0 = r6.f60792a
            boolean r0 = r0.getRenderDefaultVisibility()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0028
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = r18.getConstructedClass()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r0 = r0.getModality()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r3 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED
            if (r0 == r3) goto L_0x0039
        L_0x0028:
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r0 = r18.getVisibility()
            java.lang.String r3 = "constructor.visibility"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            boolean r0 = r6.m44885a((kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility) r0, (java.lang.StringBuilder) r7)
            if (r0 == 0) goto L_0x0039
            r0 = 1
            goto L_0x003a
        L_0x0039:
            r0 = 0
        L_0x003a:
            r3 = r18
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r3
            r6.m44903c((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r3, (java.lang.StringBuilder) r7)
            boolean r3 = r17.getRenderConstructorKeyword()
            if (r3 != 0) goto L_0x0052
            boolean r3 = r18.isPrimary()
            if (r3 == 0) goto L_0x0052
            if (r0 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r0 = 0
            goto L_0x0053
        L_0x0052:
            r0 = 1
        L_0x0053:
            if (r0 == 0) goto L_0x005e
            java.lang.String r3 = "constructor"
            java.lang.String r3 = r6.m44840a((java.lang.String) r3)
            r7.append(r3)
        L_0x005e:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r3 = r18.getContainingDeclaration()
            java.lang.String r4 = "constructor.containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r4 = r17.getSecondaryConstructorsAsPrimary()
            java.lang.String r5 = "constructor.typeParameters"
            if (r4 == 0) goto L_0x0086
            if (r0 == 0) goto L_0x0076
            java.lang.String r0 = " "
            r7.append(r0)
        L_0x0076:
            r0 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r0
            r6.m44865a((kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r0, (java.lang.StringBuilder) r7, (boolean) r2)
            java.util.List r0 = r18.getTypeParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            r6.m44858a((java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>) r0, (java.lang.StringBuilder) r7, (boolean) r1)
        L_0x0086:
            java.util.List r0 = r18.getValueParameters()
            java.lang.String r4 = "constructor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r4 = r18.hasSynthesizedParameterNames()
            r6.m44856a((java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor>) r0, (boolean) r4, (java.lang.StringBuilder) r7)
            boolean r0 = r17.getRenderConstructorDelegation()
            if (r0 == 0) goto L_0x0127
            boolean r0 = r18.isPrimary()
            if (r0 != 0) goto L_0x0127
            boolean r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r0 == 0) goto L_0x0127
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r0 = r3.getUnsubstitutedPrimaryConstructor()
            if (r0 == 0) goto L_0x0127
            java.util.List r0 = r0.getValueParameters()
            java.lang.String r3 = "primaryConstructor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r0 = r0.iterator()
        L_0x00c6:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x00e8
            java.lang.Object r4 = r0.next()
            r8 = r4
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r8
            boolean r9 = r8.declaresDefaultValue()
            if (r9 != 0) goto L_0x00e1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r8.getVarargElementType()
            if (r8 != 0) goto L_0x00e1
            r8 = 1
            goto L_0x00e2
        L_0x00e1:
            r8 = 0
        L_0x00e2:
            if (r8 == 0) goto L_0x00c6
            r3.add(r4)
            goto L_0x00c6
        L_0x00e8:
            java.util.List r3 = (java.util.List) r3
            r0 = r3
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x0127
            java.lang.String r0 = " : "
            r7.append(r0)
            java.lang.String r0 = "this"
            java.lang.String r0 = r6.m44840a((java.lang.String) r0)
            r7.append(r0)
            r8 = r3
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.lang.String r0 = ", "
            r9 = r0
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String r0 = "("
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.String r0 = ")"
            r11 = r0
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r12 = 0
            r13 = 0
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderConstructor$1 r0 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderConstructor$1.INSTANCE
            r14 = r0
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            r15 = 24
            r16 = 0
            java.lang.String r0 = kotlin.collections.CollectionsKt.joinToString$default(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r7.append(r0)
        L_0x0127:
            boolean r0 = r17.getSecondaryConstructorsAsPrimary()
            if (r0 == 0) goto L_0x0137
            java.util.List r0 = r18.getTypeParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            r6.m44857a((java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>) r0, (java.lang.StringBuilder) r7)
        L_0x0137:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.m44863a(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, java.lang.StringBuilder):void");
    }

    /* renamed from: a */
    private final void m44857a(List<? extends TypeParameterDescriptor> list, StringBuilder sb) {
        if (!getWithoutTypeParameters()) {
            ArrayList arrayList = new ArrayList(0);
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
                for (KotlinType kotlinType : CollectionsKt.drop(upperBounds, 1)) {
                    StringBuilder sb2 = new StringBuilder();
                    Name name = typeParameterDescriptor.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "typeParameter.name");
                    sb2.append(renderName(name, false));
                    sb2.append(" : ");
                    Intrinsics.checkNotNullExpressionValue(kotlinType, "it");
                    sb2.append(renderType(kotlinType));
                    arrayList.add(sb2.toString());
                }
                Collection collection = arrayList;
            }
            if (!arrayList.isEmpty()) {
                sb.append(" ");
                sb.append(m44840a("where"));
                sb.append(" ");
                CollectionsKt.joinTo$default(arrayList, sb, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null);
            }
        }
    }

    /* renamed from: a */
    private final void m44856a(Collection<? extends ValueParameterDescriptor> collection, boolean z, StringBuilder sb) {
        boolean a = m44888a(z);
        int size = collection.size();
        getValueParametersHandler().appendBeforeValueParameters(size, sb);
        int i = 0;
        for (ValueParameterDescriptor valueParameterDescriptor : collection) {
            getValueParametersHandler().appendBeforeValueParameter(valueParameterDescriptor, i, size, sb);
            m44875a(valueParameterDescriptor, a, sb, false);
            getValueParametersHandler().appendAfterValueParameter(valueParameterDescriptor, i, size, sb);
            i++;
        }
        getValueParametersHandler().appendAfterValueParameters(size, sb);
    }

    /* renamed from: a */
    private final boolean m44888a(boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$1[getParameterNameRenderingPolicy().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            } else if (!z) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0093, code lost:
        if ((getDebugMode() ? r10.declaresDefaultValue() : kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(r10)) != false) goto L_0x0097;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m44875a(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r10, boolean r11, java.lang.StringBuilder r12, boolean r13) {
        /*
            r9 = this;
            if (r13 == 0) goto L_0x0011
            java.lang.String r0 = "value-parameter"
            java.lang.String r0 = r9.m44840a((java.lang.String) r0)
            r12.append(r0)
            java.lang.String r0 = " "
            r12.append(r0)
        L_0x0011:
            boolean r0 = r9.getVerbose()
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "/*"
            r12.append(r0)
            int r0 = r10.getIndex()
            r12.append(r0)
            java.lang.String r0 = "*/ "
            r12.append(r0)
        L_0x0028:
            r3 = r10
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r3 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated) r3
            r4 = 0
            r5 = 2
            r6 = 0
            r1 = r9
            r2 = r12
            m44880a((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl) r1, (java.lang.StringBuilder) r2, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated) r3, (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget) r4, (int) r5, (java.lang.Object) r6)
            boolean r0 = r10.isCrossinline()
            java.lang.String r1 = "crossinline"
            r9.m44855a((java.lang.StringBuilder) r12, (boolean) r0, (java.lang.String) r1)
            boolean r0 = r10.isNoinline()
            java.lang.String r1 = "noinline"
            r9.m44855a((java.lang.StringBuilder) r12, (boolean) r0, (java.lang.String) r1)
            boolean r0 = r9.getRenderPrimaryConstructorParametersAsProperties()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0068
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r0 = r10.getContainingDeclaration()
            boolean r3 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor
            if (r3 == 0) goto L_0x0058
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) r0
            goto L_0x0059
        L_0x0058:
            r0 = 0
        L_0x0059:
            if (r0 != 0) goto L_0x005d
        L_0x005b:
            r0 = 0
            goto L_0x0064
        L_0x005d:
            boolean r0 = r0.isPrimary()
            if (r0 != r1) goto L_0x005b
            r0 = 1
        L_0x0064:
            if (r0 == 0) goto L_0x0068
            r8 = 1
            goto L_0x0069
        L_0x0068:
            r8 = 0
        L_0x0069:
            if (r8 == 0) goto L_0x0074
            boolean r0 = r9.getActualPropertiesInPrimaryConstructor()
            java.lang.String r3 = "actual"
            r9.m44855a((java.lang.StringBuilder) r12, (boolean) r0, (java.lang.String) r3)
        L_0x0074:
            r4 = r10
            kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor) r4
            r3 = r9
            r5 = r11
            r6 = r12
            r7 = r13
            r3.m44878a((kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor) r4, (boolean) r5, (java.lang.StringBuilder) r6, (boolean) r7, (boolean) r8)
            kotlin.jvm.functions.Function1 r11 = r9.getDefaultParameterValueRenderer()
            if (r11 == 0) goto L_0x0096
            boolean r11 = r9.getDebugMode()
            if (r11 == 0) goto L_0x008f
            boolean r11 = r10.declaresDefaultValue()
            goto L_0x0093
        L_0x008f:
            boolean r11 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(r10)
        L_0x0093:
            if (r11 == 0) goto L_0x0096
            goto L_0x0097
        L_0x0096:
            r1 = 0
        L_0x0097:
            if (r1 == 0) goto L_0x00ad
            kotlin.jvm.functions.Function1 r11 = r9.getDefaultParameterValueRenderer()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            java.lang.Object r10 = r11.invoke(r10)
            java.lang.String r11 = " = "
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r10)
            r12.append(r10)
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.m44875a(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, boolean, java.lang.StringBuilder, boolean):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m44882a(DescriptorRendererImpl descriptorRendererImpl, VariableDescriptor variableDescriptor, StringBuilder sb, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        descriptorRendererImpl.m44877a(variableDescriptor, sb, z);
    }

    /* renamed from: a */
    private final void m44877a(VariableDescriptor variableDescriptor, StringBuilder sb, boolean z) {
        if (z || !(variableDescriptor instanceof ValueParameterDescriptor)) {
            sb.append(m44840a(variableDescriptor.isVar() ? "var" : "val"));
            sb.append(" ");
        }
    }

    /* renamed from: a */
    private final void m44878a(VariableDescriptor variableDescriptor, boolean z, StringBuilder sb, boolean z2, boolean z3) {
        KotlinType type = variableDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "variable.type");
        KotlinType kotlinType = null;
        ValueParameterDescriptor valueParameterDescriptor = variableDescriptor instanceof ValueParameterDescriptor ? (ValueParameterDescriptor) variableDescriptor : null;
        if (valueParameterDescriptor != null) {
            kotlinType = valueParameterDescriptor.getVarargElementType();
        }
        KotlinType kotlinType2 = kotlinType == null ? type : kotlinType;
        m44855a(sb, kotlinType != null, "vararg");
        if (z3 || (z2 && !getStartFromName())) {
            m44877a(variableDescriptor, sb, z3);
        }
        if (z) {
            m44865a((DeclarationDescriptor) variableDescriptor, sb, z2);
            sb.append(": ");
        }
        sb.append(renderType(kotlinType2));
        m44876a(variableDescriptor, sb);
        if (getVerbose() && kotlinType != null) {
            sb.append(" /*");
            sb.append(renderType(type));
            sb.append("*/");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m44872a(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        if (!getStartFromName()) {
            if (!getStartFromDeclarationKeyword()) {
                m44898b(propertyDescriptor, sb);
                DescriptorVisibility visibility = propertyDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "property.visibility");
                m44885a(visibility, sb);
                boolean z = false;
                m44855a(sb, getModifiers().contains(DescriptorRendererModifier.CONST) && propertyDescriptor.isConst(), "const");
                m44867a((MemberDescriptor) propertyDescriptor, sb);
                CallableMemberDescriptor callableMemberDescriptor = propertyDescriptor;
                m44860a(callableMemberDescriptor, sb);
                m44895b(callableMemberDescriptor, sb);
                if (getModifiers().contains(DescriptorRendererModifier.LATEINIT) && propertyDescriptor.isLateInit()) {
                    z = true;
                }
                m44855a(sb, z, "lateinit");
                m44903c(callableMemberDescriptor, sb);
            }
            m44882a(this, (VariableDescriptor) propertyDescriptor, sb, false, 4, (Object) null);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptor.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "property.typeParameters");
            m44858a((List<? extends TypeParameterDescriptor>) typeParameters, sb, true);
            m44894b((CallableDescriptor) propertyDescriptor, sb);
        }
        m44865a((DeclarationDescriptor) propertyDescriptor, sb, true);
        sb.append(": ");
        KotlinType type = propertyDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "property.type");
        sb.append(renderType(type));
        m44859a((CallableDescriptor) propertyDescriptor, sb);
        m44876a((VariableDescriptor) propertyDescriptor, sb);
        List<TypeParameterDescriptor> typeParameters2 = propertyDescriptor.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters2, "property.typeParameters");
        m44857a((List<? extends TypeParameterDescriptor>) typeParameters2, sb);
    }

    /* renamed from: b */
    private final void m44898b(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            m44880a(this, sb, (Annotated) propertyDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
            FieldDescriptor backingField = propertyDescriptor.getBackingField();
            if (backingField != null) {
                m44850a(sb, (Annotated) backingField, AnnotationUseSiteTarget.FIELD);
            }
            FieldDescriptor delegateField = propertyDescriptor.getDelegateField();
            if (delegateField != null) {
                m44850a(sb, (Annotated) delegateField, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
            }
            if (getPropertyAccessorRenderingPolicy() == PropertyAccessorRenderingPolicy.NONE) {
                PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
                if (getter != null) {
                    m44850a(sb, (Annotated) getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
                }
                PropertySetterDescriptor setter = propertyDescriptor.getSetter();
                if (setter != null) {
                    m44850a(sb, (Annotated) setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                    List<ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(valueParameters, "setter.valueParameters");
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt.single(valueParameters);
                    Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "it");
                    m44850a(sb, (Annotated) valueParameterDescriptor, AnnotationUseSiteTarget.SETTER_PARAMETER);
                }
            }
        }
    }

    /* renamed from: a */
    private final void m44876a(VariableDescriptor variableDescriptor, StringBuilder sb) {
        ConstantValue<?> compileTimeInitializer;
        if (getIncludePropertyConstant() && (compileTimeInitializer = variableDescriptor.getCompileTimeInitializer()) != null) {
            sb.append(" = ");
            sb.append(m44901c(m44843a(compileTimeInitializer)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m44873a(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
        m44880a(this, sb, (Annotated) typeAliasDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
        DescriptorVisibility visibility = typeAliasDescriptor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "typeAlias.visibility");
        m44885a(visibility, sb);
        m44867a((MemberDescriptor) typeAliasDescriptor, sb);
        sb.append(m44840a("typealias"));
        sb.append(" ");
        m44865a((DeclarationDescriptor) typeAliasDescriptor, sb, true);
        List<TypeParameterDescriptor> declaredTypeParameters = typeAliasDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "typeAlias.declaredTypeParameters");
        m44858a((List<? extends TypeParameterDescriptor>) declaredTypeParameters, sb, false);
        m44862a((ClassifierDescriptorWithTypeParameters) typeAliasDescriptor, sb);
        sb.append(" = ");
        sb.append(renderType(typeAliasDescriptor.getUnderlyingType()));
    }

    /* renamed from: a */
    private final void m44862a(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, StringBuilder sb) {
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "classifier.declaredTypeParameters");
        List<TypeParameterDescriptor> parameters = classifierDescriptorWithTypeParameters.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "classifier.typeConstructor.parameters");
        if (getVerbose() && classifierDescriptorWithTypeParameters.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb.append(" /*captured type parameters: ");
            m44892b(sb, (List<? extends TypeParameterDescriptor>) parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb.append("*/");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m44861a(ClassDescriptor classDescriptor, StringBuilder sb) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        boolean z = classDescriptor.getKind() == ClassKind.ENUM_ENTRY;
        if (!getStartFromName()) {
            m44880a(this, sb, (Annotated) classDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
            if (!z) {
                DescriptorVisibility visibility = classDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "klass.visibility");
                m44885a(visibility, sb);
            }
            if (!(classDescriptor.getKind() == ClassKind.INTERFACE && classDescriptor.getModality() == Modality.ABSTRACT) && (!classDescriptor.getKind().isSingleton() || classDescriptor.getModality() != Modality.FINAL)) {
                Modality modality = classDescriptor.getModality();
                Intrinsics.checkNotNullExpressionValue(modality, "klass.modality");
                m44868a(modality, sb, m44844a((MemberDescriptor) classDescriptor));
            }
            m44867a((MemberDescriptor) classDescriptor, sb);
            m44855a(sb, getModifiers().contains(DescriptorRendererModifier.INNER) && classDescriptor.isInner(), "inner");
            m44855a(sb, getModifiers().contains(DescriptorRendererModifier.DATA) && classDescriptor.isData(), "data");
            m44855a(sb, getModifiers().contains(DescriptorRendererModifier.INLINE) && classDescriptor.isInline(), "inline");
            m44855a(sb, getModifiers().contains(DescriptorRendererModifier.VALUE) && classDescriptor.isValue(), "value");
            m44855a(sb, getModifiers().contains(DescriptorRendererModifier.FUN) && classDescriptor.isFun(), "fun");
            m44904c(classDescriptor, sb);
        }
        DeclarationDescriptor declarationDescriptor = classDescriptor;
        if (!DescriptorUtils.isCompanionObject(declarationDescriptor)) {
            if (!getStartFromName()) {
                m44846a(sb);
            }
            m44865a(declarationDescriptor, sb, true);
        } else {
            m44864a(declarationDescriptor, sb);
        }
        if (!z) {
            List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
            Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "klass.declaredTypeParameters");
            m44858a((List<? extends TypeParameterDescriptor>) declaredTypeParameters, sb, false);
            m44862a((ClassifierDescriptorWithTypeParameters) classDescriptor, sb);
            if (!classDescriptor.getKind().isSingleton() && getClassWithPrimaryConstructor() && (unsubstitutedPrimaryConstructor = classDescriptor.getUnsubstitutedPrimaryConstructor()) != null) {
                sb.append(" ");
                m44880a(this, sb, (Annotated) unsubstitutedPrimaryConstructor, (AnnotationUseSiteTarget) null, 2, (Object) null);
                DescriptorVisibility visibility2 = unsubstitutedPrimaryConstructor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility2, "primaryConstructor.visibility");
                m44885a(visibility2, sb);
                sb.append(m44840a("constructor"));
                List<ValueParameterDescriptor> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "primaryConstructor.valueParameters");
                m44856a((Collection<? extends ValueParameterDescriptor>) valueParameters, unsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb);
            }
            m44896b(classDescriptor, sb);
            m44857a((List<? extends TypeParameterDescriptor>) declaredTypeParameters, sb);
        }
    }

    /* renamed from: b */
    private final void m44896b(ClassDescriptor classDescriptor, StringBuilder sb) {
        if (!getWithoutSuperTypes() && !KotlinBuiltIns.isNothing(classDescriptor.getDefaultType())) {
            Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            Intrinsics.checkNotNullExpressionValue(supertypes, "klass.typeConstructor.supertypes");
            if (supertypes.isEmpty()) {
                return;
            }
            if (supertypes.size() != 1 || !KotlinBuiltIns.isAnyOrNullableAny(supertypes.iterator().next())) {
                m44846a(sb);
                sb.append(": ");
                CollectionsKt.joinTo$default(supertypes, sb, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new DescriptorRendererImpl$renderSuperTypes$1(this), 60, (Object) null);
            }
        }
    }

    /* renamed from: c */
    private final void m44904c(ClassDescriptor classDescriptor, StringBuilder sb) {
        sb.append(m44840a(DescriptorRenderer.Companion.getClassifierKindPrefix(classDescriptor)));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m44870a(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
        m44879a(packageViewDescriptor.getFqName(), "package", sb);
        if (getDebugMode()) {
            sb.append(" in context of ");
            m44865a((DeclarationDescriptor) packageViewDescriptor.getModule(), sb, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m44869a(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
        m44879a(packageFragmentDescriptor.getFqName(), "package-fragment", sb);
        if (getDebugMode()) {
            sb.append(" in ");
            m44865a((DeclarationDescriptor) packageFragmentDescriptor.getContainingDeclaration(), sb, false);
        }
    }

    /* renamed from: a */
    private final void m44879a(FqName fqName, String str, StringBuilder sb) {
        sb.append(m44840a(str));
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "fqName.toUnsafe()");
        String renderFqName = renderFqName(unsafe);
        if (renderFqName.length() > 0) {
            sb.append(" ");
            sb.append(renderFqName);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m44871a(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb) {
        m44867a((MemberDescriptor) propertyAccessorDescriptor, sb);
    }

    /* compiled from: DescriptorRendererImpl.kt */
    private final class RenderDeclarationDescriptorVisitor implements DeclarationDescriptorVisitor<Unit, StringBuilder> {
        final /* synthetic */ DescriptorRendererImpl this$0;

        /* compiled from: DescriptorRendererImpl.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PropertyAccessorRenderingPolicy.values().length];
                iArr[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;
                iArr[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;
                iArr[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public RenderDeclarationDescriptorVisitor(DescriptorRendererImpl descriptorRendererImpl) {
            Intrinsics.checkNotNullParameter(descriptorRendererImpl, "this$0");
            this.this$0 = descriptorRendererImpl;
        }

        public /* bridge */ /* synthetic */ Object visitClassDescriptor(ClassDescriptor classDescriptor, Object obj) {
            visitClassDescriptor(classDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, Object obj) {
            visitConstructorDescriptor(constructorDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitFunctionDescriptor(FunctionDescriptor functionDescriptor, Object obj) {
            visitFunctionDescriptor(functionDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitModuleDeclaration(ModuleDescriptor moduleDescriptor, Object obj) {
            visitModuleDeclaration(moduleDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, Object obj) {
            visitPackageFragmentDescriptor(packageFragmentDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, Object obj) {
            visitPackageViewDescriptor(packageViewDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, Object obj) {
            visitPropertyDescriptor(propertyDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, Object obj) {
            visitPropertyGetterDescriptor(propertyGetterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, Object obj) {
            visitPropertySetterDescriptor(propertySetterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, Object obj) {
            visitReceiverParameterDescriptor(receiverParameterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, Object obj) {
            visitTypeAliasDescriptor(typeAliasDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, Object obj) {
            visitTypeParameterDescriptor(typeParameterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, Object obj) {
            visitValueParameterDescriptor(valueParameterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public void visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(valueParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            this.this$0.m44875a(valueParameterDescriptor, true, sb, true);
        }

        public void visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(propertyDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            this.this$0.m44872a(propertyDescriptor, sb);
        }

        public void visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(propertyGetterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            visitPropertyAccessorDescriptor(propertyGetterDescriptor, sb, "getter");
        }

        public void visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(propertySetterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            visitPropertyAccessorDescriptor(propertySetterDescriptor, sb, "setter");
        }

        private final void visitPropertyAccessorDescriptor(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb, String str) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.this$0.getPropertyAccessorRenderingPolicy().ordinal()];
            if (i == 1) {
                this.this$0.m44871a(propertyAccessorDescriptor, sb);
                sb.append(Intrinsics.stringPlus(str, " for "));
                DescriptorRendererImpl descriptorRendererImpl = this.this$0;
                PropertyDescriptor correspondingProperty = propertyAccessorDescriptor.getCorrespondingProperty();
                Intrinsics.checkNotNullExpressionValue(correspondingProperty, "descriptor.correspondingProperty");
                descriptorRendererImpl.m44872a(correspondingProperty, sb);
            } else if (i == 2) {
                visitFunctionDescriptor((FunctionDescriptor) propertyAccessorDescriptor, sb);
            }
        }

        public void visitFunctionDescriptor(FunctionDescriptor functionDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            this.this$0.m44905c(functionDescriptor, sb);
        }

        public void visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(receiverParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            sb.append(receiverParameterDescriptor.getName());
        }

        public void visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(constructorDescriptor, "constructorDescriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            this.this$0.m44863a(constructorDescriptor, sb);
        }

        public void visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(typeParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            this.this$0.m44874a(typeParameterDescriptor, sb, true);
        }

        public void visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            this.this$0.m44869a(packageFragmentDescriptor, sb);
        }

        public void visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(packageViewDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            this.this$0.m44870a(packageViewDescriptor, sb);
        }

        public void visitModuleDeclaration(ModuleDescriptor moduleDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            this.this$0.m44865a((DeclarationDescriptor) moduleDescriptor, sb, true);
        }

        public void visitClassDescriptor(ClassDescriptor classDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            this.this$0.m44861a(classDescriptor, sb);
        }

        public void visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            this.this$0.m44873a(typeAliasDescriptor, sb);
        }
    }

    /* renamed from: a */
    private final void m44846a(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    /* renamed from: a */
    private final String m44841a(String str, String str2, String str3, String str4, String str5) {
        if (StringsKt.startsWith$default(str, str2, false, 2, (Object) null) && StringsKt.startsWith$default(str3, str4, false, 2, (Object) null)) {
            int length = str2.length();
            if (str != null) {
                String substring = str.substring(length);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                int length2 = str4.length();
                if (str3 != null) {
                    String substring2 = str3.substring(length2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                    String stringPlus = Intrinsics.stringPlus(str5, substring);
                    if (Intrinsics.areEqual((Object) substring, (Object) substring2)) {
                        return stringPlus;
                    }
                    if (m44883a(substring, substring2)) {
                        return Intrinsics.stringPlus(stringPlus, "!");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return null;
    }

    /* renamed from: a */
    private final boolean m44883a(String str, String str2) {
        if (!Intrinsics.areEqual((Object) str, (Object) StringsKt.replace$default(str2, "?", "", false, 4, (Object) null)) && (!StringsKt.endsWith$default(str2, "?", false, 2, (Object) null) || !Intrinsics.areEqual((Object) Intrinsics.stringPlus(str, "?"), (Object) str2))) {
            StringBuilder sb = new StringBuilder();
            sb.append(VersionRange.LEFT_OPEN);
            sb.append(str);
            sb.append(")?");
            return Intrinsics.areEqual((Object) sb.toString(), (Object) str2);
        }
    }

    /* renamed from: a */
    private final boolean m44884a(CallableMemberDescriptor callableMemberDescriptor) {
        return !callableMemberDescriptor.getOverriddenDescriptors().isEmpty();
    }
}
