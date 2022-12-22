package com.didi.soda.home.topgun.binder;

import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.EmptyLogicRepo;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinder;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/HomeBusinessItemBinderNewLogic;", "Lcom/didi/soda/customer/base/binder/logic/BinderLogic;", "Lcom/didi/soda/customer/base/binder/logic/EmptyLogicRepo;", "Lcom/didi/soda/home/topgun/binder/HomeBusinessItemBinder$HomeBusinessOmegaInterface;", "()V", "onItemClick", "", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "setBusinessOmegaInterface", "impl", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeBusinessItemNewBinder.kt */
public abstract class HomeBusinessItemBinderNewLogic extends BinderLogic<EmptyLogicRepo> implements HomeBusinessItemBinder.HomeBusinessOmegaInterface {
    public abstract void onItemClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel);

    public void setBusinessOmegaInterface(HomeBusinessItemBinder.HomeBusinessOmegaInterface homeBusinessOmegaInterface) {
    }
}
