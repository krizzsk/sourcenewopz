package com.didi.hawaii.p118ar.core;

import android.content.Context;
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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.hawaii.ar.core.DiAREngineImpl */
public class DiAREngineImpl implements DiAREngine {
    public static final int DO_FAILED = 0;
    public static final int DO_SUCCESS = 1;
    public static final int NOSTATUS = 0;
    public static final int PAUSE = 1;
    public static final int RESUME = 2;

    /* renamed from: a */
    private int f23011a = 0;

    /* renamed from: b */
    private long f23012b = -1;

    /* renamed from: c */
    private long f23013c = -1;

    /* renamed from: d */
    private boolean f23014d = false;

    /* renamed from: e */
    private boolean f23015e = false;

    /* renamed from: f */
    private boolean f23016f = false;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.DiAREngineImpl$status */
    public @interface C8860status {
    }

    public int ARZGEngineCreate(DARCZGNavCreateData dARCZGNavCreateData, Context context) {
        return 0;
    }

    public void ARZGEngineDestory() {
    }

    public void ARZGEngineSetCallbacks(SwigARCallback swigARCallback) {
    }

    public void activeZG() {
    }

    public void inactiveZG() {
    }

    public boolean isGPSWeak() {
        return false;
    }

    public boolean isShowEndGuidNode() {
        return false;
    }

    public boolean needShowBehindTips() {
        return false;
    }

    public void setZGEffectiveRect(DARCRectF dARCRectF) {
    }

    public void updateZG(DARCZGNavUpdateData dARCZGNavUpdateData) {
    }

    public void updateZGGPS(DARCGPSData dARCGPSData) {
    }

    DiAREngineImpl() {
        createEngineContext();
    }

    public int getDiARNavKitVersion() {
        return AREngineJNI.DiARNavKitGetVersion();
    }

    public int createEngineContext() {
        this.f23012b = AREngineJNI.createJNIContext();
        this.f23014d = true;
        return 1;
    }

    public void destroyEngineContext() {
        if (m16562a()) {
            AREngineDestory();
            this.f23013c = -1;
        }
        AREngineJNI.destroyJNIContext(this.f23012b);
        this.f23014d = false;
    }

    public int AREngineCreate(DARCNAVCreateData dARCNAVCreateData, Context context) {
        this.f23013c = AREngineJNI.ARCreate(this.f23012b, dARCNAVCreateData, DiAREngineImpl.class.getClassLoader(), context);
        this.f23015e = true;
        return 1;
    }

    public void AREngineDestory() {
        if (m16562a()) {
            AREngineJNI.ARDestory(this.f23013c, this.f23012b);
            this.f23015e = false;
            this.f23013c = -1;
        }
    }

    public void AREngineSetCallbacks(SwigARCallback swigARCallback) {
        if (m16562a()) {
            AREngineJNI.ARSetCallbacks(this.f23013c, this.f23012b, swigARCallback);
        }
    }

    public void start() {
        if (m16562a()) {
            AREngineJNI.start(this.f23013c);
            this.f23016f = true;
        }
    }

    public void pause() {
        if (m16562a() && this.f23016f && this.f23011a != 1) {
            AREngineJNI.pause(this.f23013c);
            this.f23011a = 1;
        }
    }

    public void resume() {
        if (m16562a() && this.f23016f && this.f23011a != 2) {
            AREngineJNI.resume(this.f23013c);
            this.f23011a = 2;
        }
    }

    public void stop() {
        if (m16562a()) {
            AREngineJNI.stop(this.f23013c);
        }
    }

    public void update(DARCNAVUpdateData dARCNAVUpdateData) {
        if (m16562a()) {
            AREngineJNI.update(this.f23013c, dARCNAVUpdateData);
        }
    }

    public void renderUpdate() {
        if (m16562a()) {
            AREngineJNI.renderUpdate(this.f23013c);
        }
    }

    public void setCorrectNodeVisible(boolean z) {
        if (m16562a()) {
            AREngineJNI.setCorrectNodeVisible(this.f23013c, z);
        }
    }

    public void recvHTTPResponse(DARCHTTPResponse dARCHTTPResponse) {
        if (m16562a()) {
            AREngineJNI.recvHTTPResponse(this.f23013c, dARCHTTPResponse);
        }
    }

    public void networkStatusChanged(DARCNetworkStatus dARCNetworkStatus) {
        if (m16562a()) {
            AREngineJNI.networkStatusChanged(this.f23013c, dARCNetworkStatus);
        }
    }

    public void eventShowAlertReply(DARCNAVEDShowAlert dARCNAVEDShowAlert, int i) {
        if (m16562a()) {
            AREngineJNI.eventShowAlertReply(this.f23013c, dARCNAVEDShowAlert, i);
        }
    }

    public DARCNAVStatus status() {
        if (m16562a()) {
            return AREngineJNI.status(this.f23013c);
        }
        return null;
    }

    public double currentTime() {
        if (m16562a()) {
            return AREngineJNI.currentTime(this.f23013c);
        }
        return 0.0d;
    }

    public void currentLocation(DARCLocationInScene dARCLocationInScene) {
        if (m16562a()) {
            AREngineJNI.currentLocation(this.f23013c, dARCLocationInScene);
        }
    }

    public void getGuidePosInScreen(DARCPointF dARCPointF) {
        if (m16562a()) {
            AREngineJNI.getGuidePosInScreen(this.f23013c, dARCPointF);
        }
    }

    public float distanceOfEnd() {
        if (m16562a()) {
            return AREngineJNI.distanceOfEnd(this.f23013c);
        }
        return 0.0f;
    }

    public void errorAppear() {
        if (m16562a()) {
            AREngineJNI.errorAppear(this.f23013c);
        }
    }

    public void errorDisappear() {
        if (m16562a()) {
            AREngineJNI.errorDisappear(this.f23013c);
        }
    }

    /* renamed from: a */
    private synchronized boolean m16562a() {
        return this.f23014d && this.f23015e;
    }
}
