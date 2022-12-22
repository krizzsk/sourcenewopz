package com.didi.hawaii.p118ar.core;

import com.didi.hawaii.p118ar.jni.DARCLocationInScene;
import com.didi.hawaii.p118ar.jni.DARCNAVStatus;
import com.didi.hawaii.p118ar.jni.DARCPointF;

/* renamed from: com.didi.hawaii.ar.core.ScenceManager */
public class ScenceManager extends BaseDelegate implements IScenceDelegate {
    ScenceManager(DiAREngine diAREngine) {
        attachEngine(diAREngine);
    }

    public DARCNAVStatus status() {
        if (this.mAREngine != null) {
            return this.mAREngine.status();
        }
        return null;
    }

    public double currentTime() {
        if (this.mAREngine != null) {
            return this.mAREngine.currentTime();
        }
        return -1.0d;
    }

    public void currentLocation(DARCLocationInScene dARCLocationInScene) {
        if (this.mAREngine != null) {
            this.mAREngine.currentLocation(dARCLocationInScene);
        }
    }

    public void getGuidePosInScreen(DARCPointF dARCPointF) {
        if (this.mAREngine != null) {
            this.mAREngine.getGuidePosInScreen(dARCPointF);
        }
    }

    public float distanceOfEnd() {
        if (this.mAREngine != null) {
            return this.mAREngine.distanceOfEnd();
        }
        return -1.0f;
    }

    public void release() {
        super.release();
    }
}
