package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzcwf<AdT> implements zzcsz<AdT> {
    /* access modifiers changed from: protected */
    public abstract zzebt<AdT> zza(zzdpm zzdpm, Bundle bundle);

    public final boolean zza(zzdpi zzdpi, zzdot zzdot) {
        return !TextUtils.isEmpty(zzdot.zzhmk.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    public final zzebt<AdT> zzb(zzdpi zzdpi, zzdot zzdot) {
        zzdot zzdot2 = zzdot;
        String optString = zzdot2.zzhmk.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzdpm zzdpm = zzdpi.zzhns.zzfzg;
        zzdpo zzgt = new zzdpo().zzc(zzdpm).zzgt(optString);
        Bundle zzm = zzm(zzdpm.zzhnx.zzcih);
        Bundle zzm2 = zzm(zzm.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzm2.putInt("gw", 1);
        String optString2 = zzdot2.zzhmk.optString("mad_hac", (String) null);
        if (optString2 != null) {
            zzm2.putString("mad_hac", optString2);
        }
        String optString3 = zzdot2.zzhmk.optString("adJson", (String) null);
        if (optString3 != null) {
            zzm2.putString("_ad", optString3);
        }
        zzm2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzdot2.zzhmn.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzdot2.zzhmn.optString(next, (String) null);
            if (next != null) {
                zzm2.putString(next, optString4);
            }
        }
        zzm.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzm2);
        zzvq zzvq = r5;
        zzvq zzvq2 = new zzvq(zzdpm.zzhnx.versionCode, zzdpm.zzhnx.zzcia, zzm2, zzdpm.zzhnx.zzcib, zzdpm.zzhnx.zzcic, zzdpm.zzhnx.zzcid, zzdpm.zzhnx.zzadv, zzdpm.zzhnx.zzbns, zzdpm.zzhnx.zzcie, zzdpm.zzhnx.zzcif, zzdpm.zzhnx.zzng, zzdpm.zzhnx.zzcig, zzm, zzdpm.zzhnx.zzcii, zzdpm.zzhnx.zzcij, zzdpm.zzhnx.zzcik, zzdpm.zzhnx.zzcil, zzdpm.zzhnx.zzcim, zzdpm.zzhnx.zzcip, zzdpm.zzhnx.zzadw, zzdpm.zzhnx.zzadx, zzdpm.zzhnx.zzcin, zzdpm.zzhnx.zzcio);
        zzdpm zzawg = zzgt.zzh(zzvq).zzawg();
        Bundle bundle = new Bundle();
        zzdpi zzdpi2 = zzdpi;
        zzdoy zzdoy = zzdpi2.zzhnt.zzeuy;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList(zzdoy.zzdnd));
        bundle2.putInt("refresh_interval", zzdoy.zzhnh);
        bundle2.putString("gws_query_id", zzdoy.zzbwe);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzdpi2.zzhns.zzfzg.zzhny;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        zzdot zzdot3 = zzdot;
        bundle3.putString("allocation_id", zzdot3.zzdnw);
        bundle3.putStringArrayList("click_urls", new ArrayList(zzdot3.zzdna));
        bundle3.putStringArrayList("imp_urls", new ArrayList(zzdot3.zzdnb));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList(zzdot3.zzdxk));
        bundle3.putStringArrayList("fill_urls", new ArrayList(zzdot3.zzhmd));
        bundle3.putStringArrayList("video_start_urls", new ArrayList(zzdot3.zzdxx));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList(zzdot3.zzdxy));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList(zzdot3.zzhmc));
        bundle3.putString(FirebaseAnalytics.Param.TRANSACTION_ID, zzdot3.zzdoh);
        bundle3.putString("valid_from_timestamp", zzdot3.zzdoi);
        bundle3.putBoolean("is_closable_area_disabled", zzdot3.zzbpw);
        if (zzdot3.zzdxw != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzdot3.zzdxw.zzean);
            bundle4.putString("rb_type", zzdot3.zzdxw.type);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zza(zzawg, bundle);
    }

    private static Bundle zzm(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }
}
