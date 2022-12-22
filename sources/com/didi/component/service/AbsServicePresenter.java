package com.didi.component.service;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.app.router.PageRouter;
import com.didi.component.business.cancelintercept.CancelInterceptJumpEvent;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.data.form.listener.TripListener;
import com.didi.component.business.event.OrderServiceEvent;
import com.didi.component.business.event.TripSwitchSceneEvent;
import com.didi.component.business.pageswitchparam.BackToConfirmParam;
import com.didi.component.business.pageswitchparam.CreateOrderParam;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.MapUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.business.util.PriceUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.base.CompSceneUtil;
import com.didi.component.common.cache.CacheApolloUtils;
import com.didi.component.common.config.DynamicConfigManager;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.common.dialog.ImageHintDialog;
import com.didi.component.common.dialog.ImageHintDialogInfo;
import com.didi.component.common.loading.AbsLoadingPresenter;
import com.didi.component.common.push.model.WalletChangeDialogModel;
import com.didi.component.common.track.DidiTrackingClient;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.core.Animations;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.service.util.PageSenceUtil;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.ComponentConfigManager;
import com.didi.global.globalgenerickit.GGKUICreator;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.global.globalgenerickit.dialog.GGKDialogFragment;
import com.didi.global.globalgenerickit.dialog.GGKDialogModel3;
import com.didi.global.globalgenerickit.dialog.GGKDialogModel7;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel2;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.events.SwitchTypeEvent;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.event.CarInfoUpdateEvent;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.service.ForegroundLauncher;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.p171v2.session.Scene;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.model.response.CarConfig;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.p170v2.poll.ExpressOrderStatusPoll;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import com.didi.travel.psnger.utils.JsonUtil;
import com.didi.travel.psnger.utils.TextUtil;
import com.didi.travel.psnger.utils.WindowUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsServicePresenter extends AbsLoadingPresenter<IServiceView> {
    protected static final int DIALOG_ID_FIXED_PRICE_CHANGE_FAIL = 102;
    protected static final int DIALOG_ID_FIXED_PRICE_CHANGE_SUCCESS = 101;
    public static final int REQUEST_CODE_CPF_AUTH = 72;
    public static final int REQUEST_CODE_CPF_BLOCKING_CREDIT = 73;
    public static final int REQUEST_CODE_FOR_DYNAMIC = 71;
    public static final int REQUEST_CODE_FOR_SEND_ORDER_LOGIN = 70;
    public static final int REQUEST_CODE_FOR_WAYPOINT_SEND_ORDER_LOGIN = 78;
    public static final int REQUEST_CODE_PREPAY = 77;
    public static final int REQUEST_CODE_SIGN_CARD = 76;
    public static final int REQUEST_RISK_ACTIVITY = 100;

    /* renamed from: b */
    private static final int f15551b = 1;

    /* renamed from: c */
    private static final int f15552c = 2;

    /* renamed from: d */
    private static final int f15553d = 3;

    /* renamed from: e */
    private static final int f15554e = 4;

    /* renamed from: f */
    private static final int f15555f = 600000;

    /* renamed from: h */
    private static final int f15556h = 0;

    /* renamed from: i */
    private static final int f15557i = 1;

    /* renamed from: j */
    private static final int f15558j = 2;

    /* renamed from: k */
    private static final int f15559k = 3;

    /* renamed from: l */
    private static final int f15560l = 4;

    /* renamed from: m */
    private static final int f15561m = 103;

    /* renamed from: s */
    private static final long f15562s = 120000;

    /* renamed from: A */
    private BaseEventPublisher.OnEventListener<String> f15563A = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            JSONArray optJSONArray;
            try {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (jSONObject.has("business_scene") && (optJSONArray = jSONObject.optJSONArray("business_scene")) != null) {
                        ArrayList<String> parseJSONArrayString = JsonUtil.parseJSONArrayString(optJSONArray);
                        if (!CollectionUtils.isEmpty((Collection) parseJSONArrayString)) {
                            int i = AbsServicePresenter.this.mComponentParams.pageID;
                            String str3 = "";
                            String str4 = i == 1001 ? ComponentConfigManager.BUSINESS_SCENE_HOME : i == 1030 ? ComponentConfigManager.BUSINESS_SCENE_ESTIMATE : i == 1040 ? ComponentConfigManager.BUSINESS_SCENE_ON_TRIP : str3;
                            if (!TextUtils.isEmpty(str4)) {
                                boolean z = false;
                                Iterator<String> it = parseJSONArrayString.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (str4.equals(it.next())) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                if (z) {
                                    JSONObject optJSONObject = jSONObject.optJSONObject("extra_data");
                                    HashMap hashMap = new HashMap();
                                    if (CarOrderHelper.getOrder() != null) {
                                        str3 = CarOrderHelper.getOrder().oid;
                                    }
                                    hashMap.put("oid", str3);
                                    hashMap.put("extra_data", optJSONObject);
                                    GGKConfigManager.requestConfig(AbsServicePresenter.this.getHost().getActivity(), hashMap, str4, (String) null, "passenger_newPopup");
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                GLog.m7971i("Component Config Alert", e.getMessage());
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: B */
    public ImageHintDialog f15564B;

    /* renamed from: C */
    private BaseEventPublisher.OnEventListener<String> f15565C = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (BaseEventKeys.Push.EVENT_SHOW_COMPENSATION_4_WAIT.equals(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    final String string = jSONObject.getString("title");
                    final String string2 = jSONObject.getString("content");
                    final String string3 = jSONObject.getString("but_text");
                    final int i = jSONObject.getInt("action_type");
                    final String string4 = jSONObject.getString("act_id");
                    AbsServicePresenter.this.m11292a(str2);
                    UiThreadHandler.postDelayed(new Runnable() {
                        public void run() {
                            if (i == 1) {
                                AbsServicePresenter.this.m11294a(string, string2, string3, string4);
                            }
                        }
                    }, 500);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    /* renamed from: D */
    private int f15566D = GlobalApolloUtil.howLongCanRecreateOrderAfterCancelled();

    /* renamed from: E */
    private BaseEventPublisher.OnEventListener<Boolean> f15567E = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            AbsServicePresenter.this.gotoConfirmPage(false, "");
            OmegaSDKAdapter.trackEvent("gp_cancelreason_panel_request_fail_event_fail");
        }
    };

    /* renamed from: F */
    private BaseEventPublisher.OnEventListener<String> f15568F = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            GLog.m7965d("hgl_tag", "onEvent() category = " + str + " switch2TargetBiz = " + str2);
            if (str.equals(BaseEventKeys.Componentization.EVENT_COMPONENTIZATION_BACK_HOME)) {
                AbsServicePresenter.this.switchBiz(str2);
            }
        }
    };

    /* renamed from: G */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15569G = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsServicePresenter.this.m11309f();
        }
    };
    protected final String TAG = getClass().getSimpleName();

    /* renamed from: a */
    private final Logger f15570a = LoggerFactory.getLogger(getClass());

    /* renamed from: g */
    private int f15571g = 1;
    protected boolean isAnyCar = false;
    protected BusinessContext mBusinessContext;
    protected GotoWaitRspPage mGotoWaitRspPage;
    protected ExpressOrderStatusPoll mOrderStatusPoll;

    /* renamed from: n */
    BaseEventPublisher.OnEventListener<CancelInterceptJumpEvent> f15572n = new BaseEventPublisher.OnEventListener<CancelInterceptJumpEvent>() {
        public void onEvent(String str, CancelInterceptJumpEvent cancelInterceptJumpEvent) {
            if (cancelInterceptJumpEvent != null) {
                AbsServicePresenter.this.forwardNew(cancelInterceptJumpEvent.pageId, cancelInterceptJumpEvent.bundle);
            }
        }
    };
    protected int orderSource = 0;

    /* renamed from: p */
    BaseEventPublisher.OnEventListener<String> f15573p = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            try {
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject("common_alert");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("title");
                    String optString2 = optJSONObject.optString("show_msg");
                    String optString3 = optJSONObject.optString("image");
                    JSONArray jSONArray = optJSONObject.getJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        GGKDialogFragment unused = AbsServicePresenter.this.f15580x = GGKUICreator.showDialogModel(((FragmentActivity) AbsServicePresenter.this.mContext).getSupportFragmentManager(), new GGKDialogModel3(optString, optString2, new GGKBtnTextAndCallback(jSONArray.getJSONObject(0).optString("text"), new GGKOnAntiShakeClickListener() {
                            public void onAntiShakeClick(View view) {
                                AbsServicePresenter.this.f15580x.dismiss();
                            }
                        })).setImageUrl(optString3), "Guess what's new");
                        AbsServicePresenter.this.f15580x.setCancelable(false);
                    }
                }
            } catch (Exception e) {
                GLog.m7971i("Common Alert", e.getMessage());
            }
        }
    };

    /* renamed from: q */
    BaseEventPublisher.OnEventListener<WalletChangeDialogModel> f15574q = new BaseEventPublisher.OnEventListener<WalletChangeDialogModel>() {
        public void onEvent(String str, final WalletChangeDialogModel walletChangeDialogModel) {
            if (walletChangeDialogModel != null && AbsServicePresenter.this.f15582z == null) {
                GGKBtnTextAndCallback gGKBtnTextAndCallback = new GGKBtnTextAndCallback(walletChangeDialogModel.posText, new GGKOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        if (AbsServicePresenter.this.f15582z != null) {
                            AbsServicePresenter.this.f15582z.dismiss();
                            GGKDialogFragment unused = AbsServicePresenter.this.f15582z = null;
                        }
                        if (ConfProxy.getInstance().getGroupByType("wallet") != null) {
                            AbsServicePresenter.this.switchBiz("wallet");
                        } else {
                            DRouter.build("taxis99OneTravel://one/nativeWallet").start(AbsServicePresenter.this.mContext);
                        }
                    }
                });
                GGKBtnTextAndCallback gGKBtnTextAndCallback2 = new GGKBtnTextAndCallback(walletChangeDialogModel.negText, new GGKOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        if (AbsServicePresenter.this.f15582z != null) {
                            AbsServicePresenter.this.f15582z.dismiss();
                            GGKDialogFragment unused = AbsServicePresenter.this.f15582z = null;
                        }
                    }
                });
                GGKDialogModel7 gGKDialogModel7 = new GGKDialogModel7(walletChangeDialogModel.title, walletChangeDialogModel.content, walletChangeDialogModel.linkText, new GGKOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        if (AbsServicePresenter.this.f15582z != null) {
                            AbsServicePresenter.this.f15582z.dismiss();
                            GGKDialogFragment unused = AbsServicePresenter.this.f15582z = null;
                        }
                        WalletChangeDialogModel walletChangeDialogModel = walletChangeDialogModel;
                        if (walletChangeDialogModel != null && !TextUtils.isEmpty(walletChangeDialogModel.link)) {
                            Intent intent = new Intent(AbsServicePresenter.this.mContext, GlobalWebActivity.class);
                            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(walletChangeDialogModel.link));
                            AbsServicePresenter.this.mContext.startActivity(intent);
                        }
                    }
                }, gGKBtnTextAndCallback);
                gGKDialogModel7.addMinorBtn(gGKBtnTextAndCallback2);
                gGKDialogModel7.setImageUrl(walletChangeDialogModel.imageUrl);
                AbsServicePresenter absServicePresenter = AbsServicePresenter.this;
                GGKDialogFragment unused = absServicePresenter.f15582z = GGKUICreator.showDialogModel(((FragmentActivity) absServicePresenter.mContext).getSupportFragmentManager(), gGKDialogModel7, "wallet_change_dialog");
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: r */
    public String f15575r = "";

    /* renamed from: t */
    private int f15576t = 0;

    /* renamed from: u */
    private AlertDialogFragment f15577u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public long f15578v = 0;

    /* renamed from: w */
    private GGKDialogFragment f15579w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public GGKDialogFragment f15580x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public LEGODrawer f15581y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public GGKDialogFragment f15582z;

    /* access modifiers changed from: protected */
    public boolean dispatchDynamicPriceConfirm(EstimateItem estimateItem) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onSendOrderRequestAction() {
    }

    public AbsServicePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mBusinessContext = componentParams.bizCtx;
        this.mComponentParams = componentParams;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.orderSource = bundle.getInt(BaseExtras.Common.EXTRA_ORDER_SOURCE, 0);
        this.f15571g = 1;
        subscribe(BaseEventKeys.Componentization.EVENT_COMPONENTIZATION_BACK_HOME, this.f15568F);
        m11288a(bundle);
        stopTracking();
    }

    /* access modifiers changed from: protected */
    public void beforeOrderIdUpdate() {
        super.beforeOrderIdUpdate();
        ExpressOrderStatusPoll expressOrderStatusPoll = this.mOrderStatusPoll;
        if (expressOrderStatusPoll != null) {
            expressOrderStatusPoll.stopPoll((Scene) null);
            this.mOrderStatusPoll.destroyPoll((Scene) null);
        }
    }

    /* access modifiers changed from: protected */
    public void afterOrderIdUpdate() {
        super.afterOrderIdUpdate();
        if (this.mComponentProxy.getSession() == null || TextUtils.isEmpty(this.mComponentProxy.getOrderId())) {
            String str = this.TAG;
            LogUtils.m31495w(str, "afterOrderIdUpdate:invalid data, session = " + this.mComponentProxy.getSession() + ", orderId = " + this.mComponentProxy.getOrderId());
            return;
        }
        this.mOrderStatusPoll = ExpressOrderStatusPoll.getInstance(TravelUtil.getScene(1104), this.mComponentProxy.getSession(), this.mComponentProxy.getOrderId());
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Componentization.EVENT_COMPONENTIZATION_BACK_HOME, this.f15568F);
        this.f15571g = 2;
        onUnsubscribeEventReceiver();
        this.f15578v = 0;
        endReEstimate();
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        this.f15571g = 3;
        onUnsubscribeEventReceiver();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        this.f15571g = 4;
        onSubscribeEventReceiver();
    }

    /* renamed from: a */
    private void m11288a(Bundle bundle) {
        m11299b(bundle);
        m11298b();
        onSubscribeEventReceiver();
    }

    /* renamed from: b */
    private void m11299b(Bundle bundle) {
        CarOrder carOrder;
        if (CarOrderHelper.getOrder() == null && (carOrder = (CarOrder) bundle.getSerializable(BaseExtras.Common.EXTRA_ORDER_BEAN)) != null) {
            CarOrderHelper.saveOrder(carOrder);
        }
    }

    /* renamed from: b */
    private void m11298b() {
        if (this.mComponentProxy.getSession() == null || TextUtils.isEmpty(this.mComponentProxy.getOrderId())) {
            String str = this.TAG;
            LogUtils.m31495w(str, "initTravelOrdervice:invalid data, session = " + this.mComponentProxy.getSession() + ", orderId = " + this.mComponentProxy.getOrderId());
            return;
        }
        this.mOrderStatusPoll = ExpressOrderStatusPoll.getInstance(TravelUtil.getScene(1103), this.mComponentProxy.getSession(), this.mComponentProxy.getOrderId());
    }

    /* access modifiers changed from: protected */
    public void showProgressDialog(String str) {
        showMaskLayerLoading();
    }

    /* access modifiers changed from: protected */
    public void dismissProgressDialog() {
        hideLoading();
    }

    /* access modifiers changed from: protected */
    public void onSubscribeEventReceiver() {
        subscribe(BaseEventKeys.Push.EVENT_SHOW_COMPENSATION_4_WAIT, this.f15565C);
        subscribe(BaseEventKeys.Service.CancelOrder.EVENT_CANCEL_REASON_SUBMIT_SKIP, this.f15567E);
        subscribe(BaseEventKeys.Service.EVENT_CANCEL_INTERCEPT_PAGE_JUMP, this.f15572n);
        subscribe(BaseEventKeys.Push.EVENT_COMMON_ALERT, this.f15573p);
        subscribe(BaseEventKeys.Push.EVENT_COMPONENT_CONFIG_LEGO_ALERT, this.f15563A);
        subscribe(BaseEventKeys.Push.EVENT_WALLET_CHANGE_ALERT, this.f15574q);
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_BACK_TO_HOME, this.f15569G);
    }

    /* access modifiers changed from: protected */
    public void onUnsubscribeEventReceiver() {
        unsubscribe(BaseEventKeys.Push.EVENT_SHOW_COMPENSATION_4_WAIT, this.f15565C);
        unsubscribe(BaseEventKeys.Service.CancelOrder.EVENT_CANCEL_REASON_SUBMIT_SKIP, this.f15567E);
        unsubscribe(BaseEventKeys.Service.EVENT_CANCEL_INTERCEPT_PAGE_JUMP, this.f15572n);
        unsubscribe(BaseEventKeys.Push.EVENT_COMMON_ALERT, this.f15573p);
        unsubscribe(BaseEventKeys.Push.EVENT_COMPONENT_CONFIG_LEGO_ALERT, this.f15563A);
        unsubscribe(BaseEventKeys.Push.EVENT_WALLET_CHANGE_ALERT, this.f15574q);
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_BACK_TO_HOME, this.f15569G);
    }

    /* access modifiers changed from: protected */
    public boolean interceptRequestAction() {
        FormStore instance = FormStore.getInstance();
        boolean booleanData = instance.getBooleanData(FormStore.KEY_RECALL_ORDER, false);
        Logger logger = this.f15570a;
        logger.info("AbsServicePresenter interceptRequestAction autoSendOrder=" + booleanData, new Object[0]);
        if (booleanData) {
            FormStore.getInstance().setData(FormStore.KEY_RECALL_ORDER, false);
            return false;
        } else if (!instance.isAddressValid()) {
            ToastHelper.showLongInfo(this.mContext, (int) R.string.car_toast_address_empty);
            return true;
        } else if (interceptBookOrder()) {
            doPublish(BaseEventKeys.Confirm.EVENT_CONFIRM_BOOK_TIME_ERROR);
            return true;
        } else if (interceptPayWay()) {
            this.f15570a.info("AbsServicePresenter interceptRequestAction interceptPayWay", new Object[0]);
            return true;
        } else if (!NationComponentDataUtil.isLoginNow() || TextUtils.isEmpty(NationComponentDataUtil.getToken())) {
            gotoLoginForResult(70);
            return true;
        } else if (m11303c()) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: c */
    private boolean m11303c() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null && confirmListener.getIsAnyCar()) {
            AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
            if (selectedSingleAnyCarItem != null) {
                FormStore instance = FormStore.getInstance();
                if (instance.hasStopPoints()) {
                    return false;
                }
                JSONObject deliveryInfo = instance.getDeliveryInfo();
                if (deliveryInfo == null || deliveryInfo.optBoolean("intercepted")) {
                    CarConfig.ConfirmActionInfo a = m11286a(selectedSingleAnyCarItem);
                    if (a != null && a.validated()) {
                        DRouter.build(a.getActionDeepLink()).start(this.mContext);
                        FormStore.getInstance().setSkipEstimateGet(true);
                        return true;
                    }
                } else {
                    try {
                        deliveryInfo.put("intercepted", true);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return false;
                }
            }
            return false;
        } else if (FormStore.getInstance().getNewEstimateItem() == null) {
            return false;
        } else {
            FormStore instance2 = FormStore.getInstance();
            if (instance2.hasStopPoints()) {
                return false;
            }
            JSONObject deliveryInfo2 = instance2.getDeliveryInfo();
            if (deliveryInfo2 == null || deliveryInfo2.optBoolean("intercepted")) {
                CarConfig.ConfirmActionInfo confirmActionInfo = FormStore.getInstance().getConfirmActionInfo();
                if (confirmActionInfo == null || !confirmActionInfo.validated()) {
                    return false;
                }
                DRouter.build(confirmActionInfo.getActionDeepLink()).start(this.mContext);
                FormStore.getInstance().setSkipEstimateGet(true);
                return true;
            }
            try {
                deliveryInfo2.put("intercepted", true);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: a */
    private CarConfig.ConfirmActionInfo m11286a(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        if (!(anyCarEstimateItemModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakDelivery == null || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null)) {
            try {
                JSONObject jSONObject = new JSONObject(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakDelivery.toString());
                return new CarConfig.ConfirmActionInfo(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carProductId + "", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean interceptPayWay() {
        return TextUtils.isEmpty(FormStore.getInstance().getPayWay());
    }

    /* access modifiers changed from: protected */
    public void gotoLoginForResult(int i) {
        NationComponentDataUtil.goToLoginPageForResult(getHost(), requestCodeForHost(i));
    }

    /* access modifiers changed from: protected */
    public boolean interceptBookOrder() {
        long transportTime = FormStore.getInstance().getTransportTime();
        return transportTime > 0 && transportTime - System.currentTimeMillis() < 600000;
    }

    /* access modifiers changed from: protected */
    public void buildDYEstimateShow(String str) {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        String str2 = newEstimateItem != null ? newEstimateItem.estimateId : null;
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("bubble_id", str2);
        }
        GlobalOmegaUtils.trackEvent(str, "", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void gotoConfirmPage(boolean z, String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        bundle.putBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_GET_ON_SCENE, z);
        bundle.putBoolean(BaseExtras.ConfirmService.CANCEL_ORDER_BACK_TO_ESTIMATE, false);
        bundle.putString(BaseExtras.ConfirmService.EXTRA_BACK_TO_CONFIRM_TIP, str);
        bundle.putSerializable(BaseExtras.Common.EXTRA_BACK_TO_CONFIRM, m11305d());
        forward(1030, bundle);
    }

    /* renamed from: d */
    private BackToConfirmParam m11305d() {
        BackToConfirmParam backToConfirmParam = new BackToConfirmParam();
        TripListener tripListener = PageCompDataTransfer.getInstance().getTripListener();
        if (tripListener != null) {
            List<AnyCarEstimateItemModel> selectedAnyCarItems = tripListener.getSelectedAnyCarItems();
            if (!CollectionUtil.isEmpty((Collection<?>) selectedAnyCarItems)) {
                backToConfirmParam.mAnyCarSelectedItemModels = selectedAnyCarItems;
            }
            backToConfirmParam.groups = tripListener.getGroups();
            backToConfirmParam.mIsAnyCar = tripListener.getIsAnyCar();
            backToConfirmParam.mPreference = tripListener.getPreference();
        }
        return backToConfirmParam;
    }

    /* access modifiers changed from: protected */
    public void gotoWaitRspPage(CarOrder carOrder, boolean z) {
        GotoWaitRspPage gotoWaitRspPage = this.mGotoWaitRspPage;
        if (gotoWaitRspPage != null) {
            UiThreadHandler.removeCallbacks(gotoWaitRspPage);
        } else {
            this.mGotoWaitRspPage = new GotoWaitRspPage(carOrder, z);
        }
        if (CacheApolloUtils.openWaitRspOptimization()) {
            doPublish(BaseEventKeys.WaitRsp.EVENT_BEFORE_GOTO_WAITRSP_ANIMATION);
            UiThreadHandler.postDelayed(this.mGotoWaitRspPage, 200);
            return;
        }
        this.mGotoWaitRspPage.run();
    }

    protected class GotoWaitRspPage implements Runnable {
        private boolean isSendOrderInWaitRspPage;
        private CarOrder order;

        public GotoWaitRspPage(CarOrder carOrder, boolean z) {
            this.order = carOrder;
            this.isSendOrderInWaitRspPage = z;
        }

        public void run() {
            Bundle bundle = new Bundle();
            bundle.putSerializable(BaseExtras.Common.EXTRA_ORDER_BEAN, this.order);
            bundle.putString(BaseExtras.ConfirmService.EXTRA_GOTO_WAIT_RSP_SOURCE, "AbsServicePresenter.GotoWaitRspPage.run&isSendOrderInWaitRspPage=" + this.isSendOrderInWaitRspPage);
            bundle.putSerializable(BaseExtras.ConfirmService.EXTRA_SEND_ORDER_IN_WAIT_RSP_PAGE, Boolean.valueOf(this.isSendOrderInWaitRspPage));
            bundle.putSerializable(BaseExtras.Common.EXTRA_CREATE_ORDER, AbsServicePresenter.this.getCreateOrderParam());
            AbsServicePresenter.this.forwardNew(1005, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public CreateOrderParam getCreateOrderParam() {
        CreateOrderParam createOrderParam = new CreateOrderParam();
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null && confirmListener.getIsAnyCar()) {
            this.isAnyCar = true;
            if (confirmListener.getSelectedSingleAnyCarItem() != null) {
                createOrderParam.mSelectedSingleModel = confirmListener.getSelectedSingleAnyCarItem();
                createOrderParam.mAnyCarSelectedItemModels = confirmListener.getSelectedAnyCarItems();
            } else if (!CollectionUtil.isEmpty((Collection<?>) confirmListener.getAllCarItems()) && !CollectionUtil.isEmpty((Collection<?>) confirmListener.getSelectedAnyCarItems())) {
                createOrderParam.mAllCar = confirmListener.getAllCarItems();
                createOrderParam.mAnyCarSelectedItemModels = confirmListener.getSelectedAnyCarItems();
            }
            createOrderParam.mPreference = confirmListener.getPreference();
            createOrderParam.groups = confirmListener.getGroups();
            createOrderParam.mIsAnyCar = confirmListener.getIsAnyCar();
            if (!(confirmListener.getAnyCarResponse() == null || confirmListener.getAnyCarResponse().globalConfig == null)) {
                createOrderParam.mTraceId = confirmListener.getAnyCarResponse().globalConfig.globalEstimateTraceId;
            }
        }
        return createOrderParam;
    }

    /* access modifiers changed from: protected */
    public void dispatchActionResponseEvent(RequestServiceAction requestServiceAction, OrderServiceEvent orderServiceEvent) {
        int i = this.f15571g;
        if (3 != i && 2 != i && C691214.$SwitchMap$com$didi$component$service$RequestServiceAction[requestServiceAction.ordinal()] == 1) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.SendOrder.EVENT_RESPONSE_ACTION_SEND_ORDER, orderServiceEvent);
        }
    }

    /* renamed from: com.didi.component.service.AbsServicePresenter$14 */
    static /* synthetic */ class C691214 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$component$service$RequestServiceAction;

        static {
            int[] iArr = new int[RequestServiceAction.values().length];
            $SwitchMap$com$didi$component$service$RequestServiceAction = iArr;
            try {
                iArr[RequestServiceAction.SendOrder.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void setBackVisible(boolean z) {
        if (getParent() != null) {
            getParent().setBackVisible(z);
        }
    }

    /* access modifiers changed from: protected */
    public final void setTitle(String str) {
        if (str == null) {
            str = "";
        }
        if (getParent() != null) {
            getParent().setTitle(str);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00b4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x006b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean reEstimateBeforeSendOrder() {
        /*
            r19 = this;
            r0 = r19
            com.didi.component.business.data.form.FormStore r1 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.component.business.data.form.PageCompDataTransfer r2 = com.didi.component.business.data.form.PageCompDataTransfer.getInstance()
            com.didi.component.business.data.form.listener.ConfirmListener r2 = r2.getConfirmListener()
            java.lang.String r3 = "reEstimateBeforeSendOrder start reestimate"
            r4 = 4
            r5 = 120000(0x1d4c0, double:5.9288E-319)
            r7 = 0
            r9 = 2
            r10 = 0
            r11 = 1
            if (r2 == 0) goto L_0x00cb
            boolean r12 = r2.getIsAnyCar()
            if (r12 == 0) goto L_0x00cb
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r12 = r2.getSelectedSingleAnyCarItem()
            r13 = 0
            if (r12 == 0) goto L_0x0062
            int r2 = r12.countPriceType
            if (r2 != r9) goto L_0x0060
            boolean r2 = r19.m11307e()
            if (r2 == 0) goto L_0x0036
            r0.f15576t = r11
            goto L_0x00be
        L_0x0036:
            long r14 = r1.getEstimateTime()
            int r2 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0055
            long r7 = java.lang.System.currentTimeMillis()
            long r14 = r1.getEstimateTime()
            long r7 = r7 - r14
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0055
            boolean r1 = r1.isInMiniBus()
            if (r1 != 0) goto L_0x0055
            r0.f15576t = r9
            goto L_0x00be
        L_0x0055:
            float r1 = r12.feeNumber
            int r1 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r1 >= 0) goto L_0x005e
            r0.f15576t = r10
            goto L_0x00be
        L_0x005e:
            r0.f15576t = r4
        L_0x0060:
            r11 = 0
            goto L_0x00be
        L_0x0062:
            java.util.List r2 = r2.getSelectedAnyCarItems()
            java.util.Iterator r2 = r2.iterator()
            r12 = 0
        L_0x006b:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x00bd
            java.lang.Object r14 = r2.next()
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r14 = (com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel) r14
            if (r14 == 0) goto L_0x006b
            int r15 = r14.countPriceType
            if (r15 != r9) goto L_0x006b
            boolean r12 = r19.m11307e()
            if (r12 == 0) goto L_0x0087
            r0.f15576t = r11
        L_0x0085:
            r12 = 1
            goto L_0x00b2
        L_0x0087:
            long r15 = r1.getEstimateTime()
            int r12 = (r15 > r7 ? 1 : (r15 == r7 ? 0 : -1))
            if (r12 <= 0) goto L_0x00a6
            long r15 = java.lang.System.currentTimeMillis()
            long r17 = r1.getEstimateTime()
            long r15 = r15 - r17
            int r12 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r12 <= 0) goto L_0x00a6
            boolean r12 = r1.isInMiniBus()
            if (r12 != 0) goto L_0x00a6
            r0.f15576t = r9
            goto L_0x0085
        L_0x00a6:
            float r12 = r14.feeNumber
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 >= 0) goto L_0x00af
            r0.f15576t = r10
            goto L_0x0085
        L_0x00af:
            r0.f15576t = r4
            r12 = 0
        L_0x00b2:
            if (r12 == 0) goto L_0x006b
            com.didi.sdk.logging.Logger r1 = r0.f15570a
            java.lang.Object[] r2 = new java.lang.Object[r10]
            java.lang.String r4 = "reEstimateBeforeSendOrder reestimate "
            r1.info((java.lang.String) r4, (java.lang.Object[]) r2)
        L_0x00bd:
            r11 = r12
        L_0x00be:
            if (r11 == 0) goto L_0x00ca
            com.didi.sdk.logging.Logger r1 = r0.f15570a
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r1.info((java.lang.String) r3, (java.lang.Object[]) r2)
            r19.startReEstimate()
        L_0x00ca:
            return r11
        L_0x00cb:
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r2 = r1.getNewEstimateItem()
            if (r2 == 0) goto L_0x0115
            int r12 = r2.countPriceType
            if (r12 != r9) goto L_0x0115
            boolean r12 = r19.m11307e()
            if (r12 == 0) goto L_0x00de
            r0.f15576t = r11
            goto L_0x0108
        L_0x00de:
            long r12 = r1.getEstimateTime()
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 <= 0) goto L_0x00fc
            long r7 = java.lang.System.currentTimeMillis()
            long r12 = r1.getEstimateTime()
            long r7 = r7 - r12
            int r12 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r12 <= 0) goto L_0x00fc
            boolean r1 = r1.isInMiniBus()
            if (r1 != 0) goto L_0x00fc
            r0.f15576t = r9
            goto L_0x0108
        L_0x00fc:
            boolean r1 = com.didi.component.business.util.BusinessDataUtil.isEstimateSuccessWithNoPrice(r2)
            if (r1 == 0) goto L_0x0105
            r0.f15576t = r10
            goto L_0x0108
        L_0x0105:
            r0.f15576t = r4
            r11 = 0
        L_0x0108:
            if (r11 == 0) goto L_0x0114
            com.didi.sdk.logging.Logger r1 = r0.f15570a
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r1.info((java.lang.String) r3, (java.lang.Object[]) r2)
            r19.startReEstimate()
        L_0x0114:
            r10 = r11
        L_0x0115:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.service.AbsServicePresenter.reEstimateBeforeSendOrder():boolean");
    }

    /* access modifiers changed from: protected */
    public void startReEstimate() {
        showProgressDialog(this.mContext.getString(R.string.car_sending_order));
    }

    /* access modifiers changed from: protected */
    public void endReEstimate() {
        dismissProgressDialog();
    }

    /* access modifiers changed from: protected */
    public void showFixedPriceChangeDialog(int i, String str) {
        String str2;
        char c;
        String str3;
        String str4;
        String str5;
        AlertController.IconType iconType = AlertController.IconType.INFO;
        String str6 = "";
        if (i == 4) {
            c = 'f';
            str2 = this.mContext.getString(R.string.fixed_price_change_dialog_fail_title);
            str4 = DDTravelConfigStore.getInstance().getPriceChangeReminderConfirmFailure(this.mContext.getString(R.string.fixed_price_change_dialog_fail_message));
            str3 = this.mContext.getString(R.string.fixed_price_change_dialog_fail_ok);
            AlertController.IconType iconType2 = AlertController.IconType.INFO;
        } else {
            if (i == 1) {
                str6 = this.mContext.getString(R.string.fixed_price_change_dialog_title, new Object[]{str});
                str5 = DDTravelConfigStore.getInstance().getPriceChangeReminderChangePickup(this.mContext.getString(R.string.fixed_price_change_dialog_message_change_pickup));
                AlertController.IconType iconType3 = AlertController.IconType.ADDRESS;
            } else if (i == 2) {
                str6 = this.mContext.getString(R.string.fixed_price_change_dialog_title, new Object[]{str});
                str5 = DDTravelConfigStore.getInstance().getPriceChangeReminderTimeout(this.mContext.getString(R.string.fixed_price_change_dialog_message_timeout));
                AlertController.IconType iconType4 = AlertController.IconType.INFO;
            } else if (i == 0) {
                str6 = this.mContext.getString(R.string.fixed_price_change_dialog_title, new Object[]{str});
                str5 = DDTravelConfigStore.getInstance().getPriceChangeReminderConfirmPrice(this.mContext.getString(R.string.fixed_price_change_dialog_message_price));
                AlertController.IconType iconType5 = AlertController.IconType.ADDRESS;
            } else if (i == 3) {
                str6 = this.mContext.getString(R.string.fixed_price_change_dialog_title_no_price);
                str5 = DDTravelConfigStore.getInstance().getPriceChangeReminderConfirmNoPrice(this.mContext.getString(R.string.fixed_price_change_dialog_message_no_price));
                AlertController.IconType iconType6 = AlertController.IconType.PAY;
            } else {
                str5 = str6;
            }
            str3 = this.mContext.getString(R.string.fixed_price_change_dialog_ok);
            String string = this.mContext.getString(R.string.fixed_price_change_dialog_cancel);
            this.f15578v = System.currentTimeMillis();
            str4 = str5;
            c = 'e';
            String str7 = str6;
            str6 = string;
            str2 = str7;
        }
        if (c == 'e') {
            this.f15581y = LEGOUICreator.showDrawerTemplate(this.mContext, new LEGODrawerModel2(str2, new LEGOBtnTextAndCallback(str3, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    AbsServicePresenter.this.f15581y.dismiss();
                    if (AbsServicePresenter.this.f15578v <= 0 || System.currentTimeMillis() - AbsServicePresenter.this.f15578v <= 120000) {
                        AbsServicePresenter.this.onSendOrderRequestAction();
                    } else {
                        AbsServicePresenter.this.reEstimateBeforeSendOrder();
                    }
                    long unused = AbsServicePresenter.this.f15578v = 0;
                }
            }), new LEGOBtnTextAndCallback(str6, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    AbsServicePresenter.this.f15581y.dismiss();
                    boolean unused = AbsServicePresenter.this.onBackPressed(IPresenter.BackType.BackKey);
                    long unused2 = AbsServicePresenter.this.f15578v = 0;
                }
            })).setIsShowCloseImg(false).setSubTitle(str4).setClickOutsideCanCancel(false));
            return;
        }
        this.f15581y = LEGOUICreator.showDrawerTemplate(this.mContext, new LEGODrawerModel1(str2, new LEGOBtnTextAndCallback(str3, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                AbsServicePresenter.this.f15581y.dismiss();
                boolean unused = AbsServicePresenter.this.onBackPressed(IPresenter.BackType.BackKey);
                long unused2 = AbsServicePresenter.this.f15578v = 0;
            }
        })).setSubTitle(str4).setIsShowCloseImg(false).setClickOutsideCanCancel(false));
    }

    /* renamed from: e */
    private boolean m11307e() {
        return MapUtils.getDistance(FormStore.getInstance().getGetOnStartAddress(), FormStore.getInstance().getStartAddress()) >= 50.0d;
    }

    /* access modifiers changed from: protected */
    public void reEstimateSuccess(boolean z) {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || !confirmListener.getIsAnyCar()) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (!(newEstimateItem == null || newEstimateItem.carConfig == null)) {
                if (newEstimateItem.carConfig.use_expo_intercept_popup == 1) {
                    this.f15570a.info("use_expo_intercept_popup", new Object[0]);
                    return;
                } else if (newEstimateItem.carConfig.direct_new_order == 1) {
                    this.f15570a.info("direct_new_order", new Object[0]);
                    onSendOrderRequestAction();
                    return;
                }
            }
            EstimateItemModel newEstimateItem2 = FormStore.getInstance().getNewEstimateItem();
            if (!z || newEstimateItem2 == null) {
                onSendOrderRequestAction();
            } else if (BusinessDataUtil.isEstimateSuccessWithNoPrice(newEstimateItem2) || newEstimateItem2.feeDisplay == null || newEstimateItem2.feeDisplay.isEmpty()) {
                showFixedPriceChangeDialog(3, "0");
            } else {
                showFixedPriceChangeDialog(this.f15576t, PriceUtils.getFeeDisplay(this.mBusinessContext, (double) newEstimateItem2.feeNumber, newEstimateItem2.feeDisplay, false, PriceUtils.TYPE_ESTIMATE_FEE_AMOUNT));
            }
        } else {
            AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
            if (selectedSingleAnyCarItem == null) {
                for (AnyCarEstimateItemModel next : confirmListener.getSelectedAnyCarItems()) {
                    if (next != null && next.mAnyCarEstimateNetItem.carConfig != null && next.mAnyCarEstimateNetItem.carConfig.use_expo_intercept_popup == 1) {
                        this.f15570a.info("use_expo_intercept_popup", new Object[0]);
                        return;
                    }
                }
            } else if (selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig != null && selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.use_expo_intercept_popup == 1) {
                this.f15570a.info("use_expo_intercept_popup", new Object[0]);
                return;
            }
            onSendOrderRequestAction();
        }
    }

    /* access modifiers changed from: protected */
    public void reEstimateFail() {
        showFixedPriceChangeDialog(4, "0");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11294a(String str, String str2, String str3, String str4) {
        this.f15575r = str4;
        ImageHintDialogInfo imageHintDialogInfo = new ImageHintDialogInfo(103);
        imageHintDialogInfo.setTitle(str);
        imageHintDialogInfo.setSubtitle(str2);
        imageHintDialogInfo.setButton(str3);
        imageHintDialogInfo.setCancelable(false);
        imageHintDialogInfo.setImageHolder(R.drawable.dialog_icon_4_wait_must_pay);
        ImageHintDialog.DialogBuilder dialogBuilder = new ImageHintDialog.DialogBuilder(this.mBusinessContext);
        dialogBuilder.setListener(new IDialog.DialogListener() {
            public void onAction(int i) {
                long currentTimeMillis = System.currentTimeMillis();
                if (AbsServicePresenter.this.f15564B != null) {
                    AbsServicePresenter.this.f15564B.dismiss();
                    ImageHintDialog unused = AbsServicePresenter.this.f15564B = null;
                }
                AbsServicePresenter.this.dismissDialog(103);
                if (!TextUtils.isEmpty(AbsServicePresenter.this.f15575r)) {
                    AbsServicePresenter absServicePresenter = AbsServicePresenter.this;
                    absServicePresenter.m11293a(absServicePresenter.f15575r, currentTimeMillis);
                    String unused2 = AbsServicePresenter.this.f15575r = "";
                }
            }
        });
        dialogBuilder.setDialogInfo(imageHintDialogInfo);
        ImageHintDialog build = dialogBuilder.build();
        this.f15564B = build;
        build.show();
        NotificationUtils.getInstance(this.mContext).showNotification(1112, str, str2, false, false, false, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11293a(String str, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("act_id", str);
        hashMap.put("duration", Long.valueOf(System.currentTimeMillis() - j));
        OmegaSDKAdapter.trackEvent("gp_WaitMustPay_Push_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11292a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean has = jSONObject.has("ty");
            HashMap hashMap = new HashMap();
            hashMap.put("act_id", jSONObject.get("act_id"));
            if (!(CarOrderHelper.getOrder() == null || CarOrderHelper.getOrder().orderState == null)) {
                hashMap.put("order_statue", Integer.valueOf(CarOrderHelper.getOrder().orderState.subStatus));
            }
            PageSenceUtil.PageSence pageSence = PageSenceUtil.getPageSence(getClass());
            if (pageSence != null) {
                hashMap.put("scene", Integer.valueOf(pageSence.getType()));
            }
            if (jSONObject.has(ParamConst.TRACE_ID)) {
                hashMap.put(ParamConst.TRACE_ID, jSONObject.get(ParamConst.TRACE_ID));
            }
            if (has) {
                hashMap.put("in_forground", Integer.valueOf(ActivityLifecycleManager.getInstance().isAppActive() ? 1 : 0));
                OmegaSDKAdapter.trackEvent("gp_WaitMustPay_Push_Show_ApnsFCM_sw", (Map<String, Object>) hashMap);
                return;
            }
            OmegaSDKAdapter.trackEvent("gp_WaitMustPay_Push_Show_LongConnect_sw", (Map<String, Object>) hashMap);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void switchBiz(final String str) {
        m11309f();
        if (!TextUtil.isEmpty(str)) {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    EventBus.getDefault().post(new SwitchTypeEvent(str));
                }
            }, 200);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m11309f() {
        if (!WindowUtil.getTopActivityName(this.mContext).contains("MainActivity")) {
            Intent intent = new Intent();
            intent.setFlags(View.STATUS_BAR_TRANSIENT);
            PageRouter.getInstance().startMainActivity(this.mContext, intent);
        }
        goBackRoot(new Bundle());
    }

    /* access modifiers changed from: protected */
    public void startTracking() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            DidiTrackingClient instance = DidiTrackingClient.getInstance();
            if (!instance.checkTrackingIsReduced()) {
                int pickUpFrequency = instance.getPickUpFrequency();
                int i = order.status;
                int i2 = order.substatus;
                if (i == 1 || i == 4) {
                    if (i2 == 4006) {
                        pickUpFrequency = instance.getSendFrequency();
                    }
                    instance.startTracking(1, pickUpFrequency);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void stopTracking() {
        int i;
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && (i = order.status) != 4 && i != 1) {
            stopTrackingAndStopService();
        }
    }

    /* access modifiers changed from: protected */
    public void stopTrackingAndStopService() {
        DidiTrackingClient.getInstance().stopTracking();
        ForegroundLauncher.stopForeground(this.mContext == null ? DIDIApplication.getAppContext() : this.mContext);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(CarInfoUpdateEvent carInfoUpdateEvent) {
        if (carInfoUpdateEvent != null && EventKeys.MisConfig.CAR_INFO_UPDATE.equalsIgnoreCase(carInfoUpdateEvent.tag)) {
            int i = carInfoUpdateEvent.result;
            if (i == 1 || i == 2) {
                requestDynamicConfig();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void forwardNew(int i, Bundle bundle) {
        int pageIdtoScene = CompSceneUtil.pageIdtoScene(i);
        if (pageIdtoScene == 10402 || pageIdtoScene == 10403) {
            doPublish(BaseEventKeys.Service.Trip.EVENT_TRIP_SCENE_SWITCH, new TripSwitchSceneEvent(pageIdtoScene, bundle, true));
        } else if (pageIdtoScene == 10401) {
            bundle.putInt(BaseExtras.Trip.EXTRA_TRIP_SCENE, pageIdtoScene);
            bundle.putBoolean(BaseExtras.Trip.EXTRA_TRIP_IS_ANY_CAR, this.isAnyCar);
            forward(1040, bundle, new Animations(0, 0, 0, 0));
        } else {
            forward(i, bundle);
        }
    }

    public void requestDynamicConfig() {
        DynamicConfigManager.getInstance().requestConfig(this.mContext);
    }
}
