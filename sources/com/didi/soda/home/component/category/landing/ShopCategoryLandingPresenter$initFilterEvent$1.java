package com.didi.soda.home.component.category.landing;

import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.home.component.category.landing.Contract;
import com.didi.soda.home.shimmer.ShimmerViewType;
import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import com.didi.soda.home.topgun.component.filter.OnFilterEvent;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/home/component/category/landing/ShopCategoryLandingPresenter$initFilterEvent$1", "Lcom/didi/soda/home/topgun/component/filter/OnFilterEvent;", "onConfirm", "", "filterDataManager", "Lcom/didi/soda/home/topgun/component/filter/FilterDataManager;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopCategoryLandingPresenter.kt */
public final class ShopCategoryLandingPresenter$initFilterEvent$1 implements OnFilterEvent {
    final /* synthetic */ ShopCategoryLandingPresenter this$0;

    ShopCategoryLandingPresenter$initFilterEvent$1(ShopCategoryLandingPresenter shopCategoryLandingPresenter) {
        this.this$0 = shopCategoryLandingPresenter;
    }

    public void onConfirm(FilterDataManager filterDataManager) {
        Intrinsics.checkNotNullParameter(filterDataManager, "filterDataManager");
        this.this$0.m30018d();
        ((Contract.AbsShopCategoryLandingView) this.this$0.getLogicView()).intoFloating();
        ((HomeFeedParam) this.this$0.getDataSource().getPageParams()).updateFilterParam(GsonUtil.toJson(filterDataManager.generateOutParams()));
        ((HomeFeedParam) this.this$0.getDataSource().getPageParams()).setIsFilter(true);
        this.this$0.m30010a(false, ShimmerViewType.HOME_FILTER);
    }
}
