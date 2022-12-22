package p057class;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

/* renamed from: class.do */
/* compiled from: CannyShader */
public abstract class C1286do {

    /* renamed from: do */
    protected int f499do;

    /* renamed from: for  reason: not valid java name */
    public static void m46129for(int i, float[] fArr) {
        GLES20.glUniform4fv(i, 1, FloatBuffer.wrap(fArr));
    }

    /* renamed from: if */
    public static void m1007if(int i, float[] fArr) {
        GLES20.glUniform3fv(i, 1, FloatBuffer.wrap(fArr));
    }

    /* renamed from: do */
    public int mo14156do() {
        return this.f499do;
    }

    /* renamed from: for  reason: not valid java name */
    public abstract void m46130for();

    /* renamed from: if */
    public boolean mo14155if() {
        return false;
    }

    /* renamed from: do */
    public static void m1005do(int i, float f) {
        GLES20.glUniform1f(i, f);
    }

    /* renamed from: do */
    public static void m1006do(int i, float[] fArr) {
        GLES20.glUniform2fv(i, 1, FloatBuffer.wrap(fArr));
    }

    /* access modifiers changed from: protected */
    /* renamed from: do */
    public final int mo14157do(String str) {
        return GLES20.glGetUniformLocation(this.f499do, str);
    }
}
