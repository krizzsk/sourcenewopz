package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.RemoteException;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Timer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcsq implements DialogInterface.OnClickListener {
    private final Activity zzehb;
    private final String zzetx;
    private final zzcmb zzguq;
    private final zzdtw zzgur;
    private final zzcsh zzgus;
    private final zzbg zzgut;
    private final String zzguu;
    private final Resources zzguv;
    private final zze zzguw;

    zzcsq(zzcmb zzcmb, Activity activity, zzdtw zzdtw, zzcsh zzcsh, String str, zzbg zzbg, String str2, Resources resources, zze zze) {
        this.zzguq = zzcmb;
        this.zzehb = activity;
        this.zzgur = zzdtw;
        this.zzgus = zzcsh;
        this.zzetx = str;
        this.zzgut = zzbg;
        this.zzguu = str2;
        this.zzguv = resources;
        this.zzguw = zze;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zze zze;
        String str;
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        zzcmb zzcmb = this.zzguq;
        Activity activity = this.zzehb;
        zzdtw zzdtw = this.zzgur;
        zzcsh zzcsh = this.zzgus;
        String str2 = this.zzetx;
        zzbg zzbg = this.zzgut;
        String str3 = this.zzguu;
        Resources resources = this.zzguv;
        zze zze2 = this.zzguw;
        if (zzcmb != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", XPanelScene.SCENE_CONFIRM);
            zze = zze2;
            zzcsr.zza(activity, zzcmb, zzdtw, zzcsh, str2, "dialog_click", hashMap);
        } else {
            zze = zze2;
        }
        boolean z = false;
        try {
            z = zzbg.zzd(ObjectWrapper.wrap(activity), str3, str2);
        } catch (RemoteException e) {
            zzd.zzc("Failed to schedule offline notification poster.", e);
        }
        if (!z) {
            zzcsh.zzgn(str2);
            if (zzcmb != null) {
                zzcsr.zza(activity, zzcmb, zzdtw, zzcsh, str2, "offline_notification_worker_not_scheduled");
            }
        }
        zzr.zzkv();
        AlertDialog.Builder zzc = zzj.zzc(activity, zzr.zzkx().zzzy());
        if (resources == null) {
            str = "You'll get a notification with the link when you're back online";
        } else {
            str = resources.getString(R.string.offline_opt_in_confirmation);
        }
        zzc.setMessage(str).setOnCancelListener(new zzcsv(zze));
        AlertDialog create = zzc.create();
        SystemUtils.showDialog(create);
        Timer timer = new Timer();
        timer.schedule(new zzcsu(create, timer, zze), 3000);
    }
}
