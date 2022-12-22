package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaaw;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzzd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class VideoController {
    public static final int PLAYBACK_STATE_ENDED = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_READY = 5;
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object lock = new Object();
    private zzzd zzaea;
    private VideoLifecycleCallbacks zzaeb;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public final void zza(zzzd zzzd) {
        synchronized (this.lock) {
            this.zzaea = zzzd;
            if (this.zzaeb != null) {
                setVideoLifecycleCallbacks(this.zzaeb);
            }
        }
    }

    public final zzzd zzdz() {
        zzzd zzzd;
        synchronized (this.lock) {
            zzzd = this.zzaea;
        }
        return zzzd;
    }

    public final void play() {
        synchronized (this.lock) {
            if (this.zzaea != null) {
                try {
                    this.zzaea.play();
                } catch (RemoteException e) {
                    zzbao.zzc("Unable to call play on video controller.", e);
                }
            }
        }
    }

    public final void pause() {
        synchronized (this.lock) {
            if (this.zzaea != null) {
                try {
                    this.zzaea.pause();
                } catch (RemoteException e) {
                    zzbao.zzc("Unable to call pause on video controller.", e);
                }
            }
        }
    }

    public final void stop() {
        synchronized (this.lock) {
            if (this.zzaea != null) {
                try {
                    this.zzaea.stop();
                } catch (RemoteException e) {
                    zzbao.zzc("Unable to call stop on video controller.", e);
                }
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.lock) {
            if (this.zzaea != null) {
                try {
                    this.zzaea.mute(z);
                } catch (RemoteException e) {
                    zzbao.zzc("Unable to call mute on video controller.", e);
                }
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return true;
            }
            try {
                boolean isMuted = this.zzaea.isMuted();
                return isMuted;
            } catch (RemoteException e) {
                zzbao.zzc("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    public final int getPlaybackState() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return 0;
            }
            try {
                int playbackState = this.zzaea.getPlaybackState();
                return playbackState;
            } catch (RemoteException e) {
                zzbao.zzc("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return false;
            }
            try {
                boolean isCustomControlsEnabled = this.zzaea.isCustomControlsEnabled();
                return isCustomControlsEnabled;
            } catch (RemoteException e) {
                zzbao.zzc("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return false;
            }
            try {
                boolean isClickToExpandEnabled = this.zzaea.isClickToExpandEnabled();
                return isClickToExpandEnabled;
            } catch (RemoteException e) {
                zzbao.zzc("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public final float getVideoDuration() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return 0.0f;
            }
            try {
                float duration = this.zzaea.getDuration();
                return duration;
            } catch (RemoteException e) {
                zzbao.zzc("Unable to call getDuration on video controller.", e);
                return 0.0f;
            }
        }
    }

    public final float getVideoCurrentTime() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return 0.0f;
            }
            try {
                float currentTime = this.zzaea.getCurrentTime();
                return currentTime;
            } catch (RemoteException e) {
                zzbao.zzc("Unable to call getCurrentTime on video controller.", e);
                return 0.0f;
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.lock) {
            this.zzaeb = videoLifecycleCallbacks;
            if (this.zzaea != null) {
                try {
                    this.zzaea.zza(new zzaaw(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzbao.zzc("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
        }
    }

    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.lock) {
            videoLifecycleCallbacks = this.zzaeb;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzaea != null;
        }
        return z;
    }

    @Deprecated
    public final float getAspectRatio() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return 0.0f;
            }
            try {
                float aspectRatio = this.zzaea.getAspectRatio();
                return aspectRatio;
            } catch (RemoteException e) {
                zzbao.zzc("Unable to call getAspectRatio on video controller.", e);
                return 0.0f;
            }
        }
    }
}
