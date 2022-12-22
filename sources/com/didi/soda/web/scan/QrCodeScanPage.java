package com.didi.soda.web.scan;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.app.nova.skeleton.Page;
import com.didi.dqr.ResultPoint;
import com.didi.security.wireless.ISecurityConf;
import com.didi.soda.web.tools.LogUtil;
import com.didi.zxing.barcodescanner.BarcodeCallback;
import com.didi.zxing.barcodescanner.BarcodeResult;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.didi.zxing.barcodescanner.CaptureManager;
import com.didi.zxing.barcodescanner.DecoratedBarcodeView;
import com.didi.zxing.barcodescanner.ViewfinderView;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.List;

public abstract class QrCodeScanPage extends Page {
    private static final float TOO_DARK_LUX = 40.0f;
    /* access modifiers changed from: private */
    public ImageView ivFlash;
    /* access modifiers changed from: private */
    public DecoratedBarcodeView mBarCodeView;
    /* access modifiers changed from: private */
    public CaptureManager mCaptureManager;
    private View mCloseIcon;
    /* access modifiers changed from: private */
    public boolean mFlashLightClickedByUser;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler();
    private Sensor mLightSensor;
    private SensorEventListener mLightSensorListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.values[0] <= 40.0f && !QrCodeScanPage.this.torchOn && !QrCodeScanPage.this.mFlashLightClickedByUser) {
                QrCodeScanPage.this.mBarCodeView.setTorchOn();
                boolean unused = QrCodeScanPage.this.torchOn = true;
            }
        }
    };
    /* access modifiers changed from: private */
    public View mLoadingView;
    /* access modifiers changed from: private */
    public ViewfinderView mViewFinderView;
    private SensorManager sensorManager;
    /* access modifiers changed from: private */
    public boolean torchOn;

    public abstract void provideScanResult(String str);

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.nova_assembly_qr_code_scan, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public String getTitle() {
        return getResources().getString(R.string.qr_code_scanner_title_text);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        this.mBarCodeView = (DecoratedBarcodeView) findViewById(R.id.bv_scanner_container);
        this.mLoadingView = findViewById(R.id.zxing_rl_surface_loading);
        this.mCloseIcon = findViewById(R.id.qr_code_iv_scanner_close);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.zxing_viewfinder_view);
        this.mViewFinderView = viewfinderView;
        viewfinderView.setAnimeFlag(false);
        ImageView imageView = (ImageView) findViewById(R.id.qr_code_iv_flash_light);
        this.ivFlash = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (QrCodeScanPage.this.torchOn) {
                    boolean unused = QrCodeScanPage.this.mFlashLightClickedByUser = true;
                    QrCodeScanPage.this.mBarCodeView.setTorchOff();
                    boolean unused2 = QrCodeScanPage.this.torchOn = false;
                    return;
                }
                QrCodeScanPage.this.mBarCodeView.setTorchOn();
                boolean unused3 = QrCodeScanPage.this.torchOn = true;
            }
        });
        this.mBarCodeView.setTorchListener(new DecoratedBarcodeView.TorchListener() {
            public void onTorchOn() {
                QrCodeScanPage.this.ivFlash.setImageResource(R.drawable.qr_code_flashlight_on_icon_selector);
            }

            public void onTorchOff() {
                QrCodeScanPage.this.ivFlash.setImageResource(R.drawable.qr_code_flashlight_icon_selector);
            }
        });
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QrCodeScanPage.this.finish();
            }
        });
        initCapture();
        checkPermission();
    }

    public void onResume() {
        super.onResume();
    }

    private void checkPermission() {
        requestPermissions(new String[]{Permission.CAMERA});
    }

    public void onPermissionDenied(String[] strArr) {
        super.onPermissionDenied(strArr);
        finish();
    }

    public void onPermissionGranted() {
        super.onPermissionGranted();
        if (this.mCaptureManager == null || !isCameraCanUse()) {
            finish();
        } else {
            this.mHandler.post(new Runnable() {
                public void run() {
                    if (QrCodeScanPage.this.mCaptureManager != null) {
                        QrCodeScanPage.this.mCaptureManager.onResume();
                    }
                }
            });
        }
    }

    public void onPause() {
        super.onPause();
        CaptureManager captureManager = this.mCaptureManager;
        if (captureManager != null) {
            captureManager.onPause();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages((Object) null);
        CaptureManager captureManager = this.mCaptureManager;
        if (captureManager != null) {
            captureManager.onDestroy();
        }
    }

    private void initCapture() {
        CaptureManager captureManager = new CaptureManager((Activity) getBaseContext(), this.mBarCodeView);
        this.mCaptureManager = captureManager;
        captureManager.decodeContinuous(new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(BarcodeResult barcodeResult) {
                if (QrCodeScanPage.this.mCaptureManager != null) {
                    QrCodeScanPage.this.mCaptureManager.onPauseWhioutWait();
                }
                QrCodeScanPage.this.onBarCodeResultGot(barcodeResult);
            }
        });
        this.mCaptureManager.addStateListener(new CameraPreview.StateListener() {
            public void cameraClosed() {
            }

            public void previewSized() {
            }

            public void previewStarted() {
                QrCodeScanPage.this.hideScannerLoading();
                QrCodeScanPage.this.mViewFinderView.setAnimeFlag(true);
            }

            public void previewStopped() {
                QrCodeScanPage.this.mViewFinderView.setAnimeFlag(false);
            }

            public void cameraError(Exception exc) {
                QrCodeScanPage.this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        if (QrCodeScanPage.this.mCaptureManager != null) {
                            QrCodeScanPage.this.mCaptureManager.onResume();
                        }
                    }
                }, 2000);
                exc.printStackTrace();
            }
        });
        initAutoFlash();
    }

    /* access modifiers changed from: private */
    public void onBarCodeResultGot(BarcodeResult barcodeResult) {
        String text = barcodeResult.getText();
        if (TextUtils.isEmpty(text)) {
            LogUtil.info("empty, return.");
            return;
        }
        provideScanResult(text);
        finish();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0011 A[SYNTHETIC, Splitter:B:10:0x0011] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isCameraCanUse() {
        /*
            r2 = this;
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.web.scan.QrCodeScanPage.isCameraCanUse():boolean");
    }

    private void initAutoFlash() {
        SensorManager sensorManager2 = (SensorManager) getApplicationContext().getSystemService(ISecurityConf.KEY_SENSOR);
        this.sensorManager = sensorManager2;
        Sensor defaultSensor = sensorManager2.getDefaultSensor(5);
        this.mLightSensor = defaultSensor;
        if (defaultSensor != null) {
            this.sensorManager.registerListener(this.mLightSensorListener, defaultSensor, 3);
        }
    }

    public void hideScannerLoading() {
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                if (QrCodeScanPage.this.mLoadingView != null && QrCodeScanPage.this.mLoadingView.getParent() != null) {
                    ((ViewGroup) QrCodeScanPage.this.mLoadingView.getParent()).removeView(QrCodeScanPage.this.mLoadingView);
                    View unused = QrCodeScanPage.this.mLoadingView = null;
                }
            }
        }, 100);
    }
}
