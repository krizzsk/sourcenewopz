package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdep implements Callable {
    private final zzdeq zzhey;

    zzdep(zzdeq zzdeq) {
        this.zzhey = zzdeq;
    }

    public final Object call() {
        String str;
        String str2;
        String str3;
        zzr.zzkv();
        zzrq zzza = zzr.zzkz().zzyl().zzza();
        Bundle bundle = null;
        if (!(zzza == null || zzza == null || (zzr.zzkz().zzyl().zzzb() && zzr.zzkz().zzyl().zzzd()))) {
            if (zzza.zzms()) {
                zzza.wakeup();
            }
            zzrk zzmq = zzza.zzmq();
            if (zzmq != null) {
                str2 = zzmq.zzmf();
                str = zzmq.zzmg();
                str3 = zzmq.zzmh();
                if (str2 != null) {
                    zzr.zzkz().zzyl().zzee(str2);
                }
                if (str3 != null) {
                    zzr.zzkz().zzyl().zzef(str3);
                }
            } else {
                str2 = zzr.zzkz().zzyl().zzzc();
                str3 = zzr.zzkz().zzyl().zzze();
                str = null;
            }
            Bundle bundle2 = new Bundle(1);
            if (!zzr.zzkz().zzyl().zzzd()) {
                if (str3 == null || TextUtils.isEmpty(str3)) {
                    bundle2.putString("v_fp_vertical", "no_hash");
                } else {
                    bundle2.putString("v_fp_vertical", str3);
                }
            }
            if (str2 != null && !zzr.zzkz().zzyl().zzzb()) {
                bundle2.putString("fingerprint", str2);
                if (!str2.equals(str)) {
                    bundle2.putString("v_fp", str);
                }
            }
            if (!bundle2.isEmpty()) {
                bundle = bundle2;
            }
        }
        return new zzden(bundle);
    }
}
