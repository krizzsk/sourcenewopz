package kshark;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.FilteringLeakingObjectFinder;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "heapObject", "Lkshark/HeapObject;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: FilteringLeakingObjectFinder.kt */
final class FilteringLeakingObjectFinder$findLeakingObjectIds$1 extends Lambda implements Function1<HeapObject, Boolean> {
    final /* synthetic */ FilteringLeakingObjectFinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FilteringLeakingObjectFinder$findLeakingObjectIds$1(FilteringLeakingObjectFinder filteringLeakingObjectFinder) {
        super(1);
        this.this$0 = filteringLeakingObjectFinder;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((HeapObject) obj));
    }

    public final boolean invoke(HeapObject heapObject) {
        Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
        Iterable<FilteringLeakingObjectFinder.LeakingObjectFilter> access$getFilters$p = this.this$0.f4517a;
        if ((access$getFilters$p instanceof Collection) && ((Collection) access$getFilters$p).isEmpty()) {
            return false;
        }
        for (FilteringLeakingObjectFinder.LeakingObjectFilter isLeakingObject : access$getFilters$p) {
            if (isLeakingObject.isLeakingObject(heapObject)) {
                return true;
            }
        }
        return false;
    }
}
