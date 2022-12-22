package com.didi.hawaii.p118ar.core.p119zg;

import android.content.Context;
import com.didi.hawaii.p118ar.core.DiAREngine;
import com.didi.hawaii.p118ar.jni.AREngineJNI;
import com.didi.hawaii.p118ar.jni.DARCGPSData;
import com.didi.hawaii.p118ar.jni.DARCHTTPResponse;
import com.didi.hawaii.p118ar.jni.DARCLocationInScene;
import com.didi.hawaii.p118ar.jni.DARCNAVCreateData;
import com.didi.hawaii.p118ar.jni.DARCNAVEDShowAlert;
import com.didi.hawaii.p118ar.jni.DARCNAVStatus;
import com.didi.hawaii.p118ar.jni.DARCNAVUpdateData;
import com.didi.hawaii.p118ar.jni.DARCNetworkStatus;
import com.didi.hawaii.p118ar.jni.DARCPointF;
import com.didi.hawaii.p118ar.jni.DARCRectF;
import com.didi.hawaii.p118ar.jni.DARCZGNavCreateData;
import com.didi.hawaii.p118ar.jni.DARCZGNavUpdateData;
import com.didi.hawaii.p118ar.jni.SwigARCallback;

/* renamed from: com.didi.hawaii.ar.core.zg.DiARZGEngineImpl */
public class DiARZGEngineImpl implements DiAREngine {
    public static final int DO_FAILED = 0;
    public static final int DO_SUCCESS = 1;

    /* renamed from: a */
    private long f23102a = -1;

    /* renamed from: b */
    private long f23103b = -1;

    /* renamed from: c */
    private boolean f23104c = false;

    /* renamed from: d */
    private boolean f23105d = false;

    public int AREngineCreate(DARCNAVCreateData dARCNAVCreateData, Context context) {
        return -1;
    }

    public void AREngineDestory() {
    }

    public void AREngineSetCallbacks(SwigARCallback swigARCallback) {
    }

    public void currentLocation(DARCLocationInScene dARCLocationInScene) {
    }

    public double currentTime() {
        return 0.0d;
    }

    public float distanceOfEnd() {
        return 0.0f;
    }

    public void errorAppear() {
    }

    public void errorDisappear() {
    }

    public void eventShowAlertReply(DARCNAVEDShowAlert dARCNAVEDShowAlert, int i) {
    }

    public void getGuidePosInScreen(DARCPointF dARCPointF) {
    }

    public void networkStatusChanged(DARCNetworkStatus dARCNetworkStatus) {
    }

    public void pause() {
    }

    public void recvHTTPResponse(DARCHTTPResponse dARCHTTPResponse) {
    }

    public void renderUpdate() {
    }

    public void resume() {
    }

    public void setCorrectNodeVisible(boolean z) {
    }

    public void start() {
    }

    public DARCNAVStatus status() {
        return null;
    }

    public void stop() {
    }

    public void update(DARCNAVUpdateData dARCNAVUpdateData) {
    }

    public DiARZGEngineImpl() {
        createEngineContext();
    }

    public int getDiARNavKitVersion() {
        return AREngineJNI.DiARNavKitGetVersion();
    }

    public int createEngineContext() {
        this.f23102a = AREngineJNI.createJNIContext();
        this.f23104c = true;
        return 1;
    }

    public void destroyEngineContext() {
        if (m16597a()) {
            ARZGEngineDestory();
            this.f23103b = -1;
        }
        AREngineJNI.destroyJNIContext(this.f23102a);
        this.f23104c = false;
    }

    public int ARZGEngineCreate(DARCZGNavCreateData dARCZGNavCreateData, Context context) {
        this.f23103b = AREngineJNI.ARZGCreate(this.f23102a, dARCZGNavCreateData, DiARZGEngineImpl.class.getClassLoader(), context);
        this.f23105d = true;
        return 1;
    }

    public void ARZGEngineDestory() {
        if (m16597a()) {
            AREngineJNI.ARZGDestory(this.f23103b, this.f23102a);
            this.f23105d = false;
            this.f23103b = -1;
        }
    }

    public void ARZGEngineSetCallbacks(SwigARCallback swigARCallback) {
        if (m16597a()) {
            AREngineJNI.ARZGSetCallbacks(this.f23103b, this.f23102a, swigARCallback);
        }
    }

    public void updateZG(DARCZGNavUpdateData dARCZGNavUpdateData) {
        if (m16597a()) {
            AREngineJNI.updateZG(this.f23103b, dARCZGNavUpdateData);
        }
    }

    public void activeZG() {
        if (m16597a()) {
            AREngineJNI.resumeZG(this.f23103b);
        }
    }

    public void inactiveZG() {
        if (m16597a()) {
            AREngineJNI.pauseZG(this.f23103b);
        }
    }

    public void setZGEffectiveRect(DARCRectF dARCRectF) {
        if (m16597a()) {
            AREngineJNI.setZGEffectiveRect(this.f23103b, dARCRectF);
        }
    }

    public void updateZGGPS(DARCGPSData dARCGPSData) {
        if (m16597a()) {
            AREngineJNI.updateZGGPS(this.f23103b, dARCGPSData);
        }
    }

    public boolean isShowEndGuidNode() {
        if (m16597a()) {
            return AREngineJNI.isShowEndGuidNode(this.f23103b);
        }
        return false;
    }

    public boolean isGPSWeak() {
        if (m16597a()) {
            return AREngineJNI.isGPSWeak(this.f23103b);
        }
        return false;
    }

    public boolean needShowBehindTips() {
        if (m16597a()) {
            return AREngineJNI.needShowBehindTips(this.f23103b);
        }
        return false;
    }

    /* renamed from: a */
    private synchronized boolean m16597a() {
        return this.f23104c && this.f23105d;
    }
}
