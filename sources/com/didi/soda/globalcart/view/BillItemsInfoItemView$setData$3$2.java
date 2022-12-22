package com.didi.soda.globalcart.view;

import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.BillCartItemModel;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.router.DiRouter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillItemsInfoItemView.kt */
final class BillItemsInfoItemView$setData$3$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $cartId;
    final /* synthetic */ ComponentModel $componentModel;
    final /* synthetic */ BillCartItemModel $item;
    final /* synthetic */ String $shopId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillItemsInfoItemView$setData$3$2(ComponentModel componentModel, String str, String str2, BillCartItemModel billCartItemModel) {
        super(0);
        this.$componentModel = componentModel;
        this.$cartId = str;
        this.$shopId = str2;
        this.$item = billCartItemModel;
    }

    public final void invoke() {
        int i = 2;
        if (this.$componentModel.getSourcePage() == 1) {
            i = 1;
        } else if (this.$componentModel.getSourcePage() != 2) {
            i = 0;
        }
        BillOmegaHelper.Companion.traceMutualExclusionRuleCK(this.$cartId, this.$shopId, i, this.$item.getItemId());
        DiRouter.request().path(RoutePath.MUTUAL_EXCLUSION_RULE_PAGE).putSerializable("entity", this.$item.getActRules()).open();
    }
}
