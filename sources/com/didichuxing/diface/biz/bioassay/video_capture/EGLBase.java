package com.didichuxing.diface.biz.bioassay.video_capture;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.didi.sdk.apm.SystemUtils;

public class EGLBase {

    /* renamed from: a */
    private static final boolean f47389a = false;

    /* renamed from: b */
    private static final String f47390b = "EGLBase";

    /* renamed from: c */
    private static final int f47391c = 12610;

    /* renamed from: d */
    private EGLConfig f47392d = null;

    /* renamed from: e */
    private EGLContext f47393e = EGL14.EGL_NO_CONTEXT;

    /* renamed from: f */
    private EGLDisplay f47394f = EGL14.EGL_NO_DISPLAY;

    /* renamed from: g */
    private EGLContext f47395g = EGL14.EGL_NO_CONTEXT;

    public EGLBase(EGLContext eGLContext, boolean z, boolean z2) {
        m33954a(eGLContext, z, z2);
    }

    public void release() {
        if (this.f47394f != EGL14.EGL_NO_DISPLAY) {
            m33961b();
            EGL14.eglTerminate(this.f47394f);
            EGL14.eglReleaseThread();
        }
        this.f47394f = EGL14.EGL_NO_DISPLAY;
        this.f47393e = EGL14.EGL_NO_CONTEXT;
    }

    public EglSurface createFromSurface(Object obj) {
        EglSurface eglSurface = new EglSurface(this, obj);
        eglSurface.makeCurrent();
        return eglSurface;
    }

    public EglSurface createOffscreen(int i, int i2) {
        EglSurface eglSurface = new EglSurface(this, i, i2);
        eglSurface.makeCurrent();
        return eglSurface;
    }

    public EGLContext getContext() {
        return this.f47393e;
    }

    public int querySurface(EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f47394f, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    /* renamed from: a */
    private void m33954a(EGLContext eGLContext, boolean z, boolean z2) {
        if (this.f47394f == EGL14.EGL_NO_DISPLAY) {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f47394f = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(this.f47394f, iArr, 0, iArr, 1)) {
                    if (eGLContext == null) {
                        eGLContext = EGL14.EGL_NO_CONTEXT;
                    }
                    if (this.f47393e == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig a = m33947a(z, z2);
                        this.f47392d = a;
                        if (a != null) {
                            this.f47393e = m33948a(eGLContext);
                        } else {
                            throw new RuntimeException("chooseConfig failed");
                        }
                    }
                    EGL14.eglQueryContext(this.f47394f, this.f47393e, 12440, new int[1], 0);
                    m33953a();
                    return;
                }
                this.f47394f = null;
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }
        throw new RuntimeException("EGL already set up");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m33957a(EGLSurface eGLSurface) {
        if (eGLSurface == null || eGLSurface == EGL14.EGL_NO_SURFACE) {
            if (EGL14.eglGetError() == 12299) {
                SystemUtils.log(6, f47390b, "makeCurrent:returned EGL_BAD_NATIVE_WINDOW.", (Throwable) null, "com.didichuxing.diface.biz.bioassay.video_capture.EGLBase", 154);
            }
            return false;
        } else if (EGL14.eglMakeCurrent(this.f47394f, eGLSurface, eGLSurface, this.f47393e)) {
            return true;
        } else {
            SystemUtils.log(5, f47390b, "eglMakeCurrent:" + EGL14.eglGetError(), (Throwable) null, "com.didichuxing.diface.biz.bioassay.video_capture.EGLBase", 161);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33953a() {
        if (!EGL14.eglMakeCurrent(this.f47394f, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
            SystemUtils.log(5, "TAG", "makeDefault" + EGL14.eglGetError(), (Throwable) null, "com.didichuxing.diface.biz.bioassay.video_capture.EGLBase", 175);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m33959b(EGLSurface eGLSurface) {
        if (!EGL14.eglSwapBuffers(this.f47394f, eGLSurface)) {
            return EGL14.eglGetError();
        }
        return 12288;
    }

    /* renamed from: a */
    private EGLContext m33948a(EGLContext eGLContext) {
        EGLContext eglCreateContext = EGL14.eglCreateContext(this.f47394f, this.f47392d, eGLContext, new int[]{12440, 2, 12344}, 0);
        m33956a("eglCreateContext");
        return eglCreateContext;
    }

    /* renamed from: b */
    private void m33961b() {
        if (!EGL14.eglDestroyContext(this.f47394f, this.f47393e)) {
            SystemUtils.log(6, "destroyContext", "display:" + this.f47394f + " context: " + this.f47393e, (Throwable) null, "com.didichuxing.diface.biz.bioassay.video_capture.EGLBase", 216);
            StringBuilder sb = new StringBuilder();
            sb.append("eglDestroyContex:");
            sb.append(EGL14.eglGetError());
            SystemUtils.log(6, f47390b, sb.toString(), (Throwable) null, "com.didichuxing.diface.biz.bioassay.video_capture.EGLBase", 217);
        }
        this.f47393e = EGL14.EGL_NO_CONTEXT;
        if (this.f47395g != EGL14.EGL_NO_CONTEXT) {
            if (!EGL14.eglDestroyContext(this.f47394f, this.f47395g)) {
                SystemUtils.log(6, "destroyContext", "display:" + this.f47394f + " context: " + this.f47395g, (Throwable) null, "com.didichuxing.diface.biz.bioassay.video_capture.EGLBase", 224);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("eglDestroyContex:");
                sb2.append(EGL14.eglGetError());
                SystemUtils.log(6, f47390b, sb2.toString(), (Throwable) null, "com.didichuxing.diface.biz.bioassay.video_capture.EGLBase", 225);
            }
            this.f47395g = EGL14.EGL_NO_CONTEXT;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public EGLSurface m33952a(Object obj) {
        try {
            return EGL14.eglCreateWindowSurface(this.f47394f, this.f47392d, obj, new int[]{12344}, 0);
        } catch (IllegalArgumentException e) {
            SystemUtils.log(6, f47390b, "eglCreateWindowSurface", e, "com.didichuxing.diface.biz.bioassay.video_capture.EGLBase", 248);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public EGLSurface m33949a(int i, int i2) {
        int[] iArr = {12375, i, 12374, i2, 12344};
        EGLSurface eGLSurface = null;
        try {
            eGLSurface = EGL14.eglCreatePbufferSurface(this.f47394f, this.f47392d, iArr, 0);
            m33956a("eglCreatePbufferSurface");
            if (eGLSurface != null) {
                return eGLSurface;
            }
            throw new RuntimeException("surface was null");
        } catch (IllegalArgumentException e) {
            SystemUtils.log(6, f47390b, "createOffscreenSurface", e, "com.didichuxing.diface.biz.bioassay.video_capture.EGLBase", 279);
        } catch (RuntimeException e2) {
            SystemUtils.log(6, f47390b, "createOffscreenSurface", e2, "com.didichuxing.diface.biz.bioassay.video_capture.EGLBase", 283);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m33962c(EGLSurface eGLSurface) {
        if (eGLSurface != EGL14.EGL_NO_SURFACE) {
            EGL14.eglMakeCurrent(this.f47394f, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.f47394f, eGLSurface);
        }
        EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
    }

    /* renamed from: a */
    private void m33956a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    /* renamed from: a */
    private EGLConfig m33947a(boolean z, boolean z2) {
        int[] iArr = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344, 12344, 12344, 12344, 12344, 12344, 12344};
        int i = 10;
        if (z) {
            iArr[10] = 12325;
            i = 12;
            iArr[11] = 16;
        }
        if (z2 && Build.VERSION.SDK_INT >= 18) {
            int i2 = i + 1;
            iArr[i] = 12610;
            i = i2 + 1;
            iArr[i2] = 1;
        }
        for (int i3 = 16; i3 >= i; i3--) {
            iArr[i3] = 12344;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f47394f, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        SystemUtils.log(5, f47390b, "unable to find RGBA8888 /  EGLConfig", (Throwable) null, "com.didichuxing.diface.biz.bioassay.video_capture.EGLBase", 357);
        return null;
    }

    public static class EglSurface {
        private final EGLBase mEgl;
        private EGLSurface mEglSurface = EGL14.EGL_NO_SURFACE;
        private final int mHeight;
        private final int mWidth;

        EglSurface(EGLBase eGLBase, Object obj) {
            if ((obj instanceof SurfaceView) || (obj instanceof Surface) || (obj instanceof SurfaceHolder) || (obj instanceof SurfaceTexture)) {
                this.mEgl = eGLBase;
                EGLSurface a = eGLBase.m33952a(obj);
                this.mEglSurface = a;
                this.mWidth = this.mEgl.querySurface(a, 12375);
                this.mHeight = this.mEgl.querySurface(this.mEglSurface, 12374);
                return;
            }
            throw new IllegalArgumentException("unsupported surface");
        }

        EglSurface(EGLBase eGLBase, int i, int i2) {
            this.mEgl = eGLBase;
            this.mEglSurface = eGLBase.m33949a(i, i2);
            this.mWidth = i;
            this.mHeight = i2;
        }

        public void makeCurrent() {
            boolean unused = this.mEgl.m33957a(this.mEglSurface);
        }

        public void swap() {
            int unused = this.mEgl.m33959b(this.mEglSurface);
        }

        public EGLContext getContext() {
            return this.mEgl.getContext();
        }

        public void release() {
            this.mEgl.m33953a();
            this.mEgl.m33962c(this.mEglSurface);
            this.mEglSurface = EGL14.EGL_NO_SURFACE;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }
    }
}
