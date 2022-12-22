package com.didi.safety.god2020.p145ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.ifx.license.IFXLicenseClient;
import com.didi.safety.god.event.ReqFocusEvent;
import com.didi.safety.god.event.RestartDetectionEvent;
import com.didi.safety.god.event.RestartFromBeginningEvent;
import com.didi.safety.god.event.TaskType;
import com.didi.safety.god.http.Card;
import com.didi.safety.god.http.InitConfigResp2;
import com.didi.safety.god.http.SafetyHttp;
import com.didi.safety.god.http.SafetyResponse2;
import com.didi.safety.god.http.SafetyTraceEventHandler;
import com.didi.safety.god.manager.GodManager;
import com.didi.safety.god.manager.SGActivityDelegateHolder;
import com.didi.safety.god.p144ui.DetectionRectBgDrawables;
import com.didi.safety.god.p144ui.GLSurfaceRecorder;
import com.didi.safety.god.p144ui.GLSurfaceRecorder2;
import com.didi.safety.god.p144ui.IDetectionAct;
import com.didi.safety.god.p144ui.NormalDialog;
import com.didi.safety.god.p144ui.SafetyGodProgressFragment;
import com.didi.safety.god.util.AppUtils;
import com.didi.safety.god.util.LogUtils;
import com.didi.safety.god2020.network.GodApi;
import com.didi.safety.god2020.task.DetectionTask;
import com.didi.safety.god2020.task.IDDetectionTask;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.logupload2.LogReporter2;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.omega.sdk.analysis.TrackListener;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.google.gson.Gson;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.safety.god2020.ui.GlobalCardDetectionAct2 */
public class GlobalCardDetectionAct2 extends FragmentActivity implements IDetectionAct {

    /* renamed from: g */
    private static final int f34905g = 100;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public GLSurfaceRecorder f34906a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TaskManager f34907b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Card[] f34908c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f34909d;

    /* renamed from: e */
    private String f34910e;

    /* renamed from: f */
    private ImageView f34911f;

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        Context attachBaseContext = SGActivityDelegateHolder.getActivityDelegate() != null ? SGActivityDelegateHolder.getActivityDelegate().getAttachBaseContext(context) : null;
        if (attachBaseContext != null) {
            context = attachBaseContext;
        }
        super.attachBaseContext(context);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        AppContextHolder.init(this);
        m24648a(getIntent());
        LogUtils.m24578d("current host api is " + SafetyHttp.getApiHost());
        m24655e();
        boolean z = false;
        boolean z2 = true;
        boolean z3 = ContextCompat.checkSelfPermission(this, Permission.CAMERA) == 0;
        if (Build.VERSION.SDK_INT < 18) {
            if (ContextCompat.checkSelfPermission(this, Permission.RECORD_AUDIO) == 0) {
                z = true;
            }
            z2 = z;
        }
        if (!z3 && !z2) {
            ActivityCompat.requestPermissions(this, new String[]{Permission.CAMERA, Permission.RECORD_AUDIO}, 666);
        } else if (!z3) {
            ActivityCompat.requestPermissions(this, new String[]{Permission.CAMERA}, 666);
        } else if (!z2) {
            ActivityCompat.requestPermissions(this, new String[]{Permission.RECORD_AUDIO}, 666);
        } else {
            m24656f();
        }
        BusUtils.register(this);
    }

    /* renamed from: d */
    private void m24654d() {
        OmegaSDK.init(getApplicationContext());
        OmegaSDK.addTrackListener(new TrackListener() {
            public void afterTrackEvent(Event event) {
                SystemUtils.log(6, "OmegaSDK", event.toString(), (Throwable) null, "com.didi.safety.god2020.ui.GlobalCardDetectionAct2$1", 131);
            }
        });
        OmegaSDK.switchUseHttps(true);
        IFXLicenseClient iFXLicenseClient = IFXLicenseClient.getIFXLicenseClient(this);
        iFXLicenseClient.setMaxModelNum(1);
        iFXLicenseClient.setLocationCode(1);
    }

    /* renamed from: e */
    private void m24655e() {
        LogReporter2 logReporter2 = new LogReporter2(SafetyHttp.getFullLogApi());
        logReporter2.setCallerVersion(SafetyHttp.getFullLogApi(), "7.0.0.7");
        GodManager.getInstance().setLogReporter(logReporter2);
    }

    /* renamed from: a */
    private void m24648a(Intent intent) {
        if (intent != null) {
            if (intent.hasExtra("offLineEnv")) {
                String stringExtra = intent.getStringExtra("offLineEnv");
                LogUtils.m24578d("offLineEnv is " + stringExtra);
                SafetyHttp.setOffLineEnv(stringExtra);
            }
            if (intent.hasExtra("debug")) {
                boolean booleanExtra = intent.getBooleanExtra("debug", false);
                LogUtils.m24584i("debug extra===" + booleanExtra);
                LogUtils.m24584i("current debugState is " + booleanExtra);
                SafetyHttp.switchOnOff(booleanExtra);
            } else if (intent.hasExtra(SafetyHttp.ENV_SWITCH_KEY)) {
                int intExtra = intent.getIntExtra(SafetyHttp.ENV_SWITCH_KEY, 0);
                LogUtils.m24584i("doorgodEnv===" + intExtra);
                SafetyHttp.setApiEnv(intExtra);
            }
        }
    }

    /* renamed from: f */
    private void m24656f() {
        SystemUtil.init(getApplicationContext());
        final HashMap hashMap = new HashMap();
        hashMap.put("cmd", "INIT");
        final long currentTimeMillis = System.currentTimeMillis();
        SafetyHttp.initParams2020(getApplication());
        Intent intent = getIntent();
        this.f34909d = intent.getStringExtra("keeperId");
        String stringExtra = intent.getStringExtra("token");
        int intExtra = intent.getIntExtra("bizCode", 0);
        String stringExtra2 = intent.getStringExtra("cardsImgCode");
        this.f34910e = intent.getStringExtra("language");
        GodManager.getInstance().setLanguage(this.f34910e);
        SafetyHttp.setNation(intent.getStringExtra("nation"));
        SafetyHttp.getCommonBodyParams().put("keeperId", this.f34909d);
        SafetyHttp.getCommonBodyParams().put("bizCode", Integer.valueOf(intExtra));
        SafetyHttp.getCommonBodyParams().put("cardsImgCode", stringExtra2);
        SafetyHttp.getCommonBodyParams().put("token", stringExtra);
        LogUtils.m24578d("keeperId===" + this.f34909d + ", bizCode=" + intExtra + ", cardArray=" + stringExtra2);
        if (TextUtils.isEmpty(this.f34909d) || TextUtils.isEmpty(stringExtra2)) {
            ToastHelper.showShortInfo(getApplicationContext(), (int) R.string.params_error);
            hashMap.put(DMWebSocketListener.KEY_ERR_MSG, getString(R.string.params_error));
            SafetyTraceEventHandler.trace(hashMap);
            GodManager.getInstance().callbackOut(108, "调用入参不符合要求", this.f34909d);
            finish();
            return;
        }
        TaskType.initCardsInfo(stringExtra2, this);
        GodManager.getInstance().init(this);
        GodApi.getInstance().fillParams(SafetyHttp.getCommonBodyParams());
        if (GodManager.getInstance().getReturnCallback() == null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("cmd", "INIT_CALLBACK_NULL");
            hashMap2.put("keeperId", this.f34909d);
            hashMap2.put("bizCode", Integer.valueOf(intExtra));
            SafetyTraceEventHandler.trace(hashMap2);
        }
        AppUtils.changeAppBrightness(this, 255);
        final View inflate = getLayoutInflater().inflate(R.layout.safety_detection_pre, (ViewGroup) null);
        final View inflate2 = getLayoutInflater().inflate(R.layout.safety_detection_detect, (ViewGroup) null);
        this.f34906a = new GLSurfaceRecorder2(this, (GLSurfaceView) inflate2.findViewById(R.id.detection_gl_camera_view));
        this.f34907b = new TaskManager(new DetectionTask[0]);
        HashMap hashMap3 = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("language", GodManager.getInstance().getLanguage());
        } catch (JSONException e) {
            LogUtils.logStackTrace(e);
        }
        hashMap3.put("extraJsonObj", jSONObject.toString());
        final SafetyGodProgressFragment safetyGodProgressFragment = new SafetyGodProgressFragment();
        safetyGodProgressFragment.setContent(getString(R.string.GRider_OCR_Loading_rsnT), false);
        safetyGodProgressFragment.show(getSupportFragmentManager(), "loading");
        GodApi.getInstance().getInitConfig2(hashMap3, new RpcService.Callback<SafetyResponse2<InitConfigResp2>>() {
            public void onSuccess(SafetyResponse2<InitConfigResp2> safetyResponse2) {
                InitConfigResp2 initConfigResp2 = (InitConfigResp2) safetyResponse2.data.result;
                int i = safetyResponse2.data.code;
                SafetyHttp.HttpAction httpAction = SafetyHttp.getHttpAction(i);
                LogUtils.m24584i("init2 code===" + i + ", action=" + httpAction);
                hashMap.put("apiCode", Integer.valueOf(i));
                int i2 = C118665.$SwitchMap$com$didi$safety$god$http$SafetyHttp$HttpAction[httpAction.ordinal()];
                if (i2 == 1) {
                    GodManager.Config config = new GodManager.Config();
                    if (initConfigResp2.getCards().length > 0) {
                        Card[] cards = initConfigResp2.getCards();
                        if (initConfigResp2.getDectConf() > 0.0f) {
                            config.dectConf = initConfigResp2.getDectConf();
                        }
                        if (initConfigResp2.getScreenCheckRate() >= 0.0d && initConfigResp2.getScreenCheckRate() <= 1.0d) {
                            config.mScreenCheckRate = initConfigResp2.getScreenCheckRate();
                        }
                        if (initConfigResp2.getDelayedFocusTime() >= 0) {
                            config.delayedFocusTime = initConfigResp2.getDelayedFocusTime();
                        }
                        if (!TextUtils.isEmpty(initConfigResp2.getAppealUrl())) {
                            config.appealUrl = initConfigResp2.getAppealUrl();
                        }
                        config.failCaseSwitch = initConfigResp2.failCaseSwitch;
                        config.successCaseSwitch = initConfigResp2.successCaseSwitch;
                        config.standardLabelTimeoutSwitch = initConfigResp2.standardTimeoutSwitch;
                        config.clearPicProportion = initConfigResp2.getClearPicProportion();
                        GodManager.getInstance().setConfig(config);
                        hashMap.put("code", Integer.valueOf(i));
                        hashMap.put("params", new Gson().toJson((Object) safetyResponse2));
                        doFinish(cards);
                        GlobalCardDetectionAct2.this.m24657g();
                        return;
                    }
                    hashMap.put("code", 2);
                    hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "cards is empty!!!");
                    doFinish((Card[]) null);
                } else if (i2 != 2) {
                    hashMap.put("costTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    hashMap.put("code", Integer.valueOf(i));
                    doFinish((Card[]) null);
                } else {
                    hashMap.put("costTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    hashMap.put("code", Integer.valueOf(i));
                    SafetyTraceEventHandler.trace(hashMap, GlobalCardDetectionAct2.this.getApplicationContext());
                    safetyGodProgressFragment.dismiss();
                    GlobalCardDetectionAct2.this.finish();
                    GodManager.getInstance().callbackOut(110, "init失败", GlobalCardDetectionAct2.this.f34909d);
                }
            }

            public void onFailure(IOException iOException) {
                LogUtils.m24578d("init2 api failed, msg===" + iOException.getMessage());
                LogUtils.logStackTrace(iOException);
                hashMap.put("costTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                hashMap.put("code", 3);
                hashMap.put(DMWebSocketListener.KEY_ERR_MSG, iOException.getMessage());
                doFinish((Card[]) null);
            }

            private void doFinish(Card[] cardArr) {
                Card[] unused = GlobalCardDetectionAct2.this.f34908c = cardArr;
                hashMap.put("costTime", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                SafetyTraceEventHandler.trace(hashMap, GlobalCardDetectionAct2.this.getApplicationContext());
                safetyGodProgressFragment.dismiss();
                if (cardArr == null || cardArr.length == 0) {
                    GodManager.getInstance().callbackOut(110, "init失败", GlobalCardDetectionAct2.this.f34909d);
                    GlobalCardDetectionAct2.this.finish();
                    return;
                }
                for (Card iDDetectionTask : cardArr) {
                    GlobalCardDetectionAct2 globalCardDetectionAct2 = GlobalCardDetectionAct2.this;
                    GlobalCardDetectionAct2.this.f34907b.addTask(new IDDetectionTask(globalCardDetectionAct2, inflate, inflate2, globalCardDetectionAct2.f34906a, iDDetectionTask));
                }
            }
        });
    }

    /* renamed from: com.didi.safety.god2020.ui.GlobalCardDetectionAct2$5 */
    static /* synthetic */ class C118665 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$safety$god$http$SafetyHttp$HttpAction;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.safety.god.http.SafetyHttp$HttpAction[] r0 = com.didi.safety.god.http.SafetyHttp.HttpAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$safety$god$http$SafetyHttp$HttpAction = r0
                com.didi.safety.god.http.SafetyHttp$HttpAction r1 = com.didi.safety.god.http.SafetyHttp.HttpAction.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$safety$god$http$SafetyHttp$HttpAction     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.safety.god.http.SafetyHttp$HttpAction r1 = com.didi.safety.god.http.SafetyHttp.HttpAction.QUIT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god2020.p145ui.GlobalCardDetectionAct2.C118665.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m24657g() {
        runOnUiThread(new Runnable() {
            public void run() {
                GodManager.getInstance().loadModel();
                GlobalCardDetectionAct2.this.f34907b.executeTask();
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        for (int i2 : iArr) {
            if (i2 != 0) {
                ToastHelper.showShortInfo((Context) this, (int) R.string.GRider_OCR_Camera_permissions_jaju);
                GodManager.getInstance().callbackOut(109, "相机不可用", this.f34909d);
                finish();
                return;
            }
        }
        m24656f();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        TaskManager taskManager = this.f34907b;
        if (taskManager != null) {
            taskManager.mo90120h();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        TaskManager taskManager = this.f34907b;
        if (taskManager != null) {
            taskManager.mo90121i();
        }
    }

    public void onBackPressed() {
        TaskManager taskManager = this.f34907b;
        if (taskManager != null && taskManager.isBegin()) {
            this.f34907b.mo90109a();
            this.f34907b.mo90116e();
        }
        mo90100a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo90100a() {
        final NormalDialog normalDialog = new NormalDialog();
        normalDialog.setInfo(getString(R.string.GRider_OCR_Exit_tXaz), getString(R.string.GRider_OCR_It_will_RypI), getString(R.string.GRider_OCR_Re_shooting_bQzB), getString(R.string.GRider_OCR_Exit_tXaz));
        normalDialog.show(this, "showCancelDetectionDialog");
        normalDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (view.getId() == R.id.confirm) {
                    GlobalCardDetectionAct2.this.mo90103c();
                    HashMap hashMap = new HashMap();
                    hashMap.put("cmd", "QUITCANCEL");
                    hashMap.put("collectType", GlobalCardDetectionAct2.this.f34907b != null ? GlobalCardDetectionAct2.this.f34907b.mo90109a() : "");
                    SafetyTraceEventHandler.trace(hashMap);
                    normalDialog.dismiss();
                    return;
                }
                normalDialog.dismiss();
                GlobalCardDetectionAct2.this.mo90102b();
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo90102b() {
        TaskManager taskManager = this.f34907b;
        if (taskManager != null) {
            taskManager.mo90119g();
        }
        finish();
        GodManager.getInstance().callbackOut(100, "Cancel", this.f34909d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo90103c() {
        TaskManager taskManager = this.f34907b;
        if (taskManager != null && taskManager.isBegin()) {
            this.f34907b.mo90118f();
        }
    }

    @Subscribe
    public void onReqFocusEvent(ReqFocusEvent reqFocusEvent) {
        TaskManager taskManager = this.f34907b;
        if (taskManager != null) {
            taskManager.mo90113b();
        }
    }

    @Subscribe
    public void onRestartDetectionEvent(RestartDetectionEvent restartDetectionEvent) {
        TaskManager taskManager = this.f34907b;
        if (taskManager != null) {
            taskManager.mo90114c();
        }
    }

    @Subscribe
    public void onRestartFromBeginningEvent(RestartFromBeginningEvent restartFromBeginningEvent) {
        TaskManager taskManager = this.f34907b;
        if (taskManager != null) {
            taskManager.mo90115d();
        }
    }

    public void pauseDetect() {
        GLSurfaceRecorder gLSurfaceRecorder = this.f34906a;
        if (gLSurfaceRecorder != null) {
            gLSurfaceRecorder.pauseDetect();
        }
    }

    public void resumeDetect() {
        GLSurfaceRecorder gLSurfaceRecorder = this.f34906a;
        if (gLSurfaceRecorder != null) {
            gLSurfaceRecorder.resumeDetect();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        TaskManager taskManager;
        LogUtils.m24578d("reqCode===" + i + ", resultCode=" + i2 + ", data=" + intent);
        if (i2 == -1 && intent != null) {
            Uri data = intent.getData();
            if (i == 100 && (taskManager = this.f34907b) != null) {
                taskManager.mo90110a(data);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BusUtils.unregister(this);
        DetectionRectBgDrawables.clearDrawables();
        TaskManager taskManager = this.f34907b;
        if (taskManager != null) {
            taskManager.onDestroy();
        }
    }
}
