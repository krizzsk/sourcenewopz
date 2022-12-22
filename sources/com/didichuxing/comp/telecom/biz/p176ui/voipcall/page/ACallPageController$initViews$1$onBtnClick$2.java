package com.didichuxing.comp.telecom.biz.p176ui.voipcall.page;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$1$onBtnClick$2 */
/* compiled from: ACallPageController.kt */
final class ACallPageController$initViews$1$onBtnClick$2 implements View.OnClickListener {
    final /* synthetic */ ACallPageController$initViews$1 this$0;

    ACallPageController$initViews$1$onBtnClick$2(ACallPageController$initViews$1 aCallPageController$initViews$1) {
        this.this$0 = aCallPageController$initViews$1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003a, code lost:
        r2 = r2.getRole();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r6) {
        /*
            r5 = this;
            com.didi.autotracker.AutoTrackHelper.trackViewOnClick(r6)
            r6 = 2131952244(0x7f130274, float:1.9540925E38)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            com.didichuxing.comp.telecom.core.CallToastUtil.makeToast((java.lang.Integer) r6)
            com.didichuxing.comp.telecom.core.CallManagerAssist r6 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r0 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r0)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r6 = r6.getConfig()
            if (r6 == 0) goto L_0x0057
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallEventTickHandler r6 = r6.getEventTickHandler()
            if (r6 == 0) goto L_0x0057
            r0 = 0
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$1 r1 = r5.this$0
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController r1 = r1.this$0
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState r1 = r1.getMUiState()
            java.lang.String r1 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toStr(r1)
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$1 r2 = r5.this$0
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController r2 = r2.this$0
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r2 = r2.getMCurCall()
            r3 = 0
            if (r2 == 0) goto L_0x0045
            com.didichuxing.comp.telecom.core.CallRole r2 = r2.getRole()
            if (r2 == 0) goto L_0x0045
            java.lang.String r2 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r2)
            goto L_0x0046
        L_0x0045:
            r2 = r3
        L_0x0046:
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$1 r4 = r5.this$0
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController r4 = r4.this$0
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r4 = r4.getMCurCall()
            if (r4 == 0) goto L_0x0054
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r3 = r4.getModel()
        L_0x0054:
            r6.onRequestFloatWindowClick(r0, r1, r2, r3)
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.p176ui.voipcall.page.ACallPageController$initViews$1$onBtnClick$2.onClick(android.view.View):void");
    }
}
