package com.microblink.blinkbarcode.secured;

import android.content.Context;
import com.microblink.blinkbarcode.recognition.RightsManager;
import com.microblink.blinkbarcode.secured.IIllIlIlII;
import com.microblink.blinkbarcode.settings.NativeLibraryInfo;
import com.microblink.blinkbarcode.util.lIlIIIIlIl;
import java.util.concurrent.TimeUnit;

/* compiled from: line */
class lIIlIIllII {
    private final long IIlIIIllIl;
    /* access modifiers changed from: private */
    public final lllIIlIlII IlIllIlIIl;
    private final String IllIIIIllI;
    private final lIlIIIIlIl IllIIIllII;
    private final String lIlIIIIlIl;
    private final String llIIIlllll;
    private final String llIIlIIlll;
    private final IIllIlIlII llIIlIlIIl = new IIllIlIlII();

    /* compiled from: line */
    public class IlIllIlIIl implements Runnable {
        public IlIllIlIIl() {
        }

        public void run() {
            lIIlIIllII.IlIllIlIIl(lIIlIIllII.this);
        }
    }

    /* compiled from: line */
    public class llIIlIlIIl implements Runnable {
        public final /* synthetic */ IIIlIIIIll llIIlIlIIl;

        public llIIlIlIIl(IIIlIIIIll iIIlIIIIll) {
            this.llIIlIlIIl = iIIlIIIIll;
        }

        public void run() {
            lIIlIIllII.this.IlIllIlIIl.llIIlIlIIl(this.llIIlIlIIl);
            lIIlIIllII.IlIllIlIIl(lIIlIIllII.this);
        }
    }

    public lIIlIIllII(Context context) {
        lllIIlIlII llliililii = new lllIIlIlII(context);
        this.IlIllIlIIl = llliililii;
        lIlIIIIlIl liliiiilil = new lIlIIIIlIl("Ping");
        this.IllIIIllII = liliiiilil;
        liliiiilil.start();
        this.llIIIlllll = context.getPackageName();
        this.IllIIIIllI = RightsManager.IlIllIlIIl();
        this.lIlIIIIlIl = RightsManager.llIIlIlIIl();
        this.llIIlIIlll = llliililii.IllIIIllII();
        this.IIlIIIllIl = TimeUnit.DAYS.toMillis((long) RightsManager.IllIIIllII());
    }

    public static void IlIllIlIIl(lIIlIIllII liiliillii) {
        liiliillii.getClass();
        if (System.currentTimeMillis() - liiliillii.IlIllIlIIl.llIIlIlIIl() >= liiliillii.IIlIIIllIl) {
            IIIlIIIIll IlIllIlIIl2 = liiliillii.IlIllIlIIl.IlIllIlIIl();
            if (!IlIllIlIIl2.IllIIIIllI()) {
                try {
                    if (liiliillii.llIIlIlIIl.llIIlIlIIl(new IIllIlIlII.llIIlIlIIl(NativeLibraryInfo.IllIIIllII(), liiliillii.llIIlIIlll, IlIllIlIIl2, liiliillii.IllIIIIllI, liiliillii.lIlIIIIlIl, liiliillii.llIIIlllll)).llIIlIlIIl()) {
                        liiliillii.IlIllIlIIl.llIIlIlIIl(System.currentTimeMillis());
                        liiliillii.IlIllIlIIl.llIIIlllll();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        this.IllIIIllII.IlIllIlIIl();
    }

    public void llIIlIlIIl(IIIlIIIIll iIIlIIIIll) {
        this.IllIIIllII.llIIlIlIIl((Runnable) new llIIlIlIIl(iIIlIIIIll));
    }

    public void llIIlIlIIl() {
        this.IllIIIllII.llIIlIlIIl((Runnable) new IlIllIlIIl());
    }
}
