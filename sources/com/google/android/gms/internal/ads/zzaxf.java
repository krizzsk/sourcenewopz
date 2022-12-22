package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzay;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzeqz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaxf implements zzaxo {
    /* access modifiers changed from: private */
    public static List<Future<Void>> zzebi = Collections.synchronizedList(new ArrayList());
    private final Context context;
    private final Object lock = new Object();
    private final zzaxn zzdyb;
    private final zzeqz.zzb.C22018zzb zzebj;
    private final LinkedHashMap<String, zzeqz.zzb.zzh.C22024zzb> zzebk;
    private final List<String> zzebl = new ArrayList();
    private final List<String> zzebm = new ArrayList();
    private final zzaxq zzebn;
    private boolean zzebo;
    private HashSet<String> zzebp = new HashSet<>();
    private boolean zzebq = false;
    private boolean zzebr = false;
    private boolean zzebs = false;

    public zzaxf(Context context2, zzbar zzbar, zzaxn zzaxn, String str, zzaxq zzaxq) {
        Preconditions.checkNotNull(zzaxn, "SafeBrowsing config is not present.");
        this.context = context2.getApplicationContext() != null ? context2.getApplicationContext() : context2;
        this.zzebk = new LinkedHashMap<>();
        this.zzebn = zzaxq;
        this.zzdyb = zzaxn;
        for (String lowerCase : zzaxn.zzeca) {
            this.zzebp.add(lowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.zzebp.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzeqz.zzb.C22018zzb zzbmo = zzeqz.zzb.zzbmo();
        zzbmo.zzb(zzeqz.zzb.zzg.OCTAGON_AD);
        zzbmo.zzif(str);
        zzbmo.zzig(str);
        zzeqz.zzb.zza.C22017zza zzbmq = zzeqz.zzb.zza.zzbmq();
        if (this.zzdyb.zzebw != null) {
            zzbmq.zzii(this.zzdyb.zzebw);
        }
        zzbmo.zzb((zzeqz.zzb.zza) ((zzena) zzbmq.zzbjv()));
        zzeqz.zzb.zzi.zza zzca = zzeqz.zzb.zzi.zzbnf().zzca(Wrappers.packageManager(this.context).isCallerInstantApp());
        if (zzbar.zzbrz != null) {
            zzca.zzin(zzbar.zzbrz);
        }
        long apkVersion = (long) GoogleApiAvailabilityLight.getInstance().getApkVersion(this.context);
        if (apkVersion > 0) {
            zzca.zzft(apkVersion);
        }
        zzbmo.zzb((zzeqz.zzb.zzi) ((zzena) zzca.zzbjv()));
        this.zzebj = zzbmo;
    }

    static final /* synthetic */ Void zzdy(String str) {
        return null;
    }

    public final zzaxn zzxg() {
        return this.zzdyb;
    }

    public final void zzdw(String str) {
        synchronized (this.lock) {
            if (str == null) {
                this.zzebj.zzbms();
            } else {
                this.zzebj.zzih(str);
            }
        }
    }

    public final boolean zzxh() {
        return PlatformVersion.isAtLeastKitKat() && this.zzdyb.zzeby && !this.zzebr;
    }

    public final void zzl(View view) {
        if (this.zzdyb.zzeby && !this.zzebr) {
            zzr.zzkv();
            Bitmap zzn = zzj.zzn(view);
            if (zzn == null) {
                zzaxp.zzdz("Failed to capture the webview bitmap.");
                return;
            }
            this.zzebr = true;
            zzj.zzc((Runnable) new zzaxe(this, zzn));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            r1 = 3
            if (r9 != r1) goto L_0x0009
            r2 = 1
            r6.zzebs = r2     // Catch:{ all -> 0x00bd }
        L_0x0009:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzeqz$zzb$zzh$zzb> r2 = r6.zzebk     // Catch:{ all -> 0x00bd }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x0024
            if (r9 != r1) goto L_0x0022
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzeqz$zzb$zzh$zzb> r8 = r6.zzebk     // Catch:{ all -> 0x00bd }
            java.lang.Object r7 = r8.get(r7)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeqz$zzb$zzh$zzb r7 = (com.google.android.gms.internal.ads.zzeqz.zzb.zzh.C22024zzb) r7     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeqz$zzb$zzh$zza r8 = com.google.android.gms.internal.ads.zzeqz.zzb.zzh.zza.zzij(r9)     // Catch:{ all -> 0x00bd }
            r7.zzb((com.google.android.gms.internal.ads.zzeqz.zzb.zzh.zza) r8)     // Catch:{ all -> 0x00bd }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            return
        L_0x0024:
            com.google.android.gms.internal.ads.zzeqz$zzb$zzh$zzb r1 = com.google.android.gms.internal.ads.zzeqz.zzb.zzh.zzbnd()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeqz$zzb$zzh$zza r9 = com.google.android.gms.internal.ads.zzeqz.zzb.zzh.zza.zzij(r9)     // Catch:{ all -> 0x00bd }
            if (r9 == 0) goto L_0x0031
            r1.zzb((com.google.android.gms.internal.ads.zzeqz.zzb.zzh.zza) r9)     // Catch:{ all -> 0x00bd }
        L_0x0031:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzeqz$zzb$zzh$zzb> r9 = r6.zzebk     // Catch:{ all -> 0x00bd }
            int r9 = r9.size()     // Catch:{ all -> 0x00bd }
            r1.zzik(r9)     // Catch:{ all -> 0x00bd }
            r1.zzil(r7)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeqz$zzb$zzd$zzb r9 = com.google.android.gms.internal.ads.zzeqz.zzb.zzd.zzbmv()     // Catch:{ all -> 0x00bd }
            java.util.HashSet<java.lang.String> r2 = r6.zzebp     // Catch:{ all -> 0x00bd }
            int r2 = r2.size()     // Catch:{ all -> 0x00bd }
            if (r2 <= 0) goto L_0x00ab
            if (r8 == 0) goto L_0x00ab
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x00bd }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00bd }
        L_0x0053:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x00ab
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x00bd }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00bd }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00bd }
            if (r3 == 0) goto L_0x006c
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00bd }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00bd }
            goto L_0x006e
        L_0x006c:
            java.lang.String r3 = ""
        L_0x006e:
            java.lang.Object r4 = r2.getValue()     // Catch:{ all -> 0x00bd }
            if (r4 == 0) goto L_0x007b
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00bd }
            goto L_0x007d
        L_0x007b:
            java.lang.String r2 = ""
        L_0x007d:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = r3.toLowerCase(r4)     // Catch:{ all -> 0x00bd }
            java.util.HashSet<java.lang.String> r5 = r6.zzebp     // Catch:{ all -> 0x00bd }
            boolean r4 = r5.contains(r4)     // Catch:{ all -> 0x00bd }
            if (r4 == 0) goto L_0x0053
            com.google.android.gms.internal.ads.zzeqz$zzb$zzc$zza r4 = com.google.android.gms.internal.ads.zzeqz.zzb.zzc.zzbmt()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzelq r3 = com.google.android.gms.internal.ads.zzelq.zzhz(r3)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeqz$zzb$zzc$zza r3 = r4.zzap(r3)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzelq r2 = com.google.android.gms.internal.ads.zzelq.zzhz(r2)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeqz$zzb$zzc$zza r2 = r3.zzaq(r2)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeon r2 = r2.zzbjv()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzena r2 = (com.google.android.gms.internal.ads.zzena) r2     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeqz$zzb$zzc r2 = (com.google.android.gms.internal.ads.zzeqz.zzb.zzc) r2     // Catch:{ all -> 0x00bd }
            r9.zzb(r2)     // Catch:{ all -> 0x00bd }
            goto L_0x0053
        L_0x00ab:
            com.google.android.gms.internal.ads.zzeon r8 = r9.zzbjv()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzena r8 = (com.google.android.gms.internal.ads.zzena) r8     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeqz$zzb$zzd r8 = (com.google.android.gms.internal.ads.zzeqz.zzb.zzd) r8     // Catch:{ all -> 0x00bd }
            r1.zzb((com.google.android.gms.internal.ads.zzeqz.zzb.zzd) r8)     // Catch:{ all -> 0x00bd }
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzeqz$zzb$zzh$zzb> r8 = r6.zzebk     // Catch:{ all -> 0x00bd }
            r8.put(r7, r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            return
        L_0x00bd:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxf.zza(java.lang.String, java.util.Map, int):void");
    }

    public final void zzxi() {
        this.zzebq = true;
    }

    private final zzeqz.zzb.zzh.C22024zzb zzdx(String str) {
        zzeqz.zzb.zzh.C22024zzb zzb;
        synchronized (this.lock) {
            zzb = this.zzebk.get(str);
        }
        return zzb;
    }

    public final void zzxj() {
        synchronized (this.lock) {
            zzebt<O> zzb = zzebh.zzb(this.zzebn.zza(this.context, this.zzebk.keySet()), new zzaxh(this), (Executor) zzbat.zzekj);
            zzebt<O> zza = zzebh.zza(zzb, 10, TimeUnit.SECONDS, zzbat.zzekh);
            zzebh.zza(zzb, new zzaxi(this, zza), zzbat.zzekj);
            zzebi.add(zza);
        }
    }

    private final zzebt<Void> zzxk() {
        zzebt<Void> zzb;
        if (!((this.zzebo && this.zzdyb.zzecc) || (this.zzebs && this.zzdyb.zzecb) || (!this.zzebo && this.zzdyb.zzebz))) {
            return zzebh.zzag(null);
        }
        synchronized (this.lock) {
            for (zzeqz.zzb.zzh.C22024zzb zzbjv : this.zzebk.values()) {
                this.zzebj.zzb((zzeqz.zzb.zzh) ((zzena) zzbjv.zzbjv()));
            }
            this.zzebj.zzo(this.zzebl);
            this.zzebj.zzp(this.zzebm);
            if (zzaxp.isEnabled()) {
                String url = this.zzebj.getUrl();
                String zzbmm = this.zzebj.zzbmm();
                StringBuilder sb = new StringBuilder(String.valueOf(url).length() + 53 + String.valueOf(zzbmm).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(url);
                sb.append("\n  clickUrl: ");
                sb.append(zzbmm);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzeqz.zzb.zzh next : this.zzebj.zzbml()) {
                    sb2.append("    [");
                    sb2.append(next.zzbnc());
                    sb2.append("] ");
                    sb2.append(next.getUrl());
                }
                zzaxp.zzdz(sb2.toString());
            }
            zzebt<String> zza = new zzay(this.context).zza(1, this.zzdyb.zzebx, (Map<String, String>) null, ((zzeqz.zzb) ((zzena) this.zzebj.zzbjv())).toByteArray());
            if (zzaxp.isEnabled()) {
                zza.addListener(zzaxg.zzebt, zzbat.zzeke);
            }
            zzb = zzebh.zzb(zza, zzaxj.zzebv, (Executor) zzbat.zzekj);
        }
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzi(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.lock) {
                            int length = optJSONArray.length();
                            zzeqz.zzb.zzh.C22024zzb zzdx = zzdx(str);
                            if (zzdx == null) {
                                String valueOf = String.valueOf(str);
                                zzaxp.zzdz(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                boolean z = false;
                                for (int i = 0; i < length; i++) {
                                    zzdx.zzim(optJSONArray.getJSONObject(i).getString("threat_type"));
                                }
                                boolean z2 = this.zzebo;
                                if (length > 0) {
                                    z = true;
                                }
                                this.zzebo = z | z2;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (zzadt.zzdfx.get().booleanValue()) {
                    zzd.zzb("Failed to get SafeBrowsing metadata", e);
                }
                return zzebh.immediateFailedFuture(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zzebo) {
            synchronized (this.lock) {
                this.zzebj.zzb(zzeqz.zzb.zzg.OCTAGON_AD_SB_MATCH);
            }
        }
        return zzxk();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Bitmap bitmap) {
        zzelz zzbhk = zzelq.zzbhk();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzbhk);
        synchronized (this.lock) {
            this.zzebj.zzb((zzeqz.zzb.zzf) ((zzena) zzeqz.zzb.zzf.zzbna().zzas(zzbhk.zzbgy()).zzij("image/png").zzb(zzeqz.zzb.zzf.zza.TYPE_CREATIVE).zzbjv()));
        }
    }
}
