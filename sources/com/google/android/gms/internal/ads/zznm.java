package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zznm implements zzkh {
    private final zzpn zzaqd = new zzpn(32);
    private final zzol zzbdz;
    private final int zzbgo;
    private final zznk zzbgp = new zznk();
    private final zznj zzbgq = new zznj();
    private final AtomicInteger zzbgr = new AtomicInteger();
    private zznl zzbgs;
    private zznl zzbgt;
    private zzht zzbgu;
    private boolean zzbgv;
    private zzht zzbgw;
    private long zzbgx;
    private int zzbgy;
    private zzno zzbgz;

    public zznm(zzol zzol) {
        this.zzbdz = zzol;
        this.zzbgo = zzol.zzis();
        int i = this.zzbgo;
        this.zzbgy = i;
        zznl zznl = new zznl(0, i);
        this.zzbgs = zznl;
        this.zzbgt = zznl;
    }

    public final void zzl(boolean z) {
        int andSet = this.zzbgr.getAndSet(z ? 0 : 2);
        zzif();
        this.zzbgp.zzig();
        if (andSet == 2) {
            this.zzbgu = null;
        }
    }

    public final int zzih() {
        return this.zzbgp.zzih();
    }

    public final void disable() {
        if (this.zzbgr.getAndSet(2) == 0) {
            zzif();
        }
    }

    public final boolean zzii() {
        return this.zzbgp.zzii();
    }

    public final zzht zzij() {
        return this.zzbgp.zzij();
    }

    public final long zzhz() {
        return this.zzbgp.zzhz();
    }

    public final void zzim() {
        long zzik = this.zzbgp.zzik();
        if (zzik != -1) {
            zzej(zzik);
        }
    }

    public final boolean zze(long j, boolean z) {
        long zzd = this.zzbgp.zzd(j, z);
        if (zzd == -1) {
            return false;
        }
        zzej(zzd);
        return true;
    }

    public final int zza(zzhv zzhv, zzjp zzjp, boolean z, boolean z2, long j) {
        int i;
        zzjp zzjp2 = zzjp;
        int zza = this.zzbgp.zza(zzhv, zzjp, z, z2, this.zzbgu, this.zzbgq);
        if (zza == -5) {
            this.zzbgu = zzhv.zzaij;
            return -5;
        } else if (zza == -4) {
            if (!zzjp.zzgm()) {
                if (zzjp2.zzaov < j) {
                    zzjp2.zzad(Integer.MIN_VALUE);
                }
                if (zzjp.isEncrypted()) {
                    zznj zznj = this.zzbgq;
                    long j2 = zznj.zzaxf;
                    this.zzaqd.reset(1);
                    zza(j2, this.zzaqd.data, 1);
                    long j3 = j2 + 1;
                    byte b = this.zzaqd.data[0];
                    boolean z3 = (b & 128) != 0;
                    byte b2 = b & Byte.MAX_VALUE;
                    if (zzjp2.zzaou.f52602iv == null) {
                        zzjp2.zzaou.f52602iv = new byte[16];
                    }
                    zza(j3, zzjp2.zzaou.f52602iv, (int) b2);
                    long j4 = j3 + ((long) b2);
                    if (z3) {
                        this.zzaqd.reset(2);
                        zza(j4, this.zzaqd.data, 2);
                        j4 += 2;
                        i = this.zzaqd.readUnsignedShort();
                    } else {
                        i = 1;
                    }
                    int[] iArr = zzjp2.zzaou.numBytesOfClearData;
                    if (iArr == null || iArr.length < i) {
                        iArr = new int[i];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = zzjp2.zzaou.numBytesOfEncryptedData;
                    if (iArr3 == null || iArr3.length < i) {
                        iArr3 = new int[i];
                    }
                    int[] iArr4 = iArr3;
                    if (z3) {
                        int i2 = i * 6;
                        this.zzaqd.reset(i2);
                        zza(j4, this.zzaqd.data, i2);
                        j4 += (long) i2;
                        this.zzaqd.zzbl(0);
                        for (int i3 = 0; i3 < i; i3++) {
                            iArr2[i3] = this.zzaqd.readUnsignedShort();
                            iArr4[i3] = this.zzaqd.zzje();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = zznj.size - ((int) (j4 - zznj.zzaxf));
                    }
                    zzkk zzkk = zznj.zzarz;
                    zzjp2.zzaou.set(i, iArr2, iArr4, zzkk.zzaps, zzjp2.zzaou.f52602iv, zzkk.zzapr);
                    int i4 = (int) (j4 - zznj.zzaxf);
                    zznj.zzaxf += (long) i4;
                    zznj.size -= i4;
                }
                zzjp2.zzag(this.zzbgq.size);
                long j5 = this.zzbgq.zzaxf;
                ByteBuffer byteBuffer = zzjp2.zzdr;
                int i5 = this.zzbgq.size;
                zzej(j5);
                while (i5 > 0) {
                    int i6 = (int) (j5 - this.zzbgs.zzbgk);
                    int min = Math.min(i5, this.zzbgo - i6);
                    zzom zzom = this.zzbgs.zzbgm;
                    byteBuffer.put(zzom.data, i6 + 0, min);
                    j5 += (long) min;
                    i5 -= min;
                    if (j5 == this.zzbgs.zzate) {
                        this.zzbdz.zza(zzom);
                        this.zzbgs = this.zzbgs.zzil();
                    }
                }
                zzej(this.zzbgq.zzbfx);
            }
            return -4;
        } else if (zza == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }

    private final void zza(long j, byte[] bArr, int i) {
        zzej(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.zzbgs.zzbgk);
            int min = Math.min(i - i2, this.zzbgo - i3);
            zzom zzom = this.zzbgs.zzbgm;
            System.arraycopy(zzom.data, i3 + 0, bArr, i2, min);
            j += (long) min;
            i2 += min;
            if (j == this.zzbgs.zzate) {
                this.zzbdz.zza(zzom);
                this.zzbgs = this.zzbgs.zzil();
            }
        }
    }

    private final void zzej(long j) {
        while (j >= this.zzbgs.zzate) {
            this.zzbdz.zza(this.zzbgs.zzbgm);
            this.zzbgs = this.zzbgs.zzil();
        }
    }

    public final void zza(zzno zzno) {
        this.zzbgz = zzno;
    }

    public final void zze(zzht zzht) {
        zzht zzht2 = zzht == null ? null : zzht;
        boolean zzg = this.zzbgp.zzg(zzht2);
        this.zzbgw = zzht;
        this.zzbgv = false;
        zzno zzno = this.zzbgz;
        if (zzno != null && zzg) {
            zzno.zzf(zzht2);
        }
    }

    public final int zza(zzjz zzjz, int i, boolean z) throws IOException, InterruptedException {
        if (!zzin()) {
            int zzai = zzjz.zzai(i);
            if (zzai != -1) {
                return zzai;
            }
            throw new EOFException();
        }
        try {
            int read = zzjz.read(this.zzbgt.zzbgm.data, this.zzbgy + 0, zzbd(i));
            if (read != -1) {
                this.zzbgy += read;
                this.zzbgx += (long) read;
                return read;
            }
            throw new EOFException();
        } finally {
            zzio();
        }
    }

    public final void zza(zzpn zzpn, int i) {
        if (!zzin()) {
            zzpn.zzbm(i);
            return;
        }
        while (i > 0) {
            int zzbd = zzbd(i);
            zzpn.zze(this.zzbgt.zzbgm.data, this.zzbgy + 0, zzbd);
            this.zzbgy += zzbd;
            this.zzbgx += (long) zzbd;
            i -= zzbd;
        }
        zzio();
    }

    public final void zza(long j, int i, int i2, int i3, zzkk zzkk) {
        if (!zzin()) {
            long j2 = j;
            this.zzbgp.zzei(j);
            return;
        }
        long j3 = j;
        try {
            this.zzbgp.zza(j, i, (this.zzbgx - ((long) i2)) - ((long) i3), i2, zzkk);
        } finally {
            zzio();
        }
    }

    private final boolean zzin() {
        return this.zzbgr.compareAndSet(0, 1);
    }

    private final void zzio() {
        if (!this.zzbgr.compareAndSet(1, 0)) {
            zzif();
        }
    }

    private final void zzif() {
        this.zzbgp.zzif();
        zznl zznl = this.zzbgs;
        if (zznl.zzbgl) {
            int i = (this.zzbgt.zzbgl ? 1 : 0) + (((int) (this.zzbgt.zzbgk - zznl.zzbgk)) / this.zzbgo);
            zzom[] zzomArr = new zzom[i];
            for (int i2 = 0; i2 < i; i2++) {
                zzomArr[i2] = zznl.zzbgm;
                zznl = zznl.zzil();
            }
            this.zzbdz.zza(zzomArr);
        }
        zznl zznl2 = new zznl(0, this.zzbgo);
        this.zzbgs = zznl2;
        this.zzbgt = zznl2;
        this.zzbgx = 0;
        this.zzbgy = this.zzbgo;
        this.zzbdz.zzn();
    }

    private final int zzbd(int i) {
        if (this.zzbgy == this.zzbgo) {
            this.zzbgy = 0;
            if (this.zzbgt.zzbgl) {
                this.zzbgt = this.zzbgt.zzbgn;
            }
            zznl zznl = this.zzbgt;
            zzom zzir = this.zzbdz.zzir();
            zznl zznl2 = new zznl(this.zzbgt.zzate, this.zzbgo);
            zznl.zzbgm = zzir;
            zznl.zzbgn = zznl2;
            zznl.zzbgl = true;
        }
        return Math.min(i, this.zzbgo - this.zzbgy);
    }
}
