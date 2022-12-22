package com.didi.soda.globalcart.view;

import android.content.Context;
import android.view.View;
import com.didi.soda.bill.model.datamodel.BillCartItemModel;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/globalcart/view/CartGiftDishItemView;", "Lcom/didi/soda/globalcart/view/CartDishItemView;", "context", "Landroid/content/Context;", "isNewVersion", "", "(Landroid/content/Context;Z)V", "dishAmount", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "dishDetail", "dishName", "dishOriginPrice", "giftTagView", "maskView", "Landroid/view/View;", "bindData", "", "model", "Lcom/didi/soda/bill/model/datamodel/BillCartItemModel;", "isBusinessOpen", "initView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartGiftDishItemView.kt */
public final class CartGiftDishItemView extends CartDishItemView {

    /* renamed from: a */
    private CustomerAppCompatTextView f42335a;

    /* renamed from: b */
    private CustomerAppCompatTextView f42336b;

    /* renamed from: c */
    private CustomerAppCompatTextView f42337c;

    /* renamed from: d */
    private CustomerAppCompatTextView f42338d;

    /* renamed from: e */
    private CustomerAppCompatTextView f42339e;

    /* renamed from: f */
    private View f42340f;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartGiftDishItemView(Context context, boolean z) {
        super(context, z);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, isNewVersion() ? R.layout.customer_widget_cart_gift_dish_item_view2 : R.layout.customer_widget_cart_gift_dish_item_view, this);
        View findViewById = findViewById(R.id.customer_tv_gift_dish_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_gift_dish_tag)");
        this.f42335a = (CustomerAppCompatTextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_tv_gift_dish_name);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_gift_dish_name)");
        this.f42336b = (CustomerAppCompatTextView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_gift_dish_detail);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_gift_dish_detail)");
        this.f42337c = (CustomerAppCompatTextView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_tv_cart_gift_dish_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…tv_cart_gift_dish_amount)");
        this.f42338d = (CustomerAppCompatTextView) findViewById4;
        View findViewById5 = findViewById(R.id.customer_tv_cart_gift_dish_origin_price);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…t_gift_dish_origin_price)");
        this.f42339e = (CustomerAppCompatTextView) findViewById5;
        View findViewById6 = findViewById(R.id.customer_cart_mask_view);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_cart_mask_view)");
        this.f42340f = findViewById6;
    }

    public void bindData(BillCartItemModel billCartItemModel, boolean z) {
        Intrinsics.checkNotNullParameter(billCartItemModel, "model");
        CharSequence itemName = billCartItemModel.getItemName();
        boolean z2 = true;
        View view = null;
        if (!(itemName == null || itemName.length() == 0)) {
            CustomerAppCompatTextView customerAppCompatTextView = this.f42336b;
            if (customerAppCompatTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishName");
                customerAppCompatTextView = null;
            }
            customerAppCompatTextView.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView2 = this.f42336b;
            if (customerAppCompatTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishName");
                customerAppCompatTextView2 = null;
            }
            customerAppCompatTextView2.setText(billCartItemModel.getItemName());
        } else {
            CustomerAppCompatTextView customerAppCompatTextView3 = this.f42336b;
            if (customerAppCompatTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishName");
                customerAppCompatTextView3 = null;
            }
            customerAppCompatTextView3.setVisibility(8);
        }
        CharSequence subItemDesc = billCartItemModel.getSubItemDesc();
        if (!(subItemDesc == null || subItemDesc.length() == 0)) {
            CustomerAppCompatTextView customerAppCompatTextView4 = this.f42337c;
            if (customerAppCompatTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishDetail");
                customerAppCompatTextView4 = null;
            }
            customerAppCompatTextView4.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView5 = this.f42337c;
            if (customerAppCompatTextView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishDetail");
                customerAppCompatTextView5 = null;
            }
            customerAppCompatTextView5.setText(billCartItemModel.getSubItemDesc());
        } else {
            CustomerAppCompatTextView customerAppCompatTextView6 = this.f42337c;
            if (customerAppCompatTextView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishDetail");
                customerAppCompatTextView6 = null;
            }
            customerAppCompatTextView6.setVisibility(4);
        }
        if (billCartItemModel.getAmount() > 0) {
            CustomerAppCompatTextView customerAppCompatTextView7 = this.f42338d;
            if (customerAppCompatTextView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishAmount");
                customerAppCompatTextView7 = null;
            }
            customerAppCompatTextView7.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView8 = this.f42338d;
            if (customerAppCompatTextView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishAmount");
                customerAppCompatTextView8 = null;
            }
            customerAppCompatTextView8.setText(Intrinsics.stringPlus("x", Integer.valueOf(billCartItemModel.getAmount())));
        }
        CharSequence priceDisplay = billCartItemModel.getPriceDisplay();
        if (!(priceDisplay == null || priceDisplay.length() == 0)) {
            z2 = false;
        }
        if (z2 || billCartItemModel.getPrice() <= billCartItemModel.getSpecialPrice()) {
            CustomerAppCompatTextView customerAppCompatTextView9 = this.f42339e;
            if (customerAppCompatTextView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishOriginPrice");
                customerAppCompatTextView9 = null;
            }
            customerAppCompatTextView9.setVisibility(8);
            CustomerAppCompatTextView customerAppCompatTextView10 = this.f42337c;
            if (customerAppCompatTextView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishDetail");
                customerAppCompatTextView10 = null;
            }
            if (customerAppCompatTextView10.getVisibility() == 4) {
                CustomerAppCompatTextView customerAppCompatTextView11 = this.f42337c;
                if (customerAppCompatTextView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dishDetail");
                    customerAppCompatTextView11 = null;
                }
                customerAppCompatTextView11.setVisibility(8);
            }
        } else {
            CustomerAppCompatTextView customerAppCompatTextView12 = this.f42339e;
            if (customerAppCompatTextView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishOriginPrice");
                customerAppCompatTextView12 = null;
            }
            customerAppCompatTextView12.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView13 = this.f42339e;
            if (customerAppCompatTextView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishOriginPrice");
                customerAppCompatTextView13 = null;
            }
            customerAppCompatTextView13.setText(billCartItemModel.getPriceDisplay());
            CustomerAppCompatTextView customerAppCompatTextView14 = this.f42339e;
            if (customerAppCompatTextView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishOriginPrice");
                customerAppCompatTextView14 = null;
            }
            customerAppCompatTextView14.getPaint().setFlags(16);
        }
        if (z) {
            View view2 = this.f42340f;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        View view3 = this.f42340f;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maskView");
        } else {
            view = view3;
        }
        view.setVisibility(0);
    }
}
