package com.google.android.gms.internal.ads;

import com.didi.soda.blocks.constant.Const;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbep implements zzaig<zzbcs> {
    private static Integer zza(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzd.zzez(sb.toString());
            return null;
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbek zzbek;
        zzbcs zzbcs = (zzbcs) obj;
        if (zzd.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzd.zzdz(sb.toString());
        }
        zzr.zzlr();
        if (!map.containsKey("abort")) {
            String str = (String) map.get(Const.BlockParamConst.SRC);
            Integer zza = zza((Map<String, String>) map, "periodicReportIntervalMs");
            Integer zza2 = zza((Map<String, String>) map, "exoPlayerRenderingIntervalMs");
            Integer zza3 = zza((Map<String, String>) map, "exoPlayerIdleIntervalMs");
            if (str != null) {
                String[] strArr = {str};
                String str2 = (String) map.get("demuxed");
                if (str2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            strArr2[i] = jSONArray.getString(i);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused) {
                        String valueOf2 = String.valueOf(str2);
                        zzd.zzez(valueOf2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(valueOf2) : new String("Malformed demuxed URL list for precache: "));
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str};
                }
                if (zzbeh.zzd(zzbcs) != null) {
                    zzd.zzez("Precache task is already running.");
                    return;
                } else if (zzbcs.zzaby() == null) {
                    zzd.zzez("Precache requires a dependency provider.");
                    return;
                } else {
                    zzbcp zzbcp = new zzbcp((String) map.get("flags"));
                    Integer zza4 = zza((Map<String, String>) map, "player");
                    if (zza4 == null) {
                        zza4 = 0;
                    }
                    if (zza != null) {
                        zzbcs.zzdv(zza.intValue());
                    }
                    if (zza2 != null) {
                        zzbcs.zzdw(zza2.intValue());
                    }
                    if (zza3 != null) {
                        zzbcs.zzdx(zza3.intValue());
                    }
                    zzbek = zzbcs.zzaby().zzbou.zza(zzbcs, zza4.intValue(), (String) null, zzbcp);
                    new zzbef(zzbcs, zzbek, str, strArr).zzyx();
                }
            } else {
                zzbef zzd = zzbeh.zzd(zzbcs);
                if (zzd != null) {
                    zzbek = zzd.zzerp;
                } else {
                    zzd.zzez("Precache must specify a source.");
                    return;
                }
            }
            Integer zza5 = zza((Map<String, String>) map, "minBufferMs");
            if (zza5 != null) {
                zzbek.zzdq(zza5.intValue());
            }
            Integer zza6 = zza((Map<String, String>) map, "maxBufferMs");
            if (zza6 != null) {
                zzbek.zzdr(zza6.intValue());
            }
            Integer zza7 = zza((Map<String, String>) map, "bufferForPlaybackMs");
            if (zza7 != null) {
                zzbek.zzds(zza7.intValue());
            }
            Integer zza8 = zza((Map<String, String>) map, "bufferForPlaybackAfterRebufferMs");
            if (zza8 != null) {
                zzbek.zzdt(zza8.intValue());
            }
        } else if (!zzbeh.zzc(zzbcs)) {
            zzd.zzez("Precache abort but no precache task running.");
        }
    }
}
