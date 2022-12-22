package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzarl extends NativeAd.AdChoicesInfo {
    private String text;
    private final List<NativeAd.Image> zzdgq = new ArrayList();

    public zzarl(zzaek zzaek) {
        try {
            this.text = zzaek.getText();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            this.text = "";
        }
        try {
            for (zzaes next : zzaek.zztj()) {
                zzaes zzo = next instanceof IBinder ? zzaev.zzo((IBinder) next) : null;
                if (zzo != null) {
                    this.zzdgq.add(new zzarn(zzo));
                }
            }
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzdgq;
    }
}
