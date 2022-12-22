package com.microblink.blinkbarcode.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.microblink.blinkbarcode.hardware.IllIIIllII;
import com.microblink.blinkbarcode.hardware.SuccessCallback;
import com.microblink.blinkbarcode.hardware.accelerometer.ShakeCallback;
import com.microblink.blinkbarcode.hardware.camera.CameraType;
import com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl;
import com.microblink.blinkbarcode.hardware.camera.VideoResolutionPreset;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.hardware.orientation.OrientationChangeListener;
import com.microblink.blinkbarcode.hardware.orientation.llIIlIlIIl;
import com.microblink.blinkbarcode.secured.lIlIllIIll;
import com.microblink.blinkbarcode.secured.llIIlllIll;
import com.microblink.blinkbarcode.secured.llIllIIlll;
import com.microblink.blinkbarcode.secured.llIllllIIl;
import com.microblink.blinkbarcode.secured.lllIIIlIlI;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.exception.CalledFromWrongThreadException;
import com.microblink.blinkbarcode.view.exception.NonLandscapeOrientationNotSupportedException;
import com.microblink.blinkbarcode.view.surface.CameraSurface;
import com.microblink.blinkbarcode.view.surface.ICameraView;
import com.microblink.blinkbarcode.view.surface.llIIIlllll;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: line */
public abstract class BaseCameraView extends ViewGroup {
    /* access modifiers changed from: private */
    public boolean IIIIIIIIII = true;
    /* access modifiers changed from: private */
    public RectF[] IIIllIlIIl;
    public int IIlIIIllIl = 1;
    /* access modifiers changed from: private */
    public boolean IIlIlllIIl = false;
    /* access modifiers changed from: private */
    public float IlIIIIIlll = 0.0f;
    /* access modifiers changed from: private */
    public boolean IlIIlIIIII = false;
    private OnSizeChangedListener IlIIlllIIl;
    private RectF IlIlIlIIlI = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    public boolean IlIllIlIIl = false;
    public boolean IlIllIlllI = false;
    public ConcurrentLinkedQueue<OrientationChangeListener> IlIlllllII = new ConcurrentLinkedQueue<>();
    public ICameraView IllIIIIllI;
    public IllIIIllII IllIIIllII = null;
    public boolean IllIIlIIII = false;
    /* access modifiers changed from: private */
    public Handler IlllIIIllI = new Handler();
    public Orientation lIIIIIlIlI;
    public CameraAspectMode lIIIIIllll = CameraAspectMode.ASPECT_FILL;
    /* access modifiers changed from: private */
    public Orientation lIIIlIIllI = Orientation.ORIENTATION_UNKNOWN;
    public int lIlIIIIlIl;
    private boolean lIlIIlIIll = false;
    private int lIllIIlIIl = 0;
    private IlIllIlIIl lIlllIlIlI = new IlIllIlIIl();
    public CameraViewState llIIIlllll = CameraViewState.DESTROYED;
    /* access modifiers changed from: private */
    public com.microblink.blinkbarcode.hardware.camera.IllIIIllII llIIlIIIll;
    public OnActivityFlipListener llIIlIIlll;
    public CameraEventsListener llIIlIlIIl;
    private OrientationAllowedListener llIlIlIlIl;
    private ShakeCallback llIllIIlll;
    public boolean lllIIIlIlI = false;
    private int lllIIlIIlI = 0;
    public OrientationChangeListener lllIlIlIIl;
    private llIIlIlIIl lllllIlIll = null;

    /* compiled from: line */
    public abstract class BaseCameraListener implements com.microblink.blinkbarcode.hardware.camera.llIIlIlIIl {

        /* compiled from: line */
        public class IlIllIlIIl implements Runnable {
            public final /* synthetic */ Rect[] llIIlIlIIl;

            public IlIllIlIIl(Rect[] rectArr) {
                this.llIIlIlIIl = rectArr;
            }

            public void run() {
                BaseCameraView.this.llIIlIlIIl.onAutofocusStopped(BaseCameraView.llIIlIlIIl(BaseCameraView.this, this.llIIlIlIIl));
            }
        }

        /* compiled from: line */
        public class llIIlIlIIl implements Runnable {
            public final /* synthetic */ Rect[] llIIlIlIIl;

            public llIIlIlIIl(Rect[] rectArr) {
                this.llIIlIlIIl = rectArr;
            }

            public void run() {
                BaseCameraView.this.llIIlIlIIl.onAutofocusStarted(BaseCameraView.llIIlIlIIl(BaseCameraView.this, this.llIIlIlIIl));
            }
        }

        public BaseCameraListener() {
        }

        public abstract /* synthetic */ boolean canReceiveFrame();

        public final void onAutofocusFailed() {
            CameraEventsListener cameraEventsListener = BaseCameraView.this.llIIlIlIIl;
            if (cameraEventsListener != null) {
                cameraEventsListener.onAutofocusFailed();
            }
        }

        public final void onAutofocusStarted(Rect[] rectArr) {
            BaseCameraView baseCameraView = BaseCameraView.this;
            if (baseCameraView.llIIlIlIIl != null) {
                baseCameraView.llIIlIlIIl((Runnable) new llIIlIlIIl(rectArr));
            }
        }

        public final void onAutofocusStopped(Rect[] rectArr) {
            BaseCameraView baseCameraView = BaseCameraView.this;
            if (baseCameraView.llIIlIlIIl != null) {
                baseCameraView.llIIlIlIIl((Runnable) new IlIllIlIIl(rectArr));
            }
        }

        public abstract /* synthetic */ void onCameraFrame(llIIlllIll lliilllill);

        public abstract /* synthetic */ void onHighResFrame(llIIlllIll lliilllill);
    }

    /* compiled from: line */
    public class BaseCameraViewEventsListener implements ICameraView.CameraViewEventListener {
        public BaseCameraViewEventsListener() {
        }

        public void onCameraPinchEvent(float f) {
            if (BaseCameraView.this.IIlIlllIIl && BaseCameraView.this.llIIlIIIll != null) {
                BaseCameraView baseCameraView = BaseCameraView.this;
                baseCameraView.setZoomLevel(baseCameraView.IlIIIIIlll + (f - 1.0f));
            }
        }

        public void onCameraTapEvent(float f, float f2) {
            if (BaseCameraView.this.IIIIIIIIII && BaseCameraView.this.llIIlIIIll != null && BaseCameraView.this.getCurrentOrientation() != null) {
                if (BaseCameraView.this.IIIllIlIIl == null) {
                    float f3 = f - 0.165f;
                    float f4 = f2 - 0.165f;
                    if (f3 <= 1.0f && f4 <= 1.0f) {
                        if (f3 < 0.0f) {
                            f3 = 0.0f;
                        }
                        if (f4 < 0.0f) {
                            f4 = 0.0f;
                        }
                        float f5 = 0.33f;
                        float f6 = f3 + 0.33f > 1.0f ? 1.0f - f3 : 0.33f;
                        if (f4 + 0.33f > 1.0f) {
                            f5 = 1.0f - f4;
                        }
                        BaseCameraView.this.setMeteringAreas(new RectF[]{new RectF(f3, f4, f6 + f3, f5 + f4)}, false);
                    } else {
                        return;
                    }
                }
                BaseCameraView.this.focusCamera();
            }
        }
    }

    /* compiled from: line */
    public class BaseOrientationChangeListener implements OrientationChangeListener {
        public BaseOrientationChangeListener() {
        }

        private boolean llIIlIlIIl(int i, Orientation orientation) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 8) {
                        return i == 9 && orientation == Orientation.ORIENTATION_PORTRAIT;
                    }
                    if (orientation == Orientation.ORIENTATION_LANDSCAPE_RIGHT) {
                        return true;
                    }
                    return false;
                } else if (orientation == Orientation.ORIENTATION_PORTRAIT_UPSIDE) {
                    return true;
                } else {
                    return false;
                }
            } else if (orientation == Orientation.ORIENTATION_LANDSCAPE_LEFT) {
                return true;
            } else {
                return false;
            }
        }

        public void onOrientationChange(Orientation orientation) {
            BaseCameraView baseCameraView = BaseCameraView.this;
            Object[] objArr = new Object[2];
            objArr[0] = orientation;
            int i = baseCameraView.IIlIIIllIl;
            int i2 = 9;
            objArr[1] = i != 0 ? i != 1 ? i != 8 ? i != 9 ? "unknown" : "reverse_portrait" : "reverse_landscape" : "portrait" : "landscape";
            Log.m40231i(baseCameraView, "Orientation changed to {}, host screen orientation is {}", objArr);
            BaseCameraView baseCameraView2 = BaseCameraView.this;
            Log.m40231i(baseCameraView2, "is host activity on sensor: {}", Boolean.valueOf(baseCameraView2.llIIlIIlll()));
            BaseCameraView baseCameraView3 = BaseCameraView.this;
            Log.m40231i(baseCameraView3, "is flipped: {}", Boolean.valueOf(llIIlIlIIl(baseCameraView3.IIlIIIllIl, orientation)));
            if (BaseCameraView.this.llIIlIIlll() && llIIlIlIIl(BaseCameraView.this.IIlIIIllIl, orientation)) {
                Log.m40231i(BaseCameraView.this, "Activity is flipped", new Object[0]);
                BaseCameraView baseCameraView4 = BaseCameraView.this;
                if (baseCameraView4.llIIIlllll != CameraViewState.DESTROYED) {
                    int ordinal = orientation.ordinal();
                    if (ordinal == 0) {
                        i2 = 1;
                    } else if (ordinal == 1) {
                        i2 = 0;
                    } else if (ordinal != 2) {
                        i2 = ordinal != 3 ? -1 : 8;
                    }
                    baseCameraView4.IIlIIIllIl = i2;
                    BaseCameraView baseCameraView5 = BaseCameraView.this;
                    baseCameraView5.llIIlIlIIl(baseCameraView5.getContext().getResources().getConfiguration());
                    BaseCameraView.this.IIlIIIllIl();
                    OnActivityFlipListener onActivityFlipListener = BaseCameraView.this.llIIlIIlll;
                    if (onActivityFlipListener != null) {
                        onActivityFlipListener.onActivityFlip();
                    }
                }
            }
            if (BaseCameraView.this.llIIlIlIIl(orientation)) {
                Log.m40233v(BaseCameraView.this, "{} orientation is allowed. Dispatching...", orientation);
                Orientation unused = BaseCameraView.this.lIIIlIIllI = orientation;
                BaseCameraView baseCameraView6 = BaseCameraView.this;
                if (baseCameraView6.IllIIlIIII) {
                    baseCameraView6.lllIlIlIIl();
                }
            }
        }
    }

    /* compiled from: line */
    public enum CameraViewState {
        DESTROYED,
        CREATED,
        STARTED,
        RESUMED
    }

    public BaseCameraView(Context context) {
        super(context);
        llIIlIlIIl(context);
    }

    private int getCameraRotation() {
        int i = this.IIlIIIllIl;
        if (i == 1) {
            return 90;
        }
        if (i != 8) {
            return i != 9 ? 0 : 270;
        }
        return 180;
    }

    private float llIIlIlIIl(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    public static Rect[] llIIlIlIIl(BaseCameraView baseCameraView, Rect[] rectArr) {
        baseCameraView.getClass();
        if (rectArr == null || baseCameraView.IllIIIIllI == null) {
            return null;
        }
        Rect[] rectArr2 = new Rect[rectArr.length];
        for (int i = 0; i < rectArr.length; i++) {
            Rect rect = rectArr[i];
            RectF rectF = new RectF(((float) (rect.left + 1000)) / 2000.0f, ((float) (rect.top + 1000)) / 2000.0f, ((float) (rect.right + 1000)) / 2000.0f, ((float) (rect.bottom + 1000)) / 2000.0f);
            if (baseCameraView.lIlIIIIlIl()) {
                float f = 1.0f - rectF.right;
                float f2 = 1.0f - rectF.bottom;
                rectF = new RectF(f, f2, rectF.width() + f, rectF.height() + f2);
            }
            rectArr2[i] = baseCameraView.IllIIIIllI.convertRectangleToActualRect(rectF);
        }
        return rectArr2;
    }

    public abstract void IIlIIIllIl();

    public abstract boolean IlIllIlllI();

    public boolean IllIIlIIII() {
        return true;
    }

    public void addOrientationChangeListener(OrientationChangeListener orientationChangeListener) {
        CameraViewState cameraViewState = this.llIIIlllll;
        if (cameraViewState == CameraViewState.DESTROYED || cameraViewState == CameraViewState.CREATED) {
            this.IlIlllllII.add(orientationChangeListener);
            return;
        }
        throw new IllegalStateException("Method addOrientationChangeListener must be called before calling start()");
    }

    public void changeConfiguration(Configuration configuration) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.m40231i(this, "changeConfiguration: Context: {}", getContext());
            this.lIlIIIIlIl = configuration.orientation;
            this.IIlIIIllIl = IlIllIlIIl();
            llIIlIlIIl(configuration);
            return;
        }
        throw new CalledFromWrongThreadException("ChangeConfiguration must be called from UI thread!");
    }

    public void create() {
        ICameraView iCameraView;
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("It is not allowed to call create() on already created view (state is " + this.llIIIlllll.name() + ")");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new CalledFromWrongThreadException("Create must be called from UI thread!");
        } else if (getCameraFactorySettings().llIIlIlIIl() != null) {
            this.IlIllIlIIl = false;
            Log.m40231i(this, "Camera view create. Context = {}", getContext());
            if (this.llIIlIlIIl != null) {
                this.lIIIlIIllI = this.lIIIIIlIlI;
                this.lllIlIlIIl = IllIIIIllI();
                this.lllllIlIll = new llIIlIlIIl(this.IllIIIllII, this.lllIlIlIIl);
                llIIlIlIIl(this.lIlllIlIlI);
                com.microblink.blinkbarcode.hardware.camera.IllIIIllII llIIlIlIIl2 = new lIlIllIIll(getContext()).llIIlIlIIl(llIIIlllll(), this.lIlllIlIlI);
                this.llIIlIIIll = llIIlIlIIl2;
                llIIlIlIIl2.llIIlIlIIl(this.llIllIIlll);
                IllIIIllII illIIIllII = this.IllIIIllII;
                IlIllIlIIl ilIllIlIIl = this.lIlllIlIlI;
                com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII2 = this.llIIlIIIll;
                if (illIIIllII.lIllIIlIIl()) {
                    Log.m40231i(com.microblink.blinkbarcode.view.surface.llIIlIlIIl.class, "Creating CameraTextureView because of device list rule", new Object[0]);
                    iCameraView = new com.microblink.blinkbarcode.view.surface.IllIIIllII(illIIIllII.llIIIlllll());
                } else {
                    int ordinal = ilIllIlIIl.lIlIIIIlIl().ordinal();
                    if (ordinal == 1) {
                        Log.m40231i(com.microblink.blinkbarcode.view.surface.llIIlIlIIl.class, "Creating CameraTextureView because explicitly asked to", new Object[0]);
                        iCameraView = new com.microblink.blinkbarcode.view.surface.IllIIIllII(illIIIllII.llIIIlllll());
                    } else if (ordinal == 2) {
                        Log.m40231i(com.microblink.blinkbarcode.view.surface.llIIlIlIIl.class, "Creating CameraSurfaceView because explicitly asked to", new Object[0]);
                        iCameraView = new com.microblink.blinkbarcode.view.surface.IlIllIlIIl(illIIIllII.llIIIlllll());
                    } else if (illIIIllII2 instanceof lllIIIlIlI) {
                        Log.m40231i(com.microblink.blinkbarcode.view.surface.llIIlIlIIl.class, "Defaulting to CameraTextureView", new Object[0]);
                        iCameraView = new com.microblink.blinkbarcode.view.surface.IllIIIllII(illIIIllII.llIIIlllll());
                    } else {
                        Log.m40231i(com.microblink.blinkbarcode.view.surface.llIIlIlIIl.class, "Defaulting to CameraSurfaceView", new Object[0]);
                        iCameraView = new com.microblink.blinkbarcode.view.surface.IlIllIlIIl(illIIIllII.llIIIlllll());
                    }
                }
                this.IllIIIIllI = iCameraView;
                iCameraView.setAspectMode(this.lIIIIIllll);
                this.IllIIIIllI.setCameraViewEventListener(new BaseCameraViewEventsListener());
                this.IllIIIIllI.setHostActivityOrientation(this.IIlIIIllIl);
                this.IllIIIIllI.setDeviceNaturalOrientationLandscape(this.lIlIIlIIll);
                addView(this.IllIIIIllI.getView(), 0);
                this.llIIIlllll = CameraViewState.CREATED;
                return;
            }
            throw new NullPointerException("Please set CameraEventsListener with method setCameraEventsListener before calling create method!");
        } else {
            throw new NullPointerException("You have to set camera factory settings before calling create()");
        }
    }

    public void destroy() {
        if (this.llIIIlllll != CameraViewState.CREATED) {
            throw new IllegalStateException("It is not allowed to call destroy() method on view that is not stopped. State is " + this.llIIIlllll.name());
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.m40231i(this, "Camera view destroy. Context = {}", getContext());
            this.llIIlIIIll.dispose();
            this.IllIIIIllI.dispose();
            this.IllIIIIllI = null;
            this.llIIlIIIll = null;
            this.lIlllIlIlI.llIIlIlIIl((ShakeCallback) null);
            removeAllViews();
            this.llIIIlllll = CameraViewState.DESTROYED;
        } else {
            throw new CalledFromWrongThreadException("Destroy must be called from UI thread!");
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ICameraView iCameraView = this.IllIIIIllI;
        return (iCameraView == null || iCameraView.getView() == null || !this.IllIIIIllI.getView().dispatchTouchEvent(motionEvent)) ? false : true;
    }

    public final void focusCamera() {
        com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII = this.llIIlIIIll;
        if (illIIIllII != null) {
            illIIIllII.llIIIlllll();
        }
    }

    public CameraAspectMode getAspectMode() {
        return this.lIIIIIllll;
    }

    public CameraEventsListener getCameraEventsListener() {
        return this.llIIlIlIIl;
    }

    public IlIllIlIIl getCameraFactorySettings() {
        return this.lIlllIlIlI;
    }

    public final int getCameraPreviewHeight() {
        return this.lllIIlIIlI;
    }

    public final int getCameraPreviewWidth() {
        return this.lIllIIlIIl;
    }

    public int getCameraSensorOrientation() {
        return this.llIIlIIIll.llIIlIIlll();
    }

    public final CameraViewState getCameraViewState() {
        return this.llIIIlllll;
    }

    public final int getConfigurationOrientation() {
        return this.lIlIIIIlIl;
    }

    public Orientation getCurrentOrientation() {
        return this.lIIIlIIllI;
    }

    public final int getHighResFrameLimit() {
        return this.lIlllIlIlI.IllIIIllII();
    }

    public Activity getHostActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public int getHostScreenOrientation() {
        return this.IIlIIIllIl;
    }

    public final Orientation getInitialOrientation() {
        return this.lIIIIIlIlI;
    }

    public final CameraType getOpenedCameraType() {
        com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII = this.llIIlIIIll;
        if (illIIIllII != null) {
            return illIIIllII.IlIllIlllI();
        }
        return null;
    }

    public RectF getVisiblePart() {
        return this.IlIlIlIIlI;
    }

    public final float getZoomLevel() {
        return this.IlIIIIIlll;
    }

    public final Boolean isAutofocusSupported() {
        com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII = this.llIIlIIIll;
        if (illIIIllII != null) {
            return illIIIllII.IlIllIlIIl();
        }
        return null;
    }

    public final boolean isCameraActive() {
        return this.IlIIlIIIII;
    }

    public final boolean isCameraFocused() {
        com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII = this.llIIlIIIll;
        if (illIIIllII != null) {
            return illIIIllII.llIIlIlIIl();
        }
        return false;
    }

    public final boolean isCameraTorchSupported() {
        com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII = this.llIIlIIIll;
        if (illIIIllII != null) {
            return illIIIllII.IIlIIIllIl();
        }
        return false;
    }

    public final boolean isDeviceShaking() {
        com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII = this.llIIlIIIll;
        if (illIIIllII != null) {
            return illIIIllII.lIlIIIIlIl();
        }
        Log.m40229e(this, "Camera manager is null! Defining that device is shaking!", new Object[0]);
        return true;
    }

    public boolean isHighResFrameCaptureEnabled() {
        return this.lIlllIlIlI.lIIIIIllll();
    }

    public final boolean isPinchToZoomAllowed() {
        return this.IIlIlllIIl;
    }

    public final boolean isTapToFocusAllowed() {
        return this.IIIIIIIIII;
    }

    public void lIIIIIllll() {
    }

    public abstract com.microblink.blinkbarcode.hardware.camera.llIIlIlIIl llIIIlllll();

    public void lllIIIlIlI() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0146 A[LOOP:0: B:6:0x0013->B:39:0x0146, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0157 A[EDGE_INSN: B:46:0x0157->B:40:0x0157 ?: BREAK  
    EDGE_INSN: B:49:0x0157->B:40:0x0157 ?: BREAK  ] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void lllIlIlIIl() {
        /*
            r12 = this;
            com.microblink.blinkbarcode.hardware.camera.IllIIIllII r0 = r12.llIIlIIIll
            r1 = 0
            if (r0 == 0) goto L_0x0180
            android.graphics.RectF[] r2 = r12.IIIllIlIIl
            if (r2 != 0) goto L_0x000f
            r1 = 0
            r0.llIIlIlIIl((android.graphics.Rect[]) r1)
            goto L_0x0187
        L_0x000f:
            int r0 = r2.length
            android.graphics.Rect[] r0 = new android.graphics.Rect[r0]
            r2 = 0
        L_0x0013:
            android.graphics.RectF[] r3 = r12.IIIllIlIIl
            int r4 = r3.length
            if (r2 >= r4) goto L_0x017a
            r4 = r3[r2]
            if (r4 == 0) goto L_0x0172
            r3 = r3[r2]
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            com.microblink.blinkbarcode.hardware.orientation.Orientation r6 = r12.lIIIlIIllI
            r5[r1] = r6
            java.lang.String r6 = "Metering rect is for orientation {}!"
            com.microblink.blinkbarcode.util.Log.m40227d(r12, r6, r5)
            com.microblink.blinkbarcode.hardware.orientation.Orientation r5 = r12.lIIIlIIllI
            int r5 = r5.ordinal()
            r6 = 2
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r5 == 0) goto L_0x006f
            if (r5 == r6) goto L_0x0054
            r8 = 3
            if (r5 == r8) goto L_0x003b
            goto L_0x008a
        L_0x003b:
            float r5 = r3.right
            float r5 = r7 - r5
            float r8 = r3.bottom
            float r8 = r7 - r8
            android.graphics.RectF r9 = new android.graphics.RectF
            float r10 = r3.width()
            float r10 = r10 + r5
            float r3 = r3.height()
            float r3 = r3 + r8
            r9.<init>(r5, r8, r10, r3)
            r3 = r9
            goto L_0x008a
        L_0x0054:
            float r5 = r3.height()
            float r8 = r3.width()
            float r9 = r3.top
            float r10 = r3.height()
            float r9 = r9 + r10
            float r9 = r7 - r9
            float r3 = r3.left
            android.graphics.RectF r10 = new android.graphics.RectF
            float r5 = r5 + r9
            float r8 = r8 + r3
            r10.<init>(r9, r3, r5, r8)
            goto L_0x0089
        L_0x006f:
            float r5 = r3.height()
            float r8 = r3.width()
            float r9 = r3.top
            float r10 = r3.left
            float r3 = r3.width()
            float r10 = r10 + r3
            float r3 = r7 - r10
            android.graphics.RectF r10 = new android.graphics.RectF
            float r5 = r5 + r9
            float r8 = r8 + r3
            r10.<init>(r9, r3, r5, r8)
        L_0x0089:
            r3 = r10
        L_0x008a:
            boolean r5 = r12.lIlIIIIlIl()
            if (r5 == 0) goto L_0x00af
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.String r8 = "Metering rect is sensor upside down!"
            com.microblink.blinkbarcode.util.Log.m40227d(r12, r8, r5)
            float r5 = r3.right
            float r5 = r7 - r5
            float r8 = r3.bottom
            float r7 = r7 - r8
            android.graphics.RectF r8 = new android.graphics.RectF
            float r9 = r3.width()
            float r9 = r9 + r5
            float r3 = r3.height()
            float r3 = r3 + r7
            r8.<init>(r5, r7, r9, r3)
            r3 = r8
            goto L_0x00b6
        L_0x00af:
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.String r7 = "Metering rect is sensor normal!"
            com.microblink.blinkbarcode.util.Log.m40227d(r12, r7, r5)
        L_0x00b6:
            android.graphics.RectF r5 = r12.IlIlIlIIlI
            float r7 = r5.left
            float r8 = r3.left
            float r5 = r5.width()
            float r8 = r8 * r5
            float r7 = r7 + r8
            android.graphics.RectF r5 = r12.IlIlIlIIlI
            float r8 = r5.top
            float r9 = r3.top
            float r5 = r5.height()
            float r9 = r9 * r5
            float r8 = r8 + r9
            float r5 = r3.width()
            android.graphics.RectF r9 = r12.IlIlIlIIlI
            float r9 = r9.width()
            float r5 = r5 * r9
            float r3 = r3.height()
            android.graphics.RectF r9 = r12.IlIlIlIIlI
            float r9 = r9.height()
            float r3 = r3 * r9
            android.graphics.RectF r9 = new android.graphics.RectF
            float r5 = r5 + r7
            float r3 = r3 + r8
            r9.<init>(r7, r8, r5, r3)
            float r3 = r9.left
            r5 = 1157234688(0x44fa0000, float:2000.0)
            float r3 = r3 * r5
            int r3 = java.lang.Math.round(r3)
            r7 = 1000(0x3e8, float:1.401E-42)
            int r3 = r3 - r7
            float r8 = r9.top
            float r8 = r8 * r5
            int r8 = java.lang.Math.round(r8)
            int r8 = r8 - r7
            float r10 = r9.width()
            float r10 = r10 * r5
            int r10 = java.lang.Math.round(r10)
            float r11 = r9.height()
            float r11 = r11 * r5
            int r5 = java.lang.Math.round(r11)
            android.graphics.Rect r11 = new android.graphics.Rect
            int r10 = r10 + r3
            int r5 = r5 + r8
            r11.<init>(r3, r8, r10, r5)
            int r3 = r11.left
            r5 = -1000(0xfffffffffffffc18, float:NaN)
            if (r3 >= r5) goto L_0x0128
            r11.left = r5
        L_0x0128:
            int r3 = r11.right
            if (r3 <= r7) goto L_0x012e
            r11.right = r7
        L_0x012e:
            int r3 = r11.top
            if (r3 >= r5) goto L_0x0134
            r11.top = r5
        L_0x0134:
            int r3 = r11.bottom
            if (r3 <= r7) goto L_0x013a
            r11.bottom = r7
        L_0x013a:
            boolean r3 = r11.isEmpty()
            if (r3 != 0) goto L_0x0157
            boolean r3 = r11.intersects(r5, r5, r7, r7)
            if (r3 == 0) goto L_0x0157
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r3[r1] = r11
            r3[r4] = r9
            java.lang.String r4 = "Metering rect is {} (original rect was {})"
            com.microblink.blinkbarcode.util.Log.m40231i(r12, r4, r3)
            r0[r2] = r11
            int r2 = r2 + 1
            goto L_0x0013
        L_0x0157:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid metering area: "
            r1.append(r2)
            java.lang.String r2 = r9.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0172:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Metering area elements cannot be null!"
            r0.<init>(r1)
            throw r0
        L_0x017a:
            com.microblink.blinkbarcode.hardware.camera.IllIIIllII r1 = r12.llIIlIIIll
            r1.llIIlIlIIl((android.graphics.Rect[]) r0)
            goto L_0x0187
        L_0x0180:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "CameraView is already disposed. Cannot set metering areas!"
            com.microblink.blinkbarcode.util.Log.m40235w(r12, r1, r0)
        L_0x0187:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.view.BaseCameraView.lllIlIlIIl():void");
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        float f;
        float f2;
        float f3;
        float f4;
        Log.m40227d(this, "Camera preview ({} childs) layouting to: top: {} bottom: {}, left: {}, right: {} (changed: {}) ", Integer.valueOf(getChildCount()), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z));
        if (getChildCount() == 0) {
            Log.wtf(this, "Camera view has no children?!?", new Object[0]);
            return;
        }
        int i9 = i3 - i;
        int i10 = i4 - i2;
        if (i9 == 0 || i10 == 0) {
            Log.wtf(this, "Layout size is 0x0?!?", new Object[0]);
            return;
        }
        ICameraView iCameraView = this.IllIIIIllI;
        if (iCameraView == null) {
            Log.m40229e(this, "Create not called. Cannot layout view!", new Object[0]);
            return;
        }
        int size = View.MeasureSpec.getSize(iCameraView.getView().getMeasuredWidth());
        int size2 = View.MeasureSpec.getSize(this.IllIIIIllI.getView().getMeasuredHeight());
        Log.m40227d(this, "Camera surface view size is {}x{}", Integer.valueOf(size), Integer.valueOf(size2));
        Log.m40227d(this, "Base camera view size: {}x{}", Integer.valueOf(i9), Integer.valueOf(i10));
        int i11 = (i9 - size) / 2;
        int i12 = (i9 + size) / 2;
        int i13 = (i10 - size2) / 2;
        int i14 = (i10 + size2) / 2;
        if (this.lIIIIIllll == CameraAspectMode.ASPECT_FIT) {
            Log.m40227d(this, "Layouting in ASPECT_FIT mode", new Object[0]);
            this.IlIlIlIIlI = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
            i8 = i11;
            i6 = i12;
            i7 = i13;
            i5 = i14;
        } else {
            Log.m40227d(this, "Layouting in ASPECT_FILL mode", new Object[0]);
            if (size <= 0 || size2 <= 0) {
                f4 = 1.0f;
                f3 = 1.0f;
                f2 = 0.0f;
                f = 0.0f;
            } else {
                float f5 = (float) size;
                f4 = ((float) i9) / f5;
                float f6 = (float) size2;
                f3 = ((float) i10) / f6;
                f = ((float) (-i11)) / f5;
                f2 = ((float) (-i13)) / f6;
            }
            if (llIllIIlll.llIIlIlIIl(getContext())) {
                float f7 = f;
                f = f2;
                f2 = f7;
            } else {
                float f8 = f3;
                f3 = f4;
                f4 = f8;
            }
            float llIIlIlIIl2 = llIIlIlIIl(f, 0.0f, 1.0f);
            float llIIlIlIIl3 = llIIlIlIIl(f2, 0.0f, 1.0f);
            this.IlIlIlIIlI = new RectF(llIIlIlIIl2, llIIlIlIIl3, llIIlIlIIl(f3, 0.0f, 1.0f) + llIIlIlIIl2, llIIlIlIIl(f4, 0.0f, 1.0f) + llIIlIlIIl3);
            Log.m40227d(this, "Visible ROI: " + this.IlIlIlIIlI.toString(), new Object[0]);
            i8 = i;
            i7 = i2;
            i6 = i3;
            i5 = i4;
        }
        this.lIllIIlIIl = i6 - i8;
        this.lllIIlIIlI = i5 - i7;
        Log.m40231i(this, "Layouting camera surface view: Left: {}, Top: {}, Right: {}, Bottom: {}", Integer.valueOf(i11), Integer.valueOf(i13), Integer.valueOf(i12), Integer.valueOf(i14));
        this.IllIIIIllI.getView().layout(i11, i13, i12, i14);
        if (this.IlIIlllIIl != null) {
            if (this.lIIIlIIllI.isHorizontal()) {
                this.IlIIlllIIl.onSizeChanged(this.lllIIlIIlI, this.lIllIIlIIl);
            } else {
                this.IlIIlllIIl.onSizeChanged(this.lIllIIlIIl, this.lllIIlIIlI);
            }
        }
        for (int i15 = 1; i15 < getChildCount(); i15++) {
            View childAt = getChildAt(i15);
            Log.m40231i(this, "Layouting child {}: Left: {}, Top: {}, Right: {}, Bottom: {}", Integer.valueOf(i15), Integer.valueOf(i8), Integer.valueOf(i7), Integer.valueOf(i6), Integer.valueOf(i5));
            childAt.layout(i8, i7, i6, i5);
        }
    }

    public void onMeasure(int i, int i2) {
        int resolveSize = ViewGroup.resolveSize(getSuggestedMinimumWidth(), i);
        int resolveSize2 = ViewGroup.resolveSize(getSuggestedMinimumHeight(), i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(resolveSize, 1073741824), View.MeasureSpec.makeMeasureSpec(resolveSize2, 1073741824));
            }
        }
        Log.m40227d(this, "Measured dimension: {}x{}", Integer.valueOf(resolveSize), Integer.valueOf(resolveSize2));
        setMeasuredDimension(resolveSize, resolveSize2);
    }

    public void pause() {
        if (this.llIIIlllll != CameraViewState.RESUMED) {
            throw new IllegalStateException("Cannot pause view that has not been resumed. Please make sure that your view has been resumed with resume() method. State is " + this.llIIIlllll.name());
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.m40231i(this, "Camera view pause. Context = {}", getContext());
            llIIlIlIIl lliililiil = this.lllllIlIll;
            if (lliililiil != null) {
                lliililiil.disable();
            }
            com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII = this.llIIlIIIll;
            if (illIIIllII != null) {
                illIIIllII.IllIIIIllI();
                this.IlIIlIIIII = false;
            }
            this.llIIIlllll = CameraViewState.STARTED;
        } else {
            throw new CalledFromWrongThreadException("Pause must be called from UI thread!");
        }
    }

    public void removeOrientationChangeListener(OrientationChangeListener orientationChangeListener) {
        this.IlIlllllII.remove(orientationChangeListener);
    }

    public void resume() {
        if (this.llIIIlllll != CameraViewState.STARTED) {
            throw new IllegalStateException("Cannot resume view that has not been started. Please call start() first. State is " + this.llIIIlllll.name());
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.m40231i(this, "Camera view resume. Context = {}", getContext());
            this.llIIIlllll = CameraViewState.RESUMED;
            if (Build.VERSION.SDK_INT >= 23 && getContext().checkSelfPermission(Permission.CAMERA) != 0) {
                this.llIIlIlIIl.onCameraPermissionDenied();
            } else if (!this.IlIllIlIIl) {
                llIIlIlIIl lliililiil = this.lllllIlIll;
                if (lliililiil != null) {
                    lliililiil.enable();
                }
                Context context = getContext();
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    Log.m40229e(this, "Will not open camera because activity is already finishing.", new Object[0]);
                } else if (IllIIlIIII()) {
                    this.IllIIIIllI.setRotation(getCameraRotation());
                    this.lIlllIlIlI.llIIlIlIIl(this.IlIIIIIlll);
                    this.llIIlIIIll.llIIlIlIIl(getContext(), this.lIlllIlIlI, new llIIlIlIIl(this));
                } else {
                    this.IlIIlIIIII = false;
                    this.IlIllIlIIl = true;
                    CameraEventsListener cameraEventsListener = this.llIIlIlIIl;
                    if (cameraEventsListener != null) {
                        cameraEventsListener.onError(new Exception("Initialization failed!"));
                    }
                }
            }
        } else {
            throw new CalledFromWrongThreadException("Resume must be called from UI thread!");
        }
    }

    public void setAspectMode(CameraAspectMode cameraAspectMode) {
        if (this.llIIIlllll == CameraViewState.DESTROYED) {
            this.lIIIIIllll = cameraAspectMode;
            if (cameraAspectMode == null) {
                this.lIIIIIllll = CameraAspectMode.ASPECT_FILL;
                return;
            }
            return;
        }
        throw new IllegalStateException("Method setAspectMode must be called before calling create()");
    }

    public void setCameraEventsListener(CameraEventsListener cameraEventsListener) {
        if (this.llIIIlllll == CameraViewState.DESTROYED) {
            this.llIIlIlIIl = cameraEventsListener;
            return;
        }
        throw new IllegalStateException("Method setCameraEventsListener must be called before calling create()");
    }

    public final void setCameraFrameFactory(llIllllIIl llilllliil) {
        if (this.llIIIlllll == CameraViewState.DESTROYED) {
            this.lIlllIlIlI.llIIlIlIIl(llilllliil);
            return;
        }
        throw new IllegalStateException("This method can only be called before calling create().");
    }

    public void setCameraType(CameraType cameraType) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setCameraType must be called before calling create()");
        } else if (cameraType != null) {
            this.lIlllIlIlI.llIIlIlIIl(cameraType);
        }
    }

    public final void setForceUseLegacyCamera(boolean z) {
        if (this.llIIIlllll == CameraViewState.DESTROYED) {
            this.lIlllIlIlI.lIlIIIIlIl(z);
            return;
        }
        throw new IllegalStateException("This method can only be called before calling create().");
    }

    public void setHighResFrameCaptureEnabled(boolean z) {
        if (this.llIIIlllll == CameraViewState.DESTROYED) {
            this.lIlllIlIlI.IlIllIlIIl(z);
            return;
        }
        throw new IllegalStateException("This method can only be called before calling create().");
    }

    public final void setHighResFrameLimit(int i) {
        if (i > 0) {
            this.lIlllIlIlI.llIIlIlIIl(i);
            return;
        }
        throw new IllegalArgumentException("High res frame limit has to be at least 1");
    }

    public void setInitialOrientation(Orientation orientation) {
        if (this.llIIIlllll != CameraViewState.DESTROYED) {
            throw new IllegalStateException("Method setInitialOrientation must be called before calling create()");
        } else if (orientation != null) {
            this.lIIIIIlIlI = orientation;
        }
    }

    public final void setMeteringAreas(RectF[] rectFArr, boolean z) {
        this.IIIllIlIIl = rectFArr;
        this.IllIIlIIII = z;
        lllIlIlIIl();
    }

    public final void setOnActivityFlipListener(OnActivityFlipListener onActivityFlipListener) {
        this.llIIlIIlll = onActivityFlipListener;
    }

    public final void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.IlIIlllIIl = onSizeChangedListener;
    }

    public final void setOptimizeCameraForNearScan(boolean z) {
        if (this.llIIIlllll == CameraViewState.DESTROYED) {
            this.lIlllIlIlI.IllIIIllII(z);
            return;
        }
        throw new IllegalStateException("This method can only be called before calling create().");
    }

    public void setOrientationAllowedListener(OrientationAllowedListener orientationAllowedListener) {
        if (this.llIIIlllll == CameraViewState.DESTROYED) {
            this.llIlIlIlIl = orientationAllowedListener;
            return;
        }
        throw new IllegalStateException("Method setOrientationAllowedListener must be called before calling create()");
    }

    public final void setPinchToZoomAllowed(boolean z) {
        this.IIlIlllIIl = z;
    }

    public final void setRequestAutofocusOnShakingStopInContinousAutofocusMode(boolean z) {
        if (this.llIIIlllll == CameraViewState.DESTROYED) {
            this.lIlllIlIlI.IllIIIIllI(z);
            return;
        }
        throw new IllegalStateException("This method can only be called before calling create().");
    }

    public final void setRequestedSurfaceViewForCameraDisplay(CameraSurface cameraSurface) {
        if (this.llIIIlllll == CameraViewState.DESTROYED) {
            this.lIlllIlIlI.llIIlIlIIl(cameraSurface);
            return;
        }
        throw new IllegalStateException("This method can only be called before calling create().");
    }

    public void setShakeListener(ShakeCallback shakeCallback) {
        this.llIllIIlll = shakeCallback;
    }

    public final void setTapToFocusAllowed(boolean z) {
        this.IIIIIIIIII = z;
    }

    public final void setTorchState(boolean z, SuccessCallback successCallback) {
        com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII = this.llIIlIIIll;
        if (illIIIllII != null) {
            illIIIllII.llIIlIlIIl(z, successCallback);
        } else {
            successCallback.onOperationDone(false);
        }
    }

    public final void setVideoResolutionPreset(VideoResolutionPreset videoResolutionPreset) {
        if (this.llIIIlllll == CameraViewState.DESTROYED) {
            this.lIlllIlIlI.llIIlIlIIl(videoResolutionPreset);
            return;
        }
        throw new IllegalStateException("This method can only be called before calling create().");
    }

    public final void setZoomLevel(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.IlIIIIIlll = f;
        com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII = this.llIIlIIIll;
        if (illIIIllII != null) {
            illIIIllII.llIIlIlIIl(f);
        }
    }

    public void start() {
        if (this.llIIIlllll != CameraViewState.CREATED) {
            throw new IllegalStateException("Cannot start view that has not been created. Please call create() first. State is " + this.llIIIlllll.name());
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.m40231i(this, "Camera view start. Context = {}", getContext());
            this.IlIllIlIIl = false;
            this.IllIIIIllI.installCallback(this.llIIlIIIll);
            this.llIIIlllll = CameraViewState.STARTED;
        } else {
            throw new CalledFromWrongThreadException("Start must be called from UI thread!");
        }
    }

    public void stop() {
        if (this.llIIIlllll != CameraViewState.STARTED) {
            throw new IllegalStateException("Cannot stop view that has not been paused. Please call pause() method first. State is " + this.llIIIlllll.name());
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.m40231i(this, "Camera view stop. Context = {}", getContext());
            this.IllIIIIllI.removeCallback();
            this.llIIIlllll = CameraViewState.CREATED;
        } else {
            throw new CalledFromWrongThreadException("Stop must be called from UI thread!");
        }
    }

    private boolean lIlIIIIlIl() {
        com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII = this.llIIlIIIll;
        if (illIIIllII == null) {
            return false;
        }
        CameraType IlIllIlllI2 = illIIIllII.IlIllIlllI();
        boolean lIIIIIllll2 = this.llIIlIIIll.lIIIIIllll();
        return IlIllIlllI2 == CameraType.CAMERA_BACKFACE ? lIIIIIllll2 : !lIIIIIllll2;
    }

    public int IlIllIlIIl() {
        WindowManager windowManager;
        if (isInEditMode()) {
            windowManager = (WindowManager) getContext().getSystemService("window");
        } else {
            windowManager = (WindowManager) getHostActivity().getApplicationContext().getSystemService("window");
        }
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (llIllIIlll.llIIlIlIIl(getContext())) {
            Log.m40227d(this, "Activity is in portrait", new Object[0]);
            if (rotation == 0) {
                Log.m40227d(this, "Screen orientation is 0", new Object[0]);
            } else if (rotation == 2) {
                Log.m40227d(this, "Screen orientation is 180", new Object[0]);
                return 9;
            } else if (rotation == 3) {
                Log.m40227d(this, "Screen orientation is 270", new Object[0]);
                this.lIlIIlIIll = true;
            } else {
                Log.m40227d(this, "Screen orientation is 90", new Object[0]);
                this.lIlIIlIIll = true;
                return 9;
            }
            return 1;
        }
        Log.m40227d(this, "Activity is in landscape", new Object[0]);
        if (rotation == 1) {
            Log.m40227d(this, "Screen orientation is 90", new Object[0]);
        } else {
            if (rotation == 3) {
                Log.m40227d(this, "Screen orientation is 270", new Object[0]);
            } else if (rotation == 0) {
                Log.m40227d(this, "Screen orientation is 0", new Object[0]);
                this.lIlIIlIIll = true;
            } else {
                Log.m40227d(this, "Screen orientation is 180", new Object[0]);
                this.lIlIIlIIll = true;
            }
            return 8;
        }
        return 0;
    }

    public OrientationChangeListener IllIIIIllI() {
        return new BaseOrientationChangeListener();
    }

    public void IllIIIllII() {
        if (this.lIlllIlIlI.lIIIIIllll()) {
            this.llIIlIIIll.IllIIIllII();
            return;
        }
        throw new IllegalStateException("High res frame capture is not enabled!");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if ((android.os.Build.VERSION.SDK_INT >= 24 && getHostActivity().isInMultiWindowMode()) != false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean llIIlIIlll() {
        /*
            r4 = this;
            boolean r0 = r4.lllIIIlIlI
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r4.IlIllIlllI
            r2 = 0
            if (r0 != 0) goto L_0x0020
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r0 < r3) goto L_0x001d
            android.app.Activity r0 = r4.getHostActivity()
            boolean r0 = r0.isInMultiWindowMode()
            if (r0 == 0) goto L_0x001d
            r0 = 1
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 == 0) goto L_0x0037
        L_0x0020:
            android.content.Context r0 = r4.getContext()     // Catch:{ SettingNotFoundException -> 0x0033 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0033 }
            java.lang.String r3 = "accelerometer_rotation"
            int r0 = android.provider.Settings.System.getInt(r0, r3)     // Catch:{ SettingNotFoundException -> 0x0033 }
            if (r0 != r1) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            return r1
        L_0x0033:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0037:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.view.BaseCameraView.llIIlIIlll():boolean");
    }

    public BaseCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        llIIlIlIIl(context);
    }

    private void llIIlIlIIl(Context context) {
        this.lIlIIIIlIl = context.getResources().getConfiguration().orientation;
        int IlIllIlIIl2 = IlIllIlIIl();
        this.IIlIIIllIl = IlIllIlIIl2;
        this.lIIIIIlIlI = Orientation.fromActivityInfoCode(IlIllIlIIl2);
        boolean z = false;
        if (!isInEditMode()) {
            IllIIIllII llIIlIIlll2 = IllIIIllII.llIIlIIlll();
            this.IllIIIllII = llIIlIIlll2;
            com.microblink.blinkbarcode.util.llIIlIlIIl.llIIlIlIIl(this.IIlIIIllIl, llIIlIIlll2);
            if (com.microblink.blinkbarcode.util.llIIlIlIIl.IlIllIlIIl() || this.IIlIIIllIl == 0) {
                Activity hostActivity = getHostActivity();
                int requestedOrientation = hostActivity.getRequestedOrientation();
                this.lllIIIlIlI = requestedOrientation == 10 || requestedOrientation == 4 || requestedOrientation == 6 || requestedOrientation == 7;
                int requestedOrientation2 = hostActivity.getRequestedOrientation();
                if (Build.VERSION.SDK_INT < 18 ? requestedOrientation2 == 2 || requestedOrientation2 == 13 || requestedOrientation2 == -1 : requestedOrientation2 == 2 || requestedOrientation2 == 12 || requestedOrientation2 == 11 || requestedOrientation2 == 13 || requestedOrientation2 == -1) {
                    z = true;
                }
                this.IlIllIlllI = z;
                return;
            }
            throw new NonLandscapeOrientationNotSupportedException("This device does not support having camera on non-landscape oriented activity. Please set activity orientation to landscape!");
        }
        llIIIlllll lliiilllll = new llIIIlllll(getContext(), this.lIIIIIllll);
        this.IllIIIIllI = lliiilllll;
        addView(lliiilllll.getView(), 0);
    }

    public void llIIlIlIIl(Runnable runnable) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            runnable.run();
        } else {
            this.IlllIIIllI.post(runnable);
        }
    }

    public void llIIlIlIIl(Configuration configuration) {
        this.IllIIIIllI.setRotation(getCameraRotation());
        this.IllIIIIllI.setHostActivityOrientation(this.IIlIIIllIl);
        this.IllIIIIllI.getView().dispatchConfigurationChanged(configuration);
    }

    public void llIIlIlIIl(IlIllIlIIl ilIllIlIIl) {
        ilIllIlIIl.llIIlIlIIl(IlIllIlllI());
    }

    public boolean llIIlIlIIl() {
        com.microblink.blinkbarcode.hardware.camera.IllIIIllII illIIIllII = this.llIIlIIIll;
        if (illIIIllII != null) {
            return illIIIllII.lIIIIIllll();
        }
        return false;
    }

    public final boolean llIIlIlIIl(Orientation orientation) {
        OrientationAllowedListener orientationAllowedListener = this.llIlIlIlIl;
        if (orientationAllowedListener != null) {
            return orientationAllowedListener.isOrientationAllowed(orientation);
        }
        return orientation == Orientation.fromActivityInfoCode(this.IIlIIIllIl);
    }
}
