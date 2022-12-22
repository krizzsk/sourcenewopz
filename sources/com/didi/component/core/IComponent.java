package com.didi.component.core;

import android.view.ViewGroup;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;

public interface IComponent<V extends IView, P extends IPresenter> {
    P getPresenter();

    V getView();

    void init(ComponentParams componentParams, ViewGroup viewGroup);
}
