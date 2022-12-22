package com.didi.soda.cart.binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.cart.model.CartTyingItemModel;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CustomerTyingItemAdapter extends RecyclerView.Adapter<TyingViewHolder> {

    /* renamed from: a */
    private List<CartTyingItemModel> f39894a = new ArrayList();

    /* renamed from: b */
    private OnItemClickListener f39895b;

    public interface OnItemClickListener {
        void onItemAddClick(CartTyingItemModel cartTyingItemModel);

        void onItemClick(CartTyingItemModel cartTyingItemModel);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f39895b = onItemClickListener;
    }

    public int getItemCount() {
        return this.f39894a.size();
    }

    public void onBindViewHolder(TyingViewHolder tyingViewHolder, int i) {
        List<CartTyingItemModel> list;
        if (tyingViewHolder != null && (list = this.f39894a) != null && i < list.size()) {
            CartTyingItemModel cartTyingItemModel = this.f39894a.get(i);
            Context context = tyingViewHolder.itemView.getContext();
            if (cartTyingItemModel != null && context != null) {
                tyingViewHolder.itemView.setOnClickListener(new View.OnClickListener(cartTyingItemModel) {
                    public final /* synthetic */ CartTyingItemModel f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        CustomerTyingItemAdapter.this.m28454b(this.f$1, view);
                    }
                });
                tyingViewHolder.mCustomerTvDishPurchase.setOnClickListener(new View.OnClickListener(cartTyingItemModel) {
                    public final /* synthetic */ CartTyingItemModel f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        CustomerTyingItemAdapter.this.m28453a(this.f$1, view);
                    }
                });
                FlyImageLoader.loadImage1x1(context, cartTyingItemModel.getHeadImg()).placeholder((int) R.drawable.customer_img_dish_round_border_placeholder).into(tyingViewHolder.mCustomerIvDishImage);
                tyingViewHolder.mCustomerTvDishName.setText(cartTyingItemModel.getItemName());
                String specialPriceDisplay = cartTyingItemModel.getSpecialPrice() >= 0 ? cartTyingItemModel.getSpecialPriceDisplay() : cartTyingItemModel.getPriceDisplay();
                String priceDisplay = cartTyingItemModel.getSpecialPrice() >= 0 ? cartTyingItemModel.getPriceDisplay() : "";
                tyingViewHolder.mCustomerTvDishChargePrice.setText(specialPriceDisplay);
                tyingViewHolder.mCustomerTvDishOriginPrice.setText(priceDisplay);
                if (cartTyingItemModel.getMGoodsMarketingTips() == null || cartTyingItemModel.getMGoodsMarketingTips().size() <= 0 || cartTyingItemModel.getMGoodsMarketingTips().get(0) == null) {
                    tyingViewHolder.mCustomerTvMatketTip.setVisibility(8);
                } else {
                    tyingViewHolder.mCustomerTvMatketTip.setVisibility(0);
                    tyingViewHolder.mCustomerTvMatketTip.setText(cartTyingItemModel.getMGoodsMarketingTips().get(0));
                }
                if (getItemCount() >= 1 && i == getItemCount() - 1 && (tyingViewHolder.mCustomerClItemRoot.getLayoutParams() instanceof RecyclerView.LayoutParams)) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) tyingViewHolder.mCustomerClItemRoot.getLayoutParams();
                    layoutParams.rightMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32);
                    tyingViewHolder.mCustomerClItemRoot.setLayoutParams(layoutParams);
                } else if (tyingViewHolder.mCustomerClItemRoot.getLayoutParams() instanceof RecyclerView.LayoutParams) {
                    RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) tyingViewHolder.mCustomerClItemRoot.getLayoutParams();
                    layoutParams2.rightMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_0);
                    tyingViewHolder.mCustomerClItemRoot.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m28454b(CartTyingItemModel cartTyingItemModel, View view) {
        OnItemClickListener onItemClickListener = this.f39895b;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(cartTyingItemModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28453a(CartTyingItemModel cartTyingItemModel, View view) {
        OnItemClickListener onItemClickListener = this.f39895b;
        if (onItemClickListener != null) {
            onItemClickListener.onItemAddClick(cartTyingItemModel);
        }
    }

    public void setCartItemModels(List<CartTyingItemModel> list) {
        this.f39894a.clear();
        notifyDataSetChanged();
        this.f39894a.addAll(list);
        notifyDataSetChanged();
    }

    public TyingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TyingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_tying_cart_item, viewGroup, false));
    }

    static class TyingViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout mCustomerClItemRoot;
        ImageView mCustomerIvDishImage = ((ImageView) this.itemView.findViewById(R.id.customer_iv_dish_image));
        RichTextView mCustomerTvDishChargePrice = ((RichTextView) this.itemView.findViewById(R.id.customer_tv_dish_charge_price));
        RichTextView mCustomerTvDishName = ((RichTextView) this.itemView.findViewById(R.id.customer_tv_dish_name));
        RichTextView mCustomerTvDishOriginPrice;
        RFIconView mCustomerTvDishPurchase;
        RichTextView mCustomerTvMatketTip;

        TyingViewHolder(View view) {
            super(view);
            RichTextView richTextView = (RichTextView) this.itemView.findViewById(R.id.customer_tv_dish_origin_price);
            this.mCustomerTvDishOriginPrice = richTextView;
            richTextView.getPaint().setFlags(16);
            this.mCustomerTvDishPurchase = (RFIconView) this.itemView.findViewById(R.id.customer_tv_dish_purchase);
            this.mCustomerClItemRoot = (ConstraintLayout) this.itemView.findViewById(R.id.customer_cl_item_root);
            this.mCustomerTvMatketTip = (RichTextView) this.itemView.findViewById(R.id.tv_market_tip);
        }
    }
}
