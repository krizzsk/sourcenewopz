package com.microblink.blinkbarcode.secured;

import com.microblink.blinkbarcode.hardware.camera.Camera2Frame;
import com.microblink.blinkbarcode.hardware.camera.IllIIIIllI;

/* compiled from: line */
public class lIlIllIIlI {
    private lIlIllllII llIIlIlIIl = null;

    /* compiled from: line */
    public class llIIlIlIIl implements IllIllllII {
        public final /* synthetic */ llIllllIIl llIIlIlIIl;

        public llIIlIlIIl(llIllllIIl llilllliil) {
            this.llIIlIlIIl = llilllliil;
        }

        public llIIlllIll llIIlIlIIl() {
            llIllllIIl llilllliil = this.llIIlIlIIl;
            lIlIllIIlI lililliili = lIlIllIIlI.this;
            ((IllIIIIllI) llilllliil).getClass();
            return new Camera2Frame(lililliili);
        }
    }

    public lIlIllIIlI(int i, llIllllIIl llilllliil) {
        this.llIIlIlIIl = new lIlIllllII(new llIIlIlIIl(llilllliil), i);
    }

    public IIllIIllll llIIlIlIIl() {
        return (IIllIIllll) this.llIIlIlIIl.llIIlIlIIl();
    }

    public void llIIlIlIIl(IIllIIllll iIllIIllll) {
        this.llIIlIlIIl.llIIlIlIIl(iIllIIllll);
    }
}
