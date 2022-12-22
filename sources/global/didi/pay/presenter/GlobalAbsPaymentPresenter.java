package global.didi.pay.presenter;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.adyen.checkout.components.ActionComponentData;
import com.adyen.checkout.components.ComponentError;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didi.payment.creditcard.open.IGlobalCreditCardApi;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalCardExpireInterceptData;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.IDidiGlobalPayApi;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.unifiedPay.UnifiedPaySystem;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.manager.PayCache;
import com.didi.unifiedPay.component.model.BackKeyType;
import com.didi.unifiedPay.component.model.PayChannelItem;
import com.didi.unifiedPay.component.model.PayErrorEvent;
import com.didi.unifiedPay.component.model.PayItem;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.component.model.PayState;
import com.didi.unifiedPay.component.model.PayTypes;
import com.didi.unifiedPay.component.model.PlatformPayItem;
import com.didi.unifiedPay.component.presenter.AbsPaymentPresenter;
import com.didi.unifiedPay.component.presenter.PayInfoManager;
import com.didi.unifiedPay.component.view.DeductionItemType;
import com.didi.unifiedPay.component.view.IInstallmentView;
import com.didi.unifiedPay.component.view.IPayView;
import com.didi.unifiedPay.component.view.PayBtnState;
import com.didi.unifiedPay.component.view.VoucherViewConfig;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.internal.PayError;
import com.didi.unifiedPay.sdk.internal.PayServiceCallback;
import com.didi.unifiedPay.sdk.model.ActionType;
import com.didi.unifiedPay.sdk.model.BasicBill;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.didi.unifiedPay.sdk.model.DetailBill;
import com.didi.unifiedPay.sdk.model.ExternalPayChannel;
import com.didi.unifiedPay.sdk.model.InstallmentModel;
import com.didi.unifiedPay.sdk.model.InstallmentRecommendModel;
import com.didi.unifiedPay.sdk.model.InternalPayChannel;
import com.didi.unifiedPay.sdk.model.MerchantInfo;
import com.didi.unifiedPay.sdk.model.PasswordModel;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PayMethodGroup;
import com.didi.unifiedPay.sdk.model.PayParamObject;
import com.didi.unifiedPay.sdk.model.PayStatus;
import com.didi.unifiedPay.sdk.model.PaySuccessMessage;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.sdk.model.SubChannel;
import com.didi.unifiedPay.sdk.net.Error;
import com.didi.unifiedPay.util.ABTestProxyHolder;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.UiThreadHandler;
import com.didi.unifiedPay.util.UniPayParamUtil;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import com.taxis99.R;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.installment.InstallmentActivity;
import global.didi.pay.model.LoadingState;
import global.didi.pay.newview.pix.IPixView;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import global.didi.pay.omega.GlobalPayOmegaManager;
import global.didi.pay.select.activity.PayMethodSelectActivity;
import global.didi.pay.select.model.PayMethodGroupInfo;
import global.didi.pay.select.model.PayMethodItemInfo;
import global.didi.pay.select.model.PayMethodPageHeadInfo;
import global.didi.pay.select.model.PayMethodPageInfo;
import global.didi.pay.select.model.RequestPayEvent;
import global.didi.pay.threeds.ThreeDSFactory;
import global.didi.pay.threeds.contract.IAdyen3DS;
import global.didi.pay.threeds.contract.ICybs3DS;
import global.didi.pay.threeds.method.adyen.IAdyen3DSListener;
import global.didi.pay.threeds.method.cybs.ICybs3DSListener;
import global.didi.pay.threeds.model.Adyen3DSModel;
import global.didi.pay.threeds.model.AdyenActionComponentData;
import global.didi.pay.threeds.model.Cybs3DSModel;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;
import global.didi.pay.threeds.network.model.ThreedsError;
import global.didi.pay.view.dialog.UnifiedPayDialogConfig;
import global.didi.pay.view.dialog.password.GlobalPayPasswordDialog;
import global.didi.pay.web.UniPayFusionInitializer;
import global.didi.pay.web.UniPayWebModel;
import global.didi.pay.web.UniPayWebUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

public abstract class GlobalAbsPaymentPresenter extends AbsPaymentPresenter<IGlobalPayView> implements IInstallmentView.IInstallmentListener, IPayView.PayViewListener, IPixView.PixViewListener, IAdyen3DSListener, ICybs3DSListener {
    private static final int CHARGE_DISSENT_REQUEST_CODE = 12;
    public static final String KEY_RETURN_FROM_PAYVIEW = "KEY_RETURN_FROM_PAYVIEW";
    private static final int REQUEST_CODE_GOTOPAYTYPE = 81;
    private static final int REQUEST_CODE_INSTALLMENT = 94;
    private static final int REQUEST_CODE_PAY_BALOTO = 87;
    private static final int REQUEST_CODE_PAY_BANKTRANS = 91;
    private static final int REQUEST_CODE_PAY_BOLETO = 84;
    private static final int REQUEST_CODE_PAY_EFECTY = 88;
    private static final int REQUEST_CODE_PAY_FAST_BALOTO = 92;
    private static final int REQUEST_CODE_PAY_FAWRY = 93;
    private static final int REQUEST_CODE_PAY_OXXO = 85;
    private static final int REQUEST_CODE_PAY_PAGOFACIL = 89;
    private static final int REQUEST_CODE_PAY_RAPIPAGO = 90;
    private static final int REQUEST_CODE_PAY_SERVIPAG = 86;
    private static final int REQUEST_CODE_PAY_SPEI = 95;
    private static final int REQUEST_CODE_REAR_ENTERPRISE_NOTE = 11;
    private static final int REQUEST_CODE_SELECT_COUPON = 3;
    private static final int REQUEST_CODE_UPDATE_CARD = 82;
    private static final int REQUEST_CODE_VERIFY_BALANCE = 83;
    private static final int SYC_PAY_STATUS_INTERVAL = 1000;
    private static final String TAG = GlobalAbsPaymentPresenter.class.getSimpleName();
    protected IAdyen3DS mAdyen3DS;
    protected String mAppIdForOmega = "";
    /* access modifiers changed from: private */
    public String mChannel;
    protected ICybs3DS mCybs3DS;
    public FragmentActivity mFragmentActivity;
    protected FragmentManager mFragmentManager;
    private String mInstallmentNumber = "";
    private boolean mJumpToMethodListPage = false;
    private GlobalPayOmegaManager mOmegaManager;
    /* access modifiers changed from: private */
    public long mPixSyncStart = 0;
    protected String mSid;
    protected Adyen3DSModel mThreeDSModel;
    public IViewCallback mViewCallback;
    protected String mVoucherIdForOmega = "";
    /* access modifiers changed from: private */
    public boolean requestFromEvent;

    /* access modifiers changed from: protected */
    public String getVerifyScene() {
        return "CHECK_OUT_TRIP";
    }

    /* access modifiers changed from: protected */
    public void gotoCostObjectionActivity(PayInfo payInfo, int i) {
    }

    /* access modifiers changed from: protected */
    public boolean isSupportCostObjection() {
        return false;
    }

    public void itemClicked(int i, PlatformPayItem platformPayItem) {
    }

    public void onExpandAllThirdPayItemByUser() {
    }

    public void onPaySuccess() {
    }

    public void onPaySuccessMessageCreated(PaySuccessMessage paySuccessMessage) {
    }

    public void onPlatformItemSelectChange(int i, boolean z, PlatformPayItem platformPayItem, boolean z2) {
    }

    public void onShowQueryPayResultView() {
    }

    /* access modifiers changed from: protected */
    public void onStartPay() {
    }

    public void onThirdPartPayItemClicked(int i, PayItem payItem) {
    }

    /* access modifiers changed from: protected */
    public void onViewFilled() {
    }

    public void unSelectThirdPartItem(int i, PayChannelItem payChannelItem) {
    }

    public GlobalAbsPaymentPresenter(Context context, FragmentManager fragmentManager, String str, IViewCallback iViewCallback) {
        super(context, fragmentManager);
        this.mViewCallback = iViewCallback;
        this.mSid = str;
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        this.mFragmentActivity = fragmentActivity;
        this.mAdyen3DS = ThreeDSFactory.getAdyen3DS(fragmentActivity);
        UniPayFusionInitializer.exportUniPayWebBridge();
    }

    /* access modifiers changed from: protected */
    public String getProductId() {
        if (getCurPayInfo() == null) {
            return "";
        }
        return getCurPayInfo().cashier_product_id;
    }

    /* access modifiers changed from: protected */
    public PayInfo getCurPayInfo() {
        return PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId());
    }

    /* access modifiers changed from: protected */
    public PayStatus getCurPayStaus() {
        return PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayStatus(getOrderId());
    }

    /* access modifiers changed from: protected */
    public void requestPayInfoResult(boolean z, PayInfo payInfo, String str, int i) {
        if (z) {
            payInfoRequestSuccess(payInfo);
            if (this.requestFromEvent) {
                this.requestFromEvent = false;
                EventBus.getDefault().post(getPayMethodInfo(payInfo));
                return;
            }
            return;
        }
        showRetryView();
        payInfoRequestFailed(str);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        prepareData();
        this.mAdyen3DS.registerListener(this);
        ((IGlobalPayView) this.mView).setPixViewListener(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    public void onSuccess(ActionComponentData actionComponentData) {
        getOmegaManager().doOmegaForThreedsCallback(UniPayParamUtil.getUid(this.mContext), actionComponentData.getPaymentData(), "", "", 0);
        if (this.mThreeDSModel == null) {
            this.mViewCallback.closeView();
        } else {
            this.mUnifiedPaySystem.paymentThreeDSDetails(this.mThreeDSModel, new AdyenActionComponentData(actionComponentData), this.mThreeDSAdyenCallBack);
        }
    }

    public void onFailure(ComponentError componentError) {
        onPayFailed(new PayError(5), componentError.getErrorMessage());
        getOmegaManager().doOmegaForThreedsCallback(UniPayParamUtil.getUid(this.mContext), (String) null, componentError.getErrorMessage(), componentError.getErrorMessage(), 0);
    }

    public void onCancel() {
        onPayFailed(new PayError(5), this.mContext.getString(R.string.threeds_fail_message));
        getOmegaManager().doOmegaForThreedsCallback(UniPayParamUtil.getUid(this.mContext), (String) null, (String) null, (String) null, 1);
    }

    public void onSuccess(ThreedsCybsDataResponse threedsCybsDataResponse) {
        this.mUnifiedPaySystem.setCybs3DSData(threedsCybsDataResponse);
        doPay(getPayTypeObject());
    }

    public void onFailure(ThreedsError threedsError) {
        showErrorTitle(threedsError.getMessage());
    }

    /* access modifiers changed from: protected */
    public void initPayApi() {
        this.mUnifiedPaySystem = UnifiedPaySystem.createUnifiedPay(this.mContext, getPayBillType());
        this.mUnifiedPaySystem.init(getBid(), getOrderId(), this.mFragmentManager);
    }

    public void onCloseBtnClick() {
        if (!intercept()) {
            doClose();
        }
    }

    /* access modifiers changed from: protected */
    public void doClose() {
        IViewCallback iViewCallback;
        String lang = UniPayParamUtil.getLang();
        PayInfo payInfo = PayInfoManager.getInstance(lang).getPayInfo(getOrderId());
        if (payInfo != null && payInfo.payStatus == 2) {
            PayInfoManager.getInstance(lang).clearData();
        }
        if (this.mBundle != null) {
            this.mBundle.putBoolean("KEY_RETURN_FROM_PAYVIEW", true);
        }
        if (this.mCurrentState == PayState.ServiceNotUsable) {
            PayInfoManager.getInstance(lang).clearData();
        }
        if (!onClose() && (iViewCallback = this.mViewCallback) != null) {
            iViewCallback.closeView();
        }
    }

    private boolean intercept() {
        if (!((IGlobalPayView) this.mView).newUIType() || getCurPayInfo() == null || getCurPayInfo().eventInfo == null || !getCurPayInfo().eventInfo.intercept()) {
            return false;
        }
        UnifiedPayDialogConfig unifiedPayDialogConfig = UnifiedPayDialogConfig.TIP_CONFIRM;
        if (!TextUtils.isEmpty(getCurPayInfo().eventInfo.getCancelPayTitle())) {
            unifiedPayDialogConfig.setContent(getCurPayInfo().eventInfo.getCancelPayTitle());
        }
        if (!TextUtils.isEmpty(getCurPayInfo().eventInfo.getCancelPaySubtitle())) {
            unifiedPayDialogConfig.setSubContent(getCurPayInfo().eventInfo.getCancelPaySubtitle());
        }
        ((IGlobalPayView) this.mView).showConfirmDialog(unifiedPayDialogConfig, new IGlobalPayView.DialogConfirmListener() {
            public void onCancel() {
                GlobalAbsPaymentPresenter.this.onInterceptCancel();
            }

            public void onConfirm() {
                GlobalAbsPaymentPresenter.this.onInterceptConfirm();
            }
        });
        return true;
    }

    /* access modifiers changed from: protected */
    public void onInterceptConfirm() {
        doClose();
    }

    /* access modifiers changed from: protected */
    public void onInterceptCancel() {
        if (getCurPayInfo() == null) {
            showRetryView();
        } else {
            ((IGlobalPayView) this.mView).onPayInfoLoadComplete(IPayView.TYPE_MAIN);
        }
    }

    public void onClosePixBtnClick() {
        getOmegaManager().doOmegaForPixPrepay(GlobalPayOmegaConstant.EventId.ibt_gp_cashier_waitpix_exit_ck, (String) null, "cashier", (String) null);
        this.mUnifiedPaySystem.cancelSyncPayResult();
    }

    /* access modifiers changed from: protected */
    public boolean onClose() {
        getOmegaManager().doOmegaForClose(getPayMethod(), this.mVoucherIdForOmega, getPayBillType() == PayConstant.PayBillType.Merchant ? "3rd merchant" : null);
        PayErrorEvent isShowErrorView = ((IGlobalPayView) this.mView).isShowErrorView();
        if (isShowErrorView == null || isShowErrorView.errorCode == 0) {
            return false;
        }
        EventBus.getDefault().post(isShowErrorView);
        return true;
    }

    /* access modifiers changed from: protected */
    public int transRequestCode(int i) {
        IViewCallback iViewCallback = this.mViewCallback;
        if (iViewCallback != null) {
            return iViewCallback.requestCode(i);
        }
        return super.transRequestCode(i);
    }

    /* access modifiers changed from: protected */
    public void prepareData() {
        getPayInfo();
    }

    public void onDeductionItemClick(VoucherViewConfig voucherViewConfig) {
        DeductionInfo voucherInfo;
        if (voucherViewConfig.deductionType == DeductionItemType.TYPE_VOUCHER && (voucherInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getVoucherInfo(getOrderId())) != null && !TextUtil.isEmpty(voucherInfo.url)) {
            UniPayWebModel uniPayWebModel = new UniPayWebModel();
            uniPayWebModel.context = this.mContext;
            uniPayWebModel.url = voucherInfo.url;
            uniPayWebModel.sid = this.mSid;
            uniPayWebModel.requestCode = 3;
            uniPayWebModel.intentFlag = View.NAVIGATION_BAR_UNHIDE;
            uniPayWebModel.contentType = 1;
            UniPayWebUtil.startWebPage(uniPayWebModel, this.mViewCallback);
            getOmegaManager().doOmegaForChangecoupon(getPayMethod(), this.mVoucherIdForOmega);
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        IViewCallback iViewCallback = this.mViewCallback;
        if (iViewCallback != null) {
            iViewCallback.callStartActivityForResult(intent, i);
        }
    }

    public void onPayButtonClick() {
        if (isSupportPay()) {
            if (GlobalOffLinePaymentHelper.needSecondConfirm(getOrderId())) {
                GlobalOffLinePaymentHelper.gotoConfirmPayActivity(this.mContext, getPayBillType(), getOrderId(), getBid());
            } else {
                doPay(getPayTypeObject());
            }
        }
    }

    public void onRemove() {
        super.onRemove();
        this.mViewCallback = null;
        UiThreadHandler.removeCallbacks((Runnable) null);
        this.mAdyen3DS.unregisterListener();
        ICybs3DS iCybs3DS = this.mCybs3DS;
        if (iCybs3DS != null) {
            iCybs3DS.unregisterListener();
            this.mCybs3DS = null;
        }
        if (this.mUnifiedPaySystem != null) {
            this.mUnifiedPaySystem.onDestroy();
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    public void onDateClean() {
        super.onDateClean();
        PayInfoManager.getInstance(UniPayParamUtil.getLang()).clearData();
    }

    public void onPageResume() {
        LogUtil.m31684d(TAG, "onPageResume");
        ((IGlobalPayView) this.mView).resetViewClickable();
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId());
        if (payInfo != null && payInfo.billDetail != null && payInfo.billDetail.payEnable == 0) {
            updatePayBtnView(payInfo.billDetail.payBtnTitle, false);
        }
    }

    public void onPageStop() {
        LogUtil.m31684d(TAG, "onPageStop");
    }

    public void onShowFeeDetailClick() {
        ActionType[] actionTypeArr;
        getOmegaManager().doOmegaForFeeDetailClick(getPayMethod(), this.mVoucherIdForOmega);
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId());
        if (payInfo != null && payInfo.billBasic != null && (actionTypeArr = payInfo.billBasic.actionTypes) != null) {
            int i = 0;
            while (i < actionTypeArr.length) {
                ActionType actionType = actionTypeArr[i];
                if (actionType == null || TextUtil.isEmpty(actionType.url)) {
                    i++;
                } else {
                    UniPayWebModel uniPayWebModel = new UniPayWebModel();
                    uniPayWebModel.context = this.mContext;
                    uniPayWebModel.url = actionType.url;
                    uniPayWebModel.sid = this.mSid;
                    uniPayWebModel.intentFlag = 268435456;
                    UniPayWebUtil.startWebPage(uniPayWebModel, this.mViewCallback);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public PayStatus getCurPayStatus() {
        return PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayStatus(getOrderId());
    }

    /* access modifiers changed from: protected */
    public void onPaySuccessed(int i, String str) {
        if (this.mCurrentState == PayState.PaySuccess) {
            LogUtil.m31685fi(TAG, "currentState is PaySuccess,return ");
            return;
        }
        this.mCurrentState = PayState.PaySuccess;
        if (!GlobalOffLinePaymentHelper.needJumpOfflineWebPage(getOrderId())) {
            showSuccessDialog(str);
        }
        onDateClean();
        buildSuccessMessage();
    }

    /* access modifiers changed from: protected */
    public void onAdyenThreeDSAction(Adyen3DSModel adyen3DSModel) {
        if (adyen3DSModel != null && adyen3DSModel.action != null) {
            getOmegaManager().doOmegaForThreedsCall(UniPayParamUtil.getUid(this.mContext), (String) adyen3DSModel.action.get("type"));
            this.mAdyen3DS.handleAction(new JSONObject(adyen3DSModel.action));
            this.mThreeDSModel = adyen3DSModel;
        }
    }

    /* access modifiers changed from: protected */
    public void onCybsThreeDSAction(Cybs3DSModel cybs3DSModel) {
        if (cybs3DSModel != null && !cybs3DSModel.sessionId.isEmpty()) {
            if (this.mCybs3DS == null) {
                ICybs3DS cybs3DS = ThreeDSFactory.getCybs3DS(this.mFragmentActivity);
                this.mCybs3DS = cybs3DS;
                cybs3DS.registerListener(this);
                HashMap hashMap = new HashMap();
                hashMap.put("uid", UniPayParamUtil.getUid(this.mContext));
                hashMap.put("scene", "trade");
                hashMap.put("order_id", getOrderId());
                this.mCybs3DS.updateOmegaAttr(hashMap);
            }
            ICybs3DS iCybs3DS = this.mCybs3DS;
            if (iCybs3DS != null) {
                iCybs3DS.handleModel(cybs3DSModel);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPasswordModel(PasswordModel passwordModel) {
        if (passwordModel == null || passwordModel.getSet() == null || passwordModel.getPaySessionId() == null) {
            onPayFailed(new PayError(5), this.mContext.getString(R.string.pay_fail));
            return;
        }
        ServiceLoader<S> load = ServiceLoader.load(OpenCertificationListener.class);
        if (load.iterator().hasNext()) {
            final OpenCertificationListener openCertificationListener = (OpenCertificationListener) load.iterator().next();
            if (passwordModel.getSet().intValue() == 1) {
                if (getCurPayInfo() == null || getCurPayInfo().billBasic == null) {
                    onPayFailed(new PayError(5), this.mContext.getString(R.string.pay_fail));
                } else {
                    PaySecure.INSTANCE.verifyPayPassword(getVerifyScene(), passwordModel.getPaySessionId(), getCurPayInfo().billBasic.needPayFeeTextDisplay, new PayPwdResultListener() {
                        public void onSuccess(String str) {
                            GlobalAbsPaymentPresenter.this.mUnifiedPaySystem.setPassword(str);
                            GlobalAbsPaymentPresenter globalAbsPaymentPresenter = GlobalAbsPaymentPresenter.this;
                            globalAbsPaymentPresenter.doPay(globalAbsPaymentPresenter.getPayTypeObject());
                        }

                        public void onFailure(String str, String str2) {
                            String str3 = GlobalAbsPaymentPresenter.this.getCurPayInfo().pay_title;
                            ((IGlobalPayView) GlobalAbsPaymentPresenter.this.mView).setTitle(true, str3, str + " " + str2);
                            ((IGlobalPayView) GlobalAbsPaymentPresenter.this.mView).onPayInfoLoadComplete(IPayView.TYPE_MAIN);
                        }
                    }, openCertificationListener);
                }
            } else if (passwordModel.getSet().intValue() == 0) {
                GlobalPayPasswordDialog createDialog = GlobalPayPasswordDialog.createDialog(this.mFragmentActivity);
                createDialog.setConfig(UnifiedPayDialogConfig.TIP_PASSWORD);
                createDialog.setListener(new IGlobalPayView.DialogConfirmListener() {
                    public void onCancel() {
                        ((IGlobalPayView) GlobalAbsPaymentPresenter.this.mView).onPayInfoLoadComplete(IPayView.TYPE_MAIN);
                    }

                    public void onConfirm() {
                        PaySecure.INSTANCE.createPayPassword("CHECK_OUT_SETTING", openCertificationListener, new SetPwdResultListener() {
                            public void onSuccess(String str) {
                                GlobalAbsPaymentPresenter.this.mUnifiedPaySystem.setPassword(str);
                                GlobalAbsPaymentPresenter.this.doPay(GlobalAbsPaymentPresenter.this.getPayTypeObject());
                            }

                            public void onFailure(String str, String str2) {
                                if (GlobalAbsPaymentPresenter.this.getCurPayInfo() != null) {
                                    ((IGlobalPayView) GlobalAbsPaymentPresenter.this.mView).setTitle(true, GlobalAbsPaymentPresenter.this.getCurPayInfo().pay_title, str);
                                    ((IGlobalPayView) GlobalAbsPaymentPresenter.this.mView).onPayInfoLoadComplete(IPayView.TYPE_MAIN);
                                    return;
                                }
                                GlobalAbsPaymentPresenter.this.mViewCallback.closeView();
                            }
                        });
                    }
                });
                SystemUtils.showDialog(createDialog);
            }
        }
    }

    private void buildSuccessMessage() {
        if (getCurPayInfo() != null) {
            PaySuccessMessage paySuccessMessage = new PaySuccessMessage();
            if (getCurPayInfo().billBasic != null) {
                BasicBill basicBill = getCurPayInfo().billBasic;
                paySuccessMessage.totalFee = basicBill.totalFee;
                paySuccessMessage.shouldPayFee = basicBill.shouldPayFee;
            }
            if (getCurPayInfo().billDetail != null && getCurPayInfo().billDetail.deductions != null) {
                DeductionInfo[] deductionInfoArr = getCurPayInfo().billDetail.deductions;
                int length = deductionInfoArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    DeductionInfo deductionInfo = deductionInfoArr[i];
                    if (deductionInfo.type != 1) {
                        i++;
                    } else if (deductionInfo.status == 1 || deductionInfo.status == 5) {
                        paySuccessMessage.voucherValue = deductionInfo.cost;
                    }
                }
            }
            onPaySuccessMessageCreated(paySuccessMessage);
        }
    }

    /* access modifiers changed from: protected */
    public void onQueryResult(boolean z, LoadingState loadingState, int i) {
        queryPayResult(false, loadingState, i);
        if (z) {
            this.mOmegaManager.doOmegaForWaitResult(getOrderId(), getPayMethod());
        }
    }

    /* access modifiers changed from: protected */
    public void onPrePayFailed(int i, String str) {
        if (i == 11) {
            ((IGlobalPayView) this.mView).resetViewClickable();
        }
        showErrorTitle(str);
    }

    /* access modifiers changed from: protected */
    public void onPrePaySuccessed(PrepayInfo prepayInfo) {
        int i = prepayInfo.pay_channel;
        if (i != 175) {
            if (i != 178) {
                switch (i) {
                    case 200:
                        if (prepayInfo == null || TextUtils.isEmpty(prepayInfo.offline_pay_params)) {
                            onPayFailed(new PayError(5), "");
                            return;
                        }
                        GlobalOffLinePaymentHelper.startOfflinePage(this.mContext, GlobalOffLinePaymentHelper.getOfflinePayH5Url(prepayInfo.offline_pay_params), this.mSid, 86, this.mViewCallback);
                        onPaySuccessed(5, "");
                        return;
                    case 201:
                        if (prepayInfo == null || TextUtils.isEmpty(prepayInfo.offline_pay_params)) {
                            onPayFailed(new PayError(5), "");
                            return;
                        }
                        GlobalOffLinePaymentHelper.startOfflinePage(this.mContext, GlobalOffLinePaymentHelper.getOfflinePayH5Url(prepayInfo.offline_pay_params), this.mSid, 87, this.mViewCallback);
                        onPaySuccessed(5, "");
                        return;
                    case 202:
                        if (prepayInfo == null || TextUtils.isEmpty(prepayInfo.offline_pay_params)) {
                            onPayFailed(new PayError(5), "");
                            return;
                        }
                        GlobalOffLinePaymentHelper.startOfflinePage(this.mContext, GlobalOffLinePaymentHelper.getOfflinePayH5Url(prepayInfo.offline_pay_params), this.mSid, 88, this.mViewCallback);
                        onPaySuccessed(5, "");
                        return;
                    case 203:
                        if (prepayInfo == null || TextUtils.isEmpty(prepayInfo.offline_pay_params)) {
                            onPayFailed(new PayError(5), "");
                            return;
                        }
                        GlobalOffLinePaymentHelper.startOfflinePage(this.mContext, GlobalOffLinePaymentHelper.getOfflinePayH5Url(prepayInfo.offline_pay_params), this.mSid, 90, this.mViewCallback);
                        onPaySuccessed(5, "");
                        return;
                    case 204:
                        if (prepayInfo == null || TextUtils.isEmpty(prepayInfo.offline_pay_params)) {
                            onPayFailed(new PayError(5), "");
                            return;
                        }
                        GlobalOffLinePaymentHelper.startOfflinePage(this.mContext, GlobalOffLinePaymentHelper.getOfflinePayH5Url(prepayInfo.offline_pay_params), this.mSid, 89, this.mViewCallback);
                        onPaySuccessed(5, "");
                        return;
                    case 205:
                        if (prepayInfo == null || TextUtils.isEmpty(prepayInfo.offline_pay_params)) {
                            onPayFailed(new PayError(5), "");
                            return;
                        }
                        GlobalOffLinePaymentHelper.startOfflinePage(this.mContext, GlobalOffLinePaymentHelper.getOfflinePayH5Url(prepayInfo.offline_pay_params), this.mSid, 91, this.mViewCallback);
                        onPaySuccessed(5, "");
                        return;
                    default:
                        switch (i) {
                            case 213:
                                if (prepayInfo == null || TextUtils.isEmpty(prepayInfo.offline_pay_params)) {
                                    onPayFailed(new PayError(5), "");
                                    return;
                                }
                                GlobalOffLinePaymentHelper.startOfflinePage(this.mContext, GlobalOffLinePaymentHelper.getOfflinePayH5Url(prepayInfo.offline_pay_params), this.mSid, 93, this.mViewCallback);
                                onPaySuccessed(5, "");
                                return;
                            case 214:
                                if (prepayInfo == null || TextUtils.isEmpty(prepayInfo.offline_pay_params)) {
                                    onPayFailed(new PayError(5), "");
                                    return;
                                }
                                GlobalOffLinePaymentHelper.startOfflinePage(this.mContext, GlobalOffLinePaymentHelper.getOfflinePayH5Url(prepayInfo.offline_pay_params), this.mSid, 92, this.mViewCallback);
                                onPaySuccessed(5, "");
                                return;
                            case 215:
                                if (prepayInfo == null || TextUtils.isEmpty(prepayInfo.offline_pay_params)) {
                                    onPayFailed(new PayError(5), "");
                                    return;
                                }
                                GlobalOffLinePaymentHelper.startOfflinePage(this.mContext, GlobalOffLinePaymentHelper.getOfflinePayH5Url(prepayInfo.offline_pay_params), this.mSid, 95, this.mViewCallback);
                                onPaySuccessed(5, "");
                                return;
                            default:
                                onPayFailed(new PayError(5), "");
                                return;
                        }
                }
            } else if (prepayInfo == null || TextUtils.isEmpty(prepayInfo.offline_pay_params)) {
                onPayFailed(new PayError(5), "");
            } else {
                GlobalOffLinePaymentHelper.startOfflinePage(this.mContext, GlobalOffLinePaymentHelper.getOfflinePayH5Url(prepayInfo.offline_pay_params), this.mSid, 84, this.mViewCallback);
                onPaySuccessed(5, "");
            }
        } else if (prepayInfo == null || TextUtils.isEmpty(prepayInfo.offline_pay_params)) {
            onPayFailed(new PayError(5), "");
        } else {
            GlobalOffLinePaymentHelper.startOfflinePage(this.mContext, GlobalOffLinePaymentHelper.getOfflinePayH5Url(prepayInfo.offline_pay_params), this.mSid, 85, this.mViewCallback);
            onPaySuccessed(5, "");
        }
    }

    /* access modifiers changed from: protected */
    public void onPayFailed(PayError payError, String str) {
        if (isOptimize() && payError.errorCode == 5) {
            this.mJumpToMethodListPage = true;
            changePayInfo(7);
        } else if (!TextUtils.equals(getPixType(), "pix_prepay_page")) {
            ((IGlobalPayView) this.mView).resetViewClickable();
            if (payError.errorCode == 6) {
                showErrorTitle(str, false);
            } else {
                showErrorTitle(str);
            }
        } else if (getCurPayInfo() == null || getCurPayInfo().billDetail == null) {
            this.mViewCallback.closeView();
        } else {
            ((IGlobalPayView) this.mView).updatePix(getCurPayInfo().billDetail.pixCode, IPixView.PAGE_STATUS_PAID);
            ((IGlobalPayView) this.mView).onPayInfoLoadComplete("pix_prepay_page");
        }
    }

    /* access modifiers changed from: private */
    public void handlePayInfo(PayInfo payInfo) {
        String str;
        int i = payInfo.payStatus;
        if (i == 0) {
            showErrorTitle("");
            showRetryView();
        } else if (i == 1) {
            setupView(payInfo);
        } else if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    setupView(payInfo);
                    if (!PayCache.getInstance().isLastPayFailShow(getOrderId()) && !TextUtil.isEmpty(payInfo.statusMsg)) {
                        PayCache.getInstance().setLastPayFailShowed(getOrderId());
                        showErrorTitle(payInfo.statusMsg);
                    }
                } else if (i != 5) {
                    if (i == 7) {
                        setupView(payInfo);
                        if (TextUtils.isEmpty(payInfo.statusMsg)) {
                            str = this.mContext.getResources().getString(R.string.oc_pay_closed);
                        } else {
                            str = payInfo.statusMsg;
                        }
                        showErrorTitle(str, false);
                    }
                }
            }
            onPaySuccessed(payInfo.payStatus, payInfo.statusMsg);
        } else {
            setupView(payInfo);
            onNoPwdPay();
        }
        onViewFilled();
        jumpToMethodListPage();
    }

    public void jumpToMethodListPage() {
        if (isOptimize() && this.mJumpToMethodListPage) {
            gotoPayMethodActivity(getPayBillType() == PayConstant.PayBillType.Merchant ? 2 : 1);
        }
        this.mJumpToMethodListPage = false;
    }

    private void payInfoRequestSuccess(PayInfo payInfo) {
        String str = TAG;
        LogUtil.m31684d(str, "mPayinfoCallback onSuccess payInfo:" + payInfo);
        PayInfoManager.getInstance(UniPayParamUtil.getLang()).setPayInfo(getOrderId(), payInfo);
        this.mAppIdForOmega = payInfo.appId;
        if (!TextUtils.isEmpty(payInfo.oid)) {
            getOmegaManager().updateOid(payInfo.oid, payInfo.outTradeId);
        }
        if (isSupportCostObjection() && hasChargeDissent(payInfo)) {
            payInfo.objectionInfo.productId = getBid();
            gotoCostObjectionActivity(payInfo, 12);
        } else if (payInfo == null || payInfo.billDetail == null || !TextUtils.equals(getPixType(), "pix_prepay_page") || payInfo.billDetail.holdOnFlag != 1 || !TextUtils.isEmpty(payInfo.billDetail.pixCode)) {
            if (this.mCurrentState != PayState.PaySuccess) {
                handlePayInfo(payInfo);
                hideLoadingDialog();
            }
        } else if (!this.mUnifiedPaySystem.syncPayInfo()) {
            onPixPrePayTimeout();
        }
    }

    private void payInfoRequestFailed(String str) {
        String str2 = TAG;
        LogUtil.m31684d(str2, "mPayinfoCallback onFail error:" + str);
        PayInfoManager.getInstance(UniPayParamUtil.getLang()).clearPayInfo();
        showErrorTitle(str);
    }

    private boolean hasChargeDissent(PayInfo payInfo) {
        if (3 == payInfo.payStatus || payInfo.objectionInfo == null || payInfo.objectionInfo.pageInfo == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void changeVoucher(String str) {
        showLoadingDialog(LoadingState.TYPE_REFRESHING.type);
        this.mUnifiedPaySystem.changeCoupon(str);
        this.mUnifiedPaySystem.changePayInfo(2, this.mPayinfoCallback);
        this.mVoucherIdForOmega = str;
    }

    /* access modifiers changed from: protected */
    public void changeInstallmentNumber(String str) {
        this.mInstallmentNumber = str;
        this.mUnifiedPaySystem.changeInstallmentNumber(str);
    }

    /* access modifiers changed from: protected */
    public void setupView(PayInfo payInfo) {
        if (payInfo == null || payInfo.billBasic == null || payInfo.billDetail == null) {
            LogUtil.m31684d(TAG, "payinfo  is null,return");
            return;
        }
        showCorrectTitle(payInfo.pay_title, payInfo.statusMsg);
        PayInfoManager.getInstance(UniPayParamUtil.getLang()).setPayInfo(getOrderId(), payInfo);
        BasicBill basicBill = payInfo.billBasic;
        DetailBill detailBill = payInfo.billDetail;
        setTotalFee(basicBill);
        updateMerchantView(detailBill.merchantInfo);
        updateDeductionView(detailBill.deductions);
        updateBalanceView(detailBill.internalChannels);
        updatePayMethodView(detailBill);
        updateInstallmentView(payInfo.installmentModel);
        updateInstallmentRecommend(payInfo.recommendModel);
        ((IGlobalPayView) this.mView).updatePix(detailBill.pixCode, IPixView.PAGE_STATUS_INIT);
        boolean z = true;
        ((IGlobalPayView) this.mView).setCancelableForThirdPay(true);
        ((IGlobalPayView) this.mView).updateBillAmount(basicBill);
        ((IGlobalPayView) this.mView).updateTransactionFee(basicBill.getTransactionFee());
        String str = detailBill.payBtnTitle;
        if (detailBill.payEnable <= 0) {
            z = false;
        }
        updatePayBtnView(str, z);
        if (TextUtils.equals("pix_prepay_page", getPixType())) {
            if (!TextUtils.isEmpty(detailBill.pixCode)) {
                getOmegaManager().doOmegaForPixPrepay(GlobalPayOmegaConstant.EventId.ibt_gp_pixpay_page_sw, (String) null, "pixpay_page", (String) null);
                ((IGlobalPayView) this.mView).onPayInfoLoadComplete("pix_prepay_page");
                return;
            }
            onPixPrePayTimeout();
        } else if (!TextUtils.equals("pix_page", getPixType())) {
        } else {
            if (!TextUtils.isEmpty(detailBill.pixCode)) {
                ((IGlobalPayView) this.mView).onPayInfoLoadComplete("pix_page");
                getOmegaManager().doOmegaForPixShow(UniPayParamUtil.getUid(this.mContext));
                return;
            }
            ((IGlobalPayView) this.mView).onPayInfoLoadComplete(IPayView.TYPE_MAIN);
        }
    }

    public void onPixCancel(boolean z) {
        if (TextUtils.equals(getPixType(), "pix_page")) {
            ((IGlobalPayView) this.mView).onPayInfoLoadComplete(IPayView.TYPE_MAIN);
            if (getCurPayInfo() != null) {
                showCorrectTitle(getCurPayInfo().pay_title, getCurPayInfo().statusMsg);
            } else {
                IViewCallback iViewCallback = this.mViewCallback;
                if (iViewCallback != null) {
                    iViewCallback.closeView();
                }
            }
            getOmegaManager().doOmegaForPixCancel(UniPayParamUtil.getUid(this.mContext));
        } else if (TextUtils.equals(getPixType(), "pix_prepay_page")) {
            if (z) {
                getOmegaManager().doOmegaForPixPrepay(GlobalPayOmegaConstant.EventId.ibt_gp_pixpay_page_pix_ck, "1", "pixpay_page", (String) null);
            } else {
                getOmegaManager().doOmegaForPixPrepay(GlobalPayOmegaConstant.EventId.ibt_gp_cashier_noresult_cancel_ck, (String) null, "cashier", (String) null);
            }
            IViewCallback iViewCallback2 = this.mViewCallback;
            if (iViewCallback2 != null) {
                iViewCallback2.closeView();
            }
        }
    }

    public void onPixConfirm(boolean z) {
        if (!TextUtils.isEmpty(((IGlobalPayView) this.mView).getPixCode())) {
            FragmentActivity fragmentActivity = this.mFragmentActivity;
            ToastHelper.showShortInfo((Context) fragmentActivity, fragmentActivity.getString(R.string.GRider_payment_Copy_successfully_Lycd), (int) R.drawable.g_icon_payment_success);
            doClip(((IGlobalPayView) this.mView).getPixCode());
            getOmegaManager().doOmegaForPixConfirm(UniPayParamUtil.getUid(this.mContext));
            if (TextUtils.equals("pix_prepay_page", getPixType())) {
                if (z) {
                    getOmegaManager().doOmegaForPixPrepay(GlobalPayOmegaConstant.EventId.ibt_gp_pixpay_page_pix_ck, "2", "pixpay_page", (String) null);
                }
                getOmegaManager().doOmegaForPixPrepay(GlobalPayOmegaConstant.EventId.IBT_GP_CASHIER_WAITPIX_SW, (String) null, "cashier", (String) null);
            }
            syncPixPayStatus(LoadingState.TYPE_PIX, 3000, TextUtils.equals(getPixType(), "pix_prepay_page"));
        }
    }

    public void onPixPaid(boolean z) {
        if (!TextUtils.isEmpty(((IGlobalPayView) this.mView).getPixCode())) {
            if (TextUtils.equals("pix_prepay_page", getPixType()) && !z) {
                getOmegaManager().doOmegaForPixPrepay(GlobalPayOmegaConstant.EventId.ibt_gp_cashier_noresult_retry_ck, (String) null, "cashier", (String) null);
            }
            syncPixPayStatus(LoadingState.TYPE_WAITING, 0, TextUtils.equals(getPixType(), "pix_prepay_page"));
            getOmegaManager().doOmegaForPixPay(UniPayParamUtil.getUid(this.mContext));
        }
    }

    /* access modifiers changed from: protected */
    public void onPixPrePayTimeout() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("code", 4);
        intent.putExtras(bundle);
        FragmentActivity fragmentActivity = this.mFragmentActivity;
        if (fragmentActivity != null) {
            fragmentActivity.setResult(-1, intent);
            this.mFragmentActivity.finish();
        }
    }

    public void onPixChange(boolean z) {
        getOmegaManager().doOmegaForPixPrepay(GlobalPayOmegaConstant.EventId.ibt_gp_pixpay_page_pix_ck, "3", "pixpay_page", (String) null);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("code", 5);
        intent.putExtras(bundle);
        FragmentActivity fragmentActivity = this.mFragmentActivity;
        if (fragmentActivity != null) {
            fragmentActivity.setResult(-1, intent);
            this.mFragmentActivity.finish();
        }
    }

    private void syncPixPayStatus(final LoadingState loadingState, long j, final boolean z) {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                long unused = GlobalAbsPaymentPresenter.this.mPixSyncStart = System.currentTimeMillis();
                ((IGlobalPayView) GlobalAbsPaymentPresenter.this.mView).showLoadingView("", true, loadingState.type, z ? 1 : 0);
                GlobalAbsPaymentPresenter.this.mUnifiedPaySystem.doPixPay(GlobalAbsPaymentPresenter.this.mFragmentActivity, GlobalAbsPaymentPresenter.this.mPayCallback, loadingState, z ? 1 : 0);
            }
        }, j);
    }

    private void doClip(String str) {
        ((ClipboardManager) this.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Label", str));
    }

    /* access modifiers changed from: protected */
    public void onPixCode(String str) {
        if (TextUtils.equals("pix_prepay_page", getPixType())) {
            getOmegaManager().doOmegaForPixPrepay(GlobalPayOmegaConstant.EventId.ibt_gp_cashier_waitpix_time_sw, (String) null, "cashier", String.valueOf(System.currentTimeMillis() - this.mPixSyncStart));
            getOmegaManager().doOmegaForPixPrepay(GlobalPayOmegaConstant.EventId.ibt_gp_cashier_noresult_sw, (String) null, "cashier", (String) null);
        }
        ((IGlobalPayView) this.mView).updatePix(str, !TextUtils.isEmpty(str) ? IPixView.PAGE_STATUS_INIT : IPixView.PAGE_STATUS_PAID);
        ((IGlobalPayView) this.mView).onPayInfoLoadComplete(getPixType());
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateVoucherView(com.didi.unifiedPay.sdk.model.DeductionInfo r7) {
        /*
            r6 = this;
            long r0 = r7.cost
            java.lang.String r0 = com.didi.unifiedPay.util.UnipayTextUtil.format(r0)
            java.lang.String r1 = r7.name
            boolean r1 = com.didi.sdk.util.TextUtil.isEmpty(r1)
            if (r1 == 0) goto L_0x0019
            android.content.Context r1 = r6.mContext
            r2 = 2131956523(0x7f13132b, float:1.9549604E38)
            java.lang.String r1 = com.didi.sdk.util.ResourcesHelper.getString(r1, r2)
            r7.name = r1
        L_0x0019:
            int r1 = r7.status
            r2 = 2131956525(0x7f13132d, float:1.9549608E38)
            r3 = 1
            if (r1 == r3) goto L_0x0066
            r4 = 2
            if (r1 == r4) goto L_0x0049
            r4 = 5
            if (r1 == r4) goto L_0x0029
            r7 = 0
            goto L_0x007f
        L_0x0029:
            com.didi.unifiedPay.component.view.VoucherViewConfig r1 = new com.didi.unifiedPay.component.view.VoucherViewConfig
            java.lang.String r4 = r7.name
            java.lang.String r5 = r7.deduction
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0038
            java.lang.String r7 = r7.deduction
            goto L_0x003e
        L_0x0038:
            android.content.Context r7 = r6.mContext
            java.lang.String r7 = com.didi.sdk.util.ResourcesHelper.getString(r7, r2, r0)
        L_0x003e:
            r1.<init>(r4, r7, r3)
            r7 = 0
            r1.setCanClick(r7)
            r1.showRightIcon(r7)
            goto L_0x007e
        L_0x0049:
            com.didi.unifiedPay.component.view.VoucherViewConfig r0 = new com.didi.unifiedPay.component.view.VoucherViewConfig
            java.lang.String r1 = r7.name
            java.lang.String r2 = r7.deduction
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0058
            java.lang.String r7 = r7.deduction
            goto L_0x0061
        L_0x0058:
            android.content.Context r7 = r6.mContext
            r2 = 2131956524(0x7f13132c, float:1.9549606E38)
            java.lang.String r7 = com.didi.sdk.util.ResourcesHelper.getString(r7, r2)
        L_0x0061:
            r0.<init>(r1, r7, r3)
            r7 = r0
            goto L_0x007f
        L_0x0066:
            com.didi.unifiedPay.component.view.VoucherViewConfig r1 = new com.didi.unifiedPay.component.view.VoucherViewConfig
            java.lang.String r4 = r7.name
            java.lang.String r5 = r7.deduction
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0075
            java.lang.String r7 = r7.deduction
            goto L_0x007b
        L_0x0075:
            android.content.Context r7 = r6.mContext
            java.lang.String r7 = com.didi.sdk.util.ResourcesHelper.getString(r7, r2, r0)
        L_0x007b:
            r1.<init>(r4, r7, r3)
        L_0x007e:
            r7 = r1
        L_0x007f:
            if (r7 != 0) goto L_0x0082
            return
        L_0x0082:
            com.didi.unifiedPay.component.view.DeductionItemType r0 = com.didi.unifiedPay.component.view.DeductionItemType.TYPE_VOUCHER
            r7.deductionType = r0
            com.didi.unifiedPay.component.view.IView r0 = r6.mView
            global.didi.pay.IGlobalPayView r0 = (global.didi.pay.IGlobalPayView) r0
            r0.addDeductionItem(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.presenter.GlobalAbsPaymentPresenter.updateVoucherView(com.didi.unifiedPay.sdk.model.DeductionInfo):void");
    }

    /* access modifiers changed from: protected */
    public void setTotalFee(BasicBill basicBill) {
        String str = basicBill.totalFeeDisplay;
        String str2 = basicBill.totalFeeDisplay;
        if (isOptimize() && basicBill.shouldPayFee != basicBill.totalFee) {
            str = basicBill.shouldPayFeeDisplay;
        }
        ((IGlobalPayView) this.mView).setDisplayFeeWithUnit(str);
        if (!isOptimize() || basicBill.shouldPayFee == basicBill.totalFee) {
            ((IGlobalPayView) this.mView).setCrossFeeWithUnit((String) null);
        } else {
            ((IGlobalPayView) this.mView).setCrossFeeWithUnit(str2);
        }
        ((IGlobalPayView) this.mView).setJumpableItem(getFeeDes());
    }

    private void updateInstallmentView(List<InstallmentModel> list) {
        if (list == null || list.size() == 0 || !this.mChannel.startsWith(String.valueOf(150))) {
            ((IGlobalPayView) this.mView).updateInstallment((InstallmentModel) null);
            changeInstallmentNumber((String) null);
            return;
        }
        for (InstallmentModel next : list) {
            if (next.getSelected() == 1) {
                ((IGlobalPayView) this.mView).updateInstallment(next);
                changeInstallmentNumber(next.getNumber());
            }
        }
    }

    private void updateInstallmentRecommend(InstallmentRecommendModel installmentRecommendModel) {
        if (installmentRecommendModel != null) {
            if (!this.mChannel.startsWith(String.valueOf(150)) && !TextUtils.isEmpty(installmentRecommendModel.getChangePay()) && GlobalBubbleShowHelper.show(this.mContext)) {
                ((IGlobalPayView) this.mView).showInstallmentBubble(installmentRecommendModel.getChangePay());
            }
            ((IGlobalPayView) this.mView).updateCashbackInfo(installmentRecommendModel.getGeneralMarketingText());
            ((IGlobalPayView) this.mView).updateInstallmentRedPoint(GlobalRedPointHelper.getInstallmentRedPointVisibility(this.mContext));
            ((IGlobalPayView) this.mView).setHelperUrl(installmentRecommendModel.getInstallmentFaqLink());
        }
    }

    public void onInstallmentClick() {
        this.mOmegaManager.doOmegaForInstallmentClick();
        gotoInstallmentActivity();
    }

    public void gotoInstallmentActivity() {
        if (PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId()) != null) {
            PayParam payParam = new PayParam();
            payParam.omegaAttrs = getOmegaAttrs();
            payParam.oid = getOrderId();
            payParam.sid = this.mSid;
            startActivityForResult(InstallmentActivity.Companion.getIntent(this.mContext, payParam, ((IGlobalPayView) this.mView).getCurrentInstallmentNumber(), ((IGlobalPayView) this.mView).getHelperUrl()), 94);
            this.mOmegaManager.doOmegaForInstallmentPageShow();
        }
    }

    private void updateMerchantView(MerchantInfo merchantInfo) {
        ((IGlobalPayView) this.mView).updateMerchantInfo(merchantInfo);
    }

    private void updateDeductionView(DeductionInfo[] deductionInfoArr) {
        ((IGlobalPayView) this.mView).removeAllDeductions();
        if (deductionInfoArr != null && deductionInfoArr.length > 0) {
            for (DeductionInfo deductionInfo : deductionInfoArr) {
                if (deductionInfo != null) {
                    if (deductionInfo.type == 1) {
                        updateVoucherView(deductionInfo);
                        this.mVoucherIdForOmega = deductionInfo.couponId;
                    } else {
                        VoucherViewConfig voucherViewConfig = new VoucherViewConfig(deductionInfo.name, deductionInfo.deduction, true);
                        voucherViewConfig.showRightIcon = false;
                        voucherViewConfig.canClick = false;
                        ((IGlobalPayView) this.mView).addDeductionItem(voucherViewConfig);
                    }
                }
            }
        }
    }

    private void updateBalanceView(InternalPayChannel[] internalPayChannelArr) {
        if (internalPayChannelArr != null && internalPayChannelArr.length != 0) {
            InternalPayChannel internalPayChannel = null;
            int length = internalPayChannelArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                InternalPayChannel internalPayChannel2 = internalPayChannelArr[i];
                if (internalPayChannel2.channel_id == 120) {
                    internalPayChannel = internalPayChannel2;
                    break;
                }
                i++;
            }
            if (internalPayChannel != null) {
                final String str = "" + internalPayChannel.channel_id;
                ((IGlobalPayView) this.mView).updateBalance(internalPayChannel, new IGlobalPayView.CheckCallBack() {
                    public void onCheckChanged(boolean z) {
                        GlobalAbsPaymentPresenter.this.showLoadingDialog(LoadingState.TYPE_REFRESHING.type);
                        GlobalAbsPaymentPresenter globalAbsPaymentPresenter = GlobalAbsPaymentPresenter.this;
                        globalAbsPaymentPresenter.changePayWithBalance(str, z ? globalAbsPaymentPresenter.mChannel : "");
                        GlobalAbsPaymentPresenter.this.changePayInfo(z ? 3 : 4);
                    }
                });
            }
        }
    }

    private void updatePayMethodView(DetailBill detailBill) {
        if (detailBill != null) {
            ArrayList arrayList = new ArrayList();
            checkInternalChannel(arrayList, detailBill.internalChannels);
            if (arrayList.isEmpty()) {
                checkExternalChannel(arrayList, detailBill.externalChannels);
            }
            this.mChannel = "";
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                PayChannelItem payChannelItem = (PayChannelItem) it.next();
                if (TextUtils.isEmpty(payChannelItem.subChannelId)) {
                    this.mChannel += "," + payChannelItem.channelId;
                } else {
                    this.mChannel += "," + payChannelItem.channelId + "+" + payChannelItem.subChannelId;
                }
            }
            if (!TextUtils.isEmpty(this.mChannel)) {
                this.mChannel = this.mChannel.replaceFirst(",", "");
            }
            ((IGlobalPayView) this.mView).updateThirdPartPayView(arrayList, 0, true);
        }
    }

    private void checkInternalChannel(ArrayList<PayChannelItem> arrayList, InternalPayChannel[] internalPayChannelArr) {
        if (internalPayChannelArr != null && internalPayChannelArr.length > 0) {
            for (InternalPayChannel internalPayChannel : internalPayChannelArr) {
                if (121 == internalPayChannel.channel_id && internalPayChannel.selected == 1) {
                    PayChannelItem payChannelItem = new PayChannelItem();
                    payChannelItem.channelId = internalPayChannel.channel_id;
                    payChannelItem.payName = internalPayChannel.name;
                    payChannelItem.iconUrl = internalPayChannel.icon;
                    arrayList.add(payChannelItem);
                }
            }
        }
    }

    private void checkExternalChannel(ArrayList<PayChannelItem> arrayList, ExternalPayChannel[] externalPayChannelArr) {
        if (externalPayChannelArr != null && externalPayChannelArr.length > 0) {
            for (ExternalPayChannel externalPayChannel : externalPayChannelArr) {
                if (PayConstant.isGlobalThirdChannel(externalPayChannel.channel_id) && externalPayChannel.selected == 1) {
                    arrayList.add(getPayItem(externalPayChannel));
                }
            }
        }
    }

    private PayChannelItem getPayItem(ExternalPayChannel externalPayChannel) {
        PayChannelItem payChannelItem = new PayChannelItem();
        payChannelItem.channelId = externalPayChannel.channel_id;
        payChannelItem.payName = externalPayChannel.name;
        payChannelItem.is_new_channel = externalPayChannel.is_new_channel;
        payChannelItem.deposit_msg = externalPayChannel.deposit_msg;
        if (externalPayChannel.channel_id != 150 || TextUtils.isEmpty(externalPayChannel.selected_sub_id) || externalPayChannel.sub_channels == null || externalPayChannel.sub_channels.length <= 0) {
            payChannelItem.payNumber = externalPayChannel.channel_number;
            if (externalPayChannel.flags == null || externalPayChannel.flags.length <= 0) {
                payChannelItem.iconUrl = externalPayChannel.icon;
            } else {
                payChannelItem.iconUrl = externalPayChannel.flags[0];
            }
        } else {
            for (SubChannel subChannel : externalPayChannel.sub_channels) {
                if (subChannel.sub_id.equals(externalPayChannel.selected_sub_id)) {
                    payChannelItem.payNumber = subChannel.sub_name;
                    payChannelItem.iconUrl = subChannel.sub_icon;
                    payChannelItem.subChannelId = subChannel.sub_id;
                    payChannelItem.expired_desc = subChannel.expired_desc;
                    payChannelItem.expired = subChannel.expired;
                    payChannelItem.card_status = subChannel.card_status;
                    payChannelItem.status_desc = subChannel.status_desc;
                    payChannelItem.sub_id = subChannel.sub_id;
                    payChannelItem.sub_name = subChannel.sub_name;
                }
            }
        }
        return payChannelItem;
    }

    private void updatePayBtnView(String str, boolean z) {
        if (z) {
            ((IGlobalPayView) this.mView).setPayBtnState(PayBtnState.ENABLE);
        } else {
            ((IGlobalPayView) this.mView).setPayBtnState(PayBtnState.DISABLE);
        }
        ((IGlobalPayView) this.mView).setPayBtnText(str);
    }

    public void getPayInfo() {
        super.getPayInfo();
        showLoadingDialog(LoadingState.TYPE_LOADING.type);
    }

    public void refreshOrderBillAndAutoPay(final int i) {
        C209346 r0 = new PayServiceCallback<PayInfo>() {
            public void onSuccess(PayInfo payInfo) {
                ExternalPayChannel[] externalPayChannelArr;
                GlobalAbsPaymentPresenter.this.hideLoadingDialog();
                if (payInfo.billDetail != null && (externalPayChannelArr = payInfo.billDetail.externalChannels) != null && externalPayChannelArr.length > 0 && GlobalAbsPaymentPresenter.this.containPayChannel(externalPayChannelArr, i)) {
                    ExternalPayChannel[] externalPayChannelArr2 = new ExternalPayChannel[externalPayChannelArr.length];
                    for (int i = 0; i < externalPayChannelArr.length; i++) {
                        ExternalPayChannel externalPayChannel = externalPayChannelArr[i];
                        if (externalPayChannel.channel_id == i) {
                            externalPayChannel.selected = 1;
                        } else {
                            externalPayChannel.selected = 0;
                        }
                        externalPayChannelArr2[i] = externalPayChannel;
                    }
                    payInfo.billDetail.externalChannels = externalPayChannelArr2;
                }
                PayInfoManager.getInstance(UniPayParamUtil.getLang()).setPayInfo(GlobalAbsPaymentPresenter.this.getOrderId(), payInfo);
                GlobalAbsPaymentPresenter.this.handlePayInfo(payInfo);
            }

            public void onFail(Error error) {
                GlobalAbsPaymentPresenter.this.showErrorTitle(error.msg);
                GlobalAbsPaymentPresenter.this.showRetryView();
            }
        };
        showLoadingDialog(LoadingState.TYPE_REFRESHING.type);
        if (this.mUnifiedPaySystem != null) {
            this.mUnifiedPaySystem.getPayInfo(r0, 20);
        }
    }

    /* access modifiers changed from: private */
    public boolean containPayChannel(ExternalPayChannel[] externalPayChannelArr, int i) {
        if (externalPayChannelArr != null && externalPayChannelArr.length >= 1) {
            for (ExternalPayChannel externalPayChannel : externalPayChannelArr) {
                if (externalPayChannel.channel_id == i) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public PayParamObject getPayTypeObject() {
        boolean z;
        PayParamObject payParamObject = new PayParamObject();
        payParamObject.checkPayResultSilent = true;
        PayTypes payMethodTypes = ((IGlobalPayView) this.mView).getPayMethodTypes();
        int i = 0;
        if (payMethodTypes != null) {
            payParamObject.canUseEntraprisepay = payMethodTypes.canUseEntraprisepay;
            payParamObject.thirdPayType = payMethodTypes.thirdPartPayType;
            payParamObject.platformPayType = payMethodTypes.platformPayType;
            z = false;
        } else {
            z = true;
        }
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId());
        if (payInfo != null && payInfo.billDetail != null) {
            DetailBill detailBill = payInfo.billDetail;
            ExternalPayChannel[] externalPayChannelArr = detailBill.externalChannels;
            if (externalPayChannelArr != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= externalPayChannelArr.length) {
                        break;
                    }
                    ExternalPayChannel externalPayChannel = externalPayChannelArr[i2];
                    if (z && externalPayChannel.selected == 1) {
                        payParamObject.thirdPayType = externalPayChannel.channel_id;
                    }
                    if (externalPayChannel != null && externalPayChannel.channel_id == payParamObject.thirdPayType) {
                        payParamObject.needSign = externalPayChannel.needSign;
                        payParamObject.signData = externalPayChannel.signObj;
                        payParamObject.needInputPwd = externalPayChannel.needPasswd;
                        break;
                    }
                    i2++;
                }
            }
            InternalPayChannel[] internalPayChannelArr = detailBill.internalChannels;
            if (internalPayChannelArr != null) {
                while (true) {
                    if (i < internalPayChannelArr.length) {
                        InternalPayChannel internalPayChannel = internalPayChannelArr[i];
                        if (internalPayChannel != null && internalPayChannel.needPasswd == 1) {
                            payParamObject.needInputPwd = internalPayChannel.needPasswd;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
        return payParamObject;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        PayMethodItemInfo payMethodItemInfo;
        String str = TAG;
        LogUtil.m31685fi(str, "onActivityResult requestCode:" + i + " resultCode:" + i2);
        Bundle extras = intent != null ? intent.getExtras() : null;
        hideLoadingDialog();
        if (i == 94) {
            GlobalRedPointHelper.setInstallmentRedPointVisibility(this.mContext);
            ((IGlobalPayView) this.mView).updateInstallmentRedPoint(false);
            if (i2 == -1 && extras != null && getCurPayInfo() != null) {
                String string = extras.getString(InstallmentActivity.INSTALLMENT_NUMBER);
                showLoadingDialog(LoadingState.TYPE_REFRESHING.type);
                changeInstallmentNumber(string);
                changePayInfo(6);
                this.mOmegaManager.doOmegaForInstallmentPageConfirm(string);
            }
        } else if (i == 81 && i2 == -1) {
            if (intent != null && (payMethodItemInfo = (PayMethodItemInfo) intent.getSerializableExtra("pay_method_list_result")) != null) {
                if (payMethodItemInfo != null) {
                    GlobalRedPointHelper.markAsClicked(this.mContext, payMethodItemInfo.channelId);
                }
                showLoadingDialog(LoadingState.TYPE_REFRESHING.type);
                changePayChannel(payMethodItemInfo.channelId, payMethodItemInfo.cardIndex);
                changePayInfo(3);
            }
        } else if (11 == i) {
            getPayInfo();
        } else if (12 == i) {
            if (i2 != -1) {
                return;
            }
            if (!((Boolean) extras.get("isPayFinished")).booleanValue()) {
                getPayInfo();
            } else {
                PayInfoManager.getInstance(UniPayParamUtil.getLang()).clearData();
            }
        } else if (3 == i) {
            if (i2 == -1 && extras != null) {
                changeVoucher(extras.getString("para_coupons_select"));
            }
        } else if (100 == i) {
            if (i2 != 0) {
                getPayInfo();
            }
        } else if (82 == i) {
            if (i2 == -1) {
                String stringExtra = intent != null ? intent.getStringExtra("card_index") : "";
                showLoadingDialog(LoadingState.TYPE_REFRESHING.type);
                changePayChannel(150, stringExtra);
                changePayInfo(3);
            }
        } else if (83 == i && i2 == -1) {
            getPayInfo();
        }
    }

    private void onNoPwdPay() {
        showLoadingDialog(LoadingState.TYPE_PAYING.type);
        this.mUnifiedPaySystem.registerCallback(this.mPayCallback);
        this.mUnifiedPaySystem.startSyncPayResult(15, 1000);
    }

    public void queryPayResult(boolean z, LoadingState loadingState, int i) {
        ((IGlobalPayView) this.mView).showQueryPayResultView(true, loadingState, i);
        ((IGlobalPayView) this.mView).setCloseIconEnable(false);
        if (z) {
            this.mUnifiedPaySystem.startSyncPayResult(15, 1000);
        }
    }

    private String getFeeDes() {
        ActionType[] actionTypeArr;
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId());
        if (payInfo == null || payInfo.billBasic == null || (actionTypeArr = payInfo.billBasic.actionTypes) == null) {
            return "";
        }
        int i = 0;
        while (i < actionTypeArr.length) {
            ActionType actionType = actionTypeArr[i];
            if (actionType == null || TextUtil.isEmpty(actionType.url)) {
                i++;
            } else if (!TextUtil.isEmpty(actionType.name)) {
                return actionType.name;
            } else {
                return this.mContext.getString(R.string.oc_pay_fee_detail_str);
            }
        }
        return "";
    }

    public boolean onBackPressed(BackKeyType backKeyType) {
        onCloseBtnClick();
        return true;
    }

    /* access modifiers changed from: protected */
    public String getPayMethod() {
        return ((IGlobalPayView) this.mView).getPayMethod();
    }

    public void onPayItemSelected(int i, PayChannelItem payChannelItem) {
        gotoPayMethodActivity(1);
        getOmegaManager().doOmegaForChangePayType(getPayMethod(), this.mVoucherIdForOmega, (getCurPayInfo() == null || getCurPayInfo().installmentModel == null) ? false : true, GlobalBubbleShowHelper.show(this.mContext) && getPayMethod().startsWith(String.valueOf(150)) && getCurPayInfo() != null && getCurPayInfo().recommendModel != null && !TextUtils.isEmpty(getCurPayInfo().recommendModel.getChangePay()), getPayBillType() == PayConstant.PayBillType.Merchant ? "3rd merchant" : null);
    }

    public void gotoPayMethodActivity(int i) {
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId());
        if (payInfo != null) {
            PayMethodPageInfo payMethodInfo = getPayMethodInfo(payInfo);
            PayParam payParam = new PayParam();
            payParam.omegaAttrs = getOmegaAttrs();
            payParam.oid = getOrderId();
            payParam.sid = this.mSid;
            String str = null;
            if (payInfo.recommendModel != null) {
                str = payInfo.recommendModel.getAddCard();
            }
            startActivityForResult(PayMethodSelectActivity.createIntent(this.mContext, payMethodInfo, payParam, str, i), 81);
        }
    }

    private PayMethodPageInfo getPayMethodInfo(PayInfo payInfo) {
        PayMethodPageInfo payMethodPageInfo = new PayMethodPageInfo();
        payMethodPageInfo.headInfo = getHeadInfo(payInfo);
        payMethodPageInfo.payMethodList = getPayTypeList(payInfo);
        payMethodPageInfo.productLine = payInfo.product_id;
        payMethodPageInfo.productId = getProductId();
        payMethodPageInfo.appId = payInfo.appId;
        payMethodPageInfo.orderId = payInfo.oid;
        payMethodPageInfo.groupList = getGroupList(payInfo);
        return payMethodPageInfo;
    }

    private PayMethodPageHeadInfo getHeadInfo(PayInfo payInfo) {
        if (payInfo == null || payInfo.billDetail == null) {
            return null;
        }
        PayMethodPageHeadInfo payMethodPageHeadInfo = new PayMethodPageHeadInfo();
        if (!TextUtils.isEmpty(payInfo.billDetail.frozenTitle)) {
            payMethodPageHeadInfo.content = payInfo.billDetail.frozenTitle;
            payMethodPageHeadInfo.link = payInfo.billDetail.frozenLink;
            payMethodPageHeadInfo.addCardEnable = false;
        } else if (!isOptimize() || TextUtils.isEmpty(payInfo.billDetail.topCopyWriting)) {
            return null;
        } else {
            payMethodPageHeadInfo.content = payInfo.billDetail.topCopyWriting;
            payMethodPageHeadInfo.addCardEnable = true;
        }
        return payMethodPageHeadInfo;
    }

    private List<PayMethodGroupInfo> getGroupList(PayInfo payInfo) {
        ArrayList arrayList = new ArrayList();
        if (!(payInfo == null || payInfo.billDetail == null || payInfo.billDetail.group == null)) {
            for (PayMethodGroup payMethodGroup : payInfo.billDetail.group) {
                if (!(payMethodGroup == null || payMethodGroup.payment_methods == null)) {
                    PayMethodGroupInfo payMethodGroupInfo = new PayMethodGroupInfo();
                    payMethodGroupInfo.name = payMethodGroup.name;
                    payMethodGroupInfo.icon = payMethodGroup.icon;
                    payMethodGroupInfo.channelIds = new ArrayList();
                    for (Integer intValue : payMethodGroup.payment_methods) {
                        payMethodGroupInfo.channelIds.add(Integer.valueOf(intValue.intValue()));
                    }
                    arrayList.add(payMethodGroupInfo);
                }
            }
        }
        return arrayList;
    }

    private List<PayMethodItemInfo> getPayTypeList(PayInfo payInfo) {
        DetailBill detailBill;
        ArrayList arrayList = new ArrayList();
        if (!(payInfo == null || (detailBill = payInfo.billDetail) == null)) {
            InternalPayChannel[] internalPayChannelArr = detailBill.internalChannels;
            ExternalPayChannel[] externalPayChannelArr = detailBill.externalChannels;
            if (internalPayChannelArr != null && internalPayChannelArr.length > 0) {
                int length = internalPayChannelArr.length;
                for (int i = 0; i < length; i++) {
                    if (internalPayChannelArr[i].channel_id == 121) {
                        PayMethodItemInfo payMethodItemInfo = new PayMethodItemInfo();
                        payMethodItemInfo.channelId = internalPayChannelArr[i].channel_id;
                        payMethodItemInfo.title = internalPayChannelArr[i].name;
                        payMethodItemInfo.subTitle = internalPayChannelArr[i].extention;
                        payMethodItemInfo.isSelected = internalPayChannelArr[i].selected == 1;
                        payMethodItemInfo.status = 1;
                        payMethodItemInfo.isEnabled = internalPayChannelArr[i].level != 3;
                        payMethodItemInfo.iconUrl = internalPayChannelArr[i].icon;
                        payMethodItemInfo.style = 1;
                        arrayList.add(payMethodItemInfo);
                    }
                }
            }
            if (externalPayChannelArr != null && externalPayChannelArr.length > 0) {
                int length2 = externalPayChannelArr.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    if (externalPayChannelArr[i2].channel_id == 150) {
                        PayMethodItemInfo payMethodItemInfo2 = new PayMethodItemInfo();
                        payMethodItemInfo2.channelId = externalPayChannelArr[i2].channel_id;
                        payMethodItemInfo2.title = externalPayChannelArr[i2].name;
                        payMethodItemInfo2.subTitle = externalPayChannelArr[i2].extension;
                        payMethodItemInfo2.iconUrl = externalPayChannelArr[i2].icon;
                        payMethodItemInfo2.status = 0;
                        arrayList.add(payMethodItemInfo2);
                        if (externalPayChannelArr[i2].sub_channels != null && externalPayChannelArr[i2].sub_channels.length > 0) {
                            for (SubChannel methodInfo : externalPayChannelArr[i2].sub_channels) {
                                arrayList.add(getMethodInfo(externalPayChannelArr[i2], methodInfo));
                            }
                        }
                    } else if (PayConstant.isGlobalThirdChannel(externalPayChannelArr[i2].channel_id)) {
                        arrayList.add(getMethodInfo(externalPayChannelArr[i2], (SubChannel) null));
                    }
                }
            }
        }
        return arrayList;
    }

    private PayMethodItemInfo getMethodInfo(ExternalPayChannel externalPayChannel, SubChannel subChannel) {
        PayMethodItemInfo payMethodItemInfo = new PayMethodItemInfo();
        payMethodItemInfo.channelId = externalPayChannel.channel_id;
        payMethodItemInfo.subTitle = externalPayChannel.extension;
        payMethodItemInfo.subTitleTip = externalPayChannel.amount_notice;
        payMethodItemInfo.marketing = externalPayChannel.marketing_text;
        if (!TextUtils.isEmpty(externalPayChannel.payment_select_name)) {
            payMethodItemInfo.title = externalPayChannel.payment_select_name;
        } else {
            payMethodItemInfo.title = externalPayChannel.name;
        }
        if (externalPayChannel.needSign == 0) {
            payMethodItemInfo.status = 1;
        } else {
            payMethodItemInfo.status = 0;
        }
        if (payMethodItemInfo.status == 1) {
            payMethodItemInfo.isSelected = externalPayChannel.selected == 1;
            payMethodItemInfo.style = 1;
        } else {
            payMethodItemInfo.isSelected = false;
            payMethodItemInfo.style = 2;
        }
        payMethodItemInfo.isEnabled = externalPayChannel.level != 3;
        payMethodItemInfo.iconUrl = externalPayChannel.icon;
        payMethodItemInfo.depositStatus = externalPayChannel.deposit_status;
        if (payMethodItemInfo.depositStatus == 2 || payMethodItemInfo.depositStatus == 3) {
            payMethodItemInfo.isSelected = false;
            payMethodItemInfo.style = 2;
        } else if (payMethodItemInfo.depositStatus == 1) {
            payMethodItemInfo.isSelected = externalPayChannel.selected == 1;
            payMethodItemInfo.style = 1;
        }
        if (subChannel != null) {
            payMethodItemInfo.cardIndex = subChannel.sub_id;
            payMethodItemInfo.marketing = subChannel.marketing_text;
            payMethodItemInfo.subTitle = subChannel.status_desc;
            payMethodItemInfo.iconUrl = subChannel.sub_icon;
            payMethodItemInfo.isEnabled = payMethodItemInfo.isEnabled && subChannel.canSelect == 1;
            payMethodItemInfo.copyWriting = subChannel.copy_writing;
            if (!TextUtils.isEmpty(subChannel.sub_select_name)) {
                payMethodItemInfo.title = subChannel.sub_select_name;
            } else {
                payMethodItemInfo.title = subChannel.sub_name;
            }
            if (!payMethodItemInfo.isSelected || externalPayChannel.selected_sub_id == null || !externalPayChannel.selected_sub_id.equals(subChannel.sub_id)) {
                payMethodItemInfo.isSelected = false;
            } else {
                payMethodItemInfo.isSelected = true;
            }
            if (subChannel.card_status == 1) {
                payMethodItemInfo.status = 2;
                payMethodItemInfo.style = 2;
            }
            if (subChannel.expired == 1) {
                payMethodItemInfo.status = 3;
                payMethodItemInfo.style = 2;
                payMethodItemInfo.info = subChannel.expired_desc;
                payMethodItemInfo.infoStyle = 1;
            }
        }
        if (!GlobalRedPointHelper.isClicked(this.mContext, externalPayChannel.channel_id)) {
            payMethodItemInfo.label = externalPayChannel.new_channel_tip;
        }
        return payMethodItemInfo;
    }

    /* access modifiers changed from: protected */
    public void doPay(final PayParamObject payParamObject) {
        String str;
        if (payParamObject != null) {
            ((IGlobalPayView) this.mView).showLoadingView("", true, LoadingState.TYPE_PAYING.type);
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    GlobalAbsPaymentPresenter.super.doPay(payParamObject);
                }
            }, 1000);
            String str2 = null;
            try {
                str = getCurPayInfo().installmentModel.get(Integer.parseInt(this.mInstallmentNumber) - 1).getEachAmount();
            } catch (Exception unused) {
                str = null;
            }
            GlobalPayOmegaManager omegaManager = getOmegaManager();
            String payMethod = getPayMethod();
            String str3 = this.mAppIdForOmega;
            String str4 = this.mVoucherIdForOmega;
            String str5 = this.mInstallmentNumber;
            if (getPayBillType() == PayConstant.PayBillType.Merchant) {
                str2 = "3rd merchant";
            }
            omegaManager.doOmegaForDoPay(payMethod, str3, str4, str5, str, str2);
        }
    }

    private void showCorrectTitle(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        ((IGlobalPayView) this.mView).setTitle(false, str, str2);
        setTitleLink(false);
    }

    /* access modifiers changed from: private */
    public void showErrorTitle(String str) {
        ((IGlobalPayView) this.mView).setTitle(true, this.mContext.getResources().getString(R.string.pay_fail), str);
        getOmegaManager().doOmegaForPayError(getPayMethod(), this.mVoucherIdForOmega);
        setTitleLink(true);
    }

    private void showErrorTitle(String str, boolean z) {
        ((IGlobalPayView) this.mView).setTitle(true, z, this.mContext.getResources().getString(R.string.pay_fail), str);
        getOmegaManager().doOmegaForPayError(getPayMethod(), this.mVoucherIdForOmega);
        setTitleLink(true);
    }

    private void setTitleLink(boolean z) {
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId());
        if (payInfo != null) {
            ((IGlobalPayView) this.mView).setTitleLink(z, payInfo.payStatusColor, payInfo.payStatusLink, new IGlobalPayView.OnWebLinkClickListener() {
                public void onClick(String str) {
                    GlobalAbsPaymentPresenter.this.getOmegaManager().doOmegaPayFailFAQClick(GlobalAbsPaymentPresenter.this.getPayMethod(), GlobalAbsPaymentPresenter.this.mVoucherIdForOmega);
                    if (!TextUtils.isEmpty(str)) {
                        UniPayWebModel uniPayWebModel = new UniPayWebModel();
                        uniPayWebModel.context = GlobalAbsPaymentPresenter.this.mContext;
                        uniPayWebModel.url = str;
                        uniPayWebModel.sid = GlobalAbsPaymentPresenter.this.mSid;
                        uniPayWebModel.intentFlag = View.STATUS_BAR_TRANSIENT;
                        uniPayWebModel.requestCode = -1;
                        UniPayWebUtil.startWebPage(uniPayWebModel, GlobalAbsPaymentPresenter.this.mViewCallback);
                    }
                }
            });
        }
    }

    public void showRetryView() {
        ((IGlobalPayView) this.mView).showRetryView(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalAbsPaymentPresenter.this.getPayInfo();
                GlobalAbsPaymentPresenter.this.getOmegaManager().doOmegaForRetry(GlobalAbsPaymentPresenter.this.getPayMethod(), GlobalAbsPaymentPresenter.this.mVoucherIdForOmega);
            }
        });
    }

    /* access modifiers changed from: private */
    public void showLoadingDialog(int i) {
        ((IGlobalPayView) this.mView).showLoadingPop(i);
        getOmegaManager().doOmegaForShowLoading(getPayMethod(), this.mVoucherIdForOmega);
    }

    /* access modifiers changed from: private */
    public void hideLoadingDialog() {
        ((IGlobalPayView) this.mView).hideLoadingPop(true);
        getOmegaManager().doOmegaForShowRoot(getPayMethod(), this.mVoucherIdForOmega, this.mAppIdForOmega, (getCurPayInfo() == null || getCurPayInfo().installmentModel == null) ? false : true, getPayBillType() == PayConstant.PayBillType.Merchant ? "3rd merchant" : null);
    }

    private void showSuccessDialog(String str) {
        ((IGlobalPayView) this.mView).showSuccessView(true, str);
        getOmegaManager().doOmegaForShowSuccess(getPayMethod(), this.mVoucherIdForOmega);
    }

    /* access modifiers changed from: protected */
    public GlobalPayOmegaManager getOmegaManager() {
        if (this.mOmegaManager == null) {
            GlobalPayOmegaManager globalPayOmegaManager = new GlobalPayOmegaManager(getOrderId());
            this.mOmegaManager = globalPayOmegaManager;
            globalPayOmegaManager.addOmegaAttr(getOmegaAttrs());
        }
        return this.mOmegaManager;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getOmegaAttrs() {
        if (this.mPayParam == null || this.mPayParam.omegaAttrs == null) {
            return null;
        }
        return this.mPayParam.omegaAttrs;
    }

    /* access modifiers changed from: protected */
    public String getPixType() {
        if (this.mPayParam != null && this.mPayParam.pixPrepay) {
            return "pix_prepay_page";
        }
        return "pix_page";
    }

    /* access modifiers changed from: protected */
    public boolean isSupportPay() {
        DetailBill detailBill;
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId());
        ArrayList arrayList = new ArrayList();
        if (payInfo == null || (detailBill = payInfo.billDetail) == null) {
            return false;
        }
        checkInternalChannel(arrayList, detailBill.internalChannels);
        if (arrayList.isEmpty()) {
            checkExternalChannel(arrayList, detailBill.externalChannels);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final PayChannelItem payChannelItem = (PayChannelItem) it.next();
            if (payChannelItem.channelId == 150 && payChannelItem.expired == 1) {
                IDidiGlobalPayApi createDidiPay = DidiGlobalPayApiFactory.createDidiPay();
                DidiGlobalCardExpireInterceptData.CardExpireInterceptParam cardExpireInterceptParam = new DidiGlobalCardExpireInterceptData.CardExpireInterceptParam();
                cardExpireInterceptParam.cardNo = payChannelItem.payNumber;
                cardExpireInterceptParam.icon = payChannelItem.iconUrl;
                cardExpireInterceptParam.type = 1;
                createDidiPay.startCardExpireIntercept((Activity) this.mFragmentActivity, cardExpireInterceptParam, (DidiGlobalCardExpireInterceptData.CardExpireInterceptCallback) new DidiGlobalCardExpireInterceptData.CardExpireInterceptCallback() {
                    public void onClick(int i) {
                        if (i == 0) {
                            GlobalAbsPaymentPresenter.this.gotoUpdateCardActivity(payChannelItem.payNumber);
                        } else if (i == 1) {
                            GlobalAbsPaymentPresenter.this.gotoPayMethodActivity(1);
                        }
                    }
                });
                return false;
            } else if (payChannelItem.channelId == 150 && payChannelItem.card_status == 1) {
                DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam = new DidiGlobalVerifyCardData.VerifyCardParam();
                verifyCardParam.cardIndex = payChannelItem.sub_id;
                verifyCardParam.cardNo = payChannelItem.sub_name;
                DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity(this.mFragmentActivity, transRequestCode(83), verifyCardParam);
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void gotoUpdateCardActivity(String str) {
        if (getCurPayInfo() != null) {
            DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
            addCardParam.bindType = 4;
            addCardParam.isSignAfterOrder = true;
            addCardParam.productLine = getCurPayInfo().product_id;
            addCardParam.orderId = getCurPayInfo().oid;
            addCardParam.resourceId = "8";
            addCardParam.appId = this.mAppIdForOmega;
            addCardParam.productId = getProductId();
            addCardParam.cardNo = str;
            DidiCreditCardFactory.createGlobalCreditCardApi().prepareAddCardActivityIntent(this.mFragmentActivity, addCardParam, new IGlobalCreditCardApi.PrepareAddCardCallback() {
                public void onIntentPrepared(Intent intent) {
                    GlobalAbsPaymentPresenter.this.startActivityForResult(intent, 82);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public PayConstant.PayBillType getPayBillType() {
        return PayConstant.PayBillType.Trip;
    }

    private boolean isOptimize() {
        return ABTestProxyHolder.getOptimizedUISwitch().optimized() && ((IGlobalPayView) this.mView).newUIType();
    }

    @Subscribe
    public void onEvent(final RequestPayEvent requestPayEvent) {
        if (requestPayEvent != null) {
            ((IGlobalPayView) this.mView).showLoadingView("", true, LoadingState.TYPE_PAYING.type);
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    if (requestPayEvent.type == RequestPayEvent.RequestType.GetPayInfo) {
                        GlobalAbsPaymentPresenter.super.getPayInfo();
                        boolean unused = GlobalAbsPaymentPresenter.this.requestFromEvent = true;
                    } else if (requestPayEvent.type == RequestPayEvent.RequestType.ChangePayInfo) {
                        GlobalAbsPaymentPresenter.this.changePayChannel(requestPayEvent.channnel, requestPayEvent.sub_channel);
                        GlobalAbsPaymentPresenter.this.changePayInfo(3);
                        boolean unused2 = GlobalAbsPaymentPresenter.this.requestFromEvent = true;
                    } else if (requestPayEvent.type == RequestPayEvent.RequestType.PrePay) {
                        GlobalAbsPaymentPresenter globalAbsPaymentPresenter = GlobalAbsPaymentPresenter.this;
                        globalAbsPaymentPresenter.doPay(globalAbsPaymentPresenter.getPayTypeObject());
                    }
                }
            }, 1000);
        }
    }
}
