package com.didi.soda.business.component.category;

import com.didi.soda.business.component.category.Contract;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\u000b\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/soda/business/component/category/BusinessCategoryView$initRecyclerView$1", "Lcom/didi/soda/business/component/category/CategoryPanelBinder;", "onCategoryItemClick", "", "index", "", "item", "Lcom/didi/soda/business/model/BusinessCategoryRvModel;", "onCategoryItemExposure", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessCategoryView.kt */
public final class BusinessCategoryView$initRecyclerView$1 extends CategoryPanelBinder {
    final /* synthetic */ BusinessCategoryView this$0;

    BusinessCategoryView$initRecyclerView$1(BusinessCategoryView businessCategoryView) {
        this.this$0 = businessCategoryView;
    }

    public void onCategoryItemClick(int i, BusinessCategoryRvModel businessCategoryRvModel) {
        Intrinsics.checkNotNullParameter(businessCategoryRvModel, "item");
        this.this$0.m27868a(i);
        ((Contract.AbsCategoryPresenter) this.this$0.getPresenter()).onItemClick(i, businessCategoryRvModel);
    }

    public void onCategoryItemExposure(int i, BusinessCategoryRvModel businessCategoryRvModel) {
        Intrinsics.checkNotNullParameter(businessCategoryRvModel, "item");
        ((Contract.AbsCategoryPresenter) this.this$0.getPresenter()).onItemExposure(i, businessCategoryRvModel);
    }
}
