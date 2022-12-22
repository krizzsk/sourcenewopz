package com.google.android.gms.internal.ads;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.Iterator;
import org.osgi.framework.VersionRange;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzdym implements Iterable<String> {
    private final /* synthetic */ CharSequence zzhzh;
    private final /* synthetic */ zzdyh zzhzi;

    zzdym(zzdyh zzdyh, CharSequence charSequence) {
        this.zzhzi = zzdyh;
        this.zzhzh = charSequence;
    }

    public final Iterator<String> iterator() {
        return this.zzhzi.zzb(this.zzhzh);
    }

    public final String toString() {
        StringBuilder zza = zzdxz.zzhl(", ").zza(new StringBuilder(Const.jaLeft), iterator());
        zza.append(VersionRange.RIGHT_CLOSED);
        return zza.toString();
    }
}
