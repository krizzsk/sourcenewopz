package com.didi.hawaii.mapsdkv2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.didi.hawaii.mapsdkv2.jni.MapEngineJNI;
import com.didi.hawaii.mapsdkv2.jni.SWIGTYPE_p_void;
import com.didi.sdk.apm.SystemUtils;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class VulkanSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLSurfaceView";
    /* access modifiers changed from: private */
    public static final GLThreadManager sVKThreadManager = new GLThreadManager();
    private int mDebugFlags;
    private boolean mDetached;
    private EGLConfigChooser mEGLConfigChooser;
    /* access modifiers changed from: private */
    public int mEGLContextClientVersion;
    private EGLContextFactory mEGLContextFactory;
    private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLWrapper mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    /* access modifiers changed from: private */
    public Renderer mRenderer;
    private final WeakReference<VulkanSurfaceView> mThisWeakRef = new WeakReference<>(this);
    private VKThread mVKThread;

    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public interface GLWrapper {
        GL wrap(GL gl);
    }

    public interface Renderer {
        boolean onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i, int i2);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    public VulkanSurfaceView(Context context) {
        super(context);
        init();
    }

    public VulkanSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.mVKThread != null) {
                this.mVKThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.mGLWrapper = gLWrapper;
    }

    public void setDebugFlags(int i) {
        this.mDebugFlags = i;
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.mPreserveEGLContextOnPause = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public void setRenderer(Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        VKThread vKThread = new VKThread(this.mThisWeakRef);
        this.mVKThread = vKThread;
        vKThread.start();
    }

    public void setEGLContextFactory(EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.mEGLContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setEGLConfigChooser(EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = eGLConfigChooser;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser((EGLConfigChooser) new SimpleEGLConfigChooser(z));
    }

    public void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser((EGLConfigChooser) new ComponentSizeChooser(i, i2, i3, i4, i5, i6));
    }

    public void setEGLContextClientVersion(int i) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
    }

    public void setRenderMode(int i) {
        this.mVKThread.setRenderMode(i);
    }

    public int getRenderMode() {
        return this.mVKThread.getRenderMode();
    }

    public void requestRender() {
        this.mVKThread.requestRender();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mVKThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mVKThread.surfaceDestroyed();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mVKThread.onWindowResize(i2, i3);
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        VKThread vKThread = this.mVKThread;
        if (vKThread != null) {
            vKThread.requestRenderAndWait();
        }
    }

    public void onPause() {
        this.mVKThread.onPause();
    }

    public void onResume() {
        this.mVKThread.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.mVKThread.queueEvent(runnable);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.mRenderer != null) {
            VKThread vKThread = this.mVKThread;
            int renderMode = vKThread != null ? vKThread.getRenderMode() : 1;
            VKThread vKThread2 = new VKThread(this.mThisWeakRef);
            this.mVKThread = vKThread2;
            if (renderMode != 1) {
                vKThread2.setRenderMode(renderMode);
            }
            this.mVKThread.start();
        }
        this.mDetached = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        VKThread vKThread = this.mVKThread;
        if (vKThread != null) {
            vKThread.requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    private class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, VulkanSurfaceView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (VulkanSurfaceView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                SystemUtils.log(6, "DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext, (Throwable) null, "com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$DefaultContextFactory", 513);
            }
        }
    }

    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (int[]) null);
            } catch (IllegalArgumentException e) {
                SystemUtils.log(6, VulkanSurfaceView.TAG, "eglCreateWindowSurface", e, "com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$DefaultWindowSurfaceFactory", 549);
                return null;
            }
        }

        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    private abstract class BaseConfigChooser implements EGLConfigChooser {
        protected int[] mConfigSpec;

        /* access modifiers changed from: package-private */
        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public BaseConfigChooser(int[] iArr) {
            this.mConfigSpec = filterConfigSpec(iArr);
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, (EGLConfig[]) null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i, iArr)) {
                        EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                        if (chooseConfig != null) {
                            return chooseConfig;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        private int[] filterConfigSpec(int[] iArr) {
            if (VulkanSurfaceView.this.mEGLContextClientVersion != 2 && VulkanSurfaceView.this.mEGLContextClientVersion != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (VulkanSurfaceView.this.mEGLContextClientVersion == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    private class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ComponentSizeChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                int findConfigAttrib = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    EGL10 egl103 = egl10;
                    EGLDisplay eGLDisplay3 = eGLDisplay;
                    EGLConfig eGLConfig3 = eGLConfig;
                    int findConfigAttrib3 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue) ? this.mValue[0] : i2;
        }
    }

    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SimpleEGLConfigChooser(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    private static class SwigPVoid extends SWIGTYPE_p_void {
        SwigPVoid(long j) {
            super(j, false);
        }

        SwigPVoid(SWIGTYPE_p_void sWIGTYPE_p_void) {
            super(SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void), false);
        }

        /* access modifiers changed from: package-private */
        public long getPtr() {
            return SWIGTYPE_p_void.getCPtr(this);
        }
    }

    static class VKThread extends Thread {
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        /* access modifiers changed from: private */
        public boolean mExited;
        private boolean mFinishedCreatingEglSurface;
        private WeakReference<VulkanSurfaceView> mGLSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveVulkanContext;
        private boolean mHaveVulkanSurface;
        private int mHeight = 0;
        private boolean mPaused;
        private boolean mReadyRender = false;
        private boolean mRenderComplete;
        private int mRenderMode = 1;
        private boolean mRequestPaused;
        private boolean mRequestRender = true;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged = true;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private boolean mWantRenderNotification = false;
        private int mWidth = 0;
        private long vulkanHandle;

        VKThread(WeakReference<VulkanSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public void run() {
            this.vulkanHandle = new SwigPVoid(MapEngineJNI.DMapVulkanCreate()).getPtr();
            setName("VKThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                VulkanSurfaceView.sVKThreadManager.threadExiting(this);
                throw th;
            }
            VulkanSurfaceView.sVKThreadManager.threadExiting(this);
        }

        private void stopVulkanSurface() {
            if (this.mHaveVulkanSurface) {
                this.mHaveVulkanSurface = false;
                this.mReadyRender = false;
                this.mWidth = 0;
                this.mHeight = 0;
                MapEngineJNI.DMapVulkanSurfaceDestroy(this.vulkanHandle);
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveVulkanContext) {
                this.mHaveVulkanContext = false;
                VulkanSurfaceView.sVKThreadManager.releaseEglContextLocked(this);
            }
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x011c, code lost:
            if (r11 == null) goto L_0x0124;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            r11.run();
            r11 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0124, code lost:
            if (r6 == false) goto L_0x013f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0126, code lost:
            r6 = (com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView) r15.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x012e, code lost:
            if (r6 == null) goto L_0x013c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0130, code lost:
            com.didi.hawaii.mapsdkv2.jni.MapEngineJNI.DMapVulkanSurfaceCreated(r15.vulkanHandle);
            com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.access$400(r6).onSurfaceCreated((javax.microedition.khronos.opengles.GL10) null, (javax.microedition.khronos.egl.EGLConfig) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x013c, code lost:
            r15.mReadyRender = true;
            r6 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x013f, code lost:
            if (r5 == false) goto L_0x0142;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x0141, code lost:
            r5 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0142, code lost:
            if (r7 == false) goto L_0x015d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0144, code lost:
            r7 = (com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView) r15.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x014c, code lost:
            if (r7 == null) goto L_0x015a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x014e, code lost:
            com.didi.hawaii.mapsdkv2.jni.MapEngineJNI.DMapVulkanSurfaceChanged(r15.vulkanHandle);
            com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.access$400(r7).onSurfaceChanged((javax.microedition.khronos.opengles.GL10) null, r9, r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x015a, code lost:
            r15.mReadyRender = true;
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x015f, code lost:
            if (r15.mReadyRender == false) goto L_0x017f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0161, code lost:
            r12 = (com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView) r15.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0169, code lost:
            if (r12 == null) goto L_0x017f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x016b, code lost:
            com.didi.hawaii.mapsdkv2.jni.MapEngineJNI.DMapVulkanAcquireImage(r15.vulkanHandle);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x0178, code lost:
            if (com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.access$400(r12).onDrawFrame((javax.microedition.khronos.opengles.GL10) null) == false) goto L_0x017f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x017a, code lost:
            com.didi.hawaii.mapsdkv2.jni.MapEngineJNI.DMapVulkanQueuePresent(r15.vulkanHandle);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x017f, code lost:
            if (r8 == false) goto L_0x0010;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0181, code lost:
            r3 = true;
            r8 = false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
                r15 = this;
                r0 = 0
                r15.mHaveVulkanContext = r0
                r15.mHaveVulkanSurface = r0
                r1 = 0
                r2 = 1
                r11 = r1
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
            L_0x0010:
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r12 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x0191 }
                monitor-enter(r12)     // Catch:{ all -> 0x0191 }
            L_0x0015:
                boolean r13 = r15.mShouldExit     // Catch:{ all -> 0x018e }
                if (r13 == 0) goto L_0x002f
                monitor-exit(r12)     // Catch:{ all -> 0x018e }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager
                monitor-enter(r0)
                r15.stopVulkanSurface()     // Catch:{ all -> 0x002c }
                r15.stopEglContextLocked()     // Catch:{ all -> 0x002c }
                long r1 = r15.vulkanHandle     // Catch:{ all -> 0x002c }
                com.didi.hawaii.mapsdkv2.jni.MapEngineJNI.DMapVulkanCleanUpContext(r1)     // Catch:{ all -> 0x002c }
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                return
            L_0x002c:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                throw r1
            L_0x002f:
                java.util.ArrayList<java.lang.Runnable> r13 = r15.mEventQueue     // Catch:{ all -> 0x018e }
                boolean r13 = r13.isEmpty()     // Catch:{ all -> 0x018e }
                if (r13 != 0) goto L_0x0041
                java.util.ArrayList<java.lang.Runnable> r11 = r15.mEventQueue     // Catch:{ all -> 0x018e }
                java.lang.Object r11 = r11.remove(r0)     // Catch:{ all -> 0x018e }
                java.lang.Runnable r11 = (java.lang.Runnable) r11     // Catch:{ all -> 0x018e }
                goto L_0x011b
            L_0x0041:
                boolean r13 = r15.mPaused     // Catch:{ all -> 0x018e }
                boolean r14 = r15.mRequestPaused     // Catch:{ all -> 0x018e }
                if (r13 == r14) goto L_0x0052
                boolean r13 = r15.mRequestPaused     // Catch:{ all -> 0x018e }
                r15.mPaused = r13     // Catch:{ all -> 0x018e }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r13 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x018e }
                r13.notifyAll()     // Catch:{ all -> 0x018e }
            L_0x0052:
                boolean r13 = r15.mShouldReleaseEglContext     // Catch:{ all -> 0x018e }
                if (r13 == 0) goto L_0x005f
                r15.stopVulkanSurface()     // Catch:{ all -> 0x018e }
                r15.stopEglContextLocked()     // Catch:{ all -> 0x018e }
                r15.mShouldReleaseEglContext = r0     // Catch:{ all -> 0x018e }
                r4 = 1
            L_0x005f:
                boolean r13 = r15.mHasSurface     // Catch:{ all -> 0x018e }
                if (r13 != 0) goto L_0x0079
                boolean r13 = r15.mWaitingForSurface     // Catch:{ all -> 0x018e }
                if (r13 != 0) goto L_0x0079
                boolean r13 = r15.mHaveVulkanSurface     // Catch:{ all -> 0x018e }
                if (r13 == 0) goto L_0x006e
                r15.stopVulkanSurface()     // Catch:{ all -> 0x018e }
            L_0x006e:
                r15.mWaitingForSurface = r2     // Catch:{ all -> 0x018e }
                r15.mSurfaceIsBad = r0     // Catch:{ all -> 0x018e }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r13 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x018e }
                r13.notifyAll()     // Catch:{ all -> 0x018e }
            L_0x0079:
                boolean r13 = r15.mHasSurface     // Catch:{ all -> 0x018e }
                if (r13 == 0) goto L_0x008a
                boolean r13 = r15.mWaitingForSurface     // Catch:{ all -> 0x018e }
                if (r13 == 0) goto L_0x008a
                r15.mWaitingForSurface = r0     // Catch:{ all -> 0x018e }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r13 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x018e }
                r13.notifyAll()     // Catch:{ all -> 0x018e }
            L_0x008a:
                if (r3 == 0) goto L_0x0098
                r15.mWantRenderNotification = r0     // Catch:{ all -> 0x018e }
                r15.mRenderComplete = r2     // Catch:{ all -> 0x018e }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r3 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x018e }
                r3.notifyAll()     // Catch:{ all -> 0x018e }
                r3 = 0
            L_0x0098:
                boolean r13 = r15.readyToDraw()     // Catch:{ all -> 0x018e }
                if (r13 == 0) goto L_0x0185
                boolean r13 = r15.mHaveVulkanContext     // Catch:{ all -> 0x018e }
                if (r13 != 0) goto L_0x00bf
                if (r4 == 0) goto L_0x00a6
                r4 = 0
                goto L_0x00bf
            L_0x00a6:
                long r13 = r15.vulkanHandle     // Catch:{ RuntimeException -> 0x00b6 }
                com.didi.hawaii.mapsdkv2.jni.MapEngineJNI.DMapVulkanCreateContext(r13)     // Catch:{ RuntimeException -> 0x00b6 }
                r15.mHaveVulkanContext = r2     // Catch:{ all -> 0x018e }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r5 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x018e }
                r5.notifyAll()     // Catch:{ all -> 0x018e }
                r5 = 1
                goto L_0x00bf
            L_0x00b6:
                r0 = move-exception
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x018e }
                r1.releaseEglContextLocked(r15)     // Catch:{ all -> 0x018e }
                throw r0     // Catch:{ all -> 0x018e }
            L_0x00bf:
                boolean r13 = r15.mHaveVulkanContext     // Catch:{ all -> 0x018e }
                if (r13 == 0) goto L_0x00e2
                boolean r13 = r15.mHaveVulkanSurface     // Catch:{ all -> 0x018e }
                if (r13 != 0) goto L_0x00e2
                r15.mHaveVulkanSurface = r2     // Catch:{ all -> 0x018e }
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView> r6 = r15.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x018e }
                java.lang.Object r6 = r6.get()     // Catch:{ all -> 0x018e }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView r6 = (com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView) r6     // Catch:{ all -> 0x018e }
                if (r6 == 0) goto L_0x00e0
                long r13 = r15.vulkanHandle     // Catch:{ all -> 0x018e }
                android.view.SurfaceHolder r6 = r6.getHolder()     // Catch:{ all -> 0x018e }
                android.view.Surface r6 = r6.getSurface()     // Catch:{ all -> 0x018e }
                com.didi.hawaii.mapsdkv2.jni.MapEngineJNI.DMapVulkanSetWindow_Wrap(r13, r6)     // Catch:{ all -> 0x018e }
            L_0x00e0:
                r6 = 1
                r7 = 1
            L_0x00e2:
                boolean r13 = r15.mHaveVulkanSurface     // Catch:{ all -> 0x018e }
                if (r13 == 0) goto L_0x0185
                boolean r13 = r15.mSizeChanged     // Catch:{ all -> 0x018e }
                if (r13 == 0) goto L_0x010d
                int r6 = r15.mWidth     // Catch:{ all -> 0x018e }
                int r7 = r15.mHeight     // Catch:{ all -> 0x018e }
                r15.mWantRenderNotification = r2     // Catch:{ all -> 0x018e }
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView> r9 = r15.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x018e }
                java.lang.Object r9 = r9.get()     // Catch:{ all -> 0x018e }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView r9 = (com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView) r9     // Catch:{ all -> 0x018e }
                if (r9 == 0) goto L_0x0107
                long r13 = r15.vulkanHandle     // Catch:{ all -> 0x018e }
                android.view.SurfaceHolder r9 = r9.getHolder()     // Catch:{ all -> 0x018e }
                android.view.Surface r9 = r9.getSurface()     // Catch:{ all -> 0x018e }
                com.didi.hawaii.mapsdkv2.jni.MapEngineJNI.DMapVulkanSetWindow_Wrap(r13, r9)     // Catch:{ all -> 0x018e }
            L_0x0107:
                r15.mSizeChanged = r0     // Catch:{ all -> 0x018e }
                r9 = r6
                r10 = r7
                r6 = 1
                r7 = 1
            L_0x010d:
                r15.mRequestRender = r0     // Catch:{ all -> 0x018e }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r13 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x018e }
                r13.notifyAll()     // Catch:{ all -> 0x018e }
                boolean r13 = r15.mWantRenderNotification     // Catch:{ all -> 0x018e }
                if (r13 == 0) goto L_0x011b
                r8 = 1
            L_0x011b:
                monitor-exit(r12)     // Catch:{ all -> 0x018e }
                if (r11 == 0) goto L_0x0124
                r11.run()     // Catch:{ all -> 0x0191 }
                r11 = r1
                goto L_0x0010
            L_0x0124:
                if (r6 == 0) goto L_0x013f
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView> r6 = r15.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x0191 }
                java.lang.Object r6 = r6.get()     // Catch:{ all -> 0x0191 }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView r6 = (com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView) r6     // Catch:{ all -> 0x0191 }
                if (r6 == 0) goto L_0x013c
                long r12 = r15.vulkanHandle     // Catch:{ all -> 0x0191 }
                com.didi.hawaii.mapsdkv2.jni.MapEngineJNI.DMapVulkanSurfaceCreated(r12)     // Catch:{ all -> 0x0191 }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$Renderer r6 = r6.mRenderer     // Catch:{ all -> 0x0191 }
                r6.onSurfaceCreated(r1, r1)     // Catch:{ all -> 0x0191 }
            L_0x013c:
                r15.mReadyRender = r2     // Catch:{ all -> 0x0191 }
                r6 = 0
            L_0x013f:
                if (r5 == 0) goto L_0x0142
                r5 = 0
            L_0x0142:
                if (r7 == 0) goto L_0x015d
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView> r7 = r15.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x0191 }
                java.lang.Object r7 = r7.get()     // Catch:{ all -> 0x0191 }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView r7 = (com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView) r7     // Catch:{ all -> 0x0191 }
                if (r7 == 0) goto L_0x015a
                long r12 = r15.vulkanHandle     // Catch:{ all -> 0x0191 }
                com.didi.hawaii.mapsdkv2.jni.MapEngineJNI.DMapVulkanSurfaceChanged(r12)     // Catch:{ all -> 0x0191 }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$Renderer r7 = r7.mRenderer     // Catch:{ all -> 0x0191 }
                r7.onSurfaceChanged(r1, r9, r10)     // Catch:{ all -> 0x0191 }
            L_0x015a:
                r15.mReadyRender = r2     // Catch:{ all -> 0x0191 }
                r7 = 0
            L_0x015d:
                boolean r12 = r15.mReadyRender     // Catch:{ all -> 0x0191 }
                if (r12 == 0) goto L_0x017f
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView> r12 = r15.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x0191 }
                java.lang.Object r12 = r12.get()     // Catch:{ all -> 0x0191 }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView r12 = (com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView) r12     // Catch:{ all -> 0x0191 }
                if (r12 == 0) goto L_0x017f
                long r13 = r15.vulkanHandle     // Catch:{ all -> 0x0191 }
                com.didi.hawaii.mapsdkv2.jni.MapEngineJNI.DMapVulkanAcquireImage(r13)     // Catch:{ all -> 0x0191 }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$Renderer r12 = r12.mRenderer     // Catch:{ all -> 0x0191 }
                boolean r12 = r12.onDrawFrame(r1)     // Catch:{ all -> 0x0191 }
                if (r12 == 0) goto L_0x017f
                long r12 = r15.vulkanHandle     // Catch:{ all -> 0x0191 }
                com.didi.hawaii.mapsdkv2.jni.MapEngineJNI.DMapVulkanQueuePresent(r12)     // Catch:{ all -> 0x0191 }
            L_0x017f:
                if (r8 == 0) goto L_0x0010
                r3 = 1
                r8 = 0
                goto L_0x0010
            L_0x0185:
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r13 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x018e }
                r13.wait()     // Catch:{ all -> 0x018e }
                goto L_0x0015
            L_0x018e:
                r0 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x018e }
                throw r0     // Catch:{ all -> 0x0191 }
            L_0x0191:
                r0 = move-exception
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager
                monitor-enter(r1)
                r15.stopVulkanSurface()     // Catch:{ all -> 0x01a4 }
                r15.stopEglContextLocked()     // Catch:{ all -> 0x01a4 }
                long r2 = r15.vulkanHandle     // Catch:{ all -> 0x01a4 }
                com.didi.hawaii.mapsdkv2.jni.MapEngineJNI.DMapVulkanCleanUpContext(r2)     // Catch:{ all -> 0x01a4 }
                monitor-exit(r1)     // Catch:{ all -> 0x01a4 }
                throw r0
            L_0x01a4:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x01a4 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.VKThread.guardedRun():void");
        }

        public boolean ableToDraw() {
            return this.mHaveVulkanContext && this.mHaveVulkanSurface && readyToDraw();
        }

        private boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (VulkanSurfaceView.sVKThreadManager) {
                this.mRenderMode = i;
                VulkanSurfaceView.sVKThreadManager.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (VulkanSurfaceView.sVKThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (VulkanSurfaceView.sVKThreadManager) {
                this.mRequestRender = true;
                VulkanSurfaceView.sVKThreadManager.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:16|17|18|19|31|25|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x001c, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0036 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void requestRenderAndWait() {
            /*
                r2 = this;
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager
                monitor-enter(r0)
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0040 }
                if (r1 != r2) goto L_0x000d
                monitor-exit(r0)     // Catch:{ all -> 0x0040 }
                return
            L_0x000d:
                r1 = 1
                r2.mWantRenderNotification = r1     // Catch:{ all -> 0x0040 }
                r2.mRequestRender = r1     // Catch:{ all -> 0x0040 }
                r1 = 0
                r2.mRenderComplete = r1     // Catch:{ all -> 0x0040 }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x0040 }
                r1.notifyAll()     // Catch:{ all -> 0x0040 }
            L_0x001c:
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0040 }
                if (r1 != 0) goto L_0x003e
                boolean r1 = r2.mPaused     // Catch:{ all -> 0x0040 }
                if (r1 != 0) goto L_0x003e
                boolean r1 = r2.mRenderComplete     // Catch:{ all -> 0x0040 }
                if (r1 != 0) goto L_0x003e
                boolean r1 = r2.ableToDraw()     // Catch:{ all -> 0x0040 }
                if (r1 == 0) goto L_0x003e
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ InterruptedException -> 0x0036 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0036 }
                goto L_0x001c
            L_0x0036:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0040 }
                r1.interrupt()     // Catch:{ all -> 0x0040 }
                goto L_0x001c
            L_0x003e:
                monitor-exit(r0)     // Catch:{ all -> 0x0040 }
                return
            L_0x0040:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0040 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.VKThread.requestRenderAndWait():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0012, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void surfaceCreated() {
            /*
                r2 = this;
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mHasSurface = r1     // Catch:{ all -> 0x0030 }
                r1 = 0
                r2.mFinishedCreatingEglSurface = r1     // Catch:{ all -> 0x0030 }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x0030 }
                r1.notifyAll()     // Catch:{ all -> 0x0030 }
            L_0x0012:
                boolean r1 = r2.mWaitingForSurface     // Catch:{ all -> 0x0030 }
                if (r1 == 0) goto L_0x002e
                boolean r1 = r2.mFinishedCreatingEglSurface     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ InterruptedException -> 0x0026 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0026 }
                goto L_0x0012
            L_0x0026:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0030 }
                r1.interrupt()     // Catch:{ all -> 0x0030 }
                goto L_0x0012
            L_0x002e:
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                return
            L_0x0030:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.VKThread.surfaceCreated():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void surfaceDestroyed() {
            /*
                r2 = this;
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager
                monitor-enter(r0)
                r1 = 0
                r2.mHasSurface = r1     // Catch:{ all -> 0x0029 }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.mWaitingForSurface     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.VKThread.surfaceDestroyed():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPause() {
            /*
                r2 = this;
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mRequestPaused = r1     // Catch:{ all -> 0x0029 }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.mPaused     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.VKThread.onPause():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0014, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0028 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResume() {
            /*
                r3 = this;
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager
                monitor-enter(r0)
                r1 = 0
                r3.mRequestPaused = r1     // Catch:{ all -> 0x0032 }
                r2 = 1
                r3.mRequestRender = r2     // Catch:{ all -> 0x0032 }
                r3.mRenderComplete = r1     // Catch:{ all -> 0x0032 }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x0032 }
                r1.notifyAll()     // Catch:{ all -> 0x0032 }
            L_0x0014:
                boolean r1 = r3.mExited     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                boolean r1 = r3.mPaused     // Catch:{ all -> 0x0032 }
                if (r1 == 0) goto L_0x0030
                boolean r1 = r3.mRenderComplete     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ InterruptedException -> 0x0028 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0028 }
                goto L_0x0014
            L_0x0028:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0032 }
                r1.interrupt()     // Catch:{ all -> 0x0032 }
                goto L_0x0014
            L_0x0030:
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                return
            L_0x0032:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.VKThread.onResume():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:16|17|18|19|31|25|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0020, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x003a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onWindowResize(int r2, int r3) {
            /*
                r1 = this;
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager
                monitor-enter(r0)
                r1.mWidth = r2     // Catch:{ all -> 0x0044 }
                r1.mHeight = r3     // Catch:{ all -> 0x0044 }
                r2 = 1
                r1.mSizeChanged = r2     // Catch:{ all -> 0x0044 }
                r1.mRequestRender = r2     // Catch:{ all -> 0x0044 }
                r2 = 0
                r1.mRenderComplete = r2     // Catch:{ all -> 0x0044 }
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0044 }
                if (r2 != r1) goto L_0x0019
                monitor-exit(r0)     // Catch:{ all -> 0x0044 }
                return
            L_0x0019:
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r2 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x0044 }
                r2.notifyAll()     // Catch:{ all -> 0x0044 }
            L_0x0020:
                boolean r2 = r1.mExited     // Catch:{ all -> 0x0044 }
                if (r2 != 0) goto L_0x0042
                boolean r2 = r1.mPaused     // Catch:{ all -> 0x0044 }
                if (r2 != 0) goto L_0x0042
                boolean r2 = r1.mRenderComplete     // Catch:{ all -> 0x0044 }
                if (r2 != 0) goto L_0x0042
                boolean r2 = r1.ableToDraw()     // Catch:{ all -> 0x0044 }
                if (r2 == 0) goto L_0x0042
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r2 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ InterruptedException -> 0x003a }
                r2.wait()     // Catch:{ InterruptedException -> 0x003a }
                goto L_0x0020
            L_0x003a:
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0044 }
                r2.interrupt()     // Catch:{ all -> 0x0044 }
                goto L_0x0020
            L_0x0042:
                monitor-exit(r0)     // Catch:{ all -> 0x0044 }
                return
            L_0x0044:
                r2 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0044 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.VKThread.onWindowResize(int, int):void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void requestExitAndWait() {
            /*
                r2 = this;
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mShouldExit = r1     // Catch:{ all -> 0x0025 }
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ all -> 0x0025 }
                r1.notifyAll()     // Catch:{ all -> 0x0025 }
            L_0x000f:
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0025 }
                if (r1 != 0) goto L_0x0023
                com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.sVKThreadManager     // Catch:{ InterruptedException -> 0x001b }
                r1.wait()     // Catch:{ InterruptedException -> 0x001b }
                goto L_0x000f
            L_0x001b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0025 }
                r1.interrupt()     // Catch:{ all -> 0x0025 }
                goto L_0x000f
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView.VKThread.requestExitAndWait():void");
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            VulkanSurfaceView.sVKThreadManager.notifyAll();
        }

        public void queueEvent(Runnable runnable) {
            if (runnable != null) {
                synchronized (VulkanSurfaceView.sVKThreadManager) {
                    this.mEventQueue.add(runnable);
                    VulkanSurfaceView.sVKThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        public void close() {
            flushBuilder();
        }

        public void flush() {
            flushBuilder();
        }

        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                SystemUtils.log(2, VulkanSurfaceView.TAG, this.mBuilder.toString(), (Throwable) null, "com.didi.hawaii.mapsdkv2.view.VulkanSurfaceView$LogWriter", 1253);
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }
    }

    private void checkRenderThreadState() {
        if (this.mVKThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static class GLThreadManager {
        private static String TAG = "GLThreadManager";

        private GLThreadManager() {
        }

        public synchronized void threadExiting(VKThread vKThread) {
            boolean unused = vKThread.mExited = true;
            notifyAll();
        }

        public void releaseEglContextLocked(VKThread vKThread) {
            notifyAll();
        }
    }
}
