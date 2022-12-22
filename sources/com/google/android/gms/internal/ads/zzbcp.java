package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbcp {
    public final boolean zzenh;
    public final int zzeni;
    public final int zzenj;
    public final int zzenk;
    private final String zzenl;
    public final int zzenm;
    public final int zzenn;
    public final int zzeno;
    public final int zzenp;
    public final boolean zzenq;
    public final int zzenr;
    public final boolean zzens;

    public zzbcp(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zzenh = zza(jSONObject, "aggressive_media_codec_release", zzabq.zzcnv);
        this.zzeni = zzb(jSONObject, "byte_buffer_precache_limit", zzabq.zzcnb);
        this.zzenj = zzb(jSONObject, "exo_cache_buffer_size", zzabq.zzcnk);
        this.zzenk = zzb(jSONObject, "exo_connect_timeout_millis", zzabq.zzcmx);
        this.zzenl = zzc(jSONObject, "exo_player_version", zzabq.zzcmw);
        this.zzenm = zzb(jSONObject, "exo_read_timeout_millis", zzabq.zzcmy);
        this.zzenn = zzb(jSONObject, "load_check_interval_bytes", zzabq.zzcmz);
        this.zzeno = zzb(jSONObject, "player_precache_limit", zzabq.zzcna);
        this.zzenp = zzb(jSONObject, "socket_receive_buffer_size", zzabq.zzcnc);
        this.zzenq = zza(jSONObject, "use_cache_data_source", zzabq.zzcuz);
        this.zzenr = zzb(jSONObject, "min_retry_count", zzabq.zzcne);
        this.zzens = zza(jSONObject, "treat_load_exception_as_non_fatal", zzabq.zzcnh);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzabf<java.lang.Boolean>, com.google.android.gms.internal.ads.zzabf] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zza(org.json.JSONObject r1, java.lang.String r2, com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r3) {
        /*
            com.google.android.gms.internal.ads.zzabm r0 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r3 = r0.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            boolean r1 = zza((org.json.JSONObject) r1, (java.lang.String) r2, (boolean) r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcp.zza(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzabf):boolean");
    }

    private static boolean zza(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzabf, com.google.android.gms.internal.ads.zzabf<java.lang.Integer>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(org.json.JSONObject r0, java.lang.String r1, com.google.android.gms.internal.ads.zzabf<java.lang.Integer> r2) {
        /*
            if (r0 == 0) goto L_0x0007
            int r0 = r0.getInt(r1)     // Catch:{ JSONException -> 0x0007 }
            return r0
        L_0x0007:
            com.google.android.gms.internal.ads.zzabm r0 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r0.zzd(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcp.zzb(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzabf):int");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzabf, com.google.android.gms.internal.ads.zzabf<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zzc(org.json.JSONObject r0, java.lang.String r1, com.google.android.gms.internal.ads.zzabf<java.lang.String> r2) {
        /*
            if (r0 == 0) goto L_0x0007
            java.lang.String r0 = r0.getString(r1)     // Catch:{ JSONException -> 0x0007 }
            return r0
        L_0x0007:
            com.google.android.gms.internal.ads.zzabm r0 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r0.zzd(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcp.zzc(org.json.JSONObject, java.lang.String, com.google.android.gms.internal.ads.zzabf):java.lang.String");
    }
}
