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

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/bill/binder/CustomerDisclaimerBinderV2;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/bill/model/DisclaimerModel;", "Lcom/didi/soda/bill/binder/CustomerDisclaimerBinderV2$ViewHolder;", "()V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerDisclaimerBinderV2.kt */
public final class CustomerDisclaimerBinderV2 extends ItemBinder<DisclaimerModel, ViewHolder> {
    public Class<DisclaimerModel> bindDataType() {
        return DisclaimerModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.customer_binder_disclaimer_container_v2, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…tainer_v2, parent, false)");
        return new ViewHolder(inflate);
    }

    public void bind(ViewHolder viewHolder, DisclaimerModel disclaimerModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(disclaimerModel, "item");
        viewHolder.bindData(disclaimerModel);
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/bill/binder/CustomerDisclaimerBinderV2$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/bill/model/DisclaimerModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "descTv", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "bindData", "", "item", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerDisclaimerBinderV2.kt */
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
            CharSequence orderDisclaimer = disclaimerModel.getOrderDisclaimer();
            if (orderDisclaimer == null || orderDisclaimer.length() == 0) {
                this.descTv.setVisibility(8);
            } else {
                this.descTv.setVisibility(0);
            }
        }
    }
}
