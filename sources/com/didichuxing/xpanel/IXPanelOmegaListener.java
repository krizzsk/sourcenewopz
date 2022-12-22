package com.didichuxing.xpanel;

import com.didichuxing.xpanel.base.XPanelCardData;
import java.util.HashMap;

public interface IXPanelOmegaListener {
    int getCardIdByObject(XPanelCardData xPanelCardData);

    HashMap<String, Object> getCommonParams();
}
