package com.didi.component.framework.pages.invitation.helper;

import com.didi.component.framework.pages.invitation.model.InviteContactsModel;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/helper/ICheckInvite;", "", "onError", "", "exception", "Ljava/io/IOException;", "onFailure", "errorMsg", "", "onSuccess", "contactsModel", "Lcom/didi/component/framework/pages/invitation/model/InviteContactsModel;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ICheckInvite.kt */
public interface ICheckInvite {
    void onError(IOException iOException);

    void onFailure(String str);

    void onSuccess(InviteContactsModel inviteContactsModel);
}
