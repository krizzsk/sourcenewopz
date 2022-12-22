package com.didi.entrega.bill.view;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.bill.model.ComponentModel;
import com.didi.entrega.bill.view.item.BillAddressItemView;
import com.didi.entrega.bill.view.item.BillCommonItemView;
import com.didi.entrega.bill.view.item.BillPackageItemView;
import com.didi.entrega.bill.view.item.BillPayChannelItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/entrega/bill/view/BillItemViewFactory;", "", "()V", "createItemView", "Lcom/didi/entrega/bill/view/BillItemView;", "component", "Lcom/didi/entrega/bill/model/ComponentModel;", "context", "Landroid/content/Context;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillItemViewFactory.kt */
public final class BillItemViewFactory {
    public final BillItemView createItemView(ComponentModel componentModel, Context context, ScopeContext scopeContext) {
        BillItemView billItemView;
        Intrinsics.checkNotNullParameter(componentModel, "component");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        int type = componentModel.getType();
        if (type == 4) {
            billItemView = new BillPayChannelItemView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        } else if (type == 10 || type == 6 || type == 7) {
            billItemView = new BillCommonItemView(context);
        } else if (type == 16) {
            billItemView = new BillAddressItemView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        } else if (type != 17) {
            billItemView = new FallBackItemView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        } else {
            billItemView = new BillPackageItemView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        }
        billItemView.setData(componentModel);
        return billItemView;
    }
}
