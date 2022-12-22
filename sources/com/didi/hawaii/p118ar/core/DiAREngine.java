package com.didi.hawaii.p118ar.core;

import android.content.Context;
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

/* renamed from: com.didi.hawaii.ar.core.DiAREngine */
public interface DiAREngine {
    int AREngineCreate(DARCNAVCreateData dARCNAVCreateData, Context context);

    void AREngineDestory();

    void AREngineSetCallbacks(SwigARCallback swigARCallback);

    int ARZGEngineCreate(DARCZGNavCreateData dARCZGNavCreateData, Context context);

    void ARZGEngineDestory();

    void ARZGEngineSetCallbacks(SwigARCallback swigARCallback);

    void activeZG();

    int createEngineContext();

    void currentLocation(DARCLocationInScene dARCLocationInScene);

    double currentTime();

    void destroyEngineContext();

    float distanceOfEnd();

    void errorAppear();

    void errorDisappear();

    void eventShowAlertReply(DARCNAVEDShowAlert dARCNAVEDShowAlert, int i);

    int getDiARNavKitVersion();

    void getGuidePosInScreen(DARCPointF dARCPointF);

    void inactiveZG();

    boolean isGPSWeak();

    boolean isShowEndGuidNode();

    boolean needShowBehindTips();

    void networkStatusChanged(DARCNetworkStatus dARCNetworkStatus);

    void pause();

    void recvHTTPResponse(DARCHTTPResponse dARCHTTPResponse);

    void renderUpdate();

    void resume();

    void setCorrectNodeVisible(boolean z);

    void setZGEffectiveRect(DARCRectF dARCRectF);

    void start();

    DARCNAVStatus status();

    void stop();

    void update(DARCNAVUpdateData dARCNAVUpdateData);

    void updateZG(DARCZGNavUpdateData dARCZGNavUpdateData);

    void updateZGGPS(DARCGPSData dARCGPSData);
}
