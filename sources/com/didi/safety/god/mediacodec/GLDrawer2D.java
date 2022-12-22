package com.didi.safety.god.mediacodec;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GLDrawer2D {

    /* renamed from: e */
    private static final boolean f34623e = false;

    /* renamed from: f */
    private static final String f34624f = "GLDrawer2D";

    /* renamed from: g */
    private static final String f34625g = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\n\nvoid main() {\n\tgl_Position = uMVPMatrix * aPosition;\n\tvTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: h */
    private static final String f34626h = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying highp vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}";

    /* renamed from: i */
    private static final float[] f34627i = {1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};

    /* renamed from: j */
    private static final float[] f34628j = {1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: k */
    private static final int f34629k = 4;

    /* renamed from: l */
    private static final int f34630l = 4;

    /* renamed from: m */
    private static final int f34631m = 8;

    /* renamed from: a */
    int f34632a;

    /* renamed from: b */
    int f34633b;

    /* renamed from: c */
    int f34634c;

    /* renamed from: d */
    int f34635d;

    /* renamed from: n */
    private final FloatBuffer f34636n;

    /* renamed from: o */
    private final FloatBuffer f34637o;

    /* renamed from: p */
    private final float[] f34638p = new float[16];

    /* renamed from: q */
    private int f34639q;

    public GLDrawer2D() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f34636n = asFloatBuffer;
        asFloatBuffer.put(f34627i);
        this.f34636n.flip();
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f34637o = asFloatBuffer2;
        asFloatBuffer2.put(f34628j);
        this.f34637o.flip();
        int loadShader = loadShader(f34625g, f34626h);
        this.f34639q = loadShader;
        GLES20.glUseProgram(loadShader);
        this.f34632a = GLES20.glGetAttribLocation(this.f34639q, "aPosition");
        this.f34633b = GLES20.glGetAttribLocation(this.f34639q, "aTextureCoord");
        this.f34634c = GLES20.glGetUniformLocation(this.f34639q, "uMVPMatrix");
        this.f34635d = GLES20.glGetUniformLocation(this.f34639q, "uTexMatrix");
        Matrix.setIdentityM(this.f34638p, 0);
        GLES20.glUniformMatrix4fv(this.f34634c, 1, false, this.f34638p, 0);
        GLES20.glUniformMatrix4fv(this.f34635d, 1, false, this.f34638p, 0);
        GLES20.glVertexAttribPointer(this.f34632a, 2, 5126, false, 8, this.f34636n);
        GLES20.glVertexAttribPointer(this.f34633b, 2, 5126, false, 8, this.f34637o);
        GLES20.glEnableVertexAttribArray(this.f34632a);
        GLES20.glEnableVertexAttribArray(this.f34633b);
    }

    public static int initTex() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLES20.glTexParameteri(36197, 10241, 9728);
        GLES20.glTexParameteri(36197, 10240, 9728);
        return iArr[0];
    }

    public static void deleteTex(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
    }

    public static int loadShader(String str, String str2) {
        int glCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        int i = 0;
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteShader(glCreateShader);
            glCreateShader = 0;
        }
        int glCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(glCreateShader2, str2);
        GLES20.glCompileShader(glCreateShader2);
        GLES20.glGetShaderiv(glCreateShader2, 35713, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteShader(glCreateShader2);
        } else {
            i = glCreateShader2;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, glCreateShader);
        GLES20.glAttachShader(glCreateProgram, i);
        GLES20.glLinkProgram(glCreateProgram);
        return glCreateProgram;
    }

    public void release() {
        int i = this.f34639q;
        if (i >= 0) {
            GLES20.glDeleteProgram(i);
        }
        this.f34639q = -1;
    }

    public void draw(int i, float[] fArr) {
        GLES20.glUseProgram(this.f34639q);
        if (fArr != null) {
            GLES20.glUniformMatrix4fv(this.f34635d, 1, false, fArr, 0);
        }
        GLES20.glUniformMatrix4fv(this.f34634c, 1, false, this.f34638p, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(36197, 0);
        GLES20.glUseProgram(0);
    }

    public void setMatrix(float[] fArr, int i) {
        if (fArr == null || fArr.length < i + 16) {
            Matrix.setIdentityM(this.f34638p, 0);
        } else {
            System.arraycopy(fArr, i, this.f34638p, 0, 16);
        }
    }
}
