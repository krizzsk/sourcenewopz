package com.didi.safety.god.mediacodec;

import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.view.Surface;
import com.didi.safety.god.mediacodec.EGLBase;

public final class RenderHandler implements Runnable {

    /* renamed from: a */
    private static final boolean f34681a = false;

    /* renamed from: b */
    private static final String f34682b = "RenderHandler";

    /* renamed from: c */
    private final Object f34683c = new Object();

    /* renamed from: d */
    private EGLContext f34684d;

    /* renamed from: e */
    private boolean f34685e;

    /* renamed from: f */
    private Object f34686f;

    /* renamed from: g */
    private int f34687g = -1;

    /* renamed from: h */
    private float[] f34688h = new float[32];

    /* renamed from: i */
    private boolean f34689i;

    /* renamed from: j */
    private boolean f34690j;

    /* renamed from: k */
    private int f34691k;

    /* renamed from: l */
    private EGLBase f34692l;

    /* renamed from: m */
    private EGLBase.EglSurface f34693m;

    /* renamed from: n */
    private GLDrawer2D f34694n;

    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|(1:5)(1:6)|7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.didi.safety.god.mediacodec.RenderHandler createHandler(java.lang.String r4) {
        /*
            com.didi.safety.god.mediacodec.RenderHandler r0 = new com.didi.safety.god.mediacodec.RenderHandler
            r0.<init>()
            java.lang.Object r1 = r0.f34683c
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
            java.lang.Object r4 = r0.f34683c     // Catch:{ InterruptedException -> 0x001e }
            r4.wait()     // Catch:{ InterruptedException -> 0x001e }
        L_0x001e:
            monitor-exit(r1)     // Catch:{ all -> 0x0020 }
            return r0
        L_0x0020:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0020 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.mediacodec.RenderHandler.createHandler(java.lang.String):com.didi.safety.god.mediacodec.RenderHandler");
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
            java.lang.Object r0 = r2.f34683c
            monitor-enter(r0)
            boolean r1 = r2.f34690j     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x002d
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x002d:
            r2.f34684d = r3     // Catch:{ all -> 0x0051 }
            r2.f34687g = r4     // Catch:{ all -> 0x0051 }
            r2.f34686f = r5     // Catch:{ all -> 0x0051 }
            r2.f34685e = r6     // Catch:{ all -> 0x0051 }
            r3 = 1
            r2.f34689i = r3     // Catch:{ all -> 0x0051 }
            float[] r3 = r2.f34688h     // Catch:{ all -> 0x0051 }
            r4 = 0
            android.opengl.Matrix.setIdentityM(r3, r4)     // Catch:{ all -> 0x0051 }
            float[] r3 = r2.f34688h     // Catch:{ all -> 0x0051 }
            r4 = 16
            android.opengl.Matrix.setIdentityM(r3, r4)     // Catch:{ all -> 0x0051 }
            java.lang.Object r3 = r2.f34683c     // Catch:{ all -> 0x0051 }
            r3.notifyAll()     // Catch:{ all -> 0x0051 }
            java.lang.Object r3 = r2.f34683c     // Catch:{ InterruptedException -> 0x004f }
            r3.wait()     // Catch:{ InterruptedException -> 0x004f }
        L_0x004f:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x0051:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.mediacodec.RenderHandler.setEglContext(android.opengl.EGLContext, int, java.lang.Object, boolean):void");
    }

    public final void draw() {
        draw(this.f34687g, this.f34688h, (float[]) null);
    }

    public final void draw(int i) {
        draw(i, this.f34688h, (float[]) null);
    }

    public final void draw(float[] fArr) {
        draw(this.f34687g, fArr, (float[]) null);
    }

    public final void draw(float[] fArr, float[] fArr2) {
        draw(this.f34687g, fArr, fArr2);
    }

    public final void draw(int i, float[] fArr) {
        draw(i, fArr, (float[]) null);
    }

    public final void draw(int i, float[] fArr, float[] fArr2) {
        synchronized (this.f34683c) {
            if (!this.f34690j) {
                this.f34687g = i;
                if (fArr == null || fArr.length < 16) {
                    Matrix.setIdentityM(this.f34688h, 0);
                } else {
                    System.arraycopy(fArr, 0, this.f34688h, 0, 16);
                }
                if (fArr2 == null || fArr2.length < 16) {
                    Matrix.setIdentityM(this.f34688h, 16);
                } else {
                    System.arraycopy(fArr2, 0, this.f34688h, 16, 16);
                }
                this.f34691k++;
                this.f34683c.notifyAll();
            }
        }
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.f34683c) {
            if (this.f34686f instanceof Surface) {
                if (!((Surface) this.f34686f).isValid()) {
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
            java.lang.Object r0 = r2.f34683c
            monitor-enter(r0)
            boolean r1 = r2.f34690j     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0009:
            r1 = 1
            r2.f34690j = r1     // Catch:{ all -> 0x0018 }
            java.lang.Object r1 = r2.f34683c     // Catch:{ all -> 0x0018 }
            r1.notifyAll()     // Catch:{ all -> 0x0018 }
            java.lang.Object r1 = r2.f34683c     // Catch:{ InterruptedException -> 0x0016 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0016 }
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.mediacodec.RenderHandler.release():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
        if (r0 == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0036, code lost:
        if (r5.f34692l == null) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003a, code lost:
        if (r5.f34687g < 0) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003c, code lost:
        r5.f34693m.makeCurrent();
        android.opengl.GLES20.glClearColor(1.0f, 1.0f, 0.0f, 1.0f);
        android.opengl.GLES20.glClear(16384);
        r5.f34694n.setMatrix(r5.f34688h, 16);
        r5.f34694n.draw(r5.f34687g, r5.f34688h);
        r5.f34693m.swap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        r0 = r5.f34683c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0066, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r5.f34683c.wait();
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
            java.lang.Object r0 = r5.f34683c
            monitor-enter(r0)
            r1 = 0
            r5.f34690j = r1     // Catch:{ all -> 0x0088 }
            r5.f34689i = r1     // Catch:{ all -> 0x0088 }
            r5.f34691k = r1     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r5.f34683c     // Catch:{ all -> 0x0088 }
            r2.notifyAll()     // Catch:{ all -> 0x0088 }
            monitor-exit(r0)     // Catch:{ all -> 0x0088 }
        L_0x0010:
            java.lang.Object r2 = r5.f34683c
            monitor-enter(r2)
            boolean r0 = r5.f34690j     // Catch:{ all -> 0x0085 }
            r3 = 1
            if (r0 == 0) goto L_0x001a
            monitor-exit(r2)     // Catch:{ all -> 0x0085 }
            goto L_0x0071
        L_0x001a:
            boolean r0 = r5.f34689i     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x0023
            r5.f34689i = r1     // Catch:{ all -> 0x0085 }
            r5.m24492a()     // Catch:{ all -> 0x0085 }
        L_0x0023:
            int r0 = r5.f34691k     // Catch:{ all -> 0x0085 }
            if (r0 <= 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x0029:
            r0 = 0
        L_0x002a:
            if (r0 == 0) goto L_0x0031
            int r4 = r5.f34691k     // Catch:{ all -> 0x0085 }
            int r4 = r4 - r3
            r5.f34691k = r4     // Catch:{ all -> 0x0085 }
        L_0x0031:
            monitor-exit(r2)     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x0064
            com.didi.safety.god.mediacodec.EGLBase r0 = r5.f34692l
            if (r0 == 0) goto L_0x0010
            int r0 = r5.f34687g
            if (r0 < 0) goto L_0x0010
            com.didi.safety.god.mediacodec.EGLBase$EglSurface r0 = r5.f34693m
            r0.makeCurrent()
            r0 = 0
            r2 = 1065353216(0x3f800000, float:1.0)
            android.opengl.GLES20.glClearColor(r2, r2, r0, r2)
            r0 = 16384(0x4000, float:2.2959E-41)
            android.opengl.GLES20.glClear(r0)
            com.didi.safety.god.mediacodec.GLDrawer2D r0 = r5.f34694n
            float[] r2 = r5.f34688h
            r3 = 16
            r0.setMatrix(r2, r3)
            com.didi.safety.god.mediacodec.GLDrawer2D r0 = r5.f34694n
            int r2 = r5.f34687g
            float[] r3 = r5.f34688h
            r0.draw(r2, r3)
            com.didi.safety.god.mediacodec.EGLBase$EglSurface r0 = r5.f34693m
            r0.swap()
            goto L_0x0010
        L_0x0064:
            java.lang.Object r0 = r5.f34683c
            monitor-enter(r0)
            java.lang.Object r2 = r5.f34683c     // Catch:{ InterruptedException -> 0x0070 }
            r2.wait()     // Catch:{ InterruptedException -> 0x0070 }
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            goto L_0x0010
        L_0x006e:
            r1 = move-exception
            goto L_0x0083
        L_0x0070:
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
        L_0x0071:
            java.lang.Object r1 = r5.f34683c
            monitor-enter(r1)
            r5.f34690j = r3     // Catch:{ all -> 0x0080 }
            r5.m24493b()     // Catch:{ all -> 0x0080 }
            java.lang.Object r0 = r5.f34683c     // Catch:{ all -> 0x0080 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safety.god.mediacodec.RenderHandler.run():void");
    }

    /* renamed from: a */
    private final void m24492a() {
        m24493b();
        EGLBase eGLBase = new EGLBase(this.f34684d, false, this.f34685e);
        this.f34692l = eGLBase;
        EGLBase.EglSurface createFromSurface = eGLBase.createFromSurface(this.f34686f);
        this.f34693m = createFromSurface;
        createFromSurface.makeCurrent();
        this.f34694n = new GLDrawer2D();
        this.f34686f = null;
        this.f34683c.notifyAll();
    }

    /* renamed from: b */
    private final void m24493b() {
        EGLBase.EglSurface eglSurface = this.f34693m;
        if (eglSurface != null) {
            eglSurface.release();
            this.f34693m = null;
        }
        GLDrawer2D gLDrawer2D = this.f34694n;
        if (gLDrawer2D != null) {
            gLDrawer2D.release();
            this.f34694n = null;
        }
        EGLBase eGLBase = this.f34692l;
        if (eGLBase != null) {
            eGLBase.release();
            this.f34692l = null;
        }
    }
}
