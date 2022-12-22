package com.didi.component.never.core.node;

import android.os.Bundle;
import com.didi.component.never.core.annotation.AnnotationUtil;
import com.didi.component.never.core.node.NodePresenterImpl;

public abstract class NodeImpl<P extends NodePresenterImpl> implements Node {

    /* renamed from: a */
    private NodeManager f14661a;

    /* renamed from: b */
    private P f14662b;

    public abstract P createPresenter(Bundle bundle);

    public NodeImpl(NodeManager nodeManager, Bundle bundle) {
        this.f14661a = nodeManager;
        P createPresenter = createPresenter(bundle);
        this.f14662b = createPresenter;
        createPresenter.setContext(nodeManager.getContext());
    }

    public P getPresenter() {
        return this.f14662b;
    }

    public NodeManager getNodeManager() {
        return this.f14661a;
    }

    public String getId() {
        return AnnotationUtil.getNodeId(getClass());
    }
}
