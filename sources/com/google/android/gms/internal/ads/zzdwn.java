package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.didi.raven.config.RavenKey;
import com.google.android.gms.internal.ads.zzcf;
import global.didi.pay.newview.pix.IPixView;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdwn implements zzdvb {
    private final Object zzhxj;
    private final zzdwm zzhxk;
    private final zzdwy zzhxl;
    private final zzduv zzvx;

    zzdwn(Object obj, zzdwm zzdwm, zzdwy zzdwy, zzduv zzduv) {
        this.zzhxj = obj;
        this.zzhxk = zzdwm;
        this.zzhxl = zzdwy;
        this.zzvx = zzduv;
    }

    /* access modifiers changed from: package-private */
    public final zzdwm zzazn() {
        return this.zzhxk;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzazo() throws zzdww {
        try {
        } catch (Exception e) {
            throw new zzdww(2001, (Throwable) e);
        }
        return ((Boolean) this.zzhxj.getClass().getDeclaredMethod(IPixView.PAGE_STATUS_INIT, new Class[0]).invoke(this.zzhxj, new Object[0])).booleanValue();
    }

    public final synchronized void close() throws zzdww {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.zzhxj.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zzhxj, new Object[0]);
            this.zzvx.zzh(3001, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzdww(2003, (Throwable) e);
        }
    }

    public final synchronized String zzs(Context context, String str) {
        Map<String, Object> zzcd;
        zzcd = this.zzhxl.zzcd();
        zzcd.put("f", "q");
        zzcd.put("ctx", context);
        zzcd.put("aid", (Object) null);
        return zzj(zzd((Map<String, String>) null, zzcd));
    }

    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map<String, Object> zzce;
        zzce = this.zzhxl.zzce();
        zzce.put("f", RavenKey.VERSION);
        zzce.put("ctx", context);
        zzce.put("aid", (Object) null);
        zzce.put("view", view);
        zzce.put("act", activity);
        return zzj(zzd((Map<String, String>) null, zzce));
    }

    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map<String, Object> zzcf;
        zzcf = this.zzhxl.zzcf();
        zzcf.put("f", "c");
        zzcf.put("ctx", context);
        zzcf.put("cs", str2);
        zzcf.put("aid", (Object) null);
        zzcf.put("view", view);
        zzcf.put("act", activity);
        return zzj(zzd((Map<String, String>) null, zzcf));
    }

    public final synchronized void zza(String str, MotionEvent motionEvent) throws zzdww {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("aid", (Object) null);
            hashMap.put("evt", motionEvent);
            this.zzhxj.getClass().getDeclaredMethod("he", new Class[]{Map.class}).invoke(this.zzhxj, new Object[]{hashMap});
            this.zzvx.zzh(3003, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzdww(2005, (Throwable) e);
        }
    }

    public final synchronized int zzazp() throws zzdww {
        try {
        } catch (Exception e) {
            throw new zzdww(2006, (Throwable) e);
        }
        return ((Integer) this.zzhxj.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zzhxj, new Object[0])).intValue();
    }

    private static String zzj(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(((zzcf.zzf) ((zzena) zzcf.zzf.zzbm().zza(zzcm.DG).zzi(zzelq.zzt(bArr)).zzbjv())).toByteArray(), 11);
    }

    private final synchronized byte[] zzd(Map<String, String> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.zzvx.zza(2007, System.currentTimeMillis() - currentTimeMillis, e);
            return null;
        }
        return (byte[]) this.zzhxj.getClass().getDeclaredMethod("xss", new Class[]{Map.class, Map.class}).invoke(this.zzhxj, new Object[]{null, map2});
    }
}
