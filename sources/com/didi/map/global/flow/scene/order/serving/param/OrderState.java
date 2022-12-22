package com.didi.map.global.flow.scene.order.serving.param;

import com.didi.component.comp_xpanel.XPanelScene;

public enum OrderState {
    STATE_NONE("none", 0),
    STATE_CALLING("state_calling", 1),
    STATE_PICKUP("state_pickup", 2),
    STATE_ARRIVED(XPanelScene.SCENE_ARRIVED, 3),
    STATE_PASSENGER_LATE("passenger_late", 3),
    STATE_PASSENGER_BOARDED("passenger_boarded", 4),
    STATE_CANCEL_REASSIGNMENT("state_far_cancel_reassignment", 5),
    STATE_CANCEL("state_far_cancel", 6);
    
    private String mDescribe;
    private int mOrderNum;

    private OrderState(String str, int i) {
        this.mDescribe = str;
        this.mOrderNum = i;
    }

    public int order() {
        return this.mOrderNum;
    }

    public String describe() {
        return this.mDescribe;
    }
}
