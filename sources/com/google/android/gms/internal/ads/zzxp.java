package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzxp extends zzgy implements zzxq {
    public zzxp() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzxq zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface instanceof zzxq) {
            return (zzxq) queryLocalInterface;
        }
        return new zzxs(iBinder);
    }

    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.internal.ads.zzxc] */
    /* JADX WARNING: type inference failed for: r5v7, types: [com.google.android.gms.internal.ads.zzxy] */
    /* JADX WARNING: type inference failed for: r5v12, types: [com.google.android.gms.internal.ads.zzwx] */
    /* JADX WARNING: type inference failed for: r5v17, types: [com.google.android.gms.internal.ads.zzye] */
    /* JADX WARNING: type inference failed for: r5v22, types: [com.google.android.gms.internal.ads.zzxt] */
    /* JADX WARNING: type inference failed for: r5v27, types: [com.google.android.gms.internal.ads.zzyx] */
    /* JADX WARNING: type inference failed for: r5v32, types: [com.google.android.gms.internal.ads.zzxd] */
    /* JADX WARNING: type inference failed for: r5v37, types: [com.google.android.gms.internal.ads.zzyg] */
    /* JADX WARNING: type inference failed for: r5v42 */
    /* JADX WARNING: type inference failed for: r5v43 */
    /* JADX WARNING: type inference failed for: r5v44 */
    /* JADX WARNING: type inference failed for: r5v45 */
    /* JADX WARNING: type inference failed for: r5v46 */
    /* JADX WARNING: type inference failed for: r5v47 */
    /* JADX WARNING: type inference failed for: r5v48 */
    /* JADX WARNING: type inference failed for: r5v49 */
    /* JADX WARNING: type inference failed for: r5v50 */
    /* JADX WARNING: type inference failed for: r5v51 */
    /* JADX WARNING: type inference failed for: r5v52 */
    /* JADX WARNING: type inference failed for: r5v53 */
    /* JADX WARNING: type inference failed for: r5v54 */
    /* JADX WARNING: type inference failed for: r5v55 */
    /* JADX WARNING: type inference failed for: r5v56 */
    /* JADX WARNING: type inference failed for: r5v57 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            r5 = 0
            switch(r2) {
                case 1: goto L_0x02b2;
                case 2: goto L_0x02ab;
                case 3: goto L_0x02a0;
                case 4: goto L_0x028d;
                case 5: goto L_0x0286;
                case 6: goto L_0x027f;
                case 7: goto L_0x025e;
                case 8: goto L_0x023d;
                case 9: goto L_0x0235;
                case 10: goto L_0x022d;
                case 11: goto L_0x0225;
                case 12: goto L_0x0219;
                case 13: goto L_0x0209;
                case 14: goto L_0x01f9;
                case 15: goto L_0x01e5;
                case 16: goto L_0x0004;
                case 17: goto L_0x0004;
                case 18: goto L_0x01d9;
                case 19: goto L_0x01c9;
                case 20: goto L_0x01a7;
                case 21: goto L_0x0185;
                case 22: goto L_0x0179;
                case 23: goto L_0x016d;
                case 24: goto L_0x015d;
                case 25: goto L_0x0151;
                case 26: goto L_0x0145;
                case 27: goto L_0x0004;
                case 28: goto L_0x0004;
                case 29: goto L_0x0135;
                case 30: goto L_0x0125;
                case 31: goto L_0x0119;
                case 32: goto L_0x010d;
                case 33: goto L_0x0101;
                case 34: goto L_0x00f5;
                case 35: goto L_0x00e9;
                case 36: goto L_0x00c7;
                case 37: goto L_0x00bb;
                case 38: goto L_0x00af;
                case 39: goto L_0x009f;
                case 40: goto L_0x008f;
                case 41: goto L_0x0083;
                case 42: goto L_0x0061;
                case 43: goto L_0x0038;
                case 44: goto L_0x0028;
                case 45: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r2 = 0
            return r2
        L_0x0006:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x000d
            goto L_0x0020
        L_0x000d:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IFullScreenContentCallback"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzyg
            if (r5 == 0) goto L_0x001b
            r5 = r3
            com.google.android.gms.internal.ads.zzyg r5 = (com.google.android.gms.internal.ads.zzyg) r5
            goto L_0x0020
        L_0x001b:
            com.google.android.gms.internal.ads.zzyi r5 = new com.google.android.gms.internal.ads.zzyi
            r5.<init>(r2)
        L_0x0020:
            r1.zza((com.google.android.gms.internal.ads.zzyg) r5)
            r4.writeNoException()
            goto L_0x02bc
        L_0x0028:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r1.zze(r2)
            r4.writeNoException()
            goto L_0x02bc
        L_0x0038:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvq> r2 = com.google.android.gms.internal.ads.zzvq.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzvq r2 = (com.google.android.gms.internal.ads.zzvq) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x0047
            goto L_0x0059
        L_0x0047:
            java.lang.String r5 = "com.google.android.gms.ads.internal.client.IAdLoadCallback"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzxd
            if (r0 == 0) goto L_0x0054
            com.google.android.gms.internal.ads.zzxd r5 = (com.google.android.gms.internal.ads.zzxd) r5
            goto L_0x0059
        L_0x0054:
            com.google.android.gms.internal.ads.zzxf r5 = new com.google.android.gms.internal.ads.zzxf
            r5.<init>(r3)
        L_0x0059:
            r1.zza((com.google.android.gms.internal.ads.zzvq) r2, (com.google.android.gms.internal.ads.zzxd) r5)
            r4.writeNoException()
            goto L_0x02bc
        L_0x0061:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0068
            goto L_0x007b
        L_0x0068:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IOnPaidEventListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzyx
            if (r5 == 0) goto L_0x0076
            r5 = r3
            com.google.android.gms.internal.ads.zzyx r5 = (com.google.android.gms.internal.ads.zzyx) r5
            goto L_0x007b
        L_0x0076:
            com.google.android.gms.internal.ads.zzyz r5 = new com.google.android.gms.internal.ads.zzyz
            r5.<init>(r2)
        L_0x007b:
            r1.zza((com.google.android.gms.internal.ads.zzyx) r5)
            r4.writeNoException()
            goto L_0x02bc
        L_0x0083:
            com.google.android.gms.internal.ads.zzzc r2 = r1.zzkm()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r4, (android.os.IInterface) r2)
            goto L_0x02bc
        L_0x008f:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzsq r2 = com.google.android.gms.internal.ads.zzst.zzb(r2)
            r1.zza((com.google.android.gms.internal.ads.zzsq) r2)
            r4.writeNoException()
            goto L_0x02bc
        L_0x009f:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzwc> r2 = com.google.android.gms.internal.ads.zzwc.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzwc r2 = (com.google.android.gms.internal.ads.zzwc) r2
            r1.zza((com.google.android.gms.internal.ads.zzwc) r2)
            r4.writeNoException()
            goto L_0x02bc
        L_0x00af:
            java.lang.String r2 = r3.readString()
            r1.zzbl(r2)
            r4.writeNoException()
            goto L_0x02bc
        L_0x00bb:
            android.os.Bundle r2 = r1.getAdMetadata()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgx.zzb(r4, r2)
            goto L_0x02bc
        L_0x00c7:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x00ce
            goto L_0x00e1
        L_0x00ce:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAdMetadataListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzxt
            if (r5 == 0) goto L_0x00dc
            r5 = r3
            com.google.android.gms.internal.ads.zzxt r5 = (com.google.android.gms.internal.ads.zzxt) r5
            goto L_0x00e1
        L_0x00dc:
            com.google.android.gms.internal.ads.zzxv r5 = new com.google.android.gms.internal.ads.zzxv
            r5.<init>(r2)
        L_0x00e1:
            r1.zza((com.google.android.gms.internal.ads.zzxt) r5)
            r4.writeNoException()
            goto L_0x02bc
        L_0x00e9:
            java.lang.String r2 = r1.zzkl()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x02bc
        L_0x00f5:
            boolean r2 = com.google.android.gms.internal.ads.zzgx.zza(r3)
            r1.setImmersiveMode(r2)
            r4.writeNoException()
            goto L_0x02bc
        L_0x0101:
            com.google.android.gms.internal.ads.zzxc r2 = r1.zzko()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r4, (android.os.IInterface) r2)
            goto L_0x02bc
        L_0x010d:
            com.google.android.gms.internal.ads.zzxy r2 = r1.zzkn()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r4, (android.os.IInterface) r2)
            goto L_0x02bc
        L_0x0119:
            java.lang.String r2 = r1.getAdUnitId()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x02bc
        L_0x0125:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzzj> r2 = com.google.android.gms.internal.ads.zzzj.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzzj r2 = (com.google.android.gms.internal.ads.zzzj) r2
            r1.zza((com.google.android.gms.internal.ads.zzzj) r2)
            r4.writeNoException()
            goto L_0x02bc
        L_0x0135:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaaz> r2 = com.google.android.gms.internal.ads.zzaaz.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzaaz r2 = (com.google.android.gms.internal.ads.zzaaz) r2
            r1.zza((com.google.android.gms.internal.ads.zzaaz) r2)
            r4.writeNoException()
            goto L_0x02bc
        L_0x0145:
            com.google.android.gms.internal.ads.zzzd r2 = r1.getVideoController()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r4, (android.os.IInterface) r2)
            goto L_0x02bc
        L_0x0151:
            java.lang.String r2 = r3.readString()
            r1.setUserId(r2)
            r4.writeNoException()
            goto L_0x02bc
        L_0x015d:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzavn r2 = com.google.android.gms.internal.ads.zzavm.zzap(r2)
            r1.zza((com.google.android.gms.internal.ads.zzavn) r2)
            r4.writeNoException()
            goto L_0x02bc
        L_0x016d:
            boolean r2 = r1.isLoading()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgx.writeBoolean(r4, r2)
            goto L_0x02bc
        L_0x0179:
            boolean r2 = com.google.android.gms.internal.ads.zzgx.zza(r3)
            r1.setManualImpressionsEnabled(r2)
            r4.writeNoException()
            goto L_0x02bc
        L_0x0185:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x018c
            goto L_0x019f
        L_0x018c:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzye
            if (r5 == 0) goto L_0x019a
            r5 = r3
            com.google.android.gms.internal.ads.zzye r5 = (com.google.android.gms.internal.ads.zzye) r5
            goto L_0x019f
        L_0x019a:
            com.google.android.gms.internal.ads.zzyd r5 = new com.google.android.gms.internal.ads.zzyd
            r5.<init>(r2)
        L_0x019f:
            r1.zza((com.google.android.gms.internal.ads.zzye) r5)
            r4.writeNoException()
            goto L_0x02bc
        L_0x01a7:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x01ae
            goto L_0x01c1
        L_0x01ae:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAdClickListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzwx
            if (r5 == 0) goto L_0x01bc
            r5 = r3
            com.google.android.gms.internal.ads.zzwx r5 = (com.google.android.gms.internal.ads.zzwx) r5
            goto L_0x01c1
        L_0x01bc:
            com.google.android.gms.internal.ads.zzwz r5 = new com.google.android.gms.internal.ads.zzwz
            r5.<init>(r2)
        L_0x01c1:
            r1.zza((com.google.android.gms.internal.ads.zzwx) r5)
            r4.writeNoException()
            goto L_0x02bc
        L_0x01c9:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzacm r2 = com.google.android.gms.internal.ads.zzacp.zzl(r2)
            r1.zza((com.google.android.gms.internal.ads.zzacm) r2)
            r4.writeNoException()
            goto L_0x02bc
        L_0x01d9:
            java.lang.String r2 = r1.getMediationAdapterClassName()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x02bc
        L_0x01e5:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzasx r2 = com.google.android.gms.internal.ads.zzasw.zzam(r2)
            java.lang.String r3 = r3.readString()
            r1.zza((com.google.android.gms.internal.ads.zzasx) r2, (java.lang.String) r3)
            r4.writeNoException()
            goto L_0x02bc
        L_0x01f9:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzasr r2 = com.google.android.gms.internal.ads.zzasq.zzak(r2)
            r1.zza((com.google.android.gms.internal.ads.zzasr) r2)
            r4.writeNoException()
            goto L_0x02bc
        L_0x0209:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvt> r2 = com.google.android.gms.internal.ads.zzvt.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzvt r2 = (com.google.android.gms.internal.ads.zzvt) r2
            r1.zza((com.google.android.gms.internal.ads.zzvt) r2)
            r4.writeNoException()
            goto L_0x02bc
        L_0x0219:
            com.google.android.gms.internal.ads.zzvt r2 = r1.zzkk()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgx.zzb(r4, r2)
            goto L_0x02bc
        L_0x0225:
            r1.zzkj()
            r4.writeNoException()
            goto L_0x02bc
        L_0x022d:
            r1.stopLoading()
            r4.writeNoException()
            goto L_0x02bc
        L_0x0235:
            r1.showInterstitial()
            r4.writeNoException()
            goto L_0x02bc
        L_0x023d:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0244
            goto L_0x0257
        L_0x0244:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzxy
            if (r5 == 0) goto L_0x0252
            r5 = r3
            com.google.android.gms.internal.ads.zzxy r5 = (com.google.android.gms.internal.ads.zzxy) r5
            goto L_0x0257
        L_0x0252:
            com.google.android.gms.internal.ads.zzya r5 = new com.google.android.gms.internal.ads.zzya
            r5.<init>(r2)
        L_0x0257:
            r1.zza((com.google.android.gms.internal.ads.zzxy) r5)
            r4.writeNoException()
            goto L_0x02bc
        L_0x025e:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0265
            goto L_0x0278
        L_0x0265:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzxc
            if (r5 == 0) goto L_0x0273
            r5 = r3
            com.google.android.gms.internal.ads.zzxc r5 = (com.google.android.gms.internal.ads.zzxc) r5
            goto L_0x0278
        L_0x0273:
            com.google.android.gms.internal.ads.zzxe r5 = new com.google.android.gms.internal.ads.zzxe
            r5.<init>(r2)
        L_0x0278:
            r1.zza((com.google.android.gms.internal.ads.zzxc) r5)
            r4.writeNoException()
            goto L_0x02bc
        L_0x027f:
            r1.resume()
            r4.writeNoException()
            goto L_0x02bc
        L_0x0286:
            r1.pause()
            r4.writeNoException()
            goto L_0x02bc
        L_0x028d:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvq> r2 = com.google.android.gms.internal.ads.zzvq.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzvq r2 = (com.google.android.gms.internal.ads.zzvq) r2
            boolean r2 = r1.zza((com.google.android.gms.internal.ads.zzvq) r2)
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgx.writeBoolean(r4, r2)
            goto L_0x02bc
        L_0x02a0:
            boolean r2 = r1.isReady()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgx.writeBoolean(r4, r2)
            goto L_0x02bc
        L_0x02ab:
            r1.destroy()
            r4.writeNoException()
            goto L_0x02bc
        L_0x02b2:
            com.google.android.gms.dynamic.IObjectWrapper r2 = r1.zzki()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r4, (android.os.IInterface) r2)
        L_0x02bc:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxp.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
