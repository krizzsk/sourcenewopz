package com.didichuxing.xpanel.agent;

import com.didichuxing.xpanel.base.XPanelCardData;

public interface IXPanelAgentClickListener {
    void clickUri(String str, XPanelCardData xPanelCardData);

    boolean dispatchClickUri(String str, XPanelCardData xPanelCardData, String str2);
}
