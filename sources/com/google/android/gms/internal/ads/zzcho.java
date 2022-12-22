package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcho extends zzafr {
    private final Context zzaai;
    private final zzcdr zzgeo;
    /* access modifiers changed from: private */
    public zzcdf zzghx;
    private zzcen zzgle;

    public zzcho(Context context, zzcdr zzcdr, zzcen zzcen, zzcdf zzcdf) {
        this.zzaai = context;
        this.zzgeo = zzcdr;
        this.zzgle = zzcen;
        this.zzghx = zzcdf;
    }

    public final IObjectWrapper zzts() {
        return null;
    }

    public final String zzct(String str) {
        return this.zzgeo.zzaoy().get(str);
    }

    public final zzaes zzcu(String str) {
        return this.zzgeo.zzaow().get(str);
    }

    public final List<String> getAvailableAssetNames() {
        SimpleArrayMap<String, zzaee> zzaow = this.zzgeo.zzaow();
        SimpleArrayMap<String, String> zzaoy = this.zzgeo.zzaoy();
        String[] strArr = new String[(zzaow.size() + zzaoy.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzaow.size()) {
            strArr[i3] = zzaow.keyAt(i2);
            i2++;
            i3++;
        }
        while (i < zzaoy.size()) {
            strArr[i3] = zzaoy.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    public final String getCustomTemplateId() {
        return this.zzgeo.getCustomTemplateId();
    }

    public final void performClick(String str) {
        zzcdf zzcdf = this.zzghx;
        if (zzcdf != null) {
            zzcdf.zzfx(str);
        }
    }

    public final void recordImpression() {
        zzcdf zzcdf = this.zzghx;
        if (zzcdf != null) {
            zzcdf.zzaod();
        }
    }

    public final zzzd getVideoController() {
        return this.zzgeo.getVideoController();
    }

    public final void destroy() {
        zzcdf zzcdf = this.zzghx;
        if (zzcdf != null) {
            zzcdf.destroy();
        }
        this.zzghx = null;
        this.zzgle = null;
    }

    public final IObjectWrapper zztx() {
        return ObjectWrapper.wrap(this.zzaai);
    }

    public final boolean zzp(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup)) {
            return false;
        }
        zzcen zzcen = this.zzgle;
        if (!(zzcen != null && zzcen.zza((ViewGroup) unwrap))) {
            return false;
        }
        this.zzgeo.zzaot().zza((zzaeg) new zzchr(this));
        return true;
    }

    public final boolean zzty() {
        zzcdf zzcdf = this.zzghx;
        if ((zzcdf == null || zzcdf.zzaok()) && this.zzgeo.zzaou() != null && this.zzgeo.zzaot() == null) {
            return true;
        }
        return false;
    }

    public final boolean zztz() {
        IObjectWrapper zzaov = this.zzgeo.zzaov();
        if (zzaov != null) {
            zzr.zzlk().zzac(zzaov);
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzcwn)).booleanValue() || this.zzgeo.zzaou() == null) {
                return true;
            }
            this.zzgeo.zzaou().zza("onSdkLoaded", (Map<String, ?>) new ArrayMap());
            return true;
        }
        zzd.zzez("Trying to start OMID session before creation.");
        return false;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) {
        zzcdf zzcdf;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzgeo.zzaov() != null && (zzcdf = this.zzghx) != null) {
            zzcdf.zzaa((View) unwrap);
        }
    }

    public final void zzua() {
        String zzaox = this.zzgeo.zzaox();
        if ("Google".equals(zzaox)) {
            zzd.zzez("Illegal argument specified for omid partner name.");
            return;
        }
        zzcdf zzcdf = this.zzghx;
        if (zzcdf != null) {
            zzcdf.zzk(zzaox, false);
        }
    }
}
