package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzazz {
    private final Object lock = new Object();
    private final zzf zzecl;
    private long zzefd = -1;
    private long zzefe = -1;
    private int zzeff = -1;
    int zzefg = -1;
    private long zzefh = 0;
    private final String zzefi;
    private int zzefj = 0;
    private int zzefk = 0;

    public zzazz(String str, zzf zzf) {
        this.zzefi = str;
        this.zzecl = zzf;
    }

    public final void zzyc() {
        synchronized (this.lock) {
            this.zzefj++;
        }
    }

    public final void zzyb() {
        synchronized (this.lock) {
            this.zzefk++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzvq r11, long r12) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.lock
            monitor-enter(r0)
            com.google.android.gms.ads.internal.util.zzf r1 = r10.zzecl     // Catch:{ all -> 0x0077 }
            long r1 = r1.zzzh()     // Catch:{ all -> 0x0077 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzr.zzlc()     // Catch:{ all -> 0x0077 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0077 }
            long r5 = r10.zzefe     // Catch:{ all -> 0x0077 }
            r7 = -1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0040
            long r1 = r3 - r1
            com.google.android.gms.internal.ads.zzabf<java.lang.Long> r5 = com.google.android.gms.internal.ads.zzabq.zzcqb     // Catch:{ all -> 0x0077 }
            com.google.android.gms.internal.ads.zzabm r6 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x0077 }
            java.lang.Object r5 = r6.zzd(r5)     // Catch:{ all -> 0x0077 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0077 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0077 }
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0033
            r1 = -1
            r10.zzefg = r1     // Catch:{ all -> 0x0077 }
            goto L_0x003b
        L_0x0033:
            com.google.android.gms.ads.internal.util.zzf r1 = r10.zzecl     // Catch:{ all -> 0x0077 }
            int r1 = r1.zzzi()     // Catch:{ all -> 0x0077 }
            r10.zzefg = r1     // Catch:{ all -> 0x0077 }
        L_0x003b:
            r10.zzefe = r12     // Catch:{ all -> 0x0077 }
            r10.zzefd = r12     // Catch:{ all -> 0x0077 }
            goto L_0x0042
        L_0x0040:
            r10.zzefd = r12     // Catch:{ all -> 0x0077 }
        L_0x0042:
            r12 = 1
            if (r11 == 0) goto L_0x0056
            android.os.Bundle r13 = r11.extras     // Catch:{ all -> 0x0077 }
            if (r13 == 0) goto L_0x0056
            android.os.Bundle r11 = r11.extras     // Catch:{ all -> 0x0077 }
            java.lang.String r13 = "gw"
            r1 = 2
            int r11 = r11.getInt(r13, r1)     // Catch:{ all -> 0x0077 }
            if (r11 != r12) goto L_0x0056
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            return
        L_0x0056:
            int r11 = r10.zzeff     // Catch:{ all -> 0x0077 }
            int r11 = r11 + r12
            r10.zzeff = r11     // Catch:{ all -> 0x0077 }
            int r11 = r10.zzefg     // Catch:{ all -> 0x0077 }
            int r11 = r11 + r12
            r10.zzefg = r11     // Catch:{ all -> 0x0077 }
            if (r11 != 0) goto L_0x006c
            r11 = 0
            r10.zzefh = r11     // Catch:{ all -> 0x0077 }
            com.google.android.gms.ads.internal.util.zzf r11 = r10.zzecl     // Catch:{ all -> 0x0077 }
            r11.zzfb(r3)     // Catch:{ all -> 0x0077 }
            goto L_0x0075
        L_0x006c:
            com.google.android.gms.ads.internal.util.zzf r11 = r10.zzecl     // Catch:{ all -> 0x0077 }
            long r11 = r11.zzzj()     // Catch:{ all -> 0x0077 }
            long r3 = r3 - r11
            r10.zzefh = r3     // Catch:{ all -> 0x0077 }
        L_0x0075:
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            return
        L_0x0077:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazz.zza(com.google.android.gms.internal.ads.zzvq, long):void");
    }

    public final Bundle zzn(Context context, String str) {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzecl.zzzn() ? "" : this.zzefi);
            bundle.putLong("basets", this.zzefe);
            bundle.putLong("currts", this.zzefd);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzeff);
            bundle.putInt("preqs_in_session", this.zzefg);
            bundle.putLong("time_in_session", this.zzefh);
            bundle.putInt("pclick", this.zzefj);
            bundle.putInt("pimp", this.zzefk);
            bundle.putBoolean("support_transparent_background", zzal(context));
        }
        return bundle;
    }

    private static boolean zzal(Context context) {
        Context zzx = zzava.zzx(context);
        int identifier = zzx.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            zzd.zzey("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == zzx.getPackageManager().getActivityInfo(new ComponentName(zzx.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzd.zzey("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            zzd.zzez("Fail to fetch AdActivity theme");
            zzd.zzey("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }
}
