package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;
import kshark.ValueHolder;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "Lkshark/HeapValue;", "it", "", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: HeapObject.kt */
final class HeapObject$HeapObjectArray$readElements$1 extends Lambda implements Function1<Long, HeapValue> {
    final /* synthetic */ HeapObject.HeapObjectArray this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeapObject$HeapObjectArray$readElements$1(HeapObject.HeapObjectArray heapObjectArray) {
        super(1);
        this.this$0 = heapObjectArray;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }

    public final HeapValue invoke(long j) {
        return new HeapValue(this.this$0.hprofGraph, new ValueHolder.ReferenceHolder(j));
    }
}
