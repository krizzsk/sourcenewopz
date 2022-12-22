package com.didi.sdk.store.util;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableUtil {
    public static byte[] marshall(Parcelable parcelable) {
        if (parcelable == null) {
            return new byte[0];
        }
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <T> T unmarshall(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null || creator == null) {
            return null;
        }
        return creator.createFromParcel(m26669a(bArr));
    }

    /* renamed from: a */
    private static Parcel m26669a(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }
}
