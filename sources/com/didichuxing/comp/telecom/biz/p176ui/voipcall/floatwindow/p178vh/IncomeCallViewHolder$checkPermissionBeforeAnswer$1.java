package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh;

import com.didichuxing.comp.telecom.biz.util.AudioGrantedCallback;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallRole;
import com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo175978d2 = {"com/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/vh/IncomeCallViewHolder$checkPermissionBeforeAnswer$1", "Lcom/didichuxing/comp/telecom/biz/util/AudioGrantedCallback;", "onCancel", "", "onGranted", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.IncomeCallViewHolder$checkPermissionBeforeAnswer$1 */
/* compiled from: IncomeCallViewHolder.kt */
public final class IncomeCallViewHolder$checkPermissionBeforeAnswer$1 implements AudioGrantedCallback {
    final /* synthetic */ IncomeCallViewHolder this$0;

    IncomeCallViewHolder$checkPermissionBeforeAnswer$1(IncomeCallViewHolder incomeCallViewHolder) {
        this.this$0 = incomeCallViewHolder;
    }

    public void onGranted() {
        CallLogUtil.logI(this.this$0.getTAG(), "checkPermissionBeforeAnswer - onGranted");
        AnalyseTickHelper analyseTickHelper = AnalyseTickHelper.INSTANCE;
        VoipAudioCall access$getMCurCall$p = this.this$0.f46365h;
        analyseTickHelper.tickVoipSteps(AnalyseTickHelper.STEP_GRANTED, access$getMCurCall$p != null ? access$getMCurCall$p.getVoipCallModel() : null, CallRole.CALLEE);
        VoipAudioCall access$getMCurCall$p2 = this.this$0.f46365h;
        if (access$getMCurCall$p2 != null) {
            access$getMCurCall$p2.answerCall();
        }
    }

    public void onCancel() {
        CallLogUtil.logI(this.this$0.getTAG(), "checkPermissionBeforeAnswer - onCancel");
        this.this$0.m33271a();
    }
}
