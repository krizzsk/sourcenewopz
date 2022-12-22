package com.didi.soda.order.component.tips;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.address.AndroidBug5497Workaround;
import com.didi.soda.bill.widgets.CustomerCartTipsGroupView;
import com.didi.soda.cart.component.globalmini.Contract;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.PayMethodListInfoEntity;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.CustomerCommonBubbleView;
import com.didi.soda.customer.widget.abnormal.AbnormalView;
import com.didi.soda.customer.widget.abnormal.AbnormalViewModel;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.jadux.Store;
import com.taxis99.R;

public class EditTipsView extends Contract.AbsEditTipsView {

    /* renamed from: a */
    private View f43473a;

    /* renamed from: b */
    private ViewTreeObserver.OnGlobalLayoutListener f43474b = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (EditTipsView.this.getView().getPaddingBottom() == 0) {
                EditTipsView.this.mTipRoot.setPadding(0, 0, 0, 0);
                return;
            }
            EditTipsView.this.mTipRoot.fullScroll(130);
            EditTipsView.this.mTipRoot.setPadding(0, 0, 0, 100);
        }
    };
    @BindView(18385)
    IconTextView mClose;
    @BindView(17951)
    RFMainButton mConfirm;
    @BindView(18847)
    TextView mCurrencyView;
    @BindView(18082)
    AbnormalView mErrorView;
    @BindView(17993)
    CustomerCommonBubbleView mInputBubble;
    @BindView(18656)
    RelativeLayout mInputLayout;
    @BindView(17947)
    EditText mManuTipfeeView;
    @BindView(17948)
    TextView mManuTipfeeViewHint;
    @BindView(18845)
    TextView mOrderPriceView;
    @BindView(19081)
    TextView mPayment;
    @BindView(18455)
    ImageView mPaymentIcon;
    @BindView(18556)
    RelativeLayout mPaymentView;
    @BindView(18848)
    TextView mPercentView;
    @BindView(18575)
    LinearLayout mSubTotal;
    @BindView(18099)
    RelativeLayout mTipGroupRoot;
    @BindView(18728)
    ScrollView mTipRoot;
    @BindView(18850)
    TextView mTipfeeView;
    @BindView(18846)
    TextView mTipsDes;
    @BindView(17946)
    CustomerCartTipsGroupView mTipsGroupView;
    @BindView(18849)
    TextView mTipsPaidView;
    @BindView(18876)
    TextView mTitle;

    public void hideConfirmLoading() {
        this.mConfirm.setLoading(false);
    }

    public void initTipsGroupStore(Store<TipState> store) {
        this.mTipsGroupView.setStore(store);
    }

    public void initView(TipState tipState) {
        if (tipState.mIsFromOrder) {
            m30801b();
        }
        if (tipState.mConfig.tipFeeType == 1) {
            String currencySymbol = LocalizationUtils.CurrencyUtils.getCurrencySymbol(tipState.mCurrency);
            if (LocalizationUtils.CurrencyUtils.isJPYLocalLang(tipState.mCurrency)) {
                this.mCurrencyView.setText("");
                this.mPercentView.setText(currencySymbol);
            } else {
                this.mCurrencyView.setText(currencySymbol);
                this.mPercentView.setText("");
            }
            TextView textView = this.mManuTipfeeViewHint;
            textView.setText(getContext().getString(R.string.customer_cart_tips_hint_quota) + " " + currencySymbol);
            this.mTipsDes.setText(getContext().getString(R.string.customer_cart_tips_des_quota));
            this.mSubTotal.setVisibility(4);
        } else if (tipState.mConfig.tipFeeType == 2) {
            this.mCurrencyView.setText("");
            this.mPercentView.setText("%");
            TextView textView2 = this.mManuTipfeeViewHint;
            textView2.setText(getContext().getString(R.string.customer_cart_tips_hint_percent) + " %");
            this.mTipsDes.setText(getContext().getString(R.string.customer_cart_tips_des_percent));
            this.mSubTotal.setVisibility(0);
        }
        if (tipState.mIsFromOrder && tipState.mConfig.paid > 0) {
            this.mTipsPaidView.setVisibility(0);
            String string = getContext().getResources().getString(R.string.customer_cart_tips_paid);
            this.mTipsPaidView.setText(String.format(string, new Object[]{LocalizationUtils.CurrencyUtils.getCurrency(tipState.mConfig.paid, tipState.mCurrency)}));
        }
        TextView textView3 = this.mOrderPriceView;
        textView3.setText("(" + LocalizationUtils.CurrencyUtils.getCurrency(tipState.mOrderPrice, tipState.mCurrency) + ")");
    }

    public boolean isLoading() {
        return this.mConfirm.isLoading();
    }

    public void onCreate() {
        super.onCreate();
        ButterKnife.bind((Object) this, getView());
        m30797a();
        this.mTipGroupRoot.setVisibility(8);
        AndroidBug5497Workaround.getInstance((Activity) getContext()).assistComponent(getScopeContext(), getView());
    }

    public void showConfirmLoading() {
        this.mConfirm.setLoading(true);
    }

    public void showLoadError(AbnormalViewModel abnormalViewModel) {
        DialogUtil.hideLoadingDialog();
        this.mErrorView.setVisibility(0);
        this.mErrorView.show(abnormalViewModel);
    }

    public void showLoading() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
        this.mConfirm.setVisibility(8);
    }

    public void showSuccess() {
        this.mTipGroupRoot.setVisibility(0);
        DialogUtil.hideLoadingDialog();
        this.mErrorView.setVisibility(8);
    }

    public void updateView(TipState tipState) {
        if (tipState != null && tipState.mConfig != null) {
            if (!this.mManuTipfeeView.getEditableText().toString().equals(tipState.mInput)) {
                this.mManuTipfeeView.setText(tipState.mInput);
                if (!TextUtils.isEmpty(tipState.mInput)) {
                    this.mManuTipfeeView.setSelection(tipState.mInput.length());
                }
            }
            this.mInputLayout.setVisibility(0);
            this.mInputBubble.setContent(tipState.mBubbleTxt);
            this.mTipfeeView.setText(LocalizationUtils.CurrencyUtils.getCurrency(tipState.mTips.tipPayValue, tipState.mCurrency));
            this.mConfirm.setVisibility(0);
            m30799a(tipState.mPaychannel);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getView().getViewTreeObserver().addOnGlobalLayoutListener(this.f43474b);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f43474b);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f43474b);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.customer_component_tips, viewGroup, true);
        this.f43473a = inflate;
        return inflate;
    }

    /* renamed from: a */
    private void m30797a() {
        this.mTitle.setText(R.string.customer_cart_tip_title);
        this.mConfirm.setText(getContext().getString(R.string.customer_dialog_confirm));
        this.mInputLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EditTipsView.this.m30798a(view);
            }
        });
        this.mManuTipfeeView.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (TextUtils.isEmpty(editable.toString())) {
                    EditTipsView.this.mManuTipfeeViewHint.setVisibility(0);
                    ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(EditTipsView.this.mManuTipfeeView, IToolsService.FontType.NORMAL);
                    EditTipsView.this.mCurrencyView.setVisibility(8);
                    EditTipsView.this.mPercentView.setVisibility(8);
                } else {
                    EditTipsView.this.mManuTipfeeViewHint.setVisibility(8);
                    ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(EditTipsView.this.mManuTipfeeView, IToolsService.FontType.MEDIUM);
                    EditTipsView.this.mCurrencyView.setVisibility(0);
                    EditTipsView.this.mPercentView.setVisibility(0);
                }
                ((Contract.AbsEditTipsPresenter) EditTipsView.this.getPresenter()).onTipsInputChange(obj);
            }
        });
        this.mClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                KeyboardUtils.hideSoftInput(EditTipsView.this.getContext(), view);
                EditTipsView.this.getScopeContext().getNavigator().finish();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30798a(View view) {
        KeyboardUtils.showSoftInput(getContext(), this.mManuTipfeeView);
    }

    /* renamed from: b */
    private void m30801b() {
        this.mPaymentView.setVisibility(0);
        this.mPaymentView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsEditTipsPresenter) EditTipsView.this.getPresenter()).onPaymethodSelect();
            }
        });
        this.mConfirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                KeyboardUtils.hideSoftInput(EditTipsView.this.getContext(), (View) null);
                ((Contract.AbsEditTipsPresenter) EditTipsView.this.getPresenter()).payTips();
            }
        });
    }

    /* renamed from: a */
    private void m30799a(PayChannelEntity payChannelEntity) {
        if (payChannelEntity != null) {
            String payMethodChannelName = PayMethodListInfoEntity.getPayMethodChannelName(payChannelEntity.channelId, payChannelEntity.channelName, payChannelEntity.cardSuffix, false);
            if (!TextUtils.isEmpty(payMethodChannelName)) {
                this.mPayment.setText(payMethodChannelName);
                this.mPayment.setHint("");
                this.mPayment.setTextSize(18.0f);
                this.mPayment.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
                FlyImageLoader.loadImageUnspecified(getContext(), payChannelEntity.cardOrg).into(this.mPaymentIcon);
                this.mPaymentIcon.setVisibility(0);
            }
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mPayment, IToolsService.FontType.MEDIUM);
            return;
        }
        this.mPayment.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_4_80_CCCCCC));
        this.mPayment.setHint(R.string.customer_name_pelease_select_pay_method);
        this.mPayment.setTextSize(14.0f);
        this.mPaymentIcon.setVisibility(8);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mPayment, IToolsService.FontType.NORMAL);
    }
}
