package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzesp extends CustomTabsServiceConnection {
    private WeakReference<zzeso> zzjfj;

    public zzesp(zzeso zzeso) {
        this.zzjfj = new WeakReference<>(zzeso);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzeso zzeso = (zzeso) this.zzjfj.get();
        if (zzeso != null) {
            zzeso.zza(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzeso zzeso = (zzeso) this.zzjfj.get();
        if (zzeso != null) {
            zzeso.zzta();
        }
    }
}
