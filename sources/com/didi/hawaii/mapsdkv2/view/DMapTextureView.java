package com.didi.hawaii.mapsdkv2.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
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

public class DMapTextureView extends TextureView implements TextureView.SurfaceTextureListener {
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
    public static final GLThreadManager sGLThreadManager = new GLThreadManager();
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
    private final WeakReference<DMapTextureView> mThisWeakRef = new WeakReference<>(this);

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

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public DMapTextureView(Context context) {
        super(context);
        init();
    }

    public DMapTextureView(Context context, AttributeSet attributeSet) {
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
        setSurfaceTextureListener(this);
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
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.mDetached = true;
        try {
            super.onDetachedFromWindow();
        } catch (Exception unused) {
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mGLThread.surfaceCreated();
        onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mGLThread.onWindowResize(i, i2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mGLThread.surfaceDestroyed();
        return true;
    }

    private class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, DMapTextureView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (DMapTextureView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                SystemUtils.log(6, "DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext, (Throwable) null, "com.didi.hawaii.mapsdkv2.view.DMapTextureView$DefaultContextFactory", 685);
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
                SystemUtils.log(6, DMapTextureView.TAG, "eglCreateWindowSurface", e, "com.didi.hawaii.mapsdkv2.view.DMapTextureView$DefaultWindowSurfaceFactory", 723);
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
            if (DMapTextureView.this.mEGLContextClientVersion != 2 && DMapTextureView.this.mEGLContextClientVersion != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (DMapTextureView.this.mEGLContextClientVersion == 2) {
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
        private WeakReference<DMapTextureView> mGLSurfaceViewWeakRef;

        public EglHelper(WeakReference<DMapTextureView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public void start() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.mEgl = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                    DMapTextureView dMapTextureView = (DMapTextureView) this.mGLSurfaceViewWeakRef.get();
                    if (dMapTextureView == null) {
                        this.mEglConfig = null;
                        this.mEglContext = null;
                    } else {
                        this.mEglConfig = dMapTextureView.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                        this.mEglContext = dMapTextureView.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
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
                DMapTextureView dMapTextureView = (DMapTextureView) this.mGLSurfaceViewWeakRef.get();
                if (dMapTextureView != null) {
                    this.mEglSurface = dMapTextureView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, dMapTextureView.getSurfaceTexture());
                } else {
                    this.mEglSurface = null;
                }
                EGLSurface eGLSurface = this.mEglSurface;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.mEgl.eglGetError() == 12299) {
                        SystemUtils.log(6, "EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.", (Throwable) null, "com.didi.hawaii.mapsdkv2.view.DMapTextureView$EglHelper", 993);
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
            DMapTextureView dMapTextureView = (DMapTextureView) this.mGLSurfaceViewWeakRef.get();
            if (dMapTextureView == null) {
                return gl;
            }
            if (dMapTextureView.mGLWrapper != null) {
                gl = dMapTextureView.mGLWrapper.wrap(gl);
            }
            if ((dMapTextureView.mDebugFlags & 3) == 0) {
                return gl;
            }
            int i = 0;
            LogWriter logWriter = null;
            if ((dMapTextureView.mDebugFlags & 1) != 0) {
                i = 1;
            }
            if ((dMapTextureView.mDebugFlags & 2) != 0) {
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
                DMapTextureView dMapTextureView = (DMapTextureView) this.mGLSurfaceViewWeakRef.get();
                if (dMapTextureView != null) {
                    dMapTextureView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                DMapTextureView dMapTextureView = (DMapTextureView) this.mGLSurfaceViewWeakRef.get();
                if (dMapTextureView != null) {
                    dMapTextureView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
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
            SystemUtils.log(5, str, formatEglError(str2, i), (Throwable) null, "com.didi.hawaii.mapsdkv2.view.DMapTextureView$EglHelper", 1116);
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
        private boolean mFinishedCreatingEglSurface;
        private WeakReference<DMapTextureView> mGLSurfaceViewWeakRef;
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

        GLThread(WeakReference<DMapTextureView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public void run() {
            setName("GLThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                DMapTextureView.sGLThreadManager.threadExiting(this);
                throw th;
            }
            DMapTextureView.sGLThreadManager.threadExiting(this);
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
                DMapTextureView.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        /* JADX WARNING: type inference failed for: r0v31, types: [javax.microedition.khronos.opengles.GL] */
        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0152, code lost:
            r2 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0156, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
            r1.mFinishedCreatingEglSurface = true;
            com.didi.hawaii.mapsdkv2.view.DMapTextureView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x0161, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0162, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0167, code lost:
            r2 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x016b, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
            r1.mFinishedCreatingEglSurface = true;
            r1.mSurfaceIsBad = true;
            com.didi.hawaii.mapsdkv2.view.DMapTextureView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0178, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x017e, code lost:
            if (r10 == false) goto L_0x018a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x0180, code lost:
            r7 = r1.mEglHelper.createGL();
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x018a, code lost:
            if (r8 == false) goto L_0x01a2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x018c, code lost:
            r0 = (com.didi.hawaii.mapsdkv2.view.DMapTextureView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x0194, code lost:
            if (r0 == null) goto L_0x01a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x0196, code lost:
            com.didi.hawaii.mapsdkv2.view.DMapTextureView.access$1000(r0).onSurfaceCreated(r7, r1.mEglHelper.mEglConfig);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x01a1, code lost:
            r8 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x01a2, code lost:
            if (r11 == false) goto L_0x01b6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x01a4, code lost:
            r0 = (com.didi.hawaii.mapsdkv2.view.DMapTextureView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x01ac, code lost:
            if (r0 == null) goto L_0x01b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x01ae, code lost:
            com.didi.hawaii.mapsdkv2.view.DMapTextureView.access$1000(r0).onSurfaceChanged(r7, r12, r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x01b5, code lost:
            r11 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x01b6, code lost:
            r0 = (com.didi.hawaii.mapsdkv2.view.DMapTextureView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x01be, code lost:
            if (r0 == null) goto L_0x01d7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x01c0, code lost:
            if (r4 == false) goto L_0x01cb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x01c2, code lost:
            r2 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.access$1000(r0).onDrawFrame(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x01cb, code lost:
            r7.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            r7.glClear(16384);
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x01d7, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x01d8, code lost:
            if (r2 == false) goto L_0x020d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x01da, code lost:
            r0 = r1.mEglHelper.swap();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x01e2, code lost:
            if (r0 == 12288) goto L_0x0208;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x01e6, code lost:
            if (r0 == 12302) goto L_0x0205;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x01e8, code lost:
            r17 = r3;
            com.didi.hawaii.mapsdkv2.view.DMapTextureView.EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r0);
            r2 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x01f5, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
            r1.mSurfaceIsBad = true;
            com.didi.hawaii.mapsdkv2.view.DMapTextureView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x0200, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x0205, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x0208, code lost:
            r17 = r3;
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x020d, code lost:
            r17 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0210, code lost:
            r3 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x0212, code lost:
            if (r15 == false) goto L_0x0216;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x0214, code lost:
            r5 = true;
            r15 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x0140, code lost:
            if (r14 == null) goto L_0x0148;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
            r14.run();
            r14 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0148, code lost:
            if (r9 == false) goto L_0x017e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x0150, code lost:
            if (r1.mEglHelper.createSurface() == false) goto L_0x0167;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
                r18 = this;
                r1 = r18
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$EglHelper r0 = new com.didi.hawaii.mapsdkv2.view.DMapTextureView$EglHelper
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.DMapTextureView> r2 = r1.mGLSurfaceViewWeakRef
                r0.<init>(r2)
                r1.mEglHelper = r0
                r0 = 0
                r1.mHaveEglContext = r0
                r1.mHaveEglSurface = r0
                r1.mWantRenderNotification = r0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
            L_0x001f:
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r16 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0226 }
                monitor-enter(r16)     // Catch:{ all -> 0x0226 }
            L_0x0024:
                boolean r0 = r1.mShouldExit     // Catch:{ all -> 0x0223 }
                if (r0 == 0) goto L_0x0039
                monitor-exit(r16)     // Catch:{ all -> 0x0223 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r2 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager
                monitor-enter(r2)
                r18.stopEglSurfaceLocked()     // Catch:{ all -> 0x0036 }
                r18.stopEglContextLocked()     // Catch:{ all -> 0x0036 }
                monitor-exit(r2)     // Catch:{ all -> 0x0036 }
                return
            L_0x0036:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0036 }
                throw r0
            L_0x0039:
                com.didi.hawaii.mapsdkv2.view.RenderTask r0 = r1.head     // Catch:{ all -> 0x0223 }
                if (r0 == 0) goto L_0x0051
                if (r4 == 0) goto L_0x0051
                com.didi.hawaii.mapsdkv2.view.RenderTask r14 = r1.head     // Catch:{ all -> 0x0223 }
                com.didi.hawaii.mapsdkv2.view.RenderTask r0 = r1.head     // Catch:{ all -> 0x0223 }
                com.didi.hawaii.mapsdkv2.view.RenderTask r0 = r0.next     // Catch:{ all -> 0x0223 }
                r1.head = r0     // Catch:{ all -> 0x0223 }
                if (r0 != 0) goto L_0x004d
                r0 = 0
                r1.tail = r0     // Catch:{ all -> 0x0223 }
                goto L_0x004e
            L_0x004d:
                r0 = 0
            L_0x004e:
                r0 = 0
                goto L_0x013f
            L_0x0051:
                boolean r0 = r1.mPaused     // Catch:{ all -> 0x0223 }
                boolean r2 = r1.mRequestPaused     // Catch:{ all -> 0x0223 }
                if (r0 == r2) goto L_0x0065
                boolean r0 = r1.mRequestPaused     // Catch:{ all -> 0x0223 }
                boolean r2 = r1.mRequestPaused     // Catch:{ all -> 0x0223 }
                r1.mPaused = r2     // Catch:{ all -> 0x0223 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r2 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0223 }
                r2.notifyAll()     // Catch:{ all -> 0x0223 }
                goto L_0x0066
            L_0x0065:
                r0 = 0
            L_0x0066:
                boolean r2 = r1.mShouldReleaseEglContext     // Catch:{ all -> 0x0223 }
                if (r2 == 0) goto L_0x0074
                r18.stopEglSurfaceLocked()     // Catch:{ all -> 0x0223 }
                r18.stopEglContextLocked()     // Catch:{ all -> 0x0223 }
                r2 = 0
                r1.mShouldReleaseEglContext = r2     // Catch:{ all -> 0x0223 }
                r6 = 1
            L_0x0074:
                if (r3 == 0) goto L_0x007d
                r18.stopEglSurfaceLocked()     // Catch:{ all -> 0x0223 }
                r18.stopEglContextLocked()     // Catch:{ all -> 0x0223 }
                r3 = 0
            L_0x007d:
                if (r0 == 0) goto L_0x0086
                boolean r2 = r1.mHaveEglSurface     // Catch:{ all -> 0x0223 }
                if (r2 == 0) goto L_0x0086
                r18.stopEglSurfaceLocked()     // Catch:{ all -> 0x0223 }
            L_0x0086:
                if (r0 == 0) goto L_0x00a1
                boolean r0 = r1.mHaveEglContext     // Catch:{ all -> 0x0223 }
                if (r0 == 0) goto L_0x00a1
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.DMapTextureView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x0223 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0223 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView r0 = (com.didi.hawaii.mapsdkv2.view.DMapTextureView) r0     // Catch:{ all -> 0x0223 }
                if (r0 != 0) goto L_0x0098
                r0 = 0
                goto L_0x009c
            L_0x0098:
                boolean r0 = r0.mPreserveEGLContextOnPause     // Catch:{ all -> 0x0223 }
            L_0x009c:
                if (r0 != 0) goto L_0x00a1
                r18.stopEglContextLocked()     // Catch:{ all -> 0x0223 }
            L_0x00a1:
                boolean r0 = r1.mHasSurface     // Catch:{ all -> 0x0223 }
                if (r0 != 0) goto L_0x00bd
                boolean r0 = r1.mWaitingForSurface     // Catch:{ all -> 0x0223 }
                if (r0 != 0) goto L_0x00bd
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x0223 }
                if (r0 == 0) goto L_0x00b0
                r18.stopEglSurfaceLocked()     // Catch:{ all -> 0x0223 }
            L_0x00b0:
                r0 = 1
                r1.mWaitingForSurface = r0     // Catch:{ all -> 0x0223 }
                r0 = 0
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x0223 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0223 }
                r0.notifyAll()     // Catch:{ all -> 0x0223 }
            L_0x00bd:
                boolean r0 = r1.mHasSurface     // Catch:{ all -> 0x0223 }
                if (r0 == 0) goto L_0x00cf
                boolean r0 = r1.mWaitingForSurface     // Catch:{ all -> 0x0223 }
                if (r0 == 0) goto L_0x00cf
                r0 = 0
                r1.mWaitingForSurface = r0     // Catch:{ all -> 0x0223 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0223 }
                r0.notifyAll()     // Catch:{ all -> 0x0223 }
            L_0x00cf:
                if (r5 == 0) goto L_0x00df
                r0 = 0
                r1.mWantRenderNotification = r0     // Catch:{ all -> 0x0223 }
                r0 = 1
                r1.mRenderComplete = r0     // Catch:{ all -> 0x0223 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0223 }
                r0.notifyAll()     // Catch:{ all -> 0x0223 }
                r5 = 0
            L_0x00df:
                boolean r0 = r18.readyToDraw()     // Catch:{ all -> 0x0223 }
                if (r0 == 0) goto L_0x021a
                boolean r0 = r1.mHaveEglContext     // Catch:{ all -> 0x0223 }
                if (r0 != 0) goto L_0x0108
                if (r6 == 0) goto L_0x00ed
                r2 = 0
                goto L_0x0109
            L_0x00ed:
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$EglHelper r0 = r1.mEglHelper     // Catch:{ RuntimeException -> 0x00ff }
                r0.start()     // Catch:{ RuntimeException -> 0x00ff }
                r0 = 1
                r1.mHaveEglContext = r0     // Catch:{ all -> 0x0223 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0223 }
                r0.notifyAll()     // Catch:{ all -> 0x0223 }
                r2 = r6
                r8 = 1
                goto L_0x0109
            L_0x00ff:
                r0 = move-exception
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r2 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0223 }
                r2.releaseEglContextLocked(r1)     // Catch:{ all -> 0x0223 }
                throw r0     // Catch:{ all -> 0x0223 }
            L_0x0108:
                r2 = r6
            L_0x0109:
                boolean r0 = r1.mHaveEglContext     // Catch:{ all -> 0x0223 }
                if (r0 == 0) goto L_0x0117
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x0223 }
                if (r0 != 0) goto L_0x0117
                r0 = 1
                r1.mHaveEglSurface = r0     // Catch:{ all -> 0x0223 }
                r9 = 1
                r10 = 1
                r11 = 1
            L_0x0117:
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x0223 }
                if (r0 == 0) goto L_0x0219
                boolean r0 = r1.mSizeChanged     // Catch:{ all -> 0x0223 }
                if (r0 == 0) goto L_0x012d
                int r12 = r1.mWidth     // Catch:{ all -> 0x0223 }
                int r13 = r1.mHeight     // Catch:{ all -> 0x0223 }
                r0 = 1
                r1.mWantRenderNotification = r0     // Catch:{ all -> 0x0223 }
                r0 = 0
                r1.mSizeChanged = r0     // Catch:{ all -> 0x0223 }
                r0 = 0
                r9 = 1
                r11 = 1
                goto L_0x012e
            L_0x012d:
                r0 = 0
            L_0x012e:
                r1.mRequestRender = r0     // Catch:{ all -> 0x0223 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r6 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0223 }
                r6.notifyAll()     // Catch:{ all -> 0x0223 }
                boolean r6 = r1.mWantRenderNotification     // Catch:{ all -> 0x0223 }
                if (r6 == 0) goto L_0x013e
                r6 = r2
                r15 = 1
                goto L_0x013f
            L_0x013e:
                r6 = r2
            L_0x013f:
                monitor-exit(r16)     // Catch:{ all -> 0x0223 }
                if (r14 == 0) goto L_0x0148
                r14.run()     // Catch:{ all -> 0x0226 }
                r14 = 0
                goto L_0x001f
            L_0x0148:
                if (r9 == 0) goto L_0x017e
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$EglHelper r2 = r1.mEglHelper     // Catch:{ all -> 0x0226 }
                boolean r2 = r2.createSurface()     // Catch:{ all -> 0x0226 }
                if (r2 == 0) goto L_0x0167
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r2 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0226 }
                monitor-enter(r2)     // Catch:{ all -> 0x0226 }
                r9 = 1
                r1.mFinishedCreatingEglSurface = r9     // Catch:{ all -> 0x0164 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r9 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0164 }
                r9.notifyAll()     // Catch:{ all -> 0x0164 }
                monitor-exit(r2)     // Catch:{ all -> 0x0164 }
                r9 = 0
                goto L_0x017e
            L_0x0164:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0164 }
                throw r0     // Catch:{ all -> 0x0226 }
            L_0x0167:
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r2 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0226 }
                monitor-enter(r2)     // Catch:{ all -> 0x0226 }
                r0 = 1
                r1.mFinishedCreatingEglSurface = r0     // Catch:{ all -> 0x017b }
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x017b }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x017b }
                r0.notifyAll()     // Catch:{ all -> 0x017b }
                monitor-exit(r2)     // Catch:{ all -> 0x017b }
                goto L_0x0216
            L_0x017b:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x017b }
                throw r0     // Catch:{ all -> 0x0226 }
            L_0x017e:
                if (r10 == 0) goto L_0x018a
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x0226 }
                javax.microedition.khronos.opengles.GL r0 = r0.createGL()     // Catch:{ all -> 0x0226 }
                r7 = r0
                javax.microedition.khronos.opengles.GL10 r7 = (javax.microedition.khronos.opengles.GL10) r7     // Catch:{ all -> 0x0226 }
                r10 = 0
            L_0x018a:
                if (r8 == 0) goto L_0x01a2
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.DMapTextureView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x0226 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0226 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView r0 = (com.didi.hawaii.mapsdkv2.view.DMapTextureView) r0     // Catch:{ all -> 0x0226 }
                if (r0 == 0) goto L_0x01a1
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$Renderer r0 = r0.mRenderer     // Catch:{ all -> 0x0226 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$EglHelper r2 = r1.mEglHelper     // Catch:{ all -> 0x0226 }
                javax.microedition.khronos.egl.EGLConfig r2 = r2.mEglConfig     // Catch:{ all -> 0x0226 }
                r0.onSurfaceCreated(r7, r2)     // Catch:{ all -> 0x0226 }
            L_0x01a1:
                r8 = 0
            L_0x01a2:
                if (r11 == 0) goto L_0x01b6
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.DMapTextureView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x0226 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0226 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView r0 = (com.didi.hawaii.mapsdkv2.view.DMapTextureView) r0     // Catch:{ all -> 0x0226 }
                if (r0 == 0) goto L_0x01b5
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$Renderer r0 = r0.mRenderer     // Catch:{ all -> 0x0226 }
                r0.onSurfaceChanged(r7, r12, r13)     // Catch:{ all -> 0x0226 }
            L_0x01b5:
                r11 = 0
            L_0x01b6:
                java.lang.ref.WeakReference<com.didi.hawaii.mapsdkv2.view.DMapTextureView> r0 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x0226 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0226 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView r0 = (com.didi.hawaii.mapsdkv2.view.DMapTextureView) r0     // Catch:{ all -> 0x0226 }
                if (r0 == 0) goto L_0x01d7
                if (r4 == 0) goto L_0x01cb
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$Renderer r0 = r0.mRenderer     // Catch:{ all -> 0x0226 }
                boolean r2 = r0.onDrawFrame(r7)     // Catch:{ all -> 0x0226 }
                goto L_0x01d8
            L_0x01cb:
                r0 = 1065353216(0x3f800000, float:1.0)
                r7.glClearColor(r0, r0, r0, r0)     // Catch:{ all -> 0x0226 }
                r0 = 16384(0x4000, float:2.2959E-41)
                r7.glClear(r0)     // Catch:{ all -> 0x0226 }
                r2 = 1
                goto L_0x01d8
            L_0x01d7:
                r2 = 0
            L_0x01d8:
                if (r2 == 0) goto L_0x020d
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x0226 }
                int r0 = r0.swap()     // Catch:{ all -> 0x0226 }
                r2 = 12288(0x3000, float:1.7219E-41)
                if (r0 == r2) goto L_0x0208
                r2 = 12302(0x300e, float:1.7239E-41)
                if (r0 == r2) goto L_0x0205
                java.lang.String r2 = "GLThread"
                r17 = r3
                java.lang.String r3 = "eglSwapBuffers"
                com.didi.hawaii.mapsdkv2.view.DMapTextureView.EglHelper.logEglErrorAsWarning(r2, r3, r0)     // Catch:{ all -> 0x0226 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r2 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0226 }
                monitor-enter(r2)     // Catch:{ all -> 0x0226 }
                r0 = 1
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x0202 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r3 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0202 }
                r3.notifyAll()     // Catch:{ all -> 0x0202 }
                monitor-exit(r2)     // Catch:{ all -> 0x0202 }
                goto L_0x0210
            L_0x0202:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0202 }
                throw r0     // Catch:{ all -> 0x0226 }
            L_0x0205:
                r0 = 1
                r3 = 1
                goto L_0x0212
            L_0x0208:
                r17 = r3
                r0 = 1
                r4 = 1
                goto L_0x0212
            L_0x020d:
                r17 = r3
                r0 = 1
            L_0x0210:
                r3 = r17
            L_0x0212:
                if (r15 == 0) goto L_0x0216
                r5 = 1
                r15 = 0
            L_0x0216:
                r0 = 0
                goto L_0x001f
            L_0x0219:
                r6 = r2
            L_0x021a:
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0223 }
                r0.wait()     // Catch:{ all -> 0x0223 }
                goto L_0x0024
            L_0x0223:
                r0 = move-exception
                monitor-exit(r16)     // Catch:{ all -> 0x0223 }
                throw r0     // Catch:{ all -> 0x0226 }
            L_0x0226:
                r0 = move-exception
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r2 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager
                monitor-enter(r2)
                r18.stopEglSurfaceLocked()     // Catch:{ all -> 0x0234 }
                r18.stopEglContextLocked()     // Catch:{ all -> 0x0234 }
                monitor-exit(r2)     // Catch:{ all -> 0x0234 }
                throw r0
            L_0x0234:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0234 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.DMapTextureView.GLThread.guardedRun():void");
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
            synchronized (DMapTextureView.sGLThreadManager) {
                this.mRenderMode = i;
                DMapTextureView.sGLThreadManager.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (DMapTextureView.sGLThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (DMapTextureView.sGLThreadManager) {
                this.mRequestRender = true;
                DMapTextureView.sGLThreadManager.notifyAll();
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
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager
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
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0040 }
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
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x0036 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.DMapTextureView.GLThread.requestRenderAndWait():void");
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
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mHasSurface = r1     // Catch:{ all -> 0x0030 }
                r1 = 0
                r2.mFinishedCreatingEglSurface = r1     // Catch:{ all -> 0x0030 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0030 }
                r1.notifyAll()     // Catch:{ all -> 0x0030 }
            L_0x0012:
                boolean r1 = r2.mWaitingForSurface     // Catch:{ all -> 0x0030 }
                if (r1 == 0) goto L_0x002e
                boolean r1 = r2.mFinishedCreatingEglSurface     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x0026 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.DMapTextureView.GLThread.surfaceCreated():void");
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
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager
                monitor-enter(r0)
                r1 = 0
                r2.mHasSurface = r1     // Catch:{ all -> 0x0029 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.mWaitingForSurface     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001f }
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.DMapTextureView.GLThread.surfaceDestroyed():void");
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
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mRequestPaused = r1     // Catch:{ all -> 0x0029 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.mPaused     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001f }
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.DMapTextureView.GLThread.onPause():void");
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
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager
                monitor-enter(r0)
                r1 = 0
                r3.mRequestPaused = r1     // Catch:{ all -> 0x0032 }
                r2 = 1
                r3.mRequestRender = r2     // Catch:{ all -> 0x0032 }
                r3.mRenderComplete = r1     // Catch:{ all -> 0x0032 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0032 }
                r1.notifyAll()     // Catch:{ all -> 0x0032 }
            L_0x0014:
                boolean r1 = r3.mExited     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                boolean r1 = r3.mPaused     // Catch:{ all -> 0x0032 }
                if (r1 == 0) goto L_0x0030
                boolean r1 = r3.mRenderComplete     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x0028 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.DMapTextureView.GLThread.onResume():void");
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
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager
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
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r2 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0044 }
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
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r2 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x003a }
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.DMapTextureView.GLThread.onWindowResize(int, int):void");
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
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r0 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mShouldExit = r1     // Catch:{ all -> 0x0025 }
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ all -> 0x0025 }
                r1.notifyAll()     // Catch:{ all -> 0x0025 }
            L_0x000f:
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0025 }
                if (r1 != 0) goto L_0x0023
                com.didi.hawaii.mapsdkv2.view.DMapTextureView$GLThreadManager r1 = com.didi.hawaii.mapsdkv2.view.DMapTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001b }
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.mapsdkv2.view.DMapTextureView.GLThread.requestExitAndWait():void");
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            DMapTextureView.sGLThreadManager.notifyAll();
        }

        public void queueEvent(RenderTask renderTask) {
            if (renderTask != null) {
                synchronized (DMapTextureView.sGLThreadManager) {
                    if (this.head == null) {
                        this.head = renderTask;
                        this.tail = renderTask;
                    } else {
                        this.tail.next = renderTask;
                        this.tail = this.tail.next;
                    }
                    DMapTextureView.sGLThreadManager.notifyAll();
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
                SystemUtils.log(2, DMapTextureView.TAG, this.mBuilder.toString(), (Throwable) null, "com.didi.hawaii.mapsdkv2.view.DMapTextureView$LogWriter", 1772);
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
