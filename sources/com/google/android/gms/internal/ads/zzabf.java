package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzabf<T> {
    private final String zzcm;
    private final int zzcmf;
    private final T zzcmg;

    private zzabf(int i, String str, T t) {
        this.zzcmf = i;
        this.zzcm = str;
        this.zzcmg = t;
        zzww.zzqz().zza(this);
    }

    /* access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract T zza(Bundle bundle);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    /* access modifiers changed from: protected */
    public abstract T zzb(JSONObject jSONObject);

    public final String getKey() {
        return this.zzcm;
    }

    public final T zzsh() {
        return this.zzcmg;
    }

    public static zzabf<Boolean> zza(int i, String str, Boolean bool) {
        return new zzabe(i, str, bool);
    }

    public static zzabf<Integer> zza(int i, String str, int i2) {
        return new zzabh(1, str, Integer.valueOf(i2));
    }

    public static zzabf<Long> zzb(int i, String str, long j) {
        return new zzabg(1, str, Long.valueOf(j));
    }

    public static zzabf<Float> zza(int i, String str, float f) {
        return new zzabj(1, str, Float.valueOf(0.0f));
    }

    public static zzabf<String> zza(int i, String str, String str2) {
        return new zzabi(1, str, str2);
    }

    public static zzabf<String> zzb(int i, String str) {
        zzabf<String> zza = zza(1, str, (String) null);
        zzww.zzqz().zzc(zza);
        return zza;
    }

    public final int getSource() {
        return this.zzcmf;
    }

    /* synthetic */ zzabf(int i, String str, Object obj, zzabe zzabe) {
        this(i, str, obj);
    }
}
