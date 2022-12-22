package com.didiglobal.eevee_framework.node.eevee.impl;

import android.os.Bundle;
import com.didi.component.never.core.node.NodeManager;
import com.didi.component.never.core.node.NodePresenterImpl;
import com.didi.component_processor.annonation.NodeName;
import com.didiglobal.common.common.never.node.EeveeNodeImpl;

@NodeName(name = "eevee_push")
public class EeveePushNode extends EeveeNodeImpl<EeveePushNodePresenter> {
    public EeveePushNode(NodeManager nodeManager, Bundle bundle) {
        super(nodeManager, bundle);
    }

    public NodePresenterImpl createPresenter(Bundle bundle) {
        return new EeveePushNodePresenter(this, bundle);
    }
}
