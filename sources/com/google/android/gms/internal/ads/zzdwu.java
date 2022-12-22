package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.util.Hex;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzdwu {
    private static final Object zzhxt = new Object();
    private final Context context;
    private final SharedPreferences zzcmn;
    private final String zzhxq;
    private final zzdwd zzhxr;
    private boolean zzhxs;

    public zzdwu(Context context2, zzgp zzgp, zzdwd zzdwd, boolean z) {
        this(context2, zzgp, zzdwd);
        this.zzhxs = z;
    }

    private zzdwu(Context context2, zzgp zzgp, zzdwd zzdwd) {
        this.zzhxs = false;
        this.context = context2;
        this.zzhxq = Integer.toString(zzgp.zzv());
        this.zzcmn = SystemUtils.getSharedPreferences(context2, "pcvmspf", 0);
        this.zzhxr = zzdwd;
    }

    public final zzdwm zzp(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzhxt) {
            zzgv zzer = zzer(i);
            if (zzer == null) {
                zza(4022, currentTimeMillis);
                return null;
            }
            File zzhk = zzhk(zzer.zzdh());
            File file = new File(zzhk, "pcam.jar");
            if (!file.exists()) {
                file = new File(zzhk, "pcam");
            }
            File file2 = new File(zzhk, "pcbc");
            File file3 = new File(zzhk, "pcopt");
            zza(5016, currentTimeMillis);
            zzdwm zzdwm = new zzdwm(zzer, file, file2, file3);
            return zzdwm;
        }
    }

    public final boolean zzes(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzhxt) {
            zzgv zzer = zzer(i);
            if (zzer == null) {
                zza(4025, currentTimeMillis);
                return false;
            }
            File zzhk = zzhk(zzer.zzdh());
            if (!new File(zzhk, "pcam.jar").exists()) {
                zza(4026, currentTimeMillis);
                return false;
            } else if (!new File(zzhk, "pcbc").exists()) {
                zza(4027, currentTimeMillis);
                return false;
            } else {
                zza(5019, currentTimeMillis);
                return true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b1 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzgr r17, com.google.android.gms.internal.ads.zzdwv r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Object r4 = zzhxt
            monitor-enter(r4)
            int r5 = com.google.android.gms.internal.ads.zzdwx.zzhxv     // Catch:{ all -> 0x018b }
            com.google.android.gms.internal.ads.zzgv r5 = r1.zzer(r5)     // Catch:{ all -> 0x018b }
            com.google.android.gms.internal.ads.zzgv r6 = r17.zzdd()     // Catch:{ all -> 0x018b }
            java.lang.String r6 = r6.zzdh()     // Catch:{ all -> 0x018b }
            r7 = 0
            if (r5 == 0) goto L_0x002d
            java.lang.String r5 = r5.zzdh()     // Catch:{ all -> 0x018b }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x018b }
            if (r5 == 0) goto L_0x002d
            r0 = 4014(0xfae, float:5.625E-42)
            r1.zza((int) r0, (long) r2)     // Catch:{ all -> 0x018b }
            monitor-exit(r4)     // Catch:{ all -> 0x018b }
            return r7
        L_0x002d:
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x018b }
            java.io.File r5 = r1.zzhk(r6)     // Catch:{ all -> 0x018b }
            boolean r10 = r5.exists()     // Catch:{ all -> 0x018b }
            r11 = 4015(0xfaf, float:5.626E-42)
            r12 = 1
            if (r10 == 0) goto L_0x0081
            r10 = 4023(0xfb7, float:5.637E-42)
            boolean r13 = r5.isDirectory()     // Catch:{ all -> 0x018b }
            if (r13 == 0) goto L_0x0049
            java.lang.String r13 = "1"
            goto L_0x004b
        L_0x0049:
            java.lang.String r13 = "0"
        L_0x004b:
            boolean r5 = r5.isFile()     // Catch:{ all -> 0x018b }
            if (r5 == 0) goto L_0x0054
            java.lang.String r5 = "1"
            goto L_0x0056
        L_0x0054:
            java.lang.String r5 = "0"
        L_0x0056:
            int r14 = r13.length()     // Catch:{ all -> 0x018b }
            int r14 = r14 + 5
            int r15 = r5.length()     // Catch:{ all -> 0x018b }
            int r14 = r14 + r15
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x018b }
            r15.<init>(r14)     // Catch:{ all -> 0x018b }
            java.lang.String r14 = "d:"
            r15.append(r14)     // Catch:{ all -> 0x018b }
            r15.append(r13)     // Catch:{ all -> 0x018b }
            java.lang.String r13 = ",f:"
            r15.append(r13)     // Catch:{ all -> 0x018b }
            r15.append(r5)     // Catch:{ all -> 0x018b }
            java.lang.String r5 = r15.toString()     // Catch:{ all -> 0x018b }
            r1.zza(r10, r8, r5)     // Catch:{ all -> 0x018b }
            r1.zza((int) r11, (long) r8)     // Catch:{ all -> 0x018b }
            goto L_0x00ae
        L_0x0081:
            boolean r10 = r5.mkdirs()     // Catch:{ all -> 0x018b }
            if (r10 != 0) goto L_0x00ae
            r10 = 4024(0xfb8, float:5.639E-42)
            java.lang.String r13 = "cw:"
            boolean r5 = r5.canWrite()     // Catch:{ all -> 0x018b }
            if (r5 == 0) goto L_0x0094
            java.lang.String r5 = "1"
            goto L_0x0096
        L_0x0094:
            java.lang.String r5 = "0"
        L_0x0096:
            int r14 = r5.length()     // Catch:{ all -> 0x018b }
            if (r14 == 0) goto L_0x00a1
            java.lang.String r5 = r13.concat(r5)     // Catch:{ all -> 0x018b }
            goto L_0x00a6
        L_0x00a1:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x018b }
            r5.<init>(r13)     // Catch:{ all -> 0x018b }
        L_0x00a6:
            r1.zza(r10, r8, r5)     // Catch:{ all -> 0x018b }
            r1.zza((int) r11, (long) r8)     // Catch:{ all -> 0x018b }
            r5 = 0
            goto L_0x00af
        L_0x00ae:
            r5 = 1
        L_0x00af:
            if (r5 != 0) goto L_0x00b3
            monitor-exit(r4)     // Catch:{ all -> 0x018b }
            return r7
        L_0x00b3:
            java.io.File r5 = r1.zzhk(r6)     // Catch:{ all -> 0x018b }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x018b }
            java.lang.String r8 = "pcam.jar"
            r6.<init>(r5, r8)     // Catch:{ all -> 0x018b }
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x018b }
            java.lang.String r9 = "pcbc"
            r8.<init>(r5, r9)     // Catch:{ all -> 0x018b }
            com.google.android.gms.internal.ads.zzelq r9 = r17.zzde()     // Catch:{ all -> 0x018b }
            byte[] r9 = r9.toByteArray()     // Catch:{ all -> 0x018b }
            boolean r9 = com.google.android.gms.internal.ads.zzdwo.zza((java.io.File) r6, (byte[]) r9)     // Catch:{ all -> 0x018b }
            if (r9 != 0) goto L_0x00da
            r0 = 4016(0xfb0, float:5.628E-42)
            r1.zza((int) r0, (long) r2)     // Catch:{ all -> 0x018b }
            monitor-exit(r4)     // Catch:{ all -> 0x018b }
            return r7
        L_0x00da:
            com.google.android.gms.internal.ads.zzelq r9 = r17.zzdf()     // Catch:{ all -> 0x018b }
            byte[] r9 = r9.toByteArray()     // Catch:{ all -> 0x018b }
            boolean r8 = com.google.android.gms.internal.ads.zzdwo.zza((java.io.File) r8, (byte[]) r9)     // Catch:{ all -> 0x018b }
            if (r8 != 0) goto L_0x00ef
            r0 = 4017(0xfb1, float:5.629E-42)
            r1.zza((int) r0, (long) r2)     // Catch:{ all -> 0x018b }
            monitor-exit(r4)     // Catch:{ all -> 0x018b }
            return r7
        L_0x00ef:
            if (r0 == 0) goto L_0x0101
            boolean r0 = r0.zzb(r6)     // Catch:{ all -> 0x018b }
            if (r0 != 0) goto L_0x0101
            r0 = 4018(0xfb2, float:5.63E-42)
            r1.zza((int) r0, (long) r2)     // Catch:{ all -> 0x018b }
            com.google.android.gms.internal.ads.zzdwo.zze(r5)     // Catch:{ all -> 0x018b }
            monitor-exit(r4)     // Catch:{ all -> 0x018b }
            return r7
        L_0x0101:
            java.lang.String r0 = zzb(r17)     // Catch:{ all -> 0x018b }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x018b }
            android.content.SharedPreferences r8 = r1.zzcmn     // Catch:{ all -> 0x018b }
            java.lang.String r9 = r16.zzazs()     // Catch:{ all -> 0x018b }
            r10 = 0
            java.lang.String r8 = r8.getString(r9, r10)     // Catch:{ all -> 0x018b }
            android.content.SharedPreferences r9 = r1.zzcmn     // Catch:{ all -> 0x018b }
            android.content.SharedPreferences$Editor r9 = r9.edit()     // Catch:{ all -> 0x018b }
            java.lang.String r10 = r16.zzazs()     // Catch:{ all -> 0x018b }
            r9.putString(r10, r0)     // Catch:{ all -> 0x018b }
            if (r8 == 0) goto L_0x012a
            java.lang.String r0 = r16.zzazr()     // Catch:{ all -> 0x018b }
            r9.putString(r0, r8)     // Catch:{ all -> 0x018b }
        L_0x012a:
            boolean r0 = r9.commit()     // Catch:{ all -> 0x018b }
            if (r0 != 0) goto L_0x0135
            r8 = 4019(0xfb3, float:5.632E-42)
            r1.zza((int) r8, (long) r5)     // Catch:{ all -> 0x018b }
        L_0x0135:
            if (r0 != 0) goto L_0x0139
            monitor-exit(r4)     // Catch:{ all -> 0x018b }
            return r7
        L_0x0139:
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x018b }
            r0.<init>()     // Catch:{ all -> 0x018b }
            int r5 = com.google.android.gms.internal.ads.zzdwx.zzhxv     // Catch:{ all -> 0x018b }
            com.google.android.gms.internal.ads.zzgv r5 = r1.zzer(r5)     // Catch:{ all -> 0x018b }
            if (r5 == 0) goto L_0x014d
            java.lang.String r5 = r5.zzdh()     // Catch:{ all -> 0x018b }
            r0.add(r5)     // Catch:{ all -> 0x018b }
        L_0x014d:
            int r5 = com.google.android.gms.internal.ads.zzdwx.zzhxw     // Catch:{ all -> 0x018b }
            com.google.android.gms.internal.ads.zzgv r5 = r1.zzer(r5)     // Catch:{ all -> 0x018b }
            if (r5 == 0) goto L_0x015c
            java.lang.String r5 = r5.zzdh()     // Catch:{ all -> 0x018b }
            r0.add(r5)     // Catch:{ all -> 0x018b }
        L_0x015c:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x018b }
            android.content.Context r6 = r1.context     // Catch:{ all -> 0x018b }
            java.lang.String r8 = "pccache"
            java.io.File r6 = r6.getDir(r8, r7)     // Catch:{ all -> 0x018b }
            java.lang.String r8 = r1.zzhxq     // Catch:{ all -> 0x018b }
            r5.<init>(r6, r8)     // Catch:{ all -> 0x018b }
            java.io.File[] r5 = r5.listFiles()     // Catch:{ all -> 0x018b }
            int r6 = r5.length     // Catch:{ all -> 0x018b }
        L_0x0170:
            if (r7 >= r6) goto L_0x0184
            r8 = r5[r7]     // Catch:{ all -> 0x018b }
            java.lang.String r9 = r8.getName()     // Catch:{ all -> 0x018b }
            boolean r9 = r0.contains(r9)     // Catch:{ all -> 0x018b }
            if (r9 != 0) goto L_0x0181
            com.google.android.gms.internal.ads.zzdwo.zze(r8)     // Catch:{ all -> 0x018b }
        L_0x0181:
            int r7 = r7 + 1
            goto L_0x0170
        L_0x0184:
            r0 = 5014(0x1396, float:7.026E-42)
            r1.zza((int) r0, (long) r2)     // Catch:{ all -> 0x018b }
            monitor-exit(r4)     // Catch:{ all -> 0x018b }
            return r12
        L_0x018b:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x018b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwu.zza(com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzdwv):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzgr r7) {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Object r2 = zzhxt
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzgv r3 = r7.zzdd()     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = r3.zzdh()     // Catch:{ all -> 0x0054 }
            java.io.File r3 = r6.zzhk(r3)     // Catch:{ all -> 0x0054 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "pcbc"
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzelq r3 = r7.zzdf()     // Catch:{ all -> 0x0054 }
            byte[] r3 = r3.toByteArray()     // Catch:{ all -> 0x0054 }
            boolean r3 = com.google.android.gms.internal.ads.zzdwo.zza((java.io.File) r4, (byte[]) r3)     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x0030
            r7 = 4020(0xfb4, float:5.633E-42)
            r6.zza((int) r7, (long) r0)     // Catch:{ all -> 0x0054 }
            r7 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            return r7
        L_0x0030:
            java.lang.String r7 = zzb(r7)     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences r3 = r6.zzcmn     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r6.zzazs()     // Catch:{ all -> 0x0054 }
            r3.putString(r4, r7)     // Catch:{ all -> 0x0054 }
            boolean r7 = r3.commit()     // Catch:{ all -> 0x0054 }
            if (r7 == 0) goto L_0x004d
            r3 = 5015(0x1397, float:7.028E-42)
            r6.zza((int) r3, (long) r0)     // Catch:{ all -> 0x0054 }
            goto L_0x0052
        L_0x004d:
            r3 = 4021(0xfb5, float:5.635E-42)
            r6.zza((int) r3, (long) r0)     // Catch:{ all -> 0x0054 }
        L_0x0052:
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            return r7
        L_0x0054:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwu.zza(com.google.android.gms.internal.ads.zzgr):boolean");
    }

    private final zzgv zzer(int i) {
        String str;
        zzemn zzemn;
        if (i == zzdwx.zzhxv) {
            str = this.zzcmn.getString(zzazs(), (String) null);
        } else {
            str = i == zzdwx.zzhxw ? this.zzcmn.getString(zzazr(), (String) null) : null;
        }
        if (str == null) {
            return null;
        }
        try {
            zzelq zzt = zzelq.zzt(Hex.stringToBytes(str));
            if (this.zzhxs) {
                zzemn = zzemn.zzbiv();
            } else {
                zzemn = zzemn.zzbiw();
            }
            return zzgv.zzb(zzt, zzemn);
        } catch (zzenn unused) {
            return null;
        } catch (NullPointerException unused2) {
            zza(2029, System.currentTimeMillis());
            return null;
        }
    }

    private final File zzhk(String str) {
        return new File(new File(this.context.getDir("pccache", 0), this.zzhxq), str);
    }

    private final String zzazr() {
        String valueOf = String.valueOf(this.zzhxq);
        return valueOf.length() != 0 ? "FBAMTD".concat(valueOf) : new String("FBAMTD");
    }

    private final String zzazs() {
        String valueOf = String.valueOf(this.zzhxq);
        return valueOf.length() != 0 ? "LATMTD".concat(valueOf) : new String("LATMTD");
    }

    private static String zzb(zzgr zzgr) {
        return Hex.bytesToStringLowercase(((zzgv) ((zzena) zzgv.zzdm().zzav(zzgr.zzdd().zzdh()).zzaw(zzgr.zzdd().zzdi()).zzdk(zzgr.zzdd().zzdk()).zzdl(zzgr.zzdd().zzdl()).zzdj(zzgr.zzdd().zzdj()).zzbjv())).zzbgy().toByteArray());
    }

    private final void zza(int i, long j) {
        zzdwd zzdwd = this.zzhxr;
        if (zzdwd != null) {
            zzdwd.zza(i, j);
        }
    }

    private final void zza(int i, long j, String str) {
        zzdwd zzdwd = this.zzhxr;
        if (zzdwd != null) {
            zzdwd.zza(i, j, str);
        }
    }
}
