package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzarg extends zzarj implements zzaig<zzbfi> {
    private final Context context;
    private float density;
    private int maxHeight = -1;
    private int maxWidth = -1;
    private int rotation;
    private final WindowManager zzbro;
    private final zzbfi zzdkm;
    private final zzabb zzdrq;
    private int zzdrr = -1;
    private int zzdrs = -1;
    private int zzdrt = -1;
    private int zzdru = -1;
    private DisplayMetrics zzxe;

    public zzarg(zzbfi zzbfi, Context context2, zzabb zzabb) {
        super(zzbfi);
        this.zzdkm = zzbfi;
        this.context = context2;
        this.zzdrq = zzabb;
        this.zzbro = (WindowManager) context2.getSystemService("window");
    }

    public final void zzl(int i, int i2) {
        int i3 = 0;
        if (this.context instanceof Activity) {
            zzr.zzkv();
            i3 = zzj.zzh((Activity) this.context)[0];
        }
        if (this.zzdkm.zzaed() == null || !this.zzdkm.zzaed().zzafj()) {
            int width = this.zzdkm.getWidth();
            int height = this.zzdkm.getHeight();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcof)).booleanValue()) {
                if (width == 0 && this.zzdkm.zzaed() != null) {
                    width = this.zzdkm.zzaed().widthPixels;
                }
                if (height == 0 && this.zzdkm.zzaed() != null) {
                    height = this.zzdkm.zzaed().heightPixels;
                }
            }
            this.zzdrt = zzww.zzqw().zzd(this.context, width);
            this.zzdru = zzww.zzqw().zzd(this.context, height);
        }
        zzc(i, i2 - i3, this.zzdrt, this.zzdru);
        this.zzdkm.zzaef().zzk(i, i2);
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbfi zzbfi = (zzbfi) obj;
        this.zzxe = new DisplayMetrics();
        Display defaultDisplay = this.zzbro.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzxe);
        this.density = this.zzxe.density;
        this.rotation = defaultDisplay.getRotation();
        zzww.zzqw();
        DisplayMetrics displayMetrics = this.zzxe;
        this.zzdrr = zzbae.zzb(displayMetrics, displayMetrics.widthPixels);
        zzww.zzqw();
        DisplayMetrics displayMetrics2 = this.zzxe;
        this.zzdrs = zzbae.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzabx = this.zzdkm.zzabx();
        if (zzabx == null || zzabx.getWindow() == null) {
            this.maxWidth = this.zzdrr;
            this.maxHeight = this.zzdrs;
        } else {
            zzr.zzkv();
            int[] zzf = zzj.zzf(zzabx);
            zzww.zzqw();
            this.maxWidth = zzbae.zzb(this.zzxe, zzf[0]);
            zzww.zzqw();
            this.maxHeight = zzbae.zzb(this.zzxe, zzf[1]);
        }
        if (this.zzdkm.zzaed().zzafj()) {
            this.zzdrt = this.zzdrr;
            this.zzdru = this.zzdrs;
        } else {
            this.zzdkm.measure(0, 0);
        }
        zza(this.zzdrr, this.zzdrs, this.maxWidth, this.maxHeight, this.density, this.rotation);
        this.zzdkm.zza("onDeviceFeaturesReceived", new zzarf(new zzarh().zzai(this.zzdrq.zzsd()).zzah(this.zzdrq.zzse()).zzaj(this.zzdrq.zzsg()).zzak(this.zzdrq.zzsf()).zzal(true)).zzds());
        int[] iArr = new int[2];
        this.zzdkm.getLocationOnScreen(iArr);
        zzl(zzww.zzqw().zzd(this.context, iArr[0]), zzww.zzqw().zzd(this.context, iArr[1]));
        if (zzd.isLoggable(2)) {
            zzd.zzey("Dispatching Ready Event.");
        }
        zzdu(this.zzdkm.zzacc().zzbrz);
    }
}
