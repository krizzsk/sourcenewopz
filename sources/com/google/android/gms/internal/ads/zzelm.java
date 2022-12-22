package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzelm {
    static int zza(byte[] bArr, int i, zzell zzell) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zzell);
        }
        zzell.zziov = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzell zzell) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzell.zziov = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzell.zziov = i5 | (b2 << Ascii.f53594SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << Ascii.f53594SO);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzell.zziov = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << Ascii.NAK);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzell.zziov = i9 | (b4 << Ascii.f53587FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << Ascii.f53587FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzell.zziov = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzell zzell) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzell.zziow = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzell.zziow = j2;
        return i3;
    }

    static int zzh(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static long zzi(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzj(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzi(bArr, i));
    }

    static float zzk(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzh(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzell zzell) throws zzenn {
        int zza = zza(bArr, i, zzell);
        int i2 = zzell.zziov;
        if (i2 < 0) {
            throw zzenn.zzbka();
        } else if (i2 == 0) {
            zzell.zziox = "";
            return zza;
        } else {
            zzell.zziox = new String(bArr, zza, i2, zzenc.UTF_8);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzell zzell) throws zzenn {
        int zza = zza(bArr, i, zzell);
        int i2 = zzell.zziov;
        if (i2 < 0) {
            throw zzenn.zzbka();
        } else if (i2 == 0) {
            zzell.zziox = "";
            return zza;
        } else {
            zzell.zziox = zzeqj.zzo(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzell zzell) throws zzenn {
        int zza = zza(bArr, i, zzell);
        int i2 = zzell.zziov;
        if (i2 < 0) {
            throw zzenn.zzbka();
        } else if (i2 > bArr.length - zza) {
            throw zzenn.zzbjz();
        } else if (i2 == 0) {
            zzell.zziox = zzelq.zzipc;
            return zza;
        } else {
            zzell.zziox = zzelq.zzi(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zza(com.google.android.gms.internal.ads.zzepi r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.ads.zzell r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zza((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.ads.zzell) r10)
            int r8 = r10.zziov
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zza(r1, r2, r3, r4, r5)
            r6.zzak(r9)
            r10.zziox = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.ads.zzenn r6 = com.google.android.gms.internal.ads.zzenn.zzbjz()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzelm.zza(com.google.android.gms.internal.ads.zzepi, byte[], int, int, com.google.android.gms.internal.ads.zzell):int");
    }

    static int zza(zzepi zzepi, byte[] bArr, int i, int i2, int i3, zzell zzell) throws IOException {
        zzeor zzeor = (zzeor) zzepi;
        Object newInstance = zzeor.newInstance();
        int zza = zzeor.zza(newInstance, bArr, i, i2, i3, zzell);
        zzeor.zzak(newInstance);
        zzell.zziox = newInstance;
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzenk<?> zzenk, zzell zzell) {
        zzend zzend = (zzend) zzenk;
        int zza = zza(bArr, i2, zzell);
        zzend.zzhp(zzell.zziov);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzell);
            if (i != zzell.zziov) {
                break;
            }
            zza = zza(bArr, zza2, zzell);
            zzend.zzhp(zzell.zziov);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzenk<?> zzenk, zzell zzell) throws IOException {
        zzend zzend = (zzend) zzenk;
        int zza = zza(bArr, i, zzell);
        int i2 = zzell.zziov + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzell);
            zzend.zzhp(zzell.zziov);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzenn.zzbjz();
    }

    static int zza(zzepi<?> zzepi, int i, byte[] bArr, int i2, int i3, zzenk<?> zzenk, zzell zzell) throws IOException {
        int zza = zza((zzepi) zzepi, bArr, i2, i3, zzell);
        zzenk.add(zzell.zziox);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzell);
            if (i != zzell.zziov) {
                break;
            }
            zza = zza((zzepi) zzepi, bArr, zza2, i3, zzell);
            zzenk.add(zzell.zziox);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzeqd zzeqd, zzell zzell) throws zzenn {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzell);
                zzeqd.zzd(i, Long.valueOf(zzell.zziow));
                return zzb;
            } else if (i4 == 1) {
                zzeqd.zzd(i, Long.valueOf(zzi(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzell);
                int i5 = zzell.zziov;
                if (i5 < 0) {
                    throw zzenn.zzbka();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzeqd.zzd(i, zzelq.zzipc);
                    } else {
                        zzeqd.zzd(i, zzelq.zzi(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzenn.zzbjz();
                }
            } else if (i4 == 3) {
                zzeqd zzblz = zzeqd.zzblz();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzell);
                    int i8 = zzell.zziov;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzblz, zzell);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzenn.zzbkg();
                }
                zzeqd.zzd(i, zzblz);
                return i2;
            } else if (i4 == 5) {
                zzeqd.zzd(i, Integer.valueOf(zzh(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzenn.zzbkc();
            }
        } else {
            throw zzenn.zzbkc();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzell zzell) throws zzenn {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzell);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzell) + zzell.zziov;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzell);
                    i6 = zzell.zziov;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzell);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzenn.zzbkg();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzenn.zzbkc();
            }
        } else {
            throw zzenn.zzbkc();
        }
    }
}
