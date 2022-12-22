package com.didi.entrega.bill.view.pay;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.entrega.bill.model.PriceModel;
import com.didi.entrega.customer.widget.text.RichTextView;
import com.didi.rfusion.widget.button.RFMainButton;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/entrega/bill/view/pay/BillPayCardLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setDataModel", "", "priceModel", "Lcom/didi/entrega/bill/model/PriceModel;", "updatePriceText", "payBtnText", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillPayCardLayout.kt */
public final class BillPayCardLayout extends FrameLayout {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillPayCardLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillPayCardLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillPayCardLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillPayCardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.inflate(context, R.layout.entrega_bill_item_pay_layout, this);
    }

    public final void setDataModel(PriceModel priceModel) {
        Intrinsics.checkNotNullParameter(priceModel, "priceModel");
        ((RFMainButton) findViewById(R.id.entrega_bill_pay_btn)).setOnClickListener(new View.OnClickListener(this) {
            public final /* synthetic */ BillPayCardLayout f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BillPayCardLayout.m14628a(PriceModel.this, this.f$1, view);
            }
        });
        ((RFMainButton) findViewById(R.id.entrega_bill_pay_btn)).setText(priceModel.getPayBtnText());
        ((RFMainButton) findViewById(R.id.entrega_bill_pay_btn)).setLoading(priceModel.isShowLoading());
        priceModel.getRealPayPriceText();
        CharSequence priceSumOriText = priceModel.getPriceSumOri() <= priceModel.getRealPayPrice() ? null : priceModel.getPriceSumOriText();
        if (!(priceSumOriText == null || priceSumOriText.length() == 0)) {
            ((RichTextView) findViewById(R.id.entrega_bill_pay_ori_price)).setText(priceSumOriText);
            ((RichTextView) findViewById(R.id.entrega_bill_pay_ori_price)).setVisibility(0);
            ((RichTextView) findViewById(R.id.entrega_bill_pay_ori_price)).setPaintFlags(((RichTextView) findViewById(R.id.entrega_bill_pay_ori_price)).getPaintFlags() | 16);
            return;
        }
        ((RichTextView) findViewById(R.id.entrega_bill_pay_ori_price)).setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14628a(PriceModel priceModel, BillPayCardLayout billPayCardLayout, View view) {
        Intrinsics.checkNotNullParameter(priceModel, "$priceModel");
        Intrinsics.checkNotNullParameter(billPayCardLayout, "this$0");
        priceModel.getOnPayClick().invoke(billPayCardLayout);
    }

    public final void updatePriceText(String str) {
        Intrinsics.checkNotNullParameter(str, "payBtnText");
        ((RFMainButton) findViewById(R.id.entrega_bill_pay_btn)).setText(str);
    }
}
