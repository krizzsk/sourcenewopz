package com.didi.component.framework.pages.invitation.view;

import com.didi.component.framework.pages.invitation.item.SwiperItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/component/framework/pages/invitation/view/IInvitationNewHomeView;", "Lcom/didi/component/framework/pages/invitation/view/IInvitationHomeView;", "initBanner", "", "initBottomView", "initHeadView", "initIntroductionView", "initInviteCodeView", "initRecyclerView", "list", "", "Lcom/didi/component/framework/pages/invitation/item/SwiperItem;", "initRewardView", "initShareView", "initTermsView", "initTitleView", "showCopyToastView", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IInvitationNewHomeView.kt */
public interface IInvitationNewHomeView extends IInvitationHomeView {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IInvitationNewHomeView.kt */
    public static final class DefaultImpls {
        public static void initBottomView(IInvitationNewHomeView iInvitationNewHomeView) {
            Intrinsics.checkNotNullParameter(iInvitationNewHomeView, "this");
        }

        public static void initInviteCodeView(IInvitationNewHomeView iInvitationNewHomeView) {
            Intrinsics.checkNotNullParameter(iInvitationNewHomeView, "this");
        }

        public static void initRecyclerView(IInvitationNewHomeView iInvitationNewHomeView, List<SwiperItem> list) {
            Intrinsics.checkNotNullParameter(iInvitationNewHomeView, "this");
            Intrinsics.checkNotNullParameter(list, "list");
        }

        public static void initTitleView(IInvitationNewHomeView iInvitationNewHomeView) {
            Intrinsics.checkNotNullParameter(iInvitationNewHomeView, "this");
        }

        public static void showCopyToastView(IInvitationNewHomeView iInvitationNewHomeView) {
            Intrinsics.checkNotNullParameter(iInvitationNewHomeView, "this");
        }
    }

    void initBanner();

    void initBottomView();

    void initHeadView();

    void initIntroductionView();

    void initInviteCodeView();

    void initRecyclerView(List<SwiperItem> list);

    void initRewardView();

    void initShareView();

    void initTermsView();

    void initTitleView();

    void showCopyToastView();
}
