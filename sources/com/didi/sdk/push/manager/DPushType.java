package com.didi.sdk.push.manager;

import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

public enum DPushType {
    GEITUI_PUSH("geitui"),
    GEITUI_PUSH_MIS_CLICK("geitui_msg_click"),
    XIAOMI_PUSH("xiaomi"),
    FCM_PUSH("fcm"),
    TENCENT_PUSH(ErrInfo.SOURCE_TENCENT);
    
    private String mName;

    private DPushType(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }
}
