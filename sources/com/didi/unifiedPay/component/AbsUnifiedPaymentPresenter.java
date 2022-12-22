package com.didi.unifiedPay.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.payment.DidiCreditCardData;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.unifiedPay.UnifiedPaySystem;
import com.didi.unifiedPay.component.activity.CouponsListWebActivityIntent;
import com.didi.unifiedPay.component.activity.RearEnterprisePayIntent;
import com.didi.unifiedPay.component.manager.PayCache;
import com.didi.unifiedPay.component.manager.PayTranceEventManager;
import com.didi.unifiedPay.component.manager.PayTypeManager;
import com.didi.unifiedPay.component.model.BackKeyType;
import com.didi.unifiedPay.component.model.BillMarketing;
import com.didi.unifiedPay.component.model.DownGradeInfo;
import com.didi.unifiedPay.component.model.PayChannelItem;
import com.didi.unifiedPay.component.model.PayErrorEvent;
import com.didi.unifiedPay.component.model.PayItem;
import com.didi.unifiedPay.component.model.PayResult;
import com.didi.unifiedPay.component.model.PayState;
import com.didi.unifiedPay.component.model.PayTypes;
import com.didi.unifiedPay.component.model.PlatformDownGradeInfo;
import com.didi.unifiedPay.component.model.PlatformPayItem;
import com.didi.unifiedPay.component.model.SignResultModel;
import com.didi.unifiedPay.component.presenter.AbsPaymentPresenter;
import com.didi.unifiedPay.component.presenter.PayInfoManager;
import com.didi.unifiedPay.component.presenter.PayWindowManager;
import com.didi.unifiedPay.component.view.DeductionItemType;
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
import com.didi.unifiedPay.sdk.model.InternalPayChannel;
import com.didi.unifiedPay.sdk.model.PasswordModel;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PayParamObject;
import com.didi.unifiedPay.sdk.net.Error;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.UiThreadHandler;
import com.didi.unifiedPay.util.UniPayParamUtil;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.taxis99.R;
import global.didi.pay.model.LoadingState;
import global.didi.pay.threeds.model.Adyen3DSModel;
import global.didi.pay.threeds.model.Cybs3DSModel;
import global.didi.pay.web.UniPayWebModel;
import global.didi.pay.web.UniPayWebUtil;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public abstract class AbsUnifiedPaymentPresenter extends AbsPaymentPresenter<IPayView> implements IPayView.PayViewListener {
    public static final String KEY_RESET_DOMAIN = "absunifiedpaymentpresenter_key_reset_domain";
    public static final String KEY_RETURN_FROM_PAYVIEW = "KEY_RETURN_FROM_PAYVIEW";
    protected static final int PAY_SUCCESS_ON_BTTON_DURATION = 1000;
    protected static final int PAY_TO_EVALUATE_DURATION = 1500;
    private static final int REQUEST_CODE_MARKETING = 5;
    public static final int REQUEST_CODE_REAR_ENTERPRISE_NOTE = 11;
    private static final int REQUEST_CODE_SELECT_COUPON = 3;
    private static final int SYC_PAY_STATUS_INTERVAL = 3000;
    private static final String TAG = AbsUnifiedPaymentPresenter.class.getSimpleName();
    private boolean firstShow = true;
    private boolean isPayClosed;
    protected String mChannel;
    protected String mCoupon;
    protected PayTranceEventManager mEventManager;
    private boolean mExpandAllThirdPayItemByUser;
    protected FragmentManager mFragmentManager;
    public boolean mIsChangePayType;
    private int mResetDomain = -1;
    protected String mSid;
    public IViewCallback mViewCallback;
    public PayWindowManager mWindowManager;

    /* access modifiers changed from: protected */
    public String getWxAppid() {
        return "";
    }

    /* access modifiers changed from: protected */
    public void gotoCostObjectioActivity(PayInfo payInfo, int i) {
    }

    /* access modifiers changed from: protected */
    public void onAdyenThreeDSAction(Adyen3DSModel adyen3DSModel) {
    }

    /* access modifiers changed from: protected */
    public void onCybsThreeDSAction(Cybs3DSModel cybs3DSModel) {
    }

    public void onOrderFeezeConfirmClick() {
    }

    /* access modifiers changed from: protected */
    public void onPasswordModel(PasswordModel passwordModel) {
    }

    /* access modifiers changed from: protected */
    public void onPixCode(String str) {
    }

    public void onThirdPartPayItemClicked(int i, PayItem payItem) {
    }

    /* access modifiers changed from: protected */
    public void onViewFilled() {
    }

    /* access modifiers changed from: protected */
    public void updatePayTypeInfo(PayInfo payInfo) {
    }

    public AbsUnifiedPaymentPresenter(Context context, FragmentManager fragmentManager, String str, IViewCallback iViewCallback) {
        super(context, fragmentManager);
        this.mViewCallback = iViewCallback;
        this.mSid = str;
    }

    /* access modifiers changed from: protected */
    public void requestPayInfoResult(boolean z, PayInfo payInfo, String str, int i) {
        if (z) {
            payInfoRequestSuccess(payInfo);
        } else {
            payInfoRequestFailed(str, i);
        }
    }

    public void onAdd(Bundle bundle) {
        if (bundle != null) {
            this.mResetDomain = bundle.getInt(KEY_RESET_DOMAIN);
        }
        super.onAdd(bundle);
        this.mEventManager = new PayTranceEventManager(this.mContext, getOrderId(), getBid());
        this.mWindowManager = new PayWindowManager((IPayView) this.mView, this, this.mContext, getOrderId(), getBid());
        prepareData();
    }

    /* access modifiers changed from: protected */
    public void initPayApi() {
        this.mUnifiedPaySystem = UnifiedPaySystem.createUnifiedPay(this.mContext, PayConstant.PayBillType.Trip);
        this.mUnifiedPaySystem.init(getBid(), getOrderId(), this.mFragmentManager);
    }

    public void onCloseBtnClick() {
        IViewCallback iViewCallback;
        this.mEventManager.doOmegaPayCardClose(getPayMethod(), this.mCoupon, this.mChannel);
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

    public void onClosePixBtnClick() {
        this.mUnifiedPaySystem.cancelSyncPayResult();
    }

    /* access modifiers changed from: protected */
    public boolean onClose() {
        PayErrorEvent isShowErrorView = ((IPayView) this.mView).isShowErrorView();
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

    public void gotoPayedPage() {
        PayInfoManager.getInstance(UniPayParamUtil.getLang()).clearData();
    }

    /* access modifiers changed from: protected */
    public void prepareData() {
        getPayInfo();
    }

    public void onDeductionItemClick(VoucherViewConfig voucherViewConfig) {
        if (voucherViewConfig.deductionType == DeductionItemType.TYPE_VOUCHER) {
            this.mEventManager.doOmegaPayCardSwitchCoupon(getPayMethod(), this.mCoupon, this.mChannel);
            DeductionInfo voucherInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getVoucherInfo(getOrderId());
            if (voucherInfo != null && !TextUtil.isEmpty(voucherInfo.url)) {
                CouponsListWebActivityIntent couponsListWebActivityIntent = new CouponsListWebActivityIntent();
                couponsListWebActivityIntent.setWebUrl(voucherInfo.url);
                couponsListWebActivityIntent.addFlags(View.NAVIGATION_BAR_UNHIDE);
                startActivityForResult(couponsListWebActivityIntent, 3);
            }
        }
    }

    public String getPid() {
        return UniPayParamUtil.getUid(this.mContext);
    }

    public void startActivityForResult(Intent intent, int i) {
        IViewCallback iViewCallback = this.mViewCallback;
        if (iViewCallback != null) {
            iViewCallback.callStartActivityForResult(intent, i);
        }
    }

    public void onPayButtonClick() {
        this.mEventManager.doOmegaPayCardPay(getPayMethod(), this.mCoupon, this.mChannel);
        this.mEventManager.doOmegaPayMethodChange(((IPayView) this.mView).getInitPayMethod(), getPayMethod());
        doPay(getPayTypeObject());
    }

    public void onRemove() {
        super.onRemove();
        this.mViewCallback = null;
        UiThreadHandler.removeCallbacks((Runnable) null);
        if (this.mUnifiedPaySystem != null) {
            this.mUnifiedPaySystem.onDestroy();
        }
    }

    public void onPageResume() {
        LogUtil.m31684d(TAG, "onPageResume");
        ((IPayView) this.mView).resetViewClickable();
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId());
        if (payInfo != null && payInfo.billDetail != null && payInfo.billDetail.payEnable == 0) {
            updatePayBtnView(payInfo.billDetail.payBtnTitle, false);
        }
    }

    public void onPageStop() {
        LogUtil.m31684d(TAG, "onPageStop");
    }

    public void onShowFeeDetailClick() {
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId());
        if (payInfo != null && payInfo.billBasic != null) {
            ActionType[] actionTypeArr = payInfo.billBasic.actionTypes;
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
                    uniPayWebModel.requestCode = -1;
                    UniPayWebUtil.startWebPage(uniPayWebModel, this.mViewCallback);
                    return;
                }
            }
        }
    }

    public void itemClicked(int i, PlatformPayItem platformPayItem) {
        String str = TAG;
        LogUtil.m31684d(str, "itemClicked index:" + i);
        PlatformDownGradeInfo platformDownGradeInfo = platformPayItem.downGradeInfo;
        if (platformDownGradeInfo != null) {
            String str2 = platformDownGradeInfo.url;
            if (!TextUtil.isEmpty(str2)) {
                if (platformPayItem.channelId == 121) {
                    RearEnterprisePayIntent rearEnterprisePayIntent = new RearEnterprisePayIntent();
                    rearEnterprisePayIntent.setWebUrl(str2);
                    startActivityForResult(rearEnterprisePayIntent, 11);
                } else if (platformPayItem.channelId == 161) {
                    goSignDDCredit(102, str2);
                }
            }
        }
    }

    public void onPayItemSelected(int i, PayChannelItem payChannelItem) {
        this.mUnifiedPaySystem.changePayChannel(payChannelItem.channelId, "");
        this.mIsChangePayType = true;
        this.mUnifiedPaySystem.changePayInfo(3, this.mPayinfoCallback);
    }

    public void onExpandAllThirdPayItemByUser() {
        this.mExpandAllThirdPayItemByUser = true;
    }

    public void unSelectThirdPartItem(int i, PayChannelItem payChannelItem) {
        if (payChannelItem == null || !payChannelItem.canCancel) {
            this.mIsChangePayType = false;
            ((IPayView) this.mView).setChangePayItemResult(false);
            return;
        }
        this.mUnifiedPaySystem.changePayChannel(payChannelItem.channelId, "");
        this.mIsChangePayType = true;
        this.mUnifiedPaySystem.changePayInfo(4, this.mPayinfoCallback);
    }

    public void onPlatformItemSelectChange(int i, boolean z, PlatformPayItem platformPayItem, boolean z2) {
        if (platformPayItem != null) {
            if (!z2 && platformPayItem.channelId == 121) {
                if (z) {
                    ((IPayView) this.mView).removeThirdPartPay();
                } else {
                    ((IPayView) this.mView).showThirdPartPay();
                }
            }
            if (platformPayItem.channelId == 121) {
                this.mUnifiedPaySystem.changeEnterprisePayType(z ? 21 : 20);
            }
            this.mUnifiedPaySystem.changePayChannel(platformPayItem.channelId, "");
            this.mIsChangePayType = true;
            this.mUnifiedPaySystem.changePayInfo(z ? 3 : 4, this.mPayinfoCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void onStartPay() {
        ((IPayView) this.mView).showLoadingView("", false);
    }

    /* access modifiers changed from: protected */
    public void onPaySuccessed(int i, String str) {
        if (this.mCurrentState == PayState.PaySuccess) {
            LogUtil.m31685fi(TAG, "currentState is PaySuccess,return ");
            return;
        }
        this.mCurrentState = PayState.PaySuccess;
        ((IPayView) this.mView).showSuccessView(true);
        PayInfoManager.getInstance(UniPayParamUtil.getLang()).clearData();
    }

    /* access modifiers changed from: protected */
    public boolean isPayClosed() {
        return this.isPayClosed;
    }

    /* access modifiers changed from: protected */
    public void onQueryResult(boolean z, LoadingState loadingState, int i) {
        queryPayResult(false, loadingState, i);
        if (z) {
            this.mEventManager.doOmegaPayCardResultWait(getPayMethod(), this.mCoupon, this.mChannel);
        }
    }

    /* access modifiers changed from: protected */
    public void onPrePayFailed(int i, String str) {
        if (i == 11) {
            ((IPayView) this.mView).resetViewClickable();
        } else if (i == 1059) {
            this.mWindowManager.showFailView(i, str, true);
        } else if (i == 3042) {
            showOrderFreezeDialog(str);
        } else if (i == 82153 || i == 500101) {
            this.mWindowManager.payFailedAndReflushBill(str, ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_i_know), getPayMethod(), this.mCoupon, this.mChannel);
        } else {
            this.mWindowManager.showFailView(str, getPayMethod(), this.mCoupon, this.mChannel);
        }
    }

    /* access modifiers changed from: protected */
    public void onPayFailed(PayError payError, String str) {
        ((IPayView) this.mView).resetViewClickable();
        if (payError.errorCode == 3042) {
            showOrderFreezeDialog(str);
            return;
        }
        switch (payError.errorCode) {
            case 1:
                return;
            case 2:
                LogUtil.m31684d(TAG, "NOT_SUPPORT_PAY");
                if (TextUtil.isEmpty(str)) {
                    str = ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_not_support);
                }
                this.mWindowManager.showFailView(str, getPayMethod(), this.mCoupon, this.mChannel);
                return;
            case 3:
                this.mWindowManager.onNotGetPayResult(ResourcesHelper.getString(this.mContext, R.string.scar_pay_stop_content), getPayMethod(), this.mCoupon, this.mChannel);
                return;
            case 4:
                this.mWindowManager.showFailView(ResourcesHelper.getString(this.mContext, R.string.oc_pay_select_channel), getPayMethod(), this.mCoupon, this.mChannel);
                return;
            case 5:
                this.mWindowManager.showFailView(ResourcesHelper.getString(this.mContext, R.string.car_no_pwd_pay_fail_title), getPayMethod(), this.mCoupon, this.mChannel);
                return;
            case 6:
                this.mWindowManager.showFailView(ResourcesHelper.getString(this.mContext, R.string.oc_pay_closed), getPayMethod(), this.mCoupon, this.mChannel);
                return;
            case 7:
                this.mWindowManager.showFailView(ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_result_unknown), getPayMethod(), this.mCoupon, this.mChannel);
                return;
            default:
                this.mWindowManager.payFailedAndRePay(str);
                return;
        }
    }

    private void showOrderFreezeDialog(String str) {
        this.mWindowManager.showOrderFreezeDialog(str);
    }

    /* access modifiers changed from: private */
    public void handlePayInfo(PayInfo payInfo) {
        this.mChannel = "";
        int i = payInfo.payStatus;
        if (i == 0) {
            this.mWindowManager.payFailedAndReflushBill(ResourcesHelper.getString(this.mContext, R.string.oc_pay_bill_refresh_failed), getPayMethod(), this.mCoupon, this.mChannel);
        } else if (i == 1) {
            setupView(payInfo);
        } else if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    setupView(payInfo);
                    if (!PayCache.getInstance().isLastPayFailShow(getOrderId()) && !TextUtil.isEmpty(payInfo.statusMsg)) {
                        this.mWindowManager.showFailView(0, payInfo.statusMsg, false);
                        PayCache.getInstance().setLastPayFailShowed(getOrderId());
                    }
                } else if (i != 5) {
                    if (i == 7) {
                        this.isPayClosed = true;
                        onPaySuccessed(payInfo.payStatus, payInfo.statusMsg);
                    }
                }
            }
            onPaySuccessed(payInfo.payStatus, payInfo.statusMsg);
        } else {
            setupView(payInfo);
            onNoPwdPay();
        }
        onViewFilled();
    }

    private void payInfoRequestSuccess(PayInfo payInfo) {
        String str = TAG;
        LogUtil.m31684d(str, "mPayinfoCallback onSuccess payInfo:" + payInfo);
        if (this.mIsChangePayType) {
            this.mIsChangePayType = false;
            ((IPayView) this.mView).setChangePayItemResult(true);
        }
        PayInfoManager.getInstance(UniPayParamUtil.getLang()).setPayInfo(getOrderId(), payInfo);
        if (this.mCurrentState != PayState.PaySuccess) {
            ((IPayView) this.mView).showLoadingView("", false);
            handlePayInfo(payInfo);
        }
    }

    private void payInfoRequestFailed(String str, int i) {
        String str2 = TAG;
        LogUtil.m31684d(str2, "mPayinfoCallback onFail error:" + str);
        if (this.mIsChangePayType) {
            this.mIsChangePayType = false;
            ((IPayView) this.mView).setChangePayItemResult(false);
        }
        PayInfoManager.getInstance(UniPayParamUtil.getLang()).clearPayInfo();
        if (i == 3042) {
            showOrderFreezeDialog(str);
        } else {
            this.mWindowManager.payFailedAndReflushBill(str, getPayMethod(), this.mCoupon, this.mChannel);
        }
    }

    /* access modifiers changed from: protected */
    public void changeVoucher(String str) {
        ((IPayView) this.mView).showLoadingView(this.mContext.getString(R.string.oc_uni_pay_loading_bill), true);
        this.mUnifiedPaySystem.changeCoupon(str);
        this.mUnifiedPaySystem.changePayChannel(0, "");
        this.mUnifiedPaySystem.changePayInfo(2, this.mPayinfoCallback);
    }

    /* access modifiers changed from: protected */
    public void setupView(PayInfo payInfo) {
        if (payInfo == null || payInfo.billBasic == null || payInfo.billDetail == null) {
            LogUtil.m31684d(TAG, "payinfo  is null,return");
            return;
        }
        PayInfoManager.getInstance(UniPayParamUtil.getLang()).setPayInfo(getOrderId(), payInfo);
        BasicBill basicBill = payInfo.billBasic;
        DetailBill detailBill = payInfo.billDetail;
        updatePayTypeInfo(payInfo);
        if (!TextUtils.isEmpty(payInfo.pay_title)) {
            ((IPayView) this.mView).setCradTitle(payInfo.pay_title);
        } else {
            ((IPayView) this.mView).setCradTitle("");
        }
        setTotalFee(basicBill);
        updateDeductionView(detailBill.deductions);
        updatePlatformPayChannelView(detailBill.internalChannels);
        updateThirdPayChannelView(detailBill.externalChannels);
        updateMarketing(detailBill.marketing);
        boolean z = true;
        ((IPayView) this.mView).setCancelableForThirdPay(true);
        String str = detailBill.payBtnTitle;
        if (detailBill.payEnable <= 0) {
            z = false;
        }
        updatePayBtnView(str, z);
        doOmegaPaymentShow();
    }

    private void doOmegaPaymentShow() {
        if (this.firstShow) {
            this.firstShow = false;
            this.mEventManager.doOmegaPayCardShow(getPayMethod(), this.mCoupon, this.mChannel);
        }
    }

    /* access modifiers changed from: protected */
    public void setCardPaddingTop(int i) {
        ((IPayView) this.mView).setCardPaddingTop(i);
    }

    private void updateMarketing(BillMarketing[] billMarketingArr) {
        if (billMarketingArr == null || billMarketingArr.length == 0) {
            ((IPayView) this.mView).setMarketing((String) null, (View.OnClickListener) null);
            return;
        }
        final BillMarketing billMarketing = billMarketingArr[0];
        ((IPayView) this.mView).setMarketing(billMarketing.title, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (!TextUtils.isEmpty(billMarketing.url)) {
                    UniPayWebModel uniPayWebModel = new UniPayWebModel();
                    uniPayWebModel.context = AbsUnifiedPaymentPresenter.this.mContext;
                    uniPayWebModel.url = billMarketing.url;
                    uniPayWebModel.sid = AbsUnifiedPaymentPresenter.this.mSid;
                    uniPayWebModel.requestCode = 5;
                    uniPayWebModel.intentFlag = View.NAVIGATION_BAR_UNHIDE;
                    UniPayWebUtil.startWebPage(uniPayWebModel, AbsUnifiedPaymentPresenter.this.mViewCallback);
                    AbsUnifiedPaymentPresenter.this.mEventManager.doOmegaPayCardCouponClick();
                }
            }
        });
        this.mEventManager.doOmegaPayCardCouponShow(getPayMethod(), this.mCoupon, this.mChannel);
    }

    private void updateVoucherView(DeductionInfo deductionInfo) {
        int i = deductionInfo.type;
        int i2 = deductionInfo.status;
        if (i == 3) {
            i2 = 5;
        }
        VoucherViewConfig voucherViewConfig = new VoucherViewConfig();
        voucherViewConfig.info = deductionInfo;
        if (deductionInfo.type == 1) {
            voucherViewConfig.deductionType = DeductionItemType.TYPE_VOUCHER;
        } else if (deductionInfo.type == 3) {
            voucherViewConfig.deductionType = DeductionItemType.REPLACE_ORDER_DEDUCTION;
        }
        voucherViewConfig.leftDes = "" + deductionInfo.name;
        String str = deductionInfo.deduction;
        if (TextUtils.isEmpty(str)) {
            String format = UnipayTextUtil.format(deductionInfo.cost);
            if (i2 == 1) {
                str = ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_voucher_deduction_value, format);
            } else if (i2 == 2) {
                str = ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_voucher_deduction_choose, format);
            } else if (i2 == 3) {
                str = ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_no_voucher, format);
            } else if (i2 == 4) {
                str = ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_not_support_voucher, format);
            } else if (i2 == 5) {
                str = ResourcesHelper.getString(this.mContext, R.string.oc_uni_pay_voucher_deduction_value, format);
            }
        }
        voucherViewConfig.rightDes = str;
        voucherViewConfig.showOrangeText = false;
        if (i2 == 1 || i2 == 5 || i2 == 2) {
            voucherViewConfig.showOrangeText = true;
        }
        voucherViewConfig.canClick = false;
        if ((i2 == 1 || i2 == 3 || i2 == 2) && !TextUtils.isEmpty(deductionInfo.url)) {
            voucherViewConfig.canClick = true;
            voucherViewConfig.url = deductionInfo.url;
        }
        if (voucherViewConfig.canClick) {
            voucherViewConfig.showRightIcon = true;
        } else {
            voucherViewConfig.showRightIcon = false;
        }
        voucherViewConfig.desc = deductionInfo.info;
        ((IPayView) this.mView).addDeductionItem(voucherViewConfig);
    }

    /* access modifiers changed from: protected */
    public void setTotalFee(BasicBill basicBill) {
        ((IPayView) this.mView).refreshTotalPayArea(basicBill.total_fee_title, basicBill.getPayMoneyDes(), basicBill.total_fee_include_text);
        String leftDes = basicBill.getLeftDes();
        String rightDes = basicBill.getRightDes();
        String needPayFee = basicBill.getNeedPayFee();
        if (!TextUtils.isEmpty(leftDes) || !TextUtils.isEmpty(rightDes)) {
            ((IPayView) this.mView).setDisplayFeeWithUnit(leftDes + needPayFee + rightDes);
        } else {
            ((IPayView) this.mView).setDisplayFee(needPayFee);
        }
        ((IPayView) this.mView).setJumpableItem(getFeeDes());
    }

    private void updateDeductionView(DeductionInfo[] deductionInfoArr) {
        ((IPayView) this.mView).removeAllDeductions();
        if (deductionInfoArr != null && deductionInfoArr.length > 0) {
            for (DeductionInfo deductionInfo : deductionInfoArr) {
                if (deductionInfo.type == 1) {
                    this.mCoupon = deductionInfo.couponId;
                }
                updateVoucherView(deductionInfo);
            }
        }
    }

    private void updatePlatformPayChannelView(InternalPayChannel[] internalPayChannelArr) {
        ArrayList arrayList = new ArrayList();
        int length = internalPayChannelArr.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                InternalPayChannel internalPayChannel = internalPayChannelArr[i];
                PlatformPayItem platformPayItem = new PlatformPayItem();
                if (PayTypeManager.isPlatformPayType(internalPayChannel.channel_id)) {
                    if (internalPayChannel.selected == 1) {
                        if (TextUtils.isEmpty(this.mChannel)) {
                            this.mChannel = "" + internalPayChannel.channel_id;
                        } else {
                            this.mChannel += "," + internalPayChannel.channel_id;
                        }
                    }
                    platformPayItem.channelId = internalPayChannel.channel_id;
                    platformPayItem.name = internalPayChannel.name;
                    platformPayItem.payMoney = internalPayChannel.deduction;
                    platformPayItem.flags = internalPayChannel.icon;
                    if (!TextUtils.isEmpty(internalPayChannel.info)) {
                        platformPayItem.balanceDes = this.mContext.getString(R.string.oc_pay_detail_str, new Object[]{internalPayChannel.info});
                    } else if (internalPayChannel.balance > 0) {
                        platformPayItem.balanceDes = this.mContext.getString(R.string.oc_uni_pay_balance_label, new Object[]{UnipayTextUtil.format(internalPayChannel.balance)});
                    }
                    PlatformDownGradeInfo.PlatformDownGrade platformDownGrade = PlatformDownGradeInfo.PlatformDownGrade.NORMAL;
                    int i2 = internalPayChannel.level;
                    if (i2 == 0) {
                        platformPayItem.canSelect = true;
                        if (internalPayChannel.selected <= 0) {
                            z = false;
                        }
                        platformPayItem.selected = z;
                        platformDownGrade = PlatformDownGradeInfo.PlatformDownGrade.NORMAL;
                    } else if (i2 == 1) {
                        platformPayItem.canSelect = true;
                        platformPayItem.selected = false;
                        platformDownGrade = PlatformDownGradeInfo.PlatformDownGrade.BALANCE_NOT_ENOUGH;
                    } else if (i2 == 3) {
                        platformPayItem.canSelect = false;
                        platformDownGrade = PlatformDownGradeInfo.PlatformDownGrade.NOT_USEABLE;
                    }
                    if (internalPayChannel.canSelect == 0) {
                        platformPayItem.canSelect = false;
                        platformPayItem.selected = false;
                    }
                    PlatformDownGradeInfo platformDownGradeInfo = new PlatformDownGradeInfo(platformDownGrade, internalPayChannel.extention);
                    platformDownGradeInfo.url = internalPayChannel.url;
                    platformPayItem.downGradeInfo = platformDownGradeInfo;
                    arrayList.add(platformPayItem);
                }
                i++;
            } else {
                ((IPayView) this.mView).updatePlatformPayView(arrayList, true);
                return;
            }
        }
    }

    private void updateThirdPayChannelView(ExternalPayChannel[] externalPayChannelArr) {
        if (externalPayChannelArr == null || externalPayChannelArr.length <= 0) {
            ((IPayView) this.mView).removeThirdPartPay();
            return;
        }
        ((IPayView) this.mView).updateThirdPartPayView(toCommonPayChannel(externalPayChannelArr), getSelectedPayChannelIndex(externalPayChannelArr), true);
    }

    private List<PayChannelItem> toCommonPayChannel(ExternalPayChannel[] externalPayChannelArr) {
        DownGradeInfo downGradeInfo;
        ArrayList arrayList = new ArrayList();
        for (ExternalPayChannel externalPayChannel : externalPayChannelArr) {
            if (PayConstant.isGlobalThirdChannel(externalPayChannel.channel_id)) {
                boolean z = true;
                if (externalPayChannel.selected == 1) {
                    if (TextUtils.isEmpty(this.mChannel)) {
                        this.mChannel = "" + externalPayChannel.channel_id;
                    } else {
                        this.mChannel += "," + externalPayChannel.channel_id;
                    }
                }
                PayChannelItem payChannelItem = new PayChannelItem();
                payChannelItem.payName = externalPayChannel.name;
                payChannelItem.payNumber = externalPayChannel.channel_number;
                payChannelItem.detail = externalPayChannel.info;
                payChannelItem.iconUrl = externalPayChannel.icon;
                payChannelItem.flags = externalPayChannel.icon;
                payChannelItem.marketing_text = externalPayChannel.marketing_text;
                if (3 == externalPayChannel.level) {
                    downGradeInfo = new DownGradeInfo(DownGradeInfo.DownGrade.NOT_USEABLE, externalPayChannel.extension);
                } else if (1 == externalPayChannel.level) {
                    downGradeInfo = new DownGradeInfo(DownGradeInfo.DownGrade.NOT_STABLE, externalPayChannel.extension);
                } else {
                    downGradeInfo = new DownGradeInfo(DownGradeInfo.DownGrade.NORMAL, "");
                }
                payChannelItem.canCancel = externalPayChannel.canCancel == 1;
                payChannelItem.downGradeInfo = downGradeInfo;
                payChannelItem.channelId = externalPayChannel.channel_id;
                if (!this.mExpandAllThirdPayItemByUser) {
                    if (externalPayChannel.hidden != 1) {
                        z = false;
                    }
                    payChannelItem.isHide = z;
                }
                payChannelItem.iconUrl = externalPayChannel.icon;
                arrayList.add(payChannelItem);
            }
        }
        return arrayList;
    }

    private int getSelectedPayChannelIndex(ExternalPayChannel[] externalPayChannelArr) {
        for (int i = 0; i < externalPayChannelArr.length; i++) {
            ExternalPayChannel externalPayChannel = externalPayChannelArr[i];
            if (externalPayChannel != null && externalPayChannel.selected == 1) {
                return i;
            }
        }
        return -1;
    }

    private void updatePayBtnView(String str, boolean z) {
        if (z) {
            ((IPayView) this.mView).setPayBtnState(PayBtnState.ENABLE);
        } else {
            ((IPayView) this.mView).setPayBtnState(PayBtnState.DISABLE);
        }
        ((IPayView) this.mView).setPayBtnText(str);
    }

    public void getPayInfo() {
        super.getPayInfo();
        ((IPayView) this.mView).showLoadingView(this.mContext.getString(R.string.oc_uni_pay_loading_bill), true);
    }

    /* access modifiers changed from: protected */
    public void refreshOrderBillAndAutoPay(final int i) {
        C144352 r0 = new PayServiceCallback<PayInfo>() {
            public void onSuccess(PayInfo payInfo) {
                ExternalPayChannel[] externalPayChannelArr;
                ((IPayView) AbsUnifiedPaymentPresenter.this.mView).showLoadingView("", false);
                if (payInfo.billDetail != null && (externalPayChannelArr = payInfo.billDetail.externalChannels) != null && externalPayChannelArr.length > 0 && AbsUnifiedPaymentPresenter.this.containPayChan(externalPayChannelArr, i)) {
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
                PayInfoManager.getInstance(UniPayParamUtil.getLang()).setPayInfo(AbsUnifiedPaymentPresenter.this.getOrderId(), payInfo);
                AbsUnifiedPaymentPresenter.this.handlePayInfo(payInfo);
            }

            public void onFail(Error error) {
                AbsUnifiedPaymentPresenter.this.mWindowManager.payFailedAndReflushBill(error.msg, AbsUnifiedPaymentPresenter.this.getPayMethod(), AbsUnifiedPaymentPresenter.this.mCoupon, AbsUnifiedPaymentPresenter.this.mChannel);
            }
        };
        ((IPayView) this.mView).showLoadingView(this.mContext.getString(R.string.oc_uni_pay_loading_bill), true);
        if (this.mUnifiedPaySystem != null) {
            this.mUnifiedPaySystem.getPayInfo(r0, 20);
        }
    }

    /* access modifiers changed from: private */
    public boolean containPayChan(ExternalPayChannel[] externalPayChannelArr, int i) {
        if (externalPayChannelArr != null && externalPayChannelArr.length >= 1) {
            for (ExternalPayChannel externalPayChannel : externalPayChannelArr) {
                if (externalPayChannel.channel_id == i) {
                    return true;
                }
            }
        }
        return false;
    }

    private PayParamObject getPayTypeObject() {
        PayTypes payMethodTypes = ((IPayView) this.mView).getPayMethodTypes();
        PayParamObject payParamObject = new PayParamObject();
        payParamObject.checkPayResultSilent = true;
        payParamObject.canUseEntraprisepay = payMethodTypes.canUseEntraprisepay;
        payParamObject.thirdPayType = payMethodTypes.thirdPartPayType;
        payParamObject.platformPayType = payMethodTypes.platformPayType;
        payParamObject.wXAppId = getWxAppid();
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId());
        if (payInfo != null && payInfo.billDetail != null) {
            DetailBill detailBill = payInfo.billDetail;
            ExternalPayChannel[] externalPayChannelArr = detailBill.externalChannels;
            int i = 0;
            if (externalPayChannelArr != null) {
                int i2 = 0;
                while (true) {
                    if (i2 < externalPayChannelArr.length) {
                        ExternalPayChannel externalPayChannel = externalPayChannelArr[i2];
                        if (externalPayChannel != null && externalPayChannel.channel_id == payParamObject.thirdPayType) {
                            payParamObject.needSign = externalPayChannel.needSign;
                            payParamObject.signData = externalPayChannel.signObj;
                            payParamObject.needInputPwd = externalPayChannel.needPasswd;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
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
        SignResultModel signResultModel;
        DidiCreditCardData.Result result;
        String str = TAG;
        LogUtil.m31685fi(str, "onActivityResult requestCode:" + i + " resultCode:" + i2);
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (11 == i) {
            getPayInfo();
        } else if (3 == i) {
            if (i2 == -1 && extras != null) {
                changeVoucher(extras.getString("para_coupons_select"));
            }
        } else if (100 == i) {
            if (intent != null && (result = (DidiCreditCardData.Result) intent.getSerializableExtra(DidiCreditCardData.PAY_RESULT)) != null && 1 == result.code) {
                refreshOrderBillAndAutoPay(150);
            }
        } else if (102 == i) {
            if (i2 != -1 || extras == null || (signResultModel = (SignResultModel) extras.getSerializable("param_ddcredit_bind_result")) == null || signResultModel.result != 2) {
                getPayInfo();
            }
        } else if (104 == i) {
            if (i2 != -1) {
                onPayFailed(new PayError(1), "");
            } else if (extras != null) {
                PayResult payResult = (PayResult) extras.getSerializable("BANK_PAY_RESULT");
                if (payResult.result == 1) {
                    this.mUnifiedPaySystem.startSyncPayResult(15, 3000);
                } else if (payResult.result == 2) {
                    onPayFailed(new PayError(5), "");
                }
            }
        } else if (5 == i) {
            ((IPayView) this.mView).showLoadingView(this.mContext.getString(R.string.oc_uni_pay_loading_bill), true);
            this.mUnifiedPaySystem.changePayInfo(5, this.mPayinfoCallback);
        } else if (106 == i) {
            refreshOrderBillAndAutoPay(152);
        }
    }

    private void onNoPwdPay() {
        ((IPayView) this.mView).showLoadingView(ResourcesHelper.getString(this.mContext, R.string.car_no_pwd_pay_wait_title), true);
        this.mUnifiedPaySystem.registerCallback(this.mPayCallback);
        this.mUnifiedPaySystem.startSyncPayResult(15, 3000);
    }

    public void queryPayResult(boolean z, LoadingState loadingState, int i) {
        ((IPayView) this.mView).showQueryPayResultView(true, loadingState, i);
        ((IPayView) this.mView).setCloseIconEnable(false);
        if (z) {
            this.mUnifiedPaySystem.startSyncPayResult(15, 3000);
        }
    }

    private String getFeeDes() {
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(getOrderId());
        if (payInfo == null || payInfo.billBasic == null) {
            return "";
        }
        ActionType[] actionTypeArr = payInfo.billBasic.actionTypes;
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

    public void onShowQueryPayResultView() {
        this.mEventManager.doOmegaPayCardResultWait(getPayMethod(), this.mCoupon, this.mChannel);
    }

    public void onPaySuccess() {
        this.mEventManager.doOmegaPayCardSuccess(getPayMethod(), this.mCoupon, this.mChannel);
    }

    /* access modifiers changed from: private */
    public String getPayMethod() {
        return ((IPayView) this.mView).getPayMethod();
    }
}
