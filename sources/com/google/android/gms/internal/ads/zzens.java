package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public class zzens {
    private static final zzemn zzioq = zzemn.zzbiv();
    private zzelq zziuy;
    private volatile zzeon zziuz;
    private volatile zzelq zziva;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzens)) {
            return false;
        }
        zzens zzens = (zzens) obj;
        zzeon zzeon = this.zziuz;
        zzeon zzeon2 = zzens.zziuz;
        if (zzeon == null && zzeon2 == null) {
            return zzbgy().equals(zzens.zzbgy());
        }
        if (zzeon != null && zzeon2 != null) {
            return zzeon.equals(zzeon2);
        }
        if (zzeon != null) {
            return zzeon.equals(zzens.zzm(zzeon.zzbjp()));
        }
        return zzm(zzeon2.zzbjp()).equals(zzeon2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzeon zzm(com.google.android.gms.internal.ads.zzeon r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzeon r0 = r1.zziuz
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzeon r0 = r1.zziuz     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zziuz = r2     // Catch:{ zzenn -> 0x0012 }
            com.google.android.gms.internal.ads.zzelq r0 = com.google.android.gms.internal.ads.zzelq.zzipc     // Catch:{ zzenn -> 0x0012 }
            r1.zziva = r0     // Catch:{ zzenn -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zziuz = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.ads.zzelq r2 = com.google.android.gms.internal.ads.zzelq.zzipc     // Catch:{ all -> 0x001a }
            r1.zziva = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.ads.zzeon r2 = r1.zziuz
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzens.zzm(com.google.android.gms.internal.ads.zzeon):com.google.android.gms.internal.ads.zzeon");
    }

    public final zzeon zzn(zzeon zzeon) {
        zzeon zzeon2 = this.zziuz;
        this.zziuy = null;
        this.zziva = null;
        this.zziuz = zzeon;
        return zzeon2;
    }

    public final int zzbjj() {
        if (this.zziva != null) {
            return this.zziva.size();
        }
        if (this.zziuz != null) {
            return this.zziuz.zzbjj();
        }
        return 0;
    }

    public final zzelq zzbgy() {
        if (this.zziva != null) {
            return this.zziva;
        }
        synchronized (this) {
            if (this.zziva != null) {
                zzelq zzelq = this.zziva;
                return zzelq;
            }
            if (this.zziuz == null) {
                this.zziva = zzelq.zzipc;
            } else {
                this.zziva = this.zziuz.zzbgy();
            }
            zzelq zzelq2 = this.zziva;
            return zzelq2;
        }
    }
}
