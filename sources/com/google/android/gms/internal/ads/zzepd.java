package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzepd implements zzeol {
    private final int flags;
    private final String info;
    private final Object[] zzivv;
    private final zzeon zzivy;

    zzepd(zzeon zzeon, String str, Object[] objArr) {
        this.zzivy = zzeon;
        this.info = str;
        this.zzivv = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzblf() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzblg() {
        return this.zzivv;
    }

    public final zzeon zzbkz() {
        return this.zzivy;
    }

    public final int zzbkx() {
        return (this.flags & 1) == 1 ? zzeoy.zziwn : zzeoy.zziwo;
    }

    public final boolean zzbky() {
        return (this.flags & 2) == 2;
    }
}
