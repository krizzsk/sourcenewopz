package com.didi.soda.customer.foundation.rpc.extra;

import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.ApiUrlFactory;
import com.didi.soda.customer.foundation.rpc.BaseRpcManager;
import com.didi.soda.customer.foundation.rpc.Clock;
import com.didi.soda.customer.foundation.rpc.ParamsHelper;
import com.didi.soda.customer.foundation.rpc.entity.UserInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcServiceFactory;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didichuxing.foundation.rpc.Rpc;
import java.io.File;

public final class CustomerUploadImageRpcManager extends BaseRpcManager<CustomerUploadImageRpcService> {
    private CustomerUploadImageRpcManager() {
    }

    public static CustomerUploadImageRpcManager getInstance() {
        return Holder.INSTANCE;
    }

    public Rpc updateUserInfo(String str, String str2, File file, CustomerRpcCallback<UserInfoEntity> customerRpcCallback) {
        return getRpcService().updateUserInfo(SystemUtil.getIMEI(), LocationUtil.getPoiId(), LocationUtil.getPoiLat(), LocationUtil.getPoiLng(), Clock.timeAtSeconds(), CustomerSystemUtil.getDeviceId(), SecurityUtil.getSUUID(), LocationUtil.getCurrentLng(), LocationUtil.getCurrentLat(), ParamsHelper.getClientType(), LoginUtil.getToken(), SystemUtil.getVersionName(GlobalContext.getContext()), SystemUtil.getVersionCode(), LocationUtil.getCityId(), ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag(), str, str2, file, customerRpcCallback);
    }

    /* access modifiers changed from: protected */
    public final CustomerUploadImageRpcService getRpcService() {
        return (CustomerUploadImageRpcService) SFRpcServiceFactory.getRpcService(CustomerUploadImageRpcService.class, ApiUrlFactory.getCustomerApiDomain());
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final CustomerUploadImageRpcManager INSTANCE = new CustomerUploadImageRpcManager();

        private Holder() {
        }
    }
}
