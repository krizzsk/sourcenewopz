package com.didichuxing.xpanel.base;

import java.util.List;

public interface IXPanelViewPrivate extends IXPanelViewPublic {
    void notifyAll(List<XPanelCardData> list, boolean z);
}
