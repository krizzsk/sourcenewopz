package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaxb extends zzawd {
    private final String type;
    private final int zzean;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzaxb(zzavy zzavy) {
        this(zzavy != null ? zzavy.type : "", zzavy != null ? zzavy.zzean : 1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzaxb(RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzaxb(String str, int i) {
        this.type = str;
        this.zzean = i;
    }

    public final String getType() throws RemoteException {
        return this.type;
    }

    public final int getAmount() throws RemoteException {
        return this.zzean;
    }
}
