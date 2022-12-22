package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzso extends zzgy implements zzsp {
    public zzso() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.internal.ads.zzsv] */
    /* JADX WARNING: type inference failed for: r5v7, types: [com.google.android.gms.internal.ads.zzsw] */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            r5 = 0
            switch(r2) {
                case 2: goto L_0x0075;
                case 3: goto L_0x0054;
                case 4: goto L_0x002c;
                case 5: goto L_0x0021;
                case 6: goto L_0x0016;
                case 7: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r2 = 0
            return r2
        L_0x0006:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzyx r2 = com.google.android.gms.internal.ads.zzza.zzi(r2)
            r1.zza((com.google.android.gms.internal.ads.zzyx) r2)
            r4.writeNoException()
            goto L_0x007f
        L_0x0016:
            boolean r2 = com.google.android.gms.internal.ads.zzgx.zza(r3)
            r1.setImmersiveMode(r2)
            r4.writeNoException()
            goto L_0x007f
        L_0x0021:
            com.google.android.gms.internal.ads.zzzc r2 = r1.zzkm()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r4, (android.os.IInterface) r2)
            goto L_0x007f
        L_0x002c:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x003b
            goto L_0x004d
        L_0x003b:
            java.lang.String r5 = "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzsw
            if (r0 == 0) goto L_0x0048
            com.google.android.gms.internal.ads.zzsw r5 = (com.google.android.gms.internal.ads.zzsw) r5
            goto L_0x004d
        L_0x0048:
            com.google.android.gms.internal.ads.zzsy r5 = new com.google.android.gms.internal.ads.zzsy
            r5.<init>(r3)
        L_0x004d:
            r1.zza(r2, r5)
            r4.writeNoException()
            goto L_0x007f
        L_0x0054:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x005b
            goto L_0x006e
        L_0x005b:
            java.lang.String r3 = "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzsv
            if (r5 == 0) goto L_0x0069
            r5 = r3
            com.google.android.gms.internal.ads.zzsv r5 = (com.google.android.gms.internal.ads.zzsv) r5
            goto L_0x006e
        L_0x0069:
            com.google.android.gms.internal.ads.zzsx r5 = new com.google.android.gms.internal.ads.zzsx
            r5.<init>(r2)
        L_0x006e:
            r1.zza((com.google.android.gms.internal.ads.zzsv) r5)
            r4.writeNoException()
            goto L_0x007f
        L_0x0075:
            com.google.android.gms.internal.ads.zzxq r2 = r1.zzea()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r4, (android.os.IInterface) r2)
        L_0x007f:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzso.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
