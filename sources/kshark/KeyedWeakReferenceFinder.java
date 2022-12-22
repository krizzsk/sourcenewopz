package kshark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kshark.internal.KeyedWeakReferenceMirror;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, mo175978d2 = {"Lkshark/KeyedWeakReferenceFinder;", "Lkshark/LeakingObjectFinder;", "()V", "findKeyedWeakReferences", "", "Lkshark/internal/KeyedWeakReferenceMirror;", "graph", "Lkshark/HeapGraph;", "findKeyedWeakReferences$shark", "findLeakingObjectIds", "", "", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: KeyedWeakReferenceFinder.kt */
public final class KeyedWeakReferenceFinder implements LeakingObjectFinder {
    public static final KeyedWeakReferenceFinder INSTANCE = new KeyedWeakReferenceFinder();

    private KeyedWeakReferenceFinder() {
    }

    public Set<Long> findLeakingObjectIds(HeapGraph heapGraph) {
        Intrinsics.checkParameterIsNotNull(heapGraph, "graph");
        Iterable<KeyedWeakReferenceMirror> findKeyedWeakReferences$shark = findKeyedWeakReferences$shark(heapGraph);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(findKeyedWeakReferences$shark, 10));
        for (KeyedWeakReferenceMirror referent : findKeyedWeakReferences$shark) {
            arrayList.add(Long.valueOf(referent.getReferent().getValue()));
        }
        return CollectionsKt.toSet((List) arrayList);
    }

    public final List<KeyedWeakReferenceMirror> findKeyedWeakReferences$shark(HeapGraph heapGraph) {
        Intrinsics.checkParameterIsNotNull(heapGraph, "graph");
        return (List) heapGraph.getContext().getOrPut(ObjectInspectors.KEYED_WEAK_REFERENCE.name(), new KeyedWeakReferenceFinder$findKeyedWeakReferences$1(heapGraph));
    }
}
