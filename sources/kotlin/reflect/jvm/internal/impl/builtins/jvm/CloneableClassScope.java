package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: CloneableClassScope.kt */
public final class CloneableClassScope extends GivenFunctionsMemberScope {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Name f60124b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CloneableClassScope(StorageManager storageManager, ClassDescriptor classDescriptor) {
        super(storageManager, classDescriptor);
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(classDescriptor, "containingClass");
    }

    /* access modifiers changed from: protected */
    public List<FunctionDescriptor> computeDeclaredFunctions() {
        SimpleFunctionDescriptorImpl create = SimpleFunctionDescriptorImpl.create(getContainingClass(), Annotations.Companion.getEMPTY(), f60124b, CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE);
        create.initialize((ReceiverParameterDescriptor) null, getContainingClass().getThisAsReceiverParameter(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), (KotlinType) DescriptorUtilsKt.getBuiltIns(getContainingClass()).getAnyType(), Modality.OPEN, DescriptorVisibilities.PROTECTED);
        return CollectionsKt.listOf(create);
    }

    /* compiled from: CloneableClassScope.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Name getCLONE_NAME() {
            return CloneableClassScope.f60124b;
        }
    }

    static {
        Name identifier = Name.identifier("clone");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"clone\")");
        f60124b = identifier;
    }
}
