package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzov extends IOException {
    private final int type;
    private final zzos zzbji;

    public zzov(String str, zzos zzos, int i) {
        super(str);
        this.zzbji = zzos;
        this.type = 1;
    }

    public zzov(IOException iOException, zzos zzos, int i) {
        super(iOException);
        this.zzbji = zzos;
        this.type = i;
    }

    public zzov(String str, IOException iOException, zzos zzos, int i) {
        super(str, iOException);
        this.zzbji = zzos;
        this.type = 1;
    }
}
