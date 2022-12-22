package com.google.android.gms.maps;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-maps@@18.0.0 */
public final class MapsInitializer {
    private static final String zza = MapsInitializer.class.getSimpleName();
    private static boolean zzb = false;
    private static Renderer zzc = Renderer.LEGACY;

    /* compiled from: com.google.android.gms:play-services-maps@@18.0.0 */
    public enum Renderer {
        LEGACY,
        LATEST
    }

    private MapsInitializer() {
    }

    public static synchronized int initialize(Context context) {
        int initialize;
        synchronized (MapsInitializer.class) {
            initialize = initialize(context, (Renderer) null, (OnMapsSdkInitializedCallback) null);
        }
        return initialize;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a7, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        return 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063 A[Catch:{ RemoteException -> 0x00a8, RemoteException -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a1 A[Catch:{ RemoteException -> 0x00a8, RemoteException -> 0x006f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int initialize(android.content.Context r18, com.google.android.gms.maps.MapsInitializer.Renderer r19, com.google.android.gms.maps.OnMapsSdkInitializedCallback r20) {
        /*
            r1 = r20
            java.lang.Class<com.google.android.gms.maps.MapsInitializer> r2 = com.google.android.gms.maps.MapsInitializer.class
            monitor-enter(r2)
            java.lang.String r0 = "Context is null"
            r3 = r18
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3, r0)     // Catch:{ all -> 0x00b5 }
            java.lang.String r5 = zza     // Catch:{ all -> 0x00b5 }
            java.lang.String r0 = java.lang.String.valueOf(r19)     // Catch:{ all -> 0x00b5 }
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00b5 }
            r4.length()     // Catch:{ all -> 0x00b5 }
            java.lang.String r4 = "preferredRenderer: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00b5 }
            java.lang.String r6 = r4.concat(r0)     // Catch:{ all -> 0x00b5 }
            r4 = 3
            r7 = 0
            java.lang.String r8 = "com.google.android.gms.maps.MapsInitializer"
            r9 = 3
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00b5 }
            boolean r0 = zzb     // Catch:{ all -> 0x00b5 }
            r4 = 0
            if (r0 == 0) goto L_0x0039
            if (r1 == 0) goto L_0x0037
            com.google.android.gms.maps.MapsInitializer$Renderer r0 = zzc     // Catch:{ all -> 0x00b5 }
            r1.onMapsSdkInitialized(r0)     // Catch:{ all -> 0x00b5 }
        L_0x0037:
            monitor-exit(r2)
            return r4
        L_0x0039:
            com.google.android.gms.maps.internal.zzf r0 = com.google.android.gms.maps.internal.zzca.zza(r18, r19)     // Catch:{ GooglePlayServicesNotAvailableException -> 0x00af }
            com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate r5 = r0.zze()     // Catch:{ RemoteException -> 0x00a8 }
            com.google.android.gms.maps.CameraUpdateFactory.zza(r5)     // Catch:{ RemoteException -> 0x00a8 }
            com.google.android.gms.internal.maps.zzi r5 = r0.zzj()     // Catch:{ RemoteException -> 0x00a8 }
            com.google.android.gms.maps.model.BitmapDescriptorFactory.zza(r5)     // Catch:{ RemoteException -> 0x00a8 }
            r5 = 1
            zzb = r5     // Catch:{ all -> 0x00b5 }
            r6 = 2
            if (r19 == 0) goto L_0x005c
            int r7 = r19.ordinal()     // Catch:{ all -> 0x00b5 }
            if (r7 == 0) goto L_0x005d
            if (r7 == r5) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r5 = 2
            goto L_0x005d
        L_0x005c:
            r5 = 0
        L_0x005d:
            int r7 = r0.zzd()     // Catch:{ RemoteException -> 0x006f }
            if (r7 != r6) goto L_0x0067
            com.google.android.gms.maps.MapsInitializer$Renderer r6 = com.google.android.gms.maps.MapsInitializer.Renderer.LATEST     // Catch:{ RemoteException -> 0x006f }
            zzc = r6     // Catch:{ RemoteException -> 0x006f }
        L_0x0067:
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r18)     // Catch:{ RemoteException -> 0x006f }
            r0.zzl(r3, r5)     // Catch:{ RemoteException -> 0x006f }
            goto L_0x007d
        L_0x006f:
            r0 = move-exception
            r9 = r0
            java.lang.String r7 = zza     // Catch:{ all -> 0x00b5 }
            java.lang.String r8 = "Failed to retrieve renderer type or log initialization."
            r6 = 6
            java.lang.String r10 = "com.google.android.gms.maps.MapsInitializer"
            r11 = 13
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00b5 }
        L_0x007d:
            java.lang.String r13 = zza     // Catch:{ all -> 0x00b5 }
            com.google.android.gms.maps.MapsInitializer$Renderer r0 = zzc     // Catch:{ all -> 0x00b5 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00b5 }
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00b5 }
            r3.length()     // Catch:{ all -> 0x00b5 }
            java.lang.String r3 = "loadedRenderer: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00b5 }
            java.lang.String r14 = r3.concat(r0)     // Catch:{ all -> 0x00b5 }
            r12 = 3
            r15 = 0
            java.lang.String r16 = "com.google.android.gms.maps.MapsInitializer"
            r17 = 14
            com.didi.sdk.apm.SystemUtils.log(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x00b5 }
            if (r1 == 0) goto L_0x00a6
            com.google.android.gms.maps.MapsInitializer$Renderer r0 = zzc     // Catch:{ all -> 0x00b5 }
            r1.onMapsSdkInitialized(r0)     // Catch:{ all -> 0x00b5 }
        L_0x00a6:
            monitor-exit(r2)
            return r4
        L_0x00a8:
            r0 = move-exception
            com.google.android.gms.maps.model.RuntimeRemoteException r1 = new com.google.android.gms.maps.model.RuntimeRemoteException     // Catch:{ all -> 0x00b5 }
            r1.<init>(r0)     // Catch:{ all -> 0x00b5 }
            throw r1     // Catch:{ all -> 0x00b5 }
        L_0x00af:
            r0 = move-exception
            r1 = r0
            int r0 = r1.errorCode     // Catch:{ all -> 0x00b5 }
            monitor-exit(r2)
            return r0
        L_0x00b5:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.MapsInitializer.initialize(android.content.Context, com.google.android.gms.maps.MapsInitializer$Renderer, com.google.android.gms.maps.OnMapsSdkInitializedCallback):int");
    }
}
