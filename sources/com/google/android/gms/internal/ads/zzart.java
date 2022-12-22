package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzart implements NativeCustomFormatAd {
    private final VideoController zzcks = new VideoController();
    private final zzafo zzdhj;
    private final MediaView zzdse;
    private NativeCustomFormatAd.DisplayOpenMeasurement zzdsf;

    public zzart(zzafo zzafo) {
        Context context;
        this.zzdhj = zzafo;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzafo.zztx());
        } catch (RemoteException | NullPointerException e) {
            zzbao.zzc("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.zzdhj.zzp(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzbao.zzc("", e2);
            }
        }
        this.zzdse = mediaView;
    }

    public final CharSequence getText(String str) {
        try {
            return this.zzdhj.zzct(str);
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final NativeAd.Image getImage(String str) {
        try {
            zzaes zzcu = this.zzdhj.zzcu(str);
            if (zzcu != null) {
                return new zzarn(zzcu);
            }
            return null;
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            zzzd videoController = this.zzdhj.getVideoController();
            if (videoController != null) {
                this.zzcks.zza(videoController);
            }
        } catch (RemoteException e) {
            zzbao.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcks;
    }

    public final MediaView getVideoMediaView() {
        return this.zzdse;
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zzdhj.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final String getCustomFormatId() {
        try {
            return this.zzdhj.getCustomTemplateId();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            return null;
        }
    }

    public final void performClick(String str) {
        try {
            this.zzdhj.performClick(str);
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final void recordImpression() {
        try {
            this.zzdhj.recordImpression();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final NativeCustomFormatAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzdsf == null && this.zzdhj.zzty()) {
                this.zzdsf = new zzark(this.zzdhj);
            }
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
        return this.zzdsf;
    }

    public final void destroy() {
        try {
            this.zzdhj.destroy();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}
