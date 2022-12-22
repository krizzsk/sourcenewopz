package com.didi.component.routeguide;

import android.view.View;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;

public abstract class AbsRouteGuidePresenter extends BaseExpressPresenter<IRouteGuideView> implements View.OnClickListener {
    /* access modifiers changed from: protected */
    public abstract RouteGuideData initCardData();

    public AbsRouteGuidePresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
