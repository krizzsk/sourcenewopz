package com.didichuxing.sdk.alphaface.core.liveness;

public class LivenessConfig {

    /* renamed from: a */
    private final long f48683a;

    /* renamed from: b */
    private final int f48684b;

    /* renamed from: c */
    private final int f48685c;

    /* renamed from: d */
    private final int f48686d;

    /* renamed from: e */
    private final double f48687e;

    /* renamed from: f */
    private final double f48688f;

    /* renamed from: g */
    private final int f48689g;

    /* renamed from: h */
    private final int f48690h;

    /* renamed from: i */
    private final ILivenessCallback f48691i;

    /* renamed from: j */
    private final int[] f48692j;

    /* renamed from: k */
    private final int f48693k;

    /* renamed from: l */
    private final int f48694l;

    /* renamed from: m */
    private final boolean f48695m;

    /* renamed from: n */
    private final int f48696n;

    /* renamed from: o */
    private final float f48697o;

    /* renamed from: p */
    private final float f48698p;

    /* renamed from: q */
    private final float f48699q;

    /* renamed from: r */
    private final float f48700r;

    /* renamed from: s */
    private final float f48701s;

    /* renamed from: t */
    private final int f48702t;

    private LivenessConfig(Builder builder) {
        this.f48683a = builder.skipTime;
        this.f48684b = builder.detectTime;
        this.f48685c = builder.attackPicCount;
        this.f48686d = builder.faceErrorCountMax;
        this.f48687e = builder.bestPicQualityThreshold;
        this.f48688f = builder.attackPicQualityThreshold;
        this.f48689g = builder.faceQualityErrorMaxTimes;
        this.f48690h = builder.faceQualityErrorDelay;
        this.f48691i = builder.callback;
        this.f48692j = builder.detectAction;
        this.f48693k = builder.actionTimeout;
        this.f48694l = builder.actionInterruptTime;
        this.f48695m = builder.attackEnable;
        this.f48696n = builder.frame_time_interval;
        this.f48697o = builder.yaw_thresh;
        this.f48698p = builder.pitch_thresh;
        this.f48699q = builder.occ_thresh;
        this.f48700r = builder.illum_thresh;
        this.f48701s = builder.blur_thresh;
        this.f48702t = builder.waterType;
    }

    public long getSkipTime() {
        return this.f48683a;
    }

    public int getDetectTime() {
        return this.f48684b;
    }

    public int getAttackPicCount() {
        return this.f48685c;
    }

    public int getFaceErrorCountMax() {
        return this.f48686d;
    }

    public double getBestPicQualityThreshold() {
        return this.f48687e;
    }

    public double getAttackPicQualityThreshold() {
        return this.f48688f;
    }

    public int getFaceQualityErrorMaxTimes() {
        return this.f48689g;
    }

    public int getFaceQualityErrorDelay() {
        return this.f48690h;
    }

    public ILivenessCallback getCallback() {
        return this.f48691i;
    }

    public int[] getDetectAction() {
        return this.f48692j;
    }

    public int getActionTimeout() {
        return this.f48693k;
    }

    public int getActionInterruptTime() {
        return this.f48694l;
    }

    public boolean attackEnable() {
        return this.f48695m;
    }

    public int getFrame_time_interval() {
        return this.f48696n;
    }

    public float getYaw_thresh() {
        return this.f48697o;
    }

    public float getPitch_thresh() {
        return this.f48698p;
    }

    public float getOcc_thresh() {
        return this.f48699q;
    }

    public float getIllum_thresh() {
        return this.f48700r;
    }

    public float getBlur_thresh() {
        return this.f48701s;
    }

    public int getWaterType() {
        return this.f48702t;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public int actionInterruptTime = 1000;
        /* access modifiers changed from: private */
        public int actionTimeout = 10000;
        /* access modifiers changed from: private */
        public boolean attackEnable = true;
        /* access modifiers changed from: private */
        public int attackPicCount = 5;
        /* access modifiers changed from: private */
        public double attackPicQualityThreshold;
        /* access modifiers changed from: private */
        public double bestPicQualityThreshold;
        /* access modifiers changed from: private */
        public float blur_thresh = 0.1f;
        /* access modifiers changed from: private */
        public ILivenessCallback callback;
        /* access modifiers changed from: private */
        public int[] detectAction = {3};
        /* access modifiers changed from: private */
        public int detectTime = 1000;
        /* access modifiers changed from: private */
        public int faceErrorCountMax = 3;
        /* access modifiers changed from: private */
        public int faceQualityErrorDelay = 1000;
        /* access modifiers changed from: private */
        public int faceQualityErrorMaxTimes = 1;
        /* access modifiers changed from: private */
        public int frame_time_interval = 500;
        /* access modifiers changed from: private */
        public float illum_thresh = 0.78f;
        /* access modifiers changed from: private */
        public float occ_thresh = 0.6f;
        /* access modifiers changed from: private */
        public float pitch_thresh = 0.3f;
        /* access modifiers changed from: private */
        public long skipTime = 75;
        /* access modifiers changed from: private */
        public int waterType = 0;
        /* access modifiers changed from: private */
        public float yaw_thresh = 0.3f;

        public Builder setWaterType(int i) {
            this.waterType = i;
            return this;
        }

        public Builder setFrameSkipTime(long j) {
            this.skipTime = j;
            return this;
        }

        public Builder setDetectTime(int i) {
            this.detectTime = i;
            return this;
        }

        public Builder setActionPicCount(int i) {
            this.attackPicCount = i;
            return this;
        }

        public Builder setFaceErrorCountMax(int i) {
            this.faceErrorCountMax = i;
            return this;
        }

        public Builder setBestPicQualityThreshold(double d) {
            this.bestPicQualityThreshold = d;
            return this;
        }

        public Builder setFaceQualityErrorMaxTimes(int i) {
            this.faceQualityErrorMaxTimes = i;
            return this;
        }

        public Builder setFaceQualityErrorDelay(int i) {
            this.faceQualityErrorDelay = i;
            return this;
        }

        public Builder setAttackPicQualityThreshold(double d) {
            this.attackPicQualityThreshold = d;
            return this;
        }

        public Builder setCallback(ILivenessCallback iLivenessCallback) {
            this.callback = iLivenessCallback;
            return this;
        }

        public Builder setDetectAction(int[] iArr) {
            this.detectAction = iArr;
            return this;
        }

        public Builder setActionTimeout(int i) {
            this.actionTimeout = i;
            return this;
        }

        public Builder setActionInterruptTime(int i) {
            this.actionInterruptTime = i;
            return this;
        }

        public Builder setAttackEnable(boolean z) {
            this.attackEnable = z;
            return this;
        }

        public Builder setFrame_time_interval(int i) {
            this.frame_time_interval = i;
            return this;
        }

        public Builder setYaw_thresh(float f) {
            this.yaw_thresh = f;
            return this;
        }

        public Builder setPitch_thresh(float f) {
            this.pitch_thresh = f;
            return this;
        }

        public Builder setOcc_thresh(float f) {
            this.occ_thresh = f;
            return this;
        }

        public Builder setIllum_thresh(float f) {
            this.illum_thresh = f;
            return this;
        }

        public Builder setBlur_thresh(float f) {
            this.blur_thresh = f;
            return this;
        }

        public LivenessConfig builder() {
            return new LivenessConfig(this);
        }
    }
}
