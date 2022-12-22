package com.didi.soda.home.component.category.landing;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/home/component/category/landing/ShopCategoryLandingPresenter$initShopCateDataSource$2", "Lcom/didi/app/nova/skeleton/repo/Action1;", "", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "call", "", "updatedList", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopCategoryLandingPresenter.kt */
public final class ShopCategoryLandingPresenter$initShopCateDataSource$2 implements Action1<List<? extends RecyclerModel>> {
    final /* synthetic */ ShopCategoryLandingPresenter this$0;

    ShopCategoryLandingPresenter$initShopCateDataSource$2(ShopCategoryLandingPresenter shopCategoryLandingPresenter) {
        this.this$0 = shopCategoryLandingPresenter;
    }

    public void call(List<? extends RecyclerModel> list) {
        if (list != null) {
            ShopCategoryLandingPresenter shopCategoryLandingPresenter = this.this$0;
            int i = 0;
            int size = list.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = i + 1;
                    RecyclerModel recyclerModel = (RecyclerModel) list.get(i);
                    ChildDataListManager access$getMCategoryListManager$p = shopCategoryLandingPresenter.f42562b;
                    ChildDataListManager childDataListManager = null;
                    if (access$getMCategoryListManager$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCategoryListManager");
                        access$getMCategoryListManager$p = null;
                    }
                    int indexOf = access$getMCategoryListManager$p.indexOf(recyclerModel);
                    if (indexOf >= 0) {
                        ChildDataListManager access$getMCategoryListManager$p2 = shopCategoryLandingPresenter.f42562b;
                        if (access$getMCategoryListManager$p2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mCategoryListManager");
                        } else {
                            childDataListManager = access$getMCategoryListManager$p2;
                        }
                        childDataListManager.set(indexOf, recyclerModel);
                    }
                    if (i2 <= size) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
