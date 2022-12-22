package com.didi.component.framework.pages.invitation.view;

import com.didi.component.core.IView;
import com.didi.component.framework.pages.invitation.model.InviteContactInfo;
import com.didi.component.framework.pages.invitation.presenter.InvitationContactsPresenter;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u0004H&J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0004H&J\b\u0010\u0013\u001a\u00020\u0004H&¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/view/IInvitationContactsView;", "Lcom/didi/component/core/IView;", "Lcom/didi/component/framework/pages/invitation/presenter/InvitationContactsPresenter;", "hideLoadingView", "", "refreRecView", "data", "", "Lcom/didi/component/framework/pages/invitation/model/InviteContactInfo;", "setMaxRewardAndValidFriend", "maxReward", "", "validFriends", "showDefalutView", "showErrorDialog", "msg", "", "title", "showLoadingTips", "showLoadingView", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IInvitationContactsView.kt */
public interface IInvitationContactsView extends IView<InvitationContactsPresenter> {
    void hideLoadingView();

    void refreRecView(List<InviteContactInfo> list);

    void setMaxRewardAndValidFriend(int i, int i2);

    void showDefalutView();

    void showErrorDialog(String str, String str2);

    void showLoadingTips();

    void showLoadingView();

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IInvitationContactsView.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void showErrorDialog$default(IInvitationContactsView iInvitationContactsView, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = "";
                }
                iInvitationContactsView.showErrorDialog(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorDialog");
        }
    }
}
