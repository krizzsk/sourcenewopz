package com.google.android.gms.internal.auth;

import android.content.Context;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public abstract class zzcz<T> {
    private static final Object zza = new Object();
    public static final /* synthetic */ int zzd = 0;
    @Nullable
    private static volatile zzcy zze = null;
    private static volatile boolean zzf = false;
    private static final AtomicReference<Collection<zzcz<?>>> zzg = new AtomicReference<>();
    private static final zzdb zzh = new zzdb(zzcr.zza, (byte[]) null);
    private static final AtomicInteger zzi = new AtomicInteger();
    final zzcx zzb;
    final String zzc;
    private final T zzj;
    private volatile int zzk = -1;
    private volatile T zzl;
    private final boolean zzm;

    /* synthetic */ zzcz(zzcx zzcx, String str, Object obj, boolean z, zzct zzct) {
        if (zzcx.zzb != null) {
            this.zzb = zzcx;
            this.zzc = str;
            this.zzj = obj;
            this.zzm = true;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    static void zzd() {
        zzi.incrementAndGet();
    }

    public static void zze(Context context) {
        if (zze == null) {
            synchronized (zza) {
                if (zze == null) {
                    synchronized (zza) {
                        zzcy zzcy = zze;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (zzcy == null || zzcy.zza() != context) {
                            zzcg.zzd();
                            zzda.zzc();
                            zzcn.zze();
                            zze = new zzcd(context, zzdk.zza(new zzcs(context)));
                            zzi.incrementAndGet();
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    public final String zzc() {
        String str = this.zzb.zzd;
        return this.zzc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzb() {
        /*
            r10 = this;
            boolean r0 = r10.zzm
            if (r0 != 0) goto L_0x0011
            java.lang.String r0 = r10.zzc
            if (r0 == 0) goto L_0x0009
            goto L_0x0011
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "flagName must not be null"
            r0.<init>(r1)
            throw r0
        L_0x0011:
            java.util.concurrent.atomic.AtomicInteger r0 = zzi
            int r0 = r0.get()
            int r1 = r10.zzk
            if (r1 >= r0) goto L_0x012e
            monitor-enter(r10)
            int r1 = r10.zzk     // Catch:{ all -> 0x012b }
            if (r1 >= r0) goto L_0x0129
            com.google.android.gms.internal.auth.zzcy r1 = zze     // Catch:{ all -> 0x012b }
            java.lang.String r2 = "Must call PhenotypeFlag.init() first"
            if (r1 == 0) goto L_0x0123
            com.google.android.gms.internal.auth.zzcx r2 = r10.zzb     // Catch:{ all -> 0x012b }
            boolean r3 = r2.zzf     // Catch:{ all -> 0x012b }
            boolean r2 = r2.zzg     // Catch:{ all -> 0x012b }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x012b }
            com.google.android.gms.internal.auth.zzcn r2 = com.google.android.gms.internal.auth.zzcn.zza(r2)     // Catch:{ all -> 0x012b }
            java.lang.String r3 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.String r2 = r2.zzb(r3)     // Catch:{ all -> 0x012b }
            r3 = 0
            if (r2 == 0) goto L_0x007b
            java.util.regex.Pattern r4 = com.google.android.gms.internal.auth.zzcb.zzc     // Catch:{ all -> 0x012b }
            java.util.regex.Matcher r2 = r4.matcher(r2)     // Catch:{ all -> 0x012b }
            boolean r2 = r2.matches()     // Catch:{ all -> 0x012b }
            if (r2 == 0) goto L_0x007b
            java.lang.String r2 = "PhenotypeFlag"
            r4 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r4)     // Catch:{ all -> 0x012b }
            if (r2 == 0) goto L_0x0079
            java.lang.String r5 = "PhenotypeFlag"
            java.lang.String r2 = "Bypass reading Phenotype values for flag: "
            java.lang.String r4 = r10.zzc()     // Catch:{ all -> 0x012b }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x012b }
            int r6 = r4.length()     // Catch:{ all -> 0x012b }
            if (r6 == 0) goto L_0x006a
            java.lang.String r2 = r2.concat(r4)     // Catch:{ all -> 0x012b }
            r6 = r2
            goto L_0x0070
        L_0x006a:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x012b }
            r4.<init>(r2)     // Catch:{ all -> 0x012b }
            r6 = r4
        L_0x0070:
            r4 = 3
            r7 = 0
            java.lang.String r8 = "com.google.android.gms.internal.auth.zzcz"
            r9 = 17
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x012b }
        L_0x0079:
            r2 = r3
            goto L_0x00c2
        L_0x007b:
            com.google.android.gms.internal.auth.zzcx r2 = r10.zzb     // Catch:{ all -> 0x012b }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x012b }
            if (r2 == 0) goto L_0x00a6
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x012b }
            com.google.android.gms.internal.auth.zzcx r4 = r10.zzb     // Catch:{ all -> 0x012b }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x012b }
            boolean r2 = com.google.android.gms.internal.auth.zzcp.zza(r2, r4)     // Catch:{ all -> 0x012b }
            if (r2 == 0) goto L_0x00a4
            com.google.android.gms.internal.auth.zzcx r2 = r10.zzb     // Catch:{ all -> 0x012b }
            boolean r2 = r2.zzh     // Catch:{ all -> 0x012b }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x012b }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x012b }
            com.google.android.gms.internal.auth.zzcx r4 = r10.zzb     // Catch:{ all -> 0x012b }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x012b }
            com.google.android.gms.internal.auth.zzcg r2 = com.google.android.gms.internal.auth.zzcg.zza(r2, r4)     // Catch:{ all -> 0x012b }
            goto L_0x00b2
        L_0x00a4:
            r2 = r3
            goto L_0x00b2
        L_0x00a6:
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x012b }
            com.google.android.gms.internal.auth.zzcx r4 = r10.zzb     // Catch:{ all -> 0x012b }
            java.lang.String r4 = r4.zza     // Catch:{ all -> 0x012b }
            com.google.android.gms.internal.auth.zzda r2 = com.google.android.gms.internal.auth.zzda.zza(r2, r3)     // Catch:{ all -> 0x012b }
        L_0x00b2:
            if (r2 == 0) goto L_0x0079
            java.lang.String r4 = r10.zzc()     // Catch:{ all -> 0x012b }
            java.lang.Object r2 = r2.zzb(r4)     // Catch:{ all -> 0x012b }
            if (r2 == 0) goto L_0x0079
            java.lang.Object r2 = r10.zza(r2)     // Catch:{ all -> 0x012b }
        L_0x00c2:
            if (r2 == 0) goto L_0x00c5
            goto L_0x00f1
        L_0x00c5:
            com.google.android.gms.internal.auth.zzcx r2 = r10.zzb     // Catch:{ all -> 0x012b }
            boolean r4 = r2.zze     // Catch:{ all -> 0x012b }
            if (r4 != 0) goto L_0x00ec
            com.google.android.gms.internal.auth.zzdd<android.content.Context, java.lang.Boolean> r2 = r2.zzi     // Catch:{ all -> 0x012b }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x012b }
            com.google.android.gms.internal.auth.zzcn r2 = com.google.android.gms.internal.auth.zzcn.zza(r2)     // Catch:{ all -> 0x012b }
            com.google.android.gms.internal.auth.zzcx r4 = r10.zzb     // Catch:{ all -> 0x012b }
            boolean r5 = r4.zze     // Catch:{ all -> 0x012b }
            if (r5 == 0) goto L_0x00dd
            r4 = r3
            goto L_0x00e1
        L_0x00dd:
            java.lang.String r4 = r4.zzc     // Catch:{ all -> 0x012b }
            java.lang.String r4 = r10.zzc     // Catch:{ all -> 0x012b }
        L_0x00e1:
            java.lang.String r2 = r2.zzb(r4)     // Catch:{ all -> 0x012b }
            if (r2 == 0) goto L_0x00ec
            java.lang.Object r2 = r10.zza(r2)     // Catch:{ all -> 0x012b }
            goto L_0x00ed
        L_0x00ec:
            r2 = r3
        L_0x00ed:
            if (r2 != 0) goto L_0x00f1
            T r2 = r10.zzj     // Catch:{ all -> 0x012b }
        L_0x00f1:
            com.google.android.gms.internal.auth.zzdg r1 = r1.zzb()     // Catch:{ all -> 0x012b }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x012b }
            com.google.android.gms.internal.auth.zzde r1 = (com.google.android.gms.internal.auth.zzde) r1     // Catch:{ all -> 0x012b }
            boolean r4 = r1.zzb()     // Catch:{ all -> 0x012b }
            if (r4 == 0) goto L_0x011e
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x012b }
            com.google.android.gms.internal.auth.zzco r1 = (com.google.android.gms.internal.auth.zzco) r1     // Catch:{ all -> 0x012b }
            com.google.android.gms.internal.auth.zzcx r2 = r10.zzb     // Catch:{ all -> 0x012b }
            android.net.Uri r4 = r2.zzb     // Catch:{ all -> 0x012b }
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x012b }
            java.lang.String r2 = r2.zzd     // Catch:{ all -> 0x012b }
            java.lang.String r5 = r10.zzc     // Catch:{ all -> 0x012b }
            java.lang.String r1 = r1.zza(r4, r3, r2, r5)     // Catch:{ all -> 0x012b }
            if (r1 != 0) goto L_0x011a
            T r2 = r10.zzj     // Catch:{ all -> 0x012b }
            goto L_0x011e
        L_0x011a:
            java.lang.Object r2 = r10.zza(r1)     // Catch:{ all -> 0x012b }
        L_0x011e:
            r10.zzl = r2     // Catch:{ all -> 0x012b }
            r10.zzk = r0     // Catch:{ all -> 0x012b }
            goto L_0x0129
        L_0x0123:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x012b }
            r0.<init>(r2)     // Catch:{ all -> 0x012b }
            throw r0     // Catch:{ all -> 0x012b }
        L_0x0129:
            monitor-exit(r10)     // Catch:{ all -> 0x012b }
            goto L_0x012e
        L_0x012b:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x012b }
            throw r0
        L_0x012e:
            T r0 = r10.zzl
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzcz.zzb():java.lang.Object");
    }
}
