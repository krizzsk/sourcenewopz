package com.didi.component.framework.pages.invitation.fragment;

import com.didi.component.framework.pages.invitation.helper.INoInvite;
import com.didi.component.framework.pages.invitation.model.InviteListModel;
import com.didi.component.framework.pages.invitation.model.InviteTheme;
import com.didi.component.framework.pages.invitation.model.PageData;
import com.didi.sharesdk.OneKeyShareModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H&J\u001a\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0017H&J\b\u0010\u001b\u001a\u00020\u0011H&J$\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0017H&J \u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0003H&¨\u0006%"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/fragment/IInvitationListener;", "", "canLoadMore", "", "currentCount", "", "checkContactsPermission", "getListInfo", "Lcom/didi/component/framework/pages/invitation/model/InviteListModel;", "getPageInfo", "Lcom/didi/component/framework/pages/invitation/model/PageData;", "getSystemShareInfo", "Lcom/didi/sharesdk/OneKeyShareModel;", "getThemeInfo", "Lcom/didi/component/framework/pages/invitation/model/InviteTheme;", "hasRewards", "hideLoadingView", "", "isGlobal", "setSystemShareInfo", "shareInfo", "setTitlteBar", "text", "", "showErrorDialog", "msg", "title", "showLoadingView", "showNoInvitationDialog", "listener", "Lcom/didi/component/framework/pages/invitation/helper/INoInvite;", "switchToTargetPage", "tag", "updateContactsList", "isTop", "currentPage", "isLoadingMore", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IInvitationListener.kt */
public interface IInvitationListener {
    boolean canLoadMore(long j);

    boolean checkContactsPermission();

    InviteListModel getListInfo();

    PageData getPageInfo();

    OneKeyShareModel getSystemShareInfo();

    InviteTheme getThemeInfo();

    boolean hasRewards();

    void hideLoadingView();

    boolean isGlobal();

    void setSystemShareInfo(OneKeyShareModel oneKeyShareModel);

    void setTitlteBar(String str);

    void showErrorDialog(String str, String str2);

    void showLoadingView();

    void showNoInvitationDialog(String str, String str2, INoInvite iNoInvite);

    void switchToTargetPage(String str);

    void updateContactsList(boolean z, long j, boolean z2);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IInvitationListener.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void showErrorDialog$default(IInvitationListener iInvitationListener, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = "";
                }
                iInvitationListener.showErrorDialog(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorDialog");
        }

        public static /* synthetic */ void showNoInvitationDialog$default(IInvitationListener iInvitationListener, String str, String str2, INoInvite iNoInvite, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = "";
                }
                iInvitationListener.showNoInvitationDialog(str, str2, iNoInvite);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNoInvitationDialog");
        }
    }
}
