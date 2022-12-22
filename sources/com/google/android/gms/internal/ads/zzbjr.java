package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbjr extends zzyk {
    private final Context context;
    private final zzbar zzbpx;
    private final zzayd zzbrf;
    private final zzckb zzfsr;
    private final zzcta<zzdqd, zzcuu> zzfss;
    private final zzczb zzfst;
    private final zzcna zzfsu;
    private final zzckd zzfsv;
    private boolean zzzq = false;

    zzbjr(Context context2, zzbar zzbar, zzckb zzckb, zzcta<zzdqd, zzcuu> zzcta, zzczb zzczb, zzcna zzcna, zzayd zzayd, zzckd zzckd) {
        this.context = context2;
        this.zzbpx = zzbar;
        this.zzfsr = zzckb;
        this.zzfss = zzcta;
        this.zzfst = zzczb;
        this.zzfsu = zzcna;
        this.zzbrf = zzayd;
        this.zzfsv = zzckd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void initialize() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzzq     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "Mobile ads is initialized already."
            com.google.android.gms.ads.internal.util.zzd.zzez(r0)     // Catch:{ all -> 0x005d }
            monitor-exit(r3)
            return
        L_0x000c:
            android.content.Context r0 = r3.context     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzabq.initialize(r0)     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzazs r0 = com.google.android.gms.ads.internal.zzr.zzkz()     // Catch:{ all -> 0x005d }
            android.content.Context r1 = r3.context     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzbar r2 = r3.zzbpx     // Catch:{ all -> 0x005d }
            r0.zzd(r1, r2)     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzta r0 = com.google.android.gms.ads.internal.zzr.zzlb()     // Catch:{ all -> 0x005d }
            android.content.Context r1 = r3.context     // Catch:{ all -> 0x005d }
            r0.initialize(r1)     // Catch:{ all -> 0x005d }
            r0 = 1
            r3.zzzq = r0     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzcna r0 = r3.zzfsu     // Catch:{ all -> 0x005d }
            r0.zzarv()     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcrp     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x005d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005d }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzczb r0 = r3.zzfst     // Catch:{ all -> 0x005d }
            r0.zzaqq()     // Catch:{ all -> 0x005d }
        L_0x0044:
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcum     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x005d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005d }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzckd r0 = r3.zzfsv     // Catch:{ all -> 0x005d }
            r0.zzaqq()     // Catch:{ all -> 0x005d }
        L_0x005b:
            monitor-exit(r3)
            return
        L_0x005d:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjr.initialize():void");
    }

    public final synchronized void setAppVolume(float f) {
        zzr.zzla().setAppVolume(f);
    }

    public final synchronized float zzrg() {
        return zzr.zzla().zzrg();
    }

    public final synchronized void setAppMuted(boolean z) {
        zzr.zzla().setAppMuted(z);
    }

    public final synchronized boolean zzrh() {
        return zzr.zzla().zzrh();
    }

    public final synchronized void zzcd(String str) {
        zzabq.initialize(this.context);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcul)).booleanValue()) {
                zzr.zzld().zza(this.context, this.zzbpx, str, (Runnable) null);
            }
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzd.zzex("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context2 == null) {
            zzd.zzex("Context is null. Failed to open debug menu.");
            return;
        }
        zzad zzad = new zzad(context2);
        zzad.setAdUnitId(str);
        zzad.zzu(this.zzbpx.zzbrz);
        zzad.showDialog();
    }

    public final void zza(String str, IObjectWrapper iObjectWrapper) {
        String str2;
        zzabq.initialize(this.context);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcuo)).booleanValue()) {
            zzr.zzkv();
            str2 = zzj.zzbb(this.context);
        } else {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            boolean booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcul)).booleanValue() | ((Boolean) zzww.zzra().zzd(zzabq.zzcpw)).booleanValue();
            zzbjq zzbjq = null;
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcpw)).booleanValue()) {
                booleanValue = true;
                zzbjq = new zzbjq(this, (Runnable) ObjectWrapper.unwrap(iObjectWrapper));
            }
            if (booleanValue) {
                zzr.zzld().zza(this.context, this.zzbpx, str, (Runnable) zzbjq);
            }
        }
    }

    public final String getVersionString() {
        return this.zzbpx.zzbrz;
    }

    public final void zzce(String str) {
        this.zzfst.zzgq(str);
    }

    public final void zza(zzann zzann) throws RemoteException {
        this.zzfsr.zzb(zzann);
    }

    public final void zza(zzajt zzajt) throws RemoteException {
        this.zzfsu.zzb(zzajt);
    }

    public final List<zzajm> zzri() throws RemoteException {
        return this.zzfsu.zzarw();
    }

    public final void zza(zzaat zzaat) throws RemoteException {
        this.zzbrf.zza(this.context, zzaat);
    }

    public final void zzrj() {
        this.zzfsu.disable();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzani> zzyt = zzr.zzkz().zzyl().zzzg().zzyt();
        if (zzyt != null && !zzyt.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzd.zzd("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzfsr.zzaqo()) {
                HashMap hashMap = new HashMap();
                for (zzani zzani : zzyt.values()) {
                    for (zzanj next : zzani.zzdmy) {
                        String str = next.zzdod;
                        for (String next2 : next.zzdnv) {
                            if (!hashMap.containsKey(next2)) {
                                hashMap.put(next2, new ArrayList());
                            }
                            if (str != null) {
                                ((Collection) hashMap.get(next2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    try {
                        zzctb<zzdqd, zzcuu> zzf = this.zzfss.zzf(str2, jSONObject);
                        if (zzf != null) {
                            zzdqd zzdqd = (zzdqd) zzf.zzdoy;
                            if (!zzdqd.isInitialized()) {
                                if (zzdqd.zzvj()) {
                                    zzdqd.zza(this.context, (zzavu) (zzcuu) zzf.zzgvk, (List<String>) (List) entry.getValue());
                                    String valueOf = String.valueOf(str2);
                                    zzd.zzdz(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                                }
                            }
                        }
                    } catch (zzdpq e) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                        sb.append("Failed to initialize rewarded video mediation adapter \"");
                        sb.append(str2);
                        sb.append(Const.jsQuote);
                        zzd.zzd(sb.toString(), e);
                    }
                }
            }
        }
    }
}
