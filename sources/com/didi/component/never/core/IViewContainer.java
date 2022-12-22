package com.didi.component.never.core;

import android.os.Bundle;
import android.view.ViewGroup;

@Deprecated
public interface IViewContainer {

    @Deprecated
    public interface IComponentCreator {
        @Deprecated
        IComponent inflateComponent(ComponentPresenter componentPresenter, String str, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Bundle bundle);

        @Deprecated
        IComponent newComponent(ComponentPresenter componentPresenter, String str, ViewGroup viewGroup, Bundle bundle);

        @Deprecated
        void removeComponent(ComponentPresenter componentPresenter, IComponent iComponent);

        @Deprecated
        void removeComponent(ComponentPresenter componentPresenter, String str);
    }

    @Deprecated
    ComponentPresenter getHostPresenter();

    @Deprecated
    void setComponentCreator(IComponentCreator iComponentCreator);
}
