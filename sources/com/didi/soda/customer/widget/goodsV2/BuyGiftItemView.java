package com.didi.soda.customer.widget.goodsV2;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.goods.CartFoodItemView;
import com.taxis99.R;

public class BuyGiftItemView extends ConstraintLayout {

    /* renamed from: a */
    private TextView f41896a;

    /* renamed from: b */
    private TextView f41897b;

    /* renamed from: c */
    private TextView f41898c;

    /* renamed from: d */
    private TextView f41899d;

    public BuyGiftItemView(Context context) {
        super(context);
        m29548a();
    }

    public BuyGiftItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29548a();
    }

    public BuyGiftItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29548a();
    }

    public BuyGiftItemView setData(CartFoodItemView.FoodItemModel foodItemModel) {
        this.f41896a.setText(foodItemModel.name);
        if (!TextUtils.isEmpty(foodItemModel.originalPrice) && !foodItemModel.originalPrice.equals(foodItemModel.currentPrice)) {
            this.f41897b.setText(foodItemModel.originalPrice);
        }
        this.f41898c.setText(foodItemModel.currentPrice);
        this.f41899d.setText(getResources().getString(R.string.customer_order_amount, new Object[]{Integer.valueOf(foodItemModel.amount)}));
        return this;
    }

    public BuyGiftItemView setType(int i) {
        if (i == 101) {
            this.f41896a.setTextColor(getResources().getColor(R.color.rf_color_gery_1_0_000000));
            this.f41898c.setVisibility(0);
            this.f41897b.setVisibility(0);
        } else if (i == 102) {
            this.f41896a.setTextColor(getResources().getColor(R.color.rf_color_gery_4_80_CCCCCC));
            this.f41898c.setVisibility(8);
            this.f41897b.setVisibility(8);
        } else {
            this.f41896a.setTextColor(getResources().getColor(R.color.rf_color_gery_1_0_000000));
            this.f41898c.setVisibility(0);
            this.f41897b.setVisibility(0);
        }
        return this;
    }

    /* renamed from: a */
    private void m29548a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_buy_gift_area, this);
        this.f41896a = (TextView) findViewById(R.id.customer_tv_food_name);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41896a, IToolsService.FontType.MEDIUM);
        TextView textView = (TextView) findViewById(R.id.customer_tv_food_original_price);
        this.f41897b = textView;
        textView.getPaint().setFlags(16);
        this.f41898c = (TextView) findViewById(R.id.customer_tv_food_current_price);
        this.f41899d = (TextView) findViewById(R.id.customer_tv_gift_count);
    }
}
