package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    private final Context context;
    private final String zzadx;
    private final int zzdos;
    private final String zzdpg;
    private final String zzewu;
    private final Bundle zzewv;
    private final Bundle zzeww;
    private final int zzewx;
    private final boolean zznf;
    private final Location zzng;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(Context context2, String str, Bundle bundle, Bundle bundle2, boolean z, Location location, int i, int i2, String str2, String str3) {
        this.zzewu = str;
        this.zzewv = bundle;
        this.zzeww = bundle2;
        this.context = context2;
        this.zznf = z;
        this.zzng = location;
        this.zzdos = i;
        this.zzewx = i2;
        this.zzadx = str2;
        this.zzdpg = str3;
    }

    public String getBidResponse() {
        return this.zzewu;
    }

    public Bundle getServerParameters() {
        return this.zzewv;
    }

    public Bundle getMediationExtras() {
        return this.zzeww;
    }

    public Context getContext() {
        return this.context;
    }

    public Location getLocation() {
        return this.zzng;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzdos;
    }

    public boolean isTestRequest() {
        return this.zznf;
    }

    public int taggedForUnderAgeTreatment() {
        return this.zzewx;
    }

    public String getMaxAdContentRating() {
        return this.zzadx;
    }

    public String getWatermark() {
        return this.zzdpg;
    }
}
