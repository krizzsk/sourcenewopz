package com.didi.soda.globalcart.view;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.bill.model.ComponentModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/globalcart/view/Style;", "", "dishCollapseCount", "", "getDishCollapseCount", "()I", "getResId", "initView", "", "rootView", "Lcom/didi/soda/globalcart/view/BillItemsInfoItemView;", "setData", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillItemsInfoItemView.kt */
interface Style {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillItemsInfoItemView.kt */
    public static final class DefaultImpls {
        public static void initView(Style style, BillItemsInfoItemView billItemsInfoItemView) {
            Intrinsics.checkNotNullParameter(style, "this");
            Intrinsics.checkNotNullParameter(billItemsInfoItemView, "rootView");
        }

        public static void setData(Style style, ComponentModel componentModel, ScopeContext scopeContext) {
            Intrinsics.checkNotNullParameter(style, "this");
            Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        }
    }

    /* renamed from: a */
    int mo106447a();

    /* renamed from: a */
    void mo106448a(ComponentModel componentModel, ScopeContext scopeContext);

    /* renamed from: a */
    void mo106449a(BillItemsInfoItemView billItemsInfoItemView);

    /* renamed from: b */
    int mo106450b();
}
