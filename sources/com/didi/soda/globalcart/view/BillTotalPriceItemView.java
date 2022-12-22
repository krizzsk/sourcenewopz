package com.didi.soda.globalcart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.didi.raven.config.RavenKey;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.PriceInfoModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.cart.listener.OnCartItemOperateListener;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.didi.soda.globalcart.binder.GlobalCartItemBinder;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB'\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u001cR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/globalcart/view/BillTotalPriceItemView;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "checkoutBtn", "Lcom/didi/rfusion/widget/button/RFMainButton;", "hintTv", "Lcom/didi/soda/customer/widget/text/RichTextView;", "listener", "Lcom/didi/soda/cart/listener/OnCartItemOperateListener;", "totalPriceTv", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "initView", "", "setData", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "setOnCartItemOperateListener", "Lcom/didi/soda/globalcart/binder/GlobalCartItemBinder;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillTotalPriceItemView.kt */
public final class BillTotalPriceItemView extends BillItemView<ItemViewCommonLogic> {

    /* renamed from: a */
    private CustomerAppCompatTextView f42318a;

    /* renamed from: b */
    private RichTextView f42319b;

    /* renamed from: c */
    private RFMainButton f42320c;

    /* renamed from: d */
    private OnCartItemOperateListener f42321d;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillTotalPriceItemView(Context context) {
        super(context, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillTotalPriceItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillTotalPriceItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillTotalPriceItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    public void initView() {
        View.inflate(getContext(), R.layout.customer_widget_cart_checkout_item_view, this);
        View findViewById = findViewById(R.id.customer_tv_cart_total_price);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_cart_total_price)");
        this.f42318a = (CustomerAppCompatTextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_tv_cart_hint);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_cart_hint)");
        this.f42319b = (RichTextView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_checkout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_checkout)");
        this.f42320c = (RFMainButton) findViewById3;
    }

    public final void setOnCartItemOperateListener(GlobalCartItemBinder globalCartItemBinder) {
        Intrinsics.checkNotNullParameter(globalCartItemBinder, "listener");
        this.f42321d = globalCartItemBinder;
    }

    public void setData(ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        ComponentDataModel data = componentModel.getData();
        RFMainButton rFMainButton = null;
        PriceInfoModel priceInfoModel = data == null ? null : data.getPriceInfoModel();
        boolean z = true;
        if (priceInfoModel != null) {
            CharSequence payPriceDisplay = priceInfoModel.getPayPriceDisplay();
            if (!(payPriceDisplay == null || payPriceDisplay.length() == 0)) {
                CustomerAppCompatTextView customerAppCompatTextView = this.f42318a;
                if (customerAppCompatTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("totalPriceTv");
                    customerAppCompatTextView = null;
                }
                customerAppCompatTextView.setVisibility(0);
                CustomerAppCompatTextView customerAppCompatTextView2 = this.f42318a;
                if (customerAppCompatTextView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("totalPriceTv");
                    customerAppCompatTextView2 = null;
                }
                customerAppCompatTextView2.setText(priceInfoModel.getPayPriceDisplay());
            } else {
                CustomerAppCompatTextView customerAppCompatTextView3 = this.f42318a;
                if (customerAppCompatTextView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("totalPriceTv");
                    customerAppCompatTextView3 = null;
                }
                customerAppCompatTextView3.setVisibility(8);
            }
        }
        CharSequence hint = componentModel.getHint();
        if (!(hint == null || hint.length() == 0)) {
            z = false;
        }
        if (!z) {
            RichTextView richTextView = this.f42319b;
            if (richTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintTv");
                richTextView = null;
            }
            richTextView.setVisibility(0);
            RichTextView richTextView2 = this.f42319b;
            if (richTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintTv");
                richTextView2 = null;
            }
            richTextView2.setText(componentModel.getHint());
        } else {
            RichTextView richTextView3 = this.f42319b;
            if (richTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hintTv");
                richTextView3 = null;
            }
            richTextView3.setVisibility(8);
        }
        RFMainButton rFMainButton2 = this.f42320c;
        if (rFMainButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutBtn");
        } else {
            rFMainButton = rFMainButton2;
        }
        rFMainButton.setOnClickListener(new View.OnClickListener(this) {
            public final /* synthetic */ BillTotalPriceItemView f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BillTotalPriceItemView.m29817a(ComponentModel.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29817a(ComponentModel componentModel, BillTotalPriceItemView billTotalPriceItemView, View view) {
        OnCartItemOperateListener onCartItemOperateListener;
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        Intrinsics.checkNotNullParameter(billTotalPriceItemView, "this$0");
        String shopId = componentModel.getShopId();
        CharSequence charSequence = shopId;
        if (!(charSequence == null || charSequence.length() == 0) && (onCartItemOperateListener = billTotalPriceItemView.f42321d) != null) {
            String cartId = componentModel.getCartId();
            if (cartId == null) {
                cartId = "";
            }
            onCartItemOperateListener.onCartItemCheckoutClick(shopId, cartId);
        }
    }
}
