package com.didi.soda.bill.component.cpf;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.bill.component.Contract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\u0003H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0014J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0007\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/bill/component/cpf/CPFCheckComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/soda/bill/component/Contract$AbsCPFCheckView;", "Lcom/didi/soda/bill/component/Contract$AbsCPFCheckPresenter;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "presenter", "onCreatePresenter", "onCreateView", "setCPFCheckComponentListener", "", "listener", "Lcom/didi/soda/bill/component/cpf/CPFCheckVisibleListener;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CPFCheckComponent.kt */
public final class CPFCheckComponent extends MvpComponent<Contract.AbsCPFCheckView, Contract.AbsCPFCheckPresenter> {

    /* renamed from: a */
    private Contract.AbsCPFCheckPresenter f38913a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CPFCheckComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
    }

    /* access modifiers changed from: protected */
    public Contract.AbsCPFCheckPresenter onCreatePresenter() {
        Contract.AbsCPFCheckPresenter cPFCheckPresenter = new CPFCheckPresenter();
        this.f38913a = cPFCheckPresenter;
        if (cPFCheckPresenter != null) {
            return cPFCheckPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        return null;
    }

    /* access modifiers changed from: protected */
    public Contract.AbsCPFCheckView onCreateView() {
        return new CPFCheckView();
    }

    public final void setCPFCheckComponentListener(CPFCheckVisibleListener cPFCheckVisibleListener) {
        Intrinsics.checkNotNullParameter(cPFCheckVisibleListener, "listener");
        Contract.AbsCPFCheckPresenter absCPFCheckPresenter = this.f38913a;
        if (absCPFCheckPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            absCPFCheckPresenter = null;
        }
        absCPFCheckPresenter.setCPFVisibleListener(cPFCheckVisibleListener);
    }
}
