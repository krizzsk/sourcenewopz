package com.didi.component.comp_anycar_append_list;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "passenger_newXpanel+anycar_appendCard_logic+anycar_append_list")
public class AnyCarAppendListComponent extends BaseComponent<AnyCarAppendListView, AnyCarAppendListPresenter> {
    /* access modifiers changed from: protected */
    public AnyCarAppendListView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new AnyCarAppendListView(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AnyCarAppendListPresenter onCreatePresenter(ComponentParams componentParams) {
        return new AnyCarAppendListPresenter(componentParams.getActivity());
    }
}
