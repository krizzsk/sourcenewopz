package com.didi.hawaii.p118ar.core.p119zg;

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
import com.didi.common.map.util.DLog;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.hawaii.p118ar.DiARNavActivity;
import com.didi.hawaii.p118ar.core.CreateDiARNavViewException;
import com.didi.hawaii.p118ar.utils.ARCoreCheckerAndGenerator;
import com.didi.hawaii.p118ar.utils.ARNavGlobal;
import com.didi.hawaii.p118ar.utils.AROmega;
import com.didi.hawaii.p118ar.utils.PermissionHelper;
import com.didi.hawaii.p118ar.view.AlertDialog;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.core.zg.DiARZGNavActivity */
public class DiARZGNavActivity extends AppCompatActivity implements ZGUIListener {

    /* renamed from: a */
    private static long f23106a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static DiARZGNavActivity f23107b = null;

    /* renamed from: c */
    private static boolean f23108c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Handler f23109d = new Handler(Looper.getMainLooper());
    public static DiARNavActivity.NotifyStatusSubscriber subscriber = new DiARNavActivity.NotifyStatusSubscriber() {
        public void onStatusChange(final int i) {
            DiARZGNavActivity.f23109d.post(new Runnable() {
                public void run() {
                    if (DiARZGNavActivity.f23107b != null) {
                        DLog.m7384d("ZGNotifySubscriber", "type:" + i, new Object[0]);
                        String string = DiARZGNavActivity.f23107b.getString(R.string.driver_exception);
                        int i = i;
                        if (i == 1) {
                            string = DiARZGNavActivity.f23107b.getString(R.string.GRider_guide_Trips_have_XmYI);
                        } else if (i == 2) {
                            string = DiARZGNavActivity.f23107b.getString(R.string.GRider_guide_The_driver_Xheq);
                        }
                        DiARZGNavActivity.f23107b.onOrderStateChange(string);
                    }
                }
            });
        }

        public void onDriverArrived(final String str) {
            DiARZGNavActivity.f23109d.post(new Runnable() {
                public void run() {
                    DLog.m7384d("onDriverArrived", "msg:" + str, new Object[0]);
                    if (DiARZGNavActivity.f23107b != null) {
                        DiARZGNavActivity.f23107b.onDriverArrived(str);
                    }
                }
            });
        }
    };

    /* renamed from: e */
    private AlertDialog f23110e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DiARZGNavView f23111f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f23112g = false;

    /* renamed from: h */
    private boolean f23113h = false;

    /* renamed from: i */
    private boolean f23114i = false;

    public static boolean isStartedActivity() {
        return f23108c;
    }

    public static DiARNavActivity.NotifyStatusSubscriber startDiARZGNavActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (f23108c) {
            DLog.m7384d("AR-ZG", "ZGARNavStarted:" + f23108c + " actvitiy:" + f23107b, new Object[0]);
            return subscriber;
        }
        Intent intent = new Intent(context, DiARZGNavActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
        f23108c = true;
        f23106a = System.currentTimeMillis();
        DLog.m7384d("AR-ZG", "startZGARActivity", new Object[0]);
        return subscriber;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        SystemUtils.log(4, "zgdebug", NachoLifecycleManager.LIFECYCLE_ON_CREATE, (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 123);
        super.onCreate(bundle);
        m16603d();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        SystemUtils.log(4, "zgdebug", "onResume", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 132);
        super.onResume();
        if (!this.f23112g && !this.f23114i && !PermissionHelper.hasCameraPermission(this)) {
            PermissionHelper.requestCameraPermission(this);
        } else if (!PermissionHelper.hasStoragePerssion(this) && PermissionHelper.requestStoragePermissions(this)) {
        } else {
            if (PermissionHelper.hasLocationPerssion(this) || !PermissionHelper.requestLocationPermissions(this)) {
                if (PermissionHelper.hasCameraPermission(this)) {
                    DiARZGNavView diARZGNavView = this.f23111f;
                    if (diARZGNavView != null) {
                        diARZGNavView.openCamera();
                    }
                    if (this.f23113h) {
                        DiARZGNavView diARZGNavView2 = this.f23111f;
                        if (diARZGNavView2 != null) {
                            diARZGNavView2.activeZGNav();
                        }
                    } else {
                        alertSafeDialog(ARNavGlobal.zgAlertMessage);
                    }
                }
                DiARZGNavView diARZGNavView3 = this.f23111f;
                if (diARZGNavView3 != null) {
                    diARZGNavView3.onResume();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        SystemUtils.log(4, "zgdebug", "onPause", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 172);
        super.onPause();
        DiARZGNavView diARZGNavView = this.f23111f;
        if (diARZGNavView != null) {
            diARZGNavView.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        SystemUtils.log(4, "zgdebug", "onStart", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 184);
        super.onStart();
        DiARZGNavView diARZGNavView = this.f23111f;
        if (diARZGNavView != null) {
            diARZGNavView.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        SystemUtils.log(4, "zgdebug", "onRestart", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 196);
        super.onRestart();
        DiARZGNavView diARZGNavView = this.f23111f;
        if (diARZGNavView != null) {
            diARZGNavView.onRestart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        SystemUtils.log(4, "zgdebug", "onStop", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 208);
        super.onStop();
        DiARZGNavView diARZGNavView = this.f23111f;
        if (diARZGNavView != null) {
            diARZGNavView.onStop();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        DLog.m7384d("AR-ZG", "onDestroy zgActivityStarted:" + f23108c, new Object[0]);
        SystemUtils.log(4, "zgdebug", NachoLifecycleManager.LIFECYCLE_ON_DESTROY, (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 222);
        super.onDestroy();
        DiARZGNavView diARZGNavView = this.f23111f;
        if (diARZGNavView != null) {
            diARZGNavView.onDestroy();
            this.f23111f = null;
        }
        AlertDialog alertDialog = this.f23110e;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f23110e.dismiss();
            DLog.m7384d("AR-ZG", "onDestroy dismiss Dialog", new Object[0]);
        }
        f23108c = false;
        f23107b = null;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0 && !PermissionHelper.hasCameraPermission(this)) {
            AROmega.zgMapARNavDirectAuthorizeCam();
            if (!this.f23112g && !this.f23114i) {
                m16604e();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        SystemUtils.log(4, "zgdebug", "onRestoreInstanceState", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 254);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        SystemUtils.log(4, "zgdebug", "onSaveInstanceState", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 261);
    }

    public void finish() {
        DLog.m7384d("AR-ZG", "finish zgActivityStarted:" + f23108c, new Object[0]);
        SystemUtils.log(4, "zgdebug", XPanelScene.SCENE_FINISH, (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 269);
        DiARZGNavView diARZGNavView = this.f23111f;
        if (diARZGNavView != null) {
            diARZGNavView.onPause();
        }
        AROmega.zgMapARNavDirectUseSeconds(((float) (System.currentTimeMillis() - f23106a)) / 1000.0f);
        ARCoreCheckerAndGenerator.clearCache();
        ZGThemeManager.getInstance().reset();
        super.finish();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m16602c();
    }

    /* renamed from: c */
    private void m16602c() {
        getWindow().getDecorView().setSystemUiVisibility(4866);
        getWindow().addFlags(128);
    }

    /* renamed from: d */
    private void m16603d() {
        try {
            ARNavGlobal.init(this);
            AROmega.setMapVendor(this);
            m16602c();
            this.f23110e = new AlertDialog(this);
            DiARZGNavView diARZGNavView = new DiARZGNavView(this);
            this.f23111f = diARZGNavView;
            setContentView((View) diARZGNavView);
            this.f23111f.setUiManagerListener(this);
            ZGThemeManager.getInstance().init(this, ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption() != null ? ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption().getScene() : 0);
            f23107b = this;
            f23108c = true;
            DLog.m7384d("AR-ZG", "initZG", new Object[0]);
        } catch (CreateDiARNavViewException unused) {
            DLog.m7384d("AR-ZG", "initZG CreateDiARNavViewException", new Object[0]);
            finish();
        }
    }

    /* renamed from: e */
    private void m16604e() {
        this.f23110e.builder(1).setMsg(getString(R.string.GRider_guide_Open_camera_dUdA)).setNegativeButton(getString(R.string.GRider_guide_Not_set_fOSr), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiARZGNavActivity.this.finish();
            }
        }).setPositiveButton(getString(R.string.GRider_guide_Go_Settings_yMQQ), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean unused = DiARZGNavActivity.this.f23112g = false;
                PermissionHelper.launchPermissionSettings(DiARZGNavActivity.this);
            }
        }).setCancelable(false);
        this.f23110e.show();
        this.f23112g = true;
    }

    public void alertSafeDialog(String str) {
        if (TextUtils.isEmpty(str)) {
            AROmega.zgMapARNavResDataError();
        }
        this.f23110e.builder(2).setTitle(getString(R.string.GRider_guide_Safety_Tips_Zwle)).setMsg(str).setPositiveButton(getString(R.string.GRider_guide_I_see_YCKe), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (DiARZGNavActivity.this.f23111f != null) {
                    DiARZGNavActivity.this.f23111f.activeZGNav();
                }
            }
        }).setCancelable(false).show();
        this.f23113h = true;
        AROmega.zgMapARNavDirectWarning();
    }

    /* renamed from: f */
    private void m16605f() {
        this.f23114i = true;
        DiARZGNavView diARZGNavView = this.f23111f;
        if (diARZGNavView != null) {
            diARZGNavView.setUiManagerListener((ZGUIListener) null);
        }
    }

    public void onOrderStateChange(String str) {
        this.f23110e.builder(1).setMsg(str).setPositiveButton(getString(R.string.GRider_guide_Exit_Navigation_xQcr), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiARZGNavActivity.this.finish();
            }
        }).setCancelable(false).show();
        m16605f();
    }

    public void onDriverArrived(String str) {
        DiARZGNavView diARZGNavView = this.f23111f;
        if (diARZGNavView != null) {
            diARZGNavView.onDriverArrived(str);
        }
    }

    public void onBackPressed() {
        onFinishBtnClick();
    }

    public void onFinishBtnClick() {
        this.f23110e.builder(1).setMsg(getString(R.string.GRider_guide_Are_you_BPIy)).setNegativeButton(getString(R.string.GRider_guide_Cancel_XIbT), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        }).setPositiveButton(getString(R.string.GRider_guide_Determination_KSWw), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AROmega.zgMapARNavDirectBack();
                DiARZGNavActivity.this.finish();
            }
        }).setCancelable(false);
        this.f23110e.show();
    }

    public void onHelpBtnClick() {
        this.f23110e.builder(3).setTitle(getString(R.string.use_introduct)).setMsg(ARNavGlobal.zgHelpText).setPositiveButton(getString(R.string.GRider_guide_Got_it_XtfI), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        }).setCancelable(true).show();
    }

    public void onReachDestination() {
        this.f23110e.builder(1).setCancelable(false).setMsg(ZGThemeManager.getInstance().getThemeString(R.string.GRider_guide_Arrive_near_eIRX)).setPositiveButton(getString(R.string.GRider_guide_Exit_Navigation_xQcr), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiARZGNavActivity.this.finish();
            }
        });
        this.f23110e.show();
        m16605f();
    }
}
