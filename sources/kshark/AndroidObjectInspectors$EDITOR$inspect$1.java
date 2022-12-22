package kshark;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "Lkshark/ObjectReporter;", "instance", "Lkshark/HeapObject$HeapInstance;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: AndroidObjectInspectors.kt */
final class AndroidObjectInspectors$EDITOR$inspect$1 extends Lambda implements Function2<ObjectReporter, HeapObject.HeapInstance, Unit> {
    public static final AndroidObjectInspectors$EDITOR$inspect$1 INSTANCE = new AndroidObjectInspectors$EDITOR$inspect$1();

    AndroidObjectInspectors$EDITOR$inspect$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ObjectReporter) obj, (HeapObject.HeapInstance) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ObjectReporter objectReporter, HeapObject.HeapInstance heapInstance) {
        Intrinsics.checkParameterIsNotNull(objectReporter, "$receiver");
        Intrinsics.checkParameterIsNotNull(heapInstance, "instance");
        AndroidObjectInspectorsKt.m2906a(objectReporter, AndroidObjectInspectors.VIEW, heapInstance.get("android.widget.Editor", "mTextView"));
    }
}
