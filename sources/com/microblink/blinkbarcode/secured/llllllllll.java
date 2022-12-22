package com.microblink.blinkbarcode.secured;

import android.content.Context;
import com.microblink.blinkbarcode.licence.llIIlIlIIl;
import com.microblink.blinkbarcode.util.IllIIIIllI;

/* compiled from: line */
class llllllllll extends IllIIIIllI {
    public llllllllll(Context context) {
        super(context, "com.microblink.blinkbarcode.baltazar.preferences");
    }

    public String IlIllIlIIl() {
        return IllIIIllII("com.microblink.blinkbarcode.baltazar.preferences.lastServerResponse");
    }

    public void IllIIIIllI(String str) {
        llIIlIlIIl("com.microblink.blinkbarcode.baltazar.preferences.lastServerResponse", str);
    }

    public Boolean IllIIIllII() {
        return llIIlIlIIl("com.microblink.blinkbarcode.baltazar.preferences.licenceUnlocked");
    }

    public void llIIlIlIIl(llIIlIlIIl lliililiil) {
        llIIlIlIIl("com.microblink.blinkbarcode.baltazar.preferences.licenceUnlocked", Boolean.valueOf(lliililiil.llIIlIlIIl));
        llIIlIlIIl("com.microblink.blinkbarcode.baltazar.preferences.lease", lliililiil.IlIllIlIIl);
    }

    public long llIIlIlIIl() {
        return IlIllIlIIl("com.microblink.blinkbarcode.baltazar.preferences.lease");
    }
}
