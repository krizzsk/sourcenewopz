package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"kshark/ObjectInspector$Companion$invoke$1", "Lkshark/ObjectInspector;", "inspect", "", "reporter", "Lkshark/ObjectReporter;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: ObjectInspector.kt */
public final class ObjectInspector$Companion$invoke$1 implements ObjectInspector {
    final /* synthetic */ Function1 $block;

    public ObjectInspector$Companion$invoke$1(Function1 function1) {
        this.$block = function1;
    }

    public void inspect(ObjectReporter objectReporter) {
        Intrinsics.checkParameterIsNotNull(objectReporter, "reporter");
        this.$block.invoke(objectReporter);
    }
}
