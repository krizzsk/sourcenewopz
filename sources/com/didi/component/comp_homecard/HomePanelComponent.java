package com.didi.component.comp_homecard;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.business.commonlist.AbsCommonListPresenter;
import com.didi.component.business.commonlist.ICommonListView;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "home_panel")
public class HomePanelComponent extends BaseComponent<ICommonListView, AbsCommonListPresenter> {
    /* access modifiers changed from: protected */
    public ICommonListView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new HomePanelView(componentParams.getActivity(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsCommonListPresenter onCreatePresenter(ComponentParams componentParams) {
        return new HomePanelPresenter(componentParams);
    }
}
