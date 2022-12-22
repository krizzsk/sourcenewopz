package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.util.zzi;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzazs {
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public zzbar zzbpx;
    private final zzbac zzedz = new zzbac(zzww.zzrb(), this.zzeeh);
    private final zzi zzeeh = new zzi();
    /* access modifiers changed from: private */
    public zzabx zzeei = null;
    private Boolean zzeej = null;
    private final AtomicInteger zzeek = new AtomicInteger(0);
    private final zzazx zzeel = new zzazx((zzazu) null);
    private final Object zzeem = new Object();
    private zzebt<ArrayList<String>> zzeen;
    private boolean zzzq = false;

    public final zzabx zzyf() {
        zzabx zzabx;
        synchronized (this.lock) {
            zzabx = this.zzeei;
        }
        return zzabx;
    }

    public final void zza(Boolean bool) {
        synchronized (this.lock) {
            this.zzeej = bool;
        }
    }

    public final Boolean zzyg() {
        Boolean bool;
        synchronized (this.lock) {
            bool = this.zzeej;
        }
        return bool;
    }

    public final void zzyh() {
        this.zzeel.zzyh();
    }

    public final void zzd(Context context2, zzbar zzbar) {
        zzabx zzabx;
        synchronized (this.lock) {
            if (!this.zzzq) {
                this.context = context2.getApplicationContext();
                this.zzbpx = zzbar;
                zzr.zzky().zza(this.zzedz);
                this.zzeeh.initialize(this.context);
                zzatl.zzc(this.context, this.zzbpx);
                zzr.zzle();
                if (!zzadg.zzded.get().booleanValue()) {
                    zzd.zzed("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    zzabx = null;
                } else {
                    zzabx = new zzabx();
                }
                this.zzeei = zzabx;
                if (zzabx != null) {
                    zzbba.zza(new zzazu(this).zzyx(), "AppState.registerCsiReporter");
                }
                this.zzzq = true;
                zzym();
            }
        }
        zzr.zzkv().zzq(context2, zzbar.zzbrz);
    }

    public final Resources getResources() {
        if (this.zzbpx.zzekc) {
            return this.context.getResources();
        }
        try {
            zzban.zzbw(this.context).getResources();
            return null;
        } catch (zzbap e) {
            zzd.zzd("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void zza(Throwable th, String str) {
        zzatl.zzc(this.context, this.zzbpx).zza(th, str);
    }

    public final void zzb(Throwable th, String str) {
        zzatl.zzc(this.context, this.zzbpx).zza(th, str, zzads.zzdfv.get().floatValue());
    }

    public final void zzyi() {
        this.zzeek.incrementAndGet();
    }

    public final void zzyj() {
        this.zzeek.decrementAndGet();
    }

    public final int zzyk() {
        return this.zzeek.get();
    }

    public final zzf zzyl() {
        zzi zzi;
        synchronized (this.lock) {
            zzi = this.zzeeh;
        }
        return zzi;
    }

    public final Context getApplicationContext() {
        return this.context;
    }

    public final zzebt<ArrayList<String>> zzym() {
        if (PlatformVersion.isAtLeastJellyBean() && this.context != null) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzcsx)).booleanValue()) {
                synchronized (this.zzeem) {
                    if (this.zzeen != null) {
                        zzebt<ArrayList<String>> zzebt = this.zzeen;
                        return zzebt;
                    }
                    zzebt<ArrayList<String>> zze = zzbat.zzeke.zze(new zzazv(this));
                    this.zzeen = zze;
                    return zze;
                }
            }
        }
        return zzebh.zzag(new ArrayList());
    }

    private static ArrayList<String> zzak(Context context2) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context2).getPackageInfo(context2.getApplicationInfo().packageName, 4096);
            if (!(packageInfo.requestedPermissions == null || packageInfo.requestedPermissionsFlags == null)) {
                for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(packageInfo.requestedPermissions[i]);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final zzbac zzyn() {
        return this.zzedz;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzyo() throws Exception {
        return zzak(zzava.zzx(this.context));
    }
}
