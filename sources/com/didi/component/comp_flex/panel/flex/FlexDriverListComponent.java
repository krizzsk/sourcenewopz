package com.didi.component.comp_flex.panel.flex;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.business.commonlist.AbsCommonListPresenter;
import com.didi.component.business.commonlist.ICommonListView;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "flex_list")
public class FlexDriverListComponent extends BaseComponent<ICommonListView, AbsCommonListPresenter> {
    /* access modifiers changed from: protected */
    public ICommonListView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new FlexDriverListView(componentParams.getActivity(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsCommonListPresenter onCreatePresenter(ComponentParams componentParams) {
        return new FlexDriverListPresenter(componentParams);
    }
}
