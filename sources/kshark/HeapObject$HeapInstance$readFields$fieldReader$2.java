package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;
import kshark.internal.FieldValuesReader;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "Lkshark/internal/FieldValuesReader;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: HeapObject.kt */
final class HeapObject$HeapInstance$readFields$fieldReader$2 extends Lambda implements Function0<FieldValuesReader> {
    final /* synthetic */ HeapObject.HeapInstance this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeapObject$HeapInstance$readFields$fieldReader$2(HeapObject.HeapInstance heapInstance) {
        super(0);
        this.this$0 = heapInstance;
    }

    public final FieldValuesReader invoke() {
        return this.this$0.hprofGraph.createFieldValuesReader$shark(this.this$0.readRecord());
    }
}
