package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u0006\u0012\u0002\b\u00030#*\u00020$H\u0002J\u0010\u0010%\u001a\u0006\u0012\u0002\b\u00030&*\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, mo175978d2 = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "container", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "", "hashCode", "", "toString", "getContainerClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;", "toKClassImpl", "Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: KTypeParameterImpl.kt */
public final class KTypeParameterImpl implements KTypeParameter, KClassifierImpl {

    /* renamed from: a */
    static final /* synthetic */ KProperty[] f60063a = {C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};

    /* renamed from: b */
    private final ReflectProperties.LazySoftVal f60064b = ReflectProperties.lazySoft(new KTypeParameterImpl$upperBounds$2(this));

    /* renamed from: c */
    private final KTypeParameterOwnerImpl f60065c;

    /* renamed from: d */
    private final TypeParameterDescriptor f60066d;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Variance.INVARIANT.ordinal()] = 1;
            $EnumSwitchMapping$0[Variance.IN_VARIANCE.ordinal()] = 2;
            $EnumSwitchMapping$0[Variance.OUT_VARIANCE.ordinal()] = 3;
        }
    }

    public List<KType> getUpperBounds() {
        return (List) this.f60064b.getValue(this, f60063a[0]);
    }

    public KTypeParameterImpl(KTypeParameterOwnerImpl kTypeParameterOwnerImpl, TypeParameterDescriptor typeParameterDescriptor) {
        Object obj;
        KClassImpl<?> kClassImpl;
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "descriptor");
        this.f60066d = typeParameterDescriptor;
        if (kTypeParameterOwnerImpl == null) {
            KTypeParameterImpl kTypeParameterImpl = this;
            DeclarationDescriptor containingDeclaration = kTypeParameterImpl.getDescriptor().getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof ClassDescriptor) {
                obj = kTypeParameterImpl.m44451a((ClassDescriptor) containingDeclaration);
            } else if (containingDeclaration instanceof CallableMemberDescriptor) {
                DeclarationDescriptor containingDeclaration2 = ((CallableMemberDescriptor) containingDeclaration).getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "declaration.containingDeclaration");
                if (containingDeclaration2 instanceof ClassDescriptor) {
                    kClassImpl = kTypeParameterImpl.m44451a((ClassDescriptor) containingDeclaration2);
                } else {
                    DeserializedMemberDescriptor deserializedMemberDescriptor = (DeserializedMemberDescriptor) (!(containingDeclaration instanceof DeserializedMemberDescriptor) ? null : containingDeclaration);
                    if (deserializedMemberDescriptor != null) {
                        KClass<?> kotlinClass = JvmClassMappingKt.getKotlinClass(kTypeParameterImpl.m44450a(deserializedMemberDescriptor));
                        if (kotlinClass != null) {
                            kClassImpl = (KClassImpl) kotlinClass;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                        }
                    } else {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + containingDeclaration);
                    }
                }
                obj = containingDeclaration.accept(new CreateKCallableVisitor(kClassImpl), Unit.INSTANCE);
            } else {
                throw new KotlinReflectionInternalError("Unknown type parameter container: " + containingDeclaration);
            }
            Intrinsics.checkNotNullExpressionValue(obj, "when (val declaration = … $declaration\")\n        }");
            kTypeParameterOwnerImpl = (KTypeParameterOwnerImpl) obj;
        }
        this.f60065c = kTypeParameterOwnerImpl;
    }

    public TypeParameterDescriptor getDescriptor() {
        return this.f60066d;
    }

    public String getName() {
        String asString = getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "descriptor.name.asString()");
        return asString;
    }

    public KVariance getVariance() {
        int i = WhenMappings.$EnumSwitchMapping$0[getDescriptor().getVariance().ordinal()];
        if (i == 1) {
            return KVariance.INVARIANT;
        }
        if (i == 2) {
            return KVariance.IN;
        }
        if (i == 3) {
            return KVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public boolean isReified() {
        return getDescriptor().isReified();
    }

    /* renamed from: a */
    private final KClassImpl<?> m44451a(ClassDescriptor classDescriptor) {
        Class<?> javaClass = UtilKt.toJavaClass(classDescriptor);
        KClassImpl<?> kClassImpl = (KClassImpl) (javaClass != null ? JvmClassMappingKt.getKotlinClass(javaClass) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + classDescriptor.getContainingDeclaration());
    }

    /* renamed from: a */
    private final Class<?> m44450a(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        Class<?> klass;
        DeserializedContainerSource containerSource = deserializedMemberDescriptor.getContainerSource();
        KotlinJvmBinaryClass kotlinJvmBinaryClass = null;
        if (!(containerSource instanceof JvmPackagePartSource)) {
            containerSource = null;
        }
        JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) containerSource;
        KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource != null ? jvmPackagePartSource.getKnownJvmBinaryClass() : null;
        if (knownJvmBinaryClass instanceof ReflectKotlinClass) {
            kotlinJvmBinaryClass = knownJvmBinaryClass;
        }
        ReflectKotlinClass reflectKotlinClass = (ReflectKotlinClass) kotlinJvmBinaryClass;
        if (reflectKotlinClass != null && (klass = reflectKotlinClass.getKlass()) != null) {
            return klass;
        }
        throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + deserializedMemberDescriptor);
    }

    public boolean equals(Object obj) {
        if (obj instanceof KTypeParameterImpl) {
            KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) obj;
            return Intrinsics.areEqual((Object) this.f60065c, (Object) kTypeParameterImpl.f60065c) && Intrinsics.areEqual((Object) getName(), (Object) kTypeParameterImpl.getName());
        }
    }

    public int hashCode() {
        return (this.f60065c.hashCode() * 31) + getName().hashCode();
    }

    public String toString() {
        return TypeParameterReference.Companion.toString(this);
    }
}
