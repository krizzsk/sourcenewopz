package com.didi.soda.bill.view.item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewTotalPriceLogic;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillTotalItemViewV2;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewTotalPriceLogic;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "totalName", "Landroid/widget/TextView;", "totalPrice", "totalPriceHint", "Lcom/didi/soda/customer/widget/text/RichTextView;", "initView", "", "setData", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "showOrHide", "isShow", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillTotalItemViewV2.kt */
public final class BillTotalItemViewV2 extends BillItemView<ItemViewTotalPriceLogic> {

    /* renamed from: a */
    private TextView f39244a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f39245b;

    /* renamed from: c */
    private RichTextView f39246c;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillTotalItemViewV2(Context context) {
        super(context, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView() {
        View.inflate(getContext(), R.layout.customer_item_bill_total_v2, this);
        View findViewById = findViewById(R.id.customer_tv_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_name)");
        this.f39244a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_tv_price);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_price)");
        this.f39245b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_price_hint);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_price_hint)");
        this.f39246c = (RichTextView) findViewById3;
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [kotlin.Unit] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setData(com.didi.soda.bill.model.ComponentModel r6) {
        /*
            r5 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.widget.TextView r0 = r5.f39244a
            r1 = 0
            if (r0 != 0) goto L_0x0011
            java.lang.String r0 = "totalName"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r1
        L_0x0011:
            java.lang.String r2 = r6.getName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            com.didi.soda.customer.widget.text.RichTextView r0 = r5.f39246c
            java.lang.String r2 = "totalPriceHint"
            if (r0 != 0) goto L_0x0025
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L_0x0025:
            java.lang.String r3 = r6.getHint()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            com.didi.soda.customer.widget.text.RichTextView r0 = r5.f39246c
            if (r0 != 0) goto L_0x0036
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L_0x0036:
            java.lang.String r2 = r6.getHint()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0049
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r2 = 0
            goto L_0x004a
        L_0x0049:
            r2 = 1
        L_0x004a:
            if (r2 == 0) goto L_0x004f
            r2 = 8
            goto L_0x0050
        L_0x004f:
            r2 = 0
        L_0x0050:
            r0.setVisibility(r2)
            com.didi.soda.bill.model.ComponentDataModel r6 = r6.getData()
            if (r6 != 0) goto L_0x005b
            r6 = r1
            goto L_0x005f
        L_0x005b:
            com.didi.soda.bill.model.datamodel.PriceInfoModel r6 = r6.getPriceInfoModel()
        L_0x005f:
            if (r6 != 0) goto L_0x0062
            goto L_0x009a
        L_0x0062:
            r5.m27792a(r3)
            com.didi.soda.bill.view.item.logic.ItemViewAbsLogic r0 = r5.getLogic()
            com.didi.soda.bill.view.item.logic.ItemViewTotalPriceLogic r0 = (com.didi.soda.bill.view.item.logic.ItemViewTotalPriceLogic) r0
            if (r0 == 0) goto L_0x0083
            java.lang.String r1 = r6.getPayPriceDisplay()
            r0.setTotalDisplay(r1)
            java.lang.String r6 = r6.getPayPriceDisplay()
            com.didi.soda.bill.view.item.BillTotalItemViewV2$setData$1$1 r1 = new com.didi.soda.bill.view.item.BillTotalItemViewV2$setData$1$1
            r1.<init>(r5)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r0.startTotalPriceAnim(r6, r1)
            goto L_0x0098
        L_0x0083:
            android.widget.TextView r0 = r5.f39245b
            if (r0 != 0) goto L_0x008e
            java.lang.String r0 = "totalPrice"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x008f
        L_0x008e:
            r1 = r0
        L_0x008f:
            java.lang.String r6 = r6.getPayPriceDisplay()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1.setText(r6)
        L_0x0098:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x009a:
            if (r1 != 0) goto L_0x009f
            r5.m27792a(r4)
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.BillTotalItemViewV2.setData(com.didi.soda.bill.model.ComponentModel):void");
    }

    /* renamed from: a */
    private final void m27792a(boolean z) {
        setVisibility(z ? 0 : 8);
    }
}
