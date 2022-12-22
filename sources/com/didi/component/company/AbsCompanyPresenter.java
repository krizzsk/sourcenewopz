package com.didi.component.company;

import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;

public abstract class AbsCompanyPresenter extends BaseExpressPresenter<ICompanyView> {
    public abstract void showCompanySelectPage();

    public AbsCompanyPresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
