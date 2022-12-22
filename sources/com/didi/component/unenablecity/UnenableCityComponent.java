package com.didi.component.unenablecity;

import android.view.ViewGroup;
import com.didi.component.business.xpanel.sdk.component.DefaultNotVisibleController;
import com.didi.component.business.xpanel.sdk.component.SelfControlComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.unenablecity.impl.ConfirmUnableCityPresenter;
import com.didi.component.unenablecity.impl.HomeUnableCityPresenter;
import com.didi.component.unenablecity.impl.UnableCityContainerView;

@ComponentRegister(product = "ride", type = "unenable_city")
public class UnenableCityComponent extends SelfControlComponent<IUnopenedCityView, AbsUnableCityPresenter, DefaultNotVisibleController> {
    /* access modifiers changed from: protected */
    public AbsUnableCityPresenter onCreatePresenter(ComponentParams componentParams) {
        if (componentParams.pageID == 1001) {
            return new HomeUnableCityPresenter(componentParams);
        }
        if (componentParams.pageID == 1030) {
            return new ConfirmUnableCityPresenter(componentParams);
        }
        return new ConfirmUnableCityPresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public IUnopenedCityView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new UnableCityContainerView(componentParams.getActivity(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public DefaultNotVisibleController createInflateController() {
        return new DefaultNotVisibleController();
    }
}
