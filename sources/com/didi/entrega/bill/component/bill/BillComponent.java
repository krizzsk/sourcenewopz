package com.didi.entrega.bill.component.bill;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014J\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/entrega/bill/component/bill/BillComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/entrega/bill/component/bill/BillView;", "Lcom/didi/entrega/bill/component/bill/BillPresenter;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "onCreatePresenter", "onCreateView", "onHandleBack", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillComponent.kt */
public final class BillComponent extends MvpComponent<BillView, BillPresenter> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
    }

    /* access modifiers changed from: protected */
    public BillPresenter onCreatePresenter() {
        return new BillPresenter();
    }

    /* access modifiers changed from: protected */
    public BillView onCreateView() {
        return new BillView();
    }

    public final boolean onHandleBack() {
        BillPresenter billPresenter = (BillPresenter) getPresenter();
        if (billPresenter == null) {
            return false;
        }
        return billPresenter.onHandleBack();
    }
}
