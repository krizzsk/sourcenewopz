package com.iproov.sdk.cameray;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.exifinterface.media.ExifInterface;
import com.iproov.sdk.cameray.C19771case;
import com.iproov.sdk.cameray.C19792try;
import com.iproov.sdk.core.C19898import;
import com.iproov.sdk.core.C19909while;
import com.iproov.sdk.logging.IPLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p232do.C20817break;
import p232do.C20820else;
import p232do.C20821for;
import p232do.C20822goto;
import p232do.C20824new;
import p232do.C20825this;
import p232do.C20826try;

/* renamed from: com.iproov.sdk.cameray.do */
/* compiled from: Camera1 */
public class C19776do implements C19792try {

    /* renamed from: a */
    private static final String f54019a = ("🎥1 " + C19776do.class.getSimpleName());

    /* renamed from: b */
    private static final Rect f54020b = new Rect(-200, -200, 200, 200);

    /* renamed from: c */
    private final int f54021c;

    /* renamed from: class  reason: not valid java name */
    protected SurfaceTexture f61744class;

    /* renamed from: const  reason: not valid java name */
    protected C20817break f61745const;

    /* renamed from: d */
    private final C19792try.C19793do f54022d;

    /* renamed from: e */
    private final Camera.PreviewCallback f54023e;

    /* renamed from: f */
    private final C19777do f54024f;

    /* renamed from: g */
    private final C20826try f54025g;

    /* renamed from: h */
    private final C20822goto f54026h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C19768break f54027i;

    /* renamed from: j */
    private final AtomicBoolean f54028j = new AtomicBoolean(false);

    /* renamed from: k */
    private volatile boolean f54029k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Camera f54030l;

    /* renamed from: m */
    private boolean f54031m;

    /* renamed from: n */
    private HandlerThread f54032n;

    /* renamed from: o */
    private Handler f54033o;

    /* renamed from: p */
    private Rect f54034p = f54020b;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public volatile Float f54035q;

    /* renamed from: throw  reason: not valid java name */
    protected final Camera.CameraInfo f61746throw;

    /* renamed from: com.iproov.sdk.cameray.do$do */
    /* compiled from: Camera1 */
    public class C19777do implements C20824new {

        /* renamed from: do */
        protected final Orientation f54036do;

        protected C19777do(Orientation orientation) {
            this.f54036do = orientation;
        }

        /* renamed from: do */
        public C19768break mo161909do() {
            return C19776do.this.f54027i;
        }

        /* renamed from: for  reason: not valid java name */
        public Float m47460for() {
            if (C19776do.this.f54030l == null) {
                return null;
            }
            return C19776do.this.f54035q;
        }

        /* renamed from: if */
        public C20817break mo161911if() {
            return new C20817break(C19776do.this.f61745const.mo170632if(), C19776do.this.f61745const.mo170629do());
        }

        /* renamed from: new  reason: not valid java name */
        public Orientation m47461new() {
            return this.f54036do;
        }
    }

    public C19776do(int i, C19768break breakR, C19792try.C19793do doVar, C20826try tryR, C20822goto gotoR) {
        this.f54021c = i;
        this.f54027i = breakR;
        this.f54022d = doVar;
        this.f54025g = tryR;
        this.f54026h = gotoR;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.f61746throw = cameraInfo;
        Camera.getCameraInfo(i, cameraInfo);
        this.f54024f = new C19777do(Orientation.findByDegrees(cameraInfo.orientation));
        HandlerThread handlerThread = new HandlerThread("Camera1", -8);
        this.f54032n = handlerThread;
        handlerThread.start();
        this.f54033o = new Handler(this.f54032n.getLooper());
        this.f54023e = new Camera.PreviewCallback(doVar) {
            public final /* synthetic */ C19792try.C19793do f$1;

            {
                this.f$1 = r2;
            }

            public final void onPreviewFrame(byte[] bArr, Camera camera) {
                C19776do.this.m38683a(this.f$1, bArr, camera);
            }
        };
    }

    /* renamed from: a */
    private List<C20817break> m38680a() {
        ArrayList arrayList = new ArrayList();
        Camera camera = this.f54030l;
        if (camera != null) {
            for (Camera.Size next : camera.getParameters().getSupportedPreviewSizes()) {
                arrayList.add(new C20817break(next.width, next.height));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private int[] m38690b() {
        Camera camera = this.f54030l;
        if (camera == null) {
            return null;
        }
        try {
            for (int[] next : camera.getParameters().getSupportedPreviewFpsRange()) {
                if (next[1] >= 30000) {
                    return next;
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m38692c() {
        if (this.f54030l == null || this.f54029k) {
            this.f54028j.set(false);
            this.f54029k = false;
            return;
        }
        try {
            this.f54022d.mo161942do();
            this.f54030l.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, new Camera.PictureCallback() {
                public final void onPictureTaken(byte[] bArr, Camera camera) {
                    C19776do.this.m38686a(bArr, camera);
                }
            });
        } catch (RuntimeException e) {
            try {
                this.f54022d.mo161943do(C19792try.C19794if.FAILED_TO_TAKE_PICTURE, e);
                m38689b(false);
                this.f54028j.set(false);
            } catch (RuntimeException e2) {
                this.f54022d.mo161947do((Exception) new C19771case(C19771case.C19772do.CAMERA_ERROR, "Failed to restart review after take picture failed", e2));
            }
        }
    }

    /* renamed from: new  reason: not valid java name */
    public C20824new m47457new() {
        return this.f54024f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: this  reason: not valid java name */
    public void m47458this() {
        Camera camera = this.f54030l;
        if (camera != null) {
            try {
                if (this.f54031m) {
                    camera.stopPreview();
                }
                this.f54030l.setPreviewTexture((SurfaceTexture) null);
                this.f54030l.setPreviewCallback((Camera.PreviewCallback) null);
            } catch (IOException | RuntimeException e) {
                this.f54022d.mo161943do(C19792try.C19794if.FAILED_TO_STOP_GRACEFULLY, e);
            } finally {
                this.f54030l.release();
                this.f54030l = null;
                this.f54032n.quit();
                this.f54032n = null;
                this.f54033o = null;
            }
        }
        this.f54031m = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: try  reason: not valid java name */
    public void m47459try() throws IOException {
        int i;
        Camera camera = this.f54030l;
        if (camera != null) {
            if (this.f61746throw.canDisableShutterSound) {
                camera.enableShutterSound(false);
            }
            Camera.Parameters parameters = this.f54030l.getParameters();
            this.f54035q = Float.valueOf(parameters.getFocalLength());
            parameters.setPreviewFormat(17);
            StringBuilder sb = new StringBuilder();
            sb.append("Zoom supported");
            sb.append(parameters.isZoomSupported());
            if (parameters.isZoomSupported() && (i = this.f54026h.mo162092do(C19775const.CAMERA1, Float.valueOf(this.f54030l.getParameters().getFocalLength()), parameters.getZoomRatios())) != -1) {
                parameters.setZoom(i);
            }
            this.f54030l.setParameters(parameters);
            C20817break breakR = this.f54025g.mo162071do(C19775const.CAMERA1, m38680a());
            this.f61745const = breakR;
            if (breakR != null) {
                parameters.setPreviewSize(breakR.mo170632if(), this.f61745const.mo170629do());
                this.f54030l.setPreviewTexture(this.f61744class);
                int[] b = m38690b();
                if (b != null) {
                    parameters.setPreviewFpsRange(b[0], b[1]);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Applying Preview Size: ");
                    sb2.append(this.f61745const.mo170632if());
                    sb2.append("x");
                    sb2.append(this.f61745const.mo170629do());
                    sb2.append(" @ ");
                    sb2.append(b[1] / 1000);
                    sb2.append("fps");
                }
                m38687a(parameters);
                this.f54030l.setParameters(parameters);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m38682a(SurfaceTexture surfaceTexture) {
        this.f61744class = surfaceTexture;
        if (this.f54030l == null) {
            try {
                this.f54030l = Camera.open(this.f54021c);
                m47459try();
                if (this.f61745const == null) {
                    m47458this();
                    this.f54022d.mo161947do((Exception) new C19771case(C19771case.C19772do.CAMERA_ERROR, "No preview size available!"));
                    return;
                }
                C19909while.m39264do(C19898import.AND2);
                this.f54030l.setPreviewCallback(this.f54023e);
                m38689b(true);
            } catch (IOException | RuntimeException e) {
                m47458this();
                this.f54022d.mo161947do((Exception) new C19771case(C19771case.C19772do.CAMERA_ERROR, "Failed to open camera", e));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m38683a(C19792try.C19793do doVar, byte[] bArr, Camera camera) {
        if (camera != null && bArr != null && bArr.length != 0) {
            try {
                C19791throw throwR = new C19791throw(this.f61745const.mo170632if(), this.f61745const.mo170629do(), bArr);
                C19909while.m39264do(C19898import.AND3);
                C19909while.m39264do(C19898import.AND14);
                mo161901do((C20821for) throwR);
            } catch (Exception e) {
                String str = f54019a;
                IPLog.m39301e(str, "Corrupt frame? " + e.toString());
                e.printStackTrace();
                doVar.mo161944do((C20821for) null);
            }
        }
    }

    /* renamed from: b */
    private void m38689b(boolean z) {
        Camera camera = this.f54030l;
        if (camera != null) {
            try {
                camera.setPreviewTexture(this.f61744class);
                this.f54030l.setPreviewCallback(this.f54023e);
                this.f54030l.startPreview();
                this.f54031m = true;
                if (z) {
                    this.f54022d.mo161945do(m47457new());
                }
            } catch (IOException | RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: for  reason: not valid java name */
    public void m47456for() {
        this.f54029k = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38693c(boolean z) {
        Camera camera = this.f54030l;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                parameters.setAutoExposureLock(z);
                parameters.setAutoWhiteBalanceLock(z);
                this.f54030l.setParameters(parameters);
                this.f54022d.mo161948do(z);
            } catch (IllegalStateException e) {
                this.f54022d.mo161943do(C19792try.C19794if.FAILED_TO_LOCK_EXPOSURE, e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: do */
    public void mo161901do(C20821for forR) {
        this.f54022d.mo161944do(forR);
    }

    /* renamed from: do */
    public void mo161900do(SurfaceTexture surfaceTexture) {
        Handler handler = this.f54033o;
        if (handler != null) {
            handler.post(new Runnable(surfaceTexture) {
                public final /* synthetic */ SurfaceTexture f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C19776do.this.m38682a(this.f$1);
                }
            });
        }
    }

    /* renamed from: do */
    public void mo161902do(Runnable runnable) {
        Handler handler = this.f54033o;
        if (handler != null) {
            handler.post(new Runnable(runnable) {
                public final /* synthetic */ Runnable f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C19776do.this.m38684a(this.f$1);
                }
            });
        }
    }

    /* renamed from: do */
    public void mo161903do(boolean z) {
        Handler handler = this.f54033o;
        if (handler != null) {
            handler.post(new Runnable(z) {
                public final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C19776do.this.m38693c(this.f$1);
                }
            });
        }
    }

    /* renamed from: do */
    public void mo161898do() {
        Handler handler;
        if (this.f54028j.compareAndSet(false, true) && this.f54030l != null && (handler = this.f54033o) != null) {
            handler.postDelayed(new Runnable() {
                public final void run() {
                    C19776do.this.m38692c();
                }
            }, 480);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m38684a(Runnable runnable) {
        m47458this();
        runnable.run();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m38686a(byte[] bArr, Camera camera) {
        try {
            this.f54022d.mo161946do(new C20825this(new ExifInterface((InputStream) new ByteArrayInputStream(bArr))));
            m38693c(true);
        } catch (IOException e) {
            this.f54022d.mo161943do(C19792try.C19794if.FAILED_TO_READ_EXIF_DATA, e);
        } finally {
            m38689b(false);
            this.f54028j.set(false);
        }
    }

    /* renamed from: if */
    public C19775const mo161905if() {
        return C19775const.CAMERA1;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m38681a(RectF rectF) {
        this.f54034p = C20820else.m41011do(rectF);
        Camera camera = this.f54030l;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (m38687a(parameters)) {
                this.f54030l.setParameters(parameters);
            }
        }
    }

    /* renamed from: do */
    public void mo161899do(RectF rectF) {
        Handler handler = this.f54033o;
        if (handler != null) {
            handler.post(new Runnable(rectF) {
                public final /* synthetic */ RectF f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    C19776do.this.m38681a(this.f$1);
                }
            });
        }
    }

    /* renamed from: a */
    private boolean m38687a(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() <= 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Camera.Area(this.f54034p, 1000));
        parameters.setMeteringAreas(arrayList);
        StringBuilder sb = new StringBuilder();
        sb.append("Set metering area (");
        sb.append(this.f54034p);
        sb.append(") OK");
        return true;
    }
}
