package com.didi.soda.goods.binder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.app.nova.skeleton.image.ImageRequestListener;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.goods.GoodsStateBar;
import com.didi.soda.goods.contract.GoodsItemState;
import com.didi.soda.goods.helper.GoodsDataHelper;
import com.didi.soda.goods.model.GoodsPurchaseHeaderRvModel;
import com.taxis99.R;

public abstract class GoodsPurchaseHeaderBinder extends ItemBinder<GoodsPurchaseHeaderRvModel, ViewHolder> {
    public abstract void onBind(View view, View view2, View view3);

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_goods_purchasel_header, viewGroup, false));
    }

    public void bind(final ViewHolder viewHolder, GoodsPurchaseHeaderRvModel goodsPurchaseHeaderRvModel) {
        GoodsItemState goodsItemState = GoodsDataHelper.getGoodsItemState(goodsPurchaseHeaderRvModel.mStatus, goodsPurchaseHeaderRvModel.mSoldStatus, goodsPurchaseHeaderRvModel.mBusinessStatus);
        if (TextUtils.isEmpty(goodsPurchaseHeaderRvModel.mHeadImg)) {
            viewHolder.mGoodsMask.setVisibility(8);
            if (GoodsDataHelper.isSoldOutOrLimitSale(goodsItemState)) {
                viewHolder.mGoodsName.setVisibility(0);
                viewHolder.mGoodsImg.setVisibility(0);
                Context context = viewHolder.mGoodsImg.getContext();
                viewHolder.mGoodsImg.setImageDrawable(BitmapUtil.getRoundedDrawable(context, R.drawable.customer_skin_img_placeholder_x75, DisplayUtils.dip2px(context, 4.0f)));
            } else {
                viewHolder.mGoodsName.setVisibility(8);
                viewHolder.mGoodsImg.setVisibility(8);
            }
        } else {
            viewHolder.mGoodsName.setVisibility(0);
            viewHolder.mGoodsImg.setVisibility(0);
            FlyImageLoader.loadImage1x1(viewHolder.mGoodsImg.getContext(), goodsPurchaseHeaderRvModel.mHeadImg).placeholder((Drawable) BitmapUtil.getRoundedDrawable(viewHolder.mGoodsImg.getContext(), R.drawable.customer_skin_img_placeholder_x75, 0)).centerCrop().transform(new RoundedCornersTransformation(viewHolder.mGoodsImg.getContext(), 0, 0, RoundedCornersTransformation.CornerType.ALL, true)).listener(new ImageRequestListener() {
                public boolean onException(Exception exc, boolean z) {
                    viewHolder.mGoodsMask.setVisibility(8);
                    return false;
                }

                public boolean onResourceReady(Object obj, boolean z, boolean z2) {
                    viewHolder.mGoodsMask.setVisibility(0);
                    return false;
                }
            }).into(viewHolder.mGoodsImg);
        }
        viewHolder.mGoodsName.setText(goodsPurchaseHeaderRvModel.mGoodsName);
        if (TextUtils.isEmpty(goodsPurchaseHeaderRvModel.mShortDesc)) {
            viewHolder.mGoodsDesc.setVisibility(8);
        } else {
            viewHolder.mGoodsDesc.setText(goodsPurchaseHeaderRvModel.mShortDesc);
            viewHolder.mGoodsDesc.setVisibility(0);
        }
        viewHolder.mGoodsStateBar.setActTag(goodsPurchaseHeaderRvModel.mActTagModel, goodsItemState);
        if (!goodsPurchaseHeaderRvModel.mNeedShowAlcoholRemind || TextUtils.isEmpty(goodsPurchaseHeaderRvModel.mSoldDesc)) {
            viewHolder.mNeedShowAlcoholRemind.setVisibility(8);
        } else {
            viewHolder.mNeedShowAlcoholRemind.setVisibility(0);
            viewHolder.mNeedShowAlcoholRemind.setText(goodsPurchaseHeaderRvModel.mSoldDesc);
            OmegaTracker.Builder.create(EventConst.Alcohol.SPEC_TEXT_SHOW).addEventParam("shop_id", goodsPurchaseHeaderRvModel.mBusinessId).addEventParam(ParamConst.PARAM_SHOP_BIZ_STATUS, Integer.valueOf(goodsPurchaseHeaderRvModel.mBusinessStatus)).addEventParam("item_id", goodsPurchaseHeaderRvModel.mGoodsId).build().track();
        }
        if (goodsItemState == GoodsItemState.SHOP_DISABLED) {
            viewHolder.mStatusTextView.setVisibility(8);
        } else if (goodsItemState == GoodsItemState.SOLD_OUT) {
            viewHolder.mStatusTextView.setVisibility(0);
            viewHolder.mStatusTextView.setText(ResourceHelper.getString(R.string.customer_global_sold_out));
        } else if (goodsItemState != GoodsItemState.LIMIT_SALE) {
            viewHolder.mStatusTextView.setVisibility(8);
        } else if (TextUtils.isEmpty(goodsPurchaseHeaderRvModel.mSoldTimeDesc)) {
            viewHolder.mStatusTextView.setVisibility(8);
        } else {
            viewHolder.mStatusTextView.setVisibility(0);
            viewHolder.mStatusTextView.setText(goodsPurchaseHeaderRvModel.mSoldTimeDesc);
        }
        onBind(viewHolder.itemView, viewHolder.mGoodsName, viewHolder.mGoodsImg);
    }

    public Class<GoodsPurchaseHeaderRvModel> bindDataType() {
        return GoodsPurchaseHeaderRvModel.class;
    }

    class ViewHolder extends ItemViewHolder<GoodsPurchaseHeaderRvModel> {
        TextView mGoodsDesc;
        ImageView mGoodsImg;
        View mGoodsMask;
        TextView mGoodsName;
        GoodsStateBar mGoodsStateBar;
        TextView mNeedShowAlcoholRemind;
        TextView mStatusTextView;

        ViewHolder(View view) {
            super(view);
            this.mGoodsMask = view.findViewById(R.id.customer_view_goods_detial_mask);
            this.mGoodsImg = (ImageView) view.findViewById(R.id.customer_iv_goods_detail_img);
            this.mGoodsName = (TextView) view.findViewById(R.id.customer_tv_goods_detail_name);
            this.mGoodsDesc = (TextView) view.findViewById(R.id.customer_tv_goods_detail_desc);
            this.mGoodsStateBar = (GoodsStateBar) view.findViewById(R.id.customer_custom_business_goods_state_bar);
            this.mNeedShowAlcoholRemind = (TextView) view.findViewById(R.id.customer_tv_goods_detail_alcohol_remind);
            this.mStatusTextView = (TextView) view.findViewById(R.id.customer_iv_goods_detail_status);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mGoodsName, IToolsService.FontType.MEDIUM);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mGoodsDesc, IToolsService.FontType.LIGHT);
        }
    }
}
