package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzos {
    public final int flags;
    public final long position;
    public final Uri uri;
    public final byte[] zzbiv;
    public final long zzbiw;
    public final String zzcm;
    public final long zzco;

    public zzos(Uri uri2) {
        this(uri2, 0);
    }

    private zzos(Uri uri2, int i) {
        this(uri2, 0, -1, (String) null, 0);
    }

    public zzos(Uri uri2, long j, long j2, String str) {
        this(uri2, j, j, j2, str, 0);
    }

    private zzos(Uri uri2, long j, long j2, String str, int i) {
        this(uri2, 0, 0, -1, (String) null, 0);
    }

    private zzos(Uri uri2, long j, long j2, long j3, String str, int i) {
        this(uri2, (byte[]) null, j, j2, j3, str, 0);
    }

    public zzos(Uri uri2, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        zzpg.checkArgument(j >= 0);
        zzpg.checkArgument(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        zzpg.checkArgument(z);
        this.uri = uri2;
        this.zzbiv = bArr;
        this.zzbiw = j;
        this.position = j2;
        this.zzco = j3;
        this.zzcm = str;
        this.flags = i;
    }

    public final boolean isFlagSet(int i) {
        return (this.flags & 1) == 1;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.uri);
        String arrays = Arrays.toString(this.zzbiv);
        long j = this.zzbiw;
        long j2 = this.position;
        long j3 = this.zzco;
        String str = this.zzcm;
        int i = this.flags;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 93 + String.valueOf(arrays).length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(valueOf);
        sb.append(", ");
        sb.append(arrays);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append(Const.jaRight);
        return sb.toString();
    }
}
