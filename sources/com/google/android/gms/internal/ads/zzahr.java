package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.raven.config.RavenConfigKey;
import com.didi.sdk.lawpop.SimpleWebActivity;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.ads.internal.util.zzd;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzahr {
    public static final zzaig<zzbfi> zzdig = zzahq.zzdif;
    public static final zzaig<zzbfi> zzdih = zzaht.zzdif;
    public static final zzaig<zzbfi> zzdii = zzahs.zzdif;
    public static final zzaig<zzbfi> zzdij = zzahv.zzdif;
    public static final zzaig<zzbfi> zzdik = new zzahw();
    public static final zzaig<zzbfi> zzdil = new zzahy();
    public static final zzaig<zzbfi> zzdim = zzahu.zzdif;
    public static final zzaig<Object> zzdin = new zzaib();
    public static final zzaig<zzbfi> zzdio = new zzaia();
    public static final zzaig<zzbfi> zzdip = zzahx.zzdif;
    public static final zzaig<zzbfi> zzdiq = new zzaid();
    public static final zzaig<zzbfi> zzdir = new zzaic();
    public static final zzaig<zzbcs> zzdis = new zzbed();
    public static final zzaig<zzbcs> zzdit = new zzbeg();
    public static final zzaig<zzbfi> zzdiu = new zzaho();
    public static final zzais zzdiv = new zzais();
    public static final zzaig<zzbfi> zzdiw = new zzaif();
    public static final zzaig<zzbfi> zzdix = new zzaie();
    public static final zzaig<zzbfi> zzdiy = new zzaih();
    public static final zzaig<zzbfi> zzdiz = new zzahz();

    public static <T extends zzbgk & zzbgp & zzbgr> String zza(T t, String str) {
        Uri parse = Uri.parse(str);
        try {
            zzei zzaei = ((zzbgp) t).zzaei();
            if (zzaei != null && zzaei.zzb(parse)) {
                parse = zzaei.zza(parse, t.getContext(), ((zzbgr) t).getView(), t.zzabx());
            }
        } catch (zzeh unused) {
            String valueOf = String.valueOf(str);
            zzd.zzez(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
        }
        return zzayv.zzb(parse, t.getContext());
    }

    static final /* synthetic */ void zza(zzbgp zzbgp, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzei zzaei = zzbgp.zzaei();
            if (zzaei != null) {
                zzaei.zzcb().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzd.zzez("Could not parse touch parameters from gmsg.");
        }
    }

    static final /* synthetic */ void zza(zzbgk zzbgk, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzd.zzez("URL missing from httpTrack GMSG.");
        } else {
            new zzbq(zzbgk.getContext(), ((zzbgs) zzbgk).zzacc().zzbrz, str).zzyx();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzbgk, com.google.android.gms.internal.ads.zzbex] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzbex r2, java.util.Map r3) {
        /*
            java.lang.String r0 = "u"
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0010
            java.lang.String r2 = "URL missing from click GMSG."
            com.google.android.gms.ads.internal.util.zzd.zzez(r2)
            return
        L_0x0010:
            java.lang.String r3 = zza(r2, (java.lang.String) r3)
            com.google.android.gms.ads.internal.util.zzbq r0 = new com.google.android.gms.ads.internal.util.zzbq
            r1 = r2
            com.google.android.gms.internal.ads.zzbgk r1 = (com.google.android.gms.internal.ads.zzbgk) r1
            android.content.Context r1 = r1.getContext()
            com.google.android.gms.internal.ads.zzbgs r2 = (com.google.android.gms.internal.ads.zzbgs) r2
            com.google.android.gms.internal.ads.zzbar r2 = r2.zzacc()
            java.lang.String r2 = r2.zzbrz
            r0.<init>(r1, r2, r3)
            r0.zzyx()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahr.zza(com.google.android.gms.internal.ads.zzbex, java.util.Map):void");
    }

    static final /* synthetic */ void zzb(zzbgk zzbgk, Map map) {
        PackageManager packageManager = zzbgk.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString(RavenConfigKey.PHONE);
                        String optString6 = jSONObject2.optString("c");
                        String optString7 = jSONObject2.optString(SimpleWebActivity.INTENT_URL);
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e) {
                                URISyntaxException uRISyntaxException = e;
                                String valueOf = String.valueOf(optString7);
                                zzd.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), uRISyntaxException);
                            }
                        }
                        boolean z = true;
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        if (packageManager.resolveActivity(intent, 65536) == null) {
                            z = false;
                        }
                        try {
                            jSONObject.put(optString, z);
                        } catch (JSONException e2) {
                            zzd.zzc("Error constructing openable urls response.", e2);
                        }
                    } catch (JSONException e3) {
                        zzd.zzc("Error parsing the intent data.", e3);
                    }
                }
                ((zzakr) zzbgk).zza("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzakr) zzbgk).zza("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzakr) zzbgk).zza("openableIntents", new JSONObject());
        }
    }

    static final /* synthetic */ void zzc(zzbgk zzbgk, Map map) {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzdaw)).booleanValue()) {
            zzd.zzez("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get(GlobalCashierCoreModule.PACKAGE_NAME);
        if (TextUtils.isEmpty(str)) {
            zzd.zzez("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap hashMap = new HashMap();
        Boolean valueOf = Boolean.valueOf(zzbgk.getContext().getPackageManager().getLaunchIntentForPackage(str) != null);
        hashMap.put(str, valueOf);
        String valueOf2 = String.valueOf(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(valueOf2).length());
        sb.append("/canOpenApp;");
        sb.append(str);
        sb.append(";");
        sb.append(valueOf2);
        zzd.zzed(sb.toString());
        ((zzakr) zzbgk).zza("openableApp", (Map<String, ?>) hashMap);
    }

    static final /* synthetic */ void zzd(zzbgk zzbgk, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzd.zzez("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzbgk.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            hashMap.put(str2, valueOf);
            String valueOf2 = String.valueOf(valueOf);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 14 + String.valueOf(valueOf2).length());
            sb.append("/canOpenURLs;");
            sb.append(str2);
            sb.append(";");
            sb.append(valueOf2);
            zzd.zzed(sb.toString());
        }
        ((zzakr) zzbgk).zza("openableURLs", (Map<String, ?>) hashMap);
    }
}
