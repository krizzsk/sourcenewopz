package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzchv implements zzaig<Object> {
    private final zzeru<zzcho> zzgfv;
    private final zzchu zzgio;
    private final zzafy zzglj;

    public zzchv(zzcdy zzcdy, zzcdr zzcdr, zzchu zzchu, zzeru<zzcho> zzeru) {
        this.zzglj = zzcdy.zzgc(zzcdr.getCustomTemplateId());
        this.zzgio = zzchu;
        this.zzgfv = zzeru;
    }

    public final void zzaqi() {
        if (this.zzglj != null) {
            this.zzgio.zza("/nativeAdCustomClick", (zzaig<Object>) this);
        }
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get(UriUtil.LOCAL_ASSET_SCHEME);
        try {
            this.zzglj.zza(this.zzgfv.get(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzd.zzd(sb.toString(), e);
        }
    }
}
