package com.didichuxing.diface.biz.bioassay.video_capture;

import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.view.Surface;
import com.didichuxing.diface.biz.bioassay.video_capture.EGLBase;

public final class RenderHandler implements Runnable {

    /* renamed from: a */
    private static final boolean f47441a = false;

    /* renamed from: b */
    private static final String f47442b = "RenderHandler";

    /* renamed from: c */
    private final Object f47443c = new Object();

    /* renamed from: d */
    private EGLContext f47444d;

    /* renamed from: e */
    private boolean f47445e;

    /* renamed from: f */
    private Object f47446f;

    /* renamed from: g */
    private int f47447g = -1;

    /* renamed from: h */
    private float[] f47448h = new float[32];

    /* renamed from: i */
    private boolean f47449i;

    /* renamed from: j */
    private boolean f47450j;

    /* renamed from: k */
    private int f47451k;

    /* renamed from: l */
    private EGLBase f47452l;

    /* renamed from: m */
    private EGLBase.EglSurface f47453m;

    /* renamed from: n */
    private GLDrawer2D f47454n;

    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|(1:5)(1:6)|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.didichuxing.diface.biz.bioassay.video_capture.RenderHandler createHandler(java.lang.String r4) {
        /*
            com.didichuxing.diface.biz.bioassay.video_capture.RenderHandler r0 = new com.didichuxing.diface.biz.bioassay.video_capture.RenderHandler
            r0.<init>()
            java.lang.Object r1 = r0.f47443c
            monitor-enter(r1)
            java.lang.Thread r2 = new java.lang.Thread     // Catch:{ all -> 0x0020 }
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0020 }
            if (r3 != 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            java.lang.String r4 = "RenderHandler"
        L_0x0013:
            r2.<init>(r0, r4)     // Catch:{ all -> 0x0020 }
            r2.start()     // Catch:{ all -> 0x0020 }
            java.lang.Object r4 = r0.f47443c     // Catch:{ InterruptedException -> 0x001e }
            r4.wait()     // Catch:{ InterruptedException -> 0x001e }
        L_0x001e:
            monitor-exit(r1)     // Catch:{ all -> 0x0020 }
            return r0
        L_0x0020:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0020 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.biz.bioassay.video_capture.RenderHandler.createHandler(java.lang.String):com.didichuxing.diface.biz.bioassay.video_capture.RenderHandler");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|17|18|19|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setEglContext(android.opengl.EGLContext r3, int r4, java.lang.Object r5, boolean r6) {
        /*
            r2 = this;
            boolean r0 = r5 instanceof android.view.Surface
            if (r0 != 0) goto L_0x0024
            boolean r0 = r5 instanceof android.graphics.SurfaceTexture
            if (r0 != 0) goto L_0x0024
            boolean r0 = r5 instanceof android.view.SurfaceHolder
            if (r0 == 0) goto L_0x000d
            goto L_0x0024
        L_0x000d:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "unsupported window type:"
            r4.append(r6)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L_0x0024:
            java.lang.Object r0 = r2.f47443c
            monitor-enter(r0)
            boolean r1 = r2.f47450j     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x002d
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x002d:
            r2.f47444d = r3     // Catch:{ all -> 0x0051 }
            r2.f47447g = r4     // Catch:{ all -> 0x0051 }
            r2.f47446f = r5     // Catch:{ all -> 0x0051 }
            r2.f47445e = r6     // Catch:{ all -> 0x0051 }
            r3 = 1
            r2.f47449i = r3     // Catch:{ all -> 0x0051 }
            float[] r3 = r2.f47448h     // Catch:{ all -> 0x0051 }
            r4 = 0
            android.opengl.Matrix.setIdentityM(r3, r4)     // Catch:{ all -> 0x0051 }
            float[] r3 = r2.f47448h     // Catch:{ all -> 0x0051 }
            r4 = 16
            android.opengl.Matrix.setIdentityM(r3, r4)     // Catch:{ all -> 0x0051 }
            java.lang.Object r3 = r2.f47443c     // Catch:{ all -> 0x0051 }
            r3.notifyAll()     // Catch:{ all -> 0x0051 }
            java.lang.Object r3 = r2.f47443c     // Catch:{ InterruptedException -> 0x004f }
            r3.wait()     // Catch:{ InterruptedException -> 0x004f }
        L_0x004f:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x0051:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.biz.bioassay.video_capture.RenderHandler.setEglContext(android.opengl.EGLContext, int, java.lang.Object, boolean):void");
    }

    public final void draw() {
        draw(this.f47447g, this.f47448h, (float[]) null);
    }

    public final void draw(int i) {
        draw(i, this.f47448h, (float[]) null);
    }

    public final void draw(float[] fArr) {
        draw(this.f47447g, fArr, (float[]) null);
    }

    public final void draw(float[] fArr, float[] fArr2) {
        draw(this.f47447g, fArr, fArr2);
    }

    public final void draw(int i, float[] fArr) {
        draw(i, fArr, (float[]) null);
    }

    public final void draw(int i, float[] fArr, float[] fArr2) {
        synchronized (this.f47443c) {
            if (!this.f47450j) {
                this.f47447g = i;
                if (fArr == null || fArr.length < 16) {
                    Matrix.setIdentityM(this.f47448h, 0);
                } else {
                    System.arraycopy(fArr, 0, this.f47448h, 0, 16);
                }
                if (fArr2 == null || fArr2.length < 16) {
                    Matrix.setIdentityM(this.f47448h, 16);
                } else {
                    System.arraycopy(fArr2, 0, this.f47448h, 16, 16);
                }
                this.f47451k++;
                this.f47443c.notifyAll();
            }
        }
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.f47443c) {
            if (this.f47446f instanceof Surface) {
                if (!((Surface) this.f47446f).isValid()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f47443c
            monitor-enter(r0)
            boolean r1 = r2.f47450j     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0009:
            r1 = 1
            r2.f47450j = r1     // Catch:{ all -> 0x0018 }
            java.lang.Object r1 = r2.f47443c     // Catch:{ all -> 0x0018 }
            r1.notifyAll()     // Catch:{ all -> 0x0018 }
            java.lang.Object r1 = r2.f47443c     // Catch:{ InterruptedException -> 0x0016 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0016 }
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.biz.bioassay.video_capture.RenderHandler.release():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
        if (r0 == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0036, code lost:
        if (r5.f47452l == null) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003a, code lost:
        if (r5.f47447g < 0) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003c, code lost:
        r5.f47453m.makeCurrent();
        android.opengl.GLES20.glClearColor(1.0f, 1.0f, 0.0f, 1.0f);
        android.opengl.GLES20.glClear(16384);
        r5.f47454n.setMatrix(r5.f47448h, 16);
        r5.f47454n.draw(r5.f47447g, r5.f47448h);
        r5.f47453m.swap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        r0 = r5.f47443c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0066, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r5.f47443c.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0084, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f47443c
            monitor-enter(r0)
            r1 = 0
            r5.f47450j = r1     // Catch:{ all -> 0x0088 }
            r5.f47449i = r1     // Catch:{ all -> 0x0088 }
            r5.f47451k = r1     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r5.f47443c     // Catch:{ all -> 0x0088 }
            r2.notifyAll()     // Catch:{ all -> 0x0088 }
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
        L_0x0010:
            java.lang.Object r2 = r5.f47443c
            monitor-enter(r2)
            boolean r0 = r5.f47450j     // Catch:{ all -> 0x0085 }
            r3 = 1
            if (r0 == 0) goto L_0x001a
            monitor-exit(r2)     // Catch:{ all -> 0x0085 }
            goto L_0x0071
        L_0x001a:
            boolean r0 = r5.f47449i     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x0023
            r5.f47449i = r1     // Catch:{ all -> 0x0085 }
            r5.m33974a()     // Catch:{ all -> 0x0085 }
        L_0x0023:
            int r0 = r5.f47451k     // Catch:{ all -> 0x0085 }
            if (r0 <= 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x0029:
            r0 = 0
        L_0x002a:
            if (r0 == 0) goto L_0x0031
            int r4 = r5.f47451k     // Catch:{ all -> 0x0085 }
            int r4 = r4 - r3
            r5.f47451k = r4     // Catch:{ all -> 0x0085 }
        L_0x0031:
            monitor-exit(r2)     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x0064
            com.didichuxing.diface.biz.bioassay.video_capture.EGLBase r0 = r5.f47452l
            if (r0 == 0) goto L_0x0010
            int r0 = r5.f47447g
            if (r0 < 0) goto L_0x0010
            com.didichuxing.diface.biz.bioassay.video_capture.EGLBase$EglSurface r0 = r5.f47453m
            r0.makeCurrent()
            r0 = 0
            r2 = 1065353216(0x3f800000, float:1.0)
            android.opengl.GLES20.glClearColor(r2, r2, r0, r2)
            r0 = 16384(0x4000, float:2.2959E-41)
            android.opengl.GLES20.glClear(r0)
            com.didichuxing.diface.biz.bioassay.video_capture.GLDrawer2D r0 = r5.f47454n
            float[] r2 = r5.f47448h
            r3 = 16
            r0.setMatrix(r2, r3)
            com.didichuxing.diface.biz.bioassay.video_capture.GLDrawer2D r0 = r5.f47454n
            int r2 = r5.f47447g
            float[] r3 = r5.f47448h
            r0.draw(r2, r3)
            com.didichuxing.diface.biz.bioassay.video_capture.EGLBase$EglSurface r0 = r5.f47453m
            r0.swap()
            goto L_0x0010
        L_0x0064:
            java.lang.Object r0 = r5.f47443c
            monitor-enter(r0)
            java.lang.Object r2 = r5.f47443c     // Catch:{ InterruptedException -> 0x0070 }
            r2.wait()     // Catch:{ InterruptedException -> 0x0070 }
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            goto L_0x0010
        L_0x006e:
            r1 = move-exception
            goto L_0x0083
        L_0x0070:
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
        L_0x0071:
            java.lang.Object r1 = r5.f47443c
            monitor-enter(r1)
            r5.f47450j = r3     // Catch:{ all -> 0x0080 }
            r5.m33975b()     // Catch:{ all -> 0x0080 }
            java.lang.Object r0 = r5.f47443c     // Catch:{ all -> 0x0080 }
            r0.notifyAll()     // Catch:{ all -> 0x0080 }
            monitor-exit(r1)     // Catch:{ all -> 0x0080 }
            return
        L_0x0080:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0080 }
            throw r0
        L_0x0083:
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            throw r1
        L_0x0085:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0085 }
            throw r0
        L_0x0088:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.biz.bioassay.video_capture.RenderHandler.run():void");
    }

    /* renamed from: a */
    private final void m33974a() {
        m33975b();
        EGLBase eGLBase = new EGLBase(this.f47444d, false, this.f47445e);
        this.f47452l = eGLBase;
        EGLBase.EglSurface createFromSurface = eGLBase.createFromSurface(this.f47446f);
        this.f47453m = createFromSurface;
        createFromSurface.makeCurrent();
        this.f47454n = new GLDrawer2D();
        this.f47446f = null;
        this.f47443c.notifyAll();
    }

    /* renamed from: b */
    private final void m33975b() {
        EGLBase.EglSurface eglSurface = this.f47453m;
        if (eglSurface != null) {
            eglSurface.release();
            this.f47453m = null;
        }
        GLDrawer2D gLDrawer2D = this.f47454n;
        if (gLDrawer2D != null) {
            gLDrawer2D.release();
            this.f47454n = null;
        }
        EGLBase eGLBase = this.f47452l;
        if (eGLBase != null) {
            eGLBase.release();
            this.f47452l = null;
        }
    }
}
