package com.didi.component.business.web;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.router.GlobalRouter;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.events.FusionTitlebarRightClickEvent;
import com.didi.sdk.events.FusionTitlebarRightTextEvent;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.sign.model.event.PayMethodConfirmEvent;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.travel.psnger.model.response.ScarShareReportModel;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.net.URLEncoder;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

public class GlobalHybird extends BaseHybridModule {
    private static final String TAG = "GlobalHybird";
    private Activity mActivity;
    private CallbackFunction mOpenUniPayCallback;

    @JsInterface({"getEstimateData"})
    public void getEstimateData(CallbackFunction callbackFunction) {
    }

    public GlobalHybird(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.mActivity = hybridableContainer.getActivity();
    }

    @JsInterface({"commonClosePage"})
    public void commonClosePage(JSONObject jSONObject) {
        Intent intent = new Intent();
        if (jSONObject != null) {
            intent.putExtra(BaseExtras.Common.EXTRA_CLOSE_H5_CALLBACK_DATA, jSONObject.toString());
        }
        this.mActivity.setResult(-1, intent);
        this.mActivity.finish();
    }

    @JsInterface({"closeCancelReason"})
    public void closeCancelReason() {
        this.mActivity.finish();
    }

    @JsInterface({"updatePickupPoint"})
    public void updatePickupPoint() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT);
        this.mActivity.finish();
    }

    @JsInterface({"cancelOrder"})
    public void cancelOrder(JSONObject jSONObject) {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.OnService.EVENT_CANCEL_TRIP_H5_CALLBACK, jSONObject);
    }

    @JsInterface({"dashcamAgreement"})
    public void dashCamAgreement(JSONObject jSONObject) {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.OnService.EVENT_GET_DASH_CAM_AGREEMENT, jSONObject);
    }

    @JsInterface({"helpCancelOrder"})
    public void helpCancelOrder(JSONObject jSONObject) {
        GLog.m7965d(TAG, "helpCancelOrder done");
        Intent intent = new Intent();
        intent.putExtra("isCancelTrip", true);
        this.mActivity.setResult(-1, intent);
        this.mActivity.finish();
    }

    @JsInterface({"markup"})
    public void dynamicPriceMarkup(String str) {
        if ("close".equals(str)) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_DYNAMIC_CLOSE);
        } else {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_DYNAMIC_BRIDGE_CALLBACK, str);
        }
    }

    @JsInterface({"jumpToBindCardPage"})
    public void jumpToBindCardPage(JSONObject jSONObject) {
        GLog.m7965d(TAG, "jumpToBindCardPage");
        Activity activity = this.mActivity;
        if (activity != null && activity.getClass().getName().contains("CPFAuthWebActivity")) {
            DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
            addCardParam.bindType = 15;
            addCardParam.resourceId = ScarShareReportModel.CHANNEL_TWITTER;
            DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(this.mActivity, 111, addCardParam);
        }
        GlobalOmegaUtils.trackEvent("Brazil_fillin_creditInfo_ck");
    }

    @JsInterface({"CPFResult"})
    public void CPFResult(JSONObject jSONObject) {
        GLog.m7965d(TAG, "CPFResult:[ " + jSONObject + Const.jaRight);
        Activity activity = this.mActivity;
        if (activity != null && (activity instanceof FragmentActivity) && 1 == jSONObject.optInt("result")) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Flutter.EVENT_FLUTTER_CPF_RESULT, 0);
            this.mActivity.setResult(-1);
            this.mActivity.finish();
        }
    }

    @JsInterface({"CPFInLoginPageAddLaterEvent"})
    public void CPFInLoginPageAddLaterEvent(JSONObject jSONObject) {
        Activity activity = this.mActivity;
        if (activity != null && activity.getClass().getName().contains("CPFAuthWebActivity")) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Flutter.EVENT_FLUTTER_CPF_RESULT, 2);
            this.mActivity.setResult(0);
            this.mActivity.finish();
        }
    }

    @JsInterface({"onRiskAuthResult"})
    public void onRiskAuthResult(JSONObject jSONObject) {
        GLog.m7965d(TAG, "onRiskAuthResult:[" + jSONObject + Const.jaRight);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Flutter.EVENT_FLUTTER_CPF_RESULT, 0);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Risk.EVENT_SAFETY_AUTH_JS_CALLBACK, jSONObject);
    }

    @JsInterface({"queryHeaderData"})
    public void queryHeaderData(CallbackFunction callbackFunction) {
        double d;
        JSONObject jSONObject;
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        String localeCode = nationComponentData.getLocaleCode();
        int timeZoneUtcOffset = nationComponentData.getTimeZoneUtcOffset();
        DIDILocation lastKnownLocation = NationComponentDataUtil.getLastKnownLocation();
        double d2 = 0.0d;
        if (lastKnownLocation != null) {
            d2 = lastKnownLocation.getLatitude();
            d = lastKnownLocation.getLongitude();
        } else {
            d = 0.0d;
        }
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("lang", localeCode + "");
                jSONObject.put("utc_offset", timeZoneUtcOffset + "");
                jSONObject.put("lat", d2 + "");
                jSONObject.put("lng", d + "");
            } catch (JSONException e) {
                e = e;
                jSONObject2 = jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
            jSONObject = jSONObject2;
            callbackFunction.onCallBack(jSONObject);
        }
        callbackFunction.onCallBack(jSONObject);
    }

    @JsInterface({"openUniPay"})
    public void openUniPay(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("order_id")) {
                    DRouter.build("globalOneTravel" + HWMapConstant.HTTP.SEPARATOR + "one" + GlobalRouter.PAYMENT + "?oid=" + URLEncoder.encode(jSONObject.optString("order_id"), "utf-8") + "&pid=" + jSONObject.optString("product_id")).start(this.mActivity);
                    return;
                }
                if (jSONObject.has(Const.PayParams.BIZ_CONTENT_UNDERLINE)) {
                    jSONObject.put(Const.PayParams.BIZ_CONTENT, jSONObject.opt(Const.PayParams.BIZ_CONTENT_UNDERLINE));
                }
                if (jSONObject.has(Const.PayParams.SIGN_TYPE_UNDERLINE)) {
                    jSONObject.put(Const.PayParams.SIGN_TYPE, jSONObject.opt(Const.PayParams.SIGN_TYPE_UNDERLINE));
                }
                if (jSONObject.has("out_trade_id")) {
                    jSONObject.put(Const.PayParams.OUT_TRADE_ID, jSONObject.opt("out_trade_id"));
                }
                this.mOpenUniPayCallback = callbackFunction;
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                intent.setPackage(this.mActivity.getPackageName());
                intent.setAction("com.didi.global.unifiedPay.entrance");
                bundle.putSerializable("uni_pay_param", jSONObject.toString());
                intent.putExtras(bundle);
                ((Request) DRouter.build("").putExtra(Extend.START_ACTIVITY_VIA_INTENT, (Parcelable) intent)).start(this.mActivity, new RouterCallback.ActivityCallback() {
                    public void onActivityResult(int i, Intent intent) {
                        GlobalHybird.this.handleOpenUniPayResult(intent);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleOpenUniPayResult(Intent intent) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (intent != null) {
                int intExtra = intent.getIntExtra("code", 0);
                String stringExtra = intent.getStringExtra("message");
                jSONObject.put("code", intExtra);
                jSONObject.put("message", stringExtra);
            } else {
                jSONObject.put("code", 0);
                jSONObject.put("message", "");
            }
            if (this.mOpenUniPayCallback != null) {
                this.mOpenUniPayCallback.onCallBack(jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JsInterface({"setTopRightBtn"})
    public void setTopRightBtn(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            EventBus.getDefault().post(new FusionTitlebarRightTextEvent(jSONObject));
        }
        if (callbackFunction != null) {
            EventBus.getDefault().post(new FusionTitlebarRightClickEvent(callbackFunction));
        }
    }

    @JsInterface({"notifyInvoiceStatus"})
    public void notifyInvoiceStatus(JSONObject jSONObject) {
        if (jSONObject != null) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Invoice.KEY_INVOICE_STATUS_NOTIFY, Integer.valueOf(jSONObject.optInt("buttonStatus")));
        }
    }

    @JsInterface({"jumpToSettingPage"})
    public void jumpToSettingPage(JSONObject jSONObject, String str) {
        DRouter.build("global://one/settings").start(this.mActivity);
        this.mActivity.finish();
    }

    @JsInterface({"updateSelectedPoints"})
    public void updateMemberPoints(JSONObject jSONObject) {
        if (jSONObject != null) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.GroupForm.EVENT_GROUP_FORM_UPDATE_POINT_INFO, jSONObject.optString("selected_point"));
            this.mActivity.finish();
        }
    }

    @JsInterface({"confirmPayMethod"})
    public void onPayMethodConfirm() {
        GLog.m7965d(TAG, "onPayMethodConfirm");
        EventBus.getDefault().post(new PayMethodConfirmEvent());
        this.mActivity.finish();
    }
}
