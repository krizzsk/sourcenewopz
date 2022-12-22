package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzayv {
    public static String zzc(String str, Context context, boolean z) {
        String zzaf;
        if ((((Boolean) zzww.zzra().zzd(zzabq.zzcoz)).booleanValue() && !z) || !zzr.zzlt().zzaa(context) || TextUtils.isEmpty(str) || (zzaf = zzr.zzlt().zzaf(context)) == null) {
            return str;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcor)).booleanValue()) {
            String str2 = (String) zzww.zzra().zzd(zzabq.zzcos);
            if (!str.contains(str2)) {
                return str;
            }
            if (zzr.zzkv().zzek(str)) {
                zzr.zzlt().zzg(context, zzaf);
                return zzb(str, context).replace(str2, zzaf);
            } else if (!zzr.zzkv().zzel(str)) {
                return str;
            } else {
                zzr.zzlt().zzh(context, zzaf);
                return zzb(str, context).replace(str2, zzaf);
            }
        } else if (str.contains("fbs_aeid")) {
            return str;
        } else {
            if (zzr.zzkv().zzek(str)) {
                zzr.zzlt().zzg(context, zzaf);
                return zza(zzb(str, context), "fbs_aeid", zzaf).toString();
            } else if (!zzr.zzkv().zzel(str)) {
                return str;
            } else {
                zzr.zzlt().zzh(context, zzaf);
                return zza(zzb(str, context), "fbs_aeid", zzaf).toString();
            }
        }
    }

    private static String zzb(String str, Context context) {
        String zzad = zzr.zzlt().zzad(context);
        String zzae = zzr.zzlt().zzae(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(zzad)) {
            str = zza(str, "gmp_app_id", zzad).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(zzae)) ? str : zza(str, "fbs_aiid", zzae).toString();
    }

    public static String zzb(Uri uri, Context context) {
        if (!zzr.zzlt().zzaa(context)) {
            return uri.toString();
        }
        String zzaf = zzr.zzlt().zzaf(context);
        if (zzaf == null) {
            return uri.toString();
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcor)).booleanValue()) {
            String str = (String) zzww.zzra().zzd(zzabq.zzcos);
            String uri2 = uri.toString();
            if (uri2.contains(str)) {
                zzr.zzlt().zzg(context, zzaf);
                return zzb(uri2, context).replace(str, zzaf);
            }
        } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            String uri3 = zza(zzb(uri.toString(), context), "fbs_aeid", zzaf).toString();
            zzr.zzlt().zzg(context, zzaf);
            return uri3;
        }
        return uri.toString();
    }

    private static Uri zza(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = indexOf + 1;
        return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + ParamKeys.SIGN_AND + str.substring(i));
    }
}
