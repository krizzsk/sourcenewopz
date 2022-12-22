package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzab;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzajg;
import com.google.android.gms.internal.ads.zzap;
import com.google.android.gms.internal.ads.zzar;
import com.google.android.gms.internal.ads.zzau;
import com.google.android.gms.internal.ads.zzav;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbd;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzz;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzan extends zzau {
    private final Context context;

    public static zzaf zzbl(Context context2) {
        zzaf zzaf = new zzaf(new zzav(new File(context2.getCacheDir(), "admob_volley"), 20971520), new zzan(context2, new zzbd()));
        zzaf.start();
        return zzaf;
    }

    private zzan(Context context2, zzar zzar) {
        super(zzar);
        this.context = context2;
    }

    public final zzz zza(zzab<?> zzab) throws zzap {
        if (zzab.zzh() && zzab.getMethod() == 0) {
            if (Pattern.matches((String) zzww.zzra().zzd(zzabq.zzcvi), zzab.getUrl())) {
                zzww.zzqw();
                if (zzbae.zzf(this.context, 13400000)) {
                    zzz zza = new zzajg(this.context).zza(zzab);
                    if (zza != null) {
                        String valueOf = String.valueOf(zzab.getUrl());
                        zzd.zzed(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zza;
                    }
                    String valueOf2 = String.valueOf(zzab.getUrl());
                    zzd.zzed(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zza(zzab);
    }
}
