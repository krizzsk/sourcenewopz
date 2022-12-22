package com.didichuxing.xpanel.agent;

import com.didichuxing.xpanel.base.XPanelCardData;
import java.util.List;

public interface IAgentCallBack {
    void notify(List<XPanelCardData> list, boolean z);
}
