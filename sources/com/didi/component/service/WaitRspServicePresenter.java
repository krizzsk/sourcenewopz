package com.didi.component.service;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.bizconfig.BizConfigFacade;
import com.didi.component.business.cancelintercept.CancelInterceptRequest;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.OrderServiceEvent;
import com.didi.component.business.event.WaitRspCancelEvent;
import com.didi.component.business.util.CarHttpHelper;
import com.didi.component.business.util.CarNotifyManager;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.business.util.SoundUtils;
import com.didi.component.business.util.Utils;
import com.didi.component.common.cache.CacheApolloUtils;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.push.CommonPushManager;
import com.didi.component.common.push.model.ExpectationManagementModel;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.service.view.NewCancelInterceptPopup;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.travel.p171v2.session.Scene;
import com.didi.travel.p171v2.store.Store;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.bff.BffConstants;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.common.push.PushManager;
import com.didi.travel.psnger.core.listener.DefaultDiDiCoreCallback;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.model.event.UpdateWaitTimeEvent;
import com.didi.travel.psnger.model.response.CancelOrder;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.PreAuthModel;
import com.didi.travel.psnger.p170v2.IExpress;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.p170v2.api.ResponseListenerAdapter;
import com.didi.travel.psnger.p170v2.poll.ExpressOrderStatusPoll;
import com.didi.travel.psnger.utils.LogUtil;
import com.didi.travel.psnger.utils.OmegaUtils;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.travel.biz.ride.strategy.WaitRspBehaviorStrategy;
import com.didiglobal.travel.biz.ride.trip.TripBehaviorController;
import com.didiglobal.travel.util.Preconditions;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class WaitRspServicePresenter extends AbsSendOrderServicePresenter {

    /* renamed from: b */
    BaseEventPublisher.OnEventListener<Object> f15629b = new BaseEventPublisher.OnEventListener<Object>() {
        public void onEvent(String str, Object obj) {
            WaitRspServicePresenter.this.onCancelOrderRequestAction(obj);
        }
    };

    /* renamed from: c */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15630c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            Bundle bundle = new Bundle();
            if (WaitRspServicePresenter.this.f15643t) {
                bundle.putString("key_sub_title", ResourcesHelper.getString(WaitRspServicePresenter.this.mContext, R.string.Global_Rider_Expand_brandcast_epidemic_patience_WFeO));
            }
            NewCancelInterceptPopup.show(WaitRspServicePresenter.this.getHost().getFragmentManager(), NewCancelInterceptPopup.CancelInterceptScene.wait_rsp, WaitRspServicePresenter.this.mComponentParams, bundle);
        }
    };

    /* renamed from: d */
    private final Logger f15631d = LoggerFactory.getLogger(getClass());

    /* renamed from: e */
    private Bundle f15632e;

    /* renamed from: f */
    private Runnable f15633f;

    /* renamed from: g */
    private Runnable f15634g;

    /* renamed from: h */
    private Runnable f15635h;

    /* renamed from: i */
    private int f15636i;

    /* renamed from: j */
    private long f15637j;

    /* renamed from: k */
    private String f15638k;

    /* renamed from: l */
    private long f15639l;

    /* renamed from: m */
    private final DefaultDiDiCoreCallback f15640m = new DefaultDiDiCoreCallback() {
        public void onOrderStatusTimeOut() {
            super.onOrderStatusTimeOut();
            WaitRspServicePresenter.this.m11404b(true);
        }

        public void onOrderPollTimeChange(int i) {
            super.onOrderPollTimeChange(i);
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null) {
                if ((order.orderState == null ? order.status : order.orderState.status) == 7) {
                    String second2Min = Utils.second2Min(i);
                    WaitRspServicePresenter.this.m11390a(i, second2Min);
                    WaitRspServicePresenter.this.m11403b(second2Min);
                }
            }
        }

        public void onOrderStatusChange(IOrderStatus iOrderStatus) {
            super.onOrderStatusChange(iOrderStatus);
            WaitRspServicePresenter.this.m11404b(false);
        }

        public void onCommonMessageReceive(int i, String str) {
            super.onCommonMessageReceive(i, str);
        }
    };

    /* renamed from: r */
    private BaseEventPublisher.OnEventListener<Bundle> f15641r = new BaseEventPublisher.OnEventListener<Bundle>() {
        public void onEvent(String str, Bundle bundle) {
            if ("continue".equals(bundle.getString("action")) && CarOrderHelper.getOrder() != null) {
                WaitRspServicePresenter.this.onCancelOrderRequestAction(new WaitRspCancelEvent(true));
            }
        }
    };

    /* renamed from: s */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15642s = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            FormStore.getInstance().clear();
            WaitRspServicePresenter.this.goBackRoot();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f15643t = false;

    /* renamed from: u */
    private BaseEventPublisher.OnEventListener<ExpectationManagementModel> f15644u = new BaseEventPublisher.OnEventListener<ExpectationManagementModel>() {
        public void onEvent(String str, ExpectationManagementModel expectationManagementModel) {
            if (expectationManagementModel != null) {
                int i = expectationManagementModel.duse_status;
                if (i == 1 || i == 2) {
                    boolean unused = WaitRspServicePresenter.this.f15643t = expectationManagementModel.isEpidemic();
                }
            }
        }
    };

    /* renamed from: v */
    private AtomicBoolean f15645v = new AtomicBoolean(false);

    /* renamed from: w */
    private PushManager.PreAuthListener f15646w = new PushManager.PreAuthListener() {
        public void onPreAuthReceived(PreAuthModel preAuthModel) {
            CarOrder order = CarOrderHelper.getOrder();
            if (preAuthModel != null && !TextUtil.isEmpty(preAuthModel.oid) && order != null && preAuthModel.oid.equals(order.getOid())) {
                NormalDialogInfo normalDialogInfo = new NormalDialogInfo(104);
                normalDialogInfo.setIcon(AlertController.IconType.INFO);
                normalDialogInfo.setCancelable(false);
                normalDialogInfo.setIconVisible(true);
                normalDialogInfo.setMessage(preAuthModel.errorMsg);
                normalDialogInfo.setPositiveText(ResourcesHelper.getString(WaitRspServicePresenter.this.mContext, R.string.pre_auth_error_dialog_change));
                normalDialogInfo.setNegativeText(ResourcesHelper.getString(WaitRspServicePresenter.this.mContext, R.string.pre_auth_error_dialog_cancel));
                WaitRspServicePresenter.this.showDialog(normalDialogInfo);
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onForwardNextPage(int i) {
    }

    public WaitRspServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        GLog.m7965d("quxiaozaifadan", "WaitRspServicePresenter on Add");
        OmegaSDK.putGlobalAttr("g_PageId", "wait");
        this.f15637j = System.currentTimeMillis();
        this.f15632e = bundle;
        if (bundle != null) {
            this.f15636i = bundle.getInt(BaseExtras.WaitResponse.EXTRA_WAIT_RSP_PAGE_SOURCE, 0);
            this.f15638k = this.f15632e.getString(BaseExtras.ConfirmService.EXTRA_GOTO_WAIT_RSP_SOURCE);
        }
        if (this.f15632e.getBoolean(BaseExtras.ConfirmService.EXTRA_SEND_ORDER_IN_WAIT_RSP_PAGE, false)) {
            createOrder(0);
            GLog.m7965d("quxiaozaifadan", "WaitRspServicePresenter on Add 后置");
        } else {
            m11408c();
            m11391a(bundle);
            GLog.m7965d("quxiaozaifadan", "WaitRspServicePresenter on Add 后置 else");
        }
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this.mContext, "wait_rsp_tip", 0);
        String string = sharedPreferences.getString("wait_rsp_tip_order_id", "");
        if (!TextUtils.isEmpty(string) && CarOrderHelper.getOrder() != null && string.equals(CarOrderHelper.getOrder().oid)) {
            this.f15643t = sharedPreferences.getBoolean("wait_rsp_tip_is_epidemic", false);
        }
        PushManager.registerPreAuthListener(this.f15646w);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        OmegaSDK.putGlobalAttr("g_PageId", "wait");
        if (CarOrderHelper.getOrder() != null) {
            m11400a("tech_pax_order_wait_enter");
        }
        this.f15639l = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
        m11400a("tech_pax_order_wait_exit");
        m11402b();
    }

    /* renamed from: b */
    private void m11402b() {
        OmegaSDK.putGlobalAttr("g_PageId", "wait");
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() - this.f15639l;
        this.f15639l = currentTimeMillis;
        hashMap.put("time", Long.valueOf(currentTimeMillis));
        GlobalOmegaUtils.trackEvent("ibt_gp_orderstatus_time_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m11400a(String str) {
        HashMap hashMap = new HashMap();
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            hashMap.put("oid", order.getOid());
            hashMap.put("status", Integer.valueOf(order.getStatus()));
            hashMap.put(ParamKeys.PARAM_SUB_STATUS, Integer.valueOf(order.getSubStatus()));
        }
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m11410d();
        PushManager.unregisterPreAuthListener();
    }

    /* access modifiers changed from: protected */
    public void onSubscribeEventReceiver() {
        super.onSubscribeEventReceiver();
        subscribe(BaseEventKeys.Service.CancelOrder.EVENT_REQUEST_ACTION_CANCEL_ORDER, this.f15629b);
        subscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_SHOW_CANCEL_INTERCEPT_POPUP, this.f15630c);
        subscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_EXPECTATION_MANAGEMENT, this.f15644u);
        subscribe(BaseEventKeys.WaitRsp.EVENT_WAITRSP_CANCEL, this.f15641r);
        subscribe(BaseEventKeys.WaitRsp.EVENT_WAITRSP_BOOK_BACKHOME, this.f15642s);
    }

    /* access modifiers changed from: protected */
    public void onUnsubscribeEventReceiver() {
        super.onUnsubscribeEventReceiver();
        unsubscribe(BaseEventKeys.Service.CancelOrder.EVENT_REQUEST_ACTION_CANCEL_ORDER, this.f15629b);
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_SHOW_CANCEL_INTERCEPT_POPUP, this.f15630c);
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_EXPECTATION_MANAGEMENT, this.f15644u);
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAITRSP_CANCEL, this.f15641r);
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAITRSP_BOOK_BACKHOME, this.f15642s);
    }

    /* renamed from: c */
    private void m11408c() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            order.status = 7;
            m11400a("tech_pax_order_wait_enter");
        }
    }

    /* renamed from: a */
    private void m11391a(Bundle bundle) {
        if (CarOrderHelper.getOrder() != null) {
            boolean z = false;
            int i = bundle.getInt(BaseExtras.Common.EXTRA_ORDER_SOURCE, 0);
            if ((2 == i || 1 == i) && this.f15636i != 2) {
                z = true;
            }
            m11401a(z);
            m11403b("00:00");
        }
    }

    /* renamed from: a */
    private void m11401a(boolean z) {
        if (this.mOrderStatusPoll == null) {
            String str = this.TAG;
            LogUtils.m31492e(str, "startOrderService:mOrderStatusPoll is null, mTag = " + this.TAG);
            HashMap hashMap = new HashMap();
            hashMap.put("source", this.f15638k);
            hashMap.put("component_oid", this.mComponentProxy.getOrderId());
            hashMap.put("car_order_helper_oid", CarOrderHelper.getOrder() == null ? "" : CarOrderHelper.getOrder().oid);
            OmegaSDKAdapter.trackEvent("tech_waitrsp_order_poll_null", (Map<String, Object>) hashMap);
            return;
        }
        this.mOrderStatusPoll.addCoreCallback(this.f15640m);
        this.mOrderStatusPoll.startPoll((Scene) null);
    }

    /* renamed from: d */
    private void m11410d() {
        if (this.mOrderStatusPoll != null) {
            this.mOrderStatusPoll.removeCoreCallback(this.f15640m);
            this.mOrderStatusPoll.stopPoll((Scene) null);
            return;
        }
        LogUtils.m31495w(this.TAG, "stopOrderService:mOrderStatusPoll is null");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11404b(boolean z) {
        LogUtil.m31432fi("onOrderStatusChangedGot, this = " + WaitRspServicePresenter.class.getSimpleName() + ", isTimeOut = " + z);
        Logger logger = this.f15631d;
        StringBuilder sb = new StringBuilder();
        sb.append("onOrderStatusChangedGot isTimeOut=");
        sb.append(z);
        logger.info(sb.toString(), new Object[0]);
        if (z) {
            toDealWithOrderByTimeOut();
            return;
        }
        CarOrder carOrder = this.mComponentProxy.getCarOrder();
        if (carOrder == null) {
            LogUtil.m31431fe("carOrder is null");
            return;
        }
        Store store = Store.getStore(TravelUtil.generateCarOrderStoreKey(carOrder.oid));
        if (store != null) {
            store.setOuterLifecycle(this.mComponentProxy.getSession().getLifecycle());
        } else {
            String str = this.TAG;
            LogUtils.m31492e(str, "onOrderStatusChangedGot:store is null, oid = " + carOrder.oid);
        }
        String reassignOrderId = CarOrderHelper.getReassignOrderId();
        if (!TextUtils.isEmpty(reassignOrderId)) {
            GLog.m7964d("WaitRspServicePresenter#onOrderStatusChanged : reassign orderid is:" + reassignOrderId);
            new CancelInterceptRequest(this.mContext).loadOrderDetailAndJump(this.mComponentParams, reassignOrderId, (ResponseListener<CarOrder>) null);
            return;
        }
        int i = carOrder.orderState == null ? carOrder.status : carOrder.orderState.status;
        int i2 = carOrder.orderState == null ? carOrder.substatus : carOrder.orderState.subStatus;
        LogUtil.m31432fi("onOrderStatusChangedGot status=" + i + " subStatus=" + i2);
        BizConfigFacade instance = BizConfigFacade.getInstance();
        BusinessContext businessContext = this.mBusinessContext;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(carOrder.productid);
        String str2 = "";
        sb2.append(str2);
        instance.doubleCheckBizConfig(businessContext, sb2.toString());
        if (i == 5) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(BaseExtras.Common.EXTRA_ORDER_BEAN, carOrder);
            if (5001 == i2) {
                bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 2);
                forwardNew(1015, bundle);
                return;
            }
            bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
            bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 3);
            bundle.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_CANCEL, true);
            forwardNew(1015, bundle);
        } else if (i == 1 || i == 4) {
            if (i != 7 && i != 6) {
                m11410d();
                SoundUtils.getInstance(this.mContext).playMustSound(R.raw.push_notify);
                carOrder.mOperationModel = null;
                if (carOrder.flierFeature != null) {
                    carOrder.flierFeature.willWaitInfo = null;
                }
                if (carOrder.carDriver != null) {
                    if (!carOrder.isBooking() || carOrder.transportTime <= 0) {
                        CarNotifyManager.buildPickUpNotificationRealtime(this.mContext, carOrder.carDriver.card, carOrder.carDriver.carType);
                    } else {
                        CarNotifyManager.buildPickUpNotificationBooking(this.mContext, carOrder.transportTime, carOrder.carDriver.card, carOrder.carDriver.carType);
                    }
                }
                if (CacheApolloUtils.openWaitRspOptimization()) {
                    Runnable runnable = this.f15633f;
                    if (runnable == null) {
                        this.f15633f = new Runnable() {
                            public void run() {
                                Bundle bundle = new Bundle();
                                bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
                                bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                                bundle.putInt(BaseExtras.Common.EXTRA_FROM_PAGE_ID, 1005);
                                WaitRspServicePresenter.this.forwardNew(1010, bundle);
                                WaitRspServicePresenter.this.onForwardNextPage(1010);
                            }
                        };
                    } else {
                        UiThreadHandler.removeCallbacks(runnable);
                    }
                    if (GlobalApolloUtil.isExpectationManageEnabled() || GlobalApolloUtil.isExpectationManageEnabledRU()) {
                        m11412e();
                        HashMap hashMap = new HashMap();
                        hashMap.put("time_elapsed_value", 7);
                        String str3 = carOrder.oid;
                        if (!TextUtils.isEmpty(str3)) {
                            hashMap.put("order_id", str3);
                        }
                        OmegaSDKAdapter.trackEvent("pg_acceptance_wait_sw", (Map<String, Object>) hashMap);
                    }
                    UiThreadHandler.postDelayed(this.f15633f, 1440);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
                bundle2.putBoolean(IGroupView.BACK_VISIBILITY, true);
                forwardNew(1010, bundle2);
                onForwardNextPage(1010);
            }
        } else if (i == 2 && i2 == 2003) {
            if (carOrder.orderState != null) {
                str2 = carOrder.orderState.newOrderId;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("oid", carOrder.oid);
            hashMap2.put("new_oid", str2);
            OmegaSDKAdapter.trackEvent("tech_pax_waitrsp_receive_resign_status", (Map<String, Object>) hashMap2);
            m11399a(carOrder, carOrder.orderState.newOrderId);
        } else if (i == 3) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 1);
            bundle3.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
            bundle3.putBoolean(IGroupView.BACK_VISIBILITY, true);
            forwardNew(1015, bundle3);
        } else if (i == 6) {
            Bundle bundle4 = new Bundle();
            bundle4.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_CANCEL, true);
            if (6002 == carOrder.substatus) {
                bundle4.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 3);
            }
            bundle4.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
            bundle4.putBoolean(IGroupView.BACK_VISIBILITY, true);
            forwardNew(1015, bundle4);
        }
    }

    /* renamed from: a */
    private void m11399a(CarOrder carOrder, String str) {
        m11410d();
        if (TextUtils.isEmpty(str)) {
            goBackConfirm((Bundle) null);
            return;
        }
        TravelUtil.checkAndStoreOid(str, this.TAG + ".reassignOrder");
        this.mComponentProxy.updateOrderId(this.mComponentProxy.getPageId(), str);
        CarOrder carOrder2 = new CarOrder();
        carOrder2.oid = str;
        carOrder2.status = 7;
        carOrder2.substatus = 7;
        if (carOrder != null && carOrder.startAddress != null) {
            carOrder2.startAddress = carOrder.startAddress;
        } else if (!(CarOrderHelper.getOrder() == null || CarOrderHelper.getOrder().startAddress == null)) {
            carOrder2.startAddress = CarOrderHelper.getOrder().startAddress;
        }
        if (carOrder != null && carOrder.endAddress != null) {
            carOrder2.endAddress = carOrder.endAddress;
        } else if (!(CarOrderHelper.getOrder() == null || CarOrderHelper.getOrder().endAddress == null)) {
            carOrder2.endAddress = CarOrderHelper.getOrder().endAddress;
        }
        CarOrderHelper.saveOrder(carOrder2);
        Store orCreateStore = Store.getOrCreateStore(TravelUtil.generateCarOrderStoreKey(carOrder2.oid));
        orCreateStore.setStore(Store.S_NONE_INVOKE_ARGS, carOrder2);
        orCreateStore.setOuterLifecycle(this.mComponentProxy.getSession().getLifecycle());
        m11401a(false);
    }

    /* renamed from: e */
    private void m11412e() {
        ExpectationManagementModel expectationManagementModel = new ExpectationManagementModel();
        expectationManagementModel.duse_status = 5;
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_EXPECTATION_MANAGEMENT, expectationManagementModel);
    }

    /* access modifiers changed from: protected */
    public void toDealWithOrderByTimeOut() {
        String str;
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_WAITRSP_LEAVE_PAGE);
        OmegaUtils.trackEvent("ibt_calltimeout_autoback_ex", "order_type", "Realtime");
        if (Utils.isAppFront()) {
            CarOrder order = CarOrderHelper.getOrder();
            str = (order == null || !order.isJPFixPrice()) ? this.mContext.getResources().getString(R.string.car_wait_rsp_timeout) : this.mContext.getResources().getString(R.string.car_wait_rsp_jp_fix_price_timeout);
        } else {
            str = "";
        }
        Bundle bundle = null;
        if ("sodaEntrega".equals(ConfProxy.getInstance().getSelectedType())) {
            goBack();
            CarOrderHelper.saveOrder((CarOrder) null);
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_CLEAR_MAP_SCENE);
            DRouter.build(NationTypeUtil.getNationComponentData().getProductPreFix() + "OneTravel://sodaEntrega/homePage?noSwitchTab=1").start();
        } else {
            if (!TextUtils.isEmpty(str)) {
                bundle = new Bundle();
                bundle.putString(BaseExtras.ConfirmService.EXTRA_BACK_TO_CONFIRM_TIP, str);
            }
            goBackConfirm(bundle);
        }
        CarNotifyManager.waitRspTimeoutNotify(this.mContext);
        NotificationUtils.getInstance(this.mContext).hideNotification(1114);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11390a(int i, String str) {
        UpdateWaitTimeEvent updateWaitTimeEvent = new UpdateWaitTimeEvent();
        updateWaitTimeEvent.intWaitTime = i;
        updateWaitTimeEvent.strWaitTime = str;
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_MAP_UPDATE_WAIT_TIME, updateWaitTimeEvent);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11403b(String str) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || order.substatus != 7003) {
            showWaitPspTimeNotify(str);
        }
    }

    /* access modifiers changed from: protected */
    public void showWaitPspTimeNotify(String str) {
        CarNotifyManager.waitRspShowTimeNotify(this.mContext, str);
    }

    /* access modifiers changed from: protected */
    public void goBackConfirm(Bundle bundle) {
        String str = "";
        this.mComponentProxy.updateOrderId(this.mComponentProxy.getPageId(), str);
        if (this.f15636i == 1) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(BaseExtras.ConfirmService.CANCEL_ORDER_BACK_TO_ESTIMATE, false);
            bundle.putBoolean(IGroupView.BACK_VISIBILITY, false);
            forward(1030, bundle);
        } else if ("sodaEntrega".equals(ConfProxy.getInstance().getSelectedType())) {
            goBack();
            CarOrderHelper.saveOrder((CarOrder) null);
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_CLEAR_MAP_SCENE);
            DRouter.build(NationTypeUtil.getNationComponentData().getProductPreFix() + "OneTravel://sodaEntrega/homePage?noSwitchTab=1").start();
        } else {
            if (bundle != null) {
                str = bundle.getString(BaseExtras.ConfirmService.EXTRA_BACK_TO_CONFIRM_TIP);
            }
            gotoConfirmPage(false, str);
        }
        CommonPushManager.getInstance().stopPushOrderService();
        CarOrderHelper.saveOrder((CarOrder) null);
    }

    /* access modifiers changed from: protected */
    public void onCancelOrderRequestAction(Object obj) {
        if (CarOrderHelper.getOrder() != null) {
            boolean z = false;
            if (obj instanceof WaitRspCancelEvent) {
                z = ((WaitRspCancelEvent) obj).popupCancel;
            }
            if (!z) {
                showMaskLayerLoading();
            }
            final OrderServiceEvent orderServiceEvent = new OrderServiceEvent();
            C69893 r0 = new ResponseListener<CancelOrder>() {
                public void onSuccess(CancelOrder cancelOrder) {
                    super.onSuccess(cancelOrder);
                    orderServiceEvent.setEventFlag(0);
                }

                public void onError(CancelOrder cancelOrder) {
                    super.onError(cancelOrder);
                    orderServiceEvent.setEventFlag(2);
                }

                public void onFail(CancelOrder cancelOrder) {
                    super.onFail(cancelOrder);
                    orderServiceEvent.setEventFlag(1);
                }

                public void onFinish(CancelOrder cancelOrder) {
                    super.onFinish(cancelOrder);
                    orderServiceEvent.setEventResult(cancelOrder);
                    WaitRspServicePresenter.this.m11392a(orderServiceEvent);
                }
            };
            HashMap hashMap = new HashMap();
            hashMap.put("oid", this.mComponentProxy.getOrderId());
            if (this.mComponentProxy.getSession() != null && this.mComponentProxy.getSession().getIBiz(IExpress.class) != null) {
                ((IExpress) this.mComponentProxy.getSession().getIBiz(IExpress.class)).cancelOrder(hashMap, new ResponseListenerAdapter(r0));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11392a(OrderServiceEvent orderServiceEvent) {
        doPublish(BaseEventKeys.WaitRsp.EVENT_CANCEL_ORDER_FINISH);
        if (orderServiceEvent != null) {
            int eventFlag = orderServiceEvent.getEventFlag();
            CancelOrder cancelOrder = (CancelOrder) orderServiceEvent.getEventResult();
            if (eventFlag == 0) {
                hideLoading();
                m11410d();
                ToastHelper.showShortCompleted(this.mContext, ResourcesHelper.getString(this.mContext, R.string.car_cancel_success_txt_toast));
                CarNotifyManager.hideNotify(this.mContext);
                if (CacheApolloUtils.openWaitRspOptimization()) {
                    Runnable runnable = this.f15634g;
                    if (runnable == null) {
                        this.f15634g = new Runnable() {
                            public void run() {
                                Bundle bundle = new Bundle();
                                bundle.putBoolean("is_change_address", true);
                                WaitRspServicePresenter.this.goBackConfirm(bundle);
                                SearchIdUploadManager.getInstance().setEstimateAction(BffConstants.Tags.BFF_CANCEL_ORDER_TAG);
                            }
                        };
                    } else {
                        UiThreadHandler.removeCallbacks(runnable);
                    }
                    doPublish(BaseEventKeys.WaitRsp.EVENT_BEFORE_OUT_WAITRSP_ANIMATION_DUE_CANCEL);
                    UiThreadHandler.postDelayed(this.f15634g, 720);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("is_change_address", true);
                goBackConfirm(bundle);
                SearchIdUploadManager.getInstance().setEstimateAction(BffConstants.Tags.BFF_CANCEL_ORDER_TAG);
            } else if (eventFlag == 1) {
                hideLoading();
                if (cancelOrder != null && !CarHttpHelper.validate((FragmentActivity) this.mContext, cancelOrder) && cancelOrder != null && cancelOrder.errno == 22151) {
                    new CancelInterceptRequest(this.mContext).loadOrderDetailAndJump(this.mComponentParams, cancelOrder.reassignOid, new ResponseListener<CarOrder>() {
                        public void onFinish(CarOrder carOrder) {
                            super.onFinish(carOrder);
                            WaitRspServicePresenter.this.hideLoading();
                        }
                    });
                }
            } else if (eventFlag == 2 && cancelOrder != null) {
                hideLoading();
                if (TextUtil.isEmpty(cancelOrder.getErrorMsg())) {
                    ToastHelper.showShortError(this.mContext, this.mContext.getString(R.string.car_confrim_cancel_fail));
                } else {
                    ToastHelper.showShortError(this.mContext, cancelOrder.getErrorMsg());
                }
                if (cancelOrder.getErrorCode() != 101 && cancelOrder.getErrorCode() != 1011) {
                    return;
                }
                if (CacheApolloUtils.openWaitRspOptimization()) {
                    Runnable runnable2 = this.f15635h;
                    if (runnable2 == null) {
                        this.f15635h = new Runnable() {
                            public void run() {
                                WaitRspServicePresenter.this.goBackConfirm((Bundle) null);
                            }
                        };
                    } else {
                        UiThreadHandler.removeCallbacks(runnable2);
                    }
                    doPublish(BaseEventKeys.WaitRsp.EVENT_BEFORE_OUT_WAITRSP_ANIMATION_DUE_CANCEL);
                    UiThreadHandler.postDelayed(this.f15635h, 720);
                    return;
                }
                goBackConfirm((Bundle) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void forward(int i, Bundle bundle) {
        if (!this.f15645v.get()) {
            super.forward(i, bundle);
            this.f15645v.set(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onOrderCreated(CarOrder carOrder) {
        super.onOrderCreated(carOrder);
        m11408c();
        m11391a(this.f15632e);
        if (carOrder != null) {
            TravelUtil.getOrderDetail(this.mComponentProxy.getSession(), carOrder.oid, new ITravelOrderListener() {
                public void onError(int i, String str) {
                }

                public void onFail(int i, String str) {
                }

                public void onTimeout(String str) {
                }

                public void onSuccess(ICarOrder iCarOrder) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_WAITRSP_LOAD_ORDERDETAIL_SUCCESS);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onOrderCreateFail(CarOrder carOrder) {
        FormStore.getInstance().setCreateFailOrder(carOrder);
        if (carOrder != null) {
            omegaTrackSendOrderErrorCode(carOrder.errno);
            int errorCode = carOrder.getErrorCode();
            if (errorCode == 1055) {
                verifyCard(carOrder);
                return;
            } else if (errorCode == 1058) {
                this.f15631d.info("onOrderCreateFail  ERROR_CODE_NEED_FACE_RECOGNIZE", new Object[0]);
                enterFaceRecognize(carOrder);
                return;
            } else if (orderIntercept(carOrder)) {
                return;
            }
        }
        goBackConfirm((Bundle) null);
        doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
    }

    /* access modifiers changed from: protected */
    public void backToEstimate() {
        goBackConfirm((Bundle) null);
        doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
    }

    /* access modifiers changed from: protected */
    public void showPaymentsPage() {
        goBackConfirm((Bundle) null);
        doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
        FormStore.getInstance().setShowPayWayAfterEstimate(true);
    }

    /* access modifiers changed from: protected */
    public void trackEvent(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("bubble_id", SearchIdUploadManager.getInstance().getBubbleId());
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            Address address = order.startAddress;
            if (address != null) {
                hashMap.put("lng", Double.valueOf(address.longitude));
                hashMap.put("lat", Double.valueOf(address.latitude));
            }
            DIDILocation lastKnownLocation = LocationController.getInstance().getLastKnownLocation(this.mContext);
            if (lastKnownLocation != null) {
                hashMap.put("poi_lng", Double.valueOf(lastKnownLocation.getLongitude()));
                hashMap.put("poi_lat", Double.valueOf(lastKnownLocation.getLatitude()));
            }
        }
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        super.onDialogAction(i, i2);
        if (104 != i) {
            return;
        }
        if (2 == i2) {
            dismissDialog(104);
            FormStore.getInstance().setShowPayWayAfterEstimate(true);
            onCancelOrderRequestAction((Object) null);
        } else if (1 == i2) {
            dismissDialog(104);
            onCancelOrderRequestAction((Object) null);
        }
    }

    public boolean onBackPressed(IPresenter.BackType backType) {
        WaitRspBehaviorStrategy checkRspBehavior = TripBehaviorController.checkRspBehavior(this.mComponentParams.pageID);
        if (Preconditions.nonNull(checkRspBehavior) && checkRspBehavior.isBackAllowed()) {
            CarOrder order = CarOrderHelper.getOrder();
            GlobalOmegaUtils.trackEvent(LoginOmegaUtil.PAS_RETURN_CK, "g_OrderId", Preconditions.isNull(order) ? "" : order.getOid());
            FormStore.getInstance().clear();
            if (order == null || !(order.orderSource == 1 || order.orderSource == 3)) {
                goBackRoot();
            } else {
                goBack();
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void beforeOrderIdUpdate() {
        super.beforeOrderIdUpdate();
        if (this.mOrderStatusPoll != null && this.mOrderStatusPoll.isPollRunning()) {
            this.mOrderStatusPoll.stopPoll((Scene) null);
            this.mOrderStatusPoll.destroyPoll((Scene) null);
        }
    }

    /* access modifiers changed from: protected */
    public void afterOrderIdUpdate() {
        super.afterOrderIdUpdate();
        if (!TextUtils.isEmpty(this.mComponentProxy.getOrderId())) {
            this.mOrderStatusPoll = ExpressOrderStatusPoll.getInstance((Scene) null, this.mComponentProxy.getSession(), this.mComponentProxy.getOrderId());
        }
    }
}
