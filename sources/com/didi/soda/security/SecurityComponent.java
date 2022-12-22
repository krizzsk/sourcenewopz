package com.didi.soda.security;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.security.Contract;

public class SecurityComponent extends MvpComponent<Contract.AbsSecurityView, Contract.AbsSecurityPresenter> {

    /* renamed from: a */
    private SecurityView f43810a;

    public SecurityComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public Contract.AbsSecurityPresenter onCreatePresenter() {
        return new SecurityPresenter();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsSecurityView onCreateView() {
        SecurityView securityView = new SecurityView();
        this.f43810a = securityView;
        return securityView;
    }
}
