package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzxm extends zzgy implements zzxj {
    public zzxm() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2, types: [com.google.android.gms.internal.ads.zzxc] */
    /* JADX WARNING: type inference failed for: r4v9, types: [com.google.android.gms.internal.ads.zzye] */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            r4 = 0
            switch(r1) {
                case 1: goto L_0x00f9;
                case 2: goto L_0x00d8;
                case 3: goto L_0x00c9;
                case 4: goto L_0x00ba;
                case 5: goto L_0x009f;
                case 6: goto L_0x0090;
                case 7: goto L_0x006e;
                case 8: goto L_0x0056;
                case 9: goto L_0x0046;
                case 10: goto L_0x0036;
                case 11: goto L_0x0004;
                case 12: goto L_0x0004;
                case 13: goto L_0x0026;
                case 14: goto L_0x0016;
                case 15: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r1 = 0
            return r1
        L_0x0006:
            android.os.Parcelable$Creator<com.google.android.gms.ads.formats.AdManagerAdViewOptions> r1 = com.google.android.gms.ads.formats.AdManagerAdViewOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.ads.formats.AdManagerAdViewOptions r1 = (com.google.android.gms.ads.formats.AdManagerAdViewOptions) r1
            r0.zza((com.google.android.gms.ads.formats.AdManagerAdViewOptions) r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x0016:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzakg r1 = com.google.android.gms.internal.ads.zzakj.zzab(r1)
            r0.zza((com.google.android.gms.internal.ads.zzakg) r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x0026:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzajy> r1 = com.google.android.gms.internal.ads.zzajy.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzajy r1 = (com.google.android.gms.internal.ads.zzajy) r1
            r0.zza((com.google.android.gms.internal.ads.zzajy) r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x0036:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzagl r1 = com.google.android.gms.internal.ads.zzagk.zzx(r1)
            r0.zza((com.google.android.gms.internal.ads.zzagl) r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x0046:
            android.os.Parcelable$Creator<com.google.android.gms.ads.formats.PublisherAdViewOptions> r1 = com.google.android.gms.ads.formats.PublisherAdViewOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.ads.formats.PublisherAdViewOptions r1 = (com.google.android.gms.ads.formats.PublisherAdViewOptions) r1
            r0.zza((com.google.android.gms.ads.formats.PublisherAdViewOptions) r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x0056:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzagg r1 = com.google.android.gms.internal.ads.zzagj.zzw(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvt> r4 = com.google.android.gms.internal.ads.zzvt.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r2, r4)
            com.google.android.gms.internal.ads.zzvt r2 = (com.google.android.gms.internal.ads.zzvt) r2
            r0.zza(r1, r2)
            r3.writeNoException()
            goto L_0x0103
        L_0x006e:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0075
            goto L_0x0088
        L_0x0075:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzye
            if (r4 == 0) goto L_0x0083
            r4 = r2
            com.google.android.gms.internal.ads.zzye r4 = (com.google.android.gms.internal.ads.zzye) r4
            goto L_0x0088
        L_0x0083:
            com.google.android.gms.internal.ads.zzyd r4 = new com.google.android.gms.internal.ads.zzyd
            r4.<init>(r1)
        L_0x0088:
            r0.zzb((com.google.android.gms.internal.ads.zzye) r4)
            r3.writeNoException()
            goto L_0x0103
        L_0x0090:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaei> r1 = com.google.android.gms.internal.ads.zzaei.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzaei r1 = (com.google.android.gms.internal.ads.zzaei) r1
            r0.zza((com.google.android.gms.internal.ads.zzaei) r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x009f:
            java.lang.String r1 = r2.readString()
            android.os.IBinder r4 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzagd r4 = com.google.android.gms.internal.ads.zzagc.zzv(r4)
            android.os.IBinder r2 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafy r2 = com.google.android.gms.internal.ads.zzagb.zzu(r2)
            r0.zza(r1, r4, r2)
            r3.writeNoException()
            goto L_0x0103
        L_0x00ba:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafx r1 = com.google.android.gms.internal.ads.zzafw.zzt(r1)
            r0.zza((com.google.android.gms.internal.ads.zzafx) r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x00c9:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzafs r1 = com.google.android.gms.internal.ads.zzafv.zzs(r1)
            r0.zza((com.google.android.gms.internal.ads.zzafs) r1)
            r3.writeNoException()
            goto L_0x0103
        L_0x00d8:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x00df
            goto L_0x00f2
        L_0x00df:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzxc
            if (r4 == 0) goto L_0x00ed
            r4 = r2
            com.google.android.gms.internal.ads.zzxc r4 = (com.google.android.gms.internal.ads.zzxc) r4
            goto L_0x00f2
        L_0x00ed:
            com.google.android.gms.internal.ads.zzxe r4 = new com.google.android.gms.internal.ads.zzxe
            r4.<init>(r1)
        L_0x00f2:
            r0.zzb((com.google.android.gms.internal.ads.zzxc) r4)
            r3.writeNoException()
            goto L_0x0103
        L_0x00f9:
            com.google.android.gms.internal.ads.zzxi r1 = r0.zzrf()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgx.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
        L_0x0103:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxm.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
