package com.didi.soda.bill.component.bill;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032.\u0010\u0006\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b`\u000bH\n"}, mo175978d2 = {"<anonymous>", "", "platformCouponAmount", "", "shopCouponAmount", "rCouponAmount", "priceList", "Ljava/util/ArrayList;", "", "", "", "Lkotlin/collections/ArrayList;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.bill.component.bill.CustomerBillPresenterV2$BillRpcCallback$onRpcSuccess$copyFunction$1 */
/* compiled from: CustomerBillPresenterV2.kt */
final class C13398x78a4b6db extends Lambda implements Function4<Integer, Integer, Integer, ArrayList<Map<String, ? extends Object>>, Unit> {
    final /* synthetic */ CustomerBillPresenterV2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C13398x78a4b6db(CustomerBillPresenterV2 customerBillPresenterV2) {
        super(4);
        this.this$0 = customerBillPresenterV2;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), (ArrayList<Map<String, Object>>) (ArrayList) obj4);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2, int i3, ArrayList<Map<String, Object>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "priceList");
        this.this$0.f38880u = i;
        this.this$0.f38881v = i2;
        this.this$0.f38882w = i3;
        this.this$0.f38883x = arrayList;
    }
}
