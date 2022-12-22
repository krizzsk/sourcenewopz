package com.didi.component.framework.pages.invitation;

import com.didi.component.common.util.GLog;
import com.didi.component.framework.pages.invitation.fragment.IInvitationListener;
import com.didi.component.framework.pages.invitation.helper.InvitePageController;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, mo175978d2 = {"com/didi/component/framework/pages/invitation/InvitationPageActivity$initRecommendInfo$1", "Lcom/didi/component/framework/pages/invitation/helper/InvitePageController$CallbackPage;", "onError", "", "exception", "Ljava/io/IOException;", "onFailure", "errorMsg", "", "onSuccess", "pageData", "Lcom/didi/component/framework/pages/invitation/model/PageData;", "themeData", "Lcom/didi/component/framework/pages/invitation/model/InviteTheme;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationPageActivity.kt */
public final class InvitationPageActivity$initRecommendInfo$1 implements InvitePageController.CallbackPage {
    final /* synthetic */ InvitationPageActivity this$0;

    InvitationPageActivity$initRecommendInfo$1(InvitationPageActivity invitationPageActivity) {
        this.this$0 = invitationPageActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
        r0 = r0.getRedirectModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didi.component.framework.pages.invitation.model.PageData r6, com.didi.component.framework.pages.invitation.model.InviteTheme r7) {
        /*
            r5 = this;
            com.didi.component.framework.pages.invitation.InvitationPageActivity r0 = r5.this$0
            r0.f13788g = r6
            com.didi.component.framework.pages.invitation.InvitationPageActivity r0 = r5.this$0
            r0.f13789h = r7
            com.didi.component.framework.pages.invitation.InvitationPageActivity r7 = r5.this$0
            com.didi.component.framework.pages.invitation.model.PageData r0 = r7.f13788g
            r1 = 0
            if (r0 != 0) goto L_0x0015
        L_0x0013:
            r0 = r1
            goto L_0x0020
        L_0x0015:
            com.didi.component.framework.pages.invitation.model.RedirectModel r0 = r0.getRedirectModel()
            if (r0 != 0) goto L_0x001c
            goto L_0x0013
        L_0x001c:
            java.lang.String r0 = r0.getCanonicalCountryCode()
        L_0x0020:
            if (r0 != 0) goto L_0x0028
            com.didi.component.framework.pages.invitation.InvitationPageActivity r0 = r5.this$0
            java.lang.String r0 = r0.f13785d
        L_0x0028:
            r7.f13785d = r0
            com.didi.component.framework.pages.invitation.InvitationPageActivity r7 = r5.this$0
            com.didi.component.framework.pages.invitation.model.PageData r0 = r7.f13788g
            if (r0 != 0) goto L_0x0035
        L_0x0033:
            r0 = r1
            goto L_0x0047
        L_0x0035:
            com.didi.component.framework.pages.invitation.model.RedirectModel r0 = r0.getRedirectModel()
            if (r0 != 0) goto L_0x003c
            goto L_0x0033
        L_0x003c:
            com.didi.component.framework.pages.invitation.model.AreaVo r0 = r0.getAreaVo()
            if (r0 != 0) goto L_0x0043
            goto L_0x0033
        L_0x0043:
            java.lang.String r0 = r0.getCityId()
        L_0x0047:
            if (r0 != 0) goto L_0x004f
            com.didi.component.framework.pages.invitation.InvitationPageActivity r0 = r5.this$0
            java.lang.String r0 = r0.f13786e
        L_0x004f:
            r7.f13786e = r0
            com.didi.component.framework.pages.invitation.InvitationPageActivity r7 = r5.this$0
            if (r6 != 0) goto L_0x0057
            goto L_0x005b
        L_0x0057:
            java.util.HashMap r1 = r6.getLogParams()
        L_0x005b:
            if (r1 != 0) goto L_0x0063
            com.didi.component.framework.pages.invitation.InvitationPageActivity r0 = r5.this$0
            java.util.HashMap r1 = r0.f13795n
        L_0x0063:
            r7.f13795n = r1
            com.didi.component.framework.pages.invitation.InvitationPageActivity r7 = r5.this$0
            com.didi.component.framework.pages.invitation.model.PageData r7 = r7.f13788g
            java.lang.String r0 = "0"
            if (r7 != 0) goto L_0x0071
            goto L_0x0080
        L_0x0071:
            com.didi.component.framework.pages.invitation.model.RewardModel r7 = r7.getRewardModel()
            if (r7 != 0) goto L_0x0078
            goto L_0x0080
        L_0x0078:
            java.lang.String r7 = r7.getTotalAmountFormat()
            if (r7 != 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r0 = r7
        L_0x0080:
            kotlin.text.Regex r7 = new kotlin.text.Regex
            java.lang.String r1 = "[1-9]+"
            r7.<init>((java.lang.String) r1)
            com.didi.component.framework.pages.invitation.InvitationPageActivity r1 = r5.this$0
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r7 = r7.containsMatchIn(r0)
            r1.f13793l = r7
            com.didi.component.framework.pages.invitation.InvitationPageActivity r7 = r5.this$0
            com.didi.component.framework.pages.invitation.model.PageData r0 = r7.f13788g
            r1 = 0
            if (r0 != 0) goto L_0x009e
        L_0x009c:
            r3 = r1
            goto L_0x00b0
        L_0x009e:
            com.didi.component.framework.pages.invitation.model.RedirectModel r0 = r0.getRedirectModel()
            if (r0 != 0) goto L_0x00a5
            goto L_0x009c
        L_0x00a5:
            java.lang.Long r0 = r0.getActivityId()
            if (r0 != 0) goto L_0x00ac
            goto L_0x009c
        L_0x00ac:
            long r3 = r0.longValue()
        L_0x00b0:
            r7.f13791j = r3
            com.didi.component.framework.pages.invitation.InvitationPageActivity r7 = r5.this$0
            r0 = 0
            if (r6 != 0) goto L_0x00ba
        L_0x00b8:
            r3 = 0
            goto L_0x00cc
        L_0x00ba:
            com.didi.component.framework.pages.invitation.model.ExperimentControl r3 = r6.getExperimentControl()
            if (r3 != 0) goto L_0x00c1
            goto L_0x00b8
        L_0x00c1:
            java.lang.Integer r3 = r3.isNewPage()
            if (r3 != 0) goto L_0x00c8
            goto L_0x00b8
        L_0x00c8:
            int r3 = r3.intValue()
        L_0x00cc:
            r4 = 1
            if (r3 != r4) goto L_0x00d1
            r3 = 1
            goto L_0x00d2
        L_0x00d1:
            r3 = 0
        L_0x00d2:
            r7.f13796o = r3
            com.didi.component.framework.pages.invitation.InvitationPageActivity r7 = r5.this$0
            if (r6 != 0) goto L_0x00db
        L_0x00d9:
            r3 = 0
            goto L_0x00ed
        L_0x00db:
            com.didi.component.framework.pages.invitation.model.ExperimentControl r3 = r6.getExperimentControl()
            if (r3 != 0) goto L_0x00e2
            goto L_0x00d9
        L_0x00e2:
            java.lang.Integer r3 = r3.isLunbo()
            if (r3 != 0) goto L_0x00e9
            goto L_0x00d9
        L_0x00e9:
            int r3 = r3.intValue()
        L_0x00ed:
            if (r3 != r4) goto L_0x00f1
            r3 = 1
            goto L_0x00f2
        L_0x00f1:
            r3 = 0
        L_0x00f2:
            r7.f13797p = r3
            com.didi.component.framework.pages.invitation.InvitationPageActivity r7 = r5.this$0
            if (r6 != 0) goto L_0x00fb
        L_0x00f9:
            r6 = 0
            goto L_0x010d
        L_0x00fb:
            com.didi.component.framework.pages.invitation.model.ExperimentControl r6 = r6.getExperimentControl()
            if (r6 != 0) goto L_0x0102
            goto L_0x00f9
        L_0x0102:
            java.lang.Integer r6 = r6.isShareContact()
            if (r6 != 0) goto L_0x0109
            goto L_0x00f9
        L_0x0109:
            int r6 = r6.intValue()
        L_0x010d:
            if (r6 != r4) goto L_0x0111
            r6 = 1
            goto L_0x0112
        L_0x0111:
            r6 = 0
        L_0x0112:
            r7.f13798q = r6
            com.didi.component.framework.pages.invitation.InvitationPageActivity r6 = r5.this$0
            long r6 = r6.f13791j
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0135
            com.didi.component.framework.pages.invitation.InvitationPageActivity r6 = r5.this$0
            r6.m9575i()
            long r6 = android.os.SystemClock.elapsedRealtime()
            com.didi.component.framework.pages.invitation.InvitationPageActivity r0 = r5.this$0
            long r0 = r0.f13794m
            long r6 = r6 - r0
            com.didi.component.framework.pages.invitation.InvitationPageActivity r0 = r5.this$0
            r0.m9562a((long) r6, (int) r4)
            goto L_0x016a
        L_0x0135:
            com.didi.component.framework.pages.invitation.InvitationPageActivity r6 = r5.this$0
            boolean r6 = r6.f13793l
            if (r6 == 0) goto L_0x0145
            com.didi.component.framework.pages.invitation.InvitationPageActivity r6 = r5.this$0
            r1 = 1
            r6.m9566a(r4, r1, r0)
            goto L_0x016a
        L_0x0145:
            com.didi.component.framework.pages.invitation.InvitationPageActivity r6 = r5.this$0
            boolean r6 = r6.f13796o
            if (r6 == 0) goto L_0x0153
            com.didi.component.framework.pages.invitation.InvitationPageActivity r6 = r5.this$0
            r6.m9565a((boolean) r4)
            goto L_0x015a
        L_0x0153:
            com.didi.component.framework.pages.invitation.InvitationPageActivity r6 = r5.this$0
            java.lang.String r7 = "blank"
            r6.switchToTargetPage(r7)
        L_0x015a:
            long r6 = android.os.SystemClock.elapsedRealtime()
            com.didi.component.framework.pages.invitation.InvitationPageActivity r0 = r5.this$0
            long r0 = r0.f13794m
            long r6 = r6 - r0
            com.didi.component.framework.pages.invitation.InvitationPageActivity r0 = r5.this$0
            r0.m9562a((long) r6, (int) r4)
        L_0x016a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.InvitationPageActivity$initRecommendInfo$1.onSuccess(com.didi.component.framework.pages.invitation.model.PageData, com.didi.component.framework.pages.invitation.model.InviteTheme):void");
    }

    public void onFailure(String str) {
        this.this$0.hideLoadingView();
        IInvitationListener iInvitationListener = this.this$0;
        if (str == null) {
            str = "";
        }
        IInvitationListener.DefaultImpls.showErrorDialog$default(iInvitationListener, str, (String) null, 2, (Object) null);
    }

    public void onError(IOException iOException) {
        this.this$0.hideLoadingView();
        this.this$0.m9578l();
        GLog.m7969e(InvitationPageActivity.TAG, "InvitationPageActivity.initRecommendInfo()", iOException);
    }
}
