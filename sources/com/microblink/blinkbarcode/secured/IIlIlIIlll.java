package com.microblink.blinkbarcode.secured;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import com.microblink.blinkbarcode.hardware.SuccessCallback;
import com.microblink.blinkbarcode.hardware.accelerometer.ShakeCallback;
import com.microblink.blinkbarcode.hardware.camera.AutoFocusRequiredButNotSupportedException;
import com.microblink.blinkbarcode.hardware.camera.CameraType;
import com.microblink.blinkbarcode.hardware.camera.IllIIIllII;
import com.microblink.blinkbarcode.secured.IlIIIlIIIl;
import com.microblink.blinkbarcode.secured.llIIllIlII;
import com.microblink.blinkbarcode.secured.llllIllllI;
import com.microblink.blinkbarcode.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: line */
public class IIlIlIIlll implements com.microblink.blinkbarcode.hardware.camera.IllIIIllII {
    /* access modifiers changed from: private */
    public llllIllllI IIIIIIIIII;
    private IIllllIIlI IIlIIIllIl;
    /* access modifiers changed from: private */
    public CameraCaptureSession.CaptureCallback IIlIlllIIl = new IlIllIlIIl();
    /* access modifiers changed from: private */
    public boolean IlIIIIIlll = false;
    private boolean IlIIlIIIII = false;
    /* access modifiers changed from: private */
    public CaptureRequest IlIIlllIIl;
    /* access modifiers changed from: private */
    public AtomicBoolean IlIlIlIIlI = new AtomicBoolean(false);
    public com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl IlIllIlIIl = null;
    /* access modifiers changed from: private */
    public IllIIIllII.llIIlIlIIl IlIllIlllI;
    /* access modifiers changed from: private */
    public CaptureRequest.Builder IlIlllllII;
    /* access modifiers changed from: private */
    public IlllllIIIl IllIIIIllI;
    /* access modifiers changed from: private */
    public com.microblink.blinkbarcode.hardware.IllIIIllII IllIIIllII = com.microblink.blinkbarcode.hardware.IllIIIllII.llIIlIIlll();
    /* access modifiers changed from: private */
    public ShakeCallback IllIIlIIII;
    /* access modifiers changed from: private */
    public boolean IlllIIIllI = false;
    /* access modifiers changed from: private */
    public CameraCaptureSession lIIIIIlIlI;
    private lIlIIIlIll lIIIIIllll;
    /* access modifiers changed from: private */
    public IlIIlllIll lIlIIIIlIl;
    /* access modifiers changed from: private */
    public com.microblink.blinkbarcode.util.IllIIIllII lIllIIlIIl;
    /* access modifiers changed from: private */
    public com.microblink.blinkbarcode.util.lIlIIIIlIl lIlllIlIlI;
    private IlIIIlIIIl llIIIlllll;
    /* access modifiers changed from: private */
    public llIIllIlII llIIlIIIll;
    /* access modifiers changed from: private */
    public IlIlIIllll llIIlIIlll;
    public com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl llIIlIlIIl = null;
    /* access modifiers changed from: private */
    public llIIllIlII llIllIIlll;
    public com.microblink.blinkbarcode.hardware.camera.llIIlIlIIl lllIIIlIlI = null;
    /* access modifiers changed from: private */
    public boolean lllIIlIIlI = false;
    /* access modifiers changed from: private */
    public ShakeCallback lllIlIlIIl = ShakeCallback.EMPTY;
    private CaptureRequest lllllIlIll;

    /* compiled from: line */
    public class IIlIIIllIl implements Runnable {
        public final /* synthetic */ SuccessCallback IlIllIlIIl;
        public final /* synthetic */ boolean llIIlIlIIl;

        public IIlIIIllIl(boolean z, SuccessCallback successCallback) {
            this.llIIlIlIIl = z;
            this.IlIllIlIIl = successCallback;
        }

        public void run() {
            if (IIlIlIIlll.this.IlIlllllII != null && IIlIlIIlll.this.lIIIIIlIlI != null) {
                IlllllIIIl lIIIIIllll = IIlIlIIlll.this.IllIIIIllI;
                CaptureRequest.Builder IllIIIllII2 = IIlIlIIlll.this.IlIlllllII;
                boolean z = this.llIIlIlIIl;
                lIIIIIllll.getClass();
                if (z) {
                    IllIIIllII2.set(CaptureRequest.FLASH_MODE, 2);
                } else {
                    IllIIIllII2.set(CaptureRequest.FLASH_MODE, 0);
                }
                try {
                    IIlIlIIlll.this.llIIlIIIll();
                    IIlIlIIlll.this.IllIIIIllI.llIIlIlIIl(this.llIIlIlIIl, this.IlIllIlIIl);
                } catch (CameraAccessException | IllegalStateException unused) {
                    this.IlIllIlIIl.onOperationDone(false);
                }
            }
        }
    }

    /* compiled from: line */
    public class IlIllIlIIl extends CameraCaptureSession.CaptureCallback {
        public IlIllIlIIl() {
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
            Log.m40233v(IIlIlIIlll.this, "Capture completed", new Object[0]);
            IIlIlIIlll.this.IllIIIIllI.llIIlIlIIl(totalCaptureResult);
            IlIlIIllll llIIlIIlll = IIlIlIIlll.this.llIIlIIlll;
            IIlIlIIlll iIlIlIIlll = IIlIlIIlll.this;
            if (llIIlIIlll.llIIlIlIIl(totalCaptureResult, iIlIlIIlll.lllIIIlIlI, iIlIlIIlll.lIlIIIIlIl)) {
                IIlIlIIlll.IllIIlIIII(IIlIlIIlll.this);
            }
            if (Log.getCurrentLogLevel().ordinal() >= 4) {
                Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num != null) {
                    int intValue = num.intValue();
                    if (intValue == 0) {
                        Log.m40233v(IIlIlIIlll.class, "AE inactive", new Object[0]);
                    } else if (intValue == 1) {
                        Log.m40233v(IIlIlIIlll.class, "AE searching", new Object[0]);
                    } else if (intValue == 2) {
                        Log.m40233v(IIlIlIIlll.class, "AE converged", new Object[0]);
                    } else if (intValue == 3) {
                        Log.m40233v(IIlIlIIlll.class, "AE locked", new Object[0]);
                    } else if (intValue == 4) {
                        Log.m40233v(IIlIlIIlll.class, "AE flash required", new Object[0]);
                    } else if (intValue == 5) {
                        Log.m40233v(IIlIlIIlll.class, "AE precapture", new Object[0]);
                    }
                } else {
                    Log.m40233v(IIlIlIIlll.class, "AE null", new Object[0]);
                }
                Log.m40233v(IIlIlIIlll.class, "ISO: {}", totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY));
                Log.m40233v(IIlIlIIlll.class, "Exposure time: {}", totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME));
                Log.m40233v(IIlIlIIlll.class, "Frame duration: {}", totalCaptureResult.get(CaptureResult.SENSOR_FRAME_DURATION));
            }
        }

        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
            Log.m40233v(IIlIlIIlll.this, "Capture started", new Object[0]);
            if (IIlIlIIlll.this.IlIlIlIIlI.compareAndSet(false, true)) {
                IIlIlIIlll.this.IlIllIlllI.llIIlIlIIl();
            }
        }
    }

    /* compiled from: line */
    public class IllIIIIllI implements Runnable {
        public IllIIIIllI() {
        }

        public void run() {
            try {
                IIlIlIIlll.this.IlIlllllII();
            } catch (Throwable th) {
                IIlIlIIlll.this.IIIIIIIIII.IllIIIllII();
                IIlIlIIlll.this.IlIllIlllI.llIIlIlIIl(th);
            }
        }
    }

    /* compiled from: line */
    public class IllIIIllII implements IlIIIlIIIl.llIIIlllll {
        public IllIIIllII() {
        }
    }

    /* compiled from: line */
    public class lIIIIIllll implements Runnable {
        public lIIIIIllll() {
        }

        public void run() {
            IIlIlIIlll iIlIlIIlll = IIlIlIIlll.this;
            if (iIlIlIIlll.llIIlIlIIl != null) {
                Log.m40231i(iIlIlIIlll, "Pausing accelerometer", new Object[0]);
                IIlIlIIlll.this.llIIlIlIIl.llIIIlllll();
            }
            if (IIlIlIIlll.this.IIIIIIIIII.IIlIIIllIl()) {
                if (IIlIlIIlll.this.lIIIIIlIlI != null) {
                    Log.m40231i(IIlIlIIlll.this, "Closing preview session", new Object[0]);
                    IIlIlIIlll.this.lIIIIIlIlI.close();
                    CameraCaptureSession unused = IIlIlIIlll.this.lIIIIIlIlI = null;
                }
                IIlIlIIlll.this.IlIllIlllI.IlIllIlIIl();
                IIlIlIIlll.this.llIIlIIIll.IllIIIllII();
                IIlIlIIlll.this.llIllIIlll.IllIIIllII();
                Log.m40231i(IIlIlIIlll.this, "Closing camera device", new Object[0]);
                IIlIlIIlll.this.IIIIIIIIII.llIIIlllll();
                Log.m40231i(IIlIlIIlll.this, "Closed", new Object[0]);
            }
        }
    }

    /* compiled from: line */
    public class lIlIIIIlIl implements llllIllllI.IlIllIlIIl {
        public lIlIIIIlIl() {
        }
    }

    /* compiled from: line */
    public class llIIIlllll implements Runnable {
        public llIIIlllll() {
        }

        public void run() {
            IIlIlIIlll iIlIlIIlll = IIlIlIIlll.this;
            iIlIlIIlll.llIIlIlIIl = null;
            iIlIlIIlll.IlIllIlIIl = null;
            com.microblink.blinkbarcode.util.IllIIIllII unused = iIlIlIIlll.lIllIIlIIl = null;
            com.microblink.blinkbarcode.hardware.IllIIIllII unused2 = IIlIlIIlll.this.IllIIIllII = null;
            IIlIlIIlll.this.llIIlIIIll.llIIlIlIIl();
            IIlIlIIlll.this.llIllIIlll.llIIlIlIIl();
            IIlIlIIlll.this.lIlllIlIlI.IlIllIlIIl();
            com.microblink.blinkbarcode.util.lIlIIIIlIl unused3 = IIlIlIIlll.this.lIlllIlIlI = null;
        }
    }

    /* compiled from: line */
    public class llIIlIIlll implements Runnable {
        public llIIlIIlll() {
        }

        public void run() {
            if (IIlIlIIlll.this.IlIlllllII == null || IIlIlIIlll.this.lIIIIIlIlI == null || IIlIlIIlll.this.lIlllIlIlI == null || !IIlIlIIlll.this.lllIIlIIlI) {
                Log.m40235w(IIlIlIIlll.this, "Cannot trigger autofocus. Camera session is closed!", new Object[0]);
                return;
            }
            Log.m40227d(IIlIlIIlll.this, "Triggering autofocus", new Object[0]);
            com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl ilIllIlIIl = IIlIlIIlll.this.IlIllIlIIl;
            if (ilIllIlIIl == null || !ilIllIlIIl.IllIIlIIII()) {
                IIlIlIIlll.this.IlIlllllII.set(CaptureRequest.CONTROL_AF_MODE, 1);
            } else {
                IIlIlIIlll.this.IlIlllllII.set(CaptureRequest.CONTROL_AF_MODE, 2);
            }
            try {
                IIlIlIIlll.this.IlIlllllII.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                IIlIlIIlll.this.llIIlIIIll();
                IIlIlIIlll.this.llIIlIIlll.llIIlIlIIl(false);
                IIlIlIIlll.this.IlIlllllII.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                IIlIlIIlll.this.lIIIIIlIlI.capture(IIlIlIIlll.this.IlIlllllII.build(), IIlIlIIlll.this.IIlIlllIIl, IIlIlIIlll.this.lIlllIlIlI.llIIlIlIIl());
                IIlIlIIlll.this.IlIlllllII.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            } catch (Exception unused) {
                IIlIlIIlll.this.lllIIIlIlI.onAutofocusFailed();
            }
        }
    }

    /* compiled from: line */
    public class lllIIIlIlI implements Runnable {
        public lllIIIlIlI() {
        }

        public void run() {
            if (IIlIlIIlll.this.lIIIIIlIlI != null && IIlIlIIlll.this.IlIlllllII != null) {
                try {
                    IIlIlIIlll.this.llIIlIIIll();
                } catch (CameraAccessException e) {
                    Log.m40236w(this, e, "Failed to set capture request with new parameters", new Object[0]);
                } catch (IllegalStateException e2) {
                    Log.m40236w(this, e2, "Failed to set capture request with new parameters - capture session is already closed", new Object[0]);
                }
            }
        }
    }

    /* compiled from: line */
    public class lllIlIlIIl implements ShakeCallback {
        private lllIlIlIIl() {
        }

        public void onShakingStarted() {
            Log.m40233v(this, "Shaking started", new Object[0]);
            IIlIlIIlll.this.IllIIlIIII.onShakingStarted();
            IIlIlIIlll.this.lllIlIlIIl.onShakingStarted();
        }

        public void onShakingStopped() {
            Log.m40233v(this, "Shaking stopped", new Object[0]);
            IIlIlIIlll.this.IllIIlIIII.onShakingStopped();
            IIlIlIIlll.this.lllIlIlIIl.onShakingStopped();
            com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl ilIllIlIIl = IIlIlIIlll.this.IlIllIlIIl;
            if (ilIllIlIIl != null && ilIllIlIIl.lllIIIlIlI()) {
                IIlIlIIlll.this.llIIIlllll();
            }
        }

        public /* synthetic */ lllIlIlIIl(IIlIlIIlll iIlIlIIlll, IllIIIllII illIIIllII) {
            this();
        }
    }

    public IIlIlIIlll(Context context, com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl lliililiil, com.microblink.blinkbarcode.hardware.camera.llIIlIlIIl lliililiil2, com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl ilIllIlIIl) {
        this.llIIlIlIIl = lliililiil;
        this.lllIIIlIlI = lliililiil2;
        this.IlIllIlIIl = ilIllIlIIl;
        this.IllIIlIIII = ilIllIlIIl.llIIlIIlll();
        if (this.llIIlIlIIl == null) {
            throw new NullPointerException("Camera manager requires accelerometer manager and camera strategy factory to be non-null");
        } else if (this.lllIIIlIlI != null) {
            if (this.IlIllIlIIl == null) {
                this.IlIllIlIIl = new com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl();
            }
            this.llIIlIlIIl.llIIlIlIIl((ShakeCallback) new lllIlIlIIl(this, (IllIIIllII) null));
            com.microblink.blinkbarcode.util.lIlIIIIlIl liliiiilil = new com.microblink.blinkbarcode.util.lIlIIIIlIl("Camera2Control " + hashCode());
            this.lIlllIlIlI = liliiiilil;
            liliiiilil.start();
            this.lIllIIlIIl = new com.microblink.blinkbarcode.util.llIIIlllll();
            this.IIIIIIIIII = new llllIllllI(context, this.lIlllIlIlI);
            this.IllIIIIllI = new IlllllIIIl();
            com.microblink.blinkbarcode.hardware.IllIIIllII illIIIllII = this.IllIIIllII;
            this.lIlIIIIlIl = new IlIIlllIll(illIIIllII);
            this.llIIlIIlll = new IlIlIIllll();
            this.IIlIIIllIl = new IIllllIIlI();
            this.lIIIIIllll = new lIlIIIlIll(illIIIllII);
            this.llIIlIIIll = IllIIlIIII();
            this.llIllIIlll = lllIlIlIIl();
            this.llIIIlllll = new IlIIIlIIIl(this.lIlllIlIlI, new IllIIIllII());
        } else {
            throw new NullPointerException("Camera delegate can't be null.");
        }
    }

    public static void IllIIlIIII(IIlIlIIlll iIlIlIIlll) {
        iIlIlIIlll.getClass();
        try {
            iIlIlIIlll.IlIlllllII.set(CaptureRequest.CONTROL_AF_MODE, 4);
            iIlIlIIlll.llIIlIIIll();
            iIlIlIIlll.llIIlIIlll.llIIlIlIIl(true);
        } catch (Exception e) {
            Log.m40236w(iIlIlIIlll, e, "Failed to resume continuous autofocus", new Object[0]);
        }
    }

    public void dispose() {
        if (!this.IlllIIIllI) {
            this.IlllIIIllI = true;
            this.lIlllIlIlI.llIIlIlIIl((Runnable) new llIIIlllll());
        }
    }

    /* compiled from: line */
    public class llIIlIlIIl implements llIIllIlII.IllIIIllII {
        public llIIlIlIIl() {
        }

        public boolean IlIllIlIIl() {
            com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl lliililiil = IIlIlIIlll.this.llIIlIlIIl;
            return lliililiil == null || lliililiil.IlIllIlIIl();
        }

        public void IllIIIllII() {
            if (!IIlIlIIlll.this.IIIIIIIIII.lIIIIIllll()) {
                IIlIlIIlll iIlIlIIlll = IIlIlIIlll.this;
                iIlIlIIlll.llIIlIlIIl(iIlIlIIlll.IlIIlllIIl);
            }
        }

        public boolean canReceiveFrame() {
            com.microblink.blinkbarcode.hardware.camera.llIIlIlIIl lliililiil = IIlIlIIlll.this.lllIIIlIlI;
            return lliililiil != null && lliililiil.canReceiveFrame();
        }

        public void llIIlIlIIl(llIIlllIll lliilllill) {
            com.microblink.blinkbarcode.hardware.camera.llIIlIlIIl lliililiil = IIlIlIIlll.this.lllIIIlIlI;
            if (lliililiil != null) {
                lliililiil.onCameraFrame(lliilllill);
            }
        }

        public boolean llIIlIlIIl() {
            return IIlIlIIlll.this.llIIlIIlll.IlIllIlIIl();
        }
    }

    /* access modifiers changed from: private */
    public void IlIIlllIIl() {
        if (this.IIIIIIIIII.IlIllIlIIl() && this.lIIIIIlIlI != null) {
            try {
                this.IlIlllllII.set(CaptureRequest.CONTROL_MODE, 1);
                this.llIIlIIlll.llIIlIlIIl(this.IlIlllllII);
                this.IlIlllllII.set(CaptureRequest.CONTROL_AE_MODE, 1);
                this.IlIlllllII.set(CaptureRequest.CONTROL_AWB_MODE, 1);
                this.IIlIIIllIl.llIIlIlIIl(this.IlIlllllII);
                if (this.IlIllIlIIl.IllIIlIIII() && this.IlIllIlIIl.llIIIlllll() == 0.0f) {
                    this.IlIllIlIIl.llIIlIlIIl(0.2f);
                }
                this.lIlIIIIlIl.llIIlIlIIl(this.IlIlllllII, this.IlIllIlIIl.llIIIlllll());
                llIIlIIIll();
                com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl lliililiil = this.llIIlIlIIl;
                if (lliililiil != null) {
                    lliililiil.IllIIIllII();
                }
                for (int i = 0; i < 3; i++) {
                    llIIlIlIIl(this.IlIIlllIIl);
                }
            } catch (CameraAccessException e) {
                Log.m40230e(this, e, "Failed to start capturing frames", new Object[0]);
                this.IlIllIlllI.llIIlIlIIl(e);
            } catch (IllegalStateException e2) {
                Log.wtf(this, e2, "Camera session was just created and is already invalid?!?", new Object[0]);
                this.IlIllIlllI.llIIlIlIIl(e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void IlIlllllII() {
        if (!this.IIIIIIIIII.lllIIIlIlI()) {
            Log.m40231i(this, "Camera is already being opened.", new Object[0]);
            return;
        }
        try {
            CameraCharacteristics llIIlIlIIl2 = this.IIIIIIIIII.llIIlIlIIl(this.IlIllIlIIl.IlIllIlIIl(), this.IlIllIlllI, new lIlIIIIlIl());
            if (llIIlIlIIl2 != null) {
                this.llIIlIIlll.llIIlIlIIl(llIIlIlIIl2, this.IllIIIllII);
                if (!this.llIIlIIlll.llIIlIlIIl()) {
                    if (this.IlIllIlIIl.lllIlIlIIl()) {
                        throw new AutoFocusRequiredButNotSupportedException("Autofocus is required, but not supported on this device");
                    }
                }
                this.IIlIIIllIl.llIIlIlIIl(llIIlIlIIl2);
                this.lIlIIIIlIl.llIIlIlIIl(llIIlIlIIl2);
                this.IllIIIIllI.llIIlIlIIl(llIIlIlIIl2);
                this.lIIIIIllll.llIIlIlIIl(llIIlIlIIl2, this.IlIllIlIIl);
                Size IllIIIllII2 = this.lIIIIIllll.IllIIIllII();
                this.IlIllIlllI.llIIlIlIIl(IllIIIllII2.getWidth(), IllIIIllII2.getHeight());
                this.llIIIlllll.llIIlIlIIl(this.lIIIIIllll.llIIIlllll(), this.lIllIIlIIl);
            }
        } catch (CameraAccessException e) {
            this.IlIllIlllI.llIIlIlIIl(e);
        } catch (NullPointerException e2) {
            int i = com.microblink.blinkbarcode.hardware.IllIIIllII.lIlIIIIlIl;
            Log.m40230e(this, e2, "Camera2 API not supported on this device: {}", new com.microblink.blinkbarcode.hardware.llIIlIlIIl(Build.DEVICE, Build.MODEL));
            this.IlIllIlllI.llIIlIlIIl(e2);
        } catch (SecurityException e3) {
            Log.m40230e(this, e3, "User has not granted permission to use camera!", new Object[0]);
            this.IlIllIlllI.llIIlIlIIl(e3);
        }
    }

    /* access modifiers changed from: private */
    public void lIIIIIlIlI() {
        if (this.IlIIIIIlll) {
            Log.m40231i(this, "Preview is already starting... Ignoring this call...", new Object[0]);
        } else if (!this.IIIIIIIIII.IIlIIIllIl() || !this.llIIIlllll.llIIIlllll()) {
            Log.m40235w(this, "Cannot start preview. CameraDevice: {}, surface ready: {}, PreviewSize: {}", Boolean.valueOf(this.IIIIIIIIII.IIlIIIllIl()), Boolean.valueOf(this.llIIIlllll.llIIIlllll()), this.lIIIIIllll.IllIIIllII());
        } else {
            try {
                this.IlIIIIIlll = true;
                Surface IllIIIllII2 = this.llIIIlllll.IllIIIllII();
                this.llIIlIIIll.IlIllIlIIl(this.lIIIIIllll, 3, this.IlIllIlIIl.llIIlIlIIl());
                if (this.IlIllIlIIl.lIIIIIllll()) {
                    this.llIllIIlll.llIIlIlIIl(this.lIIIIIllll, this.IlIllIlIIl.IllIIIllII(), this.IlIllIlIIl.llIIlIlIIl());
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(IllIIIllII2);
                Surface IlIllIlIIl2 = this.llIIlIIIll.IlIllIlIIl();
                if (IlIllIlIIl2 != null) {
                    arrayList.add(IlIllIlIIl2);
                }
                Surface IlIllIlIIl3 = this.llIllIIlll.IlIllIlIIl();
                if (IlIllIlIIl3 != null) {
                    arrayList.add(IlIllIlIIl3);
                }
                CaptureRequest.Builder IllIIIIllI2 = this.IIIIIIIIII.IllIIIIllI();
                this.IlIlllllII = IllIIIIllI2;
                IllIIIIllI2.addTarget(IllIIIllII2);
                this.lllIIlIIlI = false;
                this.IIIIIIIIII.llIIlIlIIl((List<Surface>) arrayList, (CameraCaptureSession.StateCallback) new IIllllllll(this));
            } catch (CameraAccessException e) {
                this.IlIIIIIlll = false;
                this.IlIllIlllI.llIIlIlIIl(e);
            } catch (IllegalStateException e2) {
                this.IlIIIIIlll = false;
                this.IlIllIlllI.llIIlIlIIl(e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void llIIlIIIll() throws CameraAccessException {
        Surface IlIllIlIIl2 = this.llIIlIIIll.IlIllIlIIl();
        if (IlIllIlIIl2 != null) {
            this.IlIlllllII.addTarget(IlIllIlIIl2);
            this.IlIIlllIIl = this.IlIlllllII.build();
            this.IlIlllllII.removeTarget(IlIllIlIIl2);
        }
        Surface IlIllIlIIl3 = this.llIllIIlll.IlIllIlIIl();
        if (IlIllIlIIl3 != null) {
            this.IlIlllllII.addTarget(IlIllIlIIl3);
            this.lllllIlIll = this.IlIlllllII.build();
            this.IlIlllllII.removeTarget(IlIllIlIIl3);
        }
        this.lIIIIIlIlI.setRepeatingRequest(this.IlIlllllII.build(), this.IIlIlllIIl, this.lIlllIlIlI.llIIlIlIIl());
    }

    private llIIllIlII lllIlIlIIl() {
        return new llIIllIlII(IIlIIlIllI.INSTANCE.IlIllIlIIl(), new IlIllIlllI());
    }

    public boolean IIlIIIllIl() {
        return this.IllIIIIllI.llIIlIlIIl();
    }

    public CameraType IlIllIlllI() {
        return this.IIIIIIIIII.llIIlIIlll();
    }

    public void IllIIIIllI() {
        if (!this.IlIIlIIIII) {
            Log.m40231i(this, "Stop preview has already been called. Ignoring this call!", new Object[0]);
            return;
        }
        this.IlIIlIIIII = false;
        this.IIIIIIIIII.IlIllIlllI();
        Log.m40231i(this, "Camera2Manager.stopPreview", new Object[0]);
        this.lIlllIlIlI.llIIlIlIIl((Runnable) new lIIIIIllll());
    }

    public void IllIIIllII() {
        llIIlIlIIl(this.lllllIlIll);
    }

    public boolean lIIIIIllll() {
        return this.IIIIIIIIII.llIIlIlIIl();
    }

    public boolean lIlIIIIlIl() {
        return this.llIIlIlIIl.IlIllIlIIl();
    }

    public void llIIIlllll() {
        com.microblink.blinkbarcode.util.lIlIIIIlIl liliiiilil;
        if (!this.llIIlIIlll.llIIlIlIIl()) {
            Log.m40235w(this, "Autofocus not supported, unable to trigger it", new Object[0]);
        } else if (this.IlIlllllII == null || this.lIIIIIlIlI == null || (liliiiilil = this.lIlllIlIlI) == null) {
            Log.m40235w(this, "Cannot trigger autofocus. Camera session is closed!", new Object[0]);
        } else {
            liliiiilil.llIIlIlIIl((Runnable) new llIIlIIlll());
        }
    }

    public int llIIlIIlll() {
        return this.IIIIIIIIII.lIlIIIIlIl();
    }

    public com.microblink.blinkbarcode.hardware.camera.lIlIIIIlIl lllIIIlIlI() {
        return this.llIIIlllll;
    }

    public Boolean IlIllIlIIl() {
        if (this.IlIlIlIIlI.get()) {
            return Boolean.valueOf(this.llIIlIIlll.llIIlIlIIl());
        }
        return null;
    }

    /* compiled from: line */
    public class IlIllIlllI implements llIIllIlII.IllIIIllII {
        public IlIllIlllI() {
        }

        public boolean IlIllIlIIl() {
            com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl lliililiil = IIlIlIIlll.this.llIIlIlIIl;
            return lliililiil != null && lliililiil.IlIllIlIIl();
        }

        public void IllIIIllII() {
        }

        public boolean canReceiveFrame() {
            return true;
        }

        public void llIIlIlIIl(llIIlllIll lliilllill) {
            com.microblink.blinkbarcode.hardware.camera.llIIlIlIIl lliililiil = IIlIlIIlll.this.lllIIIlIlI;
            if (lliililiil != null) {
                lliililiil.onHighResFrame(lliilllill);
            }
            ((IIllIIllll) lliilllill).IllIIIllII();
        }

        public boolean llIIlIlIIl() {
            return IIlIlIIlll.this.llIIlIIlll.IlIllIlIIl();
        }
    }

    public void llIIlIlIIl(ShakeCallback shakeCallback) {
        if (shakeCallback == null) {
            this.lllIlIlIIl = ShakeCallback.EMPTY;
        } else {
            this.lllIlIlIIl = shakeCallback;
        }
    }

    public void llIIlIlIIl(float f) {
        CaptureRequest.Builder builder = this.IlIlllllII;
        if (builder != null && this.lIIIIIlIlI != null) {
            this.lIlIIIIlIl.llIIlIlIIl(builder, f);
            llIIlIlIIl(this.lIlIIIIlIl.llIIlIlIIl());
        }
    }

    public void llIIlIlIIl(Context context, com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl ilIllIlIIl, IllIIIllII.llIIlIlIIl lliililiil) {
        if (this.IlIIlIIIII) {
            Log.m40231i(this, "Start preview has already been called. Ignoring this call!", new Object[0]);
            return;
        }
        this.llIIlIIIll.llIIlIlIIl();
        this.llIllIIlll.llIIlIlIIl();
        Log.m40231i(this, "Camera2Manager.startPreview", new Object[0]);
        this.IlIIlIIIII = true;
        this.IlIllIlllI = lliililiil;
        this.IlIllIlIIl = ilIllIlIIl;
        this.IlIlIlIIlI = new AtomicBoolean(false);
        this.llIIlIIIll.llIIIlllll();
        this.llIllIIlll.llIIIlllll();
        this.IlIIIIIlll = false;
        this.IllIIIIllI.IlIllIlIIl();
        this.llIIlIIlll.IllIIIllII();
        this.lIlllIlIlI.llIIlIlIIl((Runnable) new IllIIIIllI());
    }

    /* access modifiers changed from: private */
    public void llIIlIlIIl(CaptureRequest captureRequest) {
        try {
            CameraCaptureSession cameraCaptureSession = this.lIIIIIlIlI;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.capture(captureRequest, (CameraCaptureSession.CaptureCallback) null, this.lIlllIlIlI.llIIlIlIIl());
            } else {
                Log.m40233v(this, "Session is already closed. Cannot capture another frame.", new Object[0]);
            }
        } catch (Exception e) {
            Log.m40230e(this, e, "Failed to capture frame", new Object[0]);
        }
    }

    public void llIIlIlIIl(boolean z, SuccessCallback successCallback) {
        if (this.IlIlllllII != null && this.lIIIIIlIlI != null) {
            this.lIlllIlIlI.llIIlIlIIl((Runnable) new IIlIIIllIl(z, successCallback));
        }
    }

    public boolean llIIlIlIIl() {
        return this.llIIlIIlll.IlIllIlIIl();
    }

    public void llIIlIlIIl(Rect[] rectArr) {
        if (this.IlIlllllII != null && this.lIIIIIlIlI != null && !this.IllIIIllII.lllllIlIll()) {
            this.lIlIIIIlIl.llIIlIlIIl(this.IlIlllllII, rectArr);
            this.lIlllIlIlI.llIIlIlIIl((Runnable) new lllIIIlIlI());
        }
    }

    private llIIllIlII IllIIlIIII() {
        return new llIIllIlII(IIlIIlIllI.INSTANCE.llIIlIlIIl(), new llIIlIlIIl());
    }
}
