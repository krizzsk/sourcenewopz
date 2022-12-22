package com.google.android.gms.ads.nativead;

import com.google.android.gms.ads.VideoOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;
    private final boolean zzbob;
    private final int zzbod;
    private final boolean zzboe;
    private final int zzbof;
    private final VideoOptions zzbog;
    private final boolean zzboh;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    public @interface AdChoicesPlacement {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    public @interface NativeMediaAspectRatio {
    }

    private NativeAdOptions(Builder builder) {
        this.zzbob = builder.zzbob;
        this.zzbod = builder.zzbod;
        this.zzboe = builder.zzboe;
        this.zzbof = builder.zzbof;
        this.zzbog = builder.zzbog;
        this.zzboh = builder.zzboh;
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzbob = false;
        /* access modifiers changed from: private */
        public int zzbod = 0;
        /* access modifiers changed from: private */
        public boolean zzboe = false;
        /* access modifiers changed from: private */
        public int zzbof = 1;
        /* access modifiers changed from: private */
        public VideoOptions zzbog;
        /* access modifiers changed from: private */
        public boolean zzboh = false;

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.zzbob = z;
            return this;
        }

        public final Builder setMediaAspectRatio(int i) {
            this.zzbod = i;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.zzboe = z;
            return this;
        }

        public final Builder setAdChoicesPlacement(int i) {
            this.zzbof = i;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.zzbog = videoOptions;
            return this;
        }

        public final Builder setRequestCustomMuteThisAd(boolean z) {
            this.zzboh = z;
            return this;
        }

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.zzbob;
    }

    public final int getMediaAspectRatio() {
        return this.zzbod;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.zzboe;
    }

    public final int getAdChoicesPlacement() {
        return this.zzbof;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbog;
    }

    public final boolean zzjx() {
        return this.zzboh;
    }
}
