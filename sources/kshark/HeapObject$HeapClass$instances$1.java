package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "it", "Lkshark/HeapObject$HeapInstance;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: HeapObject.kt */
final class HeapObject$HeapClass$instances$1 extends Lambda implements Function1<HeapObject.HeapInstance, Boolean> {
    final /* synthetic */ HeapObject.HeapClass this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeapObject$HeapClass$instances$1(HeapObject.HeapClass heapClass) {
        super(1);
        this.this$0 = heapClass;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((HeapObject.HeapInstance) obj));
    }

    public final boolean invoke(HeapObject.HeapInstance heapInstance) {
        Intrinsics.checkParameterIsNotNull(heapInstance, "it");
        return heapInstance.instanceOf(this.this$0);
    }
}
