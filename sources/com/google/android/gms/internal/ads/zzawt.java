package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzawt implements RewardItem {
    private final zzawa zzeaz;

    public zzawt(zzawa zzawa) {
        this.zzeaz = zzawa;
    }

    public final String getType() {
        zzawa zzawa = this.zzeaz;
        if (zzawa == null) {
            return null;
        }
        try {
            return zzawa.getType();
        } catch (RemoteException e) {
            zzbao.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    public final int getAmount() {
        zzawa zzawa = this.zzeaz;
        if (zzawa == null) {
            return 0;
        }
        try {
            return zzawa.getAmount();
        } catch (RemoteException e) {
            zzbao.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
