package com.didi.component.comp_form_common;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.comp_form_common.presenter.FormCommonPresenter;
import com.didi.component.comp_form_common.view.FormCommonView;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "form_common_item")
public class FormCommonComponent extends BaseComponent<AbsFormCommonView, AbsFormCommonPresenter> {
    /* access modifiers changed from: protected */
    public AbsFormCommonView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new FormCommonView(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsFormCommonPresenter onCreatePresenter(ComponentParams componentParams) {
        return new FormCommonPresenter(componentParams.bizCtx);
    }
}
