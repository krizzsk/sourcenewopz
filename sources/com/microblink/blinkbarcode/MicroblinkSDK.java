package com.microblink.blinkbarcode;

import android.content.Context;
import com.microblink.blinkbarcode.hardware.IllIIIllII;
import com.microblink.blinkbarcode.hardware.MicroblinkDeviceManager;
import com.microblink.blinkbarcode.intent.IntentDataTransferMode;
import com.microblink.blinkbarcode.licence.LicenceManager;
import com.microblink.blinkbarcode.licence.exception.InvalidLicenceKeyException;
import com.microblink.blinkbarcode.recognition.IlIllIlIIl;
import com.microblink.blinkbarcode.settings.NativeLibraryInfo;

/* compiled from: line */
public final class MicroblinkSDK {
    private static IntentDataTransferMode IlIllIlIIl = IntentDataTransferMode.PERSISTED_OPTIMISED;
    private static Context llIIlIlIIl;

    static {
        IlIllIlIIl.llIIlIlIIl();
    }

    private MicroblinkSDK() {
        throw new AssertionError();
    }

    private static native void applicationContextNativeInitialize(Context context);

    public static Context getApplicationContext() {
        return llIIlIlIIl;
    }

    public static IntentDataTransferMode getIntentDataTransferMode() {
        return IlIllIlIIl;
    }

    public static String getNativeLibraryVersionString() {
        return NativeLibraryInfo.getNativeBuildVersion();
    }

    private static void llIIlIlIIl(Context context) {
        if (MicroblinkDeviceManager.lIlIIIIlIl()) {
            applicationContextNativeInitialize(context);
            llIIlIlIIl = context;
            IllIIIllII.llIIlIlIIl(context, "microblink");
            return;
        }
        throw new InvalidLicenceKeyException("Incompatible processor. This device is not supported!");
    }

    public static void setIntentDataTransferMode(IntentDataTransferMode intentDataTransferMode) {
        IlIllIlIIl = intentDataTransferMode;
    }

    public static void setLicenseBuffer(byte[] bArr, Context context) {
        if (bArr != null) {
            llIIlIlIIl(context);
            LicenceManager.llIIlIlIIl(context, bArr);
            return;
        }
        throw new NullPointerException("License buffer cannot be null");
    }

    public static void setLicenseFile(String str, Context context) {
        if (str == null) {
            throw new NullPointerException("License file path cannot be null");
        } else if (context != null) {
            llIIlIlIIl(context);
            LicenceManager.IlIllIlIIl(context, str);
        } else {
            throw new NullPointerException("Context cannot be null");
        }
    }

    public static void setLicenseKey(String str, Context context) {
        if (str != null) {
            llIIlIlIIl(context);
            LicenceManager.IllIIIllII(context, str);
            return;
        }
        throw new NullPointerException("License buffer cannot be null");
    }

    public static void setShowTrialLicenseWarning(boolean z) {
        LicenceManager.llIIlIlIIl(z);
    }

    public static void setLicenseBuffer(byte[] bArr, String str, Context context) {
        if (bArr == null) {
            throw new NullPointerException("License buffer cannot be null");
        } else if (str != null) {
            llIIlIlIIl(context);
            LicenceManager.llIIlIlIIl(context, bArr, str);
        } else {
            throw new NullPointerException("Licensee cannot be null");
        }
    }

    public static void setLicenseKey(String str, String str2, Context context) {
        if (str == null) {
            throw new NullPointerException("License buffer cannot be null");
        } else if (str2 != null) {
            llIIlIlIIl(context);
            LicenceManager.IlIllIlIIl(context, str, str2);
        } else {
            throw new NullPointerException("Licensee cannot be null");
        }
    }

    public static void setLicenseFile(String str, String str2, Context context) {
        if (str == null) {
            throw new NullPointerException("License file path cannot be null");
        } else if (str2 == null) {
            throw new NullPointerException("Licensee cannot be null");
        } else if (context != null) {
            llIIlIlIIl(context);
            LicenceManager.llIIlIlIIl(context, str, str2);
        } else {
            throw new NullPointerException("Context cannot be null");
        }
    }
}
