package com.didi.component.framework.pages.invitation.fragment;

import com.didi.component.framework.pages.invitation.helper.ICheckInvite;
import com.didi.component.framework.pages.invitation.view.IInvitationContactsView;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/component/framework/pages/invitation/fragment/InvitationContactsFragment$initRecView$1$onClicked$1", "Lcom/didi/component/framework/pages/invitation/helper/ICheckInvite;", "onError", "", "exception", "Ljava/io/IOException;", "onFailure", "errorMsg", "", "onSuccess", "contactsModel", "Lcom/didi/component/framework/pages/invitation/model/InviteContactsModel;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationContactsFragment.kt */
public final class InvitationContactsFragment$initRecView$1$onClicked$1 implements ICheckInvite {
    final /* synthetic */ String $phoneNum;
    final /* synthetic */ InvitationContactsFragment this$0;

    InvitationContactsFragment$initRecView$1$onClicked$1(InvitationContactsFragment invitationContactsFragment, String str) {
        this.this$0 = invitationContactsFragment;
        this.$phoneNum = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r4 = r4.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.didi.component.framework.pages.invitation.model.InviteContactsModel r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0005
        L_0x0003:
            r4 = r0
            goto L_0x0010
        L_0x0005:
            com.didi.component.framework.pages.invitation.model.ContactsData r4 = r4.getData()
            if (r4 != 0) goto L_0x000c
            goto L_0x0003
        L_0x000c:
            java.util.List r4 = r4.getValidPhoneList()
        L_0x0010:
            if (r4 != 0) goto L_0x0014
            r1 = r0
            goto L_0x001c
        L_0x0014:
            int r1 = r4.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x001c:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.intValue()
            if (r1 <= 0) goto L_0x002d
            r1 = 0
            java.lang.Object r4 = r4.get(r1)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0030
        L_0x002d:
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
        L_0x0030:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0054
            com.didi.component.framework.pages.invitation.fragment.InvitationContactsFragment r4 = r3.this$0
            com.didi.component.framework.pages.invitation.fragment.IInvitationListener r1 = r4.f13804b
            if (r1 != 0) goto L_0x0041
            goto L_0x0045
        L_0x0041:
            com.didi.sharesdk.OneKeyShareModel r0 = r1.getSystemShareInfo()
        L_0x0045:
            r4.m9583a((com.didi.sharesdk.OneKeyShareModel) r0)
            com.didi.component.framework.pages.invitation.fragment.InvitationContactsFragment r4 = r3.this$0
            java.lang.String r0 = r3.$phoneNum
            if (r0 != 0) goto L_0x0050
            java.lang.String r0 = "0"
        L_0x0050:
            r4.m9584a((java.lang.String) r0)
            goto L_0x0074
        L_0x0054:
            com.didi.component.framework.pages.invitation.fragment.InvitationContactsFragment r4 = r3.this$0
            android.content.Context r4 = r4.getContext()
            r0 = 2131953148(0x7f1305fc, float:1.9542759E38)
            java.lang.String r4 = com.didi.sdk.util.ResourcesHelper.getString(r4, r0)
            com.didi.component.framework.pages.invitation.fragment.InvitationContactsFragment r0 = r3.this$0
            java.lang.String r1 = "sorryText"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            com.didi.component.framework.pages.invitation.fragment.InvitationContactsFragment$initRecView$1$onClicked$1$onSuccess$1 r1 = new com.didi.component.framework.pages.invitation.fragment.InvitationContactsFragment$initRecView$1$onClicked$1$onSuccess$1
            r1.<init>()
            com.didi.component.framework.pages.invitation.helper.INoInvite r1 = (com.didi.component.framework.pages.invitation.helper.INoInvite) r1
            java.lang.String r2 = ""
            r0.m9585a(r4, r2, r1)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.pages.invitation.fragment.InvitationContactsFragment$initRecView$1$onClicked$1.onSuccess(com.didi.component.framework.pages.invitation.model.InviteContactsModel):void");
    }

    public void onFailure(String str) {
        if (str != null) {
            IInvitationContactsView.DefaultImpls.showErrorDialog$default(this.this$0, str, (String) null, 2, (Object) null);
        }
    }

    public void onError(IOException iOException) {
        InvitationContactsFragment invitationContactsFragment = this.this$0;
        String string = ResourcesHelper.getString(invitationContactsFragment.getContext(), R.string.df_no_net_connected_toast);
        Intrinsics.checkNotNullExpressionValue(string, "getString(context, R.str…f_no_net_connected_toast)");
        IInvitationContactsView.DefaultImpls.showErrorDialog$default(invitationContactsFragment, string, (String) null, 2, (Object) null);
    }
}
