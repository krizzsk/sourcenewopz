package com.didi.component.comp_xengine;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.comp_xengine.presenter.AbsGlobalXEnginePresenter;
import com.didi.component.comp_xengine.presenter.EstimateXEnginePresenter;
import com.didi.component.comp_xengine.presenter.HomeXEngineService;
import com.didi.component.comp_xengine.presenter.ServiceXEnginePresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IView;

@ComponentRegister(product = "ride", type = "global_xengine")
public class GlobalXEngineComponent extends BaseComponent<IView, AbsGlobalXEnginePresenter> {
    /* access modifiers changed from: protected */
    public IView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public AbsGlobalXEnginePresenter onCreatePresenter(ComponentParams componentParams) {
        int i = componentParams.pageID;
        if (i == 1001) {
            return new HomeXEngineService(componentParams);
        }
        if (i == 1030 || i == 1035) {
            return new EstimateXEnginePresenter(componentParams);
        }
        return new ServiceXEnginePresenter(componentParams);
    }
}
