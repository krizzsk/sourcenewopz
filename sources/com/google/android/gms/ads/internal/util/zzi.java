package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.request.ServerParam;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzrq;
import com.google.android.gms.internal.ads.zzww;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzi implements zzf {
    private final Object lock = new Object();
    private SharedPreferences zzcmn;
    private boolean zzdvu = true;
    private boolean zzdxs = true;
    private boolean zzdyd = true;
    private boolean zzefv;
    private final List<Runnable> zzefw = new ArrayList();
    private zzebt<?> zzefx;
    private zzrq zzefy = null;
    private SharedPreferences.Editor zzefz;
    private boolean zzega = false;
    private String zzegb;
    private String zzegc;
    private boolean zzegd = true;
    private zzazt zzege = new zzazt("", 0);
    private long zzegf = 0;
    private long zzegg = 0;
    private int zzegh = -1;
    private int zzegi = 0;
    private Set<String> zzegj = Collections.emptySet();
    private JSONObject zzegk = new JSONObject();
    private String zzegl = null;
    private int zzegm = -1;
    private int zzegn = -1;

    public final void initialize(Context context) {
        synchronized (this.lock) {
            if (this.zzcmn == null) {
                this.zzefx = zzbat.zzeke.zzg(new zzh(this, context, "admob"));
                this.zzefv = true;
            }
        }
    }

    private final void zzzo() {
        zzebt<?> zzebt = this.zzefx;
        if (zzebt != null && !zzebt.isDone()) {
            try {
                this.zzefx.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                zzd.zzd("Interrupted while waiting for preferences loaded.", e);
            } catch (CancellationException | ExecutionException | TimeoutException e2) {
                zzd.zzc("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    private final void zzzp() {
        zzbat.zzeke.execute(new zzk(this));
    }

    public final zzrq zzza() {
        if (!this.zzefv) {
            return null;
        }
        if ((zzzb() && zzzd()) || !zzadh.zzdef.get().booleanValue()) {
            return null;
        }
        synchronized (this.lock) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zzefy == null) {
                this.zzefy = new zzrq();
            }
            this.zzefy.zzmo();
            zzd.zzey("start fetching content...");
            zzrq zzrq = this.zzefy;
            return zzrq;
        }
    }

    public final void zzas(boolean z) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzdxs != z) {
                this.zzdxs = z;
                if (this.zzefz != null) {
                    this.zzefz.putBoolean("content_url_opted_out", z);
                    this.zzefz.apply();
                }
                zzzp();
            }
        }
    }

    public final boolean zzzb() {
        boolean z;
        zzzo();
        synchronized (this.lock) {
            z = this.zzdxs;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzee(java.lang.String r4) {
        /*
            r3 = this;
            r3.zzzo()
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0028
            java.lang.String r1 = r3.zzegb     // Catch:{ all -> 0x002a }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0011
            goto L_0x0028
        L_0x0011:
            r3.zzegb = r4     // Catch:{ all -> 0x002a }
            android.content.SharedPreferences$Editor r1 = r3.zzefz     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.zzefz     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "content_url_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x002a }
            android.content.SharedPreferences$Editor r4 = r3.zzefz     // Catch:{ all -> 0x002a }
            r4.apply()     // Catch:{ all -> 0x002a }
        L_0x0023:
            r3.zzzp()     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzi.zzee(java.lang.String):void");
    }

    public final String zzzc() {
        String str;
        zzzo();
        synchronized (this.lock) {
            str = this.zzegb;
        }
        return str;
    }

    public final void zzat(boolean z) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzdyd != z) {
                this.zzdyd = z;
                if (this.zzefz != null) {
                    this.zzefz.putBoolean("content_vertical_opted_out", z);
                    this.zzefz.apply();
                }
                zzzp();
            }
        }
    }

    public final boolean zzzd() {
        boolean z;
        zzzo();
        synchronized (this.lock) {
            z = this.zzdyd;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzef(java.lang.String r4) {
        /*
            r3 = this;
            r3.zzzo()
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0028
            java.lang.String r1 = r3.zzegc     // Catch:{ all -> 0x002a }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0011
            goto L_0x0028
        L_0x0011:
            r3.zzegc = r4     // Catch:{ all -> 0x002a }
            android.content.SharedPreferences$Editor r1 = r3.zzefz     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.zzefz     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "content_vertical_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x002a }
            android.content.SharedPreferences$Editor r4 = r3.zzefz     // Catch:{ all -> 0x002a }
            r4.apply()     // Catch:{ all -> 0x002a }
        L_0x0023:
            r3.zzzp()     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzi.zzef(java.lang.String):void");
    }

    public final String zzze() {
        String str;
        zzzo();
        synchronized (this.lock) {
            str = this.zzegc;
        }
        return str;
    }

    public final void zzau(boolean z) {
        zzzo();
        synchronized (this.lock) {
            if (z != this.zzegd) {
                this.zzegd = z;
                if (this.zzefz != null) {
                    this.zzefz.putBoolean("gad_idless", z);
                    this.zzefz.apply();
                }
                zzzp();
            }
        }
    }

    public final boolean zzzn() {
        boolean z;
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcpg)).booleanValue()) {
            return false;
        }
        zzzo();
        synchronized (this.lock) {
            z = this.zzegd;
        }
        return z;
    }

    public final void zzdi(int i) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzegi != i) {
                this.zzegi = i;
                if (this.zzefz != null) {
                    this.zzefz.putInt(ServerParam.PARAM_VERSION_CODE, i);
                    this.zzefz.apply();
                }
                zzzp();
            }
        }
    }

    public final int zzzf() {
        int i;
        zzzo();
        synchronized (this.lock) {
            i = this.zzegi;
        }
        return i;
    }

    public final void zzeg(String str) {
        zzzo();
        synchronized (this.lock) {
            long currentTimeMillis = zzr.zzlc().currentTimeMillis();
            if (str != null) {
                if (!str.equals(this.zzege.zzyr())) {
                    this.zzege = new zzazt(str, currentTimeMillis);
                    if (this.zzefz != null) {
                        this.zzefz.putString("app_settings_json", str);
                        this.zzefz.putLong("app_settings_last_update_ms", currentTimeMillis);
                        this.zzefz.apply();
                    }
                    zzzp();
                    for (Runnable run : this.zzefw) {
                        run.run();
                    }
                    return;
                }
            }
            this.zzege.zzez(currentTimeMillis);
        }
    }

    public final zzazt zzzg() {
        zzazt zzazt;
        zzzo();
        synchronized (this.lock) {
            zzazt = this.zzege;
        }
        return zzazt;
    }

    public final void zzb(Runnable runnable) {
        this.zzefw.add(runnable);
    }

    public final void zzfa(long j) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzegf != j) {
                this.zzegf = j;
                if (this.zzefz != null) {
                    this.zzefz.putLong("app_last_background_time_ms", j);
                    this.zzefz.apply();
                }
                zzzp();
            }
        }
    }

    public final long zzzh() {
        long j;
        zzzo();
        synchronized (this.lock) {
            j = this.zzegf;
        }
        return j;
    }

    public final void zzdj(int i) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzegh != i) {
                this.zzegh = i;
                if (this.zzefz != null) {
                    this.zzefz.putInt("request_in_session_count", i);
                    this.zzefz.apply();
                }
                zzzp();
            }
        }
    }

    public final int zzzi() {
        int i;
        zzzo();
        synchronized (this.lock) {
            i = this.zzegh;
        }
        return i;
    }

    public final void zzfb(long j) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzegg != j) {
                this.zzegg = j;
                if (this.zzefz != null) {
                    this.zzefz.putLong("first_ad_req_time_ms", j);
                    this.zzefz.apply();
                }
                zzzp();
            }
        }
    }

    public final long zzzj() {
        long j;
        zzzo();
        synchronized (this.lock) {
            j = this.zzegg;
        }
        return j;
    }

    public final void zza(String str, String str2, boolean z) {
        zzzo();
        synchronized (this.lock) {
            JSONArray optJSONArray = this.zzegk.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                if (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        if (!str2.equals(optJSONObject.optString("template_id"))) {
                            i++;
                        } else if (!z || !optJSONObject.optBoolean("uses_media_view", false)) {
                            length = i;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzr.zzlc().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzegk.put(str, optJSONArray);
            } catch (JSONException e) {
                zzd.zzd("Could not update native advanced settings", e);
            }
            if (this.zzefz != null) {
                this.zzefz.putString("native_advanced_settings", this.zzegk.toString());
                this.zzefz.apply();
            }
            zzzp();
        }
    }

    public final JSONObject zzzk() {
        JSONObject jSONObject;
        zzzo();
        synchronized (this.lock) {
            jSONObject = this.zzegk;
        }
        return jSONObject;
    }

    public final void zzzl() {
        zzzo();
        synchronized (this.lock) {
            this.zzegk = new JSONObject();
            if (this.zzefz != null) {
                this.zzefz.remove("native_advanced_settings");
                this.zzefz.apply();
            }
            zzzp();
        }
    }

    public final String zzzm() {
        String str;
        zzzo();
        synchronized (this.lock) {
            str = this.zzegl;
        }
        return str;
    }

    public final void zzeh(String str) {
        zzzo();
        synchronized (this.lock) {
            if (!TextUtils.equals(this.zzegl, str)) {
                this.zzegl = str;
                if (this.zzefz != null) {
                    this.zzefz.putString("display_cutout", str);
                    this.zzefz.apply();
                }
                zzzp();
            }
        }
    }

    public final void zzdk(int i) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzegn != i) {
                this.zzegn = i;
                if (this.zzefz != null) {
                    this.zzefz.putInt("sd_app_measure_npa", i);
                    this.zzefz.apply();
                }
                zzzp();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.lock) {
            this.zzcmn = sharedPreferences;
            this.zzefz = edit;
            if (PlatformVersion.isAtLeastM() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.zzega = z;
            this.zzdvu = this.zzcmn.getBoolean("use_https", this.zzdvu);
            this.zzdxs = this.zzcmn.getBoolean("content_url_opted_out", this.zzdxs);
            this.zzegb = this.zzcmn.getString("content_url_hashes", this.zzegb);
            this.zzegd = this.zzcmn.getBoolean("gad_idless", this.zzegd);
            this.zzdyd = this.zzcmn.getBoolean("content_vertical_opted_out", this.zzdyd);
            this.zzegc = this.zzcmn.getString("content_vertical_hashes", this.zzegc);
            this.zzegi = this.zzcmn.getInt(ServerParam.PARAM_VERSION_CODE, this.zzegi);
            this.zzege = new zzazt(this.zzcmn.getString("app_settings_json", this.zzege.zzyr()), this.zzcmn.getLong("app_settings_last_update_ms", this.zzege.zzyp()));
            this.zzegf = this.zzcmn.getLong("app_last_background_time_ms", this.zzegf);
            this.zzegh = this.zzcmn.getInt("request_in_session_count", this.zzegh);
            this.zzegg = this.zzcmn.getLong("first_ad_req_time_ms", this.zzegg);
            this.zzegj = this.zzcmn.getStringSet("never_pool_slots", this.zzegj);
            this.zzegl = this.zzcmn.getString("display_cutout", this.zzegl);
            this.zzegm = this.zzcmn.getInt("app_measurement_npa", this.zzegm);
            this.zzegn = this.zzcmn.getInt("sd_app_measure_npa", this.zzegn);
            try {
                this.zzegk = new JSONObject(this.zzcmn.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzd.zzd("Could not convert native advanced settings to json object", e);
            }
            zzzp();
        }
    }
}
