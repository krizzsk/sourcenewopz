package com.didi.component.groupform.anycar;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.groupform.anycar.presenter.AbsAnycarGroupFormPresenter;
import com.didi.component.groupform.anycar.presenter.AnycarGroupFormPresenter;
import com.didi.component.groupform.anycar.view.AnyCarGroupFormView;
import com.didi.component.groupform.anycar.view.IAnycarGroupFormView;

@ComponentRegister(product = "ride", type = "anycar_group_form_container")
public class AnycarGroupFormComponent extends BaseComponent<IAnycarGroupFormView, AbsAnycarGroupFormPresenter> {
    /* access modifiers changed from: protected */
    public AbsAnycarGroupFormPresenter onCreatePresenter(ComponentParams componentParams) {
        return new AnycarGroupFormPresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public IAnycarGroupFormView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new AnyCarGroupFormView(componentParams.bizCtx.getContext(), viewGroup);
    }
}
