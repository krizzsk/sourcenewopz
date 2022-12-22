package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.google.android.gms.ads.internal.util.zzbn;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbxr;
import com.google.android.gms.internal.ads.zzdbs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdbf extends zzazf {
    private static final List<String> zzhck = new ArrayList(Arrays.asList(new String[]{"/aclk", "/pcs/click"}));
    private static final List<String> zzhcl = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com"}));
    private static final List<String> zzhcm = new ArrayList(Arrays.asList(new String[]{"/pagead/adview", "/pcs/view", "/pagead/conversion"}));
    private static final List<String> zzhcn = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"}));
    private Context context;
    /* access modifiers changed from: private */
    public zzbar zzbpj;
    private final ScheduledExecutorService zzftq;
    private zzei zzftt;
    private Point zzgey = new Point();
    private Point zzgez = new Point();
    private final zzebs zzgka;
    private zzdqc<zzchu> zzgxm;
    private zzbhh zzhco;
    private zzatj zzhcp;

    public zzdbf(zzbhh zzbhh, Context context2, zzei zzei, zzbar zzbar, zzdqc<zzchu> zzdqc, zzebs zzebs, ScheduledExecutorService scheduledExecutorService) {
        this.zzhco = zzbhh;
        this.context = context2;
        this.zzftt = zzei;
        this.zzbpj = zzbar;
        this.zzgxm = zzdqc;
        this.zzgka = zzebs;
        this.zzftq = scheduledExecutorService;
    }

    public final IObjectWrapper zzap(IObjectWrapper iObjectWrapper) {
        return null;
    }

    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return null;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzazi zzazi, zzazb zzazb) {
        Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.context = context2;
        String str = zzazi.zzbvf;
        String str2 = zzazi.zzbrw;
        zzvt zzvt = zzazi.zzedt;
        zzvq zzvq = zzazi.zzedu;
        zzdbc zzagm = this.zzhco.zzagm();
        zzbsj.zza zzci = new zzbsj.zza().zzci(context2);
        zzdpo zzdpo = new zzdpo();
        if (str == null) {
            str = "adUnitId";
        }
        zzdpo zzgt = zzdpo.zzgt(str);
        if (zzvq == null) {
            zzvq = new zzvp().zzqj();
        }
        zzdpo zzh = zzgt.zzh(zzvq);
        if (zzvt == null) {
            zzvt = new zzvt();
        }
        zzebh.zza(zzagm.zzg(zzci.zza(zzh.zzg(zzvt).zzawg()).zzami()).zza(new zzdbs(new zzdbs.zza().zzgs(str2))).zzg(new zzbxr.zza().zzanf()).zzajg().zzajf(), new zzdbo(this, zzazb), this.zzhco.zzafv());
    }

    public final void zzao(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdaa)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzatj zzatj = this.zzhcp;
            this.zzgey = zzbn.zza(motionEvent, zzatj == null ? null : zzatj.zzaay);
            if (motionEvent.getAction() == 0) {
                this.zzgez = this.zzgey;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation((float) this.zzgey.x, (float) this.zzgey.y);
            this.zzftt.zza(obtain);
            obtain.recycle();
        }
    }

    public final void zza(zzatj zzatj) {
        this.zzhcp = zzatj;
        this.zzgxm.ensureSize(1);
    }

    public final void zza(List<Uri> list, IObjectWrapper iObjectWrapper, zzasy zzasy) {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzdaa)).booleanValue()) {
            try {
                zzasy.onError("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzbao.zzc("", e);
            }
        } else {
            zzebt zze = this.zzgka.zze(new zzdbe(this, list, iObjectWrapper));
            if (zzatq()) {
                zze = zzebh.zzb(zze, new zzdbh(this), (Executor) this.zzgka);
            } else {
                zzd.zzey("Asset view map is empty.");
            }
            zzebh.zza(zze, new zzdbr(this, zzasy), this.zzhco.zzafv());
        }
    }

    public final void zzb(List<Uri> list, IObjectWrapper iObjectWrapper, zzasy zzasy) {
        try {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzdaa)).booleanValue()) {
                zzasy.onError("The updating URL feature is not enabled.");
            } else if (list.size() != 1) {
                zzasy.onError("There should be only 1 click URL.");
            } else {
                Uri uri = list.get(0);
                if (!zza(uri, zzhck, zzhcl)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzd.zzez(sb.toString());
                    zzasy.onSuccess(list);
                    return;
                }
                zzebt zze = this.zzgka.zze(new zzdbg(this, uri, iObjectWrapper));
                if (zzatq()) {
                    zze = zzebh.zzb(zze, new zzdbj(this), (Executor) this.zzgka);
                } else {
                    zzd.zzey("Asset view map is empty.");
                }
                zzebh.zza(zze, new zzdbq(this, zzasy), this.zzhco.zzafv());
            }
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    private static boolean zzk(Uri uri) {
        return zza(uri, zzhcm, zzhcn);
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final Uri zzb(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        try {
            uri = this.zzftt.zza(uri, this.context, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
        } catch (zzeh e) {
            zzbao.zzd("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    private static boolean zza(Uri uri, List<String> list, List<String> list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (!(host == null || path == null)) {
            for (String contains : list) {
                if (path.contains(contains)) {
                    for (String endsWith : list2) {
                        if (host.endsWith(endsWith)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    private final zzebt<String> zzgr(String str) {
        zzchu[] zzchuArr = new zzchu[1];
        zzebt<O> zzb = zzebh.zzb(this.zzgxm.zzawl(), new zzdbm(this, zzchuArr, str), (Executor) this.zzgka);
        zzb.addListener(new zzdbp(this, zzchuArr), this.zzgka);
        return zzebc.zzg(zzb).zza((long) ((Integer) zzww.zzra().zzd(zzabq.zzdab)).intValue(), TimeUnit.MILLISECONDS, this.zzftq).zza(zzdbk.zzebv, this.zzgka).zza(Exception.class, zzdbn.zzebv, (Executor) this.zzgka);
    }

    private static Uri zza(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = indexOf + 1;
        return Uri.parse(uri2.substring(0, i) + str + "=" + str2 + ParamKeys.SIGN_AND + uri2.substring(i));
    }

    private final boolean zzatq() {
        zzatj zzatj = this.zzhcp;
        return (zzatj == null || zzatj.zzdva == null || this.zzhcp.zzdva.isEmpty()) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzchu[] zzchuArr) {
        if (zzchuArr[0] != null) {
            this.zzgxm.zzd(zzebh.zzag(zzchuArr[0]));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzchu[] zzchuArr, String str, zzchu zzchu) throws Exception {
        zzchuArr[0] = zzchu;
        JSONObject zza = zzbn.zza(this.context, this.zzhcp.zzdva, this.zzhcp.zzdva, this.zzhcp.zzaay);
        JSONObject zza2 = zzbn.zza(this.context, this.zzhcp.zzaay);
        JSONObject zzt = zzbn.zzt(this.zzhcp.zzaay);
        JSONObject zzb = zzbn.zzb(this.context, this.zzhcp.zzaay);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zza);
        jSONObject.put("ad_view_signal", zza2);
        jSONObject.put("scroll_view_signal", zzt);
        jSONObject.put("lock_screen_signal", zzb);
        if (str == "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") {
            jSONObject.put("click_signal", zzbn.zza((String) null, this.context, this.zzgez, this.zzgey));
        }
        return zzchu.zzc(str, jSONObject);
    }

    static /* synthetic */ Uri zzc(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zza(uri, "nas", str) : uri;
    }

    static /* synthetic */ ArrayList zza(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzk(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zza(uri, "nas", str));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzl(Uri uri) throws Exception {
        return zzebh.zzb(zzgr("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzdbl(this, uri), (Executor) this.zzgka);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzb(ArrayList arrayList) throws Exception {
        return zzebh.zzb(zzgr("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzdbi(this, arrayList), (Executor) this.zzgka);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zza(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String zza = this.zzftt.zzcb() != null ? this.zzftt.zzcb().zza(this.context, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null) : "";
        if (!TextUtils.isEmpty(zza)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!zzk(uri)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzd.zzez(sb.toString());
                    arrayList.add(uri);
                } else {
                    arrayList.add(zza(uri, "ms", zza));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }
}
