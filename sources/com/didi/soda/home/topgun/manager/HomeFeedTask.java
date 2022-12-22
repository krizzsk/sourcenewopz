package com.didi.soda.home.topgun.manager;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.task.CustomerAsyncTask;
import com.didi.soda.customer.foundation.tracker.LaunchAppTracker;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.topgun.manager.HomeFeedRefreshRepo;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;

public class HomeFeedTask extends CustomerAsyncTask<HomeEntity> {

    /* renamed from: a */
    private static final String f42987a = "HomeFeedTask";

    /* renamed from: b */
    private CustomerRpcService f42988b = CustomerRpcManagerProxy.get();

    /* renamed from: c */
    private HomeFeedParam f42989c;

    public HomeFeedTask(CRpcCallBackWithTraceId cRpcCallBackWithTraceId, HomeFeedParam homeFeedParam) {
        super(cRpcCallBackWithTraceId);
        this.f42989c = homeFeedParam;
    }

    public void onCancel() {
        super.onCancel();
        LogUtil.m29104i(f42987a, toString() + "-onCancel");
    }

    public void onMainThread() {
        super.onMainThread();
        LogUtil.m29104i(f42987a, toString() + "-onMainThread");
    }

    public void onWorkThread() {
        LaunchAppTracker.Companion.endTraceInThread("init-addQueue");
        super.onWorkThread();
        LogUtil.m29104i(f42987a, toString() + "-onWorkThread");
    }

    /* access modifiers changed from: protected */
    public CRpcResult<HomeEntity> execute() {
        AddressEntity addressEntity;
        if (this.f42989c.getScene() == 7) {
            addressEntity = new AddressEntity();
            HomeFeedRefreshRepo.CityInfo cityInfo = ((HomeFeedRefreshRepo) RepoFactory.getRepo(HomeFeedRefreshRepo.class)).getCityInfo();
            if (cityInfo != null) {
                addressEntity.poi = new AddressEntity.PoiEntity();
                addressEntity.poi.lng = cityInfo.mLng;
                addressEntity.poi.lat = cityInfo.mLat;
                addressEntity.poi.cityId = cityInfo.mCityId;
            }
        } else {
            addressEntity = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getCacheAddress();
        }
        return this.f42988b.getHomeFeedV3(this.f42989c.getScene(), addressEntity.poi, addressEntity.getAid(), this.f42989c.getFilterParam(), this.f42989c.getPageIndex(), this.f42989c.getRecId());
    }
}
