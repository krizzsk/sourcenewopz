package com.didichuxing.comp.telecom.biz.p176ui.voipcall.page;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.CallStateKt;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$4 */
/* compiled from: ACallPageController.kt */
final class ACallPageController$initViews$4 implements View.OnClickListener {
    final /* synthetic */ ACallPageController this$0;

    ACallPageController$initViews$4(ACallPageController aCallPageController) {
        this.this$0 = aCallPageController;
    }

    public final void onClick(View view) {
        CallManagerAssist.CallEventTickHandler eventTickHandler;
        AutoTrackHelper.trackViewOnClick(view);
        CallLogUtil.logI(this.this$0.getTAG(), "[User click] - mMicSwitch");
        VoipAudioCall mCurCall = this.this$0.getMCurCall();
        if (mCurCall == null) {
            return;
        }
        if (mCurCall.getState() != CallState.IN_CALL) {
            CallLogUtil.logI(this.this$0.getTAG(), "not in call , switch mic not valid");
            return;
        }
        boolean z = !mCurCall.isMicOn();
        CallLogUtil.logI(this.this$0.getTAG(), "mic toOpen:" + z);
        if (mCurCall.setMicState(z)) {
            this.this$0.changeMicOnShowState(z);
            CallManagerAssist instance = CallManagerAssist.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
            CallManagerAssist.CallManagerConfig config = instance.getConfig();
            if (config != null && (eventTickHandler = config.getEventTickHandler()) != null) {
                eventTickHandler.onCallPageBtnClick(z ? "OffMute" : "Mute", VoipCallPageStateKt.toStr(this.this$0.getMUiState()), CallStateKt.toStr(mCurCall.getRole()), mCurCall.getModel());
            }
        }
    }
}
