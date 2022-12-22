package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.onehotpatch.openapi.HotpatchStateConst;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    public static final int REMOTE = 1;
    public static final VersionPolicy zza = new zzl();
    private static Boolean zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static Boolean zzf;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    private static zzq zzk;
    private static zzr zzl;
    private final Context zzj;

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzp) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzp) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            SystemUtils.log(6, "DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + str + "'", (Throwable) null, "com.google.android.gms.dynamite.DynamiteModule", 8);
            return 0;
        } catch (ClassNotFoundException unused) {
            SystemUtils.log(5, "DynamiteModule", "Local module descriptor class for " + str + " not found.", (Throwable) null, "com.google.android.gms.dynamite.DynamiteModule", 11);
            return 0;
        } catch (Exception e) {
            SystemUtils.log(6, "DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())), (Throwable) null, "com.google.android.gms.dynamite.DynamiteModule", 10);
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02c2, code lost:
        if (r1 != null) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a4, code lost:
        if (r1 != null) goto L_0x00a6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0332  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule load(android.content.Context r27, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy r28, java.lang.String r29) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r1 = r27
            r2 = r28
            r3 = r29
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r4 = com.google.android.gms.dynamite.DynamiteModule.class
            java.lang.ThreadLocal r0 = zzg
            java.lang.Object r0 = r0.get()
            r5 = r0
            com.google.android.gms.dynamite.zzn r5 = (com.google.android.gms.dynamite.zzn) r5
            com.google.android.gms.dynamite.zzn r6 = new com.google.android.gms.dynamite.zzn
            r7 = 0
            r6.<init>(r7)
            java.lang.ThreadLocal r0 = zzg
            r0.set(r6)
            java.lang.ThreadLocal r0 = zzh
            java.lang.Object r0 = r0.get()
            java.lang.Long r0 = (java.lang.Long) r0
            long r8 = r0.longValue()
            r10 = 0
            java.lang.ThreadLocal r0 = zzh     // Catch:{ all -> 0x0319 }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0319 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0319 }
            r0.set(r12)     // Catch:{ all -> 0x0319 }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions r0 = zzi     // Catch:{ all -> 0x0319 }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r12 = r2.selectModule(r1, r3, r0)     // Catch:{ all -> 0x0319 }
            int r0 = r12.localVersion     // Catch:{ all -> 0x0319 }
            int r13 = r12.remoteVersion     // Catch:{ all -> 0x0319 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0319 }
            r14.<init>()     // Catch:{ all -> 0x0319 }
            java.lang.String r15 = "Considering local module "
            r14.append(r15)     // Catch:{ all -> 0x0319 }
            r14.append(r3)     // Catch:{ all -> 0x0319 }
            java.lang.String r15 = ":"
            r14.append(r15)     // Catch:{ all -> 0x0319 }
            r14.append(r0)     // Catch:{ all -> 0x0319 }
            java.lang.String r0 = " and remote module "
            r14.append(r0)     // Catch:{ all -> 0x0319 }
            r14.append(r3)     // Catch:{ all -> 0x0319 }
            java.lang.String r0 = ":"
            r14.append(r0)     // Catch:{ all -> 0x0319 }
            r14.append(r13)     // Catch:{ all -> 0x0319 }
            java.lang.String r16 = "DynamiteModule"
            java.lang.String r17 = r14.toString()     // Catch:{ all -> 0x0319 }
            r15 = 4
            r18 = 0
            java.lang.String r19 = "com.google.android.gms.dynamite.DynamiteModule"
            r20 = 6
            com.didi.sdk.apm.SystemUtils.log(r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0319 }
            int r0 = r12.selection     // Catch:{ all -> 0x0319 }
            if (r0 == 0) goto L_0x02e5
            r13 = -1
            if (r0 != r13) goto L_0x0082
            int r0 = r12.localVersion     // Catch:{ all -> 0x0319 }
            if (r0 == 0) goto L_0x02e5
            r0 = -1
        L_0x0082:
            r14 = 1
            if (r0 != r14) goto L_0x0089
            int r15 = r12.remoteVersion     // Catch:{ all -> 0x0319 }
            if (r15 == 0) goto L_0x02e5
        L_0x0089:
            if (r0 != r13) goto L_0x00af
            com.google.android.gms.dynamite.DynamiteModule r0 = zzc(r1, r3)     // Catch:{ all -> 0x0319 }
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x0099
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x00a2
        L_0x0099:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            r1.set(r2)
        L_0x00a2:
            android.database.Cursor r1 = r6.zza
            if (r1 == 0) goto L_0x00a9
        L_0x00a6:
            r1.close()
        L_0x00a9:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r5)
            return r0
        L_0x00af:
            if (r0 != r14) goto L_0x02ce
            int r0 = r12.remoteVersion     // Catch:{ LoadingException -> 0x0271 }
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            boolean r16 = zzf(r27)     // Catch:{ all -> 0x0254 }
            if (r16 == 0) goto L_0x024c
            java.lang.Boolean r16 = zzb     // Catch:{ all -> 0x0254 }
            monitor-exit(r4)     // Catch:{ all -> 0x0254 }
            if (r16 == 0) goto L_0x0244
            boolean r16 = r16.booleanValue()     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            r14 = 2
            if (r16 == 0) goto L_0x0180
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            r13.<init>()     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.String r15 = "Selected remote version of "
            r13.append(r15)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            r13.append(r3)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.String r15 = ", version >= "
            r13.append(r15)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            r13.append(r0)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.String r20 = "DynamiteModule"
            java.lang.String r21 = r13.toString()     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            r19 = 4
            r22 = 0
            java.lang.String r23 = "com.google.android.gms.dynamite.DynamiteModule"
            r24 = 31
            com.didi.sdk.apm.SystemUtils.log(r19, r20, r21, r22, r23, r24)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamite.zzr r13 = zzl     // Catch:{ all -> 0x017d }
            monitor-exit(r4)     // Catch:{ all -> 0x017d }
            if (r13 == 0) goto L_0x0175
            java.lang.ThreadLocal r15 = zzg     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.Object r15 = r15.get()     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamite.zzn r15 = (com.google.android.gms.dynamite.zzn) r15     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            if (r15 == 0) goto L_0x016d
            android.database.Cursor r10 = r15.zza     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            if (r10 == 0) goto L_0x016d
            android.content.Context r10 = r27.getApplicationContext()     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            android.database.Cursor r11 = r15.zza     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamic.ObjectWrapper.wrap(r7)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            int r15 = zze     // Catch:{ all -> 0x016a }
            if (r15 < r14) goto L_0x0110
            r14 = 1
            goto L_0x0111
        L_0x0110:
            r14 = 0
        L_0x0111:
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)     // Catch:{ all -> 0x016a }
            monitor-exit(r4)     // Catch:{ all -> 0x016a }
            boolean r4 = r14.booleanValue()     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            if (r4 == 0) goto L_0x0138
            java.lang.String r22 = "DynamiteModule"
            java.lang.String r23 = "Dynamite loader version >= 2, using loadModule2NoCrashUtils"
            r21 = 2
            r24 = 0
            java.lang.String r25 = "com.google.android.gms.dynamite.DynamiteModule"
            r26 = 41
            com.didi.sdk.apm.SystemUtils.log(r21, r22, r23, r24, r25, r26)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r13.zzf(r4, r3, r0, r10)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            goto L_0x0153
        L_0x0138:
            java.lang.String r22 = "DynamiteModule"
            java.lang.String r23 = "Dynamite loader version < 2, falling back to loadModule2"
            r21 = 5
            r24 = 0
            java.lang.String r25 = "com.google.android.gms.dynamite.DynamiteModule"
            r26 = 45
            com.didi.sdk.apm.SystemUtils.log(r21, r22, r23, r24, r25, r26)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r13.zze(r4, r3, r0, r10)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
        L_0x0153:
            java.lang.Object r0 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            if (r0 == 0) goto L_0x0162
            com.google.android.gms.dynamite.DynamiteModule r4 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            r4.<init>(r0)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            goto L_0x0212
        L_0x0162:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.String r4 = "Failed to get module context"
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            throw r0     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
        L_0x016a:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x016a }
            throw r0     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
        L_0x016d:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.String r4 = "No result cursor"
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            throw r0     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
        L_0x0175:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.String r4 = "DynamiteLoaderV2 was not cached."
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            throw r0     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
        L_0x017d:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x017d }
            throw r0     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
        L_0x0180:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            r4.<init>()     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.String r10 = "Selected remote version of "
            r4.append(r10)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            r4.append(r3)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.String r10 = ", version >= "
            r4.append(r10)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            r4.append(r0)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.String r22 = "DynamiteModule"
            java.lang.String r23 = r4.toString()     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            r21 = 4
            r24 = 0
            java.lang.String r25 = "com.google.android.gms.dynamite.DynamiteModule"
            r26 = 15
            com.didi.sdk.apm.SystemUtils.log(r21, r22, r23, r24, r25, r26)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamite.zzq r4 = zzg(r27)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            if (r4 == 0) goto L_0x023c
            int r10 = r4.zze()     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            r11 = 3
            if (r10 < r11) goto L_0x01d4
            java.lang.ThreadLocal r10 = zzg     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.Object r10 = r10.get()     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamite.zzn r10 = (com.google.android.gms.dynamite.zzn) r10     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            if (r10 == 0) goto L_0x01cc
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r27)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            android.database.Cursor r10 = r10.zza     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zzi(r11, r3, r0, r10)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            goto L_0x0205
        L_0x01cc:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.String r4 = "No cached result cursor holder"
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            throw r0     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
        L_0x01d4:
            if (r10 != r14) goto L_0x01ee
            java.lang.String r22 = "DynamiteModule"
            java.lang.String r23 = "IDynamite loader version = 2"
            r21 = 5
            r24 = 0
            java.lang.String r25 = "com.google.android.gms.dynamite.DynamiteModule"
            r26 = 24
            com.didi.sdk.apm.SystemUtils.log(r21, r22, r23, r24, r25, r26)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r27)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zzj(r10, r3, r0)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            goto L_0x0205
        L_0x01ee:
            java.lang.String r22 = "DynamiteModule"
            java.lang.String r23 = "Dynamite loader version < 2, falling back to createModuleContext"
            r21 = 5
            r24 = 0
            java.lang.String r25 = "com.google.android.gms.dynamite.DynamiteModule"
            r26 = 26
            com.didi.sdk.apm.SystemUtils.log(r21, r22, r23, r24, r25, r26)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r27)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zzh(r10, r3, r0)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
        L_0x0205:
            java.lang.Object r0 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            if (r0 == 0) goto L_0x0234
            com.google.android.gms.dynamite.DynamiteModule r4 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            r4.<init>(r0)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
        L_0x0212:
            r1 = 0
            int r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x021e
            java.lang.ThreadLocal r0 = zzh
            r0.remove()
            goto L_0x0227
        L_0x021e:
            java.lang.ThreadLocal r0 = zzh
            java.lang.Long r1 = java.lang.Long.valueOf(r8)
            r0.set(r1)
        L_0x0227:
            android.database.Cursor r0 = r6.zza
            if (r0 == 0) goto L_0x022e
            r0.close()
        L_0x022e:
            java.lang.ThreadLocal r0 = zzg
            r0.set(r5)
            return r4
        L_0x0234:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.String r4 = "Failed to load remote module."
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            throw r0     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
        L_0x023c:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.String r4 = "Failed to create IDynamiteLoader."
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            throw r0     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
        L_0x0244:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            java.lang.String r4 = "Failed to determine which loading route to use."
            r0.<init>(r4, r7)     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
            throw r0     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
        L_0x024c:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0254 }
            java.lang.String r10 = "Remote loading disabled"
            r0.<init>(r10, r7)     // Catch:{ all -> 0x0254 }
            throw r0     // Catch:{ all -> 0x0254 }
        L_0x0254:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0254 }
            throw r0     // Catch:{ RemoteException -> 0x025b, LoadingException -> 0x0259, all -> 0x0257 }
        L_0x0257:
            r0 = move-exception
            goto L_0x025d
        L_0x0259:
            r0 = move-exception
            goto L_0x0268
        L_0x025b:
            r0 = move-exception
            goto L_0x0269
        L_0x025d:
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r1, r0)     // Catch:{ all -> 0x0315 }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r4 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0315 }
            java.lang.String r10 = "Failed to load remote module."
            r4.<init>(r10, r0, r7)     // Catch:{ all -> 0x0315 }
            throw r4     // Catch:{ all -> 0x0315 }
        L_0x0268:
            throw r0     // Catch:{ all -> 0x0315 }
        L_0x0269:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r4 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0315 }
            java.lang.String r10 = "Failed to load remote module."
            r4.<init>(r10, r0, r7)     // Catch:{ all -> 0x0315 }
            throw r4     // Catch:{ all -> 0x0315 }
        L_0x0271:
            r0 = move-exception
            java.lang.String r4 = r0.getMessage()     // Catch:{  }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{  }
            r10.<init>()     // Catch:{  }
            java.lang.String r11 = "Failed to load remote module: "
            r10.append(r11)     // Catch:{  }
            r10.append(r4)     // Catch:{  }
            java.lang.String r22 = "DynamiteModule"
            java.lang.String r23 = r10.toString()     // Catch:{  }
            r21 = 5
            r24 = 0
            java.lang.String r25 = "com.google.android.gms.dynamite.DynamiteModule"
            r26 = 56
            com.didi.sdk.apm.SystemUtils.log(r21, r22, r23, r24, r25, r26)     // Catch:{  }
            int r4 = r12.localVersion     // Catch:{  }
            if (r4 == 0) goto L_0x02c6
            com.google.android.gms.dynamite.zzo r10 = new com.google.android.gms.dynamite.zzo     // Catch:{  }
            r11 = 0
            r10.<init>(r4, r11)     // Catch:{  }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r2 = r2.selectModule(r1, r3, r10)     // Catch:{  }
            int r2 = r2.selection     // Catch:{  }
            r4 = -1
            if (r2 != r4) goto L_0x02c6
            com.google.android.gms.dynamite.DynamiteModule r0 = zzc(r1, r3)     // Catch:{  }
            r1 = 0
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x02b7
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x02c0
        L_0x02b7:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            r1.set(r2)
        L_0x02c0:
            android.database.Cursor r1 = r6.zza
            if (r1 == 0) goto L_0x00a9
            goto L_0x00a6
        L_0x02c6:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r1 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{  }
            java.lang.String r2 = "Remote load failed. No local fallback found."
            r1.<init>(r2, r0, r7)     // Catch:{  }
            throw r1     // Catch:{  }
        L_0x02ce:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r1 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{  }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
            r2.<init>()     // Catch:{  }
            java.lang.String r3 = "VersionPolicy returned invalid code:"
            r2.append(r3)     // Catch:{  }
            r2.append(r0)     // Catch:{  }
            java.lang.String r0 = r2.toString()     // Catch:{  }
            r1.<init>(r0, r7)     // Catch:{  }
            throw r1     // Catch:{  }
        L_0x02e5:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{  }
            int r1 = r12.localVersion     // Catch:{  }
            int r2 = r12.remoteVersion     // Catch:{  }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{  }
            r4.<init>()     // Catch:{  }
            java.lang.String r10 = "No acceptable module "
            r4.append(r10)     // Catch:{  }
            r4.append(r3)     // Catch:{  }
            java.lang.String r3 = " found. Local version is "
            r4.append(r3)     // Catch:{  }
            r4.append(r1)     // Catch:{  }
            java.lang.String r1 = " and remote version is "
            r4.append(r1)     // Catch:{  }
            r4.append(r2)     // Catch:{  }
            java.lang.String r1 = "."
            r4.append(r1)     // Catch:{  }
            java.lang.String r1 = r4.toString()     // Catch:{  }
            r0.<init>(r1, r7)     // Catch:{  }
            throw r0     // Catch:{  }
        L_0x0315:
            r0 = move-exception
            r1 = 0
            goto L_0x031b
        L_0x0319:
            r0 = move-exception
            r1 = r10
        L_0x031b:
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x0325
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x032e
        L_0x0325:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            r1.set(r2)
        L_0x032e:
            android.database.Cursor r1 = r6.zza
            if (r1 == 0) goto L_0x0335
            r1.close()
        L_0x0335:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.load(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$VersionPolicy, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0056=Splitter:B:31:0x0056, B:17:0x003b=Splitter:B:17:0x003b, B:50:0x009c=Splitter:B:50:0x009c} */
    public static int zza(android.content.Context r12, java.lang.String r13, boolean r14) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x01e9 }
            java.lang.Boolean r1 = zzb     // Catch:{ all -> 0x01e6 }
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x00e0
            android.content.Context r1 = r12.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Class r1 = r1.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Class r4 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Object r5 = r1.get(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x00b4 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b4 }
            if (r5 != r6) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b4 }
            goto L_0x00b2
        L_0x0036:
            if (r5 == 0) goto L_0x003f
            zzd(r5)     // Catch:{ LoadingException -> 0x003b }
        L_0x003b:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b4 }
            goto L_0x00b2
        L_0x003f:
            boolean r5 = zzf(r12)     // Catch:{ all -> 0x00b4 }
            if (r5 != 0) goto L_0x0048
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r0)     // Catch:{ all -> 0x01e6 }
            return r3
        L_0x0048:
            boolean r5 = zzd     // Catch:{ all -> 0x00b4 }
            if (r5 != 0) goto L_0x00a9
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b4 }
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x00b4 }
            if (r5 == 0) goto L_0x0055
            goto L_0x00a9
        L_0x0055:
            r5 = 1
            int r5 = zzb(r12, r13, r14, r5)     // Catch:{ LoadingException -> 0x009f }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x009f }
            if (r6 == 0) goto L_0x009c
            boolean r6 = r6.isEmpty()     // Catch:{ LoadingException -> 0x009f }
            if (r6 == 0) goto L_0x0065
            goto L_0x009c
        L_0x0065:
            java.lang.ClassLoader r6 = com.google.android.gms.dynamite.zzb.zza()     // Catch:{ LoadingException -> 0x009f }
            if (r6 == 0) goto L_0x006c
            goto L_0x008f
        L_0x006c:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x009f }
            r7 = 29
            if (r6 < r7) goto L_0x0081
            dalvik.system.DelegateLastClassLoader r6 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x009f }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x009f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ LoadingException -> 0x009f }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009f }
            r6.<init>(r7, r8)     // Catch:{ LoadingException -> 0x009f }
            goto L_0x008f
        L_0x0081:
            com.google.android.gms.dynamite.zzc r6 = new com.google.android.gms.dynamite.zzc     // Catch:{ LoadingException -> 0x009f }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x009f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ LoadingException -> 0x009f }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009f }
            r6.<init>(r7, r8)     // Catch:{ LoadingException -> 0x009f }
        L_0x008f:
            zzd(r6)     // Catch:{ LoadingException -> 0x009f }
            r1.set(r2, r6)     // Catch:{ LoadingException -> 0x009f }
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x009f }
            zzb = r6     // Catch:{ LoadingException -> 0x009f }
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r0)     // Catch:{ all -> 0x01e6 }
            return r5
        L_0x009c:
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r0)     // Catch:{ all -> 0x01e6 }
            return r5
        L_0x009f:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b4 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b4 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b4 }
            goto L_0x00b2
        L_0x00a9:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b4 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b4 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b4 }
        L_0x00b2:
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            goto L_0x00de
        L_0x00b4:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
        L_0x00b7:
            r1 = move-exception
            goto L_0x00bc
        L_0x00b9:
            r1 = move-exception
            goto L_0x00bc
        L_0x00bb:
            r1 = move-exception
        L_0x00bc:
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01e6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e6 }
            r4.<init>()     // Catch:{ all -> 0x01e6 }
            java.lang.String r5 = "Failed to load module via V2: "
            r4.append(r5)     // Catch:{ all -> 0x01e6 }
            r4.append(r1)     // Catch:{ all -> 0x01e6 }
            java.lang.String r7 = "DynamiteModule"
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x01e6 }
            r6 = 5
            r9 = 0
            java.lang.String r10 = "com.google.android.gms.dynamite.DynamiteModule"
            r11 = 25
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01e6 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01e6 }
        L_0x00de:
            zzb = r1     // Catch:{ all -> 0x01e6 }
        L_0x00e0:
            monitor-exit(r0)     // Catch:{ all -> 0x01e6 }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x01e9 }
            if (r0 == 0) goto L_0x010e
            int r12 = zzb(r12, r13, r14, r3)     // Catch:{ LoadingException -> 0x00ec }
            return r12
        L_0x00ec:
            r13 = move-exception
            java.lang.String r13 = r13.getMessage()     // Catch:{ all -> 0x01e9 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e9 }
            r14.<init>()     // Catch:{ all -> 0x01e9 }
            java.lang.String r0 = "Failed to retrieve remote module version: "
            r14.append(r0)     // Catch:{ all -> 0x01e9 }
            r14.append(r13)     // Catch:{ all -> 0x01e9 }
            java.lang.String r5 = "DynamiteModule"
            java.lang.String r6 = r14.toString()     // Catch:{ all -> 0x01e9 }
            r4 = 5
            r7 = 0
            java.lang.String r8 = "com.google.android.gms.dynamite.DynamiteModule"
            r9 = 48
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x01e9 }
            return r3
        L_0x010e:
            com.google.android.gms.dynamite.zzq r4 = zzg(r12)     // Catch:{ all -> 0x01e9 }
            if (r4 != 0) goto L_0x0116
            goto L_0x01dd
        L_0x0116:
            int r0 = r4.zze()     // Catch:{ RemoteException -> 0x01b6 }
            r1 = 3
            if (r0 < r1) goto L_0x0185
            java.lang.ThreadLocal r0 = zzg     // Catch:{ RemoteException -> 0x01b6 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x01b6 }
            com.google.android.gms.dynamite.zzn r0 = (com.google.android.gms.dynamite.zzn) r0     // Catch:{ RemoteException -> 0x01b6 }
            if (r0 == 0) goto L_0x0131
            android.database.Cursor r0 = r0.zza     // Catch:{ RemoteException -> 0x01b6 }
            if (r0 == 0) goto L_0x0131
            int r3 = r0.getInt(r3)     // Catch:{ RemoteException -> 0x01b6 }
            goto L_0x01dd
        L_0x0131:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r12)     // Catch:{ RemoteException -> 0x01b6 }
            java.lang.ThreadLocal r0 = zzh     // Catch:{ RemoteException -> 0x01b6 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x01b6 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x01b6 }
            long r8 = r0.longValue()     // Catch:{ RemoteException -> 0x01b6 }
            r6 = r13
            r7 = r14
            com.google.android.gms.dynamic.IObjectWrapper r13 = r4.zzk(r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x01b6 }
            java.lang.Object r13 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r13)     // Catch:{ RemoteException -> 0x01b6 }
            android.database.Cursor r13 = (android.database.Cursor) r13     // Catch:{ RemoteException -> 0x01b6 }
            if (r13 == 0) goto L_0x016c
            boolean r14 = r13.moveToFirst()     // Catch:{ RemoteException -> 0x0182, all -> 0x017f }
            if (r14 != 0) goto L_0x0156
            goto L_0x016c
        L_0x0156:
            int r14 = r13.getInt(r3)     // Catch:{ RemoteException -> 0x0182, all -> 0x017f }
            if (r14 <= 0) goto L_0x0163
            boolean r0 = zze(r13)     // Catch:{ RemoteException -> 0x0182, all -> 0x017f }
            if (r0 == 0) goto L_0x0163
            goto L_0x0164
        L_0x0163:
            r2 = r13
        L_0x0164:
            if (r2 == 0) goto L_0x0169
            r2.close()     // Catch:{ all -> 0x01e9 }
        L_0x0169:
            r3 = r14
            goto L_0x01dd
        L_0x016c:
            java.lang.String r5 = "DynamiteModule"
            java.lang.String r6 = "Failed to retrieve remote module version."
            r4 = 5
            r7 = 0
            java.lang.String r8 = "com.google.android.gms.dynamite.DynamiteModule"
            r9 = 35
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ RemoteException -> 0x0182, all -> 0x017f }
            if (r13 == 0) goto L_0x01dd
            r13.close()     // Catch:{ all -> 0x01e9 }
            goto L_0x01dd
        L_0x017f:
            r14 = move-exception
            r2 = r13
            goto L_0x01e0
        L_0x0182:
            r14 = move-exception
            r2 = r13
            goto L_0x01b8
        L_0x0185:
            r1 = 2
            if (r0 != r1) goto L_0x019e
            java.lang.String r6 = "DynamiteModule"
            java.lang.String r7 = "IDynamite loader version = 2, no high precision latency measurement."
            r5 = 5
            r8 = 0
            java.lang.String r9 = "com.google.android.gms.dynamite.DynamiteModule"
            r10 = 40
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ RemoteException -> 0x01b6 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r12)     // Catch:{ RemoteException -> 0x01b6 }
            int r3 = r4.zzg(r0, r13, r14)     // Catch:{ RemoteException -> 0x01b6 }
            goto L_0x01dd
        L_0x019e:
            java.lang.String r6 = "DynamiteModule"
            java.lang.String r7 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            r5 = 5
            r8 = 0
            java.lang.String r9 = "com.google.android.gms.dynamite.DynamiteModule"
            r10 = 43
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ RemoteException -> 0x01b6 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r12)     // Catch:{ RemoteException -> 0x01b6 }
            int r3 = r4.zzf(r0, r13, r14)     // Catch:{ RemoteException -> 0x01b6 }
            goto L_0x01dd
        L_0x01b4:
            r14 = r13
            goto L_0x01e0
        L_0x01b6:
            r13 = move-exception
            r14 = r13
        L_0x01b8:
            java.lang.String r13 = r14.getMessage()     // Catch:{ all -> 0x01de }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x01de }
            r14.<init>()     // Catch:{ all -> 0x01de }
            java.lang.String r0 = "Failed to retrieve remote module version: "
            r14.append(r0)     // Catch:{ all -> 0x01de }
            r14.append(r13)     // Catch:{ all -> 0x01de }
            java.lang.String r5 = "DynamiteModule"
            java.lang.String r6 = r14.toString()     // Catch:{ all -> 0x01de }
            r4 = 5
            r7 = 0
            java.lang.String r8 = "com.google.android.gms.dynamite.DynamiteModule"
            r9 = 45
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x01de }
            if (r2 == 0) goto L_0x01dd
            r2.close()     // Catch:{ all -> 0x01e9 }
        L_0x01dd:
            return r3
        L_0x01de:
            r13 = move-exception
            goto L_0x01b4
        L_0x01e0:
            if (r2 == 0) goto L_0x01e5
            r2.close()     // Catch:{ all -> 0x01e9 }
        L_0x01e5:
            throw r14     // Catch:{ all -> 0x01e9 }
        L_0x01e6:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01e6 }
            throw r13     // Catch:{ all -> 0x01e9 }
        L_0x01e9:
            r13 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r12, r13)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c2 A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c3 A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r10, java.lang.String r11, boolean r12, boolean r13) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            java.lang.ThreadLocal r1 = zzh     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L_0x0019
            r10 = r4
        L_0x0019:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r12.<init>()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            android.net.Uri r4 = r10.build()     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            if (r10 == 0) goto L_0x00a3
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x009b }
            if (r11 == 0) goto L_0x00a3
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch:{ Exception -> 0x009b }
            if (r12 <= 0) goto L_0x008e
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x009b }
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x008b }
            zzc = r2     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x006f
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            zze = r2     // Catch:{ all -> 0x008b }
        L_0x006f:
            java.lang.String r2 = "disableStandaloneDynamiteLoader2"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x0082
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r9 = 0
        L_0x007f:
            zzd = r9     // Catch:{ all -> 0x008b }
            r11 = r9
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            boolean r1 = zze(r10)     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x008e
            r10 = r0
            goto L_0x008e
        L_0x008b:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x008e:
            if (r13 == 0) goto L_0x009d
            if (r11 != 0) goto L_0x0093
            goto L_0x009d
        L_0x0093:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "forcing fallback to container DynamiteLoader impl"
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x009b:
            r11 = move-exception
            goto L_0x00be
        L_0x009d:
            if (r10 == 0) goto L_0x00a2
            r10.close()
        L_0x00a2:
            return r12
        L_0x00a3:
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r3 = "Failed to retrieve remote module version."
            r1 = 5
            r4 = 0
            java.lang.String r5 = "com.google.android.gms.dynamite.DynamiteModule"
            r6 = 12
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x009b }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x00b8:
            r10 = move-exception
            r11 = r10
            goto L_0x00cd
        L_0x00bb:
            r10 = move-exception
            r11 = r10
            r10 = r0
        L_0x00be:
            boolean r12 = r11 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00cb }
            if (r12 == 0) goto L_0x00c3
            throw r11     // Catch:{ all -> 0x00cb }
        L_0x00c3:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r12 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00cb }
            java.lang.String r13 = "V2 version check failed"
            r12.<init>(r13, r11, r0)     // Catch:{ all -> 0x00cb }
            throw r12     // Catch:{ all -> 0x00cb }
        L_0x00cb:
            r11 = move-exception
            r0 = r10
        L_0x00cd:
            if (r0 == 0) goto L_0x00d2
            r0.close()
        L_0x00d2:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str) {
        SystemUtils.log(4, "DynamiteModule", "Selected local version of ".concat(String.valueOf(str)), (Throwable) null, "com.google.android.gms.dynamite.DynamiteModule", 1);
        return new DynamiteModule(context.getApplicationContext());
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzr;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzr = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzr = (zzr) queryLocalInterface;
                } else {
                    zzr = new zzr(iBinder);
                }
            }
            zzl = zzr;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzp) null);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zzn = (zzn) zzg.get();
        if (zzn == null || zzn.zza != null) {
            return false;
        }
        zzn.zza = cursor;
        return true;
    }

    private static boolean zzf(Context context) {
        if (Boolean.TRUE.equals((Object) null) || Boolean.TRUE.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, HotpatchStateConst.ROLLBACK_PATHCH) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzf = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider != null && resolveContentProvider.applicationInfo != null && (resolveContentProvider.applicationInfo.flags & 129) == 0) {
                SystemUtils.log(4, "DynamiteModule", "Non-system-image GmsCore APK, forcing V1", (Throwable) null, "com.google.android.gms.dynamite.DynamiteModule", 10);
                zzd = true;
            }
        }
        if (!z) {
            SystemUtils.log(6, "DynamiteModule", "Invalid GmsCore APK, remote loading disabled.", (Throwable) null, "com.google.android.gms.dynamite.DynamiteModule", 11);
        }
        return z;
    }

    private static zzq zzg(Context context) {
        zzq zzq;
        synchronized (DynamiteModule.class) {
            zzq zzq2 = zzk;
            if (zzq2 != null) {
                return zzq2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzq = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
                }
                if (zzq != null) {
                    zzk = zzq;
                    return zzq;
                }
            } catch (Exception e) {
                SystemUtils.log(6, "DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage(), (Throwable) null, "com.google.android.gms.dynamite.DynamiteModule", 9);
            }
        }
        return null;
    }

    public Context getModuleContext() {
        return this.zzj;
    }

    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e, (zzp) null);
        }
    }
}
