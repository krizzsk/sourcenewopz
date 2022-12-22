package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
abstract class zzdyl extends zzdxn<String> {
    private int limit;
    private int offset = 0;
    private final zzdxr zzhzb;
    private final boolean zzhzc;
    final CharSequence zzhzg;

    protected zzdyl(zzdyh zzdyh, CharSequence charSequence) {
        this.zzhzb = zzdyh.zzhzb;
        this.zzhzc = false;
        this.limit = zzdyh.limit;
        this.zzhzg = charSequence;
    }

    /* access modifiers changed from: package-private */
    public abstract int zzev(int i);

    /* access modifiers changed from: package-private */
    public abstract int zzew(int i);

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzazz() {
        int i;
        int i2 = this.offset;
        while (true) {
            int i3 = this.offset;
            if (i3 != -1) {
                int zzev = zzev(i3);
                if (zzev == -1) {
                    zzev = this.zzhzg.length();
                    this.offset = -1;
                } else {
                    this.offset = zzew(zzev);
                }
                int i4 = this.offset;
                if (i4 == i2) {
                    int i5 = i4 + 1;
                    this.offset = i5;
                    if (i5 > this.zzhzg.length()) {
                        this.offset = -1;
                    }
                } else {
                    while (i2 < zzev && this.zzhzb.zzc(this.zzhzg.charAt(i2))) {
                        i2++;
                    }
                    while (i > i2 && this.zzhzb.zzc(this.zzhzg.charAt(i - 1))) {
                        zzev = i - 1;
                    }
                    int i6 = this.limit;
                    if (i6 == 1) {
                        i = this.zzhzg.length();
                        this.offset = -1;
                        while (i > i2 && this.zzhzb.zzc(this.zzhzg.charAt(i - 1))) {
                            i--;
                        }
                    } else {
                        this.limit = i6 - 1;
                    }
                    return this.zzhzg.subSequence(i2, i).toString();
                }
            } else {
                zzbaa();
                return null;
            }
        }
    }
}
