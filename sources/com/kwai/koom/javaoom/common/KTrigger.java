package com.kwai.koom.javaoom.common;

import androidx.lifecycle.LifecycleObserver;
import com.kwai.koom.javaoom.monitor.TriggerReason;

public interface KTrigger extends LifecycleObserver {
    void startTrack();

    void stopTrack();

    KTriggerStrategy strategy();

    void trigger(TriggerReason triggerReason);
}
