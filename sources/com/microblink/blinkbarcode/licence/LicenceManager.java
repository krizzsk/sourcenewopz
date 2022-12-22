package com.microblink.blinkbarcode.licence;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.microblink.blinkbarcode.licence.exception.InvalidLicenceKeyException;
import com.microblink.blinkbarcode.licence.llIIlIlIIl;
import com.microblink.blinkbarcode.recognition.IlIllIlIIl;
import com.microblink.blinkbarcode.recognition.Right;
import com.microblink.blinkbarcode.recognition.RightsManager;
import com.microblink.blinkbarcode.secured.IIIIIllIll;
import com.microblink.blinkbarcode.secured.lIllllIlll;

/* compiled from: line */
public class LicenceManager {
    private static boolean llIIlIlIIl = true;

    static {
        IlIllIlIIl.llIIlIlIIl();
    }

    public static void IlIllIlIIl(Context context, String str, String str2) {
        llIIlIlIIl(context, nativeSetBase64LibraryLicenseKey(str, str2));
        llIIlIlIIl(context);
    }

    public static void IllIIIllII(Context context, String str) {
        llIIlIlIIl(context, nativeSetBase64LicenseKey(str));
        llIIlIlIIl(context);
    }

    public static void llIIlIlIIl(boolean z) {
        llIIlIlIIl = z;
    }

    private static native long nativeGetLease();

    private static native boolean nativeIsLicenceOnline();

    private static native String nativeSetBase64LibraryLicenseKey(String str, String str2);

    private static native String nativeSetBase64LicenseKey(String str);

    private static native String nativeSetLibraryLicenseBuffer(byte[] bArr, String str);

    private static native String nativeSetLibraryLicenseFile(String str, String str2, AssetManager assetManager);

    private static native String nativeSetLicenseBuffer(byte[] bArr);

    private static native String nativeSetLicenseFile(String str, AssetManager assetManager);

    private static native int nativeSubmitServerPermission(String str);

    public static void llIIlIlIIl(Context context, byte[] bArr) {
        llIIlIlIIl(context, nativeSetLicenseBuffer(bArr));
        llIIlIlIIl(context);
    }

    public static void IlIllIlIIl(Context context, String str) {
        llIIlIlIIl(context, nativeSetLicenseFile(str, context.getAssets()));
        llIIlIlIIl(context);
    }

    public static void llIIlIlIIl(Context context, byte[] bArr, String str) {
        llIIlIlIIl(context, nativeSetLibraryLicenseBuffer(bArr, str));
        llIIlIlIIl(context);
    }

    public static void llIIlIlIIl(Context context, String str, String str2) {
        llIIlIlIIl(context, nativeSetLibraryLicenseFile(str, str2, context.getAssets()));
        llIIlIlIIl(context);
    }

    public static llIIlIlIIl llIIlIlIIl(String str) {
        llIIlIlIIl.C22033llIIlIlIIl lliililiil;
        int nativeSubmitServerPermission = nativeSubmitServerPermission(str);
        boolean z = nativeSubmitServerPermission == -1;
        if (!z) {
            llIIlIlIIl.C22033llIIlIlIIl.values();
            lliililiil = nativeSubmitServerPermission >= 5 ? llIIlIlIIl.C22033llIIlIlIIl.PayloadCorrupted : llIIlIlIIl.C22033llIIlIlIIl.values()[nativeSubmitServerPermission];
        } else {
            lliililiil = null;
        }
        return new llIIlIlIIl(z, nativeGetLease() * 1000, lliililiil);
    }

    private static void llIIlIlIIl(Context context, String str) {
        if (str != null) {
            throw new InvalidLicenceKeyException(str);
        } else if (RightsManager.llIIlIlIIl(Right.IS_TRIAL) && llIIlIlIIl) {
            SystemUtils.showToast(Toast.makeText(context, "Using trial license!", 1));
        }
    }

    public static boolean llIIlIlIIl() {
        return nativeIsLicenceOnline();
    }

    private static void llIIlIlIIl(Context context) {
        lIllllIlll.llIIlIlIIl(context);
        lIllllIlll.llIIlIlIIl().llIIlIlIIl();
        IIIIIllIll.llIIlIlIIl().IlIllIlIIl(context);
    }
}
