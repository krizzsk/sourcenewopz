package com.microblink.blinkbarcode.secured;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import com.microblink.blinkbarcode.hardware.camera.memory.BitmapCameraFrame;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;

/* compiled from: line */
public class IlIIlIIIII implements llIIlllIll {
    private BitmapCameraFrame IlIllIlIIl;
    private IlllIIIllI llIIlIlIIl;

    public IlIIlIIIII(IlllIIIllI illlIIIllI) {
        this.llIIlIlIIl = illlIIIllI;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(illlIIIllI.llIIlIIlll(), 0, this.llIIlIlIIl.llIIlIIlll().length);
        if (decodeByteArray != null) {
            this.IlIllIlIIl = new BitmapCameraFrame(decodeByteArray, this.llIIlIlIIl.lIlIIIIlIl());
            return;
        }
        throw new RuntimeException("Failed to decode photo data!");
    }

    public long IlIllIlIIl() {
        return this.IlIllIlIIl.IlIllIlIIl();
    }

    public double IllIIIIllI() {
        this.IlIllIlIIl.getClass();
        return -1.0d;
    }

    public void IllIIIllII() {
        this.IlIllIlIIl.IllIIIllII();
        this.llIIlIlIIl.llIIlIlIIl();
    }

    public long lIlIIIIlIl() {
        return this.llIIlIlIIl.lIIIIIllll;
    }

    public void llIIIlllll() {
    }

    public void llIIlIlIIl() {
    }

    public void llIIlIlIIl(RectF rectF) {
        this.IlIllIlIIl.llIIlIlIIl(rectF);
    }

    public boolean llIIlIlIIl(long j) {
        return this.IlIllIlIIl.llIIlIlIIl(j);
    }

    public void llIIlIlIIl(Orientation orientation) {
        this.IlIllIlIIl.llIIlIlIIl(orientation);
    }
}
