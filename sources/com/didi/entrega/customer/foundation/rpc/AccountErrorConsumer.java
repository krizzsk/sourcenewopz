package com.didi.entrega.customer.foundation.rpc;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.rpc.ApiErrorConst;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IOneSdkService;
import java.lang.ref.WeakReference;

public class AccountErrorConsumer extends RpcErrorConsumer {

    /* renamed from: a */
    private WeakReference<ScopeContext> f19945a;

    public boolean consumeRpcErrorWhenScopeContextDestroyed(SFRpcException sFRpcException) {
        return true;
    }

    public AccountErrorConsumer(ScopeContext scopeContext) {
        this.f19945a = new WeakReference<>(scopeContext);
    }

    public boolean consumeRpcError(SFRpcException sFRpcException) {
        if (!ApiErrorConst.isAccountAbnormal(sFRpcException.getCode())) {
            return false;
        }
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).logOut(GlobalContext.getContext(), ApiErrorConst.LogoutReasons.getSignReasonByErrorCode(sFRpcException.getCode()));
        if (this.f19945a.get() == null) {
            return true;
        }
        ((ScopeContext) this.f19945a.get()).getNavigator().popToRoot();
        LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 3);
        return true;
    }

    public ScopeContext provideScopeContext() {
        return (ScopeContext) this.f19945a.get();
    }
}
