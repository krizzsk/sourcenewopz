package kshark.internal;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kshark.GcRoot;
import kshark.HeapObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u00032&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, mo175978d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lkshark/HeapObject;", "Lkshark/GcRoot;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 1>", "compare"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: PathFinder.kt */
final class PathFinder$sortedGcRoots$3<T> implements Comparator<Pair<? extends HeapObject, ? extends GcRoot>> {
    final /* synthetic */ Function1 $rootClassName;

    PathFinder$sortedGcRoots$3(Function1 function1) {
        this.$rootClassName = function1;
    }

    public final int compare(Pair<? extends HeapObject, ? extends GcRoot> pair, Pair<? extends HeapObject, ? extends GcRoot> pair2) {
        HeapObject heapObject = (HeapObject) pair.component1();
        HeapObject heapObject2 = (HeapObject) pair2.component1();
        String name = ((GcRoot) pair2.component2()).getClass().getName();
        String name2 = ((GcRoot) pair.component2()).getClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "root1::class.java.name");
        int compareTo = name.compareTo(name2);
        return compareTo != 0 ? compareTo : ((String) this.$rootClassName.invoke(heapObject)).compareTo((String) this.$rootClassName.invoke(heapObject2));
    }
}
