package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdhh implements zzdhb<Bundle> {
    private final boolean zzdyy;
    private final boolean zzdyz;
    private final String zzdzb;
    private final boolean zzdzc;
    private final boolean zzdzd;
    private final boolean zzdze;
    private final String zzdzh;
    private final String zzdzi;
    private final String zzdzj;
    private final boolean zzdzw;
    private final ArrayList<String> zzhgp;
    private final String zzhgq;
    private final String zzhgr;
    private final long zzhgs;

    public zzdhh(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, ArrayList<String> arrayList, @Nullable String str3, @Nullable String str4, String str5, boolean z6, String str6, long j) {
        this.zzdyy = z;
        this.zzdyz = z2;
        this.zzdzb = str;
        this.zzdzc = z3;
        this.zzdzd = z4;
        this.zzdze = z5;
        this.zzdzh = str2;
        this.zzhgp = arrayList;
        this.zzdzi = str3;
        this.zzdzj = str4;
        this.zzhgq = str5;
        this.zzdzw = z6;
        this.zzhgr = str6;
        this.zzhgs = j;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBoolean("cog", this.zzdyy);
        bundle.putBoolean("coh", this.zzdyz);
        bundle.putString("gl", this.zzdzb);
        bundle.putBoolean("simulator", this.zzdzc);
        bundle.putBoolean("is_latchsky", this.zzdzd);
        bundle.putBoolean("is_sidewinder", this.zzdze);
        bundle.putString("hl", this.zzdzh);
        if (!this.zzhgp.isEmpty()) {
            bundle.putStringArrayList("hl_list", this.zzhgp);
        }
        bundle.putString("mv", this.zzdzi);
        bundle.putString("submodel", this.zzhgr);
        Bundle zza = zzdpw.zza(bundle, "device");
        bundle.putBundle("device", zza);
        zza.putString("build", this.zzhgq);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzctl)).booleanValue()) {
            zza.putLong("remaining_data_partition_space", this.zzhgs);
        }
        Bundle zza2 = zzdpw.zza(zza, "browser");
        zza.putBundle("browser", zza2);
        zza2.putBoolean("is_browser_custom_tabs_capable", this.zzdzw);
        if (!TextUtils.isEmpty(this.zzdzj)) {
            Bundle zza3 = zzdpw.zza(zza, "play_store");
            zza.putBundle("play_store", zza3);
            zza3.putString("package_version", this.zzdzj);
        }
    }
}
