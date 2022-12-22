package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbgc extends zzzg {
    private final Object lock = new Object();
    private boolean zzaef;
    private boolean zzaeg;
    private int zzafh;
    private zzzi zzdor;
    private final zzbcs zzekz;
    private final boolean zzewf;
    private final boolean zzewg;
    private boolean zzewh;
    private boolean zzewi = true;
    private float zzewj;
    private float zzewk;
    private float zzewl;
    private zzage zzewm;

    public zzbgc(zzbcs zzbcs, float f, boolean z, boolean z2) {
        this.zzekz = zzbcs;
        this.zzewj = f;
        this.zzewf = z;
        this.zzewg = z2;
    }

    public final void play() {
        zze("play", (Map<String, String>) null);
    }

    public final void pause() {
        zze("pause", (Map<String, String>) null);
    }

    public final void stop() {
        zze("stop", (Map<String, String>) null);
    }

    public final void mute(boolean z) {
        zze(z ? "mute" : "unmute", (Map<String, String>) null);
    }

    public final void zzb(zzaaz zzaaz) {
        boolean z = zzaaz.zzaee;
        boolean z2 = zzaaz.zzaef;
        boolean z3 = zzaaz.zzaeg;
        synchronized (this.lock) {
            this.zzaef = z2;
            this.zzaeg = z3;
        }
        zze("initialState", CollectionUtils.mapOf("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    private final void zze(String str, Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzbat.zzeki.execute(new zzbgb(this, hashMap));
    }

    public final boolean isMuted() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzewi;
        }
        return z;
    }

    public final int getPlaybackState() {
        int i;
        synchronized (this.lock) {
            i = this.zzafh;
        }
        return i;
    }

    public final float getAspectRatio() {
        float f;
        synchronized (this.lock) {
            f = this.zzewl;
        }
        return f;
    }

    public final float getDuration() {
        float f;
        synchronized (this.lock) {
            f = this.zzewj;
        }
        return f;
    }

    public final float getCurrentTime() {
        float f;
        synchronized (this.lock) {
            f = this.zzewk;
        }
        return f;
    }

    public final void zza(zzzi zzzi) {
        synchronized (this.lock) {
            this.zzdor = zzzi;
        }
    }

    public final zzzi zzrm() throws RemoteException {
        zzzi zzzi;
        synchronized (this.lock) {
            zzzi = this.zzdor;
        }
        return zzzi;
    }

    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzewf && this.zzaef;
        }
        return z;
    }

    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.lock) {
            if (!isCustomControlsEnabled) {
                try {
                    if (this.zzaeg && this.zzewg) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            z = false;
        }
        return z;
    }

    public final void zze(float f) {
        synchronized (this.lock) {
            this.zzewk = f;
        }
    }

    public final void zzafe() {
        boolean z;
        int i;
        synchronized (this.lock) {
            z = this.zzewi;
            i = this.zzafh;
            this.zzafh = 3;
        }
        zza(i, 3, z, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(float r4, float r5, int r6, boolean r7, float r8) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            float r1 = r3.zzewj     // Catch:{ all -> 0x004f }
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0012
            float r1 = r3.zzewl     // Catch:{ all -> 0x004f }
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r1 = 0
            goto L_0x0013
        L_0x0012:
            r1 = 1
        L_0x0013:
            r3.zzewj = r5     // Catch:{ all -> 0x004f }
            r3.zzewk = r4     // Catch:{ all -> 0x004f }
            boolean r4 = r3.zzewi     // Catch:{ all -> 0x004f }
            r3.zzewi = r7     // Catch:{ all -> 0x004f }
            int r5 = r3.zzafh     // Catch:{ all -> 0x004f }
            r3.zzafh = r6     // Catch:{ all -> 0x004f }
            float r2 = r3.zzewl     // Catch:{ all -> 0x004f }
            r3.zzewl = r8     // Catch:{ all -> 0x004f }
            float r8 = r8 - r2
            float r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x004f }
            r2 = 953267991(0x38d1b717, float:1.0E-4)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzbcs r8 = r3.zzekz     // Catch:{ all -> 0x004f }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x004f }
            r8.invalidate()     // Catch:{ all -> 0x004f }
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzage r8 = r3.zzewm     // Catch:{ RemoteException -> 0x0045 }
            if (r8 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzage r8 = r3.zzewm     // Catch:{ RemoteException -> 0x0045 }
            r8.zzuc()     // Catch:{ RemoteException -> 0x0045 }
            goto L_0x004b
        L_0x0045:
            r8 = move-exception
            java.lang.String r0 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzbao.zze(r0, r8)
        L_0x004b:
            r3.zza(r5, r6, r4, r7)
            return
        L_0x004f:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgc.zza(float, float, int, boolean, float):void");
    }

    public final void zza(zzage zzage) {
        synchronized (this.lock) {
            this.zzewm = zzage;
        }
    }

    private final void zza(int i, int i2, boolean z, boolean z2) {
        zzbat.zzeki.execute(new zzbge(this, i, i2, z, z2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(int i, int i2, boolean z, boolean z2) {
        synchronized (this.lock) {
            boolean z3 = false;
            boolean z4 = i != i2;
            boolean z5 = !this.zzewh && i2 == 1;
            boolean z6 = z4 && i2 == 1;
            boolean z7 = z4 && i2 == 2;
            boolean z8 = z4 && i2 == 3;
            boolean z9 = z != z2;
            if (this.zzewh || z5) {
                z3 = true;
            }
            this.zzewh = z3;
            if (z5) {
                try {
                    if (this.zzdor != null) {
                        this.zzdor.onVideoStart();
                    }
                } catch (RemoteException e) {
                    zzbao.zze("#007 Could not call remote method.", e);
                }
            }
            if (z6 && this.zzdor != null) {
                this.zzdor.onVideoPlay();
            }
            if (z7 && this.zzdor != null) {
                this.zzdor.onVideoPause();
            }
            if (z8) {
                if (this.zzdor != null) {
                    this.zzdor.onVideoEnd();
                }
                this.zzekz.zzacf();
            }
            if (z9 && this.zzdor != null) {
                this.zzdor.onVideoMute(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(Map map) {
        this.zzekz.zza("pubVideoCmd", (Map<String, ?>) map);
    }
}
