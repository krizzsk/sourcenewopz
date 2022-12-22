package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

public class ClassTypeConstructorImpl extends AbstractClassTypeConstructor implements TypeConstructor {

    /* renamed from: a */
    private final ClassDescriptor f61088a;

    /* renamed from: b */
    private final List<TypeParameterDescriptor> f61089b;

    /* renamed from: c */
    private final Collection<KotlinType> f61090c;

    /* renamed from: a */
    private static /* synthetic */ void m45024a(int i) {
        String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i == 4) {
            objArr[1] = "getParameters";
        } else if (i == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (!(i == 4 || i == 5 || i == 6 || i == 7)) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        throw ((i == 4 || i == 5 || i == 6 || i == 7) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public boolean isDenotable() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClassTypeConstructorImpl(ClassDescriptor classDescriptor, List<? extends TypeParameterDescriptor> list, Collection<KotlinType> collection, StorageManager storageManager) {
        super(storageManager);
        if (classDescriptor == null) {
            m45024a(0);
        }
        if (list == null) {
            m45024a(1);
        }
        if (collection == null) {
            m45024a(2);
        }
        if (storageManager == null) {
            m45024a(3);
        }
        this.f61088a = classDescriptor;
        this.f61089b = Collections.unmodifiableList(new ArrayList(list));
        this.f61090c = Collections.unmodifiableCollection(collection);
    }

    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> list = this.f61089b;
        if (list == null) {
            m45024a(4);
        }
        return list;
    }

    public String toString() {
        return DescriptorUtils.getFqName(this.f61088a).asString();
    }

    public ClassDescriptor getDeclarationDescriptor() {
        ClassDescriptor classDescriptor = this.f61088a;
        if (classDescriptor == null) {
            m45024a(5);
        }
        return classDescriptor;
    }

    /* access modifiers changed from: protected */
    public Collection<KotlinType> computeSupertypes() {
        Collection<KotlinType> collection = this.f61090c;
        if (collection == null) {
            m45024a(6);
        }
        return collection;
    }

    /* access modifiers changed from: protected */
    public SupertypeLoopChecker getSupertypeLoopChecker() {
        SupertypeLoopChecker.EMPTY empty = SupertypeLoopChecker.EMPTY.INSTANCE;
        if (empty == null) {
            m45024a(7);
        }
        return empty;
    }
}
