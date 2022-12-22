package com.didi.component.never.core.page;

import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.IComponent;
import com.didi.component.never.core.IViewContainer;
import com.didi.component.never.core.container.ContainerComponent;
import com.didi.component.never.core.node.Node;
import com.didi.component.never.core.node.NodeManager;
import java.util.Map;

public interface Page {
    void changeLayoutParams(String str, ViewGroup.LayoutParams layoutParams);

    IComponent findChildComponentByType(String str);

    IComponent findComponentByType(String str);

    void forward();

    Map<String, IComponent> getActiveComponents();

    ComponentParams getComponentParams(String str, String str2);

    ViewGroup getContainerView();

    Map<String, IComponent> getInflatedComponents();

    NodeManager getNodeManager();

    IViewContainer.IComponentCreator getViewCreator();

    boolean handleBackPressed();

    IComponent inflateComponent(Class<? extends IComponent> cls);

    void invisibleComponent(IComponent iComponent);

    void layoutComponents(ContainerComponent containerComponent);

    void onNodeChanged(Node node);

    void removeComponent(IComponent iComponent);

    void visibleComponent(IComponent iComponent);
}
