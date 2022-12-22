package com.didichuxing.dfbasesdk.camera2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didichuxing.dfbasesdk.thread.DiSafetyThreadManager;
import com.didichuxing.dfbasesdk.utils.CameraUtils;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.lang.reflect.Field;

public class CameraPermissionAct2 extends FragmentActivity {

    /* renamed from: a */
    private static final String f46544a = "camera_permission_param";

    /* renamed from: b */
    private static final String f46545b = "camera_permission_statement";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static CameraPermissionCallback2 f46546f;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String[] f46547c = {Permission.CAMERA};

    /* renamed from: d */
    private final int f46548d = 1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f46549e;

    /* renamed from: g */
    private Runnable f46550g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f46551h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f46552i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Params f46553j;

    public static class Params {
        public String cameraPermissionInstructions;
        public String cameraPermissionTitle;
        public String dialogNegativeButton;
        public String dialogPositiveButton;
        public String dialogTitle;
    }

    @Deprecated
    public static void start(Context context, String str, CameraPermissionCallback2 cameraPermissionCallback2) {
        f46546f = cameraPermissionCallback2;
        Intent intent = new Intent(context, CameraPermissionAct2.class);
        intent.putExtra(f46545b, str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void start(Context context, Params params, CameraPermissionCallback2 cameraPermissionCallback2) {
        f46546f = cameraPermissionCallback2;
        Intent intent = new Intent(context, CameraPermissionAct2.class);
        intent.putExtra(f46544a, GsonUtils.toJson(params));
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        getWindow().setSoftInputMode(2);
        if (f46546f == null) {
            finish();
            m33392a("mCallback is null");
        } else if (bundle != null) {
            m33392a("savedInstanceState not null");
            f46546f.onActivityRestore();
        } else {
            setContentView((int) R.layout.access_security_camera_permission_layout);
            this.f46549e = findViewById(R.id.note_container);
            if (getIntent().hasExtra(f46544a)) {
                String stringExtra = getIntent().getStringExtra(f46544a);
                if (!TextUtils.isEmpty(stringExtra)) {
                    Params params = (Params) GsonUtils.fromJson(stringExtra, Params.class);
                    this.f46553j = params;
                    if (params != null) {
                        ((TextView) findViewById(R.id.permission_title)).setText(this.f46553j.cameraPermissionTitle);
                        ((TextView) findViewById(R.id.permission_info)).setText(this.f46553j.cameraPermissionInstructions);
                    }
                }
            } else {
                String stringExtra2 = getIntent().getStringExtra(f46545b);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    ((TextView) findViewById(R.id.permission_info)).setText(stringExtra2);
                }
            }
            m33400c();
        }
    }

    public void finish() {
        View view = this.f46549e;
        if (view != null) {
            view.setVisibility(8);
        }
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        DiSafetyThreadManager.getUiHandler().removeCallbacks(this.f46550g);
    }

    /* renamed from: c */
    private void m33400c() {
        this.f46550g = new Runnable() {
            public void run() {
                CameraPermissionAct2.this.f46549e.setVisibility(0);
            }
        };
        DiSafetyThreadManager.getUiHandler().postDelayed(this.f46550g, 400);
        final long currentTimeMillis = System.currentTimeMillis();
        m33391a((Runnable) new Runnable() {
            public void run() {
                if (System.currentTimeMillis() - currentTimeMillis < 500) {
                    DiSafetyThreadManager.getUiHandler().post(new Runnable() {
                        public void run() {
                            long unused = CameraPermissionAct2.this.f46552i = System.currentTimeMillis();
                            ActivityCompat.requestPermissions(CameraPermissionAct2.this, CameraPermissionAct2.this.f46547c, 1);
                        }
                    });
                } else {
                    CameraPermissionAct2.this.m33393a(true);
                }
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            m33391a((Runnable) new Runnable() {
                public void run() {
                    CameraPermissionAct2.this.m33393a(System.currentTimeMillis() - CameraPermissionAct2.this.f46552i > 500);
                }
            });
        }
    }

    /* renamed from: a */
    private void m33391a(final Runnable runnable) {
        final long currentTimeMillis = System.currentTimeMillis();
        DiSafetyThreadManager.getCachedThreadPool().execute(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
                if (com.didichuxing.dfbasesdk.camera2.CameraPermissionAct2.m33394a(r1) == false) goto L_0x0045;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r8 = this;
                    java.lang.System.currentTimeMillis()
                    r0 = 0
                    int r1 = com.didichuxing.dfbasesdk.camera2.CameraPermissionAct2.m33403e()     // Catch:{ all -> 0x001e }
                    android.hardware.Camera r1 = android.hardware.Camera.open(r1)     // Catch:{ all -> 0x001e }
                    if (r1 == 0) goto L_0x001c
                    android.hardware.Camera$Parameters r2 = r1.getParameters()     // Catch:{ all -> 0x001e }
                    r1.setParameters(r2)     // Catch:{ all -> 0x001e }
                    boolean r2 = com.didichuxing.dfbasesdk.camera2.CameraPermissionAct2.m33396b((android.hardware.Camera) r1)     // Catch:{ all -> 0x001e }
                    if (r2 != 0) goto L_0x001c
                    goto L_0x0045
                L_0x001c:
                    r0 = r1
                    goto L_0x0045
                L_0x001e:
                    r1 = move-exception
                    com.didichuxing.dfbasesdk.camera2.CameraPermissionAct2 r2 = com.didichuxing.dfbasesdk.camera2.CameraPermissionAct2.this
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "tryOpenCamera, "
                    r3.append(r4)
                    long r4 = java.lang.System.currentTimeMillis()
                    long r6 = r0
                    long r4 = r4 - r6
                    r3.append(r4)
                    java.lang.String r4 = "ms, "
                    r3.append(r4)
                    r3.append(r1)
                    java.lang.String r1 = r3.toString()
                    r2.m33392a((java.lang.String) r1)
                L_0x0045:
                    if (r0 == 0) goto L_0x0068
                    r0.release()     // Catch:{ all -> 0x004b }
                    goto L_0x0062
                L_0x004b:
                    r0 = move-exception
                    com.didichuxing.dfbasesdk.camera2.CameraPermissionAct2 r1 = com.didichuxing.dfbasesdk.camera2.CameraPermissionAct2.this
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "camera.release()："
                    r2.append(r3)
                    r2.append(r0)
                    java.lang.String r0 = r2.toString()
                    r1.m33392a((java.lang.String) r0)
                L_0x0062:
                    com.didichuxing.dfbasesdk.camera2.CameraPermissionAct2 r0 = com.didichuxing.dfbasesdk.camera2.CameraPermissionAct2.this
                    r0.m33401d()
                    goto L_0x0071
                L_0x0068:
                    android.os.Handler r0 = com.didichuxing.dfbasesdk.thread.DiSafetyThreadManager.getUiHandler()
                    java.lang.Runnable r1 = r5
                    r0.post(r1)
                L_0x0071:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.camera2.CameraPermissionAct2.C152764.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33392a(String str) {
        CameraPermissionCallback2 cameraPermissionCallback2 = f46546f;
        if (cameraPermissionCallback2 != null) {
            cameraPermissionCallback2.onMessage(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m33401d() {
        DiSafetyThreadManager.getUiHandler().removeCallbacks(this.f46550g);
        runOnUiThread(new Runnable() {
            public void run() {
                CameraPermissionAct2.this.finish();
                if (CameraPermissionAct2.f46546f != null) {
                    CameraPermissionAct2.f46546f.onPermissionChanged(true);
                    CameraPermissionCallback2 unused = CameraPermissionAct2.f46546f = null;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33393a(final boolean z) {
        runOnUiThread(new Runnable() {
            public void run() {
                if (z) {
                    CameraPermissionAct2.this.finish();
                    if (CameraPermissionAct2.f46546f != null) {
                        CameraPermissionAct2.f46546f.onPermissionChanged(false);
                        CameraPermissionCallback2 unused = CameraPermissionAct2.f46546f = null;
                        return;
                    }
                    return;
                }
                boolean unused2 = CameraPermissionAct2.this.f46551h = false;
                new AlertDialogFragment.Builder(CameraPermissionAct2.this).setTitle(CameraPermissionAct2.this.f46553j != null ? CameraPermissionAct2.this.f46553j.dialogTitle : CameraPermissionAct2.this.getResources().getString(R.string.access_security_open_camera_permission)).setPositiveButton((CharSequence) CameraPermissionAct2.this.f46553j != null ? CameraPermissionAct2.this.f46553j.dialogPositiveButton : CameraPermissionAct2.this.getResources().getString(R.string.access_security_go_setting), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                    public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                        boolean unused = CameraPermissionAct2.this.f46551h = true;
                        alertDialogFragment.dismiss();
                        if (CameraPermissionAct2.this.f46549e != null) {
                            CameraPermissionAct2.this.f46549e.setVisibility(8);
                        }
                        if (!CameraPermissionAct2.this.m33405f()) {
                            CameraPermissionAct2.this.finish();
                            if (CameraPermissionAct2.f46546f != null) {
                                CameraPermissionAct2.f46546f.onPermissionChanged(false);
                                CameraPermissionCallback2 unused2 = CameraPermissionAct2.f46546f = null;
                            }
                        }
                    }
                }).setPositiveButtonDefault().setNegativeButton((CharSequence) CameraPermissionAct2.this.f46553j != null ? CameraPermissionAct2.this.f46553j.dialogNegativeButton : CameraPermissionAct2.this.getResources().getString(R.string.access_security_cancel), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                    public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                        alertDialogFragment.dismiss();
                        CameraPermissionAct2.this.finish();
                        if (CameraPermissionAct2.f46546f != null) {
                            CameraPermissionAct2.f46546f.onPermissionChanged(false);
                            CameraPermissionCallback2 unused = CameraPermissionAct2.f46546f = null;
                        }
                    }
                }).setCancelable(false).create().show(CameraPermissionAct2.this.getSupportFragmentManager(), "");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static int m33403e() {
        return CameraUtils.hasFacingBackCamera() ^ true ? 1 : 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m33396b(Camera camera) {
        if (camera != null) {
            String lowerCase = WsgSecInfo.model().toLowerCase();
            if (lowerCase.contains("vivo") || lowerCase.contains("oppo")) {
                try {
                    Field declaredField = camera.getClass().getDeclaredField("mHasPermission");
                    declaredField.setAccessible(true);
                    return ((Boolean) declaredField.get(camera)).booleanValue();
                } catch (Exception unused) {
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m33405f() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setFlags(268435456);
            intent.setData(Uri.fromParts("package", WsgSecInfo.packageName(this), (String) null));
            if (intent.resolveActivity(getPackageManager()) == null) {
                return false;
            }
            startActivity(intent);
            return true;
        } catch (Exception e) {
            m33392a("startActivity(ACTION_APPLICATION_DETAILS_SETTINGS)：" + e);
            try {
                Intent intent2 = new Intent("android.settings.SETTINGS");
                intent2.setFlags(268435456);
                if (intent2.resolveActivity(getPackageManager()) == null) {
                    return false;
                }
                startActivity(intent2);
                return true;
            } catch (Exception e2) {
                m33392a("startActivity(ACTION_SETTINGS)：" + e2);
                return false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        if (this.f46551h) {
            this.f46551h = false;
            m33400c();
        }
    }
}
