package com.didi.soda.pay;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.didi.universal.pay.biz.manager.UniversalBizManagerFactory;
import com.didi.universal.pay.biz.manager.listener.IUniversalPayBizManager;
import com.didi.universal.pay.biz.model.ErrorMessage;
import com.didi.universal.pay.biz.model.PayStatusModel;
import com.didi.universal.pay.biz.model.UniversalViewModel;
import com.didi.universal.pay.biz.p172ui.IUniversalPayView;
import com.didi.universal.pay.sdk.method.model.PayInfo;
import com.didi.universal.pay.sdk.model.UniversalPayParams;
import com.didi.universal.pay.sdk.net.model.Error;

public class CustomerPayManager implements ICustomerPayManager {
    public static final int INTERNAL_PAY_FAIL = -1;

    /* renamed from: a */
    private static final String f43626a = "CustomerPayManager";

    public String getManagerName() {
        return null;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void getPayStatus(Activity activity, ScopeContext scopeContext, ICustomerPayManager.PayParamEntity payParamEntity, ICustomerPayManager.PayCallback payCallback) {
        final IUniversalPayBizManager a = m30922a(activity, payParamEntity, payCallback);
        a.doGetPayInfo();
        scopeContext.getLiveHandler().bind(new Cancelable() {
            public void cancel() {
                a.doQuit(true);
            }
        });
    }

    public void pay(ScopeContext scopeContext, Activity activity, ICustomerPayManager.PayParamEntity payParamEntity, ICustomerPayManager.PayCallback payCallback) {
        UniversalPayParams universalPayParams = new UniversalPayParams();
        universalPayParams.outToken = payParamEntity.token;
        universalPayParams.outTradeId = payParamEntity.transId;
        universalPayParams.domain = 2;
        m30922a(activity, payParamEntity, payCallback).doPay(IUniversalPayView.Action.CLICK_PAY_BTN);
    }

    /* renamed from: a */
    private IUniversalPayBizManager m30922a(Activity activity, ICustomerPayManager.PayParamEntity payParamEntity, final ICustomerPayManager.PayCallback payCallback) {
        UniversalPayParams universalPayParams = new UniversalPayParams();
        universalPayParams.outToken = payParamEntity.token;
        universalPayParams.outTradeId = payParamEntity.transId;
        universalPayParams.domain = 2;
        final IUniversalPayBizManager iUniversalPayBizManager = UniversalBizManagerFactory.get(activity, universalPayParams, (IUniversalPayView) new IUniversalPayView() {
            public View getView() {
                return null;
            }

            public void setViewEnabled(boolean z) {
            }

            public void showContent() {
            }

            public void showError(ErrorMessage errorMessage) {
            }

            public void showLoading(IUniversalPayView.Action action, String str) {
            }

            public void showSuccess() {
            }

            public void update(UniversalViewModel universalViewModel) {
            }
        });
        iUniversalPayBizManager.addCallBack(new IUniversalPayBizManager.Result() {
            public void onBizFail(IUniversalPayBizManager.Action action, PayStatusModel payStatusModel) {
            }

            public void onRequestPayInfoSuccess(UniversalViewModel universalViewModel) {
            }

            public void onThirdPayComplete(int i) {
            }

            public void startActivity(Intent intent) {
            }

            public void startActivityForResult(Intent intent, int i) {
            }

            public void onPaySuccess() {
                ICustomerPayManager.PayCallback payCallback = payCallback;
                if (payCallback != null) {
                    payCallback.paySucceed();
                }
                successTrack();
                LogUtil.m29104i(CustomerPayManager.f43626a, "onPaySuccess");
                iUniversalPayBizManager.doQuit(true);
            }

            public void fail(IUniversalPayBizManager.Action action, PayStatusModel payStatusModel, Error error) {
                PayInfo payInfoCache = iUniversalPayBizManager.getPayInfoCache();
                if (action == IUniversalPayBizManager.Action.GET_PAY_INFO && payInfoCache != null && payInfoCache.payStatus == 4 && error.code != 100) {
                    error = new Error(payInfoCache.payStatusDetail, error.msg);
                }
                iUniversalPayBizManager.doQuit(true);
                if (payCallback != null) {
                    errorTrack(action.name(), error.code + "", "code:" + error.code + ",msg:" + error.msg, payInfoCache != null ? payInfoCache.payStatus : -1, payInfoCache != null ? payInfoCache.payStatusDetail : -1, payInfoCache != null ? payInfoCache.statusMsg : "null");
                    payCallback.payFail(error.code, error.msg, payStatusModel);
                }
                LogUtil.m29104i(CustomerPayManager.f43626a, "fail: action=" + action + " error code: " + error.code + " error msg: " + error.msg);
            }

            public void onThirdPayStart(int i) {
                ICustomerPayManager.PayCallback payCallback = payCallback;
                if (payCallback != null) {
                    payCallback.onThirdPayStart(i);
                }
            }

            private void successTrack() {
                OmegaTracker.Builder.create(EventConst.Trace.SAILING_C_K_SYSTEM_PAY_TRACE).addEventParam("status", 1).build().track();
            }

            private void errorTrack(String str, String str2, String str3, int i, int i2, String str4) {
                ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_CART_PAY_ERROR).addErrorType(str2).addModuleName(ErrorConst.ModuleName.CART).addErrorMsg(str3).build().trackError();
                OmegaTracker.Builder.create(EventConst.Trace.SAILING_C_K_SYSTEM_PAY_TRACE).addEventParam("status", 0).addEventParam("error_code", str2).addEventParam("error_msg", str3).addEventParam("pay_status", str).addEventParam(ParamConst.PARAM_PAYINFO_PAY_STATUS, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_PAY_DETAIL_STATUS, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_PAY_STATUS_MSG, str4).build().track();
            }
        });
        return iUniversalPayBizManager;
    }
}
