package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzapn {
    public static int zza(AdRequest.ErrorCode errorCode) {
        int i = zzapm.zzdpx[errorCode.ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 0 : 3;
        }
        return 2;
    }

    public static MediationAdRequest zza(zzvq zzvq, boolean z) {
        AdRequest.Gender gender;
        HashSet hashSet = zzvq.zzcic != null ? new HashSet(zzvq.zzcic) : null;
        Date date = new Date(zzvq.zzcia);
        int i = zzvq.zzcib;
        if (i == 1) {
            gender = AdRequest.Gender.MALE;
        } else if (i != 2) {
            gender = AdRequest.Gender.UNKNOWN;
        } else {
            gender = AdRequest.Gender.FEMALE;
        }
        return new MediationAdRequest(date, gender, hashSet, z, zzvq.zzng);
    }
}
