package com.didi.component.framework.pages.invitation.view;

import android.view.View;
import com.didi.component.core.IView;
import com.didi.component.framework.pages.invitation.item.SwiperItem;
import com.didi.component.framework.pages.invitation.presenter.InvitationHomePresenter;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\b\u0010\u000f\u001a\u00020\tH&J\b\u0010\u0010\u001a\u00020\tH&¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/view/IInvitationHomeView;", "Lcom/didi/component/core/IView;", "Lcom/didi/component/framework/pages/invitation/presenter/InvitationHomePresenter;", "Landroid/view/View$OnClickListener;", "gotPromoCode", "", "gotRefereeMoney", "gotRefererMoney", "initBottomView", "", "initInviteCodeView", "initRecyclerView", "list", "", "Lcom/didi/component/framework/pages/invitation/item/SwiperItem;", "initTitleView", "showCopyToastView", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IInvitationHomeView.kt */
public interface IInvitationHomeView extends View.OnClickListener, IView<InvitationHomePresenter> {
    String gotPromoCode();

    String gotRefereeMoney();

    String gotRefererMoney();

    void initBottomView();

    void initInviteCodeView();

    void initRecyclerView(List<SwiperItem> list);

    void initTitleView();

    void showCopyToastView();
}
