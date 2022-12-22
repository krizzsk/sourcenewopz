package com.didi.component.realtimeprice.impl;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.DateConverUtils;
import com.didi.component.common.widget.loading.NewPopUpLoadingBar;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.realtimeprice.AbsRealTimePricePresenter;
import com.didi.component.realtimeprice.IRealTimePriceView;
import com.didi.component.realtimeprice.model.ChangePayWayPushModel;
import com.didi.component.realtimeprice.model.PayInfo;
import com.didi.component.realtimeprice.model.RealTimePrice;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.presenter.PayMethodSelectAdapter;
import com.didi.sdk.webview.WebActivity;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.model.OrderStatus;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.xengine.register.XERegister;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.enginecore.callback.XEReqParamsCallback;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class RealTimePricePresenter extends AbsRealTimePricePresenter {

    /* renamed from: a */
    private static final int f15255a = 4;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public NewPopUpLoadingBar f15256b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f15257c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CountDownTimer f15258d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public PayInfo f15259e;

    /* renamed from: f */
    private int f15260f = 0;

    /* renamed from: g */
    private String f15261g = "";

    /* renamed from: h */
    private Map<String, Object> f15262h = new HashMap();

    /* renamed from: i */
    private int f15263i = 0;

    /* renamed from: j */
    private String f15264j = "";

    /* renamed from: k */
    private String f15265k = "";

    /* renamed from: l */
    private PayMethodSelectAdapter f15266l;

    /* renamed from: m */
    private BaseEventPublisher.OnEventListener f15267m = new BaseEventPublisher.OnEventListener<OrderRealtimePriceCount>() {
        public void onEvent(String str, OrderRealtimePriceCount orderRealtimePriceCount) {
            if (orderRealtimePriceCount != null && RealTimePricePresenter.this.f15259e != null && TextUtils.isEmpty(RealTimePricePresenter.this.f15259e.totalFee)) {
                RealTimePricePresenter.this.m10961a(orderRealtimePriceCount);
            }
        }
    };

    /* renamed from: n */
    private BaseEventPublisher.OnEventListener<JSONObject> f15268n = new BaseEventPublisher.OnEventListener<JSONObject>() {
        public void onEvent(String str, JSONObject jSONObject) {
            if (TextUtils.equals(str, BaseEventKeys.OnService.EVENT_SHOW_GROUP_INFO_V2)) {
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("normal").optJSONObject("data").optJSONObject("pay_info");
                    if (optJSONObject != null) {
                        PayInfo unused = RealTimePricePresenter.this.f15259e = new PayInfo();
                        RealTimePricePresenter.this.f15259e.parse(optJSONObject);
                        ((IRealTimePriceView) RealTimePricePresenter.this.mView).setData(RealTimePricePresenter.this.f15259e);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };

    /* renamed from: p */
    private BaseEventPublisher.OnEventListener f15269p = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            RealTimePricePresenter realTimePricePresenter = RealTimePricePresenter.this;
            realTimePricePresenter.paywayChange(realTimePricePresenter.f15259e);
        }
    };

    /* renamed from: q */
    private BaseEventPublisher.OnEventListener f15270q = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (RealTimePricePresenter.this.f15258d != null) {
                RealTimePricePresenter.this.f15258d.cancel();
                CountDownTimer unused = RealTimePricePresenter.this.f15258d = null;
            }
            if (RealTimePricePresenter.this.f15256b != null) {
                RealTimePricePresenter.this.f15256b.dismiss();
                NewPopUpLoadingBar unused2 = RealTimePricePresenter.this.f15256b = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        ChangePayWayPushModel changePayWayPushModel = (ChangePayWayPushModel) new Gson().fromJson(str2, ChangePayWayPushModel.class);
                        if (changePayWayPushModel.changePaywayInfo != null) {
                            RealTimePricePresenter.this.f15257c.putAll((HashMap) new Gson().fromJson((JsonElement) changePayWayPushModel.changePaywayInfo, new TypeToken<HashMap<String, String>>() {
                            }.getType()));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
            }
        }
    };

    public RealTimePricePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (OrderStatus.isWaitResponse(CarOrderHelper.getOrder())) {
            OmegaSDK.putGlobalAttr("g_PageId", "wait");
        }
        if (CarOrderHelper.isWaitDriver()) {
            OmegaSDK.putGlobalAttr("g_PageId", "pick");
        }
        if (CarOrderHelper.isOnService()) {
            OmegaSDK.putGlobalAttr("g_PageId", GPageIdConstant.G_PAGE_ID_PROC);
        }
        if (intent != null) {
            int i3 = 0;
            this.f15260f = 0;
            this.f15261g = "";
            if (4 == i && intent != null && -1 == i2) {
                m10959a((DidiGlobalPayMethodListData.PayMethodListResult) intent.getSerializableExtra("pay_method_list_result"));
            }
            if (this.f15259e != null) {
                this.f15262h.put(GlobalPayOmegaConstant.EventKey.TAB, this.f15264j);
                this.f15262h.put("style", Integer.valueOf(this.f15259e.mPayAssistorModule != null ? 1 : 0));
                this.f15262h.put("ischange", 0);
                this.f15262h.put("paytype", Integer.valueOf(this.f15260f));
                if (this.f15259e.mLog != null) {
                    try {
                        this.f15262h.putAll((Map) new Gson().fromJson(this.f15259e.mLog.toString(), new TypeToken<HashMap<String, Object>>() {
                        }.getType()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                this.f15262h.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
                GlobalOmegaUtils.trackEvent("ibt_gp_payment_ck", this.f15262h);
                this.f15262h.clear();
                if (this.f15260f == this.f15259e.paymentsType) {
                    return;
                }
            }
            PayInfo payInfo = this.f15259e;
            if (payInfo != null && !TextUtils.isEmpty(payInfo.engineCommitUrl)) {
                Uri parse = Uri.parse(this.f15259e.engineCommitUrl);
                try {
                    JSONObject jSONObject = new JSONObject(parse.getQueryParameter("query"));
                    jSONObject.put("id", URLEncoder.encode(jSONObject.optString("id"), "UTF-8"));
                    jSONObject.put(ParamKeys.PARAM_PAYMENTS_TYPE, this.f15260f);
                    jSONObject.put("card_index", this.f15261g);
                    jSONObject.put("change_payment_scene", this.f15263i);
                    StringBuffer stringBuffer = new StringBuffer(parse.getScheme());
                    stringBuffer.append(HWMapConstant.HTTP.SEPARATOR);
                    stringBuffer.append(parse.getHost());
                    stringBuffer.append(parse.getPath());
                    stringBuffer.append("?query=");
                    stringBuffer.append(jSONObject.toString());
                    DRouter.build(stringBuffer.toString()).start(this.mContext, new RouterCallback() {
                        public void onResult(Result result) {
                        }
                    });
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.mContext instanceof Activity) {
                    if (this.f15256b == null) {
                        NewPopUpLoadingBar newPopUpLoadingBar = new NewPopUpLoadingBar(this.mContext);
                        this.f15256b = newPopUpLoadingBar;
                        newPopUpLoadingBar.show();
                    }
                    if (!this.f15256b.isShowing()) {
                        this.f15256b.show();
                    }
                    PayInfo payInfo2 = this.f15259e;
                    if (payInfo2 != null) {
                        i3 = payInfo2.processTime;
                    }
                    this.f15258d = new CountDownTimer((long) (i3 * 1000), 1000) {
                        public void onTick(long j) {
                        }

                        public void onFinish() {
                            RealTimePricePresenter.this.f15257c.clear();
                            RealTimePricePresenter.this.f15257c.put("overtime", 1);
                            XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
                            if (RealTimePricePresenter.this.f15256b != null) {
                                RealTimePricePresenter.this.f15256b.dismiss();
                                NewPopUpLoadingBar unused = RealTimePricePresenter.this.f15256b = null;
                            }
                        }
                    }.start();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Service.OnService.EVENT_REALTIME_TIME_PRICE_COUNT, this.f15267m);
        subscribe(BaseEventKeys.OnService.EVENT_SHOW_GROUP_INFO_V2, this.f15268n);
        subscribe(BaseEventKeys.Push.EVENT_CHANGE_PAYWAY_RESULT, this.f15270q);
        subscribe(BaseEventKeys.Router.EVENT_PAYWAY_CHANGE, this.f15269p);
        ((IRealTimePriceView) this.mView).setClickable(true);
        m10964b();
        XERegisterModel xERegisterModel = new XERegisterModel("travel_group_info_v2", XERequestKey.SCENE_TRIP, (XEResponseCallback) new XEResponseCallback() {
            public void onFailed(String str, EngineErrorException engineErrorException) {
            }

            public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            }
        });
        xERegisterModel.requestParams = new XEReqParamsCallback() {
            public Object getRequestParams() {
                HashMap hashMap = new HashMap();
                hashMap.putAll(RealTimePricePresenter.this.f15257c);
                RealTimePricePresenter.this.f15257c.clear();
                return hashMap;
            }
        };
        XERegister.registerTemplate(xERegisterModel);
        this.f15266l = new PayMethodAdapterImpl();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Service.OnService.EVENT_REALTIME_TIME_PRICE_COUNT, this.f15267m);
        unsubscribe(BaseEventKeys.OnService.EVENT_SHOW_GROUP_INFO_V2, this.f15268n);
        unsubscribe(BaseEventKeys.Push.EVENT_CHANGE_PAYWAY_RESULT, this.f15270q);
        unsubscribe(BaseEventKeys.Router.EVENT_PAYWAY_CHANGE, this.f15269p);
        XERegister.unregisterTemplate("travel_group_info_v2");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10961a(OrderRealtimePriceCount orderRealtimePriceCount) {
        if (CarOrderHelper.getOrder() != null && orderRealtimePriceCount != null) {
            ((IRealTimePriceView) this.mView).setData(buildRealTimePrice(orderRealtimePriceCount));
        }
    }

    /* access modifiers changed from: protected */
    public RealTimePrice buildRealTimePrice(OrderRealtimePriceCount orderRealtimePriceCount) {
        RealTimePrice realTimePrice = new RealTimePrice();
        if (m10962a(realTimePrice)) {
            return realTimePrice;
        }
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            realTimePrice.isDetailPriceClosed = order.isDetailPriceClosed;
        }
        realTimePrice.showArrow = true;
        realTimePrice.totalPrice = orderRealtimePriceCount.totalFee;
        realTimePrice.totalPriceDisplay = orderRealtimePriceCount.totalFeeText;
        realTimePrice.currencyId = getCurrencyId(this.mBusinessContext);
        return realTimePrice;
    }

    /* renamed from: a */
    private boolean m10962a(RealTimePrice realTimePrice) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || order.cardInfo == null || TextUtils.isEmpty(order.cardInfo.msg)) {
            return false;
        }
        realTimePrice.showArrow = false;
        realTimePrice.meterFare = order.cardInfo.msg;
        realTimePrice.isDetailPriceClosed = order.isDetailPriceClosed;
        return true;
    }

    /* renamed from: b */
    private void m10964b() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.cardInfo != null && !TextUtils.isEmpty(order.cardInfo.msg)) {
            ((IRealTimePriceView) this.mView).setData(m10957a(order.cardInfo.msg, order.isDetailPriceClosed));
        } else if (order == null || order.mRealtimePriceCount == null || TextUtils.isEmpty(order.mRealtimePriceCount.totalFee)) {
            ((IRealTimePriceView) this.mView).showLoading();
        } else {
            ((IRealTimePriceView) this.mView).setData(buildRealTimePrice(order.mRealtimePriceCount));
        }
        m10960a(order);
    }

    /* renamed from: a */
    private RealTimePrice m10957a(String str, boolean z) {
        RealTimePrice realTimePrice = new RealTimePrice();
        realTimePrice.showArrow = false;
        realTimePrice.meterFare = str;
        realTimePrice.isDetailPriceClosed = z;
        return realTimePrice;
    }

    /* renamed from: a */
    private void m10960a(CarOrder carOrder) {
        if (carOrder != null) {
            DTSDKOrderDetail.PaymentsWayInfo paymentsWayInfo = carOrder.payInfo;
            if (paymentsWayInfo == null || TextUtils.isEmpty(paymentsWayInfo.text)) {
                ((IRealTimePriceView) this.mView).getView().postDelayed(new Runnable() {
                    public void run() {
                        RealTimePricePresenter.this.doPublish(BaseEventKeys.Service.EVENT_PAY_WAY_GUIDE_SHOW, false);
                    }
                }, 200);
                return;
            }
            String str = paymentsWayInfo.text;
            if (!TextUtils.isEmpty(paymentsWayInfo.suffix)) {
                str = str + " " + paymentsWayInfo.suffix;
            }
            ((IRealTimePriceView) this.mView).setPayWay(str);
        }
    }

    /* access modifiers changed from: protected */
    public void handleAction() {
        super.handleAction();
        GlobalOmegaUtils.trackEvent("pas_tripservice_price_ck");
        if (!((IRealTimePriceView) this.mView).isLoading() && getHost() != null && getHost().getActivity() != null) {
            Intent intent = new Intent(getHost().getActivity(), WebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(m10966c()));
            getHost().getActivity().startActivity(intent);
            getHost().getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }
    }

    /* renamed from: c */
    private String m10966c() {
        String priceDetail = GlobalWebUrl.getPriceDetail(this.mContext, "");
        CarOrder order = CarOrderHelper.getOrder();
        HashMap hashMap = new HashMap();
        hashMap.put("istrip", "true");
        if (order != null) {
            hashMap.put("oid", order.getOid());
            hashMap.put("business_id", Integer.valueOf(order.getProductId()));
            double d = 0.0d;
            hashMap.put(ParamKeys.PARAM_DEST_LAT, Double.valueOf(order.endAddress != null ? order.endAddress.longitude : 0.0d));
            if (order.endAddress != null) {
                d = order.endAddress.latitude;
            }
            hashMap.put(ParamKeys.PARAM_DEST_LNG, Double.valueOf(d));
        }
        return GlobalWebUrl.buildUrl(priceDetail, hashMap);
    }

    public void paywayChange(PayInfo payInfo) {
        if (payInfo != null && !CollectionUtils.isEmpty((Collection) payInfo.payWayList)) {
            DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
            payMethodListParam.list = DateConverUtils.converPayMethodInfoList(payInfo.payWayList);
            payMethodListParam.groupList = DateConverUtils.convertPayGroupInfoList(payInfo.payGroupList);
            payMethodListParam.configInfo = DateConverUtils.convertPayPopupInfo(payInfo.payCfgInfo);
            setSceneParams();
            payMethodListParam.resourceId = this.f15265k;
            this.f15266l = new PayMethodAdapterImpl();
            DidiGlobalPayApiFactory.createDidiPay().startPayMethodListActivity(getHost(), requestCodeForHost(4), payMethodListParam, this.f15266l);
        }
    }

    /* renamed from: a */
    private void m10959a(DidiGlobalPayMethodListData.PayMethodListResult payMethodListResult) {
        PayInfo payInfo;
        if (payMethodListResult != null && payMethodListResult.selectedPayMethods != null) {
            int i = 0;
            for (DidiGlobalPayMethodListData.SelectedPayMethod next : payMethodListResult.selectedPayMethods) {
                if (next != null && next.channelId > 0 && (payInfo = this.f15259e) != null && !CollectionUtils.isEmpty((Collection) payInfo.payWayList)) {
                    for (PayWayModel.PayWayItem next2 : this.f15259e.payWayList) {
                        if (next2.channelID == next.channelId) {
                            next2.cardIndex = next.cardIndex;
                            next2.card = next.cardNo;
                            if (!TextUtils.isEmpty(next.iconUrl)) {
                                next2.card_org = next.iconUrl;
                            }
                            i |= next2.tag;
                            this.f15261g = next2.cardIndex;
                        }
                    }
                    this.f15260f = i;
                }
            }
        }
    }

    public void setSceneParams() {
        if (OrderStatus.isWaitResponse(CarOrderHelper.getOrder())) {
            this.f15263i = 1;
            this.f15264j = "wait_reply_page";
            this.f15265k = "7";
        }
        if (CarOrderHelper.isWaitDriver()) {
            this.f15263i = 2;
            this.f15264j = "wait_driver_page";
            this.f15265k = "6";
        }
        if (CarOrderHelper.isOnService()) {
            this.f15263i = 3;
            this.f15264j = "in_trip_page";
            this.f15265k = "5";
        }
    }

    class PayMethodAdapterImpl extends PayMethodSelectAdapter {
        public void refreshPayMethodList(DidiGlobalPayMethodListData.Entrance entrance) {
        }

        PayMethodAdapterImpl() {
        }
    }
}
