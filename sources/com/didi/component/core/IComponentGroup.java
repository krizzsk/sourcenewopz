package com.didi.component.core;

import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;

public interface IComponentGroup<V extends IView, P extends IPresenter> extends IComponent<V, P> {
    boolean autoInflateChildView();

    IComponent findComponentByName(String str);

    void onChildComponentCreated(String str, IComponent iComponent);
}
