package com.google.android.gms.internal.measurement;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
public enum zzep implements zzkf {
    UNKNOWN_COMPARISON_TYPE(0),
    LESS_THAN(1),
    GREATER_THAN(2),
    EQUAL(3),
    BETWEEN(4);
    
    private static final zzkg<zzep> zzf = null;
    private final int zzg;

    static {
        zzf = new zzen();
    }

    private zzep(int i) {
        this.zzg = i;
    }

    public static zzep zza(int i) {
        if (i == 0) {
            return UNKNOWN_COMPARISON_TYPE;
        }
        if (i == 1) {
            return LESS_THAN;
        }
        if (i == 2) {
            return GREATER_THAN;
        }
        if (i == 3) {
            return EQUAL;
        }
        if (i != 4) {
            return null;
        }
        return BETWEEN;
    }

    public static zzkh zzb() {
        return zzeo.zza;
    }

    public final String toString() {
        return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
    }
}
