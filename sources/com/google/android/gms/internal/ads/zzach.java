package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzach {
    private final Object lock = new Object();
    final boolean zzdcl = true;
    private final List<zzacf> zzdcm = new LinkedList();
    private final Map<String, String> zzdcn = new LinkedHashMap();
    private zzach zzdco;

    public zzach(boolean z, String str, String str2) {
        this.zzdcn.put("action", str);
        this.zzdcn.put(FirebaseAnalytics.Param.AD_FORMAT, str2);
    }

    public final void zzc(zzach zzach) {
        synchronized (this.lock) {
            this.zzdco = zzach;
        }
    }

    public final zzacf zzex(long j) {
        if (!this.zzdcl) {
            return null;
        }
        return new zzacf(j, (String) null, (zzacf) null);
    }

    public final boolean zza(zzacf zzacf, long j, String... strArr) {
        synchronized (this.lock) {
            for (String zzacf2 : strArr) {
                this.zzdcm.add(new zzacf(j, zzacf2, zzacf));
            }
        }
        return true;
    }

    public final zzacg zzsw() {
        zzacg zzacg;
        boolean booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.lock) {
            for (zzacf next : this.zzdcm) {
                long time = next.getTime();
                String zzss = next.zzss();
                zzacf zzst = next.zzst();
                if (zzst != null && time > 0) {
                    sb.append(zzss);
                    sb.append('.');
                    sb.append(time - zzst.getTime());
                    sb.append(',');
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzst.getTime()))) {
                            hashMap.put(Long.valueOf(zzst.getTime()), new StringBuilder(zzss));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(zzst.getTime()));
                            sb2.append('+');
                            sb2.append(zzss);
                        }
                    }
                }
            }
            this.zzdcm.clear();
            String str = null;
            if (!TextUtils.isEmpty((CharSequence) null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    sb3.append(zzr.zzlc().currentTimeMillis() + (((Long) entry.getKey()).longValue() - zzr.zzlc().elapsedRealtime()));
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzacg = new zzacg(sb.toString(), str);
        }
        return zzacg;
    }

    public final void zzg(String str, String str2) {
        zzabx zzyf;
        if (this.zzdcl && !TextUtils.isEmpty(str2) && (zzyf = zzr.zzkz().zzyf()) != null) {
            synchronized (this.lock) {
                zzacb zzcq = zzyf.zzcq(str);
                Map<String, String> map = this.zzdcn;
                map.put(str, zzcq.zzf(map.get(str), str2));
            }
        }
    }

    public final Map<String, String> zzsx() {
        synchronized (this.lock) {
            zzabx zzyf = zzr.zzkz().zzyf();
            if (zzyf != null) {
                if (this.zzdco != null) {
                    Map<String, String> zza = zzyf.zza(this.zzdcn, this.zzdco.zzsx());
                    return zza;
                }
            }
            Map<String, String> map = this.zzdcn;
            return map;
        }
    }
}
