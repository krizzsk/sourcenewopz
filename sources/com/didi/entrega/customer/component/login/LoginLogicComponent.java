package com.didi.entrega.customer.component.login;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.entrega.customer.component.login.Contract;

public class LoginLogicComponent extends MvpComponent<Contract.AbsLoginLogicView, Contract.AbsLoginLogicPresenter> {
    public LoginLogicComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public Contract.AbsLoginLogicView onCreateView() {
        return new LoginLogicView();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsLoginLogicPresenter onCreatePresenter() {
        return new LoginLogicPresenter();
    }
}
