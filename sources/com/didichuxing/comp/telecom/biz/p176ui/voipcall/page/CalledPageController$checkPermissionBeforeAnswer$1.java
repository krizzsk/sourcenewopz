package com.didichuxing.comp.telecom.biz.p176ui.voipcall.page;

import androidx.fragment.app.FragmentActivity;
import com.didichuxing.comp.telecom.biz.util.AudioGrantedCallback;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallRole;
import com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo175978d2 = {"com/didichuxing/comp/telecom/biz/ui/voipcall/page/CalledPageController$checkPermissionBeforeAnswer$1", "Lcom/didichuxing/comp/telecom/biz/util/AudioGrantedCallback;", "onCancel", "", "onGranted", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.CalledPageController$checkPermissionBeforeAnswer$1 */
/* compiled from: CalledPageController.kt */
public final class CalledPageController$checkPermissionBeforeAnswer$1 implements AudioGrantedCallback {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ CalledPageController this$0;

    CalledPageController$checkPermissionBeforeAnswer$1(CalledPageController calledPageController, FragmentActivity fragmentActivity) {
        this.this$0 = calledPageController;
        this.$activity = fragmentActivity;
    }

    public void onGranted() {
        CallLogUtil.logI(this.this$0.getTAG(), "checkPermissionBeforeAnswer - onGranted");
        VoipAudioCall mCurCall = this.this$0.getMCurCall();
        if (mCurCall != null) {
            mCurCall.answerCall();
        }
        AnalyseTickHelper.INSTANCE.tickVoipSteps(AnalyseTickHelper.STEP_GRANTED, this.this$0.getMVoipModel(), CallRole.CALLEE);
    }

    public void onCancel() {
        CallLogUtil.logI(this.this$0.getTAG(), "checkPermissionBeforeAnswer - onCancel");
        this.this$0.m33277b();
        this.$activity.finish();
    }
}
