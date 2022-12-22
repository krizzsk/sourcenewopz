package com.didi.soda.customer.foundation.rpc.extra;

import com.didi.soda.customer.foundation.rpc.ApiUrlFactory;
import com.didi.soda.customer.foundation.rpc.BaseRpcManager;
import com.didi.soda.customer.foundation.rpc.entity.RedeemPageEntity;
import com.didi.soda.customer.foundation.rpc.entity.RedeemResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.SideBarRedeemEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcServiceFactory;
import com.didichuxing.foundation.rpc.Rpc;

public final class CustomerActRpcManager extends BaseRpcManager<CustomerActRpcService> implements CustomerActRpcService {
    private CustomerActRpcManager() {
    }

    public static CustomerActRpcManager getInstance() {
        return Holder.INSTANCE;
    }

    public Rpc redeemPage(String str, CustomerRpcCallback<RedeemPageEntity> customerRpcCallback) {
        return getRpcService().redeemPage(str, customerRpcCallback);
    }

    public Rpc sidebarRedeem(String str, CustomerRpcCallback<SideBarRedeemEntity> customerRpcCallback) {
        return getRpcService().sidebarRedeem(str, customerRpcCallback);
    }

    public Rpc redeemResult(String str, CustomerRpcCallback<RedeemResultEntity> customerRpcCallback) {
        return getRpcService().redeemResult(str, customerRpcCallback);
    }

    /* access modifiers changed from: protected */
    public final CustomerActRpcService getRpcService() {
        return (CustomerActRpcService) SFRpcServiceFactory.getRpcService(CustomerActRpcService.class, ApiUrlFactory.getActApiDomain());
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final CustomerActRpcManager INSTANCE = new CustomerActRpcManager();

        private Holder() {
        }
    }
}
