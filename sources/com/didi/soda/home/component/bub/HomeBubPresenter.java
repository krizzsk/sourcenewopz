package com.didi.soda.home.component.bub;

import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.bub.HomeBubRepo;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/home/component/bub/HomeBubPresenter;", "Lcom/didi/soda/customer/base/ICustomerPresenter;", "Lcom/didi/soda/home/component/bub/HomeBubView;", "()V", "onCreate", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeBubPresenter.kt */
public final class HomeBubPresenter extends ICustomerPresenter<HomeBubView> {
    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        LogUtil.m29100d("homebub", "HomeBubPresenter oncreate");
        ((HomeBubRepo) RepoFactory.getRepo(HomeBubRepo.class)).subscribe(getScopeContext(), new HomeBubPresenter$onCreate$1(this));
    }
}
