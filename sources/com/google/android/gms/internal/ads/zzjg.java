package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzjg {
    private final int zzahz;
    private float zzail = 1.0f;
    private float zzaim = 1.0f;
    private final int zzanh;
    private final int zzani;
    private final int zzanj;
    private final int zzank;
    private final short[] zzanl;
    private int zzanm;
    private short[] zzann;
    private int zzano;
    private short[] zzanp;
    private int zzanq;
    private short[] zzanr;
    private int zzans = 0;
    private int zzant = 0;
    private int zzanu;
    private int zzanv;
    private int zzanw;
    private int zzanx;
    private int zzany = 0;
    private int zzanz;
    private int zzaoa;
    private int zzaob;

    public zzjg(int i, int i2) {
        this.zzahz = i;
        this.zzanh = i2;
        this.zzani = i / 400;
        int i3 = i / 65;
        this.zzanj = i3;
        int i4 = i3 * 2;
        this.zzank = i4;
        this.zzanl = new short[i4];
        this.zzanm = i4;
        this.zzann = new short[(i4 * i2)];
        this.zzano = i4;
        this.zzanp = new short[(i4 * i2)];
        this.zzanq = i4;
        this.zzanr = new short[(i4 * i2)];
    }

    public final void setSpeed(float f) {
        this.zzail = f;
    }

    public final void zza(float f) {
        this.zzaim = f;
    }

    public final void zza(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.zzanh;
        int i2 = remaining / i;
        zzac(i2);
        shortBuffer.get(this.zzann, this.zzanu * this.zzanh, ((i * i2) << 1) / 2);
        this.zzanu += i2;
        zzgk();
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzanh, this.zzanv);
        shortBuffer.put(this.zzanp, 0, this.zzanh * min);
        int i = this.zzanv - min;
        this.zzanv = i;
        short[] sArr = this.zzanp;
        int i2 = this.zzanh;
        System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
    }

    public final void zzfp() {
        int i;
        int i2 = this.zzanu;
        float f = this.zzail;
        float f2 = this.zzaim;
        int i3 = this.zzanv + ((int) ((((((float) i2) / (f / f2)) + ((float) this.zzanw)) / f2) + 0.5f));
        zzac((this.zzank * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.zzank;
            int i5 = this.zzanh;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.zzann[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.zzanu += i * 2;
        zzgk();
        if (this.zzanv > i3) {
            this.zzanv = i3;
        }
        this.zzanu = 0;
        this.zzanx = 0;
        this.zzanw = 0;
    }

    public final int zzgj() {
        return this.zzanv;
    }

    private final void zzab(int i) {
        int i2 = this.zzanv + i;
        int i3 = this.zzano;
        if (i2 > i3) {
            int i4 = i3 + (i3 / 2) + i;
            this.zzano = i4;
            this.zzanp = Arrays.copyOf(this.zzanp, i4 * this.zzanh);
        }
    }

    private final void zzac(int i) {
        int i2 = this.zzanu + i;
        int i3 = this.zzanm;
        if (i2 > i3) {
            int i4 = i3 + (i3 / 2) + i;
            this.zzanm = i4;
            this.zzann = Arrays.copyOf(this.zzann, i4 * this.zzanh);
        }
    }

    private final void zza(short[] sArr, int i, int i2) {
        zzab(i2);
        int i3 = this.zzanh;
        System.arraycopy(sArr, i * i3, this.zzanp, this.zzanv * i3, i3 * i2);
        this.zzanv += i2;
    }

    private final void zzb(short[] sArr, int i, int i2) {
        int i3 = this.zzank / i2;
        int i4 = this.zzanh;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.zzanl[i7] = (short) (i8 / i5);
        }
    }

    private final int zza(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.zzanh;
        int i5 = 1;
        int i6 = 255;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i7 < i5 * i2) {
                i7 = i2;
                i5 = i9;
            }
            if (i9 * i6 > i8 * i2) {
                i6 = i2;
                i8 = i9;
            }
            i2++;
        }
        this.zzaoa = i5 / i7;
        this.zzaob = i8 / i6;
        return i7;
    }

    private final void zzgk() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.zzanv;
        float f = this.zzail / this.zzaim;
        double d = (double) f;
        int i8 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i9 = this.zzanu;
            if (i9 >= this.zzank) {
                int i10 = 0;
                while (true) {
                    int i11 = this.zzanx;
                    if (i11 > 0) {
                        int min = Math.min(this.zzank, i11);
                        zza(this.zzann, i10, min);
                        this.zzanx -= min;
                        i10 += min;
                    } else {
                        short[] sArr = this.zzann;
                        int i12 = this.zzahz;
                        int i13 = i12 > 4000 ? i12 / 4000 : 1;
                        if (this.zzanh == i8 && i13 == i8) {
                            i4 = zza(sArr, i10, this.zzani, this.zzanj);
                        } else {
                            zzb(sArr, i10, i13);
                            int zza = zza(this.zzanl, 0, this.zzani / i13, this.zzanj / i13);
                            if (i13 != i8) {
                                int i14 = zza * i13;
                                int i15 = i13 << 2;
                                int i16 = i14 - i15;
                                int i17 = i14 + i15;
                                int i18 = this.zzani;
                                if (i16 < i18) {
                                    i16 = i18;
                                }
                                int i19 = this.zzanj;
                                if (i17 > i19) {
                                    i17 = i19;
                                }
                                if (this.zzanh == i8) {
                                    i4 = zza(sArr, i10, i16, i17);
                                } else {
                                    zzb(sArr, i10, i8);
                                    i4 = zza(this.zzanl, 0, i16, i17);
                                }
                            } else {
                                i4 = zza;
                            }
                        }
                        int i20 = this.zzaoa;
                        int i21 = i20 != 0 && this.zzany != 0 && this.zzaob <= i20 * 3 && (i20 << 1) > this.zzanz * 3 ? this.zzany : i4;
                        this.zzanz = this.zzaoa;
                        this.zzany = i4;
                        if (d > 1.0d) {
                            short[] sArr2 = this.zzann;
                            if (f >= 2.0f) {
                                i6 = (int) (((float) i21) / (f - 1.0f));
                            } else {
                                this.zzanx = (int) ((((float) i21) * (2.0f - f)) / (f - 1.0f));
                                i6 = i21;
                            }
                            zzab(i6);
                            int i22 = i6;
                            zza(i6, this.zzanh, this.zzanp, this.zzanv, sArr2, i10, sArr2, i10 + i21);
                            this.zzanv += i22;
                            i10 += i21 + i22;
                        } else {
                            int i23 = i21;
                            short[] sArr3 = this.zzann;
                            if (f < 0.5f) {
                                i5 = (int) ((((float) i23) * f) / (1.0f - f));
                            } else {
                                this.zzanx = (int) ((((float) i23) * ((2.0f * f) - 1.0f)) / (1.0f - f));
                                i5 = i23;
                            }
                            int i24 = i23 + i5;
                            zzab(i24);
                            int i25 = this.zzanh;
                            System.arraycopy(sArr3, i10 * i25, this.zzanp, this.zzanv * i25, i25 * i23);
                            zza(i5, this.zzanh, this.zzanp, this.zzanv + i23, sArr3, i23 + i10, sArr3, i10);
                            this.zzanv += i24;
                            i10 += i5;
                        }
                    }
                    if (this.zzank + i10 > i9) {
                        break;
                    }
                    i8 = 1;
                }
                int i26 = this.zzanu - i10;
                short[] sArr4 = this.zzann;
                int i27 = this.zzanh;
                System.arraycopy(sArr4, i10 * i27, sArr4, 0, i27 * i26);
                this.zzanu = i26;
            }
        } else {
            zza(this.zzann, 0, this.zzanu);
            this.zzanu = 0;
        }
        float f2 = this.zzaim;
        if (f2 != 1.0f && this.zzanv != i7) {
            int i28 = this.zzahz;
            int i29 = (int) (((float) i28) / f2);
            while (true) {
                if (i29 <= 16384 && i28 <= 16384) {
                    break;
                }
                i29 /= 2;
                i28 /= 2;
            }
            int i30 = this.zzanv - i7;
            int i31 = this.zzanw + i30;
            int i32 = this.zzanq;
            if (i31 > i32) {
                int i33 = i32 + (i32 / 2) + i30;
                this.zzanq = i33;
                this.zzanr = Arrays.copyOf(this.zzanr, i33 * this.zzanh);
            }
            short[] sArr5 = this.zzanp;
            int i34 = this.zzanh;
            System.arraycopy(sArr5, i7 * i34, this.zzanr, this.zzanw * i34, i34 * i30);
            this.zzanv = i7;
            this.zzanw += i30;
            int i35 = 0;
            while (true) {
                i = this.zzanw;
                if (i35 >= i - 1) {
                    break;
                }
                while (true) {
                    i2 = this.zzans;
                    int i36 = (i2 + 1) * i29;
                    i3 = this.zzant;
                    if (i36 <= i3 * i28) {
                        break;
                    }
                    zzab(1);
                    int i37 = 0;
                    while (true) {
                        int i38 = this.zzanh;
                        if (i37 >= i38) {
                            break;
                        }
                        short[] sArr6 = this.zzanr;
                        int i39 = (i35 * i38) + i37;
                        short s = sArr6[i39];
                        short s2 = sArr6[i39 + i38];
                        int i40 = this.zzans;
                        int i41 = i40 * i29;
                        int i42 = (i40 + 1) * i29;
                        int i43 = i42 - (this.zzant * i28);
                        int i44 = i42 - i41;
                        this.zzanp[(this.zzanv * i38) + i37] = (short) (((s * i43) + ((i44 - i43) * s2)) / i44);
                        i37++;
                    }
                    this.zzant++;
                    this.zzanv++;
                }
                int i45 = i2 + 1;
                this.zzans = i45;
                if (i45 == i28) {
                    this.zzans = 0;
                    zzpg.checkState(i3 == i29);
                    this.zzant = 0;
                }
                i35++;
            }
            int i46 = i - 1;
            if (i46 != 0) {
                short[] sArr7 = this.zzanr;
                int i47 = this.zzanh;
                System.arraycopy(sArr7, i46 * i47, sArr7, 0, (i - i46) * i47);
                this.zzanw -= i46;
            }
        }
    }

    private static void zza(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }
}
