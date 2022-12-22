package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaep extends NativeAd.AdChoicesInfo {
    private String text;
    private final List<NativeAd.Image> zzdgq = new ArrayList();
    private final zzaek zzdha;

    public zzaep(zzaek zzaek) {
        zzaes zzaes;
        IBinder iBinder;
        this.zzdha = zzaek;
        try {
            this.text = zzaek.getText();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            this.text = "";
        }
        try {
            for (zzaes next : zzaek.zztj()) {
                if (!(next instanceof IBinder) || (iBinder = (IBinder) next) == null) {
                    zzaes = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzaes = queryLocalInterface instanceof zzaes ? (zzaes) queryLocalInterface : new zzaeu(iBinder);
                }
                if (zzaes != null) {
                    this.zzdgq.add(new zzaex(zzaes));
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
