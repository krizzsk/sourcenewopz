package com.didi.soda.home.component.category.landing;

import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.datasource.page.dynamic.DynamicRecyclePresenter;
import com.didi.soda.datasource.page.dynamic.DynamicRecycleView;
import com.didi.soda.home.shimmer.ShimmerViewType;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import com.didi.soda.home.topgun.model.FilterModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/landing/Contract;", "", "AbsShopCategoryLandingPresenter", "AbsShopCategoryLandingView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0007H&J\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0007H&¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/landing/Contract$AbsShopCategoryLandingPresenter;", "Lcom/didi/soda/datasource/page/dynamic/DynamicRecyclePresenter;", "Lcom/didi/soda/home/component/category/landing/Contract$AbsShopCategoryLandingView;", "Lcom/didi/soda/home/topgun/manager/HomeFeedParam;", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeEntity;", "()V", "doRefresh", "", "mCategoryId", "", "go2Search", "notifyFilterItemClick", "filterModel", "Lcom/didi/soda/home/topgun/model/FilterModel;", "isFloating", "", "resetFilter", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsShopCategoryLandingPresenter extends DynamicRecyclePresenter<AbsShopCategoryLandingView, HomeFeedParam, HomeEntity> {
        public abstract void doRefresh(String str);

        public abstract void go2Search();

        public abstract void notifyFilterItemClick(FilterModel filterModel, boolean z);

        public abstract void resetFilter();
    }

    @Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH&J\b\u0010\u000f\u001a\u00020\u0005H&J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0013\u001a\u00020\u0005H&J\b\u0010\u0014\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/landing/Contract$AbsShopCategoryLandingView;", "Lcom/didi/soda/datasource/page/dynamic/DynamicRecycleView;", "Lcom/didi/soda/home/component/category/landing/Contract$AbsShopCategoryLandingPresenter;", "()V", "dismissLoading", "", "fillRecyclerViewContentHeight", "hasMore", "", "hideShimmerView", "intoFloating", "scrollToFloatingState", "anchorTarget", "", "isFilterNone", "scrollToTop", "setTitle", "title", "", "showLoading", "showNetErrorToast", "showShimmerView", "shimmerViewType", "Lcom/didi/soda/home/shimmer/ShimmerViewType;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsShopCategoryLandingView extends DynamicRecycleView<AbsShopCategoryLandingPresenter> {
        public abstract void dismissLoading();

        public abstract void fillRecyclerViewContentHeight(boolean z);

        public abstract void hideShimmerView();

        public abstract void intoFloating();

        public abstract void scrollToFloatingState(int i, boolean z);

        public abstract void scrollToTop();

        public abstract void setTitle(String str);

        public abstract void showLoading();

        public abstract void showNetErrorToast();

        public abstract void showShimmerView(ShimmerViewType shimmerViewType);
    }
}
