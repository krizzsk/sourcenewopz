package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzdwz {
    private static final HashMap<String, Class<?>> zzhxz = new HashMap<>();
    private final Context context;
    private final zzdwy zzhxl;
    private final zzduu zzhya;
    private zzdwn zzhyb;
    private final Object zzhyc = new Object();
    private final zzduv zzvx;

    public zzdwz(Context context2, zzdwy zzdwy, zzduv zzduv, zzduu zzduu) {
        this.context = context2;
        this.zzhxl = zzdwy;
        this.zzvx = zzduv;
        this.zzhya = zzduu;
    }

    private final synchronized Class<?> zza(zzdwm zzdwm) throws zzdww {
        if (zzdwm.zzazj() != null) {
            String zzdh = zzdwm.zzazj().zzdh();
            Class<?> cls = zzhxz.get(zzdh);
            if (cls != null) {
                return cls;
            }
            try {
                if (this.zzhya.zzb(zzdwm.zzazk())) {
                    File zzazl = zzdwm.zzazl();
                    if (!zzazl.exists()) {
                        zzazl.mkdirs();
                    }
                    Class<?> loadClass = new DexClassLoader(zzdwm.zzazk().getAbsolutePath(), zzazl.getAbsolutePath(), (String) null, this.context.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    zzhxz.put(zzdh, loadClass);
                    return loadClass;
                }
                throw new zzdww(2026, "VM did not pass signature verification");
            } catch (GeneralSecurityException e) {
                throw new zzdww(2026, (Throwable) e);
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e2) {
                throw new zzdww(2008, e2);
            }
        } else {
            throw new zzdww(4010, "mc");
        }
    }

    private final Object zza(Class<?> cls, zzdwm zzdwm) throws zzdww {
        try {
            return cls.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.context, "msa-r", zzdwm.zzazm(), null, new Bundle(), 2});
        } catch (Exception e) {
            throw new zzdww(2004, (Throwable) e);
        }
    }

    public final void zzb(zzdwm zzdwm) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzdwn zzdwn = new zzdwn(zza(zza(zzdwm), zzdwm), zzdwm, this.zzhxl, this.zzvx);
            if (zzdwn.zzazo()) {
                int zzazp = zzdwn.zzazp();
                if (zzazp == 0) {
                    synchronized (this.zzhyc) {
                        if (this.zzhyb != null) {
                            try {
                                this.zzhyb.close();
                            } catch (zzdww e) {
                                this.zzvx.zza(e.zzazt(), -1, (Exception) e);
                            }
                        }
                        this.zzhyb = zzdwn;
                    }
                    this.zzvx.zzh(3000, System.currentTimeMillis() - currentTimeMillis);
                    return;
                }
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(zzazp);
                throw new zzdww(4001, sb.toString());
            }
            throw new zzdww(4000, "init failed");
        } catch (zzdww e2) {
            this.zzvx.zza(e2.zzazt(), System.currentTimeMillis() - currentTimeMillis, (Exception) e2);
        } catch (Exception e3) {
            this.zzvx.zza(4010, System.currentTimeMillis() - currentTimeMillis, e3);
        }
    }

    public final zzdvb zzazu() {
        zzdwn zzdwn;
        synchronized (this.zzhyc) {
            zzdwn = this.zzhyb;
        }
        return zzdwn;
    }

    public final zzdwm zzazv() {
        synchronized (this.zzhyc) {
            if (this.zzhyb == null) {
                return null;
            }
            zzdwm zzazn = this.zzhyb.zzazn();
            return zzazn;
        }
    }
}
