package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcdr {
    private Bundle extras;
    private zzaek zzdha;
    private List<zzzz> zzdhn = Collections.emptyList();
    private List<?> zzexb;
    private double zzexe;
    private float zzexq;
    private IObjectWrapper zzfya;
    private int zzggs;
    private zzzd zzggt;
    private View zzggu;
    private zzzz zzggv;
    private zzbfi zzggw;
    private zzbfi zzggx;
    private View zzggy;
    private IObjectWrapper zzggz;
    private zzaes zzgha;
    private zzaes zzghb;
    private String zzghc;
    private SimpleArrayMap<String, zzaee> zzghd = new SimpleArrayMap<>();
    private SimpleArrayMap<String, String> zzghe = new SimpleArrayMap<>();
    private String zzghf;

    public final synchronized void zzeh(int i) {
        this.zzggs = i;
    }

    public final synchronized void zzb(zzzd zzzd) {
        this.zzggt = zzzd;
    }

    public final synchronized void zza(zzaek zzaek) {
        this.zzdha = zzaek;
    }

    public final synchronized void setImages(List<zzaee> list) {
        this.zzexb = list;
    }

    public final synchronized void zzh(List<zzzz> list) {
        this.zzdhn = list;
    }

    public final synchronized void zza(zzzz zzzz) {
        this.zzggv = zzzz;
    }

    public final synchronized void zzac(View view) {
        this.zzggy = view;
    }

    public final synchronized void setStarRating(double d) {
        this.zzexe = d;
    }

    public final synchronized void zza(zzaes zzaes) {
        this.zzgha = zzaes;
    }

    public final synchronized void zzb(zzaes zzaes) {
        this.zzghb = zzaes;
    }

    public final synchronized void zzfy(String str) {
        this.zzghc = str;
    }

    public final synchronized void zzf(zzbfi zzbfi) {
        this.zzggw = zzbfi;
    }

    public final synchronized void zzg(zzbfi zzbfi) {
        this.zzggx = zzbfi;
    }

    public final synchronized void zzau(IObjectWrapper iObjectWrapper) {
        this.zzfya = iObjectWrapper;
    }

    public final synchronized void zzo(String str, String str2) {
        if (str2 == null) {
            this.zzghe.remove(str);
        } else {
            this.zzghe.put(str, str2);
        }
    }

    public final synchronized void zza(String str, zzaee zzaee) {
        if (zzaee == null) {
            this.zzghd.remove(str);
        } else {
            this.zzghd.put(str, zzaee);
        }
    }

    private final synchronized void setMediaContentAspectRatio(float f) {
        this.zzexq = f;
    }

    public final synchronized void zzfz(String str) {
        this.zzghf = str;
    }

    private final synchronized String zzga(String str) {
        return this.zzghe.get(str);
    }

    public final synchronized int zzaoo() {
        return this.zzggs;
    }

    public final synchronized zzzd getVideoController() {
        return this.zzggt;
    }

    public final synchronized zzaek zztu() {
        return this.zzdha;
    }

    public final synchronized View zzaop() {
        return this.zzggu;
    }

    public final synchronized String getHeadline() {
        return zzga("headline");
    }

    public final synchronized List<?> getImages() {
        return this.zzexb;
    }

    public final zzaes zzaoq() {
        List<?> list = this.zzexb;
        if (!(list == null || list.size() == 0)) {
            Object obj = this.zzexb.get(0);
            if (obj instanceof IBinder) {
                return zzaev.zzo((IBinder) obj);
            }
        }
        return null;
    }

    public final synchronized List<zzzz> getMuteThisAdReasons() {
        return this.zzdhn;
    }

    public final synchronized zzzz zzaor() {
        return this.zzggv;
    }

    public final synchronized String getBody() {
        return zzga("body");
    }

    public final synchronized Bundle getExtras() {
        if (this.extras == null) {
            this.extras = new Bundle();
        }
        return this.extras;
    }

    public final synchronized String getCallToAction() {
        return zzga("call_to_action");
    }

    public final synchronized View zzaos() {
        return this.zzggy;
    }

    public final synchronized IObjectWrapper zztv() {
        return this.zzggz;
    }

    public final synchronized String getStore() {
        return zzga(Payload.TYPE_STORE);
    }

    public final synchronized String getPrice() {
        return zzga("price");
    }

    public final synchronized double getStarRating() {
        return this.zzexe;
    }

    public final synchronized zzaes zztt() {
        return this.zzgha;
    }

    public final synchronized String getAdvertiser() {
        return zzga("advertiser");
    }

    public final synchronized zzaes zztw() {
        return this.zzghb;
    }

    public final synchronized String getCustomTemplateId() {
        return this.zzghc;
    }

    public final synchronized zzbfi zzaot() {
        return this.zzggw;
    }

    public final synchronized zzbfi zzaou() {
        return this.zzggx;
    }

    public final synchronized IObjectWrapper zzaov() {
        return this.zzfya;
    }

    public final synchronized SimpleArrayMap<String, zzaee> zzaow() {
        return this.zzghd;
    }

    public final synchronized float getMediaContentAspectRatio() {
        return this.zzexq;
    }

    public final synchronized String zzaox() {
        return this.zzghf;
    }

    public final synchronized SimpleArrayMap<String, String> zzaoy() {
        return this.zzghe;
    }

    public final synchronized void destroy() {
        if (this.zzggw != null) {
            this.zzggw.destroy();
            this.zzggw = null;
        }
        if (this.zzggx != null) {
            this.zzggx.destroy();
            this.zzggx = null;
        }
        this.zzfya = null;
        this.zzghd.clear();
        this.zzghe.clear();
        this.zzggt = null;
        this.zzdha = null;
        this.zzggu = null;
        this.zzexb = null;
        this.extras = null;
        this.zzggy = null;
        this.zzggz = null;
        this.zzgha = null;
        this.zzghb = null;
        this.zzghc = null;
    }

    public static zzcdr zza(zzaoc zzaoc) {
        try {
            zzcdo zza = zza(zzaoc.getVideoController(), (zzaoh) null);
            zzaek zztu = zzaoc.zztu();
            String headline = zzaoc.getHeadline();
            List<?> images = zzaoc.getImages();
            String body = zzaoc.getBody();
            Bundle extras2 = zzaoc.getExtras();
            String callToAction = zzaoc.getCallToAction();
            IObjectWrapper zztv = zzaoc.zztv();
            String advertiser = zzaoc.getAdvertiser();
            zzaes zztw = zzaoc.zztw();
            zzcdr zzcdr = new zzcdr();
            zzcdr.zzggs = 1;
            zzcdr.zzggt = zza;
            zzcdr.zzdha = zztu;
            zzcdr.zzggu = (View) zzav(zzaoc.zzvr());
            zzcdr.zzo("headline", headline);
            zzcdr.zzexb = images;
            zzcdr.zzo("body", body);
            zzcdr.extras = extras2;
            zzcdr.zzo("call_to_action", callToAction);
            zzcdr.zzggy = (View) zzav(zzaoc.zzvs());
            zzcdr.zzggz = zztv;
            zzcdr.zzo("advertiser", advertiser);
            zzcdr.zzghb = zztw;
            return zzcdr;
        } catch (RemoteException e) {
            zzd.zzd("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzcdr zza(zzaob zzaob) {
        try {
            zzcdo zza = zza(zzaob.getVideoController(), (zzaoh) null);
            zzaek zztu = zzaob.zztu();
            String headline = zzaob.getHeadline();
            List<?> images = zzaob.getImages();
            String body = zzaob.getBody();
            Bundle extras2 = zzaob.getExtras();
            String callToAction = zzaob.getCallToAction();
            IObjectWrapper zztv = zzaob.zztv();
            String store = zzaob.getStore();
            String price = zzaob.getPrice();
            double starRating = zzaob.getStarRating();
            zzaes zztt = zzaob.zztt();
            zzcdr zzcdr = new zzcdr();
            zzcdr.zzggs = 2;
            zzcdr.zzggt = zza;
            zzcdr.zzdha = zztu;
            zzcdr.zzggu = (View) zzav(zzaob.zzvr());
            zzcdr.zzo("headline", headline);
            zzcdr.zzexb = images;
            zzcdr.zzo("body", body);
            zzcdr.extras = extras2;
            zzcdr.zzo("call_to_action", callToAction);
            zzcdr.zzggy = (View) zzav(zzaob.zzvs());
            zzcdr.zzggz = zztv;
            zzcdr.zzo(Payload.TYPE_STORE, store);
            zzcdr.zzo("price", price);
            zzcdr.zzexe = starRating;
            zzcdr.zzgha = zztt;
            return zzcdr;
        } catch (RemoteException e) {
            zzd.zzd("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzcdr zzb(zzaoh zzaoh) {
        try {
            return zza(zza(zzaoh.getVideoController(), zzaoh), zzaoh.zztu(), (View) zzav(zzaoh.zzvr()), zzaoh.getHeadline(), zzaoh.getImages(), zzaoh.getBody(), zzaoh.getExtras(), zzaoh.getCallToAction(), (View) zzav(zzaoh.zzvs()), zzaoh.zztv(), zzaoh.getStore(), zzaoh.getPrice(), zzaoh.getStarRating(), zzaoh.zztt(), zzaoh.getAdvertiser(), zzaoh.getMediaContentAspectRatio());
        } catch (RemoteException e) {
            zzd.zzd("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public static zzcdr zzb(zzaob zzaob) {
        try {
            return zza(zza(zzaob.getVideoController(), (zzaoh) null), zzaob.zztu(), (View) zzav(zzaob.zzvr()), zzaob.getHeadline(), zzaob.getImages(), zzaob.getBody(), zzaob.getExtras(), zzaob.getCallToAction(), (View) zzav(zzaob.zzvs()), zzaob.zztv(), zzaob.getStore(), zzaob.getPrice(), zzaob.getStarRating(), zzaob.zztt(), (String) null, 0.0f);
        } catch (RemoteException e) {
            zzd.zzd("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzcdr zzb(zzaoc zzaoc) {
        try {
            return zza(zza(zzaoc.getVideoController(), (zzaoh) null), zzaoc.zztu(), (View) zzav(zzaoc.zzvr()), zzaoc.getHeadline(), zzaoc.getImages(), zzaoc.getBody(), zzaoc.getExtras(), zzaoc.getCallToAction(), (View) zzav(zzaoc.zzvs()), zzaoc.zztv(), (String) null, (String) null, -1.0d, zzaoc.zztw(), zzaoc.getAdvertiser(), 0.0f);
        } catch (RemoteException e) {
            zzd.zzd("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzcdr zza(zzzd zzzd, zzaek zzaek, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzaes zzaes, String str6, float f) {
        zzcdr zzcdr = new zzcdr();
        zzcdr.zzggs = 6;
        zzcdr.zzggt = zzzd;
        zzcdr.zzdha = zzaek;
        zzcdr.zzggu = view;
        String str7 = str;
        zzcdr.zzo("headline", str);
        zzcdr.zzexb = list;
        String str8 = str2;
        zzcdr.zzo("body", str2);
        zzcdr.extras = bundle;
        String str9 = str3;
        zzcdr.zzo("call_to_action", str3);
        zzcdr.zzggy = view2;
        zzcdr.zzggz = iObjectWrapper;
        String str10 = str4;
        zzcdr.zzo(Payload.TYPE_STORE, str4);
        String str11 = str5;
        zzcdr.zzo("price", str5);
        zzcdr.zzexe = d;
        zzcdr.zzgha = zzaes;
        zzcdr.zzo("advertiser", str6);
        zzcdr.setMediaContentAspectRatio(f);
        return zzcdr;
    }

    private static <T> T zzav(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    private static zzcdo zza(zzzd zzzd, zzaoh zzaoh) {
        if (zzzd == null) {
            return null;
        }
        return new zzcdo(zzzd, zzaoh);
    }
}
