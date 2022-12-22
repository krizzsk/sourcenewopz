package com.didi.sdk.events;

import android.os.Bundle;
import com.didi.sdk.app.TabEventManager;

public class SwitchTypeEvent {
    public Bundle extraBundle;
    public String scheme;
    public TabEventManager.TabHandleModel tabHandleModel;
    public String type;
    public String urlGetParams;

    public SwitchTypeEvent(String str) {
        this.type = str;
    }
}
