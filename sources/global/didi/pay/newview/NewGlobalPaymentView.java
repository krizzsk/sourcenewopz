package global.didi.pay.newview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifiedPay.component.manager.PayMethodManager;
import com.didi.unifiedPay.component.model.PayChannelItem;
import com.didi.unifiedPay.component.model.PayErrorEvent;
import com.didi.unifiedPay.component.model.PayTypes;
import com.didi.unifiedPay.component.model.PlatformPayItem;
import com.didi.unifiedPay.component.view.DeductionItemType;
import com.didi.unifiedPay.component.view.IInstallmentView;
import com.didi.unifiedPay.component.view.IPayView;
import com.didi.unifiedPay.component.view.PayBizType;
import com.didi.unifiedPay.component.view.PayBtnState;
import com.didi.unifiedPay.component.view.VoucherViewConfig;
import com.didi.unifiedPay.component.widget.FailStateView;
import com.didi.unifiedPay.component.widget.RootLinearLayout;
import com.didi.unifiedPay.component.widget.ToastView;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.model.BasicBill;
import com.didi.unifiedPay.sdk.model.InstallmentModel;
import com.didi.unifiedPay.sdk.model.InternalPayChannel;
import com.didi.unifiedPay.sdk.model.MerchantInfo;
import com.didi.unifiedPay.sdk.model.TransactionFee;
import com.didi.unifiedPay.util.UIUtils;
import com.didi.unifiedPay.util.UiThreadHandler;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.taxis99.R;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.model.GlobalPayType;
import global.didi.pay.model.LoadingState;
import global.didi.pay.newview.NewGlobalPaymentViewController;
import global.didi.pay.newview.pix.IPixView;
import global.didi.pay.newview.pix.NewGlobalPaymentPixCodeView;
import global.didi.pay.newview.pix.NewGlobalPaymentPixPrepayView;
import global.didi.pay.presenter.GlobalRedPointHelper;
import global.didi.pay.view.dialog.UnifiedPayDialogConfig;
import global.didi.pay.view.popup.CashierBubble;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rui.config.RConfigConstants;

public class NewGlobalPaymentView extends FrameLayout implements IGlobalPayView {
    /* access modifiers changed from: private */
    public boolean isFirstPixPrepay;
    private NewGlobalPaymentBalanceView mBalanceView;
    private NewGlobalPaymentBillAmountView mBillAmountView;
    /* access modifiers changed from: private */
    public Context mContext;
    private NewGlobalPaymentDeductionView mDeductionView;
    /* access modifiers changed from: private */
    public View.OnClickListener mErrorRetryClickListener;
    private NewGlobalPaymentFeeView mFeeView;
    /* access modifiers changed from: private */
    public IInstallmentView.IInstallmentListener mInstallmentListener;
    private NewGlobalPaymentInstallmentView mInstallmentView;
    /* access modifiers changed from: private */
    public IPayView.PayViewListener mListener;
    private NewGlobalPaymentMerchantView mMerchantView;
    private View mPayCenterLayout;
    private View mPayContentLayout;
    private View mPayEmptyLayout;
    private NewGlobalPaymentStateView mPayStateView;
    /* access modifiers changed from: private */
    public NewGlobalPaymentChannelView mPaymentChannelView;
    private NewGlobalPaymentSubmitView mPaymentSubmitView;
    private NewGlobalPaymentPixCodeView mPixCodeView;
    private NewGlobalPaymentPixPrepayView mPixPrepayView;
    /* access modifiers changed from: private */
    public IPixView.PixViewListener mPixViewListener;
    private RootLinearLayout mRootGroupView;
    private NewGlobalPayTitleView mTitleView;
    private NewGlobalPaymentTransactionFeeView mTransactionFeeView;
    /* access modifiers changed from: private */
    public NewGlobalPaymentViewController mViewController;

    @Deprecated
    public String getInitPayMethod() {
        return "";
    }

    public String getUIType() {
        return IGlobalPayView.TYPE_NEW_UI;
    }

    public View getView() {
        return this;
    }

    public void hideLoadingPop(boolean z) {
    }

    @Deprecated
    public boolean isCloseIconEnable() {
        return false;
    }

    @Deprecated
    public boolean isPayItemsExpand() {
        return true;
    }

    @Deprecated
    public PayErrorEvent isShowErrorView() {
        return null;
    }

    public boolean isShowSuccessOnBtn() {
        return false;
    }

    public boolean newUIType() {
        return true;
    }

    @Deprecated
    public void refreshTotalPayArea(String str, String str2, String str3) {
    }

    @Deprecated
    public void removeThirdPartPay() {
    }

    @Deprecated
    public void selectedPayItem(PayChannelItem payChannelItem) {
    }

    @Deprecated
    public void setBizType(PayBizType payBizType) {
    }

    @Deprecated
    public void setCancelableForThirdPay(boolean z) {
    }

    @Deprecated
    public void setCardPaddingTop(int i) {
    }

    @Deprecated
    public void setChangePayItemResult(boolean z) {
    }

    @Deprecated
    public void setCloseIconEnable(boolean z) {
    }

    @Deprecated
    public void setCradTitle(String str) {
    }

    @Deprecated
    public void setMarketing(String str, View.OnClickListener onClickListener) {
    }

    @Deprecated
    public void setPayStatement(String str) {
    }

    @Deprecated
    public void setPayTypeInfo(CharSequence charSequence) {
    }

    @Deprecated
    public void setPayTypeInfo(String str) {
    }

    @Deprecated
    public void setThirdPartPayChangeMode(boolean z) {
    }

    @Deprecated
    public void setVoucherDeductible(double d) {
    }

    @Deprecated
    public void setVoucherView(VoucherViewConfig voucherViewConfig) {
    }

    @Deprecated
    public void showErrorView(FailStateView.Config config) {
    }

    @Deprecated
    public void showFeeDetailEntraView(boolean z) {
    }

    @Deprecated
    public void showOrHideDeductionItem(DeductionItemType deductionItemType, boolean z) {
    }

    @Deprecated
    public void showOrHideDeductions(boolean z) {
    }

    @Deprecated
    public void showThirdPartPay() {
    }

    public void showToastView(ToastView.Config config) {
    }

    @Deprecated
    public void showVoucherView(boolean z) {
    }

    @Deprecated
    public void updatePlatformPayView(List<PlatformPayItem> list) {
    }

    @Deprecated
    public void updatePlatformPayView(List<PlatformPayItem> list, boolean z) {
    }

    public NewGlobalPaymentView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NewGlobalPaymentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewGlobalPaymentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_g_payment_layout, this);
        this.mRootGroupView = (RootLinearLayout) findViewById(R.id.g_payment_root);
        this.mPayContentLayout = findViewById(R.id.g_payment_content);
        this.mPayEmptyLayout = findViewById(R.id.g_payment_net_error_icon);
        this.mPayCenterLayout = findViewById(R.id.g_payment_center);
        this.mTitleView = (NewGlobalPayTitleView) findViewById(R.id.g_payment_title);
        this.mFeeView = (NewGlobalPaymentFeeView) findViewById(R.id.g_payment_fee);
        this.mMerchantView = (NewGlobalPaymentMerchantView) findViewById(R.id.g_payment_merchant);
        this.mPayStateView = (NewGlobalPaymentStateView) findViewById(R.id.g_payment_state);
        this.mBalanceView = (NewGlobalPaymentBalanceView) findViewById(R.id.g_payment_layout_balance);
        this.mPaymentChannelView = (NewGlobalPaymentChannelView) findViewById(R.id.g_payment_layout_paymentcheck);
        this.mDeductionView = (NewGlobalPaymentDeductionView) findViewById(R.id.g_payment_deduction);
        this.mInstallmentView = (NewGlobalPaymentInstallmentView) findViewById(R.id.g_payment_layout_installment);
        this.mPaymentSubmitView = this.mPayStateView.getSubmitView();
        this.mPixCodeView = (NewGlobalPaymentPixCodeView) findViewById(R.id.g_payment_pix_code);
        this.mPixPrepayView = (NewGlobalPaymentPixPrepayView) findViewById(R.id.g_payment_pix_prepay);
        this.mBillAmountView = (NewGlobalPaymentBillAmountView) findViewById(R.id.g_payment_layout_bill_amount);
        this.mTransactionFeeView = (NewGlobalPaymentTransactionFeeView) findViewById(R.id.g_payment_layout_trans_fee);
        this.mViewController = new NewGlobalPaymentViewController.Builder(this.mContext).setRootView(this.mRootGroupView).setContentLayout(this.mPayContentLayout).setEmptyLayout(this.mPayEmptyLayout).setCenterLayout(this.mPayCenterLayout).setTitleView(this.mTitleView).setStateView(this.mPayStateView).setSubmitView(this.mPaymentSubmitView).setPixCodeView(this.mPixCodeView).setPixPrepayView(this.mPixPrepayView).build();
        initListener();
    }

    private void initListener() {
        this.mPaymentSubmitView.setSubmitClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (!NewGlobalPaymentView.this.mViewController.isRetryViewShowed()) {
                    NewGlobalPaymentView.this.onPayBtnClick();
                } else if (NewGlobalPaymentView.this.mErrorRetryClickListener != null) {
                    NewGlobalPaymentView.this.mErrorRetryClickListener.onClick(view);
                }
            }
        });
        this.mFeeView.setFeeClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mListener != null) {
                    NewGlobalPaymentView.this.mListener.onShowFeeDetailClick();
                }
            }
        });
        this.mDeductionView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NewGlobalPaymentView.this.mListener.onDeductionItemClick((VoucherViewConfig) view.getTag());
            }
        });
        this.mInstallmentView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mInstallmentListener != null) {
                    NewGlobalPaymentView.this.mInstallmentListener.onInstallmentClick();
                }
            }
        });
        this.mTitleView.setCloseListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mListener != null) {
                    NewGlobalPaymentView.this.mListener.onCloseBtnClick();
                }
            }
        });
        this.mTitleView.setPixCloseListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mListener != null) {
                    NewGlobalPaymentView.this.mListener.onClosePixBtnClick();
                }
            }
        });
        this.mPixCodeView.setOnCancelClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mPixViewListener != null) {
                    NewGlobalPaymentView.this.mPixViewListener.onPixCancel(NewGlobalPaymentView.this.isFirstPixPrepay);
                }
            }
        });
        this.mPixCodeView.setOnConfirmClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mPixViewListener != null) {
                    NewGlobalPaymentView.this.mPixViewListener.onPixConfirm(NewGlobalPaymentView.this.isFirstPixPrepay);
                }
            }
        });
        this.mPixCodeView.setOnPaidClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mPixViewListener != null) {
                    NewGlobalPaymentView.this.mPixViewListener.onPixPaid(NewGlobalPaymentView.this.isFirstPixPrepay);
                }
            }
        });
        this.mPixPrepayView.setOnConfirmClick(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mPixViewListener != null) {
                    NewGlobalPaymentView.this.mPixViewListener.onPixConfirm(NewGlobalPaymentView.this.isFirstPixPrepay);
                }
            }
        });
        this.mPixPrepayView.setOnChangeClick(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mPixViewListener != null) {
                    NewGlobalPaymentView.this.mPixViewListener.onPixChange(NewGlobalPaymentView.this.isFirstPixPrepay);
                }
            }
        });
        this.mPixPrepayView.setOnCancelClick(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mPixViewListener != null) {
                    NewGlobalPaymentView.this.mPixViewListener.onPixCancel(NewGlobalPaymentView.this.isFirstPixPrepay);
                }
            }
        });
        this.mPixPrepayView.setOnPaidClick(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mPixViewListener != null) {
                    NewGlobalPaymentView.this.mPixViewListener.onPixPaid(NewGlobalPaymentView.this.isFirstPixPrepay);
                }
            }
        });
    }

    public void setTitle(boolean z, String str, String str2) {
        this.mTitleView.setTitle(str, (int) R.color.black);
        this.mTitleView.setMessage(str2);
        if (z && !this.mViewController.isErrorViewShowed() && !this.mViewController.isPixCodeShowed()) {
            this.mViewController.showPayInfoView();
        }
    }

    public void setTitle(boolean z, boolean z2, String str, String str2) {
        setTitle(z, str, str2);
    }

    public void setTitleLink(boolean z, String str, final String str2, final IGlobalPayView.OnWebLinkClickListener onWebLinkClickListener) {
        int color = z ? getContext().getResources().getColor(R.color.black) : 0;
        if (!TextUtils.isEmpty(str) && str.startsWith(RConfigConstants.KEYWORD_COLOR_SIGN)) {
            try {
                color = Color.parseColor(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mTitleView.setMessageColor(color);
        this.mTitleView.setMessageClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                onWebLinkClickListener.onClick(str2);
            }
        });
    }

    public void showRetryView(View.OnClickListener onClickListener) {
        this.mErrorRetryClickListener = onClickListener;
        this.mViewController.showRetryView();
        this.mPaymentSubmitView.setSubmitText(this.mContext.getString(R.string.oc_fail_state_retry));
        resetViewClickable();
    }

    public void showLoadingPop(int i) {
        showLoadingView("", true, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPayInfoLoadComplete(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -251149995(0xfffffffff107c155, float:-6.722272E29)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = -148466385(0xfffffffff726952f, float:-3.3786995E33)
            if (r0 == r1) goto L_0x0020
            r1 = 1505332425(0x59b98cc9, float:6.5284582E15)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "pix_prepay_page"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "pix_page"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "main_page"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 0
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            if (r5 == 0) goto L_0x0048
            if (r5 == r3) goto L_0x0042
            if (r5 == r2) goto L_0x003c
            goto L_0x004d
        L_0x003c:
            global.didi.pay.newview.NewGlobalPaymentViewController r5 = r4.mViewController
            r5.showPixPrepayView()
            goto L_0x004d
        L_0x0042:
            global.didi.pay.newview.NewGlobalPaymentViewController r5 = r4.mViewController
            r5.showPixCodeView()
            goto L_0x004d
        L_0x0048:
            global.didi.pay.newview.NewGlobalPaymentViewController r5 = r4.mViewController
            r5.showPayInfoView()
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.newview.NewGlobalPaymentView.onPayInfoLoadComplete(java.lang.String):void");
    }

    public void updateInstallment(InstallmentModel installmentModel) {
        if (installmentModel == null) {
            this.mInstallmentView.setCurrentNumber((String) null);
            this.mInstallmentView.setVisibility(8);
            return;
        }
        this.mInstallmentView.setVisibility(0);
        this.mInstallmentView.setCurrentNumber(installmentModel.getNumber());
        this.mInstallmentView.setContent(installmentModel.getNumber(), installmentModel.getEachAmount());
        this.mInstallmentView.setDesc(installmentModel.getInfo());
    }

    public void updateInstallmentRedPoint(boolean z) {
        this.mInstallmentView.setRedPointVisibility(z ? 0 : 8);
    }

    public String getCurrentInstallmentNumber() {
        return this.mInstallmentView.getCurrentNumber();
    }

    public String getHelperUrl() {
        return this.mInstallmentView.getHelperUrl();
    }

    public void setHelperUrl(String str) {
        this.mInstallmentView.setHelperUrl(str);
    }

    public void showInstallmentBubble(String str) {
        TextPaint paint = this.mPaymentChannelView.getTextView().getPaint();
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length() - 1, rect);
        int abs = Math.abs(rect.right - rect.left);
        int abs2 = Math.abs(rect.bottom - rect.top);
        final int dip2px = (UIUtils.dip2px(this.mContext, 16.0f) * 2) + abs > UIUtils.dip2px(this.mContext, 250.0f) ? UIUtils.dip2px(this.mContext, 250.0f) : -1;
        final int i = (UIUtils.dip2px(this.mContext, 16.0f) * 2) + abs > UIUtils.dip2px(this.mContext, 250.0f) ? -500 : -abs;
        final int dip2px2 = (abs2 * 2) + (UIUtils.dip2px(this.mContext, 11.0f) * 4) + UIUtils.dip2px(this.mContext, 20.0f);
        final String str2 = str;
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                new CashierBubble.Builder(NewGlobalPaymentView.this.mContext).setText(str2).setWidthAndHeight(dip2px, -2).setOutSideTouch(true).setDirection("bottom_right").build().show(NewGlobalPaymentView.this.mPaymentChannelView.getTextView(), i, -dip2px2);
            }
        }, 500);
    }

    public void updatePix(String str, String str2) {
        this.isFirstPixPrepay = TextUtils.equals(str2, IPixView.PAGE_STATUS_INIT);
        NewGlobalPaymentPixPrepayView newGlobalPaymentPixPrepayView = this.mPixPrepayView;
        if (newGlobalPaymentPixPrepayView != null) {
            newGlobalPaymentPixPrepayView.updatePixCode(str);
            this.mPixPrepayView.updatePixViewStatus(str2);
            NewGlobalPaymentPixCodeView newGlobalPaymentPixCodeView = this.mPixCodeView;
            if (newGlobalPaymentPixCodeView != null) {
                newGlobalPaymentPixCodeView.updatePixCode(str);
                this.mPixCodeView.updatePixViewStatus(str2);
            }
        }
    }

    public void showLoadingView(String str, boolean z) {
        showLoadingView(str, z, LoadingState.TYPE_LOADING.type);
    }

    public void showLoadingView(String str, boolean z, int i) {
        showLoadingView(str, z, i, 0);
    }

    public void showLoadingView(String str, boolean z, int i, int i2) {
        this.mViewController.showLoadingView(str, z, i, i2);
    }

    public void updatePayType(GlobalPayType globalPayType) {
        this.mPaymentChannelView.setCurrentSelectedType(globalPayType);
    }

    public void updateBalance(InternalPayChannel internalPayChannel, IGlobalPayView.CheckCallBack checkCallBack) {
        this.mBalanceView.update(internalPayChannel, checkCallBack);
    }

    public void updateBillAmount(BasicBill basicBill) {
        this.mBillAmountView.updateBillAmount(basicBill);
        this.mBillAmountView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    public void updateTransactionFee(final TransactionFee transactionFee) {
        this.mTransactionFeeView.updateTransactionFee(transactionFee);
        this.mTransactionFeeView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mTransactionFeeView.setFeeClickListener(new Function1<String, Unit>() {
            public Unit invoke(String str) {
                UnifiedPayDialogConfig unifiedPayDialogConfig = UnifiedPayDialogConfig.TIP_TRANSACTION_FEE;
                TransactionFee transactionFee = transactionFee;
                unifiedPayDialogConfig.setSubContent(transactionFee == null ? "" : transactionFee.explanation);
                NewGlobalPaymentView.this.mViewController.showTipDialog(unifiedPayDialogConfig, new IGlobalPayView.DialogTipsListener() {
                    public void onConfirm() {
                        NewGlobalPaymentView.this.onPayInfoLoadComplete(IPayView.TYPE_MAIN);
                    }
                });
                return null;
            }
        });
    }

    public void setDisplayFee(String str) {
        this.mFeeView.setDisplayFee(str);
    }

    public void setDisplayFeeWithUnit(String str) {
        this.mFeeView.setDisplayFeeWithUnit(str);
        this.mPixPrepayView.setDisplayFeeWithUnit(str);
    }

    public void setCrossFeeWithUnit(String str) {
        this.mFeeView.setCrossFeeWithUnit(str);
    }

    public void updateCashbackInfo(String str) {
        this.mFeeView.updateCashback(str);
    }

    public void updateMerchantInfo(MerchantInfo merchantInfo) {
        if (merchantInfo == null || TextUtils.isEmpty(merchantInfo.merchantName)) {
            this.mMerchantView.setVisibility(8);
            return;
        }
        this.mMerchantView.setVisibility(0);
        this.mMerchantView.setValue(merchantInfo.merchantName);
    }

    @Deprecated
    public void setJumpableItem(String str) {
        if (UnipayTextUtil.isEmpty(str)) {
            this.mFeeView.setFeeClickListener((View.OnClickListener) null);
            this.mPixPrepayView.setFeeClickListener((View.OnClickListener) null);
            this.mFeeView.showFeeArrowVisibility(8);
            this.mPixPrepayView.showFeeArrowVisibility(8);
            return;
        }
        this.mFeeView.showFeeArrowVisibility(0);
        this.mPixPrepayView.showFeeArrowVisibility(0);
        this.mFeeView.setFeeClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mListener != null) {
                    NewGlobalPaymentView.this.mListener.onShowFeeDetailClick();
                }
            }
        });
        this.mPixPrepayView.setFeeClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mListener != null) {
                    NewGlobalPaymentView.this.mListener.onShowFeeDetailClick();
                }
            }
        });
    }

    public void addDeductionItem(VoucherViewConfig voucherViewConfig) {
        this.mDeductionView.addDeductionItem(voucherViewConfig);
    }

    public void addDeductionItems(List<VoucherViewConfig> list) {
        this.mDeductionView.addDeductionItems(list);
    }

    public void removeAllDeductions() {
        this.mDeductionView.removeAllDeductions();
    }

    public void updateThirdPartPayView(List<PayChannelItem> list, int i) {
        updateThirdPartPayView(list, i, false);
    }

    public void updateThirdPartPayView(List<PayChannelItem> list, int i, boolean z) {
        GlobalPayType globalPayType = new GlobalPayType();
        globalPayType.mPayTypes = new PayTypes();
        if (list != null && list.size() > 0) {
            PayChannelItem payChannelItem = list.get(0);
            if (PayConstant.isGlobalThirdChannel(payChannelItem.channelId)) {
                globalPayType.mPayTypes.thirdPartPayType = payChannelItem.channelId;
                globalPayType.name = payChannelItem.payNumber;
                if (!TextUtils.isEmpty(payChannelItem.expired_desc)) {
                    globalPayType.name = payChannelItem.payNumber + "(" + payChannelItem.expired_desc + ")";
                }
            } else if (121 == payChannelItem.channelId) {
                globalPayType.mPayTypes.canUseEntraprisepay = true;
                globalPayType.mPayTypes.platformPayType = payChannelItem.channelId;
            }
            globalPayType.iconUrl = payChannelItem.iconUrl;
            if (TextUtils.isEmpty(globalPayType.name)) {
                globalPayType.name = payChannelItem.payName;
            }
            this.mPaymentChannelView.setRedPointVisibility(GlobalRedPointHelper.getRedPointVisibility(this.mContext, payChannelItem.channelId, payChannelItem.is_new_channel));
            this.mPaymentChannelView.setDesc(payChannelItem.deposit_msg);
        }
        this.mPaymentChannelView.setCurrentSelectedType(globalPayType);
        this.mPaymentChannelView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentView.this.mListener != null) {
                    NewGlobalPaymentView.this.mListener.onPayItemSelected(0, (PayChannelItem) null);
                }
            }
        });
    }

    public void setPayBtnText(String str) {
        if (!UnipayTextUtil.isEmpty(str)) {
            this.mPaymentSubmitView.setSubmitText(str);
        }
    }

    public PayTypes getPayMethodTypes() {
        if (this.mPaymentChannelView.getCurrentSelectedType() != null) {
            return this.mPaymentChannelView.getCurrentSelectedType().mPayTypes;
        }
        return null;
    }

    public void setPayBtnState(PayBtnState payBtnState) {
        if (payBtnState == PayBtnState.ENABLE) {
            this.mPaymentSubmitView.setSubmitEnable(true);
        } else if (payBtnState == PayBtnState.DISABLE) {
            this.mPaymentSubmitView.setSubmitEnable(false);
        } else {
            PayBtnState payBtnState2 = PayBtnState.LOADING;
        }
    }

    public void resetViewClickable() {
        setPayBtnState(PayBtnState.ENABLE);
        if (this.mRootGroupView.isIntercept()) {
            this.mRootGroupView.setIntercept(false);
        }
    }

    public void onPayBtnClick() {
        this.mListener.onPayButtonClick();
    }

    public void setListener(IPayView.PayViewListener payViewListener) {
        this.mListener = payViewListener;
    }

    public void setPixViewListener(IPixView.PixViewListener pixViewListener) {
        this.mPixViewListener = pixViewListener;
    }

    public void setInstallmentListener(IInstallmentView.IInstallmentListener iInstallmentListener) {
        this.mInstallmentListener = iInstallmentListener;
    }

    public String getPixCode() {
        return this.mPixCodeView.getPixCode();
    }

    public void showQueryPayResultView(boolean z, LoadingState loadingState, int i) {
        if (z) {
            IPayView.PayViewListener payViewListener = this.mListener;
            if (payViewListener != null) {
                payViewListener.onShowQueryPayResultView();
            }
            if (loadingState == null) {
                loadingState = LoadingState.TYPE_WAITING;
            }
            showLoadingView("", true, loadingState.type, i);
            return;
        }
        showLoadingView("", false);
        resetViewClickable();
    }

    public void showSuccessView(boolean z) {
        showSuccessView(z, "");
    }

    public void showSuccessView(boolean z, String str) {
        if (getContext() != null && !((Activity) getContext()).isFinishing()) {
            this.mViewController.showPaySuccessView(str);
        }
    }

    public void showConfirmDialog(UnifiedPayDialogConfig unifiedPayDialogConfig, IGlobalPayView.DialogConfirmListener dialogConfirmListener) {
        this.mViewController.showConfirmDialog(unifiedPayDialogConfig, dialogConfirmListener);
    }

    public void showSuccessOnPayBtn() {
        showSuccessView(true);
    }

    public String getPayMethod() {
        GlobalPayType currentSelectedType;
        NewGlobalPaymentChannelView newGlobalPaymentChannelView = this.mPaymentChannelView;
        if (newGlobalPaymentChannelView == null || (currentSelectedType = newGlobalPaymentChannelView.getCurrentSelectedType()) == null || currentSelectedType.mPayTypes == null) {
            return "";
        }
        return PayMethodManager.getPayMethodFromType(currentSelectedType.mPayTypes.canUseEntraprisepay ? currentSelectedType.mPayTypes.platformPayType : currentSelectedType.mPayTypes.thirdPartPayType);
    }
}
