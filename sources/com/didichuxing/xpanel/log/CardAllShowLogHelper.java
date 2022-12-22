package com.didichuxing.xpanel.log;

import android.text.TextUtils;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import java.util.Map;

public class CardAllShowLogHelper {

    /* renamed from: a */
    private static final String f49535a = "CardAllShowLogHelper";

    /* renamed from: b */
    private boolean f49536b = false;

    /* renamed from: c */
    private XPanelCardData f49537c;

    public CardAllShowLogHelper(XPanelCardData xPanelCardData) {
        this.f49537c = xPanelCardData;
    }

    public final boolean moveAllIn(Map<String, Object> map) {
        if (this.f49536b) {
            return false;
        }
        this.f49536b = true;
        if (!TextUtils.isEmpty(this.f49537c.f49329id)) {
            XPanelOmegaUtils.trackEvent("xpanel_card_all_sw", this.f49537c.getOmegaParams(map));
            if (this.f49537c.iCardShow != null) {
                this.f49537c.iCardShow.onCardAllShow(map);
            }
            LogcatUtil.m35794d(f49535a, "moveAllIn :  id : " + this.f49537c.f49329id);
        }
        return true;
    }

    public final boolean moveAllOut(Map<String, Object> map) {
        if (!this.f49536b) {
            return false;
        }
        this.f49536b = false;
        return true;
    }

    public boolean isAllInScreen() {
        return this.f49536b;
    }
}
