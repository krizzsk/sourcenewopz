package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzfo extends zzgn {
    private final Activity zzaax;
    private final View zzaay;

    public zzfo(zzfc zzfc, String str, String str2, zzcf.zza.zzb zzb, int i, int i2, View view, Activity activity) {
        super(zzfc, str, str2, zzb, i, 62);
        this.zzaay = view;
        this.zzaax = activity;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzaay != null) {
            boolean booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcst)).booleanValue();
            Object[] objArr = (Object[]) this.zzabq.invoke((Object) null, new Object[]{this.zzaay, this.zzaax, Boolean.valueOf(booleanValue)});
            synchronized (this.zzabg) {
                this.zzabg.zzbp(((Long) objArr[0]).longValue());
                this.zzabg.zzbq(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zzabg.zzaj((String) objArr[2]);
                }
            }
        }
    }
}
