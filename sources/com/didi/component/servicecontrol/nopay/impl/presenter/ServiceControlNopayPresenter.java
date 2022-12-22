package com.didi.component.servicecontrol.nopay.impl.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.servicecontrol.nopay.AbsServiceControlNopayPresenter;
import com.didi.component.servicecontrol.nopay.impl.view.IServiceControlNopayView;
import com.didi.component.servicecontrol.utils.ServiceControlOmegaUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.soda.customer.app.constant.Const;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.CashUnPayInterceptInfo;
import com.didi.travel.psnger.model.response.PrePayTipsModel;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServiceControlNopayPresenter extends AbsServiceControlNopayPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CashUnPayInterceptInfo f15848a;

    public ServiceControlNopayPresenter(ComponentParams componentParams) {
        super(componentParams);
        if (componentParams != null && componentParams.extras != null) {
            this.f15848a = (CashUnPayInterceptInfo) componentParams.extras.getSerializable("BUNDLE_CAR_ORDER_UNPAY_INFO");
        }
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        CashUnPayInterceptInfo cashUnPayInterceptInfo = this.f15848a;
        if (cashUnPayInterceptInfo != null) {
            showNoPayView(cashUnPayInterceptInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        close();
        return true;
    }

    public void close() {
        ((IServiceControlNopayView) this.mView).close();
        HashMap hashMap = new HashMap();
        hashMap.put("type", CashUnPayInterceptInfo.BUTTON_ACTION_CLOSE);
        Map<String, Object> extraLog = this.f15848a.getExtraLog();
        if (!CollectionUtils.isEmpty((Map) extraLog)) {
            hashMap.putAll(extraLog);
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_btn_ck", (Map<String, Object>) hashMap);
        doPublish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, ComponentType.SERVICE_CONTROL_NO_PAY);
    }

    public void payNow() {
        super.payNow();
        CashUnPayInterceptInfo cashUnPayInterceptInfo = this.f15848a;
        if (cashUnPayInterceptInfo != null && cashUnPayInterceptInfo.payNow != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", this.f15848a.payNow.action);
            Map<String, Object> extraLog = this.f15848a.getExtraLog();
            if (!CollectionUtils.isEmpty((Map) extraLog)) {
                hashMap.putAll(extraLog);
            }
            GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_btn_ck", (Map<String, Object>) hashMap);
            ((IServiceControlNopayView) this.mView).showLoading();
            ServiceControlOmegaUtils.sendNoPayButtonClick(this.f15848a.payNow.action);
            CarRequest.getCashUnpaySign(this.mContext, (this.f15848a.type != 2 && this.f15848a.type == 4) ? 1 : 0, "", this.f15848a.oid, this.f15848a.fee, new ResponseListener<PrePayTipsModel>() {
                public void onSuccess(PrePayTipsModel prePayTipsModel) {
                    super.onSuccess(prePayTipsModel);
                    if (prePayTipsModel != null) {
                        ServiceControlNopayPresenter.this.m11563a(prePayTipsModel);
                        ServiceControlNopayPresenter.this.close();
                        if (!TextUtils.isEmpty(ServiceControlNopayPresenter.this.f15848a.mCardId)) {
                            ServiceControlNopayPresenter serviceControlNopayPresenter = ServiceControlNopayPresenter.this;
                            serviceControlNopayPresenter.doPublish(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_DELETCT_ITEM, serviceControlNopayPresenter.f15848a.mCardId);
                        }
                    }
                }

                public void onError(PrePayTipsModel prePayTipsModel) {
                    super.onError(prePayTipsModel);
                    ToastHelper.showShortCompleted(ServiceControlNopayPresenter.this.mContext, (int) R.string.car_confrim_cancel_fail);
                }

                public void onFail(PrePayTipsModel prePayTipsModel) {
                    super.onFail(prePayTipsModel);
                    ToastHelper.showShortCompleted(ServiceControlNopayPresenter.this.mContext, (int) R.string.car_confrim_cancel_fail);
                }

                public void onFinish(PrePayTipsModel prePayTipsModel) {
                    super.onFinish(prePayTipsModel);
                    ((IServiceControlNopayView) ServiceControlNopayPresenter.this.mView).hideLoading();
                }
            });
        }
    }

    public void bindCardNextTime() {
        super.bindCardNextTime();
        m11562a(this.f15848a.nextBindCard);
    }

    public void havePaid() {
        super.havePaid();
        m11562a(this.f15848a.havePaid);
    }

    /* renamed from: a */
    private void m11562a(final CashUnPayInterceptInfo.ButtonInfo buttonInfo) {
        if (this.f15848a != null && buttonInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", buttonInfo.action);
            Map<String, Object> extraLog = this.f15848a.getExtraLog();
            if (!CollectionUtils.isEmpty((Map) extraLog)) {
                hashMap.putAll(extraLog);
            }
            GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_btn_ck", (Map<String, Object>) hashMap);
            ((IServiceControlNopayView) this.mView).showLoading();
            ServiceControlOmegaUtils.sendNoPayButtonClick(buttonInfo.action);
            CarRequest.reportCashUnpay(this.mContext, "", this.f15848a.oid, buttonInfo.f44214id, new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    GLog.m7964d("reportClickEvent success " + jsonObject.toString());
                    ((IServiceControlNopayView) ServiceControlNopayPresenter.this.mView).hideLoading();
                    ServiceControlNopayPresenter.this.close();
                    if (!TextUtils.isEmpty(buttonInfo.toast)) {
                        ToastHelper.showShortCompleted(ServiceControlNopayPresenter.this.mContext, buttonInfo.toast);
                    }
                }

                public void onFailure(IOException iOException) {
                    GLog.m7964d("reportClickEvent fail " + iOException.getMessage());
                    ((IServiceControlNopayView) ServiceControlNopayPresenter.this.mView).hideLoading();
                    ToastHelper.showShortCompleted(ServiceControlNopayPresenter.this.mContext, (int) R.string.car_confrim_cancel_fail);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11563a(PrePayTipsModel prePayTipsModel) {
        try {
            Intent intent = new Intent();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("sign", prePayTipsModel.sign);
            jsonObject.addProperty(Const.PayParams.SIGN_TYPE, prePayTipsModel.signType);
            jsonObject.addProperty(Const.PayParams.BIZ_CONTENT, prePayTipsModel.bizContent);
            intent.setPackage(this.mContext.getPackageName());
            intent.setAction("com.didi.global.unifiedPay.entrance");
            intent.putExtra("uni_pay_param", jsonObject.toString());
            this.mContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
