package com.didi.entrega.bill.datastore.p110op;

import com.didi.entrega.bill.model.PriceModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/entrega/bill/model/PriceModel;", "it"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.entrega.bill.datastore.op.BillPriceOperation$operate$1$2$1$updateLoading$1 */
/* compiled from: BillPriceOperation.kt */
final class BillPriceOperation$operate$1$2$1$updateLoading$1 extends Lambda implements Function1<PriceModel, PriceModel> {
    final /* synthetic */ boolean $isShowLoading;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillPriceOperation$operate$1$2$1$updateLoading$1(boolean z) {
        super(1);
        this.$isShowLoading = z;
    }

    public final PriceModel invoke(PriceModel priceModel) {
        if (priceModel != null) {
            priceModel.setShowLoading(this.$isShowLoading);
        }
        return priceModel;
    }
}
