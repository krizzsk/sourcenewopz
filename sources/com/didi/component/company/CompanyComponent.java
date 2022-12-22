package com.didi.component.company;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "company")
public class CompanyComponent extends BaseComponent<ICompanyView, AbsCompanyPresenter> {
    /* access modifiers changed from: protected */
    public ICompanyView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new NewCompanyView(componentParams.getActivity(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsCompanyPresenter onCreatePresenter(ComponentParams componentParams) {
        return new NewCompanyPresenter(componentParams);
    }
}
