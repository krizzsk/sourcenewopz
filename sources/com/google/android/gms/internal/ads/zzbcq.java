package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.didi.sdk.apm.SystemUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbcq extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzbcn {
    private static final float[] zzent = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private int height;
    private int width;
    private final float[] zzend = new float[9];
    private final zzbcl zzenu;
    private final float[] zzenv = new float[9];
    private final float[] zzenw = new float[9];
    private final float[] zzenx = new float[9];
    private final float[] zzeny = new float[9];
    private final float[] zzenz = new float[9];
    private final float[] zzeoa = new float[9];
    private float zzeob = Float.NaN;
    private float zzeoc;
    private float zzeod;
    private SurfaceTexture zzeoe;
    private SurfaceTexture zzeof;
    private int zzeog;
    private int zzeoh;
    private int zzeoi;
    private FloatBuffer zzeoj;
    private final CountDownLatch zzeok;
    private final Object zzeol;
    private EGL10 zzeom;
    private EGLDisplay zzeon;
    private EGLContext zzeoo;
    private EGLSurface zzeop;
    private volatile boolean zzeoq;
    private volatile boolean zzeor;

    public zzbcq(Context context) {
        super("SphericalVideoProcessor");
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(zzent.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzeoj = asFloatBuffer;
        asFloatBuffer.put(zzent).position(0);
        zzbcl zzbcl = new zzbcl(context);
        this.zzenu = zzbcl;
        zzbcl.zza((zzbcn) this);
        this.zzeok = new CountDownLatch(1);
        this.zzeol = new Object();
    }

    public final void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.width = i;
        this.height = i2;
        this.zzeof = surfaceTexture;
    }

    public final void zzo(int i, int i2) {
        synchronized (this.zzeol) {
            this.width = i;
            this.height = i2;
            this.zzeoq = true;
            this.zzeol.notifyAll();
        }
    }

    public final void zzabp() {
        synchronized (this.zzeol) {
            this.zzeor = true;
            this.zzeof = null;
            this.zzeol.notifyAll();
        }
    }

    public final SurfaceTexture zzabq() {
        if (this.zzeof == null) {
            return null;
        }
        try {
            this.zzeok.await();
        } catch (InterruptedException unused) {
        }
        return this.zzeoe;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzeoi++;
        synchronized (this.zzeol) {
            this.zzeol.notifyAll();
        }
    }

    public final void zzwl() {
        synchronized (this.zzeol) {
            this.zzeol.notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x03c2  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03c7  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01ec A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r22 = this;
            r1 = r22
            android.graphics.SurfaceTexture r0 = r1.zzeof
            if (r0 != 0) goto L_0x0011
            java.lang.String r0 = "SphericalVideoProcessor started with no output texture."
            com.google.android.gms.ads.internal.util.zzd.zzex(r0)
            java.util.concurrent.CountDownLatch r0 = r1.zzeok
            r0.countDown()
            return
        L_0x0011:
            javax.microedition.khronos.egl.EGL r0 = javax.microedition.khronos.egl.EGLContext.getEGL()
            javax.microedition.khronos.egl.EGL10 r0 = (javax.microedition.khronos.egl.EGL10) r0
            r1.zzeom = r0
            java.lang.Object r2 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY
            javax.microedition.khronos.egl.EGLDisplay r0 = r0.eglGetDisplay(r2)
            r1.zzeon = r0
            javax.microedition.khronos.egl.EGLDisplay r2 = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = 0
            if (r0 != r2) goto L_0x002d
        L_0x002a:
            r0 = 0
            goto L_0x0098
        L_0x002d:
            int[] r0 = new int[r4]
            javax.microedition.khronos.egl.EGL10 r2 = r1.zzeom
            javax.microedition.khronos.egl.EGLDisplay r8 = r1.zzeon
            boolean r0 = r2.eglInitialize(r8, r0)
            if (r0 != 0) goto L_0x003a
            goto L_0x002a
        L_0x003a:
            int[] r0 = new int[r6]
            javax.microedition.khronos.egl.EGLConfig[] r2 = new javax.microedition.khronos.egl.EGLConfig[r6]
            r8 = 11
            int[] r10 = new int[r8]
            r10 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r8 = r1.zzeom
            javax.microedition.khronos.egl.EGLDisplay r9 = r1.zzeon
            r12 = 1
            r11 = r2
            r13 = r0
            boolean r8 = r8.eglChooseConfig(r9, r10, r11, r12, r13)
            if (r8 == 0) goto L_0x0059
            r0 = r0[r7]
            if (r0 <= 0) goto L_0x0059
            r0 = r2[r7]
            goto L_0x005a
        L_0x0059:
            r0 = r5
        L_0x005a:
            if (r0 != 0) goto L_0x005d
            goto L_0x002a
        L_0x005d:
            int[] r2 = new int[r3]
            r2 = {12440, 2, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r8 = r1.zzeom
            javax.microedition.khronos.egl.EGLDisplay r9 = r1.zzeon
            javax.microedition.khronos.egl.EGLContext r10 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            javax.microedition.khronos.egl.EGLContext r2 = r8.eglCreateContext(r9, r0, r10, r2)
            r1.zzeoo = r2
            if (r2 == 0) goto L_0x002a
            javax.microedition.khronos.egl.EGLContext r8 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            if (r2 != r8) goto L_0x0075
            goto L_0x002a
        L_0x0075:
            javax.microedition.khronos.egl.EGL10 r2 = r1.zzeom
            javax.microedition.khronos.egl.EGLDisplay r8 = r1.zzeon
            android.graphics.SurfaceTexture r9 = r1.zzeof
            javax.microedition.khronos.egl.EGLSurface r0 = r2.eglCreateWindowSurface(r8, r0, r9, r5)
            r1.zzeop = r0
            if (r0 == 0) goto L_0x002a
            javax.microedition.khronos.egl.EGLSurface r2 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE
            if (r0 != r2) goto L_0x0088
            goto L_0x002a
        L_0x0088:
            javax.microedition.khronos.egl.EGL10 r0 = r1.zzeom
            javax.microedition.khronos.egl.EGLDisplay r2 = r1.zzeon
            javax.microedition.khronos.egl.EGLSurface r8 = r1.zzeop
            javax.microedition.khronos.egl.EGLContext r9 = r1.zzeoo
            boolean r0 = r0.eglMakeCurrent(r2, r8, r8, r9)
            if (r0 != 0) goto L_0x0097
            goto L_0x002a
        L_0x0097:
            r0 = 1
        L_0x0098:
            r2 = 35633(0x8b31, float:4.9932E-41)
            com.google.android.gms.internal.ads.zzabf<java.lang.String> r8 = com.google.android.gms.internal.ads.zzabq.zzcrd
            com.google.android.gms.internal.ads.zzabm r9 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r9 = r9.zzd(r8)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r8.zzsh()
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00bc
            com.google.android.gms.internal.ads.zzabm r9 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r8 = r9.zzd(r8)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00be
        L_0x00bc:
            java.lang.String r8 = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}"
        L_0x00be:
            int r2 = zzd(r2, r8)
            if (r2 != 0) goto L_0x00c7
        L_0x00c4:
            r9 = 0
            goto L_0x0159
        L_0x00c7:
            r8 = 35632(0x8b30, float:4.9931E-41)
            com.google.android.gms.internal.ads.zzabf<java.lang.String> r9 = com.google.android.gms.internal.ads.zzabq.zzcre
            com.google.android.gms.internal.ads.zzabm r10 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r10 = r10.zzd(r9)
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r9.zzsh()
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x00eb
            com.google.android.gms.internal.ads.zzabm r10 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r9 = r10.zzd(r9)
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x00ed
        L_0x00eb:
            java.lang.String r9 = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}"
        L_0x00ed:
            int r8 = zzd(r8, r9)
            if (r8 != 0) goto L_0x00f4
            goto L_0x00c4
        L_0x00f4:
            int r9 = android.opengl.GLES20.glCreateProgram()
            java.lang.String r10 = "createProgram"
            zzfd(r10)
            if (r9 == 0) goto L_0x0159
            android.opengl.GLES20.glAttachShader(r9, r2)
            java.lang.String r2 = "attachShader"
            zzfd(r2)
            android.opengl.GLES20.glAttachShader(r9, r8)
            java.lang.String r2 = "attachShader"
            zzfd(r2)
            android.opengl.GLES20.glLinkProgram(r9)
            java.lang.String r2 = "linkProgram"
            zzfd(r2)
            int[] r2 = new int[r6]
            r8 = 35714(0x8b82, float:5.0046E-41)
            android.opengl.GLES20.glGetProgramiv(r9, r8, r2, r7)
            java.lang.String r8 = "getProgramiv"
            zzfd(r8)
            r2 = r2[r7]
            if (r2 == r6) goto L_0x0150
            java.lang.String r11 = "SphericalVideoRenderer"
            java.lang.String r12 = "Could not link program: "
            r10 = 6
            r13 = 0
            java.lang.String r14 = "com.google.android.gms.internal.ads.zzbcq"
            r15 = 121(0x79, float:1.7E-43)
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)
            java.lang.String r17 = "SphericalVideoRenderer"
            java.lang.String r18 = android.opengl.GLES20.glGetProgramInfoLog(r9)
            r16 = 6
            r19 = 0
            java.lang.String r20 = "com.google.android.gms.internal.ads.zzbcq"
            r21 = 122(0x7a, float:1.71E-43)
            com.didi.sdk.apm.SystemUtils.log(r16, r17, r18, r19, r20, r21)
            android.opengl.GLES20.glDeleteProgram(r9)
            java.lang.String r2 = "deleteProgram"
            zzfd(r2)
            goto L_0x00c4
        L_0x0150:
            android.opengl.GLES20.glValidateProgram(r9)
            java.lang.String r2 = "validateProgram"
            zzfd(r2)
        L_0x0159:
            r1.zzeog = r9
            android.opengl.GLES20.glUseProgram(r9)
            java.lang.String r2 = "useProgram"
            zzfd(r2)
            int r2 = r1.zzeog
            java.lang.String r8 = "aPosition"
            int r2 = android.opengl.GLES20.glGetAttribLocation(r2, r8)
            r10 = 3
            r11 = 5126(0x1406, float:7.183E-42)
            r12 = 0
            r13 = 12
            java.nio.FloatBuffer r14 = r1.zzeoj
            r9 = r2
            android.opengl.GLES20.glVertexAttribPointer(r9, r10, r11, r12, r13, r14)
            java.lang.String r8 = "vertexAttribPointer"
            zzfd(r8)
            android.opengl.GLES20.glEnableVertexAttribArray(r2)
            java.lang.String r2 = "enableVertexAttribArray"
            zzfd(r2)
            int[] r2 = new int[r6]
            android.opengl.GLES20.glGenTextures(r6, r2, r7)
            java.lang.String r8 = "genTextures"
            zzfd(r8)
            r2 = r2[r7]
            r8 = 36197(0x8d65, float:5.0723E-41)
            android.opengl.GLES20.glBindTexture(r8, r2)
            java.lang.String r9 = "bindTextures"
            zzfd(r9)
            r9 = 10240(0x2800, float:1.4349E-41)
            r10 = 9729(0x2601, float:1.3633E-41)
            android.opengl.GLES20.glTexParameteri(r8, r9, r10)
            java.lang.String r9 = "texParameteri"
            zzfd(r9)
            r9 = 10241(0x2801, float:1.435E-41)
            android.opengl.GLES20.glTexParameteri(r8, r9, r10)
            java.lang.String r9 = "texParameteri"
            zzfd(r9)
            r9 = 10242(0x2802, float:1.4352E-41)
            r10 = 33071(0x812f, float:4.6342E-41)
            android.opengl.GLES20.glTexParameteri(r8, r9, r10)
            java.lang.String r9 = "texParameteri"
            zzfd(r9)
            r9 = 10243(0x2803, float:1.4354E-41)
            android.opengl.GLES20.glTexParameteri(r8, r9, r10)
            java.lang.String r8 = "texParameteri"
            zzfd(r8)
            int r8 = r1.zzeog
            java.lang.String r9 = "uVMat"
            int r8 = android.opengl.GLES20.glGetUniformLocation(r8, r9)
            r1.zzeoh = r8
            r9 = 9
            float[] r9 = new float[r9]
            r9 = {1065353216, 0, 0, 0, 1065353216, 0, 0, 0, 1065353216} // fill-array
            android.opengl.GLES20.glUniformMatrix3fv(r8, r6, r7, r9, r7)
            int r8 = r1.zzeog
            if (r8 == 0) goto L_0x01e9
            r8 = 1
            goto L_0x01ea
        L_0x01e9:
            r8 = 0
        L_0x01ea:
            if (r0 == 0) goto L_0x03ac
            if (r8 != 0) goto L_0x01f0
            goto L_0x03ac
        L_0x01f0:
            android.graphics.SurfaceTexture r0 = new android.graphics.SurfaceTexture
            r0.<init>(r2)
            r1.zzeoe = r0
            r0.setOnFrameAvailableListener(r1)
            java.util.concurrent.CountDownLatch r0 = r1.zzeok
            r0.countDown()
            com.google.android.gms.internal.ads.zzbcl r0 = r1.zzenu
            r0.start()
            r1.zzeoq = r6     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
        L_0x0206:
            boolean r0 = r1.zzeor     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            if (r0 != 0) goto L_0x0357
        L_0x020a:
            int r0 = r1.zzeoi     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            if (r0 <= 0) goto L_0x0219
            android.graphics.SurfaceTexture r0 = r1.zzeoe     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r0.updateTexImage()     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            int r0 = r1.zzeoi     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            int r0 = r0 - r6
            r1.zzeoi = r0     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            goto L_0x020a
        L_0x0219:
            com.google.android.gms.internal.ads.zzbcl r0 = r1.zzenu     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r2 = r1.zzend     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            boolean r0 = r0.zza((float[]) r2)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r2 = 5
            r8 = 4
            r9 = 1070141403(0x3fc90fdb, float:1.5707964)
            if (r0 == 0) goto L_0x029f
            float r0 = r1.zzeob     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            boolean r0 = java.lang.Float.isNaN(r0)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            if (r0 == 0) goto L_0x0294
            float[] r0 = r1.zzend     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r10 = new float[r3]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r11 = 0
            r10[r7] = r11     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r12 = 1065353216(0x3f800000, float:1.0)
            r10[r6] = r12     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r10[r4] = r11     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r11 = new float[r3]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r12 = r0[r7]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r13 = r10[r7]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r12 = r12 * r13
            r13 = r0[r6]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r14 = r10[r6]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r13 = r13 * r14
            float r12 = r12 + r13
            r13 = r0[r4]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r14 = r10[r4]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r13 = r13 * r14
            float r12 = r12 + r13
            r11[r7] = r12     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r12 = r0[r3]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r13 = r10[r7]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r12 = r12 * r13
            r13 = r0[r8]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r14 = r10[r6]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r13 = r13 * r14
            float r12 = r12 + r13
            r13 = r0[r2]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r14 = r10[r4]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r13 = r13 * r14
            float r12 = r12 + r13
            r11[r6] = r12     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r12 = 6
            r12 = r0[r12]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r13 = r10[r7]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r12 = r12 * r13
            r13 = 7
            r13 = r0[r13]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r14 = r10[r6]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r13 = r13 * r14
            float r12 = r12 + r13
            r13 = 8
            r0 = r0[r13]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r10 = r10[r4]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r0 = r0 * r10
            float r12 = r12 + r0
            r11[r4] = r12     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r0 = r11[r6]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            double r12 = (double) r0     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r0 = r11[r7]     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            double r10 = (double) r0     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            double r10 = java.lang.Math.atan2(r12, r10)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r0 = (float) r10     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r0 = r0 - r9
            float r0 = -r0
            r1.zzeob = r0     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
        L_0x0294:
            float[] r0 = r1.zzenz     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r10 = r1.zzeob     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r11 = r1.zzeoc     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r10 = r10 + r11
            zzb((float[]) r0, (float) r10)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            goto L_0x02ae
        L_0x029f:
            float[] r0 = r1.zzend     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r10 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            zza(r0, r10)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r0 = r1.zzenz     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r10 = r1.zzeoc     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            zzb((float[]) r0, (float) r10)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
        L_0x02ae:
            float[] r0 = r1.zzenv     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            zza(r0, r9)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r0 = r1.zzenw     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r9 = r1.zzenz     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r10 = r1.zzenv     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            zza((float[]) r0, (float[]) r9, (float[]) r10)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r0 = r1.zzenx     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r9 = r1.zzend     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r10 = r1.zzenw     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            zza((float[]) r0, (float[]) r9, (float[]) r10)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r0 = r1.zzeny     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r9 = r1.zzeod     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            zza(r0, r9)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r0 = r1.zzeoa     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r9 = r1.zzeny     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r10 = r1.zzenx     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            zza((float[]) r0, (float[]) r9, (float[]) r10)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            int r0 = r1.zzeoh     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float[] r9 = r1.zzeoa     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            android.opengl.GLES20.glUniformMatrix3fv(r0, r6, r7, r9, r7)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            android.opengl.GLES20.glDrawArrays(r2, r7, r8)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            java.lang.String r0 = "drawArrays"
            zzfd(r0)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            android.opengl.GLES20.glFinish()     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            javax.microedition.khronos.egl.EGL10 r0 = r1.zzeom     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            javax.microedition.khronos.egl.EGLDisplay r2 = r1.zzeon     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            javax.microedition.khronos.egl.EGLSurface r8 = r1.zzeop     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r0.eglSwapBuffers(r2, r8)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            boolean r0 = r1.zzeoq     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            if (r0 == 0) goto L_0x033d
            int r0 = r1.width     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            int r2 = r1.height     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            android.opengl.GLES20.glViewport(r7, r7, r0, r2)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            java.lang.String r0 = "viewport"
            zzfd(r0)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            int r0 = r1.zzeog     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            java.lang.String r2 = "uFOVx"
            int r0 = android.opengl.GLES20.glGetUniformLocation(r0, r2)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            int r2 = r1.zzeog     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            java.lang.String r8 = "uFOVy"
            int r2 = android.opengl.GLES20.glGetUniformLocation(r2, r8)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            int r8 = r1.width     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            int r9 = r1.height     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            r10 = 1063216883(0x3f5f66f3, float:0.87266463)
            if (r8 <= r9) goto L_0x032c
            android.opengl.GLES20.glUniform1f(r0, r10)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            int r0 = r1.height     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r0 = (float) r0     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r0 = r0 * r10
            int r8 = r1.width     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r8 = (float) r8     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r0 = r0 / r8
            android.opengl.GLES20.glUniform1f(r2, r0)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            goto L_0x033b
        L_0x032c:
            int r8 = r1.width     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r8 = (float) r8     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r8 = r8 * r10
            int r9 = r1.height     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r9 = (float) r9     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            float r8 = r8 / r9
            android.opengl.GLES20.glUniform1f(r0, r8)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
            android.opengl.GLES20.glUniform1f(r2, r10)     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
        L_0x033b:
            r1.zzeoq = r7     // Catch:{ IllegalStateException -> 0x0386, all -> 0x0367 }
        L_0x033d:
            java.lang.Object r2 = r1.zzeol     // Catch:{ InterruptedException -> 0x0206 }
            monitor-enter(r2)     // Catch:{ InterruptedException -> 0x0206 }
            boolean r0 = r1.zzeor     // Catch:{ all -> 0x0354 }
            if (r0 != 0) goto L_0x0351
            boolean r0 = r1.zzeoq     // Catch:{ all -> 0x0354 }
            if (r0 != 0) goto L_0x0351
            int r0 = r1.zzeoi     // Catch:{ all -> 0x0354 }
            if (r0 != 0) goto L_0x0351
            java.lang.Object r0 = r1.zzeol     // Catch:{ all -> 0x0354 }
            r0.wait()     // Catch:{ all -> 0x0354 }
        L_0x0351:
            monitor-exit(r2)     // Catch:{ all -> 0x0354 }
            goto L_0x0206
        L_0x0354:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0354 }
            throw r0     // Catch:{ InterruptedException -> 0x0206 }
        L_0x0357:
            com.google.android.gms.internal.ads.zzbcl r0 = r1.zzenu
            r0.stop()
            android.graphics.SurfaceTexture r0 = r1.zzeoe
            r0.setOnFrameAvailableListener(r5)
            r1.zzeoe = r5
            r22.zzabr()
            return
        L_0x0367:
            r0 = move-exception
            java.lang.String r2 = "SphericalVideoProcessor died."
            com.google.android.gms.ads.internal.util.zzd.zzc(r2, r0)     // Catch:{ all -> 0x039b }
            com.google.android.gms.internal.ads.zzazs r2 = com.google.android.gms.ads.internal.zzr.zzkz()     // Catch:{ all -> 0x039b }
            java.lang.String r3 = "SphericalVideoProcessor.run.2"
            r2.zza(r0, r3)     // Catch:{ all -> 0x039b }
            com.google.android.gms.internal.ads.zzbcl r0 = r1.zzenu
            r0.stop()
            android.graphics.SurfaceTexture r0 = r1.zzeoe
            r0.setOnFrameAvailableListener(r5)
            r1.zzeoe = r5
            r22.zzabr()
            return
        L_0x0386:
            java.lang.String r0 = "SphericalVideoProcessor halted unexpectedly."
            com.google.android.gms.ads.internal.util.zzd.zzez(r0)     // Catch:{ all -> 0x039b }
            com.google.android.gms.internal.ads.zzbcl r0 = r1.zzenu
            r0.stop()
            android.graphics.SurfaceTexture r0 = r1.zzeoe
            r0.setOnFrameAvailableListener(r5)
            r1.zzeoe = r5
            r22.zzabr()
            return
        L_0x039b:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzbcl r2 = r1.zzenu
            r2.stop()
            android.graphics.SurfaceTexture r2 = r1.zzeoe
            r2.setOnFrameAvailableListener(r5)
            r1.zzeoe = r5
            r22.zzabr()
            throw r0
        L_0x03ac:
            javax.microedition.khronos.egl.EGL10 r0 = r1.zzeom
            int r0 = r0.eglGetError()
            java.lang.String r0 = android.opengl.GLUtils.getEGLErrorString(r0)
            java.lang.String r2 = "EGL initialization failed: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r3 = r0.length()
            if (r3 == 0) goto L_0x03c7
            java.lang.String r0 = r2.concat(r0)
            goto L_0x03cc
        L_0x03c7:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x03cc:
            com.google.android.gms.ads.internal.util.zzd.zzex(r0)
            com.google.android.gms.internal.ads.zzazs r2 = com.google.android.gms.ads.internal.zzr.zzkz()
            java.lang.Throwable r3 = new java.lang.Throwable
            r3.<init>(r0)
            java.lang.String r0 = "SphericalVideoProcessor.run.1"
            r2.zza(r3, r0)
            r22.zzabr()
            java.util.concurrent.CountDownLatch r0 = r1.zzeok
            r0.countDown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcq.run():void");
    }

    public final void zzb(float f, float f2) {
        float f3;
        float f4;
        float f5;
        int i = this.width;
        int i2 = this.height;
        if (i > i2) {
            f4 = (f * 1.7453293f) / ((float) i);
            f3 = f2 * 1.7453293f;
            f5 = (float) i;
        } else {
            f4 = (f * 1.7453293f) / ((float) i2);
            f3 = f2 * 1.7453293f;
            f5 = (float) i2;
        }
        this.zzeoc -= f4;
        float f6 = this.zzeod - (f3 / f5);
        this.zzeod = f6;
        if (f6 < -1.5707964f) {
            this.zzeod = -1.5707964f;
        }
        if (this.zzeod > 1.5707964f) {
            this.zzeod = 1.5707964f;
        }
    }

    private static void zza(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static void zza(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = (double) f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    private static void zzb(float[] fArr, float f) {
        double d = (double) f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static int zzd(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzfd("createShader");
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        zzfd("shaderSource");
        GLES20.glCompileShader(glCreateShader);
        zzfd("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        zzfd("getShaderiv");
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Could not compile shader ");
        sb.append(i);
        sb.append(":");
        SystemUtils.log(6, "SphericalVideoRenderer", sb.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzbcq", 293);
        SystemUtils.log(6, "SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader), (Throwable) null, "com.google.android.gms.internal.ads.zzbcq", 294);
        GLES20.glDeleteShader(glCreateShader);
        zzfd("deleteShader");
        return 0;
    }

    private final boolean zzabr() {
        EGLSurface eGLSurface = this.zzeop;
        boolean z = false;
        if (!(eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE)) {
            z = this.zzeom.eglDestroySurface(this.zzeon, this.zzeop) | this.zzeom.eglMakeCurrent(this.zzeon, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | false;
            this.zzeop = null;
        }
        EGLContext eGLContext = this.zzeoo;
        if (eGLContext != null) {
            z |= this.zzeom.eglDestroyContext(this.zzeon, eGLContext);
            this.zzeoo = null;
        }
        EGLDisplay eGLDisplay = this.zzeon;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = z | this.zzeom.eglTerminate(eGLDisplay);
        this.zzeon = null;
        return eglTerminate;
    }

    private static void zzfd(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
            sb.append(str);
            sb.append(": glError ");
            sb.append(glGetError);
            SystemUtils.log(6, "SphericalVideoRenderer", sb.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzbcq", 314);
        }
    }
}
