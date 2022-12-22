package com.didi.soda.home.binder;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.home.component.category.landing.ShopCategoryLandingPresenter;
import com.didi.soda.home.topgun.binder.HomeHeaderItemLogicRepo;
import com.didi.soda.home.topgun.manager.FilterNoResultLogicRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/home/binder/CateLandingComponentLogicUnit;", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "presenter", "Lcom/didi/soda/home/component/category/landing/ShopCategoryLandingPresenter;", "(Lcom/didi/soda/home/component/category/landing/ShopCategoryLandingPresenter;)V", "mPresent", "dealFilterLogic", "", "logicType", "", "(Ljava/lang/Integer;)V", "dealHeaderLogic", "logicModel", "Lcom/didi/soda/home/topgun/binder/HomeHeaderItemLogicRepo$LogicModel;", "onBindLogic", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CateLandingComponentLogicUnit.kt */
public final class CateLandingComponentLogicUnit extends ComponentLogicUnit {

    /* renamed from: a */
    private ShopCategoryLandingPresenter f42535a;

    public CateLandingComponentLogicUnit(ShopCategoryLandingPresenter shopCategoryLandingPresenter) {
        Intrinsics.checkNotNullParameter(shopCategoryLandingPresenter, "presenter");
        this.f42535a = shopCategoryLandingPresenter;
    }

    public void onBindLogic() {
        ShopCategoryLandingPresenter shopCategoryLandingPresenter = this.f42535a;
        if (shopCategoryLandingPresenter != null && shopCategoryLandingPresenter.getScopeContext() != null) {
            HomeHeaderItemLogicRepo homeHeaderItemLogicRepo = (HomeHeaderItemLogicRepo) getLogic(HomeHeaderItemLogicRepo.class);
            ShopCategoryLandingPresenter shopCategoryLandingPresenter2 = this.f42535a;
            ScopeContext scopeContext = null;
            homeHeaderItemLogicRepo.subscribe(shopCategoryLandingPresenter2 == null ? null : shopCategoryLandingPresenter2.getScopeContext(), new Action1(homeHeaderItemLogicRepo) {
                public final /* synthetic */ HomeHeaderItemLogicRepo f$1;

                {
                    this.f$1 = r2;
                }

                public final void call(Object obj) {
                    CateLandingComponentLogicUnit.m29986a(CateLandingComponentLogicUnit.this, this.f$1, (HomeHeaderItemLogicRepo.LogicModel) obj);
                }
            });
            FilterNoResultLogicRepo filterNoResultLogicRepo = (FilterNoResultLogicRepo) getLogic(FilterNoResultLogicRepo.class);
            ShopCategoryLandingPresenter shopCategoryLandingPresenter3 = this.f42535a;
            if (shopCategoryLandingPresenter3 != null) {
                scopeContext = shopCategoryLandingPresenter3.getScopeContext();
            }
            filterNoResultLogicRepo.subscribe(scopeContext, new Action1(filterNoResultLogicRepo) {
                public final /* synthetic */ FilterNoResultLogicRepo f$1;

                {
                    this.f$1 = r2;
                }

                public final void call(Object obj) {
                    CateLandingComponentLogicUnit.m29987a(CateLandingComponentLogicUnit.this, this.f$1, (Integer) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29986a(CateLandingComponentLogicUnit cateLandingComponentLogicUnit, HomeHeaderItemLogicRepo homeHeaderItemLogicRepo, HomeHeaderItemLogicRepo.LogicModel logicModel) {
        Intrinsics.checkNotNullParameter(cateLandingComponentLogicUnit, "this$0");
        cateLandingComponentLogicUnit.m29988a(homeHeaderItemLogicRepo.shopLandLogicModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29987a(CateLandingComponentLogicUnit cateLandingComponentLogicUnit, FilterNoResultLogicRepo filterNoResultLogicRepo, Integer num) {
        Intrinsics.checkNotNullParameter(cateLandingComponentLogicUnit, "this$0");
        cateLandingComponentLogicUnit.m29989a(Integer.valueOf(filterNoResultLogicRepo.getShopLandStatus()));
    }

    /* renamed from: a */
    private final void m29989a(Integer num) {
        ShopCategoryLandingPresenter shopCategoryLandingPresenter;
        if (num != null && num.intValue() == 1 && (shopCategoryLandingPresenter = this.f42535a) != null) {
            shopCategoryLandingPresenter.resetFilter();
        }
    }

    /* renamed from: a */
    private final void m29988a(HomeHeaderItemLogicRepo.LogicModel logicModel) {
        ShopCategoryLandingPresenter shopCategoryLandingPresenter;
        if (logicModel != null && TextUtils.equals(HomeHeaderItemLogicRepo.TYPE_SHOP_LAND_ITEM_CLICK, logicModel.mType) && (shopCategoryLandingPresenter = this.f42535a) != null) {
            shopCategoryLandingPresenter.notifyFilterItemClick(logicModel.filterModel, logicModel.isFloating());
        }
    }
}
