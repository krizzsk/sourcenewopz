package com.didi.soda.bill.view.item;

import android.os.Bundle;
import android.view.View;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.bill.widgets.CustomerBillAddressBlackTipsLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, mo175978d2 = {"<anonymous>", "", "type", "", "bundle", "Landroid/os/Bundle;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillAddressItemView.kt */
final class BillAddressItemView$setData$1$1 extends Lambda implements Function2<Integer, Bundle, Unit> {
    final /* synthetic */ ComponentModel $componentModel;
    final /* synthetic */ BillAddressItemView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillAddressItemView$setData$1$1(BillAddressItemView billAddressItemView, ComponentModel componentModel) {
        super(2);
        this.this$0 = billAddressItemView;
        this.$componentModel = componentModel;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (Bundle) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, Bundle bundle) {
        if (i == 0) {
            View.OnClickListener access$getGoToEditPageListener$p = this.this$0.f39181r;
            View view = null;
            if (access$getGoToEditPageListener$p != null) {
                View access$getAddressItemView$p = this.this$0.f39164a;
                if (access$getAddressItemView$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressItemView");
                    access$getAddressItemView$p = null;
                }
                access$getGoToEditPageListener$p.onClick(access$getAddressItemView$p);
            }
            CustomerBillAddressBlackTipsLayout access$getBlackTipsLayout$p = this.this$0.f39177n;
            if (access$getBlackTipsLayout$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blackTipsLayout");
                access$getBlackTipsLayout$p = null;
            }
            access$getBlackTipsLayout$p.setVisibility(8);
            View access$getNoApartmentFloorLayout$p = this.this$0.f39174k;
            if (access$getNoApartmentFloorLayout$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noApartmentFloorLayout");
            } else {
                view = access$getNoApartmentFloorLayout$p;
            }
            view.setVisibility(8);
        }
        ItemViewCommonLogic itemViewCommonLogic = (ItemViewCommonLogic) this.this$0.getLogic();
        if (itemViewCommonLogic != null) {
            ItemViewCommonLogic.onItemClick$default(itemViewCommonLogic, this.$componentModel, Integer.valueOf(i), bundle, (Function1) null, 8, (Object) null);
        }
    }
}
