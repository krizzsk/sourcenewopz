package com.didichuxing.xpanel.xcard;

import java.util.HashMap;

public interface ICardListener {
    public static final String EVENT_BUTTON_CK = "xpanel_button_ck";
    public static final String EVENT_CARD_CK = "xpanel_card_ck";
    public static final String EVENT_CARD_SCROLL = "xpanel_card_scroll";
    public static final String EVENT_CLICK = "click";
    public static final String EVENT_SUB_CLICK = "xpanel_subcard_ck";

    boolean handleEvent(String str, HashMap<String, Object> hashMap);
}
