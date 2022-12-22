package com.didi.component.homedestination;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.homedestination.abs.AbsHomeDestinationPresenter;
import com.didi.component.homedestination.abs.AbsHomeDestinationView;
import com.didi.component.homedestination.newversion.p102b.HomeDestinationNewPlanBPresenter;
import com.didi.component.homedestination.newversion.p102b.HomeDestinationNewPlanBView;

@ComponentRegister(product = "ride", type = "home_destination")
public class HomeDestinationComponent extends BaseComponent<AbsHomeDestinationView, AbsHomeDestinationPresenter> {
    /* access modifiers changed from: protected */
    public AbsHomeDestinationView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new HomeDestinationNewPlanBView(componentParams.bizCtx, viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsHomeDestinationPresenter onCreatePresenter(ComponentParams componentParams) {
        return new HomeDestinationNewPlanBPresenter(componentParams);
    }
}
