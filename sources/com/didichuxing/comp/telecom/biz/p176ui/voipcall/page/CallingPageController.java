package com.didichuxing.comp.telecom.biz.p176ui.voipcall.page;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageState;
import com.didichuxing.comp.telecom.biz.util.VoipPermissionHelper;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.VoipCallListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0005H\u0016¨\u0006\u0012"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/page/CallingPageController;", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/page/ACallPageController;", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallListener;", "()V", "bindController", "", "fragment", "Landroidx/fragment/app/Fragment;", "rootView", "Landroid/view/View;", "voipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "getLogTag", "", "notifyPageStateChange", "newState", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipCallPageState;", "onHangUpClick", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.CallingPageController */
/* compiled from: CallingPageController.kt */
public final class CallingPageController extends ACallPageController implements VoipCallListener {

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 13})
    /* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.CallingPageController$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CallState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CallState.OUTGOING_CALL.ordinal()] = 1;
            $EnumSwitchMapping$0[CallState.OUTGOING_CALL_WAITING.ordinal()] = 2;
            $EnumSwitchMapping$0[CallState.IN_CALL.ordinal()] = 3;
            int[] iArr2 = new int[VoipCallPageState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[VoipCallPageState.INITIALED.ordinal()] = 1;
            $EnumSwitchMapping$1[VoipCallPageState.OUTGOING_CALLING.ordinal()] = 2;
            $EnumSwitchMapping$1[VoipCallPageState.OUTGOING_CALLING_WAITING.ordinal()] = 3;
            $EnumSwitchMapping$1[VoipCallPageState.IN_CALL.ordinal()] = 4;
        }
    }

    /* access modifiers changed from: protected */
    public String getLogTag() {
        return "CallerUiController";
    }

    public void bindController(Fragment fragment, View view, VoipAudioCall voipAudioCall) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        super.bindController(fragment, view, voipAudioCall);
        VoipPermissionHelper.INSTANCE.checkAudioPermission(fragment.getActivity(), new CallingPageController$bindController$1(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHangUpClick() {
        /*
            r5 = this;
            java.lang.String r0 = r5.getTAG()
            java.lang.String r1 = "[User click] - onHangUpClick"
            com.didichuxing.comp.telecom.core.CallLogUtil.logI(r0, r1)
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r0 = r5.getMCurCall()
            r1 = 0
            if (r0 == 0) goto L_0x0015
            com.didichuxing.comp.telecom.core.CallState r0 = r0.getState()
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 != 0) goto L_0x0019
            goto L_0x002a
        L_0x0019:
            int[] r2 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.page.CallingPageController.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r2[r0]
            r2 = 1
            if (r0 == r2) goto L_0x0055
            r2 = 2
            if (r0 == r2) goto L_0x0055
            r2 = 3
            if (r0 == r2) goto L_0x0034
        L_0x002a:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r0 = r5.getMCurCall()
            if (r0 == 0) goto L_0x0075
            r0.hangUp()
            goto L_0x0075
        L_0x0034:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r0 = r5.getMCurCall()
            if (r0 == 0) goto L_0x003d
            r0.hangUp()
        L_0x003d:
            com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper r0 = com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper.INSTANCE
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r2 = r5.getMVoipModel()
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r3 = r5.getMCurCall()
            if (r3 == 0) goto L_0x004e
            com.didichuxing.comp.telecom.core.CallRole r3 = r3.getRole()
            goto L_0x004f
        L_0x004e:
            r3 = r1
        L_0x004f:
            java.lang.String r4 = "stopcall"
            r0.tickVoipSteps(r4, r2, r3)
            goto L_0x0075
        L_0x0055:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r0 = r5.getMCurCall()
            if (r0 == 0) goto L_0x005e
            r0.cancelMakeCall()
        L_0x005e:
            com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper r0 = com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper.INSTANCE
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r2 = r5.getMVoipModel()
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r3 = r5.getMCurCall()
            if (r3 == 0) goto L_0x006f
            com.didichuxing.comp.telecom.core.CallRole r3 = r3.getRole()
            goto L_0x0070
        L_0x006f:
            r3 = r1
        L_0x0070:
            java.lang.String r4 = "cf_hang_up"
            r0.tickUserActions(r4, r2, r3)
        L_0x0075:
            com.didichuxing.comp.telecom.core.CallManagerAssist r0 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r2 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r0 = r0.getConfig()
            if (r0 == 0) goto L_0x00b3
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallEventTickHandler r0 = r0.getEventTickHandler()
            if (r0 == 0) goto L_0x00b3
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState r2 = r5.getMUiState()
            java.lang.String r2 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toStr(r2)
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r3 = r5.getMCurCall()
            if (r3 == 0) goto L_0x00a3
            com.didichuxing.comp.telecom.core.CallRole r3 = r3.getRole()
            if (r3 == 0) goto L_0x00a3
            java.lang.String r3 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r3)
            goto L_0x00a4
        L_0x00a3:
            r3 = r1
        L_0x00a4:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r4 = r5.getMCurCall()
            if (r4 == 0) goto L_0x00ae
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r1 = r4.getModel()
        L_0x00ae:
            java.lang.String r4 = "HangUp"
            r0.onCallPageBtnClick(r4, r2, r3, r1)
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.p176ui.voipcall.page.CallingPageController.onHangUpClick():void");
    }

    /* access modifiers changed from: protected */
    public void notifyPageStateChange(VoipCallPageState voipCallPageState) {
        Intrinsics.checkParameterIsNotNull(voipCallPageState, "newState");
        super.notifyPageStateChange(voipCallPageState);
        int i = WhenMappings.$EnumSwitchMapping$1[voipCallPageState.ordinal()];
        if (i == 1) {
            resetUiInitialed();
        } else if (i == 2 || i == 3) {
            changeDeviceOptionState(false);
            changeHangUpState(true);
            changeAnswerState(false);
        } else if (i == 4) {
            changeDeviceOptionState(true);
            changeHangUpState(true);
            changeAnswerState(false);
        }
    }
}
