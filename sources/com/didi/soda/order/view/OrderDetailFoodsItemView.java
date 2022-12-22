package com.didi.soda.order.view;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.order.builder.FoodItem;
import com.taxis99.R;

public class OrderDetailFoodsItemView extends ConstraintLayout {

    /* renamed from: a */
    private TextView f43562a;

    /* renamed from: b */
    private TextView f43563b;

    /* renamed from: c */
    private TextView f43564c;

    /* renamed from: d */
    private TextView f43565d;

    /* renamed from: e */
    private TextView f43566e;

    /* renamed from: f */
    private TextView f43567f;

    public OrderDetailFoodsItemView(Context context) {
        super(context);
        m30875a();
    }

    public OrderDetailFoodsItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30875a();
    }

    public OrderDetailFoodsItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30875a();
    }

    public OrderDetailFoodsItemView setData(FoodItem foodItem) {
        this.f43562a.setText(foodItem.mName);
        if (!TextUtils.isEmpty(foodItem.mDesc)) {
            this.f43563b.setText(foodItem.mDesc);
            this.f43563b.setVisibility(0);
        } else {
            this.f43563b.setVisibility(8);
        }
        if (TextUtils.isEmpty(foodItem.mOriginalPrice) || foodItem.mCurrentPrice.equals(foodItem.mOriginalPrice)) {
            this.f43565d.setVisibility(8);
        } else {
            this.f43565d.setText(foodItem.mOriginalPrice);
        }
        if (!TextUtils.isEmpty(foodItem.mCurrentPrice)) {
            this.f43564c.setText(foodItem.mCurrentPrice);
        } else {
            this.f43564c.setVisibility(8);
        }
        this.f43566e.setText(Html.fromHtml(getResources().getString(R.string.customer_order_amount, new Object[]{Integer.valueOf(foodItem.mAmount)})));
        if (!TextUtils.isEmpty(foodItem.mAbnormalDesc)) {
            this.f43567f.setText(foodItem.mAbnormalDesc);
            this.f43567f.setVisibility(0);
        } else {
            this.f43567f.setVisibility(8);
        }
        return this;
    }

    /* renamed from: a */
    private void m30875a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_order_food, this);
        this.f43562a = (TextView) findViewById(R.id.customer_tv_food_name);
        this.f43563b = (TextView) findViewById(R.id.customer_tv_food_desc);
        this.f43566e = (TextView) findViewById(R.id.customer_tv_food_count);
        this.f43564c = (TextView) findViewById(R.id.customer_tv_food_current_price);
        this.f43565d = (TextView) findViewById(R.id.customer_tv_food_original_price);
        this.f43567f = (TextView) findViewById(R.id.customer_abnormal_desc_tv);
        this.f43565d.getPaint().setFlags(16);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43562a, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43566e, IToolsService.FontType.MEDIUM);
    }
}
