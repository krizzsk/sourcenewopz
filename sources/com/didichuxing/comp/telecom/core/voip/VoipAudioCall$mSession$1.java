package com.didichuxing.comp.telecom.core.voip;

import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManager;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.CallStateKt;
import com.didichuxing.comp.telecom.core.CallToastUtil;
import com.didichuxing.comp.telecom.core.util.TtsServiceHelper;
import com.didichuxing.comp.telecom.core.util.VibrationHelper;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.tipstate.TipStateComponent;
import com.taxis99.R;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"com/didichuxing/comp/telecom/core/voip/VoipAudioCall$mSession$1", "Lcom/didichuxing/comp/telecom/core/voip/VoipSessionListener;", "lastNotifyNetworkTime", "", "onCallStateChange", "", "state", "Lcom/didichuxing/comp/telecom/core/CallState;", "onNetworkUnstable", "unstable", "", "onOppositeLeave", "onPersonChange", "feedCount", "", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipAudioCall.kt */
public final class VoipAudioCall$mSession$1 implements VoipSessionListener {
    private long lastNotifyNetworkTime = -1;
    final /* synthetic */ VoipAudioCall this$0;

    VoipAudioCall$mSession$1(VoipAudioCall voipAudioCall) {
        this.this$0 = voipAudioCall;
    }

    public void onCallStateChange(CallState callState) {
        Intrinsics.checkParameterIsNotNull(callState, "state");
        String access$getTAG$p = this.this$0.f46429a;
        CallLogUtil.logI(access$getTAG$p, "onCallStateChange - " + callState);
        int i = VoipAudioCall.WhenMappings.$EnumSwitchMapping$0[callState.ordinal()];
        if (i == 1) {
            this.this$0.playRingCallIncome();
            VibrationHelper.Companion.getInstance().vibrate(true);
        } else if (i == 2) {
            this.this$0.stopRingCallIncome();
            VibrationHelper.Companion.getInstance().tryStop();
        } else if (i == 3) {
            this.this$0.f46431c = System.currentTimeMillis();
            this.this$0.playTip();
        }
        CopyOnWriteArrayList<VoipCallListener> access$getMCallbacks$p = this.this$0.f46432d;
        if (access$getMCallbacks$p != null) {
            for (VoipCallListener onStateChange : access$getMCallbacks$p) {
                onStateChange.onStateChange(this.this$0, callState);
            }
        }
        if (callState == CallState.END_CALL) {
            this.this$0.playCallEnd();
            CallManager.Companion.getInstance().destroyCurCall(this.this$0);
            TtsServiceHelper.Companion.getInstance().clearTasks();
        }
    }

    public void onNetworkUnstable(boolean z) {
        CallManagerAssist.CallManagerConfig config;
        CallManagerAssist.CallEventTickHandler eventTickHandler;
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.lastNotifyNetworkTime;
        this.lastNotifyNetworkTime = currentTimeMillis;
        if (z && j >= 20000) {
            TtsServiceHelper.play$default(TtsServiceHelper.Companion.getInstance(), (int) R.string.GDriver_IBT_Your_network_EfMe, false, 2, (Object) null);
            CallManagerAssist instance = CallManagerAssist.getInstance();
            if (!(instance == null || (config = instance.getConfig()) == null || (eventTickHandler = config.getEventTickHandler()) == null)) {
                eventTickHandler.onToastShow(this.this$0.getCallPageState(), CallStateKt.toStr(this.this$0.getRole()), "PoorNet", this.this$0.getVoipCallModel());
            }
        }
        TipStateComponent mStateTextHelper = this.this$0.getMStateTextHelper();
        if (mStateTextHelper != null) {
            mStateTextHelper.showNetworkUnstable(z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = r0.getOnMicNum();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPersonChange(int r4) {
        /*
            r3 = this;
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r0 = r3.this$0
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r0 = r0.getVoipCallModel()
            com.didichuxing.comp.telecom.core.voip.RoomInfo r0 = r0.getRoomInfo()
            if (r0 == 0) goto L_0x0017
            java.lang.Integer r0 = r0.getOnMicNum()
            if (r0 == 0) goto L_0x0017
            int r0 = r0.intValue()
            goto L_0x0018
        L_0x0017:
            r0 = 2
        L_0x0018:
            if (r4 < r0) goto L_0x001c
            r4 = 1
            goto L_0x001d
        L_0x001c:
            r4 = 0
        L_0x001d:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r0 = r3.this$0
            boolean r0 = r0.setMicState(r4)
            if (r0 == 0) goto L_0x0045
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r0 = r3.this$0
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.f46432d
            if (r0 == 0) goto L_0x0045
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0033:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r0.next()
            com.didichuxing.comp.telecom.core.voip.VoipCallListener r1 = (com.didichuxing.comp.telecom.core.voip.VoipCallListener) r1
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r2 = r3.this$0
            r1.onMicStateChange(r2, r4)
            goto L_0x0033
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.core.voip.VoipAudioCall$mSession$1.onPersonChange(int):void");
    }

    public void onOppositeLeave() {
        CallToastUtil.makeToast(Integer.valueOf(R.string.GDriver_IBT_The_call_CxWX));
    }
}
