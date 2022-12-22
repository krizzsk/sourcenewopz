package kshark.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kshark.HeapField;
import kshark.HeapObject;
import kshark.HeapValue;
import kshark.internal.PathFinder;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo175978d2 = {"<anonymous>", "", "invoke", "kshark/internal/PathFinder$enqueueGcRoots$4$threadName$1"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: PathFinder.kt */
final class PathFinder$enqueueGcRoots$$inlined$forEach$lambda$1 extends Lambda implements Function0<String> {
    final /* synthetic */ PathFinder.State $this_enqueueGcRoots$inlined;
    final /* synthetic */ HeapObject.HeapInstance $threadInstance;
    final /* synthetic */ Map $threadNames$inlined;
    final /* synthetic */ Map $threadsBySerialNumber$inlined;
    final /* synthetic */ PathFinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PathFinder$enqueueGcRoots$$inlined$forEach$lambda$1(HeapObject.HeapInstance heapInstance, PathFinder pathFinder, PathFinder.State state, Map map, Map map2) {
        super(0);
        this.$threadInstance = heapInstance;
        this.this$0 = pathFinder;
        this.$this_enqueueGcRoots$inlined = state;
        this.$threadsBySerialNumber$inlined = map;
        this.$threadNames$inlined = map2;
    }

    public final String invoke() {
        String str;
        HeapValue value;
        HeapField heapField = this.$threadInstance.get((KClass<? extends Object>) C21490Reflection.getOrCreateKotlinClass(Thread.class), "name");
        if (heapField == null || (value = heapField.getValue()) == null || (str = value.readAsJavaString()) == null) {
            str = "";
        }
        this.$threadNames$inlined.put(this.$threadInstance, str);
        return str;
    }
}
