package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzr;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbku implements zzbkn {
    private final CookieManager zzftj;

    public zzbku(Context context) {
        this.zzftj = zzr.zzkx().zzbi(context);
    }

    public final void zzm(Map<String, String> map) {
        Object obj;
        if (this.zzftj != null) {
            if (map.get("clear") != null) {
                String str = (String) zzww.zzra().zzd(zzabq.zzcpu);
                String cookie = this.zzftj.getCookie(str);
                if (cookie != null) {
                    List<String> zzc = zzdyh.zza(zzdxr.zzb(';')).zzc(cookie);
                    for (int i = 0; i < zzc.size(); i++) {
                        CookieManager cookieManager = this.zzftj;
                        Iterable zza = zzdyh.zza(zzdxr.zzb('=')).zza((CharSequence) zzc.get(i));
                        zzdyi.checkNotNull(zza);
                        if (zza instanceof List) {
                            obj = ((List) zza).get(0);
                        } else {
                            Iterator it = zza.iterator();
                            zzdyi.checkNotNull(it);
                            zzdyi.checkArgument(true, "numberToAdvance must be nonnegative");
                            if (it.hasNext()) {
                                obj = it.next();
                            } else {
                                StringBuilder sb = new StringBuilder(91);
                                sb.append("position (0) must be less than the number of elements that remained (0");
                                sb.append(")");
                                throw new IndexOutOfBoundsException(sb.toString());
                            }
                        }
                        String valueOf = String.valueOf((String) obj);
                        String valueOf2 = String.valueOf((String) zzww.zzra().zzd(zzabq.zzcpi));
                        cookieManager.setCookie(str, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                    }
                    return;
                }
                return;
            }
            String str2 = map.get("cookie");
            if (!TextUtils.isEmpty(str2)) {
                this.zzftj.setCookie((String) zzww.zzra().zzd(zzabq.zzcpu), str2);
            }
        }
    }
}
