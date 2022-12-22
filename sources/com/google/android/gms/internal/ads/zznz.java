package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zznz {
    public final int viewportHeight;
    public final int viewportWidth;
    private final String zzbhk;
    private final String zzbhl;
    private final boolean zzbhm;
    private final boolean zzbhn;
    public final int zzbho;
    public final int zzbhp;
    public final int zzbhq;
    public final boolean zzbhr;
    public final boolean zzbhs;
    public final boolean zzbht;

    public zznz() {
        this((String) null, (String) null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
    }

    private zznz(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, int i4, int i5, boolean z5) {
        this.zzbhk = null;
        this.zzbhl = null;
        this.zzbhm = false;
        this.zzbhn = true;
        this.zzbho = Integer.MAX_VALUE;
        this.zzbhp = Integer.MAX_VALUE;
        this.zzbhq = Integer.MAX_VALUE;
        this.zzbhr = true;
        this.zzbhs = true;
        this.viewportWidth = Integer.MAX_VALUE;
        this.viewportHeight = Integer.MAX_VALUE;
        this.zzbht = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznz zznz = (zznz) obj;
            return this.zzbhn == zznz.zzbhn && this.zzbho == zznz.zzbho && this.zzbhp == zznz.zzbhp && this.zzbhr == zznz.zzbhr && this.zzbhs == zznz.zzbhs && this.zzbht == zznz.zzbht && this.viewportWidth == zznz.viewportWidth && this.viewportHeight == zznz.viewportHeight && this.zzbhq == zznz.zzbhq && TextUtils.equals((CharSequence) null, (CharSequence) null) && TextUtils.equals((CharSequence) null, (CharSequence) null);
        }
    }

    public final int hashCode() {
        String str = null;
        return (((((((((((((((((((str.hashCode() * 31) + str.hashCode()) * 31 * 31) + (this.zzbhn ? 1 : 0)) * 31) + this.zzbho) * 31) + this.zzbhp) * 31) + this.zzbhq) * 31) + (this.zzbhr ? 1 : 0)) * 31) + (this.zzbhs ? 1 : 0)) * 31) + (this.zzbht ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
    }
}
