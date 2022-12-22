package com.didiglobal.common.common.never.component;

import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didiglobal.common.common.never.component.EeveeIView;
import com.didiglobal.common.common.never.node.EeveeNodePresenterImpl;

public abstract class EeveeCompPresenterImpl<V extends EeveeIView> extends ComponentPresenterImpl {
    public EeveeCompPresenterImpl(ComponentParams componentParams) {
        super(componentParams);
    }

    public String getNodeEeveeID() {
        try {
            return ((EeveeNodePresenterImpl) getNodeParent().getPresenter()).getEeveeNodeId();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
