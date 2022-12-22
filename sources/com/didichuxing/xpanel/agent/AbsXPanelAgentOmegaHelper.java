package com.didichuxing.xpanel.agent;

import com.didichuxing.xpanel.IXPanelOmegaListener;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.models.XPanelModelRegister;
import java.util.HashMap;

public abstract class AbsXPanelAgentOmegaHelper implements IXPanelOmegaListener {
    public abstract HashMap<String, Object> getAbsCommonParams();

    public final int getCardIdByObject(XPanelCardData xPanelCardData) {
        if (xPanelCardData == null) {
            return 0;
        }
        return XPanelModelRegister.getModelID(xPanelCardData.f49329id);
    }

    public HashMap<String, Object> getCommonParams() {
        HashMap<String, Object> absCommonParams = getAbsCommonParams();
        return absCommonParams == null ? new HashMap<>() : absCommonParams;
    }
}
