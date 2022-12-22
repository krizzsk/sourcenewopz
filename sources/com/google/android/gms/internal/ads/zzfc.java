package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Pair;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzcf;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzfc {
    private static final String TAG = zzfc.class.getSimpleName();
    protected Context context;
    private volatile boolean zzxk;
    private zzfa zzyu;
    private ExecutorService zzzd;
    private DexClassLoader zzze;
    private zzek zzzf;
    private byte[] zzzg;
    private volatile AdvertisingIdClient zzzh = null;
    private Future zzzi;
    private boolean zzzj;
    /* access modifiers changed from: private */
    public volatile zzcf.zza zzzk;
    private Future zzzl;
    private zzdw zzzm;
    private boolean zzzn;
    private boolean zzzo;
    private Map<Pair<String, String>, zzgl> zzzp;
    private boolean zzzq;

    /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|(1:4)|5|6|7|8|(1:10)(1:11)|12|(1:14)(1:15)|16|17|18|(2:20|(1:22)(2:23|24))|25|26|27|28|29|(2:31|(1:33)(2:34|35))|36|(1:38)|39|40|41|42|43|44|45|66) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004d */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056 A[Catch:{ zzej -> 0x012f, zzev -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087 A[Catch:{ all -> 0x00fe, FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2 A[Catch:{ all -> 0x00fe, FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfc zza(android.content.Context r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.String r0 = "%s/%s.dex"
            com.google.android.gms.internal.ads.zzfc r1 = new com.google.android.gms.internal.ads.zzfc
            r1.<init>(r9)
            com.google.android.gms.internal.ads.zzfb r9 = new com.google.android.gms.internal.ads.zzfb     // Catch:{ zzev -> 0x0136 }
            r9.<init>()     // Catch:{ zzev -> 0x0136 }
            java.util.concurrent.ExecutorService r9 = java.util.concurrent.Executors.newCachedThreadPool(r9)     // Catch:{ zzev -> 0x0136 }
            r1.zzzd = r9     // Catch:{ zzev -> 0x0136 }
            r1.zzxk = r12     // Catch:{ zzev -> 0x0136 }
            if (r12 == 0) goto L_0x0023
            java.util.concurrent.ExecutorService r9 = r1.zzzd     // Catch:{ zzev -> 0x0136 }
            com.google.android.gms.internal.ads.zzfe r12 = new com.google.android.gms.internal.ads.zzfe     // Catch:{ zzev -> 0x0136 }
            r12.<init>(r1)     // Catch:{ zzev -> 0x0136 }
            java.util.concurrent.Future r9 = r9.submit(r12)     // Catch:{ zzev -> 0x0136 }
            r1.zzzi = r9     // Catch:{ zzev -> 0x0136 }
        L_0x0023:
            java.util.concurrent.ExecutorService r9 = r1.zzzd     // Catch:{ zzev -> 0x0136 }
            com.google.android.gms.internal.ads.zzfg r12 = new com.google.android.gms.internal.ads.zzfg     // Catch:{ zzev -> 0x0136 }
            r12.<init>(r1)     // Catch:{ zzev -> 0x0136 }
            r9.execute(r12)     // Catch:{ zzev -> 0x0136 }
            r9 = 1
            r12 = 0
            com.google.android.gms.common.GoogleApiAvailabilityLight r2 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()     // Catch:{ all -> 0x004d }
            android.content.Context r3 = r1.context     // Catch:{ all -> 0x004d }
            int r3 = r2.getApkVersion(r3)     // Catch:{ all -> 0x004d }
            if (r3 <= 0) goto L_0x003d
            r3 = 1
            goto L_0x003e
        L_0x003d:
            r3 = 0
        L_0x003e:
            r1.zzzn = r3     // Catch:{ all -> 0x004d }
            android.content.Context r3 = r1.context     // Catch:{ all -> 0x004d }
            int r2 = r2.isGooglePlayServicesAvailable(r3)     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x004a
            r2 = 1
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            r1.zzzo = r2     // Catch:{ all -> 0x004d }
        L_0x004d:
            r1.zza((int) r12, (boolean) r9)     // Catch:{ zzev -> 0x0136 }
            boolean r2 = com.google.android.gms.internal.ads.zzfh.isMainThread()     // Catch:{ zzev -> 0x0136 }
            if (r2 == 0) goto L_0x0071
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabq.zzctb     // Catch:{ zzev -> 0x0136 }
            com.google.android.gms.internal.ads.zzabm r3 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ zzev -> 0x0136 }
            java.lang.Object r2 = r3.zzd(r2)     // Catch:{ zzev -> 0x0136 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ zzev -> 0x0136 }
            boolean r2 = r2.booleanValue()     // Catch:{ zzev -> 0x0136 }
            if (r2 != 0) goto L_0x0069
            goto L_0x0071
        L_0x0069:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ zzev -> 0x0136 }
            java.lang.String r10 = "Task Context initialization must not be called from the UI thread."
            r9.<init>(r10)     // Catch:{ zzev -> 0x0136 }
            throw r9     // Catch:{ zzev -> 0x0136 }
        L_0x0071:
            com.google.android.gms.internal.ads.zzek r2 = new com.google.android.gms.internal.ads.zzek     // Catch:{ zzev -> 0x0136 }
            r3 = 0
            r2.<init>(r3)     // Catch:{ zzev -> 0x0136 }
            r1.zzzf = r2     // Catch:{ zzev -> 0x0136 }
            byte[] r10 = r2.zzao(r10)     // Catch:{ zzej -> 0x012f }
            r1.zzzg = r10     // Catch:{ zzej -> 0x012f }
            android.content.Context r10 = r1.context     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            java.io.File r10 = r10.getCacheDir()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            if (r10 != 0) goto L_0x0098
            android.content.Context r10 = r1.context     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r2 = "dex"
            java.io.File r10 = r10.getDir(r2, r12)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            if (r10 == 0) goto L_0x0092
            goto L_0x0098
        L_0x0092:
            com.google.android.gms.internal.ads.zzev r9 = new com.google.android.gms.internal.ads.zzev     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            throw r9     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
        L_0x0098:
            java.lang.String r2 = "1610724645094"
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r5 = "%s/%s.jar"
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r7[r12] = r10     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r7[r9] = r2     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r5 = java.lang.String.format(r5, r7)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            boolean r5 = r4.exists()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            if (r5 != 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zzek r5 = r1.zzzf     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            byte[] r7 = r1.zzzg     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            byte[] r11 = r5.zza(r7, r11)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r4.createNewFile()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            int r7 = r11.length     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r5.write(r11, r12, r7)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r5.close()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
        L_0x00c9:
            r1.zzb((java.io.File) r10, (java.lang.String) r2)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            dalvik.system.DexClassLoader r11 = new dalvik.system.DexClassLoader     // Catch:{ all -> 0x00fe }
            java.lang.String r5 = r4.getAbsolutePath()     // Catch:{ all -> 0x00fe }
            java.lang.String r7 = r10.getAbsolutePath()     // Catch:{ all -> 0x00fe }
            android.content.Context r8 = r1.context     // Catch:{ all -> 0x00fe }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ all -> 0x00fe }
            r11.<init>(r5, r7, r3, r8)     // Catch:{ all -> 0x00fe }
            r1.zzze = r11     // Catch:{ all -> 0x00fe }
            zzc(r4)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r1.zza((java.io.File) r10, (java.lang.String) r2)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r11[r12] = r10     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r11[r9] = r2     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r10 = java.lang.String.format(r0, r11)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            zzap(r10)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            com.google.android.gms.internal.ads.zzdw r10 = new com.google.android.gms.internal.ads.zzdw     // Catch:{ zzev -> 0x0136 }
            r10.<init>(r1)     // Catch:{ zzev -> 0x0136 }
            r1.zzzm = r10     // Catch:{ zzev -> 0x0136 }
            r1.zzzq = r9     // Catch:{ zzev -> 0x0136 }
            goto L_0x0136
        L_0x00fe:
            r11 = move-exception
            zzc(r4)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r1.zza((java.io.File) r10, (java.lang.String) r2)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r3[r12] = r10     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            r3[r9] = r2     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r9 = java.lang.String.format(r0, r3)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            zzap(r9)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
            throw r11     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzej -> 0x011a, NullPointerException -> 0x0113 }
        L_0x0113:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzev r10 = new com.google.android.gms.internal.ads.zzev     // Catch:{ zzev -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzev -> 0x0136 }
            throw r10     // Catch:{ zzev -> 0x0136 }
        L_0x011a:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzev r10 = new com.google.android.gms.internal.ads.zzev     // Catch:{ zzev -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzev -> 0x0136 }
            throw r10     // Catch:{ zzev -> 0x0136 }
        L_0x0121:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzev r10 = new com.google.android.gms.internal.ads.zzev     // Catch:{ zzev -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzev -> 0x0136 }
            throw r10     // Catch:{ zzev -> 0x0136 }
        L_0x0128:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzev r10 = new com.google.android.gms.internal.ads.zzev     // Catch:{ zzev -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzev -> 0x0136 }
            throw r10     // Catch:{ zzev -> 0x0136 }
        L_0x012f:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzev r10 = new com.google.android.gms.internal.ads.zzev     // Catch:{ zzev -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzev -> 0x0136 }
            throw r10     // Catch:{ zzev -> 0x0136 }
        L_0x0136:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfc.zza(android.content.Context, java.lang.String, java.lang.String, boolean):com.google.android.gms.internal.ads.zzfc");
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean isInitialized() {
        return this.zzzq;
    }

    public final ExecutorService zzch() {
        return this.zzzd;
    }

    public final DexClassLoader zzci() {
        return this.zzze;
    }

    public final zzek zzcj() {
        return this.zzzf;
    }

    public final byte[] zzck() {
        return this.zzzg;
    }

    public final boolean zzcl() {
        return this.zzzn;
    }

    public final zzdw zzcm() {
        return this.zzzm;
    }

    public final boolean zzcn() {
        return this.zzzo;
    }

    public final boolean zzcg() {
        return this.zzyu.zzcg();
    }

    /* access modifiers changed from: package-private */
    public final zzfa zzco() {
        return this.zzyu;
    }

    public final zzcf.zza zzcp() {
        return this.zzzk;
    }

    public final Future zzcq() {
        return this.zzzl;
    }

    private zzfc(Context context2) {
        boolean z = false;
        this.zzxk = false;
        this.zzzi = null;
        this.zzzk = null;
        this.zzzl = null;
        this.zzzn = false;
        this.zzzo = false;
        this.zzzq = false;
        Context applicationContext = context2.getApplicationContext();
        z = applicationContext != null ? true : z;
        this.zzzj = z;
        this.context = z ? applicationContext : context2;
        this.zzzp = new HashMap();
        if (this.zzyu == null) {
            this.zzyu = new zzfa(this.context);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:20|21|22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00c0 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d4 A[SYNTHETIC, Splitter:B:42:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00db A[SYNTHETIC, Splitter:B:46:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e5 A[SYNTHETIC, Splitter:B:54:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ec A[SYNTHETIC, Splitter:B:58:0x00ec] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "test"
            java.io.File r1 = new java.io.File
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r10
            r5 = 1
            r3[r5] = r11
            java.lang.String r6 = "%s/%s.tmp"
            java.lang.String r3 = java.lang.String.format(r6, r3)
            r1.<init>(r3)
            boolean r3 = r1.exists()
            if (r3 == 0) goto L_0x001d
            return
        L_0x001d:
            java.io.File r3 = new java.io.File
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r10
            r2[r5] = r11
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r2)
            r3.<init>(r10)
            boolean r10 = r3.exists()
            if (r10 != 0) goto L_0x0035
            return
        L_0x0035:
            long r5 = r3.length()
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 > 0) goto L_0x0040
            return
        L_0x0040:
            int r10 = (int) r5
            byte[] r10 = new byte[r10]
            r2 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00d0 }
            r5.<init>(r3)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00d0 }
            int r6 = r5.read(r10)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            if (r6 > 0) goto L_0x0056
            r5.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            zzc(r3)
            return
        L_0x0056:
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r6.print(r0)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r6.print(r0)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r6.print(r0)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r0 = com.google.android.gms.internal.ads.zzcf.zzc.zzbf()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzelq r6 = com.google.android.gms.internal.ads.zzelq.zzt(r6)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r0 = r0.zzh(r6)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r11 = r11.getBytes()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzelq r11 = com.google.android.gms.internal.ads.zzelq.zzt(r11)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r11 = r0.zzg(r11)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzek r0 = r9.zzzf     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r6 = r9.zzzg     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.lang.String r10 = r0.zzb(r6, r10)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r10 = r10.getBytes()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzelq r0 = com.google.android.gms.internal.ads.zzelq.zzt(r10)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzcf$zzc$zza r0 = r11.zze(r0)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r10 = com.google.android.gms.internal.ads.zzda.zzb(r10)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzelq r10 = com.google.android.gms.internal.ads.zzelq.zzt(r10)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r0.zzf(r10)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r1.createNewFile()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r10.<init>(r1)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzeon r11 = r11.zzbjv()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzena r11 = (com.google.android.gms.internal.ads.zzena) r11     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzcf$zzc r11 = (com.google.android.gms.internal.ads.zzcf.zzc) r11     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            int r0 = r11.length     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            r10.write(r11, r4, r0)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            r10.close()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            r5.close()     // Catch:{ IOException -> 0x00c0 }
        L_0x00c0:
            r10.close()     // Catch:{ IOException -> 0x00c3 }
        L_0x00c3:
            zzc(r3)
            return
        L_0x00c7:
            r11 = move-exception
            goto L_0x00cb
        L_0x00c9:
            r11 = move-exception
            r10 = r2
        L_0x00cb:
            r2 = r5
            goto L_0x00d2
        L_0x00cd:
            r10 = r2
        L_0x00ce:
            r2 = r5
            goto L_0x00e3
        L_0x00d0:
            r11 = move-exception
            r10 = r2
        L_0x00d2:
            if (r2 == 0) goto L_0x00d9
            r2.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00d9
        L_0x00d8:
        L_0x00d9:
            if (r10 == 0) goto L_0x00de
            r10.close()     // Catch:{ IOException -> 0x00de }
        L_0x00de:
            zzc(r3)
            throw r11
        L_0x00e2:
            r10 = r2
        L_0x00e3:
            if (r2 == 0) goto L_0x00ea
            r2.close()     // Catch:{ IOException -> 0x00e9 }
            goto L_0x00ea
        L_0x00e9:
        L_0x00ea:
            if (r10 == 0) goto L_0x00ef
            r10.close()     // Catch:{ IOException -> 0x00ef }
        L_0x00ef:
            zzc(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfc.zza(java.io.File, java.lang.String):void");
    }

    private static void zzap(String str) {
        zzc(new File(str));
    }

    private static void zzc(File file) {
        if (!file.exists()) {
            SystemUtils.log(3, TAG, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}), (Throwable) null, "com.google.android.gms.internal.ads.zzfc", 174);
            return;
        }
        file.delete();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:31|32|33|34|35|36|37|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e3, code lost:
        r15 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e4, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e7, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00d2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00df */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[ExcHandler: zzej | IOException | NoSuchAlgorithmException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:13:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ee A[SYNTHETIC, Splitter:B:61:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f5 A[SYNTHETIC, Splitter:B:65:0x00f5] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00fc A[SYNTHETIC, Splitter:B:72:0x00fc] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0103 A[SYNTHETIC, Splitter:B:76:0x0103] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(java.io.File r14, java.lang.String r15) {
        /*
            r13 = this;
            java.io.File r0 = new java.io.File
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r14
            r4 = 1
            r2[r4] = r15
            java.lang.String r5 = "%s/%s.tmp"
            java.lang.String r2 = java.lang.String.format(r5, r2)
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x001b
            return r3
        L_0x001b:
            java.io.File r2 = new java.io.File
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r14
            r1[r4] = r15
            java.lang.String r14 = "%s/%s.dex"
            java.lang.String r14 = java.lang.String.format(r14, r1)
            r2.<init>(r14)
            boolean r14 = r2.exists()
            if (r14 == 0) goto L_0x0033
            return r3
        L_0x0033:
            r14 = 0
            long r5 = r0.length()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00f9, all -> 0x00ea }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x0042
            zzc(r0)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00f9, all -> 0x00ea }
            return r3
        L_0x0042:
            int r1 = (int) r5     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00f9, all -> 0x00ea }
            byte[] r1 = new byte[r1]     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00f9, all -> 0x00ea }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00f9, all -> 0x00ea }
            r5.<init>(r0)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00f9, all -> 0x00ea }
            int r6 = r5.read(r1)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            if (r6 > 0) goto L_0x0064
            java.lang.String r8 = TAG     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            java.lang.String r9 = "Cannot read the cache data."
            r7 = 3
            r10 = 0
            java.lang.String r11 = "com.google.android.gms.internal.ads.zzfc"
            r12 = 194(0xc2, float:2.72E-43)
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            zzc(r0)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            r5.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0063:
            return r3
        L_0x0064:
            com.google.android.gms.internal.ads.zzemn r6 = com.google.android.gms.internal.ads.zzemn.zzbiv()     // Catch:{ NullPointerException -> 0x00df, zzej | IOException | NoSuchAlgorithmException -> 0x00e7, zzej | IOException | NoSuchAlgorithmException -> 0x00e7 }
            com.google.android.gms.internal.ads.zzcf$zzc r1 = com.google.android.gms.internal.ads.zzcf.zzc.zzb((byte[]) r1, (com.google.android.gms.internal.ads.zzemn) r6)     // Catch:{ NullPointerException -> 0x00df, zzej | IOException | NoSuchAlgorithmException -> 0x00e7, zzej | IOException | NoSuchAlgorithmException -> 0x00e7 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            com.google.android.gms.internal.ads.zzelq r7 = r1.zzbd()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            byte[] r7 = r7.toByteArray()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            r6.<init>(r7)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            boolean r15 = r15.equals(r6)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            if (r15 == 0) goto L_0x00d8
            com.google.android.gms.internal.ads.zzelq r15 = r1.zzbc()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            byte[] r15 = r15.toByteArray()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            com.google.android.gms.internal.ads.zzelq r6 = r1.zzbb()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            byte[] r6 = r6.toByteArray()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            byte[] r6 = com.google.android.gms.internal.ads.zzda.zzb(r6)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            boolean r15 = java.util.Arrays.equals(r15, r6)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            if (r15 == 0) goto L_0x00d8
            com.google.android.gms.internal.ads.zzelq r15 = r1.zzbe()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            byte[] r15 = r15.toByteArray()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            boolean r15 = java.util.Arrays.equals(r15, r6)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            if (r15 != 0) goto L_0x00ae
            goto L_0x00d8
        L_0x00ae:
            com.google.android.gms.internal.ads.zzek r15 = r13.zzzf     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            byte[] r0 = r13.zzzg     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            com.google.android.gms.internal.ads.zzelq r1 = r1.zzbb()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            byte[] r1 = r1.toByteArray()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            r6.<init>(r1)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            byte[] r15 = r15.zza(r0, r6)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            r2.createNewFile()     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            r0.<init>(r2)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            int r14 = r15.length     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e8, all -> 0x00d6 }
            r0.write(r15, r3, r14)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e8, all -> 0x00d6 }
            r5.close()     // Catch:{ IOException -> 0x00d2 }
        L_0x00d2:
            r0.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x00d5:
            return r4
        L_0x00d6:
            r15 = move-exception
            goto L_0x00e5
        L_0x00d8:
            zzc(r0)     // Catch:{ zzej | IOException | NoSuchAlgorithmException -> 0x00e7, all -> 0x00e3 }
            r5.close()     // Catch:{ IOException -> 0x00de }
        L_0x00de:
            return r3
        L_0x00df:
            r5.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x00e2:
            return r3
        L_0x00e3:
            r15 = move-exception
            r0 = r14
        L_0x00e5:
            r14 = r5
            goto L_0x00ec
        L_0x00e7:
            r0 = r14
        L_0x00e8:
            r14 = r5
            goto L_0x00fa
        L_0x00ea:
            r15 = move-exception
            r0 = r14
        L_0x00ec:
            if (r14 == 0) goto L_0x00f3
            r14.close()     // Catch:{ IOException -> 0x00f2 }
            goto L_0x00f3
        L_0x00f2:
        L_0x00f3:
            if (r0 == 0) goto L_0x00f8
            r0.close()     // Catch:{ IOException -> 0x00f8 }
        L_0x00f8:
            throw r15
        L_0x00f9:
            r0 = r14
        L_0x00fa:
            if (r14 == 0) goto L_0x0101
            r14.close()     // Catch:{ IOException -> 0x0100 }
            goto L_0x0101
        L_0x0100:
        L_0x0101:
            if (r0 == 0) goto L_0x0106
            r0.close()     // Catch:{ IOException -> 0x0106 }
        L_0x0106:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfc.zzb(java.io.File, java.lang.String):boolean");
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzzp.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzzp.put(new Pair(str, str2), new zzgl(this, str, str2, clsArr));
        return true;
    }

    public final Method zza(String str, String str2) {
        zzgl zzgl = this.zzzp.get(new Pair(str, str2));
        if (zzgl == null) {
            return null;
        }
        return zzgl.zzdc();
    }

    /* access modifiers changed from: private */
    public final void zzcr() {
        try {
            if (this.zzzh == null && this.zzzj) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.context);
                advertisingIdClient.start();
                this.zzzh = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzzh = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, boolean z) {
        if (this.zzzo) {
            Future<?> submit = this.zzzd.submit(new zzfd(this, i, z));
            if (i == 0) {
                this.zzzl = submit;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzcf.zza zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep((long) (i * 1000));
            } catch (InterruptedException unused) {
            }
        }
        return zzcs();
    }

    /* access modifiers changed from: private */
    public static boolean zza(int i, zzcf.zza zza) {
        if (i >= 4) {
            return false;
        }
        if (zza != null && zza.zzai() && !zza.zzaf().equals("0000000000000000000000000000000000000000000000000000000000000000") && zza.zzan() && zza.zzao().zzbh() && zza.zzao().zzbi() != -2) {
            return false;
        }
        return true;
    }

    private final zzcf.zza zzcs() {
        try {
            return zzdvf.zzj(this.context, this.context.getPackageName(), Integer.toString(SystemUtils.getPackageInfo(this.context.getPackageManager(), this.context.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final AdvertisingIdClient zzct() {
        if (!this.zzxk) {
            return null;
        }
        if (this.zzzh != null) {
            return this.zzzh;
        }
        Future future = this.zzzi;
        if (future != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.zzzi = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzzi.cancel(true);
            }
        }
        return this.zzzh;
    }

    public final int zzbv() {
        if (this.zzzm != null) {
            return zzdw.zzbv();
        }
        return Integer.MIN_VALUE;
    }
}
