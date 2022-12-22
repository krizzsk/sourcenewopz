package com.didi.entrega.home.component.feed;

import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerView;
import com.didi.entrega.home.component.feed.entity.HomeBackgroundEntity;
import com.didi.entrega.home.component.feed.entity.HomeServiceItemEntity;
import com.didi.entrega.home.component.feed.entity.HomeTitleEntity;
import com.didi.entrega.home.component.feed.entity.ServiceRuleEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/Contract;", "", "AbsHomeFeedPresenter", "AbsHomeFeedView", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/Contract$AbsHomeFeedPresenter;", "Lcom/didi/entrega/customer/base/recycler/CustomerRecyclerPresenter;", "Lcom/didi/entrega/home/component/feed/Contract$AbsHomeFeedView;", "()V", "onRetryAction", "", "openPlaceOrderPage", "item", "Lcom/didi/entrega/home/component/feed/entity/HomeServiceItemEntity;", "openServiceNotifyPage", "data", "Lcom/didi/entrega/home/component/feed/entity/ServiceRuleEntity;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsHomeFeedPresenter extends CustomerRecyclerPresenter<AbsHomeFeedView> {
        public abstract void onRetryAction();

        public abstract void openPlaceOrderPage(HomeServiceItemEntity homeServiceItemEntity);

        public abstract void openServiceNotifyPage(ServiceRuleEntity serviceRuleEntity);
    }

    @Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\u0005H&J&\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/Contract$AbsHomeFeedView;", "Lcom/didi/entrega/customer/base/recycler/CustomerRecyclerView;", "Lcom/didi/entrega/home/component/feed/Contract$AbsHomeFeedPresenter;", "()V", "dismissAbnormal", "", "dismissShimmer", "getAdapter", "Lcom/didi/app/nova/support/view/recyclerview/adapter/NovaRecyclerAdapter;", "showAbnormal", "errorMsg", "", "showBusinessServiceDialog", "data", "Lcom/didi/entrega/home/component/feed/entity/HomeServiceItemEntity$HomeServiceAlertEntity;", "showGooglePlayDialog", "content", "showShimmer", "updateHomePage", "address", "backGround", "Lcom/didi/entrega/home/component/feed/entity/HomeBackgroundEntity;", "homeTitle", "Lcom/didi/entrega/home/component/feed/entity/HomeTitleEntity;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsHomeFeedView extends CustomerRecyclerView<AbsHomeFeedPresenter> {
        public abstract void dismissAbnormal();

        public abstract void dismissShimmer();

        public abstract NovaRecyclerAdapter getAdapter();

        public abstract void showAbnormal(String str);

        public abstract void showBusinessServiceDialog(HomeServiceItemEntity.HomeServiceAlertEntity homeServiceAlertEntity);

        public abstract void showGooglePlayDialog(String str);

        public abstract void showShimmer();

        public abstract void updateHomePage(String str, HomeBackgroundEntity homeBackgroundEntity, HomeTitleEntity homeTitleEntity);
    }
}
