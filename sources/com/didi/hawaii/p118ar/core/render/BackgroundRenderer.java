package com.didi.hawaii.p118ar.core.render;

import android.content.Context;
import android.opengl.GLES20;
import com.didi.hawaii.p118ar.utils.ShaderUtil;
import com.google.p217ar.core.Coordinates2d;
import com.google.p217ar.core.Frame;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.didi.hawaii.ar.core.render.BackgroundRenderer */
public class BackgroundRenderer {

    /* renamed from: a */
    private static final String f23079a = BackgroundRenderer.class.getSimpleName();

    /* renamed from: b */
    private static final String f23080b = "shaders/screenquad.vert";

    /* renamed from: c */
    private static final String f23081c = "shaders/screenquad.frag";

    /* renamed from: d */
    private static final int f23082d = 2;

    /* renamed from: e */
    private static final int f23083e = 2;

    /* renamed from: f */
    private static final int f23084f = 4;

    /* renamed from: m */
    private static final float[] f23085m = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};

    /* renamed from: g */
    private FloatBuffer f23086g;

    /* renamed from: h */
    private FloatBuffer f23087h;

    /* renamed from: i */
    private int f23088i;

    /* renamed from: j */
    private int f23089j;

    /* renamed from: k */
    private int f23090k;

    /* renamed from: l */
    private int f23091l = -1;

    public int getTextureId() {
        return this.f23091l;
    }

    public void createOnGlThread(Context context) throws IOException {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        this.f23091l = i;
        GLES20.glBindTexture(36197, i);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        float[] fArr = f23085m;
        if (4 == fArr.length / 2) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            this.f23086g = asFloatBuffer;
            asFloatBuffer.put(f23085m);
            this.f23086g.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(32);
            allocateDirect2.order(ByteOrder.nativeOrder());
            this.f23087h = allocateDirect2.asFloatBuffer();
            int loadGLShader = ShaderUtil.loadGLShader(f23079a, context, 35633, f23080b);
            int loadGLShader2 = ShaderUtil.loadGLShader(f23079a, context, 35632, f23081c);
            int glCreateProgram = GLES20.glCreateProgram();
            this.f23088i = glCreateProgram;
            GLES20.glAttachShader(glCreateProgram, loadGLShader);
            GLES20.glAttachShader(this.f23088i, loadGLShader2);
            GLES20.glLinkProgram(this.f23088i);
            GLES20.glUseProgram(this.f23088i);
            ShaderUtil.checkGLError(f23079a, "Program creation");
            this.f23089j = GLES20.glGetAttribLocation(this.f23088i, "a_Position");
            this.f23090k = GLES20.glGetAttribLocation(this.f23088i, "a_TexCoord");
            ShaderUtil.checkGLError(f23079a, "Program parameters");
            return;
        }
        throw new RuntimeException("Unexpected number of vertices in BackgroundRenderer.");
    }

    public void draw(Frame frame) {
        if (frame.hasDisplayGeometryChanged()) {
            frame.transformCoordinates2d(Coordinates2d.OPENGL_NORMALIZED_DEVICE_COORDINATES, this.f23086g, Coordinates2d.TEXTURE_NORMALIZED, this.f23087h);
        }
        if (frame.getTimestamp() != 0) {
            m16588a();
        }
    }

    public void draw(int i, int i2, float f, int i3) {
        float f2;
        float f3;
        float[] fArr;
        float f4 = (float) i;
        float f5 = (float) i2;
        if (f < f4 / f5) {
            f2 = f * f5;
            f3 = f5;
        } else {
            f3 = f4 / f;
            f2 = f4;
        }
        float f6 = ((f4 - f2) / f4) * 0.5f;
        float f7 = ((f5 - f3) / f5) * 0.5f;
        if (i3 == 0) {
            float f8 = 1.0f - f7;
            float f9 = 1.0f - f6;
            fArr = new float[]{f6, f8, f6, f7, f9, f8, f9, f7};
        } else if (i3 == 90) {
            float f10 = 1.0f - f6;
            float f11 = 1.0f - f7;
            fArr = new float[]{f10, f11, f6, f11, f10, f7, f6, f7};
        } else if (i3 == 180) {
            float f12 = 1.0f - f6;
            float f13 = 1.0f - f7;
            fArr = new float[]{f12, f7, f12, f13, f6, f7, f6, f13};
        } else if (i3 == 270) {
            float f14 = 1.0f - f6;
            float f15 = 1.0f - f7;
            fArr = new float[]{f6, f7, f14, f7, f6, f15, f14, f15};
        } else {
            throw new IllegalArgumentException("Unhandled rotation: " + i3);
        }
        this.f23087h.position(0);
        this.f23087h.put(fArr);
        m16588a();
    }

    /* renamed from: a */
    private void m16588a() {
        this.f23087h.position(0);
        GLES20.glDisable(2929);
        GLES20.glDepthMask(false);
        GLES20.glBindTexture(36197, this.f23091l);
        GLES20.glUseProgram(this.f23088i);
        GLES20.glVertexAttribPointer(this.f23089j, 2, 5126, false, 0, this.f23086g);
        GLES20.glVertexAttribPointer(this.f23090k, 2, 5126, false, 0, this.f23087h);
        GLES20.glEnableVertexAttribArray(this.f23089j);
        GLES20.glEnableVertexAttribArray(this.f23090k);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f23089j);
        GLES20.glDisableVertexAttribArray(this.f23090k);
        GLES20.glDepthMask(true);
        GLES20.glEnable(2929);
        ShaderUtil.checkGLError(f23079a, "BackgroundRendererDraw");
    }
}
