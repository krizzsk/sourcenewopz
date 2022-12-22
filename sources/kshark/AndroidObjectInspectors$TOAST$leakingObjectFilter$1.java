package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "heapObject", "Lkshark/HeapObject;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: AndroidObjectInspectors.kt */
final class AndroidObjectInspectors$TOAST$leakingObjectFilter$1 extends Lambda implements Function1<HeapObject, Boolean> {
    public static final AndroidObjectInspectors$TOAST$leakingObjectFilter$1 INSTANCE = new AndroidObjectInspectors$TOAST$leakingObjectFilter$1();

    AndroidObjectInspectors$TOAST$leakingObjectFilter$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((HeapObject) obj));
    }

    public final boolean invoke(HeapObject heapObject) {
        Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
        if (!(heapObject instanceof HeapObject.HeapInstance)) {
            return false;
        }
        HeapObject.HeapInstance heapInstance = (HeapObject.HeapInstance) heapObject;
        if (!heapInstance.instanceOf("android.widget.Toast")) {
            return false;
        }
        HeapField heapField = heapInstance.get("android.widget.Toast", "mTN");
        if (heapField == null) {
            Intrinsics.throwNpe();
        }
        HeapObject asObject = heapField.getValue().getAsObject();
        if (asObject == null) {
            Intrinsics.throwNpe();
        }
        HeapObject.HeapInstance asInstance = asObject.getAsInstance();
        if (asInstance == null) {
            Intrinsics.throwNpe();
        }
        HeapField heapField2 = asInstance.get("android.widget.Toast$TN", "mWM");
        if (heapField2 == null) {
            Intrinsics.throwNpe();
        }
        if (!heapField2.getValue().isNonNullReference()) {
            return false;
        }
        HeapField heapField3 = asInstance.get("android.widget.Toast$TN", "mView");
        if (heapField3 == null) {
            Intrinsics.throwNpe();
        }
        if (heapField3.getValue().isNullReference()) {
            return true;
        }
        return false;
    }
}
