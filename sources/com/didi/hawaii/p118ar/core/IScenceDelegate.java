package com.didi.hawaii.p118ar.core;

import com.didi.hawaii.p118ar.jni.DARCLocationInScene;
import com.didi.hawaii.p118ar.jni.DARCNAVStatus;
import com.didi.hawaii.p118ar.jni.DARCPointF;

/* renamed from: com.didi.hawaii.ar.core.IScenceDelegate */
public interface IScenceDelegate {
    void currentLocation(DARCLocationInScene dARCLocationInScene);

    double currentTime();

    float distanceOfEnd();

    void getGuidePosInScreen(DARCPointF dARCPointF);

    DARCNAVStatus status();
}
