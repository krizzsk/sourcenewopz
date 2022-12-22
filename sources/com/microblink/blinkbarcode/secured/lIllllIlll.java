package com.microblink.blinkbarcode.secured;

import android.content.Context;
import com.microblink.blinkbarcode.recognition.Right;
import com.microblink.blinkbarcode.recognition.RightsManager;
import com.microblink.blinkbarcode.settings.NativeLibraryInfo;

/* compiled from: line */
public class lIllllIlll {
    private static IlllllIIll llIIlIlIIl;

    public static void llIIlIlIIl(Context context) {
        if (!NativeLibraryInfo.isProtectionEnabled() || !RightsManager.llIIlIlIIl(Right.PING_USED)) {
            llIIlIlIIl = new IIlIIlIIII();
        } else {
            llIIlIlIIl = new IIIIIIllIl(context);
        }
    }

    public static IlllllIIll llIIlIlIIl() {
        IlllllIIll illlllIIll = llIIlIlIIl;
        if (illlllIIll != null) {
            return illlllIIll;
        }
        throw new IllegalStateException("PingManagerProvider.setup wasn't called and pingManager instance is null.");
    }
}
