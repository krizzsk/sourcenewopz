package com.didi.soda.globalcart.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.OutOfStockModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.customer.foundation.rpc.entity.cart.AbnormalItemDetailEntity;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/globalcart/view/BillOutOfStockItemView;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "context", "Landroid/content/Context;", "layoutId", "", "(Landroid/content/Context;I)V", "content", "Landroid/widget/TextView;", "icon", "Landroid/view/View;", "title", "setData", "", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillOutOfStockItemView.kt */
public final class BillOutOfStockItemView extends BillItemView<ItemViewCommonLogic> {

    /* renamed from: a */
    private final int f42314a;

    /* renamed from: b */
    private TextView f42315b;

    /* renamed from: c */
    private TextView f42316c;

    /* renamed from: d */
    private View f42317d;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillOutOfStockItemView(Context context, int i) {
        super(context, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f42314a = i;
        View inflate = View.inflate(context, i, this);
        View findViewById = inflate.findViewById(R.id.customer_tv_cart_out_of_stock_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…v_cart_out_of_stock_name)");
        this.f42315b = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_tv_out_of_stock_type);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_out_of_stock_type)");
        this.f42316c = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_tv_out_of_stock_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_out_of_stock_icon)");
        this.f42317d = findViewById3;
    }

    public void setData(ComponentModel componentModel) {
        OutOfStockModel outOfStockModel;
        AbnormalItemDetailEntity currItem;
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        TextView textView = this.f42315b;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        textView.setText(componentModel.getName());
        ComponentDataModel data = componentModel.getData();
        if (!(data == null || (outOfStockModel = data.getOutOfStockModel()) == null || (currItem = outOfStockModel.getCurrItem()) == null)) {
            TextView textView2 = this.f42316c;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("content");
                textView2 = null;
            }
            textView2.setText(currItem.getName());
        }
        if (componentModel.isCanRedirect() == 1) {
            setOnClickListener(new View.OnClickListener(componentModel) {
                public final /* synthetic */ ComponentModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    BillOutOfStockItemView.m29816a(BillOutOfStockItemView.this, this.f$1, view);
                }
            });
            View view2 = this.f42317d;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("icon");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        View view3 = this.f42317d;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29816a(BillOutOfStockItemView billOutOfStockItemView, ComponentModel componentModel, View view) {
        Intrinsics.checkNotNullParameter(billOutOfStockItemView, "this$0");
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        ItemViewCommonLogic itemViewCommonLogic = (ItemViewCommonLogic) billOutOfStockItemView.getLogic();
        if (itemViewCommonLogic != null) {
            ItemViewCommonLogic.onItemClick$default(itemViewCommonLogic, componentModel, (Integer) null, (Bundle) null, (Function1) null, 14, (Object) null);
        }
    }
}
