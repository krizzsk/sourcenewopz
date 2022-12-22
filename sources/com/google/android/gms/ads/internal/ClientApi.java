package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzaew;
import com.google.android.gms.internal.ads.zzafd;
import com.google.android.gms.internal.ads.zzann;
import com.google.android.gms.internal.ads.zzaru;
import com.google.android.gms.internal.ads.zzash;
import com.google.android.gms.internal.ads.zzass;
import com.google.android.gms.internal.ads.zzavg;
import com.google.android.gms.internal.ads.zzawf;
import com.google.android.gms.internal.ads.zzazc;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbhh;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzcel;
import com.google.android.gms.internal.ads.zzczi;
import com.google.android.gms.internal.ads.zzdjv;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzxj;
import com.google.android.gms.internal.ads.zzxq;
import com.google.android.gms.internal.ads.zzyc;
import com.google.android.gms.internal.ads.zzyh;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class ClientApi extends zzyc {
    public final zzyh zzc(IObjectWrapper iObjectWrapper) {
        return null;
    }

    public final zzass zzd(IObjectWrapper iObjectWrapper) {
        return null;
    }

    public final zzxq zza(IObjectWrapper iObjectWrapper, zzvt zzvt, String str, zzann zzann, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbhh.zza(context, zzann, i).zzagd().zzcb(context).zzc(zzvt).zzfq(str).zzain().zzaiq();
    }

    public final zzxq zzb(IObjectWrapper iObjectWrapper, zzvt zzvt, String str, zzann zzann, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbhh.zza(context, zzann, i).zzagi().zzcc(context).zzd(zzvt).zzfr(str).zzais().zzaiw();
    }

    public final zzxj zza(IObjectWrapper iObjectWrapper, String str, zzann zzann, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzczi(zzbhh.zza(context, zzann, i), context, str);
    }

    public final zzaew zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzcel((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 204890000);
    }

    public final zzavg zza(IObjectWrapper iObjectWrapper, zzann zzann, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbhh.zza(context, zzann, i).zzagl().zzcd(context).zzaiv().zzaiy();
    }

    public final zzash zzb(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zzd = AdOverlayInfoParcel.zzd(activity.getIntent());
        if (zzd == null) {
            return new zzs(activity);
        }
        int i = zzd.zzduk;
        if (i == 1) {
            return new zzt(activity);
        }
        if (i == 2) {
            return new zzaa(activity);
        }
        if (i == 3) {
            return new zzac(activity);
        }
        if (i == 4) {
            return new zzu(activity, zzd);
        }
        if (i != 5) {
            return new zzs(activity);
        }
        return new zzy(activity);
    }

    public final zzyh zza(IObjectWrapper iObjectWrapper, int i) {
        return zzbhh.zzh((Context) ObjectWrapper.unwrap(iObjectWrapper), i).zzagb();
    }

    public final zzxq zza(IObjectWrapper iObjectWrapper, zzvt zzvt, String str, int i) {
        return new zzl((Context) ObjectWrapper.unwrap(iObjectWrapper), zzvt, str, new zzbar(204890000, i, true, false));
    }

    public final zzafd zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzcei((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzawf zzb(IObjectWrapper iObjectWrapper, String str, zzann zzann, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbhh.zza(context, zzann, i).zzagl().zzcd(context).zzfs(str).zzaiv().zzaiz();
    }

    public final zzxq zzc(IObjectWrapper iObjectWrapper, zzvt zzvt, String str, zzann zzann, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdjv zzaic = zzbhh.zza(context, zzann, i).zzagg().zzfp(str).zzca(context).zzaic();
        if (i >= ((Integer) zzww.zzra().zzd(zzabq.zzcws)).intValue()) {
            return zzaic.zzaig();
        }
        return zzaic.zzaif();
    }

    public final zzazc zzb(IObjectWrapper iObjectWrapper, zzann zzann, int i) {
        return zzbhh.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzann, i).zzagn();
    }

    public final zzaru zzc(IObjectWrapper iObjectWrapper, zzann zzann, int i) {
        return zzbhh.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzann, i).zzago();
    }
}
