package com.google.android.gms.maps.internal;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.MapsInitializer;

/* compiled from: com.google.android.gms:play-services-maps@@18.0.0 */
public final class zzca {
    private static final String zza = zzca.class.getSimpleName();
    private static Context zzb = null;
    private static zzf zzc;

    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.maps.internal.zzf zza(android.content.Context r7, com.google.android.gms.maps.MapsInitializer.Renderer r8) throws com.google.android.gms.common.GooglePlayServicesNotAvailableException {
        /*
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            java.lang.String r1 = zza
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r2 = java.lang.String.valueOf(r0)
            r2.length()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "preferredRenderer: "
            java.lang.String r2 = r2.concat(r0)
            r0 = 3
            r3 = 0
            java.lang.String r4 = "com.google.android.gms.maps.internal.zzca"
            r5 = 2
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
            com.google.android.gms.maps.internal.zzf r0 = zzc
            if (r0 != 0) goto L_0x009b
            r0 = 13400000(0xcc77c0, float:1.87774E-38)
            int r0 = com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(r7, r0)
            if (r0 != 0) goto L_0x0095
            java.lang.String r2 = zza
            r1 = 4
            r4 = 0
            r6 = 4
            java.lang.String r3 = "Making Creator dynamically"
            java.lang.String r5 = "com.google.android.gms.maps.internal.zzca"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
            android.content.Context r0 = zzc(r7, r8)
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.String r1 = "com.google.android.gms.maps.internal.CreatorImpl"
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ ClassNotFoundException -> 0x008d }
            java.lang.ClassLoader r0 = (java.lang.ClassLoader) r0     // Catch:{ ClassNotFoundException -> 0x008d }
            java.lang.Class r0 = r0.loadClass(r1)     // Catch:{ ClassNotFoundException -> 0x008d }
            java.lang.Object r0 = zzd(r0)     // Catch:{ ClassNotFoundException -> 0x008d }
            android.os.IBinder r0 = (android.os.IBinder) r0
            if (r0 != 0) goto L_0x0059
            r0 = 0
            goto L_0x006d
        L_0x0059:
            java.lang.String r1 = "com.google.android.gms.maps.internal.ICreator"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.maps.internal.zzf
            if (r2 == 0) goto L_0x0067
            r0 = r1
            com.google.android.gms.maps.internal.zzf r0 = (com.google.android.gms.maps.internal.zzf) r0
            goto L_0x006d
        L_0x0067:
            com.google.android.gms.maps.internal.zze r1 = new com.google.android.gms.maps.internal.zze
            r1.<init>(r0)
            r0 = r1
        L_0x006d:
            zzc = r0
            android.content.Context r7 = zzc(r7, r8)     // Catch:{ RemoteException -> 0x0086 }
            r7.getClass()     // Catch:{ RemoteException -> 0x0086 }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ RemoteException -> 0x0086 }
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r7)     // Catch:{ RemoteException -> 0x0086 }
            int r8 = com.google.android.gms.common.GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE     // Catch:{ RemoteException -> 0x0086 }
            r0.zzk(r7, r8)     // Catch:{ RemoteException -> 0x0086 }
            com.google.android.gms.maps.internal.zzf r7 = zzc
            return r7
        L_0x0086:
            r7 = move-exception
            com.google.android.gms.maps.model.RuntimeRemoteException r8 = new com.google.android.gms.maps.model.RuntimeRemoteException
            r8.<init>(r7)
            throw r8
        L_0x008d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Unable to find dynamic class com.google.android.gms.maps.internal.CreatorImpl"
            r7.<init>(r8)
            throw r7
        L_0x0095:
            com.google.android.gms.common.GooglePlayServicesNotAvailableException r7 = new com.google.android.gms.common.GooglePlayServicesNotAvailableException
            r7.<init>(r0)
            throw r7
        L_0x009b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.internal.zzca.zza(android.content.Context, com.google.android.gms.maps.MapsInitializer$Renderer):com.google.android.gms.maps.internal.zzf");
    }

    private static Context zzb(Exception exc, Context context) {
        SystemUtils.log(6, zza, "Failed to load maps module, use pre-Chimera", exc, "com.google.android.gms.maps.internal.zzca", 1);
        return GooglePlayServicesUtil.getRemoteContext(context);
    }

    private static Context zzc(Context context, MapsInitializer.Renderer renderer) {
        String str;
        Context context2;
        Context context3 = zzb;
        if (context3 != null) {
            return context3;
        }
        context.getApplicationContext();
        if (renderer != null) {
            int ordinal = renderer.ordinal();
            if (ordinal == 0) {
                str = "com.google.android.gms.maps_legacy_dynamite";
            } else if (ordinal == 1) {
                str = "com.google.android.gms.maps_core_dynamite";
            }
            context2 = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, str).getModuleContext();
            zzb = context2;
            return context2;
        }
        str = "com.google.android.gms.maps_dynamite";
        try {
            context2 = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, str).getModuleContext();
        } catch (Exception e) {
            if (!str.equals("com.google.android.gms.maps_dynamite")) {
                try {
                    SystemUtils.log(3, zza, "Attempting to load maps_dynamite again.", (Throwable) null, "com.google.android.gms.maps.internal.zzca", 7);
                    context2 = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.maps_dynamite").getModuleContext();
                } catch (Exception e2) {
                    context2 = zzb(e2, context);
                }
            } else {
                context2 = zzb(e, context);
            }
        }
        zzb = context2;
        return context2;
    }

    private static <T> T zzd(Class cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException unused) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf.length() != 0 ? "Unable to instantiate the dynamic class ".concat(valueOf) : new String("Unable to instantiate the dynamic class "));
        } catch (IllegalAccessException unused2) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf2.length() != 0 ? "Unable to call the default constructor of ".concat(valueOf2) : new String("Unable to call the default constructor of "));
        }
    }
}
