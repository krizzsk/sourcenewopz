package com.didi.soda.customer.app;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.IdentityEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;

public class SccManager {

    /* renamed from: a */
    private static final String f40338a = "SccManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f40339b;

    public String getScc() {
        return this.f40339b;
    }

    public void initData() {
        m28589a();
        CustomerRpcManagerProxy.get().getIdentity(new CustomerRpcCallback<IdentityEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                LogUtil.m29104i(SccManager.f40338a, "fetch params error, code = " + sFRpcException.getCode() + ", msg = " + sFRpcException.getOriginalMessage());
            }

            public void onRpcSuccess(IdentityEntity identityEntity, long j) {
                if (identityEntity != null) {
                    String unused = SccManager.this.f40339b = identityEntity.scc;
                }
            }
        });
    }

    /* renamed from: a */
    private void m28589a() {
        this.f40339b = null;
    }
}
