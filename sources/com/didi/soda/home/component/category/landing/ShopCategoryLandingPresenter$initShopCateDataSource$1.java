package com.didi.soda.home.component.category.landing;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/home/component/category/landing/ShopCategoryLandingPresenter$initShopCateDataSource$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "call", "", "list", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopCategoryLandingPresenter.kt */
public final class ShopCategoryLandingPresenter$initShopCateDataSource$1 implements Action1<List<? extends RecyclerModel>> {
    final /* synthetic */ ShopCategoryLandingPresenter this$0;

    ShopCategoryLandingPresenter$initShopCateDataSource$1(ShopCategoryLandingPresenter shopCategoryLandingPresenter) {
        this.this$0 = shopCategoryLandingPresenter;
    }

    public void call(List<? extends RecyclerModel> list) {
        ChildDataListManager access$getMCategoryListManager$p = this.this$0.f42562b;
        if (access$getMCategoryListManager$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryListManager");
            access$getMCategoryListManager$p = null;
        }
        access$getMCategoryListManager$p.set(list);
    }
}
