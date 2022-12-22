package com.microblink.blinkbarcode.hardware.camera.memory;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;
import com.microblink.blinkbarcode.secured.llIIlllIll;
import com.microblink.blinkbarcode.secured.llIllIIlll;

/* compiled from: line */
public class BitmapCameraFrame implements llIIlllIll {
    private long IlIllIlIIl;
    private Orientation IllIIIIllI = Orientation.ORIENTATION_LANDSCAPE_RIGHT;
    private RectF IllIIIllII;
    private long llIIIlllll;
    private Bitmap llIIlIlIIl;

    public BitmapCameraFrame(Bitmap bitmap, long j) {
        this.llIIlIlIIl = bitmap;
        if (bitmap == null) {
            throw new NullPointerException("Cannot use null bitmap!");
        } else if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            this.llIIIlllll = j;
        } else {
            throw new UnsupportedOperationException("Cannot recognizer bitmaps that are not in ARGB_8888 config!");
        }
    }

    private static native long initializeNativeBitmapFrame(long j, Bitmap bitmap, int i, float f, float f2, float f3, float f4);

    private static native void terminateNativeBitmapFrame(long j);

    public long IlIllIlIIl() {
        return this.IlIllIlIIl;
    }

    public double IllIIIIllI() {
        return -1.0d;
    }

    public void IllIIIllII() {
        terminateNativeBitmapFrame(this.IlIllIlIIl);
        this.IlIllIlIIl = 0;
        this.llIIlIlIIl = null;
    }

    public long lIlIIIIlIl() {
        return this.llIIIlllll;
    }

    public void llIIIlllll() {
    }

    public void llIIlIlIIl() {
    }

    public void llIIlIlIIl(RectF rectF) {
        this.IllIIIllII = rectF;
        llIllIIlll.llIIlIlIIl(rectF);
    }

    public boolean llIIlIlIIl(long j) {
        if (this.IlIllIlIIl == 0) {
            Bitmap bitmap = this.llIIlIlIIl;
            int intValue = this.IllIIIIllI.intValue();
            RectF rectF = this.IllIIIllII;
            long initializeNativeBitmapFrame = initializeNativeBitmapFrame(j, bitmap, intValue, rectF.left, rectF.top, rectF.width(), this.IllIIIllII.height());
            this.IlIllIlIIl = initializeNativeBitmapFrame;
            return initializeNativeBitmapFrame != 0;
        }
        throw new IllegalStateException("Native part is already initialized!");
    }

    public void llIIlIlIIl(Orientation orientation) {
        this.IllIIIIllI = orientation;
    }
}
