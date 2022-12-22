package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.appsflyer.internal.referrer.Payload;
import com.didi.sdk.apm.SystemUtils;
import com.dmap.apollo.BuildConfig;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcsr extends zzarx {
    private final Context context;
    private final zzcmb zzdje;
    private final zzdtw zzdjf;
    private final zzbas zzdjg;
    private final zzcsh zzdji;

    public zzcsr(Context context2, zzcsh zzcsh, zzbas zzbas, zzcmb zzcmb, zzdtw zzdtw) {
        this.context = context2;
        this.zzdje = zzcmb;
        this.zzdjg = zzbas;
        this.zzdji = zzcsh;
        this.zzdjf = zzdtw;
    }

    public static void zza(Activity activity, zze zze, zzbg zzbg, zzcsh zzcsh, zzcmb zzcmb, zzdtw zzdtw, String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        zzr.zzkv();
        AlertDialog.Builder zzc = zzj.zzc(activity, zzr.zzkx().zzzy());
        Resources resources = zzr.zzkz().getResources();
        if (resources == null) {
            str3 = "Open ad when you're back online.";
        } else {
            str3 = resources.getString(R.string.offline_opt_in_title);
        }
        AlertDialog.Builder title = zzc.setTitle(str3);
        if (resources == null) {
            str4 = "We'll send you a notification with a link to the advertiser site.";
        } else {
            str4 = resources.getString(R.string.offline_opt_in_message);
        }
        AlertDialog.Builder message = title.setMessage(str4);
        if (resources == null) {
            str5 = Payload.RESPONSE_OK;
        } else {
            str5 = resources.getString(R.string.offline_opt_in_confirm);
        }
        AlertDialog.Builder positiveButton = message.setPositiveButton(str5, new zzcsq(zzcmb, activity, zzdtw, zzcsh, str, zzbg, str2, resources, zze));
        if (resources == null) {
            str6 = "No thanks";
        } else {
            str6 = resources.getString(R.string.offline_opt_in_decline);
        }
        zzcsh zzcsh2 = zzcsh;
        String str7 = str;
        zzcmb zzcmb2 = zzcmb;
        Activity activity2 = activity;
        zzdtw zzdtw2 = zzdtw;
        zze zze2 = zze;
        positiveButton.setNegativeButton(str6, new zzcst(zzcsh2, str7, zzcmb2, activity2, zzdtw2, zze2)).setOnCancelListener(new zzcss(zzcsh2, str7, zzcmb2, activity2, zzdtw2, zze2));
        SystemUtils.showDialog(zzc.create());
    }

    public static void zza(Context context2, zzcmb zzcmb, zzdtw zzdtw, zzcsh zzcsh, String str, String str2) {
        zza(context2, zzcmb, zzdtw, zzcsh, str, str2, new HashMap());
    }

    public static void zza(Context context2, zzcmb zzcmb, zzdtw zzdtw, zzcsh zzcsh, String str, String str2, Map<String, String> map) {
        String str3;
        boolean booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue();
        String str4 = BuildConfig.FLAVOR;
        if (booleanValue) {
            zzdtx zzw = zzdtx.zzgy(str2).zzw("gqi", str);
            zzr.zzkv();
            if (!zzj.zzbd(context2)) {
                str4 = "offline";
            }
            zzdtx zzw2 = zzw.zzw("device_connectivity", str4).zzw("event_timestamp", String.valueOf(zzr.zzlc().currentTimeMillis()));
            for (Map.Entry next : map.entrySet()) {
                zzw2.zzw((String) next.getKey(), (String) next.getValue());
            }
            str3 = zzdtw.zzc(zzw2);
        } else {
            zzcma zzarp = zzcmb.zzarp();
            zzarp.zzs("gqi", str);
            zzarp.zzs("action", str2);
            zzr.zzkv();
            if (!zzj.zzbd(context2)) {
                str4 = "offline";
            }
            zzarp.zzs("device_connectivity", str4);
            zzarp.zzs("event_timestamp", String.valueOf(zzr.zzlc().currentTimeMillis()));
            for (Map.Entry next2 : map.entrySet()) {
                zzarp.zzs((String) next2.getKey(), (String) next2.getValue());
            }
            str3 = zzarp.zzarn();
        }
        zzcsh.zza(new zzcso(zzr.zzlc().currentTimeMillis(), str, str3, zzcse.zzgui));
    }

    private final void zza(String str, String str2, Map<String, String> map) {
        zza(this.context, this.zzdje, this.zzdjf, this.zzdji, str, str2, map);
    }

    public final void zzc(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra(ShareConstants.MEDIA_URI);
            zzr.zzkv();
            boolean zzbd = zzj.zzbd(this.context);
            int i = zzcsx.zzgvg;
            HashMap hashMap = new HashMap();
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (zzbd) {
                    i = zzcsx.zzgvf;
                }
                hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("olaih", String.valueOf(stringExtra3.startsWith("http")));
                try {
                    Context context2 = this.context;
                    Intent launchIntentForPackage = context2.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(268435456);
                    context2.startActivity(launchIntentForPackage);
                    hashMap.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    hashMap.put("olaa", "olaf");
                }
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            zza(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.zzdji.getWritableDatabase();
                if (i == zzcsx.zzgvf) {
                    this.zzdji.zza(writableDatabase, this.zzdjg, stringExtra2);
                } else {
                    zzcsh.zza(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 51);
                sb.append("Failed to get writable offline buffering database: ");
                sb.append(valueOf);
                zzd.zzex(sb.toString());
            }
        }
    }

    public final void zzc(IObjectWrapper iObjectWrapper, String str, String str2) {
        String str3;
        String str4;
        Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzr.zzkv();
        zzj.zzbe(context2);
        int i = PlatformVersion.isAtLeastM() ? 1140850688 : 1073741824;
        Intent intent = new Intent();
        intent.setClass(context2, AdService.class);
        intent.setAction("offline_notification_clicked");
        intent.putExtra("offline_notification_action", "offline_notification_clicked");
        intent.putExtra("gws_query_id", str2);
        intent.putExtra(ShareConstants.MEDIA_URI, str);
        PendingIntent service = zzdxk.getService(context2, 0, intent, i);
        Intent intent2 = new Intent();
        intent2.setClass(context2, AdService.class);
        intent2.setAction("offline_notification_dismissed");
        intent2.putExtra("offline_notification_action", "offline_notification_dismissed");
        intent2.putExtra("gws_query_id", str2);
        PendingIntent service2 = zzdxk.getService(context2, 0, intent2, i);
        Resources resources = zzr.zzkz().getResources();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context2, "offline_notification_channel");
        if (resources == null) {
            str3 = "View the ad you saved when you were offline";
        } else {
            str3 = resources.getString(R.string.offline_notification_title);
        }
        NotificationCompat.Builder contentTitle = builder.setContentTitle(str3);
        if (resources == null) {
            str4 = "Tap to open ad";
        } else {
            str4 = resources.getString(R.string.offline_notification_text);
        }
        ((NotificationManager) context2.getSystemService("notification")).notify(str2, 54321, contentTitle.setContentText(str4).setAutoCancel(true).setDeleteIntent(service2).setContentIntent(service).setSmallIcon(context2.getApplicationInfo().icon).build());
        zza(str2, "offline_notification_impression", new HashMap());
    }

    public final void zzwe() {
        this.zzdji.zza(this.zzdjg);
    }
}
