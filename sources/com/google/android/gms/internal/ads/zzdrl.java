package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdrl implements zzdri {
    private final Object[] zzhrm;

    public zzdrl(zzvq zzvq, String str, int i, String str2, zzwc zzwc) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzvq.zzcia));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zzp(zzvq.extras));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzvq.extras.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzvq.zzcib));
        }
        if (hashSet.contains("keywords")) {
            if (zzvq.zzcic != null) {
                arrayList.add(zzvq.zzcic.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzvq.zzcid));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzvq.zzadv));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzvq.zzbns));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzvq.zzcie);
        }
        if (hashSet.contains("location")) {
            if (zzvq.zzng != null) {
                arrayList.add(zzvq.zzng.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzvq.zzcig);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zzp(zzvq.zzcih));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zzp(zzvq.zzcii));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (zzvq.zzcij != null) {
                arrayList.add(zzvq.zzcij.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzvq.zzcik);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzvq.zzcil);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzvq.zzcim));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(zzvq.zzadw));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzvq.zzadx);
        }
        if (hashSet.contains(OptionsBridge.ORIENTATION_KEY)) {
            if (zzwc != null) {
                arrayList.add(Integer.valueOf(zzwc.orientation));
            } else {
                arrayList.add((Object) null);
            }
        }
        this.zzhrm = arrayList.toArray();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdrl)) {
            return false;
        }
        return Arrays.equals(this.zzhrm, ((zzdrl) obj).zzhrm);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzhrm);
    }

    public final String toString() {
        int hashCode = hashCode();
        String arrays = Arrays.toString(this.zzhrm);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 22);
        sb.append("[PoolKey#");
        sb.append(hashCode);
        sb.append(" ");
        sb.append(arrays);
        sb.append(Const.jaRight);
        return sb.toString();
    }

    private static String zzp(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            if (obj == null) {
                str = "null";
            } else if (obj instanceof Bundle) {
                str = zzp((Bundle) obj);
            } else {
                str = obj.toString();
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
