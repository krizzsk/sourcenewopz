package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzbq extends zzerk implements Closeable {
    private static zzers zzdc = zzers.zzp(zzbq.class);

    public zzbq(zzerm zzerm, zzbn zzbn) throws IOException {
        zza(zzerm, zzerm.size(), zzbn);
    }

    public void close() throws IOException {
        this.zzjeg.close();
    }

    public String toString() {
        String obj = this.zzjeg.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
