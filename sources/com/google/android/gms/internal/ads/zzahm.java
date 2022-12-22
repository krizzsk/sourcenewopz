package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzahm implements zzaig<Object> {
    private final zzahp zzdie;

    public zzahm(zzahp zzahp) {
        this.zzdie = zzahp;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzd.zzez("App event with no name parameter.");
        } else {
            this.zzdie.onAppEvent(str, map.get("info"));
        }
    }
}
