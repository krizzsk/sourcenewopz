package p065me.dm7.barcodescanner.core;

import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* renamed from: me.dm7.barcodescanner.core.CameraHandlerThread */
public class CameraHandlerThread extends HandlerThread {

    /* renamed from: a */
    private static final String f4735a = "CameraHandlerThread";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BarcodeScannerView f4736b;

    public CameraHandlerThread(BarcodeScannerView barcodeScannerView) {
        super(f4735a);
        this.f4736b = barcodeScannerView;
        start();
    }

    public void startCamera(final int i) {
        new Handler(getLooper()).post(new Runnable() {
            public void run() {
                final Camera cameraInstance = CameraUtils.getCameraInstance(i);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        CameraHandlerThread.this.f4736b.setupCameraPreview(CameraWrapper.getWrapper(cameraInstance, i));
                    }
                });
            }
        });
    }
}
