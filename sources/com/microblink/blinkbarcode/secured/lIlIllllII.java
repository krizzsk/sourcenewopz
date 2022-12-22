package com.microblink.blinkbarcode.secured;

/* compiled from: line */
public class lIlIllllII {
    private IllIllllII IlIllIlIIl;
    private llIIlllIll[] IllIIIllII;
    private int llIIIlllll = -1;
    public final int llIIlIlIIl;

    public lIlIllllII(IllIllllII illIllllII, int i) {
        this.IlIllIlIIl = illIllllII;
        this.IllIIIllII = new llIIlllIll[i];
        this.llIIlIlIIl = i - 1;
    }

    public synchronized llIIlllIll llIIlIlIIl() {
        llIIlllIll lliilllill;
        int i = this.llIIIlllll;
        if (i == -1) {
            lliilllill = this.IlIllIlIIl.llIIlIlIIl();
        } else {
            llIIlllIll lliilllill2 = this.IllIIIllII[i];
            this.llIIIlllll = i - 1;
            lliilllill = lliilllill2;
        }
        lliilllill.llIIIlllll();
        return lliilllill;
    }

    public synchronized void llIIlIlIIl(llIIlllIll lliilllill) {
        if (lliilllill != null) {
            lliilllill.llIIlIlIIl();
            int i = this.llIIIlllll;
            if (i < this.llIIlIlIIl) {
                int i2 = i + 1;
                this.llIIIlllll = i2;
                this.IllIIIllII[i2] = lliilllill;
            }
        }
    }
}
