package com.didi.soda.bill.component.outofstock;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/bill/component/outofstock/OutOfStockDescBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "", "Lcom/didi/soda/bill/component/outofstock/OutOfStockDescBinder$ViewHolder;", "()V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OutOfStockDescBinder.kt */
public final class OutOfStockDescBinder extends ItemBinder<String, ViewHolder> {
    public Class<String> bindDataType() {
        return String.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.customer_item_bill_out_of_stock_desc, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…tock_desc, parent, false)");
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, String str) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(str, "item");
        viewHolder.getMDescTv().setText(str);
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/bill/component/outofstock/OutOfStockDescBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "mDescTv", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "getMDescTv", "()Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "setMDescTv", "(Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OutOfStockDescBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<String> {
        private CustomerAppCompatTextView mDescTv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Object findViewById = findViewById(R.id.customer_tv_out_of_stock_desc);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_out_of_stock_desc)");
            this.mDescTv = (CustomerAppCompatTextView) findViewById;
        }

        public final CustomerAppCompatTextView getMDescTv() {
            return this.mDescTv;
        }

        public final void setMDescTv(CustomerAppCompatTextView customerAppCompatTextView) {
            Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<set-?>");
            this.mDescTv = customerAppCompatTextView;
        }
    }
}
