package com.google.android.gms.internal.ads;

import android.content.Context;
import com.didi.dimina.container.bean.Constant;
import com.google.android.gms.ads.internal.util.zzar;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzr;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzale {
    private final Context context;
    /* access modifiers changed from: private */
    public final Object lock;
    /* access modifiers changed from: private */
    public int status;
    private final zzbar zzbpx;
    private final String zzdkr;
    /* access modifiers changed from: private */
    public zzar<zzakv> zzdks;
    private zzar<zzakv> zzdkt;
    /* access modifiers changed from: private */
    public zzalz zzdku;

    private zzale(Context context2, zzbar zzbar, String str) {
        this.lock = new Object();
        this.status = 1;
        this.zzdkr = str;
        this.context = context2.getApplicationContext();
        this.zzbpx = zzbar;
        this.zzdks = new zzals();
        this.zzdkt = new zzals();
    }

    public zzale(Context context2, zzbar zzbar, String str, zzar<zzakv> zzar, zzar<zzakv> zzar2) {
        this(context2, zzbar, str);
        this.zzdks = zzar;
        this.zzdkt = zzar2;
    }

    /* access modifiers changed from: protected */
    public final zzalz zza(zzei zzei) {
        zzalz zzalz = new zzalz(this.zzdkt);
        zzbat.zzeki.execute(new zzalh(this, zzei, zzalz));
        zzalz.zza(new zzalr(this, zzalz), new zzalq(this, zzalz));
        return zzalz;
    }

    public final zzalv zzb(zzei zzei) {
        synchronized (this.lock) {
            synchronized (this.lock) {
                if (this.zzdku != null && this.status == 0) {
                    this.zzdku.zza(new zzalg(this), zzalj.zzdla);
                }
            }
            if (this.zzdku != null) {
                if (this.zzdku.getStatus() != -1) {
                    if (this.status == 0) {
                        zzalv zzuw = this.zzdku.zzuw();
                        return zzuw;
                    } else if (this.status == 1) {
                        this.status = 2;
                        zza((zzei) null);
                        zzalv zzuw2 = this.zzdku.zzuw();
                        return zzuw2;
                    } else if (this.status == 2) {
                        zzalv zzuw3 = this.zzdku.zzuw();
                        return zzuw3;
                    } else {
                        zzalv zzuw4 = this.zzdku.zzuw();
                        return zzuw4;
                    }
                }
            }
            this.status = 2;
            zzalz zza = zza((zzei) null);
            this.zzdku = zza;
            zzalv zzuw5 = zza.zzuw();
            return zzuw5;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzakv zzakv) {
        if (zzakv.isDestroyed()) {
            this.status = 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzei zzei, zzalz zzalz) {
        try {
            zzakx zzakx = new zzakx(this.context, this.zzbpx, zzei, (zzb) null);
            zzakx.zza(new zzali(this, zzalz, zzakx));
            zzakx.zza("/jsLoaded", new zzaln(this, zzalz, zzakx));
            zzbs zzbs = new zzbs();
            zzalm zzalm = new zzalm(this, zzei, zzakx, zzbs);
            zzbs.set(zzalm);
            zzakx.zza("/requestReload", zzalm);
            if (this.zzdkr.endsWith(Constant.LAUNCHER_JS.PAGE_WEB_VIEW_JAVASCRIPT_SUFFIX)) {
                zzakx.zzcw(this.zzdkr);
            } else if (this.zzdkr.startsWith("<html>")) {
                zzakx.zzcy(this.zzdkr);
            } else {
                zzakx.zzcx(this.zzdkr);
            }
            zzj.zzegq.postDelayed(new zzalp(this, zzalz, zzakx), (long) zzalt.zzdli);
        } catch (Throwable th) {
            zzd.zzc("Error creating webview.", th);
            zzr.zzkz().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzalz.reject();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzalz r4, com.google.android.gms.internal.ads.zzakv r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = -1
            if (r1 == r2) goto L_0x0028
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != r2) goto L_0x0012
            goto L_0x0028
        L_0x0012:
            r4.reject()     // Catch:{ all -> 0x002a }
            com.google.android.gms.internal.ads.zzebs r4 = com.google.android.gms.internal.ads.zzbat.zzeki     // Catch:{ all -> 0x002a }
            r5.getClass()     // Catch:{ all -> 0x002a }
            java.lang.Runnable r5 = com.google.android.gms.internal.ads.zzalk.zzb(r5)     // Catch:{ all -> 0x002a }
            r4.execute(r5)     // Catch:{ all -> 0x002a }
            java.lang.String r4 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.ads.internal.util.zzd.zzed(r4)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzale.zza(com.google.android.gms.internal.ads.zzalz, com.google.android.gms.internal.ads.zzakv):void");
    }
}
