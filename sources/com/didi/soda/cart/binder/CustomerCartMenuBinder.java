package com.didi.soda.cart.binder;

import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.widget.TextViewCompat;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.rfusion.widget.stepper.RFStepper;
import com.didi.soda.cart.listener.OnFloatingCartItemListener;
import com.didi.soda.cart.model.CartItemModel;
import com.didi.soda.cart.omega.FloatingCartOmegaHelper;
import com.didi.soda.customer.foundation.rpc.entity.ActTagEntity;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.RoundImageView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001aB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/cart/binder/CustomerCartMenuBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/cart/model/CartItemModel;", "Lcom/didi/soda/cart/binder/CustomerCartMenuBinder$ViewHolder;", "Lcom/didi/soda/cart/listener/OnFloatingCartItemListener;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "modifyMarginTop", "view", "Landroid/view/View;", "rootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "marginTop", "", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerCartMenuBinder.kt */
public abstract class CustomerCartMenuBinder extends ItemBinder<CartItemModel, ViewHolder> implements OnFloatingCartItemListener {
    /* access modifiers changed from: private */
    public ScopeContext scopeContext;

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1  reason: not valid java name */
    public static final void m46849bind$lambda1(View view) {
    }

    public Class<CartItemModel> bindDataType() {
        return CartItemModel.class;
    }

    public CustomerCartMenuBinder(ScopeContext scopeContext2) {
        Intrinsics.checkNotNullParameter(scopeContext2, "scopeContext");
        this.scopeContext = scopeContext2;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.customer_binder_cart_menu, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…cart_menu, parent, false)");
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, CartItemModel cartItemModel) {
        ActTagEntity actTagEntity;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(cartItemModel, "item");
        FloatingCartOmegaHelper.Companion.trackItemRealShow("1", Intrinsics.stringPlus(cartItemModel.getCartId(), ""), cartItemModel.getShopId(), cartItemModel.getItemId(), Intrinsics.stringPlus("", Integer.valueOf(cartItemModel.getPrice())), Intrinsics.stringPlus("", Integer.valueOf(cartItemModel.getSpecialPrice())), Intrinsics.stringPlus("", Integer.valueOf(cartItemModel.getActivityType())));
        CharSequence headImg = cartItemModel.getHeadImg();
        boolean z = true;
        if (headImg == null || headImg.length() == 0) {
            viewHolder.getDishImageParent().setVisibility(8);
        } else {
            viewHolder.getDishImageParent().setVisibility(0);
            FlyImageLoader.loadImage1x1(viewHolder.getView().getContext(), cartItemModel.getHeadImg()).placeholder((int) R.drawable.customer_skin_img_business_goods_item_x11).into((ImageView) viewHolder.getDishImage());
        }
        CharSequence itemName = cartItemModel.getItemName();
        if (!(itemName == null || itemName.length() == 0)) {
            viewHolder.getDishName().setVisibility(0);
            viewHolder.getDishName().setText(cartItemModel.getItemName());
        } else {
            viewHolder.getDishName().setVisibility(8);
        }
        CharSequence subItemDesc = cartItemModel.getSubItemDesc();
        if (!(subItemDesc == null || subItemDesc.length() == 0)) {
            viewHolder.getDishDetail().setVisibility(0);
            viewHolder.getDishDetail().setText(cartItemModel.getSubItemDesc());
        } else {
            viewHolder.getDishDetail().setVisibility(8);
        }
        CharSequence priceDisplay = cartItemModel.getPriceDisplay();
        if ((priceDisplay == null || priceDisplay.length() == 0) || cartItemModel.getSpecialPrice() >= cartItemModel.getPrice()) {
            viewHolder.getDishOriginPrice().setVisibility(8);
        } else {
            CharSequence priceDisplay2 = cartItemModel.getPriceDisplay();
            if (!(priceDisplay2 == null || priceDisplay2.length() == 0)) {
                viewHolder.getDishOriginPrice().setVisibility(0);
                SpannableString spannableString = new SpannableString(cartItemModel.getPriceDisplay());
                StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                String priceDisplay3 = cartItemModel.getPriceDisplay();
                Intrinsics.checkNotNull(priceDisplay3);
                spannableString.setSpan(strikethroughSpan, 0, priceDisplay3.length(), 33);
                viewHolder.getDishOriginPrice().setText(spannableString);
            }
        }
        CharSequence specialPriceDisplay = cartItemModel.getSpecialPriceDisplay();
        if (specialPriceDisplay == null || specialPriceDisplay.length() == 0) {
            viewHolder.getDishFavorPrice().setVisibility(8);
        } else {
            viewHolder.getDishFavorPrice().setVisibility(0);
            viewHolder.getDishFavorPrice().setText(cartItemModel.getSpecialPriceDisplay());
        }
        viewHolder.getView().setOnClickListener(new View.OnClickListener(cartItemModel) {
            public final /* synthetic */ CartItemModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CustomerCartMenuBinder.m46848bind$lambda0(CustomerCartMenuBinder.this, this.f$1, view);
            }
        });
        viewHolder.getStepperContainer().setOnClickListener($$Lambda$CustomerCartMenuBinder$YwmKIom4S8rR6b02VVwxom7uz30.INSTANCE);
        viewHolder.getStepper().setOnStepperChangedListener((RFStepper.OnStepperChangedListener) null);
        viewHolder.getStepper().setCurValue(cartItemModel.getAmount());
        if (cartItemModel.getShopStatus() != 1) {
            viewHolder.getStepper().setEnablePlusAction(false);
            viewHolder.getStepper().setEnableMinusAction(false);
        } else {
            viewHolder.getStepper().setEnablePlusAction(true);
            viewHolder.getStepper().setEnableMinusAction(true);
        }
        viewHolder.getStepper().setOnStepperChangedListener(new CustomerCartMenuBinder$bind$3(this, cartItemModel));
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(viewHolder.getDishOriginPrice(), 2, 14, 1, 1);
        viewHolder.getActIcon().setVisibility(8);
        viewHolder.getActInfo().setVisibility(8);
        List<ActTagEntity> mActTagList = cartItemModel.getMActTagList();
        if (mActTagList != null && (actTagEntity = mActTagList.get(0)) != null) {
            CharSequence charSequence = actTagEntity.content;
            if (!(charSequence == null || charSequence.length() == 0)) {
                viewHolder.getActInfo().setText(actTagEntity.content);
                viewHolder.getActInfo().setVisibility(0);
                if (cartItemModel.getActivityType() == 2) {
                    viewHolder.getActInfo().setBackgroundResource(0);
                    modifyMarginTop(viewHolder.getActInfo(), viewHolder.getItemInfoContainer(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_10));
                } else {
                    viewHolder.getActInfo().setBackgroundResource(R.drawable.customer_shape_cart_present_tag_bg);
                    modifyMarginTop(viewHolder.getActInfo(), viewHolder.getItemInfoContainer(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_8));
                }
            }
            CharSequence charSequence2 = actTagEntity.icon;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                z = false;
            }
            if (!z) {
                viewHolder.getActIcon().setText(actTagEntity.icon);
                viewHolder.getActIcon().setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m46848bind$lambda0(CustomerCartMenuBinder customerCartMenuBinder, CartItemModel cartItemModel, View view) {
        Intrinsics.checkNotNullParameter(customerCartMenuBinder, "this$0");
        Intrinsics.checkNotNullParameter(cartItemModel, "$model");
        customerCartMenuBinder.toBusinessSkuPage(cartItemModel);
    }

    private final void modifyMarginTop(View view, ConstraintLayout constraintLayout, int i) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.setMargin(view.getId(), 3, i);
        constraintSet.applyTo(constraintLayout);
        view.setTag(true);
    }

    @Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0011\u0010\u001d\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001a¨\u0006*"}, mo175978d2 = {"Lcom/didi/soda/cart/binder/CustomerCartMenuBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/cart/model/CartItemModel;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "actIcon", "Lcom/didi/soda/customer/widget/text/IconRichTextView;", "getActIcon", "()Lcom/didi/soda/customer/widget/text/IconRichTextView;", "actInfo", "Lcom/didi/soda/customer/widget/text/RichTextView;", "getActInfo", "()Lcom/didi/soda/customer/widget/text/RichTextView;", "dishDetail", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "getDishDetail", "()Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "dishFavorPrice", "getDishFavorPrice", "dishImage", "Lcom/didi/soda/customer/widget/RoundImageView;", "getDishImage", "()Lcom/didi/soda/customer/widget/RoundImageView;", "dishImageParent", "getDishImageParent", "()Landroid/view/View;", "dishName", "getDishName", "dishOriginPrice", "getDishOriginPrice", "itemInfoContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getItemInfoContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "stepper", "Lcom/didi/rfusion/widget/stepper/RFStepper;", "getStepper", "()Lcom/didi/rfusion/widget/stepper/RFStepper;", "stepperContainer", "getStepperContainer", "getView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerCartMenuBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<CartItemModel> {
        private final IconRichTextView actIcon;
        private final RichTextView actInfo;
        private final CustomerAppCompatTextView dishDetail;
        private final CustomerAppCompatTextView dishFavorPrice;
        private final RoundImageView dishImage;
        private final View dishImageParent;
        private final CustomerAppCompatTextView dishName;
        private final CustomerAppCompatTextView dishOriginPrice;
        private final ConstraintLayout itemInfoContainer;
        private final RFStepper stepper;
        private final ConstraintLayout stepperContainer;
        private final View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
            super(view2);
            Intrinsics.checkNotNullParameter(view2, "view");
            this.view = view2;
            View findViewById = view2.findViewById(R.id.customer_cl_sku_detail);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.customer_cl_sku_detail)");
            this.itemInfoContainer = (ConstraintLayout) findViewById;
            View findViewById2 = this.view.findViewById(R.id.customer_iv_dish_image);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.customer_iv_dish_image)");
            this.dishImage = (RoundImageView) findViewById2;
            View findViewById3 = this.view.findViewById(R.id.customer_fl_dish_image_parent);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.c…mer_fl_dish_image_parent)");
            this.dishImageParent = findViewById3;
            View findViewById4 = this.view.findViewById(R.id.customer_tv_dish_name);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.customer_tv_dish_name)");
            this.dishName = (CustomerAppCompatTextView) findViewById4;
            View findViewById5 = this.view.findViewById(R.id.customer_tv_dish_detail);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.customer_tv_dish_detail)");
            this.dishDetail = (CustomerAppCompatTextView) findViewById5;
            View findViewById6 = this.view.findViewById(R.id.customer_tv_cart_dish_favor_price);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.c…tv_cart_dish_favor_price)");
            this.dishFavorPrice = (CustomerAppCompatTextView) findViewById6;
            View findViewById7 = this.view.findViewById(R.id.customer_tv_cart_dish_origin_price);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.c…v_cart_dish_origin_price)");
            this.dishOriginPrice = (CustomerAppCompatTextView) findViewById7;
            View findViewById8 = this.view.findViewById(R.id.customer_custom_stepper);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.customer_custom_stepper)");
            this.stepper = (RFStepper) findViewById8;
            View findViewById9 = this.view.findViewById(R.id.customer_cl_stepper_container);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.c…mer_cl_stepper_container)");
            this.stepperContainer = (ConstraintLayout) findViewById9;
            View findViewById10 = this.view.findViewById(R.id.customer_tv_cart_dish_act_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.c…er_tv_cart_dish_act_icon)");
            this.actIcon = (IconRichTextView) findViewById10;
            View findViewById11 = this.view.findViewById(R.id.customer_tv_cart_dish_act_info);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.c…er_tv_cart_dish_act_info)");
            this.actInfo = (RichTextView) findViewById11;
        }

        public final View getView() {
            return this.view;
        }

        public final ConstraintLayout getItemInfoContainer() {
            return this.itemInfoContainer;
        }

        public final RoundImageView getDishImage() {
            return this.dishImage;
        }

        public final View getDishImageParent() {
            return this.dishImageParent;
        }

        public final CustomerAppCompatTextView getDishName() {
            return this.dishName;
        }

        public final CustomerAppCompatTextView getDishDetail() {
            return this.dishDetail;
        }

        public final CustomerAppCompatTextView getDishFavorPrice() {
            return this.dishFavorPrice;
        }

        public final CustomerAppCompatTextView getDishOriginPrice() {
            return this.dishOriginPrice;
        }

        public final RFStepper getStepper() {
            return this.stepper;
        }

        public final ConstraintLayout getStepperContainer() {
            return this.stepperContainer;
        }

        public final IconRichTextView getActIcon() {
            return this.actIcon;
        }

        public final RichTextView getActInfo() {
            return this.actInfo;
        }
    }
}
