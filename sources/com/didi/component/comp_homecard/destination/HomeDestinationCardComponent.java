package com.didi.component.comp_homecard.destination;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "pas_home_address_card")
public class HomeDestinationCardComponent extends BaseComponent<IHomeDestinationCardView, AbsHomeDestinationCardPresenter> {
    /* access modifiers changed from: protected */
    public IHomeDestinationCardView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new HomeDestinationCardView(componentParams.bizCtx, viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsHomeDestinationCardPresenter onCreatePresenter(ComponentParams componentParams) {
        return new HomeDestinationCardPresenter(componentParams);
    }
}
