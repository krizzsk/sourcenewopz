package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2 */
/* compiled from: findClassInModule.kt */
final class C21555x24bfe127 extends Lambda implements Function1<ClassId, Integer> {
    public static final C21555x24bfe127 INSTANCE = new C21555x24bfe127();

    C21555x24bfe127() {
        super(1);
    }

    public final Integer invoke(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "it");
        return 0;
    }
}
