package com.iproov.sdk.cameray;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.iproov.sdk.cameray.C19771case;
import com.iproov.sdk.cameray.C19792try;
import com.iproov.sdk.core.C19898import;
import com.iproov.sdk.core.C19909while;
import com.iproov.sdk.logging.IPLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import p232do.C20820else;
import p232do.C20821for;
import p232do.C20822goto;
import p232do.C20824new;
import p232do.C20825this;
import p232do.C20826try;

/* renamed from: com.iproov.sdk.cameray.if */
/* compiled from: Camera2 */
public class C19783if implements C19792try {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f54047b = ("🎥2 " + C19783if.class.getSimpleName());

    /* renamed from: c */
    private static final RectF f54048c = new RectF(0.4f, 0.4f, 0.6f, 0.6f);

    /* renamed from: a */
    List<Surface> f54049a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Semaphore f54050d = new Semaphore(1);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C20822goto f54051e;

    /* renamed from: else  reason: not valid java name */
    protected final Surface f61748else;

    /* renamed from: f */
    private final ImageReader f54052f;

    /* renamed from: for  reason: not valid java name */
    protected final CameraManager f61749for;

    /* renamed from: g */
    private HandlerThread f54053g;

    /* renamed from: goto  reason: not valid java name */
    protected Surface f61750goto;

    /* renamed from: h */
    private HandlerThread f54054h;

    /* renamed from: i */
    private Handler f54055i;

    /* renamed from: if */
    protected final C19792try.C19793do f54056if;

    /* renamed from: j */
    private Handler f54057j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public CameraDevice f54058k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Object f54059l = new Object();

    /* renamed from: m */
    private C19767b f54060m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public CameraCaptureSession f54061n;

    /* renamed from: new  reason: not valid java name */
    protected final C19780for f61751new;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public RectF f54062o = f54048c;

    /* renamed from: p */
    private final CameraDevice.StateCallback f54063p = new C19785for();

    /* renamed from: q */
    private CameraCaptureSession.CaptureCallback f54064q = new C19784do();

    /* renamed from: com.iproov.sdk.cameray.if$do */
    /* compiled from: Camera2 */
    class C19784do extends CameraCaptureSession.CaptureCallback {
        C19784do() {
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            C19783if.this.f54056if.mo161946do(new C20825this(totalCaptureResult));
        }
    }

    /* renamed from: com.iproov.sdk.cameray.if$for */
    /* compiled from: Camera2 */
    public class C19785for extends CameraDevice.StateCallback {
        public C19785for() {
        }

        public void onClosed(CameraDevice cameraDevice) {
            C19783if.this.f54050d.release();
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            C19783if.this.m38733b();
            C19783if.this.f54056if.mo161947do((Exception) new C19771case(C19771case.C19772do.CAMERA_ERROR, "error camera disconnected"));
        }

        public void onError(CameraDevice cameraDevice, int i) {
            C19783if.this.m38733b();
            C19792try.C19793do doVar = C19783if.this.f54056if;
            C19771case.C19772do doVar2 = C19771case.C19772do.CAMERA_ERROR;
            doVar.mo161947do((Exception) new C19771case(doVar2, "error in camera: " + i));
        }

        public void onOpened(CameraDevice cameraDevice) {
            CameraDevice unused = C19783if.this.f54058k = cameraDevice;
            C19783if.this.f54050d.release();
            C19909while.m39264do(C19898import.AND2);
            try {
                C19783if ifVar = C19783if.this;
                C19783if ifVar2 = C19783if.this;
                ifVar.m38726a(new C19767b(cameraDevice, (C19780for) C19783if.this.m47470new(), ifVar2.f54049a, ifVar2.f54051e, C19783if.this.f54062o));
                C19783if ifVar3 = C19783if.this;
                ifVar3.f54056if.mo161945do(ifVar3.m47470new());
                C19783if.this.m47471this();
            } catch (Exception e) {
                C19783if.this.f54056if.mo161947do(e);
            }
        }
    }

    /* renamed from: com.iproov.sdk.cameray.if$if */
    /* compiled from: Camera2 */
    class C19786if extends CameraCaptureSession.StateCallback {
        C19786if() {
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            IPLog.m39305w(C19783if.f54047b, "CAMERA: onConfigureFailed");
            C19783if.this.f54056if.mo161947do((Exception) new C19771case(C19771case.C19772do.CAMERA_ERROR, "onConfigureFailed"));
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            synchronized (C19783if.this.f54059l) {
                if (C19783if.this.f54058k != null) {
                    CameraCaptureSession unused = C19783if.this.f54061n = cameraCaptureSession;
                    try {
                        C19783if.this.m38735c();
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: com.iproov.sdk.cameray.if$new */
    /* compiled from: Camera2 */
    public class C19787new implements ImageReader.OnImageAvailableListener {
        public C19787new() {
        }

        public void onImageAvailable(ImageReader imageReader) {
            Image image;
            try {
                synchronized (C19783if.this.f54059l) {
                    image = imageReader.acquireLatestImage();
                    if (image != null) {
                        C19909while.m39264do(C19898import.AND3);
                        if (image.getHeight() == C19783if.this.f61751new.mo161920a().mo170629do() || image.getWidth() == C19783if.this.f61751new.mo161920a().mo170632if()) {
                            C19909while.m39264do(C19898import.AND14);
                        }
                        C19795while whileR = new C19795while(image);
                        image.close();
                        C19783if.this.mo161924do((C20821for) whileR);
                    }
                }
            } catch (RuntimeException e) {
                if (C19783if.this.m38731a(e)) {
                    image = null;
                } else {
                    throw e;
                }
            } catch (Exception e2) {
                String a = C19783if.f54047b;
                IPLog.m39301e(a, "Corrupt frame? " + e2.toString());
                e2.printStackTrace();
                C19783if.this.f54056if.mo161947do((Exception) new C19771case(C19771case.C19772do.CAMERA_ERROR, "Frame not available, perhaps corrupt", e2));
            } catch (Throwable th) {
                image.close();
                throw th;
            }
        }
    }

    public C19783if(Context context, String str, C19768break breakR, C19792try.C19793do doVar, C20826try tryR, C20822goto gotoR) throws C19771case {
        this.f54056if = doVar;
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        this.f61749for = cameraManager;
        if (cameraManager != null) {
            HandlerThread handlerThread = new HandlerThread("Camera2 Capture");
            this.f54053g = handlerThread;
            handlerThread.start();
            this.f54057j = new Handler(this.f54053g.getLooper());
            HandlerThread handlerThread2 = new HandlerThread("Camera2");
            this.f54054h = handlerThread2;
            handlerThread2.start();
            this.f54055i = new Handler(this.f54054h.getLooper());
            try {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                Float f = C20820else.m41015do(cameraCharacteristics);
                this.f54051e = gotoR;
                C19780for forR = new C19780for(str, breakR, cameraCharacteristics, f, tryR);
                this.f61751new = forR;
                ImageReader newInstance = ImageReader.newInstance(forR.mo161920a().mo170632if(), forR.mo161920a().mo170629do(), 35, 2);
                this.f54052f = newInstance;
                newInstance.setOnImageAvailableListener(new C19787new(), this.f54057j);
                this.f61748else = newInstance.getSurface();
            } catch (CameraAccessException e) {
                throw new C19771case(C19771case.C19772do.CAMERA_PERMISSION_DENIED, (Throwable) e);
            }
        } else {
            throw new C19771case(C19771case.C19772do.CAMERA_ERROR, "Cannot open camera service");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m38733b() {
        Semaphore semaphore;
        synchronized (this.f54059l) {
            try {
                this.f54060m.mo161893a(this.f61748else);
                this.f54060m.mo161893a(this.f61750goto);
                m47469goto();
                boolean z = m47467else();
                this.f54060m = null;
                if (!z) {
                    semaphore = this.f54050d;
                    semaphore.release();
                }
            } catch (RuntimeException e) {
                try {
                    this.f54056if.mo161943do(C19792try.C19794if.FAILED_TO_STOP_GRACEFULLY, e);
                    this.f54060m = null;
                    semaphore = this.f54050d;
                } catch (Throwable th) {
                    this.f54060m = null;
                    this.f54050d.release();
                    throw th;
                }
            }
        }
    }

    /* renamed from: do */
    public void mo161898do() {
    }

    /* renamed from: for  reason: not valid java name */
    public void m47468for() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: goto  reason: not valid java name */
    public void m47469goto() {
        synchronized (this.f54059l) {
            CameraCaptureSession cameraCaptureSession = this.f54061n;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.f54061n = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: this  reason: not valid java name */
    public void m47471this() throws CameraAccessException {
        if (this.f54058k != null && this.f54057j != null) {
            m47469goto();
            this.f54058k.createCaptureSession(this.f54049a, new C19786if(), this.f54057j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m38725a(SurfaceTexture surfaceTexture) {
        try {
            if (!this.f54050d.tryAcquire(5000, TimeUnit.MILLISECONDS)) {
                this.f54056if.mo161947do((Exception) new RuntimeException("Time out waiting to lock camera opening."));
                return;
            }
            mo161927if(surfaceTexture);
            this.f61749for.openCamera(this.f61751new.mo161922c(), this.f54063p, (Handler) null);
        } catch (CameraAccessException | InterruptedException e) {
            this.f54056if.mo161947do((Exception) new C19771case(C19771case.C19772do.CAMERA_ERROR, "Failed to open camera", e));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m38735c() throws CameraAccessException {
        CameraCaptureSession cameraCaptureSession;
        synchronized (this.f54059l) {
            C19767b bVar = this.f54060m;
            if (!(bVar == null || (cameraCaptureSession = this.f54061n) == null)) {
                cameraCaptureSession.setRepeatingRequest(bVar.mo161891a(), this.f54064q, this.f54055i);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: else  reason: not valid java name */
    public boolean m47467else() {
        CameraDevice cameraDevice = this.f54058k;
        boolean z = cameraDevice != null;
        if (z) {
            cameraDevice.close();
            this.f54058k = null;
        }
        this.f54052f.close();
        this.f54053g.quit();
        this.f54053g = null;
        this.f54054h.quit();
        this.f54054h = null;
        this.f54055i = null;
        this.f54057j = null;
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: if */
    public void mo161927if(SurfaceTexture surfaceTexture) {
        surfaceTexture.setDefaultBufferSize(this.f61751new.mo161911if().mo170632if(), this.f61751new.mo161911if().mo170629do());
        Surface surface = new Surface(surfaceTexture);
        this.f61750goto = surface;
        this.f54049a = Collections.unmodifiableList(Arrays.asList(new Surface[]{this.f61748else, surface}));
    }

    /* renamed from: new  reason: not valid java name */
    public C20824new m47470new() {
        return this.f61751new;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m38728a(Runnable runnable) {
        try {
            if (!this.f54050d.tryAcquire(5000, TimeUnit.MILLISECONDS)) {
                this.f54056if.mo161947do((Exception) new RuntimeException("Time out waiting to lock camera closing."));
                return;
            }
            m38733b();
            runnable.run();
        } catch (InterruptedException e) {
            this.f54056if.mo161947do((Exception) new C19771case(C19771case.C19772do.CAMERA_ERROR, "Failed to close camera", e));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m38731a(RuntimeException runtimeException) {
        return "ImageReaderContext is not initialized".equals(runtimeException.getMessage());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38726a(C19767b bVar) {
        synchronized (this.f54059l) {
            this.f54060m = bVar;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: do */
    public void mo161924do(C20821for forR) {
        this.f54056if.mo161944do(forR);
    }

    /* renamed from: do */
    public void mo161900do(SurfaceTexture surfaceTexture) {
        Handler handler = this.f54055i;
        if (handler != null) {
            handler.post(new Runnable(surfaceTexture) {
                public final /* synthetic */ SurfaceTexture f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C19783if.this.m38725a(this.f$1);
                }
            });
        }
    }

    /* renamed from: do */
    public void mo161902do(Runnable runnable) {
        Handler handler = this.f54055i;
        if (handler != null) {
            handler.post(new Runnable(runnable) {
                public final /* synthetic */ Runnable f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C19783if.this.m38728a(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m38729a(boolean z) {
        synchronized (this.f54059l) {
            C19767b bVar = this.f54060m;
            if (bVar != null) {
                bVar.mo161894a(z);
                try {
                    m38735c();
                } catch (CameraAccessException | IllegalStateException e) {
                    this.f54056if.mo161943do(C19792try.C19794if.FAILED_TO_LOCK_EXPOSURE, e);
                }
            } else {
                return;
            }
        }
        this.f54056if.mo161948do(z);
    }

    /* renamed from: do */
    public void mo161903do(boolean z) {
        Handler handler = this.f54055i;
        if (handler != null) {
            handler.post(new Runnable(z) {
                public final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C19783if.this.m38729a(this.f$1);
                }
            });
        }
    }

    /* renamed from: do */
    public void mo161899do(RectF rectF) {
        Handler handler = this.f54055i;
        if (handler != null) {
            handler.post(new Runnable(rectF) {
                public final /* synthetic */ RectF f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C19783if.this.m38724a(this.f$1);
                }
            });
        }
    }

    /* renamed from: if */
    public C19775const mo161905if() {
        return C19775const.CAMERA2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m38724a(RectF rectF) {
        synchronized (this.f54059l) {
            this.f54062o = rectF;
            C19767b bVar = this.f54060m;
            if (bVar != null) {
                bVar.mo161892a(C19767b.m38666a(rectF, this.f61751new.m47464try(), 1000));
                try {
                    m38735c();
                } catch (CameraAccessException | IllegalStateException e) {
                    this.f54056if.mo161943do(C19792try.C19794if.FAILED_TO_LOCK_EXPOSURE, e);
                }
            }
        }
    }
}
