package com.adyen.checkout.core.util;

import android.os.Parcel;
import com.adyen.checkout.core.exception.NoConstructorException;

public final class ParcelUtils {
    public static final int NO_FILE_DESCRIPTOR = 0;

    /* renamed from: a */
    private static final int f948a = 1;

    /* renamed from: b */
    private static final int f949b = 0;

    private ParcelUtils() {
        throw new NoConstructorException();
    }

    public static void writeBoolean(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static boolean readBoolean(Parcel parcel) {
        return parcel.readInt() == 1;
    }
}
