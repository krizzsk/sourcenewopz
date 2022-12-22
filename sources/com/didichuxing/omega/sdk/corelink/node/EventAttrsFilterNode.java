package com.didichuxing.omega.sdk.corelink.node;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;

public class EventAttrsFilterNode {
    private static final String OMEGA_EVENT_PARAM_BLACK_LIST_ANDROID = "omega_event_param_black_list_android_global";

    public static void attrsFilter(Event event) {
        String[] split;
        if (event != null) {
            String str = (String) CommonUtil.getParams("omega_event_param_black_list_android_global", event.getEventId(), "");
            if (!TextUtils.isEmpty(str) && (split = str.split(",")) != null && split.length != 0) {
                for (String removeAttr : split) {
                    event.removeAttr(removeAttr);
                }
            }
        }
    }
}
