package com.didichuxing.comp.telecom.biz.p176ui.voipcall.page;

import com.didichuxing.comp.telecom.biz.util.AudioGrantedCallback;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo175978d2 = {"com/didichuxing/comp/telecom/biz/ui/voipcall/page/CallingPageController$bindController$1", "Lcom/didichuxing/comp/telecom/biz/util/AudioGrantedCallback;", "onCancel", "", "onGranted", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.CallingPageController$bindController$1 */
/* compiled from: CallingPageController.kt */
public final class CallingPageController$bindController$1 implements AudioGrantedCallback {
    final /* synthetic */ CallingPageController this$0;

    CallingPageController$bindController$1(CallingPageController callingPageController) {
        this.this$0 = callingPageController;
    }

    public void onGranted() {
        VoipAudioCall mCurCall;
        CallLogUtil.logI(this.this$0.getTAG(), "checkPermissionBeforeAnswer - onGranted");
        VoipAudioCall mCurCall2 = this.this$0.getMCurCall();
        if ((mCurCall2 != null ? mCurCall2.getState() : null) == CallState.INITIALED && (mCurCall = this.this$0.getMCurCall()) != null) {
            mCurCall.makeCall();
        }
    }

    public void onCancel() {
        CallLogUtil.logI(this.this$0.getTAG(), "checkPermissionBeforeAnswer - onCancel");
        VoipAudioCall mCurCall = this.this$0.getMCurCall();
        if (mCurCall != null) {
            mCurCall.forceStop();
        }
    }
}
