package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdcp implements zzdhe<zzdcq> {
    private final Context context;
    private final zzazs zzbqn;
    private final zzdpm zzfzg;
    private final zzdhe<zzdhh> zzhdk;

    public zzdcp(zzddz<zzdhh> zzddz, zzdpm zzdpm, Context context2, zzazs zzazs) {
        this.zzhdk = zzddz;
        this.zzfzg = zzdpm;
        this.context = context2;
        this.zzbqn = zzazs;
    }

    public final zzebt<zzdcq> zzatu() {
        return zzebh.zzb(this.zzhdk.zzatu(), new zzdcs(this), (Executor) zzbat.zzekj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdcq zza(zzdhh zzdhh) {
        boolean z;
        String str;
        int i;
        int i2;
        float f;
        String str2;
        int i3;
        int i4;
        int i5;
        DisplayMetrics displayMetrics;
        zzvt zzvt = this.zzfzg.zzbpy;
        if (zzvt.zzcis != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzvt zzvt2 : zzvt.zzcis) {
                if (!zzvt2.zzcit && !z2) {
                    str = zzvt2.zzadd;
                    z2 = true;
                }
                if (zzvt2.zzcit && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzvt.zzadd;
            z = zzvt.zzcit;
        }
        Resources resources = this.context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i2 = 0;
            i = 0;
        } else {
            float f2 = displayMetrics.density;
            int i6 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
            str2 = this.zzbqn.zzyl().zzzm();
            i2 = i6;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        if (zzvt.zzcis != null) {
            boolean z4 = false;
            for (zzvt zzvt3 : zzvt.zzcis) {
                if (zzvt3.zzcit) {
                    z4 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    if (zzvt3.width != -1 || f == 0.0f) {
                        i4 = zzvt3.width;
                    } else {
                        i4 = (int) (((float) zzvt3.widthPixels) / f);
                    }
                    sb.append(i4);
                    sb.append("x");
                    if (zzvt3.height == -2) {
                        if (f != 0.0f) {
                            i5 = (int) (((float) zzvt3.heightPixels) / f);
                            sb.append(i5);
                        }
                    }
                    i5 = zzvt3.height;
                    sb.append(i5);
                }
            }
            if (z4) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzdcq(zzvt, str, z, sb.toString(), f, i2, i, str2, this.zzfzg.zzhdn);
    }
}
