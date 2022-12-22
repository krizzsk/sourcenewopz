package com.didi.component.comp_flex.option;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "flex_option")
public class FlexOptionComponent extends BaseComponent<AbsFlexOptionView, FlexOptionPresenter> {
    /* access modifiers changed from: protected */
    public AbsFlexOptionView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new FlexOptionView(componentParams.getActivity(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public FlexOptionPresenter onCreatePresenter(ComponentParams componentParams) {
        return new FlexOptionPresenter(componentParams);
    }
}
