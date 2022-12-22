package com.didi.entrega.bill.component.bill;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"defaultMaxOffset", "", "setUpNavBar", "", "Lcom/didi/entrega/bill/component/bill/BillView;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillViewEx.kt */
public final class BillViewExKt {

    /* renamed from: a */
    private static final float f19473a = 230.0f;

    public static final void setUpNavBar(BillView billView) {
        Intrinsics.checkNotNullParameter(billView, "<this>");
        billView.getNovaRecyclerView().addOnScrollListener(new BillViewExKt$setUpNavBar$onScrollListenerForNavBar$1(billView));
    }
}
