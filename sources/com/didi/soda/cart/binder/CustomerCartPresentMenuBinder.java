package com.didi.soda.cart.binder;

import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.cart.model.CartPresentItemModel;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/cart/binder/CustomerCartPresentMenuBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/cart/model/CartPresentItemModel;", "Lcom/didi/soda/cart/binder/CustomerCartPresentMenuBinder$ViewHolder;", "()V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerCartPresentMenuBinder.kt */
public final class CustomerCartPresentMenuBinder extends ItemBinder<CartPresentItemModel, ViewHolder> {
    public Class<CartPresentItemModel> bindDataType() {
        return CartPresentItemModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.customer_binder_cart_present_menu_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…menu_item, parent, false)");
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, CartPresentItemModel cartPresentItemModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        viewHolder.bindData();
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/cart/binder/CustomerCartPresentMenuBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/cart/model/CartPresentItemModel;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "giftTag", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "presentDishAmount", "presentDishDetail", "presentDishName", "presentOriginPrice", "getView", "()Landroid/view/View;", "bindData", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerCartPresentMenuBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<CartPresentItemModel> {
        private final CustomerAppCompatTextView giftTag;
        private final CustomerAppCompatTextView presentDishAmount;
        private final CustomerAppCompatTextView presentDishDetail;
        private final CustomerAppCompatTextView presentDishName;
        private final CustomerAppCompatTextView presentOriginPrice;
        private final View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
            super(view2);
            Intrinsics.checkNotNullParameter(view2, "view");
            this.view = view2;
            View findViewById = view2.findViewById(R.id.customer_tv_cart_present_dish_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.c…v_cart_present_dish_name)");
            this.presentDishName = (CustomerAppCompatTextView) findViewById;
            View findViewById2 = this.view.findViewById(R.id.customer_tv_cart_present_dish_amount);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.c…cart_present_dish_amount)");
            this.presentDishAmount = (CustomerAppCompatTextView) findViewById2;
            View findViewById3 = this.view.findViewById(R.id.customer_tv_cart_present_dish_detail);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.c…cart_present_dish_detail)");
            this.presentDishDetail = (CustomerAppCompatTextView) findViewById3;
            View findViewById4 = this.view.findViewById(R.id.customer_tv_cart_present_origin_price);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.c…art_present_origin_price)");
            this.presentOriginPrice = (CustomerAppCompatTextView) findViewById4;
            View findViewById5 = this.view.findViewById(R.id.customer_tv_cart_present_tag);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.c…omer_tv_cart_present_tag)");
            this.giftTag = (CustomerAppCompatTextView) findViewById5;
        }

        public final View getView() {
            return this.view;
        }

        public final void bindData() {
            Object item = getItem();
            Intrinsics.checkNotNullExpressionValue(item, "item");
            CartPresentItemModel cartPresentItemModel = (CartPresentItemModel) item;
            CharSequence itemName = cartPresentItemModel.getItemName();
            boolean z = true;
            if (!(itemName == null || itemName.length() == 0)) {
                this.giftTag.setVisibility(0);
                this.presentDishName.setVisibility(0);
                this.presentDishName.setText(cartPresentItemModel.getItemName());
            } else {
                this.giftTag.setVisibility(8);
                this.presentDishName.setVisibility(8);
            }
            CharSequence subItemDesc = cartPresentItemModel.getSubItemDesc();
            if (subItemDesc == null || subItemDesc.length() == 0) {
                this.presentDishDetail.setVisibility(8);
            } else {
                this.presentDishDetail.setVisibility(0);
                this.presentDishDetail.setText(cartPresentItemModel.getSubItemDesc());
            }
            CharSequence priceDisplay = cartPresentItemModel.getPriceDisplay();
            if ((priceDisplay == null || priceDisplay.length() == 0) || cartPresentItemModel.getSpecialPrice() >= cartPresentItemModel.getPrice()) {
                this.presentOriginPrice.setVisibility(8);
            } else {
                CharSequence priceDisplay2 = cartPresentItemModel.getPriceDisplay();
                if (!(priceDisplay2 == null || priceDisplay2.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    this.presentOriginPrice.setVisibility(0);
                    SpannableString spannableString = new SpannableString(cartPresentItemModel.getPriceDisplay());
                    StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                    String priceDisplay3 = cartPresentItemModel.getPriceDisplay();
                    Intrinsics.checkNotNull(priceDisplay3);
                    spannableString.setSpan(strikethroughSpan, 0, priceDisplay3.length(), 33);
                    this.presentOriginPrice.setText(spannableString);
                }
            }
            this.presentDishAmount.setWidth((ResourceHelper.getDimensionPixelSize(R.dimen.rf_stepper_operation_size_small) * 2) + (ResourceHelper.getDimensionPixelSize(R.dimen.rf_stepper_content_margin_width_small) * 2) + ResourceHelper.getDimensionPixelSize(R.dimen.rf_stepper_content_size_small));
            this.presentDishAmount.setText(String.valueOf(cartPresentItemModel.getAmount()));
        }
    }
}
