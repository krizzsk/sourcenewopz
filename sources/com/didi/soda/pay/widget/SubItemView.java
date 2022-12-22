package com.didi.soda.pay.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.pay.CombinedPayLayout;
import com.didi.soda.pay.model.PayMethodInfoModel;
import com.didi.soda.pay.widget.PayMethodInfoView;
import com.taxis99.R;

public class SubItemView extends FrameLayout {

    /* renamed from: a */
    private View f43646a;

    /* renamed from: b */
    private View f43647b;
    protected ImageView mArrowImageView;
    protected View mArrowLayout;
    protected TextView mArrowTextView;
    protected CombinedPayLayout mCombinedIcon;
    protected View mDividerView;
    protected PayMethodInfoView.PayMethodListener mListener;
    protected View mMsgLayout;
    protected TextView mMsgTv;
    protected ImageView mPayIconView;
    protected TextView mPayInfoTitleView;
    protected ImageView mPayRightIconView;
    protected TextView mPaySubtitleView;
    protected TextView mRecommendView;
    protected View mRightLayout;
    protected TextView mSaveStringView;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m30955a(View view) {
    }

    public SubItemView(Context context) {
        super(context);
        m30954a();
    }

    /* access modifiers changed from: protected */
    public boolean setSaveString(PayMethodInfoModel payMethodInfoModel) {
        if (!TextUtils.isEmpty(payMethodInfoModel.mSaveString)) {
            this.mSaveStringView.setText(payMethodInfoModel.mSaveString);
            return true;
        }
        this.mSaveStringView.setVisibility(8);
        return false;
    }

    /* access modifiers changed from: protected */
    public void setSubtitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mPaySubtitleView.setVisibility(8);
            return;
        }
        this.mPaySubtitleView.setVisibility(0);
        this.mPaySubtitleView.setText(str);
    }

    /* access modifiers changed from: protected */
    public void showOrHideMaskView(boolean z) {
        if (z) {
            this.f43646a.setVisibility(0);
            this.mPayInfoTitleView.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_4_a100));
            this.f43647b.setVisibility(0);
            this.f43646a.setOnClickListener($$Lambda$SubItemView$icVBy6JsQNL6vb4ilsXDCL4zNwM.INSTANCE);
            return;
        }
        this.f43646a.setVisibility(8);
        this.mPayInfoTitleView.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_1_a100));
        this.f43647b.setVisibility(8);
        this.f43646a.setOnClickListener((View.OnClickListener) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108721a(PayMethodInfoView.PayMethodListener payMethodListener) {
        this.mListener = payMethodListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108722a(boolean z) {
        this.mDividerView.setVisibility(z ? 0 : 8);
    }

    /* renamed from: a */
    private void m30954a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_pay_method, this);
        this.mPayIconView = (ImageView) findViewById(R.id.customer_tv_cart_paymethod_icon);
        this.mPayInfoTitleView = (TextView) findViewById(R.id.customer_tv_cart_paymethod_item_title);
        this.mPaySubtitleView = (TextView) findViewById(R.id.customer_tv_cart_paymethod_item_subtitle);
        this.mPayRightIconView = (ImageView) findViewById(R.id.customer_iv_cart_paymethod_right_icon);
        this.f43646a = findViewById(R.id.customer_iv_item_mask);
        this.mSaveStringView = (TextView) findViewById(R.id.customer_tv_cart_save_tip);
        this.mRightLayout = findViewById(R.id.customer_fl_cart_paymethod_left_layout);
        this.mArrowLayout = findViewById(R.id.customer_ll_paymethod_arrow_layout);
        this.mArrowTextView = (TextView) findViewById(R.id.customer_tv_paymethod_arrow_text);
        this.mArrowImageView = (ImageView) findViewById(R.id.customer_tv_paymethod_arrow_image);
        this.mRecommendView = (TextView) findViewById(R.id.customer_tv_card_recommand);
        this.mDividerView = findViewById(R.id.customer_v_paymethod_list_divider);
        this.mCombinedIcon = (CombinedPayLayout) findViewById(R.id.customer_iv_combined_icon);
        this.mMsgTv = (TextView) findViewById(R.id.customer_pay_item_msg);
        this.mMsgLayout = findViewById(R.id.customer_pay_item_msg_layout);
        this.f43647b = findViewById(R.id.customer_iv_item_icon_mask);
    }
}
