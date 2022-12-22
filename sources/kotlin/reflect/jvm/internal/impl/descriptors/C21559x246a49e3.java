package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2 */
/* compiled from: typeParameterUtils.kt */
final class C21559x246a49e3 extends Lambda implements Function1<DeclarationDescriptor, Boolean> {
    public static final C21559x246a49e3 INSTANCE = new C21559x246a49e3();

    C21559x246a49e3() {
        super(1);
    }

    public final Boolean invoke(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "it");
        return Boolean.valueOf(!(declarationDescriptor instanceof ConstructorDescriptor));
    }
}
