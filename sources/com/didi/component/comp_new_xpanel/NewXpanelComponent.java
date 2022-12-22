package com.didi.component.comp_new_xpanel;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.comp_new_xpanel.presenter.NewXpanelTripPresenter;
import com.didi.component.comp_new_xpanel.view.NewXpanelTripView;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "new_xpanel")
public class NewXpanelComponent extends BaseComponent<AbsNewXPanelView, AbsNewXPanelPresenter> {
    /* access modifiers changed from: protected */
    public AbsNewXPanelView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new NewXpanelTripView(componentParams.getActivity());
    }

    /* access modifiers changed from: protected */
    public AbsNewXPanelPresenter onCreatePresenter(ComponentParams componentParams) {
        return new NewXpanelTripPresenter(componentParams);
    }
}
