package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "graph", "Lkshark/HeapGraph;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: AndroidReferenceMatchers.kt */
final class AndroidReferenceMatchers$Companion$libraryLeak$1 extends Lambda implements Function1<HeapGraph, Boolean> {
    final /* synthetic */ Function1 $patternApplies;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidReferenceMatchers$Companion$libraryLeak$1(Function1 function1) {
        super(1);
        this.$patternApplies = function1;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((HeapGraph) obj));
    }

    public final boolean invoke(HeapGraph heapGraph) {
        Intrinsics.checkParameterIsNotNull(heapGraph, "graph");
        return ((Boolean) this.$patternApplies.invoke(AndroidBuildMirror.Companion.fromHeapGraph(heapGraph))).booleanValue();
    }
}
