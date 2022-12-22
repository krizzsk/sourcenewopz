package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzuh;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcru {
    private static final SparseArray<zzuh.zzo.zzb> zzgtt;
    private final Context context;
    /* access modifiers changed from: private */
    public final zzf zzeci;
    private final zzbsc zzfzn;
    private final zzcrr zzgqu;
    private final TelephonyManager zzgtq;
    /* access modifiers changed from: private */
    public final zzcrl zzgtr;
    private zzur zzgts;

    zzcru(Context context2, zzbsc zzbsc, zzcrr zzcrr, zzcrl zzcrl, zzf zzf) {
        this.context = context2;
        this.zzfzn = zzbsc;
        this.zzgqu = zzcrr;
        this.zzgtr = zzcrl;
        this.zzgtq = (TelephonyManager) context2.getSystemService("phone");
        this.zzeci = zzf;
    }

    private static zzur zzbn(boolean z) {
        return z ? zzur.ENUM_TRUE : zzur.ENUM_FALSE;
    }

    /* access modifiers changed from: private */
    public final zzuh.zzm zzj(Bundle bundle) {
        zzuh.zzm.zzb zzb;
        zzuh.zzm.zza zzov = zzuh.zzm.zzov();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.zzgts = zzur.ENUM_TRUE;
        } else {
            this.zzgts = zzur.ENUM_FALSE;
            if (i == 0) {
                zzov.zza(zzuh.zzm.zzc.CELL);
            } else if (i != 1) {
                zzov.zza(zzuh.zzm.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzov.zza(zzuh.zzm.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzb = zzuh.zzm.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzb = zzuh.zzm.zzb.THREE_G;
                    break;
                case 13:
                    zzb = zzuh.zzm.zzb.LTE;
                    break;
                default:
                    zzb = zzuh.zzm.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzov.zza(zzb);
        }
        return (zzuh.zzm) ((zzena) zzov.zzbjv());
    }

    /* access modifiers changed from: private */
    public static zzuh.zzo.zzb zzk(Bundle bundle) {
        return zzgtt.get(zzdpw.zza(zzdpw.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzuh.zzo.zzb.UNSPECIFIED);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zzuh.zzc.zza> zzl(android.os.Bundle r7) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r7 = r7.get(r0)
            boolean r0 = r7 instanceof java.util.List
            if (r0 == 0) goto L_0x000d
            java.util.List r7 = (java.util.List) r7
            goto L_0x0017
        L_0x000d:
            boolean r0 = r7 instanceof java.lang.String[]
            if (r0 == 0) goto L_0x003d
            java.lang.String[] r7 = (java.lang.String[]) r7
            java.util.List r7 = java.util.Arrays.asList(r7)
        L_0x0017:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.size()
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L_0x0024:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0038
            java.lang.Object r1 = r7.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0024
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
            goto L_0x0024
        L_0x0038:
            java.util.List r7 = java.util.Collections.unmodifiableList(r0)
            goto L_0x0041
        L_0x003d:
            java.util.List r7 = java.util.Collections.emptyList()
        L_0x0041:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x004a:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x00a3
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r3 = r1.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case -1396342996: goto L_0x0080;
                case -1052618729: goto L_0x0076;
                case -239580146: goto L_0x006c;
                case 604727084: goto L_0x0062;
                default: goto L_0x0061;
            }
        L_0x0061:
            goto L_0x0089
        L_0x0062:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 1
            goto L_0x0089
        L_0x006c:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 3
            goto L_0x0089
        L_0x0076:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 2
            goto L_0x0089
        L_0x0080:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            r2 = 0
        L_0x0089:
            if (r2 == 0) goto L_0x009d
            if (r2 == r6) goto L_0x009a
            if (r2 == r5) goto L_0x0097
            if (r2 == r4) goto L_0x0094
            com.google.android.gms.internal.ads.zzuh$zzc$zza r1 = com.google.android.gms.internal.ads.zzuh.zzc.zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto L_0x009f
        L_0x0094:
            com.google.android.gms.internal.ads.zzuh$zzc$zza r1 = com.google.android.gms.internal.ads.zzuh.zzc.zza.REWARD_BASED_VIDEO_AD
            goto L_0x009f
        L_0x0097:
            com.google.android.gms.internal.ads.zzuh$zzc$zza r1 = com.google.android.gms.internal.ads.zzuh.zzc.zza.NATIVE_APP_INSTALL
            goto L_0x009f
        L_0x009a:
            com.google.android.gms.internal.ads.zzuh$zzc$zza r1 = com.google.android.gms.internal.ads.zzuh.zzc.zza.INTERSTITIAL
            goto L_0x009f
        L_0x009d:
            com.google.android.gms.internal.ads.zzuh$zzc$zza r1 = com.google.android.gms.internal.ads.zzuh.zzc.zza.BANNER
        L_0x009f:
            r0.add(r1)
            goto L_0x004a
        L_0x00a3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcru.zzl(android.os.Bundle):java.util.ArrayList");
    }

    /* access modifiers changed from: private */
    public final byte[] zza(boolean z, ArrayList<zzuh.zzc.zza> arrayList, zzuh.zzm zzm, zzuh.zzo.zzb zzb) {
        boolean z2 = true;
        zzuh.zzo.zza.C22029zza zzes = zzuh.zzo.zza.zzpk().zze(arrayList).zzh(zzbn(zzr.zzkx().zzb(this.context.getContentResolver()) != 0)).zzi(zzr.zzkx().zza(this.context, this.zzgtq)).zzet(this.zzgqu.zzpa()).zzeu(this.zzgqu.zzpb()).zzcm(this.zzgqu.getResponseCode()).zzb(zzb).zzb(zzm).zzj(this.zzgts).zzf(zzbn(z)).zzes(zzr.zzlc().currentTimeMillis());
        if (zzr.zzkx().zza(this.context.getContentResolver()) == 0) {
            z2 = false;
        }
        return ((zzuh.zzo.zza) ((zzena) zzes.zzg(zzbn(z2)).zzbjv())).toByteArray();
    }

    public final void zzbm(boolean z) {
        zzebh.zza(this.zzfzn.zzamc(), new zzcrx(this, z), zzbat.zzekj);
    }

    static {
        SparseArray<zzuh.zzo.zzb> sparseArray = new SparseArray<>();
        zzgtt = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzuh.zzo.zzb.CONNECTED);
        zzgtt.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzuh.zzo.zzb.CONNECTING);
        zzgtt.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzuh.zzo.zzb.CONNECTING);
        zzgtt.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzuh.zzo.zzb.CONNECTING);
        zzgtt.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzuh.zzo.zzb.DISCONNECTING);
        zzgtt.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzuh.zzo.zzb.DISCONNECTED);
        zzgtt.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzuh.zzo.zzb.DISCONNECTED);
        zzgtt.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzuh.zzo.zzb.DISCONNECTED);
        zzgtt.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzuh.zzo.zzb.DISCONNECTED);
        zzgtt.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzuh.zzo.zzb.DISCONNECTED);
        zzgtt.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzuh.zzo.zzb.SUSPENDED);
        if (Build.VERSION.SDK_INT >= 17) {
            zzgtt.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzuh.zzo.zzb.CONNECTING);
        }
        zzgtt.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzuh.zzo.zzb.CONNECTING);
    }
}
