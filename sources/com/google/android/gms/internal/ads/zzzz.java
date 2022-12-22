package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzzz extends zzyr {
    private final String description;
    private final String zzcls;

    public zzzz(String str, String str2) {
        this.description = str;
        this.zzcls = str2;
    }

    public final String getDescription() throws RemoteException {
        return this.description;
    }

    public final String zzrk() throws RemoteException {
        return this.zzcls;
    }
}
