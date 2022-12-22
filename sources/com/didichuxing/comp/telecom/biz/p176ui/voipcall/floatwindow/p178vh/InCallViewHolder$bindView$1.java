package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh;

import com.didichuxing.comp.telecom.biz.p176ui.view.DebounceClickListener;
import com.didichuxing.comp.telecom.core.voip.VoipAudioCall;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/vh/InCallViewHolder$bindView$1", "Lcom/didichuxing/comp/telecom/biz/ui/view/DebounceClickListener;", "onBtnClick", "", "v", "Landroid/view/View;", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.InCallViewHolder$bindView$1 */
/* compiled from: InCallViewHolder.kt */
public final class InCallViewHolder$bindView$1 extends DebounceClickListener {
    final /* synthetic */ VoipAudioCall $voipCall;
    final /* synthetic */ InCallViewHolder this$0;

    InCallViewHolder$bindView$1(InCallViewHolder inCallViewHolder, VoipAudioCall voipAudioCall) {
        this.this$0 = inCallViewHolder;
        this.$voipCall = voipAudioCall;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0034, code lost:
        r1 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toUiState((r1 = r1.getState()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBtnClick(android.view.View r6) {
        /*
            r5 = this;
            java.lang.String r0 = "v"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.InCallViewHolder r0 = r5.this$0
            java.lang.String r0 = r0.getTAG()
            java.lang.String r1 = "[User click] - openPage"
            com.didichuxing.comp.telecom.core.CallLogUtil.logI(r0, r1)
            com.didichuxing.comp.telecom.core.CallManagerAssist r0 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r1 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r0 = r0.getConfig()
            if (r0 == 0) goto L_0x0063
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallEventTickHandler r0 = r0.getEventTickHandler()
            if (r0 == 0) goto L_0x0063
            com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.InCallViewHolder r1 = r5.this$0
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r1 = r1.getMCurCall()
            r2 = 0
            if (r1 == 0) goto L_0x003f
            com.didichuxing.comp.telecom.core.CallState r1 = r1.getState()
            if (r1 == 0) goto L_0x003f
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState r1 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toUiState(r1)
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toStr(r1)
            goto L_0x0040
        L_0x003f:
            r1 = r2
        L_0x0040:
            com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.InCallViewHolder r3 = r5.this$0
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r3 = r3.getMCurCall()
            if (r3 == 0) goto L_0x0053
            com.didichuxing.comp.telecom.core.CallRole r3 = r3.getRole()
            if (r3 == 0) goto L_0x0053
            java.lang.String r3 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r3)
            goto L_0x0054
        L_0x0053:
            r3 = r2
        L_0x0054:
            com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.vh.InCallViewHolder r4 = r5.this$0
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r4 = r4.getMCurCall()
            if (r4 == 0) goto L_0x0060
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r2 = r4.getModel()
        L_0x0060:
            r0.onFloatWindowClick(r1, r3, r2)
        L_0x0063:
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipBusinessActivity$Companion r0 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipBusinessActivity.Companion
            android.content.Context r6 = r6.getContext()
            java.lang.String r1 = "v.context"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r1 = r5.$voipCall
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r1 = r1.getVoipCallModel()
            r2 = 1
            r0.openPage(r6, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.p178vh.InCallViewHolder$bindView$1.onBtnClick(android.view.View):void");
    }
}
