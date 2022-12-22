package kshark;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.internal.KeyedWeakReferenceMirror;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "heapObject", "Lkshark/HeapObject;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: ObjectInspectors.kt */
final class ObjectInspectors$KEYED_WEAK_REFERENCE$leakingObjectFilter$1 extends Lambda implements Function1<HeapObject, Boolean> {
    public static final ObjectInspectors$KEYED_WEAK_REFERENCE$leakingObjectFilter$1 INSTANCE = new ObjectInspectors$KEYED_WEAK_REFERENCE$leakingObjectFilter$1();

    ObjectInspectors$KEYED_WEAK_REFERENCE$leakingObjectFilter$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((HeapObject) obj));
    }

    public final boolean invoke(HeapObject heapObject) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(heapObject, "heapObject");
        Iterable<KeyedWeakReferenceMirror> findKeyedWeakReferences$shark = KeyedWeakReferenceFinder.INSTANCE.findKeyedWeakReferences$shark(heapObject.getGraph());
        if (!(findKeyedWeakReferences$shark instanceof Collection) || !((Collection) findKeyedWeakReferences$shark).isEmpty()) {
            for (KeyedWeakReferenceMirror referent : findKeyedWeakReferences$shark) {
                if (referent.getReferent().getValue() == heapObject.getObjectId()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }
}
