package com.didi.soda.customer.component.error;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.customer.component.error.Contract;

public class ErrorHandleComponent extends MvpComponent<Contract.AbsErrorHandleView, Contract.AbsErrorHandlePresenter> {
    public ErrorHandleComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public Contract.AbsErrorHandleView onCreateView() {
        return new ErrorHandleView();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsErrorHandlePresenter onCreatePresenter() {
        return new ErrorHandlePresenter();
    }
}
