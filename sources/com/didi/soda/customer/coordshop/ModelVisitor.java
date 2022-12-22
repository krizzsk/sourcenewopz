package com.didi.soda.customer.coordshop;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/ModelVisitor;", "", "type", "Lcom/didi/soda/customer/coordshop/ModelVisitorType;", "getType", "()Lcom/didi/soda/customer/coordshop/ModelVisitorType;", "visit", "Lcom/didi/soda/customer/coordshop/CollectedShopInfo;", "indexInRv", "", "model", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopSaver.kt */
public interface ModelVisitor {
    ModelVisitorType getType();

    CollectedShopInfo visit(int i, RecyclerModel recyclerModel);
}
