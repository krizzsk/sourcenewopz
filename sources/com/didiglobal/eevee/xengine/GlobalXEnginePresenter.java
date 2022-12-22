package com.didiglobal.eevee.xengine;

import com.didi.component.never.core.ComponentParams;

public class GlobalXEnginePresenter extends AbsGlobalXEnginePresenter {
    public GlobalXEnginePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public String getScene() {
        return getNodeEeveeID();
    }
}
