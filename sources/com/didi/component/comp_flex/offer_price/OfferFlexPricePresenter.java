package com.didi.component.comp_flex.offer_price;

import android.app.Activity;
import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.tracker.flex.FlexTrack;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;

public class OfferFlexPricePresenter extends IPresenter<IView> {
    public static final String CHANEL_NAME = "com.didi.global.pax_flex_price";

    /* renamed from: a */
    private final Logger f12187a = LoggerFactory.getLogger("OfferFlexPricePresenter");

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f12188b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            OfferFlexPricePresenter.this.m8245a("show flex offer dialog ");
            if (OfferFlexPricePresenter.this.mContext != null) {
                FormStore.getInstance().setSkipEstimateGet(true);
                OfferFlexPricePresenter offerFlexPricePresenter = OfferFlexPricePresenter.this;
                offerFlexPricePresenter.startActivity(FlexOfferPriceActivity.getIntent(offerFlexPricePresenter.mContext, OfferFlexPricePresenter.this.offerFlexPriceJsonStr));
                ((Activity) OfferFlexPricePresenter.this.mContext).overridePendingTransition(0, 0);
            }
        }
    };

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<Object> f12189c = new BaseEventPublisher.OnEventListener<Object>() {
        public void onEvent(String str, Object obj) {
            OfferFlexPricePresenter.this.m8245a("EVENT_FLUTTER_PRICE_SHEET ");
            if (OfferFlexPricePresenter.this.offerFlexPriceModel == null) {
                OfferFlexPricePresenter.this.m8245a("offerFlexPriceModel is null");
                return;
            }
            try {
                HashMap hashMap = (HashMap) obj;
                String str2 = (String) hashMap.get("price_remind");
                String str3 = (String) hashMap.get("offer_price");
                OfferFlexPricePresenter offerFlexPricePresenter = OfferFlexPricePresenter.this;
                offerFlexPricePresenter.m8245a("price_remind " + str2 + "/ offer_price=" + str3);
                char c = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != 48) {
                    if (hashCode == 51) {
                        if (str2.equals("3")) {
                            c = 0;
                        }
                    }
                } else if (str2.equals("0")) {
                    c = 1;
                }
                if (c == 0) {
                    str3 = OfferFlexPricePresenter.this.offerFlexPriceModel.recommend_price;
                } else if (c != 1) {
                    OfferFlexPricePresenter.this.m8245a("flutter callback default ");
                    return;
                }
                if (str3 == null) {
                    str3 = OfferFlexPricePresenter.this.offerFlexPriceModel.recommend_price;
                }
                OfferFlexPricePresenter.this.doPublish(BaseEventKeys.Service.SendOrder.EVENT_ENTER_CONFIRM_ADDRESS, str3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    protected XEResponseCallback mXELogicCallbackOfferPrice = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData != null) {
                OfferFlexPricePresenter offerFlexPricePresenter = OfferFlexPricePresenter.this;
                offerFlexPricePresenter.m8245a("onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
                OfferFlexPricePresenter.this.m8244a(xEngineData.jsonObject);
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            OfferFlexPricePresenter offerFlexPricePresenter = OfferFlexPricePresenter.this;
            offerFlexPricePresenter.m8245a("onFailed:e = " + engineErrorException);
        }
    };
    public String offerFlexPriceJsonStr;
    public OfferFlexPriceModel offerFlexPriceModel;

    public OfferFlexPricePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8244a(JsonObject jsonObject) {
        if (jsonObject == null || !jsonObject.has("data")) {
            FlexTrack.track(FlexTrack.FlexEvent.sFlexMonitorEventId, 1);
            return;
        }
        this.offerFlexPriceModel = new OfferFlexPriceModel();
        try {
            String jsonElement = jsonObject.get("data").toString();
            this.offerFlexPriceJsonStr = jsonElement;
            this.offerFlexPriceModel.parse(jsonElement);
            FormStore.getInstance().setFlex_order_params(this.offerFlexPriceModel.order_params);
            if (this.offerFlexPriceModel != null) {
                FlexTrack.trackInValidPrice(this.offerFlexPriceModel.max_price, this.offerFlexPriceModel.min_price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m8245a("onadd");
        XERegister.registerTemplate(new XERegisterModel(XERequestKey.SingleCompRefresh.REQUEST_KEY_OFFER_FLEX_PRICE, XERequestKey.SCENE_ESTIMATE, this.mXELogicCallbackOfferPrice));
        subscribe(BaseEventKeys.Flutter.EVENT_FLUTTER_PRICE_SHEET, this.f12189c);
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_OFFER_PRICE_DIALOG, this.f12188b);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m8245a("onremove");
        XERegister.unregisterTemplate(XERequestKey.SingleCompRefresh.REQUEST_KEY_OFFER_FLEX_PRICE);
        unsubscribe(BaseEventKeys.Flutter.EVENT_FLUTTER_PRICE_SHEET, this.f12189c);
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_OFFER_PRICE_DIALOG, this.f12188b);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8245a(String str) {
        this.f12187a.info(str, new Object[0]);
    }
}
