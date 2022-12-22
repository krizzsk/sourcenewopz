package com.didichuxing.comp.telecom.core.voip;

import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.voip.VoipSessionImpl;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* compiled from: VoipSessionImpl.kt */
final class VoipSessionImpl$ACallingCallback$emitOvertimeTick$action$1 implements Runnable {
    final /* synthetic */ VoipSessionImpl.ACallingCallback this$0;

    VoipSessionImpl$ACallingCallback$emitOvertimeTick$action$1(VoipSessionImpl.ACallingCallback aCallingCallback) {
        this.this$0 = aCallingCallback;
    }

    public final void run() {
        if (VoipSessionImpl.this.f46442c != CallState.IN_CALL && VoipSessionImpl.this.f46442c != CallState.END_CALL) {
            String compName = this.this$0.getCompName();
            CallLogUtil.logI(compName, "wait over time " + VoipSessionImpl.this.f46442c);
            this.this$0.onWaitOverTime();
            this.this$0.quitForOvertime();
        }
    }
}
