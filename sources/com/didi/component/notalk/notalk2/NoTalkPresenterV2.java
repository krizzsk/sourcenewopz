package com.didi.component.notalk.notalk2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.request.XESimpleReqParams;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.notalk.info.NonTalkingMeetCardActivity;
import com.didi.component.notalk.presenter.AbsNoTalkPresenter;
import com.didi.component.notalk.view.INoTalkView;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;

public class NoTalkPresenterV2 extends AbsNoTalkPresenter {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f14700c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f14701d;

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener f14702e = new BaseEventPublisher.OnEventListener<Float>() {
        public void onEvent(String str, Float f) {
            if (BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA.equals(str)) {
                ((INoTalkView) NoTalkPresenterV2.this.mView).getView().setAlpha(f.floatValue());
            }
        }
    };

    /* renamed from: f */
    private XEResponseCallback f14703f = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData.jsonObject == null || xEngineData.jsonObject.isJsonNull() || !xEngineData.jsonObject.has("list")) {
                ((INoTalkView) NoTalkPresenterV2.this.mView).setVisible(false);
                return;
            }
            JsonArray asJsonArray = xEngineData.jsonObject.getAsJsonArray("list");
            if (asJsonArray == null || asJsonArray.isJsonNull() || asJsonArray.size() == 0) {
                ((INoTalkView) NoTalkPresenterV2.this.mView).setVisible(false);
                return;
            }
            JsonObject asJsonObject = asJsonArray.get(0).getAsJsonObject();
            if (asJsonObject == null || asJsonObject.isJsonNull() || !asJsonObject.has("normal")) {
                ((INoTalkView) NoTalkPresenterV2.this.mView).setVisible(false);
                return;
            }
            JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("normal");
            if (asJsonObject2 == null || asJsonObject2.isJsonNull() || !asJsonObject2.has("data")) {
                ((INoTalkView) NoTalkPresenterV2.this.mView).setVisible(false);
                return;
            }
            JsonObject asJsonObject3 = asJsonObject2.getAsJsonObject("data");
            if (asJsonObject3 == null || asJsonObject3.isJsonNull() || !asJsonObject3.has("title") || !asJsonObject3.has("text")) {
                ((INoTalkView) NoTalkPresenterV2.this.mView).setVisible(false);
                return;
            }
            String unused = NoTalkPresenterV2.this.f14701d = asJsonObject3.get("text").getAsString();
            String unused2 = NoTalkPresenterV2.this.f14700c = asJsonObject3.get("title").getAsString();
            if (!TextUtils.isEmpty(NoTalkPresenterV2.this.f14701d) && !TextUtils.isEmpty(NoTalkPresenterV2.this.f14700c) && NoTalkPresenterV2.this.mView != null) {
                ((INoTalkView) NoTalkPresenterV2.this.mView).setVisible(true);
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            if (NoTalkPresenterV2.this.mView != null) {
                ((INoTalkView) NoTalkPresenterV2.this.mView).setVisible(false);
            }
        }
    };

    public NoTalkPresenterV2(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, this.f14702e);
        m10488c();
    }

    /* renamed from: b */
    private void m10486b() {
        XESimpleReqParams xESimpleReqParams = new XESimpleReqParams();
        xESimpleReqParams.requestKey = XERequestKey.REQUEST_KEY_NOTALK;
        doPublish(BaseEventKeys.XEngine.EVENT_XENGINE_SIMPLE_REQUEST, xESimpleReqParams);
    }

    /* renamed from: c */
    private void m10488c() {
        XERegister.registerTemplate(new XERegisterModel(XERequestKey.REQUEST_KEY_NOTALK, XERequestKey.SCENE_TRIP, this.f14703f));
        m10486b();
    }

    /* renamed from: d */
    private void m10490d() {
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_NOTALK);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_COMPONENT_ALPHA, this.f14702e);
        ((INoTalkView) this.mView).setVisible(false);
        m10490d();
    }

    public void showNonTalkingMeetCard() {
        OmegaSDKAdapter.trackEvent("gd_meetcardicon_ck");
        Intent intent = new Intent(this.mContext, NonTalkingMeetCardActivity.class);
        intent.putExtra("title", this.f14700c);
        intent.putExtra("text", this.f14701d);
        startActivity(intent);
    }
}
