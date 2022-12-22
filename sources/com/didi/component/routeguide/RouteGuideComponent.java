package com.didi.component.routeguide;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "routeguide")
public class RouteGuideComponent extends BaseComponent<IRouteGuideView, AbsRouteGuidePresenter> {
    /* access modifiers changed from: protected */
    public IRouteGuideView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new RouteGuideView(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsRouteGuidePresenter onCreatePresenter(ComponentParams componentParams) {
        return new RouteGuidePresenter(componentParams);
    }
}
