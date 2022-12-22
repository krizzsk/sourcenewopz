package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import java.util.Enumeration;
import java.util.Hashtable;

/* renamed from: com.cardinalcommerce.a.BCDSTU4145PublicKey */
public abstract class BCDSTU4145PublicKey implements KeyPairGeneratorSpi.C1980EC {
    /* renamed from: a */
    private static boolean m1765a(DSASigner.dsa512 dsa512, DSASigner.dsa512 dsa5122) {
        return DSASigner.noneDSA.configure(dsa512, dsa5122);
    }

    /* renamed from: a */
    private static boolean m1766a(boolean z, DSASigner.dsa512 dsa512, DSASigner.dsa512[] dsa512Arr) {
        if (z) {
            int length = dsa512Arr.length - 1;
            while (length >= 0) {
                if (dsa512Arr[length] == null || !m1765a(dsa512, dsa512Arr[length])) {
                    length--;
                } else {
                    dsa512Arr[length] = null;
                    return true;
                }
            }
        } else {
            int i = 0;
            while (i != dsa512Arr.length) {
                if (dsa512Arr[i] == null || !m1765a(dsa512, dsa512Arr[i])) {
                    i++;
                } else {
                    dsa512Arr[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public static Hashtable configure(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            hashtable2.put(nextElement, hashtable.get(nextElement));
        }
        return hashtable2;
    }

    public final int configure(DSASigner.dsaSha3_224 dsasha3_224) {
        int length = dsasha3_224.configure.length;
        DSASigner.dsa512[] dsa512Arr = new DSASigner.dsa512[length];
        System.arraycopy(dsasha3_224.configure, 0, dsa512Arr, 0, length);
        int i = 0;
        for (int i2 = 0; i2 != length; i2++) {
            if (dsa512Arr[i2].configure()) {
                DSASigner.dsaSha3_256[] Cardinal = dsa512Arr[i2].Cardinal();
                for (int i3 = 0; i3 != Cardinal.length; i3++) {
                    i = (i ^ Cardinal[i3].configure.hashCode()) ^ DSASigner.noneDSA.configure(DSASigner.noneDSA.init(Cardinal[i3].getInstance)).hashCode();
                }
            } else {
                i = (i ^ dsa512Arr[i2].init().configure.hashCode()) ^ DSASigner.noneDSA.configure(DSASigner.noneDSA.init(dsa512Arr[i2].init().getInstance)).hashCode();
            }
        }
        return i;
    }

    public final boolean Cardinal(DSASigner.dsaSha3_224 dsasha3_224, DSASigner.dsaSha3_224 dsasha3_2242) {
        int length = dsasha3_224.configure.length;
        DSASigner.dsa512[] dsa512Arr = new DSASigner.dsa512[length];
        System.arraycopy(dsasha3_224.configure, 0, dsa512Arr, 0, length);
        int length2 = dsasha3_2242.configure.length;
        DSASigner.dsa512[] dsa512Arr2 = new DSASigner.dsa512[length2];
        System.arraycopy(dsasha3_2242.configure, 0, dsa512Arr2, 0, length2);
        if (length != length2) {
            return false;
        }
        boolean z = (dsa512Arr[0].init() == null || dsa512Arr2[0].init() == null) ? false : !dsa512Arr[0].init().configure.equals(dsa512Arr2[0].init().configure);
        for (int i = 0; i != length; i++) {
            if (!m1766a(z, dsa512Arr[i], dsa512Arr2)) {
                return false;
            }
        }
        return true;
    }
}
