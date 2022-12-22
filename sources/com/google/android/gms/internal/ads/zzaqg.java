package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class zzaqg {
    public static zzaqa zzdp(String str) throws RemoteException {
        try {
            return new zzaqj((RtbAdapter) Class.forName(str, false, zzaqg.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Throwable unused) {
            throw new RemoteException();
        }
    }
}
