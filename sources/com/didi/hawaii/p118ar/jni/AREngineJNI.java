package com.didi.hawaii.p118ar.jni;

/* renamed from: com.didi.hawaii.ar.jni.AREngineJNI */
public final class AREngineJNI implements AREngineJNIConstants {
    public static void languageSet(DARCLanguage dARCLanguage, int i) {
        AREngineJNIBridge.languageSet__SWIG_0(dARCLanguage.swigValue(), i);
    }

    public static void languageSet(DARCLanguage dARCLanguage) {
        AREngineJNIBridge.languageSet__SWIG_1(dARCLanguage.swigValue());
    }

    public static DARCLanguage languageGet() {
        return DARCLanguage.swigToEnum(AREngineJNIBridge.languageGet());
    }

    public static String languageGetDirName(DARCLanguage dARCLanguage) {
        return AREngineJNIBridge.languageGetDirName(dARCLanguage.swigValue());
    }

    public static double distanceOfGeoPoints(double d, double d2, double d3, double d4) {
        return AREngineJNIBridge.distanceOfGeoPoints(d, d2, d3, d4);
    }

    public static DARCMatrix4F perspectiveFov(float f, float f2, float f3, float f4, float f5) {
        return new DARCMatrix4F(AREngineJNIBridge.perspectiveFov(f, f2, f3, f4, f5), true);
    }

    public static int DiARNavKitGetVersion() {
        return AREngineJNIBridge.DiARNavKitGetVersion();
    }

    public static void destroyJNIContext(long j) {
        AREngineJNIBridge.destroyJNIContext(j);
    }

    public static long ARCreate(long j, DARCNAVCreateData dARCNAVCreateData, Object obj, Object obj2) {
        return AREngineJNIBridge.ARCreate(j, DARCNAVCreateData.getCPtr(dARCNAVCreateData), dARCNAVCreateData, obj, obj2);
    }

    public static void ARDestory(long j, long j2) {
        AREngineJNIBridge.ARDestory(j, j2);
    }

    public static void ARSetCallbacks(long j, long j2, SwigARCallback swigARCallback) {
        AREngineJNIBridge.ARSetCallbacks(j, j2, SwigARCallback.getCPtr(swigARCallback), swigARCallback);
    }

    public static void start(long j) {
        AREngineJNIBridge.start(j);
    }

    public static void pause(long j) {
        AREngineJNIBridge.pause(j);
    }

    public static void resume(long j) {
        AREngineJNIBridge.resume(j);
    }

    public static void stop(long j) {
        AREngineJNIBridge.stop(j);
    }

    public static void update(long j, DARCNAVUpdateData dARCNAVUpdateData) {
        AREngineJNIBridge.update(j, DARCNAVUpdateData.getCPtr(dARCNAVUpdateData), dARCNAVUpdateData);
    }

    public static long ARZGCreate(long j, DARCZGNavCreateData dARCZGNavCreateData, Object obj, Object obj2) {
        return AREngineJNIBridge.ARZGCreate(j, DARCZGNavCreateData.getCPtr(dARCZGNavCreateData), dARCZGNavCreateData, obj, obj2);
    }

    public static void ARZGDestory(long j, long j2) {
        AREngineJNIBridge.ARZGDestory(j, j2);
    }

    public static void ARZGSetCallbacks(long j, long j2, SwigARCallback swigARCallback) {
        AREngineJNIBridge.ARZGSetCallbacks(j, j2, SwigARCallback.getCPtr(swigARCallback), swigARCallback);
    }

    public static void pauseZG(long j) {
        AREngineJNIBridge.pauseZG(j);
    }

    public static void resumeZG(long j) {
        AREngineJNIBridge.resumeZG(j);
    }

    public static void updateZG(long j, DARCZGNavUpdateData dARCZGNavUpdateData) {
        AREngineJNIBridge.updateZG(j, DARCZGNavUpdateData.getCPtr(dARCZGNavUpdateData), dARCZGNavUpdateData);
    }

    public static void updateZGGPS(long j, DARCGPSData dARCGPSData) {
        AREngineJNIBridge.updateZGGPS(j, DARCGPSData.getCPtr(dARCGPSData), dARCGPSData);
    }

    public static void setZGEffectiveRect(long j, DARCRectF dARCRectF) {
        AREngineJNIBridge.setZGEffectiveRect(j, DARCRectF.getCPtr(dARCRectF), dARCRectF);
    }

    public static boolean isShowEndGuidNode(long j) {
        return AREngineJNIBridge.isShowEndGuidNode(j);
    }

    public static boolean isGPSWeak(long j) {
        return AREngineJNIBridge.isGPSWeak(j);
    }

    public static boolean needShowBehindTips(long j) {
        return AREngineJNIBridge.needShowBehindTips(j);
    }

    public static void renderUpdate(long j) {
        AREngineJNIBridge.renderUpdate(j);
    }

    public static void setCorrectNodeVisible(long j, boolean z) {
        AREngineJNIBridge.setCorrectNodeVisible(j, z);
    }

    public static void recvHTTPResponse(long j, DARCHTTPResponse dARCHTTPResponse) {
        AREngineJNIBridge.recvHTTPResponse(j, DARCHTTPResponse.getCPtr(dARCHTTPResponse), dARCHTTPResponse);
    }

    public static void networkStatusChanged(long j, DARCNetworkStatus dARCNetworkStatus) {
        AREngineJNIBridge.networkStatusChanged(j, dARCNetworkStatus.swigValue());
    }

    public static void eventShowAlertReply(long j, DARCNAVEDShowAlert dARCNAVEDShowAlert, int i) {
        AREngineJNIBridge.eventShowAlertReply(j, DARCNAVEDShowAlert.getCPtr(dARCNAVEDShowAlert), dARCNAVEDShowAlert, i);
    }

    public static DARCNAVStatus status(long j) {
        return DARCNAVStatus.swigToEnum(AREngineJNIBridge.status(j));
    }

    public static double currentTime(long j) {
        return AREngineJNIBridge.currentTime(j);
    }

    public static void currentLocation(long j, DARCLocationInScene dARCLocationInScene) {
        AREngineJNIBridge.currentLocation(j, DARCLocationInScene.getCPtr(dARCLocationInScene), dARCLocationInScene);
    }

    public static void getGuidePosInScreen(long j, DARCPointF dARCPointF) {
        AREngineJNIBridge.getGuidePosInScreen(j, DARCPointF.getCPtr(dARCPointF), dARCPointF);
    }

    public static float distanceOfEnd(long j) {
        return AREngineJNIBridge.distanceOfEnd(j);
    }

    public static void errorAppear(long j) {
        AREngineJNIBridge.errorAppear(j);
    }

    public static void errorDisappear(long j) {
        AREngineJNIBridge.errorDisappear(j);
    }

    public static long createJNIContext() {
        return AREngineJNIBridge.createJNIContext();
    }

    public static void GetDARCHTTPRequestHeaders_Wrap(DARCHTTPRequest dARCHTTPRequest, Object obj) {
        AREngineJNIBridge.GetDARCHTTPRequestHeaders_Wrap(DARCHTTPRequest.getCPtr(dARCHTTPRequest), dARCHTTPRequest, obj);
    }

    public static void GetDARCAlertButtonList_Wrap(DARCAlert dARCAlert, Object obj) {
        AREngineJNIBridge.GetDARCAlertButtonList_Wrap(DARCAlert.getCPtr(dARCAlert), dARCAlert, obj);
    }

    public static void DARCNAVUpdateData_cameraColorBuffer_set(DARCNAVUpdateData dARCNAVUpdateData, byte[] bArr) {
        AREngineJNIBridge.DARCNAVUpdateData_cameraColorBuffer_set(DARCNAVUpdateData.getCPtr(dARCNAVUpdateData), dARCNAVUpdateData, bArr);
    }

    public static void DARCNAVUpdateData_cameraDepthBuffer_set(DARCNAVUpdateData dARCNAVUpdateData, byte[] bArr) {
        AREngineJNIBridge.DARCNAVUpdateData_cameraDepthBuffer_set(DARCNAVUpdateData.getCPtr(dARCNAVUpdateData), dARCNAVUpdateData, bArr);
    }

    public static void DARCNAVCreateData_containerView_set(DARCNAVCreateData dARCNAVCreateData, Object obj) {
        AREngineJNIBridge.DARCNAVCreateData_containerView_set(DARCNAVCreateData.getCPtr(dARCNAVCreateData), dARCNAVCreateData, obj);
    }

    public static void DARCNAVCreateData_containerView_release(DARCNAVCreateData dARCNAVCreateData) {
        AREngineJNIBridge.DARCNAVCreateData_containerView_release(DARCNAVCreateData.getCPtr(dARCNAVCreateData), dARCNAVCreateData);
    }

    public static void DARCZGNavCreateData_containerView_set(DARCZGNavCreateData dARCZGNavCreateData, Object obj) {
        AREngineJNIBridge.DARCZGNavCreateData_containerView_set(DARCZGNavCreateData.getCPtr(dARCZGNavCreateData), dARCZGNavCreateData, obj);
    }

    public static void DARCZGNavCreateData_containerView_release(DARCZGNavCreateData dARCZGNavCreateData) {
        AREngineJNIBridge.DARCZGNavCreateData_containerView_release(DARCZGNavCreateData.getCPtr(dARCZGNavCreateData), dARCZGNavCreateData);
    }

    public static byte[] DARCDATA_getDataWrap(DARCData dARCData) {
        return AREngineJNIBridge.DARCDATA_getDataWrap(DARCData.getCPtr(dARCData), dARCData);
    }

    public static String encryptStringWrap(String str, int i) {
        return AREngineJNIBridge.encryptStringWrap(str, i);
    }

    public static long DARCAskResponse_createAskResponseWrap(DARCHTTPResponse dARCHTTPResponse) {
        return AREngineJNIBridge.DARCAskResponse_createAskResponseWrap(DARCHTTPResponse.getCPtr(dARCHTTPResponse), dARCHTTPResponse);
    }

    public static long DARCAskRequest_createHttpRequestWrap(DARCAskRequest dARCAskRequest) {
        return AREngineJNIBridge.DARCAskRequest_createHttpRequestWrap(DARCAskRequest.getCPtr(dARCAskRequest), dARCAskRequest);
    }
}
