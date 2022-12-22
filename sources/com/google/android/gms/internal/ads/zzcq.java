package com.google.android.gms.internal.ads;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public enum zzcq implements zzenf {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(1000);
    
    private static final zzene<zzcq> zzes = null;
    private final int value;

    public final int zzv() {
        return this.value;
    }

    public static zzcq zzn(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i == 2) {
            return ENUM_FAILURE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    public static zzenh zzw() {
        return zzcs.zzeu;
    }

    public final String toString() {
        return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    private zzcq(int i) {
        this.value = i;
    }

    static {
        zzes = new zzcp();
    }
}
