package p242io.card.payment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import com.didichuxing.cardscan.CardScanCallback;
import com.didichuxing.cardscan.CardScanResult;
import com.didichuxing.cardscan.DidiCardScanner;
import com.didichuxing.cardscan.p175a.C15181b;
import com.didichuxing.cardscan.p175a.C15182c;
import com.didichuxing.cardscan.view.CardScanActivity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import kotlinx.coroutines.DebugKt;

/* renamed from: io.card.payment.CardScanner */
public class CardScanner implements Camera.AutoFocusCallback, Camera.PreviewCallback, SurfaceHolder.Callback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static long endPreviewTime = 0;
    private static boolean manualFallbackForError = true;
    private static boolean processingInProgress = false;
    public static int sDesiredPreviewHeight = 480;
    public static int sDesiredPreviewWidth = 640;
    public static long startPreviewTime;
    private DetectionInfo dInfo;
    private boolean isSurfaceValid;
    private long mAutoFocusCompletedAt;
    private long mAutoFocusStartedAt;
    private Camera mCamera;
    private boolean mDetected;
    private boolean mFirstPreviewFrame;
    private byte[] mPreviewBuffer;
    private WeakReference<CardScanActivity> mScanActivityRef;
    private boolean scanExpiry;

    static {
        System.loadLibrary("cardioDecider");
        if (usesSupportedProcessorArch()) {
            System.loadLibrary("opencv");
            if (nUseNeon() || nUseX86()) {
                System.loadLibrary("cardioRecognizer");
            } else if (nUseTegra()) {
                System.loadLibrary("cardioRecognizer_tegra2");
            }
        }
    }

    public CardScanner() {
        this.mFirstPreviewFrame = true;
        this.scanExpiry = false;
        nSetup(false, 6.0f);
    }

    public CardScanner(CardScanActivity cardScanActivity) {
        this.mFirstPreviewFrame = true;
        this.mScanActivityRef = new WeakReference<>(cardScanActivity);
        this.scanExpiry = C15181b.m33165a((Context) cardScanActivity);
        nSetup(false, 6.0f);
    }

    private static byte[] crop(byte[] bArr, Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        int i = parameters.getPreviewSize().width;
        int i2 = parameters.getPreviewSize().height;
        YuvImage yuvImage = new YuvImage(bArr, parameters.getPreviewFormat(), i, i2, (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        return null;
    }

    private boolean isAutoFocusing() {
        return this.mAutoFocusCompletedAt < this.mAutoFocusStartedAt;
    }

    private void makePreviewGo(SurfaceHolder surfaceHolder) {
        this.mFirstPreviewFrame = true;
        try {
            this.mCamera.setPreviewDisplay(surfaceHolder);
            try {
                this.mCamera.startPreview();
                this.mCamera.autoFocus(this);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        } catch (IOException unused) {
        }
    }

    private native void nCleanup();

    private native void nGetGuideFrame(int i, int i2, int i3, Rect rect);

    private native int nGetNumFramesScanned();

    private native long nGetTimeNow();

    private native void nScanFrame(byte[] bArr, int i, int i2, int i3, DetectionInfo detectionInfo, Bitmap bitmap, boolean z);

    private native void nSetup(boolean z, float f);

    public static native boolean nUseNeon();

    public static native boolean nUseTegra();

    public static native boolean nUseX86();

    public static boolean processorSupported() {
        return !manualFallbackForError;
    }

    private void setCameraDisplayOrientation(Camera camera) {
        int i;
        if (Build.VERSION.SDK_INT >= 21) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(0, cameraInfo);
            i = (cameraInfo.orientation + 360) % 360;
        } else {
            i = 90;
        }
        camera.setDisplayOrientation(i);
    }

    private void updateDetectTime() {
        DetectionInfo detectionInfo = this.dInfo;
        if (detectionInfo != null) {
            detectionInfo.num_frames_scanned = nGetNumFramesScanned();
            if ((this.dInfo.time_scanner_begin_time != 0 || this.dInfo.num_frames_scanned > 0) && this.dInfo.system_time_scanner_begin_time == 0) {
                this.dInfo.system_time_scanner_begin_time = System.currentTimeMillis();
            }
            if (this.dInfo.time_card_number_completion_time != 0 && this.dInfo.system_time_card_number_completion_time == 0) {
                this.dInfo.system_time_card_number_completion_time = System.currentTimeMillis();
            }
            if (this.dInfo.time_expiry_completion_time != 0 && this.dInfo.system_time_expiry_completion_time == 0) {
                this.dInfo.system_time_expiry_completion_time = System.currentTimeMillis();
            }
        }
    }

    private static boolean usesSupportedProcessorArch() {
        return nUseNeon() || nUseTegra() || nUseX86();
    }

    public boolean detect(byte[] bArr, int i, int i2, DetectionInfo detectionInfo) {
        nScanFrame(bArr, i, i2, 1, detectionInfo, (Bitmap) null, this.scanExpiry);
        return detectionInfo.predicted();
    }

    public void endScanning() {
        if (this.mCamera != null) {
            pauseScanning();
        }
        nCleanup();
        this.mPreviewBuffer = null;
    }

    public Rect getGuideFrame(int i, int i2) {
        if (!processorSupported()) {
            return null;
        }
        Rect rect = new Rect();
        nGetGuideFrame(1, i, i2, rect);
        return rect;
    }

    public boolean isFlashOn() {
        return this.mCamera.getParameters().getFlashMode().equals("torch");
    }

    public void onAutoFocus(boolean z, Camera camera) {
        this.mAutoFocusCompletedAt = System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public void onEdgeUpdate(DetectionInfo detectionInfo) {
        WeakReference<CardScanActivity> weakReference = this.mScanActivityRef;
        if (weakReference != null && weakReference.get() != null) {
            ((CardScanActivity) this.mScanActivityRef.get()).mo114832a(detectionInfo);
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (bArr != null) {
            if (!processingInProgress) {
                processingInProgress = true;
                if (this.mFirstPreviewFrame) {
                    this.mFirstPreviewFrame = false;
                    ((CardScanActivity) this.mScanActivityRef.get()).mo114831a();
                }
                DetectionInfo detectionInfo = new DetectionInfo(this.dInfo);
                this.dInfo = detectionInfo;
                nScanFrame(bArr, sDesiredPreviewWidth, sDesiredPreviewHeight, 1, detectionInfo, (Bitmap) null, this.scanExpiry);
                updateDetectTime();
                if (!(this.dInfo.focusScore >= 6.0f)) {
                    triggerAutoFocus();
                } else if (this.dInfo.predicted() && !this.mDetected) {
                    this.mDetected = true;
                    ((CardScanActivity) this.mScanActivityRef.get()).mo114835b(this.dInfo);
                    C15182c.m33167a((Context) this.mScanActivityRef.get(), this.dInfo);
                }
                if (camera != null) {
                    camera.addCallbackBuffer(bArr);
                }
                processingInProgress = false;
            } else if (camera != null) {
                camera.addCallbackBuffer(bArr);
            }
        }
    }

    public void pauseScanning() {
        setFlashOn(false);
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.stopPreview();
                this.mCamera.setPreviewDisplay((SurfaceHolder) null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
            this.mCamera.release();
            this.mPreviewBuffer = null;
            this.mCamera = null;
        }
    }

    public void prepareScanner() {
        this.mAutoFocusStartedAt = 0;
        this.mAutoFocusCompletedAt = 0;
        this.mFirstPreviewFrame = true;
        if (this.mCamera == null) {
            Camera open = Camera.open();
            this.mCamera = open;
            if (open != null) {
                setCameraDisplayOrientation(open);
                Camera.Parameters parameters = this.mCamera.getParameters();
                parameters.setPreviewSize(sDesiredPreviewWidth, sDesiredPreviewHeight);
                this.mCamera.setParameters(parameters);
                startPreviewTime = System.currentTimeMillis();
            }
        }
    }

    public boolean resumeScanning(SurfaceHolder surfaceHolder) {
        if (this.mCamera == null) {
            prepareScanner();
        }
        Camera camera = this.mCamera;
        if (camera == null) {
            return false;
        }
        if (this.mPreviewBuffer == null) {
            byte[] bArr = new byte[(sDesiredPreviewWidth * sDesiredPreviewHeight * (ImageFormat.getBitsPerPixel(camera.getParameters().getPreviewFormat()) / 8) * 3)];
            this.mPreviewBuffer = bArr;
            this.mCamera.addCallbackBuffer(bArr);
        }
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(3);
        this.mCamera.setPreviewCallbackWithBuffer(this);
        if (this.isSurfaceValid) {
            makePreviewGo(surfaceHolder);
        }
        setFlashOn(false);
        return true;
    }

    public boolean setFlashOn(boolean z) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return false;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(z ? "torch" : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            this.mCamera.setParameters(parameters);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.mCamera != null) {
            this.isSurfaceValid = true;
            makePreviewGo(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        CardScanCallback cardScanCallback;
        CardScanResult cardScanResult;
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.stopPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.isSurfaceValid = false;
        endPreviewTime = System.currentTimeMillis();
        if (!this.mDetected) {
            DetectionInfo detectionInfo = this.dInfo;
            int i = 5;
            if (detectionInfo != null) {
                detectionInfo.num_frames_scanned = nGetNumFramesScanned();
                C15182c.m33167a((Context) this.mScanActivityRef.get(), this.dInfo);
                cardScanCallback = DidiCardScanner.getInstance().getCardScanCallback();
                if (cardScanCallback != null) {
                    cardScanResult = new CardScanResult();
                    cardScanResult.duration = endPreviewTime - startPreviewTime;
                    cardScanResult.requestCode = DidiCardScanner.getInstance().getRequestCode();
                    if (this.dInfo.num_frames_scanned > 0) {
                        i = 6;
                    }
                } else {
                    return;
                }
            } else {
                cardScanCallback = DidiCardScanner.getInstance().getCardScanCallback();
                if (cardScanCallback != null) {
                    cardScanResult = new CardScanResult();
                    cardScanResult.duration = endPreviewTime - startPreviewTime;
                    cardScanResult.requestCode = DidiCardScanner.getInstance().getRequestCode();
                } else {
                    return;
                }
            }
            cardScanResult.resultCode = i;
            cardScanCallback.onScanResult(cardScanResult);
            DidiCardScanner.getInstance().setScanCallback((CardScanCallback) null);
        }
    }

    public void triggerAutoFocus() {
        if (!isAutoFocusing()) {
            this.mAutoFocusStartedAt = System.currentTimeMillis();
            try {
                this.mCamera.autoFocus(this);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }
}
