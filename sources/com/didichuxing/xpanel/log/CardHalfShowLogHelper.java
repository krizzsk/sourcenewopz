package com.didichuxing.xpanel.log;

import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import java.util.Map;

public class CardHalfShowLogHelper {

    /* renamed from: a */
    private boolean f49538a = false;

    /* renamed from: b */
    private long f49539b = -1;

    /* renamed from: c */
    private XPanelCardData f49540c;

    public CardHalfShowLogHelper(XPanelCardData xPanelCardData) {
        this.f49540c = xPanelCardData;
    }

    public final boolean moveHalfIn() {
        if (this.f49538a) {
            return false;
        }
        this.f49539b = System.currentTimeMillis();
        this.f49538a = true;
        return true;
    }

    public boolean isCurrentEfficientShow() {
        if (!this.f49538a || System.currentTimeMillis() - this.f49539b < 1000) {
            return false;
        }
        return true;
    }

    public final boolean moveHalfOut(Map<String, Object> map) {
        if (!this.f49538a) {
            return false;
        }
        this.f49538a = false;
        long currentTimeMillis = System.currentTimeMillis() - this.f49539b;
        if (currentTimeMillis < 1000) {
            return false;
        }
        Map<String, Object> omegaParams = this.f49540c.getOmegaParams(map);
        omegaParams.put("time", Long.valueOf(currentTimeMillis));
        XPanelOmegaUtils.trackEvent("xpanel_card_eff_sw", omegaParams);
        return true;
    }
}
