package kshark.internal;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kshark.HprofRecord;
import kshark.OnHprofRecordListener;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, mo175978d2 = {"kshark/OnHprofRecordListener$Companion$invoke$1", "Lkshark/OnHprofRecordListener;", "onHprofRecord", "", "position", "", "record", "Lkshark/HprofRecord;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* renamed from: kshark.internal.HprofInMemoryIndex$Companion$createReadingHprof$$inlined$invoke$1 */
/* compiled from: OnHprofRecordListener.kt */
public final class C2361xa2ae7540 implements OnHprofRecordListener {
    final /* synthetic */ Ref.IntRef $classCount$inlined;
    final /* synthetic */ Ref.IntRef $instanceCount$inlined;
    final /* synthetic */ Ref.IntRef $objectArrayCount$inlined;
    final /* synthetic */ Ref.IntRef $primitiveArrayCount$inlined;

    public C2361xa2ae7540(Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, Ref.IntRef intRef4) {
        this.$classCount$inlined = intRef;
        this.$instanceCount$inlined = intRef2;
        this.$objectArrayCount$inlined = intRef3;
        this.$primitiveArrayCount$inlined = intRef4;
    }

    public void onHprofRecord(long j, HprofRecord hprofRecord) {
        Intrinsics.checkParameterIsNotNull(hprofRecord, SDKConsts.TAG_KEY_RECORD);
        if (hprofRecord instanceof HprofRecord.LoadClassRecord) {
            this.$classCount$inlined.element++;
        } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.InstanceSkipContentRecord) {
            this.$instanceCount$inlined.element++;
        } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArraySkipContentRecord) {
            this.$objectArrayCount$inlined.element++;
        } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArraySkipContentRecord) {
            this.$primitiveArrayCount$inlined.element++;
        }
    }
}
