package com.didi.map.global.component.floatingwindow;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/map/global/component/floatingwindow/OrientationStateChangeCallback;", "", "stateChange", "", "state", "Lcom/didi/map/global/component/floatingwindow/OrientationStateChangeCallback$OrientationState;", "OrientationState", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrientationStateChangeCallback.kt */
public interface OrientationStateChangeCallback {

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/map/global/component/floatingwindow/OrientationStateChangeCallback$OrientationState;", "", "(Ljava/lang/String;I)V", "VERTICAL", "LEFT_HORIZONTAL", "REVERSE_VERTICAL", "RIGHT_HORIZONTAL", "HORIZONTAL", "OTHER", "compFloatingWindow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrientationStateChangeCallback.kt */
    public enum OrientationState {
        VERTICAL,
        LEFT_HORIZONTAL,
        REVERSE_VERTICAL,
        RIGHT_HORIZONTAL,
        HORIZONTAL,
        OTHER
    }

    void stateChange(OrientationState orientationState);
}
