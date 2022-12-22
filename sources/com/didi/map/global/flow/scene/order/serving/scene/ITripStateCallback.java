package com.didi.map.global.flow.scene.order.serving.scene;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ITripStateCallback {
    public static final int FAR_DISTANCE = 1;
    public static final int FIRST_ORDER_END_SECOND_ORDER_START = 3;
    public static final int NEAR_DISTANCE = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TripState {
    }

    void onTripStateUpdate(int i);
}
