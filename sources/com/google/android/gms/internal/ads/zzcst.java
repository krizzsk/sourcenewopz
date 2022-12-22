package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;
import com.google.android.gms.ads.internal.overlay.zze;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcst implements DialogInterface.OnClickListener {
    private final String zzdkl;
    private final zzcsh zzguk;
    private final zzcmb zzgux;
    private final Activity zzguy;
    private final zzdtw zzguz;
    private final zze zzgva;

    zzcst(zzcsh zzcsh, String str, zzcmb zzcmb, Activity activity, zzdtw zzdtw, zze zze) {
        this.zzguk = zzcsh;
        this.zzdkl = str;
        this.zzgux = zzcmb;
        this.zzguy = activity;
        this.zzguz = zzdtw;
        this.zzgva = zze;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        zzcsh zzcsh = this.zzguk;
        String str = this.zzdkl;
        zzcmb zzcmb = this.zzgux;
        Activity activity = this.zzguy;
        zzdtw zzdtw = this.zzguz;
        zze zze = this.zzgva;
        zzcsh.zzgn(str);
        if (zzcmb != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", "dismiss");
            zzcsr.zza(activity, zzcmb, zzdtw, zzcsh, str, "dialog_click", hashMap);
        }
        if (zze != null) {
            zze.close();
        }
    }
}
