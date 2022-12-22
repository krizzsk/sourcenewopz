package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class zzatd {
    private static zzazc zzduy;
    private final Context context;
    private final zzzl zzadb;
    private final AdFormat zzdux;

    public static zzazc zzp(Context context2) {
        zzazc zzazc;
        synchronized (zzatd.class) {
            if (zzduy == null) {
                zzduy = zzww.zzqx().zza(context2, (zzann) new zzank());
            }
            zzazc = zzduy;
        }
        return zzazc;
    }

    public zzatd(Context context2, AdFormat adFormat, zzzl zzzl) {
        this.context = context2;
        this.zzdux = adFormat;
        this.zzadb = zzzl;
    }

    public final void zza(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzvq zzvq;
        zzazc zzp = zzp(this.context);
        if (zzp == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper wrap = ObjectWrapper.wrap(this.context);
        zzzl zzzl = this.zzadb;
        if (zzzl == null) {
            zzvq = new zzvp().zzqj();
        } else {
            zzvq = zzvr.zza(this.context, zzzl);
        }
        try {
            zzp.zza(wrap, new zzazi((String) null, this.zzdux.name(), (zzvt) null, zzvq), (zzazb) new zzatc(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
