package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzafd;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzww;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzbol = new WeakHashMap<>();
    private zzafd zzbok;
    private WeakReference<View> zzbom;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if ((view instanceof NativeAdView) || (view instanceof UnifiedNativeAdView)) {
            zzbao.zzex("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
        } else if (zzbol.get(view) != null) {
            zzbao.zzex("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zzbol.put(view, this);
            this.zzbom = new WeakReference<>(view);
            this.zzbok = zzww.zzqx().zza(view, zzb(map), zzb(map2));
        }
    }

    private static HashMap<String, View> zzb(Map<String, View> map) {
        if (map == null) {
            return new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public final void setNativeAd(NativeAd nativeAd) {
        zza((IObjectWrapper) nativeAd.zzjw());
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        zza((IObjectWrapper) unifiedNativeAd.zzjw());
    }

    private final void zza(IObjectWrapper iObjectWrapper) {
        WeakReference<View> weakReference = this.zzbom;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null) {
            zzbao.zzez("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzbol.containsKey(view)) {
            zzbol.put(view, this);
        }
        zzafd zzafd = this.zzbok;
        if (zzafd != null) {
            try {
                zzafd.zza(iObjectWrapper);
            } catch (RemoteException e) {
                zzbao.zzc("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public final void unregisterNativeAd() {
        zzafd zzafd = this.zzbok;
        if (zzafd != null) {
            try {
                zzafd.unregisterNativeAd();
            } catch (RemoteException e) {
                zzbao.zzc("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference<View> weakReference = this.zzbom;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null) {
            zzbol.remove(view);
        }
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbok.zzf(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbao.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }
}
