package com.didiglobal.eevee_framework.node.biz_entrance;

import android.os.Bundle;
import com.didi.component.never.core.node.NodeManager;
import com.didi.component.never.core.node.NodePresenterImpl;
import com.didi.component_processor.annonation.NodeName;
import com.didiglobal.common.common.never.node.EeveeNodeImpl;

@NodeName(name = "biz_entrance")
public class BizEntranceNode extends EeveeNodeImpl<BizEntranceNodePresenter> {
    public BizEntranceNode(NodeManager nodeManager, Bundle bundle) {
        super(nodeManager, bundle);
    }

    public NodePresenterImpl createPresenter(Bundle bundle) {
        return new BizEntranceNodePresenter(this, bundle);
    }
}
