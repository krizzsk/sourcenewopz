package com.microblink.blinkbarcode.intent;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.MicroblinkSDK;

/* compiled from: line */
public class IllIIIllII {
    public static void llIIlIlIIl(Intent intent, String str, llIIIlllll lliiilllll) {
        IntentDataTransferMode intentDataTransferMode = MicroblinkSDK.getIntentDataTransferMode();
        if (intentDataTransferMode == IntentDataTransferMode.STANDARD) {
            Parcel obtain = Parcel.obtain();
            lliiilllll.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            if (marshall.length <= 65536) {
                intent.putExtra(str, marshall);
                return;
            }
            throw new IllegalStateException("Data cannot be saved to intent because its size exceeds intent limit!");
        }
        Context applicationContext = MicroblinkSDK.getApplicationContext();
        if (applicationContext != null) {
            IlIllIlIIl.llIIlIlIIl().llIIlIlIIl(applicationContext, str, lliiilllll, llIIlIlIIl(intentDataTransferMode));
            return;
        }
        throw new IllegalStateException("Application context has not been passed to the Microblink SDK. Please check whether you have set the license key for the Microblink SDK, where application context also has to be provided.");
    }

    public static <T extends llIIIlllll> T llIIlIlIIl(Intent intent, String str, Parcelable.Creator<T> creator) {
        IntentDataTransferMode intentDataTransferMode = MicroblinkSDK.getIntentDataTransferMode();
        if (intentDataTransferMode != IntentDataTransferMode.STANDARD) {
            return IlIllIlIIl.llIIlIlIIl().llIIlIlIIl(MicroblinkSDK.getApplicationContext(), str, creator, llIIlIlIIl(intentDataTransferMode));
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
        obtain.setDataPosition(0);
        T t = (llIIIlllll) creator.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }

    public static void llIIlIlIIl(String str, llIIIlllll lliiilllll) {
        IntentDataTransferMode intentDataTransferMode = MicroblinkSDK.getIntentDataTransferMode();
        if (intentDataTransferMode != IntentDataTransferMode.STANDARD) {
            IlIllIlIIl.llIIlIlIIl().llIIlIlIIl(MicroblinkSDK.getApplicationContext(), str, lliiilllll, llIIlIlIIl(intentDataTransferMode));
        }
    }

    public static void llIIlIlIIl(String str) {
        IntentDataTransferMode intentDataTransferMode = MicroblinkSDK.getIntentDataTransferMode();
        if (intentDataTransferMode != IntentDataTransferMode.STANDARD) {
            IlIllIlIIl.llIIlIlIIl().llIIlIlIIl(MicroblinkSDK.getApplicationContext(), str, llIIlIlIIl(intentDataTransferMode));
        }
    }

    private static boolean llIIlIlIIl(IntentDataTransferMode intentDataTransferMode) {
        return intentDataTransferMode == IntentDataTransferMode.PERSISTED_OPTIMISED;
    }
}
