package com.didi.entrega.orderlist.component;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0014J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/component/OrderListComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/entrega/orderlist/component/OrderListView;", "Lcom/didi/entrega/orderlist/component/OrderListPresenter;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "onCreatePresenter", "onCreateView", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderListComponent.kt */
public final class OrderListComponent extends MvpComponent<OrderListView, OrderListPresenter> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderListComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
    }

    /* access modifiers changed from: protected */
    public OrderListView onCreateView() {
        return new OrderListView();
    }

    /* access modifiers changed from: protected */
    public OrderListPresenter onCreatePresenter() {
        return new OrderListPresenter();
    }
}
