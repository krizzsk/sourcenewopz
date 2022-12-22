package com.microblink.blinkbarcode.secured;

import android.content.Context;
import com.microblink.blinkbarcode.licence.LicenceManager;
import com.microblink.blinkbarcode.licence.exception.LicenceLockedException;
import com.microblink.blinkbarcode.licence.exception.RemoteLicenceCheckException;
import com.microblink.blinkbarcode.licence.llIIlIlIIl;
import com.microblink.blinkbarcode.recognition.RightsManager;
import com.microblink.blinkbarcode.secured.IIIlIIIIlI;
import com.microblink.blinkbarcode.secured.IIllIllIII;
import com.microblink.blinkbarcode.settings.NativeLibraryInfo;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.util.lIlIIIIlIl;
import java.net.URL;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: line */
class IllllIIlII implements lIIIllIIlI {
    private IIllIllIII IlIllIlIIl;
    private llllllllll IllIIIllII;
    private lIlIIIIlIl llIIIlllll;

    /* compiled from: line */
    public static class llIIlIlIIl {
        public static final IllllIIlII llIIlIlIIl = new IllllIIlII((IIIIIlIIII) null);
    }

    public /* synthetic */ IllllIIlII(IIIIIlIIII iIIIIlIIII) {
        this();
    }

    public void IlIllIlIIl(Context context) {
        if (this.IllIIIllII == null) {
            this.IllIIIllII = new llllllllll(context);
        }
        if (llIIlIlIIl(3)) {
            boolean z = false;
            Log.m40227d("Baltazar", "using baltazar cache", new Object[0]);
            llIIlIlIIl.C22033llIIlIlIIl lliililiil = llIIlIlIIl(this.IllIIIllII.IlIllIlIIl()).IllIIIllII;
            if (!(lliililiil == null || lliililiil == llIIlIlIIl.C22033llIIlIlIIl.RemoteLock)) {
                z = true;
            }
            if (z) {
                this.llIIIlllll.llIIlIlIIl((Runnable) new IIIIIlIIII(this, context));
                return;
            }
            return;
        }
        this.llIIIlllll.llIIlIlIIl((Runnable) new IIIIIlIIII(this, context));
    }

    private IllllIIlII() {
        this.IlIllIlIIl = new IIllIllIII();
        lIlIIIIlIl liliiiilil = new lIlIIIIlIl("Baltazar");
        this.llIIIlllll = liliiiilil;
        liliiiilil.start();
    }

    public void llIIlIlIIl(Context context) {
        if (this.IllIIIllII == null) {
            this.IllIIIllII = new llllllllll(context);
        }
        boolean z = true;
        if (!llIIlIlIIl(0)) {
            z = llIIlIlIIl(context, true);
        } else if (!llIIlIlIIl(this.IllIIIllII.IlIllIlIIl()).llIIlIlIIl) {
            z = llIIlIlIIl(context, true);
        }
        if (!z) {
            throw new LicenceLockedException();
        }
    }

    private boolean llIIlIlIIl(int i) {
        return TimeUnit.MILLISECONDS.toMinutes(this.IllIIIllII.llIIlIlIIl() - System.currentTimeMillis()) > ((long) i) && this.IllIIIllII.IllIIIllII().booleanValue();
    }

    /* access modifiers changed from: private */
    public boolean llIIlIlIIl(Context context, boolean z) {
        try {
            IIIlIllllI IllIIIllII2 = NativeLibraryInfo.IllIIIllII();
            String llIIlIlIIl2 = RightsManager.llIIlIlIIl();
            String IlIllIlIIl2 = RightsManager.IlIllIlIIl();
            String packageName = context.getPackageName();
            String name = IllIIIllII2.llIIlIlIIl().name();
            String IlIllIlIIl3 = IllIIIllII2.IlIllIlIIl();
            IIIlIIIIlI iIIlIIIIlI = new IIIlIIIIlI(new URL("https://baltazar.microblink.com/api/v1/status/check"), "POST");
            iIIlIIIIlI.llIIlIlIIl(20000);
            TreeMap treeMap = new TreeMap();
            treeMap.put("sdkName", name);
            treeMap.put("sdkVersion", IlIllIlIIl3);
            treeMap.put("licensee", IlIllIlIIl2);
            treeMap.put("licenseId", llIIlIlIIl2);
            treeMap.put("packageName", packageName);
            treeMap.put("platform", "ANDROID");
            iIIlIIIIlI.llIIlIlIIl(new JSONObject(treeMap));
            IIllIllIII.llIIlIlIIl lliililiil = new IIllIllIII.llIIlIlIIl(iIIlIIIIlI.IlIllIlIIl(), iIIlIIIIlI.IllIIIllII());
            if (lliililiil.llIIlIlIIl()) {
                com.microblink.blinkbarcode.licence.llIIlIlIIl llIIlIlIIl3 = llIIlIlIIl(lliililiil.IlIllIlIIl);
                llIIlIlIIl.C22033llIIlIlIIl lliililiil2 = llIIlIlIIl3.IllIIIllII;
                if (!((lliililiil2 == null || lliililiil2 == llIIlIlIIl.C22033llIIlIlIIl.RemoteLock) ? false : true)) {
                    return llIIlIlIIl3.llIIlIlIIl;
                }
                if (z) {
                    return llIIlIlIIl(context, false);
                }
                throw new RemoteLicenceCheckException("Unable to do remote licence check.");
            } else if (z) {
                return llIIlIlIIl(context, false);
            } else {
                throw new RemoteLicenceCheckException("Unable to do remote licence check.");
            }
        } catch (Exception e) {
            throw new IIIlIIIIlI.llIIlIlIIl(e);
        } catch (Exception unused) {
            if (z) {
                return llIIlIlIIl(context, false);
            }
            throw new RemoteLicenceCheckException("Unable to do remote licence check.");
        }
    }

    private com.microblink.blinkbarcode.licence.llIIlIlIIl llIIlIlIIl(String str) {
        this.IllIIIllII.IllIIIIllI(str);
        com.microblink.blinkbarcode.licence.llIIlIlIIl llIIlIlIIl2 = LicenceManager.llIIlIlIIl(str);
        this.IllIIIllII.llIIlIlIIl(llIIlIlIIl2);
        return llIIlIlIIl2;
    }
}
