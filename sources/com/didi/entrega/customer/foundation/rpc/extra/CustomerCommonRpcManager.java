package com.didi.entrega.customer.foundation.rpc.extra;

import com.didi.entrega.customer.foundation.rpc.ApiUrlFactory;
import com.didi.entrega.customer.foundation.rpc.BaseRpcManager;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcServiceFactory;
import com.didichuxing.foundation.rpc.RpcService;
import java.util.HashMap;

public final class CustomerCommonRpcManager extends BaseRpcManager<CustomerCommonRpcService> implements CustomerCommonRpcService {
    private CustomerCommonRpcManager() {
    }

    public static CustomerCommonRpcManager getInstance() {
        return Holder.INSTANCE;
    }

    public Object sendLocationCallNearDriversForDriverService(HashMap<String, Object> hashMap, RpcService.Callback<String> callback) {
        return getRpcService().sendLocationCallNearDriversForDriverService(hashMap, callback);
    }

    /* access modifiers changed from: protected */
    public final CustomerCommonRpcService getRpcService() {
        return (CustomerCommonRpcService) SFRpcServiceFactory.getRpcService(CustomerCommonRpcService.class, ApiUrlFactory.getCommonApiDomain());
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final CustomerCommonRpcManager INSTANCE = new CustomerCommonRpcManager();

        private Holder() {
        }
    }
}
