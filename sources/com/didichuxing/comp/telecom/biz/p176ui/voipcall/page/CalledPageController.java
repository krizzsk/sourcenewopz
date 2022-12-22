package com.didichuxing.comp.telecom.biz.p176ui.voipcall.page;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageState;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt;
import com.didichuxing.comp.telecom.biz.util.VoipPermissionHelper;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallRole;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.CallStateKt;
import com.didichuxing.comp.telecom.core.util.VibrationHelper;
import com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import com.didichuxing.comp.telecom.core.voip.VoipCallListener;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0002¨\u0006\u0019"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/page/CalledPageController;", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/page/ACallPageController;", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallListener;", "()V", "bindController", "", "fragment", "Landroidx/fragment/app/Fragment;", "rootView", "Landroid/view/View;", "voipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "checkPermissionBeforeAnswer", "getLogTag", "", "notifyPageStateChange", "newState", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipCallPageState;", "onAnswerClick", "onBackPressed", "", "onHangUpClick", "onStart", "onStop", "rejectIncomeCall", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.CalledPageController */
/* compiled from: CalledPageController.kt */
public final class CalledPageController extends ACallPageController implements VoipCallListener {

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 13})
    /* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.CalledPageController$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VoipCallPageState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[VoipCallPageState.INITIALED.ordinal()] = 1;
            $EnumSwitchMapping$0[VoipCallPageState.INCOME_RINGING.ordinal()] = 2;
            $EnumSwitchMapping$0[VoipCallPageState.INCOME_CALLING.ordinal()] = 3;
            $EnumSwitchMapping$0[VoipCallPageState.IN_CALL.ordinal()] = 4;
        }
    }

    /* access modifiers changed from: protected */
    public String getLogTag() {
        return "CalleeUiController";
    }

    public void bindController(Fragment fragment, View view, VoipAudioCall voipAudioCall) {
        VoipAudioCall mCurCall;
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        super.bindController(fragment, view, voipAudioCall);
        if ((voipAudioCall != null ? voipAudioCall.getState() : null) == CallState.INITIALED && (mCurCall = getMCurCall()) != null) {
            mCurCall.notifyRinging();
        }
    }

    public void onStart() {
        super.onStart();
        VoipAudioCall mCurCall = getMCurCall();
        CallState state = mCurCall != null ? mCurCall.getState() : null;
        if (state == CallState.INITIALED || state == CallState.INCOME_RINGING) {
            VoipAudioCall mCurCall2 = getMCurCall();
            if (mCurCall2 != null) {
                mCurCall2.playRingCallIncome();
            }
            VibrationHelper.Companion.getInstance().vibrate(true);
            return;
        }
        VibrationHelper.Companion.getInstance().tryStop();
    }

    public void onStop() {
        super.onStop();
        VibrationHelper.Companion.getInstance().tryStop();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002d, code lost:
        r3 = r3.getRole();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAnswerClick() {
        /*
            r6 = this;
            java.lang.String r0 = r6.getTAG()
            java.lang.String r1 = "[User click] - mAnswerBtn"
            com.didichuxing.comp.telecom.core.CallLogUtil.logI(r0, r1)
            com.didichuxing.comp.telecom.core.CallManagerAssist r0 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r1 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r0 = r0.getConfig()
            r1 = 0
            if (r0 == 0) goto L_0x004a
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallEventTickHandler r0 = r0.getEventTickHandler()
            if (r0 == 0) goto L_0x004a
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState r2 = r6.getMUiState()
            java.lang.String r2 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toStr(r2)
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r3 = r6.getMCurCall()
            if (r3 == 0) goto L_0x0038
            com.didichuxing.comp.telecom.core.CallRole r3 = r3.getRole()
            if (r3 == 0) goto L_0x0038
            java.lang.String r3 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r3)
            goto L_0x0039
        L_0x0038:
            r3 = r1
        L_0x0039:
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r4 = r6.getMCurCall()
            if (r4 == 0) goto L_0x0044
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r4 = r4.getModel()
            goto L_0x0045
        L_0x0044:
            r4 = r1
        L_0x0045:
            java.lang.String r5 = "Answer"
            r0.onCallPageBtnClick(r5, r2, r3, r4)
        L_0x004a:
            com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper r0 = com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper.INSTANCE
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r2 = r6.getMVoipModel()
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r3 = r6.getMCurCall()
            if (r3 == 0) goto L_0x005a
            com.didichuxing.comp.telecom.core.CallRole r1 = r3.getRole()
        L_0x005a:
            java.lang.String r3 = "answer"
            r0.tickVoipSteps(r3, r2, r1)
            r6.m33276a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.p176ui.voipcall.page.CalledPageController.onAnswerClick():void");
    }

    /* renamed from: a */
    private final void m33276a() {
        FragmentActivity activity;
        Fragment mFragment = getMFragment();
        if (mFragment != null && (activity = mFragment.getActivity()) != null) {
            Intrinsics.checkExpressionValueIsNotNull(activity, "mFragment?.activity ?: return");
            VoipPermissionHelper.INSTANCE.checkAudioPermission(activity, new CalledPageController$checkPermissionBeforeAnswer$1(this, activity));
        }
    }

    public void onHangUpClick() {
        CallManagerAssist.CallEventTickHandler eventTickHandler;
        CallRole role;
        VoipCallModel voipCallModel = null;
        if (getMUiState() == VoipCallPageState.IN_CALL) {
            CallLogUtil.logI(getTAG(), "[User click] - onHangUpClick - hangUp");
            VoipAudioCall mCurCall = getMCurCall();
            if (mCurCall != null) {
                mCurCall.hangUp();
            }
            AnalyseTickHelper analyseTickHelper = AnalyseTickHelper.INSTANCE;
            VoipCallModel mVoipModel = getMVoipModel();
            VoipAudioCall mCurCall2 = getMCurCall();
            analyseTickHelper.tickVoipSteps(AnalyseTickHelper.STEP_STOPCALL, mVoipModel, mCurCall2 != null ? mCurCall2.getRole() : null);
        } else {
            CallLogUtil.logI(getTAG(), "[User click] - onHangUpClick - reject");
            m33277b();
        }
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config = instance.getConfig();
        if (config != null && (eventTickHandler = config.getEventTickHandler()) != null) {
            String str = VoipCallPageStateKt.toStr(getMUiState());
            VoipAudioCall mCurCall3 = getMCurCall();
            String str2 = (mCurCall3 == null || (role = mCurCall3.getRole()) == null) ? null : CallStateKt.toStr(role);
            VoipAudioCall mCurCall4 = getMCurCall();
            if (mCurCall4 != null) {
                voipCallModel = mCurCall4.getModel();
            }
            eventTickHandler.onCallPageBtnClick("HangUp", str, str2, voipCallModel);
        }
    }

    public boolean onBackPressed() {
        VoipAudioCall mCurCall = getMCurCall();
        CallState state = mCurCall != null ? mCurCall.getState() : null;
        String tag = getTAG();
        CallLogUtil.logI(tag, "[User click] - onBackPressed " + state);
        if (state != CallState.INCOME_RINGING) {
            return false;
        }
        m33277b();
        return true;
    }

    /* access modifiers changed from: protected */
    public void notifyPageStateChange(VoipCallPageState voipCallPageState) {
        Intrinsics.checkParameterIsNotNull(voipCallPageState, "newState");
        super.notifyPageStateChange(voipCallPageState);
        int i = WhenMappings.$EnumSwitchMapping$0[voipCallPageState.ordinal()];
        if (i == 1) {
            resetUiInitialed();
        } else if (i == 2) {
            changeDeviceOptionState(false);
            changeHangUpState(true);
            changeAnswerState(true);
        } else if (i == 3) {
            changeDeviceOptionState(false);
            changeHangUpState(true);
            changeAnswerState(false);
        } else if (i == 4) {
            changeDeviceOptionState(true);
            changeHangUpState(true);
            changeAnswerState(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m33277b() {
        VoipAudioCall mCurCall = getMCurCall();
        if (mCurCall != null) {
            mCurCall.rejectIncomeCall();
        }
        AnalyseTickHelper analyseTickHelper = AnalyseTickHelper.INSTANCE;
        VoipCallModel mVoipModel = getMVoipModel();
        VoipAudioCall mCurCall2 = getMCurCall();
        analyseTickHelper.tickUserActions("reject", mVoipModel, mCurCall2 != null ? mCurCall2.getRole() : null);
    }
}
