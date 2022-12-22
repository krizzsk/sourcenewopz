package com.iproov.sdk.face;

import com.iproov.sdk.face.model.Pose;

public interface PoseDetector<T> {
    Pose calculatePose(T t);

    void setOmega(float f);
}
