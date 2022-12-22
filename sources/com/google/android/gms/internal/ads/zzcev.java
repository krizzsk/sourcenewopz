package com.google.android.gms.internal.ads;

import android.view.View;
import com.didi.sdk.push.fcm.Constact;
import com.google.android.gms.ads.internal.util.zzd;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcev {
    private final zzcdz zzgfo;
    private final zzchu zzgio;
    private final zzcja zzgix;
    private final zzblv zzgiy;

    public zzcev(zzcja zzcja, zzchu zzchu, zzblv zzblv, zzcdz zzcdz) {
        this.zzgix = zzcja;
        this.zzgio = zzchu;
        this.zzgiy = zzblv;
        this.zzgfo = zzcdz;
    }

    public final View zzapz() throws zzbfu {
        zzbfi zza = this.zzgix.zza(zzvt.zzqk(), (zzdot) null, (zzdoy) null);
        zza.getView().setVisibility(8);
        zza.zza("/sendMessageToSdk", (zzaig<? super zzbfi>) new zzceu(this));
        zza.zza("/adMuted", (zzaig<? super zzbfi>) new zzcex(this));
        this.zzgio.zza(new WeakReference(zza), "/loadHtml", new zzcew(this));
        this.zzgio.zza(new WeakReference(zza), "/showOverlay", new zzcez(this));
        this.zzgio.zza(new WeakReference(zza), "/hideOverlay", new zzcey(this));
        return zza.getView();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbfi zzbfi, Map map) {
        zzd.zzey("Hiding native ads overlay.");
        zzbfi.getView().setVisibility(8);
        this.zzgiy.zzbi(false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbfi zzbfi, Map map) {
        zzd.zzey("Showing native ads overlay.");
        zzbfi.getView().setVisibility(0);
        this.zzgiy.zzbi(true);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constact.KEY_LINK_MESSAGETYPE, "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzgio.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbfi zzbfi, Map map) {
        this.zzgfo.zzaoe();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzbfi zzbfi, Map map) {
        this.zzgio.zza("sendMessageToNativeJs", (Map<String, ?>) map);
    }
}
