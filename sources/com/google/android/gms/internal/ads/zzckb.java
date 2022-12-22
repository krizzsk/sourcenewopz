package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzckb {
    private final zzcjw zzgmx;
    private final AtomicReference<zzann> zzgmy = new AtomicReference<>();

    zzckb(zzcjw zzcjw) {
        this.zzgmx = zzcjw;
    }

    public final void zzb(zzann zzann) {
        this.zzgmy.compareAndSet((Object) null, zzann);
    }

    public final zzdqd zzd(String str, JSONObject jSONObject) throws zzdpq {
        zzano zzano;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzano = new zzaon((MediationAdapter) new AdMobAdapter());
            } else if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                zzano = new zzaon((MediationAdapter) new AdUrlAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzano = new zzaon((MediationAdapter) new zzaqt());
            } else {
                zzano = zze(str, jSONObject);
            }
            zzdqd zzdqd = new zzdqd(zzano);
            this.zzgmx.zza(str, zzdqd);
            return zzdqd;
        } catch (Throwable th) {
            throw new zzdpq(th);
        }
    }

    public final zzaqa zzdi(String str) throws RemoteException {
        zzaqa zzdi = zzaqp().zzdi(str);
        this.zzgmx.zza(str, zzdi);
        return zzdi;
    }

    public final boolean zzaqo() {
        return this.zzgmy.get() != null;
    }

    private final zzano zze(String str, JSONObject jSONObject) throws RemoteException {
        zzann zzaqp = zzaqp();
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                String string = jSONObject.getString("class_name");
                if (zzaqp.zzde(string)) {
                    return zzaqp.zzdd("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                }
                if (zzaqp.zzdf(string)) {
                    return zzaqp.zzdd(string);
                }
                return zzaqp.zzdd("com.google.ads.mediation.customevent.CustomEventAdapter");
            } catch (JSONException e) {
                zzd.zzc("Invalid custom event.", e);
            }
        }
        return zzaqp.zzdd(str);
    }

    private final zzann zzaqp() throws RemoteException {
        zzann zzann = this.zzgmy.get();
        if (zzann != null) {
            return zzann;
        }
        zzd.zzez("Unexpected call to adapter creator.");
        throw new RemoteException();
    }
}
