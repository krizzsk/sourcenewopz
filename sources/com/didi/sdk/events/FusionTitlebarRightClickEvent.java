package com.didi.sdk.events;

import com.didi.onehybrid.jsbridge.CallbackFunction;

public class FusionTitlebarRightClickEvent {
    public CallbackFunction func;

    public FusionTitlebarRightClickEvent(CallbackFunction callbackFunction) {
        this.func = callbackFunction;
    }
}
