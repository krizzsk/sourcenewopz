package com.didichuxing.dfbasesdk.video_capture;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GLDrawer2D {

    /* renamed from: e */
    private static final boolean f46798e = false;

    /* renamed from: f */
    private static final String f46799f = "GLDrawer2D";

    /* renamed from: g */
    private static final String f46800g = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\n\nvoid main() {\n\tgl_Position = uMVPMatrix * aPosition;\n\tvTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: h */
    private static final String f46801h = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying highp vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}";

    /* renamed from: i */
    private static final float[] f46802i = {1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};

    /* renamed from: j */
    private static final float[] f46803j = {1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: k */
    private static final int f46804k = 4;

    /* renamed from: l */
    private static final int f46805l = 4;

    /* renamed from: m */
    private static final int f46806m = 8;

    /* renamed from: a */
    int f46807a;

    /* renamed from: b */
    int f46808b;

    /* renamed from: c */
    int f46809c;

    /* renamed from: d */
    int f46810d;

    /* renamed from: n */
    private final FloatBuffer f46811n;

    /* renamed from: o */
    private final FloatBuffer f46812o;

    /* renamed from: p */
    private final float[] f46813p = new float[16];

    /* renamed from: q */
    private int f46814q;

    public GLDrawer2D() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f46811n = asFloatBuffer;
        asFloatBuffer.put(f46802i);
        this.f46811n.flip();
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f46812o = asFloatBuffer2;
        asFloatBuffer2.put(f46803j);
        this.f46812o.flip();
        int loadShader = loadShader(f46800g, f46801h);
        this.f46814q = loadShader;
        GLES20.glUseProgram(loadShader);
        this.f46807a = GLES20.glGetAttribLocation(this.f46814q, "aPosition");
        this.f46808b = GLES20.glGetAttribLocation(this.f46814q, "aTextureCoord");
        this.f46809c = GLES20.glGetUniformLocation(this.f46814q, "uMVPMatrix");
        this.f46810d = GLES20.glGetUniformLocation(this.f46814q, "uTexMatrix");
        Matrix.setIdentityM(this.f46813p, 0);
        GLES20.glUniformMatrix4fv(this.f46809c, 1, false, this.f46813p, 0);
        GLES20.glUniformMatrix4fv(this.f46810d, 1, false, this.f46813p, 0);
        GLES20.glVertexAttribPointer(this.f46807a, 2, 5126, false, 8, this.f46811n);
        GLES20.glVertexAttribPointer(this.f46808b, 2, 5126, false, 8, this.f46812o);
        GLES20.glEnableVertexAttribArray(this.f46807a);
        GLES20.glEnableVertexAttribArray(this.f46808b);
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
        int i = this.f46814q;
        if (i >= 0) {
            GLES20.glDeleteProgram(i);
        }
        this.f46814q = -1;
    }

    public void draw(int i, float[] fArr) {
        GLES20.glUseProgram(this.f46814q);
        if (fArr != null) {
            GLES20.glUniformMatrix4fv(this.f46810d, 1, false, fArr, 0);
        }
        GLES20.glUniformMatrix4fv(this.f46809c, 1, false, this.f46813p, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(36197, 0);
        GLES20.glUseProgram(0);
    }

    public void setMatrix(float[] fArr, int i) {
        if (fArr == null || fArr.length < i + 16) {
            Matrix.setIdentityM(this.f46813p, 0);
        } else {
            System.arraycopy(fArr, i, this.f46813p, 0, 16);
        }
    }
}
