package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcna {
    private boolean enabled = true;
    /* access modifiers changed from: private */
    public final Executor executor;
    private final zzbar zzbpj;
    private final Context zzcmo;
    private final Executor zzfur;
    private final ScheduledExecutorService zzfvp;
    private boolean zzgpb = false;
    private boolean zzgpc = false;
    /* access modifiers changed from: private */
    public boolean zzgpd = false;
    /* access modifiers changed from: private */
    public final long zzgpe;
    /* access modifiers changed from: private */
    public final zzbbe<Boolean> zzgpf = new zzbbe<>();
    private final WeakReference<Context> zzgpg;
    private final zzckb zzgph;
    /* access modifiers changed from: private */
    public final zzcmk zzgpi;
    private Map<String, zzajm> zzgpj = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final zzbyr zzgpk;

    public zzcna(Executor executor2, Context context, WeakReference<Context> weakReference, Executor executor3, zzckb zzckb, ScheduledExecutorService scheduledExecutorService, zzcmk zzcmk, zzbar zzbar, zzbyr zzbyr) {
        this.zzgph = zzckb;
        this.zzcmo = context;
        this.zzgpg = weakReference;
        this.executor = executor3;
        this.zzfvp = scheduledExecutorService;
        this.zzfur = executor2;
        this.zzgpi = zzcmk;
        this.zzbpj = zzbar;
        this.zzgpk = zzbyr;
        this.zzgpe = zzr.zzlc().elapsedRealtime();
        zza("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public final void disable() {
        this.enabled = false;
    }

    public final void zzb(zzajt zzajt) {
        this.zzgpf.addListener(new zzcnd(this, zzajt), this.zzfur);
    }

    public final void zzarv() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrz)).booleanValue() && !zzado.zzdfh.get().booleanValue()) {
            if (this.zzbpj.zzekb >= ((Integer) zzww.zzra().zzd(zzabq.zzcsa)).intValue() && this.enabled) {
                if (!this.zzgpb) {
                    synchronized (this) {
                        if (!this.zzgpb) {
                            this.zzgpi.zzars();
                            this.zzgpk.zzang();
                            this.zzgpf.addListener(new zzcnc(this), this.executor);
                            this.zzgpb = true;
                            zzebt<String> zzarx = zzarx();
                            this.zzfvp.schedule(new zzcne(this), ((Long) zzww.zzra().zzd(zzabq.zzcsc)).longValue(), TimeUnit.SECONDS);
                            zzebh.zza(zzarx, new zzcnl(this), this.executor);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.zzgpb) {
            zza("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zzgpf.set(false);
            this.zzgpb = true;
            this.zzgpc = true;
        }
    }

    public final List<zzajm> zzarw() {
        ArrayList arrayList = new ArrayList();
        for (String next : this.zzgpj.keySet()) {
            zzajm zzajm = this.zzgpj.get(next);
            arrayList.add(new zzajm(next, zzajm.zzdkb, zzajm.zzdkc, zzajm.description));
        }
        return arrayList;
    }

    private final synchronized zzebt<String> zzarx() {
        String zzyr = zzr.zzkz().zzyl().zzzg().zzyr();
        if (!TextUtils.isEmpty(zzyr)) {
            return zzebh.zzag(zzyr);
        }
        zzbbe zzbbe = new zzbbe();
        zzr.zzkz().zzyl().zzb(new zzcnf(this, zzbbe));
        return zzbbe;
    }

    /* access modifiers changed from: private */
    public final void zzgi(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = new Object();
                zzbbe zzbbe = new zzbbe();
                zzebt zza = zzebh.zza(zzbbe, ((Long) zzww.zzra().zzd(zzabq.zzcsb)).longValue(), TimeUnit.SECONDS, this.zzfvp);
                this.zzgpi.zzgg(next);
                this.zzgpk.zzfu(next);
                long elapsedRealtime = zzr.zzlc().elapsedRealtime();
                Iterator<String> it = keys;
                zzcnh zzcnh = r1;
                zzcnh zzcnh2 = new zzcnh(this, obj, zzbbe, next, elapsedRealtime);
                zza.addListener(zzcnh, this.executor);
                arrayList.add(zza);
                zzcnn zzcnn = new zzcnn(this, obj, next, elapsedRealtime, zzbbe);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzajw(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zza(next, false, "", 0);
                try {
                    this.zzfur.execute(new zzcnj(this, this.zzgph.zzd(next, new JSONObject()), zzcnn, arrayList2, next));
                } catch (zzdpq unused2) {
                    try {
                        zzcnn.onInitializationFailed("Failed to create Adapter.");
                    } catch (RemoteException e) {
                        zzbao.zzc("", e);
                    }
                }
                keys = it;
            }
            zzebh.zzj(arrayList).zzb(new zzcng(this), this.executor);
        } catch (JSONException e2) {
            zzd.zza("Malformed CLD response", e2);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(String str, boolean z, String str2, int i) {
        this.zzgpj.put(str, new zzajm(str, z, i, str2));
    }

    public final boolean zzary() {
        return this.zzgpc;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        com.google.android.gms.internal.ads.zzbao.zzc("", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 74);
        r4.append("Failed to initialize adapter. ");
        r4.append(r5);
        r4.append(" does not implement the initialize() method.");
        r3.onInitializationFailed(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzdqd r2, com.google.android.gms.internal.ads.zzajo r3, java.util.List r4, java.lang.String r5) {
        /*
            r1 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.zzgpg     // Catch:{ zzdpq -> 0x0011 }
            java.lang.Object r0 = r0.get()     // Catch:{ zzdpq -> 0x0011 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ zzdpq -> 0x0011 }
            if (r0 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            android.content.Context r0 = r1.zzcmo     // Catch:{ zzdpq -> 0x0011 }
        L_0x000d:
            r2.zza((android.content.Context) r0, (com.google.android.gms.internal.ads.zzajo) r3, (java.util.List<com.google.android.gms.internal.ads.zzajw>) r4)     // Catch:{ zzdpq -> 0x0011 }
            return
        L_0x0011:
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2.length()     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2 + 74
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0035 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = "Failed to initialize adapter. "
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            r4.append(r5)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = " does not implement the initialize() method."
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = r4.toString()     // Catch:{ RemoteException -> 0x0035 }
            r3.onInitializationFailed(r2)     // Catch:{ RemoteException -> 0x0035 }
            return
        L_0x0035:
            r2 = move-exception
            java.lang.String r3 = ""
            com.google.android.gms.internal.ads.zzbao.zzc(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcna.zza(com.google.android.gms.internal.ads.zzdqd, com.google.android.gms.internal.ads.zzajo, java.util.List, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzarz() throws Exception {
        this.zzgpf.set(true);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzbbe zzbbe, String str, long j) {
        synchronized (obj) {
            if (!zzbbe.isDone()) {
                zza(str, false, "Timeout.", (int) (zzr.zzlc().elapsedRealtime() - j));
                this.zzgpi.zzt(str, "timeout");
                this.zzgpk.zzn(str, "timeout");
                zzbbe.set(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzasa() {
        synchronized (this) {
            if (!this.zzgpd) {
                zza("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzr.zzlc().elapsedRealtime() - this.zzgpe));
                this.zzgpf.setException(new Exception());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbbe zzbbe) {
        this.executor.execute(new zzcni(this, zzbbe));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzasb() {
        this.zzgpi.zzart();
        this.zzgpk.zzanh();
        this.zzgpc = true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzajt zzajt) {
        try {
            zzajt.zze(zzarw());
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}
