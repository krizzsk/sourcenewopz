package com.didi.component.never.core.node;

import com.didi.component.never.core.node.NodePresenter;

public interface Node<P extends NodePresenter> {
    String getId();

    NodeManager getNodeManager();

    P getPresenter();
}
