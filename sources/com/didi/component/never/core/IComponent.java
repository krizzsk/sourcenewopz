package com.didi.component.never.core;

import android.view.ViewGroup;
import com.didi.component.never.core.ComponentPresenter;
import com.didi.component.never.core.IView;

public interface IComponent<V extends IView, P extends ComponentPresenter> {
    ViewGroup.LayoutParams getLayoutParams(ComponentParams componentParams);

    P getPresenter();

    V getView();

    void init(ComponentParams componentParams, ViewGroup viewGroup);

    boolean needInflate(ComponentParams componentParams);

    boolean recreateWhenNodeChange(ComponentParams componentParams);

    void setComponentProxy(ComponentProxy componentProxy);
}
