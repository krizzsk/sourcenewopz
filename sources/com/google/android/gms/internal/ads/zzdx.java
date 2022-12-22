package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzcb;
import com.google.android.gms.internal.ads.zzcf;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzdx implements zzdy {
    protected static volatile zzfc zzwh;
    protected MotionEvent zzwm;
    protected LinkedList<MotionEvent> zzwn = new LinkedList<>();
    protected long zzwo = 0;
    protected long zzwp = 0;
    protected long zzwq = 0;
    protected long zzwr = 0;
    protected long zzws = 0;
    protected long zzwt = 0;
    protected long zzwu = 0;
    protected double zzwv;
    private double zzww;
    private double zzwx;
    protected float zzwy;
    protected float zzwz;
    protected float zzxa;
    protected float zzxb;
    private boolean zzxc = false;
    protected boolean zzxd = false;
    protected DisplayMetrics zzxe;

    protected zzdx(Context context) {
        try {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcta)).booleanValue()) {
                zzda.zzbp();
            } else {
                zzff.zzb(zzwh);
            }
            this.zzxe = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzev;

    /* access modifiers changed from: protected */
    public abstract zzcf.zza.zzb zza(Context context, zzcb.zza zza);

    /* access modifiers changed from: protected */
    public abstract zzcf.zza.zzb zzb(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzfi zzb(MotionEvent motionEvent) throws zzev;

    public void zzb(View view) {
    }

    /* access modifiers changed from: protected */
    public abstract zzcf.zza.zzb zzc(Context context, View view, Activity activity);

    public String zzb(Context context) {
        if (!zzfh.isMainThread()) {
            return zza(context, (String) null, zzew.zzyo, (View) null, (Activity) null, (byte[]) null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public String zza(Context context, View view, Activity activity) {
        return zza(context, (String) null, zzew.zzyp, view, activity, (byte[]) null);
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    public String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, zzew.zzyq, view, activity, (byte[]) null);
    }

    public void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.zzxc) {
            zzby();
            this.zzxc = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzwv = 0.0d;
            this.zzww = (double) motionEvent.getRawX();
            this.zzwx = (double) motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = (double) motionEvent.getRawX();
            double rawY = (double) motionEvent.getRawY();
            double d = rawX - this.zzww;
            double d2 = rawY - this.zzwx;
            this.zzwv += Math.sqrt((d * d) + (d2 * d2));
            this.zzww = rawX;
            this.zzwx = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 == 0) {
            this.zzwy = motionEvent.getX();
            this.zzwz = motionEvent.getY();
            this.zzxa = motionEvent.getRawX();
            this.zzxb = motionEvent.getRawY();
            this.zzwo++;
        } else if (action2 == 1) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.zzwm = obtain;
            this.zzwn.add(obtain);
            if (this.zzwn.size() > 6) {
                this.zzwn.remove().recycle();
            }
            this.zzwq++;
            this.zzws = zza(new Throwable().getStackTrace());
        } else if (action2 == 2) {
            this.zzwp += (long) (motionEvent.getHistorySize() + 1);
            try {
                zzfi zzb = zzb(motionEvent);
                if ((zzb == null || zzb.zzzz == null || zzb.zzaac == null) ? false : true) {
                    this.zzwt += zzb.zzzz.longValue() + zzb.zzaac.longValue();
                }
                if (!(this.zzxe == null || zzb == null || zzb.zzaaa == null || zzb.zzaad == null)) {
                    z = true;
                }
                if (z) {
                    this.zzwu += zzb.zzaaa.longValue() + zzb.zzaad.longValue();
                }
            } catch (zzev unused) {
            }
        } else if (action2 == 3) {
            this.zzwr++;
        }
        this.zzxd = true;
    }

    public void zza(int i, int i2, int i3) {
        if (this.zzwm != null) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcso)).booleanValue()) {
                zzby();
            } else {
                this.zzwm.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzxe;
        if (displayMetrics != null) {
            this.zzwm = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * displayMetrics.density, this.zzxe.density * ((float) i2), 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzwm = null;
        }
        this.zzxd = false;
    }

    private final void zzby() {
        this.zzws = 0;
        this.zzwo = 0;
        this.zzwp = 0;
        this.zzwq = 0;
        this.zzwr = 0;
        this.zzwt = 0;
        this.zzwu = 0;
        if (this.zzwn.size() > 0) {
            Iterator it = this.zzwn.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzwn.clear();
        } else {
            MotionEvent motionEvent = this.zzwm;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzwm = null;
    }

    private final String zza(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        String str2;
        zzdw zzdw;
        int i2;
        int i3;
        int i4;
        int i5;
        Context context2 = context;
        int i6 = i;
        View view2 = view;
        Activity activity2 = activity;
        long currentTimeMillis = System.currentTimeMillis();
        boolean booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcsq)).booleanValue();
        zzcf.zza.zzb zzb = null;
        if (booleanValue) {
            zzdw = zzwh != null ? zzwh.zzcm() : null;
            str2 = ((Boolean) zzww.zzra().zzd(zzabq.zzcta)).booleanValue() ? "be" : "te";
        } else {
            zzdw = null;
            str2 = null;
        }
        try {
            if (i6 == zzew.zzyq) {
                zzb = zzb(context2, view2, activity2);
                this.zzxc = true;
                i5 = 1002;
            } else if (i6 == zzew.zzyp) {
                zzb = zzc(context2, view2, activity2);
                i5 = 1008;
            } else {
                zzb = zza(context2, (zzcb.zza) null);
                i5 = 1000;
            }
            if (booleanValue && zzdw != null) {
                zzdw.zza(i5, -1, System.currentTimeMillis() - currentTimeMillis, str2);
            }
        } catch (Exception e) {
            Exception exc = e;
            if (booleanValue && zzdw != null) {
                if (i6 == zzew.zzyq) {
                    i4 = 1003;
                } else if (i6 == zzew.zzyp) {
                    i4 = 1009;
                } else {
                    i4 = i6 == zzew.zzyo ? 1001 : -1;
                }
                zzdw.zza(i4, -1, System.currentTimeMillis() - currentTimeMillis, str2, exc);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (zzb != null) {
            try {
                if (((zzcf.zza) ((zzena) zzb.zzbjv())).zzbjj() != 0) {
                    String zzj = zzda.zzj((zzcf.zza) ((zzena) zzb.zzbjv()), str);
                    if (!booleanValue || zzdw == null) {
                        return zzj;
                    }
                    if (i6 == zzew.zzyq) {
                        i3 = 1006;
                    } else if (i6 == zzew.zzyp) {
                        i3 = 1010;
                    } else {
                        i3 = i6 == zzew.zzyo ? 1004 : -1;
                    }
                    zzdw.zza(i3, -1, System.currentTimeMillis() - currentTimeMillis2, str2);
                    return zzj;
                }
            } catch (Exception e2) {
                Exception exc2 = e2;
                String num = Integer.toString(7);
                if (!booleanValue || zzdw == null) {
                    return num;
                }
                if (i6 == zzew.zzyq) {
                    i2 = 1007;
                } else if (i6 == zzew.zzyp) {
                    i2 = 1011;
                } else {
                    i2 = i6 == zzew.zzyo ? 1005 : -1;
                }
                zzdw.zza(i2, -1, System.currentTimeMillis() - currentTimeMillis2, str2, exc2);
                return num;
            }
        }
        return Integer.toString(5);
    }
}
