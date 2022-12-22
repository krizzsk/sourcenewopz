package com.didi.soda.business.component.dynamic.category;

import com.didi.soda.business.component.dynamic.category.Contract;
import com.didi.soda.business.model.BusinessCategoryMenuRvModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\u000b\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/soda/business/component/dynamic/category/BusinessDyCategoryView$initRecyclerView$1", "Lcom/didi/soda/business/component/dynamic/category/CategoryPanelDyBinder;", "onCategoryItemClick", "", "index", "", "item", "Lcom/didi/soda/business/model/BusinessCategoryMenuRvModel;", "onCategoryItemExposure", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessDyCategoryView.kt */
public final class BusinessDyCategoryView$initRecyclerView$1 extends CategoryPanelDyBinder {
    final /* synthetic */ BusinessDyCategoryView this$0;

    BusinessDyCategoryView$initRecyclerView$1(BusinessDyCategoryView businessDyCategoryView) {
        this.this$0 = businessDyCategoryView;
    }

    public void onCategoryItemClick(int i, BusinessCategoryMenuRvModel businessCategoryMenuRvModel) {
        Intrinsics.checkNotNullParameter(businessCategoryMenuRvModel, "item");
        this.this$0.m27993a(i, businessCategoryMenuRvModel);
        this.this$0.m27992a(i);
        ((Contract.AbsCategoryPresenter) this.this$0.getPresenter()).onItemClick(i, businessCategoryMenuRvModel);
    }

    public void onCategoryItemExposure(int i, BusinessCategoryMenuRvModel businessCategoryMenuRvModel) {
        Intrinsics.checkNotNullParameter(businessCategoryMenuRvModel, "item");
        ((Contract.AbsCategoryPresenter) this.this$0.getPresenter()).onItemExposure(i, businessCategoryMenuRvModel);
    }
}
