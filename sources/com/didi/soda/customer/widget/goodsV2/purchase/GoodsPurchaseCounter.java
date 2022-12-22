package com.didi.soda.customer.widget.goodsV2.purchase;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.goodsV2.GoodsQuantityListener;
import com.didi.soda.goods.contract.GoodsItemState;
import com.didi.soda.goodsV2.model.GoodsPurchaseCounterRvModel;
import com.taxis99.R;

public class GoodsPurchaseCounter extends FrameLayout {
    @BindView(18337)
    ImageView mAddIv;
    @BindView(18777)
    TextView mAmountTv;
    @BindView(18471)
    ImageView mSubtractIv;

    public GoodsPurchaseCounter(Context context) {
        super(context);
        m29576a();
    }

    public GoodsPurchaseCounter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29576a();
    }

    public GoodsPurchaseCounter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29576a();
    }

    /* renamed from: a */
    private void m29576a() {
        ButterKnife.bind((Object) this, LayoutInflater.from(getContext()).inflate(R.layout.customer_binder_goods_purchase_counter_v2, this));
    }

    public void bindData(GoodsPurchaseCounterRvModel goodsPurchaseCounterRvModel, GoodsQuantityListener goodsQuantityListener) {
        this.mSubtractIv.setOnClickListener(new View.OnClickListener(goodsPurchaseCounterRvModel) {
            public final /* synthetic */ GoodsPurchaseCounterRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                GoodsPurchaseCounter.m29578b(GoodsQuantityListener.this, this.f$1, view);
            }
        });
        this.mAmountTv.setText(String.valueOf(goodsPurchaseCounterRvModel.mGoodsAmountModel.getCurrentAmount()));
        if (goodsPurchaseCounterRvModel.mGoodsAmountModel.mGoodsItemState != GoodsItemState.FOR_SALE || !BusinessDataHelper.checkBusinessStatusNormal(goodsPurchaseCounterRvModel.mBusinessStatus)) {
            this.mSubtractIv.setImageResource(R.drawable.customer_ic_purchase_subtract_disable_v2);
            this.mAddIv.setImageResource(R.drawable.customer_ic_purchase_add_disable_v2);
            this.mAmountTv.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_neutral_5_20));
            this.mAddIv.setOnClickListener((View.OnClickListener) null);
            this.mSubtractIv.setOnClickListener((View.OnClickListener) null);
            return;
        }
        this.mAddIv.setOnClickListener(new View.OnClickListener(goodsPurchaseCounterRvModel) {
            public final /* synthetic */ GoodsPurchaseCounterRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                GoodsPurchaseCounter.m29577a(GoodsQuantityListener.this, this.f$1, view);
            }
        });
        if (goodsPurchaseCounterRvModel.mGoodsAmountModel.exceedMinAmount()) {
            this.mSubtractIv.setImageResource(R.drawable.customer_ic_purchase_subtract_disable_v2);
        } else {
            this.mSubtractIv.setImageResource(R.drawable.customer_ic_purchase_subtract_v2);
        }
        if (goodsPurchaseCounterRvModel.mGoodsAmountModel.exceedMaxAmount() || goodsPurchaseCounterRvModel.mGoodsAmountModel.exceedMaxSaleAmount()) {
            this.mAddIv.setImageResource(R.drawable.customer_ic_purchase_add_disable_v2);
        } else {
            this.mAddIv.setImageResource(R.drawable.customer_ic_purchase_add_v2);
        }
        this.mAmountTv.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_1_a100));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m29578b(GoodsQuantityListener goodsQuantityListener, GoodsPurchaseCounterRvModel goodsPurchaseCounterRvModel, View view) {
        if (goodsQuantityListener != null) {
            goodsQuantityListener.onSubtractGoodsClick(goodsPurchaseCounterRvModel.mGoodsAmountModel.mGoodsId, (Bundle) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m29577a(GoodsQuantityListener goodsQuantityListener, GoodsPurchaseCounterRvModel goodsPurchaseCounterRvModel, View view) {
        if (goodsQuantityListener != null) {
            goodsQuantityListener.onAddGoodsClick(goodsPurchaseCounterRvModel.mGoodsAmountModel.mGoodsId, (View) null, (Bundle) null);
        }
    }
}
