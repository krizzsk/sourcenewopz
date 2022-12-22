package com.didi.soda.home.topgun.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.common.map.model.LatLng;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.tracker.LaunchAppTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.performance.ConversionOmegaHelper;
import com.didi.soda.customer.foundation.tracker.performance.PerformanceOmegaHelper;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;
import com.didi.soda.home.topgun.manager.HomeFeedRefreshRepo;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerHomeManager;

public class CustomerHomeManager implements ICustomerHomeManager {

    /* renamed from: a */
    private static final String f42972a = "CustomerHomeManager";

    public String getManagerName() {
        return f42972a;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void refreshHomeByAddress(AddressEntity addressEntity, int i) {
        LogUtil.m29100d(f42972a, "start refreshHomeByAddress");
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).setDeliveryAddress(addressEntity, true, i);
        m30423a(5);
    }

    public void locateThenRefreshHome(final int i) {
        if (i == 1) {
            ConversionOmegaHelper.trackStartLoc();
        }
        LaunchAppTracker.Companion.beginTrace("init-GetLoc");
        LocationUtil.getCurrentLocationOnce(new LocationUtil.LocationCallback() {
            public void onLocationError() {
                LogUtil.m29104i(CustomerHomeManager.f42972a, "locateThenRefreshHome onLocationError");
                ((HomeFeedRepo) RepoFactory.getRepo(HomeFeedRepo.class)).abortPreLoad();
                LaunchAppTracker.Companion.clear();
                PerformanceOmegaHelper.getInstance().reset();
                ConversionOmegaHelper.trackLocation((LatLng) null);
                LaunchAppTracker.Companion.endTrace("init-GetLoc");
                CustomerHomeManager.this.m30423a(i);
            }

            public void onLocationSuccess(LatLng latLng) {
                if (i == 1) {
                    ((HomeFeedRepo) RepoFactory.getRepo(HomeFeedRepo.class)).beginPreLoad();
                }
                LogUtil.m29104i(CustomerHomeManager.f42972a, "locateThenRefreshHome onLocationSuccess");
                ConversionOmegaHelper.trackLocation(latLng);
                LaunchAppTracker.Companion.beginTrace("init-Track");
                PerformanceOmegaHelper.getInstance().trackAppRunDuration(EventConst.Performance.LOCATIONMANAGER);
                LaunchAppTracker.Companion.endTrace("init-Track");
                LaunchAppTracker.Companion.endTrace("init-GetLoc");
                CustomerHomeManager.this.m30423a(i);
            }
        }, CustomerApolloUtil.getStartGpsTimeout());
    }

    public void refreshHomeByCityInfo(double d, double d2, String str) {
        ((HomeFeedRefreshRepo) RepoFactory.getRepo(HomeFeedRefreshRepo.class)).setCityInfo(HomeFeedRefreshRepo.CityInfo.create(d, d2, str));
        m30423a(7);
    }

    public void subscribeHomeRefreshMessage(ScopeContext scopeContext, Action<Integer> action) {
        ((HomeFeedRefreshRepo) RepoFactory.getRepo(HomeFeedRefreshRepo.class)).subscribe(scopeContext, action);
    }

    public void activityInvalidedRefreshHome() {
        m30423a(5);
    }

    public void subscribeHomeData(ScopeContext scopeContext, Action1<CustomerResource<HomeEntity>> action1) {
        ((HomeFeedRepo) RepoFactory.getRepo(HomeFeedRepo.class)).subscribe(scopeContext, action1);
    }

    public void refreshTab() {
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).refreshTab();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30423a(int i) {
        LogUtil.m29100d(f42972a, "start refreshHome:" + i);
        ((HomeFeedRefreshRepo) RepoFactory.getRepo(HomeFeedRefreshRepo.class)).setValue(Integer.valueOf(i));
    }
}
