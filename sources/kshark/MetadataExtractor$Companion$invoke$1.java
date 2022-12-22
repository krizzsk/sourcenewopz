package kshark;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"kshark/MetadataExtractor$Companion$invoke$1", "Lkshark/MetadataExtractor;", "extractMetadata", "", "", "graph", "Lkshark/HeapGraph;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: MetadataExtractor.kt */
public final class MetadataExtractor$Companion$invoke$1 implements MetadataExtractor {
    final /* synthetic */ Function1 $block;

    public MetadataExtractor$Companion$invoke$1(Function1 function1) {
        this.$block = function1;
    }

    public Map<String, String> extractMetadata(HeapGraph heapGraph) {
        Intrinsics.checkParameterIsNotNull(heapGraph, "graph");
        return (Map) this.$block.invoke(heapGraph);
    }
}
