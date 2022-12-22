package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbi {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035 A[SYNTHETIC, Splitter:B:19:0x0035] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static byte[] zza(java.io.InputStream r5, int r6, com.google.android.gms.internal.ads.zzat r7) throws java.io.IOException {
        /*
            java.lang.String r0 = "Error occurred when closing InputStream"
            com.google.android.gms.internal.ads.zzbh r1 = new com.google.android.gms.internal.ads.zzbh
            r1.<init>(r7, r6)
            r6 = 1024(0x400, float:1.435E-42)
            r2 = 0
            byte[] r6 = r7.zzf(r6)     // Catch:{ all -> 0x0031 }
        L_0x000e:
            int r3 = r5.read(r6)     // Catch:{ all -> 0x002f }
            r4 = -1
            if (r3 == r4) goto L_0x0019
            r1.write(r6, r2, r3)     // Catch:{ all -> 0x002f }
            goto L_0x000e
        L_0x0019:
            byte[] r3 = r1.toByteArray()     // Catch:{ all -> 0x002f }
            if (r5 == 0) goto L_0x0028
            r5.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0028
        L_0x0023:
            java.lang.Object[] r5 = new java.lang.Object[r2]
            com.google.android.gms.internal.ads.zzao.m37367v(r0, r5)
        L_0x0028:
            r7.zza(r6)
            r1.close()
            return r3
        L_0x002f:
            r3 = move-exception
            goto L_0x0033
        L_0x0031:
            r3 = move-exception
            r6 = 0
        L_0x0033:
            if (r5 == 0) goto L_0x003e
            r5.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003e
        L_0x0039:
            java.lang.Object[] r5 = new java.lang.Object[r2]
            com.google.android.gms.internal.ads.zzao.m37367v(r0, r5)
        L_0x003e:
            r7.zza(r6)
            r1.close()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbi.zza(java.io.InputStream, int, com.google.android.gms.internal.ads.zzat):byte[]");
    }

    private static void zza(String str, zzab<?> zzab, zzap zzap) throws zzap {
        zzak zzj = zzab.zzj();
        int zzi = zzab.zzi();
        try {
            zzj.zza(zzap);
            zzab.zzc(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(zzi)}));
        } catch (zzap e) {
            zzab.zzc(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(zzi)}));
            throw e;
        }
    }

    static void zza(zzab<?> zzab, IOException iOException, long j, zzbb zzbb, byte[] bArr) throws zzap {
        if (iOException instanceof SocketTimeoutException) {
            zza("socket", zzab, (zzap) new zzam());
        } else if (iOException instanceof MalformedURLException) {
            String valueOf = String.valueOf(zzab.getUrl());
            throw new RuntimeException(valueOf.length() != 0 ? "Bad URL ".concat(valueOf) : new String("Bad URL "), iOException);
        } else if (zzbb != null) {
            int statusCode = zzbb.getStatusCode();
            zzao.m37366e("Unexpected response code %d for %s", Integer.valueOf(statusCode), zzab.getUrl());
            if (bArr != null) {
                zzz zzz = new zzz(statusCode, bArr, false, SystemClock.elapsedRealtime() - j, zzbb.zzq());
                if (statusCode == 401 || statusCode == 403) {
                    zza("auth", zzab, (zzap) new zzl(zzz));
                } else if (statusCode >= 400 && statusCode <= 499) {
                    throw new zzo(zzz);
                } else if (statusCode < 500 || statusCode > 599) {
                    throw new zzan(zzz);
                } else {
                    throw new zzan(zzz);
                }
            } else {
                zza("network", zzab, (zzap) new zzw());
            }
        } else {
            throw new zzy(iOException);
        }
    }
}
