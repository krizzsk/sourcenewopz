package com.microblink.blinkbarcode.secured;

import android.content.Context;
import android.os.Build;
import android.util.AndroidException;
import com.microblink.blinkbarcode.hardware.camera.IlIllIlIIl;
import com.microblink.blinkbarcode.hardware.camera.IllIIIllII;
import com.microblink.blinkbarcode.hardware.camera.llIIlIlIIl;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public class lIlIllIIll {
    private Context llIIlIlIIl;

    public lIlIllIIll(Context context) {
        this.llIIlIlIIl = context;
        if (context == null) {
            throw new NullPointerException("Device manager cannot be null!");
        }
    }

    public IllIIIllII llIIlIlIIl(llIIlIlIIl lliililiil, IlIllIlIIl ilIllIlIIl) {
        com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl lliililiil2 = new com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl(this.llIIlIlIIl, new com.microblink.blinkbarcode.hardware.accelerometer.IlIllIlIIl(0.083333336f, 1.0f), 0.083333336f);
        llIlIlIlIl llilililil = new llIlIlIlIl();
        if (Build.VERSION.SDK_INT < 21) {
            Log.m40231i(this, "Using camera1 manager", new Object[0]);
            return llIIlIlIIl(lliililiil, ilIllIlIIl, lliililiil2, llilililil);
        } else if (ilIllIlIIl.IlIllIlllI() || com.microblink.blinkbarcode.hardware.IllIIIllII.llIIlIIlll().llIllIIlll()) {
            Log.m40231i(this, "Using camera1 manager because either settings or device blacklist expect using legacy camera API", new Object[0]);
            return llIIlIlIIl(lliililiil, ilIllIlIIl, lliililiil2, llilililil);
        } else if (!llIllIIlll.llIIlIlIIl() || !ilIllIlIIl.lIIIIIlIlI() || !com.microblink.blinkbarcode.hardware.IllIIIllII.llIIlIIlll().lIlllIlIlI()) {
            try {
                if (IIIIlIllIl.IlIllIlIIl(this.llIIlIlIIl, ilIllIlIIl.IlIllIlIIl())) {
                    Log.m40231i(this, "Using camera2 manager", new Object[0]);
                    return new IIlIlIIlll(this.llIIlIlIIl, lliililiil2, lliililiil, ilIllIlIIl);
                }
                Log.m40231i(this, "Camera2 API not supported natively. Will use camera1 manager!", new Object[0]);
                return llIIlIlIIl(lliililiil, ilIllIlIIl, lliililiil2, llilililil);
            } catch (AndroidException unused) {
                Log.m40229e(this, "Failed to query camera capabilities when deciding which camera manager to use! Will use camera1 API", new Object[0]);
                return llIIlIlIIl(lliililiil, ilIllIlIIl, lliililiil2, llilililil);
            }
        } else {
            Log.m40231i(this, "Using camera1 manager because phase autofocus is buggy on this device", new Object[0]);
            return llIIlIlIIl(lliililiil, ilIllIlIIl, lliililiil2, llilililil);
        }
    }

    private lllIIIlIlI llIIlIlIIl(llIIlIlIIl lliililiil, IlIllIlIIl ilIllIlIIl, com.microblink.blinkbarcode.hardware.accelerometer.llIIlIlIIl lliililiil2, lIlIIlIIll liliiliill) {
        return new lllIIIlIlI(lliililiil2, liliiliill, lliililiil, ilIllIlIIl);
    }
}
