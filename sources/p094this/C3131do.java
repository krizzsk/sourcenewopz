package p094this;

import android.graphics.Rect;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import p227const.C20724do;
import p232do.C20817break;
import p238goto.C20992do;
import p238goto.C20993if;

/* renamed from: this.do */
/* compiled from: CameraFilter */
public abstract class C3131do {

    /* renamed from: a */
    static final float[] f6964a = {1.0f, -1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};

    /* renamed from: b */
    static final float[] f6965b = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: c */
    static FloatBuffer f6966c;

    /* renamed from: d */
    static FloatBuffer f6967d;

    /* renamed from: e */
    static int f6968e;

    /* renamed from: h */
    private static C20992do f6969h;

    /* renamed from: i */
    private static FloatBuffer f6970i;

    /* renamed from: j */
    private static C20817break f6971j = new C20817break(0, 0);

    /* renamed from: f */
    final long f6972f = System.currentTimeMillis();

    /* renamed from: g */
    int f6973g = 0;

    /* renamed from: k */
    private C20724do f6974k = new C20724do();

    public C3131do(float[] fArr) {
        if (f6966c == null) {
            float[] fArr2 = f6964a;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            f6966c = asFloatBuffer;
            asFloatBuffer.put(fArr2);
            f6966c.position(0);
        }
        if (f6967d == null) {
            float[] fArr3 = f6965b;
            FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            f6967d = asFloatBuffer2;
            asFloatBuffer2.put(fArr3);
            f6967d.position(0);
        }
        if (f6970i == null) {
            FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            f6970i = asFloatBuffer3;
            asFloatBuffer3.put(fArr);
            f6970i.position(0);
        }
        if (f6968e == 0) {
            f6968e = C3133if.m4107do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n\nvarying vec2                texCoord;\nuniform samplerExternalOES  iChannel0;\n\nvoid main() {\n    gl_FragColor = texture2D(iChannel0, texCoord);\n}");
        }
    }

    /* renamed from: a */
    private boolean m4093a() {
        return f6968e == 0 && f6969h == null;
    }

    /* renamed from: do */
    public static int m4094do() {
        C20992do doVar = f6969h;
        if (doVar == null) {
            return f6971j.mo170629do();
        }
        return doVar.m46211for();
    }

    /* renamed from: if */
    public static int m4096if() {
        C20992do doVar = f6969h;
        if (doVar == null) {
            return f6971j.mo170632if();
        }
        return doVar.m46213try();
    }

    /* renamed from: do */
    public abstract void mo14163do(int i, int i2, int i3);

    /* renamed from: new  reason: not valid java name */
    public void m46208new() {
        this.f6973g = 0;
    }

    /* renamed from: try  reason: not valid java name */
    public synchronized void m46209try() {
        f6968e = 0;
        f6969h = null;
        f6966c = null;
        f6967d = null;
        f6970i = null;
    }

    /* renamed from: do */
    public final synchronized void mo38640do(int i, int i2, int i3, C20993if ifVar) {
        C20992do doVar = f6969h;
        if (!(doVar != null && doVar.m46213try() == i2 && f6969h.m46211for() == i3)) {
            f6969h = new C20992do(i2, i3, 33992, ifVar);
        }
        GLES20.glUseProgram(f6968e);
        int glGetUniformLocation = GLES20.glGetUniformLocation(f6968e, "iChannel0");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(glGetUniformLocation, 0);
        int glGetAttribLocation = GLES20.glGetAttribLocation(f6968e, "vPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, f6966c);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(f6968e, "vTexCoord");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, f6970i);
        f6969h.mo38646do();
        GLES20.glClear(16384);
        GLES20.glDrawArrays(5, 0, 4);
        f6969h.m46210case();
        GLES20.glClear(16384);
        mo14163do(f6969h.m46212new(), i2, i3);
        this.f6973g++;
    }

    /* renamed from: do */
    public void mo38641do(int i, int[] iArr, int[] iArr2, int[][] iArr3) {
        mo38639a(i, f6966c, f6967d, iArr, iArr2, iArr3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo38639a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int[] iArr, int[] iArr2, int[][] iArr3) {
        int i2 = i;
        int[] iArr4 = iArr2;
        int[][] iArr5 = iArr3;
        GLES20.glUseProgram(i);
        GLES20.glUniform3fv(GLES20.glGetUniformLocation(i2, "iResolution"), 1, FloatBuffer.wrap(new float[]{(float) iArr[0], (float) iArr[1], 1.0f}));
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i2, "iGlobalTime"), ((float) (System.currentTimeMillis() - this.f6972f)) / 1000.0f);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(i2, "iFrame"), this.f6973g);
        int glGetAttribLocation = GLES20.glGetAttribLocation(i2, "vPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, floatBuffer);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(i2, "vTexCoord");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, floatBuffer2);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i2, "scaleX"), this.f6974k.m47605try());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i2, "scaleY"), this.f6974k.m47603case());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i2, "offsetX"), this.f6974k.mo169167do());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i2, "offsetY"), this.f6974k.mo169170if());
        for (int i3 = 0; i3 < iArr4.length; i3++) {
            int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "iChannel" + i3);
            GLES20.glActiveTexture(33984 + i3);
            GLES20.glBindTexture(3553, iArr4[i3]);
            GLES20.glUniform1i(glGetUniformLocation, i3);
        }
        int length = iArr5.length * 3;
        float[] fArr = new float[length];
        for (int i4 = 0; i4 < iArr5.length; i4++) {
            int i5 = i4 * 3;
            fArr[i5] = (float) iArr5[i4][0];
            fArr[i5 + 1] = (float) iArr5[i4][1];
            fArr[i5 + 2] = 1.0f;
        }
        GLES20.glUniform3fv(GLES20.glGetUniformLocation(i2, "iChannelResolution"), length, FloatBuffer.wrap(fArr));
    }

    /* renamed from: do */
    public synchronized void mo38642do(Rect rect, C20817break breakR) {
        if (!m4093a()) {
            this.f6974k.mo169168do(rect, breakR);
        }
    }

    /* renamed from: do */
    public static void m4095do(int i, int i2) {
        f6971j = new C20817break(i, i2);
    }
}
