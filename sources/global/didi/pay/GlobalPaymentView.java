package global.didi.pay;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
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
import com.didi.unifiedPay.util.SimpleSpanStringBuilder;
import com.didi.unifiedPay.util.UIUtils;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.taxis99.R;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.model.GlobalPayType;
import global.didi.pay.model.LoadingState;
import global.didi.pay.newview.pix.IPixView;
import global.didi.pay.p236ui.theme.UnifiedPayThemeManager;
import global.didi.pay.presenter.GlobalRedPointHelper;
import global.didi.pay.view.GlobalErrorView;
import global.didi.pay.view.GlobalPayTitleView;
import global.didi.pay.view.GlobalPaymentBalanceView;
import global.didi.pay.view.GlobalPaymentCheckView;
import global.didi.pay.view.dialog.UnifiedPayDialogConfig;
import java.util.List;
import rui.config.RConfigConstants;

public class GlobalPaymentView extends FrameLayout implements View.OnClickListener, IGlobalPayView {
    private TextView feeDetail;
    private GlobalPaymentBalanceView mBalanceView;
    private Context mContext;
    private Dialog mInfoDialog;
    private ImageView mLineView;
    protected IPayView.PayViewListener mListener;
    private GlobalPaymentCheckView mPaymentCheckView;
    private LinearLayout mSupplyContainer;
    private ImageView mSupplyContainerSubline;
    private GlobalPayTitleView mTitleView;
    private View mView;
    protected LinearLayout payBizViewLayout;
    private TextView payBtn;
    private ImageView payLoadingBtn;
    protected FrameLayout payStateLayout;
    private TextView payStatementTv;
    protected RootLinearLayout rootGroupView;
    private LinearLayout totalFeeContainer;
    private TextView totalFeeTv;

    public String getCurrentInstallmentNumber() {
        return null;
    }

    public String getHelperUrl() {
        return null;
    }

    public String getInitPayMethod() {
        return "";
    }

    public String getPixCode() {
        return null;
    }

    public String getUIType() {
        return IGlobalPayView.TYPE_OLD_UI;
    }

    public View getView() {
        return this;
    }

    public boolean isCloseIconEnable() {
        return true;
    }

    public boolean isPayItemsExpand() {
        return true;
    }

    public PayErrorEvent isShowErrorView() {
        return null;
    }

    public boolean isShowSuccessOnBtn() {
        return false;
    }

    public boolean newUIType() {
        return false;
    }

    public void onPayInfoLoadComplete(String str) {
    }

    public void refreshTotalPayArea(String str, String str2, String str3) {
    }

    public void removeThirdPartPay() {
    }

    public void selectedPayItem(PayChannelItem payChannelItem) {
    }

    public void setBizType(PayBizType payBizType) {
    }

    public void setCancelableForThirdPay(boolean z) {
    }

    public void setCardPaddingTop(int i) {
    }

    public void setChangePayItemResult(boolean z) {
    }

    public void setCloseIconEnable(boolean z) {
    }

    public void setCradTitle(String str) {
    }

    public void setCrossFeeWithUnit(String str) {
    }

    public void setHelperUrl(String str) {
    }

    public void setInstallmentListener(IInstallmentView.IInstallmentListener iInstallmentListener) {
    }

    public void setMarketing(String str, View.OnClickListener onClickListener) {
    }

    public void setPayTypeInfo(CharSequence charSequence) {
    }

    public void setPayTypeInfo(String str) {
    }

    public void setPixViewListener(IPixView.PixViewListener pixViewListener) {
    }

    public void setThirdPartPayChangeMode(boolean z) {
    }

    public void showConfirmDialog(UnifiedPayDialogConfig unifiedPayDialogConfig, IGlobalPayView.DialogConfirmListener dialogConfirmListener) {
    }

    public void showErrorView(FailStateView.Config config) {
    }

    public void showInstallmentBubble(String str) {
    }

    public void showThirdPartPay() {
    }

    public void updateBillAmount(BasicBill basicBill) {
    }

    public void updateCashbackInfo(String str) {
    }

    public void updateInstallment(InstallmentModel installmentModel) {
    }

    public void updateInstallmentRedPoint(boolean z) {
    }

    public void updateMerchantInfo(MerchantInfo merchantInfo) {
    }

    public void updateNewChannelPoint(boolean z) {
    }

    public void updatePix(String str, String str2) {
    }

    public void updatePlatformPayView(List<PlatformPayItem> list) {
    }

    public void updatePlatformPayView(List<PlatformPayItem> list, boolean z) {
    }

    public void updateTransactionFee(TransactionFee transactionFee) {
    }

    public GlobalPaymentView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GlobalPaymentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GlobalPaymentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(R.layout.g_payment_layout, this);
        this.rootGroupView = (RootLinearLayout) findViewById(R.id.g_payment_root);
        this.mTitleView = (GlobalPayTitleView) this.mView.findViewById(R.id.g_payment_title);
        this.mLineView = (ImageView) findViewById(R.id.g_payment_line);
        this.payBizViewLayout = (LinearLayout) findViewById(R.id.oc_ll_pay_biz_view);
        this.payStateLayout = (FrameLayout) findViewById(R.id.oc_fl_pay_state);
        initTotalFeeView();
        this.payStatementTv = (TextView) findViewById(R.id.oc_tv_pay_statement);
        ImageView imageView = (ImageView) findViewById(R.id.oc_btn_pay_loading);
        this.payLoadingBtn = imageView;
        imageView.setBackgroundResource(R.drawable.oc_button_selector);
        TextView textView = (TextView) findViewById(R.id.oc_btn_pay);
        this.payBtn = textView;
        textView.setBackground(AppCompatResources.getDrawable(getContext(), UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getMainBtnBg()));
        this.payBtn.setTextColor(getContext().getResources().getColorStateList(UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getPayBtnTxtColor()));
        this.payBtn.setOnClickListener(this);
        this.mBalanceView = (GlobalPaymentBalanceView) findViewById(R.id.g_payment_layout_balance);
        this.mPaymentCheckView = (GlobalPaymentCheckView) findViewById(R.id.g_payment_layout_paymentcheck);
        this.mSupplyContainer = (LinearLayout) findViewById(R.id.oc_pay_supplement_container);
        ImageView imageView2 = (ImageView) findViewById(R.id.oc_pay_supplement_container_subline);
        this.mSupplyContainerSubline = imageView2;
        imageView2.setVisibility(8);
    }

    private void initTotalFeeView() {
        this.totalFeeContainer = (LinearLayout) findViewById(R.id.oc_pay_total_fee_container);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.g_payment_total_fee, this.totalFeeContainer, false);
        this.totalFeeTv = (TextView) inflate.findViewById(R.id.g_pay_toal_fee);
        this.feeDetail = (TextView) inflate.findViewById(R.id.g_pay_total_fee_more);
        this.totalFeeContainer.addView(inflate);
    }

    public void setTitle(boolean z, String str, String str2) {
        if (z) {
            this.mTitleView.setTitle(str, R.color.pay_title_error);
            this.mTitleView.setMessage(str2, R.color.pay_title_error);
            return;
        }
        this.mTitleView.setTitle(str, R.color.oc_color_333333);
        this.mTitleView.setMessage(str2);
    }

    public void setTitle(boolean z, boolean z2, String str, String str2) {
        setTitle(z, str, str2);
        if (z2) {
            this.payStateLayout.setVisibility(0);
            this.payBizViewLayout.setVisibility(0);
            this.mLineView.setVisibility(0);
            return;
        }
        this.payStateLayout.setVisibility(8);
        this.payBizViewLayout.setVisibility(8);
        this.mLineView.setVisibility(8);
    }

    public void setTitleLink(boolean z, String str, final String str2, final IGlobalPayView.OnWebLinkClickListener onWebLinkClickListener) {
        int color = z ? getContext().getResources().getColor(R.color.pay_title_error) : 0;
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
        GlobalErrorView globalErrorView = new GlobalErrorView(getContext());
        globalErrorView.setOnClickListener(onClickListener);
        showPayStateView(globalErrorView);
        this.payBizViewLayout.setVisibility(8);
        this.payStateLayout.setVisibility(0);
        resetViewClickable();
    }

    public void showLoadingPop(int i) {
        showLoadingView("", true, i);
    }

    public void hideLoadingPop(boolean z) {
        hideInfoDialog();
        if (z) {
            showRootView();
            this.payStateLayout.removeAllViews();
            this.payStateLayout.setVisibility(8);
            this.payBizViewLayout.setVisibility(0);
            return;
        }
        hideRootView();
    }

    public void updatePayType(GlobalPayType globalPayType) {
        this.mPaymentCheckView.setCurrentSelectedType(globalPayType);
    }

    public void updateBalance(InternalPayChannel internalPayChannel, IGlobalPayView.CheckCallBack checkCallBack) {
        this.mBalanceView.update(internalPayChannel, checkCallBack);
    }

    private void showRootView() {
        this.rootGroupView.setVisibility(0);
    }

    private void hideRootView() {
        this.rootGroupView.setVisibility(8);
    }

    public void setListener(IPayView.PayViewListener payViewListener) {
        this.mListener = payViewListener;
        this.mTitleView.setCloseListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GlobalPaymentView.this.mListener != null) {
                    GlobalPaymentView.this.mListener.onCloseBtnClick();
                }
            }
        });
    }

    public void setDisplayFee(String str) {
        setDisplayFeeWithUnit(this.mContext.getString(R.string.oc_pay_total_str) + this.mContext.getString(R.string.oc_pay_total_fee_str, new Object[]{str}));
    }

    public void setDisplayFeeWithUnit(String str) {
        SimpleSpanStringBuilder simpleSpanStringBuilder = new SimpleSpanStringBuilder(str);
        simpleSpanStringBuilder.spanNumSize(2.14f);
        this.totalFeeTv.setText(simpleSpanStringBuilder);
        TextView textView = this.totalFeeTv;
        textView.setContentDescription(getContext().getString(R.string.oc_uni_voice_total_message) + this.totalFeeTv.getText());
    }

    public void setJumpableItem(String str) {
        if (UnipayTextUtil.isEmpty(str)) {
            showFeeDetailEntraView(false);
            return;
        }
        this.feeDetail.setText(str);
        TextView textView = this.feeDetail;
        textView.setContentDescription(this.feeDetail.getText() + getContext().getString(R.string.oc_voice_button));
        showFeeDetailEntraView(true);
    }

    public void setVoucherDeductible(double d) {
        if (d > 0.0d) {
            String string = getResources().getString(R.string.oc_pay_voucher_deduction_str);
            Resources resources = getResources();
            setVoucherView(new VoucherViewConfig(string, resources.getString(R.string.oc_uni_pay_voucher_deduction_value, new Object[]{"" + d}), true));
            return;
        }
        showOrHideDeductionItem(DeductionItemType.TYPE_VOUCHER, false);
    }

    public void setVoucherView(VoucherViewConfig voucherViewConfig) {
        removeDeductionItem(DeductionItemType.TYPE_VOUCHER);
        voucherViewConfig.deductionType = DeductionItemType.TYPE_VOUCHER;
        addDeductionItem(voucherViewConfig);
    }

    public void addDeductionItem(VoucherViewConfig voucherViewConfig) {
        if (voucherViewConfig != null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.g_pay_supply_item, this.mSupplyContainer, false);
            inflate.setTag(voucherViewConfig);
            TextView textView = (TextView) inflate.findViewById(R.id.oc_tv_voucher_left);
            textView.setText(voucherViewConfig.leftDes);
            TextView textView2 = (TextView) inflate.findViewById(R.id.oc_tv_voucher_mount);
            textView2.setText(voucherViewConfig.rightDes);
            if (textView.getText() != null) {
                inflate.setContentDescription(textView.getText().toString() + textView2.getText());
            }
            ImageView imageView = (ImageView) inflate.findViewById(R.id.oc_iv_pay_voucher_icon);
            if (voucherViewConfig.showOrangeText) {
                textView2.setTextColor(getResources().getColor(R.color.oc_color_ff7733));
                imageView.setImageResource(R.mipmap.icon_rightarrow_orange);
            } else {
                textView2.setTextColor(getResources().getColor(R.color.oc_color_999999));
                imageView.setImageResource(R.drawable.common_icon_right);
            }
            if (voucherViewConfig.showRightIcon) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (voucherViewConfig.canClick) {
                inflate.setOnClickListener(this);
                inflate.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.oc_view_selector));
                if (voucherViewConfig.deductionType == DeductionItemType.TYPE_VOUCHER) {
                    inflate.setContentDescription(inflate.getContentDescription() + getContext().getString(R.string.oc_voice_button) + getContext().getString(R.string.oc_uni_voice_change_coupons));
                }
            } else {
                inflate.setOnClickListener((View.OnClickListener) null);
                inflate.setBackgroundDrawable((Drawable) null);
            }
            this.mSupplyContainer.addView(inflate);
            if (this.mSupplyContainer.getVisibility() != 0) {
                this.mSupplyContainer.setVisibility(0);
                this.mSupplyContainerSubline.setVisibility(0);
            }
        }
    }

    public void addDeductionItems(List<VoucherViewConfig> list) {
        if (list != null && list.size() >= 1) {
            removeAllDeductions();
            for (int i = 0; i < list.size(); i++) {
                addDeductionItem(list.get(i));
            }
        }
    }

    public void showOrHideDeductionItem(DeductionItemType deductionItemType, boolean z) {
        if (this.mSupplyContainer.getChildCount() > 0) {
            for (int i = 0; i < this.mSupplyContainer.getChildCount(); i++) {
                View childAt = this.mSupplyContainer.getChildAt(i);
                if (childAt.getTag() == deductionItemType) {
                    childAt.setVisibility(z ? 0 : 8);
                    if (z) {
                        this.mSupplyContainer.setVisibility(0);
                        this.mSupplyContainerSubline.setVisibility(0);
                    }
                }
            }
        }
        if (!z && isAllChildGone(this.mSupplyContainer)) {
            this.mSupplyContainer.setVisibility(8);
            this.mSupplyContainerSubline.setVisibility(8);
        }
    }

    public void showOrHideDeductions(boolean z) {
        if (z) {
            this.mSupplyContainer.setVisibility(0);
            if (this.mSupplyContainer.getVisibility() != 0) {
                this.mSupplyContainer.setVisibility(0);
                this.mSupplyContainerSubline.setVisibility(0);
                return;
            }
            return;
        }
        this.mSupplyContainer.setVisibility(8);
        this.mSupplyContainerSubline.setVisibility(8);
    }

    public void removeAllDeductions() {
        if (this.mSupplyContainer.getChildCount() > 0) {
            this.mSupplyContainer.removeAllViews();
        }
        this.mSupplyContainer.setVisibility(8);
        this.mSupplyContainerSubline.setVisibility(8);
    }

    public void removeDeductionItem(DeductionItemType deductionItemType) {
        if (this.mSupplyContainer.getChildCount() > 0) {
            for (int i = 0; i < this.mSupplyContainer.getChildCount(); i++) {
                if (this.mSupplyContainer.getChildAt(i).getTag() == deductionItemType) {
                    this.mSupplyContainer.removeViewAt(i);
                }
            }
        }
    }

    public void showVoucherView(boolean z) {
        showOrHideDeductionItem(DeductionItemType.TYPE_VOUCHER, z);
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
            this.mPaymentCheckView.setRedPointVisibility(GlobalRedPointHelper.getRedPointVisibility(this.mContext, payChannelItem.channelId, payChannelItem.is_new_channel));
            this.mPaymentCheckView.setDesc(payChannelItem.deposit_msg);
        }
        this.mPaymentCheckView.setCurrentSelectedType(globalPayType);
        this.mPaymentCheckView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GlobalPaymentView.this.mListener != null) {
                    GlobalPaymentView.this.mListener.onPayItemSelected(0, (PayChannelItem) null);
                }
            }
        });
    }

    public void setPayStatement(String str) {
        if (!UnipayTextUtil.isEmpty(str)) {
            this.payStatementTv.setText(str);
            this.payStatementTv.setVisibility(0);
            return;
        }
        this.payStatementTv.setVisibility(8);
    }

    public void setPayBtnText(String str) {
        if (!UnipayTextUtil.isEmpty(str)) {
            this.payBtn.setText(str);
            TextView textView = this.payBtn;
            textView.setContentDescription(this.payBtn.getText().toString() + getContext().getString(R.string.oc_voice_button));
        }
    }

    public void showFeeDetailEntraView(boolean z) {
        if (z) {
            this.feeDetail.setVisibility(0);
            this.totalFeeContainer.setOnClickListener(this);
            return;
        }
        this.feeDetail.setVisibility(8);
        this.totalFeeContainer.setOnClickListener((View.OnClickListener) null);
    }

    public PayTypes getPayMethodTypes() {
        if (this.mPaymentCheckView.getCurrentSelectedType() != null) {
            return this.mPaymentCheckView.getCurrentSelectedType().mPayTypes;
        }
        return null;
    }

    public void showQueryPayResultView(boolean z, LoadingState loadingState, int i) {
        if (z) {
            IPayView.PayViewListener payViewListener = this.mListener;
            if (payViewListener != null) {
                payViewListener.onShowQueryPayResultView();
            }
            showLoadingView("", true, LoadingState.TYPE_WAITING.type);
            return;
        }
        showLoadingView("", false);
        resetViewClickable();
    }

    public void showLoadingView(String str, boolean z) {
        showLoadingView(str, z, LoadingState.TYPE_LOADING.type);
    }

    public void showLoadingView(String str, boolean z, int i) {
        showLoadingView(str, z, i, 0);
    }

    public void showLoadingView(String str, boolean z, int i, int i2) {
        if (z) {
            hideRootView();
            showInfoDialog(i, str);
            return;
        }
        hideInfoDialog();
        showRootView();
        this.payStateLayout.removeAllViews();
        this.payStateLayout.setVisibility(8);
        this.payBizViewLayout.setVisibility(0);
    }

    private void showInfoDialog(int i, String str) {
        String str2;
        if (getContext() != null && !((Activity) getContext()).isFinishing()) {
            if (this.mInfoDialog == null) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.g_payment_loading, (ViewGroup) null);
                Dialog dialog = new Dialog(getContext(), R.style.pay_dialog_style);
                this.mInfoDialog = dialog;
                dialog.setContentView(inflate);
                Window window = this.mInfoDialog.getWindow();
                window.setGravity(80);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = UIUtils.getScreenWidth(getContext());
                window.setAttributes(attributes);
            }
            ProgressBar progressBar = (ProgressBar) this.mInfoDialog.findViewById(R.id.g_payment_loading_progressbar);
            ImageView imageView = (ImageView) this.mInfoDialog.findViewById(R.id.g_payment_loading_icon);
            TextView textView = (TextView) this.mInfoDialog.findViewById(R.id.g_payment_loading_text);
            if (i == LoadingState.TYPE_SUCCESS5.type) {
                progressBar.setVisibility(8);
                imageView.setVisibility(0);
                imageView.setBackgroundResource(R.drawable.g_icon_payment_success);
                str2 = getContext().getString(R.string.g_payment_success);
            } else {
                progressBar.setVisibility(0);
                imageView.setVisibility(8);
                if (i == LoadingState.TYPE_WAITING.type) {
                    str2 = getContext().getString(R.string.g_payment_waiting);
                } else if (i == LoadingState.TYPE_REFRESHING.type) {
                    str2 = getContext().getString(R.string.g_payment_refreshing);
                } else if (i == LoadingState.TYPE_PAYING.type) {
                    str2 = getContext().getString(R.string.g_payment_paying);
                } else {
                    str2 = getContext().getString(R.string.g_payment_loading);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            } else {
                textView.setText(str2);
            }
            if (!this.mInfoDialog.isShowing()) {
                this.mInfoDialog.setCancelable(false);
                SystemUtils.showDialog(this.mInfoDialog);
                playHelpVoice(textView);
            }
        }
    }

    private void hideInfoDialog() {
        Dialog dialog = this.mInfoDialog;
        if (dialog != null) {
            dialog.dismiss();
            this.mInfoDialog = null;
        }
    }

    public void showSuccessOnPayBtn() {
        showSuccessView(true);
    }

    public void showSuccessView(boolean z) {
        showSuccessView(z, "");
    }

    public void showSuccessView(boolean z, String str) {
        hideRootView();
        showInfoDialog(LoadingState.TYPE_SUCCESS5.type, str);
    }

    public void showToastView(final ToastView.Config config) {
        ToastView toastView = new ToastView(getContext());
        toastView.setListener(new ToastView.DismissListener() {
            public void onDismiss() {
                GlobalPaymentView.this.showBizViewLayout();
                if (config.listener != null) {
                    config.listener.onDismiss();
                }
            }
        });
        toastView.setupView(config);
        showPayStateView(toastView);
        this.payBizViewLayout.setVisibility(8);
        this.payStateLayout.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void showBizViewLayout() {
        this.payStateLayout.setVisibility(8);
        this.payBizViewLayout.setVisibility(0);
        resetViewClickable();
    }

    /* access modifiers changed from: protected */
    public void showPayStateView(View view) {
        this.payStateLayout.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.payStateLayout.getLayoutParams();
        int payBizViewHeight = getPayBizViewHeight();
        if (payBizViewHeight > 0) {
            layoutParams.height = payBizViewHeight;
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            int dimension = (int) this.mContext.getResources().getDimension(R.dimen.oc_pay_state_margin);
            layoutParams.setMargins(0, dimension, 0, dimension);
        }
        this.payStateLayout.addView(view);
    }

    public void setPayBtnState(PayBtnState payBtnState) {
        if (payBtnState == PayBtnState.ENABLE) {
            this.payLoadingBtn.setVisibility(8);
            this.payBtn.setVisibility(0);
            this.payBtn.setEnabled(true);
        } else if (payBtnState == PayBtnState.DISABLE) {
            this.payLoadingBtn.setVisibility(8);
            this.payBtn.setVisibility(0);
            this.payBtn.setEnabled(false);
        } else if (payBtnState == PayBtnState.LOADING) {
            this.payBtn.setVisibility(8);
            this.payLoadingBtn.setVisibility(0);
            ((AnimationDrawable) this.payLoadingBtn.getDrawable()).start();
        }
    }

    public void resetViewClickable() {
        setPayBtnState(PayBtnState.ENABLE);
        setCloseIconEnable(true);
        if (this.rootGroupView.isIntercept()) {
            this.rootGroupView.setIntercept(false);
        }
    }

    private int getPayBizViewHeight() {
        return this.payBizViewLayout.getHeight();
    }

    private boolean isAllChildGone(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return true;
        }
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i).getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        IPayView.PayViewListener payViewListener = this.mListener;
        if (payViewListener != null && view != null) {
            if (view == this.totalFeeContainer) {
                payViewListener.onShowFeeDetailClick();
            } else if (view == this.payBtn) {
                onPayBtnClick();
            } else if (isDeductionItemView(view)) {
                this.mListener.onDeductionItemClick((VoucherViewConfig) view.getTag());
            }
        }
    }

    public void onPayBtnClick() {
        this.mListener.onPayButtonClick();
    }

    private boolean isDeductionItemView(View view) {
        if (view == null) {
            return false;
        }
        DeductionItemType deductionItemType = ((VoucherViewConfig) view.getTag()).deductionType;
        if (deductionItemType == DeductionItemType.TYPE_VOUCHER || deductionItemType == DeductionItemType.TYPE_SVIP || deductionItemType == DeductionItemType.REPLACE_ORDER_DEDUCTION || deductionItemType == DeductionItemType.MERCHANT_RIGHT_DEDUCTIO) {
            return true;
        }
        return false;
    }

    public String getPayMethod() {
        GlobalPayType currentSelectedType;
        GlobalPaymentCheckView globalPaymentCheckView = this.mPaymentCheckView;
        if (globalPaymentCheckView == null || (currentSelectedType = globalPaymentCheckView.getCurrentSelectedType()) == null || currentSelectedType.mPayTypes == null) {
            return "";
        }
        return PayMethodManager.getPayMethodFromType(currentSelectedType.mPayTypes.canUseEntraprisepay ? currentSelectedType.mPayTypes.platformPayType : currentSelectedType.mPayTypes.thirdPartPayType);
    }

    private void playHelpVoice(final View view) {
        if (view != null) {
            view.postDelayed(new Runnable() {
                public void run() {
                    View view = view;
                    if (view != null) {
                        view.setFocusable(true);
                        view.requestFocus();
                        view.sendAccessibilityEvent(128);
                    }
                }
            }, 50);
        }
    }
}
