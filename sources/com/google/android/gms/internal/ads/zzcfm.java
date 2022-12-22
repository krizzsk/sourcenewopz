package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcfm implements zzcdz {
    private final Context context;
    private final zzbar zzbpx;
    private final zzdot zzeux;
    private final zzdpm zzfzg;
    private final zzbtl zzgep;
    private final zzbst zzgeq;
    private boolean zzgeu = false;
    private boolean zzgex = false;
    private final zzaob zzgjm;
    private final zzaoc zzgjn;
    private final zzaoh zzgjo;
    private boolean zzgjp = true;

    public zzcfm(zzaob zzaob, zzaoc zzaoc, zzaoh zzaoh, zzbtl zzbtl, zzbst zzbst, Context context2, zzdot zzdot, zzbar zzbar, zzdpm zzdpm) {
        this.zzgjm = zzaob;
        this.zzgjn = zzaoc;
        this.zzgjo = zzaoh;
        this.zzgep = zzbtl;
        this.zzgeq = zzbst;
        this.context = context2;
        this.zzeux = zzdot;
        this.zzbpx = zzbar;
        this.zzfzg = zzdpm;
    }

    public final void cancelUnconfirmedClick() {
    }

    public final void destroy() {
    }

    public final void setClickConfirmingView(View view) {
    }

    public final JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    public final void zza(View view, MotionEvent motionEvent, View view2) {
    }

    public final void zza(zzagr zzagr) {
    }

    public final void zzaod() {
    }

    public final void zzaof() {
    }

    public final void zzf(Bundle bundle) {
    }

    public final void zzfx(String str) {
    }

    public final void zzg(Bundle bundle) {
    }

    public final boolean zzh(Bundle bundle) {
        return false;
    }

    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            this.zzgjp = zzc(map, map2);
            HashMap<String, View> zzb = zzb(map);
            HashMap<String, View> zzb2 = zzb(map2);
            if (this.zzgjo != null) {
                this.zzgjo.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
            } else if (this.zzgjm != null) {
                this.zzgjm.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzgjm.zzw(wrap);
            } else if (this.zzgjn != null) {
                this.zzgjn.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzgjn.zzw(wrap);
            }
        } catch (RemoteException e) {
            zzd.zzd("Failed to call trackView", e);
        }
    }

    private static HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry next : map.entrySet()) {
                View view = (View) ((WeakReference) next.getValue()).get();
                if (view != null) {
                    hashMap.put((String) next.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    public final void zza(View view, Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            if (this.zzgjo != null) {
                this.zzgjo.zzx(wrap);
            } else if (this.zzgjm != null) {
                this.zzgjm.zzx(wrap);
            } else if (this.zzgjn != null) {
                this.zzgjn.zzx(wrap);
            }
        } catch (RemoteException e) {
            zzd.zzd("Failed to call untrackView", e);
        }
    }

    public final void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzgex || !this.zzeux.zzdnp) {
            zzad(view);
        }
    }

    private final void zzad(View view) {
        try {
            if (this.zzgjo != null && !this.zzgjo.getOverrideClickHandling()) {
                this.zzgjo.zzv(ObjectWrapper.wrap(view));
                this.zzgeq.onAdClicked();
            } else if (this.zzgjm != null && !this.zzgjm.getOverrideClickHandling()) {
                this.zzgjm.zzv(ObjectWrapper.wrap(view));
                this.zzgeq.onAdClicked();
            } else if (this.zzgjn != null && !this.zzgjn.getOverrideClickHandling()) {
                this.zzgjn.zzv(ObjectWrapper.wrap(view));
                this.zzgeq.onAdClicked();
            }
        } catch (RemoteException e) {
            zzd.zzd("Failed to call handleClick", e);
        }
    }

    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzgex) {
            zzd.zzez("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zzeux.zzdnp) {
            zzd.zzez("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        } else {
            zzad(view);
        }
    }

    public final void zzud() {
        this.zzgex = true;
    }

    public final boolean isCustomClickGestureEnabled() {
        return this.zzeux.zzdnp;
    }

    public final void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        try {
            if (!this.zzgeu && this.zzeux.zzhmm != null) {
                this.zzgeu |= zzr.zzlf().zzb(this.context, this.zzbpx.zzbrz, this.zzeux.zzhmm.toString(), this.zzfzg.zzhny);
            }
            if (this.zzgjp) {
                if (this.zzgjo != null && !this.zzgjo.getOverrideImpressionRecording()) {
                    this.zzgjo.recordImpression();
                    this.zzgep.onAdImpression();
                } else if (this.zzgjm != null && !this.zzgjm.getOverrideImpressionRecording()) {
                    this.zzgjm.recordImpression();
                    this.zzgep.onAdImpression();
                } else if (this.zzgjn != null && !this.zzgjn.getOverrideImpressionRecording()) {
                    this.zzgjn.recordImpression();
                    this.zzgep.onAdImpression();
                }
            }
        } catch (RemoteException e) {
            zzd.zzd("Failed to call recordImpression", e);
        }
    }

    private final boolean zzc(Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        Object obj;
        JSONObject jSONObject = this.zzeux.zzhna;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcru)).booleanValue() && jSONObject.length() != 0) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (map2 == null) {
                map2 = new HashMap<>();
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(map);
            hashMap.putAll(map2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                if (optJSONArray != null) {
                    WeakReference weakReference = (WeakReference) hashMap.get(next);
                    if (weakReference == null || (obj = weakReference.get()) == null) {
                        return false;
                    }
                    Class<?> cls = obj.getClass();
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzcrv)).booleanValue() && next.equals("3010")) {
                        Object zzaqa = zzaqa();
                        if (zzaqa == null) {
                            return false;
                        }
                        cls = zzaqa.getClass();
                    }
                    try {
                        ArrayList arrayList = new ArrayList();
                        zzbh.zza(optJSONArray, (List<String>) arrayList);
                        zzr.zzkv();
                        if (!zzj.zza(this.context.getClassLoader(), cls, (List<String>) arrayList)) {
                            return false;
                        }
                    } catch (JSONException unused) {
                        continue;
                    }
                }
            }
        }
        return true;
    }

    private final Object zzaqa() {
        IObjectWrapper iObjectWrapper;
        zzaoh zzaoh = this.zzgjo;
        if (zzaoh != null) {
            try {
                iObjectWrapper = zzaoh.zzvs();
            } catch (RemoteException unused) {
                return null;
            }
        } else {
            zzaob zzaob = this.zzgjm;
            if (zzaob != null) {
                try {
                    iObjectWrapper = zzaob.zzvs();
                } catch (RemoteException unused2) {
                    return null;
                }
            } else {
                zzaoc zzaoc = this.zzgjn;
                if (zzaoc != null) {
                    try {
                        iObjectWrapper = zzaoc.zzvs();
                    } catch (RemoteException unused3) {
                        return null;
                    }
                } else {
                    iObjectWrapper = null;
                }
            }
        }
        if (iObjectWrapper != null) {
            try {
                return ObjectWrapper.unwrap(iObjectWrapper);
            } catch (IllegalArgumentException unused4) {
            }
        }
        return null;
    }

    public final void zza(zzys zzys) {
        zzd.zzez("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zza(zzyo zzyo) {
        zzd.zzez("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzaoe() {
        zzd.zzez("Mute This Ad is not supported for 3rd party ads");
    }
}
