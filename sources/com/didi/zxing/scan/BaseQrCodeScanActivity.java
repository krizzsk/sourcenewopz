package com.didi.zxing.scan;

import android.app.AlertDialog;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.ActivityCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.IntentUtil;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.dqr.ResultPoint;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.security.wireless.ISecurityConf;
import com.didi.zxing.barcodescanner.BarcodeCallback;
import com.didi.zxing.barcodescanner.BarcodeResult;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.didi.zxing.barcodescanner.CaptureManager;
import com.didi.zxing.barcodescanner.DecoratedBarcodeView;
import com.didi.zxing.barcodescanner.ViewfinderView;
import com.didi.zxing.scan.callback.IQrCodeOperation;
import com.didi.zxing.scan.util.ActivityCompatUtils;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.List;
import java.util.UUID;

public abstract class BaseQrCodeScanActivity extends TheOneBaseActivity implements IQrCodeOperation.IBarcodeCallback, IQrCodeOperation.IScannerLoadingView, IQrCodeOperation.ITorchStateChangedListener {
    public static final int REQUEST_CODE_CAMERA_PERMISSION = 1008;

    /* renamed from: e */
    private static final float f45494e = 40.0f;

    /* renamed from: a */
    private Logger f45495a = LoggerFactory.getLogger("BaseQrCodeScanActivity");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f45496b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DecoratedBarcodeView f45497c;

    /* renamed from: d */
    private Sensor f45498d;

    /* renamed from: f */
    private AlertDialog f45499f;

    /* renamed from: g */
    private AlertDialogFragment f45500g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f45501h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f45502i;

    /* renamed from: j */
    private SensorManager f45503j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f45504k;

    /* renamed from: l */
    private SensorEventListener f45505l = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.values[0] <= 40.0f && !BaseQrCodeScanActivity.this.f45501h && !BaseQrCodeScanActivity.this.f45502i) {
                BaseQrCodeScanActivity.this.f45497c.setTorchOn();
                boolean unused = BaseQrCodeScanActivity.this.f45501h = true;
            }
        }
    };
    protected CaptureManager mCaptureManager;
    protected View mLoadingView;
    protected ViewfinderView mViewFinderView;

    /* access modifiers changed from: protected */
    public abstract int getCustomLayoutResId();

    /* access modifiers changed from: protected */
    public int getRootLayoutResId() {
        return R.layout.a_qr_code_scan;
    }

    public int getScannerLoadingResId() {
        return R.layout.zxing_qr_code_loading;
    }

    /* access modifiers changed from: protected */
    public abstract void initCustomView();

    /* access modifiers changed from: protected */
    public boolean isAutoLight() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        AnalysisManager.setSessionId(UUID.randomUUID().toString());
        setContentView(getRootLayoutResId());
        m32629b();
        m32632c();
    }

    /* renamed from: a */
    private void m32627a() {
        if (PermissionUtil.checkPermissionAllGranted(getApplicationContext(), new String[]{Permission.CAMERA})) {
            this.f45504k = true;
            CaptureManager captureManager = this.mCaptureManager;
            if (captureManager != null) {
                captureManager.onResume();
                return;
            }
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{Permission.CAMERA}, 1008);
    }

    /* renamed from: b */
    private void m32629b() {
        LayoutInflater layoutInflater = getLayoutInflater();
        if (getCustomLayoutResId() != 0) {
            layoutInflater.inflate(getCustomLayoutResId(), (ViewGroup) findViewById(R.id.qr_code_custom_view));
        }
        layoutInflater.inflate(getScannerLoadingResId(), (ViewGroup) findViewById(R.id.zxing_barcode_loading));
        DecoratedBarcodeView decoratedBarcodeView = (DecoratedBarcodeView) findViewById(R.id.bv_scanner_container);
        this.f45497c = decoratedBarcodeView;
        decoratedBarcodeView.setTorchListener(new DecoratedBarcodeView.TorchListener() {
            public void onTorchOn() {
                boolean unused = BaseQrCodeScanActivity.this.f45501h = true;
                BaseQrCodeScanActivity.this.onTorchStateChanged(true);
            }

            public void onTorchOff() {
                boolean unused = BaseQrCodeScanActivity.this.f45501h = false;
                BaseQrCodeScanActivity.this.onTorchStateChanged(false);
            }
        });
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
        this.mViewFinderView = viewfinderView;
        viewfinderView.setAnimeFlag(false);
        initScannerLoading();
        initCustomView();
    }

    /* renamed from: c */
    private void m32632c() {
        CaptureManager captureManager = new CaptureManager(this, this.f45497c);
        this.mCaptureManager = captureManager;
        captureManager.decodeContinuous(new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(BarcodeResult barcodeResult) {
                if (BaseQrCodeScanActivity.this.mCaptureManager != null) {
                    BaseQrCodeScanActivity.this.mCaptureManager.onPauseWhioutWait();
                }
                BaseQrCodeScanActivity.this.onBarCodeResult(barcodeResult);
            }
        });
        this.mCaptureManager.addStateListener(new CameraPreview.StateListener() {
            public void cameraClosed() {
            }

            public void previewSized() {
            }

            public void previewStarted() {
                BaseQrCodeScanActivity.this.hideScannerLoading();
                BaseQrCodeScanActivity.this.mViewFinderView.setAnimeFlag(true);
            }

            public void previewStopped() {
                BaseQrCodeScanActivity.this.mViewFinderView.setAnimeFlag(false);
            }

            public void cameraError(Exception exc) {
                BaseQrCodeScanActivity.this.f45496b.postDelayed(new Runnable() {
                    public void run() {
                        if (BaseQrCodeScanActivity.this.mCaptureManager != null) {
                            BaseQrCodeScanActivity.this.mCaptureManager.onResume();
                        }
                    }
                }, 2000);
                exc.printStackTrace();
            }
        });
        m32635d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011 A[SYNTHETIC, Splitter:B:10:0x0011] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isCameraCanUse() {
        /*
            android.hardware.Camera r0 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x000d }
            android.hardware.Camera$Parameters r1 = r0.getParameters()     // Catch:{ Exception -> 0x000e }
            r0.setParameters(r1)     // Catch:{ Exception -> 0x000e }
            r1 = 1
            goto L_0x000f
        L_0x000d:
            r0 = 0
        L_0x000e:
            r1 = 0
        L_0x000f:
            if (r0 == 0) goto L_0x0019
            r0.release()     // Catch:{ Exception -> 0x0015 }
            goto L_0x0019
        L_0x0015:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.zxing.scan.BaseQrCodeScanActivity.isCameraCanUse():boolean");
    }

    /* renamed from: d */
    private void m32635d() {
        if (isAutoLight()) {
            SensorManager sensorManager = (SensorManager) getApplicationContext().getSystemService(ISecurityConf.KEY_SENSOR);
            this.f45503j = sensorManager;
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f45498d = defaultSensor;
            if (defaultSensor != null) {
                this.f45503j.registerListener(this.f45505l, defaultSensor, 3);
            }
        }
    }

    /* renamed from: e */
    private void m32636e() {
        if (this.f45498d != null) {
            if (this.f45503j == null) {
                this.f45503j = (SensorManager) getApplicationContext().getSystemService(ISecurityConf.KEY_SENSOR);
            }
            this.f45503j.unregisterListener(this.f45505l);
            this.f45498d = null;
            this.f45502i = false;
        }
    }

    public void initScannerLoading() {
        this.mLoadingView = findViewById(R.id.zxing_rl_surface_loading);
    }

    public void hideScannerLoading() {
        this.f45496b.postDelayed(new Runnable() {
            public void run() {
                if (BaseQrCodeScanActivity.this.mLoadingView != null && BaseQrCodeScanActivity.this.mLoadingView.getParent() != null) {
                    ((ViewGroup) BaseQrCodeScanActivity.this.mLoadingView.getParent()).removeView(BaseQrCodeScanActivity.this.mLoadingView);
                    BaseQrCodeScanActivity.this.mLoadingView = null;
                }
            }
        }, 100);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        CaptureManager captureManager;
        super.onResume();
        if (this.f45504k && (captureManager = this.mCaptureManager) != null) {
            captureManager.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mCaptureManager.onPauseWhioutWait();
        dissPermissionDialog();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m32637f();
    }

    /* renamed from: f */
    private void m32637f() {
        CaptureManager captureManager = this.mCaptureManager;
        if (captureManager != null) {
            captureManager.onPauseWhioutWait();
            this.mCaptureManager.onDestroy();
            this.mCaptureManager = null;
        }
        if (this.f45501h) {
            this.f45497c.setTorchOff();
        }
        m32636e();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, final int[] iArr) {
        this.f45495a.info("BaseQrCodeScanActivity#onRequestPermissionsResult", new Object[0]);
        if (!ActivityCompatUtils.isDestroyed(this) && i == 1008 && iArr.length > 0) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    if (iArr[0] == 0) {
                        boolean unused = BaseQrCodeScanActivity.this.f45504k = true;
                        if (BaseQrCodeScanActivity.this.mCaptureManager != null) {
                            BaseQrCodeScanActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    if (!BaseQrCodeScanActivity.this.isFinishing() && BaseQrCodeScanActivity.this.mCaptureManager != null) {
                                        BaseQrCodeScanActivity.this.mCaptureManager.onResume();
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void showPermissionDialog(String[] strArr) {
        this.f45499f = IntentUtil.showPermissionDialog(this, strArr[0], new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BaseQrCodeScanActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void dissPermissionDialog() {
        AlertDialog alertDialog = this.f45499f;
        if (alertDialog != null && alertDialog.isShowing()) {
            try {
                this.f45499f.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onBackPressed() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        m32627a();
    }

    public void finish() {
        super.finish();
        this.f45496b.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: protected */
    public void notifyTorchStateChanged() {
        if (this.f45501h) {
            this.f45502i = true;
            this.f45497c.setTorchOff();
            this.f45501h = false;
            return;
        }
        this.f45497c.setTorchOn();
        this.f45501h = true;
    }
}
