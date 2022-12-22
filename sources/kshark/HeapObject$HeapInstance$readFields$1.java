package kshark;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kshark.HeapObject;
import kshark.HprofRecord;
import kshark.internal.FieldValuesReader;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "Lkotlin/sequences/Sequence;", "Lkshark/HeapField;", "heapClass", "Lkshark/HeapObject$HeapClass;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: HeapObject.kt */
final class HeapObject$HeapInstance$readFields$1 extends Lambda implements Function1<HeapObject.HeapClass, Sequence<? extends HeapField>> {
    final /* synthetic */ Lazy $fieldReader;
    final /* synthetic */ KProperty $fieldReader$metadata;
    final /* synthetic */ HeapObject.HeapInstance this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeapObject$HeapInstance$readFields$1(HeapObject.HeapInstance heapInstance, Lazy lazy, KProperty kProperty) {
        super(1);
        this.this$0 = heapInstance;
        this.$fieldReader = lazy;
        this.$fieldReader$metadata = kProperty;
    }

    public final Sequence<HeapField> invoke(final HeapObject.HeapClass heapClass) {
        Intrinsics.checkParameterIsNotNull(heapClass, "heapClass");
        return SequencesKt.map(CollectionsKt.asSequence(heapClass.readRecord().getFields()), new Function1<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord, HeapField>(this) {
            final /* synthetic */ HeapObject$HeapInstance$readFields$1 this$0;

            {
                this.this$0 = r1;
            }

            public final HeapField invoke(HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord fieldRecord) {
                Intrinsics.checkParameterIsNotNull(fieldRecord, "fieldRecord");
                String fieldName$shark = this.this$0.this$0.hprofGraph.fieldName$shark(heapClass.getObjectId(), fieldRecord);
                Lazy lazy = this.this$0.$fieldReader;
                KProperty kProperty = this.this$0.$fieldReader$metadata;
                return new HeapField(heapClass, fieldName$shark, new HeapValue(this.this$0.this$0.hprofGraph, ((FieldValuesReader) lazy.getValue()).readValue(fieldRecord)));
            }
        });
    }
}
