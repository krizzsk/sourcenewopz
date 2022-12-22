package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaur {
    private float zzbsn;
    private int zzdrr;
    private int zzdrs;
    private int zzdyx;
    private boolean zzdyy;
    private boolean zzdyz;
    private String zzdza;
    private String zzdzb;
    private boolean zzdzc;
    private final boolean zzdzd;
    private boolean zzdze;
    private boolean zzdzf;
    private boolean zzdzg;
    private String zzdzh;
    private String zzdzi;
    private String zzdzj;
    private int zzdzk;
    private int zzdzl;
    private int zzdzm;
    private int zzdzn;
    private int zzdzo;
    private int zzdzp;
    private double zzdzq;
    private boolean zzdzr;
    private boolean zzdzs;
    private int zzdzt;
    private String zzdzu;
    private String zzdzv;
    private boolean zzdzw;

    public zzaur(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        zzs(context);
        zzt(context);
        zzu(context);
        Locale locale = Locale.getDefault();
        boolean z = true;
        this.zzdyy = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzdyz = zza(packageManager, "http://www.google.com") == null ? false : z;
        this.zzdzb = locale.getCountry();
        zzww.zzqw();
        this.zzdzc = zzbae.zzaap();
        this.zzdzd = DeviceProperties.isLatchsky(context);
        this.zzdze = DeviceProperties.isSidewinder(context);
        this.zzdzh = locale.getLanguage();
        this.zzdzi = zza(context, packageManager);
        this.zzdzj = zzv(context);
        Resources resources = context.getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            this.zzbsn = displayMetrics.density;
            this.zzdrr = displayMetrics.widthPixels;
            this.zzdrs = displayMetrics.heightPixels;
        }
    }

    public zzaur(Context context, zzauo zzauo) {
        zzs(context);
        zzt(context);
        zzu(context);
        this.zzdzu = Build.FINGERPRINT;
        this.zzdzv = Build.DEVICE;
        this.zzdzw = PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacq.zzj(context);
        this.zzdyy = zzauo.zzdyy;
        this.zzdyz = zzauo.zzdyz;
        this.zzdzb = zzauo.zzdzb;
        this.zzdzc = zzauo.zzdzc;
        this.zzdzd = zzauo.zzdzd;
        this.zzdze = zzauo.zzdze;
        this.zzdzh = zzauo.zzdzh;
        this.zzdzi = zzauo.zzdzi;
        this.zzdzj = zzauo.zzdzj;
        this.zzbsn = zzauo.zzbsn;
        this.zzdrr = zzauo.zzdrr;
        this.zzdrs = zzauo.zzdrs;
    }

    private final void zzs(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.zzdyx = audioManager.getMode();
                this.zzdzf = audioManager.isMusicActive();
                this.zzdzg = audioManager.isSpeakerphoneOn();
                this.zzdzk = audioManager.getStreamVolume(3);
                this.zzdzo = audioManager.getRingerMode();
                this.zzdzp = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzr.zzkz().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzdyx = -2;
        this.zzdzf = false;
        this.zzdzg = false;
        this.zzdzk = 0;
        this.zzdzo = 2;
        this.zzdzp = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzt(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r6.getSystemService(r0)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r1 = "connectivity"
            java.lang.Object r1 = r6.getSystemService(r1)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            java.lang.String r2 = r0.getNetworkOperator()
            r5.zzdza = r2
            boolean r2 = com.google.android.gms.common.util.PlatformVersion.isAtLeastR()
            r3 = 0
            if (r2 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabq.zzdbg
            com.google.android.gms.internal.ads.zzabm r4 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r2 = r4.zzd(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0031
            r2 = 0
            goto L_0x0035
        L_0x0031:
            int r2 = r0.getNetworkType()
        L_0x0035:
            r5.zzdzm = r2
            int r0 = r0.getPhoneType()
            r5.zzdzn = r0
            r0 = -2
            r5.zzdzl = r0
            r5.zzdzs = r3
            r0 = -1
            r5.zzdzt = r0
            com.google.android.gms.ads.internal.zzr.zzkv()
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r6 = com.google.android.gms.ads.internal.util.zzj.zzp(r6, r2)
            if (r6 == 0) goto L_0x006f
            android.net.NetworkInfo r6 = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo(r1)
            if (r6 == 0) goto L_0x0067
            int r0 = r6.getType()
            r5.zzdzl = r0
            android.net.NetworkInfo$DetailedState r6 = r6.getDetailedState()
            int r6 = r6.ordinal()
            r5.zzdzt = r6
            goto L_0x0069
        L_0x0067:
            r5.zzdzl = r0
        L_0x0069:
            boolean r6 = r1.isActiveNetworkMetered()
            r5.zzdzs = r6
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaur.zzt(android.content.Context):void");
    }

    private final void zzu(Context context) {
        Intent intent = null;
        try {
            intent = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        boolean z = false;
        if (intent != null) {
            int intExtra = intent.getIntExtra("status", -1);
            this.zzdzq = (double) (((float) intent.getIntExtra("level", -1)) / ((float) intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.zzdzr = z;
            return;
        }
        this.zzdzq = -1.0d;
        this.zzdzr = false;
    }

    private static String zzv(Context context) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = packageInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static String zza(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzr.zzkz().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    public final zzauo zzxd() {
        return new zzauo(this.zzdyx, this.zzdyy, this.zzdyz, this.zzdza, this.zzdzb, this.zzdzc, this.zzdzd, this.zzdze, this.zzdzf, this.zzdzg, this.zzdzh, this.zzdzi, this.zzdzj, this.zzdzk, this.zzdzl, this.zzdzm, this.zzdzn, this.zzdzo, this.zzdzp, this.zzbsn, this.zzdrr, this.zzdrs, this.zzdzq, this.zzdzr, this.zzdzs, this.zzdzt, this.zzdzu, this.zzdzw, this.zzdzv);
    }
}
