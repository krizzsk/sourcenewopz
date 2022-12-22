package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzacj extends zzack {
    private final zzg zzdcq;
    private final String zzdcr;
    private final String zzdcs;

    public zzacj(zzg zzg, String str, String str2) {
        this.zzdcq = zzg;
        this.zzdcr = str;
        this.zzdcs = str2;
    }

    public final String zzsy() {
        return this.zzdcr;
    }

    public final String getContent() {
        return this.zzdcs;
    }

    public final void zzn(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.zzdcq.zzh((View) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public final void recordClick() {
        this.zzdcq.zzkg();
    }

    public final void recordImpression() {
        this.zzdcq.zzkh();
    }
}
