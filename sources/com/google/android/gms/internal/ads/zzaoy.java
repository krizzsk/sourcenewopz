package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaoy<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzanr {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzdpp;
    private final NETWORK_EXTRAS zzdpq;

    public zzaoy(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzdpp = mediationAdapter;
        this.zzdpq = network_extras;
    }

    public final zzzd getVideoController() {
        return null;
    }

    public final boolean isInitialized() {
        return true;
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final void showVideo() {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzajo zzajo, List<zzajw> list) throws RemoteException {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzavu zzavu, List<String> list) {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzavu zzavu, String str2) throws RemoteException {
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, String str2, zzant zzant, zzaei zzaei, List<String> list) {
    }

    public final void zza(zzvq zzvq, String str) {
    }

    public final void zza(zzvq zzvq, String str, String str2) {
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzant zzant) throws RemoteException {
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzvt zzvt, zzvq zzvq, String str, String str2, zzant zzant) {
    }

    public final void zzc(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzant zzant) throws RemoteException {
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
    }

    public final zzaob zzvf() {
        return null;
    }

    public final zzaoc zzvg() {
        return null;
    }

    public final boolean zzvj() {
        return false;
    }

    public final zzafo zzvk() {
        return null;
    }

    public final zzaoh zzvl() {
        return null;
    }

    public final zzaqr zzvm() {
        return null;
    }

    public final zzaqr zzvn() {
        return null;
    }

    public final zzanu zzvo() {
        return null;
    }

    public final IObjectWrapper zzve() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdpp;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbao.zzez(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) mediationAdapter).getBannerView());
        } catch (Throwable th) {
            zzbao.zzc("", th);
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvt zzvt, zzvq zzvq, String str, zzant zzant) throws RemoteException {
        zza(iObjectWrapper, zzvt, zzvq, str, (String) null, zzant);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvt zzvt, zzvq zzvq, String str, String str2, zzant zzant) throws RemoteException {
        AdSize adSize;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdpp;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbao.zzez(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzbao.zzdz("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdpp;
            zzapb zzapb = new zzapb(zzant);
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
            MediationServerParameters zzdl = zzdl(str);
            int i = 0;
            AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
            while (true) {
                if (i < 6) {
                    if (adSizeArr[i].getWidth() == zzvt.width && adSizeArr[i].getHeight() == zzvt.height) {
                        adSize = adSizeArr[i];
                        break;
                    }
                    i++;
                } else {
                    adSize = new AdSize(zza.zza(zzvt.width, zzvt.height, zzvt.zzadd));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzapb, activity, zzdl, adSize, zzapn.zza(zzvq, zzc(zzvq)), this.zzdpq);
        } catch (Throwable th) {
            zzbao.zzc("", th);
            throw new RemoteException();
        }
    }

    public final Bundle zzvh() {
        return new Bundle();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzant zzant) throws RemoteException {
        zza(iObjectWrapper, zzvq, str, (String) null, zzant);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, String str2, zzant zzant) throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdpp;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbao.zzez(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbao.zzdz("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdpp).requestInterstitialAd(new zzapb(zzant), (Activity) ObjectWrapper.unwrap(iObjectWrapper), zzdl(str), zzapn.zza(zzvq, zzc(zzvq)), this.zzdpq);
        } catch (Throwable th) {
            zzbao.zzc("", th);
            throw new RemoteException();
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    public final void showInterstitial() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdpp;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbao.zzez(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbao.zzdz("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdpp).showInterstitial();
        } catch (Throwable th) {
            zzbao.zzc("", th);
            throw new RemoteException();
        }
    }

    public final Bundle zzvi() {
        return new Bundle();
    }

    public final void destroy() throws RemoteException {
        try {
            this.zzdpp.destroy();
        } catch (Throwable th) {
            zzbao.zzc("", th);
            throw new RemoteException();
        }
    }

    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    private final SERVER_PARAMETERS zzdl(String str) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.zzdpp.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (MediationServerParameters) serverParametersType.newInstance();
        server_parameters.load(hashMap);
        return server_parameters;
    }

    private static boolean zzc(zzvq zzvq) {
        if (zzvq.zzcid) {
            return true;
        }
        zzww.zzqw();
        return zzbae.zzaap();
    }
}
