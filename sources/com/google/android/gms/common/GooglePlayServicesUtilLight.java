package com.google.android.gms.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class GooglePlayServicesUtilLight {
    static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
    static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
    static boolean zza = false;
    private static boolean zzb = false;
    private static final AtomicBoolean zzc = new AtomicBoolean();

    GooglePlayServicesUtilLight() {
    }

    @Deprecated
    public static void cancelAvailabilityErrorNotifications(Context context) {
        if (!sCanceledAvailabilityNotification.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    public static void enableUsingApkIndependentContext() {
        zzc.set(true);
    }

    @Deprecated
    public static void ensurePlayServicesAvailable(Context context, int i) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i);
        if (isGooglePlayServicesAvailable != 0) {
            Intent errorResolutionIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(context, isGooglePlayServicesAvailable, "e");
            SystemUtils.log(6, "GooglePlayServicesUtil", "GooglePlayServices not available due to error " + isGooglePlayServicesAvailable, (Throwable) null, "com.google.android.gms.common.GooglePlayServicesUtilLight", 4);
            if (errorResolutionIntent == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", errorResolutionIntent);
        }
    }

    @Deprecated
    public static int getApkVersion(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), "com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            SystemUtils.log(5, "GooglePlayServicesUtil", "Google Play services is missing.", (Throwable) null, "com.google.android.gms.common.GooglePlayServicesUtilLight", 2);
            return 0;
        }
    }

    @Deprecated
    public static int getClientVersion(Context context) {
        Preconditions.checkState(true);
        return ClientLibraryUtils.getClientVersion(context, context.getPackageName());
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.zza(i);
    }

    @Deprecated
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int i) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent((Context) null, i, (String) null);
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean honorsDebugCertificates(Context context) {
        if (!zza) {
            try {
                PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.google.android.gms", 64);
                GoogleSignatureVerifier.getInstance(context);
                if (packageInfo == null || GoogleSignatureVerifier.zzb(packageInfo, false) || !GoogleSignatureVerifier.zzb(packageInfo, true)) {
                    zzb = false;
                } else {
                    zzb = true;
                }
            } catch (PackageManager.NameNotFoundException e) {
                SystemUtils.log(5, "GooglePlayServicesUtil", "Cannot find Google Play services package name.", e, "com.google.android.gms.common.GooglePlayServicesUtilLight", 6);
            } finally {
                zza = true;
            }
        }
        return zzb || !DeviceProperties.isUserBuild();
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @Deprecated
    public static boolean isGooglePlayServicesUid(Context context, int i) {
        return UidVerifier.isGooglePlayServicesUid(context, i);
    }

    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zza(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(Context context, int i) {
        if (i == 9) {
            return zza(context, "com.android.vending");
        }
        return false;
    }

    public static boolean isRestrictedUserProfile(Context context) {
        if (!PlatformVersion.isAtLeastJellyBeanMR2()) {
            return false;
        }
        Object systemService = context.getSystemService("user");
        Preconditions.checkNotNull(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    @Deprecated
    public static boolean isSidewinderDevice(Context context) {
        return DeviceProperties.isSidewinder(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @Deprecated
    public static boolean uidHasPackageName(Context context, int i, String str) {
        return UidVerifier.uidHasPackageName(context, i, str);
    }

    static boolean zza(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (PlatformVersion.isAtLeastLollipop()) {
            try {
                for (PackageInstaller.SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(appPackageName.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = SystemUtils.getApplicationInfo(context.getPackageManager(), str, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            return applicationInfo.enabled && !isRestrictedUserProfile(context);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b0  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int isGooglePlayServicesAvailable(android.content.Context r9, int r10) {
        /*
            android.content.res.Resources r0 = r9.getResources()     // Catch:{ all -> 0x000b }
            r1 = 2131953673(0x7f130809, float:1.9543824E38)
            r0.getString(r1)     // Catch:{ all -> 0x000b }
            goto L_0x0017
        L_0x000b:
            r2 = 6
            r5 = 0
            r7 = 4
            java.lang.String r3 = "GooglePlayServicesUtil"
            java.lang.String r4 = "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included."
            java.lang.String r6 = "com.google.android.gms.common.GooglePlayServicesUtilLight"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x0017:
            java.lang.String r0 = r9.getPackageName()
            java.lang.String r1 = "com.google.android.gms"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0043
            java.util.concurrent.atomic.AtomicBoolean r0 = zzc
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x002c
            goto L_0x0043
        L_0x002c:
            int r0 = com.google.android.gms.common.internal.zzag.zza(r9)
            if (r0 == 0) goto L_0x003d
            int r2 = GOOGLE_PLAY_SERVICES_VERSION_CODE
            if (r0 != r2) goto L_0x0037
            goto L_0x0043
        L_0x0037:
            com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException r9 = new com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException
            r9.<init>(r0)
            throw r9
        L_0x003d:
            com.google.android.gms.common.GooglePlayServicesMissingManifestValueException r9 = new com.google.android.gms.common.GooglePlayServicesMissingManifestValueException
            r9.<init>()
            throw r9
        L_0x0043:
            boolean r0 = com.google.android.gms.common.util.DeviceProperties.isWearableWithoutPlayStore(r9)
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0053
            boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzb(r9)
            if (r0 != 0) goto L_0x0053
            r0 = 1
            goto L_0x0054
        L_0x0053:
            r0 = 0
        L_0x0054:
            if (r10 < 0) goto L_0x0058
            r4 = 1
            goto L_0x0059
        L_0x0058:
            r4 = 0
        L_0x0059:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r4)
            java.lang.String r4 = r9.getPackageName()
            android.content.pm.PackageManager r5 = r9.getPackageManager()
            r6 = 9
            if (r0 == 0) goto L_0x008a
            java.lang.String r7 = "com.android.vending"
            r8 = 8256(0x2040, float:1.1569E-41)
            android.content.pm.PackageInfo r7 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r5, r7, r8)     // Catch:{ NameNotFoundException -> 0x0071 }
            goto L_0x008b
        L_0x0071:
            java.lang.String r9 = java.lang.String.valueOf(r4)
            java.lang.String r10 = " requires the Google Play Store, but it is missing."
            java.lang.String r2 = r9.concat(r10)
            r0 = 5
            r3 = 0
            r5 = 14
            java.lang.String r1 = "GooglePlayServicesUtil"
            java.lang.String r4 = "com.google.android.gms.common.GooglePlayServicesUtilLight"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x0086:
            r2 = 9
            goto L_0x016b
        L_0x008a:
            r7 = 0
        L_0x008b:
            r8 = 64
            android.content.pm.PackageInfo r8 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r5, r1, r8)     // Catch:{ NameNotFoundException -> 0x0156 }
            com.google.android.gms.common.GoogleSignatureVerifier.getInstance(r9)
            boolean r9 = com.google.android.gms.common.GoogleSignatureVerifier.zzb(r8, r2)
            if (r9 != 0) goto L_0x00b0
            java.lang.String r9 = java.lang.String.valueOf(r4)
            java.lang.String r10 = " requires Google Play services, but their signature is invalid."
            java.lang.String r2 = r9.concat(r10)
            r0 = 5
            r3 = 0
            r5 = 19
            java.lang.String r1 = "GooglePlayServicesUtil"
            java.lang.String r4 = "com.google.android.gms.common.GooglePlayServicesUtilLight"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
            goto L_0x0086
        L_0x00b0:
            if (r0 == 0) goto L_0x00d1
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            boolean r9 = com.google.android.gms.common.GoogleSignatureVerifier.zzb(r7, r2)
            if (r9 != 0) goto L_0x00d1
            java.lang.String r9 = java.lang.String.valueOf(r4)
            java.lang.String r10 = " requires Google Play Store, but its signature is invalid."
            java.lang.String r2 = r9.concat(r10)
            r0 = 5
            r3 = 0
            r5 = 31
            java.lang.String r1 = "GooglePlayServicesUtil"
            java.lang.String r4 = "com.google.android.gms.common.GooglePlayServicesUtilLight"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
            goto L_0x0086
        L_0x00d1:
            if (r0 == 0) goto L_0x00f9
            if (r7 == 0) goto L_0x00f9
            android.content.pm.Signature[] r9 = r7.signatures
            r9 = r9[r3]
            android.content.pm.Signature[] r0 = r8.signatures
            r0 = r0[r3]
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto L_0x00f9
            java.lang.String r9 = java.lang.String.valueOf(r4)
            java.lang.String r10 = " requires Google Play Store, but its signature doesn't match that of Google Play services."
            java.lang.String r2 = r9.concat(r10)
            r0 = 5
            r3 = 0
            r5 = 30
            java.lang.String r1 = "GooglePlayServicesUtil"
            java.lang.String r4 = "com.google.android.gms.common.GooglePlayServicesUtilLight"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
            goto L_0x0086
        L_0x00f9:
            int r9 = r8.versionCode
            int r9 = com.google.android.gms.common.util.zza.zza(r9)
            int r0 = com.google.android.gms.common.util.zza.zza(r10)
            if (r9 >= r0) goto L_0x0135
            int r9 = r8.versionCode
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Google Play services out of date for "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = ".  Requires "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = " but found "
            r0.append(r10)
            r0.append(r9)
            java.lang.String r3 = r0.toString()
            r1 = 5
            r4 = 0
            r6 = 25
            java.lang.String r2 = "GooglePlayServicesUtil"
            java.lang.String r5 = "com.google.android.gms.common.GooglePlayServicesUtilLight"
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)
            r2 = 2
            goto L_0x016b
        L_0x0135:
            android.content.pm.ApplicationInfo r9 = r8.applicationInfo
            if (r9 != 0) goto L_0x014f
            android.content.pm.ApplicationInfo r9 = com.didi.sdk.apm.SystemUtils.getApplicationInfo(r5, r1, r3)     // Catch:{ NameNotFoundException -> 0x013e }
            goto L_0x014f
        L_0x013e:
            r9 = move-exception
            java.lang.String r10 = java.lang.String.valueOf(r4)
            java.lang.String r0 = " requires Google Play services, but they're missing when getting application info."
            java.lang.String r10 = r10.concat(r0)
            java.lang.String r0 = "GooglePlayServicesUtil"
            android.util.Log.wtf(r0, r10, r9)
            goto L_0x016b
        L_0x014f:
            boolean r9 = r9.enabled
            if (r9 != 0) goto L_0x0155
            r2 = 3
            goto L_0x016b
        L_0x0155:
            return r3
        L_0x0156:
            java.lang.String r9 = java.lang.String.valueOf(r4)
            java.lang.String r10 = " requires Google Play services, but they are missing."
            java.lang.String r5 = r9.concat(r10)
            r3 = 5
            r6 = 0
            r8 = 16
            java.lang.String r4 = "GooglePlayServicesUtil"
            java.lang.String r7 = "com.google.android.gms.common.GooglePlayServicesUtilLight"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
        L_0x016b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(android.content.Context, int):int");
    }
}
