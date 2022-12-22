package kshark;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"kshark/OnHprofRecordListener$Companion$invoke$1", "Lkshark/OnHprofRecordListener;", "onHprofRecord", "", "position", "", "record", "Lkshark/HprofRecord;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: OnHprofRecordListener.kt */
public final class OnHprofRecordListener$Companion$invoke$1 implements OnHprofRecordListener {
    final /* synthetic */ Function2 $block;

    public OnHprofRecordListener$Companion$invoke$1(Function2 function2) {
        this.$block = function2;
    }

    public void onHprofRecord(long j, HprofRecord hprofRecord) {
        Intrinsics.checkParameterIsNotNull(hprofRecord, SDKConsts.TAG_KEY_RECORD);
        this.$block.invoke(Long.valueOf(j), hprofRecord);
    }
}
