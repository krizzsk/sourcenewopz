package com.microblink.blinkbarcode.hardware.camera;

/* compiled from: line */
public class llIIIlllll {
    private int IlIllIlIIl;
    private int llIIlIlIIl;

    public llIIIlllll(int i, int i2) {
        this.llIIlIlIIl = i;
        this.IlIllIlIIl = i2;
    }

    public int IlIllIlIIl() {
        return this.llIIlIlIIl;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof llIIIlllll)) {
            return false;
        }
        llIIIlllll lliiilllll = (llIIIlllll) obj;
        if (this.llIIlIlIIl == lliiilllll.llIIlIlIIl && this.IlIllIlIIl == lliiilllll.IlIllIlIIl) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.llIIlIlIIl * 32713) + this.IlIllIlIIl;
    }

    public boolean llIIlIlIIl(int i, int i2) {
        return this.llIIlIlIIl == i && this.IlIllIlIIl == i2;
    }

    public int llIIlIlIIl() {
        return this.IlIllIlIIl;
    }
}
