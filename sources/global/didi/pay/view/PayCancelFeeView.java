package global.didi.pay.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.Utils;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didi.unifiedPay.component.manager.PayMethodManager;
import com.didi.unifiedPay.component.model.PayChannelItem;
import com.didi.unifiedPay.component.model.PayErrorEvent;
import com.didi.unifiedPay.component.model.PayTypes;
import com.didi.unifiedPay.component.model.PlatformPayItem;
import com.didi.unifiedPay.component.view.DeductionItemType;
import com.didi.unifiedPay.component.view.IPayView;
import com.didi.unifiedPay.component.view.PayBizType;
import com.didi.unifiedPay.component.view.PayBtnState;
import com.didi.unifiedPay.component.view.VoucherViewConfig;
import com.didi.unifiedPay.component.widget.CardTitleView;
import com.didi.unifiedPay.component.widget.FailStateView;
import com.didi.unifiedPay.component.widget.RootLinearLayout;
import com.didi.unifiedPay.component.widget.SingleSelectionListView;
import com.didi.unifiedPay.component.widget.ToastView;
import com.didi.unifiedPay.component.widget.loading.FailStateDialog;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.taxis99.R;
import global.didi.pay.model.LoadingState;
import java.util.List;

public class PayCancelFeeView extends FrameLayout implements View.OnClickListener, IPayView {
    private static final String TAG = "PayCancelFeeView";
    private TextView feeStateTextView;
    private int initThirdPartSelected;
    private ScrollView mBizContentView;
    private Context mContext;
    /* access modifiers changed from: private */
    public FailStateDialog mFailStateDialog;
    private FragmentManager mFragmentManager;
    protected IPayView.PayViewListener mListener;
    private ProgressDialogFragment mLoadingDialog;
    private CardTitleView mTitleBar;
    private View mView;
    private TextView payBtn;
    private LinearLayout payBtnArea;
    private ImageView payLoadingBtn;
    private LinearLayout payMethodArea;
    protected RootLinearLayout rootGroupView;
    /* access modifiers changed from: private */
    public CancelFeePayMethodView thridPartPayView;

    public void addDeductionItem(VoucherViewConfig voucherViewConfig) {
    }

    public void addDeductionItems(List<VoucherViewConfig> list) {
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.gua_oc_pay_cancel_fee_layout;
    }

    public View getView() {
        return this;
    }

    public void refreshTotalPayArea(String str, String str2, String str3) {
    }

    public void removeAllDeductions() {
    }

    public void setBizType(PayBizType payBizType) {
    }

    public void setCardPaddingTop(int i) {
    }

    public void setCradTitle(String str) {
    }

    public void setCrossFeeWithUnit(String str) {
    }

    public void setDisplayFee(String str) {
    }

    public void setDisplayFeeWithUnit(String str) {
    }

    public void setJumpableItem(String str) {
    }

    public void setMarketing(String str, View.OnClickListener onClickListener) {
    }

    public void setPayStatement(String str) {
    }

    public void setVoucherDeductible(double d) {
    }

    public void setVoucherView(VoucherViewConfig voucherViewConfig) {
    }

    public void showFeeDetailEntraView(boolean z) {
    }

    public void showOrHideDeductionItem(DeductionItemType deductionItemType, boolean z) {
    }

    public void showOrHideDeductions(boolean z) {
    }

    public void showToastView(ToastView.Config config) {
    }

    public void showVoucherView(boolean z) {
    }

    public void updatePlatformPayView(List<PlatformPayItem> list, boolean z) {
    }

    public PayCancelFeeView(Context context, FragmentManager fragmentManager) {
        super(context);
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        loadView();
        initView();
    }

    private void loadView() {
        this.mView = LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    }

    private void initView() {
        this.rootGroupView = (RootLinearLayout) this.mView.findViewById(R.id.oc_cancel_pay_root);
        this.mBizContentView = (ScrollView) this.mView.findViewById(R.id.oc_ll_cancel_pay_biz_view);
        CardTitleView cardTitleView = (CardTitleView) this.mView.findViewById(R.id.oc_cancel_pay_title);
        this.mTitleBar = cardTitleView;
        cardTitleView.showLine(false);
        this.mTitleBar.setCloseIconListener(new CardTitleView.CardTitleCloseBtnListener() {
            public void onCloseBtnClick() {
                if (PayCancelFeeView.this.mListener != null) {
                    PayCancelFeeView.this.mListener.onCloseBtnClick();
                }
            }
        });
        setCradTitle("");
        this.feeStateTextView = (TextView) this.mView.findViewById(R.id.oc_tv_cancel_fee_State);
        this.payMethodArea = (LinearLayout) this.mView.findViewById(R.id.oc_cancel_pay_area);
        this.thridPartPayView = (CancelFeePayMethodView) this.mView.findViewById(R.id.oc_cancel_paymethod_view);
        this.payBtnArea = (LinearLayout) this.mView.findViewById(R.id.oc_cancel_ll_pay_area);
        this.payLoadingBtn = (ImageView) this.mView.findViewById(R.id.oc_btn_pay_loading);
        TextView textView = (TextView) this.mView.findViewById(R.id.oc_cancel_btn_pay);
        this.payBtn = textView;
        textView.setOnClickListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.mListener != null && view != null && !Utils.isFastDoubleClick() && view == this.payBtn) {
            onPayBtnClick();
        }
    }

    public void setPayTypeInfo(CharSequence charSequence) {
        if (UnipayTextUtil.isEmpty(charSequence)) {
            this.feeStateTextView.setVisibility(8);
            return;
        }
        this.feeStateTextView.setText(charSequence);
        this.feeStateTextView.setVisibility(0);
    }

    public void setPayTypeInfo(String str) {
        if (UnipayTextUtil.isEmpty(str)) {
            this.feeStateTextView.setVisibility(8);
            return;
        }
        this.feeStateTextView.setText(str);
        this.feeStateTextView.setVisibility(0);
    }

    public void updatePlatformPayView(List<PlatformPayItem> list) {
        updatePlatformPayView(list, false);
    }

    public void updateThirdPartPayView(List<PayChannelItem> list, int i) {
        updateThirdPartPayView(list, i, false);
    }

    public void updateThirdPartPayView(List<PayChannelItem> list, int i, boolean z) {
        if (list == null || list.size() < 1 || list.size() <= i) {
            this.thridPartPayView.setVisibility(8);
            return;
        }
        LogUtil.m31684d(TAG, "updateThirdPartPayView payChannelItems:" + list);
        if (this.initThirdPartSelected <= 0 && i >= 0) {
            this.initThirdPartSelected = list.get(i).channelId;
        }
        this.thridPartPayView.setData(list, z, false);
        if (z) {
            this.thridPartPayView.onItemClick(i, true);
            this.thridPartPayView.setSelection(i);
        } else {
            this.thridPartPayView.onItemClick(i, true);
        }
        this.thridPartPayView.setVisibility(0);
        this.thridPartPayView.setOnSelectionListener(new SingleSelectionListView.OnSelectListener() {
            public void onSelect(int i, Object obj) {
                if (PayCancelFeeView.this.thridPartPayView.hasLoadingStateItem()) {
                    PayCancelFeeView.this.changeItemViewClickable(false);
                }
                PayChannelItem payChannelItem = (PayChannelItem) obj;
                if (PayCancelFeeView.this.mListener != null) {
                    PayCancelFeeView.this.mListener.onPayItemSelected(i, payChannelItem);
                }
            }

            public void unSelect(int i, Object obj) {
                PayChannelItem payChannelItem = (PayChannelItem) obj;
                if (PayCancelFeeView.this.mListener != null) {
                    PayCancelFeeView.this.mListener.unSelectThirdPartItem(i, payChannelItem);
                }
            }

            public void itemClicked(int i, PayChannelItem payChannelItem) {
                PayCancelFeeView.this.mListener.onThirdPartPayItemClicked(i, payChannelItem);
            }
        });
    }

    public void setThirdPartPayChangeMode(boolean z) {
        this.thridPartPayView.setItemChangeMode(z);
    }

    public void setCancelableForThirdPay(boolean z) {
        this.thridPartPayView.setCancelable(z);
    }

    public void selectedPayItem(PayChannelItem payChannelItem) {
        this.thridPartPayView.onItemClick(payChannelItem);
    }

    public void setPayBtnText(String str) {
        if (!UnipayTextUtil.isEmpty(str)) {
            this.payBtn.setText(str);
        }
    }

    public void setCloseIconEnable(boolean z) {
        this.mTitleBar.setEnabled(z);
    }

    public boolean isCloseIconEnable() {
        return this.mTitleBar.isEnabled();
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

    public void onPayBtnClick() {
        setPayBtnState(PayBtnState.LOADING);
        this.rootGroupView.setIntercept(true);
        this.mListener.onPayButtonClick();
    }

    public void resetViewClickable() {
        setPayBtnState(PayBtnState.ENABLE);
        setCloseIconEnable(true);
        if (this.rootGroupView.isIntercept()) {
            this.rootGroupView.setIntercept(false);
        }
    }

    public void setChangePayItemResult(boolean z) {
        CancelFeePayMethodView cancelFeePayMethodView = this.thridPartPayView;
        if (cancelFeePayMethodView != null && cancelFeePayMethodView.hasLoadingStateItem()) {
            this.thridPartPayView.setBlockChangeResult(z);
        }
        changeItemViewClickable(true);
    }

    public PayTypes getPayMethodTypes() {
        PayTypes payTypes = new PayTypes();
        PayChannelItem selection = this.thridPartPayView.getSelection();
        if (selection != null) {
            payTypes.thirdPartPayType = selection.channelId;
        }
        return payTypes;
    }

    public boolean isPayItemsExpand() {
        return this.thridPartPayView.getChildCount() > 0;
    }

    public void setListener(IPayView.PayViewListener payViewListener) {
        this.mListener = payViewListener;
    }

    public void showQueryPayResultView(boolean z, LoadingState loadingState, int i) {
        if (z) {
            IPayView.PayViewListener payViewListener = this.mListener;
            if (payViewListener != null) {
                payViewListener.onShowQueryPayResultView();
            }
            if (isShowLoadingStateView()) {
                showLoadingView("", false);
            }
            showLoadingOnPayBtn();
            return;
        }
        showLoadingView("", false);
        resetViewClickable();
    }

    public void showSuccessView(boolean z) {
        showSuccessView(z, this.mContext.getString(R.string.oc_pay_success_state_string));
    }

    public void showSuccessView(boolean z, String str) {
        if (z) {
            IPayView.PayViewListener payViewListener = this.mListener;
            if (payViewListener != null) {
                payViewListener.onPaySuccess();
            }
            if (isShowBizView()) {
                showSuccessOnPayBtn();
            }
        }
    }

    public void showSuccessOnPayBtn() {
        if (!this.rootGroupView.isIntercept()) {
            this.rootGroupView.setIntercept(true);
        }
        setPayBtnState(PayBtnState.ENABLE);
        setPayBtnText(getResources().getString(R.string.oc_pay_success_string));
    }

    public boolean isShowSuccessOnBtn() {
        return getResources().getString(R.string.oc_pay_success_string).equals(this.payBtn.getText());
    }

    public void showLoadingView(String str, boolean z) {
        if (z && this.mLoadingDialog == null) {
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
            this.mLoadingDialog = progressDialogFragment;
            progressDialogFragment.setContent(str, false);
        }
        ProgressDialogFragment progressDialogFragment2 = this.mLoadingDialog;
        if (progressDialogFragment2 == null) {
            return;
        }
        if (z) {
            progressDialogFragment2.show(this.mFragmentManager, "");
            return;
        }
        showBizView();
        if (this.mLoadingDialog.isAdded()) {
            this.mLoadingDialog.dismissAllowingStateLoss();
            this.mLoadingDialog = null;
        }
    }

    private boolean isFillData() {
        CharSequence text = this.feeStateTextView.getText();
        return (text != null && !TextUtil.isEmpty(text.toString())) || this.thridPartPayView.getItemCount() > 0;
    }

    public void showErrorView(FailStateView.Config config) {
        showLoadingView("", false);
        if (!isFillData()) {
            hideBizView();
        }
        if (this.mFailStateDialog == null) {
            FailStateDialog failStateDialog = new FailStateDialog(this.mContext, 2132018107);
            this.mFailStateDialog = failStateDialog;
            failStateDialog.setCancelable(false);
            Window window = this.mFailStateDialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setGravity(17);
            WindowManager windowManager = this.mFailStateDialog.getWindow().getWindowManager();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            attributes.width = (int) (((double) displayMetrics.widthPixels) * 0.8d);
            window.setAttributes(attributes);
        }
        if (!this.mFailStateDialog.isShowing()) {
            final FailStateView.ClickListener clickListener = config.listener;
            FailStateDialog.Config config2 = new FailStateDialog.Config();
            config2.cancelText = config.cancelText;
            config2.confirmText = config.confirmText;
            config2.hideAllButton = config.hideAllButton;
            config2.icon = config.icon;
            config2.message = config.message;
            config2.singleButton = config.singleButton;
            config2.listener = new FailStateDialog.onClickListener() {
                public void onCancel() {
                    PayCancelFeeView.this.mFailStateDialog.dismiss();
                    FailStateView.ClickListener clickListener = clickListener;
                    if (clickListener != null) {
                        clickListener.onCancel();
                    }
                }

                public void onConfirm() {
                    PayCancelFeeView.this.mFailStateDialog.dismiss();
                    FailStateView.ClickListener clickListener = clickListener;
                    if (clickListener != null) {
                        clickListener.onConfirm();
                    }
                }
            };
            this.mFailStateDialog.setupView(config2);
            this.mFailStateDialog.setTag(new PayErrorEvent(config.errorCode, config.message));
            SystemUtils.showDialog(this.mFailStateDialog);
            resetViewClickable();
        }
    }

    public String getPayMethod() {
        PayChannelItem selection;
        CancelFeePayMethodView cancelFeePayMethodView = this.thridPartPayView;
        if (cancelFeePayMethodView == null || (selection = cancelFeePayMethodView.getSelection()) == null) {
            return "";
        }
        String payMethodFromType = PayMethodManager.getPayMethodFromType(selection.channelId);
        return "" + payMethodFromType;
    }

    public String getInitPayMethod() {
        if (this.initThirdPartSelected <= 0) {
            return "";
        }
        return "" + PayMethodManager.getPayMethodFromType(this.initThirdPartSelected);
    }

    public void removeThirdPartPay() {
        this.payMethodArea.setVisibility(8);
        this.thridPartPayView.setVisibility(8);
    }

    public void showThirdPartPay() {
        this.payMethodArea.setVisibility(0);
        this.thridPartPayView.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void changeItemViewClickable(boolean z) {
        if (z) {
            this.payBtn.setEnabled(true);
            this.thridPartPayView.setItemEnable(true);
            return;
        }
        this.payBtn.setEnabled(false);
        this.thridPartPayView.setItemEnable(false);
    }

    private void showBizView() {
        this.mBizContentView.setVisibility(0);
        this.payBtnArea.setVisibility(0);
        resetViewClickable();
    }

    private void hideBizView() {
        this.mBizContentView.setVisibility(8);
        this.payBtnArea.setVisibility(8);
    }

    private boolean isShowBizView() {
        return this.mBizContentView.getVisibility() == 0;
    }

    private void showLoadingOnPayBtn() {
        if (!this.rootGroupView.isIntercept()) {
            this.rootGroupView.setIntercept(true);
        }
        setPayBtnState(PayBtnState.LOADING);
    }

    /* access modifiers changed from: protected */
    public boolean isShowLoadingStateView() {
        ProgressDialogFragment progressDialogFragment = this.mLoadingDialog;
        return progressDialogFragment != null && progressDialogFragment.isAdded();
    }

    public PayErrorEvent isShowErrorView() {
        FailStateDialog failStateDialog = this.mFailStateDialog;
        if (failStateDialog == null || !failStateDialog.isShowing() || !(this.mFailStateDialog.getTag() instanceof PayErrorEvent)) {
            return null;
        }
        return (PayErrorEvent) this.mFailStateDialog.getTag();
    }
}
