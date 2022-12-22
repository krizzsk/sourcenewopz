package com.didi.component.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.bfflib.business.BffBaseObject;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.cpf.CPFAuthWebActivity;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.TripListener;
import com.didi.component.business.oneconfig.AbsConfirmConfigState;
import com.didi.component.business.pageswitchparam.CreateOrderParam;
import com.didi.component.business.recovery.GlobalOrderRecovery;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarHttpHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.OrderBanUIUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.cache.CacheStore;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.ggk.GgkConstant;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.service.activity.risk.RiskInterceptPopup;
import com.didi.component.service.activity.risk.RiskUserActivity;
import com.didi.component.service.activity.risk.items.ItemType;
import com.didi.component.service.cancelreason.cache.CancelTripCache;
import com.didi.component.service.util.verifycard.IDialogOperation;
import com.didi.component.service.util.verifycard.IProgressOperation;
import com.didi.component.service.util.verifycard.IVerifyOperation;
import com.didi.component.service.util.verifycard.VerifyCardOperator;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.GGKUICreator;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.config.ButtonModel;
import com.didi.global.globalgenerickit.config.GGKConfigCallbackAdapter;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.global.globalgenerickit.drawer.GGKAbsDrawer;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.convert.GGKDrawerModelConverter;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKBaseDrawerModel;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel2;
import com.didi.global.globalgenerickit.model.sheet.ComponentSheetModel;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.dialog.LEGOBaseAlertDialogFragment;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel2;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.sdk.monitor.GlobalPaxTechTracker;
import com.didi.sdk.reversegeo.ReverseLocationStore;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.p171v2.store.Store;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.TEBridge;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.core.model.request.OrderParams;
import com.didi.travel.psnger.model.CommonPopUp;
import com.didi.travel.psnger.model.response.CarConfig;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.CarOrderPrepay;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.OrderBanPopInfo;
import com.didi.travel.psnger.model.response.PayEnterpriseInfo;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.PrePayTipsModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.CarOperationDataModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didi.xengine.register.XERegister;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceParam;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didichuxing.request.ServerParam;
import com.didiglobal.enginecore.callback.XEReqParamsCallback;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.travel.util.CollectionUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsSendOrderServicePresenter extends AbsServicePresenter {
    public static final int CREATE_ORDER_CONFIRMED = 1;
    public static final int CREATE_ORDER_FIRST = 0;

    /* renamed from: a */
    LEGODrawer f15533a = null;

    /* renamed from: b */
    private List<String> f15534b = new ArrayList();

    /* renamed from: c */
    private String f15535c;

    /* renamed from: d */
    private String f15536d;

    /* renamed from: e */
    private AlertDialogFragment f15537e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public GGKAbsDrawer f15538f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public GGKDrawer f15539g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LEGODrawer f15540h;

    /* renamed from: i */
    private AnyCarEstimateItemModel f15541i;

    /* renamed from: j */
    private Map<String, Object> f15542j;

    /* renamed from: k */
    private String f15543k;

    /* renamed from: l */
    private AnyCarEstimateItemModel f15544l;

    /* renamed from: m */
    private List<AnyCarEstimateItemModel> f15545m;
    protected BusinessContext mBusinessContext;
    protected int mDoubleCheck;
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());
    protected XEReqParamsCallback mNewOrderCallback = new XEReqParamsCallback<Map<String, Object>>() {
        public Map<String, Object> getRequestParams() {
            if (FormStore.getInstance().isInMiniBus()) {
                AbsSendOrderServicePresenter absSendOrderServicePresenter = AbsSendOrderServicePresenter.this;
                Map<String, Object> params = absSendOrderServicePresenter.m11252b(absSendOrderServicePresenter.mContext, AbsSendOrderServicePresenter.this.mDoubleCheck).getParams();
                if (CollectionUtils.isNotEmpty((Map<?, ?>) FormStore.getInstance().getSelectValueParams())) {
                    params.putAll(FormStore.getInstance().getSelectValueParams());
                }
                return params;
            }
            AbsSendOrderServicePresenter absSendOrderServicePresenter2 = AbsSendOrderServicePresenter.this;
            return absSendOrderServicePresenter2.m11252b(absSendOrderServicePresenter2.mContext, AbsSendOrderServicePresenter.this.mDoubleCheck).getParams();
        }
    };
    protected XEResponseCallback mPrepayCallback = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            String str2 = AbsSendOrderServicePresenter.this.TAG;
            LogUtils.m31493i(str2, "PrepayCallback onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
            CarOrderPrepay carOrderPrepay = new CarOrderPrepay();
            carOrderPrepay.parse(xEngineData.jsonObject.toString());
            if (carOrderPrepay.needPrepay()) {
                AbsSendOrderServicePresenter.this.m11248a(carOrderPrepay.prePayTipsModel);
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            String str2 = AbsSendOrderServicePresenter.this.TAG;
            LogUtils.m31493i(str2, "PrepayCallback onFailed:e = " + engineErrorException);
        }
    };
    protected XEResponseCallback mXELogicCallback = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            String str2 = AbsSendOrderServicePresenter.this.TAG;
            LogUtils.m31493i(str2, "onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
            CarOrder carOrder = new CarOrder();
            carOrder.setIsNewVersion(true);
            carOrder.parse(xEngineData.jsonObject.getAsJsonObject("data").toString());
            String str3 = AbsSendOrderServicePresenter.this.TAG;
            LogUtils.m31493i(str3, "onSuccess:carOrder = " + carOrder + ", isAvailable = " + carOrder.isAvailable());
            if (carOrder.isAvailable()) {
                AbsSendOrderServicePresenter.this.onCreateOrderSuccess(carOrder);
            } else {
                String str4 = AbsSendOrderServicePresenter.this.TAG;
                LogUtils.m31493i(str4, "onCreateOrderFail:traceId = " + xEngineData.traceId + ", code = " + carOrder.getErrorCode());
                GlobalPaxTechTracker.getInstance().trackNewOrderError(2, carOrder.getErrorCode(), carOrder.getErrorMsg(), xEngineData.traceId);
                AbsSendOrderServicePresenter.this.onCreateOrderFail(carOrder);
            }
            AbsSendOrderServicePresenter.this.m11247a(carOrder);
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            String str2 = AbsSendOrderServicePresenter.this.TAG;
            LogUtils.m31493i(str2, "onFailed:e = " + engineErrorException);
            CarOrder carOrder = new CarOrder();
            carOrder.setErrorCode(-1);
            carOrder.setThrowable(engineErrorException);
            GlobalPaxTechTracker.getInstance().trackNewOrderError(0, -1, "", "");
            AbsSendOrderServicePresenter.this.onCreateOrderError(carOrder);
            AbsSendOrderServicePresenter.this.m11247a(carOrder);
        }
    };

    /* renamed from: r */
    private Bundle f15546r;

    /* renamed from: s */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15547s = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsSendOrderServicePresenter.this.backToEstimate();
        }
    };

    /* renamed from: t */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15548t = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsSendOrderServicePresenter.this.backToEstimate();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: u */
    public GGKDrawer f15549u;

    /* renamed from: v */
    private BaseEventPublisher.OnEventListener<String> f15550v = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (AbsSendOrderServicePresenter.this.f15549u != null) {
                AbsSendOrderServicePresenter.this.f15549u.dismiss();
                GGKDrawer unused = AbsSendOrderServicePresenter.this.f15549u = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (str2.equals("cancel")) {
                    AbsSendOrderServicePresenter.this.gotoConfirmPage(false, "");
                } else if (str2.equals("continue")) {
                    FormStore.getInstance().setPassengerSheetKey((String) CacheStore.getInstance().getCache(GgkConstant.GGK_CACHE_KEY_4_ORDER_BLOCKED, ""));
                    AbsSendOrderServicePresenter.this.createOrder(0);
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public void backConfirmPricePage() {
    }

    /* access modifiers changed from: protected */
    public void backToEstimate() {
    }

    /* access modifiers changed from: protected */
    public String getCustomFeaturesParam() {
        return "";
    }

    /* access modifiers changed from: protected */
    public void showPaymentsPage() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11248a(PrePayTipsModel prePayTipsModel) {
        try {
            Intent intent = new Intent();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("sign", prePayTipsModel.sign);
            jsonObject.addProperty(Const.PayParams.SIGN_TYPE, prePayTipsModel.signType);
            jsonObject.addProperty(Const.PayParams.BIZ_CONTENT, prePayTipsModel.bizContent);
            jsonObject.addProperty(Const.PayParams.OUT_TRADE_ID, prePayTipsModel.outTradeId);
            jsonObject.addProperty("pixPrepay", Boolean.valueOf(prePayTipsModel.pixPrepay));
            intent.setPackage(this.mContext.getPackageName());
            intent.setAction("com.didi.global.unifiedPay.entrance");
            intent.putExtra("uni_pay_param", jsonObject.toString());
            startActivityForResult(intent, 77);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AbsSendOrderServicePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mBusinessContext = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f15546r = bundle;
        m11258c();
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_NEW_ORDER, XERequestKey.SCENE_NEW_ORDER, this.mXELogicCallback);
        xERegisterModel.required = true;
        xERegisterModel.requestParams = this.mNewOrderCallback;
        XERegister.registerTemplate(xERegisterModel);
        XERegisterModel xERegisterModel2 = new XERegisterModel(XERequestKey.REQUEST_KEY_UNIPAY, XERequestKey.SCENE_NEW_ORDER, this.mPrepayCallback);
        xERegisterModel2.addScene(XERequestKey.SCENE_TRIP);
        XERegister.registerTemplate(xERegisterModel2);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m11268f();
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_NEW_ORDER);
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_UNIPAY);
    }

    /* access modifiers changed from: protected */
    public void onSubscribeEventReceiver() {
        super.onSubscribeEventReceiver();
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_ONE_KEY_SEND_ORDER_BLOCKING_BY_CPF, this.f15547s);
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_BACK_TO_ESTIMATE, this.f15548t);
        subscribe(BaseEventKeys.Service.EVENT_CREATE_ORDER_BLOCK, this.f15550v);
    }

    /* access modifiers changed from: protected */
    public void onUnsubscribeEventReceiver() {
        super.onUnsubscribeEventReceiver();
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_ONE_KEY_SEND_ORDER_BLOCKING_BY_CPF, this.f15547s);
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_BACK_TO_ESTIMATE, this.f15548t);
        unsubscribe(BaseEventKeys.Service.EVENT_CREATE_ORDER_BLOCK, this.f15550v);
    }

    /* access modifiers changed from: protected */
    public void omegaTrackSendOrderErrorCode(int i) {
        String str;
        HashMap hashMap = new HashMap();
        String estimateModelTraceId = FormStore.getInstance().getEstimateModelTraceId();
        if (estimateModelTraceId != null) {
            hashMap.put("estimate_trace_id", estimateModelTraceId);
        }
        hashMap.put("err_no", Integer.valueOf(i));
        EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (estimateItem != null && estimateItem.payWayList != null) {
            Iterator<PayWayModel.PayWayItem> it = estimateItem.payWayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PayWayModel.PayWayItem next = it.next();
                if (next.isSelected() == 1) {
                    str = next.title;
                    break;
                }
            }
        }
        str = "";
        if (newEstimateItem != null) {
            hashMap.put("bubble_id", newEstimateItem.estimateId);
            hashMap.put("price_estimated", Float.valueOf(newEstimateItem.feeNumber));
        }
        hashMap.put("payment", str);
        GlobalOmegaUtils.trackEvent("gp_popup_view_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 72) {
            if (i != 100) {
                if (i != 76) {
                    if (i == 77 && i2 == -1 && intent != null) {
                        int intExtra = intent.getIntExtra("code", 0);
                        if (intExtra == 2) {
                            m11250a(false);
                        } else if (intExtra == 5) {
                            m11250a(true);
                        } else if (intExtra == 4) {
                            LEGODrawer lEGODrawer = this.f15540h;
                            if (lEGODrawer != null && lEGODrawer.isShowing()) {
                                this.f15540h.dismiss();
                            }
                            LEGODrawerModel2 lEGODrawerModel2 = new LEGODrawerModel2(this.mContext.getString(R.string.GRider_Prepay_Pix_payment_rejH), new LEGOBtnTextAndCallback(this.mContext.getString(R.string.GRider_Prepay_Replacement_GRsz), new LEGOOnAntiShakeClickListener() {
                                public void onAntiShakeClick(View view) {
                                    if (AbsSendOrderServicePresenter.this.f15540h != null) {
                                        AbsSendOrderServicePresenter.this.f15540h.dismiss();
                                    }
                                    AbsSendOrderServicePresenter.this.m11250a(true);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("k", "click");
                                    hashMap.put(RavenKey.VERSION, "change_btn");
                                    hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "timeout_page");
                                    GlobalOmegaUtils.trackEvent("ibt_gp_timeout_page_change_ck", (Map<String, Object>) hashMap);
                                }
                            }), new LEGOBtnTextAndCallback(this.mContext.getString(R.string.GRider_Prepay_Cancel_BjKC), new LEGOOnAntiShakeClickListener() {
                                public void onAntiShakeClick(View view) {
                                    if (AbsSendOrderServicePresenter.this.f15540h != null) {
                                        AbsSendOrderServicePresenter.this.f15540h.dismiss();
                                    }
                                    AbsSendOrderServicePresenter.this.m11250a(false);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("k", "click");
                                    hashMap.put(RavenKey.VERSION, "continue_btn");
                                    hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "timeout_page");
                                    GlobalOmegaUtils.trackEvent("ibt_gp_timeout_page_continue_ck", (Map<String, Object>) hashMap);
                                }
                            }));
                            lEGODrawerModel2.setClickOutsideCanCancel(false);
                            this.f15540h = LEGOUICreator.showDrawerTemplate(this.mContext, lEGODrawerModel2);
                            HashMap hashMap = new HashMap();
                            hashMap.put("k", "show");
                            hashMap.put(RavenKey.VERSION, "thepage");
                            hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "timeout_page");
                            GlobalOmegaUtils.trackEvent("ibt_gp_timeout_page_num_sw", (Map<String, Object>) hashMap);
                        }
                    }
                } else if (i2 == -1) {
                    backToEstimate();
                    GlobalOmegaUtils.trackEvent("Brazil_card_success_sw", getOmgeaParamsOfForceBindOnlinePayment());
                }
            } else if (i2 == -1 && intent != null && "credit_card".equals(intent.getStringExtra("type"))) {
                backToEstimate();
            }
        } else if (i2 == 0 && intent != null && intent.getBooleanExtra(BaseEventKeys.Confirm.INTENT_KEY_SIGN_CREDIT_CARD, false)) {
            backToEstimate();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11250a(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "continue");
        if (z) {
            FormStore.getInstance().setShowPayWayAfterEstimate(true);
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_WAITRSP_CANCEL, bundle);
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        if (i == 10001 && i2 == 2) {
            Intent intent = new Intent(this.mContext, RiskUserActivity.class);
            intent.putExtra(RiskUserActivity.RISK_USER_ACTIVITY_EXTRA_KEY, (String[]) this.f15534b.toArray(new String[0]));
            intent.putExtra("url", this.f15535c);
            intent.putExtra("extension", this.f15536d);
            startActivityForResult(intent, 100);
            HashMap hashMap = new HashMap();
            hashMap.put("bubble_id", SearchIdUploadManager.getInstance().getBubbleId());
            GlobalOmegaUtils.trackEvent("ibt_gp_safetyvarifypopup_varify_ck", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void createOrder(int i) {
        m11239a(this.mContext, i);
    }

    /* access modifiers changed from: protected */
    public void onCreateOrderSuccess(CarOrder carOrder) {
        if (carOrder == null || TextUtils.isEmpty(carOrder.oid)) {
            String str = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onCreateOrderSuccess:order = ");
            sb.append(carOrder);
            sb.append(", oid = ");
            sb.append(carOrder == null ? "" : carOrder.oid);
            LogUtils.m31492e(str, sb.toString());
        } else {
            Store orCreateStore = Store.getOrCreateStore(TravelUtil.generateCarOrderStoreKey(carOrder.oid));
            orCreateStore.setStore(Store.S_NONE_INVOKE_ARGS, carOrder);
            orCreateStore.setOuterLifecycle(this.mComponentProxy.getSession().getLifecycle());
            this.mComponentProxy.updateOrderId(this.mComponentParams.pageID, carOrder.getOid());
        }
        onOrderCreated(carOrder);
    }

    /* access modifiers changed from: protected */
    public void onCreateOrderFail(CarOrder carOrder) {
        onOrderCreateFail(carOrder);
    }

    /* access modifiers changed from: protected */
    public void onCreateOrderError(CarOrder carOrder) {
        onOrderCreateFail(carOrder);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11247a(CarOrder carOrder) {
        GlobalOmegaUtils.trackEvent("gp_confirm_newOrder_request_result", Constants.ERROR_CODE, carOrder.getErrorCode() + "");
        dismissProgressDialog();
    }

    /* renamed from: b */
    private boolean m11256b(CarOrder carOrder) {
        if (carOrder.ConfigJson == null) {
            return false;
        }
        JSONObject jSONObject = carOrder.ConfigJson;
        if (jSONObject.has("passenger_newSheet")) {
            GGKConfigManager.legoConfig(getHost().getActivity(), jSONObject.optJSONObject("passenger_newSheet"), "passenger_newSheet", new GGKConfigCallbackAdapter() {
                public boolean sheetClickLis(LEGODrawer lEGODrawer, ButtonModel buttonModel, String str) {
                    if (lEGODrawer == null) {
                        return false;
                    }
                    DRouter.build(str).start(AbsSendOrderServicePresenter.this.mContext);
                    if (buttonModel.nodismiss == 1) {
                        return false;
                    }
                    lEGODrawer.dismiss();
                    return true;
                }
            });
            return true;
        } else if (!jSONObject.has("passenger_newPopup")) {
            return false;
        } else {
            GGKConfigManager.legoConfig(getHost().getActivity(), jSONObject.optJSONObject("passenger_newPopup"), "passenger_newPopup", new GGKConfigCallbackAdapter() {
                public boolean alertClickLis(LEGOBaseAlertDialogFragment lEGOBaseAlertDialogFragment, ButtonModel buttonModel, String str) {
                    if (lEGOBaseAlertDialogFragment == null) {
                        return false;
                    }
                    DRouter.build(str).start(AbsSendOrderServicePresenter.this.mContext);
                    if (buttonModel.nodismiss == 1) {
                        return false;
                    }
                    lEGOBaseAlertDialogFragment.dismiss();
                    return true;
                }
            });
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean orderIntercept(CarOrder carOrder) {
        if (TextUtils.isEmpty(carOrder.GGKJson)) {
            return false;
        }
        try {
            String obj = new JSONObject(carOrder.GGKJson).getJSONArray("passenger_sheet").get(0).toString();
            if (TextUtils.isEmpty(obj) || !NationComponentDataUtil.isLoginNow()) {
                return false;
            }
            ComponentSheetModel parse = new ComponentSheetModel().parse(obj);
            GGKBaseDrawerModel convert2GGKDrawerModel = GGKDrawerModelConverter.convert2GGKDrawerModel(parse);
            convert2GGKDrawerModel.setClickOutsideCanCancel(false);
            convert2GGKDrawerModel.setmBackPressedEnabled(false);
            this.f15549u = GGKUICreator.showDrawerModel(this.mContext, convert2GGKDrawerModel);
            CacheStore.getInstance().addCache(GgkConstant.GGK_CACHE_KEY_4_ORDER_BLOCKED, parse.f22194id);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private void m11239a(Context context, int i) {
        EstimateItemModel estimateItemModel;
        String str;
        if (FormStore.getInstance().getStartAddress() == null) {
            GLog.m7965d("quxiaozaifadan", "startaddress null");
            return;
        }
        if (CancelTripCache.getInstance().isUsingCachedEstimateParams()) {
            str = CancelTripCache.getInstance().getEstimateTraceId();
            estimateItemModel = CancelTripCache.getInstance().getNewEstimateModel();
        } else {
            estimateItemModel = FormStore.getInstance().getNewEstimateItem();
            str = FormStore.getInstance().getEstimateModelTraceId();
            if (!TextUtils.isEmpty(this.f15543k)) {
                str = this.f15543k;
            }
            if (str == null) {
                str = null;
            }
            CancelTripCache.getInstance().setEstimateTraceId(str);
            CancelTripCache.getInstance().setEstimateTime(System.currentTimeMillis());
        }
        if ((TextUtils.isEmpty(str) || (estimateItemModel == null && this.f15541i == null)) && GlobalApolloUtil.isSendOrderParamsErrorBackup()) {
            CarOrder carOrder = new CarOrder();
            carOrder.errno = 596;
            onOrderCreateFail(carOrder);
            GLog.m7965d("quxiaozaifadan", "isSendOrderParamsErrorBackup");
            GlobalOmegaUtils.sendOrderParamsEstimateNull();
            return;
        }
        OrderParams b = m11252b(context, i);
        if (!b.isEstimateInfoMatch()) {
            CarOrder carOrder2 = new CarOrder();
            carOrder2.errno = 596;
            GLog.m7965d("quxiaozaifadan", "isEstimateInfoMatch");
            onOrderCreateFail(carOrder2);
            return;
        }
        m11255b();
        LogUtils.m31493i(this.TAG, "createOrder");
        this.mDoubleCheck = i;
        XEngineReq.pageRequest(XERequestKey.SCENE_NEW_ORDER);
        GLog.m7964d("pNewOrder : " + b.getParams().toString());
        GlobalOmegaUtils.trackEvent("gp_confirm_newOrder_request");
    }

    /* renamed from: b */
    private void m11255b() {
        int i;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        AnyCarEstimateItemModel anyCarEstimateItemModel;
        int i2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONObject optJSONObject6;
        String str = null;
        if (this.f15544l != null || CollectionUtil.isEmpty((Collection<?>) this.f15545m)) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem != null && newEstimateItem.carConfig != null) {
                if (!(newEstimateItem.carBreakModel == null || newEstimateItem.carBreakModel.carBreakMember == null || newEstimateItem.carBreakModel.carBreakMember.passengerNewSheet == null)) {
                    try {
                        JSONArray optJSONArray = new JSONObject(newEstimateItem.carBreakModel.carBreakMember.passengerNewSheet.toString()).optJSONArray("list");
                        if (!(optJSONArray == null || (optJSONObject = optJSONArray.getJSONObject(0).optJSONObject("normal")) == null || (optJSONObject2 = optJSONObject.optJSONObject("data")) == null)) {
                            optJSONObject2.optInt("buy_type");
                            str = optJSONObject2.optString("package_id");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(str) && FormStore.getInstance().getPassPackageId() != 0) {
                    str = String.valueOf(FormStore.getInstance().getPassPackageId());
                }
                String str2 = str;
                int i3 = (FormStore.getInstance().isEstimatePassConfirm() || FormStore.getInstance().getIsDialogPassConfirm()) ? 1 : 2;
                if (FormStore.getInstance().getIsPassShowDialog()) {
                    i = 1;
                } else {
                    i = (FormStore.getInstance().isEstimatePassConfirm() || FormStore.getInstance().isHasEstimatePassData()) ? 10 : 0;
                }
                if (!TextUtils.isEmpty(str2) && i > 0) {
                    CarRequest.tripBuy(this.mContext, newEstimateItem.carConfig.estimateId, str2, i3, i, new BffResponseListener<BffBaseObject>() {
                        public void onSuccess(BffBaseObject bffBaseObject) {
                            super.onSuccess(bffBaseObject);
                            GlobalOmegaUtils.trackEvent("ibt_bp_passpurchase_bt");
                            HashMap hashMap = new HashMap();
                            if (FormStore.getInstance().isEstimatePassConfirm()) {
                                hashMap.put("is_checked", 2);
                            } else {
                                hashMap.put("is_checked", 1);
                            }
                            GlobalOmegaUtils.trackEvent("ibt_gp_bubblepage_ckrequest_checkboxstatus_bt", (Map<String, Object>) hashMap);
                        }

                        public void onError(BffBaseObject bffBaseObject) {
                            super.onError(bffBaseObject);
                        }

                        public void onFail(BffBaseObject bffBaseObject) {
                            super.onFail(bffBaseObject);
                        }

                        public void onFinish(BffBaseObject bffBaseObject) {
                            super.onFinish(bffBaseObject);
                            FormStore.getInstance().setEstimatePassConfirm(false);
                            FormStore.getInstance().setIsDialogPassConfirm(false);
                            FormStore.getInstance().setIsPassShowDialog(false);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        Iterator<AnyCarEstimateItemModel> it = this.f15545m.iterator();
        while (true) {
            if (!it.hasNext()) {
                anyCarEstimateItemModel = null;
                break;
            }
            anyCarEstimateItemModel = it.next();
            if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember.passengerNewSheet == null)) {
                try {
                    JSONArray optJSONArray2 = new JSONObject(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember.passengerNewSheet.toString()).optJSONArray("list");
                    if (!(optJSONArray2 == null || optJSONArray2.length() <= 0 || optJSONArray2.getJSONObject(0) == null || (optJSONObject5 = optJSONArray2.getJSONObject(0).optJSONObject("normal")) == null || (optJSONObject6 = optJSONObject5.optJSONObject("data")) == null || TextUtils.isEmpty(optJSONObject6.optString("package_id")))) {
                        break;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (anyCarEstimateItemModel != null && anyCarEstimateItemModel.estimatePass != null) {
                break;
            }
        }
        if (anyCarEstimateItemModel != null && anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig != null) {
            if (!(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember.passengerNewSheet == null)) {
                try {
                    JSONArray optJSONArray3 = new JSONObject(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember.passengerNewSheet.toString()).optJSONArray("list");
                    if (!(optJSONArray3 == null || (optJSONObject3 = optJSONArray3.getJSONObject(0).optJSONObject("normal")) == null || (optJSONObject4 = optJSONObject3.optJSONObject("data")) == null)) {
                        optJSONObject4.optInt("buy_type");
                        str = optJSONObject4.optString("package_id");
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str) && FormStore.getInstance().getPassPackageId() != 0) {
                str = String.valueOf(FormStore.getInstance().getPassPackageId());
            }
            String str3 = str;
            int i4 = (FormStore.getInstance().isEstimatePassConfirm() || FormStore.getInstance().getIsDialogPassConfirm()) ? 1 : 2;
            if (FormStore.getInstance().getIsPassShowDialog()) {
                i2 = 1;
            } else {
                i2 = (FormStore.getInstance().isEstimatePassConfirm() || FormStore.getInstance().isHasEstimatePassData()) ? 10 : 0;
            }
            if (!TextUtils.isEmpty(str3) && i2 > 0) {
                CarRequest.tripBuy(this.mContext, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.estimateId, str3, i4, i2, new BffResponseListener<BffBaseObject>() {
                    public void onSuccess(BffBaseObject bffBaseObject) {
                        super.onSuccess(bffBaseObject);
                        GlobalOmegaUtils.trackEvent("ibt_bp_passpurchase_bt");
                        HashMap hashMap = new HashMap();
                        if (FormStore.getInstance().isEstimatePassConfirm()) {
                            hashMap.put("is_checked", 2);
                        } else {
                            hashMap.put("is_checked", 1);
                        }
                        GlobalOmegaUtils.trackEvent("ibt_gp_bubblepage_ckrequest_checkboxstatus_bt", (Map<String, Object>) hashMap);
                    }

                    public void onError(BffBaseObject bffBaseObject) {
                        super.onError(bffBaseObject);
                    }

                    public void onFail(BffBaseObject bffBaseObject) {
                        super.onFail(bffBaseObject);
                    }

                    public void onFinish(BffBaseObject bffBaseObject) {
                        super.onFinish(bffBaseObject);
                        FormStore.getInstance().setEstimatePassConfirm(false);
                        FormStore.getInstance().setIsDialogPassConfirm(false);
                        FormStore.getInstance().setIsPassShowDialog(false);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0326 A[Catch:{ Exception -> 0x040f }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x03ff A[Catch:{ Exception -> 0x040f }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0401 A[Catch:{ Exception -> 0x040f }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0420  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0425  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0432  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x043d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x049f  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0557 A[Catch:{ Exception -> 0x055b }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x056b  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x05e0 A[Catch:{ Exception -> 0x05e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0666  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0715  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x072e  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x07e0  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x07ee  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0814 A[SYNTHETIC, Splitter:B:320:0x0814] */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0877  */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x0885  */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x08ad A[SYNTHETIC, Splitter:B:341:0x08ad] */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x08e1  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x025b  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.travel.psnger.core.model.request.OrderParams m11252b(android.content.Context r22, int r23) {
        /*
            r21 = this;
            r1 = r21
            com.didi.component.service.cancelreason.cache.CancelTripCache r0 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            boolean r2 = r0.isUsingCachedEstimateParams()
            com.didi.component.business.data.form.FormStore r3 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.sdk.address.address.entity.Address r4 = r3.getStartAddress()
            java.lang.String r0 = r4.toString()
            java.lang.String r5 = "ccclxscreateorder"
            com.didi.component.common.util.GLog.m7968e(r5, r0)
            com.didi.sdk.address.address.entity.Address r0 = r3.getEndAddress()
            long r5 = r3.getTransportTime()
            com.didi.travel.psnger.core.model.request.OrderParams r7 = new com.didi.travel.psnger.core.model.request.OrderParams
            r7.<init>()
            if (r4 == 0) goto L_0x0041
            r7.setStartAddress(r4)
            java.lang.String r8 = r1.m11237a((com.didi.sdk.address.address.entity.Address) r4)
            java.lang.String r9 = "fromAddressAll"
            r7.addParam(r9, r8)
            java.lang.String r8 = r4.hideAddress
            if (r8 == 0) goto L_0x0041
            java.lang.String r8 = r4.hideAddress
            java.lang.String r9 = "startingVagueName"
            r7.addParam(r9, r8)
        L_0x0041:
            if (r0 == 0) goto L_0x005a
            r7.setEndAddress(r0)
            java.lang.String r8 = r1.m11237a((com.didi.sdk.address.address.entity.Address) r0)
            java.lang.String r9 = "toAddressAll"
            r7.addParam(r9, r8)
            java.lang.String r8 = r0.hideAddress
            if (r8 == 0) goto L_0x005a
            java.lang.String r8 = r0.hideAddress
            java.lang.String r9 = "destVagueName"
            r7.addParam(r9, r8)
        L_0x005a:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r23)
            java.lang.String r9 = "double_check"
            r7.addParam(r9, r8)
            java.lang.String r8 = com.didi.component.business.util.NationComponentDataUtil.getMapTypeString()
            java.lang.String r9 = "mapType"
            r7.addParam(r9, r8)
            int r8 = r3.Bid
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r9 = r1.f15541i
            if (r9 == 0) goto L_0x0078
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r8 = r9.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r8 = r8.carConfig
            int r8 = r8.carBussinessId
        L_0x0078:
            r7.setBusinessId(r8)
            r7.setEndAddress(r0)
            r8 = 0
            r10 = 1
            r11 = 0
            int r0 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x0090
            r8 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r8
            r7.setDepartureTime(r5)
            r7.setBookingType(r10)
            goto L_0x0093
        L_0x0090:
            r7.setBookingType(r11)
        L_0x0093:
            int r0 = r3.getEnterpriseFlag()
            r7.setEnterpriseFlag(r0)
            if (r2 == 0) goto L_0x00ad
            com.didi.component.service.cancelreason.cache.CancelTripCache r0 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            int r0 = r0.getComboType()
            com.didi.component.service.cancelreason.cache.CancelTripCache r5 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            boolean r5 = r5.isCarPool()
            goto L_0x00c8
        L_0x00ad:
            int r0 = r3.getCurrentComboType()
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r5 = r1.f15541i
            if (r5 == 0) goto L_0x00bb
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r5.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r0 = r0.carConfig
            int r0 = r0.carComboType
        L_0x00bb:
            com.didi.component.service.cancelreason.cache.CancelTripCache r5 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            r5.setComboType(r0)
            r5 = 4
            if (r0 != r5) goto L_0x00c7
            r5 = 1
            goto L_0x00c8
        L_0x00c7:
            r5 = 0
        L_0x00c8:
            java.lang.String r6 = "pool_seat"
            if (r5 == 0) goto L_0x00d7
            int r8 = r3.getSeatCount()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.addParam(r6, r8)
        L_0x00d7:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r8 = "car_pool"
            r7.addParam(r8, r5)
            boolean r5 = r3.isCarpoolShow()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r9 = "carpool_show"
            r7.addParam(r9, r5)
            com.didi.component.business.data.form.FormStore r5 = com.didi.component.business.data.form.FormStore.getInstance()
            boolean r5 = r5.isFromOpenRide()
            if (r5 == 0) goto L_0x0108
            com.didi.travel.psnger.model.response.PinCodeInfoResult r5 = r3.getDriverInfo()
            if (r5 == 0) goto L_0x0108
            com.didi.travel.psnger.model.response.PinCodeInfoResult r5 = r3.getDriverInfo()
            java.lang.String r5 = r5.driverId
            java.lang.String r12 = "openride_driver_id"
            r7.addParam(r12, r5)
        L_0x0108:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r5 = "combo_type"
            r7.addParam(r5, r0)
            r7.setTipPrice(r11)
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getPassengerSheetKey()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x012d
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getPassengerSheetKey()
            r7.setPassengerSheetKey(r0)
        L_0x012d:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()     // Catch:{ Exception -> 0x0158 }
            int r12 = r0.getCarLevel()     // Catch:{ Exception -> 0x0158 }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i     // Catch:{ Exception -> 0x0156 }
            if (r0 == 0) goto L_0x0141
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i     // Catch:{ Exception -> 0x0156 }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem     // Catch:{ Exception -> 0x0156 }
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r0 = r0.carConfig     // Catch:{ Exception -> 0x0156 }
            int r12 = r0.carLevel     // Catch:{ Exception -> 0x0156 }
        L_0x0141:
            java.lang.String r0 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0156 }
            r7.setCarLevelId(r0)     // Catch:{ Exception -> 0x0156 }
            java.lang.String r0 = r21.getCustomFeaturesParam()     // Catch:{ Exception -> 0x0156 }
            boolean r13 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0156 }
            if (r13 != 0) goto L_0x015d
            r7.setCustomFeatures(r0)     // Catch:{ Exception -> 0x0156 }
            goto L_0x015d
        L_0x0156:
            r0 = move-exception
            goto L_0x015a
        L_0x0158:
            r0 = move-exception
            r12 = 0
        L_0x015a:
            r0.printStackTrace()
        L_0x015d:
            if (r2 == 0) goto L_0x0171
            com.didi.component.service.cancelreason.cache.CancelTripCache r0 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            java.lang.String r0 = r0.getEstimateTraceId()
            com.didi.component.service.cancelreason.cache.CancelTripCache r14 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r14 = r14.getNewEstimateModel()
            r13 = r0
            goto L_0x019e
        L_0x0171:
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r14 = r3.getNewEstimateItem()
            java.lang.String r0 = r3.getEstimateModelTraceId()
            java.lang.String r15 = r1.f15543k
            boolean r15 = android.text.TextUtils.isEmpty(r15)
            if (r15 != 0) goto L_0x0183
            java.lang.String r0 = r1.f15543k
        L_0x0183:
            if (r0 == 0) goto L_0x0186
            goto L_0x0187
        L_0x0186:
            r0 = 0
        L_0x0187:
            com.didi.component.service.cancelreason.cache.CancelTripCache r15 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            r15.setEstimateTraceId(r0)
            com.didi.component.service.cancelreason.cache.CancelTripCache r15 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            r16 = r14
            long r13 = java.lang.System.currentTimeMillis()
            r15.setEstimateTime(r13)
            r13 = r0
            r14 = r16
        L_0x019e:
            r7.setEstimateTraceId(r13)
            java.lang.String r15 = "count_price_type"
            if (r14 == 0) goto L_0x01e2
            float r10 = r14.feeNumber
            r7.setEstimatePrice(r10)
            java.lang.String r10 = r14.estimateId
            r7.setEstimateId(r10)
            int r10 = r7.getBusinessId()
            int r0 = r14.getCarBussinessId()
            if (r10 != r0) goto L_0x01bf
            int r0 = r14.getCarLevel()
            if (r12 == r0) goto L_0x01c2
        L_0x01bf:
            r7.setEstimateInfoMatch(r11)
        L_0x01c2:
            boolean r0 = com.didi.component.business.util.EstimateUtils.isFixedPricingTypeShowing()
            if (r0 == 0) goto L_0x01d2
            r0 = 101(0x65, float:1.42E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)
            r7.addParam(r15, r10)
            goto L_0x01db
        L_0x01d2:
            int r0 = r14.countPriceType
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r15, r0)
        L_0x01db:
            com.didi.component.service.cancelreason.cache.CancelTripCache r0 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            r0.setEstimateModel((com.didi.travel.psnger.model.response.estimate.EstimateItemModel) r14)
        L_0x01e2:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i
            if (r0 == 0) goto L_0x0224
            float r0 = r0.feeNumber
            r7.setEstimatePrice(r0)
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i
            java.lang.String r0 = r0.estimateId
            r7.setEstimateId(r0)
            int r0 = r7.getBusinessId()
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r10 = r1.f15541i
            int r10 = r10.getCarBussinessId()
            if (r0 != r10) goto L_0x0206
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i
            int r0 = r0.getCarLevel()
            if (r12 == r0) goto L_0x0209
        L_0x0206:
            r7.setEstimateInfoMatch(r11)
        L_0x0209:
            boolean r0 = com.didi.component.business.util.EstimateUtils.isFixedPricingTypeShowing()
            if (r0 == 0) goto L_0x0219
            r0 = 101(0x65, float:1.42E-43)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r15, r0)
            goto L_0x0224
        L_0x0219:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i
            int r0 = r0.countPriceType
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r15, r0)
        L_0x0224:
            com.didichuxing.bigdata.dp.locsdk.DIDILocationManager r0 = com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager.getInstance(r22)
            com.didichuxing.bigdata.dp.locsdk.DIDILocation r0 = r0.getLastKnownLocation()
            r7.setLastKnownLocation(r0)
            r1.m11246a((com.didi.travel.psnger.core.model.request.OrderParams) r7)
            com.didi.travel.psnger.core.model.request.OrderParams$DTSDKOrder412Param r0 = r21.m11270g()
            r7.setOrder412Param(r0)
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()
            java.lang.String r10 = "special_start"
            if (r0 == 0) goto L_0x024a
            r12 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r12)
            r7.addParam(r10, r0)
            goto L_0x0251
        L_0x024a:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
            r7.addParam(r10, r0)
        L_0x0251:
            java.lang.String r0 = r3.getWayPointAddressListJsonArray()
            boolean r10 = android.text.TextUtils.isEmpty(r0)
            if (r10 != 0) goto L_0x0260
            java.lang.String r10 = "stopover_point"
            r7.addParam(r10, r0)
        L_0x0260:
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()
            java.lang.String r10 = "station_guide_name"
            java.lang.String r12 = "station_walk_guide_link"
            if (r0 == 0) goto L_0x02aa
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()
            if (r0 == 0) goto L_0x02aa
            com.didi.map.global.component.departure.model.AddressWalkGuide r17 = r0.getWalkGuide()
            if (r17 == 0) goto L_0x02aa
            com.didi.map.global.component.departure.model.AddressWalkGuide r17 = r0.getWalkGuide()
            java.lang.String r17 = r17.getGuidePhotoH5()
            boolean r17 = android.text.TextUtils.isEmpty(r17)
            if (r17 != 0) goto L_0x02aa
            com.didi.map.global.component.departure.model.DepartureAddress r17 = r3.getAirPotAddress()
            com.didi.sdk.address.address.entity.Address r17 = r17.getAddress()
            if (r17 == 0) goto L_0x02aa
            com.didi.map.global.component.departure.model.AddressWalkGuide r0 = r0.getWalkGuide()
            java.lang.String r0 = r0.getGuidePhotoH5()
            r7.addParam(r12, r0)
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()
            com.didi.sdk.address.address.entity.Address r0 = r0.getAddress()
            java.lang.String r0 = r0.displayName
            r7.addParam(r10, r0)
        L_0x02aa:
            android.content.Context r0 = r1.mContext
            java.lang.String r0 = com.didi.component.business.util.GlobalSPUtil.getLastFaceSessionId(r0)
            if (r0 == 0) goto L_0x02cb
            java.lang.String r11 = "last_face_session_id"
            r7.addParam(r11, r0)
            android.content.Context r0 = r1.mContext
            boolean r0 = com.didi.component.business.util.GlobalSPUtil.getLastFacePassed(r0)
            if (r0 == 0) goto L_0x02c1
            r0 = 1
            goto L_0x02c2
        L_0x02c1:
            r0 = 2
        L_0x02c2:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r11 = "last_face_passed"
            r7.addParam(r11, r0)
        L_0x02cb:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r11 = r0.getNewEstimateItem()
            java.lang.String r0 = "dispatch_fee"
            if (r11 == 0) goto L_0x02f4
            r18 = r13
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r13 = r11.dispatchFeeChoice     // Catch:{ Exception -> 0x02f0 }
            if (r13 == 0) goto L_0x02f6
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r13 = r11.dispatchFeeChoice     // Catch:{ Exception -> 0x02f0 }
            java.lang.String r13 = r13.selectedValue     // Catch:{ Exception -> 0x02f0 }
            int r13 = java.lang.Integer.parseInt(r13)     // Catch:{ Exception -> 0x02f0 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x02f0 }
            r7.addParam(r0, r13)     // Catch:{ Exception -> 0x02f0 }
            r19 = r4
            r13 = 0
            goto L_0x0308
        L_0x02f0:
            r19 = r4
            r13 = 0
            goto L_0x0301
        L_0x02f4:
            r18 = r13
        L_0x02f6:
            r19 = r4
            r13 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x0301 }
            r7.addParam(r0, r4)     // Catch:{ Exception -> 0x0301 }
            goto L_0x0308
        L_0x0301:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            r7.addParam(r0, r4)
        L_0x0308:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getStartParkingProperty()
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r13 = "specialPoiParkingProperty"
            if (r4 != 0) goto L_0x031b
            r7.addParam(r13, r0)
        L_0x031b:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x040f }
            r4.<init>()     // Catch:{ Exception -> 0x040f }
            boolean r20 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x040f }
            if (r20 != 0) goto L_0x0329
            r4.put(r13, r0)     // Catch:{ Exception -> 0x040f }
        L_0x0329:
            java.lang.String r0 = "showInterceptView"
            com.didi.component.business.data.form.FormStore r13 = com.didi.component.business.data.form.FormStore.getInstance()     // Catch:{ Exception -> 0x040f }
            boolean r13 = r13.isShowInterceptorPop()     // Catch:{ Exception -> 0x040f }
            r4.put(r0, r13)     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            if (r0 == 0) goto L_0x0367
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            com.didi.sdk.address.address.entity.Address r0 = r0.getAddress()     // Catch:{ Exception -> 0x040f }
            if (r0 == 0) goto L_0x0367
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            com.didi.sdk.address.address.entity.Address r0 = r0.getAddress()     // Catch:{ Exception -> 0x040f }
            java.lang.String r0 = r0.getDisplayName()     // Catch:{ Exception -> 0x040f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x040f }
            if (r0 != 0) goto L_0x0367
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            com.didi.sdk.address.address.entity.Address r0 = r0.getAddress()     // Catch:{ Exception -> 0x040f }
            java.lang.String r0 = r0.getDisplayName()     // Catch:{ Exception -> 0x040f }
            r4.put(r10, r0)     // Catch:{ Exception -> 0x040f }
        L_0x0367:
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            if (r0 == 0) goto L_0x03ae
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x040f }
            if (r0 == 0) goto L_0x03ae
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressWalkGuide r0 = r0.getWalkGuide()     // Catch:{ Exception -> 0x040f }
            if (r0 == 0) goto L_0x03ae
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressWalkGuide r0 = r0.getWalkGuide()     // Catch:{ Exception -> 0x040f }
            java.lang.String r0 = r0.getGuidePhotoH5()     // Catch:{ Exception -> 0x040f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x040f }
            if (r0 != 0) goto L_0x03ae
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressWalkGuide r0 = r0.getWalkGuide()     // Catch:{ Exception -> 0x040f }
            java.lang.String r0 = r0.getGuidePhotoH5()     // Catch:{ Exception -> 0x040f }
            r4.put(r12, r0)     // Catch:{ Exception -> 0x040f }
        L_0x03ae:
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            if (r0 == 0) goto L_0x03f7
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x040f }
            if (r0 == 0) goto L_0x03f7
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressWalkGuide r0 = r0.getWalkGuide()     // Catch:{ Exception -> 0x040f }
            if (r0 == 0) goto L_0x03f7
            com.didi.map.global.component.departure.model.DepartureAddress r0 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressExtendInfo r0 = r0.getExtendInfo()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressWalkGuide r0 = r0.getWalkGuide()     // Catch:{ Exception -> 0x040f }
            java.lang.String r0 = r0.getGuidePhoto()     // Catch:{ Exception -> 0x040f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x040f }
            if (r0 != 0) goto L_0x03f7
            java.lang.String r0 = "walk_guide_photo"
            com.didi.map.global.component.departure.model.DepartureAddress r10 = r3.getAirPotAddress()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressExtendInfo r10 = r10.getExtendInfo()     // Catch:{ Exception -> 0x040f }
            com.didi.map.global.component.departure.model.AddressWalkGuide r10 = r10.getWalkGuide()     // Catch:{ Exception -> 0x040f }
            java.lang.String r10 = r10.getGuidePhoto()     // Catch:{ Exception -> 0x040f }
            r4.put(r0, r10)     // Catch:{ Exception -> 0x040f }
        L_0x03f7:
            java.lang.String r0 = "is_show_real_pic_in_xpanel"
            boolean r10 = r3.isShowRealPicInXpanel()     // Catch:{ Exception -> 0x040f }
            if (r10 != 0) goto L_0x0401
            r10 = 1
            goto L_0x0402
        L_0x0401:
            r10 = 0
        L_0x0402:
            r4.put(r0, r10)     // Catch:{ Exception -> 0x040f }
            java.lang.String r0 = "ibt_map_data"
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x040f }
            r7.addParam(r0, r4)     // Catch:{ Exception -> 0x040f }
            goto L_0x0413
        L_0x040f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0413:
            java.lang.String r0 = r3.getFlightNum()
            r7.setFlightNum(r0)
            if (r11 == 0) goto L_0x0425
            com.didi.travel.psnger.model.response.estimate.NewEsimateCompanyOperation r0 = r11.company
            if (r0 == 0) goto L_0x0425
            com.didi.travel.psnger.model.response.estimate.NewEsimateCompanyOperation r0 = r11.company
            com.didi.travel.psnger.model.response.TaxiCompanyListModel$CompanyModel r13 = r0.companyModel
            goto L_0x0426
        L_0x0425:
            r13 = 0
        L_0x0426:
            java.lang.String r0 = "1"
            if (r13 == 0) goto L_0x043d
            java.lang.String r4 = r13.f44227id
            boolean r4 = r0.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x043d
            r4 = 2
            java.lang.Integer r10 = java.lang.Integer.valueOf(r4)
            java.lang.String r4 = "assign_company_type"
            r7.addParam(r4, r10)
            goto L_0x0464
        L_0x043d:
            if (r13 == 0) goto L_0x0464
            java.lang.String r4 = r13.f44227id
            boolean r4 = com.didi.sdk.util.TextUtil.isEmpty(r4)
            if (r4 != 0) goto L_0x0464
            java.lang.String r4 = r13.f44227id
            java.lang.String r10 = "0"
            boolean r4 = r10.equals(r4)
            if (r4 != 0) goto L_0x0464
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            java.lang.String r10 = r13.f44227id
            r4.put(r10)
            java.lang.String r4 = r4.toString()
            java.lang.String r10 = "company_group_ids"
            r7.addParam(r10, r4)
        L_0x0464:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r10 = ""
            r4.append(r10)
            com.didi.component.business.data.form.FormStore r10 = com.didi.component.business.data.form.FormStore.getInstance()
            int r10 = r10.getCarpoolOrderScene()
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            java.lang.String r10 = "carpool_order_scene"
            r7.addParam(r10, r4)
            boolean r4 = r3.isTwoPriceBiz()
            if (r4 == 0) goto L_0x049d
            int r4 = r3.getSeatCount()
            r11 = 2
            if (r4 > r11) goto L_0x049d
            r7.addParam(r10, r0)
            int r0 = r3.getSeatCount()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r6, r0)
        L_0x049d:
            if (r2 == 0) goto L_0x04a7
            com.didi.component.service.cancelreason.cache.CancelTripCache r0 = com.didi.component.service.cancelreason.cache.CancelTripCache.getInstance()
            r2 = 0
            r0.setUsingCacheEstimateParams(r2)
        L_0x04a7:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i
            java.lang.String r2 = "delivery_info"
            java.lang.String r4 = "intercepted"
            if (r0 == 0) goto L_0x04dd
            com.didi.travel.psnger.model.response.CarConfig$ConfirmActionInfo r0 = r21.getConfirmActionInfo()
            if (r0 == 0) goto L_0x04dd
            boolean r0 = r0.validated()
            if (r0 == 0) goto L_0x04dd
            org.json.JSONObject r0 = r3.getDeliveryInfo()
            if (r0 == 0) goto L_0x04dd
            java.lang.String r11 = r0.toString()
            r12 = 1
            r0.put(r4, r12)     // Catch:{ JSONException -> 0x04d9 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x04d9 }
            r0.<init>(r11)     // Catch:{ JSONException -> 0x04d9 }
            r0.remove(r4)     // Catch:{ JSONException -> 0x04d9 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x04d9 }
            r7.addParam(r2, r0)     // Catch:{ JSONException -> 0x04d9 }
            goto L_0x04dd
        L_0x04d9:
            r0 = move-exception
            r0.printStackTrace()
        L_0x04dd:
            if (r14 == 0) goto L_0x0511
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.CarConfig$ConfirmActionInfo r0 = r0.getConfirmActionInfo()
            if (r0 == 0) goto L_0x0511
            boolean r0 = r0.validated()
            if (r0 == 0) goto L_0x0511
            org.json.JSONObject r0 = r3.getDeliveryInfo()
            if (r0 == 0) goto L_0x0511
            java.lang.String r11 = r0.toString()
            r12 = 1
            r0.put(r4, r12)     // Catch:{ JSONException -> 0x050d }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x050d }
            r0.<init>(r11)     // Catch:{ JSONException -> 0x050d }
            r0.remove(r4)     // Catch:{ JSONException -> 0x050d }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x050d }
            r7.addParam(r2, r0)     // Catch:{ JSONException -> 0x050d }
            goto L_0x0511
        L_0x050d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0511:
            java.util.Map r2 = r7.getParams()
            if (r2 == 0) goto L_0x05a4
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i
            if (r0 == 0) goto L_0x05a4
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r0 = r0.carConfig
            if (r0 == 0) goto L_0x055f
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r0 = r0.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r0 = r0.extraData
            if (r0 == 0) goto L_0x055f
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r0 = r0.carConfig
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r0 = r0.extraData
            com.google.gson.JsonObject r0 = r0.orderParamsObject
            if (r0 == 0) goto L_0x055f
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x055b }
            r0.<init>()     // Catch:{ Exception -> 0x055b }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r4 = r1.f15541i     // Catch:{ Exception -> 0x055b }
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r4 = r4.mAnyCarEstimateNetItem     // Catch:{ Exception -> 0x055b }
            com.didi.travel.psnger.model.response.anycar.AnyCarConfigModel r4 = r4.carConfig     // Catch:{ Exception -> 0x055b }
            com.didi.travel.psnger.model.response.anycar.AnyCarExtraData r4 = r4.extraData     // Catch:{ Exception -> 0x055b }
            com.google.gson.JsonObject r4 = r4.orderParamsObject     // Catch:{ Exception -> 0x055b }
            com.didi.component.service.AbsSendOrderServicePresenter$13 r11 = new com.didi.component.service.AbsSendOrderServicePresenter$13     // Catch:{ Exception -> 0x055b }
            r11.<init>()     // Catch:{ Exception -> 0x055b }
            java.lang.reflect.Type r11 = r11.getType()     // Catch:{ Exception -> 0x055b }
            java.lang.Object r0 = r0.fromJson((com.google.gson.JsonElement) r4, (java.lang.reflect.Type) r11)     // Catch:{ Exception -> 0x055b }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x055b }
            if (r0 == 0) goto L_0x055f
            r2.putAll(r0)     // Catch:{ Exception -> 0x055b }
            goto L_0x055f
        L_0x055b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x055f:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i
            java.util.HashMap r4 = r0.getSelectedValueMap()
            int r0 = r4.size()
            if (r0 <= 0) goto L_0x05a4
            java.util.Set r0 = r4.keySet()
            java.util.Iterator r11 = r0.iterator()
        L_0x0573:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x05a4
            java.lang.Object r0 = r11.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x059f }
            com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0     // Catch:{ Exception -> 0x059f }
            com.google.gson.Gson r12 = new com.google.gson.Gson     // Catch:{ Exception -> 0x059f }
            r12.<init>()     // Catch:{ Exception -> 0x059f }
            com.didi.component.service.AbsSendOrderServicePresenter$14 r13 = new com.didi.component.service.AbsSendOrderServicePresenter$14     // Catch:{ Exception -> 0x059f }
            r13.<init>()     // Catch:{ Exception -> 0x059f }
            java.lang.reflect.Type r13 = r13.getType()     // Catch:{ Exception -> 0x059f }
            java.lang.Object r0 = r12.fromJson((com.google.gson.JsonElement) r0, (java.lang.reflect.Type) r13)     // Catch:{ Exception -> 0x059f }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x059f }
            if (r0 == 0) goto L_0x0573
            r2.putAll(r0)     // Catch:{ Exception -> 0x059f }
            goto L_0x0573
        L_0x059f:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0573
        L_0x05a4:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r4 = r0.getNewEstimateItem()
            java.lang.String r11 = "bubble_id"
            if (r2 == 0) goto L_0x06fd
            if (r4 == 0) goto L_0x06fd
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r0 = r4.carConfig
            if (r0 == 0) goto L_0x065c
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r0 = r4.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r0 = r0.extraData
            if (r0 == 0) goto L_0x065c
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r0 = r4.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r0 = r0.extraData
            com.google.gson.JsonObject r0 = r0.orderParamsObject
            if (r0 == 0) goto L_0x065c
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x05e4 }
            r0.<init>()     // Catch:{ Exception -> 0x05e4 }
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r12 = r4.carConfig     // Catch:{ Exception -> 0x05e4 }
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r12 = r12.extraData     // Catch:{ Exception -> 0x05e4 }
            com.google.gson.JsonObject r12 = r12.orderParamsObject     // Catch:{ Exception -> 0x05e4 }
            com.didi.component.service.AbsSendOrderServicePresenter$15 r13 = new com.didi.component.service.AbsSendOrderServicePresenter$15     // Catch:{ Exception -> 0x05e4 }
            r13.<init>()     // Catch:{ Exception -> 0x05e4 }
            java.lang.reflect.Type r13 = r13.getType()     // Catch:{ Exception -> 0x05e4 }
            java.lang.Object r0 = r0.fromJson((com.google.gson.JsonElement) r12, (java.lang.reflect.Type) r13)     // Catch:{ Exception -> 0x05e4 }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x05e4 }
            if (r0 == 0) goto L_0x065c
            r2.putAll(r0)     // Catch:{ Exception -> 0x05e4 }
            goto L_0x065c
        L_0x05e4:
            r0 = move-exception
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r12 = r4.carConfig
            if (r12 == 0) goto L_0x065c
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r12 = r4.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r12 = r12.extraData
            if (r12 == 0) goto L_0x065c
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r12 = r4.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r12 = r12.extraData
            com.didi.travel.psnger.model.response.estimate.OrderParams r12 = r12.getOrderParams()
            if (r12 == 0) goto L_0x065c
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r12 = r4.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r12 = r12.extraData
            com.didi.travel.psnger.model.response.estimate.OrderParams r12 = r12.getOrderParams()
            java.lang.String r13 = "AbsSendOrderServicePresenter"
            com.didichuxing.omega.sdk.Omega.trackError(r13, r0)
            int r0 = r12.availableStatus
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r13 = "available_status"
            r7.addParam(r13, r0)
            float r0 = r12.feeAmount
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            java.lang.String r13 = "estimate_price"
            r7.addParam(r13, r0)
            int r0 = r12.countPriceType
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r15, r0)
            int r0 = r12.carPoolShow
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r9, r0)
            int r0 = r12.comboId
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r9 = "combo_id"
            r7.addParam(r9, r0)
            int r0 = r12.sceneType
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r9 = "scene_type"
            r7.addParam(r9, r0)
            int r0 = r12.availableStatus
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r9 = "available_status"
            r7.addParam(r9, r0)
            java.lang.String r0 = r12.bubbleId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x065c
            java.lang.String r0 = r12.bubbleId
            r7.addParam(r11, r0)
        L_0x065c:
            java.util.HashMap r9 = r4.getSelectedValueMap()
            int r0 = r9.size()
            if (r0 <= 0) goto L_0x06fd
            java.util.Set r0 = r9.keySet()
            java.util.Iterator r12 = r0.iterator()
        L_0x066e:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x06fd
            java.lang.Object r0 = r12.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r9.get(r0)     // Catch:{ Exception -> 0x069a }
            com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0     // Catch:{ Exception -> 0x069a }
            com.google.gson.Gson r13 = new com.google.gson.Gson     // Catch:{ Exception -> 0x069a }
            r13.<init>()     // Catch:{ Exception -> 0x069a }
            com.didi.component.service.AbsSendOrderServicePresenter$16 r14 = new com.didi.component.service.AbsSendOrderServicePresenter$16     // Catch:{ Exception -> 0x069a }
            r14.<init>()     // Catch:{ Exception -> 0x069a }
            java.lang.reflect.Type r14 = r14.getType()     // Catch:{ Exception -> 0x069a }
            java.lang.Object r0 = r13.fromJson((com.google.gson.JsonElement) r0, (java.lang.reflect.Type) r14)     // Catch:{ Exception -> 0x069a }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x069a }
            if (r0 == 0) goto L_0x066e
            r2.putAll(r0)     // Catch:{ Exception -> 0x069a }
            goto L_0x066e
        L_0x069a:
            r0 = move-exception
            r0.printStackTrace()
            com.didi.travel.psnger.model.response.estimate.SelectedValueParams r13 = r4.getSelectedValueParams()
            if (r13 == 0) goto L_0x066e
            java.lang.String r14 = "AbsSendOrderServicePresenter"
            com.didichuxing.omega.sdk.Omega.trackError(r14, r0)
            java.lang.String r0 = r13.seatPoolEstimateId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x06b8
            java.lang.String r0 = r13.seatPoolEstimateId
            java.lang.String r14 = "estimate_id"
            r7.addParam(r14, r0)
        L_0x06b8:
            float r0 = r13.seatPoolEstimatePrice
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            java.lang.String r14 = "estimate_price"
            r7.addParam(r14, r0)
            int r0 = r13.seatPoolCountType
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r15, r0)
            int r0 = r13.carpoolOrderScene
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r10, r0)
            int r0 = r13.carPool
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r8, r0)
            int r0 = r13.poolSeat
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r6, r0)
            int r0 = r13.comboType
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.addParam(r5, r0)
            int r0 = r13.comboId
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r13 = "combo_id"
            r7.addParam(r13, r0)
            goto L_0x066e
        L_0x06fd:
            java.lang.String r0 = r3.getBubbleId()
            r7.addParam(r11, r0)
            r0 = -1
            com.didi.sdk.nation.NationComponentData r2 = com.didi.sdk.nation.NationTypeUtil.getNationComponentData()     // Catch:{ Exception -> 0x0712 }
            java.lang.String r2 = r2.getCityId()     // Catch:{ Exception -> 0x0712 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0712 }
            goto L_0x0713
        L_0x0712:
            r2 = -1
        L_0x0713:
            if (r2 == r0) goto L_0x071e
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = "city_id"
            r7.addParam(r2, r0)
        L_0x071e:
            com.didi.map.global.component.departure.model.DepartureAddress r0 = new com.didi.map.global.component.departure.model.DepartureAddress
            r0.<init>()
            r2 = r19
            r0.setAddress(r2)
            com.didi.map.global.component.departure.model.DepartureAddress r2 = r3.getAirPotAddress()
            if (r2 == 0) goto L_0x0732
            r2 = 0
            r0.setZoneType(r2)
        L_0x0732:
            android.content.Context r2 = r1.mContext
            boolean r0 = com.didi.map.global.flow.utils.SceneUtils.isCallForOther(r2, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "is_callcar"
            r7.addParam(r2, r0)
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            boolean r0 = r0.isHasSubstituteCall()
            if (r0 == 0) goto L_0x0799
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem r0 = r0.getSelectedFriend()
            if (r0 == 0) goto L_0x0799
            com.didi.travel.psnger.model.response.estimate.daijiao.Extension r2 = r0.getExtension()
            if (r2 == 0) goto L_0x0799
            com.didi.travel.psnger.model.response.estimate.daijiao.Extension r2 = r0.getExtension()
            com.google.gson.JsonObject r2 = r2.getSelectValueParams()
            if (r2 == 0) goto L_0x0799
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x0795 }
            r2.<init>()     // Catch:{ JsonSyntaxException -> 0x0795 }
            com.didi.travel.psnger.model.response.estimate.daijiao.Extension r0 = r0.getExtension()     // Catch:{ JsonSyntaxException -> 0x0795 }
            com.google.gson.JsonObject r0 = r0.getSelectValueParams()     // Catch:{ JsonSyntaxException -> 0x0795 }
            com.didi.component.service.AbsSendOrderServicePresenter$17 r5 = new com.didi.component.service.AbsSendOrderServicePresenter$17     // Catch:{ JsonSyntaxException -> 0x0795 }
            r5.<init>()     // Catch:{ JsonSyntaxException -> 0x0795 }
            java.lang.reflect.Type r5 = r5.getType()     // Catch:{ JsonSyntaxException -> 0x0795 }
            java.lang.Object r0 = r2.fromJson((com.google.gson.JsonElement) r0, (java.lang.reflect.Type) r5)     // Catch:{ JsonSyntaxException -> 0x0795 }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ JsonSyntaxException -> 0x0795 }
            boolean r2 = com.didiglobal.travel.util.CollectionUtils.isEmpty((java.util.Map<?, ?>) r0)     // Catch:{ JsonSyntaxException -> 0x0795 }
            if (r2 != 0) goto L_0x0799
            java.util.Map r2 = r7.getParams()     // Catch:{ JsonSyntaxException -> 0x0795 }
            if (r2 == 0) goto L_0x0799
            java.util.Map r2 = r7.getParams()     // Catch:{ JsonSyntaxException -> 0x0795 }
            r2.putAll(r0)     // Catch:{ JsonSyntaxException -> 0x0795 }
            goto L_0x0799
        L_0x0795:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0799:
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i
            java.lang.String r2 = "user_input_price"
            if (r0 == 0) goto L_0x0840
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem
            if (r0 == 0) goto L_0x0840
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r0 = r0.carBreakModel
            if (r0 == 0) goto L_0x0840
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r0 = r1.f15541i
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r0 = r0.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r0 = r0.carBreakModel
            java.lang.String r0 = r0.offer_flex_price_scheme
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0840
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getInputOfferPrice()
            com.didi.sdk.logging.Logger r5 = r1.mLogger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = " generateCreateOrderParams flex input price ="
            r6.append(r8)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r8 = 0
            java.lang.Object[] r9 = new java.lang.Object[r8]
            r5.info((java.lang.String) r6, (java.lang.Object[]) r9)
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 == 0) goto L_0x07e8
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getFlex_recommend_price()
        L_0x07e8:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x07f1
            r7.addParam(r2, r0)
        L_0x07f1:
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r6 = "estimate_trace_id"
            r8 = r18
            r5.put(r6, r8)
            r5.put(r2, r0)
            r0 = 5
            java.lang.String r6 = "ibt_monitor_flex_error_ck"
            com.didi.component.business.tracker.flex.FlexTrack.track(r6, r0, r5)
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getFlex_order_params()
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x0840
            com.google.gson.Gson r5 = new com.google.gson.Gson     // Catch:{ Exception -> 0x083c }
            r5.<init>()     // Catch:{ Exception -> 0x083c }
            com.didi.component.service.AbsSendOrderServicePresenter$18 r6 = new com.didi.component.service.AbsSendOrderServicePresenter$18     // Catch:{ Exception -> 0x083c }
            r6.<init>()     // Catch:{ Exception -> 0x083c }
            java.lang.reflect.Type r6 = r6.getType()     // Catch:{ Exception -> 0x083c }
            java.lang.Object r0 = r5.fromJson((java.lang.String) r0, (java.lang.reflect.Type) r6)     // Catch:{ Exception -> 0x083c }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x083c }
            boolean r5 = com.didiglobal.travel.util.CollectionUtils.isEmpty((java.util.Map<?, ?>) r0)     // Catch:{ Exception -> 0x083c }
            if (r5 != 0) goto L_0x0840
            java.util.Map r5 = r7.getParams()     // Catch:{ Exception -> 0x083c }
            if (r5 == 0) goto L_0x0840
            java.util.Map r5 = r7.getParams()     // Catch:{ Exception -> 0x083c }
            r5.putAll(r0)     // Catch:{ Exception -> 0x083c }
            goto L_0x0840
        L_0x083c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0840:
            if (r4 == 0) goto L_0x08d9
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r0 = r4.carBreakModel
            if (r0 == 0) goto L_0x08d9
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r0 = r4.carBreakModel
            java.lang.String r0 = r0.offer_flex_price_scheme
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x08d9
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getInputOfferPrice()
            com.didi.sdk.logging.Logger r4 = r1.mLogger
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = " generateCreateOrderParams flex input price ="
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r4.info((java.lang.String) r5, (java.lang.Object[]) r6)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L_0x087f
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getFlex_recommend_price()
        L_0x087f:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x0888
            r7.addParam(r2, r0)
        L_0x0888:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r3 = r3.getEstimateModelTraceId()
            java.lang.String r5 = "estimate_trace_id"
            r4.put(r5, r3)
            r4.put(r2, r0)
            r0 = 5
            java.lang.String r2 = "ibt_monitor_flex_error_ck"
            com.didi.component.business.tracker.flex.FlexTrack.track(r2, r0, r4)
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            java.lang.String r0 = r0.getFlex_order_params()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x08d9
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ Exception -> 0x08d5 }
            r2.<init>()     // Catch:{ Exception -> 0x08d5 }
            com.didi.component.service.AbsSendOrderServicePresenter$19 r3 = new com.didi.component.service.AbsSendOrderServicePresenter$19     // Catch:{ Exception -> 0x08d5 }
            r3.<init>()     // Catch:{ Exception -> 0x08d5 }
            java.lang.reflect.Type r3 = r3.getType()     // Catch:{ Exception -> 0x08d5 }
            java.lang.Object r0 = r2.fromJson((java.lang.String) r0, (java.lang.reflect.Type) r3)     // Catch:{ Exception -> 0x08d5 }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x08d5 }
            boolean r2 = com.didiglobal.travel.util.CollectionUtils.isEmpty((java.util.Map<?, ?>) r0)     // Catch:{ Exception -> 0x08d5 }
            if (r2 != 0) goto L_0x08d9
            java.util.Map r2 = r7.getParams()     // Catch:{ Exception -> 0x08d5 }
            if (r2 == 0) goto L_0x08d9
            java.util.Map r2 = r7.getParams()     // Catch:{ Exception -> 0x08d5 }
            r2.putAll(r0)     // Catch:{ Exception -> 0x08d5 }
            goto L_0x08d9
        L_0x08d5:
            r0 = move-exception
            r0.printStackTrace()
        L_0x08d9:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.f15542j
            boolean r0 = com.didi.sdk.util.collection.CollectionUtil.isEmpty((java.util.Map<?, ?>) r0)
            if (r0 != 0) goto L_0x08ea
            java.util.Map r0 = r7.getParams()
            java.util.Map<java.lang.String, java.lang.Object> r2 = r1.f15542j
            r0.putAll(r2)
        L_0x08ea:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.service.AbsSendOrderServicePresenter.m11252b(android.content.Context, int):com.didi.travel.psnger.core.model.request.OrderParams");
    }

    public CarConfig.ConfirmActionInfo getConfirmActionInfo() {
        AnyCarEstimateItemModel anyCarEstimateItemModel = this.f15541i;
        if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel == null || this.f15541i.mAnyCarEstimateNetItem.carBreakModel.carBreakDelivery == null || this.f15541i.mAnyCarEstimateNetItem.carConfig == null)) {
            try {
                JSONObject jSONObject = new JSONObject(this.f15541i.mAnyCarEstimateNetItem.carBreakModel.carBreakDelivery.toString());
                return new CarConfig.ConfirmActionInfo(this.f15541i.mAnyCarEstimateNetItem.carConfig.carProductId + "", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: c */
    private void m11258c() {
        Serializable serializable = this.f15546r.getSerializable(BaseExtras.Common.EXTRA_CREATE_ORDER);
        setParam(serializable instanceof CreateOrderParam ? (CreateOrderParam) serializable : null);
    }

    /* access modifiers changed from: protected */
    public void setParam(CreateOrderParam createOrderParam) {
        boolean z;
        CarOperationDataModel.AnycarCarpoolSeat anycarCarpoolSeat;
        HashMap hashMap = new HashMap();
        this.f15542j = hashMap;
        hashMap.put("is_anycar", "0");
        if (createOrderParam != null) {
            List<AnyCarEstimateItemModel> list = createOrderParam.mAllCar;
            List<AnyCarEstimateItemModel> list2 = createOrderParam.mAnyCarSelectedItemModels;
            AnyCarEstimateItemModel anyCarEstimateItemModel = createOrderParam.mSelectedSingleModel;
            this.f15545m = list2;
            this.f15544l = anyCarEstimateItemModel;
            TripListener tripListener = PageCompDataTransfer.getInstance().getTripListener();
            if (tripListener != null) {
                tripListener.setSelectedSingleAnyCarItem(anyCarEstimateItemModel);
                tripListener.setSelectedAnyCarItem(list2);
                tripListener.setPreference(createOrderParam.mPreference);
                tripListener.setIsAnyCar(createOrderParam.mIsAnyCar);
                tripListener.setGroups(createOrderParam.groups);
            }
            int i = createOrderParam.mPreference;
            this.f15543k = createOrderParam.mTraceId;
            if (anyCarEstimateItemModel != null) {
                this.f15541i = anyCarEstimateItemModel;
                return;
            }
            HashMap hashMap2 = new HashMap();
            ArrayList arrayList = new ArrayList();
            int i2 = 1;
            if (this.f15544l == null && !CollectionUtil.isEmpty((Collection<?>) list) && !CollectionUtil.isEmpty((Collection<?>) list2)) {
                for (AnyCarEstimateItemModel next : list) {
                    if (next.mAnyCarEstimateNetItem.carConfig.singleCarSelect != 2) {
                        HashMap hashMap3 = new HashMap();
                        Iterator<AnyCarEstimateItemModel> it = list2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            AnyCarEstimateItemModel next2 = it.next();
                            if (next != null && next2 != null && next.mAnyCarEstimateNetItem.carConfig != null && next2.mAnyCarEstimateNetItem.carConfig != null && !TextUtils.isEmpty(next.mAnyCarEstimateNetItem.carConfig.uniqueId) && next.mAnyCarEstimateNetItem.carConfig.uniqueId.equals(next2.mAnyCarEstimateNetItem.carConfig.uniqueId) && next2.mAnyCarEstimateNetItem.carConfig.extraData != null) {
                                if (this.f15541i == null) {
                                    this.f15541i = next2;
                                }
                                next.mAnyCarEstimateNetItem.carConfig.extraData.putOrderParams(hashMap3);
                                if (!(next2 == null || next2.anycarCarpool == null || next2.anycarCarpool.operationData == null || CollectionUtil.isEmpty((Collection<?>) next2.anycarCarpool.operationData.anycarCarpoolSeatList) || (anycarCarpoolSeat = next2.anycarCarpool.operationData.anycarCarpoolSeatList.get(next2.anycarCarpool.mSelectedIndex)) == null || anycarCarpoolSeat.selectValueParams == null)) {
                                    try {
                                        hashMap3.putAll((HashMap) new Gson().fromJson((JsonElement) anycarCarpoolSeat.selectValueParams, new TypeToken<HashMap<String, Object>>() {
                                        }.getType()));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                hashMap3.put(ParamConst.PARAM_IS_SELECTED, 1);
                                arrayList.add(new JSONObject(hashMap3));
                                z = true;
                            }
                        }
                        if (!(z || next == null || next.mAnyCarEstimateNetItem.carConfig == null || next.mAnyCarEstimateNetItem.carConfig.extraData == null)) {
                            next.mAnyCarEstimateNetItem.carConfig.extraData.putOrderParams(hashMap3);
                            hashMap3.put(ParamConst.PARAM_IS_SELECTED, 0);
                            arrayList.add(new JSONObject(hashMap3));
                        }
                    }
                }
            }
            hashMap2.put(ParamKeys.PARAM_ANYCAR_PREFERENCE, Integer.valueOf(i));
            hashMap2.put("products_info", arrayList);
            Map<String, Object> map = this.f15542j;
            if (arrayList.size() == 0) {
                i2 = 0;
            }
            map.put("is_anycar", Integer.valueOf(i2));
            this.f15542j.put("anycar_info", hashMap2);
        }
    }

    /* renamed from: a */
    private String m11237a(Address address) {
        if (address != null) {
            if (!TextUtils.isEmpty(address.getFullName())) {
                return address.getFullName();
            }
            if (!TextUtils.isEmpty(address.getDisplayName())) {
                return address.getDisplayName();
            }
            if (!TextUtils.isEmpty(address.getName())) {
                return address.getName();
            }
        }
        return ResourcesHelper.getString(this.mContext, R.string.global_pin_location);
    }

    /* access modifiers changed from: protected */
    public void onOrderCreated(CarOrder carOrder) {
        CarInfo carInfo;
        this.mLogger.info("onOrderCreated", new Object[0]);
        if (carOrder != null) {
            TravelUtil.checkAndStoreOid(carOrder.oid, this.TAG);
            GlobalSPUtil.setRedPacketOid(this.mContext, carOrder.getOid());
            if (carOrder.checkIsSplitFare == 1 && carOrder.checkSplitStatus == 0) {
                carOrder.errno = 30001;
                onOrderCreateFail(carOrder);
                return;
            }
            if (carOrder.isNearbyWait == 1) {
                doPublish(BaseEventKeys.WaitRsp.EVENT_WAIT_NEARBY_ORDER_MATCH, carOrder.getOid());
                doPublish(BaseEventKeys.WaitRsp.EVENT_WAIT_NEARBY_MARK, true);
                doPublish(BaseEventKeys.WaitRsp.EVENT_WAIT_NEARBY_SHOW);
            }
            AnyCarEstimateItemModel anyCarEstimateItemModel = this.f15541i;
            if (anyCarEstimateItemModel != null) {
                int carBussinessId = anyCarEstimateItemModel.getCarBussinessId();
                if (carBussinessId == 0) {
                    carBussinessId = FormStore.getInstance().Bid;
                }
                CarOrderHelper.fillOrder(carOrder, carBussinessId);
            } else {
                CarOrderHelper.fillOrder(carOrder, FormStore.getInstance().Bid);
            }
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem == null || newEstimateItem.carConfig == null) {
                carInfo = null;
            } else {
                carInfo = new CarInfo();
                carInfo.setCarLevel(newEstimateItem.carConfig.carLevel);
                carInfo.setBusinessNumId(newEstimateItem.carConfig.carBussinessId);
                carInfo.setMapIcon(newEstimateItem.carConfig.carMapIconUrl);
                carInfo.setComboType(newEstimateItem.carConfig.carComboType);
            }
            if (carInfo != null && carInfo.getBusinessNumId() > 0 && carInfo.getCarLevel() > 0 && carOrder.productid > 0 && NumberUtil.parseInt(carOrder.carLevel) > 0) {
                GlobalSPUtil.saveLastCreatedOrderCarInfo(this.mContext, carOrder.productid, NumberUtil.parseInt(carOrder.carLevel), carInfo.getBusinessNumId(), carInfo.getCarLevel(), carInfo.getComboType(), !TextUtil.isEmpty(carOrder.carPoolOrderScene) ? NumberUtil.parseInt(carOrder.carPoolOrderScene) : -1);
            }
            doPublish(BaseEventKeys.Service.EVENT_ORDER_CREATED, carOrder.getOid());
            if (!FormStore.getInstance().isInMiniBus()) {
                XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
            }
            FormStore.getInstance().setFlexOfferPrice(false);
            FormStore.getInstance().setDeliveryInfo((JSONObject) null);
            this.mLogger.info("onOrderCreated id = " + carOrder.getOid(), new Object[0]);
            GlobalOmegaUtils.setOrderType(carOrder.orderType);
            m11259c(carOrder);
        }
    }

    /* renamed from: c */
    private void m11259c(CarOrder carOrder) {
        HashMap hashMap = new HashMap();
        hashMap.put("country_code", BusinessUtils.getCountryIsoCode(this.mBusinessContext));
        hashMap.put("city_id", Integer.valueOf(BusinessUtils.getCurrentCityId(this.mBusinessContext)));
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            hashMap.put("scene", 0);
            hashMap.put("combo_type", 0);
            hashMap.put("require_level", Integer.valueOf(newEstimateItem.getCarLevel()));
        }
        if (this.f15541i != null) {
            hashMap.put("scene", 0);
            hashMap.put("combo_type", 0);
            hashMap.put("require_level", Integer.valueOf(this.f15541i.getCarLevel()));
        }
        hashMap.put(ServerParam.PARAM_NETWORK_TYPE, SystemUtil.getNetworkType());
        hashMap.put("response", Integer.valueOf(carOrder.errno));
        GlobalOmegaUtils.trackEvent("p_requireDlg_sendOrderStatus_ck", (Map<String, Object>) hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("search_id", SearchIdUploadManager.getInstance().getSearchIdBunch());
        hashMap2.put("bubble_id", SearchIdUploadManager.getInstance().getBubbleId());
        GlobalOmegaUtils.trackEvent("searchid_upload", (Map<String, Object>) hashMap2);
        SearchIdUploadManager.getInstance().clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.didi.travel.psnger.model.CommonPopUp} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r5v21 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onOrderCreateFail(final com.didi.travel.psnger.model.response.CarOrder r13) {
        /*
            r12 = this;
            r0 = 2131953565(0x7f13079d, float:1.9543605E38)
            r1 = 0
            if (r13 != 0) goto L_0x0023
            com.didi.sdk.logging.Logger r13 = r12.mLogger
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "onOrderCreateFail  order == null"
            r13.info((java.lang.String) r2, (java.lang.Object[]) r1)
            android.content.Context r13 = r12.mContext
            androidx.fragment.app.Fragment r1 = r12.getHost()
            androidx.fragment.app.FragmentManager r1 = r1.getFragmentManager()
            android.content.Context r2 = r12.mContext
            java.lang.String r0 = r2.getString(r0)
            com.didi.component.service.util.SendOrderTipDialogHelper.showOrderFailDialog(r13, r1, r0)
            return
        L_0x0023:
            com.didi.sdk.logging.Logger r2 = r12.mLogger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "onOrderCreateFail  errorCode == "
            r3.append(r4)
            int r4 = r13.getErrorCode()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r2.info((java.lang.String) r3, (java.lang.Object[]) r4)
            java.lang.String r2 = r13.errmsg
            boolean r2 = com.didi.sdk.util.TextUtil.isEmpty(r2)
            if (r2 == 0) goto L_0x004f
            android.content.Context r2 = r12.mContext
            java.lang.String r0 = r2.getString(r0)
            r13.errmsg = r0
        L_0x004f:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            boolean r0 = r0.isInMiniBus()
            if (r0 == 0) goto L_0x0060
            boolean r0 = r12.orderIntercept(r13)
            if (r0 == 0) goto L_0x0060
            return
        L_0x0060:
            boolean r0 = r12.m11256b((com.didi.travel.psnger.model.response.CarOrder) r13)
            if (r0 == 0) goto L_0x0067
            return
        L_0x0067:
            int r0 = r13.getErrorCode()
            r2 = 1127(0x467, float:1.579E-42)
            if (r0 == r2) goto L_0x048a
            r2 = 1128(0x468, float:1.58E-42)
            r3 = 1
            if (r0 == r2) goto L_0x0440
            r2 = 20010(0x4e2a, float:2.804E-41)
            r4 = 2131954596(0x7f130ba4, float:1.9545696E38)
            if (r0 == r2) goto L_0x0410
            r2 = 20011(0x4e2b, float:2.8041E-41)
            r5 = 0
            if (r0 == r2) goto L_0x0398
            r2 = 2131953566(0x7f13079e, float:1.9543607E38)
            r4 = 2131233527(0x7f080af7, float:1.8083194E38)
            switch(r0) {
                case 101: goto L_0x036d;
                case 596: goto L_0x035d;
                case 1011: goto L_0x036d;
                case 1016: goto L_0x0347;
                case 1020: goto L_0x0335;
                case 1039: goto L_0x0347;
                case 1047: goto L_0x0347;
                case 1053: goto L_0x02a4;
                case 1055: goto L_0x0295;
                case 1102: goto L_0x0285;
                case 1123: goto L_0x0285;
                case 1144: goto L_0x0279;
                case 1154: goto L_0x01d9;
                case 10625: goto L_0x0197;
                case 20077: goto L_0x0186;
                case 30001: goto L_0x015b;
                default: goto L_0x0089;
            }
        L_0x0089:
            switch(r0) {
                case 1058: goto L_0x014c;
                case 1059: goto L_0x0120;
                case 1060: goto L_0x0116;
                default: goto L_0x008c;
            }
        L_0x008c:
            switch(r0) {
                case 1133: goto L_0x00ea;
                case 1134: goto L_0x00c0;
                case 1135: goto L_0x00bb;
                case 1136: goto L_0x0098;
                case 1137: goto L_0x00c0;
                default: goto L_0x008f;
            }
        L_0x008f:
            android.content.Context r0 = r12.mContext
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            com.didi.component.business.util.CarHttpHelper.validate(r0, r13)
            goto L_0x048d
        L_0x0098:
            com.didi.travel.psnger.model.response.CashUnPayInterceptInfo r0 = r13.cashUnPayInterceptInfo
            if (r0 == 0) goto L_0x048d
            com.didi.travel.psnger.model.response.CashUnPayInterceptInfo r0 = r13.cashUnPayInterceptInfo
            java.lang.String r0 = r0.link
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x048d
            com.didi.travel.psnger.model.response.CashUnPayInterceptInfo r13 = r13.cashUnPayInterceptInfo
            java.lang.String r13 = r13.link
            com.didi.drouter.router.Request r13 = com.didi.drouter.api.DRouter.build((java.lang.String) r13)
            androidx.fragment.app.Fragment r0 = r12.getHost()
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            r13.start(r0)
            goto L_0x048d
        L_0x00bb:
            r12.m11261d((com.didi.travel.psnger.model.response.CarOrder) r13)
            goto L_0x048d
        L_0x00c0:
            com.didi.travel.psnger.model.response.CashUnPayInterceptInfo r0 = r13.cashUnPayInterceptInfo
            if (r0 == 0) goto L_0x048d
            com.didi.component.common.base.ComponentWrap r0 = new com.didi.component.common.base.ComponentWrap
            java.lang.String r1 = "service_control_no_pay"
            r0.<init>(r1)
            r0.setClickMaskHide(r3)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            com.didi.travel.psnger.model.response.CashUnPayInterceptInfo r2 = r13.cashUnPayInterceptInfo
            java.lang.String r3 = "order"
            r2.mEntry = r3
            com.didi.travel.psnger.model.response.CashUnPayInterceptInfo r13 = r13.cashUnPayInterceptInfo
            java.lang.String r2 = "BUNDLE_CAR_ORDER_UNPAY_INFO"
            r1.putSerializable(r2, r13)
            r0.setBundle(r1)
            java.lang.String r13 = "event_show_popup_component"
            r12.doPublish(r13, r0)
            goto L_0x048d
        L_0x00ea:
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            java.lang.String r13 = r13.errmsg
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r0.setMessage(r13)
            com.didi.sdk.view.dialog.AlertController$IconType r3 = com.didi.sdk.view.dialog.AlertController.IconType.INFO
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setIcon((com.didi.sdk.view.dialog.AlertController.IconType) r3)
            android.content.Context r3 = r12.mContext
            java.lang.String r2 = r3.getString(r2)
            com.didi.component.service.AbsSendOrderServicePresenter$33 r3 = new com.didi.component.service.AbsSendOrderServicePresenter$33
            r3.<init>()
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setPositiveButton((java.lang.CharSequence) r2, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r3)
            r13.setPositiveButtonDefault()
            r0.setCancelable(r1)
            r12.m11245a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            goto L_0x048d
        L_0x0116:
            java.lang.String r13 = "estimate_get_estimate"
            r12.doPublish(r13)
            r12.backConfirmPricePage()
            goto L_0x048d
        L_0x0120:
            androidx.fragment.app.Fragment r0 = r12.getHost()
            if (r0 == 0) goto L_0x048d
            if (r13 == 0) goto L_0x012e
            com.didi.travel.psnger.model.RGCommonPopUp r0 = r13.mRGCommonPopUp
            if (r0 == 0) goto L_0x012e
            com.didi.travel.psnger.model.RGCommonPopUp r5 = r13.mRGCommonPopUp
        L_0x012e:
            r6 = r5
            java.lang.String r7 = r13.keeper_id
            int r8 = r13.bizCode
            java.lang.String r9 = r13.cardArray
            java.lang.String r10 = r13.auth_h5_url
            java.lang.String r11 = r12.m11267f((com.didi.travel.psnger.model.response.CarOrder) r13)
            com.didi.component.service.view.RGBlockingPopup r13 = com.didi.component.service.view.RGBlockingPopup.getInstance(r6, r7, r8, r9, r10, r11)
            androidx.fragment.app.Fragment r0 = r12.getHost()
            androidx.fragment.app.FragmentManager r0 = r0.getFragmentManager()
            r13.show(r0)
            goto L_0x048d
        L_0x014c:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            boolean r0 = r0.isInMiniBus()
            if (r0 == 0) goto L_0x048d
            r12.enterFaceRecognize(r13)
            goto L_0x048d
        L_0x015b:
            r12.backConfirmPricePage()
            com.didi.component.common.dialog.GlobalCommonBottomPop$BottomPopModel r0 = new com.didi.component.common.dialog.GlobalCommonBottomPop$BottomPopModel
            r0.<init>()
            java.lang.String r13 = r13.checkSplitFareMsg
            r0.content = r13
            android.content.Context r13 = r12.mContext
            r1 = 2131954777(0x7f130c59, float:1.9546063E38)
            java.lang.String r13 = r13.getString(r1)
            r0.positive = r13
            com.didi.component.common.dialog.GlobalCommonBottomPop r13 = new com.didi.component.common.dialog.GlobalCommonBottomPop
            android.content.Context r1 = r12.mContext
            r13.<init>(r1, r0)
            com.didi.component.service.AbsSendOrderServicePresenter$34 r0 = new com.didi.component.service.AbsSendOrderServicePresenter$34
            r0.<init>(r13)
            r13.setBottomActionListener(r0)
            r13.show()
            goto L_0x048d
        L_0x0186:
            android.content.Context r0 = r12.mContext
            java.lang.String r13 = r13.errmsg
            com.didi.sdk.util.ToastHelper.showLongInfo((android.content.Context) r0, (java.lang.String) r13, (int) r4)
            r12.backConfirmPricePage()
            java.lang.String r13 = "ibt_gp_carconfirm_deliverynumlimit_sw"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent(r13)
            goto L_0x048d
        L_0x0197:
            androidx.fragment.app.Fragment r0 = r12.getHost()
            if (r0 == 0) goto L_0x01d8
            androidx.fragment.app.Fragment r0 = r12.getHost()
            androidx.fragment.app.FragmentManager r0 = r0.getFragmentManager()
            if (r0 != 0) goto L_0x01a8
            goto L_0x01d8
        L_0x01a8:
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            java.lang.String r13 = r13.errmsg
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r0.setMessage(r13)
            com.didi.sdk.view.dialog.AlertController$IconType r1 = com.didi.sdk.view.dialog.AlertController.IconType.INFO
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setIcon((com.didi.sdk.view.dialog.AlertController.IconType) r1)
            android.content.Context r1 = r12.mContext
            java.lang.String r1 = r1.getString(r2)
            com.didi.component.service.AbsSendOrderServicePresenter$24 r2 = new com.didi.component.service.AbsSendOrderServicePresenter$24
            r2.<init>()
            r13.setPositiveButton((java.lang.CharSequence) r1, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r2)
            r0.setCancelable(r3)
            com.didi.component.service.AbsSendOrderServicePresenter$25 r13 = new com.didi.component.service.AbsSendOrderServicePresenter$25
            r13.<init>()
            r0.setOnDismissListener(r13)
            r12.m11245a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            goto L_0x048d
        L_0x01d8:
            return
        L_0x01d9:
            com.didi.travel.psnger.model.response.CommonPopUpModel r0 = r13.popup
            if (r0 == 0) goto L_0x0278
            com.didi.travel.psnger.model.response.CommonPopUpModel r0 = r13.popup
            java.util.List<com.didi.travel.psnger.model.response.CommonPopUpModel$PopUpOptions> r0 = r0.options
            boolean r0 = com.didi.sdk.util.collection.CollectionUtil.isEmpty((java.util.Collection<?>) r0)
            if (r0 == 0) goto L_0x01e9
            goto L_0x0278
        L_0x01e9:
            com.didi.travel.psnger.model.response.CommonPopUpModel r0 = r13.popup
            java.lang.String r0 = r0.title
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0278
            com.didi.travel.psnger.model.response.CommonPopUpModel r0 = r13.popup
            java.lang.String r0 = r0.showMsg
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01ff
            goto L_0x0278
        L_0x01ff:
            com.didi.travel.psnger.model.response.CommonPopUpModel r0 = r13.popup
            java.util.List<com.didi.travel.psnger.model.response.CommonPopUpModel$PopUpOptions> r0 = r0.options
            java.util.Iterator r0 = r0.iterator()
            r1 = r5
        L_0x0208:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0237
            java.lang.Object r2 = r0.next()
            com.didi.travel.psnger.model.response.CommonPopUpModel$PopUpOptions r2 = (com.didi.travel.psnger.model.response.CommonPopUpModel.PopUpOptions) r2
            int r4 = r2.type
            if (r4 != r3) goto L_0x0226
            com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback r4 = new com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback
            java.lang.String r2 = r2.text
            com.didi.component.service.AbsSendOrderServicePresenter$21 r5 = new com.didi.component.service.AbsSendOrderServicePresenter$21
            r5.<init>()
            r4.<init>(r2, r5)
            r5 = r4
            goto L_0x0208
        L_0x0226:
            int r4 = r2.type
            if (r4 != 0) goto L_0x0208
            com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback r1 = new com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback
            java.lang.String r2 = r2.text
            com.didi.component.service.AbsSendOrderServicePresenter$22 r4 = new com.didi.component.service.AbsSendOrderServicePresenter$22
            r4.<init>()
            r1.<init>(r2, r4)
            goto L_0x0208
        L_0x0237:
            if (r5 == 0) goto L_0x0278
            if (r1 != 0) goto L_0x023c
            goto L_0x0278
        L_0x023c:
            android.content.Context r0 = r12.mContext
            com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel2 r2 = new com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel2
            com.didi.travel.psnger.model.response.CommonPopUpModel r3 = r13.popup
            java.lang.String r3 = r3.title
            r2.<init>(r3, r5, r1)
            com.didi.travel.psnger.model.response.CommonPopUpModel r13 = r13.popup
            java.lang.String r13 = r13.showMsg
            com.didi.global.globalgenerickit.drawer.templatemodel.GGKBaseDrawerModel r13 = r2.setSubTitle(r13)
            com.didi.global.globalgenerickit.drawer.GGKDrawer r13 = com.didi.global.globalgenerickit.GGKUICreator.showDrawerModel(r0, r13)
            r12.f15539g = r13
            java.util.HashMap r13 = new java.util.HashMap
            r13.<init>()
            java.lang.String r0 = "point_id"
            java.lang.String r1 = ""
            r13.put(r0, r1)
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r2
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "timestamp"
            r13.put(r1, r0)
            java.lang.String r0 = "ibt_shortparking_request_prompt_sw"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r13)
            goto L_0x048d
        L_0x0278:
            return
        L_0x0279:
            com.didi.travel.psnger.model.CommonPopUp r13 = r13.mPopUp
            com.didi.component.service.AbsSendOrderServicePresenter$35 r0 = new com.didi.component.service.AbsSendOrderServicePresenter$35
            r0.<init>()
            r12.showDrawerDialog(r13, r0, r3)
            goto L_0x048d
        L_0x0285:
            android.content.Context r0 = r12.mContext
            java.lang.String r13 = r13.getErrorMsg()
            com.didi.component.business.util.UiHelper.showTip(r0, r13)
            java.lang.String r13 = "estimate_expired"
            r12.doPublish(r13)
            goto L_0x048d
        L_0x0295:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            boolean r0 = r0.isInMiniBus()
            if (r0 == 0) goto L_0x048d
            r12.verifyCard(r13)
            goto L_0x048d
        L_0x02a4:
            androidx.fragment.app.Fragment r0 = r12.getHost()
            if (r0 == 0) goto L_0x0334
            androidx.fragment.app.Fragment r0 = r12.getHost()
            androidx.fragment.app.FragmentManager r0 = r0.getFragmentManager()
            if (r0 != 0) goto L_0x02b6
            goto L_0x0334
        L_0x02b6:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r13 = r13.authData     // Catch:{ JSONException -> 0x02cc }
            r0.<init>(r13)     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r13 = "title"
            java.lang.String r13 = r0.optString(r13)     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r2 = "msg"
            java.lang.String r5 = r0.optString(r2)     // Catch:{ JSONException -> 0x02ca }
            goto L_0x02d1
        L_0x02ca:
            r0 = move-exception
            goto L_0x02ce
        L_0x02cc:
            r0 = move-exception
            r13 = r5
        L_0x02ce:
            r0.printStackTrace()
        L_0x02d1:
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            com.didi.sdk.view.dialog.AlertController$IconType r2 = com.didi.sdk.view.dialog.AlertController.IconType.INFO
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r2 = r0.setIcon((com.didi.sdk.view.dialog.AlertController.IconType) r2)
            boolean r3 = android.text.TextUtils.isEmpty(r13)
            if (r3 == 0) goto L_0x02ec
            android.content.Context r13 = r12.mContext
            r3 = 2131954699(0x7f130c0b, float:1.9545905E38)
            java.lang.String r13 = r13.getString(r3)
        L_0x02ec:
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r2.setTitle(r13)
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 == 0) goto L_0x02ff
            android.content.Context r2 = r12.mContext
            r3 = 2131954698(0x7f130c0a, float:1.9545903E38)
            java.lang.String r5 = r2.getString(r3)
        L_0x02ff:
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setMessage(r5)
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setPositiveButtonDefault()
            android.content.Context r2 = r12.mContext
            r3 = 2131954697(0x7f130c09, float:1.95459E38)
            java.lang.String r2 = r2.getString(r3)
            com.didi.component.service.AbsSendOrderServicePresenter$31 r3 = new com.didi.component.service.AbsSendOrderServicePresenter$31
            r3.<init>()
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setPositiveButton((java.lang.CharSequence) r2, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r3)
            r2 = 2131954696(0x7f130c08, float:1.9545899E38)
            com.didi.component.service.AbsSendOrderServicePresenter$30 r3 = new com.didi.component.service.AbsSendOrderServicePresenter$30
            r3.<init>()
            r13.setNegativeButton((int) r2, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r3)
            r0.setCancelable(r1)
            com.didi.component.service.AbsSendOrderServicePresenter$32 r13 = new com.didi.component.service.AbsSendOrderServicePresenter$32
            r13.<init>()
            r0.setOnDismissListener(r13)
            r12.m11245a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            goto L_0x048d
        L_0x0334:
            return
        L_0x0335:
            android.content.Context r2 = r12.mContext
            com.didi.sdk.app.BusinessContext r3 = r12.mBusinessContext
            java.lang.String r4 = r13.getErrorMsg()
            java.lang.String r5 = r13.overdraftOid
            int r6 = r13.productid
            r1 = r12
            r1.showNonpaymentOrderDialog(r2, r3, r4, r5, r6)
            goto L_0x048d
        L_0x0347:
            android.content.Context r0 = r12.mContext
            androidx.fragment.app.Fragment r1 = r12.getHost()
            androidx.fragment.app.FragmentManager r1 = r1.getFragmentManager()
            java.lang.String r13 = r13.getErrorMsg()
            com.didi.sdk.view.dialog.AlertDialogFragment r13 = com.didi.component.service.util.SendOrderTipDialogHelper.showOrderFailDialog(r0, r1, r13)
            r12.f15537e = r13
            goto L_0x048d
        L_0x035d:
            android.content.Context r13 = r12.mContext
            android.content.Context r0 = r12.mContext
            r1 = 2131955395(0x7f130ec3, float:1.9547316E38)
            java.lang.String r0 = com.didi.sdk.util.ResourcesHelper.getString(r0, r1)
            com.didi.sdk.util.ToastHelper.showShortInfo((android.content.Context) r13, (java.lang.String) r0, (int) r4)
            goto L_0x048d
        L_0x036d:
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            java.lang.String r13 = r13.errmsg
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r0.setMessage(r13)
            com.didi.sdk.view.dialog.AlertController$IconType r2 = com.didi.sdk.view.dialog.AlertController.IconType.INFO
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setIcon((com.didi.sdk.view.dialog.AlertController.IconType) r2)
            android.content.Context r2 = r12.mContext
            r3 = 2131953562(0x7f13079a, float:1.9543598E38)
            java.lang.String r2 = r2.getString(r3)
            com.didi.component.service.AbsSendOrderServicePresenter$23 r3 = new com.didi.component.service.AbsSendOrderServicePresenter$23
            r3.<init>()
            r13.setPositiveButton((java.lang.CharSequence) r2, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r3)
            r0.setCancelable(r1)
            r12.m11245a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            goto L_0x048d
        L_0x0398:
            int r0 = com.didi.component.common.cache.CacheApolloUtils.isNewCPFBlockingOpen()
            if (r0 != r3) goto L_0x03c3
            androidx.fragment.app.Fragment r0 = r12.getHost()
            if (r0 == 0) goto L_0x048d
            if (r13 == 0) goto L_0x03ac
            com.didi.travel.psnger.model.CommonPopUp r0 = r13.mPopUp
            if (r0 == 0) goto L_0x03ac
            com.didi.travel.psnger.model.CommonPopUp r5 = r13.mPopUp
        L_0x03ac:
            java.lang.String r0 = r13.auth_h5_url
            java.lang.String r13 = r12.m11267f((com.didi.travel.psnger.model.response.CarOrder) r13)
            com.didi.component.service.view.CPFBlockingPopup r13 = com.didi.component.service.view.CPFBlockingPopup.getInstance(r5, r0, r13)
            androidx.fragment.app.Fragment r0 = r12.getHost()
            androidx.fragment.app.FragmentManager r0 = r0.getFragmentManager()
            r13.show(r0)
            goto L_0x048d
        L_0x03c3:
            int r0 = com.didi.component.common.cache.CacheApolloUtils.isNewCPFBlockingOpen()
            r2 = 2
            if (r0 != r2) goto L_0x03da
            java.lang.String r0 = r13.auth_h5_url
            java.lang.String r13 = r12.m11267f((com.didi.travel.psnger.model.response.CarOrder) r13)
            r12.m11249a((java.lang.String) r0, (java.lang.String) r13)
            java.lang.String r13 = "tech_CPFpopup_null_view_sw"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r13)
            goto L_0x048d
        L_0x03da:
            java.lang.String r0 = "gp_CPFpopup_old_view_sw"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r0)
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            java.lang.String r2 = r13.errmsg
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r2 = r0.setMessage(r2)
            com.didi.sdk.view.dialog.AlertController$IconType r3 = com.didi.sdk.view.dialog.AlertController.IconType.INFO
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r2 = r2.setIcon((com.didi.sdk.view.dialog.AlertController.IconType) r3)
            android.content.Context r3 = r12.mContext
            java.lang.String r3 = r3.getString(r4)
            com.didi.component.service.AbsSendOrderServicePresenter$27 r4 = new com.didi.component.service.AbsSendOrderServicePresenter$27
            r4.<init>(r13)
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r2.setPositiveButton((java.lang.CharSequence) r3, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r4)
            r13.setPositiveButtonDefault()
            r0.setCancelable(r1)
            r12.m11245a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            java.lang.String r13 = "Brazil_Safety_intercept_CPF_verification_sw"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent(r13)
            goto L_0x048d
        L_0x0410:
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            java.lang.String r13 = r13.errmsg
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r0.setMessage(r13)
            com.didi.sdk.view.dialog.AlertController$IconType r2 = com.didi.sdk.view.dialog.AlertController.IconType.INFO
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setIcon((com.didi.sdk.view.dialog.AlertController.IconType) r2)
            android.content.Context r2 = r12.mContext
            java.lang.String r2 = r2.getString(r4)
            com.didi.component.service.AbsSendOrderServicePresenter$26 r3 = new com.didi.component.service.AbsSendOrderServicePresenter$26
            r3.<init>()
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setPositiveButton((java.lang.CharSequence) r2, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r3)
            r13.setPositiveButtonDefault()
            r0.setCancelable(r1)
            r12.m11245a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            java.lang.String r13 = "gp_safetyInterceptOnlinePayError_popup_sw"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent(r13)
            goto L_0x048d
        L_0x0440:
            android.content.Context r0 = r12.mContext
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r0 = com.didi.component.business.util.UiHelper.getAlertDialogBuilder(r0)
            java.lang.String r13 = r13.errmsg
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r0.setMessage(r13)
            r1 = 2131232474(0x7f0806da, float:1.8081058E38)
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setIcon((int) r1)
            android.content.Context r1 = r12.mContext
            r2 = 2131955007(0x7f130d3f, float:1.954653E38)
            java.lang.String r1 = r1.getString(r2)
            com.didi.component.service.AbsSendOrderServicePresenter$29 r2 = new com.didi.component.service.AbsSendOrderServicePresenter$29
            r2.<init>()
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setPositiveButton((java.lang.CharSequence) r1, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r2)
            com.didi.sdk.view.dialog.AlertDialogFragment$Builder r13 = r13.setPositiveButtonDefault()
            android.content.Context r1 = r12.mContext
            r2 = 2131955008(0x7f130d40, float:1.9546531E38)
            java.lang.String r1 = r1.getString(r2)
            com.didi.component.service.AbsSendOrderServicePresenter$28 r2 = new com.didi.component.service.AbsSendOrderServicePresenter$28
            r2.<init>()
            r13.setNegativeButton((java.lang.CharSequence) r1, (com.didi.sdk.view.dialog.AlertDialogFragment.OnClickListener) r2)
            r0.setCancelable(r3)
            r12.m11245a((com.didi.sdk.view.dialog.AlertDialogFragment.Builder) r0)
            java.util.Map r13 = r12.getOmgeaParamsOfForceBindOnlinePayment()
            java.lang.String r0 = "Brazil_card_show_sw"
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r13)
            goto L_0x048d
        L_0x048a:
            r12.m11264e((com.didi.travel.psnger.model.response.CarOrder) r13)
        L_0x048d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.service.AbsSendOrderServicePresenter.onOrderCreateFail(com.didi.travel.psnger.model.response.CarOrder):void");
    }

    /* renamed from: d */
    private boolean m11262d() {
        return this instanceof ConfirmServicePresenter;
    }

    /* renamed from: e */
    private boolean m11265e() {
        return !m11262d();
    }

    public LEGODrawer showNonpaymentOrderDialog(Context context, final BusinessContext businessContext, String str, final String str2, final int i) {
        LEGODrawerModel2 lEGODrawerModel2 = new LEGODrawerModel2(context.getString(R.string.car_unpay_title), new LEGOBtnTextAndCallback(context.getString(R.string.car_unpay_confirm), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (AbsSendOrderServicePresenter.this.f15533a != null) {
                    AbsConfirmConfigState.isShowPopInConfirmPage = false;
                    AbsSendOrderServicePresenter.this.f15533a.dismiss();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("oid:");
                String str = str2;
                if (str == null) {
                    str = "overdraftOid is Null";
                }
                sb.append(str);
                SystemUtils.log(6, "OidNullCheck", sb.toString(), new Exception(), "com.didi.component.service.AbsSendOrderServicePresenter$36", 2144);
                if (!TextUtils.isEmpty(str2)) {
                    new GlobalOrderRecovery(businessContext).recovery(i, str2, 2);
                }
            }
        }), new LEGOBtnTextAndCallback(context.getString(R.string.cancel), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (AbsSendOrderServicePresenter.this.f15533a != null) {
                    AbsConfirmConfigState.isShowPopInConfirmPage = false;
                    AbsSendOrderServicePresenter.this.f15533a.dismiss();
                }
            }
        }));
        lEGODrawerModel2.setIsShowCloseImg(false);
        lEGODrawerModel2.setClickOutsideCanCancel(false);
        lEGODrawerModel2.setSubTitle(str);
        AbsConfirmConfigState.isShowPopInConfirmPage = true;
        LEGODrawer showDrawerTemplate = LEGOUICreator.showDrawerTemplate(context, lEGODrawerModel2);
        this.f15533a = showDrawerTemplate;
        return showDrawerTemplate;
    }

    /* renamed from: d */
    private void m11261d(final CarOrder carOrder) {
        if (carOrder != null) {
            OrderBanPopInfo orderBanPopInfo = carOrder.banPopInfo;
            if (orderBanPopInfo == null) {
                CarHttpHelper.validate((FragmentActivity) this.mContext, carOrder);
            } else {
                OrderBanUIUtils.showBanPopDialogIfNeed(this.mContext, orderBanPopInfo, new Runnable() {
                    public void run() {
                        HashMap hashMap = new HashMap();
                        CarOrder carOrder = carOrder;
                        if (carOrder != null) {
                            hashMap.put("passenger_status", Integer.valueOf(carOrder.banStatus));
                            hashMap.put("global_id", carOrder.banGlobalId);
                        }
                        hashMap.put("passenger_id", Long.valueOf(NationComponentDataUtil.getUid()));
                        GlobalOmegaUtils.trackEvent("pax_suspension_banner_ck", (Map<String, Object>) hashMap);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11249a(String str, String str2) {
        String authH5UrlWithSourceAdded = DDTravelConfigStore.getInstance().getAuthH5UrlWithSourceAdded(3, str);
        if (!TextUtils.isEmpty(authH5UrlWithSourceAdded)) {
            Intent intent = new Intent(this.mContext, CPFAuthWebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(GlobalWebUrl.buildUrl(authH5UrlWithSourceAdded, m11238a(str2))));
            intent.putExtra("CPF_AUTH_SOURCE_KEY", 3);
            startActivityForResult(intent, 72);
        }
    }

    /* renamed from: a */
    private Map<String, Object> m11238a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (HashMap) new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void verifyCard(final CarOrder carOrder) {
        final VerifyCardOperator verifyCardOperator = new VerifyCardOperator(this.mContext);
        verifyCardOperator.setIDialogOperation(new IDialogOperation() {
            public void show(AlertDialogFragment.Builder builder) {
                AbsSendOrderServicePresenter.this.m11245a(builder);
            }

            public void dismiss() {
                AbsSendOrderServicePresenter.this.m11268f();
            }

            public void cancelDismiss() {
                AbsSendOrderServicePresenter.this.m11268f();
                AbsSendOrderServicePresenter.this.backToEstimate();
            }
        });
        verifyCardOperator.setIVerifyOperation(new IVerifyOperation() {
            public void onReVerfiry() {
                AbsSendOrderServicePresenter.this.m11268f();
                verifyCardOperator.createVerifyDialog(carOrder);
            }

            public void onSuccess() {
                AbsSendOrderServicePresenter.this.createOrder(0);
            }

            public void onChangePayMethod() {
                AbsSendOrderServicePresenter.this.m11268f();
                AbsSendOrderServicePresenter.this.showPaymentsPage();
            }
        });
        verifyCardOperator.setIProgressOperation(new IProgressOperation() {
            public void show() {
                AbsSendOrderServicePresenter absSendOrderServicePresenter = AbsSendOrderServicePresenter.this;
                absSendOrderServicePresenter.showProgressDialog(absSendOrderServicePresenter.mContext.getString(R.string.car_sending_order));
            }

            public void dismiss() {
                AbsSendOrderServicePresenter.this.dismissProgressDialog();
            }
        });
        verifyCardOperator.createVerifyDialog(carOrder);
    }

    /* access modifiers changed from: protected */
    public void enterFaceRecognize(final CarOrder carOrder) {
        DiFaceParam diFaceParam = new DiFaceParam();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lat", LocationController.getInstance().getLat(this.mContext));
            jSONObject.put("lng", LocationController.getInstance().getLng(this.mContext));
            jSONObject.put("a3", TEBridge.clientConfig().a3Token());
            jSONObject.put("ip", SystemUtil.getIPAddress(this.mContext));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        diFaceParam.setData(jSONObject.toString());
        diFaceParam.setBizCode(carOrder.faceBizcode);
        diFaceParam.setToken(NationComponentDataUtil.getToken());
        diFaceParam.setSessionId(carOrder.faceSessionId);
        DiFace.startFaceRecognition(diFaceParam, new DiFace.IDiFaceCallback() {
            public void onResult(DiFaceResult diFaceResult) {
                GLog.m7970i("face result: " + diFaceResult.getCode() + " " + diFaceResult.getMsg());
                if (diFaceResult.isSuccessful()) {
                    GlobalSPUtil.setLastFaceSessionId(AbsSendOrderServicePresenter.this.mContext, carOrder.faceSessionId);
                    GlobalSPUtil.setLastFacePassed(AbsSendOrderServicePresenter.this.mContext, true);
                    AbsSendOrderServicePresenter.this.createOrder(0);
                    FormStore.getInstance().setCreateFailOrder((CarOrder) null);
                    return;
                }
                GlobalSPUtil.setLastFaceSessionId(AbsSendOrderServicePresenter.this.mContext, carOrder.faceSessionId);
                GlobalSPUtil.setLastFacePassed(AbsSendOrderServicePresenter.this.mContext, false);
                AbsSendOrderServicePresenter.this.backToEstimate();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11245a(AlertDialogFragment.Builder builder) {
        if (getHost().getFragmentManager() != null) {
            AlertDialogFragment create = builder.create();
            this.f15537e = create;
            create.show(getHost().getFragmentManager(), getClass().getName());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m11268f() {
        AlertDialogFragment alertDialogFragment = this.f15537e;
        if (alertDialogFragment != null) {
            alertDialogFragment.dismiss();
        }
        dismissDrawerDialog();
    }

    /* renamed from: a */
    private void m11246a(OrderParams orderParams) {
        String str;
        PayEnterpriseInfo payEnterpriseInfo;
        try {
            if (CancelTripCache.getInstance().isUsingCachedEstimateParams()) {
                str = CancelTripCache.getInstance().getPayInfo();
            } else {
                str = getPayWayTag();
                CancelTripCache.getInstance().setPayInfo(str);
            }
            if (!TextUtils.isEmpty(str)) {
                orderParams.setPayType(m11254b(str, FormStore.getInstance().getCardIndex()));
                if (str.equals(String.valueOf(512)) && (payEnterpriseInfo = (PayEnterpriseInfo) FormStore.getInstance().getData(FormStore.KEY_PAY_ENTERPRISE)) != null) {
                    orderParams.setPayEnterpriseInfo(payEnterpriseInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public String getPayWayTag() {
        FormStore instance = FormStore.getInstance();
        if (instance == null) {
            return "";
        }
        return instance.getPayWay();
    }

    /* renamed from: b */
    private String m11254b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.putOpt(com.didi.entrega.customer.foundation.tracker.param.ParamConst.PARAM_PAY_TYPE, str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject.putOpt("card_index", str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        String cardPrefix = FormStore.getInstance().getCardPrefix();
        if (!TextUtils.isEmpty(cardPrefix)) {
            try {
                jSONObject.putOpt("card_prefix", cardPrefix);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    /* renamed from: g */
    private OrderParams.DTSDKOrder412Param m11270g() {
        OrderParams.DTSDKOrder412Param dTSDKOrder412Param = new OrderParams.DTSDKOrder412Param();
        dTSDKOrder412Param.defaultFSearchId = "";
        dTSDKOrder412Param.defaultFUid = "";
        dTSDKOrder412Param.defaultFSrcTag = "";
        return dTSDKOrder412Param;
    }

    /* renamed from: h */
    private OrderParams.DTSDKOrder412Param m11272h() {
        return new OrderParams.DTSDKOrder412Param();
    }

    /* renamed from: e */
    private void m11264e(CarOrder carOrder) {
        int i = carOrder.verifyMode;
        this.f15534b.clear();
        this.f15536d = null;
        this.f15535c = null;
        if (i >= 0) {
            this.f15536d = m11267f(carOrder);
            this.f15535c = carOrder.auth_h5_url;
            if (i == 1) {
                this.f15534b.add(ItemType.CREDIT_CARD.getType());
                this.f15534b.add(ItemType.FACEBOOK.getType());
            } else if (i == 2) {
                this.f15534b.add(ItemType.FACEBOOK.getType());
            } else if (i == 3) {
                this.f15534b.add(ItemType.CREDIT_CARD.getType());
            } else if (i == 5) {
                this.f15534b.add(ItemType.CREDIT_CARD.getType());
                this.f15534b.add(ItemType.FACEBOOK.getType());
                this.f15534b.add(ItemType.MEXICO_CURP.getType());
            } else if (i != 6) {
                RiskInterceptPopup.getInstance(String.valueOf(i), m11267f(carOrder)).show(((FragmentActivity) this.mContext).getSupportFragmentManager(), "");
                return;
            } else {
                this.f15534b.add(ItemType.CREDIT_CARD.getType());
                this.f15534b.add(ItemType.MEXICO_CURP.getType());
            }
            NormalDialogInfo normalDialogInfo = new NormalDialogInfo(10001);
            normalDialogInfo.setTitle((CharSequence) null);
            normalDialogInfo.setIcon(AlertController.IconType.INFO);
            normalDialogInfo.setMessage(this.mContext.getString(R.string.risk_page_dialog_msg_alert));
            normalDialogInfo.setPositiveText(this.mContext.getString(R.string.risk_page_dialog_msg_alert_confirm));
            normalDialogInfo.setTitle(this.mContext.getString(R.string.risk_page_dialog_title_alert));
            normalDialogInfo.setCancelable(false);
            normalDialogInfo.setCloseVisible(true);
            HashMap hashMap = new HashMap();
            hashMap.put("bubble_id", SearchIdUploadManager.getInstance().getBubbleId());
            GlobalOmegaUtils.trackEvent("ibt_gp_safetyvarifypopup_sw", (Map<String, Object>) hashMap);
            showDialog(normalDialogInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public String m11267f(CarOrder carOrder) {
        return carOrder.mExtendResult == null ? "" : carOrder.mExtendResult.toString();
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getOmgeaParamsOfForceBindOnlinePayment() {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", String.valueOf(NationComponentDataUtil.getUid()));
        AnyCarEstimateItemModel anyCarEstimateItemModel = this.f15541i;
        if (anyCarEstimateItemModel != null) {
            int carBussinessId = anyCarEstimateItemModel.getCarBussinessId();
            if (carBussinessId == 0) {
                carBussinessId = FormStore.getInstance().Bid;
            }
            hashMap.put("product_id", String.valueOf(carBussinessId));
        } else {
            hashMap.put("product_id", String.valueOf(FormStore.getInstance().Bid));
        }
        hashMap.put("city_id", Integer.valueOf(ReverseLocationStore.getsInstance().getCityId() == -1 ? ReverseLocationStore.getsInstance().getCachedCityId(this.mContext) : ReverseLocationStore.getsInstance().getCityId()));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void goToAddBankCard() {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 15;
        addCardParam.resourceId = DiFaceLogger.EVENT_ID_BIOASSAY_EXIT;
        DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(getHost(), requestCodeForHost(76), addCardParam);
    }

    /* access modifiers changed from: protected */
    public void dismissDrawerDialog() {
        GGKAbsDrawer gGKAbsDrawer = this.f15538f;
        if (gGKAbsDrawer != null) {
            gGKAbsDrawer.hideLoading();
            this.f15538f.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void showDrawerDialog(CommonPopUp commonPopUp, final CommonPopUp.OnOptionClickListener onOptionClickListener, final boolean z) {
        GGKBaseDrawerModel gGKBaseDrawerModel;
        if (commonPopUp != null && !CollectionUtils.isEmpty((Collection<?>) commonPopUp.options)) {
            GGKBtnTextAndCallback gGKBtnTextAndCallback = null;
            GGKBtnTextAndCallback gGKBtnTextAndCallback2 = null;
            for (final CommonPopUp.PopUpOptions next : commonPopUp.options) {
                if (next.type == 1 || next.type == 3) {
                    gGKBtnTextAndCallback = new GGKBtnTextAndCallback(next.text, new GGKOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            if (!z) {
                                AbsSendOrderServicePresenter.this.dismissDrawerDialog();
                            }
                            CommonPopUp.OnOptionClickListener onOptionClickListener = onOptionClickListener;
                            if (onOptionClickListener != null) {
                                onOptionClickListener.onConfirm(next.data);
                            }
                        }
                    });
                } else if (next.type == 0) {
                    gGKBtnTextAndCallback2 = new GGKBtnTextAndCallback(next.text, new GGKOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            AbsSendOrderServicePresenter.this.dismissDrawerDialog();
                            CommonPopUp.OnOptionClickListener onOptionClickListener = onOptionClickListener;
                            if (onOptionClickListener != null) {
                                onOptionClickListener.onCancel();
                            }
                        }
                    });
                }
            }
            if (gGKBtnTextAndCallback == null) {
                gGKBtnTextAndCallback = gGKBtnTextAndCallback2;
            }
            if (gGKBtnTextAndCallback != null) {
                if (gGKBtnTextAndCallback2 == null) {
                    gGKBaseDrawerModel = new GGKDrawerModel1(commonPopUp.title, gGKBtnTextAndCallback);
                } else {
                    gGKBaseDrawerModel = new GGKDrawerModel2(commonPopUp.title, gGKBtnTextAndCallback, gGKBtnTextAndCallback2);
                }
                gGKBaseDrawerModel.setSubTitle(commonPopUp.showMsg).setClickOutsideCanCancel(false).setIsLoadingEnable(z);
                this.f15538f = GGKUICreator.showDrawerModel(this.mContext, gGKBaseDrawerModel);
            }
        }
    }
}
