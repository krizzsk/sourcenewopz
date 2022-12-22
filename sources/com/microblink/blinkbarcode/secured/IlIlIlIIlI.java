package com.microblink.blinkbarcode.secured;

import com.microblink.blinkbarcode.hardware.camera.Camera1Frame;
import com.microblink.blinkbarcode.hardware.camera.IllIIIIllI;
import com.microblink.blinkbarcode.util.Log;
import java.util.HashMap;
import java.util.Map;

/* compiled from: line */
public class IlIlIlIIlI {
    private IlIllIlIIl llIIlIlIIl = null;

    /* compiled from: line */
    public class llIIlIlIIl implements IllIllllII {
        public final /* synthetic */ int IlIllIlIIl;
        public final /* synthetic */ lllIIIlIlI IllIIIIllI;
        public final /* synthetic */ int IllIIIllII;
        public final /* synthetic */ int llIIIlllll;
        public final /* synthetic */ llIllllIIl llIIlIlIIl;

        public llIIlIlIIl(llIllllIIl llilllliil, int i, int i2, int i3, lllIIIlIlI llliiilili) {
            this.llIIlIlIIl = llilllliil;
            this.IlIllIlIIl = i;
            this.IllIIIllII = i2;
            this.llIIIlllll = i3;
            this.IllIIIIllI = llliiilili;
        }

        public llIIlllIll llIIlIlIIl() {
            llIllllIIl llilllliil = this.llIIlIlIIl;
            int i = this.IlIllIlIIl;
            int i2 = this.IllIIIllII;
            int i3 = this.llIIIlllll;
            IlIlIlIIlI ilIlIlIIlI = IlIlIlIIlI.this;
            lllIIIlIlI llliiilili = this.IllIIIIllI;
            ((IllIIIIllI) llilllliil).getClass();
            return new Camera1Frame(i, i2, i3, ilIlIlIIlI, llliiilili);
        }
    }

    public IlIlIlIIlI(int i, int i2, int i3, int i4, lllIIIlIlI llliiilili, llIllllIIl llilllliil) {
        this.llIIlIlIIl = new IlIllIlIIl(new llIIlIlIIl(llilllliil, i, i2, i3, llliiilili), i4);
    }

    public lIllIIlIIl IlIllIlIIl() {
        return (lIllIIlIIl) this.llIIlIlIIl.llIIlIlIIl();
    }

    public void llIIlIlIIl(lIllIIlIIl lilliiliil) {
        this.llIIlIlIIl.llIIlIlIIl(lilliiliil);
    }

    public lIllIIlIIl llIIlIlIIl(byte[] bArr) {
        IlIllIlIIl ilIllIlIIl = this.llIIlIlIIl;
        if (ilIllIlIIl != null) {
            return ilIllIlIIl.llIIlIlIIl(bArr);
        }
        return null;
    }

    public void llIIlIlIIl() {
        this.llIIlIlIIl.IlIllIlIIl();
        this.llIIlIlIIl = null;
    }

    /* compiled from: line */
    public class IlIllIlIIl extends lIlIllllII {
        private Map<byte[], lIllIIlIIl> IllIIIIllI = null;

        public IlIllIlIIl(IllIllllII illIllllII, int i) {
            super(illIllllII, i);
            this.IllIIIIllI = new HashMap(i);
        }

        public void IlIllIlIIl() {
            Map<byte[], lIllIIlIIl> map = this.IllIIIIllI;
            if (map != null) {
                for (byte[] bArr : map.keySet()) {
                    this.IllIIIIllI.get(bArr).IIlIIIllIl();
                }
                this.IllIIIIllI.clear();
            }
            this.IllIIIIllI = null;
        }

        public void finalize() throws Throwable {
            IlIllIlIIl();
            super.finalize();
        }

        public synchronized llIIlllIll llIIlIlIIl() {
            lIllIIlIIl lilliiliil;
            lilliiliil = (lIllIIlIIl) super.llIIlIlIIl();
            this.IllIIIIllI.put(lilliiliil.llIIlIlIIl, lilliiliil);
            Log.m40227d(IlIlIlIIlI.this, "Creating new camera preview frame", new Object[0]);
            return lilliiliil;
        }

        public synchronized lIllIIlIIl llIIlIlIIl(byte[] bArr) {
            Map<byte[], lIllIIlIIl> map = this.IllIIIIllI;
            if (map == null) {
                return null;
            }
            lIllIIlIIl lilliiliil = map.get(bArr);
            if (lilliiliil == null) {
                return null;
            }
            lilliiliil.llIIIlllll();
            return lilliiliil;
        }
    }
}
