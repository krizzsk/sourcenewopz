package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public interface zzaob extends IInterface {
    String getBody() throws RemoteException;

    String getCallToAction() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getHeadline() throws RemoteException;

    List getImages() throws RemoteException;

    boolean getOverrideClickHandling() throws RemoteException;

    boolean getOverrideImpressionRecording() throws RemoteException;

    String getPrice() throws RemoteException;

    double getStarRating() throws RemoteException;

    String getStore() throws RemoteException;

    zzzd getVideoController() throws RemoteException;

    void recordImpression() throws RemoteException;

    void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    zzaes zztt() throws RemoteException;

    zzaek zztu() throws RemoteException;

    IObjectWrapper zztv() throws RemoteException;

    void zzv(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzvr() throws RemoteException;

    IObjectWrapper zzvs() throws RemoteException;

    void zzw(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzx(IObjectWrapper iObjectWrapper) throws RemoteException;
}
