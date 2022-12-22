package com.didi.soda.goodsV2.binder;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.goodsV2.GoodsQuantityListener;
import com.didi.soda.goods.contract.GoodsItemState;
import com.didi.soda.goodsV2.model.GoodsPurchaseCounterRvModel;
import com.taxis99.R;

public abstract class GoodsPurchaseCounterBinder extends ItemBinder<GoodsPurchaseCounterRvModel, ViewHolder> implements GoodsQuantityListener {

    /* renamed from: a */
    private static final int f42439a = 300;

    /* renamed from: b */
    private boolean f42440b = true;

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_goods_purchase_counter, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, final GoodsPurchaseCounterRvModel goodsPurchaseCounterRvModel) {
        viewHolder.mSubtractIv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GoodsPurchaseCounterBinder.this.onSubtractGoodsClick(goodsPurchaseCounterRvModel.mGoodsAmountModel.mGoodsId, (Bundle) null);
            }
        });
        viewHolder.mAmountTv.setText(String.valueOf(goodsPurchaseCounterRvModel.mGoodsAmountModel.getCurrentAmount()));
        if (goodsPurchaseCounterRvModel.mGoodsAmountModel.mGoodsItemState != GoodsItemState.FOR_SALE || !BusinessDataHelper.checkBusinessStatusNormal(goodsPurchaseCounterRvModel.mBusinessStatus)) {
            viewHolder.mSubtractIv.setImageResource(R.drawable.customer_ic_purchase_subtract_disable);
            viewHolder.mAddIv.setImageResource(R.drawable.customer_ic_purchase_add_disable);
            viewHolder.mAmountTv.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
            viewHolder.mAddIv.setOnClickListener((View.OnClickListener) null);
            viewHolder.mSubtractIv.setOnClickListener((View.OnClickListener) null);
        } else {
            viewHolder.mAddIv.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GoodsPurchaseCounterBinder.this.onAddGoodsClick(goodsPurchaseCounterRvModel.mGoodsAmountModel.mGoodsId, (View) null, (Bundle) null);
                }
            });
            if (goodsPurchaseCounterRvModel.mGoodsAmountModel.exceedMinAmount()) {
                viewHolder.mSubtractIv.setImageResource(R.drawable.customer_ic_purchase_subtract_disable);
            } else {
                viewHolder.mSubtractIv.setImageResource(R.drawable.customer_ic_purchase_subtract);
            }
            if (goodsPurchaseCounterRvModel.mGoodsAmountModel.exceedMaxAmount() || goodsPurchaseCounterRvModel.mGoodsAmountModel.exceedMaxSaleAmount()) {
                viewHolder.mAddIv.setImageResource(R.drawable.customer_ic_purchase_add_disable);
            } else {
                viewHolder.mAddIv.setImageResource(R.drawable.customer_ic_purchase_add);
            }
            viewHolder.mAmountTv.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
        }
        m29915a(viewHolder, goodsPurchaseCounterRvModel);
    }

    public Class<GoodsPurchaseCounterRvModel> bindDataType() {
        return GoodsPurchaseCounterRvModel.class;
    }

    /* renamed from: a */
    private void m29914a(ViewHolder viewHolder) {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 15.0f, 0.0f, 15.0f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.7f, 0.0f);
        animationSet.setDuration(300);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        viewHolder.mSpreadCircle.startAnimation(animationSet);
    }

    /* renamed from: a */
    private void m29915a(ViewHolder viewHolder, GoodsPurchaseCounterRvModel goodsPurchaseCounterRvModel) {
        if (TextUtils.isEmpty(goodsPurchaseCounterRvModel.mBuyTip)) {
            viewHolder.mTip.setVisibility(8);
        } else if (!goodsPurchaseCounterRvModel.mReceviedGiftLimit || this.f42440b) {
            viewHolder.mTip.setVisibility(0);
            viewHolder.mTip.setText(goodsPurchaseCounterRvModel.mBuyTip);
        } else {
            viewHolder.mTip.setVisibility(0);
            AnimationSet animationSet = new AnimationSet(true);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 37.0f, 0.0f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            animationSet.setDuration(300);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(alphaAnimation);
            viewHolder.mTip.startAnimation(animationSet);
            viewHolder.mTip.setText(goodsPurchaseCounterRvModel.mBuyTip);
            m29914a(viewHolder);
        }
        this.f42440b = goodsPurchaseCounterRvModel.mReceviedGiftLimit;
    }

    class ViewHolder extends ItemViewHolder<GoodsPurchaseCounterRvModel> {
        ImageView mAddIv;
        TextView mAmountTv;
        LinearLayout mCounterContainer;
        ImageView mSpreadCircle;
        ImageView mSubtractIv;
        TextView mTip;

        public ViewHolder(View view) {
            super(view);
            this.mSpreadCircle = (ImageView) view.findViewById(R.id.customer_iv_circle);
            this.mTip = (TextView) view.findViewById(R.id.customer_tv_tip);
            this.mSubtractIv = (ImageView) view.findViewById(R.id.customer_iv_subtract);
            this.mAddIv = (ImageView) view.findViewById(R.id.customer_iv_add);
            this.mAmountTv = (TextView) view.findViewById(R.id.customer_tv_amount);
            this.mCounterContainer = (LinearLayout) view.findViewById(R.id.customer_counter_container);
        }
    }
}
