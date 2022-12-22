package com.didi.soda.customer.foundation.push;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action4;
import com.didi.app.nova.skeleton.repo.Event;
import com.didi.foundation.sdk.push.PushParam;
import com.didi.security.uuid.adapter.DeviceTokenWrapper;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.debug.PoiUtil;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;

public final class CustomerPushReport {
    private CustomerPushReport() {
    }

    public static CustomerPushReport getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final CustomerPushReport INSTANCE = new CustomerPushReport();

        private Holder() {
        }
    }

    public void subScribeAddress(ScopeContext scopeContext) {
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddress(scopeContext, new Action4<AddressEntity>() {
            public void call(Event<AddressEntity> event) {
                int i = AddressUtil.checkAddressValid((AddressEntity) event.oldData) ? ((AddressEntity) event.oldData).poi.cityId : -1;
                if (AddressUtil.checkAddressValid((AddressEntity) event.newData) && ((AddressEntity) event.newData).poi.cityId != i) {
                    LogUtil.m29104i("TAG", "poi change PushReport");
                    CustomerPushReport.this.noticeMessageFcmToken();
                }
            }
        });
    }

    public void noticeMessageFcmOpen() {
        if (LoginUtil.isLogin()) {
            PushParam a = m29112a();
            a.setFirstOpenTime(m29113b());
            GPushManagerProvider.getInstance().uploadPushParam(GlobalContext.getContext(), a);
        }
    }

    public void noticeMessageFcmToken() {
        GPushManagerProvider.getInstance().uploadPushParam(GlobalContext.getContext(), m29112a());
    }

    public void noticeMessageFcmParam(boolean z) {
        PushParam a = m29112a();
        a.setIsFoodLegalAgreement(z ? 1 : 0);
        if (z) {
            a.setFoodLegalAgreementTime(System.currentTimeMillis() / 1000);
        }
        GPushManagerProvider.getInstance().uploadPushParam(GlobalContext.getContext(), a);
    }

    /* renamed from: a */
    private PushParam m29112a() {
        PushParam pushParam = new PushParam();
        pushParam.setPhone(LoginUtil.getPhone());
        pushParam.setUserToken(LoginUtil.getToken());
        pushParam.setUid(LoginUtil.getUid());
        int poiCityId = PoiUtil.getPoiCityId();
        if (poiCityId > 0) {
            pushParam.setFoodDeliveryCity(String.valueOf(poiCityId));
        }
        pushParam.setFirstOpenTime(m29113b());
        pushParam.setDeviceToken(DeviceTokenWrapper.getInstance().getDeviceToken());
        return pushParam;
    }

    /* renamed from: b */
    private long m29113b() {
        return ((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mFirstOpenTime;
    }
}
