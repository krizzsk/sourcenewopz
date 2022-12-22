package com.didi.soda.bill.view.item;

import android.os.Bundle;
import android.view.View;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, mo175978d2 = {"<anonymous>", "", "type", "", "bundle", "Landroid/os/Bundle;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillAddressItemViewV2.kt */
final class BillAddressItemViewV2$setData$1$1 extends Lambda implements Function2<Integer, Bundle, Unit> {
    final /* synthetic */ ComponentModel $componentModel;
    final /* synthetic */ BillAddressItemViewV2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillAddressItemViewV2$setData$1$1(BillAddressItemViewV2 billAddressItemViewV2, ComponentModel componentModel) {
        super(2);
        this.this$0 = billAddressItemViewV2;
        this.$componentModel = componentModel;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (Bundle) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, Bundle bundle) {
        if (i == 0) {
            View access$getNoApartmentFloorLayout$p = this.this$0.f39191i;
            if (access$getNoApartmentFloorLayout$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noApartmentFloorLayout");
                access$getNoApartmentFloorLayout$p = null;
            }
            access$getNoApartmentFloorLayout$p.setVisibility(8);
        }
        ItemViewCommonLogic itemViewCommonLogic = (ItemViewCommonLogic) this.this$0.getLogic();
        if (itemViewCommonLogic != null) {
            ItemViewCommonLogic.onItemClick$default(itemViewCommonLogic, this.$componentModel, Integer.valueOf(i), bundle, (Function1) null, 8, (Object) null);
        }
    }
}
