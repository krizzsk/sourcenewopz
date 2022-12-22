package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbbe;
import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzl;
import com.google.android.gms.internal.ads.zzz;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzay {
    private static zzaf zzeie;
    private static final Object zzeif = new Object();
    @Deprecated
    private static final zzbc<Void> zzeig = new zzax();

    public zzay(Context context) {
        zzbm(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    public static zzebt<zzz> zzeq(String str) {
        zzbbe zzbbe = new zzbbe();
        zzeie.zzd(new zzbe(str, zzbbe));
        return zzbbe;
    }

    public final zzebt<String> zza(int i, String str, Map<String, String> map, byte[] bArr) {
        String str2 = str;
        zzbb zzbb = new zzbb((zzax) null);
        zzba zzba = new zzba(this, str2, zzbb);
        zzbai zzbai = new zzbai((String) null);
        zzaz zzaz = new zzaz(this, i, str, zzbb, zzba, bArr, map, zzbai);
        if (zzbai.isEnabled()) {
            try {
                zzbai.zza(str2, "GET", zzaz.getHeaders(), zzaz.zzg());
            } catch (zzl e) {
                zzd.zzez(e.getMessage());
            }
        }
        zzeie.zzd(zzaz);
        return zzbb;
    }

    public final zzebt<String> zzb(String str, Map<String, String> map) {
        return zza(0, str, map, (byte[]) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzaf zzbm(android.content.Context r3) {
        /*
            java.lang.Object r0 = zzeif
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzaf r1 = zzeie     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzabq.initialize(r3)     // Catch:{ all -> 0x0036 }
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabq.zzcvh     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x0036 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x0036 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0036 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0024
            r1 = 1
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            if (r1 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzaf r3 = com.google.android.gms.ads.internal.util.zzan.zzbl(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x0030
        L_0x002c:
            com.google.android.gms.internal.ads.zzaf r3 = com.google.android.gms.internal.ads.zzbj.zza(r3)     // Catch:{ all -> 0x0036 }
        L_0x0030:
            zzeie = r3     // Catch:{ all -> 0x0036 }
        L_0x0032:
            com.google.android.gms.internal.ads.zzaf r3 = zzeie     // Catch:{ all -> 0x0036 }
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            return r3
        L_0x0036:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzay.zzbm(android.content.Context):com.google.android.gms.internal.ads.zzaf");
    }
}
