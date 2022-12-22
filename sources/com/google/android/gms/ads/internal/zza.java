package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.internal.ads.zzatu;
import com.google.android.gms.internal.ads.zzaxo;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zza {
    private final Context context;
    private boolean zzbor;
    private zzaxo zzbos;
    private zzatu zzbot = null;

    public zza(Context context2, zzaxo zzaxo, zzatu zzatu) {
        this.context = context2;
        this.zzbos = zzaxo;
        if (0 == 0) {
            this.zzbot = new zzatu();
        }
    }

    private final boolean zzkb() {
        zzaxo zzaxo = this.zzbos;
        return (zzaxo != null && zzaxo.zzxg().zzecb) || this.zzbot.zzdyl;
    }

    public final void recordClick() {
        this.zzbor = true;
    }

    public final boolean zzkc() {
        return !zzkb() || this.zzbor;
    }

    public final void zzbk(String str) {
        if (zzkb()) {
            if (str == null) {
                str = "";
            }
            zzaxo zzaxo = this.zzbos;
            if (zzaxo != null) {
                zzaxo.zza(str, (Map<String, String>) null, 3);
            } else if (this.zzbot.zzdyl && this.zzbot.zzdym != null) {
                for (String next : this.zzbot.zzdym) {
                    if (!TextUtils.isEmpty(next)) {
                        String replace = next.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzr.zzkv();
                        zzj.zzb(this.context, "", replace);
                    }
                }
            }
        }
    }
}
