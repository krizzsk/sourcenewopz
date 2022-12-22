package com.didi.component.business.xpanel.sdk;

import com.didi.component.business.xpanel.sdk.controllers.IXPanelBaseController;

public interface IGlobalXPanelControllerInflater<T extends IXPanelBaseController> {
    void inflateController(T t);
}
