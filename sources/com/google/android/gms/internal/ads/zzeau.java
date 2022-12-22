package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeal;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
abstract class zzeau<V, C> extends zzeal<V, C> {
    private List<zzeaw<V>> zzidg;

    zzeau(zzdyv<? extends zzebt<? extends V>> zzdyv, boolean z) {
        super(zzdyv, true, true);
        List<zzeaw<V>> list;
        if (zzdyv.isEmpty()) {
            list = zzdza.zzbal();
        } else {
            list = zzdzi.zzfb(zzdyv.size());
        }
        for (int i = 0; i < zzdyv.size(); i++) {
            list.add((Object) null);
        }
        this.zzidg = list;
    }

    /* access modifiers changed from: package-private */
    public abstract C zzl(List<zzeaw<V>> list);

    /* access modifiers changed from: package-private */
    public final void zzb(int i, @NullableDecl V v) {
        List<zzeaw<V>> list = this.zzidg;
        if (list != null) {
            list.set(i, new zzeaw(v));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzbaw() {
        List<zzeaw<V>> list = this.zzidg;
        if (list != null) {
            set(zzl(list));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeal.zza zza) {
        super.zza(zza);
        this.zzidg = null;
    }
}
