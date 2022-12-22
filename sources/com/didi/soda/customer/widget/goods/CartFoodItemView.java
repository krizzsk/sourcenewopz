package com.didi.soda.customer.widget.goods;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class CartFoodItemView extends ConstraintLayout implements View.OnClickListener {
    public static final int TYPE_BUSINESS_INVALID = 101;
    public static final int TYPE_ITEM_INVALID = 102;
    public static final int TYPE_NORMAL = 100;

    /* renamed from: a */
    private TextView f41818a;

    /* renamed from: b */
    private TextView f41819b;

    /* renamed from: c */
    private TextView f41820c;

    /* renamed from: d */
    private TextView f41821d;

    /* renamed from: e */
    private TextView f41822e;

    /* renamed from: f */
    private ImageView f41823f;

    /* renamed from: g */
    private ImageView f41824g;

    /* renamed from: h */
    private TextView f41825h;

    /* renamed from: i */
    private LinearLayout f41826i;

    /* renamed from: j */
    private GoodsQuantityListener f41827j;

    /* renamed from: k */
    private FoodItemModel f41828k;

    public static class FoodItemModel {
        public int amount;
        public String currentPrice;
        public String desc;
        public String mduId;
        public CharSequence name;
        public String originalPrice;
    }

    public CartFoodItemView(Context context) {
        super(context);
        m29504a();
    }

    public CartFoodItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29504a();
    }

    public CartFoodItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29504a();
    }

    public CartFoodItemView setData(FoodItemModel foodItemModel) {
        this.f41828k = foodItemModel;
        this.f41818a.setText(foodItemModel.name);
        if (TextUtils.isEmpty(foodItemModel.desc)) {
            this.f41819b.setVisibility(8);
        } else {
            this.f41819b.setText(foodItemModel.desc);
            this.f41819b.setVisibility(0);
        }
        if (!TextUtils.isEmpty(foodItemModel.originalPrice) && !foodItemModel.originalPrice.equals(foodItemModel.currentPrice)) {
            this.f41820c.setText(foodItemModel.originalPrice);
        }
        this.f41821d.setText(foodItemModel.currentPrice);
        TextView textView = this.f41825h;
        textView.setText("" + foodItemModel.amount);
        return this;
    }

    public CartFoodItemView setListener(GoodsQuantityListener goodsQuantityListener) {
        this.f41827j = goodsQuantityListener;
        return this;
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public CartFoodItemView setType(int i) {
        if (i == 101) {
            this.f41818a.setTextColor(getResources().getColor(R.color.rf_color_gery_1_0_000000));
            this.f41819b.setTextColor(getResources().getColor(R.color.rf_color_gery_3_60_999999));
            setAddOrSubtractEnable(false);
            this.f41821d.setVisibility(0);
            this.f41820c.setVisibility(0);
            this.f41822e.setVisibility(8);
            this.f41826i.setVisibility(0);
        } else if (i == 102) {
            this.f41826i.setVisibility(4);
            this.f41822e.setVisibility(0);
            this.f41818a.setTextColor(getResources().getColor(R.color.rf_color_gery_4_80_CCCCCC));
            this.f41819b.setTextColor(getResources().getColor(R.color.rf_color_gery_4_80_CCCCCC));
            this.f41821d.setVisibility(8);
            this.f41820c.setVisibility(8);
        } else {
            this.f41826i.setVisibility(0);
            this.f41818a.setTextColor(getResources().getColor(R.color.rf_color_gery_1_0_000000));
            this.f41819b.setTextColor(getResources().getColor(R.color.rf_color_gery_3_60_999999));
            this.f41821d.setVisibility(0);
            this.f41820c.setVisibility(0);
            setAddOrSubtractEnable(true);
            this.f41822e.setVisibility(8);
        }
        return this;
    }

    public void onClick(View view) {
        GoodsQuantityListener goodsQuantityListener;
        if (view.getId() == R.id.customer_iv_add) {
            GoodsQuantityListener goodsQuantityListener2 = this.f41827j;
            if (goodsQuantityListener2 != null) {
                goodsQuantityListener2.onAddGoodsClick(this.f41828k.mduId, this.f41824g, (Bundle) null);
            }
        } else if (view.getId() == R.id.customer_iv_subtract && (goodsQuantityListener = this.f41827j) != null) {
            goodsQuantityListener.onSubtractGoodsClick(this.f41828k.mduId, (Bundle) null);
        }
    }

    private void setAddOrSubtractEnable(boolean z) {
        this.f41824g.setEnabled(z);
        this.f41823f.setEnabled(z);
        this.f41825h.setEnabled(z);
    }

    /* renamed from: a */
    private void m29504a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_food_area, this);
        this.f41818a = (TextView) findViewById(R.id.customer_tv_food_name);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41818a, IToolsService.FontType.MEDIUM);
        this.f41819b = (TextView) findViewById(R.id.customer_tv_food_desc);
        TextView textView = (TextView) findViewById(R.id.customer_tv_food_original_price);
        this.f41820c = textView;
        textView.getPaint().setFlags(16);
        this.f41821d = (TextView) findViewById(R.id.customer_tv_food_current_price);
        this.f41826i = (LinearLayout) findViewById(R.id.customer_counter_container);
        this.f41823f = (ImageView) findViewById(R.id.customer_iv_subtract);
        this.f41824g = (ImageView) findViewById(R.id.customer_iv_add);
        this.f41825h = (TextView) findViewById(R.id.customer_tv_amount);
        this.f41822e = (TextView) findViewById(R.id.customer_tv_item_invalidation);
        this.f41824g.setOnClickListener(this);
        this.f41823f.setOnClickListener(this);
    }
}
