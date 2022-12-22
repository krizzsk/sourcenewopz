package com.didichuxing.comp.telecom.biz.p176ui.voipcall.page;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallRole;
import com.didichuxing.comp.telecom.core.CallStateKt;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$6 */
/* compiled from: ACallPageController.kt */
final class ACallPageController$initViews$6 implements View.OnClickListener {
    final /* synthetic */ ACallPageController this$0;

    ACallPageController$initViews$6(ACallPageController aCallPageController) {
        this.this$0 = aCallPageController;
    }

    public final void onClick(View view) {
        CallManagerAssist.CallEventTickHandler eventTickHandler;
        CallRole role;
        AutoTrackHelper.trackViewOnClick(view);
        CallLogUtil.logI(this.this$0.getTAG(), "[User click] - mSpeakerSwitch");
        VoipAudioCall mCurCall = this.this$0.getMCurCall();
        if (mCurCall != null) {
            boolean z = !mCurCall.isSpeakerOn();
            CallLogUtil.logI(this.this$0.getTAG(), "speaker toOpen:" + z);
            VoipAudioCall mCurCall2 = this.this$0.getMCurCall();
            if (mCurCall2 != null) {
                mCurCall2.setSpeakerState(z);
            }
            CallManagerAssist instance = CallManagerAssist.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
            CallManagerAssist.CallManagerConfig config = instance.getConfig();
            if (config != null && (eventTickHandler = config.getEventTickHandler()) != null) {
                String str = z ? "Speaker" : "OffSpeaker";
                String str2 = VoipCallPageStateKt.toStr(this.this$0.getMUiState());
                VoipAudioCall mCurCall3 = this.this$0.getMCurCall();
                VoipCallModel voipCallModel = null;
                String str3 = (mCurCall3 == null || (role = mCurCall3.getRole()) == null) ? null : CallStateKt.toStr(role);
                VoipAudioCall mCurCall4 = this.this$0.getMCurCall();
                if (mCurCall4 != null) {
                    voipCallModel = mCurCall4.getModel();
                }
                eventTickHandler.onCallPageBtnClick(str, str2, str3, voipCallModel);
            }
        }
    }
}
