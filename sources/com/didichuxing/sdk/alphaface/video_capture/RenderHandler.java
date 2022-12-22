package com.didichuxing.sdk.alphaface.video_capture;

import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.view.Surface;
import com.didichuxing.sdk.alphaface.video_capture.EGLBase;

public final class RenderHandler implements Runnable {

    /* renamed from: a */
    private static final boolean f48840a = false;

    /* renamed from: b */
    private static final String f48841b = "RenderHandler";

    /* renamed from: c */
    private final Object f48842c = new Object();

    /* renamed from: d */
    private EGLContext f48843d;

    /* renamed from: e */
    private boolean f48844e;

    /* renamed from: f */
    private Object f48845f;

    /* renamed from: g */
    private int f48846g = -1;

    /* renamed from: h */
    private float[] f48847h = new float[32];

    /* renamed from: i */
    private boolean f48848i;

    /* renamed from: j */
    private boolean f48849j;

    /* renamed from: k */
    private int f48850k;

    /* renamed from: l */
    private EGLBase f48851l;

    /* renamed from: m */
    private EGLBase.EglSurface f48852m;

    /* renamed from: n */
    private GLDrawer2D f48853n;

    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|(1:5)(1:6)|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.didichuxing.sdk.alphaface.video_capture.RenderHandler createHandler(java.lang.String r4) {
        /*
            com.didichuxing.sdk.alphaface.video_capture.RenderHandler r0 = new com.didichuxing.sdk.alphaface.video_capture.RenderHandler
            r0.<init>()
            java.lang.Object r1 = r0.f48842c
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
            java.lang.Object r4 = r0.f48842c     // Catch:{ InterruptedException -> 0x001e }
            r4.wait()     // Catch:{ InterruptedException -> 0x001e }
        L_0x001e:
            monitor-exit(r1)     // Catch:{ all -> 0x0020 }
            return r0
        L_0x0020:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0020 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.sdk.alphaface.video_capture.RenderHandler.createHandler(java.lang.String):com.didichuxing.sdk.alphaface.video_capture.RenderHandler");
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
            java.lang.Object r0 = r2.f48842c
            monitor-enter(r0)
            boolean r1 = r2.f48849j     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x002d
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x002d:
            r2.f48843d = r3     // Catch:{ all -> 0x0051 }
            r2.f48846g = r4     // Catch:{ all -> 0x0051 }
            r2.f48845f = r5     // Catch:{ all -> 0x0051 }
            r2.f48844e = r6     // Catch:{ all -> 0x0051 }
            r3 = 1
            r2.f48848i = r3     // Catch:{ all -> 0x0051 }
            float[] r3 = r2.f48847h     // Catch:{ all -> 0x0051 }
            r4 = 0
            android.opengl.Matrix.setIdentityM(r3, r4)     // Catch:{ all -> 0x0051 }
            float[] r3 = r2.f48847h     // Catch:{ all -> 0x0051 }
            r4 = 16
            android.opengl.Matrix.setIdentityM(r3, r4)     // Catch:{ all -> 0x0051 }
            java.lang.Object r3 = r2.f48842c     // Catch:{ all -> 0x0051 }
            r3.notifyAll()     // Catch:{ all -> 0x0051 }
            java.lang.Object r3 = r2.f48842c     // Catch:{ InterruptedException -> 0x004f }
            r3.wait()     // Catch:{ InterruptedException -> 0x004f }
        L_0x004f:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x0051:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.sdk.alphaface.video_capture.RenderHandler.setEglContext(android.opengl.EGLContext, int, java.lang.Object, boolean):void");
    }

    public final void draw() {
        draw(this.f48846g, this.f48847h, (float[]) null);
    }

    public final void draw(int i) {
        draw(i, this.f48847h, (float[]) null);
    }

    public final void draw(float[] fArr) {
        draw(this.f48846g, fArr, (float[]) null);
    }

    public final void draw(float[] fArr, float[] fArr2) {
        draw(this.f48846g, fArr, fArr2);
    }

    public final void draw(int i, float[] fArr) {
        draw(i, fArr, (float[]) null);
    }

    public final void draw(int i, float[] fArr, float[] fArr2) {
        synchronized (this.f48842c) {
            if (!this.f48849j) {
                this.f48846g = i;
                if (fArr == null || fArr.length < 16) {
                    Matrix.setIdentityM(this.f48847h, 0);
                } else {
                    System.arraycopy(fArr, 0, this.f48847h, 0, 16);
                }
                if (fArr2 == null || fArr2.length < 16) {
                    Matrix.setIdentityM(this.f48847h, 16);
                } else {
                    System.arraycopy(fArr2, 0, this.f48847h, 16, 16);
                }
                this.f48850k++;
                this.f48842c.notifyAll();
            }
        }
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.f48842c) {
            if (this.f48845f instanceof Surface) {
                if (!((Surface) this.f48845f).isValid()) {
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
            java.lang.Object r0 = r2.f48842c
            monitor-enter(r0)
            boolean r1 = r2.f48849j     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0009:
            r1 = 1
            r2.f48849j = r1     // Catch:{ all -> 0x0018 }
            java.lang.Object r1 = r2.f48842c     // Catch:{ all -> 0x0018 }
            r1.notifyAll()     // Catch:{ all -> 0x0018 }
            java.lang.Object r1 = r2.f48842c     // Catch:{ InterruptedException -> 0x0016 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0016 }
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.sdk.alphaface.video_capture.RenderHandler.release():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
        if (r2 == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0036, code lost:
        if (r5.f48851l == null) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003a, code lost:
        if (r5.f48846g < 0) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x003c, code lost:
        r5.f48852m.makeCurrent();
        android.opengl.GLES20.glClearColor(1.0f, 1.0f, 0.0f, 1.0f);
        android.opengl.GLES20.glClear(16384);
        r5.f48853n.setMatrix(r5.f48847h, 16);
        r5.f48853n.draw(r5.f48846g, r5.f48847h);
        r5.f48852m.swap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0064, code lost:
        r0 = r5.f48842c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0066, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r5.f48842c.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        monitor-exit(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f48842c     // Catch:{ all -> 0x008b }
            monitor-enter(r0)     // Catch:{ all -> 0x008b }
            r1 = 0
            r5.f48849j = r1     // Catch:{ all -> 0x0088 }
            r5.f48848i = r1     // Catch:{ all -> 0x0088 }
            r5.f48850k = r1     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r5.f48842c     // Catch:{ all -> 0x0088 }
            r2.notifyAll()     // Catch:{ all -> 0x0088 }
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
        L_0x0010:
            java.lang.Object r0 = r5.f48842c     // Catch:{ all -> 0x008b }
            monitor-enter(r0)     // Catch:{ all -> 0x008b }
            boolean r2 = r5.f48849j     // Catch:{ all -> 0x0085 }
            r3 = 1
            if (r2 == 0) goto L_0x001a
            monitor-exit(r0)     // Catch:{ all -> 0x0085 }
            goto L_0x0071
        L_0x001a:
            boolean r2 = r5.f48848i     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0023
            r5.f48848i = r1     // Catch:{ all -> 0x0085 }
            r5.m35039a()     // Catch:{ all -> 0x0085 }
        L_0x0023:
            int r2 = r5.f48850k     // Catch:{ all -> 0x0085 }
            if (r2 <= 0) goto L_0x0029
            r2 = 1
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            if (r2 == 0) goto L_0x0031
            int r4 = r5.f48850k     // Catch:{ all -> 0x0085 }
            int r4 = r4 - r3
            r5.f48850k = r4     // Catch:{ all -> 0x0085 }
        L_0x0031:
            monitor-exit(r0)     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0064
            com.didichuxing.sdk.alphaface.video_capture.EGLBase r0 = r5.f48851l     // Catch:{ all -> 0x008b }
            if (r0 == 0) goto L_0x0010
            int r0 = r5.f48846g     // Catch:{ all -> 0x008b }
            if (r0 < 0) goto L_0x0010
            com.didichuxing.sdk.alphaface.video_capture.EGLBase$EglSurface r0 = r5.f48852m     // Catch:{ all -> 0x008b }
            r0.makeCurrent()     // Catch:{ all -> 0x008b }
            r0 = 0
            r2 = 1065353216(0x3f800000, float:1.0)
            android.opengl.GLES20.glClearColor(r2, r2, r0, r2)     // Catch:{ all -> 0x008b }
            r0 = 16384(0x4000, float:2.2959E-41)
            android.opengl.GLES20.glClear(r0)     // Catch:{ all -> 0x008b }
            com.didichuxing.sdk.alphaface.video_capture.GLDrawer2D r0 = r5.f48853n     // Catch:{ all -> 0x008b }
            float[] r2 = r5.f48847h     // Catch:{ all -> 0x008b }
            r3 = 16
            r0.setMatrix(r2, r3)     // Catch:{ all -> 0x008b }
            com.didichuxing.sdk.alphaface.video_capture.GLDrawer2D r0 = r5.f48853n     // Catch:{ all -> 0x008b }
            int r2 = r5.f48846g     // Catch:{ all -> 0x008b }
            float[] r3 = r5.f48847h     // Catch:{ all -> 0x008b }
            r0.draw(r2, r3)     // Catch:{ all -> 0x008b }
            com.didichuxing.sdk.alphaface.video_capture.EGLBase$EglSurface r0 = r5.f48852m     // Catch:{ all -> 0x008b }
            r0.swap()     // Catch:{ all -> 0x008b }
            goto L_0x0010
        L_0x0064:
            java.lang.Object r0 = r5.f48842c     // Catch:{ all -> 0x008b }
            monitor-enter(r0)     // Catch:{ all -> 0x008b }
            java.lang.Object r2 = r5.f48842c     // Catch:{ InterruptedException -> 0x0070 }
            r2.wait()     // Catch:{ InterruptedException -> 0x0070 }
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            goto L_0x0010
        L_0x006e:
            r1 = move-exception
            goto L_0x0083
        L_0x0070:
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
        L_0x0071:
            java.lang.Object r0 = r5.f48842c     // Catch:{ all -> 0x008b }
            monitor-enter(r0)     // Catch:{ all -> 0x008b }
            r5.f48849j = r3     // Catch:{ all -> 0x0080 }
            r5.m35040b()     // Catch:{ all -> 0x0080 }
            java.lang.Object r1 = r5.f48842c     // Catch:{ all -> 0x0080 }
            r1.notifyAll()     // Catch:{ all -> 0x0080 }
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            goto L_0x008b
        L_0x0080:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0080 }
            throw r1     // Catch:{ all -> 0x008b }
        L_0x0083:
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            throw r1     // Catch:{ all -> 0x008b }
        L_0x0085:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0085 }
            throw r1     // Catch:{ all -> 0x008b }
        L_0x0088:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
            throw r1     // Catch:{ all -> 0x008b }
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.sdk.alphaface.video_capture.RenderHandler.run():void");
    }

    /* renamed from: a */
    private final void m35039a() {
        m35040b();
        EGLBase eGLBase = new EGLBase(this.f48843d, false, this.f48844e);
        this.f48851l = eGLBase;
        EGLBase.EglSurface createFromSurface = eGLBase.createFromSurface(this.f48845f);
        this.f48852m = createFromSurface;
        createFromSurface.makeCurrent();
        this.f48853n = new GLDrawer2D();
        this.f48845f = null;
        this.f48842c.notifyAll();
    }

    /* renamed from: b */
    private final void m35040b() {
        EGLBase.EglSurface eglSurface = this.f48852m;
        if (eglSurface != null) {
            eglSurface.release();
            this.f48852m = null;
        }
        GLDrawer2D gLDrawer2D = this.f48853n;
        if (gLDrawer2D != null) {
            gLDrawer2D.release();
            this.f48853n = null;
        }
        EGLBase eGLBase = this.f48851l;
        if (eGLBase != null) {
            eGLBase.release();
            this.f48851l = null;
        }
    }
}
