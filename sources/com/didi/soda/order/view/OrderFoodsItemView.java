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

public class OrderFoodsItemView extends ConstraintLayout {

    /* renamed from: a */
    private TextView f43614a;

    /* renamed from: b */
    private TextView f43615b;

    /* renamed from: c */
    private TextView f43616c;

    public OrderFoodsItemView(Context context) {
        super(context);
        m30909a();
    }

    public OrderFoodsItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30909a();
    }

    public OrderFoodsItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30909a();
    }

    public OrderFoodsItemView setData(FoodItem foodItem) {
        this.f43614a.setText(foodItem.mName);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43614a, IToolsService.FontType.MEDIUM);
        this.f43615b.setText(Html.fromHtml(getResources().getString(R.string.customer_order_amount, new Object[]{Integer.valueOf(foodItem.mAmount)})));
        if (!TextUtils.isEmpty(foodItem.mAbnormalDesc)) {
            this.f43616c.setText(foodItem.mAbnormalDesc);
            this.f43616c.setVisibility(0);
        } else {
            this.f43616c.setVisibility(8);
        }
        return this;
    }

    /* renamed from: a */
    private void m30909a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_order_preview_food, this);
        this.f43614a = (TextView) findViewById(R.id.customer_tv_food_name);
        this.f43615b = (TextView) findViewById(R.id.customer_tv_food_count);
        this.f43616c = (TextView) findViewById(R.id.customer_abnormal_desc_tv);
    }
}
