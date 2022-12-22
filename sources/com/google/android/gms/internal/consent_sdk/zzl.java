package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.core.content.p005pm.PackageInfoCompat;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
final class zzl {
    private final zzn zza;
    private final Activity zzb;
    private final ConsentDebugSettings zzc;
    private final ConsentRequestParameters zzd;

    private zzl(zzn zzn, Activity activity, ConsentDebugSettings consentDebugSettings, ConsentRequestParameters consentRequestParameters) {
        this.zza = zzn;
        this.zzb = activity;
        this.zzc = consentDebugSettings;
        this.zzd = consentRequestParameters;
    }

    /* access modifiers changed from: private */
    public final zzbn zza() throws zzk {
        List<zzbs> list;
        String str;
        List<zzbw> list2;
        View view;
        WindowInsets windowInsets;
        String str2;
        zzbn zzbn = new zzbn();
        zzbn.zza = zzc();
        zza zza2 = this.zza.zzb.zza();
        if (zza2 != null) {
            zzbn.zzb = zza2.zza;
            zzbn.zzi = Boolean.valueOf(zza2.zzb);
        }
        if (!this.zzc.isTestDevice()) {
            list = Collections.emptyList();
        } else {
            list = new ArrayList<>();
            int debugGeography = this.zzc.getDebugGeography();
            if (debugGeography == 1) {
                list.add(zzbs.GEO_OVERRIDE_EEA);
            } else if (debugGeography == 2) {
                list.add(zzbs.GEO_OVERRIDE_NON_EEA);
            }
        }
        zzbn.zzn = list;
        Application zza3 = this.zza.zza;
        Set<String> zzc2 = this.zza.zzc.zzc();
        HashMap hashMap = new HashMap();
        for (String next : zzc2) {
            zzcb zza4 = zzcc.zza((Context) zza3, next);
            if (zza4 == null) {
                String valueOf = String.valueOf(next);
                SystemUtils.log(3, "UserMessagingPlatform", valueOf.length() != 0 ? "Fetching request info: failed for key: ".concat(valueOf) : new String("Fetching request info: failed for key: "), (Throwable) null, "com.google.android.gms.internal.consent_sdk.zzl", 35);
            } else {
                Object obj = SystemUtils.getSharedPreferences(zza3, zza4.zza, 0).getAll().get(zza4.zzb);
                if (obj == null) {
                    String valueOf2 = String.valueOf(next);
                    SystemUtils.log(3, "UserMessagingPlatform", valueOf2.length() != 0 ? "Stored info not exists: ".concat(valueOf2) : new String("Stored info not exists: "), (Throwable) null, "com.google.android.gms.internal.consent_sdk.zzl", 42);
                } else {
                    if (obj instanceof Boolean) {
                        str2 = ((Boolean) obj).booleanValue() ? "1" : "0";
                    } else if (obj instanceof Number) {
                        str2 = obj.toString();
                    } else if (obj instanceof String) {
                        str2 = (String) obj;
                    } else {
                        String valueOf3 = String.valueOf(next);
                        SystemUtils.log(3, "UserMessagingPlatform", valueOf3.length() != 0 ? "Failed to fetch stored info: ".concat(valueOf3) : new String("Failed to fetch stored info: "), (Throwable) null, "com.google.android.gms.internal.consent_sdk.zzl", 51);
                    }
                    hashMap.put(next, str2);
                }
            }
        }
        zzbn.zzj = hashMap;
        DisplayCutout displayCutout = null;
        zzbn.zzd = null;
        zzbn.zzg = null;
        zzbn.zzh = Boolean.valueOf(this.zzd.isTagForUnderAgeOfConsent());
        zzbn.zzf = null;
        if (Build.VERSION.SDK_INT >= 21) {
            str = Locale.getDefault().toLanguageTag();
        } else {
            str = Locale.getDefault().toString();
        }
        zzbn.zze = str;
        zzbr zzbr = new zzbr();
        zzbr.zzc = Integer.valueOf(Build.VERSION.SDK_INT);
        zzbr.zzb = Build.MODEL;
        zzbr.zza = zzbu.zzb;
        zzbn.zzc = zzbr;
        Configuration configuration = this.zza.zza.getResources().getConfiguration();
        this.zza.zza.getResources().getConfiguration();
        zzbt zzbt = new zzbt();
        zzbt.zza = Integer.valueOf(configuration.screenWidthDp);
        zzbt.zzb = Integer.valueOf(configuration.screenHeightDp);
        zzbt.zzc = Double.valueOf((double) this.zza.zza.getResources().getDisplayMetrics().density);
        if (Build.VERSION.SDK_INT < 28) {
            list2 = Collections.emptyList();
        } else {
            Activity activity = this.zzb;
            Window window = activity == null ? null : activity.getWindow();
            if (window == null) {
                view = null;
            } else {
                view = window.getDecorView();
            }
            if (view == null) {
                windowInsets = null;
            } else {
                windowInsets = view.getRootWindowInsets();
            }
            if (windowInsets != null) {
                displayCutout = windowInsets.getDisplayCutout();
            }
            if (displayCutout == null) {
                list2 = Collections.emptyList();
            } else {
                displayCutout.getSafeInsetBottom();
                ArrayList arrayList = new ArrayList();
                for (Rect next2 : displayCutout.getBoundingRects()) {
                    if (next2 != null) {
                        zzbw zzbw = new zzbw();
                        zzbw.zzb = Integer.valueOf(next2.left);
                        zzbw.zzc = Integer.valueOf(next2.right);
                        zzbw.zza = Integer.valueOf(next2.top);
                        zzbw.zzd = Integer.valueOf(next2.bottom);
                        arrayList.add(zzbw);
                    }
                }
                list2 = arrayList;
            }
        }
        zzbt.zzd = list2;
        zzbn.zzk = zzbt;
        zzbn.zzl = zzb();
        zzbv zzbv = new zzbv();
        zzbv.zza = "1.0.0";
        zzbn.zzm = zzbv;
        return zzbn;
    }

    private final zzbp zzb() {
        PackageInfo packageInfo;
        Application zza2 = this.zza.zza;
        String str = null;
        try {
            packageInfo = SystemUtils.getPackageInfo(this.zza.zza.getPackageManager(), zza2.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        zzbp zzbp = new zzbp();
        zzbp.zza = zza2.getPackageName();
        CharSequence applicationLabel = this.zza.zza.getPackageManager().getApplicationLabel(this.zza.zza.getApplicationInfo());
        if (applicationLabel != null) {
            str = applicationLabel.toString();
        }
        zzbp.zzb = str;
        if (packageInfo != null) {
            zzbp.zzc = Long.toString(PackageInfoCompat.getLongVersionCode(packageInfo));
        }
        return zzbp;
    }

    private final String zzc() throws zzk {
        String zza2 = this.zzd.zza();
        if (!TextUtils.isEmpty(zza2)) {
            return zza2;
        }
        Bundle bundle = null;
        try {
            bundle = SystemUtils.getApplicationInfo(this.zza.zza.getPackageManager(), this.zza.zza.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (bundle != null) {
            zza2 = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        }
        if (!TextUtils.isEmpty(zza2)) {
            return zza2;
        }
        throw new zzk(3, "The UMP SDK requires a valid application ID in your AndroidManifest.xml through a com.google.android.gms.ads.APPLICATION_ID meta-data tag.\nExample AndroidManifest:\n    <meta-data\n        android:name=\"com.google.android.gms.ads.APPLICATION_ID\"\n        android:value=\"ca-app-pub-0000000000000000~0000000000\">");
    }
}
