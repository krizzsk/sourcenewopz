package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public class LazySubstitutingClassDescriptor extends ModuleAwareClassDescriptor {

    /* renamed from: a */
    static final /* synthetic */ boolean f60235a = (!LazySubstitutingClassDescriptor.class.desiredAssertionStatus());

    /* renamed from: b */
    private final ModuleAwareClassDescriptor f60236b;

    /* renamed from: c */
    private final TypeSubstitutor f60237c;

    /* renamed from: d */
    private TypeSubstitutor f60238d;

    /* renamed from: e */
    private List<TypeParameterDescriptor> f60239e;

    /* renamed from: f */
    private List<TypeParameterDescriptor> f60240f;

    /* renamed from: g */
    private TypeConstructor f60241g;

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00de A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ void m44533a(int r15) {
        /*
            r0 = 22
            r1 = 13
            r2 = 10
            r3 = 8
            r4 = 6
            r5 = 5
            r6 = 3
            r7 = 2
            if (r15 == r7) goto L_0x001f
            if (r15 == r6) goto L_0x001f
            if (r15 == r5) goto L_0x001f
            if (r15 == r4) goto L_0x001f
            if (r15 == r3) goto L_0x001f
            if (r15 == r2) goto L_0x001f
            if (r15 == r1) goto L_0x001f
            if (r15 == r0) goto L_0x001f
            java.lang.String r8 = "@NotNull method %s.%s must not return null"
            goto L_0x0021
        L_0x001f:
            java.lang.String r8 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
        L_0x0021:
            if (r15 == r7) goto L_0x0033
            if (r15 == r6) goto L_0x0033
            if (r15 == r5) goto L_0x0033
            if (r15 == r4) goto L_0x0033
            if (r15 == r3) goto L_0x0033
            if (r15 == r2) goto L_0x0033
            if (r15 == r1) goto L_0x0033
            if (r15 == r0) goto L_0x0033
            r9 = 2
            goto L_0x0034
        L_0x0033:
            r9 = 3
        L_0x0034:
            java.lang.Object[] r9 = new java.lang.Object[r9]
            java.lang.String r10 = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor"
            r11 = 0
            if (r15 == r7) goto L_0x005b
            if (r15 == r6) goto L_0x0056
            if (r15 == r5) goto L_0x0051
            if (r15 == r4) goto L_0x0056
            if (r15 == r3) goto L_0x005b
            if (r15 == r2) goto L_0x0051
            if (r15 == r1) goto L_0x0056
            if (r15 == r0) goto L_0x004c
            r9[r11] = r10
            goto L_0x005f
        L_0x004c:
            java.lang.String r12 = "substitutor"
            r9[r11] = r12
            goto L_0x005f
        L_0x0051:
            java.lang.String r12 = "typeSubstitution"
            r9[r11] = r12
            goto L_0x005f
        L_0x0056:
            java.lang.String r12 = "kotlinTypeRefiner"
            r9[r11] = r12
            goto L_0x005f
        L_0x005b:
            java.lang.String r12 = "typeArguments"
            r9[r11] = r12
        L_0x005f:
            java.lang.String r11 = "substitute"
            java.lang.String r12 = "getUnsubstitutedMemberScope"
            java.lang.String r13 = "getMemberScope"
            r14 = 1
            switch(r15) {
                case 2: goto L_0x00bd;
                case 3: goto L_0x00bd;
                case 4: goto L_0x00ba;
                case 5: goto L_0x00bd;
                case 6: goto L_0x00bd;
                case 7: goto L_0x00ba;
                case 8: goto L_0x00bd;
                case 9: goto L_0x00ba;
                case 10: goto L_0x00bd;
                case 11: goto L_0x00ba;
                case 12: goto L_0x00b7;
                case 13: goto L_0x00bd;
                case 14: goto L_0x00b7;
                case 15: goto L_0x00b2;
                case 16: goto L_0x00ad;
                case 17: goto L_0x00a8;
                case 18: goto L_0x00a3;
                case 19: goto L_0x009e;
                case 20: goto L_0x0099;
                case 21: goto L_0x0094;
                case 22: goto L_0x00bd;
                case 23: goto L_0x0091;
                case 24: goto L_0x008c;
                case 25: goto L_0x0087;
                case 26: goto L_0x0082;
                case 27: goto L_0x007d;
                case 28: goto L_0x0078;
                case 29: goto L_0x0073;
                case 30: goto L_0x006e;
                default: goto L_0x0069;
            }
        L_0x0069:
            java.lang.String r10 = "getTypeConstructor"
            r9[r14] = r10
            goto L_0x00bf
        L_0x006e:
            java.lang.String r10 = "getSealedSubclasses"
            r9[r14] = r10
            goto L_0x00bf
        L_0x0073:
            java.lang.String r10 = "getDeclaredTypeParameters"
            r9[r14] = r10
            goto L_0x00bf
        L_0x0078:
            java.lang.String r10 = "getSource"
            r9[r14] = r10
            goto L_0x00bf
        L_0x007d:
            java.lang.String r10 = "getUnsubstitutedInnerClassesScope"
            r9[r14] = r10
            goto L_0x00bf
        L_0x0082:
            java.lang.String r10 = "getVisibility"
            r9[r14] = r10
            goto L_0x00bf
        L_0x0087:
            java.lang.String r10 = "getModality"
            r9[r14] = r10
            goto L_0x00bf
        L_0x008c:
            java.lang.String r10 = "getKind"
            r9[r14] = r10
            goto L_0x00bf
        L_0x0091:
            r9[r14] = r11
            goto L_0x00bf
        L_0x0094:
            java.lang.String r10 = "getContainingDeclaration"
            r9[r14] = r10
            goto L_0x00bf
        L_0x0099:
            java.lang.String r10 = "getOriginal"
            r9[r14] = r10
            goto L_0x00bf
        L_0x009e:
            java.lang.String r10 = "getName"
            r9[r14] = r10
            goto L_0x00bf
        L_0x00a3:
            java.lang.String r10 = "getAnnotations"
            r9[r14] = r10
            goto L_0x00bf
        L_0x00a8:
            java.lang.String r10 = "getConstructors"
            r9[r14] = r10
            goto L_0x00bf
        L_0x00ad:
            java.lang.String r10 = "getDefaultType"
            r9[r14] = r10
            goto L_0x00bf
        L_0x00b2:
            java.lang.String r10 = "getStaticScope"
            r9[r14] = r10
            goto L_0x00bf
        L_0x00b7:
            r9[r14] = r12
            goto L_0x00bf
        L_0x00ba:
            r9[r14] = r13
            goto L_0x00bf
        L_0x00bd:
            r9[r14] = r10
        L_0x00bf:
            if (r15 == r7) goto L_0x00d6
            if (r15 == r6) goto L_0x00d6
            if (r15 == r5) goto L_0x00d6
            if (r15 == r4) goto L_0x00d6
            if (r15 == r3) goto L_0x00d6
            if (r15 == r2) goto L_0x00d6
            if (r15 == r1) goto L_0x00d3
            if (r15 == r0) goto L_0x00d0
            goto L_0x00d8
        L_0x00d0:
            r9[r7] = r11
            goto L_0x00d8
        L_0x00d3:
            r9[r7] = r12
            goto L_0x00d8
        L_0x00d6:
            r9[r7] = r13
        L_0x00d8:
            java.lang.String r8 = java.lang.String.format(r8, r9)
            if (r15 == r7) goto L_0x00f2
            if (r15 == r6) goto L_0x00f2
            if (r15 == r5) goto L_0x00f2
            if (r15 == r4) goto L_0x00f2
            if (r15 == r3) goto L_0x00f2
            if (r15 == r2) goto L_0x00f2
            if (r15 == r1) goto L_0x00f2
            if (r15 == r0) goto L_0x00f2
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            r15.<init>(r8)
            goto L_0x00f7
        L_0x00f2:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            r15.<init>(r8)
        L_0x00f7:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazySubstitutingClassDescriptor.m44533a(int):void");
    }

    public LazySubstitutingClassDescriptor(ModuleAwareClassDescriptor moduleAwareClassDescriptor, TypeSubstitutor typeSubstitutor) {
        this.f60236b = moduleAwareClassDescriptor;
        this.f60237c = typeSubstitutor;
    }

    /* renamed from: a */
    private TypeSubstitutor m44532a() {
        if (this.f60238d == null) {
            if (this.f60237c.isEmpty()) {
                this.f60238d = this.f60237c;
            } else {
                List<TypeParameterDescriptor> parameters = this.f60236b.getTypeConstructor().getParameters();
                this.f60239e = new ArrayList(parameters.size());
                this.f60238d = DescriptorSubstitutor.substituteTypeParameters(parameters, this.f60237c.getSubstitution(), this, this.f60239e);
                this.f60240f = CollectionsKt.filter(this.f60239e, new Function1<TypeParameterDescriptor, Boolean>() {
                    public Boolean invoke(TypeParameterDescriptor typeParameterDescriptor) {
                        return Boolean.valueOf(!typeParameterDescriptor.isCapturedFromOuterDeclaration());
                    }
                });
            }
        }
        return this.f60238d;
    }

    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = this.f60236b.getTypeConstructor();
        if (this.f60237c.isEmpty()) {
            if (typeConstructor == null) {
                m44533a(0);
            }
            return typeConstructor;
        }
        if (this.f60241g == null) {
            TypeSubstitutor a = m44532a();
            Collection<KotlinType> supertypes = typeConstructor.getSupertypes();
            ArrayList arrayList = new ArrayList(supertypes.size());
            for (KotlinType substitute : supertypes) {
                arrayList.add(a.substitute(substitute, Variance.INVARIANT));
            }
            this.f60241g = new ClassTypeConstructorImpl(this, this.f60239e, arrayList, LockBasedStorageManager.NO_LOCKS);
        }
        TypeConstructor typeConstructor2 = this.f60241g;
        if (typeConstructor2 == null) {
            m44533a(1);
        }
        return typeConstructor2;
    }

    public MemberScope getMemberScope(TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeSubstitution == null) {
            m44533a(5);
        }
        if (kotlinTypeRefiner == null) {
            m44533a(6);
        }
        MemberScope memberScope = this.f60236b.getMemberScope(typeSubstitution, kotlinTypeRefiner);
        if (!this.f60237c.isEmpty()) {
            return new SubstitutingScope(memberScope, m44532a());
        }
        if (memberScope == null) {
            m44533a(7);
        }
        return memberScope;
    }

    public MemberScope getMemberScope(TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            m44533a(10);
        }
        MemberScope memberScope = getMemberScope(typeSubstitution, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (memberScope == null) {
            m44533a(11);
        }
        return memberScope;
    }

    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope unsubstitutedMemberScope = getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this.f60236b)));
        if (unsubstitutedMemberScope == null) {
            m44533a(12);
        }
        return unsubstitutedMemberScope;
    }

    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            m44533a(13);
        }
        MemberScope unsubstitutedMemberScope = this.f60236b.getUnsubstitutedMemberScope(kotlinTypeRefiner);
        if (!this.f60237c.isEmpty()) {
            return new SubstitutingScope(unsubstitutedMemberScope, m44532a());
        }
        if (unsubstitutedMemberScope == null) {
            m44533a(14);
        }
        return unsubstitutedMemberScope;
    }

    public MemberScope getStaticScope() {
        MemberScope staticScope = this.f60236b.getStaticScope();
        if (staticScope == null) {
            m44533a(15);
        }
        return staticScope;
    }

    public SimpleType getDefaultType() {
        SimpleType simpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(getAnnotations(), getTypeConstructor(), TypeUtils.getDefaultTypeProjections(getTypeConstructor().getParameters()), false, getUnsubstitutedMemberScope());
        if (simpleTypeWithNonTrivialMemberScope == null) {
            m44533a(16);
        }
        return simpleTypeWithNonTrivialMemberScope;
    }

    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    public Collection<ClassConstructorDescriptor> getConstructors() {
        Collection<ClassConstructorDescriptor> constructors = this.f60236b.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (ClassConstructorDescriptor next : constructors) {
            arrayList.add(((ClassConstructorDescriptor) next.newCopyBuilder().setOriginal(next.getOriginal()).setModality(next.getModality()).setVisibility(next.getVisibility()).setKind(next.getKind()).setCopyOverrides(false).build()).substitute(m44532a()));
        }
        return arrayList;
    }

    public Annotations getAnnotations() {
        Annotations annotations = this.f60236b.getAnnotations();
        if (annotations == null) {
            m44533a(18);
        }
        return annotations;
    }

    public Name getName() {
        Name name = this.f60236b.getName();
        if (name == null) {
            m44533a(19);
        }
        return name;
    }

    public ClassDescriptor getOriginal() {
        ClassDescriptor original = this.f60236b.getOriginal();
        if (original == null) {
            m44533a(20);
        }
        return original;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor containingDeclaration = this.f60236b.getContainingDeclaration();
        if (containingDeclaration == null) {
            m44533a(21);
        }
        return containingDeclaration;
    }

    public ClassDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            m44533a(22);
        }
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        return new LazySubstitutingClassDescriptor(this, TypeSubstitutor.createChainedSubstitutor(typeSubstitutor.getSubstitution(), m44532a().getSubstitution()));
    }

    public ClassDescriptor getCompanionObjectDescriptor() {
        return this.f60236b.getCompanionObjectDescriptor();
    }

    public ClassKind getKind() {
        ClassKind kind = this.f60236b.getKind();
        if (kind == null) {
            m44533a(24);
        }
        return kind;
    }

    public Modality getModality() {
        Modality modality = this.f60236b.getModality();
        if (modality == null) {
            m44533a(25);
        }
        return modality;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility visibility = this.f60236b.getVisibility();
        if (visibility == null) {
            m44533a(26);
        }
        return visibility;
    }

    public boolean isInner() {
        return this.f60236b.isInner();
    }

    public boolean isData() {
        return this.f60236b.isData();
    }

    public boolean isInline() {
        return this.f60236b.isInline();
    }

    public boolean isFun() {
        return this.f60236b.isFun();
    }

    public boolean isValue() {
        return this.f60236b.isValue();
    }

    public boolean isExternal() {
        return this.f60236b.isExternal();
    }

    public boolean isCompanionObject() {
        return this.f60236b.isCompanionObject();
    }

    public boolean isExpect() {
        return this.f60236b.isExpect();
    }

    public boolean isActual() {
        return this.f60236b.isActual();
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, d);
    }

    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope unsubstitutedInnerClassesScope = this.f60236b.getUnsubstitutedInnerClassesScope();
        if (unsubstitutedInnerClassesScope == null) {
            m44533a(27);
        }
        return unsubstitutedInnerClassesScope;
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.f60236b.getUnsubstitutedPrimaryConstructor();
    }

    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        if (sourceElement == null) {
            m44533a(28);
        }
        return sourceElement;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        m44532a();
        List<TypeParameterDescriptor> list = this.f60240f;
        if (list == null) {
            m44533a(29);
        }
        return list;
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        Collection<ClassDescriptor> sealedSubclasses = this.f60236b.getSealedSubclasses();
        if (sealedSubclasses == null) {
            m44533a(30);
        }
        return sealedSubclasses;
    }

    public InlineClassRepresentation<SimpleType> getInlineClassRepresentation() {
        InlineClassRepresentation<SimpleType> inlineClassRepresentation = this.f60236b.getInlineClassRepresentation();
        if (inlineClassRepresentation == null) {
            return null;
        }
        return new InlineClassRepresentation<>(inlineClassRepresentation.getUnderlyingPropertyName(), m44531a(getInlineClassRepresentation().getUnderlyingType()));
    }

    /* renamed from: a */
    private SimpleType m44531a(SimpleType simpleType) {
        if (simpleType == null || this.f60237c.isEmpty()) {
            return simpleType;
        }
        KotlinType substitute = m44532a().substitute(simpleType, Variance.INVARIANT);
        if (f60235a || (substitute instanceof SimpleType)) {
            return (SimpleType) substitute;
        }
        throw new AssertionError("Substitution for SimpleType should also be a SimpleType, but it is " + substitute + "\n" + "Unsubstituted: " + simpleType);
    }
}
