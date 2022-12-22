package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzenc {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zzipi;
    private static final ByteBuffer zziud;
    private static final zzemb zziue;

    public static int zzby(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzfr(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzx(byte[] bArr) {
        return zzeqj.zzx(bArr);
    }

    public static String zzy(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static boolean zzk(zzeon zzeon) {
        if (!(zzeon instanceof zzeli)) {
            return false;
        }
        zzeli zzeli = (zzeli) zzeon;
        return false;
    }

    static Object zze(Object obj, Object obj2) {
        return ((zzeon) obj).zzbjn().zzf((zzeon) obj2).zzbju();
    }

    static {
        byte[] bArr = new byte[0];
        zzipi = bArr;
        zziud = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzipi;
        zziue = zzemb.zzb(bArr2, 0, bArr2.length, false);
    }
}
