package com.didi.soda.customer.coordshop.visitor;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.coordshop.CollectedShopInfo;
import com.didi.soda.customer.coordshop.ModelVisitor;
import com.didi.soda.customer.coordshop.ModelVisitorType;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/visitor/NativeShopItemVisitor;", "Lcom/didi/soda/customer/coordshop/ModelVisitor;", "()V", "type", "Lcom/didi/soda/customer/coordshop/ModelVisitorType;", "getType", "()Lcom/didi/soda/customer/coordshop/ModelVisitorType;", "visit", "Lcom/didi/soda/customer/coordshop/CollectedShopInfo;", "indexInRv", "", "model", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NativeShopItemVisitor.kt */
public final class NativeShopItemVisitor implements ModelVisitor {
    public ModelVisitorType getType() {
        return ModelVisitorType.Home;
    }

    public CollectedShopInfo visit(int i, RecyclerModel recyclerModel) {
        Intrinsics.checkNotNullParameter(recyclerModel, "model");
        if (!(recyclerModel instanceof HomeBusinessInfoRvModel)) {
            return null;
        }
        HomeBusinessInfoRvModel homeBusinessInfoRvModel = (HomeBusinessInfoRvModel) recyclerModel;
        String str = homeBusinessInfoRvModel.mShopId;
        if (str == null) {
            str = "";
        }
        return new CollectedShopInfo(str, homeBusinessInfoRvModel.mIndexInModule, homeBusinessInfoRvModel.mPageInModule, i);
    }
}
