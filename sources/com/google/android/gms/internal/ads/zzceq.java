package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.push.fcm.Constact;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzceq implements View.OnClickListener {
    private final Clock zzbqq;
    private final zzchu zzgio;
    private zzagr zzgip;
    private zzaig<Object> zzgiq;
    String zzgir;
    Long zzgis;
    WeakReference<View> zzgit;

    public zzceq(zzchu zzchu, Clock clock) {
        this.zzgio = zzchu;
        this.zzbqq = clock;
    }

    public final void zza(zzagr zzagr) {
        this.zzgip = zzagr;
        zzaig<Object> zzaig = this.zzgiq;
        if (zzaig != null) {
            this.zzgio.zzb("/unconfirmedClick", zzaig);
        }
        zzcet zzcet = new zzcet(this, zzagr);
        this.zzgiq = zzcet;
        this.zzgio.zza("/unconfirmedClick", (zzaig<Object>) zzcet);
    }

    public final zzagr zzapx() {
        return this.zzgip;
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzgip != null && this.zzgis != null) {
            zzapy();
            try {
                this.zzgip.onUnconfirmedClickCancelled();
            } catch (RemoteException e) {
                zzbao.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        WeakReference<View> weakReference = this.zzgit;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zzgir == null || this.zzgis == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zzgir);
                hashMap.put(SDKConstants.PARAM_A2U_TIME_INTERVAL, String.valueOf(this.zzbqq.currentTimeMillis() - this.zzgis.longValue()));
                hashMap.put(Constact.KEY_LINK_MESSAGETYPE, "onePointFiveClick");
                this.zzgio.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
            }
            zzapy();
        }
    }

    private final void zzapy() {
        View view;
        this.zzgir = null;
        this.zzgis = null;
        WeakReference<View> weakReference = this.zzgit;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            this.zzgit = null;
        }
    }
}
