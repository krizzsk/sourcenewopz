package com.microblink.blinkbarcode.secured;

import android.graphics.RectF;
import com.microblink.blinkbarcode.hardware.orientation.Orientation;

/* compiled from: line */
public abstract class lllIIlIIlI implements llIIlllIll {
    public Orientation IIlIIIllIl;
    public int IlIllIlIIl;
    public boolean IllIIIIllI;
    public int IllIIIllII;
    public long lIIIIIllll;
    public RectF lIlIIIIlIl;
    public boolean llIIIlllll;
    public long llIIlIIlll = 0;
    public byte[] llIIlIlIIl = null;

    public lllIIlIIlI(int i, int i2, int i3) {
        this.IlIllIlIIl = i;
        this.IllIIIllII = i2;
        if (i3 > 0) {
            this.llIIlIlIIl = new byte[i3];
        }
    }

    public final void IlIllIlIIl(boolean z) {
        this.llIIIlllll = z;
    }

    public long lIlIIIIlIl() {
        return this.lIIIIIllll;
    }

    public void llIIIlllll() {
        this.lIlIIIIlIl = null;
        this.IIlIIIllIl = null;
    }

    public byte[] llIIlIIlll() {
        return this.llIIlIlIIl;
    }

    public final void llIIlIlIIl(RectF rectF) {
        this.lIlIIIIlIl = rectF;
        llIllIIlll.llIIlIlIIl(rectF);
    }

    public long IlIllIlIIl() {
        return this.llIIlIIlll;
    }

    public void IlIllIlIIl(long j) {
        this.lIIIIIllll = j;
    }

    public final void llIIlIlIIl(byte[] bArr) {
        this.llIIlIlIIl = bArr;
    }

    public final void llIIlIlIIl(boolean z) {
        this.IllIIIIllI = z;
    }

    public void llIIlIlIIl(Orientation orientation) {
        this.IIlIIIllIl = orientation;
    }

    public void llIIlIlIIl() {
        this.lIlIIIIlIl = null;
        this.IIlIIIllIl = null;
    }
}
