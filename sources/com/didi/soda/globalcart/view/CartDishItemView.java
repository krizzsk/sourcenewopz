package com.didi.soda.globalcart.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.widget.TextViewCompat;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.bill.model.datamodel.BillCartItemModel;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.widget.RoundImageView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0002J\u0016\u0010&\u001a\u00020\u00162\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/didi/soda/globalcart/view/CartDishItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "isNewVersion", "", "(Landroid/content/Context;Z)V", "dishAmount", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "dishDetail", "dishImage", "Lcom/didi/soda/customer/widget/RoundImageView;", "dishItem", "Landroidx/constraintlayout/widget/ConstraintLayout;", "dishName", "dishOriginPrice", "dishSpecialPrice", "()Z", "maskView", "Landroid/view/View;", "ruleClickCallBack", "Lkotlin/Function0;", "", "ruleViewIcon", "Lcom/didi/rfusion/widget/RFIconView;", "tagViewIcon", "Landroid/widget/TextView;", "tagViewText", "bindData", "model", "Lcom/didi/soda/bill/model/datamodel/BillCartItemModel;", "isBusinessOpen", "initView", "modifyMarginTop", "view", "rootView", "marginTop", "", "setRuleClickCallBack", "callback", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartDishItemView.kt */
public class CartDishItemView extends FrameLayout {

    /* renamed from: a */
    private final boolean f42322a;

    /* renamed from: b */
    private ConstraintLayout f42323b;

    /* renamed from: c */
    private RoundImageView f42324c;

    /* renamed from: d */
    private CustomerAppCompatTextView f42325d;

    /* renamed from: e */
    private CustomerAppCompatTextView f42326e;

    /* renamed from: f */
    private CustomerAppCompatTextView f42327f;

    /* renamed from: g */
    private CustomerAppCompatTextView f42328g;

    /* renamed from: h */
    private CustomerAppCompatTextView f42329h;

    /* renamed from: i */
    private View f42330i;

    /* renamed from: j */
    private TextView f42331j;

    /* renamed from: k */
    private TextView f42332k;

    /* renamed from: l */
    private RFIconView f42333l;

    /* renamed from: m */
    private Function0<Unit> f42334m;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartDishItemView(Context context, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f42322a = z;
        initView(context);
    }

    public final boolean isNewVersion() {
        return this.f42322a;
    }

    public void initView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, this.f42322a ? R.layout.customer_widget_cart_dish_item_view2 : R.layout.customer_widget_cart_dish_item_view, this);
        View findViewById = findViewById(R.id.customer_widget_dish_item);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_widget_dish_item)");
        this.f42323b = (ConstraintLayout) findViewById;
        View findViewById2 = findViewById(R.id.customer_iv_dish_item);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_iv_dish_item)");
        this.f42324c = (RoundImageView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_dish_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_dish_name)");
        this.f42325d = (CustomerAppCompatTextView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_tv_dish_detail);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_tv_dish_detail)");
        this.f42326e = (CustomerAppCompatTextView) findViewById4;
        View findViewById5 = findViewById(R.id.customer_tv_cart_dish_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_tv_cart_dish_amount)");
        this.f42327f = (CustomerAppCompatTextView) findViewById5;
        View findViewById6 = findViewById(R.id.customer_tv_cart_dish_special_price);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.custom…_cart_dish_special_price)");
        this.f42328g = (CustomerAppCompatTextView) findViewById6;
        View findViewById7 = findViewById(R.id.customer_tv_cart_dish_origin_price);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.custom…v_cart_dish_origin_price)");
        this.f42329h = (CustomerAppCompatTextView) findViewById7;
        View findViewById8 = findViewById(R.id.customer_cart_mask_view);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.customer_cart_mask_view)");
        this.f42330i = findViewById8;
        View findViewById9 = findViewById(R.id.customer_activity_info);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.customer_activity_info)");
        this.f42331j = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.customer_activity_info_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.customer_activity_info_icon)");
        this.f42332k = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.customer_rule_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.customer_rule_icon)");
        this.f42333l = (RFIconView) findViewById11;
        CustomerAppCompatTextView customerAppCompatTextView = null;
        if (isNewVersion()) {
            CustomerAppCompatTextView customerAppCompatTextView2 = this.f42328g;
            if (customerAppCompatTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishSpecialPrice");
            } else {
                customerAppCompatTextView = customerAppCompatTextView2;
            }
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(customerAppCompatTextView, 10, 14, 1, 1);
            return;
        }
        CustomerAppCompatTextView customerAppCompatTextView3 = this.f42328g;
        if (customerAppCompatTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dishSpecialPrice");
        } else {
            customerAppCompatTextView = customerAppCompatTextView3;
        }
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(customerAppCompatTextView, 6, 18, 1, 1);
    }

    public void bindData(BillCartItemModel billCartItemModel, boolean z) {
        Intrinsics.checkNotNullParameter(billCartItemModel, "model");
        CharSequence headImg = billCartItemModel.getHeadImg();
        boolean z2 = true;
        ConstraintLayout constraintLayout = null;
        if (headImg == null || headImg.length() == 0) {
            RoundImageView roundImageView = this.f42324c;
            if (roundImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishImage");
                roundImageView = null;
            }
            roundImageView.setVisibility(8);
        } else {
            RoundImageView roundImageView2 = this.f42324c;
            if (roundImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishImage");
                roundImageView2 = null;
            }
            roundImageView2.setVisibility(0);
            FlyImageLoader.ImageRequestWrapper centerCrop = FlyImageLoader.loadImage1x1(getContext(), billCartItemModel.getHeadImg()).placeholder((int) R.drawable.customer_skin_img_business_goods_item_x11).centerCrop();
            RoundImageView roundImageView3 = this.f42324c;
            if (roundImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishImage");
                roundImageView3 = null;
            }
            centerCrop.into((ImageView) roundImageView3);
        }
        CharSequence itemName = billCartItemModel.getItemName();
        if (!(itemName == null || itemName.length() == 0)) {
            CustomerAppCompatTextView customerAppCompatTextView = this.f42325d;
            if (customerAppCompatTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishName");
                customerAppCompatTextView = null;
            }
            customerAppCompatTextView.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView2 = this.f42325d;
            if (customerAppCompatTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishName");
                customerAppCompatTextView2 = null;
            }
            customerAppCompatTextView2.setText(billCartItemModel.getItemName());
        } else {
            CustomerAppCompatTextView customerAppCompatTextView3 = this.f42325d;
            if (customerAppCompatTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishName");
                customerAppCompatTextView3 = null;
            }
            customerAppCompatTextView3.setVisibility(8);
        }
        CharSequence subItemDesc = billCartItemModel.getSubItemDesc();
        if (!(subItemDesc == null || subItemDesc.length() == 0)) {
            CustomerAppCompatTextView customerAppCompatTextView4 = this.f42326e;
            if (customerAppCompatTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishDetail");
                customerAppCompatTextView4 = null;
            }
            customerAppCompatTextView4.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView5 = this.f42326e;
            if (customerAppCompatTextView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishDetail");
                customerAppCompatTextView5 = null;
            }
            customerAppCompatTextView5.setText(billCartItemModel.getSubItemDesc());
        } else {
            CustomerAppCompatTextView customerAppCompatTextView6 = this.f42326e;
            if (customerAppCompatTextView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishDetail");
                customerAppCompatTextView6 = null;
            }
            customerAppCompatTextView6.setVisibility(8);
        }
        if (billCartItemModel.getAmount() > 0) {
            CustomerAppCompatTextView customerAppCompatTextView7 = this.f42327f;
            if (customerAppCompatTextView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishAmount");
                customerAppCompatTextView7 = null;
            }
            customerAppCompatTextView7.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView8 = this.f42327f;
            if (customerAppCompatTextView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishAmount");
                customerAppCompatTextView8 = null;
            }
            customerAppCompatTextView8.setText(Intrinsics.stringPlus("x", Integer.valueOf(billCartItemModel.getAmount())));
        }
        CharSequence specialPriceDisplay = billCartItemModel.getSpecialPriceDisplay();
        if (!(specialPriceDisplay == null || specialPriceDisplay.length() == 0)) {
            CustomerAppCompatTextView customerAppCompatTextView9 = this.f42328g;
            if (customerAppCompatTextView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishSpecialPrice");
                customerAppCompatTextView9 = null;
            }
            customerAppCompatTextView9.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView10 = this.f42328g;
            if (customerAppCompatTextView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishSpecialPrice");
                customerAppCompatTextView10 = null;
            }
            customerAppCompatTextView10.setText(billCartItemModel.getSpecialPriceDisplay());
        } else {
            CustomerAppCompatTextView customerAppCompatTextView11 = this.f42328g;
            if (customerAppCompatTextView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishSpecialPrice");
                customerAppCompatTextView11 = null;
            }
            customerAppCompatTextView11.setVisibility(8);
        }
        CharSequence priceDisplay = billCartItemModel.getPriceDisplay();
        if ((priceDisplay == null || priceDisplay.length() == 0) || billCartItemModel.getPrice() <= billCartItemModel.getSpecialPrice()) {
            CustomerAppCompatTextView customerAppCompatTextView12 = this.f42329h;
            if (customerAppCompatTextView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishOriginPrice");
                customerAppCompatTextView12 = null;
            }
            customerAppCompatTextView12.setVisibility(8);
        } else {
            CustomerAppCompatTextView customerAppCompatTextView13 = this.f42329h;
            if (customerAppCompatTextView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishOriginPrice");
                customerAppCompatTextView13 = null;
            }
            customerAppCompatTextView13.setVisibility(0);
            CustomerAppCompatTextView customerAppCompatTextView14 = this.f42329h;
            if (customerAppCompatTextView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishOriginPrice");
                customerAppCompatTextView14 = null;
            }
            customerAppCompatTextView14.setText(billCartItemModel.getPriceDisplay());
            CustomerAppCompatTextView customerAppCompatTextView15 = this.f42329h;
            if (customerAppCompatTextView15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishOriginPrice");
                customerAppCompatTextView15 = null;
            }
            CustomerExtentionKt.strike(customerAppCompatTextView15);
        }
        if (z) {
            View view = this.f42330i;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
                view = null;
            }
            view.setVisibility(8);
        } else {
            View view2 = this.f42330i;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskView");
                view2 = null;
            }
            view2.setVisibility(0);
        }
        TextView textView = this.f42331j;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagViewText");
            textView = null;
        }
        textView.setVisibility(8);
        TextView textView2 = this.f42332k;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagViewIcon");
            textView2 = null;
        }
        textView2.setVisibility(8);
        RFIconView rFIconView = this.f42333l;
        if (rFIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ruleViewIcon");
            rFIconView = null;
        }
        rFIconView.setVisibility(8);
        if (billCartItemModel.getActTag().size() > 0) {
            BillCartItemModel.DishActTag dishActTag = billCartItemModel.getActTag().get(0);
            Intrinsics.checkNotNullExpressionValue(dishActTag, "model.actTag[0]");
            BillCartItemModel.DishActTag dishActTag2 = dishActTag;
            CharSequence content = dishActTag2.getContent();
            if (!(content == null || content.length() == 0)) {
                TextView textView3 = this.f42331j;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagViewText");
                    textView3 = null;
                }
                textView3.setText(dishActTag2.getContent());
                TextView textView4 = this.f42331j;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagViewText");
                    textView4 = null;
                }
                textView4.setVisibility(0);
                if (billCartItemModel.getActivityType() == 2) {
                    TextView textView5 = this.f42331j;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tagViewText");
                        textView5 = null;
                    }
                    textView5.setBackgroundResource(0);
                    TextView textView6 = this.f42331j;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tagViewText");
                        textView6 = null;
                    }
                    View view3 = textView6;
                    ConstraintLayout constraintLayout2 = this.f42323b;
                    if (constraintLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dishItem");
                        constraintLayout2 = null;
                    }
                    m29818a(view3, constraintLayout2, getResources().getDimensionPixelSize(R.dimen.rf_dimen_10));
                } else {
                    TextView textView7 = this.f42331j;
                    if (textView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tagViewText");
                        textView7 = null;
                    }
                    textView7.setBackgroundResource(R.drawable.customer_shape_cart_present_tag_bg);
                    TextView textView8 = this.f42331j;
                    if (textView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tagViewText");
                        textView8 = null;
                    }
                    View view4 = textView8;
                    ConstraintLayout constraintLayout3 = this.f42323b;
                    if (constraintLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dishItem");
                        constraintLayout3 = null;
                    }
                    m29818a(view4, constraintLayout3, getResources().getDimensionPixelSize(R.dimen.rf_dimen_8));
                }
            }
            CharSequence icon = dishActTag2.getIcon();
            if (!(icon == null || icon.length() == 0)) {
                z2 = false;
            }
            if (!z2) {
                TextView textView9 = this.f42332k;
                if (textView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagViewIcon");
                    textView9 = null;
                }
                textView9.setText(dishActTag2.getIcon());
                TextView textView10 = this.f42332k;
                if (textView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagViewIcon");
                    textView10 = null;
                }
                textView10.setVisibility(0);
            }
        }
        if (billCartItemModel.getActRules() != null) {
            RFIconView rFIconView2 = this.f42333l;
            if (rFIconView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ruleViewIcon");
                rFIconView2 = null;
            }
            rFIconView2.setVisibility(0);
            RFIconView rFIconView3 = this.f42333l;
            if (rFIconView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ruleViewIcon");
                rFIconView3 = null;
            }
            rFIconView3.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CartDishItemView.m29819a(CartDishItemView.this, view);
                }
            });
            TextView textView11 = this.f42331j;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagViewText");
                textView11 = null;
            }
            View view5 = textView11;
            ConstraintLayout constraintLayout4 = this.f42323b;
            if (constraintLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dishItem");
            } else {
                constraintLayout = constraintLayout4;
            }
            m29818a(view5, constraintLayout, getResources().getDimensionPixelSize(R.dimen.rf_dimen_12));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29819a(CartDishItemView cartDishItemView, View view) {
        Intrinsics.checkNotNullParameter(cartDishItemView, "this$0");
        Function0<Unit> function0 = cartDishItemView.f42334m;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setRuleClickCallBack(Function0<Unit> function0) {
        this.f42334m = function0;
    }

    /* renamed from: a */
    private final void m29818a(View view, ConstraintLayout constraintLayout, int i) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.setMargin(view.getId(), 3, i);
        constraintSet.applyTo(constraintLayout);
        view.setTag(true);
    }
}
