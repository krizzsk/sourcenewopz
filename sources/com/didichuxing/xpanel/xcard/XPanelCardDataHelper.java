package com.didichuxing.xpanel.xcard;

import android.text.TextUtils;
import com.didichuxing.xpanel.agent.IXPanelAgentClickListener;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import java.util.HashMap;
import java.util.Map;

public class XPanelCardDataHelper {

    /* renamed from: a */
    private XPanelCardData f49618a;

    /* renamed from: b */
    private IXPanelAgentClickListener f49619b;

    public void onClick(String str) {
        XPanelCardData xPanelCardData;
        IXPanelAgentClickListener iXPanelAgentClickListener = this.f49619b;
        if (iXPanelAgentClickListener != null && (xPanelCardData = this.f49618a) != null) {
            iXPanelAgentClickListener.clickUri(str, xPanelCardData);
        }
    }

    public void clickOmega(String str, HashMap<String, Object> hashMap) {
        if (this.f49618a != null) {
            if ("card".equals(str)) {
                this.f49618a.clickCardOmega(hashMap);
            } else {
                XPanelOmegaUtils.trackEvent("xpanel_button_ck", this.f49618a.getOmegaParams(hashMap));
            }
        }
    }

    public void scrollCardOmega() {
        XPanelCardData xPanelCardData = this.f49618a;
        if (xPanelCardData != null && !TextUtils.isEmpty(xPanelCardData.f49329id)) {
            XPanelOmegaUtils.trackEvent("xpanel_card_scroll", this.f49618a.getOmegaParams((Map<String, Object>) null));
        }
    }

    public void setCardData(XPanelCardData xPanelCardData) {
        this.f49618a = xPanelCardData;
    }

    public void bindAgentClickListener(IXPanelAgentClickListener iXPanelAgentClickListener) {
        this.f49619b = iXPanelAgentClickListener;
    }

    public void clickSubCardOmega(Map<String, Object> map) {
        XPanelCardData xPanelCardData = this.f49618a;
        if (xPanelCardData != null && !TextUtils.isEmpty(xPanelCardData.f49329id)) {
            XPanelOmegaUtils.trackEvent("xpanel_subcard_ck", this.f49618a.getOmegaParams(map));
        }
    }
}
