package com.microblink.blinkbarcode.image;

import android.graphics.RectF;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.secured.llIIlllIll;

/* compiled from: line */
public class ImageFrame implements llIIlllIll {
    private long IlIllIlIIl = 0;
    private long IllIIIllII;
    public Image llIIlIlIIl;

    public ImageFrame(Image image, long j) {
        this.llIIlIlIIl = image;
        this.IllIIIllII = j;
    }

    private static native long nativeConstruct(long j, long j2);

    private static native void nativeDestruct(long j);

    public final long IlIllIlIIl() {
        return this.IlIllIlIIl;
    }

    public final double IllIIIIllI() {
        return -1.0d;
    }

    public void IllIIIllII() {
        nativeDestruct(this.IlIllIlIIl);
    }

    public final long lIlIIIIlIl() {
        return this.IllIIIllII;
    }

    public final void llIIIlllll() {
        throw new UnsupportedOperationException("Image frame should not be used in object pool.");
    }

    public final void llIIlIlIIl(RectF rectF) {
        throw new UnsupportedOperationException("ImageFrame's ROI is obtained from image object!");
    }

    public boolean llIIlIlIIl(long j) {
        long nativeConstruct = nativeConstruct(j, this.llIIlIlIIl.lllIIIlIlI);
        this.IlIllIlIIl = nativeConstruct;
        return nativeConstruct != 0;
    }

    public final void llIIlIlIIl(Orientation orientation) {
        throw new UnsupportedOperationException("Orientation should be set to image object before creating Image frame");
    }

    public final void llIIlIlIIl() {
        throw new UnsupportedOperationException("Image frame should not be used in object pool.");
    }
}
