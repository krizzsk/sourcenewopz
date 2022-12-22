package com.didi.entrega.bill.view.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.didi.entrega.bill.model.ComponentModel;
import com.didi.entrega.bill.view.BillItemView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/entrega/bill/view/item/BillPackageItemView;", "Lcom/didi/entrega/bill/view/BillItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initView", "", "setData", "componentModel", "Lcom/didi/entrega/bill/model/ComponentModel;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillPackageItemView.kt */
public final class BillPackageItemView extends BillItemView {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillPackageItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillPackageItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillPackageItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillPackageItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView() {
        View.inflate(getContext(), R.layout.entrega_bill_pkginfo_layout, this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0114  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setData(com.didi.entrega.bill.model.ComponentModel r8) {
        /*
            r7 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.Class<com.didi.entrega.customer.service.IToolsService> r0 = com.didi.entrega.customer.service.IToolsService.class
            com.didi.entrega.customer.service.IService r0 = com.didi.entrega.customer.service.CustomerServiceManager.getService(r0)
            com.didi.entrega.customer.service.IToolsService r0 = (com.didi.entrega.customer.service.IToolsService) r0
            r1 = 2131430400(0x7f0b0c00, float:1.84825E38)
            android.view.View r1 = r7.findViewById(r1)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r1 = (com.didi.entrega.customer.widget.support.CustomerAppCompatTextView) r1
            android.widget.TextView r1 = (android.widget.TextView) r1
            com.didi.entrega.customer.service.IToolsService$FontType r2 = com.didi.entrega.customer.service.IToolsService.FontType.MEDIUM
            r0.setTypeface(r1, r2)
            com.didi.entrega.bill.model.ComponentDataModel r0 = r8.getData()
            if (r0 != 0) goto L_0x0025
            goto L_0x0143
        L_0x0025:
            com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity r0 = r0.getPkgInfo()
            if (r0 != 0) goto L_0x002d
            goto L_0x0143
        L_0x002d:
            r1 = 2131430399(0x7f0b0bff, float:1.8482498E38)
            android.view.View r1 = r7.findViewById(r1)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r1 = (com.didi.entrega.customer.widget.support.CustomerAppCompatTextView) r1
            java.lang.String r2 = r0.cateName
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0047
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r2 = 0
            goto L_0x0048
        L_0x0047:
            r2 = 1
        L_0x0048:
            r5 = 8
            if (r2 == 0) goto L_0x004f
            r2 = 8
            goto L_0x0057
        L_0x004f:
            java.lang.String r2 = r0.cateName
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            r2 = 0
        L_0x0057:
            r1.setVisibility(r2)
            r1 = 2131430398(0x7f0b0bfe, float:1.8482496E38)
            android.view.View r1 = r7.findViewById(r1)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r1 = (com.didi.entrega.customer.widget.support.CustomerAppCompatTextView) r1
            java.lang.String r2 = r0.remark
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0072
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r2 = 0
            goto L_0x0073
        L_0x0072:
            r2 = 1
        L_0x0073:
            if (r2 == 0) goto L_0x0078
            r2 = 8
            goto L_0x0080
        L_0x0078:
            java.lang.String r2 = r0.remark
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            r2 = 0
        L_0x0080:
            r1.setVisibility(r2)
            r1 = 2131430397(0x7f0b0bfd, float:1.8482494E38)
            android.view.View r1 = r7.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            java.lang.String r2 = r0.cateImg
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x009b
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0099
            goto L_0x009b
        L_0x0099:
            r2 = 0
            goto L_0x009c
        L_0x009b:
            r2 = 1
        L_0x009c:
            if (r2 == 0) goto L_0x00a1
            r2 = 8
            goto L_0x00c4
        L_0x00a1:
            r2 = 2131101452(0x7f06070c, float:1.7815314E38)
            int r2 = com.didi.entrega.customer.foundation.util.ResourceHelper.getColor(r2)
            r1.setColorFilter(r2)
            android.content.Context r2 = r1.getContext()
            java.lang.String r6 = r0.cateImg
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r2 = com.didi.entrega.customer.foundation.util.FlyImageLoader.loadImage1x1((android.content.Context) r2, (java.lang.String) r6)
            r6 = 2131232665(0x7f080799, float:1.8081446E38)
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r2 = r2.placeholder((int) r6)
            com.didi.entrega.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r2 = r2.error((int) r6)
            r2.into((android.widget.ImageView) r1)
            r2 = 0
        L_0x00c4:
            r1.setVisibility(r2)
            r1 = 2131430395(0x7f0b0bfb, float:1.848249E38)
            android.view.View r1 = r7.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            java.lang.String r2 = r0.cateName
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x00df
            int r2 = r2.length()
            if (r2 != 0) goto L_0x00dd
            goto L_0x00df
        L_0x00dd:
            r2 = 0
            goto L_0x00e0
        L_0x00df:
            r2 = 1
        L_0x00e0:
            if (r2 == 0) goto L_0x00f7
            java.lang.String r2 = r0.remark
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x00f1
            int r2 = r2.length()
            if (r2 != 0) goto L_0x00ef
            goto L_0x00f1
        L_0x00ef:
            r2 = 0
            goto L_0x00f2
        L_0x00f1:
            r2 = 1
        L_0x00f2:
            if (r2 == 0) goto L_0x00f7
            r2 = 8
            goto L_0x00f8
        L_0x00f7:
            r2 = 0
        L_0x00f8:
            r1.setVisibility(r2)
            r1 = 2131430519(0x7f0b0c77, float:1.8482741E38)
            android.view.View r1 = r7.findViewById(r1)
            java.lang.String r2 = r0.cateName
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0111
            int r2 = r2.length()
            if (r2 != 0) goto L_0x010f
            goto L_0x0111
        L_0x010f:
            r2 = 0
            goto L_0x0112
        L_0x0111:
            r2 = 1
        L_0x0112:
            if (r2 == 0) goto L_0x0138
            java.lang.String r2 = r0.remark
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0123
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0121
            goto L_0x0123
        L_0x0121:
            r2 = 0
            goto L_0x0124
        L_0x0123:
            r2 = 1
        L_0x0124:
            if (r2 == 0) goto L_0x0138
            java.lang.String r0 = r0.cateImg
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0134
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0133
            goto L_0x0134
        L_0x0133:
            r3 = 0
        L_0x0134:
            if (r3 == 0) goto L_0x0138
            r4 = 8
        L_0x0138:
            r1.setVisibility(r4)
            com.didi.entrega.bill.view.item.-$$Lambda$BillPackageItemView$HcNcoaEPOywD446mIqFLBcvjnXI r0 = new com.didi.entrega.bill.view.item.-$$Lambda$BillPackageItemView$HcNcoaEPOywD446mIqFLBcvjnXI
            r0.<init>(r7)
            r7.setOnClickListener(r0)
        L_0x0143:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.bill.view.item.BillPackageItemView.setData(com.didi.entrega.bill.model.ComponentModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14622a(ComponentModel componentModel, BillPackageItemView billPackageItemView, View view) {
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        Intrinsics.checkNotNullParameter(billPackageItemView, "this$0");
        Function1<View, Unit> onCardClick = componentModel.getOnCardClick();
        if (onCardClick != null) {
            onCardClick.invoke(billPackageItemView);
        }
    }
}
