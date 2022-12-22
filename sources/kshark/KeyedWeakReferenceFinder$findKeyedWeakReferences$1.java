package kshark;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kshark.HeapObject;
import kshark.SharkLog;
import kshark.internal.KeyedWeakReferenceMirror;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo175978d2 = {"<anonymous>", "", "Lkshark/internal/KeyedWeakReferenceMirror;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: KeyedWeakReferenceFinder.kt */
final class KeyedWeakReferenceFinder$findKeyedWeakReferences$1 extends Lambda implements Function0<List<? extends KeyedWeakReferenceMirror>> {
    final /* synthetic */ HeapGraph $graph;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KeyedWeakReferenceFinder$findKeyedWeakReferences$1(HeapGraph heapGraph) {
        super(0);
        this.$graph = heapGraph;
    }

    public final List<KeyedWeakReferenceMirror> invoke() {
        SharkLog.Logger logger;
        HeapField heapField;
        HeapValue value;
        HeapObject.HeapClass findClassByName = this.$graph.findClassByName("leakcanary.KeyedWeakReference");
        Long l = null;
        if (!(findClassByName == null || (heapField = findClassByName.get("heapDumpUptimeMillis")) == null || (value = heapField.getValue()) == null)) {
            l = value.getAsLong();
        }
        if (l == null && (logger = SharkLog.INSTANCE.getLogger()) != null) {
            logger.mo23715d("leakcanary.KeyedWeakReference.heapDumpUptimeMillis field not found, this must be a heap dump from an older version of LeakCanary.");
        }
        List<KeyedWeakReferenceMirror> list = SequencesKt.toList(SequencesKt.filter(SequencesKt.map(SequencesKt.filter(this.$graph.getInstances(), C2357xf4ad033c.INSTANCE), new C2358xf4ad033d(l)), C2359xf4ad033e.INSTANCE));
        this.$graph.getContext().set(ObjectInspectors.KEYED_WEAK_REFERENCE.name(), list);
        return list;
    }
}
