package com.didi.soda.bill.view.item;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillTablewareItemView;", "Lcom/didi/soda/bill/view/item/BillSimpleItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "enableClick", "", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "initView", "", "setData", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillTablewareItemView.kt */
public final class BillTablewareItemView extends BillSimpleItemView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillTablewareItemView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public boolean enableClick(ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillTablewareItemView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillTablewareItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView() {
        super.initView();
        updateIcon(CustomerExtentionKt.getString(R.string.rf_icon_v3_outlined_checkbox));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        r3 = r3.getCutleryModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setData(com.didi.soda.bill.model.ComponentModel r3) {
        /*
            r2 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            super.setData(r3)
            com.didi.soda.bill.model.ComponentDataModel r3 = r3.getData()
            r0 = 1
            r1 = 0
            if (r3 != 0) goto L_0x0012
        L_0x0010:
            r3 = 0
            goto L_0x0020
        L_0x0012:
            com.didi.soda.bill.model.datamodel.CutleryModel r3 = r3.getCutleryModel()
            if (r3 != 0) goto L_0x0019
            goto L_0x0010
        L_0x0019:
            boolean r3 = r3.isNeeded()
            if (r3 != r0) goto L_0x0010
            r3 = 1
        L_0x0020:
            if (r3 == 0) goto L_0x0030
            r2.activeSelf(r0)
            r3 = 2131957544(0x7f131728, float:1.9551675E38)
            java.lang.String r3 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.getString(r3)
            r2.updateIcon(r3)
            goto L_0x003d
        L_0x0030:
            r2.activeSelf(r1)
            r3 = 2131957584(0x7f131750, float:1.9551756E38)
            java.lang.String r3 = com.didi.soda.customer.foundation.util.CustomerExtentionKt.getString(r3)
            r2.updateIcon(r3)
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.BillTablewareItemView.setData(com.didi.soda.bill.model.ComponentModel):void");
    }
}
