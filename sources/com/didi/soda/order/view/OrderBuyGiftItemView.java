package com.didi.soda.order.view;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.order.builder.FoodItem;
import com.taxis99.R;

public class OrderBuyGiftItemView extends ConstraintLayout {

    /* renamed from: a */
    private TextView f43547a;

    /* renamed from: b */
    private TextView f43548b;

    public OrderBuyGiftItemView(Context context) {
        super(context);
        m30866a();
    }

    public OrderBuyGiftItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30866a();
    }

    public OrderBuyGiftItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30866a();
    }

    public OrderBuyGiftItemView setData(FoodItem foodItem) {
        this.f43547a.setText(foodItem.mName);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43547a, IToolsService.FontType.MEDIUM);
        this.f43548b.setText(Html.fromHtml(getResources().getString(R.string.customer_order_amount, new Object[]{Integer.valueOf(foodItem.mAmount)})));
        return this;
    }

    /* renamed from: a */
    private void m30866a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_order_food_buy_gift, this);
        this.f43547a = (TextView) findViewById(R.id.customer_tv_food_name);
        this.f43548b = (TextView) findViewById(R.id.customer_tv_gift_count);
    }
}
