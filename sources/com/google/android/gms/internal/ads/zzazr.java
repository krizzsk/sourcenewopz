package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.didichuxing.afanty.common.utils.Constants;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzazr {
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public final Clock zzbqq;
    private final String zzdvz;
    private boolean zzdxi = false;
    private long zzdxm = -1;
    private final zzbac zzedz;
    private final LinkedList<zzazq> zzeea;
    private final String zzeeb;
    private long zzeec = -1;
    private long zzeed = -1;
    private long zzeee = 0;
    private long zzeef = -1;
    private long zzeeg = -1;

    zzazr(Clock clock, zzbac zzbac, String str, String str2) {
        this.zzbqq = clock;
        this.zzedz = zzbac;
        this.zzeeb = str;
        this.zzdvz = str2;
        this.zzeea = new LinkedList<>();
    }

    public final void zze(zzvq zzvq) {
        synchronized (this.lock) {
            long elapsedRealtime = this.zzbqq.elapsedRealtime();
            this.zzeef = elapsedRealtime;
            this.zzedz.zza(zzvq, elapsedRealtime);
        }
    }

    public final void zzey(long j) {
        synchronized (this.lock) {
            this.zzeeg = j;
            if (j != -1) {
                this.zzedz.zzb(this);
            }
        }
    }

    public final void zzyb() {
        synchronized (this.lock) {
            if (this.zzeeg != -1 && this.zzeec == -1) {
                this.zzeec = this.zzbqq.elapsedRealtime();
                this.zzedz.zzb(this);
            }
            this.zzedz.zzyb();
        }
    }

    public final void zzyc() {
        synchronized (this.lock) {
            if (this.zzeeg != -1) {
                zzazq zzazq = new zzazq(this);
                zzazq.zzya();
                this.zzeea.add(zzazq);
                this.zzeee++;
                this.zzedz.zzyc();
                this.zzedz.zzb(this);
            }
        }
    }

    public final void zzyd() {
        synchronized (this.lock) {
            if (this.zzeeg != -1 && !this.zzeea.isEmpty()) {
                zzazq last = this.zzeea.getLast();
                if (last.zzxy() == -1) {
                    last.zzxz();
                    this.zzedz.zzb(this);
                }
            }
        }
    }

    public final void zzar(boolean z) {
        synchronized (this.lock) {
            if (this.zzeeg != -1) {
                this.zzeed = this.zzbqq.elapsedRealtime();
            }
        }
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzeeb);
            bundle.putString("slotid", this.zzdvz);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.zzeef);
            bundle.putLong("tresponse", this.zzeeg);
            bundle.putLong("timp", this.zzeec);
            bundle.putLong("tload", this.zzeed);
            bundle.putLong(Constants.JSON_KEY_PHONE_COUNTRY_CODE, this.zzeee);
            bundle.putLong("tfetch", this.zzdxm);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzeea.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzazq) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final String zzye() {
        return this.zzeeb;
    }
}
