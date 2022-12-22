package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import com.didi.soda.customer.app.constant.Const;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdey implements zzdhe<zzdev> {
    private final Context context;
    private final zzebs zzhdd;
    private final Set<String> zzhdr;
    private final ViewGroup zzhfc;

    public zzdey(zzebs zzebs, ViewGroup viewGroup, Context context2, Set<String> set) {
        this.zzhdd = zzebs;
        this.zzhdr = set;
        this.zzhfc = viewGroup;
        this.context = context2;
    }

    private static Boolean zzl(Activity activity) {
        Window window = activity.getWindow();
        boolean z = true;
        if (window != null && (window.getAttributes().flags & 16777216) != 0) {
            return true;
        }
        try {
            if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) == 0) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final zzebt<zzdev> zzatu() {
        return this.zzhdd.zze(new zzdex(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdev zzauf() throws Exception {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyd)).booleanValue() && this.zzhfc != null && this.zzhdr.contains(Const.ComponentType.BANNER)) {
            return new zzdev(Boolean.valueOf(this.zzhfc.isHardwareAccelerated()));
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcye)).booleanValue() && this.zzhdr.contains("native")) {
            Context context2 = this.context;
            if (context2 instanceof Activity) {
                return new zzdev(zzl((Activity) context2));
            }
        }
        return new zzdev((Boolean) null);
    }
}
