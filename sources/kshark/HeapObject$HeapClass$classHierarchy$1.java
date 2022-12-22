package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo175978d2 = {"<anonymous>", "Lkshark/HeapObject$HeapClass;", "it", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: HeapObject.kt */
final class HeapObject$HeapClass$classHierarchy$1 extends Lambda implements Function1<HeapObject.HeapClass, HeapObject.HeapClass> {
    public static final HeapObject$HeapClass$classHierarchy$1 INSTANCE = new HeapObject$HeapClass$classHierarchy$1();

    HeapObject$HeapClass$classHierarchy$1() {
        super(1);
    }

    public final HeapObject.HeapClass invoke(HeapObject.HeapClass heapClass) {
        Intrinsics.checkParameterIsNotNull(heapClass, "it");
        return heapClass.getSuperclass();
    }
}
