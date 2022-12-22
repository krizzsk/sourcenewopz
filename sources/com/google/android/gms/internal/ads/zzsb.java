package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.zzd;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzsb {
    private ByteArrayOutputStream zzbus = new ByteArrayOutputStream(4096);
    private Base64OutputStream zzbut = new Base64OutputStream(this.zzbus, 10);

    public final void write(byte[] bArr) throws IOException {
        this.zzbut.write(bArr);
    }

    public final String toString() {
        try {
            this.zzbut.close();
        } catch (IOException e) {
            zzd.zzc("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.zzbus.close();
            return this.zzbus.toString();
        } catch (IOException e2) {
            zzd.zzc("HashManager: Unable to convert to Base64.", e2);
            return "";
        } finally {
            this.zzbus = null;
            this.zzbut = null;
        }
    }
}
