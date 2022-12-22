package com.didiglobal.common.common.never.node;

import android.os.Bundle;
import com.didi.component.never.core.node.NodeImpl;
import com.didi.component.never.core.node.NodeManager;
import com.didiglobal.common.common.never.node.EeveeNodePresenterImpl;

public abstract class EeveeNodeImpl<P extends EeveeNodePresenterImpl> extends NodeImpl {
    public EeveeNodeImpl(NodeManager nodeManager, Bundle bundle) {
        super(nodeManager, bundle);
    }
}
