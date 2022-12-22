package com.didi.component.comp_anycarlist;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "anycar_list")
public class AnyCarListComponent extends BaseComponent<AnyCarListView, AbsAnyCarListPresenter> {
    /* access modifiers changed from: protected */
    public AnyCarListView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new AnyCarListView(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsAnyCarListPresenter onCreatePresenter(ComponentParams componentParams) {
        return new AnyCarListPresenter(componentParams.getActivity());
    }
}
