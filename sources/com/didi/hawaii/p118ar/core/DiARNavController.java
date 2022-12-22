package com.didi.hawaii.p118ar.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.didi.hawaii.p118ar.core.AlertUiManager;
import com.didi.hawaii.p118ar.jni.AREngineJNI;
import com.didi.hawaii.p118ar.jni.DARCAlert;
import com.didi.hawaii.p118ar.jni.DARCHTTPRequest;
import com.didi.hawaii.p118ar.jni.DARCHTTPResponse;
import com.didi.hawaii.p118ar.jni.DARCLocationInScene;
import com.didi.hawaii.p118ar.jni.DARCNAVCreateData;
import com.didi.hawaii.p118ar.jni.DARCNAVEDShowAlert;
import com.didi.hawaii.p118ar.jni.DARCNAVEDStatusChange;
import com.didi.hawaii.p118ar.jni.DARCNAVEvent;
import com.didi.hawaii.p118ar.jni.DARCNAVStatus;
import com.didi.hawaii.p118ar.jni.DARCObject;
import com.didi.hawaii.p118ar.jni.DARCPointF;
import com.didi.hawaii.p118ar.jni.SwigARCallback;
import com.didi.hawaii.p118ar.utils.ARNavGlobal;
import com.didi.hawaii.p118ar.utils.AROmega;
import com.didi.hawaii.p118ar.utils.ARRequestUtil;
import com.didi.hawaii.p118ar.view.ARGlView;
import java.util.HashMap;

/* renamed from: com.didi.hawaii.ar.core.DiARNavController */
public class DiARNavController extends SwigARCallback implements ARGlView.LifeCycleCallback {

    /* renamed from: a */
    private static final String f23017a = DiARNavController.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f23018b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private DiARNavManager f23019c = null;

    /* renamed from: d */
    private NetWorkerManager f23020d = null;

    /* renamed from: e */
    private ScenceManager f23021e = null;

    /* renamed from: f */
    private RenderManager f23022f = null;

    /* renamed from: g */
    private AlertUiManager f23023g = null;

    /* renamed from: h */
    private Context f23024h;

    /* renamed from: i */
    private DARCNAVStatus f23025i = DARCNAVStatus.DARCNAVStatus_Init;

    /* renamed from: j */
    private long f23026j = 0;

    /* access modifiers changed from: protected */
    public void LogHandler(String str) {
    }

    public DiARNavController(DARCNAVCreateData dARCNAVCreateData, Context context, ViewGroup viewGroup) {
        this.f23024h = context;
        DiAREngineImpl diAREngineImpl = new DiAREngineImpl();
        diAREngineImpl.AREngineCreate(dARCNAVCreateData, this.f23024h.getApplicationContext());
        diAREngineImpl.AREngineSetCallbacks(this);
        this.f23019c = new DiARNavManager(diAREngineImpl);
        this.f23020d = new NetWorkerManager(diAREngineImpl);
        this.f23021e = new ScenceManager(diAREngineImpl);
        this.f23022f = new RenderManager(this.f23024h, diAREngineImpl);
        this.f23023g = new AlertUiManager(this.f23024h, viewGroup, diAREngineImpl);
        AROmega.arStart();
    }

    public void onHostCreated() {
        this.f23022f.createRender(this.f23024h);
    }

    public void onHostDestroy() {
        this.f23019c.destroy();
        this.f23019c.release();
        this.f23020d.release();
        this.f23021e.release();
        this.f23022f.release();
        this.f23023g.release();
    }

    public void onHostDetached() {
        this.f23019c.stop();
    }

    public void onHostResume() {
        this.f23019c.resume();
        this.f23022f.resume();
    }

    public void onHostPause() {
        this.f23019c.pause();
        this.f23022f.pause();
    }

    public void onHostSizeChanged(int i, int i2) {
        this.f23022f.onSizeChange(i, i2);
    }

    public void drawFrame() {
        int[] iArr = new int[3];
        this.f23022f.drawRender(iArr, this.f23025i);
        boolean z = false;
        this.f23023g.hintForExcessiveMotion(iArr[0] == 2);
        this.f23023g.checkPitchForNavigation(iArr[1] != 6);
        AlertUiManager alertUiManager = this.f23023g;
        if (iArr[2] == 4) {
            z = true;
        }
        alertUiManager.dissMissHintForNavigation(z);
    }

    public DARCNAVStatus status() {
        return this.f23021e.status();
    }

    public double currentTime() {
        return this.f23021e.currentTime();
    }

    public float[] currentLocation() {
        DARCLocationInScene dARCLocationInScene = new DARCLocationInScene();
        this.f23021e.currentLocation(dARCLocationInScene);
        return new float[]{(float) dARCLocationInScene.getIndex(), dARCLocationInScene.getPos().getX(), dARCLocationInScene.getPos().getY(), dARCLocationInScene.getPos().getZ()};
    }

    public void getGuidePosInScreen(DARCPointF dARCPointF) {
        this.f23021e.getGuidePosInScreen(dARCPointF);
    }

    public float distanceOfEnd() {
        return this.f23021e.distanceOfEnd();
    }

    public int getCurARStatus() {
        return this.f23023g.getCurARStatus();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16565a(DARCHTTPResponse dARCHTTPResponse) {
        this.f23020d.recvHTTPResponse(dARCHTTPResponse);
    }

    /* access modifiers changed from: protected */
    public void navigatorSendHTTPRequest(final DARCHTTPRequest dARCHTTPRequest) {
        ARRequestUtil.doAsyncHttpTask(ARRequestUtil.convertDARCHTTPRequest2ARRequest(dARCHTTPRequest), new ARRequestUtil.Callback() {
            public void onSuccess(byte[] bArr) {
                final DARCHTTPResponse convertData2DARCHttpResponse = ARRequestUtil.convertData2DARCHttpResponse(bArr, dARCHTTPRequest);
                DiARNavController.this.f23018b.post(new Runnable() {
                    public void run() {
                        if (convertData2DARCHttpResponse != null) {
                            DiARNavController.this.m16565a(convertData2DARCHttpResponse);
                        }
                    }
                });
            }

            public void onFailed(int i, Exception exc) {
                final DARCHTTPResponse convertData2DARCHttpResponse = ARRequestUtil.convertData2DARCHttpResponse((byte[]) null, dARCHTTPRequest);
                DiARNavController.this.f23018b.post(new Runnable() {
                    public void run() {
                        if (convertData2DARCHttpResponse != null) {
                            DiARNavController.this.m16565a(convertData2DARCHttpResponse);
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: protected */
    public void navigatorEvent(DARCNAVEvent dARCNAVEvent, DARCNAVEDShowAlert dARCNAVEDShowAlert) {
        if (dARCNAVEvent == DARCNAVEvent.DARCNAVEvent_ShowAlert) {
            DARCAlert alert = dARCNAVEDShowAlert.getAlert();
            DARCObject.gretain(alert);
            String title = alert.getTitle();
            String content = alert.getContent();
            HashMap hashMap = new HashMap();
            AREngineJNI.GetDARCAlertButtonList_Wrap(alert, hashMap);
            this.f23023g.onALertFromSDK(dARCNAVEDShowAlert, title, content, hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void navigatorEvent(DARCNAVEvent dARCNAVEvent, DARCNAVEDStatusChange dARCNAVEDStatusChange) {
        if (dARCNAVEvent != DARCNAVEvent.DARCNAVEvent_StatusChanged) {
            DARCNAVEvent dARCNAVEvent2 = DARCNAVEvent.DARCNAVEvent_ResetARSession;
        } else if (dARCNAVEDStatusChange.getStatusTo() == DARCNAVStatus.DARCNAVStatus_LocStart) {
            this.f23025i = DARCNAVStatus.DARCNAVStatus_LocStart;
            this.f23023g.refeshStatus(0);
            this.f23026j = System.currentTimeMillis();
            AROmega.arNavLocationView();
        } else if (dARCNAVEDStatusChange.getStatusTo() == DARCNAVStatus.DARCNAVStatus_LocEnd) {
            this.f23025i = DARCNAVStatus.DARCNAVStatus_LocEnd;
            this.f23023g.refeshStatus(1);
            AROmega.arNavLocationTime(((float) (System.currentTimeMillis() - this.f23026j)) / 1000.0f);
            if (ARNavGlobal.firstLocationSuccessTime == 0) {
                ARNavGlobal.firstLocationSuccessTime = System.currentTimeMillis();
            }
        } else if (dARCNAVEDStatusChange.getStatusTo() == DARCNAVStatus.DARCNAVStatus_Running) {
            this.f23022f.updateNavHintData();
            this.f23023g.refeshStatus(2);
            this.f23025i = DARCNAVStatus.DARCNAVStatus_Running;
        } else if (dARCNAVEDStatusChange.getStatusTo() == DARCNAVStatus.DARCNAVStatus_ReachEnd) {
            this.f23025i = DARCNAVStatus.DARCNAVStatus_ReachEnd;
            this.f23023g.alertReachDestination(dARCNAVEDStatusChange.getStringObj());
        }
    }

    public void setUiManagerListener(AlertUiManager.UIListener uIListener) {
        this.f23023g.setUIListener(uIListener);
    }

    public void start() {
        this.f23019c.start();
        this.f23023g.start();
        this.f23022f.start();
    }

    public void recoveryARUI() {
        this.f23023g.recoveryUI();
    }

    public void exitOfOrderCancell() {
        this.f23023g.exitOfOrderCancell();
    }

    public void hideARNavUI() {
        this.f23023g.hideARNavUI();
    }
}
