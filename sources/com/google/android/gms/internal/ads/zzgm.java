package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzgm extends zzgn {
    private final View zzaay;

    public zzgm(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2, View view) {
        super(zzfc, str, str2, zzb, i, 57);
        this.zzaay = view;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzaay != null) {
            Boolean bool = (Boolean) zzww.zzra().zzd(zzabq.zzctg);
            DisplayMetrics displayMetrics = this.zzwh.getContext().getResources().getDisplayMetrics();
            zzfk zzfk = new zzfk((String) this.zzabq.invoke((Object) null, new Object[]{this.zzaay, displayMetrics, bool}));
            zzcf.zza.zzg.C22013zza zzax = zzcf.zza.zzg.zzax();
            zzax.zzdc(zzfk.zzaas.longValue()).zzdd(zzfk.zzaat.longValue()).zzde(zzfk.zzaau.longValue());
            if (bool.booleanValue()) {
                zzax.zzdf(zzfk.zzaav.longValue());
            }
            this.zzabg.zzb((zzcf.zza.zzg) ((zzena) zzax.zzbjv()));
        }
    }
}
