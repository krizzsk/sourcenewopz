package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzng implements zznb, zznc {
    private zznu zzafn;
    private zznb zzbei;
    public final zznc[] zzbfp;
    private final IdentityHashMap<zznn, Integer> zzbfq = new IdentityHashMap<>();
    private int zzbfr;
    private zznc[] zzbfs;
    private zznq zzbft;

    public zzng(zznc... zzncArr) {
        this.zzbfp = zzncArr;
    }

    public final void zza(zznb zznb, long j) {
        this.zzbei = zznb;
        zznc[] zzncArr = this.zzbfp;
        this.zzbfr = zzncArr.length;
        for (zznc zza : zzncArr) {
            zza.zza(this, j);
        }
    }

    public final void zzhs() throws IOException {
        for (zznc zzhs : this.zzbfp) {
            zzhs.zzhs();
        }
    }

    public final zznu zzht() {
        return this.zzafn;
    }

    public final long zza(zzog[] zzogArr, boolean[] zArr, zznn[] zznnArr, boolean[] zArr2, long j) {
        int i;
        zzog[] zzogArr2 = zzogArr;
        zznn[] zznnArr2 = zznnArr;
        int[] iArr = new int[zzogArr2.length];
        int[] iArr2 = new int[zzogArr2.length];
        for (int i2 = 0; i2 < zzogArr2.length; i2++) {
            if (zznnArr2[i2] == null) {
                i = -1;
            } else {
                i = this.zzbfq.get(zznnArr2[i2]).intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            if (zzogArr2[i2] != null) {
                zznr zzip = zzogArr2[i2].zzip();
                int i3 = 0;
                while (true) {
                    zznc[] zzncArr = this.zzbfp;
                    if (i3 >= zzncArr.length) {
                        break;
                    } else if (zzncArr[i3].zzht().zza(zzip) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this.zzbfq.clear();
        int length = zzogArr2.length;
        zznn[] zznnArr3 = new zznn[length];
        zznn[] zznnArr4 = new zznn[zzogArr2.length];
        zzog[] zzogArr3 = new zzog[zzogArr2.length];
        ArrayList arrayList = new ArrayList(this.zzbfp.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.zzbfp.length) {
            for (int i5 = 0; i5 < zzogArr2.length; i5++) {
                zzog zzog = null;
                zznnArr4[i5] = iArr[i5] == i4 ? zznnArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    zzog = zzogArr2[i5];
                }
                zzogArr3[i5] = zzog;
            }
            int i6 = i4;
            zzog[] zzogArr4 = zzogArr3;
            ArrayList arrayList2 = arrayList;
            long zza = this.zzbfp[i4].zza(zzogArr3, zArr, zznnArr4, zArr2, j2);
            if (i6 == 0) {
                j2 = zza;
            } else if (zza != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i7 = 0; i7 < zzogArr2.length; i7++) {
                boolean z2 = true;
                if (iArr2[i7] == i6) {
                    zzpg.checkState(zznnArr4[i7] != null);
                    zznnArr3[i7] = zznnArr4[i7];
                    this.zzbfq.put(zznnArr4[i7], Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i7] == i6) {
                    if (zznnArr4[i7] != null) {
                        z2 = false;
                    }
                    zzpg.checkState(z2);
                }
            }
            if (z) {
                arrayList2.add(this.zzbfp[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            zzogArr3 = zzogArr4;
            zznnArr2 = zznnArr;
        }
        zznn[] zznnArr5 = zznnArr2;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zznnArr3, 0, zznnArr5, 0, length);
        zznc[] zzncArr2 = new zznc[arrayList3.size()];
        this.zzbfs = zzncArr2;
        arrayList3.toArray(zzncArr2);
        this.zzbft = new zzmp(this.zzbfs);
        return j2;
    }

    public final void zzef(long j) {
        for (zznc zzef : this.zzbfs) {
            zzef.zzef(j);
        }
    }

    public final boolean zzee(long j) {
        return this.zzbft.zzee(j);
    }

    public final long zzhr() {
        return this.zzbft.zzhr();
    }

    public final long zzhu() {
        long zzhu = this.zzbfp[0].zzhu();
        int i = 1;
        while (true) {
            zznc[] zzncArr = this.zzbfp;
            if (i >= zzncArr.length) {
                if (zzhu != -9223372036854775807L) {
                    zznc[] zzncArr2 = this.zzbfs;
                    int length = zzncArr2.length;
                    int i2 = 0;
                    while (i2 < length) {
                        zznc zznc = zzncArr2[i2];
                        if (zznc == this.zzbfp[0] || zznc.zzeg(zzhu) == zzhu) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzhu;
            } else if (zzncArr[i].zzhu() == -9223372036854775807L) {
                i++;
            } else {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
    }

    public final long zzhv() {
        long j = Long.MAX_VALUE;
        for (zznc zzhv : this.zzbfs) {
            long zzhv2 = zzhv.zzhv();
            if (zzhv2 != Long.MIN_VALUE) {
                j = Math.min(j, zzhv2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final long zzeg(long j) {
        long zzeg = this.zzbfs[0].zzeg(j);
        int i = 1;
        while (true) {
            zznc[] zzncArr = this.zzbfs;
            if (i >= zzncArr.length) {
                return zzeg;
            }
            if (zzncArr[i].zzeg(zzeg) == zzeg) {
                i++;
            } else {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
    }

    public final void zza(zznc zznc) {
        int i = this.zzbfr - 1;
        this.zzbfr = i;
        if (i <= 0) {
            int i2 = 0;
            for (zznc zzht : this.zzbfp) {
                i2 += zzht.zzht().length;
            }
            zznr[] zznrArr = new zznr[i2];
            int i3 = 0;
            for (zznc zzht2 : this.zzbfp) {
                zznu zzht3 = zzht2.zzht();
                int i4 = zzht3.length;
                int i5 = 0;
                while (i5 < i4) {
                    zznrArr[i3] = zzht3.zzbf(i5);
                    i5++;
                    i3++;
                }
            }
            this.zzafn = new zznu(zznrArr);
            this.zzbei.zza(this);
        }
    }

    public final /* synthetic */ void zza(zznq zznq) {
        if (this.zzafn != null) {
            this.zzbei.zza(this);
        }
    }
}
