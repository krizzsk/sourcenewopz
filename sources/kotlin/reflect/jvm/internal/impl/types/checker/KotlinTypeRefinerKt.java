package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: KotlinTypeRefiner.kt */
public final class KotlinTypeRefinerKt {

    /* renamed from: a */
    private static final ModuleCapability<Ref<KotlinTypeRefiner>> f61150a = new ModuleCapability<>("KotlinTypeRefiner");

    public static final ModuleCapability<Ref<KotlinTypeRefiner>> getREFINER_CAPABILITY() {
        return f61150a;
    }

    public static final List<KotlinType> refineTypes(KotlinTypeRefiner kotlinTypeRefiner, Iterable<? extends KotlinType> iterable) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "types");
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (KotlinType refineType : iterable) {
            arrayList.add(kotlinTypeRefiner.refineType(refineType));
        }
        return (List) arrayList;
    }
}
