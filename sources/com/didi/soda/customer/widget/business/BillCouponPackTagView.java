package com.didi.soda.customer.widget.business;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/business/BillCouponPackTagView;", "Lcom/didi/soda/customer/widget/business/BaseTagView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setData", "", "text", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseTagView.kt */
public final class BillCouponPackTagView extends BaseTagView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillCouponPackTagView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillCouponPackTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillCouponPackTagView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillCouponPackTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setMaxLines(1);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.BOLD);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0012, code lost:
        if ((r4.length() == 0) == true) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setData(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            if (r4 != 0) goto L_0x0006
        L_0x0004:
            r0 = 0
            goto L_0x0014
        L_0x0006:
            r2 = r4
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0011
            r2 = 1
            goto L_0x0012
        L_0x0011:
            r2 = 0
        L_0x0012:
            if (r2 != r0) goto L_0x0004
        L_0x0014:
            if (r0 == 0) goto L_0x001c
            r4 = 8
            r3.setVisibility(r4)
            goto L_0x002a
        L_0x001c:
            r3.setVisibility(r1)
            r0 = 2131232309(0x7f080635, float:1.8080724E38)
            r3.setBackgroundResource(r0)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.widget.business.BillCouponPackTagView.setData(java.lang.String):void");
    }
}
