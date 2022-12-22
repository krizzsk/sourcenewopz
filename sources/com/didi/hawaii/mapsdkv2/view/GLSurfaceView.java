package com.didi.hawaii.mapsdkv2.view;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.OmegaUtils;
import com.didi.map.MapApolloHawaii;
import com.didi.map.common.ApolloHawaii;
import com.didi.sdk.apm.SystemUtils;
import java.io.Writer;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class GLSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    /* access modifiers changed from: private */
    public static final boolean LOG_SURFACE = MapApolloHawaii.GL_THREAD_LAG_TRACTLOG;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLSurfaceView";
    protected static final boolean performanceGlSurface = ApolloHawaii.performanceGlSurfaceView();
    /* access modifiers changed from: private */
    public static final GLThreadManager sGLThreadManager = new GLThreadManager();
    /* access modifiers changed from: private */
    public static final boolean useAndroidOGLSurfaceView = (Build.VERSION.SDK_INT >= 26 && ApolloHawaii.useAndroidOGLSurfaceView());
    /* access modifiers changed from: private */
    public int mDebugFlags;
    private boolean mDetached;
    /* access modifiers changed from: private */
    public EGLConfigChooser mEGLConfigChooser;
    /* access modifiers changed from: private */
    public int mEGLContextClientVersion;
    /* access modifiers changed from: private */
    public EGLContextFactory mEGLContextFactory;
    /* access modifiers changed from: private */
    public EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    /* access modifiers changed from: private */
    public GLWrapper mGLWrapper;
    /* access modifiers changed from: private */
    public boolean mPreserveEGLContextOnPause;
    /* access modifiers changed from: private */
    public Renderer mRenderer;
    private final WeakReference<GLSurfaceView> mThisWeakRef = new WeakReference<>(this);

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

    public GLSurfaceView(Context context) {
        super(context);
        init();
    }

    public GLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.mGLThread != null) {
                this.mGLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        HWLog.m16761i(TAG, "useAndroidOGLSurfaceView = " + useAndroidOGLSurfaceView);
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
        GLThread gLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread = gLThread;
        gLThread.start();
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
        this.mGLThread.setRenderMode(i);
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mGLThread.surfaceDestroyed();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mGLThread.onWindowResize(i2, i3);
    }

    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        if (useAndroidOGLSurfaceView) {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                gLThread.requestRenderAndNotify(runnable);
                return;
            }
            return;
        }
        surfaceRedrawNeeded(surfaceHolder);
        runnable.run();
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        GLThread gLThread;
        if (!useAndroidOGLSurfaceView && (gLThread = this.mGLThread) != null) {
            gLThread.requestRenderAndWait();
        }
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    public void queueEvent(final Runnable runnable) {
        this.mGLThread.queueEvent(new RenderTask() {
            public void run() {
                runnable.run();
            }
        });
    }

    public void queueRenderEvent(RenderTask renderTask) {
        this.mGLThread.queueEvent(renderTask);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.mRenderer != null) {
            GLThread gLThread = this.mGLThread;
            int renderMode = gLThread != null ? gLThread.getRenderMode() : 1;
            GLThread gLThread2 = new GLThread(this.mThisWeakRef);
            this.mGLThread = gLThread2;
            if (renderMode != 1) {
                gLThread2.setRenderMode(renderMode);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (!performanceGlSurface) {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                gLThread.requestExitAndWait();
            }
            this.mDetached = true;
        }
        try {
            super.onDetachedFromWindow();
        } catch (Exception unused) {
            OmegaUtils.trackMapException("mSurfaceView NullPointer");
        }
    }

    public void onDetachedGLThread() {
        if (performanceGlSurface) {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                gLThread.requestExitAndWait();
            }
            this.mDetached = true;
        }
    }

    private class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLSurfaceView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLSurfaceView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                SystemUtils.log(6, "DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext, (Throwable) null, "com.didi.hawaii.mapsdkv2.view.GLSurfaceView$DefaultContextFactory", 719);
                EglHelper.throwEglException("eglDestroyContex", egl10.eglGetError());
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
                SystemUtils.log(6, GLSurfaceView.TAG, "eglCreateWindowSurface", e, "com.didi.hawaii.mapsdkv2.view.GLSurfaceView$DefaultWindowSurfaceFactory", 757);
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
            if (GLSurfaceView.this.mEGLContextClientVersion != 2 && GLSurfaceView.this.mEGLContextClientVersion != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (GLSurfaceView.this.mEGLContextClientVersion == 2) {
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

    private static class EglHelper {
        private static final Object lock = new Object();
        private boolean isLockThread = ApolloHawaii.isLockGLThread();
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;

        public EglHelper(WeakReference<GLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public void start() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.mEgl = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                    GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                    if (gLSurfaceView == null) {
                        this.mEglConfig = null;
                        this.mEglContext = null;
                    } else {
                        this.mEglConfig = gLSurfaceView.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                        this.mEglContext = gLSurfaceView.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                    }
                    EGLContext eGLContext = this.mEglContext;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.mEglContext = null;
                        throwEglException("createContext");
                    }
                    this.mEglSurface = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean createSurface() {
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.mEglConfig != null) {
                destroySurfaceImp();
                GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (gLSurfaceView != null) {
                    this.mEglSurface = gLSurfaceView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, gLSurfaceView.getHolder());
                } else {
                    this.mEglSurface = null;
                }
                EGLSurface eGLSurface = this.mEglSurface;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.mEgl.eglGetError() == 12299) {
                        SystemUtils.log(6, "EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.", (Throwable) null, "com.didi.hawaii.mapsdkv2.view.GLSurfaceView$EglHelper", 1027);
                    }
                    return false;
                }
                EGL10 egl10 = this.mEgl;
                EGLDisplay eGLDisplay = this.mEglDisplay;
                EGLSurface eGLSurface2 = this.mEglSurface;
                if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.mEglContext)) {
                    return true;
                }
                logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                return false;
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        /* access modifiers changed from: package-private */
        public GL createGL() {
            GL gl = this.mEglContext.getGL();
            GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
            if (gLSurfaceView == null) {
                return gl;
            }
            if (gLSurfaceView.mGLWrapper != null) {
                gl = gLSurfaceView.mGLWrapper.wrap(gl);
            }
            if ((gLSurfaceView.mDebugFlags & 3) == 0) {
                return gl;
            }
            int i = 0;
            LogWriter logWriter = null;
            if ((gLSurfaceView.mDebugFlags & 1) != 0) {
                i = 1;
            }
            if ((gLSurfaceView.mDebugFlags & 2) != 0) {
                logWriter = new LogWriter();
            }
            return GLDebugHelper.wrap(gl, i, logWriter);
        }

        public int swap() {
            if (this.isLockThread) {
                synchronized (lock) {
                    if (this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                        return 12288;
                    }
                    int eglGetError = this.mEgl.eglGetError();
                    return eglGetError;
                }
            } else if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return this.mEgl.eglGetError();
            } else {
                return 12288;
            }
        }

        public void destroySurface() {
            destroySurfaceImp();
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (gLSurfaceView != null) {
                    gLSurfaceView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (gLSurfaceView != null) {
                    gLSurfaceView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        private void throwEglException(String str) {
            throwEglException(str, this.mEgl.eglGetError());
        }

        public static void throwEglException(String str, int i) {
            throw new RuntimeException(formatEglError(str, i));
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            SystemUtils.log(5, str, formatEglError(str2, i), (Throwable) null, "com.didi.hawaii.mapsdkv2.view.GLSurfaceView$EglHelper", 1150);
        }

        public static String formatEglError(String str, int i) {
            return str + " failed error code:  " + i;
        }
    }

    static class GLThread extends Thread {
        private RenderTask head = null;
        private EglHelper mEglHelper;
        /* access modifiers changed from: private */
        public boolean mExited;
        private Runnable mFinishDrawingRunnable = null;
        private boolean mFinishedCreatingEglSurface;
        private WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight = 0;
        private boolean mPaused;
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
        private RenderTask tail = null;

        GLThread(WeakReference<GLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public void run() {
            setName("GLThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLSurfaceView.sGLThreadManager.threadExiting(this);
                throw th;
            }
            GLSurfaceView.sGLThreadManager.threadExiting(this);
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                GLSurfaceView.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        /* JADX WARNING: type inference failed for: r0v31, types: [javax.microedition.khronos.opengles.GL] */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x027a, code lost:
            if (r16 == null) goto L_0x0285;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:?, code lost:
            r16.run();
            r4 = r0;
            r16 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x0285, code lost:
            if (r11 == false) goto L_0x02d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x028b, code lost:
            if (com.didi.hawaii.mapsdkv2.view.GLSurfaceView.access$900() == false) goto L_0x029c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x028d, code lost:
            com.didi.sdk.apm.SystemUtils.log(5, "GLThread", "egl createSurface", (java.lang.Throwable) null, "com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThread", 1451);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x02a2, code lost:
            if (r1.mEglHelper.createSurface() == false) goto L_0x02b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x02a4, code lost:
            r3 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x02a8, code lost:
            monitor-enter(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:?, code lost:
            r1.mFinishedCreatingEglSurface = true;
            com.didi.hawaii.mapsdkv2.view.GLSurfaceView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x02b3, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x02b4, code lost:
            r11 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x02b9, code lost:
            r3 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x02bd, code lost:
            monitor-enter(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:?, code lost:
            r1.mFinishedCreatingEglSurface = true;
            r1.mSurfaceIsBad = true;
            com.didi.hawaii.mapsdkv2.view.GLSurfaceView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x02ca, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x02cb, code lost:
            r4 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x02d2, code lost:
            if (r12 == false) goto L_0x02de;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x02d4, code lost:
            r9 = r1.mEglHelper.createGL();
            r12 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x02de, code lost:
            if (r10 == false) goto L_0x02f6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x02e0, code lost:
            r0 = (com.didi.hawaii.mapsdkv2.view.GLSurfaceView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x02e8, code lost:
            if (r0 == null) goto L_0x02f5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x02ea, code lost:
            com.didi.hawaii.mapsdkv2.view.GLSurfaceView.access$1200(r0).onSurfaceCreated(r9, r1.mEglHelper.mEglConfig);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x02f5, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x02f6, code lost:
            if (r13 == false) goto L_0x030a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x02f8, code lost:
            r0 = (com.didi.hawaii.mapsdkv2.view.GLSurfaceView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x0300, code lost:
            if (r0 == null) goto L_0x0309;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x0302, code lost:
            com.didi.hawaii.mapsdkv2.view.GLSurfaceView.access$1200(r0).onSurfaceChanged(r9, r14, r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x0309, code lost:
            r13 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x030a, code lost:
            r0 = (com.didi.hawaii.mapsdkv2.view.GLSurfaceView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x0312, code lost:
            if (r0 == null) goto L_0x0337;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x0314, code lost:
            if (r2 == false) goto L_0x032b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x0316, code lost:
            r3 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.access$1200(r0).onDrawFrame(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x0322, code lost:
            if (com.didi.hawaii.mapsdkv2.view.GLSurfaceView.access$1100() == false) goto L_0x0338;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x0324, code lost:
            if (r8 == null) goto L_0x0338;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x0326, code lost:
            r8.run();
            r8 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x032b, code lost:
            r9.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            r9.glClear(16384);
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x0337, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x0338, code lost:
            if (r3 == false) goto L_0x0389;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x033a, code lost:
            r0 = r1.mEglHelper.swap();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x0342, code lost:
            if (r0 == 12288) goto L_0x0386;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x0346, code lost:
            if (r0 == 12302) goto L_0x0363;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0348, code lost:
            com.didi.hawaii.mapsdkv2.view.GLSurfaceView.EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r0);
            r3 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x0353, code lost:
            monitor-enter(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:?, code lost:
            r1.mSurfaceIsBad = true;
            com.didi.hawaii.mapsdkv2.view.GLSurfaceView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x035e, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:209:0x0368, code lost:
            if (com.didi.hawaii.mapsdkv2.view.GLSurfaceView.access$900() == false) goto L_0x0384;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x036a, code lost:
            com.didi.hawaii.log.HWLog.m16761i("GLThread", "egl context lost tid=" + getId());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x0384, code lost:
            r5 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:212:0x0386, code lost:
            if (r2 != false) goto L_0x0389;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:213:0x0388, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x0389, code lost:
            if (r17 == false) goto L_0x038e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:215:0x038b, code lost:
            r6 = true;
            r17 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:216:0x038e, code lost:
            r4 = null;
            r1 = r25;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x01ea A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x01f0 A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x01f9 A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:218:0x0396 A[SYNTHETIC, Splitter:B:218:0x0396] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x007e A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x008c A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0091 A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00c4 A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00c9 A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00d6 A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0102 A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0115 A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0117 A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x011d A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x014f A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x016d A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x018b A[Catch:{ RuntimeException -> 0x0213 }] */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x01b1 A[Catch:{ RuntimeException -> 0x0213 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
                r25 = this;
                r1 = r25
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$EglHelper r0 = new com.didi.hawaii.mapsdkv2.view.GLSurfaceView$EglHelper
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.GLSurfaceView> r2 = r1.mGLSurfaceViewWeakRef
                r0.<init>(r2)
                r1.mEglHelper = r0
                r0 = 0
                r1.mHaveEglContext = r0
                r1.mHaveEglSurface = r0
                r1.mWantRenderNotification = r0
                boolean r2 = com.didi.map.common.ApolloHawaii.ADD_ENGINE_AFTER_FIRST_FRAME     // Catch:{ all -> 0x03b4 }
                if (r2 == 0) goto L_0x0018
                r2 = 0
                goto L_0x0019
            L_0x0018:
                r2 = 1
            L_0x0019:
                r4 = 0
                r8 = r4
                r9 = r8
                r16 = r9
                r5 = 0
                r6 = 0
                r7 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r17 = 0
            L_0x0029:
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r18 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x03b4 }
                monitor-enter(r18)     // Catch:{ all -> 0x03b4 }
            L_0x002e:
                boolean r3 = r1.mShouldExit     // Catch:{ all -> 0x03b1 }
                if (r3 == 0) goto L_0x0043
                monitor-exit(r18)     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r2 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r2)
                r25.stopEglSurfaceLocked()     // Catch:{ all -> 0x0040 }
                r25.stopEglContextLocked()     // Catch:{ all -> 0x0040 }
                monitor-exit(r2)     // Catch:{ all -> 0x0040 }
                return
            L_0x0040:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0040 }
                throw r0
            L_0x0043:
                boolean r3 = com.didi.map.common.ApolloHawaii.USE_SHARE_CONTEXT     // Catch:{ all -> 0x03b1 }
                if (r3 == 0) goto L_0x0060
                com.didi.hawaii.mapsdkv2.view.RenderTask r3 = r1.head     // Catch:{ all -> 0x03b1 }
                if (r3 == 0) goto L_0x0078
                boolean r3 = r1.mHaveEglContext     // Catch:{ all -> 0x03b1 }
                if (r3 == 0) goto L_0x0078
                if (r2 == 0) goto L_0x0078
                com.didi.hawaii.mapsdkv2.view.RenderTask r3 = r1.head     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.mapsdkv2.view.RenderTask r0 = r1.head     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.mapsdkv2.view.RenderTask r0 = r0.next     // Catch:{ all -> 0x03b1 }
                r1.head = r0     // Catch:{ all -> 0x03b1 }
                if (r0 != 0) goto L_0x005d
                r1.tail = r4     // Catch:{ all -> 0x03b1 }
            L_0x005d:
                r16 = r3
                goto L_0x0074
            L_0x0060:
                com.didi.hawaii.mapsdkv2.view.RenderTask r0 = r1.head     // Catch:{ all -> 0x03b1 }
                if (r0 == 0) goto L_0x0078
                if (r2 == 0) goto L_0x0078
                com.didi.hawaii.mapsdkv2.view.RenderTask r0 = r1.head     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.mapsdkv2.view.RenderTask r3 = r1.head     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.mapsdkv2.view.RenderTask r3 = r3.next     // Catch:{ all -> 0x03b1 }
                r1.head = r3     // Catch:{ all -> 0x03b1 }
                if (r3 != 0) goto L_0x0072
                r1.tail = r4     // Catch:{ all -> 0x03b1 }
            L_0x0072:
                r16 = r0
            L_0x0074:
                r0 = r4
                r4 = 0
                goto L_0x0279
            L_0x0078:
                boolean r0 = r1.mPaused     // Catch:{ all -> 0x03b1 }
                boolean r3 = r1.mRequestPaused     // Catch:{ all -> 0x03b1 }
                if (r0 == r3) goto L_0x008c
                boolean r0 = r1.mRequestPaused     // Catch:{ all -> 0x03b1 }
                boolean r3 = r1.mRequestPaused     // Catch:{ all -> 0x03b1 }
                r1.mPaused = r3     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r3 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x03b1 }
                r3.notifyAll()     // Catch:{ all -> 0x03b1 }
                goto L_0x008d
            L_0x008c:
                r0 = 0
            L_0x008d:
                boolean r3 = r1.mShouldReleaseEglContext     // Catch:{ all -> 0x03b1 }
                if (r3 == 0) goto L_0x00c4
                boolean r3 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.LOG_SURFACE     // Catch:{ all -> 0x03b1 }
                if (r3 == 0) goto L_0x00b6
                java.lang.String r3 = "GLThread"
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x03b1 }
                r7.<init>()     // Catch:{ all -> 0x03b1 }
                java.lang.String r4 = "releasing EGL context because asked to tid="
                r7.append(r4)     // Catch:{ all -> 0x03b1 }
                r21 = r8
                r4 = r9
                long r8 = r25.getId()     // Catch:{ all -> 0x03b1 }
                r7.append(r8)     // Catch:{ all -> 0x03b1 }
                java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.log.HWLog.m16761i(r3, r7)     // Catch:{ all -> 0x03b1 }
                goto L_0x00b9
            L_0x00b6:
                r21 = r8
                r4 = r9
            L_0x00b9:
                r25.stopEglSurfaceLocked()     // Catch:{ all -> 0x03b1 }
                r25.stopEglContextLocked()     // Catch:{ all -> 0x03b1 }
                r3 = 0
                r1.mShouldReleaseEglContext = r3     // Catch:{ all -> 0x03b1 }
                r7 = 1
                goto L_0x00c7
            L_0x00c4:
                r21 = r8
                r4 = r9
            L_0x00c7:
                if (r5 == 0) goto L_0x00d0
                r25.stopEglSurfaceLocked()     // Catch:{ all -> 0x03b1 }
                r25.stopEglContextLocked()     // Catch:{ all -> 0x03b1 }
                r5 = 0
            L_0x00d0:
                if (r0 == 0) goto L_0x0102
                boolean r3 = r1.mHaveEglSurface     // Catch:{ all -> 0x03b1 }
                if (r3 == 0) goto L_0x0102
                boolean r3 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.LOG_SURFACE     // Catch:{ all -> 0x03b1 }
                if (r3 == 0) goto L_0x00fb
                java.lang.String r3 = "GLThread"
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x03b1 }
                r8.<init>()     // Catch:{ all -> 0x03b1 }
                java.lang.String r9 = "releasing EGL surface because paused tid="
                r8.append(r9)     // Catch:{ all -> 0x03b1 }
                r9 = r4
                r22 = r5
                long r4 = r25.getId()     // Catch:{ all -> 0x03b1 }
                r8.append(r4)     // Catch:{ all -> 0x03b1 }
                java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.log.HWLog.m16761i(r3, r4)     // Catch:{ all -> 0x03b1 }
                goto L_0x00fe
            L_0x00fb:
                r9 = r4
                r22 = r5
            L_0x00fe:
                r25.stopEglSurfaceLocked()     // Catch:{ all -> 0x03b1 }
                goto L_0x0105
            L_0x0102:
                r9 = r4
                r22 = r5
            L_0x0105:
                if (r0 == 0) goto L_0x0141
                boolean r0 = r1.mHaveEglContext     // Catch:{ all -> 0x03b1 }
                if (r0 == 0) goto L_0x0141
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.GLSurfaceView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x03b1 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView r0 = (com.didi.hawaii.mapsdkv2.view.GLSurfaceView) r0     // Catch:{ all -> 0x03b1 }
                if (r0 != 0) goto L_0x0117
                r0 = 0
                goto L_0x011b
            L_0x0117:
                boolean r0 = r0.mPreserveEGLContextOnPause     // Catch:{ all -> 0x03b1 }
            L_0x011b:
                if (r0 != 0) goto L_0x0141
                r25.stopEglContextLocked()     // Catch:{ all -> 0x03b1 }
                boolean r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.LOG_SURFACE     // Catch:{ all -> 0x03b1 }
                if (r0 == 0) goto L_0x0141
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03b1 }
                r3.<init>()     // Catch:{ all -> 0x03b1 }
                java.lang.String r4 = "releasing EGL context because paused tid="
                r3.append(r4)     // Catch:{ all -> 0x03b1 }
                long r4 = r25.getId()     // Catch:{ all -> 0x03b1 }
                r3.append(r4)     // Catch:{ all -> 0x03b1 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.log.HWLog.m16761i(r0, r3)     // Catch:{ all -> 0x03b1 }
            L_0x0141:
                boolean r0 = r1.mHasSurface     // Catch:{ all -> 0x03b1 }
                if (r0 != 0) goto L_0x017d
                boolean r0 = r1.mWaitingForSurface     // Catch:{ all -> 0x03b1 }
                if (r0 != 0) goto L_0x017d
                boolean r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.LOG_SURFACE     // Catch:{ all -> 0x03b1 }
                if (r0 == 0) goto L_0x0169
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03b1 }
                r3.<init>()     // Catch:{ all -> 0x03b1 }
                java.lang.String r4 = "noticed surfaceView surface lost tid="
                r3.append(r4)     // Catch:{ all -> 0x03b1 }
                long r4 = r25.getId()     // Catch:{ all -> 0x03b1 }
                r3.append(r4)     // Catch:{ all -> 0x03b1 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.log.HWLog.m16761i(r0, r3)     // Catch:{ all -> 0x03b1 }
            L_0x0169:
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x03b1 }
                if (r0 == 0) goto L_0x0170
                r25.stopEglSurfaceLocked()     // Catch:{ all -> 0x03b1 }
            L_0x0170:
                r0 = 1
                r1.mWaitingForSurface = r0     // Catch:{ all -> 0x03b1 }
                r0 = 0
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x03b1 }
                r0.notifyAll()     // Catch:{ all -> 0x03b1 }
            L_0x017d:
                boolean r0 = r1.mHasSurface     // Catch:{ all -> 0x03b1 }
                if (r0 == 0) goto L_0x01af
                boolean r0 = r1.mWaitingForSurface     // Catch:{ all -> 0x03b1 }
                if (r0 == 0) goto L_0x01af
                boolean r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.LOG_SURFACE     // Catch:{ all -> 0x03b1 }
                if (r0 == 0) goto L_0x01a5
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03b1 }
                r3.<init>()     // Catch:{ all -> 0x03b1 }
                java.lang.String r4 = "noticed surfaceView surface acquired tid="
                r3.append(r4)     // Catch:{ all -> 0x03b1 }
                long r4 = r25.getId()     // Catch:{ all -> 0x03b1 }
                r3.append(r4)     // Catch:{ all -> 0x03b1 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.log.HWLog.m16761i(r0, r3)     // Catch:{ all -> 0x03b1 }
            L_0x01a5:
                r0 = 0
                r1.mWaitingForSurface = r0     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x03b1 }
                r0.notifyAll()     // Catch:{ all -> 0x03b1 }
            L_0x01af:
                if (r6 == 0) goto L_0x01e0
                boolean r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.LOG_SURFACE     // Catch:{ all -> 0x03b1 }
                if (r0 == 0) goto L_0x01d2
                java.lang.String r0 = "GLThread"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03b1 }
                r3.<init>()     // Catch:{ all -> 0x03b1 }
                java.lang.String r4 = "sending render notification tid="
                r3.append(r4)     // Catch:{ all -> 0x03b1 }
                long r4 = r25.getId()     // Catch:{ all -> 0x03b1 }
                r3.append(r4)     // Catch:{ all -> 0x03b1 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.log.HWLog.m16761i(r0, r3)     // Catch:{ all -> 0x03b1 }
            L_0x01d2:
                r0 = 0
                r1.mWantRenderNotification = r0     // Catch:{ all -> 0x03b1 }
                r0 = 1
                r1.mRenderComplete = r0     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x03b1 }
                r0.notifyAll()     // Catch:{ all -> 0x03b1 }
                r6 = 0
            L_0x01e0:
                boolean r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.useAndroidOGLSurfaceView     // Catch:{ all -> 0x03b1 }
                if (r0 == 0) goto L_0x01f0
                java.lang.Runnable r0 = r1.mFinishDrawingRunnable     // Catch:{ all -> 0x03b1 }
                if (r0 == 0) goto L_0x01f0
                java.lang.Runnable r8 = r1.mFinishDrawingRunnable     // Catch:{ all -> 0x03b1 }
                r0 = 0
                r1.mFinishDrawingRunnable = r0     // Catch:{ all -> 0x03b1 }
                goto L_0x01f3
            L_0x01f0:
                r0 = 0
                r8 = r21
            L_0x01f3:
                boolean r3 = r25.readyToDraw()     // Catch:{ all -> 0x03b1 }
                if (r3 == 0) goto L_0x0396
                boolean r3 = r1.mHaveEglContext     // Catch:{ all -> 0x03b1 }
                if (r3 != 0) goto L_0x021c
                if (r7 == 0) goto L_0x0201
                r3 = 0
                goto L_0x021d
            L_0x0201:
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$EglHelper r3 = r1.mEglHelper     // Catch:{ RuntimeException -> 0x0213 }
                r3.start()     // Catch:{ RuntimeException -> 0x0213 }
                r3 = 1
                r1.mHaveEglContext = r3     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r3 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x03b1 }
                r3.notifyAll()     // Catch:{ all -> 0x03b1 }
                r3 = r7
                r10 = 1
                goto L_0x021d
            L_0x0213:
                r0 = move-exception
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r2 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x03b1 }
                r2.releaseEglContextLocked(r1)     // Catch:{ all -> 0x03b1 }
                throw r0     // Catch:{ all -> 0x03b1 }
            L_0x021c:
                r3 = r7
            L_0x021d:
                boolean r4 = r1.mHaveEglContext     // Catch:{ all -> 0x03b1 }
                if (r4 == 0) goto L_0x022b
                boolean r4 = r1.mHaveEglSurface     // Catch:{ all -> 0x03b1 }
                if (r4 != 0) goto L_0x022b
                r4 = 1
                r1.mHaveEglSurface = r4     // Catch:{ all -> 0x03b1 }
                r11 = 1
                r12 = 1
                r13 = 1
            L_0x022b:
                boolean r4 = r1.mHaveEglSurface     // Catch:{ all -> 0x03b1 }
                if (r4 == 0) goto L_0x0394
                boolean r4 = r1.mSizeChanged     // Catch:{ all -> 0x03b1 }
                if (r4 == 0) goto L_0x0263
                int r4 = r1.mWidth     // Catch:{ all -> 0x03b1 }
                int r5 = r1.mHeight     // Catch:{ all -> 0x03b1 }
                r7 = 1
                r1.mWantRenderNotification = r7     // Catch:{ all -> 0x03b1 }
                boolean r7 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.LOG_SURFACE     // Catch:{ all -> 0x03b1 }
                if (r7 == 0) goto L_0x025a
                java.lang.String r7 = "GLThread"
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x03b1 }
                r11.<init>()     // Catch:{ all -> 0x03b1 }
                java.lang.String r13 = "noticing that we want render notification tid="
                r11.append(r13)     // Catch:{ all -> 0x03b1 }
                long r13 = r25.getId()     // Catch:{ all -> 0x03b1 }
                r11.append(r13)     // Catch:{ all -> 0x03b1 }
                java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.log.HWLog.m16761i(r7, r11)     // Catch:{ all -> 0x03b1 }
            L_0x025a:
                r7 = 0
                r1.mSizeChanged = r7     // Catch:{ all -> 0x03b1 }
                r14 = r4
                r15 = r5
                r4 = 0
                r11 = 1
                r13 = 1
                goto L_0x0264
            L_0x0263:
                r4 = 0
            L_0x0264:
                r1.mRequestRender = r4     // Catch:{ all -> 0x03b1 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r5 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x03b1 }
                r5.notifyAll()     // Catch:{ all -> 0x03b1 }
                boolean r5 = r1.mWantRenderNotification     // Catch:{ all -> 0x03b1 }
                r7 = r3
                if (r5 == 0) goto L_0x0277
                r5 = r22
                r17 = 1
                goto L_0x0279
            L_0x0277:
                r5 = r22
            L_0x0279:
                monitor-exit(r18)     // Catch:{ all -> 0x03b1 }
                if (r16 == 0) goto L_0x0285
                r16.run()     // Catch:{ all -> 0x03b4 }
                r4 = r0
                r16 = r4
                r0 = 0
                goto L_0x0029
            L_0x0285:
                if (r11 == 0) goto L_0x02d2
                boolean r3 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.LOG_SURFACE     // Catch:{ all -> 0x03b4 }
                if (r3 == 0) goto L_0x029c
                java.lang.String r20 = "GLThread"
                java.lang.String r21 = "egl createSurface"
                r19 = 5
                r22 = 0
                java.lang.String r23 = "com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThread"
                r24 = 1451(0x5ab, float:2.033E-42)
                com.didi.sdk.apm.SystemUtils.log(r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x03b4 }
            L_0x029c:
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$EglHelper r3 = r1.mEglHelper     // Catch:{ all -> 0x03b4 }
                boolean r3 = r3.createSurface()     // Catch:{ all -> 0x03b4 }
                if (r3 == 0) goto L_0x02b9
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r3 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x03b4 }
                monitor-enter(r3)     // Catch:{ all -> 0x03b4 }
                r11 = 1
                r1.mFinishedCreatingEglSurface = r11     // Catch:{ all -> 0x02b6 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r11 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x02b6 }
                r11.notifyAll()     // Catch:{ all -> 0x02b6 }
                monitor-exit(r3)     // Catch:{ all -> 0x02b6 }
                r11 = 0
                goto L_0x02d2
            L_0x02b6:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x02b6 }
                throw r0     // Catch:{ all -> 0x03b4 }
            L_0x02b9:
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r3 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x03b4 }
                monitor-enter(r3)     // Catch:{ all -> 0x03b4 }
                r0 = 1
                r1.mFinishedCreatingEglSurface = r0     // Catch:{ all -> 0x02cf }
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x02cf }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x02cf }
                r0.notifyAll()     // Catch:{ all -> 0x02cf }
                monitor-exit(r3)     // Catch:{ all -> 0x02cf }
                r0 = 0
                r4 = 0
                goto L_0x0029
            L_0x02cf:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x02cf }
                throw r0     // Catch:{ all -> 0x03b4 }
            L_0x02d2:
                if (r12 == 0) goto L_0x02de
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x03b4 }
                javax.microedition.khronos.opengles.GL r0 = r0.createGL()     // Catch:{ all -> 0x03b4 }
                r9 = r0
                javax.microedition.khronos.opengles.GL10 r9 = (javax.microedition.khronos.opengles.GL10) r9     // Catch:{ all -> 0x03b4 }
                r12 = 0
            L_0x02de:
                if (r10 == 0) goto L_0x02f6
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.GLSurfaceView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x03b4 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x03b4 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView r0 = (com.didi.hawaii.mapsdkv2.view.GLSurfaceView) r0     // Catch:{ all -> 0x03b4 }
                if (r0 == 0) goto L_0x02f5
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$Renderer r0 = r0.mRenderer     // Catch:{ all -> 0x03b4 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$EglHelper r3 = r1.mEglHelper     // Catch:{ all -> 0x03b4 }
                javax.microedition.khronos.egl.EGLConfig r3 = r3.mEglConfig     // Catch:{ all -> 0x03b4 }
                r0.onSurfaceCreated(r9, r3)     // Catch:{ all -> 0x03b4 }
            L_0x02f5:
                r10 = 0
            L_0x02f6:
                if (r13 == 0) goto L_0x030a
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.GLSurfaceView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x03b4 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x03b4 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView r0 = (com.didi.hawaii.mapsdkv2.view.GLSurfaceView) r0     // Catch:{ all -> 0x03b4 }
                if (r0 == 0) goto L_0x0309
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$Renderer r0 = r0.mRenderer     // Catch:{ all -> 0x03b4 }
                r0.onSurfaceChanged(r9, r14, r15)     // Catch:{ all -> 0x03b4 }
            L_0x0309:
                r13 = 0
            L_0x030a:
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.GLSurfaceView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x03b4 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x03b4 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView r0 = (com.didi.hawaii.mapsdkv2.view.GLSurfaceView) r0     // Catch:{ all -> 0x03b4 }
                if (r0 == 0) goto L_0x0337
                if (r2 == 0) goto L_0x032b
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$Renderer r0 = r0.mRenderer     // Catch:{ all -> 0x03b4 }
                boolean r3 = r0.onDrawFrame(r9)     // Catch:{ all -> 0x03b4 }
                boolean r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.useAndroidOGLSurfaceView     // Catch:{ all -> 0x03b4 }
                if (r0 == 0) goto L_0x0338
                if (r8 == 0) goto L_0x0338
                r8.run()     // Catch:{ all -> 0x03b4 }
                r8 = 0
                goto L_0x0338
            L_0x032b:
                r0 = 1065353216(0x3f800000, float:1.0)
                r9.glClearColor(r0, r0, r0, r0)     // Catch:{ all -> 0x03b4 }
                r0 = 16384(0x4000, float:2.2959E-41)
                r9.glClear(r0)     // Catch:{ all -> 0x03b4 }
                r3 = 1
                goto L_0x0338
            L_0x0337:
                r3 = 0
            L_0x0338:
                if (r3 == 0) goto L_0x0389
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x03b4 }
                int r0 = r0.swap()     // Catch:{ all -> 0x03b4 }
                r3 = 12288(0x3000, float:1.7219E-41)
                if (r0 == r3) goto L_0x0386
                r3 = 12302(0x300e, float:1.7239E-41)
                if (r0 == r3) goto L_0x0363
                java.lang.String r3 = "GLThread"
                java.lang.String r4 = "eglSwapBuffers"
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView.EglHelper.logEglErrorAsWarning(r3, r4, r0)     // Catch:{ all -> 0x03b4 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r3 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x03b4 }
                monitor-enter(r3)     // Catch:{ all -> 0x03b4 }
                r0 = 1
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x0360 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r4 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0360 }
                r4.notifyAll()     // Catch:{ all -> 0x0360 }
                monitor-exit(r3)     // Catch:{ all -> 0x0360 }
                goto L_0x0389
            L_0x0360:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0360 }
                throw r0     // Catch:{ all -> 0x03b4 }
            L_0x0363:
                r0 = 1
                boolean r3 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.LOG_SURFACE     // Catch:{ all -> 0x03b4 }
                if (r3 == 0) goto L_0x0384
                java.lang.String r3 = "GLThread"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03b4 }
                r4.<init>()     // Catch:{ all -> 0x03b4 }
                java.lang.String r5 = "egl context lost tid="
                r4.append(r5)     // Catch:{ all -> 0x03b4 }
                long r0 = r25.getId()     // Catch:{ all -> 0x03b4 }
                r4.append(r0)     // Catch:{ all -> 0x03b4 }
                java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x03b4 }
                com.didi.hawaii.log.HWLog.m16761i(r3, r0)     // Catch:{ all -> 0x03b4 }
            L_0x0384:
                r5 = 1
                goto L_0x0389
            L_0x0386:
                if (r2 != 0) goto L_0x0389
                r2 = 1
            L_0x0389:
                if (r17 == 0) goto L_0x038e
                r6 = 1
                r17 = 0
            L_0x038e:
                r0 = 0
                r4 = 0
                r1 = r25
                goto L_0x0029
            L_0x0394:
                r7 = r3
                goto L_0x03a2
            L_0x0396:
                boolean r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.useAndroidOGLSurfaceView     // Catch:{ all -> 0x03b1 }
                if (r0 == 0) goto L_0x03a2
                if (r8 == 0) goto L_0x03a2
                r8.run()     // Catch:{ all -> 0x03b1 }
                r8 = 0
            L_0x03a2:
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x03b1 }
                r0.wait()     // Catch:{ all -> 0x03b1 }
                r5 = r22
                r0 = 0
                r4 = 0
                r1 = r25
                goto L_0x002e
            L_0x03b1:
                r0 = move-exception
                monitor-exit(r18)     // Catch:{ all -> 0x03b1 }
                throw r0     // Catch:{ all -> 0x03b4 }
            L_0x03b4:
                r0 = move-exception
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r1)
                r25.stopEglSurfaceLocked()     // Catch:{ all -> 0x03c2 }
                r25.stopEglContextLocked()     // Catch:{ all -> 0x03c2 }
                monitor-exit(r1)     // Catch:{ all -> 0x03c2 }
                throw r0
            L_0x03c2:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x03c2 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.GLSurfaceView.GLThread.guardedRun():void");
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        private boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (GLSurfaceView.sGLThreadManager) {
                this.mRenderMode = i;
                GLSurfaceView.sGLThreadManager.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (GLSurfaceView.sGLThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLSurfaceView.sGLThreadManager) {
                this.mRequestRender = true;
                GLSurfaceView.sGLThreadManager.notifyAll();
            }
        }

        public void requestRenderAndNotify(Runnable runnable) {
            if (GLSurfaceView.useAndroidOGLSurfaceView) {
                synchronized (GLSurfaceView.sGLThreadManager) {
                    if (Thread.currentThread() != this) {
                        this.mWantRenderNotification = true;
                        this.mRequestRender = true;
                        this.mRenderComplete = false;
                        this.mFinishDrawingRunnable = runnable;
                        GLSurfaceView.sGLThreadManager.notifyAll();
                    }
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:19|20|21|22|34|28|11) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0023, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void requestRenderAndWait() {
            /*
                r2 = this;
                boolean r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.useAndroidOGLSurfaceView
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0047 }
                if (r1 != r2) goto L_0x0014
                monitor-exit(r0)     // Catch:{ all -> 0x0047 }
                return
            L_0x0014:
                r1 = 1
                r2.mWantRenderNotification = r1     // Catch:{ all -> 0x0047 }
                r2.mRequestRender = r1     // Catch:{ all -> 0x0047 }
                r1 = 0
                r2.mRenderComplete = r1     // Catch:{ all -> 0x0047 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0047 }
                r1.notifyAll()     // Catch:{ all -> 0x0047 }
            L_0x0023:
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0047 }
                if (r1 != 0) goto L_0x0045
                boolean r1 = r2.mPaused     // Catch:{ all -> 0x0047 }
                if (r1 != 0) goto L_0x0045
                boolean r1 = r2.mRenderComplete     // Catch:{ all -> 0x0047 }
                if (r1 != 0) goto L_0x0045
                boolean r1 = r2.ableToDraw()     // Catch:{ all -> 0x0047 }
                if (r1 == 0) goto L_0x0045
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x003d }
                r1.wait()     // Catch:{ InterruptedException -> 0x003d }
                goto L_0x0023
            L_0x003d:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0047 }
                r1.interrupt()     // Catch:{ all -> 0x0047 }
                goto L_0x0023
            L_0x0045:
                monitor-exit(r0)     // Catch:{ all -> 0x0047 }
                return
            L_0x0047:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0047 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.GLSurfaceView.GLThread.requestRenderAndWait():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:13|14|15|16|17|29|24|7) */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0033, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x004f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void surfaceCreated() {
            /*
                r5 = this;
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                boolean r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.LOG_SURFACE     // Catch:{ all -> 0x0061 }
                if (r1 == 0) goto L_0x0026
                java.lang.String r1 = "GLThread"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r2.<init>()     // Catch:{ all -> 0x0061 }
                java.lang.String r3 = "surfaceCreated tid="
                r2.append(r3)     // Catch:{ all -> 0x0061 }
                long r3 = r5.getId()     // Catch:{ all -> 0x0061 }
                r2.append(r3)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0061 }
                com.didi.hawaii.log.HWLog.m16761i(r1, r2)     // Catch:{ all -> 0x0061 }
            L_0x0026:
                r1 = 1
                r5.mHasSurface = r1     // Catch:{ all -> 0x0061 }
                r1 = 0
                r5.mFinishedCreatingEglSurface = r1     // Catch:{ all -> 0x0061 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0061 }
                r1.notifyAll()     // Catch:{ all -> 0x0061 }
            L_0x0033:
                boolean r1 = r5.mWaitingForSurface     // Catch:{ all -> 0x0061 }
                if (r1 == 0) goto L_0x0057
                boolean r1 = r5.mFinishedCreatingEglSurface     // Catch:{ all -> 0x0061 }
                if (r1 != 0) goto L_0x0057
                boolean r1 = r5.mExited     // Catch:{ all -> 0x0061 }
                if (r1 != 0) goto L_0x0057
                java.lang.String r1 = "GLThread"
                java.lang.String r2 = "surfaceCreated try lock"
                com.didi.hawaii.log.HWLog.m16761i(r1, r2)     // Catch:{ all -> 0x0061 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x004f }
                r1.wait()     // Catch:{ InterruptedException -> 0x004f }
                goto L_0x0033
            L_0x004f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0061 }
                r1.interrupt()     // Catch:{ all -> 0x0061 }
                goto L_0x0033
            L_0x0057:
                java.lang.String r1 = "GLThread"
                java.lang.String r2 = "surfaceCreated unlock"
                com.didi.hawaii.log.HWLog.m16761i(r1, r2)     // Catch:{ all -> 0x0061 }
                monitor-exit(r0)     // Catch:{ all -> 0x0061 }
                return
            L_0x0061:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0061 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.GLSurfaceView.GLThread.surfaceCreated():void");
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
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                r1 = 0
                r2.mHasSurface = r1     // Catch:{ all -> 0x0029 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.mWaitingForSurface     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001f }
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.GLSurfaceView.GLThread.surfaceDestroyed():void");
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
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mRequestPaused = r1     // Catch:{ all -> 0x0029 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.mPaused     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001f }
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.GLSurfaceView.GLThread.onPause():void");
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
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                r1 = 0
                r3.mRequestPaused = r1     // Catch:{ all -> 0x0032 }
                r2 = 1
                r3.mRequestRender = r2     // Catch:{ all -> 0x0032 }
                r3.mRenderComplete = r1     // Catch:{ all -> 0x0032 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0032 }
                r1.notifyAll()     // Catch:{ all -> 0x0032 }
            L_0x0014:
                boolean r1 = r3.mExited     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                boolean r1 = r3.mPaused     // Catch:{ all -> 0x0032 }
                if (r1 == 0) goto L_0x0030
                boolean r1 = r3.mRenderComplete     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x0028 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.GLSurfaceView.GLThread.onResume():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(9:16|(1:18)|19|20|21|22|34|28|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0020, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onWindowResize(int r4, int r5) {
            /*
                r3 = this;
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                r3.mWidth = r4     // Catch:{ all -> 0x0065 }
                r3.mHeight = r5     // Catch:{ all -> 0x0065 }
                r4 = 1
                r3.mSizeChanged = r4     // Catch:{ all -> 0x0065 }
                r3.mRequestRender = r4     // Catch:{ all -> 0x0065 }
                r4 = 0
                r3.mRenderComplete = r4     // Catch:{ all -> 0x0065 }
                java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0065 }
                if (r4 != r3) goto L_0x0019
                monitor-exit(r0)     // Catch:{ all -> 0x0065 }
                return
            L_0x0019:
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r4 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0065 }
                r4.notifyAll()     // Catch:{ all -> 0x0065 }
            L_0x0020:
                boolean r4 = r3.mExited     // Catch:{ all -> 0x0065 }
                if (r4 != 0) goto L_0x0063
                boolean r4 = r3.mPaused     // Catch:{ all -> 0x0065 }
                if (r4 != 0) goto L_0x0063
                boolean r4 = r3.mRenderComplete     // Catch:{ all -> 0x0065 }
                if (r4 != 0) goto L_0x0063
                boolean r4 = r3.ableToDraw()     // Catch:{ all -> 0x0065 }
                if (r4 == 0) goto L_0x0063
                boolean r4 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.LOG_SURFACE     // Catch:{ all -> 0x0065 }
                if (r4 == 0) goto L_0x0053
                java.lang.String r4 = "GLThread-Main thread"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
                r5.<init>()     // Catch:{ all -> 0x0065 }
                java.lang.String r1 = "onWindowResize waiting for render complete from tid="
                r5.append(r1)     // Catch:{ all -> 0x0065 }
                long r1 = r3.getId()     // Catch:{ all -> 0x0065 }
                r5.append(r1)     // Catch:{ all -> 0x0065 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0065 }
                com.didi.hawaii.log.HWLog.m16761i(r4, r5)     // Catch:{ all -> 0x0065 }
            L_0x0053:
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r4 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x005b }
                r4.wait()     // Catch:{ InterruptedException -> 0x005b }
                goto L_0x0020
            L_0x005b:
                java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0065 }
                r4.interrupt()     // Catch:{ all -> 0x0065 }
                goto L_0x0020
            L_0x0063:
                monitor-exit(r0)     // Catch:{ all -> 0x0065 }
                return
            L_0x0065:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0065 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.GLSurfaceView.GLThread.onWindowResize(int, int):void");
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
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mShouldExit = r1     // Catch:{ all -> 0x0025 }
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ all -> 0x0025 }
                r1.notifyAll()     // Catch:{ all -> 0x0025 }
            L_0x000f:
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0025 }
                if (r1 != 0) goto L_0x0023
                com.didi.hawaii.mapsdkv2.view.GLSurfaceView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.GLSurfaceView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001b }
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.GLSurfaceView.GLThread.requestExitAndWait():void");
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            GLSurfaceView.sGLThreadManager.notifyAll();
        }

        public void queueEvent(RenderTask renderTask) {
            if (renderTask != null) {
                synchronized (GLSurfaceView.sGLThreadManager) {
                    if (this.head == null) {
                        this.head = renderTask;
                        this.tail = renderTask;
                    } else {
                        this.tail.next = renderTask;
                        this.tail = this.tail.next;
                    }
                    GLSurfaceView.sGLThreadManager.notifyAll();
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
                SystemUtils.log(2, GLSurfaceView.TAG, this.mBuilder.toString(), (Throwable) null, "com.didi.hawaii.mapsdkv2.view.GLSurfaceView$LogWriter", 1868);
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static class GLThreadManager {
        private static String TAG = "GLThreadManager";

        private GLThreadManager() {
        }

        public synchronized void threadExiting(GLThread gLThread) {
            boolean unused = gLThread.mExited = true;
            notifyAll();
        }

        public void releaseEglContextLocked(GLThread gLThread) {
            notifyAll();
        }
    }
}
