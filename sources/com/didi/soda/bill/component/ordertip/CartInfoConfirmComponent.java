package com.didi.soda.bill.component.ordertip;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.bill.component.Contract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\r\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/bill/component/ordertip/CartInfoConfirmComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/soda/bill/component/Contract$AbsCartInfoConfirmView;", "Lcom/didi/soda/bill/component/Contract$AbsCartInfoConfirmPresenter;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "onCreatePresenter", "Lcom/didi/soda/bill/component/ordertip/CartInfoConfirmPresenter;", "onCreateView", "Lcom/didi/soda/bill/component/ordertip/CartInfoConfirmView;", "onHandleBack", "", "()Lkotlin/Unit;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartInfoConfirmComponent.kt */
public final class CartInfoConfirmComponent extends MvpComponent<Contract.AbsCartInfoConfirmView, Contract.AbsCartInfoConfirmPresenter> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartInfoConfirmComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
    }

    /* access modifiers changed from: protected */
    public CartInfoConfirmPresenter onCreatePresenter() {
        return new CartInfoConfirmPresenter();
    }

    /* access modifiers changed from: protected */
    public CartInfoConfirmView onCreateView() {
        return new CartInfoConfirmView();
    }

    public final Unit onHandleBack() {
        Contract.AbsCartInfoConfirmPresenter absCartInfoConfirmPresenter = (Contract.AbsCartInfoConfirmPresenter) getPresenter();
        if (absCartInfoConfirmPresenter == null) {
            return null;
        }
        absCartInfoConfirmPresenter.onHandleBack();
        return Unit.INSTANCE;
    }
}
