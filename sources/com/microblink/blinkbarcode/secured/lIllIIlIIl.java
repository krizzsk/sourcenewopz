package com.microblink.blinkbarcode.secured;

import android.graphics.RectF;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public abstract class lIllIIlIIl extends lllIIlIIlI {
    private double IlIllIlllI = -1.0d;
    private IlIlIlIIlI lllIIIlIlI;
    public lllIIIlIlI lllIlIlIIl;

    public lIllIIlIIl(int i, int i2, int i3, IlIlIlIIlI ilIlIlIIlI, lllIIIlIlI llliiilili) {
        super(i, i2, i3);
        this.lllIlIlIIl = llliiilili;
        this.lllIIIlIlI = ilIlIlIIlI;
    }

    public void IIlIIIllIl() {
        this.llIIlIlIIl = null;
        this.lIlIIIIlIl = null;
        this.IIlIIIllIl = null;
        this.lllIlIlIIl = null;
        this.lllIIIlIlI = null;
    }

    public double IllIIIIllI() {
        if (this.IlIllIlllI < 0.0d) {
            long j = this.llIIlIIlll;
            if (j != 0) {
                this.IlIllIlllI = IllIIIllII(j);
            } else {
                throw new IllegalStateException("Prior calling getFrameQuality make sure you have initialized native part of frame");
            }
        }
        return this.IlIllIlllI;
    }

    public abstract double IllIIIllII(long j);

    public void IllIIIllII() {
        IlIlIlIIlI ilIlIlIIlI = this.lllIIIlIlI;
        if (ilIlIlIIlI != null) {
            ilIlIlIIlI.llIIlIlIIl(this);
        }
    }

    public void llIIIlllll() {
        this.lIlIIIIlIl = null;
        this.IIlIIIllIl = null;
        this.IlIllIlllI = -1.0d;
    }

    public abstract void llIIIlllll(long j);

    public abstract long llIIlIlIIl(long j, int i, int i2, byte[] bArr, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4);

    public void llIIlIlIIl() {
        Log.m40233v(this, "Finalizing frame ID: {}", Long.valueOf(this.lIIIIIllll));
        llIIIlllll(this.llIIlIIlll);
        this.llIIlIIlll = 0;
        lllIIIlIlI llliiilili = this.lllIlIlIIl;
        if (llliiilili != null) {
            llliiilili.llIIlIlIIl((lllIIlIIlI) this);
        }
        super.llIIlIlIIl();
    }

    public boolean llIIlIlIIl(long j) {
        if (this.llIIlIIlll != 0) {
            Log.m40229e(this, "Native part is already initialized!", new Object[0]);
            return false;
        }
        int i = this.IlIllIlIIl;
        int i2 = this.IllIIIllII;
        byte[] bArr = this.llIIlIlIIl;
        boolean z = this.llIIIlllll;
        boolean z2 = this.IllIIIIllI;
        int intValue = this.IIlIIIllIl.intValue();
        RectF rectF = this.lIlIIIIlIl;
        long llIIlIlIIl = llIIlIlIIl(j, i, i2, bArr, z, z2, intValue, rectF.left, rectF.top, rectF.width(), this.lIlIIIIlIl.height());
        this.llIIlIIlll = llIIlIlIIl;
        return llIIlIlIIl != 0;
    }
}
