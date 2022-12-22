package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzaaz;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class VideoOptions {
    private final boolean zzaee;
    private final boolean zzaef;
    private final boolean zzaeg;

    public VideoOptions(zzaaz zzaaz) {
        this.zzaee = zzaaz.zzaee;
        this.zzaef = zzaaz.zzaef;
        this.zzaeg = zzaaz.zzaeg;
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzaee = true;
        /* access modifiers changed from: private */
        public boolean zzaef = false;
        /* access modifiers changed from: private */
        public boolean zzaeg = false;

        public final Builder setStartMuted(boolean z) {
            this.zzaee = z;
            return this;
        }

        public final Builder setCustomControlsRequested(boolean z) {
            this.zzaef = z;
            return this;
        }

        public final Builder setClickToExpandRequested(boolean z) {
            this.zzaeg = z;
            return this;
        }

        public final VideoOptions build() {
            return new VideoOptions(this);
        }
    }

    private VideoOptions(Builder builder) {
        this.zzaee = builder.zzaee;
        this.zzaef = builder.zzaef;
        this.zzaeg = builder.zzaeg;
    }

    public final boolean getStartMuted() {
        return this.zzaee;
    }

    public final boolean getCustomControlsRequested() {
        return this.zzaef;
    }

    public final boolean getClickToExpandRequested() {
        return this.zzaeg;
    }
}
