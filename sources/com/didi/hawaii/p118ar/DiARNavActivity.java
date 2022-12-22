package com.didi.hawaii.p118ar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.hawaii.p118ar.core.AlertUiManager;
import com.didi.hawaii.p118ar.core.CreateDiARNavViewException;
import com.didi.hawaii.p118ar.core.ThemeManager;
import com.didi.hawaii.p118ar.core.p119zg.DiARZGNavActivity;
import com.didi.hawaii.p118ar.jni.DARCNaviType;
import com.didi.hawaii.p118ar.utils.ARCoreCheckerAndGenerator;
import com.didi.hawaii.p118ar.utils.ARNavGlobal;
import com.didi.hawaii.p118ar.utils.AROmega;
import com.didi.hawaii.p118ar.utils.ARSharePref;
import com.didi.hawaii.p118ar.utils.CameraPermissionHelper;
import com.didi.hawaii.p118ar.utils.LocationUtil;
import com.didi.hawaii.p118ar.utils.PermissionHelper;
import com.didi.hawaii.p118ar.view.AlertDialog;
import com.didi.hawaii.p118ar.view.GuideView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.didi.hawaii.ar.DiARNavActivity */
public class DiARNavActivity extends AppCompatActivity implements AlertUiManager.UIListener {
    /* access modifiers changed from: private */
    public static Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static boolean isDriverClick = false;
    private static boolean isStartedActivity = false;
    /* access modifiers changed from: private */
    public static DiARNavActivity myActivity;
    private static long startTime;
    public static NotifyStatusSubscriber subscriber = new NotifyStatusSubscriber() {
        public void onDriverArrived(String str) {
        }

        public void onStatusChange(final int i) {
            DiARNavActivity.handler.post(new Runnable() {
                public void run() {
                    if (DiARNavActivity.myActivity != null) {
                        String string = DiARNavActivity.myActivity.getString(R.string.dirver_cacle);
                        int i = i;
                        if (i == 2) {
                            string = DiARNavActivity.myActivity.getString(R.string.driver_money);
                            AROmega.arNavDriverClick();
                            boolean unused = DiARNavActivity.isDriverClick = true;
                        } else if (i == 3) {
                            string = DiARNavActivity.myActivity.getString(R.string.driver_exception);
                        }
                        if (DiARNavActivity.myActivity != null) {
                            if (DiARNavActivity.myActivity.diDiAR != null) {
                                DiARNavActivity.myActivity.diDiAR.exitOfOrderCancell();
                            }
                            DiARNavActivity.myActivity.alertDialog.builder(1).setMsg(string).setPositiveButton(DiARNavActivity.myActivity.getString(R.string.i_konw), new View.OnClickListener() {
                                public void onClick(View view) {
                                    AutoTrackHelper.trackViewOnClick(view);
                                    DiARNavActivity.myActivity.finish();
                                }
                            }).setCancelable(false).show();
                        }
                    }
                }
            });
        }
    };
    /* access modifiers changed from: private */
    public AlertDialog alertDialog;
    private DiARNavView arNavView;
    /* access modifiers changed from: private */
    public DiDiAR diDiAR = null;
    /* access modifiers changed from: private */
    public Timer timer = new Timer();
    private boolean verifyPosition = false;

    /* renamed from: com.didi.hawaii.ar.DiARNavActivity$NotifyStatusSubscriber */
    public interface NotifyStatusSubscriber {
        public static final int ORDER_CANCELL = 1;
        public static final int ORDER_EXCEPTION_HAPPEN = 3;
        public static final int ORDER_GET_PASSENGER = 2;

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: com.didi.hawaii.ar.DiARNavActivity$NotifyStatusSubscriber$notifyStatus */
        public @interface notifyStatus {
        }

        void onDriverArrived(String str);

        void onStatusChange(int i);
    }

    public void onLocationSuccess() {
    }

    public void onLocationing() {
    }

    public static NotifyStatusSubscriber startARNavActivity(Context context) {
        Class<DiARNavActivity> cls = DiARNavActivity.class;
        synchronized (cls) {
            if (!isStartedActivity) {
                if (!DiARZGNavActivity.isStartedActivity()) {
                    DARCNaviType dARCNaviType = DARCNaviType.DARCNaviTypeAR;
                    if (ARCoreCheckerAndGenerator.cacheResponseData.getcResData() != null) {
                        dARCNaviType = ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getEntranceType();
                    }
                    DLog.m7384d(HistoryRecordFragment.COUNTRY_CODE_AR, "startActivity entranceType:" + dARCNaviType.swigValue(), new Object[0]);
                    if (dARCNaviType == DARCNaviType.DARCNaviTypeARDirection) {
                        subscriber = DiARZGNavActivity.startDiARZGNavActivity(context);
                    } else if (dARCNaviType == DARCNaviType.DARCNaviTypeAR) {
                        Intent intent = new Intent(context, cls);
                        if (!(context instanceof Activity)) {
                            intent.setFlags(268435456);
                        }
                        context.startActivity(intent);
                        isStartedActivity = true;
                        startTime = System.currentTimeMillis();
                        isDriverClick = false;
                        DLog.m7384d(HistoryRecordFragment.COUNTRY_CODE_AR, "startARActivity", new Object[0]);
                    }
                    if (dARCNaviType != null) {
                        AROmega.zgMapARNavTypeOn(dARCNaviType.swigValue());
                    }
                    NotifyStatusSubscriber notifyStatusSubscriber = subscriber;
                    return notifyStatusSubscriber;
                }
            }
            DLog.m7384d(HistoryRecordFragment.COUNTRY_CODE_AR, "startActivity ARNavStarted:" + isStartedActivity + " ZGARNavStarted:" + DiARZGNavActivity.isStartedActivity(), new Object[0]);
            NotifyStatusSubscriber notifyStatusSubscriber2 = subscriber;
            return notifyStatusSubscriber2;
        }
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        try {
            ARNavGlobal.init(this);
            DiARNavView diARNavView = new DiARNavView(this);
            this.arNavView = diARNavView;
            setContentView((View) diARNavView);
            DiDiAR diAR = this.arNavView.getDiAR();
            this.diDiAR = diAR;
            diAR.setUiManagerListener(this);
            init();
            myActivity = this;
        } catch (CreateDiARNavViewException unused) {
            finish();
        }
    }

    private void init() {
        this.alertDialog = new AlertDialog(this);
        fullscreenActivity();
        verifyPositionAlert();
        this.timer.schedule(new TimerTask() {
            public void run() {
                float distanceOfEnd = DiARNavActivity.this.diDiAR != null ? DiARNavActivity.this.diDiAR.distanceOfEnd() : -1.0f;
                if (distanceOfEnd >= 0.0f && distanceOfEnd <= 50.0f) {
                    AROmega.arNavNavigation50exit();
                    if (DiARNavActivity.this.timer != null) {
                        DiARNavActivity.this.timer.cancel();
                        Timer unused = DiARNavActivity.this.timer = null;
                    }
                }
            }
        }, 1000, 1000);
        ThemeManager.getInstance().init(this, ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption() != null ? ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption().getScene() : 0);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        DiDiAR diDiAR2;
        super.onResume();
        if (!PermissionHelper.hasCameraPermission(this)) {
            PermissionHelper.requestCameraPermission(this);
        } else if (!PermissionHelper.hasStoragePerssion(this) && PermissionHelper.requestStoragePermissions(this)) {
        } else {
            if ((PermissionHelper.hasLocationPerssion(this) || !PermissionHelper.requestLocationPermissions(this)) && (diDiAR2 = this.diDiAR) != null) {
                diDiAR2.onResume();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        DiDiAR diDiAR2 = this.diDiAR;
        if (diDiAR2 != null) {
            diDiAR2.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        DiDiAR diDiAR2 = this.diDiAR;
        if (diDiAR2 != null) {
            diDiAR2.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        DiDiAR diDiAR2 = this.diDiAR;
        if (diDiAR2 != null) {
            diDiAR2.onRestart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        DiDiAR diDiAR2 = this.diDiAR;
        if (diDiAR2 != null) {
            diDiAR2.onStop();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        myActivity = null;
        DiDiAR diDiAR2 = this.diDiAR;
        if (diDiAR2 != null) {
            diDiAR2.onDestroy();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0 && !CameraPermissionHelper.hasCameraPermission(this)) {
            finish();
        }
    }

    public void onFinishBtnClick() {
        exitAlertDialogShow();
    }

    public void onHelpBtnClick() {
        this.alertDialog.builder(3).setTitle(getString(R.string.use_introduct)).setMsg(ARNavGlobal.helpText).setPositiveButton(getString(R.string.i_konw), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiARNavActivity.this.disMissDialog();
            }
        }).setCancelable(false).show();
    }

    public void onBatteryStateLower() {
        this.alertDialog.builder(1).setCancelable(false).setMsg(getString(R.string.power_notenough)).setPositiveButton(getString(R.string.i_continue), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiARNavActivity.this.disMissDialog();
            }
        }).setNegativeButton(getString(R.string.i_quite), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiARNavActivity.this.finish();
            }
        });
        this.alertDialog.show();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onALertFromSDK(com.didi.hawaii.p118ar.core.AlertUiManager.ALertContent r11, final com.didi.hawaii.p118ar.core.AlertUiManager.HandleButton r12) {
        /*
            r10 = this;
            java.lang.String r0 = r11.title
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x000c
            r0 = 1
            goto L_0x000d
        L_0x000c:
            r0 = 2
        L_0x000d:
            com.didi.hawaii.ar.view.AlertDialog r3 = r10.alertDialog
            com.didi.hawaii.ar.view.AlertDialog r0 = r3.builder(r0)
            java.lang.String r3 = r11.title
            com.didi.hawaii.ar.view.AlertDialog r0 = r0.setTitle(r3)
            java.lang.String r3 = r11.msg
            com.didi.hawaii.ar.view.AlertDialog r0 = r0.setMsg(r3)
            r10.alertDialog = r0
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r11.buttons
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r3 = 0
            r4 = 0
        L_0x002d:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x00b6
            java.lang.Object r5 = r0.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getValue()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "@"
            java.lang.String[] r6 = r6.split(r7)
            if (r6 == 0) goto L_0x00b2
            int r7 = r6.length
            if (r7 == r1) goto L_0x004b
            goto L_0x00b2
        L_0x004b:
            r7 = r6[r3]
            r6 = r6[r2]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x008a }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x008a }
            if (r8 <= 0) goto L_0x008b
            com.didi.hawaii.ar.view.AlertDialog r8 = r10.alertDialog     // Catch:{ Exception -> 0x008a }
            r9 = 4
            com.didi.hawaii.ar.view.AlertDialog r8 = r8.builder(r9)     // Catch:{ Exception -> 0x008a }
            java.lang.String r9 = r11.title     // Catch:{ Exception -> 0x008a }
            com.didi.hawaii.ar.view.AlertDialog r8 = r8.setTitle(r9)     // Catch:{ Exception -> 0x008a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x008a }
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x008a }
            com.didi.hawaii.ar.view.AlertDialog r6 = r8.setCountDownTime(r6)     // Catch:{ Exception -> 0x008a }
            java.lang.String r8 = r11.msg     // Catch:{ Exception -> 0x008a }
            com.didi.hawaii.ar.view.AlertDialog r6 = r6.setMsg(r8)     // Catch:{ Exception -> 0x008a }
            java.lang.Object r8 = r5.getKey()     // Catch:{ Exception -> 0x008a }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x008a }
            com.didi.hawaii.ar.DiARNavActivity$5 r9 = new com.didi.hawaii.ar.DiARNavActivity$5     // Catch:{ Exception -> 0x008a }
            r9.<init>(r7, r12, r4)     // Catch:{ Exception -> 0x008a }
            com.didi.hawaii.ar.view.AlertDialog r6 = r6.setPositiveButton(r8, r9)     // Catch:{ Exception -> 0x008a }
            r10.alertDialog = r6     // Catch:{ Exception -> 0x008a }
            goto L_0x00b6
        L_0x008a:
        L_0x008b:
            if (r4 != 0) goto L_0x009e
            com.didi.hawaii.ar.view.AlertDialog r6 = r10.alertDialog
            java.lang.Object r5 = r5.getKey()
            java.lang.String r5 = (java.lang.String) r5
            com.didi.hawaii.ar.DiARNavActivity$6 r8 = new com.didi.hawaii.ar.DiARNavActivity$6
            r8.<init>(r7, r12, r4)
            r6.setNegativeButton(r5, r8)
            goto L_0x00ae
        L_0x009e:
            com.didi.hawaii.ar.view.AlertDialog r6 = r10.alertDialog
            java.lang.Object r5 = r5.getKey()
            java.lang.String r5 = (java.lang.String) r5
            com.didi.hawaii.ar.DiARNavActivity$7 r8 = new com.didi.hawaii.ar.DiARNavActivity$7
            r8.<init>(r7, r12, r4)
            r6.setPositiveButton(r5, r8)
        L_0x00ae:
            int r4 = r4 + 1
            goto L_0x002d
        L_0x00b2:
            r10.disMissDialog()
            return
        L_0x00b6:
            com.didi.hawaii.ar.view.AlertDialog r11 = r10.alertDialog
            com.didi.hawaii.ar.view.AlertDialog r11 = r11.setCancelable(r3)
            r11.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.DiARNavActivity.onALertFromSDK(com.didi.hawaii.ar.core.AlertUiManager$ALertContent, com.didi.hawaii.ar.core.AlertUiManager$HandleButton):void");
    }

    public void onALertReachDestination(String str) {
        AROmega.arNavEndShowend();
        if (TextUtils.isEmpty(str)) {
            str = ThemeManager.getInstance().getThemeString(R.string.arrival);
        }
        this.alertDialog.builder(1).setMsg(str).setPositiveButton(getString(R.string.i_konw), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AROmega.arNavEndClick();
                DiARNavActivity.this.finish();
            }
        }).setCancelable(false).show();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        fullscreenActivity();
    }

    private void fullscreenActivity() {
        getWindow().getDecorView().setSystemUiVisibility(4866);
        getWindow().addFlags(128);
    }

    /* access modifiers changed from: private */
    public void disMissDialog() {
        DiDiAR diDiAR2 = this.diDiAR;
        if (diDiAR2 != null) {
            diDiAR2.recoveryARUI();
        }
    }

    private void showGuideView() {
        AROmega.arNavGuide();
        new GuideView(this, this.arNavView).builder().setCanclebleOutside(false).setDisMissListener(new GuideView.OnGuideViewDissMissListener() {
            public void onDisMiss() {
                DiARNavActivity.this.diDiAR.startAR();
                DiARNavActivity.this.disMissDialog();
            }
        }).show();
    }

    private void verifyPositionAlert() {
        if (!TextUtils.isEmpty(ARNavGlobal.alertMessage)) {
            AROmega.requestLocation();
            this.alertDialog.builder(2).setCancelable(false).setMsg(ARNavGlobal.alertMessage).setTitle(getString(R.string.use_alert)).setPositiveButton(getString(R.string.i_konw), new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    AROmega.requestLocationClickyes();
                    DiARNavActivity.this.startWithGuide();
                }
            }).show();
            return;
        }
        startWithGuide();
    }

    /* access modifiers changed from: private */
    public void startWithGuide() {
        this.verifyPosition = true;
        if (ARSharePref.getGuideShowTimes() < 3) {
            showGuideView();
            ARSharePref.guideShowTimesIncrement();
            return;
        }
        this.diDiAR.startAR();
        disMissDialog();
    }

    public void onBackPressed() {
        DiDiAR diDiAR2 = this.diDiAR;
        if (diDiAR2 != null) {
            diDiAR2.hideARNavUI();
        }
        exitAlertDialogShow();
    }

    public void finish() {
        isStartedActivity = false;
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer = null;
        }
        myActivity = null;
        AROmega.arNav_UseTime(((float) (System.currentTimeMillis() - startTime)) / 1000.0f);
        DiDiAR diDiAR2 = this.diDiAR;
        float distanceOfEnd = diDiAR2 != null ? diDiAR2.distanceOfEnd() : -1.0f;
        int i = (distanceOfEnd > 0.0f ? 1 : (distanceOfEnd == 0.0f ? 0 : -1));
        if (i >= 0 && distanceOfEnd <= 50.0f) {
            AROmega.arNavNavigation50exit();
        }
        if (ARNavGlobal.firstLocationSuccessTime != 0) {
            AROmega.arNavLocationTuretimeduration(((float) (System.currentTimeMillis() - ARNavGlobal.firstLocationSuccessTime)) / 1000.0f);
        }
        if (isDriverClick || (i >= 0 && distanceOfEnd <= 20.0f)) {
            AROmega.arNavNormalExit();
        } else {
            AROmega.arNavYcExit();
        }
        DiDiAR diDiAR3 = this.diDiAR;
        if (diDiAR3 != null) {
            float[] currentLocationInModle = diDiAR3.getCurrentLocationInModle();
            String format = (currentLocationInModle == null || currentLocationInModle.length != 4) ? "" : String.format("index= %f , x = %f ,y = %f , z = %f", new Object[]{Float.valueOf(currentLocationInModle[0]), Float.valueOf(currentLocationInModle[1]), Float.valueOf(currentLocationInModle[2]), Float.valueOf(currentLocationInModle[3])});
            int curARStatus = this.diDiAR.getCurARStatus();
            if (curARStatus == 0) {
                AROmega.arNavLocationExit(new LatLng(LocationUtil.getCurLocation().latitude, LocationUtil.getCurLocation().longitude), format);
            } else if (curARStatus == 1 || curARStatus == 2) {
                AROmega.arNavNavigationExit(new LatLng(LocationUtil.getCurLocation().latitude, LocationUtil.getCurLocation().longitude), format);
            }
        }
        ARCoreCheckerAndGenerator.clearCache();
        ThemeManager.getInstance().reset();
        super.finish();
    }

    private void exitAlertDialogShow() {
        AROmega.arNavBackClick();
        this.alertDialog.builder(1).setMsg(getString(R.string.quite_nav)).setNegativeButton(getString(R.string.i_cancle), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiARNavActivity.this.disMissDialog();
            }
        }).setPositiveButton(getString(R.string.i_can), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiARNavActivity.this.finish();
            }
        }).setCancelable(false);
        this.alertDialog.show();
    }
}
