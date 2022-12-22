package com.didi.soda.customer.component.error;

import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.component.error.Contract;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.ApiErrorConst;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.ErrorHandleUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;

public class ErrorHandlePresenter extends Contract.AbsErrorHandlePresenter {

    /* renamed from: a */
    private static final String f40775a = "ErrorHandlePresenter";

    /* renamed from: b */
    private ErrorHandleUtil.ErrorHandleListener f40776b = new ErrorHandleUtil.ErrorHandleListener() {
        public void onErrorHandle(SFRpcException sFRpcException) {
            if (sFRpcException.getCode() <= -1) {
                LogUtil.m29102e(ErrorHandlePresenter.f40775a, "Error msg: " + sFRpcException.getOriginalMessage());
            } else if (ApiErrorConst.isAccountAbnormal(sFRpcException.getCode())) {
                ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).logOut(ErrorHandlePresenter.this.getContext(), ApiErrorConst.LogoutReasons.getSignReasonByErrorCode(sFRpcException.getCode()));
                LoginUtil.trackLogOut(sFRpcException.getCode());
                ErrorHandlePresenter.this.getScopeContext().getNavigator().popToRoot();
                LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 12);
            } else {
                ((Contract.AbsErrorHandleView) ErrorHandlePresenter.this.getLogicView()).showErrorTip(sFRpcException.getMessage());
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate() {
        ErrorHandleUtil.setErrorHandleListener(this.f40776b);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ErrorHandleUtil.setErrorHandleListener((ErrorHandleUtil.ErrorHandleListener) null);
    }
}
