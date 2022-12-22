package com.didi.component.framework.pages.invitation.view;

import com.didi.component.core.IView;
import com.didi.component.framework.pages.invitation.item.TrackItem;
import com.didi.component.framework.pages.invitation.presenter.InvitationTrackPresenter;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\b\u0010\b\u001a\u00020\u0004H&J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\n"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/view/IInvitationTrackView;", "Lcom/didi/component/core/IView;", "Lcom/didi/component/framework/pages/invitation/presenter/InvitationTrackPresenter;", "initRecyclerView", "", "list", "", "Lcom/didi/component/framework/pages/invitation/item/TrackItem;", "loadFailure", "updateContactsList", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IInvitationTrackView.kt */
public interface IInvitationTrackView extends IView<InvitationTrackPresenter> {
    void initRecyclerView(List<TrackItem> list);

    void loadFailure();

    void updateContactsList(List<TrackItem> list);
}
