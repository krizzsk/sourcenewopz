package com.didi.component.safetoolkit.utils;

import com.didi.sdk.util.GlobalOmegaUtils;
import java.util.HashMap;

public class SafetoolkitOmegaUtils {
    public static final void sendBubbleShow(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        GlobalOmegaUtils.trackEvent("gp_safetyBubble_view_sw", hashMap);
    }

    public static final void sendBubbleClick(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        GlobalOmegaUtils.trackEvent("gp_safetyBubble_btn_ck", hashMap);
    }
}
