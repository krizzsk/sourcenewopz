package com.microblink.blinkbarcode.secured;

/* compiled from: line */
class lllllIIIlI {
    private final boolean IlIllIlIIl;
    private final llIIlIlIIl IllIIIllII;
    private final IllIIlllIl llIIlIlIIl;

    /* compiled from: line */
    public enum llIIlIlIIl {
        Empty,
        Uncertain,
        Valid,
        StageValid
    }

    public lllllIIIlI(IllIIlllIl illIIlllIl, boolean z, llIIlIlIIl lliililiil) {
        this.llIIlIlIIl = illIIlllIl;
        this.IlIllIlIIl = z;
        this.IllIIIllII = lliililiil;
    }

    public llIIlIlIIl IlIllIlIIl() {
        return this.IllIIIllII;
    }

    public boolean IllIIIllII() {
        return this.IlIllIlIIl;
    }

    public IllIIlllIl llIIlIlIIl() {
        return this.llIIlIlIIl;
    }
}
