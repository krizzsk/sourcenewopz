package com.didi.component.business.event;

import android.os.Bundle;

public class TripSwitchSceneEvent {
    public Bundle bundle;
    public int scene;
    public boolean waitXpanelEvent;

    public TripSwitchSceneEvent(int i, Bundle bundle2) {
        this.scene = i;
        this.bundle = bundle2;
        this.waitXpanelEvent = false;
    }

    public TripSwitchSceneEvent(int i, Bundle bundle2, boolean z) {
        this.scene = i;
        this.bundle = bundle2;
        this.waitXpanelEvent = z;
    }
}
