package com.didi.soda.bill.component.bill;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.component.cpf.CPFCheckVisibleListener;
import com.didi.soda.customer.app.constant.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u0003H\u0014J\b\u0010\r\u001a\u00020\u0002H\u0014J\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/bill/component/bill/CustomerBillComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/soda/bill/component/Contract$AbsBillView;", "Lcom/didi/soda/bill/component/Contract$AbsBillPresenter;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "isUseNewVersion", "", "presenter", "onAttach", "", "onCreatePresenter", "onCreateView", "onHandleBack", "onPageResult", "data", "Landroid/os/Bundle;", "setCPFVisibleListener", "listener", "Lcom/didi/soda/bill/component/cpf/CPFCheckVisibleListener;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillComponent.kt */
public final class CustomerBillComponent extends MvpComponent<Contract.AbsBillView, Contract.AbsBillPresenter> {

    /* renamed from: a */
    private Contract.AbsBillPresenter f38824a;

    /* renamed from: b */
    private boolean f38825b = true;

    public final void onPageResult(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "data");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerBillComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
    }

    public final boolean onHandleBack() {
        Contract.AbsBillPresenter absBillPresenter = this.f38824a;
        if (absBillPresenter == null) {
            return false;
        }
        return absBillPresenter.onHandleBack();
    }

    /* access modifiers changed from: protected */
    public void onAttach() {
        this.f38825b = Const.ABConfigName.BILL_PAGE.isSwitchOn();
        super.onAttach();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsBillPresenter onCreatePresenter() {
        if (this.f38825b) {
            return new CustomerBillPresenterV2();
        }
        return new CustomerBillPresenter();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsBillView onCreateView() {
        if (this.f38825b) {
            return new CustomerBillViewV2();
        }
        return new CustomerBillView();
    }

    public final void setCPFVisibleListener(CPFCheckVisibleListener cPFCheckVisibleListener) {
        Intrinsics.checkNotNullParameter(cPFCheckVisibleListener, "listener");
        Contract.AbsBillPresenter absBillPresenter = this.f38824a;
        if (absBillPresenter != null) {
            absBillPresenter.setCPFVisibleListener(cPFCheckVisibleListener);
        }
    }
}
