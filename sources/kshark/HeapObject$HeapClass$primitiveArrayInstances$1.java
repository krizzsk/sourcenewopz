package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "it", "Lkshark/HeapObject$HeapPrimitiveArray;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: HeapObject.kt */
final class HeapObject$HeapClass$primitiveArrayInstances$1 extends Lambda implements Function1<HeapObject.HeapPrimitiveArray, Boolean> {
    final /* synthetic */ PrimitiveType $primitiveType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeapObject$HeapClass$primitiveArrayInstances$1(PrimitiveType primitiveType) {
        super(1);
        this.$primitiveType = primitiveType;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((HeapObject.HeapPrimitiveArray) obj));
    }

    public final boolean invoke(HeapObject.HeapPrimitiveArray heapPrimitiveArray) {
        Intrinsics.checkParameterIsNotNull(heapPrimitiveArray, "it");
        return heapPrimitiveArray.getPrimitiveType() == this.$primitiveType;
    }
}
