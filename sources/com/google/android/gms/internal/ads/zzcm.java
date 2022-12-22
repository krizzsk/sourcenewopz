package com.google.android.gms.internal.ads;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public enum zzcm implements zzenf {
    UNKNOWN_ENCRYPTION_METHOD(0),
    BITSLICER(1),
    TINK_HYBRID(2),
    UNENCRYPTED(3),
    DG(4),
    DG_XTEA(5);
    
    private static final zzene<zzcm> zzes = null;
    private final int value;

    public final int zzv() {
        return this.value;
    }

    public static zzcm zzm(int i) {
        if (i == 0) {
            return UNKNOWN_ENCRYPTION_METHOD;
        }
        if (i == 1) {
            return BITSLICER;
        }
        if (i == 2) {
            return TINK_HYBRID;
        }
        if (i == 3) {
            return UNENCRYPTED;
        }
        if (i == 4) {
            return DG;
        }
        if (i != 5) {
            return null;
        }
        return DG_XTEA;
    }

    public static zzenh zzw() {
        return zzcn.zzeu;
    }

    public final String toString() {
        return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    private zzcm(int i) {
        this.value = i;
    }

    static {
        zzes = new zzco();
    }
}
