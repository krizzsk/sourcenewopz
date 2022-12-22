package com.microblink.blinkbarcode.secured;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Looper;
import com.microblink.blinkbarcode.hardware.SuccessCallback;
import com.microblink.blinkbarcode.hardware.accelerometer.ShakeCallback;
import com.microblink.blinkbarcode.hardware.camera.AutoFocusRequiredButNotSupportedException;
import com.microblink.blinkbarcode.hardware.camera.CameraResolutionTooSmallException;
import com.microblink.blinkbarcode.hardware.camera.CameraType;
import com.microblink.blinkbarcode.hardware.camera.IllIIIllII;
import com.microblink.blinkbarcode.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.DebugKt;

/* compiled from: line */
public class lllIIIlIlI implements com.microblink.blinkbarcode.hardware.camera.IllIIIllII {
    /* access modifiers changed from: private */
    public final Camera.PreviewCallback IIIIIIIIII = new llIIIlllll();
    /* access modifiers changed from: private */
    public com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl IIlIIIllIl = null;
    /* access modifiers changed from: private */
    public final Camera.PictureCallback IlIIIIIlll = new IIlIIIllIl();
    /* access modifiers changed from: private */
    public int IlIIlIIIII = -1;
    /* access modifiers changed from: private */
    public CameraType IlIIlllIIl = null;
    /* access modifiers changed from: private */
    public volatile IIlIlllIIl IlIlIlIIlI = IIlIlllIIl.IDLE;
    /* access modifiers changed from: private */
    public com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl IlIllIlIIl = null;
    private Boolean IlIllIlllI = null;
    /* access modifiers changed from: private */
    public lIlIIlIIll IlIlllllII = null;
    private lllIlIlIIl IllIIIIllI;
    /* access modifiers changed from: private */
    public com.microblink.blinkbarcode.hardware.camera.llIIlIlIIl IllIIIllII = null;
    /* access modifiers changed from: private */
    public boolean IllIIlIIII = false;
    private boolean IlllIIIllI = false;
    /* access modifiers changed from: private */
    public lllllIlIll lIIIIIlIlI = null;
    /* access modifiers changed from: private */
    public ShakeCallback lIIIIIllll = null;
    /* access modifiers changed from: private */
    public volatile boolean lIlIIIIlIl = false;
    /* access modifiers changed from: private */
    public IllIIIllII.llIIlIlIIl lIllIIlIIl;
    /* access modifiers changed from: private */
    public AtomicBoolean lIlllIlIlI = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public IlIIIIIlll llIIIlllll = null;
    /* access modifiers changed from: private */
    public Camera.Size llIIlIIIll = null;
    /* access modifiers changed from: private */
    public IlIlIlIIlI llIIlIIlll = null;
    /* access modifiers changed from: private */
    public Camera llIIlIlIIl = null;
    /* access modifiers changed from: private */
    public int llIllIIlll = 0;
    /* access modifiers changed from: private */
    public ShakeCallback lllIIIlIlI;
    private Boolean lllIIlIIlI = null;
    /* access modifiers changed from: private */
    public com.microblink.blinkbarcode.hardware.IllIIIllII lllIlIlIIl;
    /* access modifiers changed from: private */
    public com.microblink.blinkbarcode.util.IllIIIllII lllllIlIll;

    /* compiled from: line */
    public class IIlIIIllIl implements Camera.PictureCallback {
        private long llIIlIlIIl = 3000000;

        /* compiled from: line */
        public class llIIlIlIIl implements Runnable {
            public final /* synthetic */ IlllIIIllI llIIlIlIIl;

            public llIIlIlIIl(IlllIIIllI illlIIIllI) {
                this.llIIlIlIIl = illlIIIllI;
            }

            public void run() {
                lllllIlIll IllIIlIIII = lllIIIlIlI.IllIIlIIII(lllIIIlIlI.this);
                if (IllIIlIIII != null) {
                    IllIIlIIII.IllIIIIllI();
                    IllIIlIIII.llIIlIlIIl();
                }
                boolean unused = lllIIIlIlI.this.lIlIIIIlIl = true;
                IIlIlllIIl unused2 = lllIIIlIlI.this.IlIlIlIIlI = IIlIlllIIl.IDLE;
                if (lllIIIlIlI.this.IllIIIllII != null) {
                    lllIIIlIlI.this.IllIIIllII.onHighResFrame(this.llIIlIlIIl);
                }
                this.llIIlIlIIl.llIIlIlIIl();
            }
        }

        public IIlIIIllIl() {
        }

        public void onPictureTaken(byte[] bArr, Camera camera) {
            Log.m40231i(this, "on picture taken", new Object[0]);
            if (bArr == null) {
                IIlIlllIIl unused = lllIIIlIlI.this.IlIlIlIIlI = IIlIlllIIl.IDLE;
                return;
            }
            boolean unused2 = lllIIIlIlI.this.lIlIIIIlIl = false;
            lllIIIlIlI.this.llIIlIlIIl.stopPreview();
            Camera.Size pictureSize = camera.getParameters().getPictureSize();
            IlllIIIllI llIIlIlIIl2 = IlllIIIllI.llIIlIlIIl(pictureSize.width, pictureSize.height, bArr);
            long j = this.llIIlIlIIl;
            this.llIIlIlIIl = 1 + j;
            llIIlIlIIl2.IlIllIlIIl(j);
            try {
                lllIIIlIlI.this.llIIlIlIIl.setPreviewCallbackWithBuffer(lllIIIlIlI.this.IIIIIIIIII);
                lllIIIlIlI.this.llIIlIlIIl.startPreview();
                lllIIIlIlI.IlIlllllII(lllIIIlIlI.this).llIIlIlIIl(new llIIlIlIIl(llIIlIlIIl2), (long) lllIIIlIlI.this.llIIIlllll.llIIlIlIIl());
            } catch (RuntimeException e) {
                Log.m40230e(this, e, "Unable to restart camera preview", new Object[0]);
            }
        }
    }

    /* compiled from: line */
    public class IlIllIlIIl implements Runnable {
        public IlIllIlIIl() {
        }

        public void run() {
            if (lllIIIlIlI.this.llIIlIIlll != null) {
                lllIIIlIlI.this.llIIlIIlll.llIIlIlIIl();
            }
            IlIlIlIIlI unused = lllIIIlIlI.this.llIIlIIlll = null;
            if (lllIIIlIlI.this.lIIIIIlIlI != null) {
                lllIIIlIlI.this.lIIIIIlIlI.dispose();
            }
            lllllIlIll unused2 = lllIIIlIlI.this.lIIIIIlIlI = null;
            com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl unused3 = lllIIIlIlI.this.IlIllIlIIl = null;
            com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl unused4 = lllIIIlIlI.this.IIlIIIllIl = null;
            com.microblink.blinkbarcode.hardware.camera.llIIlIlIIl unused5 = lllIIIlIlI.this.IllIIIllII = null;
            lIlIIlIIll unused6 = lllIIIlIlI.this.IlIlllllII = null;
            ShakeCallback unused7 = lllIIIlIlI.this.lIIIIIllll = null;
            Camera.Size unused8 = lllIIIlIlI.this.llIIlIIIll = null;
            CameraType unused9 = lllIIIlIlI.this.IlIIlllIIl = null;
            com.microblink.blinkbarcode.hardware.IllIIIllII unused10 = lllIIIlIlI.this.lllIlIlIIl = null;
            IllIIIllII.llIIlIlIIl unused11 = lllIIIlIlI.this.lIllIIlIIl = null;
            ShakeCallback unused12 = lllIIIlIlI.this.lllIIIlIlI = null;
        }
    }

    /* compiled from: line */
    public class IlIllIlllI implements Runnable {
        public final /* synthetic */ boolean IlIllIlIIl;
        public final /* synthetic */ SuccessCallback llIIlIlIIl;

        public IlIllIlllI(SuccessCallback successCallback, boolean z) {
            this.llIIlIlIIl = successCallback;
            this.IlIllIlIIl = z;
        }

        public void run() {
            if (lllIIIlIlI.this.llIIlIlIIl == null) {
                Log.m40229e(lllIIIlIlI.this, "Camera not yet initialized. Unable to change torch state!", new Object[0]);
                SuccessCallback successCallback = this.llIIlIlIIl;
                if (successCallback != null) {
                    successCallback.onOperationDone(false);
                }
            }
            lllllIlIll IllIIIIllI = lllIIIlIlI.this.lIIIIIlIlI;
            if (IllIIIIllI != null && lllIIIlIlI.this.lllIlIlIIl()) {
                IllIIIIllI.llIIlIIlll();
            }
            try {
                IllIIlIIII illIIlIIII = new IllIIlIIII(lllIIIlIlI.this.llIIlIlIIl);
                if (!illIIlIIII.IlIllIlIIl(this.IlIllIlIIl)) {
                    new Exception("FLASH_MODE_OFF not supported");
                }
                illIIlIIII.llIIlIlIIl(lllIIIlIlI.this.llIIlIlIIl);
                lllIIIlIlI.this.llIIIlllll();
                SuccessCallback successCallback2 = this.llIIlIlIIl;
                if (successCallback2 != null) {
                    successCallback2.onOperationDone(true);
                }
            } catch (RuntimeException unused) {
                SuccessCallback successCallback3 = this.llIIlIlIIl;
                if (successCallback3 != null) {
                    successCallback3.onOperationDone(false);
                }
            }
        }
    }

    /* compiled from: line */
    public class IllIIIIllI implements Runnable {
        public final /* synthetic */ Context IlIllIlIIl;
        public final /* synthetic */ com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl llIIlIlIIl;

        public IllIIIIllI(com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl ilIllIlIIl, Context context) {
            this.llIIlIlIIl = ilIllIlIIl;
            this.IlIllIlIIl = context;
        }

        public void run() {
            try {
                boolean z = false;
                Log.m40231i(lllIIIlIlI.this, "Opening camera...", new Object[0]);
                lllIIIlIlI llliiilili = lllIIIlIlI.this;
                Camera unused = llliiilili.llIIlIlIIl = lllIIIlIlI.llIIlIlIIl(llliiilili, this.llIIlIlIIl.IlIllIlIIl());
                lllIIIlIlI llliiilili2 = lllIIIlIlI.this;
                IlIIIIIlll unused2 = llliiilili2.llIIIlllll = ((llIlIlIlIl) llliiilili2.IlIlllllII).llIIlIlIIl(this.IlIllIlIIl, lllIIIlIlI.this.llIIlIlIIl, this.llIIlIlIIl);
                lllIIIlIlI llliiilili3 = lllIIIlIlI.this;
                Log.m40231i(llliiilili3, "Camera strategy: {}", llliiilili3.llIIIlllll);
                lllIIIlIlI llliiilili4 = lllIIIlIlI.this;
                Log.m40231i(llliiilili4, "Camera sensor orientation is {}", Integer.valueOf(llliiilili4.IlIIlIIIII));
                if (lllIIIlIlI.this.IlIIlIIIII == 0) {
                    if (lllIIIlIlI.this.IlIIlllIIl == CameraType.CAMERA_BACKFACE) {
                        int unused3 = lllIIIlIlI.this.IlIIlIIIII = 90;
                    } else if (lllIIIlIlI.this.IlIIlllIIl == CameraType.CAMERA_FRONTFACE) {
                        int unused4 = lllIIIlIlI.this.IlIIlIIIII = 270;
                    }
                }
                if (lllIIIlIlI.this.llIllIIlll != 0) {
                    lllIIIlIlI llliiilili5 = lllIIIlIlI.this;
                    Log.m40231i(llliiilili5, "Rotating camera preview by {} degrees!", Integer.valueOf(llliiilili5.llIllIIlll));
                    Camera lllIIlIIlI = lllIIIlIlI.this.llIIlIlIIl;
                    int IlIllIlIIl2 = lllIIIlIlI.this.llIllIIlll;
                    int IlIlIlIIlI = lllIIIlIlI.this.IlIIlIIIII;
                    if (lllIIIlIlI.this.IlIIlllIIl == CameraType.CAMERA_FRONTFACE) {
                        z = true;
                    }
                    com.microblink.blinkbarcode.util.llIIlIlIIl.llIIlIlIIl(lllIIlIIlI, IlIllIlIIl2, IlIlIlIIlI, z);
                }
                lllIIIlIlI.lllIlIlIIl(lllIIIlIlI.this);
            } catch (Throwable th) {
                if (lllIIIlIlI.this.llIIlIlIIl != null) {
                    lllIIIlIlI.this.llIIlIlIIl.release();
                    Camera unused5 = lllIIIlIlI.this.llIIlIlIIl = null;
                }
                if (!lllIIIlIlI.this.lIlllIlIlI.get()) {
                    lllIIIlIlI.this.lIllIIlIIl.llIIlIlIIl(th);
                }
            }
        }
    }

    /* compiled from: line */
    public class IllIIIllII implements Runnable {
        public final /* synthetic */ lllIIlIIlI llIIlIlIIl;

        public IllIIIllII(lllIIlIIlI llliiliili) {
            this.llIIlIlIIl = llliiliili;
        }

        public void run() {
            if (lllIIIlIlI.this.llIIlIlIIl == null || lllIIIlIlI.this.IllIIlIIII) {
                Log.m40235w(lllIIIlIlI.this, "Camera is released, cannot request another frame", new Object[0]);
                return;
            }
            if (this.llIIlIlIIl.llIIlIIlll() != null) {
                lllIIIlIlI.this.llIIlIlIIl.addCallbackBuffer(this.llIIlIlIIl.llIIlIIlll());
            }
            lllllIlIll IllIIIIllI = lllIIIlIlI.this.lIIIIIlIlI;
            if (IllIIIIllI != null) {
                IllIIIIllI.llIIlIlIIl();
            }
        }
    }

    /* compiled from: line */
    public class IllIIlIIII implements ShakeCallback {

        /* compiled from: line */
        public class IlIllIlIIl implements Runnable {
            public IlIllIlIIl() {
            }

            public void run() {
                lllllIlIll IllIIIIllI = lllIIIlIlI.this.lIIIIIlIlI;
                if (IllIIIIllI != null) {
                    IllIIIIllI.IllIIIIllI();
                    if (!IllIIIIllI.IlIllIlIIl() || lllIIIlIlI.this.IIlIIIllIl.lllIIIlIlI()) {
                        IllIIIIllI.IIlIIIllIl();
                    }
                    IllIIIIllI.llIIlIlIIl(false);
                }
            }
        }

        /* compiled from: line */
        public class llIIlIlIIl implements Runnable {
            public llIIlIlIIl() {
            }

            public void run() {
                lllllIlIll IllIIIIllI = lllIIIlIlI.this.lIIIIIlIlI;
                if (IllIIIIllI != null) {
                    IllIIIIllI.lIIIIIllll();
                }
            }
        }

        private IllIIlIIII() {
        }

        public void onShakingStarted() {
            Log.m40233v(this, "shaking started, this = {}, focus manager: {}, camera queue: {}", this, lllIIIlIlI.this.lIIIIIlIlI, lllIIIlIlI.this.lllllIlIll);
            if (lllIIIlIlI.this.lIIIIIlIlI != null) {
                lllIIIlIlI.this.lllllIlIll.llIIlIlIIl(new llIIlIlIIl());
            }
            if (lllIIIlIlI.this.lIIIIIllll != null) {
                lllIIIlIlI.this.lIIIIIllll.onShakingStarted();
            }
            if (lllIIIlIlI.this.lllIIIlIlI != null) {
                lllIIIlIlI.this.lllIIIlIlI.onShakingStarted();
            }
        }

        public void onShakingStopped() {
            Log.m40233v(this, "shaking stopped, this = {}, focus manager: {}, camera queue: {}", this, lllIIIlIlI.this.lIIIIIlIlI, lllIIIlIlI.this.lllllIlIll);
            if (lllIIIlIlI.this.lIIIIIlIlI != null) {
                lllIIIlIlI.this.lllllIlIll.llIIlIlIIl(new IlIllIlIIl());
            }
            if (lllIIIlIlI.this.lIIIIIllll != null) {
                lllIIIlIlI.this.lIIIIIllll.onShakingStopped();
            }
            if (lllIIIlIlI.this.lllIIIlIlI != null) {
                lllIIIlIlI.this.lllIIIlIlI.onShakingStopped();
            }
        }

        public /* synthetic */ IllIIlIIII(lllIIIlIlI llliiilili, lIIIIIllll liiiiillll) {
            this();
        }
    }

    /* compiled from: line */
    public class lIIIIIllll implements Runnable {
        public final /* synthetic */ int llIIlIlIIl;

        public lIIIIIllll(int i) {
            this.llIIlIlIIl = i;
        }

        public void run() {
            lllllIlIll IllIIIIllI = lllIIIlIlI.this.lIIIIIlIlI;
            if (IllIIIIllI.IllIIIllII()) {
                IllIIIIllI.llIIlIIlll();
            }
            boolean z = true;
            Log.m40231i(lllIIIlIlI.this, "Rotating camera preview by {} degrees!", Integer.valueOf(this.llIIlIlIIl));
            Camera lllIIlIIlI = lllIIIlIlI.this.llIIlIlIIl;
            int i = this.llIIlIlIIl;
            int IlIlIlIIlI = lllIIIlIlI.this.IlIIlIIIII;
            if (lllIIIlIlI.this.IlIIlllIIl != CameraType.CAMERA_FRONTFACE) {
                z = false;
            }
            com.microblink.blinkbarcode.util.llIIlIlIIl.llIIlIlIIl(lllIIlIIlI, i, IlIlIlIIlI, z);
            int unused = lllIIIlIlI.this.llIllIIlll = this.llIIlIlIIl;
        }
    }

    /* compiled from: line */
    public class lIlIIIIlIl implements Runnable {
        public lIlIIIIlIl() {
        }

        public void run() {
            lllllIlIll IllIIIIllI = lllIIIlIlI.this.lIIIIIlIlI;
            if (IllIIIIllI != null) {
                Log.m40231i(lllIIIlIlI.this, "Pausing focus manager", new Object[0]);
                IllIIIIllI.lIIIIIllll();
            }
            com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl lIlIIIIlIl = lllIIIlIlI.this.IlIllIlIIl;
            if (lIlIIIIlIl != null) {
                Log.m40231i(lllIIIlIlI.this, "Pausing accelerometer", new Object[0]);
                lIlIIIIlIl.llIIIlllll();
            }
            lllIIIlIlI.llIIlIIlll(lllIIIlIlI.this);
            IlIIIIIlll unused = lllIIIlIlI.this.llIIIlllll = null;
            boolean unused2 = lllIIIlIlI.this.IllIIlIIII = false;
        }
    }

    /* compiled from: line */
    public class llIIIlllll implements Camera.PreviewCallback {
        private long llIIlIlIIl = 0;

        public llIIIlllll() {
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (lllIIIlIlI.this.llIIlIIlll == null) {
                Log.m40235w(lllIIIlIlI.this, "Cannot obtain frame by its buffer because frame pool has been disposed", new Object[0]);
                return;
            }
            lIllIIlIIl llIIlIlIIl2 = lllIIIlIlI.this.llIIlIIlll.llIIlIlIIl(bArr);
            if (llIIlIlIIl2 == null) {
                Log.m40227d(lllIIIlIlI.this, "Cannot find frame by its buffer. This is OK if buffered callback is disabled. Otherwise this is an error!", new Object[0]);
                llIIlIlIIl2 = lllIIIlIlI.this.llIIlIIlll.IlIllIlIIl();
                llIIlIlIIl2.llIIlIlIIl(bArr);
            }
            long j = this.llIIlIlIIl;
            this.llIIlIlIIl = 1 + j;
            llIIlIlIIl2.IlIllIlIIl(j);
            llIIlIlIIl2.llIIlIlIIl(lllIIIlIlI.this.IlIllIlIIl.IlIllIlIIl());
            llIIlIlIIl2.IlIllIlIIl(lllIIIlIlI.this.llIIlIlIIl());
            Log.m40233v(lllIIIlIlI.this, "Frame {} has arrived from camera", Long.valueOf(llIIlIlIIl2.lIlIIIIlIl()));
            if (lllIIIlIlI.this.IllIIIllII == null || !lllIIIlIlI.this.IllIIIllII.canReceiveFrame()) {
                llIIlIlIIl2.IllIIIllII();
            } else {
                lllIIIlIlI.this.IllIIIllII.onCameraFrame(llIIlIlIIl2);
            }
        }
    }

    /* compiled from: line */
    public class llIIlIIlll implements Runnable {
        public llIIlIIlll() {
        }

        public void run() {
            IIlIlllIIl iIlIlllIIl;
            if (lllIIIlIlI.this.llIIlIlIIl != null && lllIIIlIlI.this.IlIlIlIIlI != (iIlIlllIIl = IIlIlllIIl.CAPTURING) && lllIIIlIlI.this.lIlIIIIlIl) {
                IIlIlllIIl unused = lllIIIlIlI.this.IlIlIlIIlI = iIlIlllIIl;
                lllIIIlIlI.this.llIIlIlIIl.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, lllIIIlIlI.this.IlIIIIIlll);
            }
        }
    }

    /* compiled from: line */
    public class llIIlIlIIl implements Runnable {
        public final /* synthetic */ Rect[] llIIlIlIIl;

        public llIIlIlIIl(Rect[] rectArr) {
            this.llIIlIlIIl = rectArr;
        }

        public void run() {
            lllllIlIll IllIIIIllI = lllIIIlIlI.this.lIIIIIlIlI;
            if (IllIIIIllI != null) {
                IllIIIIllI.llIIlIlIIl(this.llIIlIlIIl);
            }
        }
    }

    /* renamed from: com.microblink.blinkbarcode.secured.lllIIIlIlI$lllIIIlIlI  reason: collision with other inner class name */
    /* compiled from: line */
    public class C22036lllIIIlIlI implements Runnable {
        public C22036lllIIIlIlI() {
        }

        public void run() {
            Log.m40227d(lllIIIlIlI.this, "Triggering autofocus", new Object[0]);
            lllllIlIll IllIIIIllI = lllIIIlIlI.this.lIIIIIlIlI;
            if (IllIIIIllI != null && !IllIIIIllI.IllIIIllII()) {
                IllIIIIllI.llIIlIlIIl(true);
            }
        }
    }

    /* compiled from: line */
    public class lllIlIlIIl implements Runnable {
        public final /* synthetic */ float llIIlIlIIl;

        public lllIlIlIIl(float f) {
            this.llIIlIlIIl = f;
        }

        public void run() {
            if (lllIIIlIlI.this.llIIlIlIIl != null) {
                try {
                    new IllIIlIIII(lllIIIlIlI.this.llIIlIlIIl).llIIlIlIIl(lllIIIlIlI.this.lllIlIlIIl.llIIlIlIIl(this.llIIlIlIIl)).llIIlIlIIl(lllIIIlIlI.this.llIIlIlIIl);
                } catch (RuntimeException unused) {
                    Log.m40229e(lllIIIlIlI.this, "Failed to set zoom level to {}", Float.valueOf(this.llIIlIlIIl));
                }
            }
        }
    }

    public lllIIIlIlI(com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl lliililiil, lIlIIlIIll liliiliill, com.microblink.blinkbarcode.hardware.camera.llIIlIlIIl lliililiil2, com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl ilIllIlIIl) {
        this.IlIllIlIIl = lliililiil;
        com.microblink.blinkbarcode.hardware.IllIIIllII llIIlIIlll2 = com.microblink.blinkbarcode.hardware.IllIIIllII.llIIlIIlll();
        this.lllIlIlIIl = llIIlIIlll2;
        if (llIIlIIlll2.lIIIIIlIlI()) {
            this.IllIIIllII = lliililiil2;
            this.IIlIIIllIl = ilIllIlIIl;
            this.IlIlllllII = liliiliill;
            if (this.IlIllIlIIl == null || liliiliill == null) {
                throw new NullPointerException("Camera manager requires accelerometer manager and camera strategy factory to be non-null");
            } else if (lliililiil2 != null) {
                if (ilIllIlIIl == null) {
                    this.IIlIIIllIl = new com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl();
                }
                this.IlIllIlIIl.llIIlIlIIl((ShakeCallback) new IllIIlIIII(this, (lIIIIIllll) null));
                this.lllIIIlIlI = ilIllIlIIl.llIIlIIlll();
                com.microblink.blinkbarcode.util.IllIIIllII llIIlIlIIl2 = lIIIIIlIlI.INSTANCE.llIIlIlIIl();
                this.lllllIlIll = llIIlIlIIl2;
                this.IllIIIIllI = new lllIlIlIIl(this.lllIlIlIIl, llIIlIlIIl2, new lIIIIIllll(this));
            } else {
                throw new NullPointerException("Camera delegate can't be null.");
            }
        } else {
            throw new IllegalArgumentException("Provided device manager must have device lists loaded!");
        }
    }

    public static com.microblink.blinkbarcode.util.IllIIIllII IlIlllllII(lllIIIlIlI llliiilili) {
        return llliiilili.lllllIlIll;
    }

    public static lllllIlIll IllIIlIIII(lllIIIlIlI llliiilili) {
        return llliiilili.lIIIIIlIlI;
    }

    public static Camera llIIlIlIIl(lllIIIlIlI llliiilili, CameraType cameraType) {
        llliiilili.getClass();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        boolean z = false;
        int i4 = -1;
        boolean z2 = false;
        for (int i5 = 0; i5 < numberOfCameras; i5++) {
            Camera.getCameraInfo(i5, cameraInfo);
            int i6 = cameraInfo.facing;
            if (i6 == 1) {
                if (i2 == -1) {
                    i4 = cameraInfo.orientation;
                    Log.m40231i(llliiilili, "Front facing orientation: {}", Integer.valueOf(i4));
                    z = llliiilili.llIIlIlIIl(i5);
                    i2 = i5;
                } else if (z) {
                    Log.m40235w(llliiilili, "Handling multiple front cameras with autofocus currently not supported! Will use the first found '{}'", Integer.valueOf(i2));
                } else if (llliiilili.llIIlIlIIl(i5)) {
                    i4 = cameraInfo.orientation;
                    Log.m40231i(llliiilili, "Front facing orientation: {}", Integer.valueOf(i4));
                    i2 = i5;
                    z = true;
                }
            } else if (i6 == 0) {
                if (i == -1) {
                    i3 = cameraInfo.orientation;
                    Log.m40231i(llliiilili, "Back facing orientation: {}", Integer.valueOf(i3));
                    z2 = llliiilili.llIIlIlIIl(i5);
                    i = i5;
                } else if (z2) {
                    Log.m40235w(llliiilili, "Handling multiple back cameras with autofocus currently not supported. Will use the first found '{}'", Integer.valueOf(i));
                } else if (llliiilili.llIIlIlIIl(i5)) {
                    i3 = cameraInfo.orientation;
                    i = i5;
                    z2 = true;
                }
            }
        }
        CameraType cameraType2 = CameraType.CAMERA_BACKFACE;
        if (cameraType != cameraType2) {
            CameraType cameraType3 = CameraType.CAMERA_FRONTFACE;
            if (cameraType == cameraType3) {
                if (i2 > -1) {
                    llliiilili.IlIIlllIIl = cameraType3;
                    llliiilili.IlIIlIIIII = i4;
                    return Camera.open(i2);
                }
                throw new RuntimeException("Device does not have front facing camera!");
            } else if (i > -1) {
                llliiilili.IlIIlllIIl = cameraType2;
                llliiilili.IlIIlIIIII = i3;
                return Camera.open(i);
            } else if (i2 > -1) {
                llliiilili.IlIIlllIIl = cameraType3;
                llliiilili.IlIIlIIIII = i4;
                return Camera.open(i2);
            } else {
                throw new RuntimeException("Device does not have cameras!");
            }
        } else if (i > -1) {
            llliiilili.IlIIlllIIl = cameraType2;
            llliiilili.IlIIlIIIII = i3;
            return Camera.open(i);
        } else {
            throw new RuntimeException("Device does not have back facing camera!");
        }
    }

    public void dispose() {
        if (this.lIlllIlIlI.compareAndSet(false, true)) {
            this.lllllIlIll.llIIlIlIIl(new IlIllIlIIl());
        }
    }

    public void finalize() throws Throwable {
        dispose();
        super.finalize();
    }

    public int llIIlIIlll() {
        return this.IlIIlIIIII;
    }

    public boolean lllIlIlIIl() {
        lllllIlIll lllllilill = this.lIIIIIlIlI;
        return lllllilill != null && lllllilill.IllIIIllII();
    }

    public static void llIIlIIlll(lllIIIlIlI llliiilili) {
        Camera camera = llliiilili.llIIlIlIIl;
        if (camera != null) {
            camera.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
            Log.m40231i(llliiilili, "Stopping camera preview", new Object[0]);
            llliiilili.lIlIIIIlIl = false;
            llliiilili.llIIlIlIIl.stopPreview();
            if (!llliiilili.lIlllIlIlI.get()) {
                llliiilili.lIllIIlIIl.IlIllIlIIl();
            }
            Log.m40231i(llliiilili, "Releasing camera", new Object[0]);
            llliiilili.llIIlIlIIl.release();
            Log.m40231i(llliiilili, "Camera released", new Object[0]);
            llliiilili.llIIlIlIIl = null;
            llliiilili.lllIIlIIlI = null;
            llliiilili.IlIllIlllI = null;
        }
    }

    public boolean IIlIIIllIl() {
        Boolean bool = this.lllIIlIIlI;
        if (bool != null) {
            return bool.booleanValue();
        }
        Log.m40229e(this, "Camera not yet initialized. Unable to determine if torch is supported!", new Object[0]);
        return false;
    }

    public final CameraType IlIllIlllI() {
        return this.IlIIlllIIl;
    }

    public void IllIIIIllI() {
        if (!this.IlllIIIllI) {
            Log.m40231i(this, "Stop preview has already been called. Ignoring this call!", new Object[0]);
            return;
        }
        this.IlllIIIllI = false;
        Log.m40231i(this, "Camera1Manager.stopPreview", new Object[0]);
        this.IllIIlIIII = true;
        this.lllllIlIll.llIIlIlIIl(new lIlIIIIlIl());
    }

    public void IllIIIllII() {
        this.lllllIlIll.llIIlIlIIl(new llIIlIIlll());
    }

    public boolean lIIIIIllll() {
        return this.IlIIlIIIII == 270;
    }

    public boolean lIlIIIIlIl() {
        return this.IlIllIlIIl.IlIllIlIIl();
    }

    public void llIIIlllll() {
        lllllIlIll lllllilill = this.lIIIIIlIlI;
        if (lllllilill != null && !lllllilill.IllIIIllII()) {
            this.lllllIlIll.llIIlIlIIl(new C22036lllIIIlIlI());
        }
    }

    public com.microblink.blinkbarcode.hardware.camera.lIlIIIIlIl lllIIIlIlI() {
        return this.IllIIIIllI;
    }

    public static void lllIlIlIIl(lllIIIlIlI llliiilili) {
        if (llliiilili.lIlIIIIlIl) {
            Log.m40235w(llliiilili, "Preview is already active", new Object[0]);
            return;
        }
        try {
            lllIlIlIIl lllililiil = llliiilili.IllIIIIllI;
            int i = 3;
            if (lllililiil.IllIIIIllI() && !llliiilili.lIlIIIIlIl) {
                Camera camera = llliiilili.llIIlIlIIl;
                if (camera != null) {
                    lllililiil.llIIlIlIIl(camera);
                    IllIIlIIII illIIlIIII = new IllIIlIIII(llliiilili.llIIlIlIIl);
                    if (llliiilili.llIIlIIIll == null) {
                        llliiilili.llIIlIlIIl(lllililiil);
                    }
                    IllIIIllII.llIIlIlIIl lliililiil = llliiilili.lIllIIlIIl;
                    Camera.Size size = llliiilili.llIIlIIIll;
                    lliililiil.llIIlIlIIl(size.width, size.height);
                    Log.m40227d(llliiilili, "Resuming camera with preview size {}x{}", Integer.valueOf(llliiilili.llIIlIIIll.width), Integer.valueOf(llliiilili.llIIlIIIll.height));
                    illIIlIIII.llIIlIlIIl(llliiilili.llIIlIIIll).llIIlIlIIl(llliiilili.lllIlIlIIl.llIIlIlIIl(llliiilili.IIlIIIllIl.llIIIlllll()));
                    lllllIlIll llIIlIlIIl2 = llliiilili.llIIlIlIIl(illIIlIIII);
                    llliiilili.lIIIIIlIlI = llIIlIlIIl2;
                    llIIlIlIIl2.getClass();
                    Log.m40233v(llliiilili, "Setting following parameters to camera: {}", illIIlIIII.toString());
                    illIIlIIII.llIIlIlIIl(llliiilili.llIIlIlIIl);
                    Camera.Size size2 = llliiilili.llIIlIIIll;
                    int bitsPerPixel = ImageFormat.getBitsPerPixel(illIIlIIII.IllIIIllII().getPreviewFormat());
                    if (bitsPerPixel == -1) {
                        bitsPerPixel = 24;
                    }
                    int i2 = ((size2.width * size2.height) * bitsPerPixel) / 8;
                    llliiilili.llIIlIlIIl.setPreviewCallbackWithBuffer(llliiilili.IIIIIIIIII);
                    if (com.microblink.blinkbarcode.hardware.IllIIIllII.IlIllIlllI() == 1) {
                        i = 1;
                    }
                    Camera.Size size3 = llliiilili.llIIlIIIll;
                    llliiilili.llIIlIIlll = new IlIlIlIIlI(size3.width, size3.height, i2, i, llliiilili, llliiilili.IIlIIIllIl.llIIlIlIIl());
                    lIllIIlIIl[] lilliiliilArr = new lIllIIlIIl[i];
                    for (int i3 = 0; i3 < i; i3++) {
                        lilliiliilArr[i3] = llliiilili.llIIlIIlll.IlIllIlIIl();
                    }
                    for (int i4 = 0; i4 < i; i4++) {
                        lilliiliilArr[i4].IllIIIllII();
                    }
                    lllllIlIll lllllilill = llliiilili.lIIIIIlIlI;
                    Log.m40233v(llliiilili, "Focus manager: {}", lllllilill);
                    if (lllllilill != null) {
                        lllllilill.llIIlIlIIl(llliiilili.llIIlIlIIl);
                        lllllilill.IllIIIIllI();
                        llliiilili.llIIlIlIIl.startPreview();
                        llliiilili.lIlIIIIlIl = true;
                        if (llliiilili.llIIlIlIIl != null) {
                            Boolean IllIIIIllI2 = new IllIIlIIII(llliiilili.llIIlIlIIl).IllIIIIllI();
                            llliiilili.lllIIlIIlI = IllIIIIllI2;
                            IllIIIIllI2.booleanValue();
                        }
                        int llIIlIlIIl3 = llliiilili.llIIIlllll.llIIlIlIIl();
                        if (llIIlIlIIl3 > 0) {
                            llliiilili.lllllIlIll.llIIlIlIIl(new IlIllIlllI(llliiilili), (long) llIIlIlIIl3);
                        } else {
                            com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl lliililiil2 = llliiilili.IlIllIlIIl;
                            if (lliililiil2 != null) {
                                lliililiil2.IllIIIllII();
                            }
                        }
                        llliiilili.lIllIIlIIl.llIIlIlIIl();
                        return;
                    }
                    throw new IllegalStateException("Method prepareCameraParametersAndFocusManager did not prepare focus manager!");
                }
            }
            Log.m40227d(llliiilili, "Camera still hasn't got surface or preview already active or camera is null (due to error). Cannot start preview!", new Object[0]);
            Log.m40227d(llliiilili, "surface sane: {}; previewActive: {}, camera: {}", Boolean.valueOf(llliiilili.IllIIIIllI.IllIIIIllI()), Boolean.valueOf(llliiilili.lIlIIIIlIl), llliiilili.llIIlIlIIl);
        } catch (RuntimeException e) {
            Log.m40230e(llliiilili, e, "Setting camera parameters failed!", new Object[0]);
            Log.m40229e(llliiilili, "Preview width: {} height: {}", Integer.valueOf(llliiilili.llIIlIIIll.width), Integer.valueOf(llliiilili.llIIlIIIll.height));
        } catch (Throwable th) {
            if (!llliiilili.lIlllIlIlI.get()) {
                llliiilili.lIllIIlIIl.llIIlIlIIl(th);
                llliiilili.lIlIIIIlIl = false;
                llliiilili.llIIlIlIIl.release();
                llliiilili.llIIlIlIIl = null;
            }
        }
    }

    public void IlIllIlIIl(int i) {
        this.llIllIIlll = i;
        if (this.lIlIIIIlIl) {
            this.lllllIlIll.llIIlIlIIl(new lIIIIIllll(i));
        }
    }

    public Boolean IlIllIlIIl() {
        return this.IlIllIlllI;
    }

    public void llIIlIlIIl(ShakeCallback shakeCallback) {
        this.lIIIIIllll = shakeCallback;
    }

    public void llIIlIlIIl(Context context, com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl ilIllIlIIl, IllIIIllII.llIIlIlIIl lliililiil) {
        if (this.IlllIIIllI) {
            Log.m40231i(this, "Start preview has already been called. Ignoring this call!", new Object[0]);
            return;
        }
        Log.m40231i(this, "Camera1Manager.startPreview", new Object[0]);
        this.IlllIIIllI = true;
        this.lIllIIlIIl = lliililiil;
        this.IIlIIIllIl = ilIllIlIIl;
        this.lllllIlIll.llIIlIlIIl(new IllIIIIllI(ilIllIlIIl, context));
    }

    public boolean llIIlIlIIl() {
        lllllIlIll lllllilill = this.lIIIIIlIlI;
        return lllllilill != null && lllllilill.lIlIIIIlIl();
    }

    public void llIIlIlIIl(boolean z, SuccessCallback successCallback) {
        boolean z2;
        Boolean bool = this.lllIIlIIlI;
        if (bool != null) {
            z2 = bool.booleanValue();
        } else {
            Log.m40229e(this, "Camera not yet initialized. Unable to determine if torch is supported!", new Object[0]);
            z2 = false;
        }
        if (!z2) {
            Log.m40229e(this, "Camera does not support torch! Cannot change torch state!", new Object[0]);
            if (successCallback != null) {
                successCallback.onOperationDone(false);
                return;
            }
            return;
        }
        this.lllllIlIll.llIIlIlIIl(new IlIllIlllI(successCallback, z));
    }

    public void llIIlIlIIl(float f) {
        this.lllllIlIll.llIIlIlIIl(new lllIlIlIIl(f));
    }

    public void llIIlIlIIl(Rect[] rectArr) {
        if (!this.lllIlIlIIl.lllllIlIll()) {
            com.microblink.blinkbarcode.util.IllIIIllII illIIIllII = this.lllllIlIll;
            if (illIIIllII != null && this.lIIIIIlIlI != null) {
                illIIIllII.llIIlIlIIl(new llIIlIlIIl(rectArr));
                return;
            }
            return;
        }
        Log.m40229e(this, "Setting metering areas not supported on this device", new Object[0]);
    }

    private lllllIlIll llIIlIlIIl(IllIIlIIII illIIlIIII) {
        String str;
        lllllIlIll lllllilill;
        boolean IllIIlIIII2 = this.IIlIIIllIl.IllIIlIIII();
        if (IllIIlIIII2 && this.IIlIIIllIl.llIIIlllll() == 0.0f) {
            this.IIlIIIllIl.llIIlIlIIl(0.2f);
        }
        if (IllIIlIIII2) {
            Log.m40231i(this, "Optimizing camera parameters for near scanning", new Object[0]);
            str = illIIlIIII.llIIlIIlll();
        } else {
            str = illIIlIIII.IIlIIIllIl();
        }
        com.microblink.blinkbarcode.hardware.IllIIIllII illIIIllII = this.lllIlIlIIl;
        com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl ilIllIlIIl = this.IIlIIIllIl;
        com.microblink.blinkbarcode.hardware.camera.llIIlIlIIl lliililiil = this.IllIIIllII;
        str.hashCode();
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 3005871) {
            if (hashCode != 103652300) {
                if (hashCode == 910005312 && str.equals("continuous-picture")) {
                    c = 2;
                }
            } else if (str.equals("macro")) {
                c = 1;
            }
        } else if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
            c = 0;
        }
        if (c == 0) {
            Log.m40233v((Object) null, "Activated autofocus", new Object[0]);
            lllllilill = new llIIlIIIll(lliililiil, illIIIllII);
        } else if (c == 1) {
            Log.m40233v((Object) null, "Activated macro focus mode", new Object[0]);
            lllllilill = new llIIlIIIll(lliililiil, illIIIllII);
        } else if (c != 2) {
            Log.m40229e((Object) null, "Autofocus not supported", new Object[0]);
            if (!ilIllIlIIl.lllIlIlIIl()) {
                lllllilill = new lIlllIlIlI();
            } else {
                throw new AutoFocusRequiredButNotSupportedException("Autofocus is required, but not supported on this camera");
            }
        } else {
            Log.m40227d((Object) null, "Activated continous picture autofocus", new Object[0]);
            lllllilill = new IlIIlllIIl(lliililiil, illIIIllII, IllIIlIIII2);
        }
        this.IlIllIlllI = Boolean.valueOf(lllllilill.llIIIlllll());
        illIIlIIII.IlIllIlIIl(false);
        illIIlIIII.llIIlIlIIl();
        illIIlIIII.lIlIIIIlIl();
        illIIlIIII.IlIllIlIIl();
        illIIlIIII.IlIllIlllI();
        int i = com.microblink.blinkbarcode.hardware.IllIIIllII.lIlIIIIlIl;
        String str2 = Build.MODEL;
        if ("Nexus 4".equals(str2)) {
            illIIlIIII.lllIIIlIlI();
        } else if (str2.contains("Glass")) {
            illIIlIIII.lIIIIIllll();
        } else {
            illIIlIIII.llIIlIlIIl(30);
        }
        Log.m40233v(this, "Final parameters: {}", illIIlIIII.toString());
        return lllllilill;
    }

    private boolean llIIlIlIIl(int i) {
        Camera open = Camera.open(i);
        boolean llIIIlllll2 = new IllIIlIIII(open).llIIIlllll();
        open.release();
        return llIIIlllll2;
    }

    private void llIIlIlIIl(lllIlIlIIl lllililiil) {
        Camera.Size llIIlIlIIl2 = this.llIIIlllll.llIIlIlIIl(lllililiil.llIIIlllll(), lllililiil.IllIIIllII(), this.IlIIlllIIl);
        this.llIIlIIIll = llIIlIlIIl2;
        if (llIIlIlIIl2 != null) {
            Log.m40231i(this, "For surface size {}x{} and preset {}, selected preview size is {}x{}", Integer.valueOf(lllililiil.llIIIlllll()), Integer.valueOf(lllililiil.IllIIIllII()), this.IIlIIIllIl.IIlIIIllIl(), Integer.valueOf(this.llIIlIIIll.width), Integer.valueOf(this.llIIlIIIll.height));
            return;
        }
        throw new CameraResolutionTooSmallException("Camera preview size could not be chosen!");
    }

    public void llIIlIlIIl(lllIIlIIlI llliiliili) {
        IllIIIllII illIIIllII = new IllIIIllII(llliiliili);
        if (this.lllllIlIll == null) {
            return;
        }
        if (Looper.myLooper() == this.lllllIlIll.llIIlIlIIl().getLooper()) {
            illIIIllII.run();
        } else {
            this.lllllIlIll.llIIlIlIIl(illIIIllII);
        }
    }
}
