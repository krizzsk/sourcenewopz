package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbac implements zzrr {
    private final Object lock = new Object();
    private final zzf zzecl;
    private final zzbab zzefo;
    private final zzazz zzefp;
    private final HashSet<zzazr> zzefq = new HashSet<>();
    private final HashSet<zzbaa> zzefr = new HashSet<>();
    private boolean zzefs = false;

    public zzbac(String str, zzf zzf) {
        this.zzefp = new zzazz(str, zzf);
        this.zzecl = zzf;
        this.zzefo = new zzbab();
    }

    public final void zzb(zzazr zzazr) {
        synchronized (this.lock) {
            this.zzefq.add(zzazr);
        }
    }

    public final void zzb(HashSet<zzazr> hashSet) {
        synchronized (this.lock) {
            this.zzefq.addAll(hashSet);
        }
    }

    public final Bundle zza(Context context, zzazy zzazy) {
        HashSet hashSet = new HashSet();
        synchronized (this.lock) {
            hashSet.addAll(this.zzefq);
            this.zzefq.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zzefp.zzn(context, this.zzefo.zzyw()));
        Bundle bundle2 = new Bundle();
        Iterator<zzbaa> it = this.zzefr.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((zzazr) it2.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzazy.zza(hashSet);
            return bundle;
        }
        zzbaa next = it.next();
        throw new NoSuchMethodError();
    }

    public final void zzq(boolean z) {
        long currentTimeMillis = zzr.zzlc().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zzecl.zzzh() > ((Long) zzww.zzra().zzd(zzabq.zzcqb)).longValue()) {
                this.zzefp.zzefg = -1;
            } else {
                this.zzefp.zzefg = this.zzecl.zzzi();
            }
            this.zzefs = true;
            return;
        }
        this.zzecl.zzfa(currentTimeMillis);
        this.zzecl.zzdj(this.zzefp.zzefg);
    }

    public final void zzyc() {
        synchronized (this.lock) {
            this.zzefp.zzyc();
        }
    }

    public final void zzyb() {
        synchronized (this.lock) {
            this.zzefp.zzyb();
        }
    }

    public final void zza(zzvq zzvq, long j) {
        synchronized (this.lock) {
            this.zzefp.zza(zzvq, j);
        }
    }

    public final zzazr zza(Clock clock, String str) {
        return new zzazr(clock, this, this.zzefo.zzyv(), str);
    }

    public final boolean zzyy() {
        return this.zzefs;
    }
}
