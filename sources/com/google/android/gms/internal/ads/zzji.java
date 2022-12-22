package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzji {
    private int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean zzgl() {
        return zzae(Integer.MIN_VALUE);
    }

    public final boolean zzgm() {
        return zzae(4);
    }

    public final boolean zzgn() {
        return zzae(1);
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final void zzad(int i) {
        this.flags |= Integer.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public final boolean zzae(int i) {
        return (this.flags & i) == i;
    }
}
