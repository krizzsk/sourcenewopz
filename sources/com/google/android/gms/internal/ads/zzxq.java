package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public interface zzxq extends IInterface {
    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getAdUnitId() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzzd getVideoController() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(zzaaz zzaaz) throws RemoteException;

    void zza(zzacm zzacm) throws RemoteException;

    void zza(zzasr zzasr) throws RemoteException;

    void zza(zzasx zzasx, String str) throws RemoteException;

    void zza(zzavn zzavn) throws RemoteException;

    void zza(zzsq zzsq) throws RemoteException;

    void zza(zzvq zzvq, zzxd zzxd) throws RemoteException;

    void zza(zzvt zzvt) throws RemoteException;

    void zza(zzwc zzwc) throws RemoteException;

    void zza(zzwx zzwx) throws RemoteException;

    void zza(zzxc zzxc) throws RemoteException;

    void zza(zzxt zzxt) throws RemoteException;

    void zza(zzxy zzxy) throws RemoteException;

    void zza(zzye zzye) throws RemoteException;

    void zza(zzyg zzyg) throws RemoteException;

    void zza(zzyx zzyx) throws RemoteException;

    void zza(zzzj zzzj) throws RemoteException;

    boolean zza(zzvq zzvq) throws RemoteException;

    void zzbl(String str) throws RemoteException;

    void zze(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzki() throws RemoteException;

    void zzkj() throws RemoteException;

    zzvt zzkk() throws RemoteException;

    String zzkl() throws RemoteException;

    zzzc zzkm() throws RemoteException;

    zzxy zzkn() throws RemoteException;

    zzxc zzko() throws RemoteException;
}
