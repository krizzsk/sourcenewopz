package com.google.android.gms.internal.ads;

import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzauh implements Runnable {
    private final OutputStream zzdyq;
    private final byte[] zzdyr;

    zzauh(OutputStream outputStream, byte[] bArr) {
        this.zzdyq = outputStream;
        this.zzdyr = bArr;
    }

    public final void run() {
        zzaue.zza(this.zzdyq, this.zzdyr);
    }
}
