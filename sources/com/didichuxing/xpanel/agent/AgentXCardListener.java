package com.didichuxing.xpanel.agent;

import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import com.didichuxing.xpanel.xcard.ICardListener;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

public class AgentXCardListener implements ICardListener {

    /* renamed from: a */
    private ICardListener f49271a;

    /* renamed from: b */
    private XPanelCardData f49272b;

    /* renamed from: c */
    private IXPanelAgentClickListener f49273c;

    public void bindXCardListener(ICardListener iCardListener) {
        this.f49271a = iCardListener;
    }

    public void bindAgentClickListener(IXPanelAgentClickListener iXPanelAgentClickListener) {
        this.f49273c = iXPanelAgentClickListener;
    }

    public void bindXCardData(XPanelCardData xPanelCardData) {
        this.f49272b = xPanelCardData;
    }

    public boolean handleEvent(String str, HashMap<String, Object> hashMap) {
        ICardListener iCardListener = this.f49271a;
        if (iCardListener != null && iCardListener.handleEvent(str, hashMap)) {
            return true;
        }
        if (this.f49272b == null) {
            return false;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1747007670:
                if (str.equals("xpanel_subcard_ck")) {
                    c = 3;
                    break;
                }
                break;
            case -1623722846:
                if (str.equals("xpanel_button_ck")) {
                    c = 1;
                    break;
                }
                break;
            case -1186313404:
                if (str.equals("xpanel_card_ck")) {
                    c = 2;
                    break;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    c = 4;
                    break;
                }
                break;
            case 1140676521:
                if (str.equals("xpanel_card_scroll")) {
                    c = 0;
                    break;
                }
                break;
        }
        if (c == 0) {
            XPanelOmegaUtils.trackEvent("xpanel_card_scroll", this.f49272b.getOmegaParams(hashMap));
        } else if (c == 1) {
            XPanelOmegaUtils.trackEvent("xpanel_button_ck", this.f49272b.getOmegaParams(hashMap));
            this.f49273c.dispatchClickUri((String) hashMap.get("url"), this.f49272b, (String) hashMap.get(Const.BUTTON_ID));
        } else if (c == 2) {
            this.f49272b.clickCardOmega(hashMap);
        } else if (c == 3) {
            XPanelOmegaUtils.trackEvent("xpanel_subcard_ck", this.f49272b.getOmegaParams(hashMap));
        } else if (c != 4) {
            return false;
        } else {
            if (this.f49273c != null) {
                Object obj = hashMap.get("url");
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    try {
                        str2 = URLDecoder.decode(str2, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    this.f49273c.clickUri(str2, this.f49272b);
                }
            }
        }
        return true;
    }
}
