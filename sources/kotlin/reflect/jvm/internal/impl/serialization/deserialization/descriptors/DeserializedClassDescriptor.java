package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.CliSealedClassInheritorsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor extends AbstractClassDescriptor implements DeserializedDescriptor {

    /* renamed from: a */
    private final ProtoBuf.Class f61023a;

    /* renamed from: b */
    private final BinaryVersion f61024b;

    /* renamed from: c */
    private final SourceElement f61025c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ClassId f61026d;

    /* renamed from: e */
    private final Modality f61027e = ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(this.f61023a.getFlags()));

    /* renamed from: f */
    private final DescriptorVisibility f61028f = ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(this.f61023a.getFlags()));

    /* renamed from: g */
    private final ClassKind f61029g = ProtoEnumFlags.INSTANCE.classKind(Flags.CLASS_KIND.get(this.f61023a.getFlags()));

    /* renamed from: h */
    private final DeserializationContext f61030h;

    /* renamed from: i */
    private final MemberScopeImpl f61031i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final DeserializedClassTypeConstructor f61032j;

    /* renamed from: k */
    private final ScopesHolderForClass<DeserializedClassMemberScope> f61033k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final EnumEntryClassDescriptors f61034l;

    /* renamed from: m */
    private final DeclarationDescriptor f61035m;

    /* renamed from: n */
    private final NullableLazyValue<ClassConstructorDescriptor> f61036n;

    /* renamed from: o */
    private final NotNullLazyValue<Collection<ClassConstructorDescriptor>> f61037o;

    /* renamed from: p */
    private final NullableLazyValue<ClassDescriptor> f61038p;

    /* renamed from: q */
    private final NotNullLazyValue<Collection<ClassDescriptor>> f61039q;

    /* renamed from: r */
    private final NullableLazyValue<InlineClassRepresentation<SimpleType>> f61040r;

    /* renamed from: s */
    private final ProtoContainer.Class f61041s;

    /* renamed from: t */
    private final Annotations f61042t;

    public boolean isActual() {
        return false;
    }

    public final ProtoBuf.Class getClassProto() {
        return this.f61023a;
    }

    public final BinaryVersion getMetadataVersion() {
        return this.f61024b;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor(DeserializationContext deserializationContext, ProtoBuf.Class classR, NameResolver nameResolver, BinaryVersion binaryVersion, SourceElement sourceElement) {
        super(deserializationContext.getStorageManager(), NameResolverUtilKt.getClassId(nameResolver, classR.getFqName()).getShortClassName());
        Annotations annotations;
        Intrinsics.checkNotNullParameter(deserializationContext, "outerContext");
        Intrinsics.checkNotNullParameter(classR, "classProto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        this.f61023a = classR;
        this.f61024b = binaryVersion;
        this.f61025c = sourceElement;
        this.f61026d = NameResolverUtilKt.getClassId(nameResolver, classR.getFqName());
        List<ProtoBuf.TypeParameter> typeParameterList = this.f61023a.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "classProto.typeParameterList");
        ProtoBuf.TypeTable typeTable = this.f61023a.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "classProto.typeTable");
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable versionRequirementTable = this.f61023a.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "classProto.versionRequirementTable");
        this.f61030h = deserializationContext.childContext(this, typeParameterList, nameResolver, typeTable2, companion.create(versionRequirementTable), this.f61024b);
        this.f61031i = this.f61029g == ClassKind.ENUM_CLASS ? new StaticScopeForKotlinEnum(this.f61030h.getStorageManager(), this) : MemberScope.Empty.INSTANCE;
        this.f61032j = new DeserializedClassTypeConstructor(this);
        this.f61033k = ScopesHolderForClass.Companion.create(this, this.f61030h.getStorageManager(), this.f61030h.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new DeserializedClassDescriptor$memberScopeHolder$1(this));
        ProtoContainer.Class classR2 = null;
        this.f61034l = this.f61029g == ClassKind.ENUM_CLASS ? new EnumEntryClassDescriptors(this) : null;
        this.f61035m = deserializationContext.getContainingDeclaration();
        this.f61036n = this.f61030h.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$primaryConstructor$1(this));
        this.f61037o = this.f61030h.getStorageManager().createLazyValue(new DeserializedClassDescriptor$constructors$1(this));
        this.f61038p = this.f61030h.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$companionObjectDescriptor$1(this));
        this.f61039q = this.f61030h.getStorageManager().createLazyValue(new DeserializedClassDescriptor$sealedSubclasses$1(this));
        this.f61040r = this.f61030h.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$inlineClassRepresentation$1(this));
        ProtoBuf.Class classR3 = this.f61023a;
        NameResolver nameResolver2 = this.f61030h.getNameResolver();
        TypeTable typeTable3 = this.f61030h.getTypeTable();
        SourceElement sourceElement2 = this.f61025c;
        DeclarationDescriptor declarationDescriptor = this.f61035m;
        DeserializedClassDescriptor deserializedClassDescriptor = declarationDescriptor instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) declarationDescriptor : null;
        this.f61041s = new ProtoContainer.Class(classR3, nameResolver2, typeTable3, sourceElement2, deserializedClassDescriptor != null ? deserializedClassDescriptor.f61041s : classR2);
        if (!Flags.HAS_ANNOTATIONS.get(this.f61023a.getFlags()).booleanValue()) {
            annotations = Annotations.Companion.getEMPTY();
        } else {
            annotations = new NonEmptyDeserializedAnnotations(this.f61030h.getStorageManager(), new DeserializedClassDescriptor$annotations$1(this));
        }
        this.f61042t = annotations;
    }

    public final DeserializationContext getC() {
        return this.f61030h;
    }

    /* renamed from: a */
    private final DeserializedClassMemberScope m44997a() {
        return this.f61033k.getScope(this.f61030h.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
    }

    public final ProtoContainer.Class getThisAsProtoContainer$deserialization() {
        return this.f61041s;
    }

    public Annotations getAnnotations() {
        return this.f61042t;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        return this.f61035m;
    }

    public TypeConstructor getTypeConstructor() {
        return this.f61032j;
    }

    public ClassKind getKind() {
        return this.f61029g;
    }

    public Modality getModality() {
        return this.f61027e;
    }

    public DescriptorVisibility getVisibility() {
        return this.f61028f;
    }

    public boolean isInner() {
        Boolean bool = Flags.IS_INNER.get(this.f61023a.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_INNER.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isData() {
        Boolean bool = Flags.IS_DATA.get(this.f61023a.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_DATA.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isInline() {
        Boolean bool = Flags.IS_INLINE_CLASS.get(this.f61023a.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_INLINE_CLASS.get(classProto.flags)");
        return bool.booleanValue() && this.f61024b.isAtMost(1, 4, 1);
    }

    public boolean isExpect() {
        Boolean bool = Flags.IS_EXPECT_CLASS.get(this.f61023a.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_EXPECT_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isExternal() {
        Boolean bool = Flags.IS_EXTERNAL_CLASS.get(this.f61023a.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isFun() {
        Boolean bool = Flags.IS_FUN_INTERFACE.get(this.f61023a.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_FUN_INTERFACE.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isValue() {
        Boolean bool = Flags.IS_INLINE_CLASS.get(this.f61023a.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_INLINE_CLASS.get(classProto.flags)");
        return bool.booleanValue() && this.f61024b.isAtLeast(1, 4, 2);
    }

    /* access modifiers changed from: protected */
    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f61033k.getScope(kotlinTypeRefiner);
    }

    public MemberScopeImpl getStaticScope() {
        return this.f61031i;
    }

    public boolean isCompanionObject() {
        return Flags.CLASS_KIND.get(this.f61023a.getFlags()) == ProtoBuf.Class.Kind.COMPANION_OBJECT;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final ClassConstructorDescriptor m44998b() {
        Object obj;
        if (this.f61029g.isSingleton()) {
            ClassConstructorDescriptorImpl createPrimaryConstructorForObject = DescriptorFactory.createPrimaryConstructorForObject(this, SourceElement.NO_SOURCE);
            createPrimaryConstructorForObject.setReturnType(getDefaultType());
            return createPrimaryConstructorForObject;
        }
        List<ProtoBuf.Constructor> constructorList = this.f61023a.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(constructorList, "classProto.constructorList");
        Iterator it = constructorList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!Flags.IS_SECONDARY.get(((ProtoBuf.Constructor) obj).getFlags()).booleanValue()) {
                break;
            }
        }
        ProtoBuf.Constructor constructor = (ProtoBuf.Constructor) obj;
        if (constructor == null) {
            return null;
        }
        return getC().getMemberDeserializer().loadConstructor(constructor, true);
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) this.f61036n.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final Collection<ClassConstructorDescriptor> m44999c() {
        return CollectionsKt.plus(CollectionsKt.plus(m45000d(), CollectionsKt.listOfNotNull(getUnsubstitutedPrimaryConstructor())), this.f61030h.getComponents().getAdditionalClassPartsProvider().getConstructors(this));
    }

    /* renamed from: d */
    private final List<ClassConstructorDescriptor> m45000d() {
        List<ProtoBuf.Constructor> constructorList = this.f61023a.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(constructorList, "classProto.constructorList");
        Collection arrayList = new ArrayList();
        for (Object next : constructorList) {
            Boolean bool = Flags.IS_SECONDARY.get(((ProtoBuf.Constructor) next).getFlags());
            Intrinsics.checkNotNullExpressionValue(bool, "IS_SECONDARY.get(it.flags)");
            if (bool.booleanValue()) {
                arrayList.add(next);
            }
        }
        Iterable<ProtoBuf.Constructor> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Constructor constructor : iterable) {
            MemberDeserializer memberDeserializer = getC().getMemberDeserializer();
            Intrinsics.checkNotNullExpressionValue(constructor, "it");
            arrayList2.add(memberDeserializer.loadConstructor(constructor, false));
        }
        return (List) arrayList2;
    }

    public Collection<ClassConstructorDescriptor> getConstructors() {
        return (Collection) this.f61037o.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final ClassDescriptor m45001e() {
        if (!this.f61023a.hasCompanionObjectName()) {
            return null;
        }
        ClassifierDescriptor contributedClassifier = m44997a().getContributedClassifier(NameResolverUtilKt.getName(this.f61030h.getNameResolver(), this.f61023a.getCompanionObjectName()), NoLookupLocation.FROM_DESERIALIZATION);
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }

    public ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor) this.f61038p.invoke();
    }

    public final boolean hasNestedClass$deserialization(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return m44997a().getClassNames$deserialization().contains(name);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final Collection<ClassDescriptor> m45002f() {
        if (this.f61027e != Modality.SEALED) {
            return CollectionsKt.emptyList();
        }
        List<Integer> sealedSubclassFqNameList = this.f61023a.getSealedSubclassFqNameList();
        Intrinsics.checkNotNullExpressionValue(sealedSubclassFqNameList, "fqNames");
        if (!(!sealedSubclassFqNameList.isEmpty())) {
            return CliSealedClassInheritorsProvider.INSTANCE.computeSealedSubclasses(this, false);
        }
        Collection arrayList = new ArrayList();
        for (Integer num : sealedSubclassFqNameList) {
            DeserializationComponents components = getC().getComponents();
            NameResolver nameResolver = getC().getNameResolver();
            Intrinsics.checkNotNullExpressionValue(num, "index");
            ClassDescriptor deserializeClass = components.deserializeClass(NameResolverUtilKt.getClassId(nameResolver, num.intValue()));
            if (deserializeClass != null) {
                arrayList.add(deserializeClass);
            }
        }
        return (List) arrayList;
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        return (Collection) this.f61039q.invoke();
    }

    public InlineClassRepresentation<SimpleType> getInlineClassRepresentation() {
        return (InlineClassRepresentation) this.f61040r.invoke();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX WARNING: type inference failed for: r1v7, types: [kotlin.reflect.jvm.internal.impl.types.KotlinType] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> m45003g() {
        /*
            r10 = this;
            r0 = r10
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r0
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r10.f61023a
            boolean r0 = r0.hasInlineClassUnderlyingPropertyName()
            r2 = 1
            if (r0 == 0) goto L_0x0025
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r10.f61030h
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r0 = r0.getNameResolver()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r3 = r10.f61023a
            int r3 = r3.getInlineClassUnderlyingPropertyName()
            kotlin.reflect.jvm.internal.impl.name.Name r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r0, r3)
            goto L_0x004c
        L_0x0025:
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion r0 = r10.f61024b
            r3 = 5
            boolean r0 = r0.isAtLeast(r2, r3, r2)
            if (r0 != 0) goto L_0x00db
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r0 = r10.getUnsubstitutedPrimaryConstructor()
            if (r0 == 0) goto L_0x00c9
            java.util.List r0 = r0.getValueParameters()
            java.lang.String r3 = "constructor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r0.getName()
            java.lang.String r3 = "{\n                // Bef…irst().name\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
        L_0x004c:
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r3 = r10.f61023a
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r4 = r10.f61030h
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r4 = r4.getTypeTable()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.inlineClassUnderlyingType(r3, r4)
            r4 = 0
            if (r3 != 0) goto L_0x005d
            r3 = r1
            goto L_0x0068
        L_0x005d:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r5 = r10.f61030h
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r5 = r5.getTypeDeserializer()
            r6 = 2
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.simpleType$default(r5, r3, r4, r6, r1)
        L_0x0068:
            if (r3 != 0) goto L_0x00c1
            r3 = r10
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) r3
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope r5 = r3.m44997a()
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r6 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r6 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r6
            java.util.Collection r5 = r5.getContributedVariables(r0, r6)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
            r7 = r1
            r6 = 0
        L_0x0081:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x009f
            java.lang.Object r8 = r5.next()
            r9 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r9
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r9 = r9.getExtensionReceiverParameter()
            if (r9 != 0) goto L_0x0096
            r9 = 1
            goto L_0x0097
        L_0x0096:
            r9 = 0
        L_0x0097:
            if (r9 == 0) goto L_0x0081
            if (r6 == 0) goto L_0x009c
            goto L_0x00a3
        L_0x009c:
            r7 = r8
            r6 = 1
            goto L_0x0081
        L_0x009f:
            if (r6 != 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r1 = r7
        L_0x00a3:
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r1
            if (r1 == 0) goto L_0x00af
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r1.getType()
            r3 = r1
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r3
            goto L_0x00c1
        L_0x00af:
            java.lang.String r0 = "Inline class has no underlying property: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r3)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00c1:
            kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation r1 = new kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r3
            r1.<init>(r0, r3)
            return r1
        L_0x00c9:
            java.lang.String r0 = "Inline class has no primary constructor: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r10)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00db:
            java.lang.String r0 = "Inline class has no underlying property name in metadata: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r10)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.m45003g():kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("deserialized ");
        sb.append(isExpect() ? "expect " : "");
        sb.append("class ");
        sb.append(getName());
        return sb.toString();
    }

    public SourceElement getSource() {
        return this.f61025c;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.f61030h.getTypeDeserializer().getOwnTypeParameters();
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    private final class DeserializedClassTypeConstructor extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters = this.this$0.getC().getStorageManager().createLazyValue(new C21730x32944d2c(this.this$0));
        final /* synthetic */ DeserializedClassDescriptor this$0;

        public boolean isDenotable() {
            return true;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeserializedClassTypeConstructor(DeserializedClassDescriptor deserializedClassDescriptor) {
            super(deserializedClassDescriptor.getC().getStorageManager());
            Intrinsics.checkNotNullParameter(deserializedClassDescriptor, "this$0");
            this.this$0 = deserializedClassDescriptor;
        }

        /* JADX WARNING: type inference failed for: r4v8, types: [kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00db, code lost:
            r7 = r7.asSingleFqName();
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> computeSupertypes() {
            /*
                r8 = this;
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r0 = r8.this$0
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r0.getClassProto()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r1 = r8.this$0
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r1 = r1.getC()
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r1 = r1.getTypeTable()
                java.util.List r0 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.supertypes(r0, r1)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r1 = r8.this$0
                java.util.ArrayList r2 = new java.util.ArrayList
                r3 = 10
                int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
                r2.<init>(r4)
                java.util.Collection r2 = (java.util.Collection) r2
                java.util.Iterator r0 = r0.iterator()
            L_0x0029:
                boolean r4 = r0.hasNext()
                if (r4 == 0) goto L_0x0045
                java.lang.Object r4 = r0.next()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r4
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r5 = r1.getC()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r5 = r5.getTypeDeserializer()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r5.type(r4)
                r2.add(r4)
                goto L_0x0029
            L_0x0045:
                java.util.List r2 = (java.util.List) r2
                java.util.Collection r2 = (java.util.Collection) r2
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r0 = r8.this$0
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r0.getC()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r0 = r0.getComponents()
                kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider r0 = r0.getAdditionalClassPartsProvider()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r1 = r8.this$0
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r1
                java.util.Collection r0 = r0.getSupertypes(r1)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.List r0 = kotlin.collections.CollectionsKt.plus(r2, r0)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.Collection r1 = (java.util.Collection) r1
                java.util.Iterator r2 = r0.iterator()
            L_0x0072:
                boolean r4 = r2.hasNext()
                r5 = 0
                if (r4 == 0) goto L_0x0094
                java.lang.Object r4 = r2.next()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r4.getConstructor()
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = r4.getDeclarationDescriptor()
                boolean r6 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor
                if (r6 == 0) goto L_0x008e
                r5 = r4
                kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$MockClassDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor) r5
            L_0x008e:
                if (r5 == 0) goto L_0x0072
                r1.add(r5)
                goto L_0x0072
            L_0x0094:
                java.util.List r1 = (java.util.List) r1
                r2 = r1
                java.util.Collection r2 = (java.util.Collection) r2
                boolean r2 = r2.isEmpty()
                r2 = r2 ^ 1
                if (r2 == 0) goto L_0x00f9
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r2 = r8.this$0
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r2.getC()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r2 = r2.getComponents()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter r2 = r2.getErrorReporter()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r4 = r8.this$0
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r6 = new java.util.ArrayList
                int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r3)
                r6.<init>(r3)
                java.util.Collection r6 = (java.util.Collection) r6
                java.util.Iterator r1 = r1.iterator()
            L_0x00c4:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x00f4
                java.lang.Object r3 = r1.next()
                kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$MockClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor) r3
                r7 = r3
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r7
                kotlin.reflect.jvm.internal.impl.name.ClassId r7 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(r7)
                if (r7 != 0) goto L_0x00db
            L_0x00d9:
                r7 = r5
                goto L_0x00e6
            L_0x00db:
                kotlin.reflect.jvm.internal.impl.name.FqName r7 = r7.asSingleFqName()
                if (r7 != 0) goto L_0x00e2
                goto L_0x00d9
            L_0x00e2:
                java.lang.String r7 = r7.asString()
            L_0x00e6:
                if (r7 != 0) goto L_0x00f0
                kotlin.reflect.jvm.internal.impl.name.Name r3 = r3.getName()
                java.lang.String r7 = r3.asString()
            L_0x00f0:
                r6.add(r7)
                goto L_0x00c4
            L_0x00f4:
                java.util.List r6 = (java.util.List) r6
                r2.reportIncompleteHierarchy(r4, r6)
            L_0x00f9:
                java.util.List r0 = kotlin.collections.CollectionsKt.toList(r0)
                java.util.Collection r0 = (java.util.Collection) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassTypeConstructor.computeSupertypes():java.util.Collection");
        }

        public List<TypeParameterDescriptor> getParameters() {
            return (List) this.parameters.invoke();
        }

        public DeserializedClassDescriptor getDeclarationDescriptor() {
            return this.this$0;
        }

        public String toString() {
            String name = this.this$0.getName().toString();
            Intrinsics.checkNotNullExpressionValue(name, "name.toString()");
            return name;
        }

        /* access modifiers changed from: protected */
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    private final class DeserializedClassMemberScope extends DeserializedMemberScope {
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
        /* access modifiers changed from: private */
        public final KotlinTypeRefiner kotlinTypeRefiner;
        private final NotNullLazyValue<Collection<KotlinType>> refinedSupertypes;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DeserializedClassMemberScope(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r8, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r9) {
            /*
                r7 = this;
                java.lang.String r0 = "this$0"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                java.lang.String r0 = "kotlinTypeRefiner"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                r7.this$0 = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r8.getC()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r3 = r0.getFunctionList()
                java.lang.String r0 = "classProto.functionList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r4 = r0.getPropertyList()
                java.lang.String r0 = "classProto.propertyList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r5 = r0.getTypeAliasList()
                java.lang.String r0 = "classProto.typeAliasList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r0 = r0.getNestedClassNameList()
                java.lang.String r1 = "classProto.nestedClassNameList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r8.getC()
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r8 = r8.getNameResolver()
                java.util.ArrayList r1 = new java.util.ArrayList
                r6 = 10
                int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r6)
                r1.<init>(r6)
                java.util.Collection r1 = (java.util.Collection) r1
                java.util.Iterator r0 = r0.iterator()
            L_0x005f:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L_0x0077
                java.lang.Object r6 = r0.next()
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                kotlin.reflect.jvm.internal.impl.name.Name r6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r8, r6)
                r1.add(r6)
                goto L_0x005f
            L_0x0077:
                java.util.List r1 = (java.util.List) r1
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$2$1 r8 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$2$1
                r8.<init>(r1)
                r6 = r8
                kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
                r1 = r7
                r1.<init>(r2, r3, r4, r5, r6)
                r7.kotlinTypeRefiner = r9
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r7.getC()
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = r8.getStorageManager()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1 r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1
                r9.<init>(r7)
                kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
                kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r8 = r8.createLazyValue(r9)
                r7.allDescriptors = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r7.getC()
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = r8.getStorageManager()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1 r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1
                r9.<init>(r7)
                kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
                kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r8 = r8.createLazyValue(r9)
                r7.refinedSupertypes = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner):void");
        }

        /* access modifiers changed from: private */
        public final DeserializedClassDescriptor getClassDescriptor() {
            return this.this$0;
        }

        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            return (Collection) this.allDescriptors.invoke();
        }

        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            recordLookup(name, lookupLocation);
            return super.getContributedFunctions(name, lookupLocation);
        }

        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            recordLookup(name, lookupLocation);
            return super.getContributedVariables(name, lookupLocation);
        }

        /* access modifiers changed from: protected */
        public boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor simpleFunctionDescriptor) {
            Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "function");
            return getC().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(this.this$0, simpleFunctionDescriptor);
        }

        /* access modifiers changed from: protected */
        public void computeNonDeclaredFunctions(Name name, List<SimpleFunctionDescriptor> list) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(list, "functions");
            ArrayList arrayList = new ArrayList();
            for (KotlinType memberScope : (Collection) this.refinedSupertypes.invoke()) {
                arrayList.addAll(memberScope.getMemberScope().getContributedFunctions(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            list.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctions(name, this.this$0));
            generateFakeOverrides(name, arrayList, list);
        }

        /* access modifiers changed from: protected */
        public void computeNonDeclaredProperties(Name name, List<PropertyDescriptor> list) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(list, "descriptors");
            ArrayList arrayList = new ArrayList();
            for (KotlinType memberScope : (Collection) this.refinedSupertypes.invoke()) {
                arrayList.addAll(memberScope.getMemberScope().getContributedVariables(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            generateFakeOverrides(name, arrayList, list);
        }

        private final <D extends CallableMemberDescriptor> void generateFakeOverrides(Name name, Collection<? extends D> collection, List<D> list) {
            Name name2 = name;
            Collection<? extends D> collection2 = collection;
            getC().getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(name2, collection2, new ArrayList(list), getClassDescriptor(), new C21728xf150c8cf(list));
        }

        /* access modifiers changed from: protected */
        public Set<Name> getNonDeclaredFunctionNames() {
            Collection linkedHashSet = new LinkedHashSet();
            for (KotlinType memberScope : getClassDescriptor().f61032j.getSupertypes()) {
                CollectionsKt.addAll(linkedHashSet, memberScope.getMemberScope().getFunctionNames());
            }
            ((LinkedHashSet) linkedHashSet).addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctionsNames(this.this$0));
            return (Set) linkedHashSet;
        }

        /* access modifiers changed from: protected */
        public Set<Name> getNonDeclaredVariableNames() {
            Collection linkedHashSet = new LinkedHashSet();
            for (KotlinType memberScope : getClassDescriptor().f61032j.getSupertypes()) {
                CollectionsKt.addAll(linkedHashSet, memberScope.getMemberScope().getVariableNames());
            }
            return (Set) linkedHashSet;
        }

        /* access modifiers changed from: protected */
        public Set<Name> getNonDeclaredClassifierNames() {
            Collection linkedHashSet = new LinkedHashSet();
            Iterator it = getClassDescriptor().f61032j.getSupertypes().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Iterable classifierNames = ((KotlinType) it.next()).getMemberScope().getClassifierNames();
                if (classifierNames == null) {
                    linkedHashSet = null;
                    break;
                }
                CollectionsKt.addAll(linkedHashSet, classifierNames);
            }
            return (Set) linkedHashSet;
        }

        public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
            ClassDescriptor findEnumEntry;
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            recordLookup(name, lookupLocation);
            EnumEntryClassDescriptors access$getEnumEntries$p = getClassDescriptor().f61034l;
            if (access$getEnumEntries$p == null || (findEnumEntry = access$getEnumEntries$p.findEnumEntry(name)) == null) {
                return super.getContributedClassifier(name, lookupLocation);
            }
            return findEnumEntry;
        }

        /* access modifiers changed from: protected */
        public ClassId createClassId(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            ClassId createNestedClassId = this.this$0.f61026d.createNestedClassId(name);
            Intrinsics.checkNotNullExpressionValue(createNestedClassId, "classId.createNestedClassId(name)");
            return createNestedClassId;
        }

        /* access modifiers changed from: protected */
        public void addEnumEntryDescriptors(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1) {
            Intrinsics.checkNotNullParameter(collection, "result");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            EnumEntryClassDescriptors access$getEnumEntries$p = getClassDescriptor().f61034l;
            Collection<ClassDescriptor> all = access$getEnumEntries$p == null ? null : access$getEnumEntries$p.all();
            if (all == null) {
                all = CollectionsKt.emptyList();
            }
            collection.addAll(all);
        }

        public void recordLookup(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            UtilsKt.record(getC().getComponents().getLookupTracker(), lookupLocation, (ClassDescriptor) getClassDescriptor(), name);
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    private final class EnumEntryClassDescriptors {
        private final MemoizedFunctionToNullable<Name, ClassDescriptor> enumEntryByName;
        /* access modifiers changed from: private */
        public final Map<Name, ProtoBuf.EnumEntry> enumEntryProtos;
        /* access modifiers changed from: private */
        public final NotNullLazyValue<Set<Name>> enumMemberNames;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        public EnumEntryClassDescriptors(DeserializedClassDescriptor deserializedClassDescriptor) {
            Intrinsics.checkNotNullParameter(deserializedClassDescriptor, "this$0");
            this.this$0 = deserializedClassDescriptor;
            List<ProtoBuf.EnumEntry> enumEntryList = this.this$0.getClassProto().getEnumEntryList();
            Intrinsics.checkNotNullExpressionValue(enumEntryList, "classProto.enumEntryList");
            Iterable iterable = enumEntryList;
            DeserializedClassDescriptor deserializedClassDescriptor2 = this.this$0;
            Map<Name, ProtoBuf.EnumEntry> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
            for (Object next : iterable) {
                linkedHashMap.put(NameResolverUtilKt.getName(deserializedClassDescriptor2.getC().getNameResolver(), ((ProtoBuf.EnumEntry) next).getName()), next);
            }
            this.enumEntryProtos = linkedHashMap;
            this.enumEntryByName = this.this$0.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new C21731xaf8327b7(this, this.this$0));
            this.enumMemberNames = this.this$0.getC().getStorageManager().createLazyValue(new C21733xaaca1f71(this));
        }

        public final ClassDescriptor findEnumEntry(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.enumEntryByName.invoke(name);
        }

        /* access modifiers changed from: private */
        public final Set<Name> computeEnumMemberNames() {
            HashSet hashSet = new HashSet();
            for (KotlinType memberScope : this.this$0.getTypeConstructor().getSupertypes()) {
                for (DeclarationDescriptor declarationDescriptor : ResolutionScope.DefaultImpls.getContributedDescriptors$default(memberScope.getMemberScope(), (DescriptorKindFilter) null, (Function1) null, 3, (Object) null)) {
                    if ((declarationDescriptor instanceof SimpleFunctionDescriptor) || (declarationDescriptor instanceof PropertyDescriptor)) {
                        hashSet.add(declarationDescriptor.getName());
                    }
                }
            }
            List<ProtoBuf.Function> functionList = this.this$0.getClassProto().getFunctionList();
            Intrinsics.checkNotNullExpressionValue(functionList, "classProto.functionList");
            DeserializedClassDescriptor deserializedClassDescriptor = this.this$0;
            for (ProtoBuf.Function name : functionList) {
                hashSet.add(NameResolverUtilKt.getName(deserializedClassDescriptor.getC().getNameResolver(), name.getName()));
            }
            Collection collection = hashSet;
            Set set = (Set) collection;
            List<ProtoBuf.Property> propertyList = this.this$0.getClassProto().getPropertyList();
            Intrinsics.checkNotNullExpressionValue(propertyList, "classProto.propertyList");
            DeserializedClassDescriptor deserializedClassDescriptor2 = this.this$0;
            for (ProtoBuf.Property name2 : propertyList) {
                collection.add(NameResolverUtilKt.getName(deserializedClassDescriptor2.getC().getNameResolver(), name2.getName()));
            }
            return SetsKt.plus(set, collection);
        }

        public final Collection<ClassDescriptor> all() {
            Collection arrayList = new ArrayList();
            for (Name findEnumEntry : this.enumEntryProtos.keySet()) {
                ClassDescriptor findEnumEntry2 = findEnumEntry(findEnumEntry);
                if (findEnumEntry2 != null) {
                    arrayList.add(findEnumEntry2);
                }
            }
            return (List) arrayList;
        }
    }
}
