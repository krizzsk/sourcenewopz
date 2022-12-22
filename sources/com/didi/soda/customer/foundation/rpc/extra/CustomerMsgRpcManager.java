package com.didi.soda.customer.foundation.rpc.extra;

import com.didi.soda.customer.foundation.rpc.ApiUrlFactory;
import com.didi.soda.customer.foundation.rpc.BaseRpcManager;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcServiceFactory;
import com.didichuxing.foundation.rpc.Rpc;

public final class CustomerMsgRpcManager extends BaseRpcManager<CustomerMsgRpcService> implements CustomerMsgRpcService {
    private CustomerMsgRpcManager() {
    }

    public static CustomerMsgRpcManager getInstance() {
        return Holder.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public final CustomerMsgRpcService getRpcService() {
        return (CustomerMsgRpcService) SFRpcServiceFactory.getRpcService(CustomerMsgRpcService.class, ApiUrlFactory.getMsgGateApiDomain());
    }

    public Rpc msgUpdate(String str, int i, int i2, CustomerRpcCallback<Object> customerRpcCallback) {
        return getRpcService().msgUpdate(str, i, i2, customerRpcCallback);
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final CustomerMsgRpcManager INSTANCE = new CustomerMsgRpcManager();

        private Holder() {
        }
    }
}
