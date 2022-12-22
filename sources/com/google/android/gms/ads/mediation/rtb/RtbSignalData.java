package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class RtbSignalData {
    private final Context context;
    private final Bundle zzcih;
    private final AdSize zzdu;
    private final List<MediationConfiguration> zzeye;

    public RtbSignalData(Context context2, List<MediationConfiguration> list, Bundle bundle, AdSize adSize) {
        this.context = context2;
        this.zzeye = list;
        this.zzcih = bundle;
        this.zzdu = adSize;
    }

    public Context getContext() {
        return this.context;
    }

    @Deprecated
    public MediationConfiguration getConfiguration() {
        List<MediationConfiguration> list = this.zzeye;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.zzeye.get(0);
    }

    public List<MediationConfiguration> getConfigurations() {
        return this.zzeye;
    }

    public Bundle getNetworkExtras() {
        return this.zzcih;
    }

    public AdSize getAdSize() {
        return this.zzdu;
    }
}
