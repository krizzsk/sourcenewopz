package com.google.android.gms.internal.ads;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public enum zzgp implements zzenf {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6),
    UNKNOWN(999);
    
    private static final zzene<zzgp> zzes = null;
    private final int value;

    public final int zzv() {
        return this.value;
    }

    public final String toString() {
        return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    private zzgp(int i) {
        this.value = i;
    }

    static {
        zzes = new zzgs();
    }
}
