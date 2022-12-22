package com.didi.soda.customer.biz.popdialog.natived;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;

public class PopDialogComponent extends MvpComponent<Contract.AbsPopDialogView, Contract.AbsPopDialogPresenter> {

    /* renamed from: a */
    private final NAPopDialogEntity f40484a;

    /* renamed from: b */
    private final PopDialogFactory f40485b = new PopDialogFactory();

    PopDialogComponent(ViewGroup viewGroup, NAPopDialogEntity nAPopDialogEntity) {
        super(viewGroup);
        this.f40484a = nAPopDialogEntity;
    }

    /* access modifiers changed from: protected */
    public Contract.AbsPopDialogPresenter onCreatePresenter() {
        return this.f40485b.mo102133a(this.f40484a);
    }

    /* access modifiers changed from: protected */
    public Contract.AbsPopDialogView onCreateView() {
        return this.f40485b.mo102134a(this.f40484a.popupType);
    }
}
