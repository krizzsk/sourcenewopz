package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaed extends zzaen {
    private static final int zzdgl = Color.rgb(12, 174, 206);
    private static final int zzdgm;
    private static final int zzdgn;
    private static final int zzdgo = zzdgl;
    private final int backgroundColor;
    private final int textColor;
    private final int textSize;
    private final String zzdgp;
    private final List<zzaee> zzdgq = new ArrayList();
    private final List<zzaes> zzdgr = new ArrayList();
    private final int zzdgs;
    private final int zzdgt;
    private final boolean zzdgu;

    public zzaed(String str, List<zzaee> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzdgp = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzaee zzaee = list.get(i3);
                this.zzdgq.add(zzaee);
                this.zzdgr.add(zzaee);
            }
        }
        this.backgroundColor = num != null ? num.intValue() : zzdgn;
        this.textColor = num2 != null ? num2.intValue() : zzdgo;
        this.textSize = num3 != null ? num3.intValue() : 12;
        this.zzdgs = i;
        this.zzdgt = i2;
        this.zzdgu = z;
    }

    public final String getText() {
        return this.zzdgp;
    }

    public final List<zzaes> zztj() {
        return this.zzdgr;
    }

    public final List<zzaee> zztk() {
        return this.zzdgq;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final int zztl() {
        return this.zzdgs;
    }

    public final int zztm() {
        return this.zzdgt;
    }

    static {
        int rgb = Color.rgb(204, 204, 204);
        zzdgm = rgb;
        zzdgn = rgb;
    }
}
