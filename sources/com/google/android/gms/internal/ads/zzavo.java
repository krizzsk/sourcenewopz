package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzavo implements RewardItem {
    private final zzavd zzeao;

    public zzavo(zzavd zzavd) {
        this.zzeao = zzavd;
    }

    public final String getType() {
        zzavd zzavd = this.zzeao;
        if (zzavd == null) {
            return null;
        }
        try {
            return zzavd.getType();
        } catch (RemoteException e) {
            zzbao.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    public final int getAmount() {
        zzavd zzavd = this.zzeao;
        if (zzavd == null) {
            return 0;
        }
        try {
            return zzavd.getAmount();
        } catch (RemoteException e) {
            zzbao.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
