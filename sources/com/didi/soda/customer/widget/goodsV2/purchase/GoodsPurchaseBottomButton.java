package com.didi.soda.customer.widget.goodsV2.purchase;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.taxis99.R;

public class GoodsPurchaseBottomButton extends FrameLayout {

    /* renamed from: a */
    private static final int f41953a = 99999999;

    /* renamed from: b */
    private boolean f41954b;
    @BindView(18954)
    TextView mBottomTempTv;
    @BindView(17823)
    RFMainButton mBtnView;
    @BindView(18894)
    TextView mCurPriceTv;
    @BindView(17824)
    View mMaskView;
    @BindView(19068)
    TextView mOriPriceTv;
    @BindView(18154)
    ViewGroup mPriceContainer;
    @BindView(17825)
    TextView mTexView;

    public GoodsPurchaseBottomButton(Context context) {
        super(context);
        m29575a();
    }

    public GoodsPurchaseBottomButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29575a();
    }

    public GoodsPurchaseBottomButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29575a();
    }

    public void changeOfflinePrice(int i, int i2, String str) {
        String str2;
        if (i > 0 || i2 > 0) {
            int min = Math.min(i, f41953a);
            int min2 = Math.min(i2, f41953a);
            String currency = LocalizationUtils.CurrencyUtils.getCurrency((long) min, str);
            if (min2 <= 0) {
                str2 = "";
            } else {
                str2 = LocalizationUtils.CurrencyUtils.getCurrency((long) min2, str);
            }
            if (TextUtils.isEmpty(str2)) {
                this.mOriPriceTv.setVisibility(8);
            } else {
                this.mOriPriceTv.setAlpha(0.5f);
                SpannableString spannableString = new SpannableString(str2);
                spannableString.setSpan(new StrikethroughSpan(), 0, str2.length(), 33);
                this.mOriPriceTv.setText(spannableString);
                this.mOriPriceTv.setVisibility(0);
            }
            this.mCurPriceTv.setText(currency);
            this.mPriceContainer.setVisibility(0);
            return;
        }
        this.mPriceContainer.setVisibility(8);
    }

    public void changeAddCartText(String str) {
        this.mTexView.setText(str);
    }

    public void showCartLoadingView() {
        this.mPriceContainer.setVisibility(4);
        this.mTexView.setVisibility(4);
        this.mBtnView.setLoading(true);
    }

    public void hideCartLoadingView() {
        this.mPriceContainer.setVisibility(0);
        this.mTexView.setVisibility(0);
        this.mBtnView.setLoading(false);
    }

    public void changeAddButtonText(String str) {
        this.mBottomTempTv.setText(str);
        this.mTexView.setVisibility(4);
        this.mBottomTempTv.setVisibility(0);
    }

    public void disableAddCartView() {
        this.mMaskView.setVisibility(0);
        this.f41954b = false;
    }

    public void enableAddCartView() {
        this.mMaskView.setVisibility(4);
        this.f41954b = true;
    }

    /* renamed from: a */
    private void m29575a() {
        ButterKnife.bind((Object) this, LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_goods_purchase_bottom_button_v2, this));
        this.mBtnView.setContentBackground(RFResUtils.getDrawable(getContext(), R.drawable.customer_purchase_cart_add_fillet));
        this.mBottomTempTv.setTextColor(SkinUtil.getUponBrandPrimaryTextColor());
        this.mCurPriceTv.setTextColor(SkinUtil.getMainButtonSideTextColor());
        this.mOriPriceTv.setTextColor(SkinUtil.getMainButtonSideTextColor());
    }
}
