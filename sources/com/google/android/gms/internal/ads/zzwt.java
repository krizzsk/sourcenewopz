package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
abstract class zzwt<T> {
    private static final zzxz zzcjw = zzqt();

    zzwt() {
    }

    /* access modifiers changed from: protected */
    public abstract T zza(zzxz zzxz) throws RemoteException;

    /* access modifiers changed from: protected */
    public abstract T zzqp();

    /* access modifiers changed from: protected */
    public abstract T zzqq() throws RemoteException;

    private static zzxz zzqt() {
        try {
            Object newInstance = zzwd.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzbao.zzez("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            if (queryLocalInterface instanceof zzxz) {
                return (zzxz) queryLocalInterface;
            }
            return new zzyb(iBinder);
        } catch (Exception unused) {
            zzbao.zzez("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    private final T zzqu() {
        zzxz zzxz = zzcjw;
        if (zzxz == null) {
            zzbao.zzez("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zza(zzxz);
        } catch (RemoteException e) {
            zzbao.zzd("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    private final T zzqv() {
        try {
            return zzqq();
        } catch (RemoteException e) {
            zzbao.zzd("Cannot invoke remote loader.", e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzd(android.content.Context r10, boolean r11) {
        /*
            r9 = this;
            r0 = 0
            r1 = 1
            if (r11 != 0) goto L_0x0006
            r11 = 0
            goto L_0x0007
        L_0x0006:
            r11 = 1
        L_0x0007:
            if (r11 != 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzww.zzqw()
            r2 = 12451000(0xbdfcb8, float:1.7447567E-38)
            boolean r2 = com.google.android.gms.internal.ads.zzbae.zzf(r10, r2)
            if (r2 != 0) goto L_0x001b
            java.lang.String r11 = "Google Play Services is not available."
            com.google.android.gms.internal.ads.zzbao.zzdz(r11)
            r11 = 1
        L_0x001b:
            java.lang.String r2 = "com.google.android.gms.ads.dynamite"
            int r3 = com.google.android.gms.dynamite.DynamiteModule.getLocalVersion(r10, r2)
            int r2 = com.google.android.gms.dynamite.DynamiteModule.getRemoteVersion(r10, r2)
            if (r3 <= r2) goto L_0x0028
            r11 = 1
        L_0x0028:
            com.google.android.gms.internal.ads.zzabq.initialize(r10)
            com.google.android.gms.internal.ads.zzacy<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzadj.zzdem
            java.lang.Object r2 = r2.get()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x003b
            r11 = 0
            goto L_0x004c
        L_0x003b:
            com.google.android.gms.internal.ads.zzacy<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzadj.zzden
            java.lang.Object r2 = r2.get()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x004c
            r11 = 1
            r2 = 1
            goto L_0x004d
        L_0x004c:
            r2 = 0
        L_0x004d:
            if (r11 == 0) goto L_0x005c
            java.lang.Object r10 = r9.zzqu()
            if (r10 != 0) goto L_0x00aa
            if (r2 != 0) goto L_0x00aa
            java.lang.Object r10 = r9.zzqv()
            goto L_0x00aa
        L_0x005c:
            java.lang.Object r11 = r9.zzqv()
            if (r11 != 0) goto L_0x0064
            r2 = 1
            goto L_0x0065
        L_0x0064:
            r2 = 0
        L_0x0065:
            if (r2 == 0) goto L_0x00a2
            com.google.android.gms.internal.ads.zzacy<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzads.zzdfp
            java.lang.Object r3 = r3.get()
            java.lang.Long r3 = (java.lang.Long) r3
            int r3 = r3.intValue()
            java.util.Random r4 = com.google.android.gms.internal.ads.zzww.zzrd()
            int r3 = r4.nextInt(r3)
            if (r3 != 0) goto L_0x007e
            r0 = 1
        L_0x007e:
            if (r0 == 0) goto L_0x00a2
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            java.lang.String r0 = "action"
            java.lang.String r1 = "dynamite_load"
            r7.putString(r0, r1)
            java.lang.String r0 = "is_missing"
            r7.putInt(r0, r2)
            com.google.android.gms.internal.ads.zzbae r3 = com.google.android.gms.internal.ads.zzww.zzqw()
            com.google.android.gms.internal.ads.zzbar r0 = com.google.android.gms.internal.ads.zzww.zzrc()
            java.lang.String r5 = r0.zzbrz
            r8 = 1
            java.lang.String r6 = "gmob-apps"
            r4 = r10
            r3.zza((android.content.Context) r4, (java.lang.String) r5, (java.lang.String) r6, (android.os.Bundle) r7, (boolean) r8)
        L_0x00a2:
            if (r11 != 0) goto L_0x00a9
            java.lang.Object r10 = r9.zzqu()
            goto L_0x00aa
        L_0x00a9:
            r10 = r11
        L_0x00aa:
            if (r10 != 0) goto L_0x00b0
            java.lang.Object r10 = r9.zzqp()
        L_0x00b0:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwt.zzd(android.content.Context, boolean):java.lang.Object");
    }
}
