package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzgn implements Callable {
    private final String TAG = getClass().getSimpleName();
    private final String className;
    protected final zzcf.zza.zzb zzabg;
    private final String zzabo;
    protected Method zzabq;
    private final int zzabt;
    private final int zzabu;
    protected final zzfc zzwh;

    public zzgn(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2) {
        this.zzwh = zzfc;
        this.className = str;
        this.zzabo = str2;
        this.zzabg = zzb;
        this.zzabt = i;
        this.zzabu = i2;
    }

    /* access modifiers changed from: protected */
    public abstract void zzcx() throws IllegalAccessException, InvocationTargetException;

    /* renamed from: zzcz */
    public Void call() throws Exception {
        try {
            long nanoTime = System.nanoTime();
            Method zza = this.zzwh.zza(this.className, this.zzabo);
            this.zzabq = zza;
            if (zza == null) {
                return null;
            }
            zzcx();
            zzdw zzcm = this.zzwh.zzcm();
            if (!(zzcm == null || this.zzabt == Integer.MIN_VALUE)) {
                zzcm.zza(this.zzabu, this.zzabt, (System.nanoTime() - nanoTime) / 1000);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
