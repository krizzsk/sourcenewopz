package com.didichuxing.diface.biz.bioassay.self_liveness;

import com.taxis99.R;

public enum ActionType {
    ACTION_BLINK_EYE(1, "file:///android_asset/liveness_eye_open_closed.gif", R.raw.blink),
    ACTION_OPEN_MOUTH(2, "file:///android_asset/liveness_mouth_open_closed.gif", R.raw.open_mouth),
    ACTION_SHAKE_HEAD(3, "file:///android_asset/liveness_head_yaw.gif", R.raw.shake_head),
    ACTION_NOD(4, "file:///android_asset/liveness_head_pitch.gif", R.raw.nod);
    
    final int action;
    final String gif;
    final int video;

    private ActionType(int i, String str, int i2) {
        this.action = i;
        this.gif = str;
        this.video = i2;
    }

    public int getAction() {
        return this.action;
    }

    public String getGif() {
        return this.gif;
    }

    public int getVideo() {
        return this.video;
    }

    public static ActionType index(int i) {
        for (ActionType actionType : values()) {
            if (actionType.action == i) {
                return actionType;
            }
        }
        return null;
    }
}
