package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzkj implements zzko {
    private final byte[] zzapk = new byte[8];
    private final Stack<zzkl> zzapl = new Stack<>();
    private final zzkt zzapm = new zzkt();
    private zzkn zzapn;
    private int zzapo;
    private int zzapp;
    private long zzapq;

    zzkj() {
    }

    public final void zza(zzkn zzkn) {
        this.zzapn = zzkn;
    }

    public final void reset() {
        this.zzapo = 0;
        this.zzapl.clear();
        this.zzapm.reset();
    }

    public final boolean zzb(zzjz zzjz) throws IOException, InterruptedException {
        String str;
        double d;
        int zzar;
        int zza;
        zzpg.checkState(this.zzapn != null);
        while (true) {
            if (this.zzapl.isEmpty() || zzjz.getPosition() < this.zzapl.peek().zzapt) {
                if (this.zzapo == 0) {
                    long zza2 = this.zzapm.zza(zzjz, true, false, 4);
                    if (zza2 == -2) {
                        zzjz.zzgu();
                        while (true) {
                            zzjz.zza(this.zzapk, 0, 4);
                            zzar = zzkt.zzar(this.zzapk[0]);
                            if (zzar != -1 && zzar <= 4) {
                                zza = (int) zzkt.zza(this.zzapk, zzar, false);
                                if (this.zzapn.zzap(zza)) {
                                    break;
                                }
                            }
                            zzjz.zzaj(1);
                        }
                        zzjz.zzaj(zzar);
                        zza2 = (long) zza;
                    }
                    if (zza2 == -1) {
                        return false;
                    }
                    this.zzapp = (int) zza2;
                    this.zzapo = 1;
                }
                if (this.zzapo == 1) {
                    this.zzapq = this.zzapm.zza(zzjz, false, true, 8);
                    this.zzapo = 2;
                }
                int zzao = this.zzapn.zzao(this.zzapp);
                if (zzao == 0) {
                    zzjz.zzaj((int) this.zzapq);
                    this.zzapo = 0;
                } else if (zzao == 1) {
                    long position = zzjz.getPosition();
                    this.zzapl.add(new zzkl(this.zzapp, this.zzapq + position));
                    this.zzapn.zzd(this.zzapp, position, this.zzapq);
                    this.zzapo = 0;
                    return true;
                } else if (zzao == 2) {
                    long j = this.zzapq;
                    if (j <= 8) {
                        this.zzapn.zzd(this.zzapp, zza(zzjz, (int) j));
                        this.zzapo = 0;
                        return true;
                    }
                    long j2 = this.zzapq;
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j2);
                    throw new zzhw(sb.toString());
                } else if (zzao == 3) {
                    long j3 = this.zzapq;
                    if (j3 <= 2147483647L) {
                        zzkn zzkn = this.zzapn;
                        int i = this.zzapp;
                        int i2 = (int) j3;
                        if (i2 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i2];
                            zzjz.readFully(bArr, 0, i2);
                            str = new String(bArr);
                        }
                        zzkn.zza(i, str);
                        this.zzapo = 0;
                        return true;
                    }
                    long j4 = this.zzapq;
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j4);
                    throw new zzhw(sb2.toString());
                } else if (zzao == 4) {
                    this.zzapn.zza(this.zzapp, (int) this.zzapq, zzjz);
                    this.zzapo = 0;
                    return true;
                } else if (zzao == 5) {
                    long j5 = this.zzapq;
                    if (j5 == 4 || j5 == 8) {
                        zzkn zzkn2 = this.zzapn;
                        int i3 = this.zzapp;
                        int i4 = (int) this.zzapq;
                        long zza3 = zza(zzjz, i4);
                        if (i4 == 4) {
                            d = (double) Float.intBitsToFloat((int) zza3);
                        } else {
                            d = Double.longBitsToDouble(zza3);
                        }
                        zzkn2.zza(i3, d);
                        this.zzapo = 0;
                        return true;
                    }
                    long j6 = this.zzapq;
                    StringBuilder sb3 = new StringBuilder(40);
                    sb3.append("Invalid float size: ");
                    sb3.append(j6);
                    throw new zzhw(sb3.toString());
                } else {
                    StringBuilder sb4 = new StringBuilder(32);
                    sb4.append("Invalid element type ");
                    sb4.append(zzao);
                    throw new zzhw(sb4.toString());
                }
            } else {
                this.zzapn.zzaq(this.zzapl.pop().zzapp);
                return true;
            }
        }
    }

    private final long zza(zzjz zzjz, int i) throws IOException, InterruptedException {
        zzjz.readFully(this.zzapk, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zzapk[i2] & 255));
        }
        return j;
    }
}
