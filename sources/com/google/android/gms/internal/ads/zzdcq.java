package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.jumio.sdk.reject.JumioRejectReason;
import java.util.ArrayList;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdcq implements zzdhb<Bundle> {
    private final String zzadd;
    private final zzvt zzbpy;
    private final float zzbsn;
    private final boolean zzcit;
    private final int zzdrr;
    private final int zzdrs;
    private final String zzhdl;
    private final String zzhdm;
    private final boolean zzhdn;

    public zzdcq(zzvt zzvt, String str, boolean z, String str2, float f, int i, int i2, String str3, boolean z2) {
        Preconditions.checkNotNull(zzvt, "the adSize must not be null");
        this.zzbpy = zzvt;
        this.zzadd = str;
        this.zzcit = z;
        this.zzhdl = str2;
        this.zzbsn = f;
        this.zzdrr = i;
        this.zzdrs = i2;
        this.zzhdm = str3;
        this.zzhdn = z2;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdpw.zza(bundle, "smart_w", "full", this.zzbpy.width == -1);
        zzdpw.zza(bundle, "smart_h", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, this.zzbpy.height == -2);
        zzdpw.zza(bundle, "ene", (Boolean) true, this.zzbpy.zzciu);
        zzdpw.zza(bundle, "rafmt", JumioRejectReason.BLACK_WHITE_COPY, this.zzbpy.zzcix);
        zzdpw.zza(bundle, "rafmt", JumioRejectReason.COLOR_PHOTOCOPY, this.zzbpy.zzciy);
        zzdpw.zza(bundle, "rafmt", Const.BindCardScene.ORDER_H5, this.zzbpy.zzadh);
        zzdpw.zza(bundle, "inline_adaptive_slot", (Boolean) true, this.zzhdn);
        zzdpw.zza(bundle, "interscroller_slot", (Boolean) true, this.zzbpy.zzadh);
        zzdpw.zza(bundle, "format", this.zzadd);
        zzdpw.zza(bundle, "fluid", "height", this.zzcit);
        String str = this.zzhdl;
        zzdpw.zza(bundle, "sz", str, !TextUtils.isEmpty(str));
        bundle.putFloat("u_sd", this.zzbsn);
        bundle.putInt(LoginOmegaUtil.ACTIONID_SW, this.zzdrr);
        bundle.putInt("sh", this.zzdrs);
        String str2 = this.zzhdm;
        zzdpw.zza(bundle, "sc", str2, true ^ TextUtils.isEmpty(str2));
        ArrayList arrayList = new ArrayList();
        if (this.zzbpy.zzcis == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", this.zzbpy.height);
            bundle2.putInt("width", this.zzbpy.width);
            bundle2.putBoolean("is_fluid_height", this.zzbpy.zzcit);
            arrayList.add(bundle2);
        } else {
            for (zzvt zzvt : this.zzbpy.zzcis) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzvt.zzcit);
                bundle3.putInt("height", zzvt.height);
                bundle3.putInt("width", zzvt.width);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
