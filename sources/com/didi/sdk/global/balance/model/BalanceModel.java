package com.didi.sdk.global.balance.model;

import android.content.Context;
import com.didi.sdk.global.balance.model.bean.BalancePageResponse;
import com.didi.sdk.global.common.utils.RpcParameterBuilder;
import com.didi.sdk.global.constant.GlobalServer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;

@Deprecated
public class BalanceModel {

    /* renamed from: a */
    private Context f36023a;

    /* renamed from: b */
    private BalanceRpcService f36024b;

    public BalanceModel(Context context) {
        this.f36023a = context;
        GlobalServer.initUrl();
        this.f36024b = (BalanceRpcService) new RpcServiceFactory(context).newRpcService(BalanceRpcService.class, GlobalServer.GLOBAL_HOST);
    }

    public void queryBalanceAccountsInfo(RpcService.Callback<BalancePageResponse> callback) {
        this.f36024b.queryBalanceAccountsInfo(new RpcParameterBuilder(this.f36023a).build(), callback);
    }
}
