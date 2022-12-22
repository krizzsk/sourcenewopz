package com.didi.soda.customer.foundation.rpc;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.ApiErrorConst;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;
import java.lang.ref.WeakReference;

public class AccountErrorConsumer extends RpcErrorConsumer {

    /* renamed from: a */
    private WeakReference<ScopeContext> f40964a;

    public boolean consumeRpcErrorWhenScopeContextDestroyed(SFRpcException sFRpcException) {
        return true;
    }

    public AccountErrorConsumer(ScopeContext scopeContext) {
        this.f40964a = new WeakReference<>(scopeContext);
    }

    public boolean consumeRpcError(SFRpcException sFRpcException) {
        if (!ApiErrorConst.isAccountAbnormal(sFRpcException.getCode())) {
            return false;
        }
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).logOut(GlobalContext.getContext(), ApiErrorConst.LogoutReasons.getSignReasonByErrorCode(sFRpcException.getCode()));
        if (sFRpcException != null) {
            LoginUtil.trackLogOut(sFRpcException.getCode());
        }
        if (this.f40964a.get() == null) {
            return true;
        }
        ((ScopeContext) this.f40964a.get()).getNavigator().popToRoot();
        LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 12);
        return true;
    }

    public ScopeContext provideScopeContext() {
        return (ScopeContext) this.f40964a.get();
    }
}
