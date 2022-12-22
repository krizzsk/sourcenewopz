package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didiglobal.domainservice.utils.DomainConstants;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcgf {
    private final Context context;
    private final Executor executor;
    private final zzbar zzbpx;
    private final zzaei zzdpr;
    private final zztz zzesy;
    private final zzei zzeus;
    private final ScheduledExecutorService zzftq;
    private final zzcfw zzgkm;
    private final zzb zzgkn;
    private final zzcgs zzgko;

    public zzcgf(Context context2, zzcfw zzcfw, zzei zzei, zzbar zzbar, zzb zzb, zztz zztz, Executor executor2, zzdpm zzdpm, zzcgs zzcgs, ScheduledExecutorService scheduledExecutorService) {
        this.context = context2;
        this.zzgkm = zzcfw;
        this.zzeus = zzei;
        this.zzbpx = zzbar;
        this.zzgkn = zzb;
        this.zzesy = zztz;
        this.executor = executor2;
        this.zzdpr = zzdpm.zzdpr;
        this.zzgko = zzcgs;
        this.zzftq = scheduledExecutorService;
    }

    public static List<zzzz> zzk(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzdza.zzbal();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzdza.zzbal();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzzz zzm = zzm(optJSONArray.optJSONObject(i));
            if (zzm != null) {
                arrayList.add(zzm);
            }
        }
        return zzdza.zzb(arrayList);
    }

    public static zzzz zzl(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzm(optJSONObject);
    }

    private static zzzz zzm(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzzz(optString, optString2);
    }

    public final zzebt<zzaee> zzc(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONObject(str), this.zzdpr.zzdgx);
    }

    public final zzebt<List<zzaee>> zzd(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONArray(str), this.zzdpr.zzdgx, this.zzdpr.zzboe);
    }

    private final zzebt<List<zzaee>> zza(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzebh.zzag(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zza(jSONArray.optJSONObject(i), z));
        }
        return zzebh.zzb(zzebh.zzi(arrayList), zzcge.zzebv, this.executor);
    }

    private final zzebt<zzaee> zza(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzebh.zzag(null);
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzebh.zzag(null);
        }
        double optDouble = jSONObject.optDouble(NNGestureClassfy.SCALE_LABLE, 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzebh.zzag(new zzaee((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zza(jSONObject.optBoolean("require"), zzebh.zzb(this.zzgkm.zza(optString, optDouble, optBoolean), new zzcgh(optString, optDouble, optInt, optInt2), this.executor), (Object) null);
    }

    public final zzebt<zzaed> zze(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzebh.zzag(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zza(optJSONObject.optBoolean("require"), zzebh.zzb(zza(optJSONArray, false, true), new zzcgg(this, optJSONObject), this.executor), (Object) null);
    }

    private static Integer zzf(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt(DomainConstants.DOMAIN_SUFFIX_G), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final zzebt<zzbfi> zzn(JSONObject jSONObject) {
        JSONObject zza = zzbh.zza(jSONObject, "html_containers", "instream");
        if (zza == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject == null) {
                return zzebh.zzag(null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                zzd.zzez("Required field 'vast_xml' is missing");
                return zzebh.zzag(null);
            }
            return zza(zzebh.zza(this.zzgko.zzo(optJSONObject), (long) ((Integer) zzww.zzra().zzd(zzabq.zzctt)).intValue(), TimeUnit.SECONDS, this.zzftq), (Object) null);
        }
        zzebt<zzbfi> zzp = this.zzgko.zzp(zza.optString("base_url"), zza.optString("html"));
        return zzebh.zzb(zzp, new zzcgi(zzp), (Executor) zzbat.zzekj);
    }

    private static <T> zzebt<T> zza(zzebt<T> zzebt, T t) {
        return zzebh.zzb(zzebt, Exception.class, new zzcgl((Object) null), zzbat.zzekj);
    }

    private static <T> zzebt<T> zza(boolean z, zzebt<T> zzebt, T t) {
        if (z) {
            return zzebh.zzb(zzebt, new zzcgk(zzebt), (Executor) zzbat.zzekj);
        }
        return zza(zzebt, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(String str, Object obj) throws Exception {
        zzr.zzkw();
        zzbfi zza = zzbfq.zza(this.context, zzbgx.zzafg(), "native-omid", false, false, this.zzeus, (zzacv) null, this.zzbpx, (zzach) null, (zzm) null, this.zzgkn, this.zzesy, (zzdot) null, (zzdoy) null);
        zzbbb zzk = zzbbb.zzk(zza);
        zza.zzaef().zza((zzbgt) new zzcgn(zzk));
        zza.loadData(str, "text/html", "UTF-8");
        return zzk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzaed zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzf = zzf(jSONObject, BlocksConst.WIDGET_PARAMS_BG_COLOR);
        Integer zzf2 = zzf(jSONObject, BlocksConst.WIDGET_PARAMS_TEXT_COLOR);
        int optInt = jSONObject.optInt(BlocksConst.WIDGET_PARAMS_TEXT_SIZE, -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzaed(optString, list, zzf, zzf2, num, optInt3 + optInt2, this.zzdpr.zzbof, optBoolean);
    }
}
