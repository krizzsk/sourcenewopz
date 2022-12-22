package com.didiglobal.eevee_framework.node.eevee.impl;

import android.os.Bundle;
import com.didi.component.never.core.node.NodeManager;
import com.didi.component.never.core.node.NodePresenterImpl;
import com.didi.component_processor.annonation.NodeName;
import com.didiglobal.common.common.never.node.EeveeNodeImpl;

@NodeName(name = "eevee_switch")
public class EeveeSwitchNode extends EeveeNodeImpl<EeveeSwitchNodePresenter> {
    public EeveeSwitchNode(NodeManager nodeManager, Bundle bundle) {
        super(nodeManager, bundle);
    }

    public NodePresenterImpl createPresenter(Bundle bundle) {
        return new EeveeSwitchNodePresenter(this, bundle);
    }
}
