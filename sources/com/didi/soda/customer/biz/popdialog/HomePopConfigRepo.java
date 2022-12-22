package com.didi.soda.customer.biz.popdialog;

import com.didi.app.nova.skeleton.repo.LiveData;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.repo.CustomerResource;

public class HomePopConfigRepo extends Repo<CustomerResource<Object>> {

    /* renamed from: a */
    private LiveData<Boolean> f40476a = new LiveData<>();

    HomePopConfigRepo() {
        m28702a();
    }

    public void setLoginFetchHomePopFlag(boolean z) {
        this.f40476a.setValue(Boolean.valueOf(z));
    }

    public boolean isLoginFetchHomePop() {
        return this.f40476a.getValue().booleanValue();
    }

    /* renamed from: a */
    private void m28702a() {
        this.f40476a.setValue(true);
    }
}
