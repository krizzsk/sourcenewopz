package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.didi.raven.config.RavenConfigKey;
import com.didi.sdk.lawpop.SimpleWebActivity;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfi;
import com.google.android.gms.internal.ads.zzbgd;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgp;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzve;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaio<T extends zzve & zzbex & zzbfi & zzakr & zzbgd & zzbgk & zzbgo & zzbgp & zzbgr> implements zzaig<T> {
    private final zza zzdjd;
    private final zzcmb zzdje;
    private final zzdtw zzdjf;
    private final zzbas zzdjg;
    private final zzaqz zzdjh;
    private final zzcsh zzdji;
    private zzv zzdjj = null;

    public zzaio(zza zza, zzaqz zzaqz, zzcsh zzcsh, zzcmb zzcmb, zzdtw zzdtw) {
        this.zzdjd = zza;
        this.zzdjh = zzaqz;
        this.zzdji = zzcsh;
        this.zzdje = zzcmb;
        this.zzdjf = zzdtw;
        this.zzdjg = new zzbas();
    }

    private final boolean zza(T t, Context context, String str, String str2) {
        String str3 = str2;
        zzr.zzkv();
        boolean zzbd = zzj.zzbd(context);
        zzr.zzkv();
        zzbg zzbg = zzj.zzbg(context);
        zzcmb zzcmb = this.zzdje;
        if (zzcmb != null) {
            zzcsr.zza(context, zzcmb, this.zzdjf, this.zzdji, str2, "offline_open");
        }
        zzbfi zzbfi = (zzbfi) t;
        boolean z = zzbfi.zzaed().zzafj() && zzbfi.zzabx() == null;
        if (zzbd) {
            this.zzdji.zzb(this.zzdjg, str3);
            return false;
        }
        zzr.zzkv();
        if (zzj.zzbf(context) && zzbg != null && !z) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdbe)).booleanValue()) {
                if (zzbfi.zzaed().zzafj()) {
                    zzcsr.zza(zzbfi.zzabx(), (zze) null, zzbg, this.zzdji, this.zzdje, this.zzdjf, str2, str);
                } else {
                    ((zzbgo) t).zza(zzbg, this.zzdji, this.zzdje, this.zzdjf, str2, str, zzr.zzkx().zzzv());
                }
                zzcmb zzcmb2 = this.zzdje;
                if (zzcmb2 != null) {
                    zzcsr.zza(context, zzcmb2, this.zzdjf, this.zzdji, str2, "dialog_impression");
                }
                t.onAdClicked();
                return true;
            }
        }
        this.zzdji.zzgn(str3);
        if (this.zzdje != null) {
            HashMap hashMap = new HashMap();
            zzr.zzkv();
            if (!zzj.zzbf(context)) {
                hashMap.put("dialog_not_shown_reason", "notifications_disabled");
            } else if (zzbg == null) {
                hashMap.put("dialog_not_shown_reason", "work_manager_unavailable");
            } else {
                if (!((Boolean) zzww.zzra().zzd(zzabq.zzdbe)).booleanValue()) {
                    hashMap.put("dialog_not_shown_reason", "notification_flow_disabled");
                } else if (z) {
                    hashMap.put("dialog_not_shown_reason", "fullscreen_no_activity");
                }
            }
            zzcsr.zza(context, this.zzdje, this.zzdjf, this.zzdji, str2, "dialog_not_shown", hashMap);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void zza(zzacs zzacs) {
        if (this.zzdje != null) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
                this.zzdjf.zzb(zzdtx.zzgy("cct_action").zzw("cct_open_status", zzacs.toString()));
            } else {
                this.zzdje.zzarp().zzs("action", "cct_action").zzs("cct_open_status", zzacs.toString()).zzarm();
            }
        }
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if (RavenConfigKey.PHONE.equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("c".equalsIgnoreCase(str)) {
            return zzr.zzkx().zzzv();
        }
        return -1;
    }

    private final void zzae(boolean z) {
        zzaqz zzaqz = this.zzdjh;
        if (zzaqz != null) {
            zzaqz.zzag(z);
        }
    }

    static Uri zza(Context context, zzei zzei, Uri uri, View view, Activity activity) {
        if (zzei == null) {
            return uri;
        }
        try {
            if (zzei.zzc(uri)) {
                return zzei.zza(uri, context, view, activity);
            }
            return uri;
        } catch (zzeh unused) {
            return uri;
        } catch (Exception e) {
            zzr.zzkz().zza(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    static Uri zze(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String valueOf = String.valueOf(uri.toString());
            zzd.zzc(valueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(valueOf) : new String("Error adding click uptime parameter to url: "), e);
        }
        return uri;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        String str;
        boolean z;
        Map map2 = map;
        zzve zzve = (zzve) obj;
        zzbfi zzbfi = (zzbfi) zzve;
        String zzc = zzayv.zzc((String) map2.get("u"), zzbfi.getContext(), true);
        String str2 = (String) map2.get(Constants.FILE_ANR_KEY);
        if (str2 == null) {
            zzd.zzez("Action missing from an open GMSG.");
            return;
        }
        zza zza = this.zzdjd;
        if (zza == null || zza.zzkc()) {
            zzdot zzadk = zzbfi.zzadk();
            zzdoy zzaev = zzbfi.zzaev();
            if (zzadk == null || zzaev == null) {
                str = "";
                z = false;
            } else {
                boolean z2 = zzadk.zzhmz;
                str = zzaev.zzbwe;
                z = z2;
            }
            if ("expand".equalsIgnoreCase(str2)) {
                if (zzbfi.zzaek()) {
                    zzd.zzez("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzae(false);
                ((zzbgo) zzve).zzb(zzc(map), zzd(map));
            } else if ("webapp".equalsIgnoreCase(str2)) {
                zzae(false);
                if (zzc != null) {
                    ((zzbgo) zzve).zza(zzc(map), zzd(map), zzc);
                } else {
                    ((zzbgo) zzve).zza(zzc(map), zzd(map), (String) map2.get("html"), (String) map2.get("baseurl"));
                }
            } else {
                if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzcvm)).booleanValue()) {
                        zzae(true);
                        if (TextUtils.isEmpty(zzc)) {
                            zzd.zzez("Cannot open browser with null or empty url");
                            zza(zzacs.EMPTY_URL);
                            return;
                        }
                        Uri zze = zze(zza(zzbfi.getContext(), zzbfi.zzaei(), Uri.parse(zzc), zzbfi.getView(), zzbfi.zzabx()));
                        if (!z || this.zzdji == null || !zza(zzve, zzbfi.getContext(), zze.toString(), str)) {
                            this.zzdjj = new zzair(this);
                            ((zzbgo) zzve).zza(new zzb(zze.toString(), this.zzdjj, true));
                            return;
                        }
                        return;
                    }
                }
                if ("app".equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map2.get("system_browser"))) {
                    zzae(true);
                    Intent zze2 = new zzait(zzbfi.getContext(), zzbfi.zzaei(), zzbfi.getView()).zze(map2);
                    if (!z || this.zzdji == null || zze2 == null || !zza(zzve, zzbfi.getContext(), zze2.getData().toString(), str)) {
                        try {
                            ((zzbgo) zzve).zza(new zzb(zze2, this.zzdjj));
                        } catch (ActivityNotFoundException e) {
                            zzd.zzez(e.getMessage());
                        }
                    }
                } else if ("open_app".equalsIgnoreCase(str2)) {
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzdaw)).booleanValue()) {
                        zzae(true);
                        String str3 = (String) map2.get(RavenConfigKey.PHONE);
                        if (str3 == null) {
                            zzd.zzez("Package name missing from open app action.");
                        } else if (!z || this.zzdji == null || !zza(zzve, zzbfi.getContext(), str3, str)) {
                            PackageManager packageManager = zzbfi.getContext().getPackageManager();
                            if (packageManager == null) {
                                zzd.zzez("Cannot get package manager from open app action.");
                                return;
                            }
                            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str3);
                            if (launchIntentForPackage != null) {
                                ((zzbgo) zzve).zza(new zzb(launchIntentForPackage, this.zzdjj));
                            }
                        }
                    }
                } else {
                    zzae(true);
                    String str4 = (String) map2.get(SimpleWebActivity.INTENT_URL);
                    Intent intent = null;
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            intent = Intent.parseUri(str4, 0);
                        } catch (URISyntaxException e2) {
                            URISyntaxException uRISyntaxException = e2;
                            String valueOf = String.valueOf(str4);
                            zzd.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), uRISyntaxException);
                        }
                    }
                    if (!(intent == null || intent.getData() == null)) {
                        Uri data = intent.getData();
                        if (!Uri.EMPTY.equals(data)) {
                            Uri zze3 = zze(zza(zzbfi.getContext(), zzbfi.zzaei(), data, zzbfi.getView(), zzbfi.zzabx()));
                            if (!TextUtils.isEmpty(intent.getType())) {
                                if (((Boolean) zzww.zzra().zzd(zzabq.zzdax)).booleanValue()) {
                                    intent.setDataAndType(zze3, intent.getType());
                                }
                            }
                            intent.setData(zze3);
                        }
                    }
                    boolean z3 = ((Boolean) zzww.zzra().zzd(zzabq.zzdbh)).booleanValue() && "intent_async".equalsIgnoreCase(str2) && map2.containsKey(ParamKeys.PARAM_EVENT_ID);
                    HashMap hashMap = new HashMap();
                    if (z3) {
                        this.zzdjj = new zzaiq(this, hashMap, map2, zzve);
                    }
                    if (intent == null) {
                        if (!TextUtils.isEmpty(zzc)) {
                            zzc = zze(zza(zzbfi.getContext(), zzbfi.zzaei(), Uri.parse(zzc), zzbfi.getView(), zzbfi.zzabx())).toString();
                        }
                        if (!z || this.zzdji == null || !zza(zzve, zzbfi.getContext(), zzc, str)) {
                            ((zzbgo) zzve).zza(new zzb((String) map2.get("i"), zzc, (String) map2.get("m"), (String) map2.get(RavenConfigKey.PHONE), (String) map2.get("c"), (String) map2.get("f"), (String) map2.get("e"), this.zzdjj));
                        } else if (z3) {
                            hashMap.put((String) map2.get(ParamKeys.PARAM_EVENT_ID), true);
                            ((zzakr) zzve).zza("openIntentAsync", (Map<String, ?>) hashMap);
                        }
                    } else if (!z || this.zzdji == null || !zza(zzve, zzbfi.getContext(), intent.getData().toString(), str)) {
                        ((zzbgo) zzve).zza(new zzb(intent, this.zzdjj));
                    } else if (z3) {
                        hashMap.put((String) map2.get(ParamKeys.PARAM_EVENT_ID), true);
                        ((zzakr) zzve).zza("openIntentAsync", (Map<String, ?>) hashMap);
                    }
                }
            }
        } else {
            this.zzdjd.zzbk(zzc);
        }
    }
}
