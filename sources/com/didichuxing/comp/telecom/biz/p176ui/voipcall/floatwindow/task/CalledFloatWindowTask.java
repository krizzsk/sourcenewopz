package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.task;

import android.content.Context;
import android.view.WindowManager;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageState;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.CallFloatWindowLayoutParams;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh.ACallFloatViewHolder;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh.InCallViewHolder;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh.IncomeCallViewHolder;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallState;
import com.didichuxing.comp.telecom.core.CallStateKt;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/task/CalledFloatWindowTask;", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/task/ACallFloatWindowTask;", "voipCall", "Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;", "(Lcom/didichuxing/comp/telecom/core/voip/VoipAudioCall;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mUiState", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/VoipCallPageState;", "innerShow", "", "state", "Lcom/didichuxing/comp/telecom/core/CallState;", "showIncallView", "showIncomecallView", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.task.CalledFloatWindowTask */
/* compiled from: CalledFloatWindowTask.kt */
public final class CalledFloatWindowTask extends ACallFloatWindowTask {

    /* renamed from: a */
    private final String f46338a = "CalledFloatWindowTask";

    /* renamed from: b */
    private VoipCallPageState f46339b = VoipCallPageState.INITIALED;

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 13})
    /* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.task.CalledFloatWindowTask$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VoipCallPageState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[VoipCallPageState.INCOME_RINGING.ordinal()] = 1;
            $EnumSwitchMapping$0[VoipCallPageState.INCOME_CALLING.ordinal()] = 2;
            $EnumSwitchMapping$0[VoipCallPageState.IN_CALL.ordinal()] = 3;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CalledFloatWindowTask(VoipAudioCall voipAudioCall) {
        super(voipAudioCall);
        Intrinsics.checkParameterIsNotNull(voipAudioCall, "voipCall");
    }

    /* access modifiers changed from: protected */
    public String getTAG() {
        return this.f46338a;
    }

    /* access modifiers changed from: protected */
    public void innerShow(CallState callState) {
        CallManagerAssist.CallEventTickHandler eventTickHandler;
        CallManagerAssist.CallEventTickHandler eventTickHandler2;
        Intrinsics.checkParameterIsNotNull(callState, "state");
        super.innerShow(callState);
        VoipCallPageState uiState = VoipCallPageStateKt.toUiState(callState);
        String tag = getTAG();
        CallLogUtil.logI(tag, "innerShow cur:" + this.f46339b + " new:" + uiState);
        if (uiState != null && uiState != this.f46339b) {
            this.f46339b = uiState;
            int i = WhenMappings.$EnumSwitchMapping$0[uiState.ordinal()];
            String str = null;
            if (i == 1) {
                CallManagerAssist instance = CallManagerAssist.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
                CallManagerAssist.CallManagerConfig config = instance.getConfig();
                if (!(config == null || (eventTickHandler = config.getEventTickHandler()) == null)) {
                    VoipCallPageState uiState2 = VoipCallPageStateKt.toUiState(getMVoipCall().getState());
                    if (uiState2 != null) {
                        str = VoipCallPageStateKt.toStr(uiState2);
                    }
                    eventTickHandler.onFloatWindowShow(str, CallStateKt.toStr(getMVoipCall().getRole()), getMVoipCall().getVoipCallModel());
                }
                m33265a();
            } else if (i == 2) {
                m33266b();
            } else if (i == 3) {
                CallManagerAssist instance2 = CallManagerAssist.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(instance2, "CallManagerAssist.getInstance()");
                CallManagerAssist.CallManagerConfig config2 = instance2.getConfig();
                if (!(config2 == null || (eventTickHandler2 = config2.getEventTickHandler()) == null)) {
                    VoipCallPageState uiState3 = VoipCallPageStateKt.toUiState(getMVoipCall().getState());
                    if (uiState3 != null) {
                        str = VoipCallPageStateKt.toStr(uiState3);
                    }
                    eventTickHandler2.onFloatWindowShow(str, CallStateKt.toStr(getMVoipCall().getRole()), getMVoipCall().getVoipCallModel());
                }
                m33266b();
            }
        }
    }

    /* renamed from: a */
    private final void m33265a() {
        CallLogUtil.logI(getTAG(), "showIncomecallView");
        FloatContainerView mFrameLayout = getMFrameLayout();
        if (mFrameLayout != null && checkCurVhUseful(IncomeCallViewHolder.class) == null) {
            Context context = mFrameLayout.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
            ACallFloatViewHolder incomeCallViewHolder = new IncomeCallViewHolder(context);
            incomeCallViewHolder.bindView(getMVoipCall());
            CallFloatWindowLayoutParams callFloatWindowLayoutParams = new CallFloatWindowLayoutParams();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            callFloatWindowLayoutParams.setLp(layoutParams);
            ACallFloatWindowTask.showNewVh$default(this, incomeCallViewHolder, callFloatWindowLayoutParams, false, 4, (Object) null);
        }
    }

    /* renamed from: b */
    private final void m33266b() {
        CallLogUtil.logI(getTAG(), "showIncallView");
        FloatContainerView mFrameLayout = getMFrameLayout();
        if (mFrameLayout != null && checkCurVhUseful(InCallViewHolder.class) == null) {
            Context context = mFrameLayout.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "container.context");
            ACallFloatViewHolder inCallViewHolder = new InCallViewHolder(context);
            inCallViewHolder.bindView(getMVoipCall());
            CallFloatWindowLayoutParams callFloatWindowLayoutParams = new CallFloatWindowLayoutParams();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            callFloatWindowLayoutParams.setLp(layoutParams);
            ACallFloatWindowTask.showNewVh$default(this, inCallViewHolder, callFloatWindowLayoutParams, false, 4, (Object) null);
        }
    }
}
