package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public interface zzano extends IInterface {
    void destroy() throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzzd getVideoController() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzajo zzajo, List<zzajw> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzavu zzavu, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzant zzant) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzavu zzavu, String str2) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, String str2, zzant zzant) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, String str2, zzant zzant, zzaei zzaei, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvt zzvt, zzvq zzvq, String str, zzant zzant) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvt zzvt, zzvq zzvq, String str, String str2, zzant zzant) throws RemoteException;

    void zza(zzvq zzvq, String str) throws RemoteException;

    void zza(zzvq zzvq, String str, String str2) throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzant zzant) throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper, zzvt zzvt, zzvq zzvq, String str, String str2, zzant zzant) throws RemoteException;

    void zzc(IObjectWrapper iObjectWrapper, zzvq zzvq, String str, zzant zzant) throws RemoteException;

    void zzs(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzt(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzu(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzve() throws RemoteException;

    zzaob zzvf() throws RemoteException;

    zzaoc zzvg() throws RemoteException;

    Bundle zzvh() throws RemoteException;

    Bundle zzvi() throws RemoteException;

    boolean zzvj() throws RemoteException;

    zzafo zzvk() throws RemoteException;

    zzaoh zzvl() throws RemoteException;

    zzaqr zzvm() throws RemoteException;

    zzaqr zzvn() throws RemoteException;

    zzanu zzvo() throws RemoteException;
}
