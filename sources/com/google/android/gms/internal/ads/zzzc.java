package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public interface zzzc extends IInterface {
    List<zzvx> getAdapterResponses() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    String getResponseId() throws RemoteException;
}
