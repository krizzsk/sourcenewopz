package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.MutableClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: suspendFunctionTypes.kt */
public final class SuspendFunctionTypesKt {

    /* renamed from: a */
    private static final MutableClassDescriptor f60105a;

    /* renamed from: b */
    private static final MutableClassDescriptor f60106b;

    static {
        ModuleDescriptor errorModule = ErrorUtils.getErrorModule();
        Intrinsics.checkNotNullExpressionValue(errorModule, "getErrorModule()");
        MutableClassDescriptor mutableClassDescriptor = new MutableClassDescriptor(new EmptyPackageFragmentDescriptor(errorModule, StandardNames.COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL), ClassKind.INTERFACE, false, false, StandardNames.CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL.shortName(), SourceElement.NO_SOURCE, LockBasedStorageManager.NO_LOCKS);
        mutableClassDescriptor.setModality(Modality.ABSTRACT);
        mutableClassDescriptor.setVisibility(DescriptorVisibilities.PUBLIC);
        mutableClassDescriptor.setTypeParameterDescriptors(CollectionsKt.listOf(TypeParameterDescriptorImpl.createWithDefaultBound(mutableClassDescriptor, Annotations.Companion.getEMPTY(), false, Variance.IN_VARIANCE, Name.identifier("T"), 0, LockBasedStorageManager.NO_LOCKS)));
        mutableClassDescriptor.createTypeConstructor();
        f60105a = mutableClassDescriptor;
        ModuleDescriptor errorModule2 = ErrorUtils.getErrorModule();
        Intrinsics.checkNotNullExpressionValue(errorModule2, "getErrorModule()");
        MutableClassDescriptor mutableClassDescriptor2 = new MutableClassDescriptor(new EmptyPackageFragmentDescriptor(errorModule2, StandardNames.COROUTINES_PACKAGE_FQ_NAME_RELEASE), ClassKind.INTERFACE, false, false, StandardNames.CONTINUATION_INTERFACE_FQ_NAME_RELEASE.shortName(), SourceElement.NO_SOURCE, LockBasedStorageManager.NO_LOCKS);
        mutableClassDescriptor2.setModality(Modality.ABSTRACT);
        mutableClassDescriptor2.setVisibility(DescriptorVisibilities.PUBLIC);
        mutableClassDescriptor2.setTypeParameterDescriptors(CollectionsKt.listOf(TypeParameterDescriptorImpl.createWithDefaultBound(mutableClassDescriptor2, Annotations.Companion.getEMPTY(), false, Variance.IN_VARIANCE, Name.identifier("T"), 0, LockBasedStorageManager.NO_LOCKS)));
        mutableClassDescriptor2.createTypeConstructor();
        f60106b = mutableClassDescriptor2;
    }

    public static final SimpleType transformSuspendFunctionToRuntimeFunctionType(KotlinType kotlinType, boolean z) {
        TypeConstructor typeConstructor;
        Intrinsics.checkNotNullParameter(kotlinType, "suspendFunType");
        boolean isSuspendFunctionType = FunctionTypesKt.isSuspendFunctionType(kotlinType);
        if (!_Assertions.ENABLED || isSuspendFunctionType) {
            KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(kotlinType);
            Annotations annotations = kotlinType.getAnnotations();
            KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
            Iterable<TypeProjection> valueParameterTypesFromFunctionType = FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(valueParameterTypesFromFunctionType, 10));
            for (TypeProjection type : valueParameterTypesFromFunctionType) {
                arrayList.add(type.getType());
            }
            Collection collection = (List) arrayList;
            Annotations empty = Annotations.Companion.getEMPTY();
            if (z) {
                typeConstructor = f60106b.getTypeConstructor();
            } else {
                typeConstructor = f60105a.getTypeConstructor();
            }
            TypeConstructor typeConstructor2 = typeConstructor;
            Intrinsics.checkNotNullExpressionValue(typeConstructor2, "if (isReleaseCoroutines)…ERIMENTAL.typeConstructor");
            List plus = CollectionsKt.plus(collection, KotlinTypeFactory.simpleType$default(empty, typeConstructor2, CollectionsKt.listOf(TypeUtilsKt.asTypeProjection(FunctionTypesKt.getReturnTypeFromFunctionType(kotlinType))), false, (KotlinTypeRefiner) null, 16, (Object) null));
            SimpleType nullableAnyType = TypeUtilsKt.getBuiltIns(kotlinType).getNullableAnyType();
            Intrinsics.checkNotNullExpressionValue(nullableAnyType, "suspendFunType.builtIns.nullableAnyType");
            return FunctionTypesKt.createFunctionType$default(builtIns, annotations, receiverTypeFromFunctionType, plus, (List) null, nullableAnyType, false, 64, (Object) null).makeNullableAsSpecified(kotlinType.isMarkedNullable());
        }
        throw new AssertionError(Intrinsics.stringPlus("This type should be suspend function type: ", kotlinType));
    }

    public static final boolean isContinuation(FqName fqName, boolean z) {
        if (z) {
            return Intrinsics.areEqual((Object) fqName, (Object) StandardNames.CONTINUATION_INTERFACE_FQ_NAME_RELEASE);
        }
        return Intrinsics.areEqual((Object) fqName, (Object) StandardNames.CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL);
    }
}
