package com.didi.entrega.bill.model;

import android.view.View;
import com.didi.entrega.router.DiRouter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PriceInfoModel.kt */
final class PriceInfoModel$Companion$convertModel$1$1$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ PriceInfoModel $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PriceInfoModel$Companion$convertModel$1$1$1(PriceInfoModel priceInfoModel) {
        super(1);
        this.$this_apply = priceInfoModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        DiRouter.request().path("priceRuleDescPage").putSerializable("entity", this.$this_apply.getRuleDesc()).open();
    }
}
