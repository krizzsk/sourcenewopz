package com.didi.component.framework.pages.invitation;

import android.os.SystemClock;
import com.didi.component.framework.pages.invitation.fragment.IInvitationListener;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.component.framework.pages.invitation.helper.InvitePageController;
import com.didi.component.framework.pages.invitation.model.InviteListModel;
import com.didi.component.framework.pages.invitation.model.ListData;
import com.didi.component.framework.pages.invitation.model.RefererRelationTotalVo;
import com.didi.component.framework.pages.invitation.model.RefererRelationVo;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/component/framework/pages/invitation/InvitationPageActivity$refreshAndGetList$1", "Lcom/didi/component/framework/pages/invitation/helper/InvitePageController$CallbackList;", "onError", "", "exception", "Ljava/io/IOException;", "onFailure", "errorMsg", "", "onSuccess", "listModel", "Lcom/didi/component/framework/pages/invitation/model/InviteListModel;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InvitationPageActivity.kt */
public final class InvitationPageActivity$refreshAndGetList$1 implements InvitePageController.CallbackList {
    final /* synthetic */ boolean $isLoadingMore;
    final /* synthetic */ boolean $isTop;
    final /* synthetic */ long $last;
    final /* synthetic */ InvitationPageActivity this$0;

    InvitationPageActivity$refreshAndGetList$1(InvitationPageActivity invitationPageActivity, boolean z, boolean z2, long j) {
        this.this$0 = invitationPageActivity;
        this.$isTop = z;
        this.$isLoadingMore = z2;
        this.$last = j;
    }

    public void onSuccess(InviteListModel inviteListModel) {
        ListData data;
        RefererRelationTotalVo refererRelationTotalVo;
        ListData data2;
        Long total;
        InvitationPageActivity invitationPageActivity = this.this$0;
        long j = 0;
        if (!(inviteListModel == null || (data2 = inviteListModel.getData()) == null || (total = data2.getTotal()) == null)) {
            j = total.longValue();
        }
        invitationPageActivity.f13787f = j;
        List<RefererRelationVo> list = null;
        if (!(inviteListModel == null || (data = inviteListModel.getData()) == null || (refererRelationTotalVo = data.getRefererRelationTotalVo()) == null)) {
            list = refererRelationTotalVo.getRefererRelationVos();
        }
        boolean z = true;
        if (this.$isTop && !this.$isLoadingMore) {
            this.this$0.f13801t = inviteListModel;
            this.this$0.m9565a(this.$isTop);
            this.this$0.m9562a(SystemClock.elapsedRealtime() - this.this$0.f13794m, 1);
        }
        if (!this.$isTop && !this.$isLoadingMore) {
            this.this$0.hideLoadingView();
            EventBus.getDefault().post(list);
            this.this$0.m9562a(SystemClock.elapsedRealtime() - this.$last, 2);
        }
        if (this.$isLoadingMore) {
            Collection collection = list;
            if (collection != null && !collection.isEmpty()) {
                z = false;
            }
            if (!z) {
                EventBus.getDefault().post(list);
            }
        }
    }

    public void onFailure(String str) {
        this.this$0.hideLoadingView();
        IInvitationListener iInvitationListener = this.this$0;
        if (str == null) {
            str = "";
        }
        IInvitationListener.DefaultImpls.showErrorDialog$default(iInvitationListener, str, (String) null, 2, (Object) null);
        EventBus.getDefault().post(InvitationTrackFragment.LOAD_FAILURE);
    }

    public void onError(IOException iOException) {
        this.this$0.hideLoadingView();
        if (this.$isTop) {
            this.this$0.m9578l();
            return;
        }
        InvitationPageActivity invitationPageActivity = this.this$0;
        String string = ResourcesHelper.getString(invitationPageActivity, R.string.df_no_net_connected_toast);
        Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …                        )");
        IInvitationListener.DefaultImpls.showErrorDialog$default(invitationPageActivity, string, (String) null, 2, (Object) null);
        EventBus.getDefault().post(InvitationTrackFragment.LOAD_FAILURE);
    }
}
