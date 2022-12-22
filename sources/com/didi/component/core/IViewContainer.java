package com.didi.component.core;

import android.os.Bundle;
import android.view.ViewGroup;

public interface IViewContainer {

    public interface IComponentCreator {
        IComponent inflateComponent(String str, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Bundle bundle);

        IComponent newComponent(String str, ViewGroup viewGroup);

        IComponent newComponent(String str, ViewGroup viewGroup, Bundle bundle);

        void removeComponent(IComponent iComponent);
    }

    void setComponentCreator(IComponentCreator iComponentCreator);
}
