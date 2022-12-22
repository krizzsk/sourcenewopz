package com.didi.component.payentrance.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import androidx.fragment.app.FragmentManager;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.constant.BundleConstants;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.UniPayManager;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.base.ComponentWrap;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.payentrance.activity.FareDetailsActivity;
import com.didi.component.payentrance.model.JumpableItem;
import com.didi.component.payentrance.utils.GlobalPayEntranceEventManager;
import com.didi.component.payentrance.utils.PERedirectUtil;
import com.didi.component.payentrance.view.IPayEntranceViewContainer;
import com.didi.component.payentrance.view.Mode;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.pay.base.PayCommonParamsUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.event.PayResultEvent;
import com.didi.travel.psnger.model.response.CarCancelTrip;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.utils.TextUtil;
import com.didi.travel.psnger.utils.UIThreadHandler;
import com.didi.unifiedPay.UnifiedPaySystem;
import com.didi.unifiedPay.sdk.internal.PayCallback;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.internal.PayError;
import com.didi.unifiedPay.sdk.internal.PayServiceCallback;
import com.didi.unifiedPay.sdk.internal.SyncPayResultCallback;
import com.didi.unifiedPay.sdk.internal.api.IUnifiedPayApi;
import com.didi.unifiedPay.sdk.model.ActionType;
import com.didi.unifiedPay.sdk.model.BasicBill;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.didi.unifiedPay.sdk.model.PushMessage;
import com.didi.unifiedPay.sdk.net.Error;
import com.didi.unifiedPay.util.HighlightUtil;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import global.didi.pay.threeds.model.Adyen3DSModel;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbsUnifiedPayEntrancePresenter extends AbsPayEntrancePresenter {
    public static final int ACCEPT_ORDER = 1;
    public static final int BIND_CARD_REQUEST_CODE = 103;
    public static final String EXTRA_CONFIRM_RESULT_KEY = "EXTRA_CONFIRM_RESULT_KEY";
    public static final String EXTRA_ORDER_STATE_UNPAY = "EXTRA_ORDER_STATE_UNPAY";
    public static final String EXTRA_PIN_CURRENCY_KEY = "EXTRA_PIN_CURRENCY_KEY";
    public static final String EXTRA_PIN_ERR_KEY = "EXTRA_PIN_ERR_KEY";
    public static final int NOT_ACCEPT_ORDER = 2;
    public static final int OBJECTION_REQUEST_CODE = 102;
    public static final int PIN_ERR_REQUEST_CODE = 101;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f14948a = AbsUnifiedPayEntrancePresenter.class.getSimpleName();

    /* renamed from: b */
    private static final String f14949b = "pay_channel_desc";

    /* renamed from: e */
    private static final String f14950e = "additional_fee_text";

    /* renamed from: f */
    private static final String f14951f = "additional_fee_text_color";

    /* renamed from: g */
    private static final String f14952g = "objection_page_url";

    /* renamed from: h */
    private static final int f14953h = 1;

    /* renamed from: c */
    private final Logger f14954c = LoggerFactory.getLogger(getClass());

    /* renamed from: d */
    private Bundle f14955d;

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener f14956i = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (TextUtils.equals(str, BaseEventKeys.Pay.CATEGORY)) {
                char c = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != -1550441114) {
                    if (hashCode != -1145184310) {
                        if (hashCode == 51041678 && str2.equals(BaseEventKeys.Pay.EVENT_PAYMENT_PAY_SUCCESS)) {
                            c = 0;
                        }
                    } else if (str2.equals(BaseEventKeys.Pay.EVENT_PAYMENT_PAY_WAIT)) {
                        c = 1;
                    }
                } else if (str2.equals(BaseEventKeys.Pay.EVENT_PAYMENT_PAY_DETAIL)) {
                    c = 2;
                }
                if (c == 0) {
                    AbsUnifiedPayEntrancePresenter.this.handleWhenPaySuccess();
                    AbsUnifiedPayEntrancePresenter.this.refreshOrderBill();
                } else if (c == 1) {
                    AbsUnifiedPayEntrancePresenter.this.mIsPayMentShow = false;
                    AbsUnifiedPayEntrancePresenter.this.refreshOrderBill();
                } else if (c == 2) {
                    AbsUnifiedPayEntrancePresenter.this.m10745e();
                }
            }
        }
    };
    protected Boolean isViewReady = null;
    protected BasicPayInfo mBasicPayInfo;
    protected FragmentManager mFragmentManager;
    protected boolean mIsFromPayView;
    protected boolean mIsNewCard;
    protected boolean mIsOrderStateUnpay;
    protected boolean mIsPayMentShow;
    protected PayServiceCallback<BasicPayInfo> mPayinfoCallback = new PayServiceCallback<BasicPayInfo>() {
        public void onSuccess(BasicPayInfo basicPayInfo) {
            ((IPayEntranceViewContainer) AbsUnifiedPayEntrancePresenter.this.mView).hideLoading();
            AbsUnifiedPayEntrancePresenter.this.mBasicPayInfo = basicPayInfo;
            AbsUnifiedPayEntrancePresenter.this.checkObjection();
            AbsUnifiedPayEntrancePresenter.this.handlePayInfo(basicPayInfo);
            AbsUnifiedPayEntrancePresenter.this.hideLoadingWithNewUI();
        }

        public void onFail(Error error) {
            ((IPayEntranceViewContainer) AbsUnifiedPayEntrancePresenter.this.mView).showError(error.msg);
            AbsUnifiedPayEntrancePresenter.this.onViewReady(false);
            AbsUnifiedPayEntrancePresenter.this.hideLoadingWithNewUI();
        }
    };
    protected String mSid;
    protected PayCallback mSyncPayResultCallback = new SyncPayResultCallback() {
        public void onPaySuccess(int i, String str) {
            GLog.m7965d(AbsUnifiedPayEntrancePresenter.f14948a, "onPaySuccess");
            ToastHelper.showShortCompleted(AbsUnifiedPayEntrancePresenter.this.mContext, AbsUnifiedPayEntrancePresenter.this.mContext.getString(R.string.pay_success));
            AbsUnifiedPayEntrancePresenter.this.m10727a(10, (BasicPayInfo) null);
        }

        public void onPayFail(PayError payError, String str) {
            GLog.m7965d(AbsUnifiedPayEntrancePresenter.f14948a, "onPayFail");
            AbsUnifiedPayEntrancePresenter.this.goPayPage();
        }

        public void onAdyenThreeDSActionHandle(Adyen3DSModel adyen3DSModel) {
            UIThreadHandler.post(new Runnable() {
                public void run() {
                    AbsUnifiedPayEntrancePresenter.this.refreshOrderBill();
                }
            }, 3000);
        }
    };
    protected IUnifiedPayApi mUnifiedPaySystem;

    /* renamed from: a */
    private boolean m10734a(int i, boolean z) {
        return i == 3 && z;
    }

    /* access modifiers changed from: protected */
    public abstract int getBid();

    public String getOfflineURL() {
        return "";
    }

    /* access modifiers changed from: protected */
    public abstract String getOrderId();

    /* access modifiers changed from: protected */
    public void handleWhenPaySuccess() {
    }

    /* access modifiers changed from: protected */
    public void hideLoadingWithNewUI() {
    }

    /* access modifiers changed from: protected */
    public void onATTransientNopayRegister() {
    }

    /* access modifiers changed from: protected */
    public void onATTransientPaidRegister() {
    }

    /* access modifiers changed from: protected */
    public void onViewReady(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void whenAddedWithNoOrderId() {
    }

    /* access modifiers changed from: protected */
    public boolean isFeeObjection() {
        BasicPayInfo basicPayInfo = this.mBasicPayInfo;
        if (basicPayInfo == null || basicPayInfo.blockType != 1 || this.mBasicPayInfo.objectionInfo == null || !this.mBasicPayInfo.objectionInfo.containsKey(f14952g)) {
            return false;
        }
        return true;
    }

    public boolean checkObjection() {
        if (this.mBasicPayInfo == null || !isFeeObjection()) {
            return false;
        }
        String str = (String) this.mBasicPayInfo.objectionInfo.get(f14952g);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("oid", getOrderId());
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            hashMap.put("business_id", Integer.valueOf(order.getProductId()));
        }
        String buildUrl = GlobalWebUrl.buildUrl(str, hashMap);
        Intent intent = new Intent(this.mContext, GlobalWebActivity.class);
        intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(buildUrl));
        startActivityForResult(intent, 102);
        return true;
    }

    /* access modifiers changed from: protected */
    public void handlePushReceiver(int i, PushMessage pushMessage) {
        if (pushMessage != null && TextUtils.equals(getOrderId(), pushMessage.oid) && i == 1) {
            refreshOrderBill();
        }
    }

    /* access modifiers changed from: protected */
    public void handlePayInfo(BasicPayInfo basicPayInfo) {
        this.mBasicPayInfo = basicPayInfo;
        if (basicPayInfo == null) {
            ((IPayEntranceViewContainer) this.mView).showError((CharSequence) null);
        } else {
            handlePayState(basicPayInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void handlePayState(BasicPayInfo basicPayInfo) {
        switch (basicPayInfo.payStatus) {
            case 0:
                ((IPayEntranceViewContainer) this.mView).showError(ResourcesHelper.getString(this.mContext, R.string.oc_pay_bill_refresh_failed));
                return;
            case 1:
            case 4:
                if (this.mIsFromPayView) {
                    setupView(basicPayInfo, false, false);
                    return;
                } else {
                    goPayPage();
                    return;
                }
            case 2:
                if (!this.mIsPayMentShow) {
                    handlePayWait(basicPayInfo);
                    return;
                }
                return;
            case 3:
                if (this.mIsOrderStateUnpay) {
                    goPayPage();
                    return;
                } else {
                    setupView(basicPayInfo, true, false);
                    return;
                }
            case 5:
                setupView(basicPayInfo, true, true);
                return;
            case 6:
                setupView(basicPayInfo, false, false);
                return;
            case 7:
                setupOrderClosedView(basicPayInfo);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void goPayPage() {
        doPublish(BaseEventKeys.Template.EVENT_SHOW_POPUP_COMPONENT, new ComponentWrap("payment"));
        m10727a(11, (BasicPayInfo) null);
    }

    public void startSyncPayResult() {
        GLog.m7965d(f14948a, "startSyncPayResult");
        IUnifiedPayApi iUnifiedPayApi = this.mUnifiedPaySystem;
        if (iUnifiedPayApi != null) {
            iUnifiedPayApi.registerCallback(this.mSyncPayResultCallback);
            this.mUnifiedPaySystem.startSyncPayResult(30, 3000);
        }
    }

    public void stopSyncPayResult() {
        IUnifiedPayApi iUnifiedPayApi = this.mUnifiedPaySystem;
        if (iUnifiedPayApi != null) {
            iUnifiedPayApi.removeCallback();
            this.mUnifiedPaySystem.stopSyncPayResult();
        }
    }

    /* access modifiers changed from: protected */
    public void launchH5Page(String str) {
        if (!TextUtil.isEmpty(str)) {
            UniPayManager.gotoWeb(this.mContext, str);
            GlobalPayEntranceEventManager.doEvent(GlobalPayEntranceEventManager.KEY_PAS_UNPAIDCARD_FARE_CK);
        }
    }

    public AbsUnifiedPayEntrancePresenter(String str, ComponentParams componentParams, FragmentManager fragmentManager, Bundle bundle) {
        super(componentParams);
        this.mSid = str;
        this.mFragmentManager = fragmentManager;
        this.f14955d = bundle;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        if (TextUtil.isEmpty(getOrderId()) || m10742c()) {
            whenAddedWithNoOrderId();
            if (TextUtil.isEmpty(getOrderId())) {
                return;
            }
        }
        m10728a(bundle);
        Bundle bundle2 = this.f14955d;
        boolean z = false;
        if (bundle2 != null) {
            this.mIsNewCard = bundle2.getBoolean(BundleConstants.PaymentEntrance.BUNDLE_KEY_PAYMENT_NEW_CARD, false);
            ((IPayEntranceViewContainer) this.mView).setNewCard(this.mIsNewCard);
        }
        if (bundle.getInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 0) == 2) {
            z = true;
        }
        this.mIsPayMentShow = z;
        lazyInit();
    }

    /* renamed from: c */
    private boolean m10742c() {
        CarOrder order = CarOrderHelper.getOrder();
        return order != null && (order.orderSource == 2 || order.orderSource == 3);
    }

    /* access modifiers changed from: protected */
    public void lazyInit() {
        try {
            Integer.parseInt(NationTypeUtil.getNationComponentData().getTerminal_id());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        IUnifiedPayApi createUnifiedPay = UnifiedPaySystem.createUnifiedPay(this.mContext, PayConstant.PayBillType.Trip);
        this.mUnifiedPaySystem = createUnifiedPay;
        createUnifiedPay.init(getBid(), getOrderId(), getHost().getFragmentManager());
        ((IPayEntranceViewContainer) this.mView).setMode(Mode.NoStateView);
        initOrderBill();
        registerPushListener();
        subscribe(BaseEventKeys.Pay.CATEGORY, this.f14956i);
    }

    /* renamed from: a */
    private void m10728a(Bundle bundle) {
        if (bundle != null) {
            this.mIsFromPayView = bundle.getBoolean("KEY_RETURN_FROM_PAYVIEW", false);
            this.mIsOrderStateUnpay = bundle.getBoolean(EXTRA_ORDER_STATE_UNPAY, false);
            Logger logger = this.f14954c;
            logger.info("mIsOrderStateUnpay:" + this.mIsOrderStateUnpay, new Object[0]);
            bundle.remove("KEY_RETURN_FROM_PAYVIEW");
            bundle.remove(EXTRA_ORDER_STATE_UNPAY);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unregisterPushListener();
        IUnifiedPayApi iUnifiedPayApi = this.mUnifiedPaySystem;
        if (iUnifiedPayApi != null) {
            iUnifiedPayApi.onDestroy();
        }
        unsubscribe(BaseEventKeys.Pay.CATEGORY, this.f14956i);
        stopSyncPayResult();
    }

    public void onErrorClick() {
        refreshOrderBill();
    }

    public void onCancelRuleClick() {
        String buildUrl = GlobalWebUrl.buildUrl(GlobalWebUrl.getCancelTripRuleUrl(this.mContext, (String) null), m10726a(CarOrderHelper.getOrder()));
        if (!TextUtils.isEmpty(buildUrl)) {
            m10733a(buildUrl, ResourcesHelper.getString(this.mContext, R.string.pe_pay_penalty_cancel_rule));
        }
    }

    /* renamed from: a */
    private HashMap<String, Object> m10726a(CarOrder carOrder) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String valueOf = carOrder.startAddress != null ? String.valueOf(carOrder.startAddress.getCityId()) : null;
        if (valueOf == null) {
            LocationController.getInstance();
            valueOf = String.valueOf(LocationController.getCurrentLocationCityId());
        }
        double latitude = carOrder.startAddress != null ? carOrder.startAddress.getLatitude() : LocationController.getInstance().getLat(this.mContext);
        double longitude = carOrder.startAddress != null ? carOrder.startAddress.getLongitude() : LocationController.getInstance().getLng(this.mContext);
        hashMap.put("token", NationComponentDataUtil.getToken());
        hashMap.put("area", valueOf);
        hashMap.put("lat", Double.valueOf(latitude));
        hashMap.put("lng", Double.valueOf(longitude));
        if (carOrder.carLevel != null) {
            hashMap.put("car_level", carOrder.carLevel);
        }
        hashMap.put("appversion", SystemUtil.getVersionName(this.mContext));
        hashMap.put("oid", carOrder.oid);
        hashMap.put("car_pool", Integer.valueOf(carOrder.flierFeature.carPool));
        hashMap.put(ParamKeys.PARAM_CONTROL, 0);
        hashMap.put(ParamKeys.PARAM_DISTRICT, carOrder.disTrict);
        hashMap.put("business_id", Integer.valueOf(carOrder.productid));
        return hashMap;
    }

    /* renamed from: a */
    private void m10733a(String str, String str2) {
        WebViewModel webViewModel = new WebViewModel();
        webViewModel.title = str2;
        webViewModel.url = str;
        webViewModel.isSupportCache = false;
        webViewModel.isPostBaseParams = false;
        Intent intent = new Intent(this.mContext, WebActivity.class);
        intent.putExtra("web_view_model", webViewModel);
        startActivity(intent);
    }

    public void onItemClick(JumpableItem jumpableItem) {
        if (jumpableItem != null) {
            String a = m10725a(jumpableItem.getId());
            if (!TextUtil.isEmpty(a)) {
                int id = jumpableItem.getId();
                if (id != 1) {
                    if (id == 2) {
                        m10732a(a);
                    } else if (id != 5) {
                        launchH5Page(a);
                    } else {
                        launchH5Page(a);
                    }
                } else if (GlobalApolloUtil.isH5CovertToNative()) {
                    m10745e();
                } else {
                    launchH5Page(a);
                }
            }
        }
    }

    public void onPayClick(Mode mode, double d, double d2) {
        goPayPage();
    }

    /* access modifiers changed from: protected */
    public void refreshOrderBill() {
        ((IPayEntranceViewContainer) this.mView).showLoading();
        IUnifiedPayApi iUnifiedPayApi = this.mUnifiedPaySystem;
        if (iUnifiedPayApi != null) {
            iUnifiedPayApi.getBasicPayInfo(this.mPayinfoCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void initOrderBill() {
        CarOrder order = CarOrderHelper.getOrder();
        if (BusinessDataUtil.isTripCanceledWithoutFee(order)) {
            setupOrderCanceledNoFeeView(order);
        } else {
            refreshOrderBill();
        }
    }

    /* access modifiers changed from: protected */
    public void setupView(BasicPayInfo basicPayInfo, boolean z, boolean z2) {
        ((IPayEntranceViewContainer) this.mView).hideLoading();
        ((IPayEntranceViewContainer) this.mView).removeSupplement();
        m10739b(basicPayInfo);
        if (z2) {
            m10741c(basicPayInfo);
            m10727a(10, (BasicPayInfo) null);
        } else if (z) {
            setupFinishView(basicPayInfo);
            m10727a(10, basicPayInfo);
        } else {
            setupPayView(basicPayInfo);
            m10727a(11, basicPayInfo);
        }
    }

    /* renamed from: a */
    private void m10731a(BasicPayInfo basicPayInfo) {
        String str = f14948a;
        GLog.m7974w(str, "setupWaitView:" + basicPayInfo.waitPayMsg);
        ((IPayEntranceViewContainer) this.mView).hideLoading();
        ((IPayEntranceViewContainer) this.mView).removeSupplement();
        m10739b(basicPayInfo);
        setupFinishView(basicPayInfo);
        PayResultEvent payResultEvent = new PayResultEvent();
        payResultEvent.payResultStatus = 13;
        payResultEvent.payStatusTitle = basicPayInfo.waitPayMsg;
        doPublish(BaseEventKeys.Service.EndService.EVENT_PAY_RESULT_GOT, payResultEvent);
    }

    /* access modifiers changed from: protected */
    public void setupPayView(BasicPayInfo basicPayInfo) {
        if (basicPayInfo == null || basicPayInfo.billBasic == null) {
            GLog.m7968e(f14948a, "payInfo or payInfo.billBasic  ==null");
            return;
        }
        BasicBill basicBill = basicPayInfo.billBasic;
        if (basicPayInfo.payStatus == 6 || basicPayInfo.blockType == 2) {
            ((IPayEntranceViewContainer) this.mView).setMode(Mode.RISKVIEW);
            ((IPayEntranceViewContainer) this.mView).setActionButtonEnable(false);
            doPublish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYMENT_PAY_FAIL_RISK);
        } else {
            ((IPayEntranceViewContainer) this.mView).setMode(Mode.NormalPay);
        }
        setTotalFee(basicPayInfo.billBasic);
        setMessage(basicPayInfo);
        addJumpable(basicBill, setCancelRule());
        addDeductions(basicPayInfo);
        if (isFeeObjection()) {
            ((IPayEntranceViewContainer) this.mView).setActionText(this.mContext.getString(R.string.pe_car_pay_entrance_title));
        } else {
            ((IPayEntranceViewContainer) this.mView).setActionText(this.mContext.getString(R.string.pe_car_pay_entrance_title_4cancel));
        }
        onATTransientNopayRegister();
    }

    /* access modifiers changed from: protected */
    public void setupOrderClosedView(BasicPayInfo basicPayInfo) {
        if (basicPayInfo == null || basicPayInfo.billBasic == null) {
            GLog.m7968e(f14948a, "payInfo or payInfo.billBasic  ==null");
            return;
        }
        BasicBill basicBill = basicPayInfo.billBasic;
        ((IPayEntranceViewContainer) this.mView).setMode(Mode.FinishPay);
        setTotalFee(basicBill);
        if (TextUtils.isEmpty(basicPayInfo.statusMsg)) {
            ((IPayEntranceViewContainer) this.mView).setMessage(ResourcesHelper.getString(this.mContext, R.string.pe_pay_entrance_order_closed_msg));
        } else {
            ((IPayEntranceViewContainer) this.mView).setMessage(basicPayInfo.statusMsg);
        }
        m10727a(12, (BasicPayInfo) null);
    }

    /* access modifiers changed from: protected */
    public void setupOrderCanceledNoFeeView(CarOrder carOrder) {
        if (carOrder != null) {
            CarCancelTrip carCancelTrip = carOrder.carCancelTrip;
            int i = carOrder.status;
            if (i != 2) {
                if (i != 6) {
                    m10744d();
                } else if (carOrder.substatus != 6001) {
                } else {
                    if (this.mIsNewCard) {
                        ((IPayEntranceViewContainer) this.mView).setMode(Mode.NoStateView);
                    } else {
                        m10730a(carCancelTrip);
                    }
                }
            } else if (this.mIsNewCard) {
                ((IPayEntranceViewContainer) this.mView).setMode(Mode.NoStateView);
            } else {
                m10738b(carCancelTrip);
            }
        }
    }

    /* renamed from: a */
    private void m10730a(CarCancelTrip carCancelTrip) {
        ((IPayEntranceViewContainer) this.mView).setMode(Mode.FinishPay);
        if (carCancelTrip == null || TextUtils.isEmpty(carCancelTrip.showTitle)) {
            ((IPayEntranceViewContainer) this.mView).setMessage(ResourcesHelper.getString(this.mContext, R.string.pe_pay_entrance_cancel_trip_title_default));
        } else {
            ((IPayEntranceViewContainer) this.mView).setMessage(carCancelTrip.showTitle);
        }
        setCancelRule();
    }

    /* renamed from: b */
    private void m10738b(CarCancelTrip carCancelTrip) {
        ((IPayEntranceViewContainer) this.mView).setMode(Mode.FinishPay);
        if (carCancelTrip == null || TextUtils.isEmpty(carCancelTrip.showTitle)) {
            ((IPayEntranceViewContainer) this.mView).setMessage(ResourcesHelper.getString(this.mContext, R.string.pe_pay_entrance_cancel_trip_title_default));
        } else {
            ((IPayEntranceViewContainer) this.mView).setMessage(carCancelTrip.showTitle);
        }
        setCancelRule();
    }

    /* renamed from: d */
    private void m10744d() {
        ((IPayEntranceViewContainer) this.mView).setMode(Mode.NoStateView);
        ((IPayEntranceViewContainer) this.mView).showError(ResourcesHelper.getString(this.mContext, R.string.pe_pay_entrance_cancel_trip_title_default));
    }

    /* access modifiers changed from: protected */
    public void setupFinishView(BasicPayInfo basicPayInfo) {
        if (basicPayInfo == null || basicPayInfo.billBasic == null) {
            GLog.m7968e(f14948a, "payInfo or payInfo.billBasic  ==null");
            return;
        }
        BasicBill basicBill = basicPayInfo.billBasic;
        ((IPayEntranceViewContainer) this.mView).setMode(Mode.FinishPay);
        setTotalFee(basicPayInfo.billBasic);
        setMessage(basicPayInfo);
        addJumpable(basicBill, setCancelRule());
        onATTransientPaidRegister();
    }

    /* renamed from: b */
    private void m10739b(BasicPayInfo basicPayInfo) {
        if (basicPayInfo.billBasic != null && basicPayInfo.billBasic.extra != null && basicPayInfo.billBasic.extra.containsKey(f14949b)) {
            HashMap hashMap = new HashMap();
            hashMap.put(getOrderId(), (String) basicPayInfo.billBasic.extra.get(f14949b));
            FormStore.getInstance().setPayedWay(hashMap);
        }
    }

    /* renamed from: c */
    private void m10741c(BasicPayInfo basicPayInfo) {
        if (basicPayInfo == null || basicPayInfo.billBasic == null) {
            GLog.m7968e(f14948a, "payInfo or payInfo.billBasic  ==null");
            return;
        }
        BasicBill basicBill = basicPayInfo.billBasic;
        ((IPayEntranceViewContainer) this.mView).setMode(Mode.CashPayed);
        setTotalFee(basicBill);
        if (!TextUtil.isEmpty(basicBill.billText)) {
            SpannableString spannableString = new SpannableString(basicBill.billText);
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, basicBill.billText.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.oc_color_666666)), 0, basicBill.billText.length(), 33);
            ((IPayEntranceViewContainer) this.mView).setMessage(spannableString);
        }
    }

    /* access modifiers changed from: protected */
    public void setMessage(BasicBill basicBill) {
        HashMap hashMap;
        if (basicBill != null && (hashMap = basicBill.extra) != null && hashMap.containsKey(f14950e)) {
            String str = (String) hashMap.get(f14950e);
            if (!TextUtil.isEmpty(str) && hashMap.containsKey(f14951f)) {
                if (1.0d == ((Double) hashMap.get(f14951f)).doubleValue()) {
                    ((IPayEntranceViewContainer) this.mView).setMessage(HighlightUtil.highlight(Const.joLeft + str + "}"));
                    return;
                }
                ((IPayEntranceViewContainer) this.mView).setMessage(str);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setMessage(BasicPayInfo basicPayInfo) {
        if (CarOrderHelper.getOrder() != null) {
            if (basicPayInfo == null || TextUtils.isEmpty(basicPayInfo.statusMsg)) {
                setMessage(basicPayInfo.billBasic);
            } else {
                ((IPayEntranceViewContainer) this.mView).setMessage(HighlightUtil.highlight(basicPayInfo.statusMsg));
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isCancelOrderPaid() {
        CarOrder order = CarOrderHelper.getOrder();
        return order != null && order.status == 6 && order.substatus == 6002;
    }

    /* access modifiers changed from: protected */
    public void setMessageForCancelOrderPaid(BasicPayInfo basicPayInfo) {
        if (CarOrderHelper.getOrder() != null && basicPayInfo != null && !TextUtils.isEmpty(basicPayInfo.statusMsg)) {
            ((IPayEntranceViewContainer) this.mView).setMessage(HighlightUtil.highlight(basicPayInfo.statusMsg));
        }
    }

    /* access modifiers changed from: protected */
    public boolean setCancelRule() {
        CarOrder order = CarOrderHelper.getOrder();
        boolean z = false;
        boolean z2 = BusinessDataUtil.isTripCanceled(order) && !BusinessDataUtil.isOrderClosedWithoutDriverService(order);
        if (!BusinessDataUtil.isTripCanceled(order) || !GlobalApolloUtil.usingCustomerServiceCardOnCancelOrder()) {
            z = z2;
        }
        ((IPayEntranceViewContainer) this.mView).setCancelRuleShow(z);
        return z;
    }

    /* access modifiers changed from: protected */
    public void setTotalFee(BasicBill basicBill) {
        String str = basicBill.leftDes;
        String str2 = basicBill.rightDes;
        String str3 = basicBill.need_pay_fee_text;
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            ((IPayEntranceViewContainer) this.mView).setPrice(str + str3 + str2);
            return;
        }
        String string = ResourcesHelper.getString(this.mContext, R.string.pe_car_noti_endservice_pay_pre);
        ((IPayEntranceViewContainer) this.mView).setPrice(string + ResourcesHelper.getString(this.mContext, R.string.pe_pay_value, str3));
    }

    /* access modifiers changed from: protected */
    public void addJumpable(BasicBill basicBill) {
        addJumpable(basicBill, false);
    }

    /* access modifiers changed from: protected */
    public void addJumpable(BasicBill basicBill, boolean z) {
        ActionType[] actionTypeArr = basicBill.actionTypes;
        if (actionTypeArr != null && actionTypeArr.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (ActionType actionType : actionTypeArr) {
                if (actionType != null && !TextUtil.isEmpty(actionType.name) && !m10734a(actionType.type, z) && (actionType.type != 3 || !GlobalApolloUtil.usingCustomerServiceCardOnCancelOrder())) {
                    arrayList.add(new JumpableItem(actionType.type, (CharSequence) new SpannableStringBuilder(actionType.name)));
                }
            }
            ((IPayEntranceViewContainer) this.mView).setJumpableItems(arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void addDeductions(BasicPayInfo basicPayInfo) {
        if (basicPayInfo != null && basicPayInfo.deductions != null) {
            CarOrder order = CarOrderHelper.getOrder();
            String str = (order == null || order.couponInfo == null) ? "" : order.couponInfo.couponText;
            String str2 = basicPayInfo.statusMsg;
            if (TextUtils.isEmpty(str2)) {
                str2 = str;
            }
            DeductionInfo[] deductionInfoArr = basicPayInfo.deductions;
            boolean z = false;
            for (DeductionInfo deductionInfo : deductionInfoArr) {
                if (deductionInfo != null) {
                    if (deductionInfo.type == 1) {
                        z = m10735a(deductionInfo, str2);
                    } else {
                        ((IPayEntranceViewContainer) this.mView).addSupplement(deductionInfo, str2);
                        z = true;
                    }
                }
            }
            if (!z && !TextUtils.isEmpty(str)) {
                ((IPayEntranceViewContainer) this.mView).addSupplement((DeductionInfo) null, str);
            }
        }
    }

    /* renamed from: a */
    private boolean m10735a(DeductionInfo deductionInfo, String str) {
        String format = UnipayTextUtil.format(deductionInfo.cost);
        if (TextUtil.isEmpty(deductionInfo.name)) {
            deductionInfo.name = ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_voucher_deduction);
        }
        boolean z = true;
        if (!TextUtil.isEmpty(deductionInfo.deduction)) {
            ((IPayEntranceViewContainer) this.mView).addSupplement(deductionInfo, str);
            return true;
        }
        int i = deductionInfo.status;
        if (i == 1) {
            deductionInfo.deduction = ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_voucher_deduction_value, format);
        } else if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    deductionInfo.deduction = ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_not_support_voucher);
                } else if (i != 5) {
                    deductionInfo.deduction = ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_no_voucher);
                } else {
                    deductionInfo.deduction = ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_voucher_deduction_value, format);
                }
            }
            z = false;
        } else {
            deductionInfo.deduction = ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_voucher_deduction_choose);
        }
        if (z) {
            ((IPayEntranceViewContainer) this.mView).addSupplement(deductionInfo, str);
        }
        return z;
    }

    /* renamed from: a */
    private String m10725a(int i) {
        ActionType[] actionTypeArr;
        BasicPayInfo basicPayInfo = this.mBasicPayInfo;
        if (basicPayInfo == null || basicPayInfo.billBasic == null || (actionTypeArr = this.mBasicPayInfo.billBasic.actionTypes) == null || actionTypeArr.length <= 0) {
            return "";
        }
        for (ActionType actionType : actionTypeArr) {
            if (actionType != null && actionType.type == i) {
                return actionType.url;
            }
        }
        return "";
    }

    /* renamed from: a */
    private void m10732a(String str) {
        PERedirectUtil.gotoWeb(GlobalWebUrl.buildWebViewModel(str));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            goPayPage();
        } else if (i == 102) {
            if (i2 != -1 || intent == null) {
                GlobalOmegaUtils.trackEvent("gp_confirmFare_return_ck");
            } else {
                refreshOrderBill();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isOnlineEnv() {
        return !PayCommonParamsUtil.getInstance().isTestNow();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10727a(int i, BasicPayInfo basicPayInfo) {
        CarOrder order;
        PayResultEvent payResultEvent = new PayResultEvent();
        payResultEvent.payResultStatus = i;
        if (basicPayInfo != null) {
            payResultEvent.payStatusTitle = basicPayInfo.payTitle;
            payResultEvent.payStatusSubTitle = basicPayInfo.payStatusSubtitle;
            payResultEvent.payStatusColor = basicPayInfo.payStatusColor;
            payResultEvent.payStatusLink = basicPayInfo.payStatusLink;
        }
        if (i == 10 && (order = CarOrderHelper.getOrder()) != null && order.getSubStatus() == 5001) {
            order.status = 3;
        }
        doPublish(BaseEventKeys.Service.EndService.EVENT_PAY_RESULT_GOT, payResultEvent);
        if (i == 10) {
            doPublish(BaseEventKeys.C4621IM.KEY_CATEGORY_IM_CLOSE_SESSION);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10745e() {
        if (getHost() != null && getHost().getActivity() != null) {
            getHost().getActivity().startActivity(new Intent(getHost().getActivity(), FareDetailsActivity.class));
            getHost().getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }
    }

    /* renamed from: f */
    private boolean m10747f() {
        CarOrder order = CarOrderHelper.getOrder();
        return order != null && (order.status == 3 || order.substatus == 6002);
    }

    /* access modifiers changed from: protected */
    public void handlePayWait(BasicPayInfo basicPayInfo) {
        if (basicPayInfo != null) {
            m10731a(basicPayInfo);
            startSyncPayResult();
        }
    }
}
