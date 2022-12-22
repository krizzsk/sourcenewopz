package com.didi.component.comp_form_common.anycar;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "anycar_form_common_item")
public class AnyCarFormCommonComponent extends BaseComponent<AbsAnyCarFormCommonView, AbsAnyCarFormCommonPresenter> {
    /* access modifiers changed from: protected */
    public AbsAnyCarFormCommonView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new AnyCarFormCommonView(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsAnyCarFormCommonPresenter onCreatePresenter(ComponentParams componentParams) {
        return new AnyCarFormCommonPresenter(componentParams.bizCtx);
    }
}
