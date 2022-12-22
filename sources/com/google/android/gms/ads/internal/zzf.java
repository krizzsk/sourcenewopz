package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzcv;
import com.google.android.gms.internal.ads.zzds;
import com.google.android.gms.internal.ads.zzduv;
import com.google.android.gms.internal.ads.zzdwb;
import com.google.android.gms.internal.ads.zzdwu;
import com.google.android.gms.internal.ads.zzdwx;
import com.google.android.gms.internal.ads.zzdy;
import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzww;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzf implements zzdy, Runnable {
    private Context context;
    private final List<Object[]> zzbpc = new Vector();
    private final AtomicReference<zzdy> zzbpd = new AtomicReference<>();
    private final AtomicReference<zzdy> zzbpe = new AtomicReference<>();
    private int zzbpf;
    private final boolean zzbpg;
    private final boolean zzbph;
    /* access modifiers changed from: private */
    public final Context zzbpi;
    private zzbar zzbpj;
    /* access modifiers changed from: private */
    public final zzbar zzbpk;
    private CountDownLatch zzbpl = new CountDownLatch(1);
    private final Executor zzvy;
    /* access modifiers changed from: private */
    public final zzduv zzxh;

    public zzf(Context context2, zzbar zzbar) {
        this.context = context2;
        this.zzbpi = context2;
        this.zzbpj = zzbar;
        this.zzbpk = zzbar;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        this.zzvy = newCachedThreadPool;
        this.zzxh = zzduv.zza(context2, newCachedThreadPool);
        this.zzbph = ((Boolean) zzww.zzra().zzd(zzabq.zzcsk)).booleanValue();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsn)).booleanValue()) {
            this.zzbpf = zzcv.zznp;
        } else {
            this.zzbpf = zzcv.zzno;
        }
        zzdwb zzdwb = new zzdwb(this.context, this.zzxh);
        zzi zzi = new zzi(this);
        this.zzbpg = new zzdwu(this.context, zzdwb.zzazf(), zzi, ((Boolean) zzww.zzra().zzd(zzabq.zzcsl)).booleanValue()).zzes(zzdwx.zzhxv);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzctc)).booleanValue()) {
            zzbat.zzeke.execute(this);
            return;
        }
        zzww.zzqw();
        if (zzbae.zzaaq()) {
            zzbat.zzeke.execute(this);
        } else {
            run();
        }
    }

    private final boolean zzkd() {
        try {
            this.zzbpl.await();
            return true;
        } catch (InterruptedException e) {
            zzd.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void zzke() {
        zzdy zzcb = zzcb();
        if (!this.zzbpc.isEmpty() && zzcb != null) {
            for (Object[] next : this.zzbpc) {
                if (next.length == 1) {
                    zzcb.zza((MotionEvent) next[0]);
                } else if (next.length == 3) {
                    zzcb.zza(((Integer) next[0]).intValue(), ((Integer) next[1]).intValue(), ((Integer) next[2]).intValue());
                }
            }
            this.zzbpc.clear();
        }
    }

    /* access modifiers changed from: private */
    public static Context zze(Context context2) {
        Context applicationContext = context2.getApplicationContext();
        return applicationContext == null ? context2 : applicationContext;
    }

    public final String zzb(Context context2) {
        zzdy zzcb;
        if (!zzkd() || (zzcb = zzcb()) == null) {
            return "";
        }
        zzke();
        return zzcb.zzb(zze(context2));
    }

    public final String zza(Context context2, View view, Activity activity) {
        zzdy zzcb = zzcb();
        return zzcb != null ? zzcb.zza(context2, view, activity) : "";
    }

    public final String zza(Context context2, String str, View view) {
        return zza(context2, str, view, (Activity) null);
    }

    public final String zza(Context context2, String str, View view, Activity activity) {
        zzdy zzcb;
        if (!zzkd() || (zzcb = zzcb()) == null) {
            return "";
        }
        zzke();
        return zzcb.zza(zze(context2), str, view, activity);
    }

    public final void zzb(View view) {
        zzdy zzcb = zzcb();
        if (zzcb != null) {
            zzcb.zzb(view);
        }
    }

    public final void zza(MotionEvent motionEvent) {
        zzdy zzcb = zzcb();
        if (zzcb != null) {
            zzke();
            zzcb.zza(motionEvent);
            return;
        }
        this.zzbpc.add(new Object[]{motionEvent});
    }

    public final void zza(int i, int i2, int i3) {
        zzdy zzcb = zzcb();
        if (zzcb != null) {
            zzke();
            zzcb.zza(i, i2, i3);
            return;
        }
        this.zzbpc.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void run() {
        long currentTimeMillis;
        boolean z = false;
        try {
            boolean z2 = this.zzbpj.zzekc;
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzcqe)).booleanValue() && z2) {
                z = true;
            }
            if (zzkf() == zzcv.zzno) {
                zza((zzdy) zzef.zzb(this.zzbpj.zzbrz, zze(this.context), z, this.zzbpf));
                if (this.zzbpf == zzcv.zznp) {
                    this.zzvy.execute(new zzh(this, z));
                }
            } else {
                currentTimeMillis = System.currentTimeMillis();
                this.zzbpe.set(zzds.zza(this.zzbpj.zzbrz, zze(this.context), z));
            }
        } catch (NullPointerException e) {
            this.zzbpf = zzcv.zzno;
            zza((zzdy) zzef.zzb(this.zzbpj.zzbrz, zze(this.context), z, this.zzbpf));
            this.zzxh.zza(2031, System.currentTimeMillis() - currentTimeMillis, (Exception) e);
        } catch (Throwable th) {
            this.zzbpl.countDown();
            this.context = null;
            this.zzbpj = null;
            throw th;
        }
        this.zzbpl.countDown();
        this.context = null;
        this.zzbpj = null;
    }

    private final zzdy zzcb() {
        if (zzkf() == zzcv.zznp) {
            return this.zzbpe.get();
        }
        return this.zzbpd.get();
    }

    private final void zza(zzdy zzdy) {
        this.zzbpd.set(zzdy);
    }

    private final int zzkf() {
        if (!this.zzbph || this.zzbpg) {
            return this.zzbpf;
        }
        return zzcv.zzno;
    }
}
