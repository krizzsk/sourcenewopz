package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kshark.HprofRecord;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "Lkshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: HprofHeapGraph.kt */
final class HprofHeapGraph$readPrimitiveArrayDumpRecord$1 extends Lambda implements Function0<HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord> {
    final /* synthetic */ HprofHeapGraph this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HprofHeapGraph$readPrimitiveArrayDumpRecord$1(HprofHeapGraph hprofHeapGraph) {
        super(0);
        this.this$0 = hprofHeapGraph;
    }

    public final HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord invoke() {
        return this.this$0.f4551d.getReader().readPrimitiveArrayDumpRecord();
    }
}
