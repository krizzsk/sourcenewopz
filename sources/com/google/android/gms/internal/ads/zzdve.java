package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.p003v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdve implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final String packageName;
    private final HandlerThread zzeiq;
    private zzdwe zzhvt;
    private final String zzhvu;
    private final LinkedBlockingQueue<zzcf.zza> zzhvv = new LinkedBlockingQueue<>();

    public zzdve(Context context, String str, String str2) {
        this.packageName = str;
        this.zzhvu = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.zzeiq = handlerThread;
        handlerThread.start();
        this.zzhvt = new zzdwe(context, this.zzeiq.getLooper(), this, this, 9200000);
        this.zzhvt.checkAvailabilityAndConnect();
    }

    public final zzcf.zza zzen(int i) {
        zzcf.zza zza;
        try {
            zza = this.zzhvv.poll(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zza = null;
        }
        return zza == null ? zzays() : zza;
    }

    private final zzdwl zzayr() {
        try {
            return this.zzhvt.zzazg();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            this.zzhvv.put(zzays());
        } catch (InterruptedException unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|11|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        zzasm();
        r3.zzeiq.quit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r3.zzhvv.put(zzays());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
        zzasm();
        r3.zzeiq.quit();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(android.os.Bundle r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzdwl r4 = r3.zzayr()
            if (r4 == 0) goto L_0x0041
            com.google.android.gms.internal.ads.zzdwh r0 = new com.google.android.gms.internal.ads.zzdwh     // Catch:{ all -> 0x0025 }
            java.lang.String r1 = r3.packageName     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = r3.zzhvu     // Catch:{ all -> 0x0025 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdwj r4 = r4.zza((com.google.android.gms.internal.ads.zzdwh) r0)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzcf$zza r4 = r4.zzazh()     // Catch:{ all -> 0x0025 }
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzcf$zza> r0 = r3.zzhvv     // Catch:{ all -> 0x0025 }
            r0.put(r4)     // Catch:{ all -> 0x0025 }
            r3.zzasm()
            android.os.HandlerThread r4 = r3.zzeiq
            r4.quit()
            return
        L_0x0025:
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzcf$zza> r4 = r3.zzhvv     // Catch:{ InterruptedException -> 0x0039, all -> 0x002f }
            com.google.android.gms.internal.ads.zzcf$zza r0 = zzays()     // Catch:{ InterruptedException -> 0x0039, all -> 0x002f }
            r4.put(r0)     // Catch:{ InterruptedException -> 0x0039, all -> 0x002f }
            goto L_0x0039
        L_0x002f:
            r4 = move-exception
            r3.zzasm()
            android.os.HandlerThread r0 = r3.zzeiq
            r0.quit()
            throw r4
        L_0x0039:
            r3.zzasm()
            android.os.HandlerThread r4 = r3.zzeiq
            r4.quit()
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdve.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzhvv.put(zzays());
        } catch (InterruptedException unused) {
        }
    }

    private final void zzasm() {
        zzdwe zzdwe = this.zzhvt;
        if (zzdwe == null) {
            return;
        }
        if (zzdwe.isConnected() || this.zzhvt.isConnecting()) {
            this.zzhvt.disconnect();
        }
    }

    private static zzcf.zza zzays() {
        return (zzcf.zza) ((zzena) zzcf.zza.zzap().zzau(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID).zzbjv());
    }
}
