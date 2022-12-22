package com.didichuxing.xpanel.agent;

import com.didichuxing.xpanel.base.XPanelCardData;
import java.util.HashMap;
import java.util.List;

public interface IXPanelDataSource {
    void bindAgentClickListener(IXPanelAgentClickListener iXPanelAgentClickListener);

    void destroy();

    String getCurrentDimension();

    void notifyServiceCards(List<XPanelCardData> list);

    void notifyServiceCards(List<XPanelCardData> list, boolean z);

    void notifyShowList();

    void onBackHome();

    void onCreate();

    void onLeaveHome();

    void onPause();

    void onResume();

    void reload();

    void reloadAgent(String str, HashMap<String, Object> hashMap, boolean z);

    void reloadAgent(boolean z, String str, HashMap<String, Object> hashMap, boolean z2, AgentRequestCallBack agentRequestCallBack);

    void reloadByCardIds(String[] strArr, HashMap<String, Object> hashMap);

    void removeAgentCard(XPanelCardData xPanelCardData);

    void setXPanelAgentListener(IXPanelAgentListener iXPanelAgentListener);

    void testResult(String str, String str2);
}
