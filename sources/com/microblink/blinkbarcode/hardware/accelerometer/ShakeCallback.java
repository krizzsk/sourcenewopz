package com.microblink.blinkbarcode.hardware.accelerometer;

/* compiled from: line */
public interface ShakeCallback {
    public static final ShakeCallback EMPTY = new llIIlIlIIl();

    /* compiled from: line */
    public static class llIIlIlIIl implements ShakeCallback {
        public void onShakingStarted() {
        }

        public void onShakingStopped() {
        }
    }

    void onShakingStarted();

    void onShakingStopped();
}
