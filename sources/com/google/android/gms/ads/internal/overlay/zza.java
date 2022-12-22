package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzacs;
import com.google.android.gms.internal.ads.zzww;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zza {
    public static boolean zza(Context context, zzb zzb, zzx zzx, zzv zzv) {
        int i = 0;
        if (zzb == null) {
            zzd.zzez("No intent data for launcher overlay.");
            return false;
        }
        zzabq.initialize(context);
        if (zzb.intent != null) {
            return zza(context, zzb.intent, zzx, zzv, zzb.zzdsy);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(zzb.url)) {
            zzd.zzez("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzb.mimeType)) {
            intent.setDataAndType(Uri.parse(zzb.url), zzb.mimeType);
        } else {
            intent.setData(Uri.parse(zzb.url));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzb.packageName)) {
            intent.setPackage(zzb.packageName);
        }
        if (!TextUtils.isEmpty(zzb.zzdsv)) {
            String[] split = zzb.zzdsv.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzb.zzdsv);
                zzd.zzez(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        String str = zzb.zzdsw;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zzd.zzez("Could not parse intent flags.");
            }
            intent.addFlags(i);
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcvl)).booleanValue()) {
            intent.addFlags(268435456);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcvk)).booleanValue()) {
                zzr.zzkv();
                zzj.zzb(context, intent);
            }
        }
        return zza(context, intent, zzx, zzv, zzb.zzdsy);
    }

    private static boolean zza(Context context, Intent intent, zzx zzx, zzv zzv, boolean z) {
        if (z) {
            return zza(context, intent.getData(), zzx, zzv);
        }
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzd.zzed(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzr.zzkv();
            zzj.zza(context, intent);
            if (zzx != null) {
                zzx.zzws();
            }
            if (zzv != null) {
                zzv.zzaf(true);
            }
            return true;
        } catch (ActivityNotFoundException e) {
            zzd.zzez(e.getMessage());
            if (zzv != null) {
                zzv.zzaf(false);
            }
            return false;
        }
    }

    private static boolean zza(Context context, Uri uri, zzx zzx, zzv zzv) {
        zzacs zzacs = zzacs.UNKNOWN;
        try {
            zzacs zza = zzr.zzkv().zza(context, uri);
            if (zzx != null) {
                zzx.zzws();
            }
            if (zzv != null) {
                zzv.zzb(zza);
            }
            return zza.equals(zzacs.CCT_READY_TO_OPEN);
        } catch (ActivityNotFoundException e) {
            zzd.zzez(e.getMessage());
            zzacs zzacs2 = zzacs.ACTIVITY_NOT_FOUND;
            if (zzv != null) {
                zzv.zzb(zzacs2);
            }
            return zzacs2.equals(zzacs.CCT_READY_TO_OPEN);
        } catch (Throwable unused) {
            if (zzv != null) {
                zzv.zzb(zzacs);
            }
            return zzacs.equals(zzacs.CCT_READY_TO_OPEN);
        }
    }
}
