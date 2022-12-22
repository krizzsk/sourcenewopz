package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzame implements zzakq, zzamf {
    private final zzamc zzdlt;
    private final HashSet<AbstractMap.SimpleEntry<String, zzaig<? super zzamc>>> zzdlu = new HashSet<>();

    public zzame(zzamc zzamc) {
        this.zzdlt = zzamc;
    }

    public final void zza(String str, Map map) {
        zzakt.zza((zzakq) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzakt.zzb(this, str, jSONObject);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzakt.zza((zzakq) this, str, jSONObject);
    }

    public final void zzi(String str, String str2) {
        zzakt.zza((zzakq) this, str, str2);
    }

    public final void zzcv(String str) {
        this.zzdlt.zzcv(str);
    }

    public final void zza(String str, zzaig<? super zzamc> zzaig) {
        this.zzdlt.zza(str, zzaig);
        this.zzdlu.add(new AbstractMap.SimpleEntry(str, zzaig));
    }

    public final void zzb(String str, zzaig<? super zzamc> zzaig) {
        this.zzdlt.zzb(str, zzaig);
        this.zzdlu.remove(new AbstractMap.SimpleEntry(str, zzaig));
    }

    public final void zzva() {
        Iterator<AbstractMap.SimpleEntry<String, zzaig<? super zzamc>>> it = this.zzdlu.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry next = it.next();
            String valueOf = String.valueOf(((zzaig) next.getValue()).toString());
            zzd.zzed(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzdlt.zzb((String) next.getKey(), (zzaig) next.getValue());
        }
        this.zzdlu.clear();
    }
}
