package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzedb {
    private static final CopyOnWriteArrayList<zzecy> zzieq = new CopyOnWriteArrayList<>();

    public static zzecy zzhq(String str) throws GeneralSecurityException {
        Iterator<zzecy> it = zzieq.iterator();
        while (it.hasNext()) {
            zzecy next = it.next();
            if (next.zzho(str)) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No KMS client does support: ".concat(valueOf) : new String("No KMS client does support: "));
    }
}
