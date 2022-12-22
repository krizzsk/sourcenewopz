package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzacq implements zzeso {
    private CustomTabsSession zzdct;
    private CustomTabsClient zzdcu;
    private CustomTabsServiceConnection zzdcv;
    private zzact zzdcw;

    public static boolean zzj(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (!(queryIntentActivities == null || resolveActivity == null)) {
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                    return resolveActivity.activityInfo.packageName.equals(zzesm.zzcp(context));
                }
            }
        }
        return false;
    }

    public final void zzc(Activity activity) {
        CustomTabsServiceConnection customTabsServiceConnection = this.zzdcv;
        if (customTabsServiceConnection != null) {
            activity.unbindService(customTabsServiceConnection);
            this.zzdcu = null;
            this.zzdct = null;
            this.zzdcv = null;
        }
    }

    public final CustomTabsSession zzsz() {
        CustomTabsClient customTabsClient = this.zzdcu;
        if (customTabsClient == null) {
            this.zzdct = null;
        } else if (this.zzdct == null) {
            this.zzdct = customTabsClient.newSession((CustomTabsCallback) null);
        }
        return this.zzdct;
    }

    public final void zza(zzact zzact) {
        this.zzdcw = zzact;
    }

    public final void zzd(Activity activity) {
        String zzcp;
        if (this.zzdcu == null && (zzcp = zzesm.zzcp(activity)) != null) {
            zzesp zzesp = new zzesp(this);
            this.zzdcv = zzesp;
            CustomTabsClient.bindCustomTabsService(activity, zzcp, zzesp);
        }
    }

    public final void zza(CustomTabsClient customTabsClient) {
        this.zzdcu = customTabsClient;
        customTabsClient.warmup(0);
        zzact zzact = this.zzdcw;
        if (zzact != null) {
            zzact.zztb();
        }
    }

    public final void zzta() {
        this.zzdcu = null;
        this.zzdct = null;
        zzact zzact = this.zzdcw;
        if (zzact != null) {
            zzact.zztc();
        }
    }
}
