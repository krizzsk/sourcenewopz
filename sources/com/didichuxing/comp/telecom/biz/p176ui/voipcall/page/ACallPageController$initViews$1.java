package com.didichuxing.comp.telecom.biz.p176ui.voipcall.page;

import androidx.fragment.app.Fragment;
import com.didichuxing.comp.telecom.biz.p176ui.view.DebounceClickListener;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didichuxing/comp/telecom/biz/ui/voipcall/page/ACallPageController$initViews$1", "Lcom/didichuxing/comp/telecom/biz/ui/view/DebounceClickListener;", "onBtnClick", "", "v", "Landroid/view/View;", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$1 */
/* compiled from: ACallPageController.kt */
public final class ACallPageController$initViews$1 extends DebounceClickListener {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ ACallPageController this$0;

    ACallPageController$initViews$1(ACallPageController aCallPageController, Fragment fragment) {
        this.this$0 = aCallPageController;
        this.$fragment = fragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
        r5 = r5.getRole();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBtnClick(android.view.View r12) {
        /*
            r11 = this;
            java.lang.String r0 = "v"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r0)
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController r0 = r11.this$0
            androidx.fragment.app.Fragment r0 = r0.getMFragment()
            if (r0 == 0) goto L_0x00ef
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            if (r0 == 0) goto L_0x00ef
            java.lang.String r1 = "mFragment?.activity ?: return"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            com.didichuxing.comp.telecom.core.CallManagerAssist r1 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r2 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r1 = r1.getConfig()
            r3 = 0
            if (r1 == 0) goto L_0x005d
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallEventTickHandler r1 = r1.getEventTickHandler()
            if (r1 == 0) goto L_0x005d
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController r4 = r11.this$0
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState r4 = r4.getMUiState()
            java.lang.String r4 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toStr(r4)
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController r5 = r11.this$0
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r5 = r5.getMCurCall()
            if (r5 == 0) goto L_0x004b
            com.didichuxing.comp.telecom.core.CallRole r5 = r5.getRole()
            if (r5 == 0) goto L_0x004b
            java.lang.String r5 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r5)
            goto L_0x004c
        L_0x004b:
            r5 = r3
        L_0x004c:
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController r6 = r11.this$0
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r6 = r6.getMCurCall()
            if (r6 == 0) goto L_0x0059
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r6 = r6.getModel()
            goto L_0x005a
        L_0x0059:
            r6 = r3
        L_0x005a:
            r1.onCollapseClick(r4, r5, r6)
        L_0x005d:
            com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.FloatWindowUtils r1 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.FloatWindowUtils.INSTANCE
            android.content.Context r12 = r12.getContext()
            boolean r12 = r1.hasFloatWindowPermission(r12)
            if (r12 == 0) goto L_0x006e
            r0.finish()
            goto L_0x00ef
        L_0x006e:
            com.didichuxing.comp.telecom.core.CallManagerAssist r12 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r2)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r12 = r12.getConfig()
            if (r12 == 0) goto L_0x00ae
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallEventTickHandler r12 = r12.getEventTickHandler()
            if (r12 == 0) goto L_0x00ae
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController r1 = r11.this$0
            com.didichuxing.comp.telecom.biz.ui.voipcall.VoipCallPageState r1 = r1.getMUiState()
            java.lang.String r1 = com.didichuxing.comp.telecom.biz.p176ui.voipcall.VoipCallPageStateKt.toStr(r1)
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController r2 = r11.this$0
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r2 = r2.getMCurCall()
            if (r2 == 0) goto L_0x009e
            com.didichuxing.comp.telecom.core.CallRole r2 = r2.getRole()
            if (r2 == 0) goto L_0x009e
            java.lang.String r2 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r2)
            goto L_0x009f
        L_0x009e:
            r2 = r3
        L_0x009f:
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController r4 = r11.this$0
            com.didichuxing.comp.telecom.core.voip.VoipAudioCall r4 = r4.getMCurCall()
            if (r4 == 0) goto L_0x00ab
            com.didichuxing.comp.telecom.core.voip.VoipCallModel r3 = r4.getModel()
        L_0x00ab:
            r12.onRequestFloatWindowShow(r1, r2, r3)
        L_0x00ae:
            r4 = r0
            android.app.Activity r4 = (android.app.Activity) r4
            r12 = 2131952241(0x7f130271, float:1.954092E38)
            java.lang.String r5 = r0.getString(r12)
            r12 = 2131952239(0x7f13026f, float:1.9540915E38)
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            com.didichuxing.comp.telecom.biz.util.VoipPermissionHelper r3 = com.didichuxing.comp.telecom.biz.util.VoipPermissionHelper.INSTANCE
            r6 = r0
            android.content.Context r6 = (android.content.Context) r6
            java.lang.String r3 = r3.getAppName(r6)
            r1[r2] = r3
            java.lang.String r6 = r0.getString(r12, r1)
            r12 = 2131953088(0x7f1305c0, float:1.9542637E38)
            java.lang.String r7 = r0.getString(r12)
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$1$onBtnClick$1 r12 = new com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$1$onBtnClick$1
            r12.<init>(r11)
            r8 = r12
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r12 = 2131953087(0x7f1305bf, float:1.9542635E38)
            java.lang.String r9 = r0.getString(r12)
            com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$1$onBtnClick$2 r12 = new com.didichuxing.comp.telecom.biz.ui.voipcall.page.ACallPageController$initViews$1$onBtnClick$2
            r12.<init>(r11)
            r10 = r12
            android.view.View$OnClickListener r10 = (android.view.View.OnClickListener) r10
            com.didichuxing.comp.telecom.impl.VoipBusinessImpl.showTipDialog(r4, r5, r6, r7, r8, r9, r10)
        L_0x00ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.biz.p176ui.voipcall.page.ACallPageController$initViews$1.onBtnClick(android.view.View):void");
    }
}
