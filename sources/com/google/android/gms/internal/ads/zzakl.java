package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.ads.instream.InstreamAdView;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzakl extends InstreamAd {
    private MediaContent zzbnv = zzur();
    private VideoController zzcks = zzuq();
    private final zzaka zzdki;

    public zzakl(zzaka zzaka) {
        this.zzdki = zzaka;
    }

    public final void zza(InstreamAdView instreamAdView) {
        if (instreamAdView == null) {
            zzbao.zzex("showInView: parameter view must not be null.");
            return;
        }
        try {
            this.zzdki.zzr(ObjectWrapper.wrap(instreamAdView));
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    public final MediaContent getMediaContent() {
        return this.zzbnv;
    }

    public final VideoController getVideoController() {
        return this.zzcks;
    }

    public final float getVideoDuration() {
        VideoController videoController = this.zzcks;
        if (videoController == null) {
            return 0.0f;
        }
        return videoController.getVideoDuration();
    }

    public final float getVideoCurrentTime() {
        VideoController videoController = this.zzcks;
        if (videoController == null) {
            return 0.0f;
        }
        return videoController.getVideoCurrentTime();
    }

    public final float getAspectRatio() {
        VideoController videoController = this.zzcks;
        if (videoController == null) {
            return 0.0f;
        }
        return videoController.getAspectRatio();
    }

    public final void destroy() {
        try {
            this.zzdki.destroy();
            this.zzcks = null;
            this.zzbnv = null;
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }

    private final VideoController zzuq() {
        VideoController videoController = new VideoController();
        try {
            videoController.zza(this.zzdki.getVideoController());
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
        return videoController;
    }

    private final MediaContent zzur() {
        try {
            if (this.zzdki.zzue() != null) {
                return new zzaab(this.zzdki.zzue());
            }
            return null;
        } catch (RemoteException e) {
            zzbao.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
