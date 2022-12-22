package com.didi.component.xengineordercompat.presenter;

import android.os.Bundle;
import com.didi.component.business.util.OrderComManager;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.request.XEParams;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.service.CoreHttpRequest;
import com.didi.travel.psnger.model.response.OrderCom;
import com.didi.travel.psnger.p170v2.EventKeys;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.google.gson.JsonObject;
import java.util.List;

public class AbsGlobalXEngineOrderDetailCompatPresenter extends BaseExpressPresenter<IView> {
    protected XEResponseCallback mOrderComLogicCallback = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            String c = AbsGlobalXEngineOrderDetailCompatPresenter.this.TAG;
            LogUtils.m31493i(c, "onSuccessOrderCom:jsonObject = " + xEngineData.jsonObject);
            AbsGlobalXEngineOrderDetailCompatPresenter.this.m11887a(xEngineData);
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            String d = AbsGlobalXEngineOrderDetailCompatPresenter.this.TAG;
            LogUtils.m31493i(d, "onFailed:e = " + engineErrorException);
            AbsGlobalXEngineOrderDetailCompatPresenter.this.onFail(engineErrorException);
        }
    };
    protected XEResponseCallback mXELogicCallback = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            String a = AbsGlobalXEngineOrderDetailCompatPresenter.this.TAG;
            LogUtils.m31493i(a, "onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
            AbsGlobalXEngineOrderDetailCompatPresenter.this.onSuccess(xEngineData.jsonObject);
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            String b = AbsGlobalXEngineOrderDetailCompatPresenter.this.TAG;
            LogUtils.m31493i(b, "onFailed:e = " + engineErrorException);
            AbsGlobalXEngineOrderDetailCompatPresenter.this.onFail(engineErrorException);
        }
    };

    public AbsGlobalXEngineOrderDetailCompatPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_ORDER_DETAIL, XERequestKey.SCENE_TRIP, this.mXELogicCallback);
        xERegisterModel.required = true;
        XERegister.registerTemplate(xERegisterModel);
        XERegisterModel xERegisterModel2 = new XERegisterModel(XERequestKey.REQUEST_KEY_ORDER_COM, XERequestKey.SCENE_TRIP, this.mOrderComLogicCallback);
        xERegisterModel2.required = true;
        XERegister.registerTemplate(xERegisterModel2);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_ORDER_DETAIL);
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_ORDER_COM);
    }

    /* access modifiers changed from: protected */
    public void onSuccess(JsonObject jsonObject) {
        DTSDKOrderDetail dTSDKOrderDetail = new DTSDKOrderDetail();
        dTSDKOrderDetail.parse(jsonObject.getAsJsonObject("data").toString());
        if (dTSDKOrderDetail.errno != 0) {
            BaseEventPublisher.getPublisher().publishSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_FAIL, "");
        } else if (dTSDKOrderDetail.dtsdkBasicData != null && dTSDKOrderDetail.dtsdkBasicData.basicOrderData != null) {
            String str = dTSDKOrderDetail.dtsdkBasicData.basicOrderData.oid;
            TravelUtil.checkAndStoreOid(str, this.TAG);
            if (str.equals(this.mComponentProxy.getOrderId())) {
                m11886a(dTSDKOrderDetail.dtsdkBasicData.basicOrderData);
                CoreHttpRequest.doOrderDetailFetchSuccess(dTSDKOrderDetail, (ITravelOrderListener) null);
                BaseEventPublisher.getPublisher().publishSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_SUCCESS, str);
                return;
            }
            String str2 = this.TAG;
            LogUtils.m31492e(str2, "oid not match component proxy, orderId = " + TravelUtil.getRichOid(str) + ", mComponentProxy.getOrderId() = " + TravelUtil.getRichOid(this.mComponentProxy.getOrderId()));
        }
    }

    /* access modifiers changed from: protected */
    public void onFail(Exception exc) {
        BaseEventPublisher.getPublisher().publishSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_ERROR, "");
    }

    /* renamed from: a */
    private void m11886a(DTSDKOrderDetail.DTSDKBasicOrderData dTSDKBasicOrderData) {
        XEParams.getInstance().setLastOrderStatus(dTSDKBasicOrderData.status);
        XEParams.getInstance().setLastOrderSubStatus(dTSDKBasicOrderData.subStatus);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11887a(XEngineData xEngineData) {
        OrderCom orderCom = new OrderCom();
        orderCom.parse(xEngineData.jsonObject.toString());
        OrderComManager.getInstance().setOrderCom(orderCom);
    }
}
