package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
public abstract class zzht<T> {
    public static final /* synthetic */ int zzc = 0;
    private static final Object zzd = new Object();
    @Nullable
    private static volatile zzhs zze = null;
    private static volatile boolean zzf = false;
    private static final AtomicReference<Collection<zzht<?>>> zzg = new AtomicReference<>();
    private static final zzhv zzh = new zzhv(zzhm.zza);
    private static final AtomicInteger zzj = new AtomicInteger();
    final zzhr zza;
    final String zzb;
    private final T zzi;
    private volatile int zzk = -1;
    private volatile T zzl;
    private final boolean zzm;

    /* synthetic */ zzht(zzhr zzhr, String str, Object obj, boolean z, zzhn zzhn) {
        if (zzhr.zzb != null) {
            this.zza = zzhr;
            this.zzb = str;
            this.zzi = obj;
            this.zzm = true;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    @Deprecated
    public static void zzb(Context context) {
        synchronized (zzd) {
            zzhs zzhs = zze;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzhs == null || zzhs.zza() != context) {
                zzha.zzd();
                zzhu.zzb();
                zzhh.zzc();
                zze = new zzgx(context, zzif.zza(new zzhl(context)));
                zzj.incrementAndGet();
            }
        }
    }

    static void zzc() {
        zzj.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    public final String zzd() {
        String str = this.zza.zzd;
        return this.zzb;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zze() {
        /*
            r10 = this;
            boolean r0 = r10.zzm
            if (r0 != 0) goto L_0x0011
            java.lang.String r0 = r10.zzb
            if (r0 == 0) goto L_0x0009
            goto L_0x0011
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "flagName must not be null"
            r0.<init>(r1)
            throw r0
        L_0x0011:
            java.util.concurrent.atomic.AtomicInteger r0 = zzj
            int r0 = r0.get()
            int r1 = r10.zzk
            if (r1 >= r0) goto L_0x0128
            monitor-enter(r10)
            int r1 = r10.zzk     // Catch:{ all -> 0x0125 }
            if (r1 >= r0) goto L_0x0123
            com.google.android.gms.internal.measurement.zzhs r1 = zze     // Catch:{ all -> 0x0125 }
            java.lang.String r2 = "Must call PhenotypeFlag.init() first"
            if (r1 == 0) goto L_0x011d
            com.google.android.gms.internal.measurement.zzhr r2 = r10.zza     // Catch:{ all -> 0x0125 }
            boolean r3 = r2.zzf     // Catch:{ all -> 0x0125 }
            boolean r2 = r2.zzg     // Catch:{ all -> 0x0125 }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.measurement.zzhh r2 = com.google.android.gms.internal.measurement.zzhh.zza(r2)     // Catch:{ all -> 0x0125 }
            java.lang.String r3 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.String r2 = r2.zze(r3)     // Catch:{ all -> 0x0125 }
            r3 = 0
            if (r2 == 0) goto L_0x007b
            java.util.regex.Pattern r4 = com.google.android.gms.internal.measurement.zzgv.zzc     // Catch:{ all -> 0x0125 }
            java.util.regex.Matcher r2 = r4.matcher(r2)     // Catch:{ all -> 0x0125 }
            boolean r2 = r2.matches()     // Catch:{ all -> 0x0125 }
            if (r2 == 0) goto L_0x007b
            java.lang.String r2 = "PhenotypeFlag"
            r4 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r4)     // Catch:{ all -> 0x0125 }
            if (r2 == 0) goto L_0x0079
            java.lang.String r5 = "PhenotypeFlag"
            java.lang.String r2 = "Bypass reading Phenotype values for flag: "
            java.lang.String r4 = r10.zzd()     // Catch:{ all -> 0x0125 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0125 }
            int r6 = r4.length()     // Catch:{ all -> 0x0125 }
            if (r6 == 0) goto L_0x006a
            java.lang.String r2 = r2.concat(r4)     // Catch:{ all -> 0x0125 }
            r6 = r2
            goto L_0x0070
        L_0x006a:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0125 }
            r4.<init>(r2)     // Catch:{ all -> 0x0125 }
            r6 = r4
        L_0x0070:
            r4 = 3
            r7 = 0
            java.lang.String r8 = "com.google.android.gms.internal.measurement.zzht"
            r9 = 17
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0125 }
        L_0x0079:
            r2 = r3
            goto L_0x00c2
        L_0x007b:
            com.google.android.gms.internal.measurement.zzhr r2 = r10.zza     // Catch:{ all -> 0x0125 }
            android.net.Uri r2 = r2.zzb     // Catch:{ all -> 0x0125 }
            if (r2 == 0) goto L_0x00a6
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.measurement.zzhr r4 = r10.zza     // Catch:{ all -> 0x0125 }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x0125 }
            boolean r2 = com.google.android.gms.internal.measurement.zzhj.zza(r2, r4)     // Catch:{ all -> 0x0125 }
            if (r2 == 0) goto L_0x00a4
            com.google.android.gms.internal.measurement.zzhr r2 = r10.zza     // Catch:{ all -> 0x0125 }
            boolean r2 = r2.zzh     // Catch:{ all -> 0x0125 }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0125 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.measurement.zzhr r4 = r10.zza     // Catch:{ all -> 0x0125 }
            android.net.Uri r4 = r4.zzb     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.measurement.zzha r2 = com.google.android.gms.internal.measurement.zzha.zza(r2, r4)     // Catch:{ all -> 0x0125 }
            goto L_0x00b2
        L_0x00a4:
            r2 = r3
            goto L_0x00b2
        L_0x00a6:
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.measurement.zzhr r4 = r10.zza     // Catch:{ all -> 0x0125 }
            java.lang.String r4 = r4.zza     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.measurement.zzhu r2 = com.google.android.gms.internal.measurement.zzhu.zza(r2, r3)     // Catch:{ all -> 0x0125 }
        L_0x00b2:
            if (r2 == 0) goto L_0x0079
            java.lang.String r4 = r10.zzd()     // Catch:{ all -> 0x0125 }
            java.lang.Object r2 = r2.zze(r4)     // Catch:{ all -> 0x0125 }
            if (r2 == 0) goto L_0x0079
            java.lang.Object r2 = r10.zza(r2)     // Catch:{ all -> 0x0125 }
        L_0x00c2:
            if (r2 == 0) goto L_0x00c5
            goto L_0x00eb
        L_0x00c5:
            com.google.android.gms.internal.measurement.zzhr r2 = r10.zza     // Catch:{ all -> 0x0125 }
            boolean r4 = r2.zze     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.measurement.zzhy<android.content.Context, java.lang.Boolean> r2 = r2.zzi     // Catch:{ all -> 0x0125 }
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.measurement.zzhh r2 = com.google.android.gms.internal.measurement.zzhh.zza(r2)     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.measurement.zzhr r4 = r10.zza     // Catch:{ all -> 0x0125 }
            boolean r5 = r4.zze     // Catch:{ all -> 0x0125 }
            java.lang.String r4 = r4.zzc     // Catch:{ all -> 0x0125 }
            java.lang.String r4 = r10.zzb     // Catch:{ all -> 0x0125 }
            java.lang.String r2 = r2.zze(r4)     // Catch:{ all -> 0x0125 }
            if (r2 == 0) goto L_0x00e6
            java.lang.Object r2 = r10.zza(r2)     // Catch:{ all -> 0x0125 }
            goto L_0x00e7
        L_0x00e6:
            r2 = r3
        L_0x00e7:
            if (r2 != 0) goto L_0x00eb
            T r2 = r10.zzi     // Catch:{ all -> 0x0125 }
        L_0x00eb:
            com.google.android.gms.internal.measurement.zzib r1 = r1.zzb()     // Catch:{ all -> 0x0125 }
            java.lang.Object r1 = r1.zza()     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.measurement.zzhz r1 = (com.google.android.gms.internal.measurement.zzhz) r1     // Catch:{ all -> 0x0125 }
            boolean r4 = r1.zza()     // Catch:{ all -> 0x0125 }
            if (r4 == 0) goto L_0x0118
            java.lang.Object r1 = r1.zzb()     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.measurement.zzhi r1 = (com.google.android.gms.internal.measurement.zzhi) r1     // Catch:{ all -> 0x0125 }
            com.google.android.gms.internal.measurement.zzhr r2 = r10.zza     // Catch:{ all -> 0x0125 }
            android.net.Uri r4 = r2.zzb     // Catch:{ all -> 0x0125 }
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x0125 }
            java.lang.String r2 = r2.zzd     // Catch:{ all -> 0x0125 }
            java.lang.String r5 = r10.zzb     // Catch:{ all -> 0x0125 }
            java.lang.String r1 = r1.zza(r4, r3, r2, r5)     // Catch:{ all -> 0x0125 }
            if (r1 != 0) goto L_0x0114
            T r2 = r10.zzi     // Catch:{ all -> 0x0125 }
            goto L_0x0118
        L_0x0114:
            java.lang.Object r2 = r10.zza(r1)     // Catch:{ all -> 0x0125 }
        L_0x0118:
            r10.zzl = r2     // Catch:{ all -> 0x0125 }
            r10.zzk = r0     // Catch:{ all -> 0x0125 }
            goto L_0x0123
        L_0x011d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0125 }
            r0.<init>(r2)     // Catch:{ all -> 0x0125 }
            throw r0     // Catch:{ all -> 0x0125 }
        L_0x0123:
            monitor-exit(r10)     // Catch:{ all -> 0x0125 }
            goto L_0x0128
        L_0x0125:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0125 }
            throw r0
        L_0x0128:
            T r0 = r10.zzl
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzht.zze():java.lang.Object");
    }
}
