package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public class TypeParameterDescriptorImpl extends AbstractTypeParameterDescriptor {

    /* renamed from: a */
    private final Function1<KotlinType, Void> f60309a;

    /* renamed from: b */
    private final List<KotlinType> f60310b;

    /* renamed from: c */
    private boolean f60311c;

    /* renamed from: a */
    private static /* synthetic */ void m44549a(int i) {
        String str = (i == 5 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 5 || i == 28) ? 2 : 3)];
        switch (i) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 5 || i == 28) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public static TypeParameterDescriptor createWithDefaultBound(DeclarationDescriptor declarationDescriptor, Annotations annotations, boolean z, Variance variance, Name name, int i, StorageManager storageManager) {
        if (declarationDescriptor == null) {
            m44549a(0);
        }
        if (annotations == null) {
            m44549a(1);
        }
        if (variance == null) {
            m44549a(2);
        }
        if (name == null) {
            m44549a(3);
        }
        if (storageManager == null) {
            m44549a(4);
        }
        TypeParameterDescriptorImpl createForFurtherModification = createForFurtherModification(declarationDescriptor, annotations, z, variance, name, i, SourceElement.NO_SOURCE, storageManager);
        createForFurtherModification.addUpperBound(DescriptorUtilsKt.getBuiltIns(declarationDescriptor).getDefaultBound());
        createForFurtherModification.setInitialized();
        if (createForFurtherModification == null) {
            m44549a(5);
        }
        return createForFurtherModification;
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(DeclarationDescriptor declarationDescriptor, Annotations annotations, boolean z, Variance variance, Name name, int i, SourceElement sourceElement, StorageManager storageManager) {
        if (declarationDescriptor == null) {
            m44549a(6);
        }
        if (annotations == null) {
            m44549a(7);
        }
        if (variance == null) {
            m44549a(8);
        }
        if (name == null) {
            m44549a(9);
        }
        if (sourceElement == null) {
            m44549a(10);
        }
        if (storageManager == null) {
            m44549a(11);
        }
        return createForFurtherModification(declarationDescriptor, annotations, z, variance, name, i, sourceElement, (Function1<KotlinType, Void>) null, SupertypeLoopChecker.EMPTY.INSTANCE, storageManager);
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(DeclarationDescriptor declarationDescriptor, Annotations annotations, boolean z, Variance variance, Name name, int i, SourceElement sourceElement, Function1<KotlinType, Void> function1, SupertypeLoopChecker supertypeLoopChecker, StorageManager storageManager) {
        if (declarationDescriptor == null) {
            m44549a(12);
        }
        if (annotations == null) {
            m44549a(13);
        }
        if (variance == null) {
            m44549a(14);
        }
        if (name == null) {
            m44549a(15);
        }
        if (sourceElement == null) {
            m44549a(16);
        }
        if (supertypeLoopChecker == null) {
            m44549a(17);
        }
        if (storageManager == null) {
            m44549a(18);
        }
        return new TypeParameterDescriptorImpl(declarationDescriptor, annotations, z, variance, name, i, sourceElement, function1, supertypeLoopChecker, storageManager);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private TypeParameterDescriptorImpl(DeclarationDescriptor declarationDescriptor, Annotations annotations, boolean z, Variance variance, Name name, int i, SourceElement sourceElement, Function1<KotlinType, Void> function1, SupertypeLoopChecker supertypeLoopChecker, StorageManager storageManager) {
        super(storageManager, declarationDescriptor, annotations, name, variance, z, i, sourceElement, supertypeLoopChecker);
        if (declarationDescriptor == null) {
            m44549a(19);
        }
        if (annotations == null) {
            m44549a(20);
        }
        if (variance == null) {
            m44549a(21);
        }
        if (name == null) {
            m44549a(22);
        }
        if (sourceElement == null) {
            m44549a(23);
        }
        if (supertypeLoopChecker == null) {
            m44549a(24);
        }
        if (storageManager == null) {
            m44549a(25);
        }
        this.f60310b = new ArrayList(1);
        this.f60311c = false;
        this.f60309a = function1;
    }

    /* renamed from: a */
    private void m44548a() {
        if (!this.f60311c) {
            throw new IllegalStateException("Type parameter descriptor is not initialized: " + m44552c());
        }
    }

    /* renamed from: b */
    private void m44551b() {
        if (this.f60311c) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + m44552c());
        }
    }

    /* renamed from: c */
    private String m44552c() {
        return getName() + " declared in " + DescriptorUtils.getFqName(getContainingDeclaration());
    }

    public void setInitialized() {
        m44551b();
        this.f60311c = true;
    }

    public void addUpperBound(KotlinType kotlinType) {
        if (kotlinType == null) {
            m44549a(26);
        }
        m44551b();
        m44550a(kotlinType);
    }

    /* renamed from: a */
    private void m44550a(KotlinType kotlinType) {
        if (!KotlinTypeKt.isError(kotlinType)) {
            this.f60310b.add(kotlinType);
        }
    }

    /* access modifiers changed from: protected */
    public void reportSupertypeLoopError(KotlinType kotlinType) {
        if (kotlinType == null) {
            m44549a(27);
        }
        Function1<KotlinType, Void> function1 = this.f60309a;
        if (function1 != null) {
            function1.invoke(kotlinType);
        }
    }

    /* access modifiers changed from: protected */
    public List<KotlinType> resolveUpperBounds() {
        m44548a();
        List<KotlinType> list = this.f60310b;
        if (list == null) {
            m44549a(28);
        }
        return list;
    }
}
