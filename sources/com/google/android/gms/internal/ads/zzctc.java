package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzctc {
    private final List<zzvx> zzaed = Collections.synchronizedList(new ArrayList());
    private zzdot zzeux = null;
    private final Map<String, zzvx> zzgvl = Collections.synchronizedMap(new HashMap());

    public final void zzd(zzdot zzdot) {
        String str = zzdot.zzdnw;
        if (!this.zzgvl.containsKey(str)) {
            Bundle bundle = new Bundle();
            Iterator<String> keys = zzdot.zzhmk.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    bundle.putString(next, zzdot.zzhmk.getString(next));
                } catch (JSONException unused) {
                }
            }
            zzvx zzvx = new zzvx(zzdot.zzhmo, 0, (zzvh) null, bundle);
            this.zzaed.add(zzvx);
            this.zzgvl.put(str, zzvx);
        }
    }

    public final void zza(zzdot zzdot, long j, zzvh zzvh) {
        String str = zzdot.zzdnw;
        if (this.zzgvl.containsKey(str)) {
            if (this.zzeux == null) {
                this.zzeux = zzdot;
            }
            zzvx zzvx = this.zzgvl.get(str);
            zzvx.zzcjb = j;
            zzvx.zzcjc = zzvh;
        }
    }

    public final zzbsp zzasu() {
        return new zzbsp(this.zzeux, "", this);
    }

    public final List<zzvx> getAdapterResponses() {
        return this.zzaed;
    }
}
