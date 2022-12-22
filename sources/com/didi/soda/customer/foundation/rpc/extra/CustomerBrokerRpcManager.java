package com.didi.soda.customer.foundation.rpc.extra;

import com.didi.soda.customer.foundation.rpc.ApiUrlFactory;
import com.didi.soda.customer.foundation.rpc.BaseRpcManager;
import com.didi.soda.customer.foundation.rpc.entity.splash.SplashEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcServiceFactory;
import com.didichuxing.foundation.rpc.Rpc;
import java.util.ArrayList;

public final class CustomerBrokerRpcManager extends BaseRpcManager<CustomerBrokerRpcService> implements CustomerBrokerRpcService {
    private CustomerBrokerRpcManager() {
    }

    public static CustomerBrokerRpcManager getInstance() {
        return Holder.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public final CustomerBrokerRpcService getRpcService() {
        return (CustomerBrokerRpcService) SFRpcServiceFactory.getRpcService(CustomerBrokerRpcService.class, ApiUrlFactory.getBrokerApiDomain());
    }

    public Rpc batchGetActivityResource(ArrayList<String> arrayList, String str, String str2, CustomerRpcCallback<SplashEntity> customerRpcCallback) {
        return getRpcService().batchGetActivityResource(arrayList, str, str2, customerRpcCallback);
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final CustomerBrokerRpcManager INSTANCE = new CustomerBrokerRpcManager();

        private Holder() {
        }
    }
}
