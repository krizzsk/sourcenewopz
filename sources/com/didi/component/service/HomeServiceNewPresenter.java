package com.didi.component.service;

import android.os.Bundle;
import com.didi.android.comp_xbanner.HomeGlobalXBannerPresenter;
import com.didi.component.business.bizconfig.BizConfigFacade;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.base.ComponentWrap;
import com.didi.component.common.push.CommonPushComponent;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.event.CarInfoUpdateEvent;
import com.didi.sdk.util.EventKeys;
import com.didi.travel.psnger.model.response.CashUnPayInterceptInfo;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeServiceNewPresenter extends SugServicePresenter {

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15610a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            XEngineReq.pageRequest(XERequestKey.SCENE_HOME);
        }
    };

    /* renamed from: b */
    private final Logger f15611b = LoggerFactory.getLogger(HomeGlobalXBannerPresenter.TAG);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f15612c = 1;

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15613d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
        }
    };

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15614e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            SystemUtils.log(6, "ccc", "mHideSugOnListener onEvent ", (Throwable) null, "com.didi.component.service.HomeServiceNewPresenter$2", 76);
        }
    };

    /* renamed from: f */
    private XEReqJSONParamsCallbackImpl f15615f = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            hashMap.put("unpaid_data_required", Integer.valueOf(HomeServiceNewPresenter.this.f15612c));
            int unused = HomeServiceNewPresenter.this.f15612c = 0;
            return new JSONObject(hashMap);
        }
    };
    protected boolean isFirstAdd = true;
    protected boolean isInHome = true;
    protected XEResponseCallback mUnPayAlert = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData != null && xEngineData.jsonObject != null && xEngineData.jsonObject.getAsJsonObject("data") != null) {
                String str2 = HomeServiceNewPresenter.this.TAG;
                GLog.m7971i(str2, "onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
                try {
                    JSONObject jSONObject = new JSONObject(xEngineData.jsonObject.getAsJsonObject("data").toString());
                    CashUnPayInterceptInfo cashUnPayInterceptInfo = new CashUnPayInterceptInfo();
                    cashUnPayInterceptInfo.parse(jSONObject);
                    ComponentWrap componentWrap = new ComponentWrap(ComponentType.SERVICE_CONTROL_NO_PAY);
                    componentWrap.setClickMaskHide(true);
                    Bundle bundle = new Bundle();
                    cashUnPayInterceptInfo.mEntry = "home";
                    bundle.putSerializable("BUNDLE_CAR_ORDER_UNPAY_INFO", cashUnPayInterceptInfo);
                    componentWrap.setBundle(bundle);
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Template.EVENT_SHOW_POPUP_COMPONENT, componentWrap);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public HomeServiceNewPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Service.EVENT_HOME_SHOWN_SUG_PAGE, this.f15613d);
        SystemUtils.log(6, "ccc", "HomeServiceNewPresenter add subscribe EVENT_HOME_HIDE_SUG_PAGE", (Throwable) null, "com.didi.component.service.HomeServiceNewPresenter", 132);
        subscribe(BaseEventKeys.Service.EVENT_HOME_HIDE_SUG_PAGE, this.f15614e);
        m11373b();
        GlobalOmegaUtils.removeOrderType();
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_CASH_UNPAY, XERequestKey.SCENE_HOME, this.mUnPayAlert);
        xERegisterModel.requestParams = this.f15615f;
        XERegister.registerTemplate(xERegisterModel);
        if (!GlobalApolloUtil.isHomeEngine()) {
            XEngineReq.pageRequest(XERequestKey.SCENE_HOME);
        } else {
            subscribe(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET, this.f15610a);
        }
        this.isFirstAdd = true;
        this.f15611b.debug("HomeService onAdd", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        this.f15611b.debug("HomeService onPageResume", new Object[0]);
        if (GlobalApolloUtil.isHomeEngine() && this.isInHome) {
            XEngineReq.pageRequest(XERequestKey.SCENE_HOME);
        }
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        this.isInHome = false;
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        this.isInHome = true;
        if (GlobalApolloUtil.isHomeEngine()) {
            XEngineReq.pageRequest(XERequestKey.SCENE_HOME);
        }
    }

    /* renamed from: b */
    private void m11373b() {
        if (this.mContext != null && NationComponentDataUtil.isLoginNow()) {
            CommonPushComponent.getInstance().getMessagePull(this.mContext);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.isInHome = false;
        unsubscribe(BaseEventKeys.Service.EVENT_HOME_SHOWN_SUG_PAGE, this.f15613d);
        unsubscribe(BaseEventKeys.Service.EVENT_HOME_HIDE_SUG_PAGE, this.f15614e);
        if (GlobalApolloUtil.isHomeEngine()) {
            unsubscribe(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET, this.f15610a);
        }
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_CASH_UNPAY);
        SystemUtils.log(6, "ccc", "HomeServiceNewPresenter onRemove unsubscribe EVENT_HOME_HIDE_SUG_PAGE", (Throwable) null, "com.didi.component.service.HomeServiceNewPresenter", 218);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(CarInfoUpdateEvent carInfoUpdateEvent) {
        super.onReceive(carInfoUpdateEvent);
        if (carInfoUpdateEvent != null && EventKeys.MisConfig.CAR_INFO_UPDATE.equalsIgnoreCase(carInfoUpdateEvent.tag)) {
            int i = carInfoUpdateEvent.result;
            if (i == 1) {
                doPublish(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET);
                BizConfigFacade.getInstance().sendRequest(this.mBusinessContext);
                GlobalOmegaUtils.setBusinessId(this.mBusinessContext);
                requestDynamicConfig();
            } else if (i == 2) {
                requestDynamicConfig();
            }
        }
    }
}
