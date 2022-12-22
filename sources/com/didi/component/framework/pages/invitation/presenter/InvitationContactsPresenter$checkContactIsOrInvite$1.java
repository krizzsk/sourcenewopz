package com.didi.component.framework.pages.invitation.presenter;

import com.didi.component.framework.pages.invitation.helper.ICheckInvite;
import com.didi.component.framework.pages.invitation.helper.InvitePageController;
import com.didi.component.framework.pages.invitation.model.InviteContactsModel;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/component/framework/pages/invitation/presenter/InvitationContactsPresenter$checkContactIsOrInvite$1", "Lcom/didi/component/framework/pages/invitation/helper/InvitePageController$CallbackContacts;", "onError", "", "exception", "Ljava/io/IOException;", "onFailure", "errorMsg", "", "onSuccess", "contactsModel", "Lcom/didi/component/framework/pages/invitation/model/InviteContactsModel;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationContactsPresenter.kt */
public final class InvitationContactsPresenter$checkContactIsOrInvite$1 implements InvitePageController.CallbackContacts {
    final /* synthetic */ ICheckInvite $checkListener;

    InvitationContactsPresenter$checkContactIsOrInvite$1(ICheckInvite iCheckInvite) {
        this.$checkListener = iCheckInvite;
    }

    public void onSuccess(InviteContactsModel inviteContactsModel) {
        ICheckInvite iCheckInvite = this.$checkListener;
        if (iCheckInvite != null) {
            iCheckInvite.onSuccess(inviteContactsModel);
        }
    }

    public void onFailure(String str) {
        ICheckInvite iCheckInvite = this.$checkListener;
        if (iCheckInvite != null) {
            iCheckInvite.onFailure(str);
        }
    }

    public void onError(IOException iOException) {
        ICheckInvite iCheckInvite = this.$checkListener;
        if (iCheckInvite != null) {
            iCheckInvite.onError(iOException);
        }
    }
}
