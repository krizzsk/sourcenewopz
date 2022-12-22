package com.iproov.sdk.face.model;

public class Pose {
    public final float pitch;
    public final float roll;
    public final float yaw;

    public Pose(float f, float f2, float f3) {
        this.roll = f;
        this.yaw = f2;
        this.pitch = f3;
    }
}
