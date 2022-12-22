package com.didi.soda.order.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.order.builder.FeeItem;
import com.taxis99.R;

public class OrderDetailFeeItemView extends ConstraintLayout {

    /* renamed from: a */
    private TextView f43558a;

    /* renamed from: b */
    private ImageView f43559b;

    /* renamed from: c */
    private TextView f43560c;

    /* renamed from: d */
    private ImageView f43561d;

    public OrderDetailFeeItemView(Context context) {
        super(context);
        m30874a();
    }

    public OrderDetailFeeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30874a();
    }

    public OrderDetailFeeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30874a();
    }

    public OrderDetailFeeItemView setData(FeeItem feeItem) {
        this.f43558a.setText(feeItem.mLeftContent);
        if (feeItem.mLeftIcon > 0) {
            this.f43559b.setImageResource(feeItem.mLeftIcon);
            this.f43559b.setVisibility(0);
        } else {
            this.f43559b.setVisibility(8);
        }
        if (feeItem.mListener != null) {
            this.f43559b.setOnClickListener(feeItem.mListener);
        }
        this.f43560c.setText(feeItem.mRigthContent);
        if (!TextUtils.isEmpty(feeItem.mRightIcon)) {
            FlyImageLoader.loadImageUnspecified(getContext(), feeItem.mRightIcon).centerCrop().into(this.f43561d);
            this.f43561d.setVisibility(0);
        } else {
            this.f43561d.setVisibility(8);
        }
        return this;
    }

    public void setLeftIconClickListener(View.OnClickListener onClickListener) {
        this.f43559b.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: protected */
    public void inflate() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_order_fee, this);
    }

    /* renamed from: a */
    private void m30874a() {
        inflate();
        this.f43558a = (TextView) findViewById(R.id.customer_tv_fee_name);
        this.f43559b = (ImageView) findViewById(R.id.customer_iv_fee_left_icon);
        this.f43560c = (TextView) findViewById(R.id.customer_tv_right_content);
        this.f43561d = (ImageView) findViewById(R.id.customer_iv_fee_right_icon);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43560c, IToolsService.FontType.MEDIUM);
    }
}
