package com.didi.zxing.barcodescanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dqr.ResultMetadataType;
import com.didi.dqr.ResultPoint;
import com.didi.sdk.apm.SystemUtils;
import com.didi.util.DecodeConfigUtil;
import com.didi.zxing.barcodescanner.CameraPreview;
import com.didi.zxing.client.BeepManager;
import com.didi.zxing.client.InactivityTimer;
import com.didi.zxing.client.Intents;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CaptureManager {

    /* renamed from: a */
    private static final String f45245a = "CaptureManager";

    /* renamed from: b */
    private static int f45246b = 250;

    /* renamed from: f */
    private static final String f45247f = "SAVED_ORIENTATION_LOCK";

    /* renamed from: c */
    private Activity f45248c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DecoratedBarcodeView f45249d;

    /* renamed from: e */
    private int f45250e;

    /* renamed from: g */
    private boolean f45251g;

    /* renamed from: h */
    private boolean f45252h;

    /* renamed from: i */
    private InactivityTimer f45253i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public BeepManager f45254j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f45255k;

    /* renamed from: l */
    private boolean f45256l;

    /* renamed from: m */
    private boolean f45257m;

    /* renamed from: n */
    private boolean f45258n;

    /* renamed from: o */
    private BarcodeCallback f45259o;

    /* renamed from: p */
    private final CameraPreview.StateListener f45260p;

    /* renamed from: q */
    private boolean f45261q;

    public CaptureManager(Activity activity, final DecoratedBarcodeView decoratedBarcodeView) {
        this.f45250e = -1;
        this.f45251g = false;
        this.f45252h = false;
        this.f45256l = false;
        this.f45257m = true;
        this.f45258n = true;
        this.f45259o = new BarcodeCallback() {
            public void possibleResultPoints(List<ResultPoint> list) {
            }

            public void barcodeResult(final BarcodeResult barcodeResult) {
                CaptureManager.this.f45249d.pause();
                CaptureManager.this.f45254j.playBeepSoundAndVibrate();
                CaptureManager.this.f45255k.post(new Runnable() {
                    public void run() {
                        CaptureManager.this.returnResult(barcodeResult);
                    }
                });
            }
        };
        this.f45260p = new CameraPreview.StateListener() {
            public void previewSized() {
            }

            public void previewStarted() {
            }

            public void previewStopped() {
            }

            public void cameraError(Exception exc) {
                SystemUtils.log(5, CaptureManager.f45245a, "error " + exc.getMessage(), (Throwable) null, "com.didi.zxing.barcodescanner.CaptureManager$2", 116);
            }

            public void cameraClosed() {
                SystemUtils.log(3, CaptureManager.f45245a, "Camera closed; finishing activity", (Throwable) null, "com.didi.zxing.barcodescanner.CaptureManager$2", 122);
            }
        };
        this.f45261q = false;
        this.f45248c = activity;
        this.f45249d = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().addStateListener(this.f45260p);
        this.f45255k = new Handler();
        this.f45253i = new InactivityTimer(activity, new Runnable() {
            public void run() {
                SystemUtils.log(3, CaptureManager.f45245a, "Finishing due to inactivity", (Throwable) null, "com.didi.zxing.barcodescanner.CaptureManager$3", 139);
                CaptureManager.this.m32504b();
            }
        });
        this.f45254j = new BeepManager(activity);
        decoratedBarcodeView.getBarcodeView().setLumListener(new LumListener() {
            private int changeCount;
            private int total;

            public int frequency() {
                return 3;
            }

            public void onLumChange(int i) {
                int i2 = this.total + i;
                this.total = i2;
                int i3 = this.changeCount + 1;
                this.changeCount = i3;
                if (i3 > 10) {
                    int i4 = i2 / i3;
                    DecodeConfigUtil.lum = i4;
                    DecodeConfig config = DecodeConfigUtil.getConfig();
                    if (config != null && config.autoTorch() && i4 <= config.autoTorchLum()) {
                        CaptureManager.this.f45255k.post(new Runnable() {
                            public void run() {
                                decoratedBarcodeView.mo113584a(true);
                            }
                        });
                    }
                    this.changeCount = 0;
                    this.total = 0;
                }
            }
        });
    }

    public CaptureManager(Activity activity, DecoratedBarcodeView decoratedBarcodeView, boolean z, boolean z2) {
        this(activity, decoratedBarcodeView);
        this.f45257m = z;
        this.f45258n = z2;
    }

    public CaptureManager(Activity activity, DecoratedBarcodeView decoratedBarcodeView, boolean z) {
        this(activity, decoratedBarcodeView);
        this.f45257m = z;
    }

    public void addStateListener(CameraPreview.StateListener stateListener) {
        this.f45249d.getBarcodeView().addStateListener(stateListener);
    }

    public void initializeFromIntent(Intent intent, Bundle bundle) {
        Activity activity = this.f45248c;
        if (activity != null) {
            activity.getWindow().addFlags(128);
            if (bundle != null) {
                this.f45250e = bundle.getInt(f45247f, -1);
            }
            if (intent != null) {
                if (intent.getBooleanExtra(Intents.Scan.ORIENTATION_LOCKED, true)) {
                    lockOrientation();
                }
                if (Intents.Scan.ACTION.equals(intent.getAction())) {
                    this.f45249d.initializeFromIntent(intent);
                }
                if (!intent.getBooleanExtra(Intents.Scan.BEEP_ENABLED, true)) {
                    this.f45254j.setBeepEnabled(false);
                }
                if (intent.hasExtra("TIMEOUT")) {
                    this.f45255k.postDelayed(new Runnable() {
                        public void run() {
                            CaptureManager.this.returnResultTimeout();
                        }
                    }, intent.getLongExtra("TIMEOUT", 0));
                }
                if (intent.getBooleanExtra(Intents.Scan.BARCODE_IMAGE_ENABLED, false)) {
                    this.f45251g = true;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void lockOrientation() {
        Activity activity = this.f45248c;
        if (activity != null) {
            if (this.f45250e == -1) {
                int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
                int i = this.f45248c.getResources().getConfiguration().orientation;
                int i2 = 0;
                if (i == 2) {
                    if (!(rotation == 0 || rotation == 1)) {
                        i2 = 8;
                    }
                } else if (i == 1) {
                    i2 = (rotation == 0 || rotation == 3) ? 1 : 9;
                }
                this.f45250e = i2;
            }
            SystemUtils.hookSetRequestedOrientation(this.f45248c, this.f45250e);
        }
    }

    public void decode() {
        this.f45249d.decodeSingle(this.f45259o);
    }

    public void decode(BarcodeCallback barcodeCallback) {
        this.f45249d.decodeSingle(barcodeCallback);
    }

    public void decodeContinuous(BarcodeCallback barcodeCallback) {
        this.f45249d.decodeContinuous(barcodeCallback);
    }

    public void onResume() {
        if (Build.VERSION.SDK_INT < 23 || !this.f45257m) {
            this.f45249d.resume();
        } else {
            m32502a();
        }
        if (this.f45258n) {
            this.f45253i.start();
        }
    }

    public boolean resume(Activity activity) {
        boolean z = this.f45248c == null;
        this.f45248c = activity;
        onResume();
        return z;
    }

    /* renamed from: a */
    private void m32502a() {
        Activity activity = this.f45248c;
        if (activity != null) {
            if (ContextCompat.checkSelfPermission(activity, Permission.CAMERA) == 0) {
                this.f45249d.resume();
            } else if (!this.f45261q) {
                ActivityCompat.requestPermissions(this.f45248c, new String[]{Permission.CAMERA}, f45246b);
                this.f45261q = true;
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != f45246b) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            displayFrameworkBugMessageAndExit();
        } else {
            this.f45249d.resume();
        }
    }

    public void onPause() {
        this.f45253i.cancel();
        this.f45249d.pauseAndWait();
    }

    public void onPauseWhioutWait() {
        this.f45253i.cancel();
        this.f45249d.pause();
    }

    public void pauseAndHoldCamera() {
        DecoratedBarcodeView decoratedBarcodeView = this.f45249d;
        if (decoratedBarcodeView != null) {
            decoratedBarcodeView.pauseAndHoldCamera();
        }
    }

    public void resumeScan() {
        DecoratedBarcodeView decoratedBarcodeView = this.f45249d;
        if (decoratedBarcodeView != null && decoratedBarcodeView.getBarcodeView() != null) {
            this.f45249d.getBarcodeView().startDecoderThread();
        }
    }

    public void onDestroy() {
        this.f45249d.destroy();
        this.f45252h = true;
        this.f45253i.cancel();
        this.f45255k.removeCallbacksAndMessages((Object) null);
        this.f45248c = null;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(f45247f, this.f45250e);
    }

    public static Intent resultIntent(BarcodeResult barcodeResult, String str) {
        Intent intent = new Intent(Intents.Scan.ACTION);
        intent.addFlags(524288);
        intent.putExtra(Intents.Scan.RESULT, barcodeResult.toString());
        intent.putExtra(Intents.Scan.RESULT_FORMAT, barcodeResult.getBarcodeFormat().toString());
        byte[] rawBytes = barcodeResult.getRawBytes();
        if (rawBytes != null && rawBytes.length > 0) {
            intent.putExtra(Intents.Scan.RESULT_BYTES, rawBytes);
        }
        Map<ResultMetadataType, Object> resultMetadata = barcodeResult.getResultMetadata();
        if (resultMetadata != null) {
            if (resultMetadata.containsKey(ResultMetadataType.UPC_EAN_EXTENSION)) {
                intent.putExtra(Intents.Scan.RESULT_UPC_EAN_EXTENSION, resultMetadata.get(ResultMetadataType.UPC_EAN_EXTENSION).toString());
            }
            Number number = (Number) resultMetadata.get(ResultMetadataType.ORIENTATION);
            if (number != null) {
                intent.putExtra(Intents.Scan.RESULT_ORIENTATION, number.intValue());
            }
            String str2 = (String) resultMetadata.get(ResultMetadataType.ERROR_CORRECTION_LEVEL);
            if (str2 != null) {
                intent.putExtra(Intents.Scan.RESULT_ERROR_CORRECTION_LEVEL, str2);
            }
            Iterable<byte[]> iterable = (Iterable) resultMetadata.get(ResultMetadataType.BYTE_SEGMENTS);
            if (iterable != null) {
                int i = 0;
                for (byte[] putExtra : iterable) {
                    intent.putExtra(Intents.Scan.RESULT_BYTE_SEGMENTS_PREFIX + i, putExtra);
                    i++;
                }
            }
        }
        if (str != null) {
            intent.putExtra(Intents.Scan.RESULT_BARCODE_IMAGE_PATH, str);
        }
        return intent;
    }

    /* renamed from: a */
    private String m32501a(BarcodeResult barcodeResult) {
        if (this.f45248c == null || !this.f45251g) {
            return null;
        }
        Bitmap bitmap = barcodeResult.getBitmap();
        try {
            File createTempFile = File.createTempFile("barcodeimage", ".jpg", this.f45248c.getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
            return createTempFile.getAbsolutePath();
        } catch (IOException e) {
            SystemUtils.log(5, f45245a, "Unable to create temporary file and store bitmap! " + e, (Throwable) null, "com.didi.zxing.barcodescanner.CaptureManager", 480);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32504b() {
        Activity activity = this.f45248c;
        if (activity != null) {
            activity.finish();
        }
        InactivityTimer inactivityTimer = this.f45253i;
        if (inactivityTimer != null) {
            inactivityTimer.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void closeAndFinish() {
        if (this.f45249d.getBarcodeView().isCameraClosed()) {
            m32504b();
        } else {
            this.f45256l = true;
        }
        this.f45249d.pause();
        this.f45253i.cancel();
    }

    /* access modifiers changed from: protected */
    public void returnResultTimeout() {
        if (this.f45248c != null) {
            Intent intent = new Intent(Intents.Scan.ACTION);
            intent.putExtra("TIMEOUT", true);
            this.f45248c.setResult(0, intent);
            closeAndFinish();
        }
    }

    /* access modifiers changed from: protected */
    public void returnResult(BarcodeResult barcodeResult) {
        if (this.f45248c != null) {
            this.f45248c.setResult(-1, resultIntent(barcodeResult, m32501a(barcodeResult)));
            closeAndFinish();
        }
    }

    /* access modifiers changed from: protected */
    public void displayFrameworkBugMessageAndExit() {
        Activity activity = this.f45248c;
        if (activity != null && !activity.isFinishing() && !this.f45252h && !this.f45256l) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f45248c);
            builder.setMessage(this.f45248c.getString(R.string.zxing_msg_camera_framework_bug));
            builder.setPositiveButton(R.string.zxing_button_ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                    CaptureManager.this.m32504b();
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    CaptureManager.this.m32504b();
                }
            });
            builder.show();
        }
    }

    public static int getCameraPermissionReqCode() {
        return f45246b;
    }

    public static void setCameraPermissionReqCode(int i) {
        f45246b = i;
    }

    public BarcodeView barcodeView() {
        DecoratedBarcodeView decoratedBarcodeView = this.f45249d;
        if (decoratedBarcodeView == null) {
            return null;
        }
        return decoratedBarcodeView.getBarcodeView();
    }

    public boolean isTorchOn() {
        DecoratedBarcodeView decoratedBarcodeView = this.f45249d;
        if (decoratedBarcodeView == null || decoratedBarcodeView.getBarcodeView() == null) {
            return false;
        }
        return this.f45249d.getBarcodeView().isTorchOn();
    }

    public void setProductId(String str) {
        DecoratedBarcodeView decoratedBarcodeView = this.f45249d;
        if (decoratedBarcodeView != null) {
            decoratedBarcodeView.setProductId(str);
        }
    }
}
