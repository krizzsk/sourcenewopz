package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "it", "Lkshark/HeapObject;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: FilteringLeakingObjectFinder.kt */
final class FilteringLeakingObjectFinder$findLeakingObjectIds$2 extends Lambda implements Function1<HeapObject, Long> {
    public static final FilteringLeakingObjectFinder$findLeakingObjectIds$2 INSTANCE = new FilteringLeakingObjectFinder$findLeakingObjectIds$2();

    FilteringLeakingObjectFinder$findLeakingObjectIds$2() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Long.valueOf(invoke((HeapObject) obj));
    }

    public final long invoke(HeapObject heapObject) {
        Intrinsics.checkParameterIsNotNull(heapObject, "it");
        return heapObject.getObjectId();
    }
}
