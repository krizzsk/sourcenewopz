package com.didi.component.comp_flex.panel.flex;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.component.business.commonlist.AbsCommonListPresenter;
import com.didi.component.business.commonlist.item.CommonListCardProperty;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.base.ComponentType;
import com.didi.component.comp_flex.drivercard.DriverItemView;
import com.didi.component.comp_flex.drivercard.FlexTemplateDriverModel;
import com.didi.component.comp_flex.drivercard.FlexTemplateDriverView;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didiglobal.common.common.xengine.XEngineRegister;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.enginecore.template.temp.XETemplateComponent;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FlexDriverListPresenter extends AbsCommonListPresenter {

    /* renamed from: b */
    private static final int f12200b = 1;

    /* renamed from: a */
    private String f12201a = "";

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12202c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            FlexDriverListPresenter.this.request();
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<DTSDKOrderStatus> f12203d = new BaseEventPublisher.OnEventListener<DTSDKOrderStatus>() {
        public void onEvent(String str, DTSDKOrderStatus dTSDKOrderStatus) {
            if (TextUtils.equals(str, BaseEventKeys.WaitRspNew.EVENT_ORDER_STATUS) && dTSDKOrderStatus != null && dTSDKOrderStatus.status != 7) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_TRIP_SHOW_OR_HIDE_FLEX, false);
            }
        }
    };

    /* renamed from: e */
    private Handler f12204e = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int i = message.arg1;
                FlexDriverListPresenter.this.request();
                FlexDriverListPresenter.this.m8258a(i);
            }
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<Boolean> f12205f = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            LinearLayout linearLayout = (LinearLayout) FlexDriverListPresenter.this.mListInterface.getCardContainer();
            int childCount = linearLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = linearLayout.getChildAt(i);
                if (childAt instanceof DriverItemView) {
                    ((DriverItemView) childAt).updateLoadingStatus(bool.booleanValue());
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public String getComponentIdByType(String str) {
        return str;
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.WaitRsp.EVENT_FLEX_COMMIT, this.f12205f);
        subscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_FLEX, this.f12202c);
        subscribe(BaseEventKeys.WaitRspNew.EVENT_ORDER_STATUS, this.f12203d);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8258a(int i) {
        this.f12204e.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.f12204e.sendMessageDelayed(obtain, (long) i);
    }

    public FlexDriverListPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public String[] getNativeCards() {
        return new String[]{ComponentType.FLEX_AUTOMATIC_MATCH_CARD};
    }

    /* access modifiers changed from: protected */
    public void afterRemoveCard() {
        boolean z;
        Iterator<CommonListCardProperty> it = this.mListInterface.getCardPropertyList().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().getId().equals("flex_driver_card")) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_TRIP_SHOW_OR_HIDE_FLEX, false);
            this.mLogger.info("lxslxs: removeAll", new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public XERegisterModel getXERegisterModel() {
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.SingleCompRefresh.REQUEST_KEY_FLEX_DRIVER, XERequestKey.SCENE_TRIP, this.xeResponse);
        xERegisterModel.components = new ArrayList();
        xERegisterModel.components.add(new XETemplateComponent("template_standard_biz_driver_card", FlexTemplateDriverView.class, FlexTemplateDriverModel.class));
        return xERegisterModel;
    }

    /* access modifiers changed from: protected */
    public void addXERequestParams(Map<String, Object> map) {
        map.put("c_timestamp", Long.valueOf(System.currentTimeMillis()));
        if (this.f12201a == null) {
            this.f12201a = "";
        }
        map.put("version", this.f12201a);
    }

    public void request() {
        XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
        xEBizParamsImpl.requestKeys = new String[]{XERequestKey.SingleCompRefresh.REQUEST_KEY_FLEX_DRIVER};
        xEBizParamsImpl.scene = XERequestKey.SCENE_TRIP;
        XEngineReq.simpleRequest(xEBizParamsImpl);
    }

    public void onRemove() {
        super.onRemove();
        this.f12204e.removeMessages(1);
        this.f12204e.removeCallbacksAndMessages((Object) null);
        XEngineRegister.unregister(XERequestKey.SingleCompRefresh.REQUEST_KEY_FLEX_DRIVER);
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_FLEX_COMMIT, this.f12205f);
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_FLEX, this.f12202c);
        unsubscribe(BaseEventKeys.WaitRspNew.EVENT_ORDER_STATUS, this.f12203d);
    }

    /* access modifiers changed from: protected */
    public boolean handleData(JsonObject jsonObject, List<XEComponent> list) {
        int i;
        JSONObject optJSONObject;
        if (jsonObject == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonObject.toString());
            String str = null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("extension");
            if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("biz_params")) == null) {
                i = 0;
            } else {
                str = optJSONObject.optString("version");
                i = optJSONObject.optInt("poll_interval");
            }
            if (i > 0) {
                m8258a(i * 1000);
            } else {
                m8258a(60000);
            }
            if (TextUtils.equals(this.f12201a, str)) {
                return true;
            }
            this.f12201a = str;
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
