package kshark.internal;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "graphObject", "Lkshark/HeapObject;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: PathFinder.kt */
final class PathFinder$sortedGcRoots$rootClassName$1 extends Lambda implements Function1<HeapObject, String> {
    public static final PathFinder$sortedGcRoots$rootClassName$1 INSTANCE = new PathFinder$sortedGcRoots$rootClassName$1();

    PathFinder$sortedGcRoots$rootClassName$1() {
        super(1);
    }

    public final String invoke(HeapObject heapObject) {
        Intrinsics.checkParameterIsNotNull(heapObject, "graphObject");
        if (heapObject instanceof HeapObject.HeapClass) {
            return ((HeapObject.HeapClass) heapObject).getName();
        }
        if (heapObject instanceof HeapObject.HeapInstance) {
            return ((HeapObject.HeapInstance) heapObject).getInstanceClassName();
        }
        if (heapObject instanceof HeapObject.HeapObjectArray) {
            return ((HeapObject.HeapObjectArray) heapObject).getArrayClassName();
        }
        if (heapObject instanceof HeapObject.HeapPrimitiveArray) {
            return ((HeapObject.HeapPrimitiveArray) heapObject).getArrayClassName();
        }
        throw new NoWhenBranchMatchedException();
    }
}
