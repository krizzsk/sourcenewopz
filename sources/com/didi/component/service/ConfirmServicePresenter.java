package com.didi.component.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.android.didi.bfflib.business.BffBaseObject;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.oneconfig.AbsConfirmConfigState;
import com.didi.component.business.oneconfig.NewConfirmAddressConfigState;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.tracker.flex.FlexTrack;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.core.Animations;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.service.activity.DynamicWebActivity;
import com.didi.component.service.cancelreason.cache.CancelTripCache;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKUICreator;
import com.didi.global.globalgenerickit.GGKView;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.global.globalgenerickit.config.GGKConfigCallbackAdapter;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel0;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOImgModel;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.p154ms.common.utils.LogUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.p171v2.session.Scene;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.listener.DefaultDiDiCoreCallback;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.NextPayResult;
import com.didi.travel.psnger.model.response.NextTotalFeeDetail;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarPayModel;
import com.didi.travel.psnger.model.response.estimate.CarBreakConfirmBlockInfoModel;
import com.didi.travel.psnger.model.response.estimate.CarBreakMemberModel;
import com.didi.travel.psnger.model.response.estimate.CarBreakModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didiglobal.enginecore.data.model.XEDataHandleModel;
import com.didiglobal.travel.util.CollectionUtils;
import com.didiglobal.travel.util.Preconditions;
import com.taxis99.R;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfirmServicePresenter extends AbsSendOrderServicePresenter implements AbsConfirmConfigState.IConfirmConfigCallback {

    /* renamed from: b */
    private static final String f15583b = "ConfirmServicePresenter";

    /* renamed from: s */
    private static final int f15584s = 101;

    /* renamed from: c */
    private boolean f15585c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f15586d;

    /* renamed from: e */
    private boolean f15587e;

    /* renamed from: f */
    private AbsConfirmConfigState f15588f;

    /* renamed from: g */
    private GGKDrawer f15589g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LEGODrawer f15590h;

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15591i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f15592j;

    /* renamed from: k */
    private BaseEventPublisher.OnEventListener<XEDataHandleModel> f15593k;

    /* renamed from: l */
    private BaseEventPublisher.OnEventListener<DTSDKOrderStatus> f15594l;

    /* renamed from: m */
    private BaseEventPublisher.OnEventListener<String> f15595m;
    protected boolean mIsSendOrderInWaitRspPage;
    protected final Logger mLogger;
    public long memberShipDrawerStartTime;
    public String offerPriceJsonString;

    /* renamed from: r */
    private BaseEventPublisher.OnEventListener<String> f15596r;

    /* renamed from: t */
    private BaseEventPublisher.OnEventListener<Object> f15597t;

    /* renamed from: u */
    private final DefaultDiDiCoreCallback f15598u;

    /* renamed from: v */
    private final BaseEventPublisher.OnEventListener<Boolean> f15599v;

    /* renamed from: w */
    private final BaseEventPublisher.OnEventListener<Boolean> f15600w;

    /* renamed from: x */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15601x;

    /* renamed from: y */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15602y;

    /* renamed from: z */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15603z;

    public static class OrderCreateErrorCode {
        public static final int ERROR_CODE_AIRPORT_INTERCEPTOR = 1154;
        public static final int ERROR_CODE_BOOKING_NOSUPPORTED = 1133;
        public static final int ERROR_CODE_CARPOOLING_TIME_LIMIT = 1047;
        public static final int ERROR_CODE_CASH_FENCE = 1060;
        public static final int ERROR_CODE_CASH_UNPAY = 1134;
        public static final int ERROR_CODE_CLEAN_FEE = 1136;
        public static final int ERROR_CODE_CREATE_ORDER_FAIL_NEED_REFRESH_ESTIMATE = 10625;
        public static final int ERROR_CODE_DELIVERY_ORDER_LIMIT = 20077;
        public static final int ERROR_CODE_DYNAMIC_PRICE_EXPIRED = 1102;
        public static final int ERROR_CODE_ESTIMATE_EXPIRED = 1123;
        public static final int ERROR_CODE_EXPRESS_NOT_SUPPORT = 1039;
        public static final int ERROR_CODE_HAVE_ORDER_TO_PAY = 1020;
        public static final int ERROR_CODE_HIGHWAY_FEE = 1137;
        public static final int ERROR_CODE_NEED_ADD_CARD = 1128;
        public static final int ERROR_CODE_NEED_CPF_CHECK = 20011;
        public static final int ERROR_CODE_NEED_FACE_RECOGNIZE = 1058;
        public static final int ERROR_CODE_NEED_RG_CHECK = 1059;
        public static final int ERROR_CODE_NEED_SAFETY_AUTH = 1127;
        public static final int ERROR_CODE_NEED_VERIFY_CARD = 1055;
        public static final int ERROR_CODE_NO_SERVICE_CURRENT = 1016;
        public static final int ERROR_CODE_ORDER_BAN = 1135;
        public static final int ERROR_CODE_ORDER_CONFLICT = 1053;
        public static final int ERROR_CODE_ORDER_VAMOS_CONFLICT = 1144;
        public static final int ERROR_CODE_RISK_BLOCK = 20010;
        public static final int ERROR_CODE_SPLITFARE_ERROR = 30001;
    }

    /* access modifiers changed from: protected */
    public boolean interceptFixPrice() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void trackEventCreateOrder() {
    }

    public boolean gotoOfferPrice() {
        doPublish(BaseEventKeys.Service.SendOrder.EVENT_OFFER_PRICE_DIALOG);
        return true;
    }

    public ConfirmServicePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mLogger = LoggerFactory.getLogger(getClass());
        this.f15585c = false;
        this.f15586d = false;
        this.f15587e = false;
        this.mIsSendOrderInWaitRspPage = false;
        this.memberShipDrawerStartTime = System.currentTimeMillis();
        this.f15591i = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                if (BaseEventKeys.Service.SendOrder.EVENT_REQUEST_SEND_ORDER.equals(str)) {
                    FormStore instance = FormStore.getInstance();
                    if (instance.getDepartureAddress() != null) {
                        instance.setStartAddress(instance.getDepartureAddress(), false);
                    }
                    ConfirmServicePresenter.this.onSendOrderRequestAction();
                }
            }
        };
        this.f15592j = false;
        this.f15593k = new BaseEventPublisher.OnEventListener<XEDataHandleModel>() {
            public void onEvent(String str, XEDataHandleModel xEDataHandleModel) {
                if (xEDataHandleModel != null && !ConfirmServicePresenter.this.f15592j) {
                    GLog.m7965d("minibusOrderStatus", "forwardOnService");
                    ConfirmServicePresenter.this.doPublish(BaseEventKeys.Confirm.EVENT_CONFORM_HIDE_START_END_LOADING);
                    ConfirmServicePresenter.this.m11330a(xEDataHandleModel);
                    boolean unused = ConfirmServicePresenter.this.f15592j = true;
                }
            }
        };
        this.f15594l = new BaseEventPublisher.OnEventListener<DTSDKOrderStatus>() {
            public void onEvent(String str, DTSDKOrderStatus dTSDKOrderStatus) {
                if (TextUtils.equals(str, BaseEventKeys.WaitRspNew.EVENT_ORDER_STATUS)) {
                    XEngineReq.pageRequest(XERequestKey.SCENE_CONFIRM);
                }
            }
        };
        this.offerPriceJsonString = "";
        this.f15595m = new BaseEventPublisher.OnEventListener<String>() {
            public void onEvent(String str, String str2) {
                ConfirmServicePresenter confirmServicePresenter = ConfirmServicePresenter.this;
                confirmServicePresenter.m11332a(" offerPriceJsonString +" + str2);
                ConfirmServicePresenter.this.offerPriceJsonString = str2;
            }
        };
        this.f15596r = new BaseEventPublisher.OnEventListener<String>() {
            public void onEvent(String str, String str2) {
                ConfirmServicePresenter confirmServicePresenter = ConfirmServicePresenter.this;
                confirmServicePresenter.m11332a(" gotoConfirmAddress " + str2);
                FormStore.getInstance().setFlexOfferPrice(true);
                FormStore.getInstance().setInputOfferPrice(str2);
                ConfirmServicePresenter.this.gotoConfirmAddress();
            }
        };
        this.f15597t = new BaseEventPublisher.OnEventListener<Object>() {
            public void onEvent(String str, Object obj) {
                ConfirmServicePresenter.this.mLogger.info("ConfirmServicePresenter sendOrderActionReceiver", new Object[0]);
                if (!ConfirmServicePresenter.this.interceptRequestAction()) {
                    if (obj instanceof Boolean) {
                        boolean unused = ConfirmServicePresenter.this.f15586d = ((Boolean) obj).booleanValue();
                    }
                    ConfirmServicePresenter.this.onSendOrderRequestAction();
                    return;
                }
                SceneHelper.getInstance().setOrderIntercepted(true);
            }
        };
        this.f15598u = new DefaultDiDiCoreCallback() {
            public void onOrderPollTimeChange(int i) {
            }

            public void onOrderStatusChange(IOrderStatus iOrderStatus) {
                super.onOrderStatusChange(iOrderStatus);
            }

            public void onOrderStatusTimeOut() {
                GLog.m7965d("minibusOrderStatus", "onOrderStatusTimeOut");
            }

            public void onCommonMessageReceive(int i, String str) {
                GLog.m7965d("minibusOrderStatus", "onCommonMessageReceive");
            }

            public void onCarpoolInfoChange() {
                GLog.m7965d("minibusOrderStatus", "onCarpoolInfoChange");
            }

            public void onRealtimePriceRefresh(OrderRealtimePriceCount orderRealtimePriceCount) {
                GLog.m7965d("minibusOrderStatus", "onRealtimePriceRefresh");
            }

            public void onTotalFeeDetailReceive(NextTotalFeeDetail nextTotalFeeDetail) {
                GLog.m7965d("minibusOrderStatus", "onTotalFeeDetailReceive");
            }

            public void onPayResultReceive(NextPayResult nextPayResult) {
                GLog.m7965d("minibusOrderStatus", "onPayResultReceive");
            }
        };
        this.f15599v = new BaseEventPublisher.OnEventListener<Boolean>() {
            public void onEvent(String str, Boolean bool) {
                ConfirmServicePresenter.this.reEstimateSuccess(bool.booleanValue());
            }
        };
        this.f15600w = new BaseEventPublisher.OnEventListener<Boolean>() {
            public void onEvent(String str, Boolean bool) {
                ConfirmServicePresenter.this.reEstimateSuccess(false);
            }
        };
        this.f15601x = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                ConfirmServicePresenter.this.reEstimateFail();
            }
        };
        this.f15602y = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                ConfirmServicePresenter.this.reEstimateFail();
            }
        };
        this.f15603z = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
            public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
                ConfirmServicePresenter.this.endReEstimate();
            }
        };
        this.mIsSendOrderInWaitRspPage = true;
    }

    /* access modifiers changed from: protected */
    public void onSubscribeEventReceiver() {
        super.onSubscribeEventReceiver();
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_ACTION_SEND_ORDER, this.f15597t);
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_SEND_ORDER, this.f15591i);
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_ENTER_CONFIRM_ADDRESS, this.f15596r);
        subscribe(BaseEventKeys.WaitRspNew.EVENT_ORDER_STATUS, this.f15594l);
        subscribe(BaseEventKeys.XEngine.EVENT_XENGINE_DATA_HANDLE, this.f15593k);
    }

    /* access modifiers changed from: protected */
    public void onUnsubscribeEventReceiver() {
        super.onUnsubscribeEventReceiver();
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_ACTION_SEND_ORDER, this.f15597t);
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_SEND_ORDER, this.f15591i);
        unsubscribe(BaseEventKeys.WaitRspNew.EVENT_ORDER_STATUS, this.f15594l);
        unsubscribe(BaseEventKeys.XEngine.EVENT_XENGINE_DATA_HANDLE, this.f15593k);
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_ENTER_CONFIRM_ADDRESS, this.f15596r);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11332a(String str) {
        this.mLogger.info(str, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        GLog.m7968e("BizLog", "Confirm onAdd");
        super.onAdd(bundle);
        boolean z = false;
        if (bundle != null) {
            this.f15585c = bundle.getBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_GET_ON_SCENE, false);
            m11333a(bundle.getBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_GET_ON_SCENE, false));
            z = bundle.getBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_REQUEST_BY_CANCEL_TRIP, false);
            String string = bundle.getString(BaseExtras.ConfirmService.EXTRA_BACK_TO_CONFIRM_TIP);
            if (!TextUtils.isEmpty(string)) {
                m11342b(string);
            }
        } else {
            m11333a(false);
        }
        GlobalOmegaUtils.removeOrderType();
        m11359m();
        m11363q();
        if (z) {
            this.f15587e = true;
            CancelTripCache.getInstance().setUsingCacheEstimateParams(true);
            onSendOrderRequestAction();
        }
        if (this.mComponentProxy.getSession() == null) {
            LogUtils.m31492e(f15583b, "onAdd:Unknown Reason, Session is null");
            this.mComponentProxy.createSession("ConfirmServicePresenter.Unknown");
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        GLog.m7968e("BizLog", "Confirm onRemove");
        dismissProgressDialog();
        AbsConfirmConfigState absConfirmConfigState = this.f15588f;
        if (absConfirmConfigState != null) {
            absConfirmConfigState.unsubscribeConfig();
        }
        m11362p();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        if (this.f15585c) {
            backConfirmPricePage();
        } else {
            m11358l();
        }
        GGKDrawer gGKDrawer = this.f15589g;
        if (gGKDrawer == null || !gGKDrawer.isShowing()) {
            return true;
        }
        this.f15589g.dismiss();
        return true;
    }

    /* renamed from: a */
    private void m11333a(boolean z) {
        AbsConfirmConfigState absConfirmConfigState = this.f15588f;
        if (absConfirmConfigState != null) {
            absConfirmConfigState.unsubscribeConfig();
        }
        if (z) {
            this.f15588f = new NewConfirmAddressConfigState(this.mBusinessContext, (AbsConfirmConfigState.IConfirmConfigCallback) null);
        }
        AbsConfirmConfigState absConfirmConfigState2 = this.f15588f;
        if (absConfirmConfigState2 != null) {
            absConfirmConfigState2.subscribeConfig();
        }
    }

    public void onNetStart() {
        showLoading();
    }

    public void onNetSuccess() {
        hideLoading();
    }

    public void onNetFail() {
        m11339b();
        GlobalOmegaUtils.trackEvent("pas_onconffailure_sw");
    }

    /* renamed from: b */
    private void m11339b() {
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(101);
        normalDialogInfo.setMessage(ResourcesHelper.getString(this.mContext, R.string.g_oneconf_fail));
        normalDialogInfo.setPositiveText(ResourcesHelper.getString(this.mContext, R.string.g_oneconf_fail_retry));
        normalDialogInfo.setNegativeText(ResourcesHelper.getString(this.mContext, R.string.g_oneconf_fail_back));
        normalDialogInfo.setCancelable(false);
        showDialog(normalDialogInfo);
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        AbsConfirmConfigState absConfirmConfigState;
        super.onDialogAction(i, i2);
        if (i == 101) {
            if (i2 == 1) {
                goBack();
            } else if (i2 == 2 && (absConfirmConfigState = this.f15588f) != null) {
                absConfirmConfigState.reGetMisConfigFromNet();
            }
        }
    }

    public void onChangeSelf() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        forward(1030, bundle);
    }

    /* renamed from: c */
    private boolean m11345c() {
        EstimateItemModel newEstimateItem;
        boolean z = false;
        if (this.f15585c || (newEstimateItem = FormStore.getInstance().getNewEstimateItem()) == null || newEstimateItem.carBreakModel == null || newEstimateItem.carBreakModel.confirmBlockInfo == null || TextUtils.isEmpty(newEstimateItem.carBreakModel.confirmBlockInfo.url)) {
            return false;
        }
        CarBreakConfirmBlockInfoModel carBreakConfirmBlockInfoModel = newEstimateItem.carBreakModel.confirmBlockInfo;
        if (carBreakConfirmBlockInfoModel != null) {
            try {
                if (!(carBreakConfirmBlockInfoModel.params == null || carBreakConfirmBlockInfoModel.params.get("is_back_home") == null || carBreakConfirmBlockInfoModel.params.get("is_back_home").getAsInt() != 1)) {
                    z = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.m26098e(f15583b, "interceptRequestAction:isBackHome data error, e = " + e);
            }
        }
        if (z) {
            m11358l();
        }
        final StringBuilder sb = new StringBuilder(carBreakConfirmBlockInfoModel.url);
        if (!(carBreakConfirmBlockInfoModel == null || carBreakConfirmBlockInfoModel.params == null || carBreakConfirmBlockInfoModel.params.size() <= 0)) {
            if (!carBreakConfirmBlockInfoModel.url.contains("?")) {
                sb.append("?");
            } else {
                sb.append(ParamKeys.SIGN_AND);
            }
            try {
                sb.append("params=");
                sb.append(URLEncoder.encode(carBreakConfirmBlockInfoModel.params.toString(), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            public void run() {
                DRouter.build(sb.toString()).start(ConfirmServicePresenter.this.mContext);
            }
        }, 100);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean interceptRequestAction() {
        Logger logger = this.mLogger;
        logger.info("ConfirmServicePresenter interceptRequestAction isConfirmAddressState=" + this.f15585c, new Object[0]);
        if (m11345c() || m11354h()) {
            return true;
        }
        if (this.f15585c) {
            return m11351f();
        }
        FormStore instance = FormStore.getInstance();
        boolean booleanData = instance.getBooleanData(FormStore.KEY_RECALL_ORDER, false);
        Logger logger2 = this.mLogger;
        logger2.info("AbsServicePresenter interceptRequestAction autoSendOrder=" + booleanData, new Object[0]);
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
            doPublish(BaseEventKeys.Confirm.SHOW_PAYMENTS);
            this.mLogger.info("AbsServicePresenter interceptRequestAction interceptPayWay", new Object[0]);
            return true;
        } else if (m11349e() || interceptCarpoolSelectSeatCount() || m11347d()) {
            return true;
        } else {
            if (NationComponentDataUtil.isLoginNow() && !TextUtils.isEmpty(NationComponentDataUtil.getToken())) {
                return super.interceptRequestAction();
            }
            gotoLoginForResult(70);
            return true;
        }
    }

    /* renamed from: d */
    private boolean m11347d() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null) {
            return false;
        }
        if (confirmListener.getIsAnyCar()) {
            AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
            if (this.f15585c || FormStore.getInstance().isShiftSelected() || selectedSingleAnyCarItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel == null || TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.seatSelectScheme)) {
                return false;
            }
            DRouter.build(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.seatSelectScheme).start();
            return true;
        }
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (this.f15585c || FormStore.getInstance().isShiftSelected() || newEstimateItem == null || newEstimateItem.carBreakModel == null || TextUtils.isEmpty(newEstimateItem.carBreakModel.seatSelectScheme)) {
            return false;
        }
        DRouter.build(newEstimateItem.carBreakModel.seatSelectScheme).start();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        r1 = m11337a(r2.mAnyCarEstimateNetItem.carBreakModel);
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m11349e() {
        /*
            r5 = this;
            com.didi.component.business.data.form.PageCompDataTransfer r0 = com.didi.component.business.data.form.PageCompDataTransfer.getInstance()
            com.didi.component.business.data.form.listener.ConfirmListener r0 = r0.getConfirmListener()
            r1 = 0
            if (r0 == 0) goto L_0x0077
            boolean r2 = r0.getIsAnyCar()
            if (r2 == 0) goto L_0x0062
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r2 = r0.getSelectedSingleAnyCarItem()
            java.util.List r3 = r0.getSelectedAnyCarItems()
            if (r2 == 0) goto L_0x002f
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r3 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r3 = r3.carBreakModel
            if (r3 == 0) goto L_0x002e
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r1 = r2.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r1 = r1.carBreakModel
            boolean r1 = r5.m11337a((com.didi.travel.psnger.model.response.estimate.CarBreakModel) r1)
            if (r1 == 0) goto L_0x002e
            r0.setHitPreOrderItem(r2)
        L_0x002e:
            return r1
        L_0x002f:
            boolean r2 = com.didi.sdk.util.collection.CollectionUtil.isEmpty((java.util.Collection<?>) r3)
            if (r2 != 0) goto L_0x0077
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r2 = r0.getHitPreOrderItem()
            if (r2 == 0) goto L_0x003c
            return r1
        L_0x003c:
            java.util.Iterator r2 = r3.iterator()
        L_0x0040:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0061
            java.lang.Object r3 = r2.next()
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel r3 = (com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel) r3
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r4 = r3.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r4 = r4.carBreakModel
            if (r4 == 0) goto L_0x0040
            com.didi.travel.psnger.model.response.anycar.AnyCarEstimateNetModel r4 = r3.mAnyCarEstimateNetItem
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r4 = r4.carBreakModel
            boolean r4 = r5.m11337a((com.didi.travel.psnger.model.response.estimate.CarBreakModel) r4)
            if (r4 == 0) goto L_0x0040
            r0.setHitPreOrderItem(r3)
            r0 = 1
            return r0
        L_0x0061:
            return r1
        L_0x0062:
            com.didi.component.business.data.form.FormStore r0 = com.didi.component.business.data.form.FormStore.getInstance()
            com.didi.travel.psnger.model.response.estimate.EstimateItemModel r0 = r0.getNewEstimateItem()
            if (r0 == 0) goto L_0x0077
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r2 = r0.carBreakModel
            if (r2 == 0) goto L_0x0077
            com.didi.travel.psnger.model.response.estimate.CarBreakModel r0 = r0.carBreakModel
            boolean r0 = r5.m11337a((com.didi.travel.psnger.model.response.estimate.CarBreakModel) r0)
            return r0
        L_0x0077:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.service.ConfirmServicePresenter.m11349e():boolean");
    }

    /* renamed from: a */
    private boolean m11337a(CarBreakModel carBreakModel) {
        if (this.f15585c || carBreakModel.preorderExpoInterceptInfo == null || TextUtils.isEmpty(carBreakModel.preorderExpoInterceptInfo.interceptScheme) || carBreakModel.preorderExpoInterceptInfo.show) {
            return false;
        }
        DRouter.build(carBreakModel.preorderExpoInterceptInfo.interceptScheme).start();
        carBreakModel.preorderExpoInterceptInfo.show = true;
        return true;
    }

    /* renamed from: f */
    private boolean m11351f() {
        this.mLogger.info("brz confirmsvr interceptRequestAction()", new Object[0]);
        if (interceptFixPrice()) {
            this.mLogger.info("interceptFixPrice", new Object[0]);
            return true;
        } else if (interceptBookOrder()) {
            this.mLogger.info("interceptBookOrder", new Object[0]);
            ToastHelper.showLongInfo(this.mContext, (int) R.string.car_toast_info_booktime_error);
            onBackPressed((IPresenter.BackType) null);
            return true;
        } else if (reEstimateBeforeSendOrder()) {
            return true;
        } else {
            if (!m11353g()) {
                return false;
            }
            this.mLogger.info("interceptLocationAbnormal", new Object[0]);
            return true;
        }
    }

    /* renamed from: g */
    private boolean m11353g() {
        if (FormStore.getInstance().isCarPoolLineBeforeHaveOrder()) {
            return false;
        }
        doPublish(BaseEventKeys.Service.SendOrder.EVENT_START_END_ABNORMAL);
        return true;
    }

    /* renamed from: h */
    private boolean m11354h() {
        PayWayModel.PayWayItem i = m11355i();
        if (i == null || i.expired != 1) {
            return false;
        }
        doPublish(BaseEventKeys.Service.SendOrder.EVENT_CARD_EXPIRED_INTERCEPT, i);
        return true;
    }

    /* renamed from: i */
    private PayWayModel.PayWayItem m11355i() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null) {
            if (confirmListener.getIsAnyCar()) {
                AnyCarPayModel anycarPayModel = confirmListener.getAnycarPayModel();
                if (anycarPayModel != null) {
                    return anycarPayModel.getSelectPayWayItem();
                }
            } else {
                EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
                if (estimateItem != null) {
                    return estimateItem.getSelectPayWayItem();
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean interceptCarpoolSelectSeatCount() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null) {
            return false;
        }
        if (confirmListener.getIsAnyCar()) {
            AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
            if (selectedSingleAnyCarItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.carBreakSeat == null || !CollectionUtils.isNotEmpty((Collection<?>) selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.carBreakSeat.seatBreakChoice) || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig == null || TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.uniqueId) || FormStore.getInstance().getIsSeatConfirmDialogShowed(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.uniqueId)) {
                return false;
            }
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_COMBO_SELECT_SEAT_SHOW);
            return true;
        }
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            if (newEstimateItem.isOperationContainsTwoPrice()) {
                if (!FormStore.getInstance().isTwoPriceBiz() || FormStore.getInstance().isTwoPriceSeatConfirm()) {
                    return false;
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_TWO_PRICE_SELECT_SEAT_SHOW);
                return true;
            } else if (newEstimateItem.carBreakModel != null && newEstimateItem.carBreakModel.carBreakSeat != null && CollectionUtils.isNotEmpty((Collection<?>) newEstimateItem.carBreakModel.carBreakSeat.seatBreakChoice) && newEstimateItem.carConfig != null && !TextUtils.isEmpty(newEstimateItem.carConfig.uniqueId) && !FormStore.getInstance().getIsSeatConfirmDialogShowed(newEstimateItem.carConfig.uniqueId)) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_COMBO_SELECT_SEAT_SHOW);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 70) {
            if (i == 71 && i2 == -1 && intent != null) {
                int intExtra = intent.getIntExtra(DynamicWebActivity.KEY_CLICK_RESULT, 0);
                Logger logger = this.mLogger;
                logger.info("result = " + intExtra, new Object[0]);
                if (intExtra == 1) {
                    onSendOrderRequestAction();
                    buildDYEstimateShow("dypricesec_ok_ck");
                } else if (intExtra == 2) {
                    buildDYEstimateShow("dypricesec_wait_ck");
                }
            }
        } else if (i2 == -1) {
            this.mLogger.info("login success, getstimate", new Object[0]);
            doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
        }
    }

    /* access modifiers changed from: protected */
    public void onSendOrderRequestAction() {
        Logger logger = this.mLogger;
        logger.info("onSendOrderRequestAction isConfirmAddressState=" + this.f15585c, new Object[0]);
        if (m11356j()) {
            this.f15586d = false;
            this.f15587e = false;
            this.mLogger.info("onSendOrderRequestAction CREATE_ORDER_FIRST", new Object[0]);
            createOrder(0);
            trackEventCreateOrder();
            return;
        }
        onFirstConfirm();
    }

    /* renamed from: j */
    private boolean m11356j() {
        return this.f15587e || this.f15585c || this.f15586d || FormStore.getInstance().isFromOpenRide();
    }

    /* access modifiers changed from: protected */
    public void onFirstConfirm() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || !confirmListener.getIsAnyCar()) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (newEstimateItem != null && newEstimateItem.carConfig != null && newEstimateItem.carConfig.carBussinessId == 21070 && (newEstimateItem.carBreakModel == null || TextUtils.isEmpty(newEstimateItem.carBreakModel.offer_flex_price_scheme))) {
                FlexTrack.track(FlexTrack.FlexEvent.sFlexMonitorEventId, 4);
            }
            if (newEstimateItem != null && newEstimateItem.carBreakModel != null && newEstimateItem.carBreakModel.carBreakMember != null && newEstimateItem.carConfig != null && !FormStore.getInstance().isEstimatePassConfirm()) {
                m11329a(newEstimateItem);
            } else if (newEstimateItem == null || newEstimateItem.carBreakModel == null || TextUtils.isEmpty(newEstimateItem.carBreakModel.offer_flex_price_scheme)) {
                gotoConfirmAddress();
            } else if (!gotoOfferPrice()) {
                gotoConfirmAddress();
            }
        } else {
            AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
            List<AnyCarEstimateItemModel> selectedAnyCarItems = confirmListener.getSelectedAnyCarItems();
            if (selectedSingleAnyCarItem != null && selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig != null && selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.carBussinessId == 21070 && (selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel == null || TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.offer_flex_price_scheme))) {
                FlexTrack.track(FlexTrack.FlexEvent.sFlexMonitorEventId, 4);
            }
            if (selectedSingleAnyCarItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel == null || TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carBreakModel.offer_flex_price_scheme)) {
                if (selectedSingleAnyCarItem == null && !CollectionUtil.isEmpty((Collection<?>) selectedAnyCarItems)) {
                    for (AnyCarEstimateItemModel next : selectedAnyCarItems) {
                        if (next.mAnyCarEstimateNetItem.carBreakModel != null && next.mAnyCarEstimateNetItem.carBreakModel.carBreakMember != null && next.mAnyCarEstimateNetItem.carConfig != null && !FormStore.getInstance().isEstimatePassConfirm()) {
                            m11328a(next);
                            return;
                        }
                    }
                }
                gotoConfirmAddress();
            } else if (!gotoOfferPrice()) {
                gotoConfirmAddress();
            }
        }
    }

    /* renamed from: b */
    private void m11342b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f15590h = LEGOUICreator.showDrawerTemplate(this.mContext, new LEGODrawerModel1(str, new LEGOBtnTextAndCallback(ResourcesHelper.getString(this.mContext, R.string.GRider_page_Determination_yMCk), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    ConfirmServicePresenter.this.f15590h.dismiss();
                }
            })));
        }
    }

    /* renamed from: a */
    private void m11329a(final EstimateItemModel estimateItemModel) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        this.memberShipDrawerStartTime = System.currentTimeMillis();
        final CarBreakMemberModel carBreakMemberModel = estimateItemModel.carBreakModel.carBreakMember;
        if (carBreakMemberModel.passengerNewSheet != null) {
            try {
                JSONObject jSONObject = new JSONObject(carBreakMemberModel.passengerNewSheet.toString());
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (!(optJSONArray == null || (optJSONObject = optJSONArray.getJSONObject(0).optJSONObject("normal")) == null || (optJSONObject2 = optJSONObject.optJSONObject("data")) == null)) {
                    if (optJSONObject2.optInt("buy_type") == 1) {
                        GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_view_sw");
                    } else {
                        GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_view_sw");
                    }
                }
                GGKConfigManager.legoConfig(getHost().getActivity(), jSONObject, "passenger_newSheet", new GGKConfigCallbackAdapter() {
                    public boolean sheetXMLClickLis(final LEGODrawer lEGODrawer, GGKData gGKData, String str, String str2, Map<String, Object> map) {
                        if (!TextUtils.isEmpty(str2) && !"null".equals(str2)) {
                            if (str2.startsWith("http") || str2.startsWith("https")) {
                                DRouter.build(str2).start(ConfirmServicePresenter.this.getHost().getActivity());
                            } else {
                                int optInt = gGKData.getData().optInt("buy_type");
                                gGKData.getData().optString("package_id");
                                C69541 r3 = new Runnable() {
                                    public void run() {
                                        LEGODrawer lEGODrawer = lEGODrawer;
                                        if (lEGODrawer != null) {
                                            lEGODrawer.dismiss();
                                            ConfirmServicePresenter.this.gotoConfirmAddress();
                                        }
                                    }
                                };
                                FormStore.getInstance().setIsPassShowDialog(true);
                                if (str2.endsWith("confirm_buy") || str2.endsWith("confirm_renew")) {
                                    GlobalOmegaUtils.trackEvent(optInt == 1 ? "ibt_gp_firstpoppasscard_buy_btn_ck" : "ibt_gp_secondpoppasscard_buy_btn_ck");
                                    FormStore.getInstance().setIsDialogPassConfirm(true);
                                    ConfirmServicePresenter.this.m11331a((Runnable) r3, true, 1);
                                } else {
                                    GlobalOmegaUtils.trackEvent(optInt == 1 ? "ibt_gp_firstpoppasscard_refuse_btn_ck" : "ibt_gp_secondpoppasscard_refuse_btn_ck");
                                    FormStore.getInstance().setIsDialogPassConfirm(false);
                                    ConfirmServicePresenter.this.m11331a((Runnable) r3, false, 2);
                                }
                                return true;
                            }
                        }
                        return true;
                    }
                });
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                gotoConfirmAddress();
            }
        }
        if (carBreakMemberModel == null || TextUtils.isEmpty(carBreakMemberModel.memberTopImg) || carBreakMemberModel.memberTopImg.equals("null") || TextUtils.isEmpty(carBreakMemberModel.memberCancelMsg) || TextUtils.isEmpty(carBreakMemberModel.memberConfirmMsg) || TextUtils.isEmpty(carBreakMemberModel.memberContent) || TextUtils.isEmpty(carBreakMemberModel.memberTitle) || TextUtils.isEmpty(carBreakMemberModel.packageId) || estimateItemModel.carConfig == null || TextUtils.isEmpty(estimateItemModel.carConfig.estimateId)) {
            gotoConfirmAddress();
            return;
        }
        final int i = carBreakMemberModel.memberBuyType;
        if (i == 1) {
            GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_view_sw");
        } else {
            GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_view_sw");
        }
        LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(carBreakMemberModel.memberTitle, new LEGOBtnTextAndCallback(carBreakMemberModel.memberConfirmMsg, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (i == 1) {
                    GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_buy_btn_ck");
                } else {
                    GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_buy_btn_ck");
                }
                ConfirmServicePresenter.this.m11334a(true, estimateItemModel.carConfig.estimateId, carBreakMemberModel.packageId, 1, new Runnable() {
                    public void run() {
                        if (ConfirmServicePresenter.this.f15590h != null) {
                            ConfirmServicePresenter.this.f15590h.dismiss();
                        }
                        ConfirmServicePresenter.this.gotoConfirmAddress();
                    }
                });
            }
        }));
        lEGODrawerModel1.setIsShowCloseImg(true);
        lEGODrawerModel1.setClickOutsideCanCancel(false);
        lEGODrawerModel1.setSubTitle(carBreakMemberModel.memberContent);
        lEGODrawerModel1.addMinorBtn(new LEGOBtnTextAndCallback(carBreakMemberModel.memberCancelMsg, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (i == 1) {
                    GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_refuse_btn_ck");
                } else {
                    GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_refuse_btn_ck");
                }
                ConfirmServicePresenter.this.m11334a(false, estimateItemModel.carConfig.estimateId, carBreakMemberModel.packageId, 2, new Runnable() {
                    public void run() {
                        if (ConfirmServicePresenter.this.f15590h != null) {
                            ConfirmServicePresenter.this.f15590h.dismiss();
                        }
                        ConfirmServicePresenter.this.gotoConfirmAddress();
                    }
                });
            }
        }));
        LEGOImgModel lEGOImgModel = new LEGOImgModel();
        lEGOImgModel.setImgUrl(carBreakMemberModel.memberTopImg);
        lEGODrawerModel1.setImgModel(lEGOImgModel);
        this.f15590h = LEGOUICreator.showDrawerTemplate(this.mContext, lEGODrawerModel1);
    }

    /* renamed from: a */
    private void m11328a(final AnyCarEstimateItemModel anyCarEstimateItemModel) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        this.memberShipDrawerStartTime = System.currentTimeMillis();
        final CarBreakMemberModel carBreakMemberModel = anyCarEstimateItemModel.mAnyCarEstimateNetItem.carBreakModel.carBreakMember;
        if (carBreakMemberModel.passengerNewSheet != null) {
            try {
                JSONObject jSONObject = new JSONObject(carBreakMemberModel.passengerNewSheet.toString());
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (!(optJSONArray == null || (optJSONObject = optJSONArray.getJSONObject(0).optJSONObject("normal")) == null || (optJSONObject2 = optJSONObject.optJSONObject("data")) == null)) {
                    if (optJSONObject2.optInt("buy_type") == 1) {
                        GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_view_sw");
                    } else {
                        GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_view_sw");
                    }
                }
                GGKConfigManager.legoConfig(getHost().getActivity(), jSONObject, "passenger_newSheet", new GGKConfigCallbackAdapter() {
                    public boolean sheetXMLClickLis(final LEGODrawer lEGODrawer, GGKData gGKData, String str, String str2, Map<String, Object> map) {
                        if (!TextUtils.isEmpty(str2) && !"null".equals(str2)) {
                            if (str2.startsWith("http") || str2.startsWith("https")) {
                                DRouter.build(str2).start(ConfirmServicePresenter.this.getHost().getActivity());
                            } else {
                                int optInt = gGKData.getData().optInt("buy_type");
                                gGKData.getData().optString("package_id");
                                C69301 r3 = new Runnable() {
                                    public void run() {
                                        LEGODrawer lEGODrawer = lEGODrawer;
                                        if (lEGODrawer != null) {
                                            lEGODrawer.dismiss();
                                            ConfirmServicePresenter.this.gotoConfirmAddress();
                                        }
                                    }
                                };
                                FormStore.getInstance().setIsPassShowDialog(true);
                                if (str2.endsWith("confirm_buy") || str2.endsWith("confirm_renew")) {
                                    GlobalOmegaUtils.trackEvent(optInt == 1 ? "ibt_gp_firstpoppasscard_buy_btn_ck" : "ibt_gp_secondpoppasscard_buy_btn_ck");
                                    FormStore.getInstance().setIsDialogPassConfirm(true);
                                    ConfirmServicePresenter.this.m11331a((Runnable) r3, true, 1);
                                } else {
                                    GlobalOmegaUtils.trackEvent(optInt == 1 ? "ibt_gp_firstpoppasscard_refuse_btn_ck" : "ibt_gp_secondpoppasscard_refuse_btn_ck");
                                    FormStore.getInstance().setIsDialogPassConfirm(false);
                                    ConfirmServicePresenter.this.m11331a((Runnable) r3, false, 2);
                                }
                                return true;
                            }
                        }
                        return true;
                    }
                });
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                gotoConfirmAddress();
            }
        }
        if (carBreakMemberModel == null || TextUtils.isEmpty(carBreakMemberModel.memberTopImg) || carBreakMemberModel.memberTopImg.equals("null") || TextUtils.isEmpty(carBreakMemberModel.memberCancelMsg) || TextUtils.isEmpty(carBreakMemberModel.memberConfirmMsg) || TextUtils.isEmpty(carBreakMemberModel.memberContent) || TextUtils.isEmpty(carBreakMemberModel.memberTitle) || TextUtils.isEmpty(carBreakMemberModel.packageId) || anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig == null || TextUtils.isEmpty(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.estimateId)) {
            gotoConfirmAddress();
            return;
        }
        final int i = carBreakMemberModel.memberBuyType;
        if (i == 1) {
            GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_view_sw");
        } else {
            GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_view_sw");
        }
        LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(carBreakMemberModel.memberTitle, new LEGOBtnTextAndCallback(carBreakMemberModel.memberConfirmMsg, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (i == 1) {
                    GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_buy_btn_ck");
                } else {
                    GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_buy_btn_ck");
                }
                ConfirmServicePresenter.this.m11334a(true, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.estimateId, carBreakMemberModel.packageId, 1, new Runnable() {
                    public void run() {
                        if (ConfirmServicePresenter.this.f15590h != null) {
                            ConfirmServicePresenter.this.f15590h.dismiss();
                        }
                        ConfirmServicePresenter.this.gotoConfirmAddress();
                    }
                });
            }
        }));
        lEGODrawerModel1.setIsShowCloseImg(true);
        lEGODrawerModel1.setClickOutsideCanCancel(false);
        lEGODrawerModel1.setSubTitle(carBreakMemberModel.memberContent);
        lEGODrawerModel1.addMinorBtn(new LEGOBtnTextAndCallback(carBreakMemberModel.memberCancelMsg, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (i == 1) {
                    GlobalOmegaUtils.trackEvent("ibt_gp_firstpoppasscard_refuse_btn_ck");
                } else {
                    GlobalOmegaUtils.trackEvent("ibt_gp_secondpoppasscard_refuse_btn_ck");
                }
                ConfirmServicePresenter.this.m11334a(false, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.estimateId, carBreakMemberModel.packageId, 2, new Runnable() {
                    public void run() {
                        if (ConfirmServicePresenter.this.f15590h != null) {
                            ConfirmServicePresenter.this.f15590h.dismiss();
                        }
                        ConfirmServicePresenter.this.gotoConfirmAddress();
                    }
                });
            }
        }));
        LEGOImgModel lEGOImgModel = new LEGOImgModel();
        lEGOImgModel.setImgUrl(carBreakMemberModel.memberTopImg);
        lEGODrawerModel1.setImgModel(lEGOImgModel);
        this.f15590h = LEGOUICreator.showDrawerTemplate(this.mContext, lEGODrawerModel1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11331a(Runnable runnable, boolean z, int i) {
        if (runnable != null) {
            runnable.run();
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("scene", z ? "buy" : "refuse");
        hashMap.put("residencetime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.memberShipDrawerStartTime)));
        GlobalOmegaUtils.trackEvent(i == 1 ? "ibt_gp_firstpoppasscard_residencetime_ex" : "ibt_gp_secondpoppasscard_residencetime_ex", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11334a(final boolean z, String str, String str2, final int i, final Runnable runnable) {
        CarRequest.tripBuy(this.mContext, str, str2, i, 1, new BffResponseListener<BffBaseObject>() {
            public void onSuccess(BffBaseObject bffBaseObject) {
                super.onSuccess(bffBaseObject);
                GlobalOmegaUtils.trackEvent("ibt_bp_passpurchase_bt");
                next();
            }

            public void onError(BffBaseObject bffBaseObject) {
                super.onError(bffBaseObject);
                ToastHelper.showShortCompleted(ConfirmServicePresenter.this.mContext, (int) R.string.global_system_busy_click_toast);
                next();
            }

            public void onFail(BffBaseObject bffBaseObject) {
                super.onFail(bffBaseObject);
                ToastHelper.showShortCompleted(ConfirmServicePresenter.this.mContext, (int) R.string.global_system_busy_click_toast);
                next();
            }

            private void next() {
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
                HashMap hashMap = new HashMap(1);
                hashMap.put("scene", z ? "buy" : "refuse");
                hashMap.put("residencetime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - ConfirmServicePresenter.this.memberShipDrawerStartTime)));
                GlobalOmegaUtils.trackEvent(i == 1 ? "ibt_gp_firstpoppasscard_residencetime_ex" : "ibt_gp_secondpoppasscard_residencetime_ex", (Map<String, Object>) hashMap);
            }
        });
    }

    /* renamed from: a */
    private void m11325a(GGKData gGKData) {
        GGKView createTemplateView = GlobalGenericKit.createTemplateView(this.mContext, gGKData);
        if (createTemplateView != null) {
            GGKDrawerModel0 gGKDrawerModel0 = new GGKDrawerModel0();
            gGKDrawerModel0.setExtendedView(createTemplateView.getView()).setIsLoadingEnable(true).setClickOutsideCanCancel(false).setmBackPressedEnabled(false);
            this.f15589g = GGKUICreator.showDrawerModel(this.mContext, gGKDrawerModel0);
            this.memberShipDrawerStartTime = System.currentTimeMillis();
        }
    }

    /* access modifiers changed from: protected */
    public void gotoConfirmAddress() {
        this.f15585c = true;
        FormStore.getInstance().setDepartureAddress((Address) null);
        FormStore.getInstance().setFlightNum((String) null);
        FormStore.getInstance().setShiftSelected(false);
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || !confirmListener.getIsAnyCar()) {
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (!(newEstimateItem == null || newEstimateItem.carBreakModel == null || newEstimateItem.carBreakModel.preorderExpoInterceptInfo == null || !newEstimateItem.carBreakModel.preorderExpoInterceptInfo.show)) {
                newEstimateItem.carBreakModel.preorderExpoInterceptInfo.show = false;
            }
        } else {
            AnyCarEstimateItemModel hitPreOrderItem = confirmListener.getHitPreOrderItem();
            if (!(hitPreOrderItem == null || hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel == null || hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel.preorderExpoInterceptInfo == null || !hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel.preorderExpoInterceptInfo.show)) {
                hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel.preorderExpoInterceptInfo.show = false;
            }
        }
        GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PICONF);
        m11333a(true);
        if (confirmListener != null) {
            confirmListener.setCurrentPage(3);
        }
        doPublish(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS);
        if (confirmListener != null) {
            AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
            if (!confirmListener.getIsAnyCar()) {
                EstimateItemModel newEstimateItem2 = FormStore.getInstance().getNewEstimateItem();
                if (newEstimateItem2 != null && newEstimateItem2.carConfig != null && !TextUtils.isEmpty(newEstimateItem2.carConfig.uniqueId)) {
                    FormStore.getInstance().setIsSeatConfirmDialogShowed(newEstimateItem2.carConfig.uniqueId, false);
                }
            } else if (selectedSingleAnyCarItem != null && selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig != null && !TextUtils.isEmpty(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.uniqueId)) {
                FormStore.getInstance().setIsSeatConfirmDialogShowed(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.uniqueId, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void backConfirmPricePage() {
        this.f15585c = false;
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null) {
            confirmListener.setCurrentPage(1);
        }
        if (FormStore.getInstance().isInMiniBus()) {
            doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
        }
        FormStore.getInstance().setIsInMiniBus(false);
        FormStore.getInstance().setFlexOfferPrice(false);
        GlobalOmegaUtils.trackEvent("gp_confirm_service_confirmDeparture_back");
        GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_CONF);
        m11333a(false);
        doPublish(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE);
        m11357k();
    }

    /* renamed from: k */
    private void m11357k() {
        FormStore.getInstance().setEstimatePassConfirm(false);
        FormStore.getInstance().setIsDialogPassConfirm(false);
        FormStore.getInstance().setIsPassShowDialog(false);
    }

    /* renamed from: l */
    private void m11358l() {
        PinCodeInfoResult driverInfo;
        if (FormStore.getInstance().isFromOpenRide() && (driverInfo = FormStore.getInstance().getDriverInfo()) != null) {
            m11318a(2, driverInfo.driverId);
        }
        FormStore.getInstance().setCurCompany((TaxiCompanyListModel.CompanyModel) null);
        GlobalOmegaUtils.trackEvent("global_checkpage_back_ck", "country", BusinessUtils.getCountryIsoCode(this.mBusinessContext));
        Bundle bundle = new Bundle();
        bundle.putSerializable("home_map_user_start_address", FormStore.getInstance().getStartAddress());
        bundle.putBoolean("is_form_confirm_back_home", true);
        goBackRoot(bundle);
    }

    /* renamed from: a */
    private void m11318a(int i, String str) {
        CarRequest.notifyDriverStateOfPsg(this.mContext, i, str, (ResponseListener<BaseObject>) null);
    }

    /* renamed from: m */
    private void m11359m() {
        Boolean bool;
        try {
            bool = (Boolean) FormStore.getInstance().getData(FormStore.KEY_RECALL_ORDER);
        } catch (Exception unused) {
            bool = false;
        }
        if (bool != null && bool.booleanValue()) {
            FormStore.getInstance().setData(FormStore.KEY_RECALL_ORDER, false);
            createOrder(0);
        }
    }

    /* access modifiers changed from: protected */
    public void createOrder(int i) {
        if (FormStore.getInstance().isInMiniBus()) {
            this.mIsSendOrderInWaitRspPage = false;
        } else {
            this.mIsSendOrderInWaitRspPage = true;
        }
        CarOrderHelper.saveOrder((CarOrder) null);
        boolean z = this.mIsSendOrderInWaitRspPage;
        if (z) {
            gotoWaitRspPage((CarOrder) null, z);
            return;
        }
        showProgressDialog(this.mContext.getString(R.string.car_sending_order));
        setParam(getCreateOrderParam());
        super.createOrder(i);
    }

    /* access modifiers changed from: protected */
    public void onOrderCreated(CarOrder carOrder) {
        super.onOrderCreated(carOrder);
        if (FormStore.getInstance().isInMiniBus()) {
            m11360n();
            m11361o();
            FormStore.getInstance().setIsInMiniBus(false);
        }
        if (Preconditions.nonNull(carOrder) && carOrder.isBooking() && carOrder.isBookingDelayAssign()) {
            m11327a(carOrder, (ResponseListener<CarOrder>) new ResponseListener<CarOrder>() {
                public void onSuccess(CarOrder carOrder) {
                    ConfirmServicePresenter.this.m11326a(carOrder);
                }
            });
        } else if (carOrder.getProductId() == 21009) {
            m11327a(carOrder, (ResponseListener<CarOrder>) new ResponseListener<CarOrder>() {
                public void onSuccess(CarOrder carOrder) {
                    ConfirmServicePresenter confirmServicePresenter = ConfirmServicePresenter.this;
                    confirmServicePresenter.gotoWaitRspPage(carOrder, confirmServicePresenter.mIsSendOrderInWaitRspPage);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11330a(XEDataHandleModel xEDataHandleModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BaseExtras.Common.EXTRA_GETON_TO_RSP, xEDataHandleModel);
        bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        bundle.putInt(BaseExtras.Trip.EXTRA_TRIP_SCENE, 10402);
        bundle.putBoolean(BaseExtras.Trip.EXTRA_TRIP_IS_ANY_CAR, this.isAnyCar);
        forward(1040, bundle, new Animations(0, 0, 0, 0));
    }

    /* renamed from: n */
    private void m11360n() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            order.status = 7;
        }
    }

    /* renamed from: o */
    private void m11361o() {
        if (this.mOrderStatusPoll == null) {
            LogUtils.m31492e(f15583b, "startOrderService:mOrderStatusPoll is null, mTag = ConfirmServicePresenter");
            return;
        }
        this.mOrderStatusPoll.addCoreCallback(this.f15598u);
        this.mOrderStatusPoll.startPoll((Scene) null);
    }

    /* renamed from: p */
    private void m11362p() {
        if (this.mOrderStatusPoll != null) {
            this.mOrderStatusPoll.removeCoreCallback(this.f15598u);
            this.mOrderStatusPoll.stopPoll((Scene) null);
            return;
        }
        LogUtils.m31495w(f15583b, "stopOrderService:mOrderStatusPoll is null");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11327a(final CarOrder carOrder, final ResponseListener<CarOrder> responseListener) {
        TravelUtil.getOrderDetail(this.mComponentProxy.getSession(), carOrder.oid, new ITravelOrderListener() {
            public void onSuccess(ICarOrder iCarOrder) {
                responseListener.onSuccess((CarOrder) iCarOrder);
            }

            public void onError(int i, String str) {
                ConfirmServicePresenter.this.m11341b(carOrder, (ResponseListener<CarOrder>) responseListener);
            }

            public void onFail(int i, String str) {
                ConfirmServicePresenter.this.m11341b(carOrder, (ResponseListener<CarOrder>) responseListener);
            }

            public void onTimeout(String str) {
                ConfirmServicePresenter.this.m11341b(carOrder, (ResponseListener<CarOrder>) responseListener);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11341b(final CarOrder carOrder, final ResponseListener<CarOrder> responseListener) {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                ConfirmServicePresenter.this.m11327a(carOrder, (ResponseListener<CarOrder>) responseListener);
            }
        }, 3000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11326a(CarOrder carOrder) {
        dismissProgressDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable(BaseExtras.Common.EXTRA_ORDER_BEAN, carOrder);
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        forwardNew(1025, bundle);
    }

    /* access modifiers changed from: protected */
    public void onOrderCreateFail(CarOrder carOrder) {
        int errorCode;
        super.onOrderCreateFail(carOrder);
        if (carOrder != null) {
            omegaTrackSendOrderErrorCode(carOrder.errno);
            if (FormStore.getInstance().isInMiniBus() && (errorCode = carOrder.getErrorCode()) != 1058 && errorCode != 1055 && errorCode != 10001) {
                backConfirmPricePage();
                doPublish(BaseEventKeys.Confirm.EVENT_CONFORM_HIDE_START_END_LOADING);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void backToEstimate() {
        if (this.f15585c) {
            onBackPressed(IPresenter.BackType.BackKey);
        }
        FormStore.getInstance().setPayWay("");
        FormStore.getInstance().setPayWayMsg("");
        doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
    }

    /* access modifiers changed from: protected */
    public void showPaymentsPage() {
        if (this.f15585c) {
            onBackPressed(IPresenter.BackType.BackKey);
            doPublish(BaseEventKeys.Confirm.SHOW_PAYMENTS);
        }
    }

    /* renamed from: q */
    private void m11363q() {
        CarOrder createFailOrder = FormStore.getInstance().getCreateFailOrder();
        if (createFailOrder != null) {
            FormStore.getInstance().setCreateFailOrder((CarOrder) null);
            onOrderCreateFail(createFailOrder);
        }
    }

    /* access modifiers changed from: protected */
    public void startReEstimate() {
        super.startReEstimate();
        doPublish(BaseEventKeys.Estimate.ESTIMATE_FIXED_PRICE_RE_ESTIMATE);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_SUCCESS, this.f15599v);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FAIL, this.f15601x);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR, this.f15602y);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH, this.f15603z);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f15600w);
    }

    /* access modifiers changed from: protected */
    public void endReEstimate() {
        super.endReEstimate();
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_SUCCESS, this.f15599v);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FAIL, this.f15601x);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_ERROR, this.f15602y);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_CALLBACK_FINISH, this.f15603z);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f15600w);
    }
}
