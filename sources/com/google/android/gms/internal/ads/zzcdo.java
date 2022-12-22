package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcdo extends zzzg {
    private final Object lock = new Object();
    @Nullable
    private zzzd zzggp;
    @Nullable
    private final zzaoh zzggq;

    public zzcdo(@Nullable zzzd zzzd, @Nullable zzaoh zzaoh) {
        this.zzggp = zzzd;
        this.zzggq = zzaoh;
    }

    public final void play() throws RemoteException {
        throw new RemoteException();
    }

    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    public final void stop() throws RemoteException {
        throw new RemoteException();
    }

    public final void mute(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isMuted() throws RemoteException {
        throw new RemoteException();
    }

    public final int getPlaybackState() throws RemoteException {
        throw new RemoteException();
    }

    public final float getDuration() throws RemoteException {
        zzaoh zzaoh = this.zzggq;
        if (zzaoh != null) {
            return zzaoh.getVideoDuration();
        }
        return 0.0f;
    }

    public final float getCurrentTime() throws RemoteException {
        zzaoh zzaoh = this.zzggq;
        if (zzaoh != null) {
            return zzaoh.getVideoCurrentTime();
        }
        return 0.0f;
    }

    public final void zza(zzzi zzzi) throws RemoteException {
        synchronized (this.lock) {
            if (this.zzggp != null) {
                this.zzggp.zza(zzzi);
            }
        }
    }

    public final zzzi zzrm() throws RemoteException {
        synchronized (this.lock) {
            if (this.zzggp == null) {
                return null;
            }
            zzzi zzrm = this.zzggp.zzrm();
            return zzrm;
        }
    }

    public final float getAspectRatio() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isCustomControlsEnabled() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isClickToExpandEnabled() throws RemoteException {
        throw new RemoteException();
    }
}
