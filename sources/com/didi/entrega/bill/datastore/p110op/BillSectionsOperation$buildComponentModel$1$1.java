package com.didi.entrega.bill.datastore.p110op;

import android.view.View;
import com.didi.entrega.bill.model.ComponentModel;
import com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "view", "Landroid/view/View;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.entrega.bill.datastore.op.BillSectionsOperation$buildComponentModel$1$1 */
/* compiled from: BillSectionsOperation.kt */
final class BillSectionsOperation$buildComponentModel$1$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ BillComponentEntity $componentEntity;
    final /* synthetic */ ComponentModel $this_apply;
    final /* synthetic */ BillSectionsOperation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillSectionsOperation$buildComponentModel$1$1(BillSectionsOperation billSectionsOperation, ComponentModel componentModel, BillComponentEntity billComponentEntity) {
        super(1);
        this.this$0 = billSectionsOperation;
        this.$this_apply = componentModel;
        this.$componentEntity = billComponentEntity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.this$0.m14609a(this.$this_apply, this.$componentEntity);
    }
}
