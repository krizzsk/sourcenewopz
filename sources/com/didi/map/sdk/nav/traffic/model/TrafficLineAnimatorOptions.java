package com.didi.map.sdk.nav.traffic.model;

public class TrafficLineAnimatorOptions {
    public TrafficLineAnimatorListener animatorListener;
    public long duration;

    public static abstract class TrafficLineAnimatorListener {
        public void onEnd() {
        }

        public void onStart() {
        }
    }
}
