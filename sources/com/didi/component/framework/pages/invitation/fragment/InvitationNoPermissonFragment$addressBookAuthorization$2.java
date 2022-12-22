package com.didi.component.framework.pages.invitation.fragment;

import com.didi.component.framework.pages.invitation.model.AddressBookAuthorization;
import com.didi.component.framework.pages.invitation.model.PageData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/component/framework/pages/invitation/model/AddressBookAuthorization;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationNoPermissonFragment.kt */
final class InvitationNoPermissonFragment$addressBookAuthorization$2 extends Lambda implements Function0<AddressBookAuthorization> {
    final /* synthetic */ InvitationNoPermissonFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InvitationNoPermissonFragment$addressBookAuthorization$2(InvitationNoPermissonFragment invitationNoPermissonFragment) {
        super(0);
        this.this$0 = invitationNoPermissonFragment;
    }

    public final AddressBookAuthorization invoke() {
        PageData pageInfo;
        IInvitationListener access$getMListener = this.this$0.m9601a();
        if (access$getMListener == null || (pageInfo = access$getMListener.getPageInfo()) == null) {
            return null;
        }
        return pageInfo.getAddressBookAuthorization();
    }
}
