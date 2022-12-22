package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public abstract class zzemk extends zzeln {
    private static final Logger logger = Logger.getLogger(zzemk.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zziqf = zzeqg.zzbmb();
    zzemm zziqg;

    public static int zzbx(boolean z) {
        return 1;
    }

    public static int zzd(double d) {
        return 8;
    }

    public static int zzfm(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzfo(long j) {
        return 8;
    }

    public static int zzfp(long j) {
        return 8;
    }

    private static long zzfq(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzg(float f) {
        return 4;
    }

    public static int zzhf(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzhh(int i) {
        return 4;
    }

    public static int zzhi(int i) {
        return 4;
    }

    private static int zzhk(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static zzemk zzv(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public abstract void writeTag(int i, int i2) throws IOException;

    public abstract void zza(int i, zzelq zzelq) throws IOException;

    public abstract void zza(int i, zzeon zzeon) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzeon zzeon, zzepi zzepi) throws IOException;

    public abstract void zzae(int i, int i2) throws IOException;

    public abstract void zzaf(int i, int i2) throws IOException;

    public abstract void zzah(int i, int i2) throws IOException;

    public abstract void zzai(zzelq zzelq) throws IOException;

    public abstract void zzb(int i, zzelq zzelq) throws IOException;

    public abstract int zzbir();

    public abstract void zzd(byte b) throws IOException;

    public abstract void zzfi(long j) throws IOException;

    public abstract void zzfk(long j) throws IOException;

    public abstract void zzg(zzeon zzeon) throws IOException;

    public abstract void zzgz(int i) throws IOException;

    public abstract void zzh(int i, boolean z) throws IOException;

    public abstract void zzha(int i) throws IOException;

    public abstract void zzhc(int i) throws IOException;

    public abstract void zzi(int i, long j) throws IOException;

    public abstract void zzi(int i, String str) throws IOException;

    public abstract void zzia(String str) throws IOException;

    public abstract void zzk(int i, long j) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzk(byte[] bArr, int i, int i2) throws IOException;

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zza(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemk.zza.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzemk() {
    }

    public final void zzag(int i, int i2) throws IOException {
        zzaf(i, zzhk(i2));
    }

    public final void zzj(int i, long j) throws IOException {
        zzi(i, zzfq(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzah(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(int i, double d) throws IOException {
        zzk(i, Double.doubleToRawLongBits(d));
    }

    public final void zzhb(int i) throws IOException {
        zzha(zzhk(i));
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    private static class zzb extends zzemk {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if ((i2 | 0 | (bArr.length - i2)) >= 0) {
                this.buffer = bArr;
                this.offset = 0;
                this.position = 0;
                this.limit = i2;
            } else {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
        }

        public final void writeTag(int i, int i2) throws IOException {
            zzha((i << 3) | i2);
        }

        public final void zzae(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzgz(i2);
        }

        public final void zzaf(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzha(i2);
        }

        public final void zzah(int i, int i2) throws IOException {
            writeTag(i, 5);
            zzhc(i2);
        }

        public final void zzi(int i, long j) throws IOException {
            writeTag(i, 0);
            zzfi(j);
        }

        public final void zzk(int i, long j) throws IOException {
            writeTag(i, 1);
            zzfk(j);
        }

        public final void zzh(int i, boolean z) throws IOException {
            writeTag(i, 0);
            zzd(z ? (byte) 1 : 0);
        }

        public final void zzi(int i, String str) throws IOException {
            writeTag(i, 2);
            zzia(str);
        }

        public final void zza(int i, zzelq zzelq) throws IOException {
            writeTag(i, 2);
            zzai(zzelq);
        }

        public final void zzai(zzelq zzelq) throws IOException {
            zzha(zzelq.size());
            zzelq.zza((zzeln) this);
        }

        public final void zzk(byte[] bArr, int i, int i2) throws IOException {
            zzha(i2);
            write(bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzeon zzeon, zzepi zzepi) throws IOException {
            writeTag(i, 2);
            zzelg zzelg = (zzelg) zzeon;
            int zzbgz = zzelg.zzbgz();
            if (zzbgz == -1) {
                zzbgz = zzepi.zzau(zzelg);
                zzelg.zzgd(zzbgz);
            }
            zzha(zzbgz);
            zzepi.zza(zzeon, this.zziqg);
        }

        public final void zza(int i, zzeon zzeon) throws IOException {
            writeTag(1, 3);
            zzaf(2, i);
            writeTag(3, 2);
            zzg(zzeon);
            writeTag(1, 4);
        }

        public final void zzb(int i, zzelq zzelq) throws IOException {
            writeTag(1, 3);
            zzaf(2, i);
            zza(3, zzelq);
            writeTag(1, 4);
        }

        public final void zzg(zzeon zzeon) throws IOException {
            zzha(zzeon.zzbjj());
            zzeon.zzb(this);
        }

        public final void zzd(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzgz(int i) throws IOException {
            if (i >= 0) {
                zzha(i);
            } else {
                zzfi((long) i);
            }
        }

        public final void zzha(int i) throws IOException {
            if (!zzemk.zziqf || zzelj.zzbhb() || zzbir() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzeqg.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzeqg.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzeqg.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzeqg.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzeqg.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzeqg.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzeqg.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzeqg.zza(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzeqg.zza(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        public final void zzhc(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i4 = i3 + 1;
                this.position = i4;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzfi(long j) throws IOException {
            if (!zzemk.zziqf || zzbir() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzeqg.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzeqg.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzfk(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                int i2 = i + 1;
                this.position = i2;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i3 = i2 + 1;
                this.position = i3;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i4 = i3 + 1;
                this.position = i4;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i6 = i5 + 1;
                this.position = i6;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i7 = i6 + 1;
                this.position = i7;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i8 = i7 + 1;
                this.position = i8;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zzh(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzia(String str) throws IOException {
            int i = this.position;
            try {
                int zzhf = zzhf(str.length() * 3);
                int zzhf2 = zzhf(str.length());
                if (zzhf2 == zzhf) {
                    int i2 = i + zzhf2;
                    this.position = i2;
                    int zza = zzeqj.zza(str, this.buffer, i2, zzbir());
                    this.position = i;
                    zzha((zza - i) - zzhf2);
                    this.position = zza;
                    return;
                }
                zzha(zzeqj.zzd(str));
                this.position = zzeqj.zza(str, this.buffer, this.position, zzbir());
            } catch (zzeqm e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(e2);
            }
        }

        public final int zzbir() {
            return this.limit - this.position;
        }
    }

    public final void zzfj(long j) throws IOException {
        zzfi(zzfq(j));
    }

    public final void zzf(float f) throws IOException {
        zzhc(Float.floatToRawIntBits(f));
    }

    public final void zzc(double d) throws IOException {
        zzfk(Double.doubleToRawLongBits(d));
    }

    public final void zzbw(boolean z) throws IOException {
        zzd(z ? (byte) 1 : 0);
    }

    public static int zzai(int i, int i2) {
        return zzhf(i << 3) + zzhe(i2);
    }

    public static int zzaj(int i, int i2) {
        return zzhf(i << 3) + zzhf(i2);
    }

    public static int zzak(int i, int i2) {
        return zzhf(i << 3) + zzhf(zzhk(i2));
    }

    public static int zzal(int i, int i2) {
        return zzhf(i << 3) + 4;
    }

    public static int zzam(int i, int i2) {
        return zzhf(i << 3) + 4;
    }

    public static int zzl(int i, long j) {
        return zzhf(i << 3) + zzfm(j);
    }

    public static int zzm(int i, long j) {
        return zzhf(i << 3) + zzfm(j);
    }

    public static int zzn(int i, long j) {
        return zzhf(i << 3) + zzfm(zzfq(j));
    }

    public static int zzo(int i, long j) {
        return zzhf(i << 3) + 8;
    }

    public static int zzp(int i, long j) {
        return zzhf(i << 3) + 8;
    }

    public static int zzb(int i, float f) {
        return zzhf(i << 3) + 4;
    }

    public static int zzc(int i, double d) {
        return zzhf(i << 3) + 8;
    }

    public static int zzi(int i, boolean z) {
        return zzhf(i << 3) + 1;
    }

    public static int zzan(int i, int i2) {
        return zzhf(i << 3) + zzhe(i2);
    }

    public static int zzj(int i, String str) {
        return zzhf(i << 3) + zzib(str);
    }

    public static int zzc(int i, zzelq zzelq) {
        int zzhf = zzhf(i << 3);
        int size = zzelq.size();
        return zzhf + zzhf(size) + size;
    }

    public static int zza(int i, zzens zzens) {
        int zzhf = zzhf(i << 3);
        int zzbjj = zzens.zzbjj();
        return zzhf + zzhf(zzbjj) + zzbjj;
    }

    static int zzb(int i, zzeon zzeon, zzepi zzepi) {
        return zzhf(i << 3) + zza(zzeon, zzepi);
    }

    public static int zzb(int i, zzeon zzeon) {
        return (zzhf(8) << 1) + zzaj(2, i) + zzhf(24) + zzh(zzeon);
    }

    public static int zzd(int i, zzelq zzelq) {
        return (zzhf(8) << 1) + zzaj(2, i) + zzc(3, zzelq);
    }

    public static int zzb(int i, zzens zzens) {
        return (zzhf(8) << 1) + zzaj(2, i) + zza(3, zzens);
    }

    public static int zzhd(int i) {
        return zzhf(i << 3);
    }

    public static int zzhe(int i) {
        if (i >= 0) {
            return zzhf(i);
        }
        return 10;
    }

    public static int zzhg(int i) {
        return zzhf(zzhk(i));
    }

    public static int zzfl(long j) {
        return zzfm(j);
    }

    public static int zzfn(long j) {
        return zzfm(zzfq(j));
    }

    public static int zzhj(int i) {
        return zzhe(i);
    }

    public static int zzib(String str) {
        int i;
        try {
            i = zzeqj.zzd(str);
        } catch (zzeqm unused) {
            i = str.getBytes(zzenc.UTF_8).length;
        }
        return zzhf(i) + i;
    }

    public static int zza(zzens zzens) {
        int zzbjj = zzens.zzbjj();
        return zzhf(zzbjj) + zzbjj;
    }

    public static int zzaj(zzelq zzelq) {
        int size = zzelq.size();
        return zzhf(size) + size;
    }

    public static int zzw(byte[] bArr) {
        int length = bArr.length;
        return zzhf(length) + length;
    }

    public static int zzh(zzeon zzeon) {
        int zzbjj = zzeon.zzbjj();
        return zzhf(zzbjj) + zzbjj;
    }

    static int zza(zzeon zzeon, zzepi zzepi) {
        zzelg zzelg = (zzelg) zzeon;
        int zzbgz = zzelg.zzbgz();
        if (zzbgz == -1) {
            zzbgz = zzepi.zzau(zzelg);
            zzelg.zzgd(zzbgz);
        }
        return zzhf(zzbgz) + zzbgz;
    }

    public final void zzbis() {
        if (zzbir() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzeqm zzeqm) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzeqm);
        byte[] bytes = str.getBytes(zzenc.UTF_8);
        try {
            zzha(bytes.length);
            zzh(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zza(e);
        } catch (zza e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzeon zzeon, zzepi zzepi) {
        int zzhf = zzhf(i << 3) << 1;
        zzelg zzelg = (zzelg) zzeon;
        int zzbgz = zzelg.zzbgz();
        if (zzbgz == -1) {
            zzbgz = zzepi.zzau(zzelg);
            zzelg.zzgd(zzbgz);
        }
        return zzhf + zzbgz;
    }

    @Deprecated
    public static int zzi(zzeon zzeon) {
        return zzeon.zzbjj();
    }

    @Deprecated
    public static int zzhl(int i) {
        return zzhf(i);
    }
}
