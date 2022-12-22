package com.didi.component.indriver.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.model.XpTrackItem;
import com.didi.component.business.model.XpanelTrackModel;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.IXpCardLifeCycle;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.indriver.AbsIndriverPresenter;
import com.didi.component.indriver.model.DriverData;
import com.didi.component.indriver.model.IndriverData;
import com.didi.sdk.app.BusinessContext;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;
import java.util.HashMap;
import org.json.JSONObject;

public class IndriverPresenter extends AbsIndriverPresenter<IndriverView> implements IXpCardLifeCycle, XpNewAdapter {

    /* renamed from: c */
    private static final int f14174c = 1;

    /* renamed from: a */
    private BusinessContext f14175a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f14176b = "";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Handler f14177d = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                XEngineReq.simpleRequest(XERequestKey.SCENE_TRIP, "passenger_newXpanel+bargainingCard_logic+bargaining_card");
                IndriverPresenter.this.m9911a(i);
            }
        }
    };

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<XpanelTrackModel> f14178e = new BaseEventPublisher.OnEventListener<XpanelTrackModel>() {
        public void onEvent(String str, XpanelTrackModel xpanelTrackModel) {
            if (IndriverPresenter.this.mView != null && xpanelTrackModel != null && xpanelTrackModel.list != null && xpanelTrackModel.list.size() > 0) {
                int i = 0;
                while (i < xpanelTrackModel.list.size()) {
                    XpTrackItem xpTrackItem = xpanelTrackModel.list.get(i);
                    if (xpTrackItem == null || !"passenger_newXpanel+bargainingCard_logic+bargaining_card".equals(xpTrackItem.f11324id)) {
                        i++;
                    } else {
                        ((IndriverView) IndriverPresenter.this.mView).omegaTrack(xpTrackItem);
                        return;
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14179f = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            XEngineReq.simpleRequest(XERequestKey.SCENE_TRIP, "passenger_newXpanel+bargainingCard_logic+bargaining_card");
        }
    };

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14180g = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null) {
                if (order.status == 7) {
                    IndriverPresenter indriverPresenter = IndriverPresenter.this;
                    indriverPresenter.subscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_INDRIVER, indriverPresenter.f14179f);
                    IndriverPresenter.this.m9914b();
                    return;
                }
                IndriverPresenter.this.f14177d.removeCallbacksAndMessages((Object) null);
                IndriverPresenter indriverPresenter2 = IndriverPresenter.this;
                indriverPresenter2.unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_INDRIVER, indriverPresenter2.f14179f);
                IndriverPresenter.this.m9916c();
            }
        }
    };

    /* renamed from: h */
    private XEReqJSONParamsCallbackImpl f14181h = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            hashMap.put("oid", CarOrderHelper.getOrderId());
            hashMap.put("bargaining_card_version", IndriverPresenter.this.f14176b);
            return new JSONObject(hashMap);
        }
    };

    public void onCardAdd() {
    }

    public IndriverPresenter(ComponentParams componentParams) {
        super(componentParams.bizCtx.getContext());
        this.f14175a = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_INDRIVER, this.f14179f);
        m9914b();
        subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f14180g);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_OMEGA_TRACK_CALLBACK, this.f14178e);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9914b() {
        XERegisterModel xERegisterModel = new XERegisterModel("passenger_newXpanel+bargainingCard_logic+bargaining_card", XERequestKey.SCENE_TRIP, (XEResponseCallback) null);
        xERegisterModel.requestParams = this.f14181h;
        XERegister.registerTemplate(xERegisterModel);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.f14177d.removeCallbacksAndMessages((Object) null);
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_INDRIVER, this.f14179f);
        m9916c();
        unsubscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f14180g);
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_OMEGA_TRACK_CALLBACK, this.f14178e);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9916c() {
        XERegister.unregisterTemplate("passenger_newXpanel+bargainingCard_logic+bargaining_card");
    }

    public void onCardRemove() {
        if (this.mView != null) {
            ((IndriverView) this.mView).resetView();
        }
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        IndriverData parse;
        JSONObject optJSONObject = jSONObject.optJSONObject("normal");
        boolean z = false;
        if (!(optJSONObject == null || (parse = IndriverData.parse(optJSONObject)) == null)) {
            m9911a(parse.pollInterval);
            if (!TextUtils.equals(this.f14176b, parse.version)) {
                if (parse.driverDataList == null || parse.driverDataList.size() <= 0) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.NewXpanel.EVENT_XPNAEL_NEW_REMOVE_CARD, "passenger_newXpanel+bargainingCard_logic+bargaining_card");
                } else {
                    ((IndriverView) this.mView).setTitleText(parse.title);
                    ((IndriverView) this.mView).setTipsText(parse.tips);
                    ((IndriverView) this.mView).setCurrentPriceText(parse.currentPrice);
                    ((IndriverView) this.mView).setIndriverList(parse.driverDataList, parse.folded_show);
                    z = true;
                }
            }
            this.f14176b = parse.version;
        }
        iXpCardBindDataReadyCallback.ready(z);
    }

    public void engineCommit(boolean z, boolean z2) {
        if (this.mView != null) {
            ((IndriverView) this.mView).engineCommit(z, z2);
            if (!z && z2) {
                XEngineReq.simpleRequest(XERequestKey.SCENE_TRIP, "passenger_newXpanel+bargainingCard_logic+bargaining_card");
            }
        }
    }

    public void expandView(boolean z) {
        if (this.mView != null) {
            ((IndriverView) this.mView).expandView(z);
        }
    }

    public void removeItem(DriverData driverData) {
        if (this.mView != null) {
            ((IndriverView) this.mView).removeItem(driverData);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9911a(int i) {
        this.f14177d.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.f14177d.sendMessageDelayed(obtain, (long) i);
    }
}
