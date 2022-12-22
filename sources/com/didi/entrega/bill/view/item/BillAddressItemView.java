package com.didi.entrega.bill.view.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.entrega.bill.model.AddressModel;
import com.didi.entrega.bill.model.ComponentDataModel;
import com.didi.entrega.bill.model.ComponentModel;
import com.didi.entrega.bill.view.BillItemView;
import com.didi.entrega.bill.view.widgets.BillAddressView;
import com.didi.entrega.customer.widget.text.RichTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\n¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/entrega/bill/view/item/BillAddressItemView;", "Lcom/didi/entrega/bill/view/BillItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getReceiverModer", "Lcom/didi/entrega/bill/model/AddressModel;", "getSenderModer", "initView", "", "setData", "componentModel", "Lcom/didi/entrega/bill/model/ComponentModel;", "updateAddress", "senderModel", "receiverModel", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillAddressItemView.kt */
public final class BillAddressItemView extends BillItemView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillAddressItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillAddressItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillAddressItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillAddressItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView() {
        View.inflate(getContext(), R.layout.entrega_bill_address_item, this);
    }

    public void setData(ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        ComponentDataModel data = componentModel.getData();
        if (data != null) {
            ((BillAddressView) findViewById(R.id.entrega_bill_sender_address_layout)).setData(data.getSenderModel());
            ((BillAddressView) findViewById(R.id.entrega_bill_receiver_address_layout)).setData(data.getReceiverModel());
            ((ImageView) findViewById(R.id.entrega_bill_switch_addr)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BillAddressItemView.m14619a(ComponentModel.this, view);
                }
            });
            if (data.getTopTips().length() == 0) {
                ((LinearLayout) findViewById(R.id.entrega_bill_address_tip_layout)).setVisibility(8);
                return;
            }
            ((LinearLayout) findViewById(R.id.entrega_bill_address_tip_layout)).setVisibility(0);
            ((RichTextView) findViewById(R.id.entrega_bill_address_tip_view)).setText(data.getTopTips());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14619a(ComponentModel componentModel, View view) {
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        Function1<View, Unit> onCardClick = componentModel.getOnCardClick();
        if (onCardClick != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            onCardClick.invoke(view);
        }
    }

    public final void updateAddress(AddressModel addressModel, AddressModel addressModel2) {
        ((BillAddressView) findViewById(R.id.entrega_bill_sender_address_layout)).setData(addressModel);
        ((BillAddressView) findViewById(R.id.entrega_bill_receiver_address_layout)).setData(addressModel2);
    }

    public final AddressModel getSenderModer() {
        return ((BillAddressView) findViewById(R.id.entrega_bill_sender_address_layout)).getData();
    }

    public final AddressModel getReceiverModer() {
        return ((BillAddressView) findViewById(R.id.entrega_bill_receiver_address_layout)).getData();
    }
}
