package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdun {
    private final Context context;
    private final Clock zzbqq;
    private final String zzbrz;
    private final String zzckb;
    private final String zzdvq;
    private final zzei zzftt;
    private final zzdph zzgbf;
    private final zzcwk zzgda;

    public zzdun(zzcwk zzcwk, zzbar zzbar, String str, String str2, Context context2, zzdph zzdph, Clock clock, zzei zzei) {
        this.zzgda = zzcwk;
        this.zzbrz = zzbar.zzbrz;
        this.zzdvq = str;
        this.zzckb = str2;
        this.context = context2;
        this.zzgbf = zzdph;
        this.zzbqq = clock;
        this.zzftt = zzei;
    }

    public final List<String> zza(zzdpi zzdpi, zzdot zzdot, List<String> list) {
        return zza(zzdpi, zzdot, false, "", "", list);
    }

    public static List<String> zza(int i, int i2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String zzc : list) {
            StringBuilder sb = new StringBuilder(23);
            sb.append(2);
            sb.append(".");
            sb.append(i2);
            arrayList.add(zzc(zzc, "@gw_mpe@", sb.toString()));
        }
        return arrayList;
    }

    public final List<String> zza(zzdpi zzdpi, zzdot zzdot, boolean z, String str, String str2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str3 = z ? "1" : "0";
        for (String zzc : list) {
            String zzc2 = zzc(zzc(zzc(zzc, "@gw_adlocid@", zzdpi.zzhns.zzfzg.zzhny), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.zzbrz);
            if (zzdot != null) {
                zzc2 = zzayv.zzc(zzc(zzc(zzc(zzc2, "@gw_qdata@", zzdot.zzdng), "@gw_adnetid@", zzdot.f52594id), "@gw_allocid@", zzdot.zzdnw), this.context, zzdot.zzdyj);
            }
            String zzc3 = zzc(zzc(zzc(zzc2, "@gw_adnetstatus@", this.zzgda.zzasy()), "@gw_seqnum@", this.zzdvq), "@gw_sessid@", this.zzckb);
            boolean z2 = ((Boolean) zzww.zzra().zzd(zzabq.zzctj)).booleanValue() && !TextUtils.isEmpty(str);
            boolean isEmpty = true ^ TextUtils.isEmpty(str2);
            if (z2 || isEmpty) {
                if (this.zzftt.zzb(Uri.parse(zzc3))) {
                    Uri.Builder buildUpon = Uri.parse(zzc3).buildUpon();
                    if (z2) {
                        buildUpon = buildUpon.appendQueryParameter("ms", str);
                    }
                    if (isEmpty) {
                        buildUpon = buildUpon.appendQueryParameter("attok", str2);
                    }
                    zzc3 = buildUpon.build().toString();
                }
            }
            arrayList.add(zzc3);
        }
        return arrayList;
    }

    public final List<String> zza(zzdot zzdot, List<String> list, zzavd zzavd) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = this.zzbqq.currentTimeMillis();
        try {
            String type = zzavd.getType();
            String num = Integer.toString(zzavd.getAmount());
            zzdph zzdph = this.zzgbf;
            String str = "";
            String zzhc = zzdph == null ? str : zzhc(zzdph.zzear);
            zzdph zzdph2 = this.zzgbf;
            if (zzdph2 != null) {
                str = zzhc(zzdph2.zzeas);
            }
            for (String zzc : list) {
                arrayList.add(zzayv.zzc(zzc(zzc(zzc(zzc(zzc(zzc(zzc, "@gw_rwd_userid@", Uri.encode(zzhc)), "@gw_rwd_custom_data@", Uri.encode(str)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(type)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.zzbrz), this.context, zzdot.zzdyj));
            }
            return arrayList;
        } catch (RemoteException e) {
            zzd.zzc("Unable to determine award type and amount.", e);
            return arrayList;
        }
    }

    private static String zzc(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    private static String zzhc(String str) {
        return (TextUtils.isEmpty(str) || !zzbai.isEnabled()) ? str : "fakeForAdDebugLog";
    }
}
