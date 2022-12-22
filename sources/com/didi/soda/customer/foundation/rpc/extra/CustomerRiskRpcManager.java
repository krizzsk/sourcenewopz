package com.didi.soda.customer.foundation.rpc.extra;

import com.didi.soda.customer.foundation.rpc.ApiUrlFactory;
import com.didi.soda.customer.foundation.rpc.BaseRpcManager;
import com.didi.soda.customer.foundation.rpc.net.SFRpcServiceFactory;
import com.didichuxing.foundation.rpc.RpcService;
import java.util.HashMap;

public final class CustomerRiskRpcManager extends BaseRpcManager<CustomerRiskRpcService> implements CustomerRiskRpcService {
    private CustomerRiskRpcManager() {
    }

    public static CustomerRiskRpcManager getInstance() {
        return Holder.INSTANCE;
    }

    public void uploadFacebookToken(HashMap<String, Object> hashMap, RpcService.Callback<String> callback) {
        getRpcService().uploadFacebookToken(hashMap, callback);
    }

    /* access modifiers changed from: protected */
    public final CustomerRiskRpcService getRpcService() {
        return (CustomerRiskRpcService) SFRpcServiceFactory.getRpcService(CustomerRiskRpcService.class, ApiUrlFactory.getMsgApiDomain());
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final CustomerRiskRpcManager INSTANCE = new CustomerRiskRpcManager();

        private Holder() {
        }
    }
}
