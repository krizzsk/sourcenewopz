package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
class zzema extends zzelx {
    protected final byte[] zzipn;

    zzema(byte[] bArr) {
        if (bArr != null) {
            this.zzipn = bArr;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public int zzbho() {
        return 0;
    }

    public byte zzgh(int i) {
        return this.zzipn[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzgi(int i) {
        return this.zzipn[i];
    }

    public int size() {
        return this.zzipn.length;
    }

    public final zzelq zzac(int i, int i2) {
        int zzi = zzi(i, i2, size());
        if (zzi == 0) {
            return zzelq.zzipc;
        }
        return new zzelt(this.zzipn, zzbho() + i, zzi);
    }

    /* access modifiers changed from: protected */
    public void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzipn, i, bArr, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeln zzeln) throws IOException {
        zzeln.zzh(this.zzipn, zzbho(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzipn, zzbho(), size(), charset);
    }

    public final boolean zzbhi() {
        int zzbho = zzbho();
        return zzeqj.zzm(this.zzipn, zzbho, size() + zzbho);
    }

    /* access modifiers changed from: protected */
    public final int zzg(int i, int i2, int i3) {
        int zzbho = zzbho() + i2;
        return zzeqj.zzb(i, this.zzipn, zzbho, i3 + zzbho);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzelq) || size() != ((zzelq) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzema)) {
            return obj.equals(this);
        }
        zzema zzema = (zzema) obj;
        int zzbhn = zzbhn();
        int zzbhn2 = zzema.zzbhn();
        if (zzbhn == 0 || zzbhn2 == 0 || zzbhn == zzbhn2) {
            return zza(zzema, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzelq zzelq, int i, int i2) {
        if (i2 <= zzelq.size()) {
            int i3 = i + i2;
            if (i3 > zzelq.size()) {
                int size = zzelq.size();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: ");
                sb.append(i);
                sb.append(", ");
                sb.append(i2);
                sb.append(", ");
                sb.append(size);
                throw new IllegalArgumentException(sb.toString());
            } else if (!(zzelq instanceof zzema)) {
                return zzelq.zzac(i, i3).equals(zzac(0, i2));
            } else {
                zzema zzema = (zzema) zzelq;
                byte[] bArr = this.zzipn;
                byte[] bArr2 = zzema.zzipn;
                int zzbho = zzbho() + i2;
                int zzbho2 = zzbho();
                int zzbho3 = zzema.zzbho() + i;
                while (zzbho2 < zzbho) {
                    if (bArr[zzbho2] != bArr2[zzbho3]) {
                        return false;
                    }
                    zzbho2++;
                    zzbho3++;
                }
                return true;
            }
        } else {
            int size2 = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i2);
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public final int zzh(int i, int i2, int i3) {
        return zzenc.zza(i, this.zzipn, zzbho() + i2, i3);
    }

    public final zzemb zzbhj() {
        return zzemb.zzb(this.zzipn, zzbho(), size(), true);
    }
}
