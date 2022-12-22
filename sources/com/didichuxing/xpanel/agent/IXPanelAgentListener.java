package com.didichuxing.xpanel.agent;

import com.didichuxing.xpanel.agent.net.BaseObject;
import com.didichuxing.xpanel.base.XPanelCardData;
import java.util.List;
import org.json.JSONObject;

public interface IXPanelAgentListener {
    XPanelCardData getViewById(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2);

    void loadError(BaseObject baseObject);

    void toShow(List<XPanelCardData> list);
}
