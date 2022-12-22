package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HeapObject;
import kshark.internal.KeyedWeakReferenceMirror;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "Lkshark/internal/KeyedWeakReferenceMirror;", "it", "Lkshark/HeapObject$HeapInstance;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* renamed from: kshark.KeyedWeakReferenceFinder$findKeyedWeakReferences$1$addedToContext$2 */
/* compiled from: KeyedWeakReferenceFinder.kt */
final class C2358xf4ad033d extends Lambda implements Function1<HeapObject.HeapInstance, KeyedWeakReferenceMirror> {
    final /* synthetic */ Long $heapDumpUptimeMillis;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2358xf4ad033d(Long l) {
        super(1);
        this.$heapDumpUptimeMillis = l;
    }

    public final KeyedWeakReferenceMirror invoke(HeapObject.HeapInstance heapInstance) {
        Intrinsics.checkParameterIsNotNull(heapInstance, "it");
        return KeyedWeakReferenceMirror.Companion.fromInstance(heapInstance, this.$heapDumpUptimeMillis);
    }
}
