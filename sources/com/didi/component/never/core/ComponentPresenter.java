package com.didi.component.never.core;

import com.didi.component.never.core.IView;
import com.didi.component.never.core.node.Node;
import java.util.List;

public interface ComponentPresenter<V extends IView> extends IPresenter {
    void addChildComponent(String str);

    List<String> getChildComponents();

    Node getNodeParent();

    void onNodeChanged(Node node);

    void removeChildComponent(String str);

    void setIView(V v);

    void setNodeParent(Node node);
}
