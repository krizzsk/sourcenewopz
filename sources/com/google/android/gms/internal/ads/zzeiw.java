package com.google.android.gms.internal.ads;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public enum zzeiw implements zzenf {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);
    
    private static final zzene<zzeiw> zzes = null;
    private final int value;

    public final int zzv() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zzeiw zzfz(int i) {
        if (i == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i == 1) {
            return TINK;
        }
        if (i == 2) {
            return LEGACY;
        }
        if (i == 3) {
            return RAW;
        }
        if (i != 4) {
            return null;
        }
        return CRUNCHY;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(IMTextUtils.STREET_IMAGE_TAG_START);
        sb.append(getClass().getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb.append(" number=");
            sb.append(zzv());
        }
        sb.append(" name=");
        sb.append(name());
        sb.append(Typography.greater);
        return sb.toString();
    }

    private zzeiw(int i) {
        this.value = i;
    }

    static {
        zzes = new zzeiy();
    }
}
