package com.didi.soda.bill.component.deliverymethod;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.bill.component.Contract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/bill/component/deliverymethod/DeliveryMethodComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/soda/bill/component/Contract$AbsDeliveryMethodView;", "Lcom/didi/soda/bill/component/Contract$AbsDeliveryMethodPresenter;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "onCreatePresenter", "Lcom/didi/soda/bill/component/deliverymethod/DeliveryMethodPresenter;", "onCreateView", "Lcom/didi/soda/bill/component/deliverymethod/DeliveryMethodView;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DeliveryMethodComponent.kt */
public final class DeliveryMethodComponent extends MvpComponent<Contract.AbsDeliveryMethodView, Contract.AbsDeliveryMethodPresenter> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeliveryMethodComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
    }

    /* access modifiers changed from: protected */
    public DeliveryMethodPresenter onCreatePresenter() {
        return new DeliveryMethodPresenter();
    }

    /* access modifiers changed from: protected */
    public DeliveryMethodView onCreateView() {
        return new DeliveryMethodView();
    }
}
