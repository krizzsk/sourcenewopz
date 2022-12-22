package com.didi.soda.bill.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.bill.model.DisclaimerModel;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/bill/binder/CustomerDisclaimerBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/bill/model/DisclaimerModel;", "Lcom/didi/soda/bill/binder/CustomerDisclaimerBinder$ViewHolder;", "resId", "", "(I)V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerDisclaimerBinder.kt */
public final class CustomerDisclaimerBinder extends ItemBinder<DisclaimerModel, ViewHolder> {

    /* renamed from: a */
    private final int f38818a;

    public Class<DisclaimerModel> bindDataType() {
        return DisclaimerModel.class;
    }

    public CustomerDisclaimerBinder(int i) {
        this.f38818a = i;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(this.f38818a, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(resId, parent, false)");
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, DisclaimerModel disclaimerModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(disclaimerModel, "item");
        viewHolder.bindData(disclaimerModel);
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/bill/binder/CustomerDisclaimerBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/bill/model/DisclaimerModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "descTv", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "bindData", "", "item", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerDisclaimerBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<DisclaimerModel> {
        private final CustomerAppCompatTextView descTv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Object findViewById = findViewById(R.id.customer_tv_disclaimer);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_disclaimer)");
            this.descTv = (CustomerAppCompatTextView) findViewById;
        }

        public final void bindData(DisclaimerModel disclaimerModel) {
            Intrinsics.checkNotNullParameter(disclaimerModel, "item");
            this.descTv.setText(disclaimerModel.getOrderDisclaimer());
        }
    }
}
