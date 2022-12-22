package com.didi.entrega.home.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.common.map.model.LatLng;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.home.component.feed.entity.HomeFeedEntity;
import com.didi.entrega.manager.base.ICustomerHomeManager;

public class CustomerHomeManager implements ICustomerHomeManager {

    /* renamed from: a */
    private static final String f20704a = "CustomerHomeManager";

    /* renamed from: b */
    private HomeFeedRepo f20705b;

    public String getManagerName() {
        return f20704a;
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onCreate() {
        this.f20705b = (HomeFeedRepo) RepoFactory.getRepo(HomeFeedRepo.class);
    }

    public void locateThenRefreshHome(final int i) {
        LocationUtil.getCurrentLocationOnce(new LocationUtil.LocationCallback() {
            public void onLocationError() {
                CustomerHomeManager.this.m15145a(i);
            }

            public void onLocationSuccess(LatLng latLng) {
                LogUtil.m14765i(CustomerHomeManager.f20704a, "locateThenRefreshHome onLocationSuccess");
                CustomerHomeManager.this.m15145a(i);
            }
        }, CustomerApolloUtil.getStartGpsTimeout());
    }

    public void refreshHomeByCityInfo() {
        m15145a(7);
    }

    public void fetchFeedIndex(ScopeContext scopeContext, int i) {
        this.f20705b.fetchFeedIndex(scopeContext, i);
    }

    public void subscribeFeedIndex(ScopeContext scopeContext, Action1<CustomerResource<HomeFeedEntity>> action1) {
        this.f20705b.from().shutViscidityNotice().subscribe(scopeContext, action1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15145a(int i) {
        LogUtil.m14761d(f20704a, "start refreshHome:" + i);
        HomeFeedRefreshRepo.Companion.setStatus(i);
    }
}
