package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public abstract class zzelq implements Serializable, Iterable<Byte> {
    public static final zzelq zzipc = new zzema(zzenc.zzipi);
    private static final zzelw zzipd = (zzelj.zzbhb() ? new zzemc((zzelp) null) : new zzelu((zzelp) null));
    private static final Comparator<zzelq> zzipe = new zzels();
    private int zzioi = 0;

    zzelq() {
    }

    /* access modifiers changed from: private */
    public static int zzb(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzeln zzeln) throws IOException;

    public abstract zzelq zzac(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void zzb(byte[] bArr, int i, int i2, int i3);

    public abstract boolean zzbhi();

    public abstract zzemb zzbhj();

    /* access modifiers changed from: protected */
    public abstract int zzbhl();

    /* access modifiers changed from: protected */
    public abstract boolean zzbhm();

    /* access modifiers changed from: protected */
    public abstract int zzg(int i, int i2, int i3);

    public abstract byte zzgh(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzgi(int i);

    /* access modifiers changed from: protected */
    public abstract int zzh(int i, int i2, int i3);

    /* renamed from: zzbhg */
    public zzelv iterator() {
        return new zzelp(this);
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public static zzelq zzi(byte[] bArr, int i, int i2) {
        zzi(i, i + i2, bArr.length);
        return new zzema(zzipd.zzj(bArr, i, i2));
    }

    public static zzelq zzt(byte[] bArr) {
        return zzi(bArr, 0, bArr.length);
    }

    static zzelq zzu(byte[] bArr) {
        return new zzema(bArr);
    }

    public static zzelq zzhz(String str) {
        return new zzema(str.getBytes(zzenc.UTF_8));
    }

    public static zzelq zzf(InputStream inputStream) throws IOException {
        zzelq zzelq;
        ArrayList arrayList = new ArrayList();
        int i = 256;
        while (true) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == 0) {
                zzelq = null;
            } else {
                zzelq = zzi(bArr, 0, i2);
            }
            if (zzelq == null) {
                return zzl(arrayList);
            }
            arrayList.add(zzelq);
            i = Math.min(i << 1, 8192);
        }
    }

    public static zzelq zzl(Iterable<zzelq> iterable) {
        int i;
        if (!(iterable instanceof Collection)) {
            i = 0;
            Iterator<zzelq> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                i++;
            }
        } else {
            i = ((Collection) iterable).size();
        }
        if (i == 0) {
            return zzipc;
        }
        return zza(iterable.iterator(), i);
    }

    private static zzelq zza(Iterator<zzelq> it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return it.next();
        } else {
            int i2 = i >>> 1;
            zzelq zza = zza(it, i2);
            zzelq zza2 = zza(it, i - i2);
            if (Integer.MAX_VALUE - zza.size() >= zza2.size()) {
                return zzepf.zza(zza, zza2);
            }
            int size = zza.size();
            int size2 = zza2.size();
            StringBuilder sb = new StringBuilder(53);
            sb.append("ByteString would be too long: ");
            sb.append(size);
            sb.append("+");
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Deprecated
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        zzi(i, i + i3, size());
        zzi(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zzb(bArr, i, i2, i3);
        }
    }

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzenc.zzipi;
        }
        byte[] bArr = new byte[size];
        zzb(bArr, 0, 0, size);
        return bArr;
    }

    public final String zzbhh() {
        return size() == 0 ? "" : zza(zzenc.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzioi;
        if (i == 0) {
            int size = size();
            i = zzh(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzioi = i;
        }
        return i;
    }

    public static zzelz zzbhk() {
        return new zzelz(128);
    }

    static zzely zzgj(int i) {
        return new zzely(i, (zzelp) null);
    }

    /* access modifiers changed from: protected */
    public final int zzbhn() {
        return this.zzioi;
    }

    static void zzad(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    static int zzi(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? zzepw.zzan(this) : String.valueOf(zzepw.zzan(zzac(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }
}
