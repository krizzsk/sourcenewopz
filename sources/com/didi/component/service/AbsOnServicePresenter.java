package com.didi.component.service;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.model.LatLng;
import com.didi.component.business.cancelintercept.CancelInterceptRequest;
import com.didi.component.business.constant.BaseConstants;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.TripSwitchSceneEvent;
import com.didi.component.business.job.GlobalJobManager;
import com.didi.component.business.job.jobs.BookHalfHourJob;
import com.didi.component.business.sharetrip.ShareTripDialogCache;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarHttpHelper;
import com.didi.component.business.util.CarNotifyManager;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.DriverPosUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.I18NUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.dialog.GlobalDialog;
import com.didi.component.common.dialog.LoadingDialogInfo;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.common.track.DidiTrackingClient;
import com.didi.component.common.util.ActivityUtil;
import com.didi.component.common.util.FireBaseEventUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.common.util.OnServiceOmegaUtil;
import com.didi.component.config.BusinessRegistry;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.service.activity.CancelTripConfirmWebActivity;
import com.didi.component.service.activity.DashCamAgreementWebActivity;
import com.didi.component.service.cancelreason.CancelReasonActivity;
import com.didi.component.service.cancelreason.bff.CancelReasonBff;
import com.didi.component.service.cancelreason.cache.CancelReasonStore;
import com.didi.component.service.cancelreason.cache.CancelTripCache;
import com.didi.component.service.cancelreason.model.CancelReasonListResponse;
import com.didi.component.service.cancelreason.newcr.NewCancelReasonActivity;
import com.didi.component.service.presenter.onservice.UploadPostion;
import com.didi.component.service.view.NewCancelInterceptPopup;
import com.didi.global.globaluikit.dialog.LEGOCustomFragment;
import com.didi.map.global.flow.MapFlowView;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.presenter.IMapFlowPresenter;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.service.ForegroundLauncher;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.travel.p171v2.biz.api.RemoteCallback;
import com.didi.travel.p171v2.session.Scene;
import com.didi.travel.p171v2.store.Store;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.common.push.PushCallBackListener;
import com.didi.travel.psnger.common.push.PushManager;
import com.didi.travel.psnger.core.listener.DefaultDiDiCoreCallback;
import com.didi.travel.psnger.core.model.response.DTSDKDriverModel;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.model.response.CancelReasonInfo;
import com.didi.travel.psnger.model.response.CarCancelTrip;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.DriverPosition;
import com.didi.travel.psnger.model.response.NextCommonPushMsg;
import com.didi.travel.psnger.model.response.NextTotalFeeDetail;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.model.response.ReAssignDriverResult;
import com.didi.travel.psnger.p170v2.IExpress;
import com.didi.travel.psnger.p170v2.TravelConstant;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.travel.psnger.utils.LogUtil;
import com.didi.travel.psnger.utils.WindowUtil;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import rui.config.RConfigConstants;

public abstract class AbsOnServicePresenter extends AbsServicePresenter {

    /* renamed from: B */
    private static final int f15497B = 1;

    /* renamed from: C */
    private static final int f15498C = 2;

    /* renamed from: G */
    private static final long f15499G = 1800000;

    /* renamed from: v */
    private static final int f15500v = 1;

    /* renamed from: w */
    private static final int f15501w = 2;

    /* renamed from: A */
    private AlertDialogFragment f15502A;

    /* renamed from: D */
    private boolean f15503D = false;

    /* renamed from: E */
    private Vibrator f15504E;

    /* renamed from: F */
    private Vibrator f15505F;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public final Runnable f15506H = new Runnable() {
        public void run() {
            AbsOnServicePresenter.this.doPublish(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: I */
    public final DefaultDiDiCoreCallback f15507I = new DefaultDiDiCoreCallback() {
        public void onOrderStatusChange(IOrderStatus iOrderStatus) {
            super.onOrderStatusChange(iOrderStatus);
            AbsOnServicePresenter.this.mLogger.info("mOrderStatusChangedEventReceiver", new Object[0]);
            UiThreadHandler.post(AbsOnServicePresenter.this.f15506H);
            AbsOnServicePresenter.this.m11207g();
            AbsOnServicePresenter.this.startTracking();
        }

        public void onOrderStatusTimeOut() {
            super.onOrderStatusTimeOut();
            AbsOnServicePresenter.this.goBackHome();
        }

        public void onCommonMessageReceive(int i, String str) {
            super.onCommonMessageReceive(i, str);
            AbsOnServicePresenter.this.m11180a(new NextCommonPushMsg(i, str));
        }

        public void onRealtimePriceRefresh(OrderRealtimePriceCount orderRealtimePriceCount) {
            super.onRealtimePriceRefresh(orderRealtimePriceCount);
            AbsOnServicePresenter.this.mLogger.info("onRealtimePriceRefresh", new Object[0]);
            if (orderRealtimePriceCount != null) {
                if (AbsOnServicePresenter.this.f15526r != null) {
                    AbsOnServicePresenter.this.f15526r.requestPassengerPositionSend();
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.OnService.EVENT_REALTIME_TIME_PRICE_COUNT, orderRealtimePriceCount);
                AbsOnServicePresenter.this.updateOnServiceRealtimePriceNotify(orderRealtimePriceCount);
            }
        }

        public void onTotalFeeDetailReceive(NextTotalFeeDetail nextTotalFeeDetail) {
            super.onTotalFeeDetailReceive(nextTotalFeeDetail);
            if (AbsOnServicePresenter.this.f15526r != null) {
                AbsOnServicePresenter.this.f15526r.doPositionSendForCheat();
            }
            CarOrder order = CarOrderHelper.getOrder();
            if (!(order == null || nextTotalFeeDetail == null)) {
                order.feeDetail = nextTotalFeeDetail;
            }
            GLog.m7964d("onTotalFeeDetailReceive");
        }

        public void onCarpoolInfoChange() {
            AbsOnServicePresenter.this.onCarPoolInfoChanged();
        }
    };

    /* renamed from: J */
    private String f15508J;

    /* renamed from: K */
    private String f15509K = "";

    /* renamed from: L */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15510L = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            boolean unused = AbsOnServicePresenter.this.f15532z = true;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: M */
    public Runnable f15511M = new Runnable() {
        public void run() {
            Resources resources = AbsOnServicePresenter.this.mContext.getResources();
            int identifier = resources.getIdentifier(resources.getString(R.string.notification_small_icon), RConfigConstants.TYPE_DRAWABLE, AbsOnServicePresenter.this.mContext.getPackageName());
            String string = resources.getString(R.string.global_app_running_notification_title, new Object[]{resources.getString(AbsOnServicePresenter.this.mContext.getApplicationInfo().labelRes)});
            Bundle bundle = new Bundle();
            bundle.putString(TravelConstant.EXTRA_SESSION_KEY, AbsOnServicePresenter.this.mComponentProxy.getSession() == null ? "" : AbsOnServicePresenter.this.mComponentProxy.getSession().getKey());
            bundle.putString(TravelConstant.EXTRA_ORDER_ID, AbsOnServicePresenter.this.mComponentProxy.getOrderId());
            bundle.putString(TravelConstant.EXTRA_SOURCE, TravelConstant.EXTRA_SOURCE_RIDE_ON_SERVICE_NOTIFICATION);
            ForegroundLauncher.startForeground(AbsOnServicePresenter.this.mContext, identifier, string, (String) null, 0, bundle);
        }
    };

    /* renamed from: N */
    private AtomicBoolean f15512N = new AtomicBoolean(false);

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<NextCommonPushMsg.DialogMessage> f15513a = new BaseEventPublisher.OnEventListener<NextCommonPushMsg.DialogMessage>() {
        public void onEvent(String str, NextCommonPushMsg.DialogMessage dialogMessage) {
            if (dialogMessage != null) {
                GLog.m7971i("car_upgrade", "接收:" + dialogMessage.toString());
                AbsOnServicePresenter.this.m11179a(dialogMessage);
                BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.OnService.EVENT_CAR_UPGRADE);
            }
        }
    };

    /* renamed from: b */
    BaseEventPublisher.OnEventListener<CarCancelTrip> f15514b = new BaseEventPublisher.OnEventListener<CarCancelTrip>() {
        public void onEvent(String str, CarCancelTrip carCancelTrip) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(NewCancelInterceptPopup.KEY_CANCEL_TRIP, carCancelTrip);
            NewCancelInterceptPopup.show(AbsOnServicePresenter.this.getHost().getFragmentManager(), NewCancelInterceptPopup.CancelInterceptScene.on_service, AbsOnServicePresenter.this.mComponentParams, bundle);
        }
    };

    /* renamed from: c */
    BaseEventPublisher.OnEventListener<Intent> f15515c = new BaseEventPublisher.OnEventListener<Intent>() {
        public void onEvent(String str, Intent intent) {
            AbsOnServicePresenter.this.m11166a(intent);
        }
    };

    /* renamed from: d */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15516d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
            bundle.putBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_GET_ON_SCENE, true);
            AbsOnServicePresenter.this.forward(1035, bundle);
        }
    };

    /* renamed from: e */
    int f15517e;

    /* renamed from: f */
    int f15518f;

    /* renamed from: g */
    boolean f15519g = false;

    /* renamed from: h */
    BaseEventPublisher.OnEventListener<Boolean> f15520h = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (BaseEventKeys.Service.OnService.EVENT_START_CANCEL_TRIP.equals(str)) {
                int unused = AbsOnServicePresenter.this.f15529u = CarOrderHelper.getOrderSubStatus();
            }
            AbsOnServicePresenter.this.startCancelTrip(bool.booleanValue());
        }
    };

    /* renamed from: i */
    BaseEventPublisher.OnEventListener<EtaEda> f15521i = new BaseEventPublisher.OnEventListener<EtaEda>() {
        public void onEvent(String str, EtaEda etaEda) {
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null && order.substatus != 4007 && order.substatus != 4003 && order.substatus != 4006 && order.substatus != 4005 && etaEda != null) {
                CarNotifyManager.pickUpEtaNotify(AbsOnServicePresenter.this.mContext, etaEda.eda, etaEda.eta);
            }
        }
    };

    /* renamed from: j */
    BaseEventPublisher.OnEventListener<Boolean> f15522j = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (CarOrderHelper.getOrder() != null && AbsOnServicePresenter.this.mContext != null && DidiTrackingClient.getInstance().isBackgroundLocOpen()) {
                if (!bool.booleanValue()) {
                    UiThreadHandler.postOnceDelayed(AbsOnServicePresenter.this.f15511M, 3000);
                    return;
                }
                UiThreadHandler.removeCallbacks(AbsOnServicePresenter.this.f15511M);
                ForegroundLauncher.stopForeground(AbsOnServicePresenter.this.mContext);
            }
        }
    };

    /* renamed from: k */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15523k = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AbsOnServicePresenter.this.mContext != null && CarOrderHelper.getOrder() != null) {
                CancelReasonBff.cancelReasonListGet(AbsOnServicePresenter.this.mContext, CarOrderHelper.getOrder().oid);
            }
        }
    };

    /* renamed from: l */
    BaseEventPublisher.OnEventListener<CancelReasonInfo> f15524l = new BaseEventPublisher.OnEventListener<CancelReasonInfo>() {
        public void onEvent(String str, CancelReasonInfo cancelReasonInfo) {
            AbsOnServicePresenter.this.m11176a(cancelReasonInfo);
        }
    };

    /* renamed from: m */
    BaseEventPublisher.OnEventListener<CarCancelTrip> f15525m = new BaseEventPublisher.OnEventListener<CarCancelTrip>() {
        public void onEvent(String str, CarCancelTrip carCancelTrip) {
            if (carCancelTrip != null && carCancelTrip.errno == 22152) {
                AbsOnServicePresenter.this.showLoading();
                new CancelInterceptRequest(AbsOnServicePresenter.this.mContext).loadOrderDetailAndJump(AbsOnServicePresenter.this.mComponentParams, carCancelTrip.reassignOid, new ResponseListener<CarOrder>() {
                    public void onFinish(CarOrder carOrder) {
                        super.onFinish(carOrder);
                        AbsOnServicePresenter.this.hideLoading();
                    }
                });
            }
        }
    };
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: r */
    public UploadPostion f15526r;

    /* renamed from: s */
    private String f15527s;

    /* renamed from: t */
    private boolean f15528t = false;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f15529u;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public CarCancelTrip f15530x;

    /* renamed from: y */
    private boolean f15531y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f15532z = false;

    /* access modifiers changed from: protected */
    public void onCarPoolInfoChanged() {
    }

    /* access modifiers changed from: protected */
    public void showFixedPriceExceedDialog(NextCommonPushMsg.FixedPriceExceedModel fixedPriceExceedModel) {
    }

    public AbsOnServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        String str = this.TAG;
        LogUtils.m31493i(str, "onAdd:arguments = " + bundle);
        super.onAdd(bundle);
        this.f15526r = new UploadPostion();
        m11186b();
        m11203e();
        m11198d();
        startTracking();
        m11209h();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m11205f();
        UploadPostion uploadPostion = this.f15526r;
        if (uploadPostion != null) {
            uploadPostion.cancelPostionSend();
            stopTrackingAndStopService();
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.OnService.EVENT_ONSERVICE_LEAVE_PAGE);
    }

    /* access modifiers changed from: protected */
    public void onSubscribeEventReceiver() {
        super.onSubscribeEventReceiver();
        subscribe(BaseEventKeys.Service.OnService.EVENT_START_CANCEL_TRIP, this.f15520h);
        subscribe(BaseEventKeys.OnService.EVENT_STATUS_WAIT_PICK_UP_ETA, this.f15521i);
        subscribe(BaseEventKeys.Common.KEY_APPLICATION_STATE_CHANGED, this.f15522j);
        subscribe(BaseEventKeys.Service.CancelOrder.EVENT_CANCEL_REASON_LIST, this.f15523k);
        BaseEventPublisher.getPublisher().subscribeSticky(BaseEventKeys.OnService.EVENT_CAR_UPGRADE, this.f15513a);
        PushManager.registerDriverPositionListener(new PushCallBackListener<DriverPosition>() {
            public void onReceive(DriverPosition driverPosition) {
                if (CarOrderHelper.getOrder() != null && AbsOnServicePresenter.this.f15526r != null) {
                    AbsOnServicePresenter.this.f15526r.requestPassengerPositionSend();
                }
            }
        });
        subscribe(BaseEventKeys.OnService.EVENT_ONSERVICE_SHOW_CANCEL_INTERCEPT_POPUP, this.f15514b);
        subscribe(BaseEventKeys.OnService.EVENT_ONSERVICE_NATIVE_CANCEL_INTERCEPT_RESULT, this.f15515c);
        subscribe(BaseEventKeys.OnService.EVENT_ONSERVICE_FORWARD_PICKUP_PAGE, this.f15516d);
        subscribe(BaseEventKeys.Service.CancelOrder.EVENT_SHOW_CANCEL_REASON_LIST, this.f15524l);
        subscribe(BaseEventKeys.Service.CancelOrder.EVENT_CANCEL_REASON_LIST_BEFORE, this.f15510L);
        subscribe(BaseEventKeys.Service.CancelOrder.EVENT_PRE_CANCEL_FAIL, this.f15525m);
    }

    /* access modifiers changed from: protected */
    public void onUnsubscribeEventReceiver() {
        super.onUnsubscribeEventReceiver();
        unsubscribe(BaseEventKeys.Service.OnService.EVENT_START_CANCEL_TRIP, this.f15520h);
        unsubscribe(BaseEventKeys.OnService.EVENT_STATUS_WAIT_PICK_UP_ETA, this.f15521i);
        unsubscribe(BaseEventKeys.OnService.EVENT_CAR_UPGRADE, this.f15513a);
        unsubscribe(BaseEventKeys.Common.KEY_APPLICATION_STATE_CHANGED, this.f15522j);
        PushManager.unregisterDriverPositionListener();
        unsubscribe(BaseEventKeys.OnService.EVENT_ONSERVICE_SHOW_CANCEL_INTERCEPT_POPUP, this.f15514b);
        unsubscribe(BaseEventKeys.OnService.EVENT_ONSERVICE_NATIVE_CANCEL_INTERCEPT_RESULT, this.f15515c);
        unsubscribe(BaseEventKeys.OnService.EVENT_ONSERVICE_FORWARD_PICKUP_PAGE, this.f15516d);
        unsubscribe(BaseEventKeys.Service.CancelOrder.EVENT_CANCEL_REASON_LIST, this.f15523k);
        unsubscribe(BaseEventKeys.Service.CancelOrder.EVENT_SHOW_CANCEL_REASON_LIST, this.f15524l);
        unsubscribe(BaseEventKeys.Service.CancelOrder.EVENT_CANCEL_REASON_LIST_BEFORE, this.f15510L);
        unsubscribe(BaseEventKeys.Service.CancelOrder.EVENT_PRE_CANCEL_FAIL, this.f15525m);
    }

    /* access modifiers changed from: protected */
    public void forwardEndServicePage(int i) {
        Bundle bundle = new Bundle();
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || order.feeObjection != 1) {
            bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, i == 1024 ? 1 : 2);
        } else {
            bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 3);
        }
        bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        forwardNew(1015, bundle);
    }

    /* access modifiers changed from: protected */
    public void tryForwardEndService() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            GLog.m7964d("get pay result");
            if (!(order.payType != 1024 || order.payResult == null || order.payResult.isPay == 0)) {
                CarNotifyManager.endServiceWithCashNotification(this.mBusinessContext, this.mContext, order.payResult.actual_pay_money, order.payResult.actual_pay_money_display, order.payResult.actual_deduction, order.payResult.actual_deduction_display);
            }
            if (BusinessDataUtil.isOrderHasCancelFee(order)) {
                forwardCancelServicePage(true);
            } else {
                forwardEndServicePage(order.payType);
            }
        }
    }

    /* renamed from: b */
    private void m11186b() {
        String str;
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            int i = order.orderState != null ? order.orderState.status : order.status;
            int i2 = order.orderState != null ? order.orderState.subStatus : order.substatus;
            this.f15508J = order.oid;
            this.f15517e = i;
            this.f15518f = i2;
            m11164a(i, i2);
            String str2 = "1";
            if (i == 1) {
                GlobalOmegaUtils.putGlobal("g_PageId", "pick");
                if (CarOrderHelper.isQuotaOrder()) {
                    str = str2;
                } else {
                    str = "0";
                }
                GlobalOmegaUtils.trackEvent("pas_waitfordriver_sw", "fixed", str);
            }
            switch (i2) {
                case 4001:
                    setTitle(ResourcesHelper.getString(this.mContext, R.string.car_title_onservice_wait_arrival));
                    GlobalOmegaUtils.putGlobal("g_PageId", "pick");
                    if (!CarOrderHelper.isQuotaOrder()) {
                        str2 = "0";
                    }
                    GlobalOmegaUtils.trackEvent("pas_waitfordriver_sw", "fixed", str2);
                    m11178a(order);
                    m11163a(1);
                    return;
                case 4003:
                case 4004:
                    setTitle(ResourcesHelper.getString(this.mContext, R.string.car_title_onservice_driver_prepared));
                    if (!(order.carDriver == null || order.orderSource == 1 || order.orderSource == 2 || order.orderSource == 3)) {
                        CarNotifyManager.driverArrivedNotification(this.mContext, order.carDriver.card, order.carDriver.carType, order.prepareSCModel);
                    }
                    GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_ARRIVAL);
                    GlobalOmegaUtils.trackEvent("gp_onservice_service_driver_arrive");
                    m11163a(1);
                    return;
                case 4005:
                case 4006:
                    setTitle(ResourcesHelper.getString(this.mContext, R.string.car_title_onservice_billing));
                    GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PROC);
                    HashMap hashMap = new HashMap();
                    hashMap.put("g_OrderId", order.oid);
                    if (!CarOrderHelper.isQuotaOrder()) {
                        str2 = "0";
                    }
                    hashMap.put("fixed", str2);
                    GlobalOmegaUtils.trackEvent("pas_tripservice_sw", (Map<String, Object>) hashMap);
                    m11193c();
                    m11163a(1);
                    return;
                case 4007:
                    setTitle(ResourcesHelper.getString(this.mContext, R.string.global_carpool_travel_is_about_to_begin));
                    m11163a(1);
                    return;
                default:
                    setTitle(ResourcesHelper.getString(this.mContext, R.string.car_title_onservice_wait_arrival));
                    GlobalOmegaUtils.putGlobal("g_PageId", "pick");
                    return;
            }
        }
    }

    /* renamed from: c */
    private void m11193c() {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.mComponentProxy.getOrderId());
        ((IExpress) this.mComponentProxy.getSession().getIBiz(IExpress.class)).getOnServiceRealtimePrice(hashMap, new RemoteCallback<OrderRealtimePriceCount>() {
            public void onBizSuccess(OrderRealtimePriceCount orderRealtimePriceCount) {
                OrderRealtimePriceCount gsonPostProcess;
                super.onBizSuccess(orderRealtimePriceCount);
                if (orderRealtimePriceCount != null && (gsonPostProcess = orderRealtimePriceCount.gsonPostProcess()) != null && TextUtils.equals(AbsOnServicePresenter.this.mComponentProxy.getOrderId(), gsonPostProcess.oid)) {
                    Store store = Store.getStore(TravelUtil.generateCarOrderStoreKey(AbsOnServicePresenter.this.mComponentProxy.getOrderId()));
                    if (!(store == null || store.getData() == null)) {
                        ((CarOrder) store.getData()).setRealtimePriceCount(gsonPostProcess);
                    }
                    if (AbsOnServicePresenter.this.f15507I != null) {
                        AbsOnServicePresenter.this.f15507I.onRealtimePriceRefresh(gsonPostProcess);
                    }
                }
            }
        });
    }

    /* renamed from: a */
    private void m11178a(CarOrder carOrder) {
        if (carOrder != null && carOrder.wayPointList != null && carOrder.wayPointList.size() > 0 && carOrder.updateWayPoint.updateIsOk != 0 && !TextUtils.isEmpty(carOrder.updateWayPoint.updateText)) {
            if (!carOrder.oid.equals(GlobalSPUtil.getShowNotSupportWayPointDialogOrderId(this.mContext))) {
                new GlobalDialog().build().title(carOrder.updateWayPoint.updateText).actions(new GlobalDialog.IButtonAction[]{new GlobalDialog.PositiveButtonAction() {
                    public String getName() {
                        return AbsOnServicePresenter.this.mContext.getString(R.string.global_not_support_waypoint_dialog_button);
                    }
                }}).show(getHost().getFragmentManager(), "not_support_way_point_dialog");
                GlobalSPUtil.setShowNotSupportWayPointDialogOrderId(this.mContext, carOrder.oid);
                OnServiceOmegaUtil.sendNotSupportWayPointOmage(1, carOrder);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void checkDashCamAgreement(CarOrder carOrder) {
        if (carOrder.carDriver != null && carOrder.carDriver.isDashcam == 1) {
            showDashCamAgreement(GlobalWebUrl.getDashCamAgreementUrl(carOrder.carDriver.agreeDashcamUrl));
        }
    }

    /* renamed from: d */
    private void m11198d() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (!order.isBooking() && (order.timeSegment == null || order.timeSegment.length < 1)) {
                return;
            }
            if (order.arriveTime > 0) {
                m11217l();
                return;
            }
            long j = order.transportTime;
            try {
                if (order.timeSegment != null && order.timeSegment.length >= 1) {
                    j = Long.valueOf(order.timeSegment[0].toString()).longValue() * 1000;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String hourMinute = I18NUtils.getHourMinute(j);
            StringBuilder sb = new StringBuilder();
            if (order.carDriver != null) {
                sb.append(order.carDriver.cardExt);
                sb.append("-");
                sb.append(order.carDriver.card);
                sb.append(",");
                sb.append(order.carDriver.carType);
            }
            String sb2 = sb.toString();
            String string = ResourcesHelper.getString(this.mContext, R.string.car_noti_title_book_half_hour);
            String format = String.format(ResourcesHelper.getString(this.mContext, R.string.car_noti_content_book_half_hour), new Object[]{hourMinute, sb2});
            long currentTimeMillis = (j - System.currentTimeMillis()) - 1800000;
            if (currentTimeMillis > 0) {
                GLog.m7964d("send content " + format);
                this.f15527s = GlobalJobManager.getInstance(this.mContext).schedule(new BookHalfHourJob(order.oid, string, format), (int) (currentTimeMillis / 1000));
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        String str;
        if (CarOrderHelper.getOrder() == null) {
            str = "";
        } else {
            str = CarOrderHelper.getOrder().getOid();
        }
        GlobalOmegaUtils.trackEvent(LoginOmegaUtil.PAS_RETURN_CK, "g_OrderId", str);
        CarOrder order = CarOrderHelper.getOrder();
        NotificationUtils.getInstance(this.mContext).hideNotification();
        if (order == null) {
            FormStore.getInstance().clear();
            goBackRoot();
            return true;
        }
        FormStore.getInstance().clear();
        if (this.orderSource == 1 || "sodaEntrega".equals(ConfProxy.getInstance().getSelectedType())) {
            goBack();
        } else {
            goBackRoot();
        }
        m11167a(backType);
        return true;
    }

    /* renamed from: a */
    private void m11167a(IPresenter.BackType backType) {
        MapFlowView mapFlowView;
        IMapFlowPresenter presenter;
        IScene currentScene;
        this.mLogger.info("singleMinibus onBackPressed", backType.name());
        if ("bus".equals(ConfProxy.getInstance().getSelectedType()) || "bus".equals(SuperAppBusinessManager.INSTANCE.getCurrentBusiness())) {
            BaseBusinessContext curBusinessContext = BusinessContextManager.getInstance().getCurBusinessContext();
            if ((curBusinessContext instanceof BusinessContext) && (mapFlowView = ((BusinessContext) curBusinessContext).getMapFlowView()) != null && mapFlowView.isMapReady() && (presenter = mapFlowView.getPresenter()) != null && (currentScene = presenter.getCurrentScene()) != null) {
                currentScene.leave();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        GLog.m7964d("cancel===onActivityResult requestCode=" + i);
        if (100 == i && -1 == i2) {
            m11166a(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11166a(Intent intent) {
        Bundle bundleExtra;
        CarCancelTrip carCancelTrip;
        if (intent != null && (bundleExtra = intent.getBundleExtra(BaseExtras.CancelService.EXTRA_CANCEL_TRIP_DATA)) != null && (carCancelTrip = (CarCancelTrip) bundleExtra.getSerializable(BaseExtras.CancelService.EXTRA_CANCEL_TRIP_CONTENT)) != null && CarOrderHelper.getOrder() != null) {
            int i = carCancelTrip.errno;
            GLog.m7964d("cancel===onActivityResult errno=" + i + ",carCancelTrip=" + carCancelTrip);
            if (i == 1030) {
                goBackHome();
            } else if (i == 1035 || i == 1044) {
                goBackHome();
            } else if (CarHttpHelper.validate((FragmentActivity) this.mContext, carCancelTrip)) {
                showChooseTag(this.mContext);
                m11177a(carCancelTrip);
            }
        }
    }

    /* renamed from: a */
    private void m11177a(CarCancelTrip carCancelTrip) {
        this.f15530x = carCancelTrip;
        showDialog(buildLoadingDialogInfo());
        m11221n();
    }

    /* renamed from: e */
    private void m11203e() {
        if (this.mOrderStatusPoll == null) {
            String str = this.TAG;
            LogUtils.m31493i(str, "startOrderService:mOrderStatusPoll is null, session = " + this.mComponentProxy.getSession() + ", ordrId = " + this.mComponentProxy.getOrderId());
        }
        this.mOrderStatusPoll.addCoreCallback(this.f15507I);
        this.mOrderStatusPoll.startPoll((Scene) null);
    }

    /* renamed from: f */
    private void m11205f() {
        this.mOrderStatusPoll.removeCoreCallback(this.f15507I);
        this.mOrderStatusPoll.stopPoll((Scene) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m11207g() {
        LogUtil.m31432fi("onOrderStatusChangedGot:this = " + getClass().getSimpleName());
        CarOrder carOrder = this.mComponentProxy.getCarOrder();
        if (carOrder != null) {
            Store.getStore(TravelUtil.generateCarOrderStoreKey(this.mComponentProxy.getOrderId())).setOuterLifecycle(this.mComponentProxy.getSession().getLifecycle());
            int i = carOrder.orderState != null ? carOrder.orderState.status : carOrder.status;
            int i2 = carOrder.orderState != null ? carOrder.orderState.subStatus : carOrder.substatus;
            m11164a(i, i2);
            Logger logger = this.mLogger;
            logger.info("onOrderStatusChangedGot status=" + i + " substatus=" + i2 + "  prestatus=" + this.f15517e + " presubstatus=" + this.f15518f + ", oid = " + TravelUtil.getRichOid(carOrder.oid), new Object[0]);
            if (i != 4 || i2 == 4006) {
                doPublish(BaseEventKeys.XPanel.EVENT_STATION_GUIDE_HIDE);
            }
            if (!TextUtils.equals(this.f15508J, carOrder.oid)) {
                if (4 != i && 1 != i) {
                    onOrderStatusChanged();
                } else if (4 == i) {
                    m11210i();
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.OrderReassign.EVENT_ORDER_REASSIGN);
            } else if (4 != i && 1 != i && this.f15517e != i) {
                onOrderStatusChanged();
            } else if (4 == i && this.f15518f != i2) {
                m11210i();
            }
            this.f15508J = carOrder.oid;
            this.f15517e = i;
            this.f15518f = i2;
            if (i2 == 4004) {
                m11183a(true);
            }
            if (i2 == 4003) {
                m11183a(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11164a(int i, int i2) {
        Logger logger = this.mLogger;
        logger.info("isDriverArrivedWhenOrderStatusChanged status=" + i + " substatus=" + i2, new Object[0]);
        if (i == 4) {
            if (i2 == 4001 || i2 == 4002 || i2 == 4007) {
                CancelTripCache.getInstance().setDriverArrived(false);
            } else {
                CancelTripCache.getInstance().setDriverArrived(true);
            }
        } else if (i == 7) {
            CancelTripCache.getInstance().setDriverArrived(false);
        }
    }

    /* renamed from: h */
    private void m11209h() {
        CarOrder order = CarOrderHelper.getOrder();
        if (!(order == null || TextUtils.isEmpty(order.oid) || getHost() == null || getHost().getActivity() == null)) {
            ShareTripDialogCache.getInstance().getTripShareInfo(getHost().getActivity(), order.oid, order.productid);
        }
        ShareTripDialogCache.getInstance().loadingTrustedContactsWithNoCache();
    }

    public void onOrderStatusChanged() {
        AlertDialogFragment alertDialogFragment;
        LogUtil.m31432fi("onOrderStatusChanged:this = " + getClass().getSimpleName());
        CarOrder carOrder = this.mComponentProxy.getCarOrder();
        if (carOrder != null) {
            boolean z = true;
            new Bundle().putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
            int i = carOrder.orderState == null ? carOrder.status : carOrder.orderState.status;
            int i2 = carOrder.orderState == null ? carOrder.substatus : carOrder.orderState.subStatus;
            Logger logger = this.mLogger;
            logger.info("onOrderStatusChanged status=" + i + " substatus=" + i2, new Object[0]);
            if (!(i == 4 || i == 1)) {
                stopTrackingAndStopService();
                if (TripRecordingManager.Companion.getInstance().isRecording()) {
                    TripRecordingManager.Companion.getInstance().stopAndUpload();
                    ToastHelper.showShortCompleted(this.mContext, (int) R.string.global_record_stop_toast);
                }
            }
            if (!(i == 4 || (alertDialogFragment = this.f15502A) == null || !alertDialogFragment.isAdded())) {
                this.f15502A.dismiss();
            }
            String reassignOrderId = CarOrderHelper.getReassignOrderId();
            if (!TextUtils.isEmpty(reassignOrderId)) {
                GLog.m7964d("AbsOnServicePresenter#onOrderStatusChanged : reassign orderid is:" + reassignOrderId);
                new CancelInterceptRequest(this.mContext).loadOrderDetailAndJump(this.mComponentParams, reassignOrderId, (ResponseListener<CarOrder>) null);
            } else if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        GLog.m7964d("onOrderStatusChanged : ORDER_STATUS_PAY_FINISH");
                        onOrderPayFinished();
                        if (i2 != 2001) {
                            m11163a(2);
                            return;
                        }
                        return;
                    } else if (i == 5) {
                        GLog.m7964d("onOrderStatusChanged : ORDER_STATUS_NOT_PAY");
                        if (5001 == i2) {
                            tryForwardEndService();
                            showNotPayNotification();
                            m11163a(2);
                            return;
                        } else if (5002 == i2) {
                            forwardCancelServicePage(true);
                            return;
                        } else if (5003 != i2) {
                            return;
                        } else {
                            if (!TextUtils.isEmpty(carOrder.orderState.newOrderId)) {
                                m11189b(carOrder);
                                return;
                            }
                            GLog.m7964d("onOrderStatusChanged : ORDER_STATUS_NOT_PAY_DRIVER_CANCEL");
                            forwardCancelServicePage(true);
                            showNotPayNotification();
                            return;
                        }
                    } else if (i != 6) {
                        if (i == 7) {
                            m11195c(CarOrderHelper.getOrder());
                            return;
                        }
                        return;
                    }
                }
                doPublish(BaseEventKeys.C4621IM.KEY_CATEGORY_IM_CLOSE_SESSION);
                doPublish(BaseEventKeys.Service.CancelOrder.EVENT_HIDE_CANCEL_REASON_LIST);
                if (TextUtils.isEmpty(carOrder.orderState.newOrderId) || 2003 != i2) {
                    if (6002 != i2) {
                        z = false;
                    }
                    forwardCancelServicePage(z);
                    if (6 != i) {
                        CarNotifyManager.driverCancelTripNotification(this.mContext);
                    } else {
                        NotificationUtils.getInstance(this.mContext).hideNotification();
                    }
                } else {
                    m11189b(carOrder);
                }
            } else {
                GlobalOmegaUtils.putGlobal("g_PageId", "pick");
                GlobalOmegaUtils.trackEvent("pas_waitfordriver_sw", "fixed", CarOrderHelper.isQuotaOrder() ? "1" : "0");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onOrderPayFinished() {
        NotificationUtils.getInstance(this.mContext).hideNotification();
        doPublish(BaseEventKeys.C4621IM.KEY_CATEGORY_IM_CLOSE_SESSION);
        tryForwardEndService();
    }

    /* renamed from: i */
    private void m11210i() {
        LogUtil.m31432fi("onOrderSubstatusChanged:this = " + getClass().getSimpleName());
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            int i = order.orderState == null ? order.substatus : order.orderState.subStatus;
            Logger logger = this.mLogger;
            logger.info("onOrderSubstatusChanged substatus=" + i, new Object[0]);
            if (i == 4002) {
                this.f15528t = true;
            } else if (i == 4003) {
                GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_ARRIVAL);
                GlobalOmegaUtils.trackEvent("gp_onservice_service_driver_arrive");
                m11215k();
            } else if (i == 4006) {
                GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PROC);
                HashMap hashMap = new HashMap();
                hashMap.put("g_OrderId", order.oid);
                hashMap.put("fixed", CarOrderHelper.isQuotaOrder() ? "1" : "0");
                GlobalOmegaUtils.trackEvent("pas_tripservice_sw", (Map<String, Object>) hashMap);
                m11213j();
                m11219m();
                doPublish(BaseEventKeys.OnService.EVENT_UPDATE_WAY_POINT);
            } else if (i == 4007) {
                setTitle(ResourcesHelper.getString(this.mContext, R.string.global_carpool_travel_is_about_to_begin));
            }
        }
    }

    /* renamed from: j */
    private void m11213j() {
        double d;
        double d2;
        HashMap hashMap = new HashMap();
        CarOrder order = CarOrderHelper.getOrder();
        double d3 = order.startAddress.longitude;
        double d4 = order.startAddress.latitude;
        if (order != null) {
            DTSDKDriverModel dTSDKDriverModel = order.carDriver;
            if (dTSDKDriverModel != null) {
                hashMap.put(CarServerParam.PARAM_DRIVER_ID, dTSDKDriverModel.did);
            }
            Address address = order.startAddress;
            if (address != null) {
                d4 = address.latitude;
                d3 = address.longitude;
            }
        }
        double d5 = d3;
        double d6 = d4;
        hashMap.put("lng", Double.valueOf(d5));
        hashMap.put("lat", Double.valueOf(d6));
        LocationController instance = LocationController.getInstance();
        double lng = instance.getLng(this.mContext);
        double lat = instance.getLat(this.mContext);
        hashMap.put("pas_lng", Double.valueOf(lng));
        hashMap.put("pas_lat", Double.valueOf(lat));
        LatLng latLng = DriverPosUtils.getLatLng();
        if (latLng == null) {
            d = 0.0d;
        } else {
            d = latLng.longitude;
        }
        if (latLng == null) {
            d2 = 0.0d;
        } else {
            d2 = latLng.latitude;
        }
        hashMap.put("dri_lng", Double.valueOf(d));
        hashMap.put("dri_lat", Double.valueOf(d2));
        hashMap.put("distance", Double.valueOf(LocationController.getDistance(d2, d, lat, lng)));
        hashMap.put("distance_from", Double.valueOf(LocationController.getDistance(d2, d, d6, d5)));
        GlobalOmegaUtils.trackEvent("gp_tripService_map_rsp", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private void m11189b(CarOrder carOrder) {
        LogUtil.m31432fi("reAssignOrder:carOrder oid = " + carOrder.oid + ", new oid = " + carOrder.orderState.newOrderId);
        if (carOrder != null) {
            String str = carOrder.orderState.newOrderId;
            TravelUtil.checkAndStoreOid(str, this.TAG + ".reAssignOrder");
            if (carOrder.orderState == null || TextUtil.isEmpty(carOrder.orderState.newOrderId) || carOrder.orderState.newOrderBookingMode != 1) {
                ReAssignDriverResult reAssignDriverResult = new ReAssignDriverResult();
                if (carOrder.orderState != null) {
                    reAssignDriverResult.oid = carOrder.orderState.oid;
                    reAssignDriverResult.newOid = carOrder.orderState.newOrderId;
                }
                if (carOrder.prepareSCModel != null && !TextUtils.isEmpty(carOrder.prepareSCModel.pushTips)) {
                    reAssignDriverResult.assignMsg = carOrder.prepareSCModel.pushTips;
                } else if (carOrder.carCancelTrip != null && !TextUtils.isEmpty(carOrder.carCancelTrip.showTitle)) {
                    reAssignDriverResult.assignMsg = carOrder.carCancelTrip.showTitle;
                }
                if (!TextUtils.isEmpty(this.f15509K)) {
                    reAssignDriverResult.assignMsg = this.f15509K;
                    this.f15509K = "";
                }
                this.f15519g = carOrder.isBooking();
                String str2 = this.TAG;
                GLog.m7972v(str2, "reAssignOrder:" + carOrder.oid);
                m11205f();
                this.mComponentProxy.updateOrderId(this.mComponentProxy.getPageId(), reAssignDriverResult.newOid);
                CarOrder carOrder2 = new CarOrder();
                carOrder2.oid = reAssignDriverResult.newOid;
                carOrder2.status = 7;
                carOrder2.substatus = 7;
                carOrder2.assignResult = reAssignDriverResult;
                carOrder2.startAddress = carOrder.startAddress;
                carOrder2.endAddress = carOrder.endAddress;
                DDTravelOrderStore.setOrder(carOrder2);
                Store orCreateStore = Store.getOrCreateStore(TravelUtil.generateCarOrderStoreKey(carOrder2.oid));
                orCreateStore.setStore(Store.S_NONE_INVOKE_ARGS, carOrder2);
                orCreateStore.setOuterLifecycle(this.mComponentProxy.getSession().getLifecycle());
                NotificationUtils.getInstance(this.mContext).hideNotification();
                if (!TextUtils.isEmpty(reAssignDriverResult.assignMsg)) {
                    CarNotifyManager.assignOrderNotify(this.mContext, reAssignDriverResult.assignMsg);
                }
                m11203e();
                return;
            }
            m11181a(carOrder.orderState.newOrderId);
        }
    }

    /* renamed from: c */
    private void m11195c(CarOrder carOrder) {
        LogUtil.m31432fi("gotoWaitRsp");
        Bundle bundle = new Bundle();
        bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
        bundle.putString(BaseExtras.ConfirmService.EXTRA_GOTO_WAIT_RSP_SOURCE, "AbsOnServicePresenter.gotoWaitRsp");
        bundle.putBoolean(BaseExtras.ConfirmService.EXTRA_SEND_ORDER_IN_WAIT_RSP_PAGE, false);
        bundle.putBoolean("is_assign_order", true);
        bundle.putInt(BaseExtras.Common.EXTRA_ORDER_SOURCE, this.orderSource);
        if (this.f15519g) {
            this.f15519g = false;
            bundle.putInt(BaseExtras.WaitResponse.EXTRA_WAIT_RSP_PAGE_SOURCE, 2);
            CarOrderHelper.fillFormStore(carOrder, false);
        }
        doPublish(BaseEventKeys.Service.Trip.EVENT_TRIP_SCENE_SWITCH, new TripSwitchSceneEvent(10401, bundle));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11181a(final String str) {
        TravelUtil.getOrderDetail(this.mComponentProxy.getSession(), str, new ITravelOrderListener() {
            public void onSuccess(ICarOrder iCarOrder) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
                bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                AbsOnServicePresenter.this.forwardNew(1025, bundle);
            }

            public void onError(int i, String str) {
                AbsOnServicePresenter.this.m11191b(str);
            }

            public void onFail(int i, String str) {
                AbsOnServicePresenter.this.m11191b(str);
            }

            public void onTimeout(String str) {
                AbsOnServicePresenter.this.m11191b(str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11191b(final String str) {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                AbsOnServicePresenter.this.m11181a(str);
            }
        }, 3000);
    }

    /* renamed from: k */
    private void m11215k() {
        doPublish(BaseEventKeys.OnService.EVENT_STATUS_DRIVER_ARRIVAL, Boolean.valueOf(this.f15528t));
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            setTitle(ResourcesHelper.getString(this.mContext, R.string.car_title_onservice_driver_prepared));
            if (order.carDriver != null) {
                CarNotifyManager.driverArrivedNotification(this.mContext, order.carDriver.card, order.carDriver.carType, order.prepareSCModel);
            }
            UploadPostion uploadPostion = this.f15526r;
            if (uploadPostion != null) {
                uploadPostion.cancelPostionSend();
                this.f15526r.requestPassengerPositionSend();
            }
            if (order.isBooking() || (order.timeSegment != null && order.timeSegment.length >= 1)) {
                m11217l();
            }
        }
    }

    /* renamed from: a */
    private void m11183a(boolean z) {
        if (z) {
            if (this.f15504E == null && OrderFloatWindowManager.Instance().isVisible()) {
                Vibrator vibrator = (Vibrator) this.mContext.getSystemService("vibrator");
                this.f15504E = vibrator;
                vibrator.vibrate(new long[]{10, 5000}, -1);
            }
        } else if (this.f15505F == null && OrderFloatWindowManager.Instance().isVisible()) {
            Vibrator vibrator2 = (Vibrator) this.mContext.getSystemService("vibrator");
            this.f15505F = vibrator2;
            vibrator2.vibrate(new long[]{10, 100, 10, 100}, -1);
        }
    }

    /* renamed from: l */
    private void m11217l() {
        GLog.m7964d("cancelHalfHourAlarm");
        if (!TextUtils.isEmpty(this.f15527s)) {
            GlobalJobManager.getInstance(this.mContext).cancel(this.f15527s);
        }
    }

    /* renamed from: m */
    private void m11219m() {
        setTitle(ResourcesHelper.getString(this.mContext, R.string.car_title_onservice_billing));
        GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PROC);
        buildInServiceNotification();
    }

    /* access modifiers changed from: protected */
    public void buildInServiceNotification() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.endAddress != null) {
            CarNotifyManager.buildInServiceNotifyParams(this.mContext, order.endAddress.getDisplayName(), "", order.currency);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11180a(NextCommonPushMsg nextCommonPushMsg) {
        Logger logger = this.mLogger;
        logger.info(">>>>>>>>dispatchCommonMessageEvent>>>>> recommendType=" + nextCommonPushMsg.getRecommendType() + ", message=" + nextCommonPushMsg.getRecommendMessage(), new Object[0]);
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            int recommendType = nextCommonPushMsg.getRecommendType();
            if (recommendType != 2) {
                if (recommendType != 14) {
                    if (recommendType != 32) {
                        if (recommendType != 52) {
                            if (recommendType == 59) {
                                m11200d(nextCommonPushMsg);
                                return;
                            } else if (recommendType == 18) {
                                order.status = 2;
                                order.substatus = 2001;
                                m11196c(nextCommonPushMsg);
                                return;
                            } else if (recommendType != 19) {
                                return;
                            }
                        }
                    } else if (!TextUtils.isEmpty(nextCommonPushMsg.getCommonTipMessage())) {
                        this.f15509K = nextCommonPushMsg.getCommonTipMessage();
                        return;
                    }
                    showFixedPriceExceedDialog(nextCommonPushMsg.getFixedPriceExceedModel());
                    return;
                }
                order.status = 2;
                order.substatus = 2003;
                m11196c(nextCommonPushMsg);
                return;
            }
            m11190b(nextCommonPushMsg);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11179a(NextCommonPushMsg.DialogMessage dialogMessage) {
        if (dialogMessage != null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.global_upgrade_alert_dialog_new, (ViewGroup) null);
            final ImageView imageView = (ImageView) inflate.findViewById(R.id.global_upgrade_bg_new);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Button button = (Button) inflate.findViewById(R.id.global_upgrade_btn_new);
            ((TextView) inflate.findViewById(R.id.global_upgrade_title_new)).setText(dialogMessage.title);
            ((TextView) inflate.findViewById(R.id.global_upgrade_subtitle_new)).setText(dialogMessage.subTitle);
            button.setText(dialogMessage.button);
            String str = TextUtil.isEmpty(dialogMessage.background_new) ? dialogMessage.background : dialogMessage.background_new;
            if (!ActivityUtil.isActivityDestroyed(this.mContext)) {
                if (!TextUtil.isEmpty(str)) {
                    RequestBuilder requestBuilder = (RequestBuilder) Glide.with(this.mContext).asBitmap().load(str).fitCenter();
                    if (BusinessDataUtil.isBetterServiceCar()) {
                        ((RequestBuilder) requestBuilder.placeholder(DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.youxiang_upgrade_icon))).error(DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.youxiang_upgrade_icon));
                    } else {
                        ((RequestBuilder) requestBuilder.placeholder((int) R.drawable.global_car_upgrade_img)).error((int) R.drawable.global_car_upgrade_img);
                    }
                    requestBuilder.into(new CustomTarget<Bitmap>() {
                        public void onLoadCleared(Drawable drawable) {
                        }

                        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                }
                final LEGOCustomFragment instance = LEGOCustomFragment.getInstance();
                instance.setRootView(inflate);
                instance.setCancelable(true);
                try {
                    instance.show(((FragmentActivity) this.mContext).getSupportFragmentManager(), "");
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", Integer.valueOf(dialogMessage.type));
                    hashMap.put("id", "global_upgrade_alert");
                    OmegaSDKAdapter.trackEvent("ibt_gp_commonmodule_sw", (Map<String, Object>) hashMap);
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            instance.dismiss();
                        }
                    });
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: b */
    private void m11190b(NextCommonPushMsg nextCommonPushMsg) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            setTitle(ResourcesHelper.getString(this.mContext, R.string.car_wait_for_arrival_dirver_change));
            if (order.substatus == 4003) {
                order.status = 2;
                order.substatus = 2002;
                new CarCancelTrip().showTitle = nextCommonPushMsg.getCommonTipMessage();
                forwardCancelServicePage(false);
                NotificationUtils.getInstance(this.mContext).hideNotification();
                return;
            }
            order.status = 4;
            order.substatus = 4000;
            doPublish(BaseEventKeys.MessageBar.EVENT_MESSAGE_BAR_STOP_TIMER);
        }
    }

    /* renamed from: c */
    private void m11196c(NextCommonPushMsg nextCommonPushMsg) {
        CarCancelTrip carCancelTrip = new CarCancelTrip();
        carCancelTrip.controlNewFlag = true;
        carCancelTrip.showTitle = nextCommonPushMsg.getCommonTipMessage();
        forwardCancelServicePage(false);
    }

    /* access modifiers changed from: protected */
    public void startCancelTrip(boolean z) {
        String buildUrl = GlobalWebUrl.buildUrl(GlobalWebUrl.getCancelTripUrl(this.mContext, (String) null), createURLParams());
        if (!TextUtil.isEmpty(buildUrl)) {
            Intent intent = new Intent(this.mContext, CancelTripConfirmWebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(buildUrl));
            intent.putExtra(CancelTripConfirmWebActivity.KEY_IS_FROM_DASH_CAM, z);
            startActivityForResult(intent, 100, (Bundle) null);
        }
    }

    /* access modifiers changed from: protected */
    public void showDashCamAgreement(String str) {
        String buildUrl = GlobalWebUrl.buildUrl(str, createURLParams());
        if (!TextUtil.isEmpty(buildUrl) && !WindowUtil.getTopActivityName(this.mContext).contains("DashCamAgreementWebActivity")) {
            Intent intent = new Intent(this.mContext, DashCamAgreementWebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(buildUrl));
            startActivityForResult(intent, 100, (Bundle) null);
        }
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Object> createURLParams() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("token", NationComponentDataUtil.getToken());
        hashMap.put("oid", order.oid);
        hashMap.put("appversion", SystemUtil.getVersionName(this.mContext));
        hashMap.put(ParamKeys.PARAM_CONTROL, 1);
        hashMap.put("pid", NationComponentDataUtil.getLoginInfo().getUid());
        if (order.carLevel != null) {
            hashMap.put("car_level", order.carLevel);
        }
        if (order.startAddress != null) {
            hashMap.put("area", Integer.valueOf(order.startAddress.getCityId()));
            hashMap.put("lat", Double.valueOf(order.startAddress.getLatitude()));
            hashMap.put("lng", Double.valueOf(order.startAddress.getLongitude()));
        }
        hashMap.put("business_id", Integer.valueOf(order.productid));
        hashMap.put("is_pickup_change", Integer.valueOf(order.showUpdatePickUpPop ? 1 : 0));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public LoadingDialogInfo buildLoadingDialogInfo() {
        LoadingDialogInfo loadingDialogInfo = new LoadingDialogInfo(11);
        loadingDialogInfo.setMessage(ResourcesHelper.getString(this.mContext, R.string.car_cancel_trip_loading_tip));
        loadingDialogInfo.setCancelable(false);
        return loadingDialogInfo;
    }

    /* renamed from: n */
    private void m11221n() {
        CarOrder order = CarOrderHelper.getOrder();
        TravelUtil.getOrderDetail(this.mComponentProxy.getSession(), order.oid, new ITravelOrderListener() {
            public void onSuccess(ICarOrder iCarOrder) {
                AbsOnServicePresenter.this.dismissDialog(11);
                NotificationUtils.getInstance(AbsOnServicePresenter.this.mContext).hideNotification();
                CarOrder carOrder = (CarOrder) iCarOrder;
                carOrder.orderState.status = carOrder.status;
                carOrder.orderState.subStatus = carOrder.substatus;
                AbsOnServicePresenter.this.m11164a(carOrder.status, carOrder.substatus);
                if (!(AbsOnServicePresenter.this.f15530x == null || AbsOnServicePresenter.this.f15530x.banStatus == 0)) {
                    carOrder.banPopInfo = AbsOnServicePresenter.this.f15530x.banPopInfo;
                    carOrder.banGlobalId = AbsOnServicePresenter.this.f15530x.banGlobalId;
                    carOrder.banStatus = AbsOnServicePresenter.this.f15530x.banStatus;
                }
                AbsOnServicePresenter.this.onOrderStatusChanged();
            }

            public void onTimeout(String str) {
                AbsOnServicePresenter.this.dismissDialog(11);
                ToastHelper.showLongCompleted(AbsOnServicePresenter.this.mContext, str);
            }

            public void onError(int i, String str) {
                AbsOnServicePresenter.this.dismissDialog(11);
                ToastHelper.showShortInfo(AbsOnServicePresenter.this.mContext, (int) R.string.car_get_order_detail_fail);
            }

            public void onFail(int i, String str) {
                AbsOnServicePresenter.this.dismissDialog(11);
                ToastHelper.showShortInfo(AbsOnServicePresenter.this.mContext, (int) R.string.car_get_order_detail_fail);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void goBackHome() {
        NotificationUtils.getInstance(this.mContext).hideNotification();
        goBackRoot();
        DDTravelOrderStore.setOrder((ICarOrder) null);
    }

    /* access modifiers changed from: protected */
    public void goBackRootWithTag(CarOrder carOrder) {
        Bundle bundle = new Bundle();
        if (carOrder != null) {
            bundle.putString(BaseConstants.NormalFinishTrip.LAST_ORDER_PARENT_SID, BusinessRegistry.bid2ParentSid(carOrder.productid));
        }
        bundle.putBoolean(BaseConstants.NormalFinishTrip.NORMAL_FINISH_THE_TRIP, true);
        goBackRoot(bundle);
    }

    /* access modifiers changed from: protected */
    public void showChooseTag(final Context context) {
        if (!this.f15532z) {
            final CancelReasonStore instance = CancelReasonStore.getInstance();
            if (instance.getCurrCancelReasonInfo() != null) {
                m11165a(context);
            } else if (CarOrderHelper.getOrder() != null) {
                CancelReasonBff.cancelReasonListGet(context, CarOrderHelper.getOrder().oid, new RpcService.Callback<JsonObject>() {
                    public void onFailure(IOException iOException) {
                    }

                    public void onSuccess(JsonObject jsonObject) {
                        CancelReasonListResponse cancelReasonListResponse = (CancelReasonListResponse) new Gson().fromJson((JsonElement) jsonObject, CancelReasonListResponse.class);
                        if (cancelReasonListResponse != null && cancelReasonListResponse.data != null && cancelReasonListResponse.data.cancel_reason_info != null) {
                            instance.saveCurrCancelReasonInfo(cancelReasonListResponse.data.cancel_reason_info);
                            AbsOnServicePresenter.this.m11165a(context);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11165a(Context context) {
        context.startActivity(new Intent(context, CancelReasonActivity.class));
    }

    /* access modifiers changed from: protected */
    public String createReasonURL(String str) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || TextUtil.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (!str.contains("?")) {
            sb.append("?");
        }
        if (!sb.toString().endsWith("?")) {
            sb.append(ParamKeys.SIGN_AND);
        }
        sb.append("oid=");
        sb.append(order.oid);
        sb.append("&otype=");
        sb.append(order.comboType2OType());
        sb.append("&token=");
        sb.append(NationComponentDataUtil.getToken());
        sb.append("&pay=");
        CarCancelTrip carCancelTrip = this.f15530x;
        sb.append(carCancelTrip != null ? carCancelTrip.cancelType : 0);
        sb.append("&business_id=");
        sb.append(order.productid);
        if (this.f15529u >= 4003) {
            sb.append("&pagestate=");
            sb.append(2);
        } else {
            sb.append("&pagestate=");
            sb.append(1);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11176a(CancelReasonInfo cancelReasonInfo) {
        if (this.mContext != null && CarOrderHelper.getOrder() != null && cancelReasonInfo != null) {
            CancelReasonStore.getInstance().saveCurrCancelReasonInfo(cancelReasonInfo);
            this.mContext.startActivity(new Intent(this.mContext, NewCancelReasonActivity.class));
            this.f15532z = true;
        }
    }

    /* access modifiers changed from: protected */
    public void forward(int i, Bundle bundle) {
        if (!this.f15512N.get()) {
            super.forward(i, bundle);
            this.f15512N.set(true);
        }
    }

    /* access modifiers changed from: protected */
    public void updateOnServiceRealtimePriceNotify(OrderRealtimePriceCount orderRealtimePriceCount) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.endAddress != null) {
            CarNotifyManager.buildInServiceNotifyParams(this.mContext, order.endAddress.getDisplayName(), orderRealtimePriceCount.totalFee, order.currency);
        }
    }

    /* access modifiers changed from: protected */
    public void showNotPayNotification() {
        CarNotifyManager.buildPayNotify(this.mContext);
    }

    /* renamed from: d */
    private void m11200d(NextCommonPushMsg nextCommonPushMsg) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order.oid.equals(nextCommonPushMsg.getOid())) {
            order.wayPointList = nextCommonPushMsg.wayPointList;
            order.wayPointsVersion = nextCommonPushMsg.wayPointsVersion;
            doPublish(BaseEventKeys.OnService.EVENT_UPDATE_WAY_POINT);
            doPublish(BaseEventKeys.Service.EVENT_WAY_POINT_CHANGED_RECEIVED);
        }
    }

    /* access modifiers changed from: protected */
    public void forwardCancelServicePage(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        bundle.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_CANCEL, true);
        if (z) {
            bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 3);
        }
        forwardNew(1015, bundle);
    }

    /* renamed from: a */
    private void m11163a(int i) {
        CarOrder order = CarOrderHelper.getOrder();
        HashSet<String> hashSet = SceneHelper.getInstance().pickSet;
        HashSet<String> hashSet2 = SceneHelper.getInstance().finishSet;
        if (order != null) {
            if (i != 1) {
                if (i == 2 && !hashSet2.contains(order.oid)) {
                    hashSet2.add(order.oid);
                    m11182a(order.oid, "pas_orderfinish_state");
                }
            } else if (!hashSet.contains(order.oid)) {
                hashSet.add(order.oid);
                m11182a(order.oid, "pas_after_drivercoming_state");
            }
        }
    }

    /* renamed from: a */
    private void m11182a(String str, String str2) {
        Set<String> stringSet = GlobalSPUtil.getStringSet(this.mContext, str2);
        if (!stringSet.contains(str)) {
            if (stringSet.size() >= 30) {
                stringSet.clear();
            }
            stringSet.add(str);
            GlobalSPUtil.putStringSet(this.mContext, str2, stringSet);
            FireBaseEventUtils.traceEvent(str2, false);
        }
    }
}
