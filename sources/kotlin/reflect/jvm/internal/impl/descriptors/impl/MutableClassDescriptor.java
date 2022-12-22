package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

public class MutableClassDescriptor extends ClassDescriptorBase {

    /* renamed from: a */
    static final /* synthetic */ boolean f60257a = (!MutableClassDescriptor.class.desiredAssertionStatus());

    /* renamed from: b */
    private final ClassKind f60258b;

    /* renamed from: c */
    private final boolean f60259c;

    /* renamed from: d */
    private Modality f60260d;

    /* renamed from: e */
    private DescriptorVisibility f60261e;

    /* renamed from: f */
    private TypeConstructor f60262f;

    /* renamed from: g */
    private List<TypeParameterDescriptor> f60263g;

    /* renamed from: h */
    private final Collection<KotlinType> f60264h;

    /* renamed from: i */
    private final StorageManager f60265i;

    /* renamed from: a */
    private static /* synthetic */ void m44537a(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutableClassDescriptor(DeclarationDescriptor declarationDescriptor, ClassKind classKind, boolean z, boolean z2, Name name, SourceElement sourceElement, StorageManager storageManager) {
        super(storageManager, declarationDescriptor, name, sourceElement, z2);
        if (declarationDescriptor == null) {
            m44537a(0);
        }
        if (classKind == null) {
            m44537a(1);
        }
        if (name == null) {
            m44537a(2);
        }
        if (sourceElement == null) {
            m44537a(3);
        }
        if (storageManager == null) {
            m44537a(4);
        }
        this.f60264h = new ArrayList();
        this.f60265i = storageManager;
        if (f60257a || classKind != ClassKind.OBJECT) {
            this.f60258b = classKind;
            this.f60259c = z;
            return;
        }
        throw new AssertionError("Fix isCompanionObject()");
    }

    public Annotations getAnnotations() {
        Annotations empty = Annotations.Companion.getEMPTY();
        if (empty == null) {
            m44537a(5);
        }
        return empty;
    }

    public void setModality(Modality modality) {
        if (modality == null) {
            m44537a(6);
        }
        if (f60257a || modality != Modality.SEALED) {
            this.f60260d = modality;
            return;
        }
        throw new AssertionError("Implement getSealedSubclasses() for this class: " + getClass());
    }

    public Modality getModality() {
        Modality modality = this.f60260d;
        if (modality == null) {
            m44537a(7);
        }
        return modality;
    }

    public ClassKind getKind() {
        ClassKind classKind = this.f60258b;
        if (classKind == null) {
            m44537a(8);
        }
        return classKind;
    }

    public void setVisibility(DescriptorVisibility descriptorVisibility) {
        if (descriptorVisibility == null) {
            m44537a(9);
        }
        this.f60261e = descriptorVisibility;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.f60261e;
        if (descriptorVisibility == null) {
            m44537a(10);
        }
        return descriptorVisibility;
    }

    public boolean isInner() {
        return this.f60259c;
    }

    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = this.f60262f;
        if (typeConstructor == null) {
            m44537a(11);
        }
        return typeConstructor;
    }

    public Set<ClassConstructorDescriptor> getConstructors() {
        Set<ClassConstructorDescriptor> emptySet = Collections.emptySet();
        if (emptySet == null) {
            m44537a(13);
        }
        return emptySet;
    }

    public void setTypeParameterDescriptors(List<TypeParameterDescriptor> list) {
        if (list == null) {
            m44537a(14);
        }
        if (this.f60263g == null) {
            this.f60263g = new ArrayList(list);
            return;
        }
        throw new IllegalStateException("Type parameters are already set for " + getName());
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> list = this.f60263g;
        if (list == null) {
            m44537a(15);
        }
        return list;
    }

    public void createTypeConstructor() {
        if (f60257a || this.f60262f == null) {
            this.f60262f = new ClassTypeConstructorImpl(this, this.f60263g, this.f60264h, this.f60265i);
            for (ClassConstructorDescriptor classConstructorDescriptor : getConstructors()) {
                ((ClassConstructorDescriptorImpl) classConstructorDescriptor).setReturnType(getDefaultType());
            }
            return;
        }
        throw new AssertionError(this.f60262f);
    }

    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            m44537a(16);
        }
        MemberScope.Empty empty = MemberScope.Empty.INSTANCE;
        if (empty == null) {
            m44537a(17);
        }
        return empty;
    }

    public MemberScope getStaticScope() {
        MemberScope.Empty empty = MemberScope.Empty.INSTANCE;
        if (empty == null) {
            m44537a(18);
        }
        return empty;
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            m44537a(19);
        }
        return emptyList;
    }

    public String toString() {
        return DeclarationDescriptorImpl.toString(this);
    }
}
