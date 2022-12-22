package p094this;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: this.for */
/* compiled from: RenderBuffer */
public class C3132for {

    /* renamed from: a */
    private int f6975a = 0;

    /* renamed from: b */
    private int f6976b = 0;

    /* renamed from: c */
    private int f6977c = 0;

    /* renamed from: d */
    private int f6978d;

    /* renamed from: e */
    private int f6979e;

    public C3132for(int i, int i2, int i3) {
        this.f6978d = i;
        this.f6979e = i2;
        int[] iArr = new int[1];
        GLES20.glActiveTexture(i3);
        this.f6975a = C3133if.m4104do();
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, ByteBuffer.allocateDirect(i * i2 * 4).order(ByteOrder.nativeOrder()).asIntBuffer());
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i4 = iArr[0];
        this.f6977c = i4;
        GLES20.glBindFramebuffer(36160, i4);
        GLES20.glGenRenderbuffers(1, iArr, 0);
        int i5 = iArr[0];
        this.f6976b = i5;
        GLES20.glBindRenderbuffer(36161, i5);
        GLES20.glRenderbufferStorage(36161, 33189, i, i2);
        m46210case();
    }

    /* renamed from: case  reason: not valid java name */
    public void m46210case() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* renamed from: do */
    public void mo38646do() {
        mo38648if();
        GLES20.glBindFramebuffer(36160, this.f6977c);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f6975a, 0);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.f6976b);
    }

    /* renamed from: for  reason: not valid java name */
    public int m46211for() {
        return this.f6979e;
    }

    /* renamed from: if */
    public void mo38648if() {
        GLES20.glViewport(0, 0, this.f6978d, this.f6979e);
    }

    /* renamed from: new  reason: not valid java name */
    public int m46212new() {
        return this.f6975a;
    }

    /* renamed from: try  reason: not valid java name */
    public int m46213try() {
        return this.f6978d;
    }
}
