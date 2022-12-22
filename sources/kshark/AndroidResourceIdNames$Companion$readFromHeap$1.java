package kshark;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kshark.HeapObject;
import kshark.HprofRecord;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "Lkshark/AndroidResourceIdNames;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: AndroidResourceIdNames.kt */
final class AndroidResourceIdNames$Companion$readFromHeap$1 extends Lambda implements Function0<AndroidResourceIdNames> {
    final /* synthetic */ HeapGraph $graph;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidResourceIdNames$Companion$readFromHeap$1(HeapGraph heapGraph) {
        super(0);
        this.$graph = heapGraph;
    }

    public final AndroidResourceIdNames invoke() {
        String name = AndroidResourceIdNames.class.getName();
        HeapGraph heapGraph = this.$graph;
        Intrinsics.checkExpressionValueIsNotNull(name, "className");
        HeapObject.HeapClass findClassByName = heapGraph.findClassByName(name);
        if (findClassByName == null) {
            return null;
        }
        HeapField heapField = findClassByName.get("holderField");
        if (heapField == null) {
            Intrinsics.throwNpe();
        }
        HeapObject.HeapInstance valueAsInstance = heapField.getValueAsInstance();
        if (valueAsInstance == null) {
            return null;
        }
        HeapField heapField2 = valueAsInstance.get(name, "resourceIds");
        if (heapField2 == null) {
            Intrinsics.throwNpe();
        }
        HeapObject.HeapPrimitiveArray valueAsPrimitiveArray = heapField2.getValueAsPrimitiveArray();
        if (valueAsPrimitiveArray == null) {
            Intrinsics.throwNpe();
        }
        HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord readRecord = valueAsPrimitiveArray.readRecord();
        if (readRecord != null) {
            int[] array = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) readRecord).getArray();
            HeapField heapField3 = valueAsInstance.get(name, "names");
            if (heapField3 == null) {
                Intrinsics.throwNpe();
            }
            HeapObject.HeapObjectArray valueAsObjectArray = heapField3.getValueAsObjectArray();
            if (valueAsObjectArray == null) {
                Intrinsics.throwNpe();
            }
            Object[] array2 = SequencesKt.toList(SequencesKt.map(valueAsObjectArray.readElements(), AndroidResourceIdNames$Companion$readFromHeap$1$1$1$names$1.INSTANCE)).toArray(new String[0]);
            if (array2 != null) {
                return new AndroidResourceIdNames(array, (String[]) array2, (DefaultConstructorMarker) null);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new TypeCastException("null cannot be cast to non-null type kshark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump");
    }
}
