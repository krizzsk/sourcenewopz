package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "heapObject", "Lkshark/HeapObject;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: AndroidObjectInspectors.kt */
final class AndroidObjectInspectors$COORDINATOR$leakingObjectFilter$1 extends Lambda implements Function1<HeapObject, Boolean> {
    public static final AndroidObjectInspectors$COORDINATOR$leakingObjectFilter$1 INSTANCE = new AndroidObjectInspectors$COORDINATOR$leakingObjectFilter$1();

    AndroidObjectInspectors$COORDINATOR$leakingObjectFilter$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((HeapObject) obj));
    }

    public final boolean invoke(HeapObject heapObject) {
        Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
        if (heapObject instanceof HeapObject.HeapInstance) {
            HeapObject.HeapInstance heapInstance = (HeapObject.HeapInstance) heapObject;
            if (heapInstance.instanceOf("com.squareup.coordinators.Coordinator")) {
                HeapField heapField = heapInstance.get("com.squareup.coordinators.Coordinator", "attached");
                if (heapField == null) {
                    Intrinsics.throwNpe();
                }
                Boolean asBoolean = heapField.getValue().getAsBoolean();
                if (asBoolean == null) {
                    Intrinsics.throwNpe();
                }
                if (!asBoolean.booleanValue()) {
                    return true;
                }
            }
        }
        return false;
    }
}
