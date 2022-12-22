package com.didi.soda.bill.component.outofstock;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.rfusion.widget.selector.RFRadio;
import com.didi.rfusion.widget.selector.RFSelectorButton;
import com.didi.soda.customer.foundation.rpc.entity.cart.AbnormalItemDetailEntity;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H&¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/bill/component/outofstock/OutOfStockSelectionBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/AbnormalItemDetailEntity;", "Lcom/didi/soda/bill/component/outofstock/OutOfStockSelectionBinder$ViewHolder;", "()V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "onItemClick", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OutOfStockSelectionBinder.kt */
public abstract class OutOfStockSelectionBinder extends ItemBinder<AbnormalItemDetailEntity, ViewHolder> {
    public Class<AbnormalItemDetailEntity> bindDataType() {
        return AbnormalItemDetailEntity.class;
    }

    public abstract void onItemClick(AbnormalItemDetailEntity abnormalItemDetailEntity);

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_item_bill_out_of_stock_selection, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, AbnormalItemDetailEntity abnormalItemDetailEntity) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(abnormalItemDetailEntity, "item");
        viewHolder.getMRadioBtn().setTitle(abnormalItemDetailEntity.getName());
        viewHolder.getMRadioBtn().setTips(abnormalItemDetailEntity.getDesc());
        viewHolder.getMRadioBtn().setOnCheckedChangeListener((RFSelectorButton.OnCheckedChangeListener) null);
        RFRadio mRadioBtn = viewHolder.getMRadioBtn();
        boolean z = true;
        if (abnormalItemDetailEntity.isSelected() != 1) {
            z = false;
        }
        mRadioBtn.setChecked(z);
        viewHolder.getMRadioBtn().setOnCheckedChangeListener(new RFSelectorButton.OnCheckedChangeListener(abnormalItemDetailEntity) {
            public final /* synthetic */ AbnormalItemDetailEntity f$1;

            {
                this.f$1 = r2;
            }

            public final void onCheckedChanged(RFSelectorButton rFSelectorButton, boolean z) {
                OutOfStockSelectionBinder.m46773bind$lambda1$lambda0(OutOfStockSelectionBinder.this, this.f$1, rFSelectorButton, z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1$lambda-0  reason: not valid java name */
    public static final void m46773bind$lambda1$lambda0(OutOfStockSelectionBinder outOfStockSelectionBinder, AbnormalItemDetailEntity abnormalItemDetailEntity, RFSelectorButton rFSelectorButton, boolean z) {
        Intrinsics.checkNotNullParameter(outOfStockSelectionBinder, "this$0");
        Intrinsics.checkNotNullParameter(abnormalItemDetailEntity, "$item");
        outOfStockSelectionBinder.onItemClick(abnormalItemDetailEntity);
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/bill/component/outofstock/OutOfStockSelectionBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/AbnormalItemDetailEntity;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "mRadioBtn", "Lcom/didi/rfusion/widget/selector/RFRadio;", "getMRadioBtn", "()Lcom/didi/rfusion/widget/selector/RFRadio;", "setMRadioBtn", "(Lcom/didi/rfusion/widget/selector/RFRadio;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OutOfStockSelectionBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<AbnormalItemDetailEntity> {
        private RFRadio mRadioBtn;

        public ViewHolder(View view) {
            super(view);
            Object findViewById = findViewById(R.id.customer_radio_item);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_radio_item)");
            this.mRadioBtn = (RFRadio) findViewById;
        }

        public final RFRadio getMRadioBtn() {
            return this.mRadioBtn;
        }

        public final void setMRadioBtn(RFRadio rFRadio) {
            Intrinsics.checkNotNullParameter(rFRadio, "<set-?>");
            this.mRadioBtn = rFRadio;
        }
    }
}
