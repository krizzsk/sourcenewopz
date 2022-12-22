package com.google.android.gms.internal.ads;

import com.didi.soda.blocks.constant.Const;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaip implements zzaig<zzbfi> {
    private static final Map<String, Integer> zzdjl = CollectionUtils.mapOfKeyValueArrays(new String[]{Const.BlockParamConst.RESIZE, "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final zza zzdjd;
    private final zzaqz zzdjh;
    private final zzari zzdjk;

    public zzaip(zza zza, zzaqz zzaqz, zzari zzari) {
        this.zzdjd = zza;
        this.zzdjh = zzaqz;
        this.zzdjk = zzari;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zza zza;
        zzbfi zzbfi = (zzbfi) obj;
        int intValue = zzdjl.get((String) map.get(Constants.FILE_ANR_KEY)).intValue();
        if (intValue != 5 && intValue != 7 && (zza = this.zzdjd) != null && !zza.zzkc()) {
            this.zzdjd.zzbk((String) null);
        } else if (intValue == 1) {
            this.zzdjh.zzg(map);
        } else if (intValue == 3) {
            new zzara(zzbfi, map).execute();
        } else if (intValue == 4) {
            new zzaqu(zzbfi, map).execute();
        } else if (intValue == 5) {
            new zzarb(zzbfi, map).execute();
        } else if (intValue == 6) {
            this.zzdjh.zzag(true);
        } else if (intValue != 7) {
            zzd.zzey("Unknown MRAID command called.");
        } else {
            this.zzdjk.zzwc();
        }
    }
}
