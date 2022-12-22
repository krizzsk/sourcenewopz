package com.didiglobal.eevee_framework.node.eevee_launch;

import android.os.Bundle;
import com.didi.component.never.core.node.NodeManager;
import com.didi.component.never.core.node.NodePresenterImpl;
import com.didi.component_processor.annonation.NodeName;
import com.didiglobal.common.common.never.node.EeveeNodeImpl;

@NodeName(name = "eevee")
public class EeveeLaunchNode extends EeveeNodeImpl<EeveeLaunchNodePresenter> {
    public EeveeLaunchNode(NodeManager nodeManager, Bundle bundle) {
        super(nodeManager, bundle);
    }

    public NodePresenterImpl createPresenter(Bundle bundle) {
        return new EeveeLaunchNodePresenter(this, bundle);
    }
}
