package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbfo implements zzebi<Map<String, String>> {
    private final /* synthetic */ Uri val$uri;
    private final /* synthetic */ zzbfh zzetq;
    private final /* synthetic */ List zzett;
    private final /* synthetic */ String zzetu;

    zzbfo(zzbfh zzbfh, List list, String str, Uri uri) {
        this.zzetq = zzbfh;
        this.zzett = list;
        this.zzetu = str;
        this.val$uri = uri;
    }

    public final void zzb(Throwable th) {
        String valueOf = String.valueOf(this.val$uri);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 33);
        sb.append("Failed to parse gmsg params for: ");
        sb.append(valueOf);
        zzd.zzez(sb.toString());
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzetq.zza((Map<String, String>) (Map) obj, (List<zzaig<? super zzbfi>>) this.zzett, this.zzetu);
    }
}
