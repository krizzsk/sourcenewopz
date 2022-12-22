package com.microblink.blinkbarcode.secured;

import java.util.ArrayList;

/* compiled from: line */
final class IIIlIIIIll {
    private final long IlIllIlIIl;
    private final long IllIIIllII;
    private final IlIlIlllIl llIIIlllll;
    private final long llIIlIlIIl;

    public IIIlIIIIll(long j, long j2, long j3, IlIlIlllIl ilIlIlllIl) {
        this.llIIlIlIIl = j;
        this.IlIllIlIIl = j2;
        this.IllIIIllII = j3;
        this.llIIIlllll = ilIlIlllIl;
    }

    public long IlIllIlIIl() {
        return this.llIIlIlIIl;
    }

    public boolean IllIIIIllI() {
        return this.llIIlIlIIl == 0 && this.IlIllIlIIl == 0 && this.IllIIIllII == 0 && this.llIIIlllll.IlIllIlIIl();
    }

    public long IllIIIllII() {
        return this.IlIllIlIIl;
    }

    public long llIIIlllll() {
        return this.IllIIIllII;
    }

    public IlIlIlllIl llIIlIlIIl() {
        return this.llIIIlllll;
    }

    public static IIIlIIIIll llIIlIlIIl(IIIlIIIIll... iIIlIIIIllArr) {
        ArrayList arrayList = new ArrayList(iIIlIIIIllArr.length);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        for (IIIlIIIIll iIIlIIIIll : iIIlIIIIllArr) {
            j += iIIlIIIIll.llIIlIlIIl;
            j2 += iIIlIIIIll.IlIllIlIIl;
            j3 += iIIlIIIIll.IllIIIllII;
            arrayList.add(iIIlIIIIll.llIIIlllll);
        }
        return new IIIlIIIIll(j, j2, j3, IlIlIlllIl.IlIllIlIIl(arrayList));
    }
}
