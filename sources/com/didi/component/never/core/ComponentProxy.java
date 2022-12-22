package com.didi.component.never.core;

import android.view.ViewGroup;
import com.didi.component.never.core.ComponentPresenter;
import com.didi.component.never.core.IView;

public abstract class ComponentProxy<V extends IView, P extends ComponentPresenter> {
    public abstract P onCreatePresenter(ComponentParams componentParams);

    public abstract V onCreateView(ComponentParams componentParams, ViewGroup viewGroup);
}
