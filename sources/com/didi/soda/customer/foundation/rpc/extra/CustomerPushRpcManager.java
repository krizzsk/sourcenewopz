package com.didi.soda.customer.foundation.rpc.extra;

import com.didi.soda.customer.foundation.rpc.ApiUrlFactory;
import com.didi.soda.customer.foundation.rpc.BaseRpcManager;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcServiceFactory;
import java.util.HashMap;

public final class CustomerPushRpcManager extends BaseRpcManager<CustomerPushRpcService> implements CustomerPushRpcService {
    private CustomerPushRpcManager() {
    }

    public static CustomerPushRpcManager getInstance() {
        return Holder.INSTANCE;
    }

    public void noticeMsgCenter(HashMap<String, Object> hashMap, CustomerRpcCallback<Object> customerRpcCallback) {
        getRpcService().noticeMsgCenter(hashMap, customerRpcCallback);
    }

    /* access modifiers changed from: protected */
    public final CustomerPushRpcService getRpcService() {
        return (CustomerPushRpcService) SFRpcServiceFactory.getRpcService(CustomerPushRpcService.class, ApiUrlFactory.getMsgApiDomain());
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final CustomerPushRpcManager INSTANCE = new CustomerPushRpcManager();

        private Holder() {
        }
    }
}
