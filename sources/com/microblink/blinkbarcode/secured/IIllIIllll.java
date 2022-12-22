package com.microblink.blinkbarcode.secured;

import android.graphics.RectF;
import android.media.Image;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.util.Log;
import java.nio.ByteBuffer;

/* compiled from: line */
public abstract class IIllIIllll implements llIIlllIll {
    private double IIlIIIllIl = -1.0d;
    private lIlIllIIlI IlIllIlIIl;
    private boolean IllIIIIllI;
    private llIIlIlIIl IllIIIllII;
    private Orientation lIIIIIllll;
    private RectF lIlIIIIlIl;
    private boolean llIIIlllll;
    private long llIIlIIlll = 0;
    public Image llIIlIlIIl;
    private long lllIIIlIlI;

    /* compiled from: line */
    public interface llIIlIlIIl {
        void llIIlIlIIl(Image image);
    }

    public IIllIIllll(lIlIllIIlI lililliili) {
        this.IlIllIlIIl = lililliili;
    }

    public abstract double IlIllIlIIl(long j);

    public final void IlIllIlIIl(boolean z) {
        this.llIIIlllll = z;
    }

    public double IllIIIIllI() {
        if (this.IIlIIIllIl < 0.0d) {
            long j = this.llIIlIIlll;
            if (j != 0) {
                this.IIlIIIllIl = IlIllIlIIl(j);
            } else {
                throw new IllegalStateException("Prior calling getFrameQuality make sure you have initialized native part of frame");
            }
        }
        return this.IIlIIIllIl;
    }

    public void IllIIIllII() {
        this.IlIllIlIIl.llIIlIlIIl(this);
    }

    public abstract void IllIIIllII(long j);

    public long lIlIIIIlIl() {
        return this.lllIIIlIlI;
    }

    public void llIIIlllll() {
        this.llIIlIlIIl = null;
        this.IllIIIllII = null;
        this.lIlIIIIlIl = null;
        this.lIIIIIllll = null;
        this.IIlIIIllIl = -1.0d;
    }

    public abstract long llIIlIlIIl(long j, int i, int i2, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4, ByteBuffer byteBuffer, int i4, int i5, ByteBuffer byteBuffer2, int i6, int i7, ByteBuffer byteBuffer3, int i8, int i9);

    public void llIIlIlIIl(Image image, llIIlIlIIl lliililiil) {
        this.llIIlIlIIl = image;
        this.IllIIIllII = lliililiil;
    }

    public long IlIllIlIIl() {
        return this.llIIlIIlll;
    }

    public void llIIlIlIIl() {
        Log.m40233v(this, "Finalizing frame ID: {}", Long.valueOf(this.lllIIIlIlI));
        IllIIIllII(this.llIIlIIlll);
        this.llIIlIIlll = 0;
        Image image = this.llIIlIlIIl;
        if (image != null) {
            this.IllIIIllII.llIIlIlIIl(image);
            this.IllIIIllII = null;
        }
    }

    public void llIIIlllll(long j) {
        this.lllIIIlIlI = j;
    }

    public void llIIlIlIIl(RectF rectF) {
        this.lIlIIIIlIl = rectF;
        llIllIIlll.llIIlIlIIl(rectF);
    }

    public final void llIIlIlIIl(boolean z) {
        this.IllIIIIllI = z;
    }

    public void llIIlIlIIl(Orientation orientation) {
        this.lIIIIIllll = orientation;
    }

    public boolean llIIlIlIIl(long j) {
        if (this.llIIlIIlll == 0) {
            int width = this.llIIlIlIIl.getWidth();
            int height = this.llIIlIlIIl.getHeight();
            boolean z = this.llIIIlllll;
            boolean z2 = this.IllIIIIllI;
            int intValue = this.lIIIIIllll.intValue();
            RectF rectF = this.lIlIIIIlIl;
            long llIIlIlIIl2 = llIIlIlIIl(j, width, height, z, z2, intValue, rectF.left, rectF.top, rectF.width(), this.lIlIIIIlIl.height(), this.llIIlIlIIl.getPlanes()[0].getBuffer(), this.llIIlIlIIl.getPlanes()[0].getRowStride(), this.llIIlIlIIl.getPlanes()[0].getPixelStride(), this.llIIlIlIIl.getPlanes()[1].getBuffer(), this.llIIlIlIIl.getPlanes()[1].getRowStride(), this.llIIlIlIIl.getPlanes()[1].getPixelStride(), this.llIIlIlIIl.getPlanes()[2].getBuffer(), this.llIIlIlIIl.getPlanes()[2].getRowStride(), this.llIIlIlIIl.getPlanes()[2].getPixelStride());
            this.llIIlIIlll = llIIlIlIIl2;
            return llIIlIlIIl2 != 0;
        }
        throw new IllegalStateException("Native part is already initialized!");
    }
}
