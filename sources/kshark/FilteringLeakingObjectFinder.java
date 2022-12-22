package kshark;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lkshark/FilteringLeakingObjectFinder;", "Lkshark/LeakingObjectFinder;", "filters", "", "Lkshark/FilteringLeakingObjectFinder$LeakingObjectFilter;", "(Ljava/util/List;)V", "findLeakingObjectIds", "", "", "graph", "Lkshark/HeapGraph;", "LeakingObjectFilter", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: FilteringLeakingObjectFinder.kt */
public final class FilteringLeakingObjectFinder implements LeakingObjectFinder {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<LeakingObjectFilter> f4517a;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lkshark/FilteringLeakingObjectFinder$LeakingObjectFilter;", "", "isLeakingObject", "", "heapObject", "Lkshark/HeapObject;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: FilteringLeakingObjectFinder.kt */
    public interface LeakingObjectFilter {
        boolean isLeakingObject(HeapObject heapObject);
    }

    public FilteringLeakingObjectFinder(List<? extends LeakingObjectFilter> list) {
        Intrinsics.checkParameterIsNotNull(list, "filters");
        this.f4517a = list;
    }

    public Set<Long> findLeakingObjectIds(HeapGraph heapGraph) {
        Intrinsics.checkParameterIsNotNull(heapGraph, "graph");
        return SequencesKt.toSet(SequencesKt.map(SequencesKt.filter(heapGraph.getObjects(), new FilteringLeakingObjectFinder$findLeakingObjectIds$1(this)), FilteringLeakingObjectFinder$findLeakingObjectIds$2.INSTANCE));
    }
}
