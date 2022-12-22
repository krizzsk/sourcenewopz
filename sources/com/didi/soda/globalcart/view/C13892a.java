package com.didi.soda.globalcart.view;

import android.view.View;
import android.widget.TextView;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.globalcart.view.Style;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/globalcart/view/NewStyle;", "Lcom/didi/soda/globalcart/view/Style;", "()V", "backTextView", "Landroid/widget/TextView;", "dishCollapseCount", "", "getDishCollapseCount", "()I", "getResId", "initView", "", "rootView", "Lcom/didi/soda/globalcart/view/BillItemsInfoItemView;", "setData", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.globalcart.view.a */
/* compiled from: BillItemsInfoItemView.kt */
final class C13892a implements Style {

    /* renamed from: a */
    private final int f42350a = 3;

    /* renamed from: b */
    private TextView f42351b;

    /* renamed from: b */
    public int mo106450b() {
        return R.layout.customer_widget_cart_items_container_view2;
    }

    /* renamed from: a */
    public int mo106447a() {
        return this.f42350a;
    }

    /* renamed from: a */
    public void mo106449a(BillItemsInfoItemView billItemsInfoItemView) {
        Intrinsics.checkNotNullParameter(billItemsInfoItemView, "rootView");
        Style.DefaultImpls.initView(this, billItemsInfoItemView);
        this.f42351b = (TextView) billItemsInfoItemView.findViewById(R.id.customer_iv_cart_business_back);
        ((GlobalCartExpandView) billItemsInfoItemView.findViewById(R.id.customer_custom_cart_expand_view)).setTextColor(CustomerExtentionKt.getColor(R.color.rf_color_v2_grey1_4_a40));
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo106448a(com.didi.soda.bill.model.ComponentModel r5, com.didi.app.nova.skeleton.ScopeContext r6) {
        /*
            r4 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = r4
            com.didi.soda.globalcart.view.Style r0 = (com.didi.soda.globalcart.view.Style) r0
            com.didi.soda.globalcart.view.Style.DefaultImpls.setData(r0, r5, r6)
            com.didi.soda.bill.model.ComponentDataModel r5 = r5.getData()
            if (r5 != 0) goto L_0x0013
            r5 = 0
            goto L_0x0017
        L_0x0013:
            com.didi.soda.bill.model.datamodel.BillItemsInfoModel r5 = r5.getItemsInfoModel()
        L_0x0017:
            if (r5 == 0) goto L_0x0053
            java.lang.String r0 = r5.getShopReturnDesc()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x002c
            int r3 = r0.length()
            if (r3 != 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r3 = 0
            goto L_0x002d
        L_0x002c:
            r3 = 1
        L_0x002d:
            if (r3 != 0) goto L_0x0039
            java.lang.String r3 = "null"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r2 = 0
        L_0x003a:
            if (r2 == 0) goto L_0x0053
            android.widget.TextView r0 = r4.f42351b
            if (r0 != 0) goto L_0x0041
            goto L_0x0044
        L_0x0041:
            r0.setVisibility(r1)
        L_0x0044:
            android.widget.TextView r0 = r4.f42351b
            if (r0 != 0) goto L_0x0049
            goto L_0x005d
        L_0x0049:
            java.lang.String r5 = r5.getShopReturnDesc()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            goto L_0x005d
        L_0x0053:
            android.widget.TextView r5 = r4.f42351b
            if (r5 != 0) goto L_0x0058
            goto L_0x005d
        L_0x0058:
            r0 = 8
            r5.setVisibility(r0)
        L_0x005d:
            android.widget.TextView r5 = r4.f42351b
            if (r5 != 0) goto L_0x0062
            goto L_0x006a
        L_0x0062:
            com.didi.soda.globalcart.view.-$$Lambda$a$9lmlYtGIa50OfVZqrSa1A-j5syk r0 = new com.didi.soda.globalcart.view.-$$Lambda$a$9lmlYtGIa50OfVZqrSa1A-j5syk
            r0.<init>()
            r5.setOnClickListener(r0)
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.globalcart.view.C13892a.mo106448a(com.didi.soda.bill.model.ComponentModel, com.didi.app.nova.skeleton.ScopeContext):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29829a(ScopeContext scopeContext, View view) {
        INavigator navigator;
        if (scopeContext != null && (navigator = scopeContext.getNavigator()) != null) {
            navigator.finish();
        }
    }
}
