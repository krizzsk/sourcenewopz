package com.didi.component.never.core;

import com.didi.component.never.core.ComponentPresenter;
import com.didi.component.never.core.IView;

public interface IComponentGroup<V extends IView, P extends ComponentPresenter> extends IComponent<V, P> {
    boolean autoInflateChildView();

    IComponent findComponentByName(String str);

    void onChildComponentCreated(String str, IComponent iComponent);
}
