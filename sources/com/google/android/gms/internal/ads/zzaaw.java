package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaaw extends zzzh {
    private final VideoController.VideoLifecycleCallbacks zzaeb;

    public zzaaw(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzaeb = videoLifecycleCallbacks;
    }

    public final void onVideoStart() {
        this.zzaeb.onVideoStart();
    }

    public final void onVideoPlay() {
        this.zzaeb.onVideoPlay();
    }

    public final void onVideoPause() {
        this.zzaeb.onVideoPause();
    }

    public final void onVideoEnd() {
        this.zzaeb.onVideoEnd();
    }

    public final void onVideoMute(boolean z) {
        this.zzaeb.onVideoMute(z);
    }
}
