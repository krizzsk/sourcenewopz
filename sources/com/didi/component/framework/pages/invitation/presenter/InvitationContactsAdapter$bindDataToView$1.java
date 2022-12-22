package com.didi.component.framework.pages.invitation.presenter;

import android.view.View;
import com.didi.component.common.util.OnAntiShakeClickListener;
import com.didi.component.framework.pages.invitation.helper.InvitationItemClickedListener;
import com.didi.component.framework.pages.invitation.model.InviteContactInfo;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/component/framework/pages/invitation/presenter/InvitationContactsAdapter$bindDataToView$1", "Lcom/didi/component/common/util/OnAntiShakeClickListener;", "onAntiShakeClick", "", "v", "Landroid/view/View;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationContactsAdapter.kt */
public final class InvitationContactsAdapter$bindDataToView$1 extends OnAntiShakeClickListener {
    final /* synthetic */ InviteContactInfo $item;
    final /* synthetic */ InvitationContactsAdapter this$0;

    InvitationContactsAdapter$bindDataToView$1(InvitationContactsAdapter invitationContactsAdapter, InviteContactInfo inviteContactInfo) {
        this.this$0 = invitationContactsAdapter;
        this.$item = inviteContactInfo;
    }

    public void onAntiShakeClick(View view) {
        InvitationItemClickedListener access$getListener$p = this.this$0.f13912b;
        if (access$getListener$p != null) {
            access$getListener$p.onClicked(view, this.$item.getPhone());
        }
    }
}
