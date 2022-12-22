package com.didi.soda.customer.widget.goods;

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
    private TextView f41814a;

    /* renamed from: b */
    private TextView f41815b;

    /* renamed from: c */
    private TextView f41816c;

    /* renamed from: d */
    private TextView f41817d;

    public BuyGiftItemView(Context context) {
        super(context);
        m29503a();
    }

    public BuyGiftItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29503a();
    }

    public BuyGiftItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29503a();
    }

    public BuyGiftItemView setData(CartFoodItemView.FoodItemModel foodItemModel) {
        this.f41814a.setText(foodItemModel.name);
        if (!TextUtils.isEmpty(foodItemModel.originalPrice) && !foodItemModel.originalPrice.equals(foodItemModel.currentPrice)) {
            this.f41815b.setText(foodItemModel.originalPrice);
        }
        this.f41816c.setText(foodItemModel.currentPrice);
        this.f41817d.setText(getResources().getString(R.string.customer_order_amount, new Object[]{Integer.valueOf(foodItemModel.amount)}));
        return this;
    }

    public BuyGiftItemView setType(int i) {
        if (i == 101) {
            this.f41814a.setTextColor(getResources().getColor(R.color.rf_color_gery_1_0_000000));
            this.f41816c.setVisibility(0);
            this.f41815b.setVisibility(0);
        } else if (i == 102) {
            this.f41814a.setTextColor(getResources().getColor(R.color.rf_color_gery_4_80_CCCCCC));
            this.f41816c.setVisibility(8);
            this.f41815b.setVisibility(8);
        } else {
            this.f41814a.setTextColor(getResources().getColor(R.color.rf_color_gery_1_0_000000));
            this.f41816c.setVisibility(0);
            this.f41815b.setVisibility(0);
        }
        return this;
    }

    /* renamed from: a */
    private void m29503a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_buy_gift_area, this);
        this.f41814a = (TextView) findViewById(R.id.customer_tv_food_name);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41814a, IToolsService.FontType.MEDIUM);
        TextView textView = (TextView) findViewById(R.id.customer_tv_food_original_price);
        this.f41815b = textView;
        textView.getPaint().setFlags(16);
        this.f41816c = (TextView) findViewById(R.id.customer_tv_food_current_price);
        this.f41817d = (TextView) findViewById(R.id.customer_tv_gift_count);
    }
}
